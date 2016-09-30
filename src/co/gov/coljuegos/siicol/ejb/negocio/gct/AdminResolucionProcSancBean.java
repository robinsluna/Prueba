package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionProcSancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionProcSanc;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionProcSancVO;

import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProcSanVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Resoluciones de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Stateless
public class AdminResolucionProcSancBean implements AdminResolucionProcSanc 
{
    @EJB
    private ResolucionProcSancDAO resolucionProcSancDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminTramiteResolProcSan adminTramiteResolProcSan;
    
    
    /**
     * Constructor.
     */
    public AdminResolucionProcSancBean() {
        super();
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de las entidades hijas de la Resoluci&oacute;n de Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @param resolucionProcSancVo - Resoluci&oacute;n de Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirHijos (ResolucionProcSancVO resolucionProcSancVo) throws ExcepcionDAO 
    {
        this.persistirTramitesResolProcSan(resolucionProcSancVo);
    }
    
    
    /**
     * Almacena la informaci&oacute;n de los Tr&aacute;mites asociados a la Resoluci&oacute;n del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @param resolucionProcSancVo - Resoluci&oacute;n del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirTramitesResolProcSan (ResolucionProcSancVO resolucionProcSancVo) throws ExcepcionDAO 
    {
        if (resolucionProcSancVo!=null && resolucionProcSancVo.getTramiteResolProcSanList()!=null) {
            for (TramiteResolProcSanVO trpVo: resolucionProcSancVo.getTramiteResolProcSanList()) {
                if (trpVo!=null) {
                    trpVo.setResolucionProcSancVo(resolucionProcSancVo);
                    
                    TramiteResolProcSanVO resultado = null;
                    if (trpVo.getTrpCodigo() == null) {
                        // OPERACION INSERTAR
                        resultado = adminTramiteResolProcSan.insertarTramiteResolProcSan(trpVo);
                    } else {
                        // OPERACION ACTUALIZAR
                        resultado = adminTramiteResolProcSan.actualizarTramiteResolProcSan(trpVo);
                    }
                    
                    if (resultado!=null)
                        trpVo.setTrpCodigo(resultado.getTrpCodigo());
                }
            }
        }
    }
    
    
    
    @Override
    public ResolucionProcSancVO buscarResolucionProcSancPorCodigo(Long repCodigo) throws ExcepcionDAO {
        ResolucionProcSancVO resultado = null;
        SiiResolucionProcSanc siiResolucionProcSanc = resolucionProcSancDao.buscarPorCodigo(repCodigo);
        if (siiResolucionProcSanc!=null)
            resultado = new ResolucionProcSancVO(siiResolucionProcSanc);
        
        return (resultado);
    }
    
    
    @Override
    public List<ResolucionProcSancVO> buscarTodaResolucionProcSanc() throws ExcepcionDAO {
        List<ResolucionProcSancVO> resultado = null;
        List<SiiResolucionProcSanc> lista = resolucionProcSancDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ResolucionProcSancVO>();
            for (SiiResolucionProcSanc siiResolucionProcSanc: lista) {
                if (siiResolucionProcSanc!=null)
                    resultado.add(new ResolucionProcSancVO(siiResolucionProcSanc));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public ResolucionProcSancVO insertarResolucionProcSanc(ResolucionProcSancVO resolucionProcSancVo) throws ExcepcionDAO {
        return ( this.insertarResolucionProcSanc(resolucionProcSancVo, false) );
    }
    
    
    @Override
    public ResolucionProcSancVO insertarResolucionProcSanc(ResolucionProcSancVO resolucionProcSancVo, boolean cascadeUpdate) throws ExcepcionDAO {
        ResolucionProcSancVO resultado = null;
        SiiResolucionProcSanc siiResolucionProcSanc = resolucionProcSancDao.insertar(conversionVoEntidad.convertir(resolucionProcSancVo));
        if (siiResolucionProcSanc!=null)
            resultado = new ResolucionProcSancVO(siiResolucionProcSanc);
        
        
        if (cascadeUpdate) {
            resultado.setTramiteResolProcSanList(resolucionProcSancVo.getTramiteResolProcSanList());
            
            this.persistirHijos(resultado);
        }
        
        return (resultado);
    }
    
    
    @Override
    public ResolucionProcSancVO actualizarResolucionProcSanc(ResolucionProcSancVO resolucionProcSancVo) throws ExcepcionDAO {
        return ( this.actualizarResolucionProcSanc(resolucionProcSancVo, false) );
    }
    
    
    @Override
    public ResolucionProcSancVO actualizarResolucionProcSanc(ResolucionProcSancVO resolucionProcSancVo, boolean cascadeUpdate) throws ExcepcionDAO {
        ResolucionProcSancVO resultado = null;
        SiiResolucionProcSanc siiResolucionProcSanc = resolucionProcSancDao.actualizar(conversionVoEntidad.convertir(resolucionProcSancVo));
        if (siiResolucionProcSanc!=null)
            resultado = new ResolucionProcSancVO(siiResolucionProcSanc);
        
        
        if (cascadeUpdate) {
            resultado.setTramiteResolProcSanList(resolucionProcSancVo.getTramiteResolProcSanList());
            
            this.persistirHijos(resultado);
        }
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarResolucionProcSanc(Long repCodigo) throws ExcepcionDAO {
        resolucionProcSancDao.eliminar(repCodigo);
    }
}
