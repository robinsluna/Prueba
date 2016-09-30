package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ClaseJuegoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiClaseJuego;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ClaseJuegoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Clases de Juego.
 * @author Camilo Miranda
 */
@Stateless
public class AdminClaseJuegoBean implements AdminClaseJuego 
{
    @EJB
    private ClaseJuegoDAO claseJuegoDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminClaseJuegoBean() { }

    @Override
    public ClaseJuegoVO buscarClaseJuegoPorId(Long cjuCodigo) throws ExcepcionDAO {
        ClaseJuegoVO resultado = null;
        SiiClaseJuego siiClaseJuego = claseJuegoDao.buscarClaseJuegoPorId(cjuCodigo);
        if (siiClaseJuego!=null)
            resultado = new ClaseJuegoVO(siiClaseJuego);
        
        return (resultado);
    }
    
    
    @Override
    public ClaseJuegoVO insertarClaseJuego(ClaseJuegoVO claseJuegoVo) throws ExcepcionDAO {
        ClaseJuegoVO resultado = null;
        SiiClaseJuego siiClaseJuego = claseJuegoDao.insertar(conversionVoEntidad.convertir(claseJuegoVo));
        if (siiClaseJuego!=null)
            resultado = new ClaseJuegoVO(siiClaseJuego);
        
        return (resultado);
    }
    
    
    @Override
    public ClaseJuegoVO actualizarClaseJuego(ClaseJuegoVO claseJuegoVo) throws ExcepcionDAO {
        ClaseJuegoVO resultado = null;
        SiiClaseJuego siiClaseJuego = claseJuegoDao.actualizar(conversionVoEntidad.convertir(claseJuegoVo));
        if (siiClaseJuego!=null)
            resultado = new ClaseJuegoVO(siiClaseJuego);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarClaseJuego(Long cjuCodigo) throws ExcepcionDAO {
        claseJuegoDao.eliminar(cjuCodigo);
    }
    
    
    @Override
    public List<ClaseJuegoVO> buscarTodaClaseJuego() throws ExcepcionDAO {
        List<ClaseJuegoVO> resultado = null;
        List<SiiClaseJuego> lista = claseJuegoDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<ClaseJuegoVO>();
            for (SiiClaseJuego siiClaseJuego: lista) {
                if (siiClaseJuego!=null)
                    resultado.add(new ClaseJuegoVO(siiClaseJuego));
            }
        }
        
        return (resultado);
    }
}
