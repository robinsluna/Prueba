/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 17-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.FiltrosLibroAuxiliarVO;
import co.gov.coljuegos.siicol.ejb.vo.LibroAuxiliarVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminLibroAuxiliar {
    
    public List<LibroAuxiliarVO> generarLibroAuxiliarPorComprobante (Long idDocumentoContable) throws ExcepcionDAO;
    public List<DocumentoContableVO> buscarTodoNumerocomprobanteDocCon(String tdcCodigo  ) throws ExcepcionDAO;
    public List<LibroAuxiliarVO> generarLibroAuxiliarPorFiltros (FiltrosLibroAuxiliarVO filtros) throws ExcepcionDAO;
    
}
