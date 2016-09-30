package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;

import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminCuotaOperador 
{
    public boolean operadorEnMora(Long opeCodigo) throws ExcepcionDAO;
    public CuotaOperadorVO buscarCuotaOperadorPorId(CuotaOperadorVO cuotaVo) throws ExcepcionDAO;
    public List<CuotaOperadorVO> buscarCuotaOperadorPorRifaPromocional(Long  idRifaPromocional ) throws ExcepcionDAO;
    public List<DuplaVO> buscarNumeroCuotasPorAcuerdoPago(long idAcuerdoPago) throws ExcepcionDAO;
    public CuotaOperadorVO buscarCuotaOperadorXContratoXConceptoXNumCuota(String codigoContrato, BigDecimal numeroCuota,
                                                                           BigDecimal conceptoLiq) throws ExcepcionDAO;
    public List<CuotaOperadorVO> buscarCuotaOperadorXIdLiquidacion (Long lmeCodigo) throws ExcepcionDAO;
    public List<CuotaOperadorVO> buscarCuotaOperadorXContratoXFechaXConcepto (Long conCodigo, Date fechaIni, Date fechaFin, List<String> listaLiqConceptos) throws ExcepcionDAO;
    
    public CuotaOperadorVO insertarCuotaOperador (CuotaOperadorVO cuotaOperadorVo) throws ExcepcionDAO;
    public CuotaOperadorVO insertarCuotaOperador (CuotaOperadorVO cuotaOperadorVo, boolean doCascade) throws ExcepcionDAO;
    public CuotaOperadorVO actualizarCuotaOperador (CuotaOperadorVO cuotaOperadorVo) throws ExcepcionDAO;
    public CuotaOperadorVO actualizarCuotaOperador (CuotaOperadorVO cuotaOperadorVo, boolean doCascade) throws ExcepcionDAO;
    public CuotaOperadorVO buscarCuotaOperadorXContratoXConceptoXNumCuotaXVigencia(String contrato, BigDecimal numeroCuota,
                                                                                    BigDecimal conceptoLiq, Integer vigencia) throws ExcepcionDAO;
    
    public CuotaOperadorVO buscarCuotaOperadorXContratoXOperadorXMesXConceptoXEstado(long codigoContrato, long codigoOperador, long codigoMes, String conceptoLiq, int anoVigencia, String estado) throws ExcepcionDAO;
    
    public Long buscarNumeroCuotasTemporalesPorAcuerdoPago(long idAcuerdoPago) throws ExcepcionDAO;
    public CuotaOperadorVO buscarCuotaOperadorXContratoXConceptoXMesXVigencia(Long contrato, BigDecimal conceptoLiq,
                                                                               Integer vigencia, Integer mes) throws ExcepcionDAO;
    public List<CuotaOperadorVO> buscarPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO;
}
