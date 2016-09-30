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
@Table(name = "SII_ASIG_RECAUDO_AA_ESTABL")
public class SiiAsigRecaudoAaEstabl implements Serializable {
    private static final long serialVersionUID = -7162912207040286610L;
    private Long asrCodigo;
    private String asrNumEstablec;
    private BigDecimal asrValor;
    private SiiUbicacion siiUbicacion;
    private SiiAsignacionRecaudoAa siiAsignacionRecaudoAa;

    public SiiAsigRecaudoAaEstabl() {
    }

    public SiiAsigRecaudoAaEstabl(SiiAsignacionRecaudoAa siiAsignacionRecaudoAa, Long asrCodigo, String asrNumEstablec, BigDecimal asrValor, SiiUbicacion siiUbicacion) {
        this.siiAsignacionRecaudoAa = siiAsignacionRecaudoAa;
        this.asrCodigo = asrCodigo;
        this.asrNumEstablec = asrNumEstablec;
        this.asrValor = asrValor;
        this.siiUbicacion = siiUbicacion;
    }


    @Id
    @Column(name = "ASR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ASIG_REC_AA_ESTABL_COD")
    @SequenceGenerator(name = "SEQ_ASIG_REC_AA_ESTABL_COD", sequenceName = "SEQ_ASIG_REC_AA_ESTABL_COD",allocationSize=1)
    public Long getAsrCodigo() {
        return asrCodigo;
    }

    public void setAsrCodigo(Long asrCodigo) {
        this.asrCodigo = asrCodigo;
    }

    @Column(name = "ASR_NUM_ESTABLEC", nullable = false, length = 30)
    public String getAsrNumEstablec() {
        return asrNumEstablec;
    }

    public void setAsrNumEstablec(String asrNumEstablec) {
        this.asrNumEstablec = asrNumEstablec;
    }

    @Column(name = "ASR_VALOR", nullable = false)
    public BigDecimal getAsrValor() {
        return asrValor;
    }

    public void setAsrValor(BigDecimal asrValor) {
        this.asrValor = asrValor;
    }


    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacion() {
        return siiUbicacion;
    }

    public void setSiiUbicacion(SiiUbicacion siiUbicacion) {
        this.siiUbicacion = siiUbicacion;
    }

    @ManyToOne
    @JoinColumn(name = "ARA_CODIGO")
    public SiiAsignacionRecaudoAa getSiiAsignacionRecaudoAa() {
        return siiAsignacionRecaudoAa;
    }

    public void setSiiAsignacionRecaudoAa(SiiAsignacionRecaudoAa siiAsignacionRecaudoAa) {
        this.siiAsignacionRecaudoAa = siiAsignacionRecaudoAa;
    }
}
