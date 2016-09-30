package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoProcesoIleVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Elementos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Local
public interface AdminElementoProcesoIle 
{
    public ElementoProcesoIleVO buscarElementoProcesoIlePorId (Long eprCodigo) throws ExcepcionDAO;
    public ElementoProcesoIleVO insertarElementoProcesoIle (ElementoProcesoIleVO elementoProcesoIleVo) throws ExcepcionDAO;
    public ElementoProcesoIleVO actualizarElementoProcesoIle (ElementoProcesoIleVO elementoProcesoIleVo) throws ExcepcionDAO;
    public void eliminarElementoProcesoIle (Long eprCodigo) throws ExcepcionDAO;
    public List<ElementoProcesoIleVO> buscarTodoElementoProcesoIle () throws ExcepcionDAO;
    public List<ElementoProcesoIleVO> buscarElementoProcesoIlePorIdProceso (Long prsCodigo) throws ExcepcionDAO;
}
