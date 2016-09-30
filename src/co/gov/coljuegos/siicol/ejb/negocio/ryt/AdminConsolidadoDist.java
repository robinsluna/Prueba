/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Camilo Miranda
 * FECHA	: 21-05-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ConsolidadoDistVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Consolidados de Distribuci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminConsolidadoDist 
{
    public ConsolidadoDistVO buscarPorCodigoConsolidadoDist(Long codCodigo) throws ExcepcionDAO;
    public ConsolidadoDistVO insertarConsolidadoDist (ConsolidadoDistVO consolidadoDistVo) throws ExcepcionDAO;
    public List<ConsolidadoDistVO> buscarPorCodigoDistribucionMes (Long dmeCodigo) throws ExcepcionDAO;
}
