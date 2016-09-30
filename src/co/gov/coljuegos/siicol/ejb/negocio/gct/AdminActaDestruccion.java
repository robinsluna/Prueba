/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 27-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ActaDestruccionVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interface que gestiona las actas de destrucci�n.
 * @author PAOLA ANDREA RUEDA LE�N
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
     * Actualizar la informaci�n del Acta de Destrucci�n.
     * @param actaDestruccionVo
     * @return resultado - Acta de destrucci�n.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    ActaDestruccionVO actualizarActaDestruccion(ActaDestruccionVO actaDestruccionVo) throws ExcepcionDAO,
                                                                                            ExcepcionAplicacion;

    /**
     * Buscar todas las actas de destrucci�n.
     * @return resultado - lista de todas las actas de destrucci�n.
     * @throws ExcepcionDAO
     */

    List<ActaDestruccionVO> buscarTodaActaDestruccion() throws ExcepcionDAO;
}
