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
@Table(name = "SII_HLP_LIQ_ESTABL_ASIG_REC")
public class SiiHlpLiqEstablAsigRec implements Serializable {
    private static final long serialVersionUID = 8802191793232953522L;
    private Long areCodigo;
    private Long hleCodigo;
    private String hleNumEstablec;
    private BigDecimal hlePonderado;
    private BigDecimal hleValor;
    private SiiUbicacion siiUbicacionMunEst;

    public SiiHlpLiqEstablAsigRec() {
    }

    public SiiHlpLiqEstablAsigRec(Long areCodigo, Long hleCodigo, String hleNumEstablec, BigDecimal hlePonderado, BigDecimal hleValor, SiiUbicacion siiUbicacionMunEst) {
        this.areCodigo = areCodigo;
        this.hleCodigo = hleCodigo;
        this.hleNumEstablec = hleNumEstablec;
        this.hlePonderado = hlePonderado;
        this.hleValor = hleValor;
        this.siiUbicacionMunEst = siiUbicacionMunEst;
    }

    @Column(name = "ARE_CODIGO")
    public Long getAreCodigo() {
        return areCodigo;
    }

    public void setAreCodigo(Long areCodigo) {
        this.areCodigo = areCodigo;
    }

    @Id
    @Column(name = "HLE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HLP_LIQ_ESTA_AS_REC_COD")
    @SequenceGenerator(name = "SEQ_HLP_LIQ_ESTA_AS_REC_COD", sequenceName = "SEQ_HLP_LIQ_ESTA_AS_REC_COD",allocationSize=1)
    public Long getHleCodigo() {
        return hleCodigo;
    }

    public void setHleCodigo(Long hleCodigo) {
        this.hleCodigo = hleCodigo;
    }

    @Column(name = "HLE_NUM_ESTABLEC", length = 30)
    public String getHleNumEstablec() {
        return hleNumEstablec;
    }

    public void setHleNumEstablec(String hleNumEstablec) {
        this.hleNumEstablec = hleNumEstablec;
    }

    @Column(name = "HLE_PONDERADO", nullable = false)
    public BigDecimal getHlePonderado() {
        return hlePonderado;
    }

    public void setHlePonderado(BigDecimal hlePonderado) {
        this.hlePonderado = hlePonderado;
    }

    @Column(name = "HLE_VALOR", nullable = false)
    public BigDecimal getHleValor() {
        return hleValor;
    }

    public void setHleValor(BigDecimal hleValor) {
        this.hleValor = hleValor;
    }


    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_MUN_EST")
    public SiiUbicacion getSiiUbicacionMunEst() {
        return siiUbicacionMunEst;
    }

    public void setSiiUbicacionMunEst(SiiUbicacion siiUbicacionMunEst) {
        this.siiUbicacionMunEst = siiUbicacionMunEst;
    }
}
