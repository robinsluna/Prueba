/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DescargoProcSanVO;

import java.util.List;

/**
 * Interface de descargo de proceso sancionatorio
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public interface AdminDescargoProcSan {
    /**
     * Buscar descargo proceso sancionatorio por id.
     * @param dpsCodigo
     * @return resultado - Descargo del proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    DescargoProcSanVO buscarDescargoProcSanPorId(Long dpsCodigo) throws ExcepcionDAO;

    /**
     * Buscar todos los descargos de proceso sancionatorio.
     * @return resultado - Value object de descargo de proceso sancionatorio.
     * @throws ExcepcionDAO
     */
    List<DescargoProcSanVO> buscarTodoDescargoProcSan() throws ExcepcionDAO;

    /**
     * Insertar el descargo de proceso sancionatorio.
     * @param descargoProcSanVo
     * @return resultado - Value Object Descargo proceso sancionatorio
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    DescargoProcSanVO insertarDescargoProcSan(DescargoProcSanVO descargoProcSanVo) throws ExcepcionDAO,
                                                                                          ExcepcionAplicacion;

    /**
     * Actualizar el descargo del proceso sancionatorio.
     * @param descargoProcSanVo
     * @return resultado - Value object del descargo del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    DescargoProcSanVO actualizarDescargoProcSan(DescargoProcSanVO descargoProcSanVo) throws ExcepcionDAO,
                                                                                            ExcepcionAplicacion;
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.DescargoProcSanDAO#buscarDescargoProcSanPorIdProcesoSancionatorio(java.lang.Long)
     */
    public List<DescargoProcSanVO> buscarDescargoProcSanPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO;
}
