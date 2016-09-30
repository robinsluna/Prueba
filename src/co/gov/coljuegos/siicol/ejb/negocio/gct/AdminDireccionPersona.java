/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 05-04-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionPersonaVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interfaz que gestiona las direcciones de la persona
 * @author Paola Andrea Rueda León
 */

@Local
public interface AdminDireccionPersona {
    
    /**
     * Insertar la dirección de la persona
     * @param direccionPersonaVO
     * @return resultado - DireccionPersonaVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    DireccionPersonaVO insertarDireccionPersona(DireccionPersonaVO direccionPersonaVO) throws ExcepcionDAO, ExcepcionAplicacion;
    
     /**
      * Actualizar la dirección de la persona
      * @param direccionPersonaVO
      * @return resultado - DireccionPersonaVO
      * @throws ExcepcionDAO
      * @throws ExcepcionAplicacion
      */

     public DireccionPersonaVO actualizarDireccionPersona(DireccionPersonaVO direccionPersonaVO, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion;
    
    /**
     * Buscar la lista de direcciones según el id de la persona
     * @param perCodigo
     * @return resultado - Lista de DireccionPersonaVO
     * @throws ExcepcionDAO
     */

    public List<DireccionPersonaVO> buscarDireccionPersonaListXIdPersona(Long perCodigo) throws ExcepcionDAO;
}
