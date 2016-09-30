package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_VALIDAC_GCT_OTROSI")
public class SiiValidacGctOtrosi implements Serializable {
    private static final long serialVersionUID = -5682374840401900770L;
    private Long vgoCodigo;
    private Date vgoFecha;
    private String vgoIndicaValid;
    private String vgoObservaciones;
    private SiiOtrosi siiOtrosi;

    public SiiValidacGctOtrosi() {
    }

    public SiiValidacGctOtrosi(SiiOtrosi siiOtrosi, Long vgoCodigo, Date vgoFecha, String vgoIndicaValid,
                               String vgoObservaciones) {
        this.siiOtrosi = siiOtrosi;
        this.vgoCodigo = vgoCodigo;
        this.vgoFecha = vgoFecha;
        this.vgoIndicaValid = vgoIndicaValid;
        this.vgoObservaciones = vgoObservaciones;
    }


    @Id
    @Column(name = "VGO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_VALIDAC_GCT_OTROSI_COD")
    @SequenceGenerator(name = "SEQ_VALIDAC_GCT_OTROSI_COD", sequenceName = "SEQ_VALIDAC_GCT_OTROSI_COD",allocationSize=1)
    public Long getVgoCodigo() {
        return vgoCodigo;
    }

    public void setVgoCodigo(Long vgoCodigo) {
        this.vgoCodigo = vgoCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VGO_FECHA", nullable = false)
    public Date getVgoFecha() {
        return vgoFecha;
    }

    public void setVgoFecha(Date vgoFecha) {
        this.vgoFecha = vgoFecha;
    }

    @Column(name = "VGO_INDICA_VALID", nullable = false, length = 1)
    public String getVgoIndicaValid() {
        return vgoIndicaValid;
    }

    public void setVgoIndicaValid(String vgoIndicaValid) {
        this.vgoIndicaValid = vgoIndicaValid;
    }

    @Column(name = "VGO_OBSERVACIONES", nullable = false, length = 1500)
    public String getVgoObservaciones() {
        return vgoObservaciones;
    }

    public void setVgoObservaciones(String vgoObservaciones) {
        this.vgoObservaciones = vgoObservaciones;
    }

    @ManyToOne
    @JoinColumn(name = "OSI_CODIGO")
    public SiiOtrosi getSiiOtrosi() {
        return siiOtrosi;
    }

    public void setSiiOtrosi(SiiOtrosi siiOtrosi) {
        this.siiOtrosi = siiOtrosi;
    }
}
