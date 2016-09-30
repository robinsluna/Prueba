/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaInexacProcSanc;

import java.math.BigDecimal;

/**
 * Value object que gestiona la cuota inexacta del proceso sancionatorio
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public class CuotaInexacProcSancVO {

    private Long cipCodigo;
    private BigDecimal cipDiferenciaDe;
    private BigDecimal cipDiferenciaGa;
    private BigDecimal cipLiquidRevisDe;
    private BigDecimal cipLiquidRevisGa;
    private BigDecimal cipValorSancion;
    private String cipActivo;

    private ProcesoSancionatorioVO procesoSancionatorioVo;
    /** Cuota Operador de Derechos de Explotaci&oacute;n. */
    private CuotaOperadorVO cuotaOperadorDE;
    /** Cuota Operador de Gastos de Administraci&oacute;n. */
    private CuotaOperadorVO cuotaOperadorGA;

    /**
     * Constructor.
     */
    public CuotaInexacProcSancVO() {
        super();
    }

    /**
     * Constructor.
     * @param siiCuotaInexacProcSanc - Entity
     */
    public CuotaInexacProcSancVO(SiiCuotaInexacProcSanc siiCuotaInexacProcSanc) {
        this.cipCodigo = siiCuotaInexacProcSanc.getCipCodigo();
        this.cipDiferenciaDe = siiCuotaInexacProcSanc.getCipDiferenciaDe();
        this.cipDiferenciaGa = siiCuotaInexacProcSanc.getCipDiferenciaGa();
        this.cipLiquidRevisDe = siiCuotaInexacProcSanc.getCipLiquidRevisDe();
        this.cipLiquidRevisGa = siiCuotaInexacProcSanc.getCipLiquidRevisGa();
        this.cipValorSancion = siiCuotaInexacProcSanc.getCipValorSancion();
        this.cipActivo = siiCuotaInexacProcSanc.getCipActivo();

        if (siiCuotaInexacProcSanc.getSiiProcesoSancionatorio() != null)
            this.procesoSancionatorioVo =
                new ProcesoSancionatorioVO(siiCuotaInexacProcSanc.getSiiProcesoSancionatorio());

        if (siiCuotaInexacProcSanc.getSiiCuotaOperador() != null)
            this.cuotaOperadorDE = new CuotaOperadorVO(siiCuotaInexacProcSanc.getSiiCuotaOperador());
        if (siiCuotaInexacProcSanc.getSiiCuotaOperadorGA()!=null)
            this.cuotaOperadorGA = new CuotaOperadorVO(siiCuotaInexacProcSanc.getSiiCuotaOperadorGA());
    }

    public void setCipCodigo(Long cipCodigo) {
        this.cipCodigo = cipCodigo;
    }

    public Long getCipCodigo() {
        return cipCodigo;
    }

    public void setCipDiferenciaDe(BigDecimal cipDiferenciaDe) {
        this.cipDiferenciaDe = cipDiferenciaDe;
    }

    public BigDecimal getCipDiferenciaDe() {
        return cipDiferenciaDe;
    }

    public void setCipDiferenciaGa(BigDecimal cipDiferenciaGa) {
        this.cipDiferenciaGa = cipDiferenciaGa;
    }

    public BigDecimal getCipDiferenciaGa() {
        return cipDiferenciaGa;
    }

    public void setCipLiquidRevisDe(BigDecimal cipLiquidRevisDe) {
        this.cipLiquidRevisDe = cipLiquidRevisDe;
    }

    public BigDecimal getCipLiquidRevisDe() {
        return cipLiquidRevisDe;
    }

    public void setCipLiquidRevisGa(BigDecimal cipLiquidRevisGa) {
        this.cipLiquidRevisGa = cipLiquidRevisGa;
    }

    public BigDecimal getCipLiquidRevisGa() {
        return cipLiquidRevisGa;
    }

    public void setCipValorSancion(BigDecimal cipValorSancion) {
        this.cipValorSancion = cipValorSancion;
    }

    public BigDecimal getCipValorSancion() {
        return cipValorSancion;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioVo = procesoSancionatorioVo;
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        return procesoSancionatorioVo;
    }

    public void setCuotaOperadorDE(CuotaOperadorVO cuotaOperadorDE) {
        this.cuotaOperadorDE = cuotaOperadorDE;
    }

    public CuotaOperadorVO getCuotaOperadorDE() {
        return cuotaOperadorDE;
    }

    public void setCuotaOperadorGA(CuotaOperadorVO cuotaOperadorGA) {
        this.cuotaOperadorGA = cuotaOperadorGA;
    }

    public CuotaOperadorVO getCuotaOperadorGA() {
        return cuotaOperadorGA;
    }

    public void setCipActivo(String cipActivo) {
        this.cipActivo = cipActivo;
    }

    public String getCipActivo() {
        return cipActivo;
    }
}
