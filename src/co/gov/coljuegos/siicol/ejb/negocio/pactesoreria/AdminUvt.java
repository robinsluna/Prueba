/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 13-05-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.UvtVO;

import javax.ejb.Local;


/**
 * Interface local para la administraci&oacute;n de UVT.
 * @author Camilo Miranda
 */
@Local
public interface AdminUvt {
    
    public UvtVO obtenerUvtPorVigencia (Integer uvtVigencia) throws ExcepcionDAO;
    
}
