package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoTramResPrSanVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Estados de Tr&aacute;mite de Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoTramResPrSan 
{
    public EstadoTramResPrSanVO buscarEstadoTramResPrSanPorCodigo (Long etrCodigo) throws ExcepcionDAO;
    public List<EstadoTramResPrSanVO> buscarTodoEstadoTramResPrSan () throws ExcepcionDAO;
}
