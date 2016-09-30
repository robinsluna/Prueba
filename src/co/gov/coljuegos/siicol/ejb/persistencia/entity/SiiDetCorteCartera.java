package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_DET_CORTE_CARTERA")
public class SiiDetCorteCartera implements Serializable {
    private static final long serialVersionUID = 4121797340574396242L;
    private Long ccuCodigo;
    private Long dccCodigo;
    private String dccContrato;
    private Integer dccDiasMora;
    private Date dccFechaFinContrato;
    private Date dccFechaIniContrato;
    private Date dccFechaLimitePago;
    private Date dccFechaPago;
    private BigDecimal dccInteresPagado;
    private String dccNit;
    private Integer dccNumeroCuota;
    private String dccRazonSocial;
    private BigDecimal dccSaldoCuota;
    private BigDecimal dccSaldoInteres;
    private String dccTipo;
    private BigDecimal dccTotalInteres;
    private BigDecimal dccTotalInteres1;
    private BigDecimal dccValorCuota;
    private BigDecimal dccValorPagado;
    private Integer dccVigencia;
    private SiiCorteCartera siiCorteCartera;
    private SiiMes siiMes;

    public SiiDetCorteCartera() {
    }

    public SiiDetCorteCartera(SiiCorteCartera siiCorteCartera, Long ccuCodigo, Long dccCodigo, String dccContrato,
                              Integer dccDiasMora, Date dccFechaFinContrato, Date dccFechaIniContrato,
                              Date dccFechaLimitePago, Date dccFechaPago, BigDecimal dccInteresPagado, String dccNit,
                              Integer dccNumeroCuota, String dccRazonSocial, BigDecimal dccSaldoCuota,
                              BigDecimal dccSaldoInteres, String dccTipo, BigDecimal dccTotalInteres,
                              BigDecimal dccTotalInteres1, BigDecimal dccValorCuota, BigDecimal dccValorPagado,
                              Integer dccVigencia, SiiMes siiMes) {
        this.siiCorteCartera = siiCorteCartera;
        this.ccuCodigo = ccuCodigo;
        this.dccCodigo = dccCodigo;
        this.dccContrato = dccContrato;
        this.dccDiasMora = dccDiasMora;
        this.dccFechaFinContrato = dccFechaFinContrato;
        this.dccFechaIniContrato = dccFechaIniContrato;
        this.dccFechaLimitePago = dccFechaLimitePago;
        this.dccFechaPago = dccFechaPago;
        this.dccInteresPagado = dccInteresPagado;
        this.dccNit = dccNit;
        this.dccNumeroCuota = dccNumeroCuota;
        this.dccRazonSocial = dccRazonSocial;
        this.dccSaldoCuota = dccSaldoCuota;
        this.dccSaldoInteres = dccSaldoInteres;
        this.dccTipo = dccTipo;
        this.dccTotalInteres = dccTotalInteres;
        this.dccTotalInteres1 = dccTotalInteres1;
        this.dccValorCuota = dccValorCuota;
        this.dccValorPagado = dccValorPagado;
        this.dccVigencia = dccVigencia;
        this.siiMes = siiMes;
    }


    @Column(name = "CCU_CODIGO", nullable = false)
    public Long getCcuCodigo() {
        return ccuCodigo;
    }

    public void setCcuCodigo(Long ccuCodigo) {
        this.ccuCodigo = ccuCodigo;
    }

    @Id
    @Column(name = "DCC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DET_CORTE_CARTERA_COD")
    @SequenceGenerator(name = "SEQ_DET_CORTE_CARTERA_COD", sequenceName = "SEQ_DET_CORTE_CARTERA_COD",allocationSize=1)
    public Long getDccCodigo() {
        return dccCodigo;
    }

    public void setDccCodigo(Long dccCodigo) {
        this.dccCodigo = dccCodigo;
    }

    @Column(name = "DCC_CONTRATO", nullable = false, length = 100)
    public String getDccContrato() {
        return dccContrato;
    }

    public void setDccContrato(String dccContrato) {
        this.dccContrato = dccContrato;
    }

    @Column(name = "DCC_DIAS_MORA")
    public Integer getDccDiasMora() {
        return dccDiasMora;
    }

