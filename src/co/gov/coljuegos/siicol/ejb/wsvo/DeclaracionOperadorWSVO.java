package co.gov.coljuegos.siicol.ejb.wsvo;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class DeclaracionOperadorWSVO {

    //Datos basicos del operador
    public String perJurNombreLargo;
    public String perNumIdentificacion;
    public String perTelefono;
    public String perDepartamento;
    public String perCiudad;
    public String perDireccion;
    public String perEmail;
    public Long opeCodigo;
    public String representanteLegal;
    public String representanteLegalIdentificacion;
    public String revisorFiscal;
    public String numeroContrato;
    public Long conCodigo;
    public Date fechaSubscripcion;
    public Date fechaInicioContrato;
    public String tipoIdentificacionEmpresa;


    //Periodo declarecion y liquidacion
    public Integer anoOperacion;
    public String mesOperacion;
    public Integer mesCodigo;
    public Integer numeroCuota;
    public Long codigoCuota;
    public Date pagoOportunoHasta;
    public Integer numeroDeclaracion;
    public Date fechaDeclaracion;
    public Integer numeroTotalElementos;
    
    public Long codigoCuotaModificada;
    public String estadoCuota;
    public String estadoCuotaModificada;

    //Valores calculados
    public BigDecimal totalLiquidacionDE;
    public BigDecimal derechosDeExplotacion;
    public BigDecimal gastosAdministracion;
    public BigDecimal interesesMoraDE;
    public BigDecimal interesesMoraGA;
    public BigDecimal valorTotalPagar;
    public BigDecimal totalVentas;
    public BigDecimal ingresosBrutos;
    //Nuevas variables por ventas MET
    public String tipoReporte;
    public BigDecimal modificacionDE;
    public BigDecimal modificacionGA;
    public BigDecimal interesesModificacionDE;
    public BigDecimal interesesModificacionGA;
    public BigDecimal totalLiquidacionModificacionDE;
    //Cupones de pago
    public Long referenciaPagoDE;
    public Long referenciaPagoGA;
    public BigDecimal totalPagarDE;
    public BigDecimal totalPagarGA;

    //Cupones de pago Modificada
    public Long referenciaPagoModificadaDE;
    public Long referenciaPagoModificadaGA;
    public BigDecimal totalPagarModificadaDE;
    public BigDecimal totalPagarModificadaGA;
    
    //Listas
    public List<EstablecimientoWSVO> listaEstablecimientosWSVO;
    public List<ElementoAsociadoWSVO> listaElementosAsociadosWSVO;
    public List<VentasMetCuotaWSVO> listaVentasMetCuotaWSVO;
    public List<VentasMetCuotaWSVO> listaModificacionVentasMetCuotaWSVO;

    //Id de la declaracion sugerida
    public long idDeclaracionSugerida;
    
    //Id de la declaracion modificada
    public long idDeclaracionModificada;
    
    public BigDecimal tarifaFija;
    public BigDecimal tarifaVariable;
    public Long totalElementosTarifaFija;
    public Long totalElementosTarifaVariable;
    
    
    public BigDecimal tarifaVariableModificada;
    
    public Long totalElementosTarifaVariableModificada;
    
    public DeclaracionOperadorWSVO() {

    }
}
