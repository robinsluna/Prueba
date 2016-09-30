/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 16-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioProcSanVO;

import java.util.List;

/**
 * Interface del bean que gestiona el inventario de los procesos sancionatorios.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public interface AdminInventarioProcSan {
    /**
     * Buscar inventario del proceso sancionatorio según id.
     * @param ipsCodigo
     * @return resultado - Value object del inventario del proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    InventarioProcSanVO buscarInventarioProcSanPorId(Long ipsCodigo) throws ExcepcionDAO;
    
     /**
      * Realiza la b&uacute;squeda de los registros de Inventario del Proceso Sancionatorio por medio del c&oacute;digo del Proceso Sancionatorio.
      * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio.
      * @return Listado de relaciones de Inventario con Proceso Sancionatorio.
      * @throws ExcepcionDAO
      */
    public List<InventarioProcSanVO> buscarInventarioProcSanPorIdProceso (Long psaCodigo) throws ExcepcionDAO;
     
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioProcSanDAO#buscarInventarioProcSanPorIdProceso(java.lang.Long, boolean)
     */
    public List<InventarioProcSanVO> buscarInventarioProcSanPorIdProceso (Long psaCodigo, boolean soloActivos) throws ExcepcionDAO;
     

    /**
     * Busca todos los registros del inventario del proceso sancionatorio.
     * @return resultado - Lista del inventario del proceso sancionatorio.
     * @throws ExcepcionDAO
     */
    List<InventarioProcSanVO> buscarTodoInventarioProcSan() throws ExcepcionDAO;

    /**
     * Insertar el inventario del proceso sancionatorio.
     * @param inventarioProcSanVo
     * @return resultado - Value object del inventario del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    InventarioProcSanVO insertarInventarioProcSan(InventarioProcSanVO inventarioProcSanVo) throws ExcepcionDAO,
                                                                                                  ExcepcionAplicacion;

    /**
     * Actualizar el inventario del proceso sancionatorio.
     * @param inventarioProcSanVo
     * @return resultado - Value object del inventario del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    InventarioProcSanVO actualizarInventarioProcSan(InventarioProcSanVO inventarioProcSanVo) throws ExcepcionDAO,
                                                                                                    ExcepcionAplicacion;
    
    /**
     * Elimina un registro del Inventario del Proceso Sancionatorio.
     * @param ipsCodigo - C&oacute;digo del registro de Inventario Proceso Sancionatorio.
     * @throws ExcepcionDAO
     */
    public void eliminarInventarioProcSan (Long ipsCodigo) throws ExcepcionDAO;
}
