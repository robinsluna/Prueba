package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionIncumContrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionIncumContr;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionIncumContrVO;

import co.gov.coljuegos.siicol.ejb.vo.TramiteResolSanConVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Resoluciones de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Stateless
public class AdminResolucionIncumContrBean implements AdminResolucionIncumContr 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ResolucionIncumContrDAO resolucionIncumContrDao;
    @EJB
    private AdminTramiteResolSanCon adminTramiteResolSanCon;
    
    
    
    /**
     * Constructor.
     */
    public AdminResolucionIncumContrBean() {
        super();
    }
    
    
    
    
    /**
     * Almacena la informaci&oacute;n de las entidades hijas de la Resoluci&oacute;n de Incumplimiento Contractual.
     * @param resolucionIncumContrVo - Resoluci&oacute;n de Incumplimiento Contractual.
     * @throws ExcepcionDAO
     */
    private void persistirHijos (ResolucionIncumContrVO resolucionIncumContrVo) throws ExcepcionDAO 
    {
        this.persistirTramitesResolSanCon(resolucionIncumContrVo);
    }
    
    
    /**
     * Almacena los Tr&aacute;mites de la Resoluci&oacute;n de Incumplimiento Contractual.
     * @param resolucionIncumContrVo
     * @throws ExcepcionDAO
     */
    private void persistirTramitesResolSanCon (ResolucionIncumContrVO resolucionIncumContrVo) throws ExcepcionDAO 
    {
        if (resolucionIncumContrVo!=null && resolucionIncumContrVo.getTramiteResolSanConList()!=null) {
            for (TramiteResolSanConVO trsVo: resolucionIncumContrVo.getTramiteResolSanConList()) {
                if (trsVo!=null) {
                    trsVo.setResolucionIncumContrVo(resolucionIncumContrVo);
                    
                    if (trsVo.getTrsCodigo() == null) {
                        // OPERACION INSERTAR
                        TramiteResolSanConVO resultado = adminTramiteResolSanCon.insertarTramiteResolSanCon(trsVo);
                        if (resultado!=null)
                            trsVo.setTrsCodigo(resultado.getTrsCodigo());
                    } else {
                        // OPERACION ACTUALIZAR
                        adminTramiteResolSanCon.actualizarTramiteResolSanCon(trsVo);
                    }
                }
            }
        }
    }
    
    
    
    @Override
    public ResolucionIncumContrVO buscarResolucionIncumContrPorId(Long rcoCodigo) throws ExcepcionDAO {
        ResolucionIncumContrVO resultado = null;
        SiiResolucionIncumContr siiResolucionIncumContr = resolucionIncumContrDao.buscarPorCodigo(rcoCodigo);
        if (siiResolucionIncumContr!=null)
            resultado = new ResolucionIncumContrVO(siiResolucionIncumContr);
        
        return (resultado);
    }
    
    
    @Override
    public ResolucionIncumContrVO insertarResolucionIncumContr(ResolucionIncumContrVO resolucionIncumContrVo) throws ExcepcionDAO {
        return ( this.insertarResolucionIncumContr(resolucionIncumContrVo, false) );
    }
    
    
    @Override
    public ResolucionIncumContrVO insertarResolucionIncumContr(ResolucionIncumContrVO resolucionIncumContrVo, boolean cascadeUpdate) throws ExcepcionDAO {
        ResolucionIncumContrVO resultado = null;
        SiiResolucionIncumContr siiResolucionIncumContr = resolucionIncumContrDao.insertar(conversionVoEntidad.convertir(resolucionIncumContrVo));
        if (siiResolucionIncumContr!=null) {
            resultado = new ResolucionIncumContrVO(siiResolucionIncumContr);
            
            if (cascadeUpdate) {
                resultado.setTramiteResolSanConList(resolucionIncumContrVo.getTramiteResolSanConList());
                
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public ResolucionIncumContrVO actualizarResolucionIncumContr(ResolucionIncumContrVO resolucionIncumContrVo) throws ExcepcionDAO {
        return ( this.actualizarResolucionIncumContr(resolucionIncumContrVo, false) );
    }
    
    
    @Override
    public ResolucionIncumContrVO actualizarResolucionIncumContr(ResolucionIncumContrVO resolucionIncumContrVo, boolean cascadeUpdate) throws ExcepcionDAO {
        ResolucionIncumContrVO resultado = null;
        SiiResolucionIncumContr siiResolucionIncumContr = resolucionIncumContrDao.actualizar(conversionVoEntidad.convertir(resolucionIncumContrVo));
        if (siiResolucionIncumContr!=null) {
            resultado = new ResolucionIncumContrVO(siiResolucionIncumContr);
            
            if (cascadeUpdate) {
                resultado.setTramiteResolSanConList(resolucionIncumContrVo.getTramiteResolSanConList());
                
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    

    @Override
    public void borrarResolucionIncumContr(Long rcoCodigo) throws ExcepcionDAO {
        resolucionIncumContrDao.eliminar(rcoCodigo);
    }
    
    
    @Override
    public List<ResolucionIncumContrVO> buscarTodaResolucionIncumContr() throws ExcepcionDAO {
        List<ResolucionIncumContrVO> resultado = null;
        List<SiiResolucionIncumContr> lista = resolucionIncumContrDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ResolucionIncumContrVO>();
            for (SiiResolucionIncumContr siiResolucionIncumContr: lista) {
                if (siiResolucionIncumContr!=null)
                    resultado.add(new ResolucionIncumContrVO(siiResolucionIncumContr));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<ResolucionIncumContrVO> buscarResolucionIncumContrPorEstadoTramEInterponeRecurso (Long ersCodigo, String rcoReponeRecurso) throws ExcepcionDAO {
        List<ResolucionIncumContrVO> resultado = null;
        List<SiiResolucionIncumContr> lista = resolucionIncumContrDao.buscarResolucionIncumContrPorEstadoTramEInterponeRecurso(ersCodigo, rcoReponeRecurso);
        if (lista!=null) {
            resultado = new ArrayList<ResolucionIncumContrVO>();
            for (SiiResolucionIncumContr siiResolucionIncumContr: lista) {
                if (siiResolucionIncumContr!=null)
                    resultado.add(new ResolucionIncumContrVO(siiResolucionIncumContr));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<ResolucionIncumContrVO> buscarResolucionIncumContrPorEstadoTramite (Long ersCodigo) throws ExcepcionDAO {
        List<ResolucionIncumContrVO> resultado = null;
        List<SiiResolucionIncumContr> lista = resolucionIncumContrDao.buscarResolucionIncumContrPorEstadoTramite(ersCodigo);
        if (lista!=null) {
            resultado = new ArrayList<ResolucionIncumContrVO>();
            for (SiiResolucionIncumContr siiResolucionIncumContr: lista) {
                if (siiResolucionIncumContr!=null)
                    resultado.add(new ResolucionIncumContrVO(siiResolucionIncumContr));
            }
        }
        
        return (resultado);
    }
}
