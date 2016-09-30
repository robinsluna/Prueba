package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolProcSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProcSan;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProcSanVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Tr&aacute;mites de Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Stateless
public class AdminTramiteResolProcSanBean implements AdminTramiteResolProcSan 
{
    @EJB
    private TramiteResolProcSanDAO tramiteResolProcSanDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminTramiteResolProcSanBean() {
        super();
    }
    
    
    @Override
    public TramiteResolProcSanVO buscarTramiteResolProcSanPorCodigo(Long trpCodigo) throws ExcepcionDAO {
        TramiteResolProcSanVO resultado = null;
        SiiTramiteResolProcSan siiTramiteResolProcSan = tramiteResolProcSanDao.buscarPorCodigo(trpCodigo);
        if (siiTramiteResolProcSan!=null)
            resultado = new TramiteResolProcSanVO(siiTramiteResolProcSan);
        
        return (resultado);
    }
    
    
    @Override
    public List<TramiteResolProcSanVO> buscarTodoTramiteResolProcSan() throws ExcepcionDAO {
        List<TramiteResolProcSanVO> resultado = null;
        List<SiiTramiteResolProcSan> lista = tramiteResolProcSanDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<TramiteResolProcSanVO>();
            for (SiiTramiteResolProcSan siiTramiteResolProcSan: lista) {
                if (siiTramiteResolProcSan!=null)
                    resultado.add(new TramiteResolProcSanVO(siiTramiteResolProcSan));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<TramiteResolProcSanVO> buscarTramiteResolProcSanPorIdResolucion(Long repCodigo) throws ExcepcionDAO {
        List<TramiteResolProcSanVO> resultado = null;
        List<SiiTramiteResolProcSan> lista = tramiteResolProcSanDao.buscarTramiteResolProcSanPorIdResolucion(repCodigo);
        if (lista!=null) {
            resultado = new ArrayList<TramiteResolProcSanVO>();
            for (SiiTramiteResolProcSan siiTramiteResolProcSan: lista) {
                if (siiTramiteResolProcSan!=null)
                    resultado.add(new TramiteResolProcSanVO(siiTramiteResolProcSan));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public TramiteResolProcSanVO insertarTramiteResolProcSan(TramiteResolProcSanVO tramiteResolProcSanVo) throws ExcepcionDAO {
        TramiteResolProcSanVO resultado = null;
        SiiTramiteResolProcSan siiTramiteResolProcSan = tramiteResolProcSanDao.insertar(conversionVoEntidad.convertir(tramiteResolProcSanVo));
        if (siiTramiteResolProcSan!=null)
            resultado = new TramiteResolProcSanVO(siiTramiteResolProcSan);
        
        return (resultado);
    }
    
    
    @Override
    public TramiteResolProcSanVO actualizarTramiteResolProcSan(TramiteResolProcSanVO tramiteResolProcSanVo) throws ExcepcionDAO {
        TramiteResolProcSanVO resultado = null;
        SiiTramiteResolProcSan siiTramiteResolProcSan = tramiteResolProcSanDao.actualizar(conversionVoEntidad.convertir(tramiteResolProcSanVo));
        if (siiTramiteResolProcSan!=null)
            resultado = new TramiteResolProcSanVO(siiTramiteResolProcSan);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarTramiteResolProcSan(Long trpCodigo) throws ExcepcionDAO {
        tramiteResolProcSanDao.eliminar(trpCodigo);
    }
}
