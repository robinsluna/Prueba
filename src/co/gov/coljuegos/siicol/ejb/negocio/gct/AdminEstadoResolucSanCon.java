/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-08-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoResolucSanConVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Estados de Resoluci&oacute;n Sin Sanci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoResolucSanCon 
{
    public EstadoResolucSanConVO buscarEstadoResolucSanConPorCodigo(Long ersCodigo) throws ExcepcionDAO;
    public List<EstadoResolucSanConVO> buscarTodoEstadoResolucSanCon() throws ExcepcionDAO;
}
