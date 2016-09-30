package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResumenNoConectado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;
import co.gov.coljuegos.siicol.ejb.vo.InteresCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionMesVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.RepLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteVentasVO;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminLiquidacionMes {
    public String ejecutarLiquidacionMensualOperadores(String tipoReporteVtas,Integer vigencia, Integer mesALiquidar, String contrato, String nit ) throws ExcepcionDAO;
    public List<LiquidacionMesVO> obtenerLiquidacionPorContratoYConceptos(Long idCodigoContrato,Date fechaInicio, Date fechaFin ) throws ExcepcionDAO;
    //public int obtenerDiasHabiles(Calendar fechaInicial, Calendar fechaFinal);
    public List<ContratoVO> buscarContratosPorEstadoEjecucion(String unEstado) throws ExcepcionDAO;
    public Long buscarSmmlvPorVigencia(int vigencia)  throws ExcepcionDAO;
    public List<InteresCuotaVO> ejecutarInteresMensual(Date fechaActual) throws ExcepcionDAO,ExcepcionAplicacion ;
   // public void ejecutarInteresMensualAutomatico();
    public Date buscarSiiFestivo(Date pFecha ) throws ExcepcionDAO;
    public Date  obtenerDiasHabiles(Calendar fechaInicial, Calendar fechaFinal) ;
    public List<RepLiquidacionVO> obtenerInventarioLiquidadoPorMesYVigencia(Integer vigencia, Integer mes, String contrato) throws ExcepcionDAO;
    public ReporteVentasVO buscarReporteVentasPorMesYVigencia(Integer mes, Integer vigencia) throws ExcepcionDAO;
    public DuplaVO calcularDiasALiquidar( Integer vigencia, Integer mesALiquidar, Date fechaInicioOperacion, Date fechaFinOperacion,
                                             Date fechaInicioContrato,Date fechaFinContrato);
public void insertarLiquidacionEstablecimiento(List<SiiLiquidacionEstabl> listaLiqEstabDE);
    public void insertarMovimientosContables(String tipoDocumentoContable,Date fechaActual,Long consecutivoCuota,
                                             String numContrato,BigDecimal totalDE, BigDecimal totalGA, Long codOperador,
                                             SiiLiquidacionMes liquidacionDe,SiiLiquidacionMes liquidacionGa );
											
public SiiCuotaOperador insertarCuotaOperador(SiiLiquidacionMes resultadoSiiLiquida,Date fechaPago,int numCuota,
                                      BigDecimal valor, int vigencia, int mesALiquidar, String concepto,
                                      Long codOperador, SiiReporteVentas reporteVtas, String estado);
									  
public void insertarCuotaOperadorMod(Date fechaPago,int numCuota,
                                      BigDecimal valor, int vigencia, int mesALiquidar, String concepto,
                                      Long codOperador, SiiReporteVentas reporteVtas);

public SiiCuotaOperador crearCuotaOperador(SiiLiquidacionMes resultadoSiiLiquida,Date fechaPago,int numCuota,
                                      BigDecimal valor, int vigencia, int mesALiquidar, String concepto,
                                      Long codOperador);

public BigDecimal calcularDEMetsOnLine(Long idMet,int mesALiquidar, int vigencia, SiiReporteVentas reporteVtasVo, SiiReporteVentas  reporteVtasSugerida) throws ExcepcionDAO;

public List<SiiLiquidacionEstabl> calcularDEPorEstablecimiento(ContratoVO miContrato,  Integer vigencia, 
                                                                       Integer mesALiquidar, BigDecimal total,SiiReporteVentas reporteVtasVo,
                                                                       SiiLiquidacionMes siiLiquidaDE, SiiLiquidacionMes siiLiquidaGA) throws ExcepcionDAO;																	   
public BigDecimal calcularNumeroDiasLiquidar(Date fechaInicioOperacion, Date fechaFinOperacion, Calendar fechaIniComparar,Calendar fechaFinComparar );


public LiquidacionVO ejecutarLiquidacionSugerida(ContratoVO miContrato,BigDecimal valorSmmlv, int vigencia, 
                                            int mesALiquidar, Date fechaPagoOportuno, SiiReporteVentas reporteVtasVo,Long consecutivoCuota, SiiReporteVentas reporteVtasSugerida)throws ExcepcionDAO;
											
public List<SiiResumenNoConectado> construirNoConectadas(Integer numElementosApuesta1,BigDecimal deTipoApuesta1,BigDecimal tarifaTipoA1, SiiTipoApuesta siiTipoApuesta1,
                                                             Integer numElementosApuesta2,BigDecimal deTipoApuesta2,BigDecimal tarifaTipoA2, SiiTipoApuesta siiTipoApuesta2,
                                                             Integer numElementosApuesta3,BigDecimal deTipoApuesta3,BigDecimal tarifaTipoA3, SiiTipoApuesta siiTipoApuesta3,
                                                             Integer numElementosApuesta4,BigDecimal deTipoApuesta4,BigDecimal tarifaTipoA4, SiiTipoApuesta siiTipoApuesta4,
                                                             Integer numElementosApuesta5,BigDecimal deTipoApuesta5,BigDecimal tarifaTipoA5, SiiTipoApuesta siiTipoApuesta5,
                                                             Integer numElementosApuesta6,BigDecimal deTipoApuesta6,BigDecimal tarifaTipoA6, SiiTipoApuesta siiTipoApuesta6,
                                                             Integer numElementosApuesta7,BigDecimal deTipoApuesta7,BigDecimal tarifaTipoA7, SiiTipoApuesta siiTipoApuesta7,
                                                             Integer numElementosApuesta8,BigDecimal deTipoApuesta8,BigDecimal tarifaTipoA8, SiiTipoApuesta siiTipoApuesta8,
                                                             Integer numElementosApuesta9,BigDecimal deTipoApuesta9,BigDecimal tarifaTipoA9, SiiTipoApuesta siiTipoApuesta9,
                                                             Integer numElementosApuesta10,BigDecimal deTipoApuesta10,BigDecimal tarifaTipoA10, SiiTipoApuesta siiTipoApuesta10,
                                                             Integer numElementosApuesta11,BigDecimal deTipoApuesta11,BigDecimal tarifaTipoA11, SiiTipoApuesta siiTipoApuesta11,
                                                             Integer numElementosApuesta12,BigDecimal deTipoApuesta12,BigDecimal tarifaTipoA12, SiiTipoApuesta siiTipoApuesta12,
                                                             Integer numElementosApuesta13,BigDecimal deTipoApuesta13,BigDecimal tarifaTipoA13, SiiTipoApuesta siiTipoApuesta13);

public List<SiiLiquidacionMes> guardarLiquidacion (LiquidacionVO liquidacion , BigDecimal totalDE, BigDecimal tarifaGA, 
						ContratoVO miContrato,int vigencia, int mesALiquidar, SiiReporteVentas reporteVtas) throws ExcepcionDAO;

public void guardarLiquidacionEstablecimiento(ContratoVO miContrato, SiiLiquidacionMes siiLiquidaDE, 
                                                  SiiLiquidacionMes siiLiquidaGA, BigDecimal totalDE, int vigencia, 
                                                  int mesALiquidar,SiiReporteVentas reporteVtas,BigDecimal totalGA);

public SiiInteresCuota calcularInteresCuota (SiiCuotaOperador resultadoSiiCuotaOperador, BigDecimal totalDE, Date fechaActual, 
                                                 long diasAno, Integer diasMora, String concepto);

												 
 public void ejecutarLiquidacionXEstablecimiento(  int vigencia, int mesALiquidar, String tipoReporteVtas) throws ExcepcionDAO, ExcepcionAplicacion;									  
 
public DuplaVO calcularDEMetsOnLineModificada(Long idMet,int mesALiquidar, int vigencia, SiiReporteVentas reporteVtasVo, SiiReporteVentas reporteVtasSugerida  ) throws ExcepcionDAO;
    
public LiquidacionMesVO buscarUltimaLiquidacion() throws ExcepcionDAO;

public void ejecutarLiquidacionMesPorContrato(ContratoVO miContrato, int vigencia, int mesALiquidar, Long consecutivoCuota);

public SiiInteresCuota calcularInteresModificada(Date fechaPagoOportuno, BigDecimal saldoConcepto, SiiCuotaOperador siiCuotaOperador);
									  
	
	
}
