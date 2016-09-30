/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-01-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.CierreAnualContableVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz Local para el Cierre Anual Contable.
 * @author Camilo Miranda
 */
@Local
public interface AdminCierreAnualContable 
{
    public CierreAnualContableVO buscarCierreAnualContablePorId (Long cacCodigo) throws ExcepcionDAO;
    public CierreAnualContableVO insertarCierreAnualContable (CierreAnualContableVO cierreAnualContableVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public CierreAnualContableVO insertarCierreAnualContable (CierreAnualContableVO cierreAnualContableVo, boolean doCascade) throws ExcepcionDAO, ExcepcionAplicacion;
    public CierreAnualContableVO actualizarCierreAnualContable (CierreAnualContableVO cierreAnualContableVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public CierreAnualContableVO actualizarCierreAnualContable (CierreAnualContableVO cierreAnualContableVo, boolean doCascade) throws ExcepcionDAO, ExcepcionAplicacion;
    public void borrarCierreAnualContable (Long cacCodigo) throws ExcepcionDAO;
    public List<CierreAnualContableVO> buscarTodoCierreAnualContable () throws ExcepcionDAO;
    public List<CierreAnualContableVO> buscarPorVigencia (Integer cacVigencia) throws ExcepcionDAO;
    public List<CierreAnualContableVO> buscarCierresAprobados () throws ExcepcionDAO;
    public CierreAnualContableVO buscarPorVigenciaYEstado (Integer cacVigencia, Long ecaCodigo) throws ExcepcionDAO;
    public List<CierreAnualContableVO> buscarTodoPorVigenciaYEstado (Integer cacVigencia, Long ecaCodigo) throws ExcepcionDAO;
}
