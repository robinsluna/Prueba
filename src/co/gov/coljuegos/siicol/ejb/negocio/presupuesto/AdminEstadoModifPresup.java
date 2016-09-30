/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoModifPresupVO;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de Estados de la Modificaci&oacute;n Presupuestal.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoModifPresup {
    public EstadoModifPresupVO buscarEstadoModifPresupPorId (Long idMprCodigo) throws ExcepcionDAO;
    public EstadoModifPresupVO actualizarEstadoModifPresup (EstadoModifPresupVO estadoModifPresupVo) throws ExcepcionDAO;
    public EstadoModifPresupVO insertarEstadoModifPresup (EstadoModifPresupVO estadoModifPresupVo) throws ExcepcionDAO;
}
