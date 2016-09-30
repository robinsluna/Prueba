package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AsignacionRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.HlpLiqEstAsigRecDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionEstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecaudoEstablecDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsignacionRecaudo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpLiqEstablAsigRec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoEstablec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AsignacionRecaudoVO;

import co.gov.coljuegos.siicol.ejb.vo.BancoVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionEstablVO;
import co.gov.coljuegos.siicol.ejb.vo.RecaudoEstablecimientoManualVO;

import co.gov.coljuegos.siicol.ejb.vo.UbicacionVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminRecaudoEstablecimientoManualBean implements AdminRecaudoEstablecimientoManual{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    private DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private AsignacionRecaudoDAO asignacionRecaudoDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private LiquidacionEstablecimientoDAO liquidacionEstablecimientoDao;
    @EJB
    private RecaudoEstablecDAO recaudoEstablecDao;
    @EJB
    private UbicacionDAO ubicacionDao;
    @EJB
    private HlpLiqEstAsigRecDAO hlpLiqEstAsigRecDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    
    
    public AdminRecaudoEstablecimientoManualBean() {
       
    }
    
    public List<RecaudoEstablecimientoManualVO> buscarPagoSinRecaudoEstabl(String numContrato) throws ExcepcionDAO {
          List<RecaudoEstablecimientoManualVO> listRecaudoEstManualVo = new ArrayList();
          List<RecaudoEstablecimientoManualVO>   listRecEstManualVo = detalleDeclaracionDao.buscarPagoSinRecaudoEstabl(numContrato);
    
    return listRecEstManualVo;
    }
    
    public List<RecaudoEstablecimientoManualVO> buscarAsignacionRecaudoXid(Long areCodigo) throws ExcepcionDAO {
        List<RecaudoEstablecimientoManualVO> listRecaudoEstManualVo = new ArrayList();
        List<SiiHlpLiqEstablAsigRec> listsiiHlpLiqEstablAsigRec = new ArrayList();
        List<LiquidacionEstablVO> listLiquidacionEstablVo = new ArrayList();
        BigDecimal divisor = new BigDecimal(100);
        List<RecaudoEstablecimientoManualVO>   listRecEstManualVo = asignacionRecaudoDao.buscarAsignacionRecaudoXid(areCodigo);
        
        listsiiHlpLiqEstablAsigRec =  hlpLiqEstAsigRecDao.buscarHlpLiqEstablAsigRecXAsigRec(areCodigo);
            for ( SiiHlpLiqEstablAsigRec siiHlpLiqEstablAsigRec:listsiiHlpLiqEstablAsigRec ){
                LiquidacionEstablVO liquidacionEstablVo = new LiquidacionEstablVO();
                liquidacionEstablVo.setLesPonderado((siiHlpLiqEstablAsigRec.getHlePonderado().multiply(divisor).setScale(2)));
                liquidacionEstablVo.setLesValor(siiHlpLiqEstablAsigRec.getHleValor());
                liquidacionEstablVo.setNumEstablecimiento(siiHlpLiqEstablAsigRec.getHleNumEstablec());
                SiiUbicacion siiUbicacion =  ubicacionDao.buscarUbicacionPorId(siiHlpLiqEstablAsigRec.getSiiUbicacionMunEst().getUbiCodigo());
                liquidacionEstablVo.setCodigoUbicacion(siiHlpLiqEstablAsigRec.getSiiUbicacionMunEst().getUbiCodigo());
                UbicacionVO ubicacionVo = new  UbicacionVO(siiUbicacion);
                liquidacionEstablVo.setUbicacionVo(ubicacionVo);
                liquidacionEstablVo.setHleCodigo(siiHlpLiqEstablAsigRec.getHleCodigo());
                listLiquidacionEstablVo.add(liquidacionEstablVo);
            }
        listRecEstManualVo.get(0).getAsignacionRecaudoVo().setListLiquidacionEstablVo(listLiquidacionEstablVo);


        return listRecEstManualVo;
    }
    
    public AsignacionRecaudoVO actualizarAsignacionRecaudo (AsignacionRecaudoVO asignacionRecaudoVo,  UsuarioVO usuarioLogueado) throws ExcepcionDAO,ExcepcionAplicacion{
        try{
            SiiAsignacionRecaudo siiAsignacionRecaudo;
            BigDecimal divisor = new BigDecimal(100);
            siiAsignacionRecaudo = conversionVoEntidad.convertir(asignacionRecaudoVo);
            if (asignacionRecaudoVo.getAreEstado().equals("A") )
                siiAsignacionRecaudo.setAreEstado("A");
            if (asignacionRecaudoVo.getAreEstado().equals("B") )
                siiAsignacionRecaudo.setAreEstado("B");
            siiAsignacionRecaudo = asignacionRecaudoDao.actualizarAsignacionRecaudo(siiAsignacionRecaudo);
            
            List<SiiHlpLiqEstablAsigRec> listExiste = new ArrayList();
            List<SiiHlpLiqEstablAsigRec> listFinal = new ArrayList();
            listExiste =  hlpLiqEstAsigRecDao.buscarHlpLiqEstablAsigRecXAsigRec(siiAsignacionRecaudo.getAreCodigo());
            boolean tempReg=false; 
            
            //compara para eliminar de la lista los registros
            for(SiiHlpLiqEstablAsigRec unaSiiHlpLiqEstablAsigRec :listExiste  ){
                tempReg=false; 
                for (LiquidacionEstablVO unaLiquidacionEstablVo :asignacionRecaudoVo.getListLiquidacionEstablVo()  ){
                    if(unaLiquidacionEstablVo.getHleCodigo() != null ){
                        if(unaSiiHlpLiqEstablAsigRec.getHleCodigo() == unaLiquidacionEstablVo.getHleCodigo())
                            tempReg=true;   
                    }
                }
                if(tempReg == false)
                    hlpLiqEstAsigRecDao.borrarHlpLiqEstablAsigRec(unaSiiHlpLiqEstablAsigRec.getHleCodigo());
            }
            //compara y inserta registros nuevos
            for (LiquidacionEstablVO unaLiquidacionEstablVo :asignacionRecaudoVo.getListLiquidacionEstablVo()  ){
                if(unaLiquidacionEstablVo.getHleCodigo()== null ){
                    SiiHlpLiqEstablAsigRec unaHlpLiqEstablAsigRec = new SiiHlpLiqEstablAsigRec();
                    unaHlpLiqEstablAsigRec.setAreCodigo(siiAsignacionRecaudo.getAreCodigo());
                    unaHlpLiqEstablAsigRec.setHleNumEstablec(unaLiquidacionEstablVo.getNumEstablecimiento());
                    unaHlpLiqEstablAsigRec.setHlePonderado(unaLiquidacionEstablVo.getLesPonderado().divide(divisor));
                    unaHlpLiqEstablAsigRec.setHleValor(unaLiquidacionEstablVo.getLesValor());
                    SiiUbicacion siiUbicacion =  ubicacionDao.buscarUbicacionPorId(unaLiquidacionEstablVo.getCodigoUbicacion());
                    unaHlpLiqEstablAsigRec.setSiiUbicacionMunEst(siiUbicacion);
                    hlpLiqEstAsigRecDao.insertarHlpLiqEstablAsigRec(unaHlpLiqEstablAsigRec);
                }
                
            }
            
           listFinal =  hlpLiqEstAsigRecDao.buscarHlpLiqEstablAsigRecXAsigRec(siiAsignacionRecaudo.getAreCodigo());
    
            //inserta liquidacion establecimiento y recaudo establecimiento
            if(siiAsignacionRecaudo.getAreEstado().equals("A") ){
                 for ( SiiHlpLiqEstablAsigRec unaHlpLiqEstablAsigRec: listFinal   ){
                    SiiRecaudoEstablec siiRecaudoEstablec = new     SiiRecaudoEstablec ();
                    
                    SiiLiquidacionEstabl siiLiquidacionEstabl = new   SiiLiquidacionEstabl(); 
                    SiiUbicacion siiUbicacion =  ubicacionDao.buscarUbicacionPorId(unaHlpLiqEstablAsigRec.getSiiUbicacionMunEst().getUbiCodigo());
                    siiLiquidacionEstabl.setLesValor(unaHlpLiqEstablAsigRec.getHleValor());
                    siiLiquidacionEstabl.setLesPonderado(unaHlpLiqEstablAsigRec.getHlePonderado());
                    siiLiquidacionEstabl.setSiiUbicacionMunEstab(siiUbicacion);
                    siiLiquidacionEstabl.setLesNumEstablec(unaHlpLiqEstablAsigRec.getHleNumEstablec());
                    siiLiquidacionEstabl.setSiiAsignacionRecaudo(siiAsignacionRecaudo);
                    SiiLiquidacionEstabl unaSiiLiquidacionEstabl = liquidacionEstablecimientoDao.insertarSiiLiquidacionEstabl(siiLiquidacionEstabl);
                    
                    siiRecaudoEstablec.setReeValorPagado(unaHlpLiqEstablAsigRec.getHleValor());
                    SiiDetalleDeclaracion siiDetalleDeclaracion =  detalleDeclaracionDao.buscarPorCodigoDetalleDeclaracion(siiAsignacionRecaudo.getSiiDetalleDeclaracion().getDdeCodigo());
                    siiRecaudoEstablec.setSiiDetalleDeclaracion(siiDetalleDeclaracion);
                    siiRecaudoEstablec.setSiiLiquidacionEstabl(unaSiiLiquidacionEstabl);
                    recaudoEstablecDao.insertarRecaudoEstablec(siiRecaudoEstablec);
                }
            }
            if(siiAsignacionRecaudo.getAreEstado() != null){
            adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.ASIGNACION_RECAUDO.getId(),
                                                        siiAsignacionRecaudo.getAreEstado(),
                                                        usuarioLogueado, siiAsignacionRecaudo.getAreCodigo());
            }
            
            AsignacionRecaudoVO  unaAsignacionRecaudoVo = new AsignacionRecaudoVO(siiAsignacionRecaudo);
        
            return unaAsignacionRecaudoVo;  
         
        } catch (ExcepcionDAO ex){
            ex.printStackTrace();
            throw ex;
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
        }
    }
    
    
    public AsignacionRecaudoVO insertarAsignacionRecaudo(AsignacionRecaudoVO asignacionRecaudoVo) throws ExcepcionDAO{
        AsignacionRecaudoVO resultado = null;
        SiiAsignacionRecaudo siiAsignacionRecaudo = asignacionRecaudoDao.insertarAsignacionRecaudo(conversionVoEntidad.convertir(asignacionRecaudoVo));
        BigDecimal divisor = new BigDecimal(100);
        for ( LiquidacionEstablVO unaLiquidacionEstablVo:asignacionRecaudoVo.getListLiquidacionEstablVo()   ){
            SiiHlpLiqEstablAsigRec siiHlpLiqEstablAsigRec = new SiiHlpLiqEstablAsigRec();
            
            siiHlpLiqEstablAsigRec.setAreCodigo(siiAsignacionRecaudo.getAreCodigo());
            siiHlpLiqEstablAsigRec.setHleNumEstablec(unaLiquidacionEstablVo.getNumEstablecimiento());
            siiHlpLiqEstablAsigRec.setHlePonderado(unaLiquidacionEstablVo.getLesPonderado().divide(divisor));
            siiHlpLiqEstablAsigRec.setHleValor(unaLiquidacionEstablVo.getLesValor());
            SiiUbicacion siiUbicacion =  ubicacionDao.buscarUbicacionPorId(unaLiquidacionEstablVo.getCodigoUbicacion());
            siiHlpLiqEstablAsigRec.setSiiUbicacionMunEst(siiUbicacion);
            siiHlpLiqEstablAsigRec = hlpLiqEstAsigRecDao.insertarHlpLiqEstablAsigRec(siiHlpLiqEstablAsigRec);
        }

        if (siiAsignacionRecaudo!=null)
            resultado = new AsignacionRecaudoVO(siiAsignacionRecaudo);
         
         return resultado;
    
    }
    
    public List<RecaudoEstablecimientoManualVO> todoAsignacionRecaudo() throws ExcepcionDAO {
        List<RecaudoEstablecimientoManualVO>  listRecEstManualVo = new ArrayList();
        List<AsignacionRecaudoVO> listRecaudo = new ArrayList<AsignacionRecaudoVO>();
        
        List<SiiAsignacionRecaudo> listSiiAsignacionRecaudo = new ArrayList<SiiAsignacionRecaudo>();
        listRecEstManualVo = asignacionRecaudoDao.todoAsignacionRecaudo();
        return listRecEstManualVo;
    
    }
    
    
    
}
