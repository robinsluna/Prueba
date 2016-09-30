/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 03-04-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaCtaBancoVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminPersonaCtaBanco {
    
    public PersonaCtaBancoVO buscarPorCodigo (Long pcbCodigo) throws ExcepcionDAO;
    
    /**
     * @author Modifica Giovanni
     * @param perCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public List<PersonaCtaBancoVO> buscarPersonaCtaBancoPorCodigoPersona (Long perCodigo) throws ExcepcionDAO;
    
}
