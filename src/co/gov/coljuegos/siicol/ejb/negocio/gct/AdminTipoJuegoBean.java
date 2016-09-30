package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoJuegoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoJuego;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoJuegoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminTipoJuegoBean implements AdminTipoJuego 
{
    @EJB
    private TipoJuegoDAO tipoJuegoDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminTipoJuegoBean() { }
    
    
    @Override
    public TipoJuegoVO buscarTipoJuegoPorId(Long tjuCodigo) throws ExcepcionDAO {
        TipoJuegoVO resultado = null;
        SiiTipoJuego siiTipoJuego = tipoJuegoDao.buscarPorCodigo(tjuCodigo);
        if (siiTipoJuego!=null)
            resultado = new TipoJuegoVO(siiTipoJuego);
        
        return (resultado);
    }
    
    
    @Override
    public TipoJuegoVO insertarTipoJuego(TipoJuegoVO tipoJuegoVo) throws ExcepcionDAO {
        TipoJuegoVO resultado = null;
        SiiTipoJuego siiTipoJuego = tipoJuegoDao.insertar(conversionVoEntidad.convertir(tipoJuegoVo));
        if (siiTipoJuego!=null)
            resultado = new TipoJuegoVO(siiTipoJuego);
        
        return (resultado);
    }
    
    
    @Override
    public TipoJuegoVO actualizarTipoJuego(TipoJuegoVO tipoJuegoVo) throws ExcepcionDAO {
        TipoJuegoVO resultado = null;
        SiiTipoJuego siiTipoJuego = tipoJuegoDao.actualizar(conversionVoEntidad.convertir(tipoJuegoVo));
        if (siiTipoJuego!=null)
            resultado = new TipoJuegoVO(siiTipoJuego);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarTipoJuego(Long tjuCodigo) throws ExcepcionDAO {
        tipoJuegoDao.eliminar(tjuCodigo);
    }
    

    @Override
    public List<TipoJuegoVO> buscarTodoTipoJuego() throws ExcepcionDAO {
        List<TipoJuegoVO> resultado = null;
        List<SiiTipoJuego> lista = tipoJuegoDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TipoJuegoVO>();
            
            for (SiiTipoJuego siiTipoJuego: lista) {
                if (siiTipoJuego!=null)
                    resultado.add(new TipoJuegoVO(siiTipoJuego));
            }
        }
        
        return (resultado);
    }
}
