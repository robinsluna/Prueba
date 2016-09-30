/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 16-05-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoRetencionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoRetencion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoRetencionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class AdminTipoRetencionBean implements AdminTipoRetencion {
    
    @EJB
    private TipoRetencionDAO tipoRetencionDao;
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminTipoRetencionBean() {
        super();
    }
    
    
    
    @Override
    public TipoRetencionVO buscarPorCodigo(String treCodigo) throws ExcepcionDAO {
        TipoRetencionVO tipoRetencionVo = null;
        SiiTipoRetencion siiTipoRetencion = tipoRetencionDao.buscarPorCodigo(treCodigo);
        if (siiTipoRetencion!=null)
            tipoRetencionVo = new TipoRetencionVO(siiTipoRetencion);
        
        return (tipoRetencionVo);
    }
    
    
    @Override
    public List<TipoRetencionVO> buscarTodoTipoRetencion() throws ExcepcionDAO {
        List<TipoRetencionVO> resultado = null;
        List<SiiTipoRetencion> lista = tipoRetencionDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<TipoRetencionVO>();
            for (SiiTipoRetencion siiTipoRetencion: lista) {
                if (siiTipoRetencion!=null) {
                    resultado.add(new TipoRetencionVO(siiTipoRetencion));
                }
            }
        }
        
        return (resultado);
    }
    
    public TipoRetencionVO insertarTipoRetencion (TipoRetencionVO tipoRetencionVo) throws ExcepcionDAO{
        
        SiiTipoRetencion siiTipoRetencion = conversionVoEntidad.convertir(tipoRetencionVo);
        siiTipoRetencion = tipoRetencionDao.insertar(siiTipoRetencion);
        return new TipoRetencionVO(siiTipoRetencion);        
    }
    
    public TipoRetencionVO actualizarTipoRetencion (TipoRetencionVO tipoRetencionVo) throws ExcepcionDAO{
        SiiTipoRetencion siiTipoRetencion = conversionVoEntidad.convertir(tipoRetencionVo);
        siiTipoRetencion = tipoRetencionDao.actualizar(siiTipoRetencion);
        return new TipoRetencionVO(siiTipoRetencion);  
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoRetencionDAO#buscarPorIdGrupoRetencion(java.lang.Long)
     */
    @Override
    public List<TipoRetencionVO> buscarPorIdGrupoRetencion (Long greCodigo) throws ExcepcionDAO 
    {
        List<TipoRetencionVO> resultado = null;
        List<SiiTipoRetencion> lista = tipoRetencionDao.buscarPorIdGrupoRetencion(greCodigo);
        if (lista!=null) {
            resultado = new ArrayList<TipoRetencionVO>();
            for (SiiTipoRetencion siiTipoRetencion: lista) {
                if (siiTipoRetencion!=null) {
                    resultado.add(new TipoRetencionVO(siiTipoRetencion));
                }
            }
        }
        
        return (resultado);
    }
}
