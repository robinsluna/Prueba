package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcesoSancVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Estados de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoProcesoSanc 
{
    public EstadoProcesoSancVO buscarEstadoProcesoSancPorCodigo (Long epsCodigo) throws ExcepcionDAO;
    public List<EstadoProcesoSancVO> buscarTodoEstadoProcesoSanc () throws ExcepcionDAO;
}
