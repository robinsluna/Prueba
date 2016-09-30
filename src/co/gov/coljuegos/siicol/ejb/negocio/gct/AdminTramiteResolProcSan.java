package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProcSanVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Tr&aacute;mites de Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Local
public interface AdminTramiteResolProcSan 
{
    public TramiteResolProcSanVO buscarTramiteResolProcSanPorCodigo (Long trpCodigo) throws ExcepcionDAO;
    public List<TramiteResolProcSanVO> buscarTodoTramiteResolProcSan() throws ExcepcionDAO;
    public List<TramiteResolProcSanVO> buscarTramiteResolProcSanPorIdResolucion (Long repCodigo) throws ExcepcionDAO;
    public TramiteResolProcSanVO insertarTramiteResolProcSan (TramiteResolProcSanVO tramiteResolProcSanVo) throws ExcepcionDAO;
    public TramiteResolProcSanVO actualizarTramiteResolProcSan (TramiteResolProcSanVO tramiteResolProcSanVo) throws ExcepcionDAO;
    public void eliminarTramiteResolProcSan (Long trpCodigo) throws ExcepcionDAO;
}
