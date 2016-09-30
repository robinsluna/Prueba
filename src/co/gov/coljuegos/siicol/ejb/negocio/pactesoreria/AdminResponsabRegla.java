/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ResponsabReglaVO;

import java.util.List;

import javax.ejb.Local;



/**
 * Interface para la administraci&oacute;n de la relaci&oacute;n entre Responsabilidad DIAN y Regla de Impuestos.
 * @author Camilo Miranda
 */
@Local
public interface AdminResponsabRegla 
{
    public ResponsabReglaVO buscarResponsabReglaPorCodigo (Long rreCodigo) throws ExcepcionDAO;
    public List<ResponsabReglaVO> buscarTodaResponsabRegla () throws ExcepcionDAO;
    public List<ResponsabReglaVO> buscarPorCodigoResponsabilidadDian (Long rdiCodigo) throws ExcepcionDAO;
}
