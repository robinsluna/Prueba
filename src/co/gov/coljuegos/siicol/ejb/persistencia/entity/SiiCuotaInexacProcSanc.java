package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CUOTA_INEXAC_PROC_SANC")
public class SiiCuotaInexacProcSanc implements Serializable {
    private static final long serialVersionUID = 1917682866952421814L;
    private Long cipCodigo;
    private BigDecimal cipDiferenciaDe;
    private BigDecimal cipDiferenciaGa;
    private BigDecimal cipLiquidRevisDe;
    private BigDecimal cipLiquidRevisGa;
    private BigDecimal cipValorSancion;
    private SiiProcesoSancionatorio siiProcesoSancionatorio;
    private SiiCuotaOperador siiCuotaOperador;
    private SiiCuotaOperador siiCuotaOperadorGA;
    private String cipActivo;

    public SiiCuotaInexacProcSanc() {
    }

    public SiiCuotaInexacProcSanc(Long cipCodigo, BigDecimal cipDiferenciaDe, BigDecimal cipDiferenciaGa, BigDecimal cipLiquidRevisDe, BigDecimal cipLiquidRevisGa, BigDecimal cipValorSancion,
                                  SiiCuotaOperador siiCuotaOperador, SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.cipCodigo = cipCodigo;
        this.cipDiferenciaDe = cipDiferenciaDe;
        this.cipDiferenciaGa = cipDiferenciaGa;
        this.cipLiquidRevisDe = cipLiquidRevisDe;
        this.cipLiquidRevisGa = cipLiquidRevisGa;
        this.cipValorSancion = cipValorSancion;
        this.siiCuotaOperador = siiCuotaOperador;
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }

    @Id
    @Column(name = "CIP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUOT_INEX_PROC_SANC_COD")
    @SequenceGenerator(name = "SEQ_CUOT_INEX_PROC_SANC_COD", sequenceName = "SEQ_CUOT_INEX_PROC_SANC_COD",allocationSize=1)
    public Long getCipCodigo() {
        return cipCodigo;
    }

    public void setCipCodigo(Long cipCodigo) {
        this.cipCodigo = cipCodigo;
    }

    @Column(name = "CIP_DIFERENCIA_DE")
    public BigDecimal getCipDiferenciaDe() {
        return cipDiferenciaDe;
    }

    public void setCipDiferenciaDe(BigDecimal cipDiferenciaDe) {
        this.cipDiferenciaDe = cipDiferenciaDe;
    }

    @Column(name = "CIP_DIFERENCIA_GA")
    public BigDecimal getCipDiferenciaGa() {
        return cipDiferenciaGa;
    }

    public void setCipDiferenciaGa(BigDecimal cipDiferenciaGa) {
        this.cipDiferenciaGa = cipDiferenciaGa;
    }

    @Column(name = "CIP_LIQUID_REVIS_DE")
    public BigDecimal getCipLiquidRevisDe() {
        return cipLiquidRevisDe;
    }

    public void setCipLiquidRevisDe(BigDecimal cipLiquidRevisDe) {
        this.cipLiquidRevisDe = cipLiquidRevisDe;
    }

    @Column(name = "CIP_LIQUID_REVIS_GA")
    public BigDecimal getCipLiquidRevisGa() {
        return cipLiquidRevisGa;
    }

    public void setCipLiquidRevisGa(BigDecimal cipLiquidRevisGa) {
        this.cipLiquidRevisGa = cipLiquidRevisGa;
    }

    @Column(name = "CIP_VALOR_SANCION", nullable = false)
    public BigDecimal getCipValorSancion() {
        return cipValorSancion;
    }

    public void setCipValorSancion(BigDecimal cipValorSancion) {
        this.cipValorSancion = cipValorSancion;
    }


    @ManyToOne
    @JoinColumn(name = "PSA_CODIGO")
    public SiiProcesoSancionatorio getSiiProcesoSancionatorio() {
        return siiProcesoSancionatorio;
    }

    public void setSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }

    @ManyToOne
    @JoinColumn(name = "COP_CODIGO")
    public SiiCuotaOperador getSiiCuotaOperador() {
        return siiCuotaOperador;
    }

    public void setSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        this.siiCuotaOperador = siiCuotaOperador;
    }

    @ManyToOne
    @JoinColumn(name = "COP_CODIGO_GA")
    public SiiCuotaOperador getSiiCuotaOperadorGA() {
        return siiCuotaOperadorGA;
    }

    public void setSiiCuotaOperadorGA(SiiCuotaOperador siiCuotaOperadorGA) {
        this.siiCuotaOperadorGA = siiCuotaOperadorGA;
    }

    @Column(name = "CIP_ACTIVO", nullable = false, length = 1)
    public String getCipActivo() {
        return cipActivo;
    }
    
    public void setCipActivo(String cipActivo) {
        this.cipActivo = cipActivo;
    }
}
