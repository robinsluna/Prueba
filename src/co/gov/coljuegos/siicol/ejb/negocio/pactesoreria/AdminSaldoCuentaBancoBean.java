package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaBancariaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SaldoCtaBancoDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancaria;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcedenciaPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSaldoCtaBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSoporte;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CuentaBancariaVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.MesVO;

import co.gov.coljuegos.siicol.ejb.vo.ProcedenciaPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.SaldoCuentaBancoVO;

import co.gov.coljuegos.siicol.ejb.vo.TipoDocSoporteVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminSaldoCuentaBancoBean implements AdminSaldoCuentaBanco{
    
    @Resource
    SessionContext sessionContext;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    SaldoCtaBancoDAO saldoCtaBancoDao;
    @EJB
    CuentaBancariaDAO cuentaBancariaDao;
    
    
    public AdminSaldoCuentaBancoBean() {
       
    }
    
    public List<SaldoCuentaBancoVO> buscarTodoSaldoCtaBanco() throws ExcepcionDAO {
        List<SiiSaldoCtaBanco> listaSiiSaldoCtaBanco = saldoCtaBancoDao.buscarTodoSaldoCtaBanco();
        List<SaldoCuentaBancoVO> listaSaldoCuentaBancoVo = new ArrayList();
        for(SiiSaldoCtaBanco unSiiSaldoCtaBanco: listaSiiSaldoCtaBanco){
                SaldoCuentaBancoVO nuevoSaldoCuentaBancoVO= new SaldoCuentaBancoVO(unSiiSaldoCtaBanco);
                if(nuevoSaldoCuentaBancoVO.getScbEstado().equals("B"))
                    nuevoSaldoCuentaBancoVO.setScbEstado("BORRADOR");
                if(nuevoSaldoCuentaBancoVO.getScbEstado().equals("A"))
                    nuevoSaldoCuentaBancoVO.setScbEstado("ACTIVO");
                listaSaldoCuentaBancoVo.add(nuevoSaldoCuentaBancoVO);
        }
        return listaSaldoCuentaBancoVo;        
    }
    
    public SaldoCuentaBancoVO insertarSaldoCtaBanco(SaldoCuentaBancoVO saldoCuentaBancoVo) throws ExcepcionDAO {
        SiiSaldoCtaBanco siiSaldoCtaBanco = conversionVoEntidad.convertir(saldoCuentaBancoVo);
        SiiSaldoCtaBanco resultadoSiiSaldoCtaBanco = saldoCtaBancoDao.insertarSaldoCtaBanco(siiSaldoCtaBanco);
        
        // actualizar cuenta bancaria 
        SiiCuentaBancaria siiCuentaBancaria =cuentaBancariaDao.buscarCuentaPorId(resultadoSiiSaldoCtaBanco.getSiiCuentaBancaria().getCbaCodigo());
        siiCuentaBancaria.setCboAplicaGmf(saldoCuentaBancoVo.getCuentaBancariaVo().getCbaAplicaGmf());
        siiCuentaBancaria.setCbaComentario(saldoCuentaBancoVo.getCuentaBancariaVo().getCbaComentario());
        cuentaBancariaDao.actualizarCuenta(siiCuentaBancaria);
                
        return new SaldoCuentaBancoVO(resultadoSiiSaldoCtaBanco);
    }
    
    public SaldoCuentaBancoVO buscarSaldoCtaBancoPorId(SaldoCuentaBancoVO saldoCuentaBancoVo) throws ExcepcionDAO{
            SiiSaldoCtaBanco siiSaldoCtaBanco=saldoCtaBancoDao.buscarSaldoCtaBancoPorId(saldoCuentaBancoVo.getScbCodigo());
            return (new  SaldoCuentaBancoVO(siiSaldoCtaBanco));
        }
        
     public SaldoCuentaBancoVO actualizarSaldoCtaBanco(SaldoCuentaBancoVO saldoCuentaBancoVo) throws ExcepcionDAO{
    
        SiiSaldoCtaBanco siiSaldoCtaBanco = conversionVoEntidad.convertir(saldoCuentaBancoVo);
        siiSaldoCtaBanco = saldoCtaBancoDao.actualizarSaldoCtaBanco(siiSaldoCtaBanco);
        SaldoCuentaBancoVO retornoSaldoCuentaBancoVo = new SaldoCuentaBancoVO(siiSaldoCtaBanco);
        
         // actualizar cuenta bancaria 
         SiiCuentaBancaria siiCuentaBancaria =cuentaBancariaDao.buscarCuentaPorId(siiSaldoCtaBanco.getSiiCuentaBancaria().getCbaCodigo());
         siiCuentaBancaria.setCboAplicaGmf(saldoCuentaBancoVo.getCuentaBancariaVo().getCbaAplicaGmf());
         siiCuentaBancaria.setCbaComentario(saldoCuentaBancoVo.getCuentaBancariaVo().getCbaComentario());
         cuentaBancariaDao.actualizarCuenta(siiCuentaBancaria);
        
        return retornoSaldoCuentaBancoVo;  
    
     }
     
    public SaldoCuentaBancoVO buscarCtaBancoXIdCuentaBanActivo(Long idCuentaBan) throws ExcepcionDAO {
        SiiSaldoCtaBanco siiSaldoCtaBanco=saldoCtaBancoDao.buscarCtaBancoXIdCuentaBanActivo(idCuentaBan);
        return (new  SaldoCuentaBancoVO(siiSaldoCtaBanco));
    }
   
    
    
    
}