    public void setDccDiasMora(Integer dccDiasMora) {
        this.dccDiasMora = dccDiasMora;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DCC_FECHA_FIN_CONTRATO", nullable = false)
    public Date getDccFechaFinContrato() {
        return dccFechaFinContrato;
    }

    public void setDccFechaFinContrato(Date dccFechaFinContrato) {
        this.dccFechaFinContrato = dccFechaFinContrato;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DCC_FECHA_INI_CONTRATO", nullable = false)
    public Date getDccFechaIniContrato() {
        return dccFechaIniContrato;
    }

    public void setDccFechaIniContrato(Date dccFechaIniContrato) {
        this.dccFechaIniContrato = dccFechaIniContrato;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DCC_FECHA_LIMITE_PAGO", nullable = false)
    public Date getDccFechaLimitePago() {
        return dccFechaLimitePago;
    }

    public void setDccFechaLimitePago(Date dccFechaLimitePago) {
        this.dccFechaLimitePago = dccFechaLimitePago;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DCC_FECHA_PAGO")
    public Date getDccFechaPago() {
        return dccFechaPago;
    }

    public void setDccFechaPago(Date dccFechaPago) {
        this.dccFechaPago = dccFechaPago;
    }

    @Column(name = "DCC_INTERES_PAGADO")
    public BigDecimal getDccInteresPagado() {
        return dccInteresPagado;
    }

    public void setDccInteresPagado(BigDecimal dccInteresPagado) {
        this.dccInteresPagado = dccInteresPagado;
    }

    @Column(name = "DCC_NIT", nullable = false, length = 20)
    public String getDccNit() {
        return dccNit;
    }

    public void setDccNit(String dccNit) {
        this.dccNit = dccNit;
    }

    @Column(name = "DCC_NUMERO_CUOTA", nullable = false)
    public Integer getDccNumeroCuota() {
        return dccNumeroCuota;
    }

    public void setDccNumeroCuota(Integer dccNumeroCuota) {
        this.dccNumeroCuota = dccNumeroCuota;
    }

    @Column(name = "DCC_RAZON_SOCIAL", length = 100)
    public String getDccRazonSocial() {
        return dccRazonSocial;
    }

    public void setDccRazonSocial(String dccRazonSocial) {
        this.dccRazonSocial = dccRazonSocial;
    }

    @Column(name = "DCC_SALDO_CUOTA")
    public BigDecimal getDccSaldoCuota() {
        return dccSaldoCuota;
    }

    public void setDccSaldoCuota(BigDecimal dccSaldoCuota) {
        this.dccSaldoCuota = dccSaldoCuota;
    }

    @Column(name = "DCC_SALDO_INTERES")
    public BigDecimal getDccSaldoInteres() {
        return dccSaldoInteres;
    }

    public void setDccSaldoInteres(BigDecimal dccSaldoInteres) {
        this.dccSaldoInteres = dccSaldoInteres;
    }

    @Column(name = "DCC_TIPO", length = 100)
    public String getDccTipo() {
        return dccTipo;
    }

    public void setDccTipo(String dccTipo) {
        this.dccTipo = dccTipo;
    }

    @Column(name = "DCC_TOTAL_INTERES")
    public BigDecimal getDccTotalInteres() {
        return dccTotalInteres;
    }

    public void setDccTotalInteres(BigDecimal dccTotalInteres) {
        this.dccTotalInteres = dccTotalInteres;
    }

    @Column(name = "DCC_TOTAL_INTERES_1")
    public BigDecimal getDccTotalInteres1() {
        return dccTotalInteres1;
    }

    public void setDccTotalInteres1(BigDecimal dccTotalInteres1) {
        this.dccTotalInteres1 = dccTotalInteres1;
    }

    @Column(name = "DCC_VALOR_CUOTA")
    public BigDecimal getDccValorCuota() {
        return dccValorCuota;
    }

    public void setDccValorCuota(BigDecimal dccValorCuota) {
        this.dccValorCuota = dccValorCuota;
    }

    @Column(name = "DCC_VALOR_PAGADO")
    public BigDecimal getDccValorPagado() {
        return dccValorPagado;
    }

    public void setDccValorPagado(BigDecimal dccValorPagado) {
        this.dccValorPagado = dccValorPagado;
    }

    @Column(name = "DCC_VIGENCIA", nullable = false)
    public Integer getDccVigencia() {
        return dccVigencia;
    }

    public void setDccVigencia(Integer dccVigencia) {
        this.dccVigencia = dccVigencia;
    }


    @ManyToOne
    @JoinColumn(name = "CCA_CODIGO")
    public SiiCorteCartera getSiiCorteCartera() {
        return siiCorteCartera;
    }

    public void setSiiCorteCartera(SiiCorteCartera siiCorteCartera) {
        this.siiCorteCartera = siiCorteCartera;
    }

    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }
}
