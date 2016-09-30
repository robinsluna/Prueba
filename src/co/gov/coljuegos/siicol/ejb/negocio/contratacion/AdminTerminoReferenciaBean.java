package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoTdrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminoReferenciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ArchivoFisicoVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoTdrVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminTerminoReferenciaBean implements AdminTerminoReferencia{
    @EJB 
    ConversionVOEntidad conversionVoEntidad; 
    @EJB 
    TerminoReferenciaDAO terminoReferenciaDao;
    @EJB
    ProcesoContratacionDAO procesoContratacionDao;
    @EJB
    ArchivoFisicoDAO archivoFisicoDao;
    @EJB
    DocumentoTdrDAO documentoTdrDao;
    @EJB
    EstadoProcContratDAO estadoProcContratDao;


    public AdminTerminoReferenciaBean() {
    }

    
   

    
    public TerminoReferenciaVO insertarSiiTerminoReferencia(TerminoReferenciaVO terminoReferenciaVO,File archivoFinal,
                                                            ArchivoFisicoVO archivoFisico,DocumentoTdrVO documentoTdr) throws ExcepcionDAO {
        SiiTerminosReferencia miTerminoReferencia = conversionVoEntidad.convertir(terminoReferenciaVO);
        SiiTerminosReferencia resultadoTr =    terminoReferenciaDao.insertarSiiTerminoReferencia(miTerminoReferencia);
        // se actualiza el estado del proceso de contratacion
        SiiProcesoContratacion miSiiProcesoContratacion = procesoContratacionDao.buscarProcesoContratacionPorId(miTerminoReferencia.getSiiProcesoContratacion().getPrcCodigo());
        SiiEstadoProcContrat miEstadoProc = estadoProcContratDao.BuscarEstadoProcContratPorId(miTerminoReferencia.getSiiProcesoContratacion().getSiiEstadoProcContrat().getEpcCodigo());
        miSiiProcesoContratacion.setSiiEstadoProcContrat(miEstadoProc);
        miSiiProcesoContratacion.setPrcObjeto(miTerminoReferencia.getSiiProcesoContratacion().getPrcObjeto());
        procesoContratacionDao.actualizarProcesoContratacion(miSiiProcesoContratacion);
        
        // se inserta el archivo físico
        SiiArchivoFisico siiArchivoFisico = conversionVoEntidad.convertir(archivoFisico);
        siiArchivoFisico = archivoFisicoDao.insertarArchivoFisico(siiArchivoFisico);
        
        // se inserta el documento TDR
        SiiDocumentoTdr miSiiDocumentoTdr = conversionVoEntidad.convertir(documentoTdr);
        miSiiDocumentoTdr.setSiiArchivoFisico(siiArchivoFisico);
        miSiiDocumentoTdr.setSiiTerminosReferencia(resultadoTr);
        SiiDocumentoTdr miDocumentoTdr = documentoTdrDao.insertarSiiDocumentoTdr(miSiiDocumentoTdr);
        
        
        return new TerminoReferenciaVO(resultadoTr);
    }

   
    public TerminoReferenciaVO actualizarSiiTerminoReferencia(TerminoReferenciaVO terminoReferenciaVO) throws ExcepcionDAO {
        SiiTerminosReferencia miSiiTerminoReferencia = conversionVoEntidad.convertir(terminoReferenciaVO);
        SiiTerminosReferencia resultadoTr = terminoReferenciaDao.buscarPorCodigoTerminoReferencia(miSiiTerminoReferencia.getTdrCodigo());
        TerminoReferenciaVO miTRVo = null;
        if(resultadoTr!= null){
            if(resultadoTr.getTdrFechaApProy()== null){
                    resultadoTr.setTdrFechaApProy(miSiiTerminoReferencia.getTdrFechaApProy());
            }
            if(resultadoTr.getTdrFechaEnProy()== null){
                    resultadoTr.setTdrFechaEnProy(miSiiTerminoReferencia.getTdrFechaEnProy());
            }
            if(resultadoTr.getTdrFechaPbProy()== null){
                    resultadoTr.setTdrFechaPbProy(miSiiTerminoReferencia.getTdrFechaPbProy());
            }
            if(resultadoTr.getTdrFechaApObs()== null){
                    resultadoTr.setTdrFechaApObs(miSiiTerminoReferencia.getTdrFechaApObs());
            }
            if(resultadoTr.getTdrFechaEnObs()== null){
                    resultadoTr.setTdrFechaEnObs(miSiiTerminoReferencia.getTdrFechaEnObs());
            }
            if(resultadoTr.getTdrFechaPbObs()== null){
                    resultadoTr.setTdrFechaPbObs(miSiiTerminoReferencia.getTdrFechaPbObs());
            }
            if(resultadoTr.getTdrFechaApDef()== null){
                    resultadoTr.setTdrFechaApDef(miSiiTerminoReferencia.getTdrFechaApDef());
            }
            if(resultadoTr.getTdrFechaEnDef()== null){
                    resultadoTr.setTdrFechaEnDef(miSiiTerminoReferencia.getTdrFechaEnDef());
            }
            if(resultadoTr.getTdrFechaPbDef()== null){
                    resultadoTr.setTdrFechaPbDef(miSiiTerminoReferencia.getTdrFechaPbDef());
            }
            if(resultadoTr.getTdrFechaApAud()== null){
                    resultadoTr.setTdrFechaApAud(miSiiTerminoReferencia.getTdrFechaApAud());
            }
            if(resultadoTr.getTdrFechaEnAud()== null){
                    resultadoTr.setTdrFechaEnAud(miSiiTerminoReferencia.getTdrFechaEnAud());
            }
            if(resultadoTr.getTdrFechaPbAud()== null){
                    resultadoTr.setTdrFechaPbAud(miSiiTerminoReferencia.getTdrFechaPbAud());
            }
            if(resultadoTr.getTdrFechaApObsDef()== null){
                    resultadoTr.setTdrFechaApObsDef(miSiiTerminoReferencia.getTdrFechaApObsDef());
            }
            if(resultadoTr.getTdrFechaEnObsDef()== null){
                    resultadoTr.setTdrFechaEnObsDef(miSiiTerminoReferencia.getTdrFechaEnObsDef());
            }
            if(resultadoTr.getTdrFechaPbObsDef()== null){
                    resultadoTr.setTdrFechaPbObsDef(miSiiTerminoReferencia.getTdrFechaPbObsDef());
            }
            
            resultadoTr.setSiiProcesoContratacion(miSiiTerminoReferencia.getSiiProcesoContratacion());
                SiiTerminosReferencia terminoReferencia = terminoReferenciaDao.actualizarSiiTerminoReferencia(resultadoTr);
                miTRVo = new TerminoReferenciaVO(terminoReferencia);
                
                //actualiza proceso de contratacion
                SiiProcesoContratacion miSiiProcesoContratacion = procesoContratacionDao.buscarProcesoContratacionPorId(miSiiTerminoReferencia.getSiiProcesoContratacion().getPrcCodigo());
                SiiEstadoProcContrat miEstadoProc = estadoProcContratDao.BuscarEstadoProcContratPorId(miSiiTerminoReferencia.getSiiProcesoContratacion().getPrcCodigo());   
                miEstadoProc.setEpcCodigo(terminoReferenciaVO.getProcesoContratacionVO().getEstadoProcContrat().getEpcCodigo());
                miSiiProcesoContratacion.setSiiEstadoProcContrat(miEstadoProc);
                procesoContratacionDao.actualizarProcesoContratacion(miSiiProcesoContratacion);
                
            }       
        
        
        return miTRVo;
    }
    
    public void borrarTerminoReferencia(Long idCodigoTerminoReferencia) throws ExcepcionDAO {
        terminoReferenciaDao.borrarTerminoReferencia(idCodigoTerminoReferencia);
    }
    public List<TerminoReferenciaVO> buscarTodoSiiTerminoReferencia() throws ExcepcionDAO {
        List<SiiTerminosReferencia> listaTerminoReferencia = terminoReferenciaDao.buscarTodoSiiTerminoReferencia();
        List<TerminoReferenciaVO> listaTerminoReferenciaVO = new ArrayList();
        for (SiiTerminosReferencia unTerminoReferencia : listaTerminoReferencia) {
            listaTerminoReferenciaVO.add(new TerminoReferenciaVO(unTerminoReferencia));
        }
        return listaTerminoReferenciaVO;
    }
    
    public TerminoReferenciaVO buscarTerminoReferencia (Integer idProcesoContratacion) throws ExcepcionDAO {
        SiiTerminosReferencia miSiiterminoReferencia = terminoReferenciaDao.buscarTerminoReferencia(idProcesoContratacion);
        TerminoReferenciaVO miTRVo = null;    
        
        List<SolicitudEstMercadoVO> miListSolMerVo = new ArrayList<SolicitudEstMercadoVO>();
        if(miSiiterminoReferencia!= null){
            miTRVo = new TerminoReferenciaVO(miSiiterminoReferencia);
            if(miSiiterminoReferencia.getSiiProcesoContratacion().getSiiSolicitudEstMercadoList()!= null){
                       
                        List<SiiSolicitudEstMercado> miListSolMer = miSiiterminoReferencia.getSiiProcesoContratacion().getSiiSolicitudEstMercadoList();
                        for(SiiSolicitudEstMercado solEm: miListSolMer){
                                SolicitudEstMercadoVO solEstMerc = new SolicitudEstMercadoVO(solEm);
                                miListSolMerVo.add(solEstMerc);
                            }
            }
            ProcesoContratacionVO proConVo = new ProcesoContratacionVO(miSiiterminoReferencia.getSiiProcesoContratacion());
            proConVo.setSolicitudEstMercadoListVo(miListSolMerVo);
            miTRVo.setProcesoContratacionVO(proConVo);
        }
        
        
        
        return (miTRVo );
    }
    public String buscarAreaColjuegosPorCodigoProcesoContratacion (Integer idProcesoContratacion) throws ExcepcionDAO{
        String area = terminoReferenciaDao.buscarAreaColjuegosPorCodigoProcesoContratacion(idProcesoContratacion);
        return area;
        }
}
