/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 27-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoNoDestruccionVO;

import java.util.List;

/**
 * Interface que gestiona los Motivos de No Destrucci�n
 * @author PAOLA ANDREA RUEDA LE�N
 */

public interface AdminMotivoNoDestruccion {
    /**
     * Insertar el Motivo No Destrucci�n
     * @param motivoNoDestruccionVo
     * @return resultado - Motivo de no destrucci�n.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    MotivoNoDestruccionVO insertarMotivoNoDestruccion(MotivoNoDestruccionVO motivoNoDestruccionVo) throws ExcepcionDAO,
                                                                                                          ExcepcionAplicacion;

    /**
     * Actualizar el Motivo de No Destrucci�n
     * @param motivoNoDestruccionVo
     * @return resultado - Motivo de No Destrucci�n.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    MotivoNoDestruccionVO actualizarMotivoNoDestruccion(MotivoNoDestruccionVO motivoNoDestruccionVo) throws ExcepcionDAO,
                                                                                                            ExcepcionAplicacion;

    /**
     * Buscar todos los Motivos de No Destrucci�n
     * @return resultado - Lista de todos los Motivos de no Destrucci�n
     * @throws ExcepcionDAO
     */

    List<MotivoNoDestruccionVO> buscarTodoMotivoNoDestruccion() throws ExcepcionDAO;
}
