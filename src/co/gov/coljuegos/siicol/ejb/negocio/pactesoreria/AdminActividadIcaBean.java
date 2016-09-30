package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActividadIcaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActividadIca;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ActividadIcaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminActividadIcaBean implements AdminActividadIca {
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ActividadIcaDAO actividadIcaDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminActividadIcaBean() {
        super();
    }
    
    
    @Override
    public ActividadIcaVO buscarPorCodigoActividadIca(String aicCodigo) throws ExcepcionDAO {
        SiiActividadIca siiActividadIca = actividadIcaDao.buscarPorCodigoActividadIca(aicCodigo);
        if (siiActividadIca!=null)
            return ( new ActividadIcaVO(siiActividadIca) );
        return null;
    }
    
    
    @Override
    public ActividadIcaVO insertarActividadIca(ActividadIcaVO actividadIcaVO) throws ExcepcionDAO {
        SiiActividadIca siiActividadIca = actividadIcaDao.insertar(conversionVoEntidad.convertir(actividadIcaVO));
        if (siiActividadIca!=null)
            return ( new ActividadIcaVO(siiActividadIca) );
        return null;
    }
    
    
    @Override
    public ActividadIcaVO actualizarActividadIca(ActividadIcaVO actividadIcaVO) throws ExcepcionDAO {
        SiiActividadIca siiActividadIca = actividadIcaDao.actualizar(conversionVoEntidad.convertir(actividadIcaVO));
        if (siiActividadIca!=null)
            return ( new ActividadIcaVO(siiActividadIca) );
        return null;
    }
    
    
    @Override
    public void borrarActividadIca(String aicCodigo) throws ExcepcionDAO {
        actividadIcaDao.borrarActividadIca(aicCodigo);
    }
    
    
    @Override
    public List<ActividadIcaVO> buscarTodaActividadIca() throws ExcepcionDAO {
        List<ActividadIcaVO> resultado = null;
        
        List<SiiActividadIca> lista = actividadIcaDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ActividadIcaVO>();
            for (SiiActividadIca siiActividadIca: lista) {
                resultado.add(new ActividadIcaVO(siiActividadIca));
            }
        }
        return (resultado);
    }
}
