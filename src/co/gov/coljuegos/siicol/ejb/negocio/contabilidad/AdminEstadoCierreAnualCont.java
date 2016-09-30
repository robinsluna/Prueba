/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-01-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCierreAnualContVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Estados de Cierre Anual Contable.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoCierreAnualCont 
{
    public EstadoCierreAnualContVO buscarEstadoCierreAnualContPorId (Long ecaCodigo) throws ExcepcionDAO;
    public List<EstadoCierreAnualContVO> buscarTodoEstadoCierreAnualCont () throws ExcepcionDAO;
}
