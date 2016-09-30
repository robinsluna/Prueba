package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionProcIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionProcIleg;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionProcIlegVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProIleVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminResolucionProcIlegBean implements AdminResolucionProcIleg{
    
    @EJB
    private ResolucionProcIlegDAO resolucionProcIlegDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminTramiteResolProIle adminTramiteResolProIle;
    
    public AdminResolucionProcIlegBean() {
        super();
    }

    @Override
    public ResolucionProcIlegVO buscarResolucionProcSancPorCodigo(Long repCodigo) throws ExcepcionDAO {
        ResolucionProcIlegVO resultado = null;
        SiiResolucionProcIleg siiResolucionProcIleg = resolucionProcIlegDao.buscarPorCodigo(repCodigo);
        if (siiResolucionProcIleg!=null)
            resultado = new ResolucionProcIlegVO(siiResolucionProcIleg);
        
        return (resultado);

    }

    @Override
    public List<ResolucionProcIlegVO> buscarTodaResolucionProcSanc() throws ExcepcionDAO {
        List<ResolucionProcIlegVO> resultado = null;
        List<SiiResolucionProcIleg> lista = resolucionProcIlegDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ResolucionProcIlegVO>();
            for (SiiResolucionProcIleg siiResolucionProcIleg: lista) {
                if (siiResolucionProcIleg!=null)
                    resultado.add(new ResolucionProcIlegVO(siiResolucionProcIleg));
            }
        }
        return (resultado);
    }

    @Override
    public ResolucionProcIlegVO insertarResolucionProcSanc(ResolucionProcIlegVO resolucionVo) throws ExcepcionDAO {
        return ( this.insertarResolucionProcSanc(resolucionVo, false) );
    }

    @Override
    public ResolucionProcIlegVO insertarResolucionProcSanc(ResolucionProcIlegVO resolucionVo, boolean cascadeUpdate) throws ExcepcionDAO {
        ResolucionProcIlegVO resultado = null;
        SiiResolucionProcIleg siiResolucionProcIleg = resolucionProcIlegDao.insertar(conversionVoEntidad.convertir(resolucionVo));
        if (siiResolucionProcIleg!=null)
            resultado = new ResolucionProcIlegVO(siiResolucionProcIleg);
        
        
        if (cascadeUpdate) {
            resultado.setTramiteResolProIleListVo(resolucionVo.getTramiteResolProIleListVo());
            
            this.persistirHijos(resultado);
        }
        
        return (resultado);
    }
    
    /**
     * Almacena la informaci&oacute;n de las entidades hijas de la Resoluci&oacute;n de Proceso Sancionatorio de Ilegalidad.
     * @param resolucionProcIleVo - Resoluci&oacute;n de Proceso Sancionatorio de Ilegalidad.
     * @throws ExcepcionDAO
     */
    private void persistirHijos (ResolucionProcIlegVO resolucionProcIlegVo) throws ExcepcionDAO 
    {
        this.persistirTramitesResolProcSan(resolucionProcIlegVo);
    }

    /**
     * Almacena la informaci&oacute;n de los Tr&aacute;mites asociados a la Resoluci&oacute;n del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @param resolucionProcSancVo - Resoluci&oacute;n del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirTramitesResolProcSan (ResolucionProcIlegVO resolucionProcIlegVo) throws ExcepcionDAO 
    {
        if (resolucionProcIlegVo!=null && resolucionProcIlegVo.getTramiteResolProIleListVo()!=null) {
            for (TramiteResolProIleVO trpVo: resolucionProcIlegVo.getTramiteResolProIleListVo()) {
                if (trpVo!=null) {
                    trpVo.setResolucionProcIlegVo(resolucionProcIlegVo);
                    
                    TramiteResolProIleVO resultado = null;
                    if (trpVo.getTpiCodigo() == null) {
                        // OPERACION INSERTAR
                        resultado = adminTramiteResolProIle.insertarTramiteResolProIle(trpVo);
                    } else {
                        // OPERACION ACTUALIZAR
                        resultado = adminTramiteResolProIle.actualizarTramiteResolProIle(trpVo);
                    }
                    
                    if (resultado!=null)
                        trpVo.setTpiCodigo(resultado.getTpiCodigo());
                }
            }
        }
    }

    @Override
    public ResolucionProcIlegVO actualizarResolucionProcSanc(ResolucionProcIlegVO resolucionVo) throws ExcepcionDAO {
        return ( this.actualizarResolucionProcSanc(resolucionVo, false) );
    }

    @Override
    public ResolucionProcIlegVO actualizarResolucionProcSanc(ResolucionProcIlegVO resolucionVo, boolean cascadeUpdate) throws ExcepcionDAO {
        ResolucionProcIlegVO resultado = null;
        SiiResolucionProcIleg siiResolucionProcIleg = resolucionProcIlegDao.actualizar(conversionVoEntidad.convertir(resolucionVo));
        if (siiResolucionProcIleg!=null)
            resultado = new ResolucionProcIlegVO(siiResolucionProcIleg);
        
        
        if (cascadeUpdate) {
            resultado.setTramiteResolProIleListVo(resolucionVo.getTramiteResolProIleListVo());
            
            this.persistirHijos(resultado);
        }
        
        return (resultado);
    }

    @Override
    public void eliminarResolucionProcSanc(Long repCodigo) throws ExcepcionDAO {
        resolucionProcIlegDao.eliminar(repCodigo);
    }
}

