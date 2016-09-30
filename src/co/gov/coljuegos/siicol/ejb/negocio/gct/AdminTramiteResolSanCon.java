/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 19-08-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolSanConVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo del Tr&aacute;mite de Resoluci&oacute;n sin Sanci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminTramiteResolSanCon 
{
    public TramiteResolSanConVO buscarTramiteResolSanConPorCodigo(Long trsCodigo) throws ExcepcionDAO;
    public List<TramiteResolSanConVO> buscarTodoTramiteResolSanCon() throws ExcepcionDAO;
    public List<TramiteResolSanConVO> buscarTramiteResolSanConPorIdResolucion (Long rcoCodigo) throws ExcepcionDAO;
    public TramiteResolSanConVO insertarTramiteResolSanCon (TramiteResolSanConVO tramiteResolSanConVo) throws ExcepcionDAO;
    public TramiteResolSanConVO actualizarTramiteResolSanCon (TramiteResolSanConVO tramiteResolSanConVo) throws ExcepcionDAO;
    public void eliminarTramiteResolSanCon (Long trsCodigo) throws ExcepcionDAO;
}
