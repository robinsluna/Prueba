package co.gov.coljuegos.siicol.ejb.negocio.ryt;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;

import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminCuotaOperadorBean implements AdminCuotaOperador {
    @EJB 
    CuotaOperadorDAO cuotaoOperadorDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    public AdminCuotaOperadorBean() {
        
    }
    
    public boolean operadorEnMora(Long opeCodigo) throws ExcepcionDAO {
        return cuotaoOperadorDao.operadorEnMora(opeCodigo);
        
    }

    public CuotaOperadorVO buscarCuotaOperadorPorId(CuotaOperadorVO cuotaVo) throws ExcepcionDAO {
        return new CuotaOperadorVO(cuotaoOperadorDao.buscarCuotaOperadorPorId(cuotaVo));
    }
    
    public List<CuotaOperadorVO> buscarCuotaOperadorPorRifaPromocional(Long  idRifaPromocional ) throws ExcepcionDAO {
        List<CuotaOperadorVO>listaCuotaOperados = new ArrayList< CuotaOperadorVO>() ;
        List<SiiCuotaOperador>  listsiiCuotaOperador= new ArrayList< SiiCuotaOperador>() ;
        listsiiCuotaOperador= cuotaoOperadorDao.buscarCuotaOperadorPorRifaPromocional(idRifaPromocional);
       
        for (SiiCuotaOperador siiCuotaOperador: listsiiCuotaOperador) {
            CuotaOperadorVO cuotaOperadorVo= new CuotaOperadorVO(siiCuotaOperador);
            listaCuotaOperados.add(cuotaOperadorVo); 
        }
        return listaCuotaOperados;
    }
    
    public List<DuplaVO> buscarNumeroCuotasPorAcuerdoPago(long idAcuerdoPago) throws ExcepcionDAO {
        return(cuotaoOperadorDao.buscarNumeroCuotasPorAcuerdoPago(idAcuerdoPago));    
    }
    public CuotaOperadorVO buscarCuotaOperadorXContratoXConceptoXNumCuota(String codigoContrato, BigDecimal numeroCuota,
                                                                           BigDecimal conceptoLiq) throws ExcepcionDAO{
        return(new CuotaOperadorVO(cuotaoOperadorDao.buscarCuotaOperadorXContratoXConceptoXNumCuota(codigoContrato, numeroCuota, conceptoLiq)))  ;                                                                     
    }
    
    
    @Override
    public List<CuotaOperadorVO> buscarCuotaOperadorXIdLiquidacion (Long lmeCodigo) throws ExcepcionDAO {
        List<CuotaOperadorVO> resultado = null;
        List<SiiCuotaOperador>  lista = cuotaoOperadorDao.buscarCuotaOperadorXIdLiquidacion(lmeCodigo);
        if (lista!=null) {
            resultado = new ArrayList<CuotaOperadorVO>();
            
            for (SiiCuotaOperador siiCuotaOperador: lista) {
                if (siiCuotaOperador!=null) 
                    resultado.add(new CuotaOperadorVO(siiCuotaOperador)); 
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<CuotaOperadorVO> buscarCuotaOperadorXContratoXFechaXConcepto (Long conCodigo, Date fechaIni, Date fechaFin, List<String> listaLiqConceptos) throws ExcepcionDAO {
        List<CuotaOperadorVO> resultado = null;
        List<SiiCuotaOperador>  lista = cuotaoOperadorDao.buscarCuotaOperadorXContratoXFechaXConcepto(conCodigo, fechaIni, fechaFin, listaLiqConceptos);
        if (lista!=null) {
            resultado = new ArrayList<CuotaOperadorVO>();
            
            for (SiiCuotaOperador siiCuotaOperador: lista) {
                if (siiCuotaOperador!=null) 
                    resultado.add(new CuotaOperadorVO(siiCuotaOperador)); 
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public CuotaOperadorVO insertarCuotaOperador (CuotaOperadorVO cuotaOperadorVo) throws ExcepcionDAO {
        CuotaOperadorVO resultado = null;
        SiiCuotaOperador siiCuotaOperador = cuotaoOperadorDao.insertarSiiCuotaOperador(conversionVoEntidad.convertir(cuotaOperadorVo));
        if (siiCuotaOperador!=null)
            resultado = new CuotaOperadorVO(siiCuotaOperador);
        
        return (resultado);
    }
    
    @Override
    public CuotaOperadorVO actualizarCuotaOperador (CuotaOperadorVO cuotaOperadorVo) throws ExcepcionDAO {
        CuotaOperadorVO resultado = null;
        SiiCuotaOperador siiCuotaOperador = cuotaoOperadorDao.insertarSiiCuotaOperador(conversionVoEntidad.convertir(cuotaOperadorVo));
        if (siiCuotaOperador!=null)
            resultado = new CuotaOperadorVO(siiCuotaOperador);
        
        return (resultado);
    }
    
    @Override
    public CuotaOperadorVO buscarCuotaOperadorXContratoXConceptoXNumCuotaXVigencia(String contrato, BigDecimal numeroCuota,
                                                                                    BigDecimal conceptoLiq, Integer vigencia) throws ExcepcionDAO{
        return(new CuotaOperadorVO(cuotaoOperadorDao.buscarCuotaOperadorXContratoXConceptoXNumCuotaXVigencia(contrato, numeroCuota, conceptoLiq, vigencia)))  ;
    }
    
    public CuotaOperadorVO insertarCuotaOperador (CuotaOperadorVO cuotaOperadorVo, boolean doCascade) throws ExcepcionDAO{
            CuotaOperadorVO resultado = null;                       
            return (resultado);
        }
    
    public CuotaOperadorVO actualizarCuotaOperador (CuotaOperadorVO cuotaOperadorVo, boolean doCascade) throws ExcepcionDAO{
            CuotaOperadorVO resultado = null;                       
            return (resultado);
        }
   
    public Long buscarNumeroCuotasTemporalesPorAcuerdoPago(long idAcuerdoPago) throws ExcepcionDAO {
        return cuotaoOperadorDao.buscarNumeroCuotasTemporalesPorAcuerdoPago(idAcuerdoPago);
    }

    
    public CuotaOperadorVO buscarCuotaOperadorXContratoXConceptoXMesXVigencia(Long contrato, BigDecimal conceptoLiq,
                                                                               Integer vigencia, Integer mes) throws ExcepcionDAO {
        CuotaOperadorVO resultado = null;
        SiiCuotaOperador siiCuotaOperador = cuotaoOperadorDao.buscarCuotaOperadorXContratoXConceptoXMesXVigencia(contrato, conceptoLiq, vigencia, mes);
        if (siiCuotaOperador!=null)
            resultado = new CuotaOperadorVO(siiCuotaOperador);
        
        return (resultado);
    }
    
    
    @Override
    public CuotaOperadorVO buscarCuotaOperadorXContratoXOperadorXMesXConceptoXEstado(long codigoContrato, long codigoOperador,
                                                                                     long codigoMes, String conceptoLiq,
                                                                                     int anoVigencia, String estado) 
        throws ExcepcionDAO 
    {
        CuotaOperadorVO resultado = null;
        SiiCuotaOperador siiCuotaOperador = cuotaoOperadorDao.buscarCuotaOperadorXContratoXOperadorXMesXConceptoXEstado(codigoContrato, codigoOperador, codigoMes, conceptoLiq, anoVigencia, estado);
        if (siiCuotaOperador!=null)
            resultado = new CuotaOperadorVO(siiCuotaOperador);
        
        return (resultado);
    }
    
    
    @Override
    public List<CuotaOperadorVO> buscarPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO {
        List<CuotaOperadorVO> resultado = null;
        List<SiiCuotaOperador>  lista = cuotaoOperadorDao.buscarPorIdProcesoSancionatorio(psaCodigo);
        if (lista!=null) {
            resultado = new ArrayList<CuotaOperadorVO>();
            
            for (SiiCuotaOperador siiCuotaOperador: lista) {
                if (siiCuotaOperador!=null) 
                    resultado.add(new CuotaOperadorVO(siiCuotaOperador)); 
            }
        }
        
        return (resultado);
    }
}
