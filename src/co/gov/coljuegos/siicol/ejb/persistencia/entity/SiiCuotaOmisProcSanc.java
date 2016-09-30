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
@Table(name = "SII_CUOTA_OMIS_PROC_SANC")
public class SiiCuotaOmisProcSanc implements Serializable {
    private static final long serialVersionUID = -4628438526231609377L;
    private Long cosCodigo;
    private BigDecimal cosValorSancion;
    private SiiCuotaOperador siiCuotaOperador;
    private SiiProcesoSancionatorio siiProcesoSancionatorio;
    private String cosActivo;
    private BigDecimal cosValorDe;

    public SiiCuotaOmisProcSanc() {
    }

    public SiiCuotaOmisProcSanc(SiiCuotaOperador siiCuotaOperador, Long cosCodigo, BigDecimal cosValorSancion, SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.siiCuotaOperador = siiCuotaOperador;
        this.cosCodigo = cosCodigo;
        this.cosValorSancion = cosValorSancion;
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }


    @Id
    @Column(name = "COS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUO_OMIS_PROC_SANC_COD")
    @SequenceGenerator(name = "SEQ_CUO_OMIS_PROC_SANC_COD", sequenceName = "SEQ_CUO_OMIS_PROC_SANC_COD",allocationSize=1)
    public Long getCosCodigo() {
        return cosCodigo;
    }

    public void setCosCodigo(Long cosCodigo) {
        this.cosCodigo = cosCodigo;
    }

    @Column(name = "COS_VALOR_SANCION", nullable = false)
    public BigDecimal getCosValorSancion() {
        return cosValorSancion;
    }

    public void setCosValorSancion(BigDecimal cosValorSancion) {
        this.cosValorSancion = cosValorSancion;
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
    @JoinColumn(name = "PSA_CODIGO")
    public SiiProcesoSancionatorio getSiiProcesoSancionatorio() {
        return siiProcesoSancionatorio;
    }

    public void setSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }

    @Column(name = "COS_ACTIVO", nullable = false, length = 1)
    public String getCosActivo() {
        return cosActivo;
    }
    
    public void setCosActivo(String cosActivo) {
        this.cosActivo = cosActivo;
    }

    @Column(name = "COS_VALOR_DE", nullable = false)
    public BigDecimal getCosValorDe() {
        return cosValorDe;
    }
    
    public void setCosValorDe(BigDecimal cosValorDe) {
        this.cosValorDe = cosValorDe;
    }
}
