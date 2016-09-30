/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 27-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ActaDestruccionVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interface que gestiona las actas de destrucción.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Local
public interface AdminActaDestruccion {
    
    /**
     * Insertar
     * @param actaDestruccionVo
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    ActaDestruccionVO insertarActaDestruccion(ActaDestruccionVO actaDestruccionVo) throws ExcepcionDAO,
                                                                                          ExcepcionAplicacion;

    /**
     * Actualizar la información del Acta de Destrucción.
     * @param actaDestruccionVo
     * @return resultado - Acta de destrucción.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    ActaDestruccionVO actualizarActaDestruccion(ActaDestruccionVO actaDestruccionVo) throws ExcepcionDAO,
                                                                                            ExcepcionAplicacion;

    /**
     * Buscar todas las actas de destrucción.
     * @return resultado - lista de todas las actas de destrucción.
     * @throws ExcepcionDAO
     */

    List<ActaDestruccionVO> buscarTodaActaDestruccion() throws ExcepcionDAO;
}
