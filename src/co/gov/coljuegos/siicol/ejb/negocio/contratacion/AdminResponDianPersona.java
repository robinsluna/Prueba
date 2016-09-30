/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ResponDianPersonaVO;

import java.util.List;

import javax.ejb.Local;



/**
 * Interface local para el manejo de la persistencia de la Responsabilidad DIAN por Persona.
 * @author Camilo Miranda
 */
@Local
public interface AdminResponDianPersona 
{
    public ResponDianPersonaVO buscarPorCodigoResponDianPersona (Long rdpCodigo) throws ExcepcionDAO;
    public ResponDianPersonaVO insertarResponDianPersona (ResponDianPersonaVO responDianPersonaVo) throws ExcepcionDAO;
    public ResponDianPersonaVO actualizarResponDianPersona (ResponDianPersonaVO responDianPersonaVo) throws ExcepcionDAO;
    public void eliminarResponDianPersona (Long rdpCodigo) throws ExcepcionDAO;
    public List<ResponDianPersonaVO> buscarTodaResponDianPersona () throws ExcepcionDAO;
    public List<ResponDianPersonaVO> buscarPorCodigoPersona (Long perCodigo) throws ExcepcionDAO;
}
