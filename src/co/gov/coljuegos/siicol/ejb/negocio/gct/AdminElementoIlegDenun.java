/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoIlegDenunVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminElementoIlegDenun {
    public List<ElementoIlegDenunVO> buscarElementoIlegDenunXCodDenuncia(Long denCodigo) throws ExcepcionDAO;
    public List<ElementoIlegDenunVO> buscarTodoElementoIlegDenunXCodDenuncia(Long denCodigo) throws ExcepcionDAO; 
    public ElementoIlegDenunVO insertarElementoIlegDenun (ElementoIlegDenunVO elementoIlegDenunVo)  throws ExcepcionDAO;
    public ElementoIlegDenunVO actualizarElementoIlegDenun (ElementoIlegDenunVO elementoIlegDenunVo)  throws ExcepcionDAO;
    public ElementoIlegDenunVO buscarElementoInactivo(ElementoIlegDenunVO elementoIlegDenunVo) throws ExcepcionDAO;
}
