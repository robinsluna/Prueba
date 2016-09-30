/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 27-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoNoDestruccionVO;

import java.util.List;

/**
 * Interface que gestiona los Motivos de No Destrucción
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public interface AdminMotivoNoDestruccion {
    /**
     * Insertar el Motivo No Destrucción
     * @param motivoNoDestruccionVo
     * @return resultado - Motivo de no destrucción.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    MotivoNoDestruccionVO insertarMotivoNoDestruccion(MotivoNoDestruccionVO motivoNoDestruccionVo) throws ExcepcionDAO,
                                                                                                          ExcepcionAplicacion;

    /**
     * Actualizar el Motivo de No Destrucción
     * @param motivoNoDestruccionVo
     * @return resultado - Motivo de No Destrucción.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    MotivoNoDestruccionVO actualizarMotivoNoDestruccion(MotivoNoDestruccionVO motivoNoDestruccionVo) throws ExcepcionDAO,
                                                                                                            ExcepcionAplicacion;

    /**
     * Buscar todos los Motivos de No Destrucción
     * @return resultado - Lista de todos los Motivos de no Destrucción
     * @throws ExcepcionDAO
     */

    List<MotivoNoDestruccionVO> buscarTodoMotivoNoDestruccion() throws ExcepcionDAO;
}
