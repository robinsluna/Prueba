/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 16-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOmisProcSancVO;

import java.util.List;

/**
 * Interface del bean que gestiona las cuotas de omisión del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public interface AdminCuotaOmisProcSanc {
    /**
     * Buscar cuotas de omisión del proceso sancionatorio según id
     * @param cosCodigo
     * @return resultado - Value object de la cuota de omisión del proceso sancionatorio.
     * @throws ExcepcionDAO
     */

    CuotaOmisProcSancVO buscarCuotaOmisProcSancPorId(Long cosCodigo) throws ExcepcionDAO;

    /**
     * Buscar todas las cuotas de omisión del proceso sancionatorio.
     * @return resultado - Lista de cuotas de omisión del proceso sancionatorio.
     * @throws ExcepcionDAO
     */
    List<CuotaOmisProcSancVO> buscarTodoCuotaOmisProcSanc() throws ExcepcionDAO;

    /**
     * Insertar la cuota de omisión del proceso sancionatorio.
     * @param cuotaOmisProcSancVo
     * @return resultado - Value Object
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    CuotaOmisProcSancVO insertarCuotaOmisProcSanc(CuotaOmisProcSancVO cuotaOmisProcSancVo) throws ExcepcionDAO,
                                                                                                  ExcepcionAplicacion;

    /**
     * Actualizar la cuota de omisión del proceso sancionatorio.
     * @param cuotaOmisProcSancVo
     * @return resultado - Value object
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    CuotaOmisProcSancVO actualizarCuotaOmisProcSanc(CuotaOmisProcSancVO cuotaOmisProcSancVo) throws ExcepcionDAO,
                                                                                                    ExcepcionAplicacion;
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaInexacProcSancDAO#buscarCuotaOmisProcSancPorIdProcesoSancionatorio(java.lang.Long)
     */
    public List<CuotaOmisProcSancVO> buscarCuotaOmisProcSancPorIdProcesoSancionatorio(Long psaCodigo) throws ExcepcionDAO;
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaInexacProcSancDAO#buscarCuotaOmisProcSancPorIdProcesoSancionatorio(java.lang.Long, boolean)
     */
    public List<CuotaOmisProcSancVO> buscarCuotaOmisProcSancPorIdProcesoSancionatorio(Long psaCodigo, boolean soloActivos) throws ExcepcionDAO;
}
