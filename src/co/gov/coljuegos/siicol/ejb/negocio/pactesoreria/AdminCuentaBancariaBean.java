package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaBancariaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancaria;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CuentaBancariaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminCuentaBancariaBean implements AdminCuentaBancaria {
    
    @EJB
    CuentaBancariaDAO cuentaBancariaDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminCuentaBancariaBean() {
       
    }

    public List<CuentaBancariaVO> buscarTodasCuentas(String fuenteFinanciacion) throws ExcepcionDAO {
        List<SiiCuentaBancaria> listaSiiCuentasBancarias = cuentaBancariaDao.buscarTodasLasCuentas(fuenteFinanciacion);
        List<CuentaBancariaVO> listaCuentaBancariaVo = new ArrayList();
        for (SiiCuentaBancaria unaCuenta : listaSiiCuentasBancarias){
            listaCuentaBancariaVo.add(new CuentaBancariaVO(unaCuenta));
        }
        return listaCuentaBancariaVo;    
    }
    
    public List<CuentaBancariaVO> buscarTodasCuentas() throws ExcepcionDAO {
        List<SiiCuentaBancaria> listaSiiCuentasBancarias = cuentaBancariaDao.buscarTodasLasCuentas();
        List<CuentaBancariaVO> listaCuentaBancariaVo = new ArrayList();
        for (SiiCuentaBancaria unaCuenta : listaSiiCuentasBancarias){
            listaCuentaBancariaVo.add(new CuentaBancariaVO(unaCuenta));
        }
        return listaCuentaBancariaVo;    
    }
    
    public CuentaBancariaVO buscarCuentaPorId(Long idCodigoCcuenta) throws ExcepcionDAO {
        
        SiiCuentaBancaria siiCuentaBancaria=cuentaBancariaDao.buscarCuentaPorId(idCodigoCcuenta);
        return (new  CuentaBancariaVO(siiCuentaBancaria));
        
    }
    
    public CuentaBancariaVO actualizarCuenta(CuentaBancariaVO cuentaBancariaVo) throws ExcepcionDAO{
        
        SiiCuentaBancaria siiCuentaBancaria = conversionVoEntidad.convertir(cuentaBancariaVo);
        siiCuentaBancaria = cuentaBancariaDao.actualizarCuenta(siiCuentaBancaria);
        CuentaBancariaVO retornoCuentaBancariaVO= new CuentaBancariaVO(siiCuentaBancaria);
        return retornoCuentaBancariaVO;  
    }
    
    
    public List<CuentaBancariaVO> buscarCuentasPorFuenteFinancContab(String ffcCodigo) throws ExcepcionDAO 
    {
        List<CuentaBancariaVO> resultado = null;
        List<SiiCuentaBancaria> listaSiiCuentasBancarias = cuentaBancariaDao.buscarCuentasPorFuenteFinancContab(ffcCodigo);
        if (listaSiiCuentasBancarias!=null) {
            resultado = new ArrayList<CuentaBancariaVO>();
            for (SiiCuentaBancaria siiCuentaBancaria : listaSiiCuentasBancarias){
                resultado.add(new CuentaBancariaVO(siiCuentaBancaria));
            }
        }
        return (resultado);
    }
    
    
    public List<CuentaBancariaVO> buscarCuentasPorFuenteFinancContab(String ffcCodigo, boolean soloActivas) throws ExcepcionDAO 
    {
        List<CuentaBancariaVO> resultado = null;
        List<SiiCuentaBancaria> listaSiiCuentasBancarias = cuentaBancariaDao.buscarCuentasPorFuenteFinancContab(ffcCodigo, soloActivas);
        if (listaSiiCuentasBancarias!=null) {
            resultado = new ArrayList<CuentaBancariaVO>();
            for (SiiCuentaBancaria siiCuentaBancaria : listaSiiCuentasBancarias){
                resultado.add(new CuentaBancariaVO(siiCuentaBancaria));
            }
        }
        return (resultado);
    }
}
