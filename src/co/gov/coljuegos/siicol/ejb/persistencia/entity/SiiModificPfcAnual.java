package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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

@Entity
@Table(name = "SII_MODIFIC_PFC_ANUAL")
public class SiiModificPfcAnual implements Serializable {
    private static final long serialVersionUID = -6874890789350326709L;
    private String mpaActivo;
    private Long mpaCodigo;
    private String mpaJustificacion;
    private String mpaTipoModif;
    private BigDecimal mpaValor;
    private SiiDistribucionPfc siiDistribucionPfc;
    private SiiSolicPfcmDetalle siiSolicPfcmDetalle;

    public SiiModificPfcAnual() {
    }

    public SiiModificPfcAnual(SiiDistribucionPfc siiDistribucionPfc, String mpaActivo, Long mpaCodigo,
                              String mpaJustificacion, String mpaTipoModif, BigDecimal mpaValor,
                              SiiSolicPfcmDetalle siiSolicPfcmDetalle) {
        this.siiDistribucionPfc = siiDistribucionPfc;
        this.mpaActivo = mpaActivo;
        this.mpaCodigo = mpaCodigo;
        this.mpaJustificacion = mpaJustificacion;
        this.mpaTipoModif = mpaTipoModif;
        this.mpaValor = mpaValor;
        this.siiSolicPfcmDetalle = siiSolicPfcmDetalle;
    }


    @Column(name = "MPA_ACTIVO", nullable = false, length = 1)
    public String getMpaActivo() {
        return mpaActivo;
    }

    public void setMpaActivo(String mpaActivo) {
        this.mpaActivo = mpaActivo;
    }

    @Id
    @Column(name = "MPA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODIFIC_PFC_ANUAL_COD")
    @SequenceGenerator(name = "SEQ_MODIFIC_PFC_ANUAL_COD", sequenceName = "SEQ_MODIFIC_PFC_ANUAL_COD",allocationSize=1)
    public Long getMpaCodigo() {
        return mpaCodigo;
    }

    public void setMpaCodigo(Long mpaCodigo) {
        this.mpaCodigo = mpaCodigo;
    }

    @Column(name = "MPA_JUSTIFICACION", nullable = false, length = 2000)
    public String getMpaJustificacion() {
        return mpaJustificacion;
    }

    public void setMpaJustificacion(String mpaJustificacion) {
        this.mpaJustificacion = mpaJustificacion;
    }

    @Column(name = "MPA_TIPO_MODIF", nullable = false, length = 2)
    public String getMpaTipoModif() {
        return mpaTipoModif;
    }

    public void setMpaTipoModif(String mpaTipoModif) {
        this.mpaTipoModif = mpaTipoModif;
    }

    @Column(name = "MPA_VALOR", nullable = false, length = 20)
    public BigDecimal getMpaValor() {
        return mpaValor;
    }

    public void setMpaValor(BigDecimal mpaValor) {
        this.mpaValor = mpaValor;
    }


    @ManyToOne
    @JoinColumn(name = "DPF_CODIGO")
    public SiiDistribucionPfc getSiiDistribucionPfc() {
        return siiDistribucionPfc;
    }

    public void setSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) {
        this.siiDistribucionPfc = siiDistribucionPfc;
    }


    @ManyToOne
    @JoinColumn(name = "SPD_CODIGO")
    public SiiSolicPfcmDetalle getSiiSolicPfcmDetalle() {
        return siiSolicPfcmDetalle;
    }

    public void setSiiSolicPfcmDetalle(SiiSolicPfcmDetalle siiSolicPfcmDetalle) {
        this.siiSolicPfcmDetalle = siiSolicPfcmDetalle;
    }
}
