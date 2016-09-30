package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CuentaBancariaVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminCuentaBancaria {
    public List<CuentaBancariaVO> buscarTodasCuentas (String fuenteFinanciacion) throws ExcepcionDAO;
    public List<CuentaBancariaVO> buscarTodasCuentas () throws ExcepcionDAO;
    public CuentaBancariaVO buscarCuentaPorId(Long idCodigoCcuenta) throws ExcepcionDAO ;
    public CuentaBancariaVO actualizarCuenta(CuentaBancariaVO cuentaBancariaVo) throws ExcepcionDAO;
    public List<CuentaBancariaVO> buscarCuentasPorFuenteFinancContab (String ffcCodigo) throws ExcepcionDAO;
    public List<CuentaBancariaVO> buscarCuentasPorFuenteFinancContab (String ffcCodigo, boolean soloActivas) throws ExcepcionDAO;
}
