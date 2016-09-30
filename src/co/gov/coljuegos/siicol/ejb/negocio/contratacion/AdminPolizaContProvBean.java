package co.gov.coljuegos.siicol.ejb.negocio.contratacion;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AmparoPolContProvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoProveedorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PolizaContProvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoPolContProv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContProv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AmparoPolContProvVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaContProvVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminPolizaContProvBean implements AdminPolizaContProv{
    @Resource
    SessionContext sessionContext;
    @EJB 
    PolizaContProvDAO polizaContProvDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    AmparoPolContProvDAO amparoPolContProvDao;
    @EJB
    RpDAO rpDao;
    @EJB
    ProcesoContratacionDAO procesoContratacionDao;
    @EJB
    ContratoProveedorDAO contratoProveedorDao;
   
    
    public AdminPolizaContProvBean() {    
    }
    
    public PolizaContProvVO buscarPolizaContProvPorId (Long idPolizaContProv) throws ExcepcionDAO{
        SiiPolizaContProv siiPolizaContProv = polizaContProvDao.buscarPolizaContProvPorId(idPolizaContProv);
        return new PolizaContProvVO(siiPolizaContProv);
    }
    
    public PolizaContProvVO actualizarPolizaContProv(PolizaContProvVO polizaContProvVo) throws ExcepcionDAO{
        SiiPolizaContProv siiPolizaContProv = polizaContProvDao.actualizarPolizaContProv(conversionVoEntidad.convertir(polizaContProvVo));
        return new PolizaContProvVO(siiPolizaContProv);
    }
    public PolizaContProvVO insertarPolizaContProv (PolizaContProvVO polizaContProvVo) throws ExcepcionDAO{
        SiiPolizaContProv siiPolizaContProv = conversionVoEntidad.convertir(polizaContProvVo);
        siiPolizaContProv = polizaContProvDao.insertarPolizaContProv(siiPolizaContProv);
        return new PolizaContProvVO(siiPolizaContProv);
    }
    
    public List<PolizaContProvVO> buscarTodosPolizaContProv () throws ExcepcionDAO{
        List<SiiPolizaContProv> listaPolizaContProv = polizaContProvDao.buscarTodoPolizaContProv();
        List<PolizaContProvVO> listaPolizaContProvVo = new ArrayList<PolizaContProvVO>();
        for (SiiPolizaContProv unaPolizaContProv : listaPolizaContProv){
            listaPolizaContProvVo.add(new PolizaContProvVO(unaPolizaContProv));
        }
        return listaPolizaContProvVo;
    }
    
    public PolizaContProvVO insertarPolizaGarantia (PolizaContProvVO polizaContProvVo) throws ExcepcionDAO{
        SiiPolizaContProv siiPolizaContProv = conversionVoEntidad.convertir(polizaContProvVo);
        SiiPolizaContProv siiPolizaContProvRetorno = polizaContProvDao.insertarPolizaContProv(siiPolizaContProv);  
        
        List<AmparoPolContProvVO> listaAmparoPolContProvVo = polizaContProvVo.getAmparoPolContProvListVo();
        if (listaAmparoPolContProvVo != null){
            for (AmparoPolContProvVO unAmparoPolContProvVo : listaAmparoPolContProvVo){
                SiiAmparoPolContProv nuevoAmparoPolContProv = conversionVoEntidad.convertir(unAmparoPolContProvVo);
                nuevoAmparoPolContProv.setSiiPolizaContProv(siiPolizaContProvRetorno);
                amparoPolContProvDao.insertarAmparoPolContProv(nuevoAmparoPolContProv);
            }
        }
        return new PolizaContProvVO(siiPolizaContProvRetorno);
    }
    public List<PolizaContProvVO> buscarPolizaContProvPorIdProcesoContratacion (Long idProcesoContratacion) throws ExcepcionDAO{
        List<SiiPolizaContProv> listaPolizaContProv = polizaContProvDao.buscarPolizaContProvPorIdProcesoContratacion(idProcesoContratacion);
        List<PolizaContProvVO> listaPolizaContProvVo = new ArrayList<PolizaContProvVO>();
        for (SiiPolizaContProv unaPolizaContProv : listaPolizaContProv){
            listaPolizaContProvVo.add(new PolizaContProvVO(unaPolizaContProv));
        }
        return listaPolizaContProvVo;
    }
    
    public PolizaContProvVO actualizarPolizaGarantia (PolizaContProvVO polizaContProvVo, List<AmparoPolContProvVO> listaAgregarAmparoPolContProv, List<AmparoPolContProvVO> listaEliminarAmparoPolContProv, ProcesoContratacionVO procesoContratacionVo, ContratoProveedorVO contratoProveedorVo ) throws ExcepcionDAO{        

        SiiPolizaContProv siiPolizaContProv = conversionVoEntidad.convertir(polizaContProvVo);
        siiPolizaContProv = polizaContProvDao.actualizarPolizaContProv(siiPolizaContProv);
        if (listaAgregarAmparoPolContProv != null){
            for (AmparoPolContProvVO amparoPolContProvVo :  listaAgregarAmparoPolContProv){
                SiiAmparoPolContProv nuevoAmparoPolContProv = conversionVoEntidad.convertir(amparoPolContProvVo);
                if (nuevoAmparoPolContProv.getApcCodigo() == null){
                    nuevoAmparoPolContProv.setApcCodigo(nuevoAmparoPolContProv.getApcCodigo());                    
                    nuevoAmparoPolContProv.setApcValorAseg(nuevoAmparoPolContProv.getApcValorAseg());
                    nuevoAmparoPolContProv.setApcVigenciaDes(nuevoAmparoPolContProv.getApcVigenciaDes());
                    nuevoAmparoPolContProv.setApcVigenciaHas(nuevoAmparoPolContProv.getApcVigenciaHas());
                    nuevoAmparoPolContProv.setSiiPolizaContProv(siiPolizaContProv);
                    nuevoAmparoPolContProv.setSiiTipoAmparo(nuevoAmparoPolContProv.getSiiTipoAmparo());
                    amparoPolContProvDao.insertarAmparoPolContProv(nuevoAmparoPolContProv);
                }
            }
        }
        
        if (listaEliminarAmparoPolContProv != null){
            for (AmparoPolContProvVO amparoPolContProvVo : listaEliminarAmparoPolContProv){
                SiiAmparoPolContProv nuevoAmparoPolContProv = conversionVoEntidad.convertir(amparoPolContProvVo);
                if (nuevoAmparoPolContProv.getApcCodigo() != null){
                    amparoPolContProvDao.eliminarAmparoPolContProv(nuevoAmparoPolContProv.getApcCodigo());
                }
            }
        }
                

        actualizarProcesoContrato(procesoContratacionVo, contratoProveedorVo); 

        return polizaContProvVo;
    }

    
    public PolizaContProvVO registrarPolizaGarantia (PolizaContProvVO polizaContProvVo, ProcesoContratacionVO procesoContratacionVo, ContratoProveedorVO contratoProveedorVo ) throws ExcepcionDAO{

        polizaContProvVo  = new PolizaContProvVO(polizaContProvDao.actualizarPolizaContProv(conversionVoEntidad.convertir(polizaContProvVo))); 
        
        actualizarProcesoContrato(procesoContratacionVo, contratoProveedorVo); 
        
       
        return polizaContProvVo;
    }

    private void actualizarProcesoContrato(ProcesoContratacionVO procesoContratacionVo, ContratoProveedorVO contratoProveedorVo) throws ExcepcionDAO {
        List<RpVO> listaRpVo = new ArrayList<RpVO>();
        
        for (SiiRp siiRp : rpDao.buscarRpAprobadosPorIdProcesoContratacion(procesoContratacionVo.getPrcCodigo())){
            listaRpVo.add(new RpVO(siiRp));
        }        
        if (listaRpVo.size() > 0){
            procesoContratacionDao.actualizarProcesoContratacion(conversionVoEntidad.convertir(procesoContratacionVo));
            contratoProveedorDao.actualizarContratoProveedor(conversionVoEntidad.convertir(contratoProveedorVo));
        }
    }

}

