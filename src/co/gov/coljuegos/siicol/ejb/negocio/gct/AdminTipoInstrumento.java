package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoInstrumentoVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Tipos de Instrumento.
 * @author Camilo Miranda
 */
@Local
public interface AdminTipoInstrumento 
{
    public TipoInstrumentoVO buscarTipoInstrumentoPorCodigo (Long tinCodigo) throws ExcepcionDAO;
    public TipoInstrumentoVO insertarTipoInstrumento (TipoInstrumentoVO tipoInstrumentoVo) throws ExcepcionDAO;
    public TipoInstrumentoVO actualizarTipoInstrumento (TipoInstrumentoVO tipoInstrumentoVo) throws ExcepcionDAO;
    public void eliminarTipoInstrumento (Long tinCodigo) throws ExcepcionDAO;
    public List<TipoInstrumentoVO> buscarTodoTipoInstrumento () throws ExcepcionDAO;
}
