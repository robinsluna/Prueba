/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 09-06-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConcDetRubVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Notas de Cr&eacute;dito por Obligaci&oacute;n Concepto/Detalle Rubro.
 * @author Camilo Miranda
 */
@Local
public interface AdminNotaCredOblConcDetRub 
{
    public NotaCredOblConcDetRubVO buscarNotaCredOblConcDetRubPorId (Long ndrCodigo) throws ExcepcionDAO;
    public NotaCredOblConcDetRubVO insertarNotaCredOblConcDetRub (NotaCredOblConcDetRubVO notaCredOblConcDetRubVo) throws ExcepcionDAO;
    public NotaCredOblConcDetRubVO actualizarNotaCredOblConcDetRub (NotaCredOblConcDetRubVO notaCredOblConcDetRubVo) throws ExcepcionDAO;
    public void borrarNotaCredOblConcDetRub (Long ndrCodigo) throws ExcepcionDAO;
    public List<NotaCredOblConcDetRubVO> buscarTodaNotaCredOblConcDetRub () throws ExcepcionDAO;
    public List<NotaCredOblConcDetRubVO> buscarNotaCredOblConcDetRubPorIdNotaCredito (Long ncrCodigo) throws ExcepcionDAO;
}
