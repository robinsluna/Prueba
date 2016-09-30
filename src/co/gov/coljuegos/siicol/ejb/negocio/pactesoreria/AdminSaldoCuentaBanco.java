package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.SaldoCuentaBancoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminSaldoCuentaBanco {
    public List<SaldoCuentaBancoVO> buscarTodoSaldoCtaBanco() throws ExcepcionDAO ;
    public SaldoCuentaBancoVO buscarSaldoCtaBancoPorId(SaldoCuentaBancoVO saldoCuentaBancoVo) throws ExcepcionDAO;
    public SaldoCuentaBancoVO actualizarSaldoCtaBanco(SaldoCuentaBancoVO saldoCuentaBancoVo) throws ExcepcionDAO;
    public SaldoCuentaBancoVO insertarSaldoCtaBanco(SaldoCuentaBancoVO saldoCuentaBancoVo) throws ExcepcionDAO ;
    public SaldoCuentaBancoVO buscarCtaBancoXIdCuentaBanActivo(Long idCuentaBan) throws ExcepcionDAO ;
    
}
