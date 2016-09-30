/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOmisProcSanc;

import java.math.BigDecimal;

/**
 * Value object que gestiona la cuota de omisión del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class CuotaOmisProcSancVO {

    private Long cosCodigo;
    private BigDecimal cosValorDe;
    private BigDecimal cosValorSancion;
    private String cosActivo;
    
    private CuotaOperadorVO cuotaOperadorVo;
    private ProcesoSancionatorioVO procesoSancionatorioVo;

    /**
     * Constructor.
     */
    public CuotaOmisProcSancVO() {
        super();
    }

    /**
     * Constructor.
     * @param siiCuotaOmisProcSanc - Entity
     */
    public CuotaOmisProcSancVO(SiiCuotaOmisProcSanc siiCuotaOmisProcSanc) {
        this.cosCodigo = siiCuotaOmisProcSanc.getCosCodigo();
        this.cosValorDe = siiCuotaOmisProcSanc.getCosValorDe();
        this.cosValorSancion = siiCuotaOmisProcSanc.getCosValorSancion();
        this.cosActivo = siiCuotaOmisProcSanc.getCosActivo();

        if (siiCuotaOmisProcSanc.getSiiCuotaOperador() != null)
            this.cuotaOperadorVo = new CuotaOperadorVO(siiCuotaOmisProcSanc.getSiiCuotaOperador());

        if (siiCuotaOmisProcSanc.getSiiProcesoSancionatorio() != null)
            this.procesoSancionatorioVo = new ProcesoSancionatorioVO(siiCuotaOmisProcSanc.getSiiProcesoSancionatorio());
    }

    public void setCosCodigo(Long cosCodigo) {
        this.cosCodigo = cosCodigo;
    }

    public Long getCosCodigo() {
        return cosCodigo;
    }

    public void setCosValorSancion(BigDecimal cosValorSancion) {
        this.cosValorSancion = cosValorSancion;
    }

    public BigDecimal getCosValorSancion() {
        return cosValorSancion;
    }

    public void setCuotaOperadorVo(CuotaOperadorVO cuotaOperadorVo) {
        this.cuotaOperadorVo = cuotaOperadorVo;
    }

    public CuotaOperadorVO getCuotaOperadorVo() {
        return cuotaOperadorVo;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioVo = procesoSancionatorioVo;
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        return procesoSancionatorioVo;
    }

    public void setCosActivo(String cosActivo) {
        this.cosActivo = cosActivo;
    }

    public String getCosActivo() {
        return cosActivo;
    }

    public void setCosValorDe(BigDecimal cosValorDe) {
        this.cosValorDe = cosValorDe;
    }

    public BigDecimal getCosValorDe() {
        return cosValorDe;
    }
}
