package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SII_TRAMITE_AUTO_PRUE_TRAS")
public class SiiTramiteAutoPrueTras implements Serializable {
    private static final long serialVersionUID = -3732921342677371624L;
    private Long traCodigo;
    private Date traFecha;
    private String traPaso;
    private SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle;
    private SiiUsuario siiUsuarioConec;

    public SiiTramiteAutoPrueTras() {
    }

    public SiiTramiteAutoPrueTras(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle, Long traCodigo, Date traFecha, String traPaso, SiiUsuario siiUsuarioConec) {
        this.siiAutoDecretaPrueProIle = siiAutoDecretaPrueProIle;
        this.traCodigo = traCodigo;
        this.traFecha = traFecha;
        this.traPaso = traPaso;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "TRA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TRAM_AUTO_PRUE_TRAS_COD")
    @SequenceGenerator(name = "SEQ_TRAM_AUTO_PRUE_TRAS_COD", sequenceName = "SEQ_TRAM_AUTO_PRUE_TRAS_COD",allocationSize=1)
    public Long getTraCodigo() {
        return traCodigo;
    }

    public void setTraCodigo(Long traCodigo) {
        this.traCodigo = traCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRA_FECHA", nullable = false)
    public Date getTraFecha() {
        return traFecha;
    }

    public void setTraFecha(Date traFecha) {
        this.traFecha = traFecha;
    }

    @Column(name = "TRA_PASO", nullable = false, length = 1)
    public String getTraPaso() {
        return traPaso;
    }

    public void setTraPaso(String traPaso) {
        this.traPaso = traPaso;
    }


    @ManyToOne
    @JoinColumn(name = "ATP_CODIGO")
    public SiiAutoDecretaPrueProIle getSiiAutoDecretaPrueProIle() {
        return siiAutoDecretaPrueProIle;
    }

    public void setSiiAutoDecretaPrueProIle(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle) {
        this.siiAutoDecretaPrueProIle = siiAutoDecretaPrueProIle;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }
}
