/* 
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
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
 * @author Paola Andrea Rueda Le�n
 */

@Local
public interface AdminDireccionPersona {
    
    /**
     * Insertar la direcci�n de la persona
     * @param direccionPersonaVO
     * @return resultado - DireccionPersonaVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    DireccionPersonaVO insertarDireccionPersona(DireccionPersonaVO direccionPersonaVO) throws ExcepcionDAO, ExcepcionAplicacion;
    
     /**
      * Actualizar la direcci�n de la persona
      * @param direccionPersonaVO
      * @return resultado - DireccionPersonaVO
      * @throws ExcepcionDAO
      * @throws ExcepcionAplicacion
      */

     public DireccionPersonaVO actualizarDireccionPersona(DireccionPersonaVO direccionPersonaVO, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion;
    
    /**
     * Buscar la lista de direcciones seg�n el id de la persona
     * @param perCodigo
     * @return resultado - Lista de DireccionPersonaVO
     * @throws ExcepcionDAO
     */

    public List<DireccionPersonaVO> buscarDireccionPersonaListXIdPersona(Long perCodigo) throws ExcepcionDAO;
}
