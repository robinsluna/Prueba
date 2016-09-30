package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_AMPARO_EST_PREV")
public class SiiAmparoEstPrev implements Serializable {
    private static final long serialVersionUID = -8677427382844020978L;
    private Long aepCodigo;
    private String aepJustificacion;
    private Integer aepPorcentaje;
    private String aepVigencia;
    private SiiEstudioPrevio siiEstudioPrevio;
    private SiiTipoAmparo siiTipoAmparo;
    private SiiTipoGarantia siiTipoGarantia;


    public SiiAmparoEstPrev() {
    }

    public SiiAmparoEstPrev(Long aepCodigo, String aepJustificacion, Integer aepPorcentaje, String aepVigencia,
                            SiiEstudioPrevio siiEstudioPrevio, SiiTipoAmparo siiTipoAmparo, SiiTipoGarantia siiTipoGarantia) {
        this.aepCodigo = aepCodigo;
        this.aepJustificacion = aepJustificacion;
        this.aepPorcentaje = aepPorcentaje;
        this.aepVigencia = aepVigencia;
        this.siiEstudioPrevio = siiEstudioPrevio;
        this.siiTipoAmparo = siiTipoAmparo;
        this.siiTipoGarantia = siiTipoGarantia;
    }

    @Id
    @Column(name = "AEP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AMPARO_EST_PREV_COD")
    @SequenceGenerator(name = "SEQ_AMPARO_EST_PREV_COD", sequenceName = "SEQ_AMPARO_EST_PREV_COD",allocationSize=1)
    public Long getAepCodigo() {
        return aepCodigo;
    }

    public void setAepCodigo(Long aepCodigo) {
        this.aepCodigo = aepCodigo;
    }

    @Column(name = "AEP_JUSTIFICACION", length = 500)
    public String getAepJustificacion() {
        return aepJustificacion;
    }

    public void setAepJustificacion(String aepJustificacion) {
        this.aepJustificacion = aepJustificacion;
    }

    @Column(name = "AEP_PORCENTAJE")
    public Integer getAepPorcentaje() {
        return aepPorcentaje;
    }

    public void setAepPorcentaje(Integer aepPorcentaje) {
        this.aepPorcentaje = aepPorcentaje;
    }

    @Column(name = "AEP_VIGENCIA", length = 100)
    public String getAepVigencia() {
        return aepVigencia;
    }

    public void setAepVigencia(String aepVigencia) {
        this.aepVigencia = aepVigencia;
    }


    @ManyToOne
    @JoinColumn(name = "EPE_CODIGO")
    public SiiEstudioPrevio getSiiEstudioPrevio() {
        return siiEstudioPrevio;
    }

    public void setSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        this.siiEstudioPrevio = siiEstudioPrevio;
    }

    @ManyToOne
    @JoinColumn(name = "TAM_CODIGO")
    public SiiTipoAmparo getSiiTipoAmparo() {
        return siiTipoAmparo;
    }

    public void setSiiTipoAmparo(SiiTipoAmparo siiTipoAmparo) {
        this.siiTipoAmparo = siiTipoAmparo;
    }

    @ManyToOne
    @JoinColumn(name = "TGA_CODIGO")
    public SiiTipoGarantia getSiiTipoGarantia() {
        return siiTipoGarantia;
    }

    public void setSiiTipoGarantia(SiiTipoGarantia siiTipoGarantia) {
        this.siiTipoGarantia = siiTipoGarantia;
    }
}
