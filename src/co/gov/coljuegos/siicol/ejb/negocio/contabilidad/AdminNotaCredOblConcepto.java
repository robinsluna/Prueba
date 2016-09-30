/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 09-06-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConceptoVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Notas de Cr&eacute;dito por Obligaci&oacute;n Concepto.
 * @author Camilo Miranda
 */
@Local
public interface AdminNotaCredOblConcepto 
{
    public NotaCredOblConceptoVO buscarNotaCredOblConceptoPorId (Long ncoCodigo) throws ExcepcionDAO;
    public NotaCredOblConceptoVO insertarNotaCredOblConcepto (NotaCredOblConceptoVO notaCredOblConceptoVo) throws ExcepcionDAO;
    public NotaCredOblConceptoVO actualizarNotaCredOblConcepto (NotaCredOblConceptoVO notaCredOblConceptoVo) throws ExcepcionDAO;
    public void borrarNotaCredOblConcepto (Long ncoCodigo) throws ExcepcionDAO;
    public List<NotaCredOblConceptoVO> buscarTodaNotaCredOblConcepto () throws ExcepcionDAO;
    public List<NotaCredOblConceptoVO> buscarNotaCredOblConceptoPorIdNotaCredito (Long ncrCodigo) throws ExcepcionDAO;
    public List<NotaCredOblConceptoVO> buscarNotaCredOblConceptoPorObligacionConcepto (Long ocoCodigo) throws ExcepcionDAO;
}
