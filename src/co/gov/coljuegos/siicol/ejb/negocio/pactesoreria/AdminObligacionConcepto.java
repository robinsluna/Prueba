/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 14-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionConceptoVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n del Concepto de Obligaci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminObligacionConcepto {
    public ObligacionConceptoVO buscarPorCodigoObligacionConcepto (Long idObligacionConcepto) throws ExcepcionDAO;
    public ObligacionConceptoVO insertarObligacionConcepto (ObligacionConceptoVO obligacionConceptoVO) throws ExcepcionDAO;
    public ObligacionConceptoVO actualizarObligacionConcepto (ObligacionConceptoVO obligacionConceptoVO) throws ExcepcionDAO;
    public void borrarObligacionConcepto (Long idObligacionConcepto) throws ExcepcionDAO;
    public List<ObligacionConceptoVO> buscarTodaObligacionConcepto () throws ExcepcionDAO;
    public List<ObligacionConceptoVO> buscarPorCodigoObligacion (Long oblCodigo) throws ExcepcionDAO;
    public List<ObligacionConceptoVO> buscarPorCodigoObligacionRP (Long oblCodigo, Long rpCodigo) throws ExcepcionDAO;
    public List<ObligacionConceptoVO> buscarPorRpFuenteFinancContab (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO;
    public List<ObligacionConceptoVO> buscarPorObligacionRpFuenteFinancContab (Long oblCodigo, Long rpCodigo, String ffcCodigo) throws ExcepcionDAO;
}
