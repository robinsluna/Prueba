/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 16-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.FuenteFinancContabVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminFuenteFinancContab 
{
    public FuenteFinancContabVO buscarPorCodigoFuenteFinancContab (String ffcCodigo) throws ExcepcionDAO;
    public FuenteFinancContabVO insertarFuenteFinancContab (FuenteFinancContabVO fuenteFinancContabVO) throws ExcepcionDAO;
    public FuenteFinancContabVO actualizarFuenteFinancContab (FuenteFinancContabVO fuenteFinancContabVO) throws ExcepcionDAO;
    public void borrarFuenteFinancContab (String ffcCodigo) throws ExcepcionDAO;
    public List<FuenteFinancContabVO> buscarTodaFuenteFinancContab () throws ExcepcionDAO;
    public List<FuenteFinancContabVO> buscarFuenteFinancContabPorRp(Long rpCodigo) throws ExcepcionDAO;
}
