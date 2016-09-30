package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ACTIVIDAD_ICA_PERS")
public class SiiActividadIcaPers implements Serializable {
    private static final long serialVersionUID = -848862654725538573L;
    private String aipActivPrinc;
    private Long aipCodigo;
    private SiiPersona siiPersona;
    private SiiActividadIca siiActividadIca;

    public SiiActividadIcaPers() {
    }

    public SiiActividadIcaPers(SiiActividadIca siiActividadIca, String aipActivPrinc, Long aipCodigo,
                               SiiPersona siiPersona) {
        this.siiActividadIca = siiActividadIca;
        this.aipActivPrinc = aipActivPrinc;
        this.aipCodigo = aipCodigo;
        this.siiPersona = siiPersona;
    }


    @Column(name = "AIP_ACTIV_PRINC", length = 1)
    public String getAipActivPrinc() {
        return aipActivPrinc;
    }

    public void setAipActivPrinc(String aipActivPrinc) {
        this.aipActivPrinc = aipActivPrinc;
    }

    @Id
    @Column(name = "AIP_CODIGO", nullable = false)
    public Long getAipCodigo() {
        return aipCodigo;
    }

    public void setAipCodigo(Long aipCodigo) {
        this.aipCodigo = aipCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "AIC_CODIGO")
    public SiiActividadIca getSiiActividadIca() {
        return siiActividadIca;
    }

    public void setSiiActividadIca(SiiActividadIca siiActividadIca) {
        this.siiActividadIca = siiActividadIca;
    }
}
