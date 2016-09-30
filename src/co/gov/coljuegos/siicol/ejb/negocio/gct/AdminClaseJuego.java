package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ClaseJuegoVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Clases de Juego.
 * @author Camilo Miranda
 */
@Local
public interface AdminClaseJuego 
{
    public ClaseJuegoVO buscarClaseJuegoPorId (Long cjuCodigo) throws ExcepcionDAO;
    public ClaseJuegoVO insertarClaseJuego (ClaseJuegoVO claseJuegoVo) throws ExcepcionDAO;
    public ClaseJuegoVO actualizarClaseJuego (ClaseJuegoVO claseJuegoVo) throws ExcepcionDAO;
    public void eliminarClaseJuego (Long cjuCodigo) throws ExcepcionDAO;
    public List<ClaseJuegoVO> buscarTodaClaseJuego () throws ExcepcionDAO;
}
