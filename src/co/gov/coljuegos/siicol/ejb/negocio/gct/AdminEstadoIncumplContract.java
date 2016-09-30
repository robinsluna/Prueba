/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 19-08-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoIncumplContractVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Estados de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoIncumplContract 
{
    public EstadoIncumplContractVO buscarEstadoIncumplContractPorCodigo(Long eicCodigo) throws ExcepcionDAO;
    public List<EstadoIncumplContractVO> buscarTodoEstadoIncumplContract() throws ExcepcionDAO;
}
