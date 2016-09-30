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
@Table(name = "SII_TRAMITE_AUTO_FOR_CAR_ILE")
public class SiiTramiteAutoForCarIle implements Serializable {
    private static final long serialVersionUID = -592146150186948290L;
    private Long tafCodigo;
    private Date tafFecha;
    private String tafPaso;
    private SiiAutoFormCargProIle siiAutoFormCargProIle;
    private SiiUsuario siiUsuarioConec;

    public SiiTramiteAutoForCarIle() {
    }

    public SiiTramiteAutoForCarIle(SiiAutoFormCargProIle siiAutoFormCargProIle, Long tafCodigo, Date tafFecha, String tafPaso, SiiUsuario siiUsuarioConec) {
        this.siiAutoFormCargProIle = siiAutoFormCargProIle;
        this.tafCodigo = tafCodigo;
        this.tafFecha = tafFecha;
        this.tafPaso = tafPaso;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "TAF_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TRAM_AUT_FOR_CAR_ILE_COD")
    @SequenceGenerator(name = "SEQ_TRAM_AUT_FOR_CAR_ILE_COD", sequenceName = "SEQ_TRAM_AUT_FOR_CAR_ILE_COD",allocationSize=1)
    public Long getTafCodigo() {
        return tafCodigo;
    }

    public void setTafCodigo(Long tafCodigo) {
        this.tafCodigo = tafCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAF_FECHA", nullable = false)
    public Date getTafFecha() {
        return tafFecha;
    }

    public void setTafFecha(Date tafFecha) {
        this.tafFecha = tafFecha;
    }

    @Column(name = "TAF_PASO", nullable = false, length = 1)
    public String getTafPaso() {
        return tafPaso;
    }

    public void setTafPaso(String tafPaso) {
        this.tafPaso = tafPaso;
    }


    @ManyToOne
    @JoinColumn(name = "AFC_CODIGO")
    public SiiAutoFormCargProIle getSiiAutoFormCargProIle() {
        return siiAutoFormCargProIle;
    }

    public void setSiiAutoFormCargProIle(SiiAutoFormCargProIle siiAutoFormCargProIle) {
        this.siiAutoFormCargProIle = siiAutoFormCargProIle;
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
