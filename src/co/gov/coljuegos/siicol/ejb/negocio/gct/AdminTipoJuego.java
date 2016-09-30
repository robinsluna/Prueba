package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoJuegoVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Tipos de Juego.
 * @author Camilo Miranda
 */
@Local
public interface AdminTipoJuego 
{
    public TipoJuegoVO buscarTipoJuegoPorId (Long tjuCodigo) throws ExcepcionDAO;
    public TipoJuegoVO insertarTipoJuego (TipoJuegoVO tipoJuegoVo) throws ExcepcionDAO;
    public TipoJuegoVO actualizarTipoJuego (TipoJuegoVO tipoJuegoVo) throws ExcepcionDAO;
    public void eliminarTipoJuego (Long tjuCodigo) throws ExcepcionDAO;
    public List<TipoJuegoVO> buscarTodoTipoJuego () throws ExcepcionDAO;
}
