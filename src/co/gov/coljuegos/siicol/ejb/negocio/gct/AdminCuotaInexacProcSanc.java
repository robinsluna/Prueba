/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 16-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaInexacProcSancVO;

import java.util.List;

/**
 * Interface que gestiona las cuotas inexactas del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public interface AdminCuotaInexacProcSanc {
    /**
     * Buscar cuota inexacta del proceso sancionatorio por id.
     * @param cipsCodigo
     * @return resultado - Cuota inexacta del proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    CuotaInexacProcSancVO buscarCuotaInexacProcSancPorId(Long cipsCodigo) throws ExcepcionDAO;

    /**
     * Buscar todos las cuotas inexactas del proceso sancionatorio.
     * @return resultado - Value object de las cuotas inexactas de proceso sancionatorio.
     * @throws ExcepcionDAO
     */
    List<CuotaInexacProcSancVO> buscarTodoCuotaInexacProcSanc() throws ExcepcionDAO;

    /**
     * Insertar cuota inexacta de proceso sancionatorio.
     * @param cuotaInexacProcSancVo
     * @return resultado - value object de la cuota inexacta del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    CuotaInexacProcSancVO insertarCuotaInexacProcSanc(CuotaInexacProcSancVO cuotaInexacProcSancVo) throws ExcepcionDAO,
                                                                                                          ExcepcionAplicacion;

    /**
     * Actualizar la cuota inexacta del proceso sancionatorio.
     * @param cuotaInexacProcSancVo
     * @return resultado - Value object de la cuota inexacta del proceso sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    CuotaInexacProcSancVO actualizarCuotaInexacProcSanc(CuotaInexacProcSancVO cuotaInexacProcSancVo) throws ExcepcionDAO,
                                                                                                            ExcepcionAplicacion;
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOmisProcSancDAO#buscarCuotaInexacProcSancPorIdProcesoSancionatorio(java.lang.Long)
     */
    public List<CuotaInexacProcSancVO> buscarCuotaInexacProcSancPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO;
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOmisProcSancDAO#buscarCuotaInexacProcSancPorIdProcesoSancionatorio(java.lang.Long, boolean)
     */
    public List<CuotaInexacProcSancVO> buscarCuotaInexacProcSancPorIdProcesoSancionatorio (Long psaCodigo, boolean soloActivos) throws ExcepcionDAO;
}
