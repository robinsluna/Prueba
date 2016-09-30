package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AdendaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AdendaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminAdendaBean implements AdminAdenda{
    @EJB 
    ConversionVOEntidad conversionVoEntidad; 
    @EJB 
    AdendaDAO adendaDao;
    @EJB
    ProcesoContratacionDAO procesoContratacionDao;
    @EJB
    EstadoProcContratDAO estadoProcContratDao;


    public AdminAdendaBean() {
    }

    
   

    
    public AdendaVO insertarSiiAdendaTdr(AdendaVO adendaVO) throws ExcepcionDAO {
        SiiAdendaTdr adenda = adendaDao.insertarSiiAdendaTdr(conversionVoEntidad.convertir(adendaVO));
        
        // Se actualiza el estado del proceso de contratacion
        if(adendaVO.getTerminosReferencia().getProcesoContratacionVO().getPrcCodigo()!= null){
            SiiProcesoContratacion miSiiProcesoContratacion = procesoContratacionDao.buscarProcesoContratacionPorId(adendaVO.getTerminosReferencia().getProcesoContratacionVO().getPrcCodigo());
            SiiEstadoProcContrat miEstadoProc = new SiiEstadoProcContrat();
            miSiiProcesoContratacion.setPrcCodigo(adendaVO.getTerminosReferencia().getProcesoContratacionVO().getPrcCodigo());   
            miEstadoProc = estadoProcContratDao.BuscarEstadoProcContratPorId(adendaVO.getTerminosReferencia().getProcesoContratacionVO().getEstadoProcContrat().getEpcCodigo());
            miSiiProcesoContratacion.setSiiEstadoProcContrat(miEstadoProc);
            procesoContratacionDao.actualizarProcesoContratacion(miSiiProcesoContratacion);
                
            }
        return new AdendaVO(adenda);
    }

   
    public AdendaVO actualizarSiiAdendaTdr(AdendaVO adendaVO) throws ExcepcionDAO {
        SiiAdendaTdr adenda = adendaDao.actualizarSiiAdendaTdr(conversionVoEntidad.convertir(adendaVO));
        return new AdendaVO(adenda);
    }
    
    public void borrarAdendaTdr(Long idCodigoAdenda) throws ExcepcionDAO {
        adendaDao.borrarAdendaTdr(idCodigoAdenda);
    }
    public List<AdendaVO> buscarTodoSiiAdenda() throws ExcepcionDAO {
        List<SiiAdendaTdr> listaAdendas = adendaDao.buscarTodoSiiAdenda();
        List<AdendaVO> listaAdendaVO = new ArrayList<AdendaVO>();
        for (SiiAdendaTdr unAdenda : listaAdendas) {
            listaAdendaVO.add(new AdendaVO(unAdenda));
        }
        return listaAdendaVO;
    }
    
    public List<AdendaVO> buscarAdendasPorCodigoProcesoContratacion (Integer idProcesoContratacion)  throws ExcepcionDAO {
        List<SiiAdendaTdr> miSiiAdendas = adendaDao.buscarAdendasPorCodigoProcesoContratacion(idProcesoContratacion);
        List<AdendaVO> miListAdendaVO = new ArrayList<AdendaVO>(); 
        List<SolicitudEstMercadoVO> solicitudEstMercadoListVo = new ArrayList<SolicitudEstMercadoVO>();
        if(miSiiAdendas!= null){
            for(SiiAdendaTdr siiAd: miSiiAdendas){
                    AdendaVO miAdendaVo = new AdendaVO(siiAd);                    
                
                    // recupero el termino de referencia
                if(siiAd.getSiiTerminosReferencia()!= null){
                    ProcesoContratacionVO miProConVo = new ProcesoContratacionVO(siiAd.getSiiTerminosReferencia().getSiiProcesoContratacion());
                    
                    if(siiAd.getSiiTerminosReferencia().getSiiProcesoContratacion()!= null){
                        for(SiiSolicitudEstMercado siiSolEstMer: siiAd.getSiiTerminosReferencia().getSiiProcesoContratacion().getSiiSolicitudEstMercadoList()){
                                    SolicitudEstMercadoVO miSolEstMerc = new SolicitudEstMercadoVO(siiSolEstMer);
                                    solicitudEstMercadoListVo.add(miSolEstMerc);
                        }
                    }
                    miProConVo.setSolicitudEstMercadoListVo(solicitudEstMercadoListVo);                    
                    TerminoReferenciaVO miTrVo = new TerminoReferenciaVO(siiAd.getSiiTerminosReferencia());
                    miTrVo.setProcesoContratacionVO(miProConVo);
                    miAdendaVo.setTerminosReferencia(miTrVo);
                }
                    miListAdendaVO.add(miAdendaVo);
                
                }
        }
        
        return (miListAdendaVO );
    }
    public AdendaVO buscarPorCodigoAdenda(Long idCodigoAdenda)  throws ExcepcionDAO {
        SiiAdendaTdr miSiiAdenda = adendaDao.buscarPorCodigoAdenda(idCodigoAdenda);            
        return new AdendaVO(miSiiAdenda);
        
    }
}
