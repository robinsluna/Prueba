package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CuentasContablesVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionResultVO;

import java.util.List;


public interface AdminCuentasContables {
   
    public List<ImputacionResultVO> buscarCuentasPorCodigosConceptos (List<Long> conceptos) throws ExcepcionDAO;
    public CuentasContablesVO buscarPorCodigo(Long ccoCodigo) throws ExcepcionDAO;
    public List<CuentasContablesVO> buscarCuentasContablesPadre (Long ccoCodigo) throws ExcepcionDAO;
    public List<CuentasContablesVO> buscarTodoCuentasContables () throws ExcepcionDAO;
    public List<CuentasContablesVO> buscarCuentasPorNaturalezaYDocumentoContable(String naturaleza,String docContable) throws ExcepcionDAO;
    public List<CuentasContablesVO> buscarPorRangoCuentas (String cuentaInicial, String cuentaFinal) throws ExcepcionDAO;
    public List<CuentasContablesVO> buscarCuentasPorFuenteFinancContab(String ffcCodigo) throws ExcepcionDAO;
    public List<CuentasContablesVO> buscarCuentasContablesPorCategoriaDistribucion (Long cadCodigo) throws ExcepcionDAO;
    public CuentasContablesVO insertarCuentasContables(CuentasContablesVO cuentasContablesVo) throws ExcepcionDAO;
    public CuentasContablesVO actualizarCuentasContables(CuentasContablesVO cuentasContablesVo) throws ExcepcionDAO;
    public CuentasContablesVO buscarPorCadenaNiveles (String cadenaNiveles) throws ExcepcionDAO;
    public List<CuentasContablesVO> buscarCuentasContablesAcreedoras() throws ExcepcionDAO;
}
