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
@Table(name = "SII_REVIS_FINANC_OTROSI")
public class SiiRevisFinancOtrosi implements Serializable {
    private static final long serialVersionUID = 7849716586966357236L;
    private Long rfoCodigo;
    private Date rfoFecha;
    private String rfoObservaciones;
    private String rfoValida;
    private SiiOtrosi siiOtrosi;
    private String rfoTipoValidac;

    public SiiRevisFinancOtrosi() {
    }

    public SiiRevisFinancOtrosi(SiiOtrosi siiOtrosi, Long rfoCodigo, Date rfoFecha, String rfoObservaciones,
                                String rfoValida) {
        this.siiOtrosi = siiOtrosi;
        this.rfoCodigo = rfoCodigo;
        this.rfoFecha = rfoFecha;
        this.rfoObservaciones = rfoObservaciones;
        this.rfoValida = rfoValida;
    }


    @Id
    @Column(name = "RFO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REVIS_FINANC_OTROSI_COD")
    @SequenceGenerator(name = "SEQ_REVIS_FINANC_OTROSI_COD", sequenceName = "SEQ_REVIS_FINANC_OTROSI_COD",allocationSize=1)
    public Long getRfoCodigo() {
        return rfoCodigo;
    }

    public void setRfoCodigo(Long rfoCodigo) {
        this.rfoCodigo = rfoCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RFO_FECHA", nullable = false)
    public Date getRfoFecha() {
        return rfoFecha;
    }

    public void setRfoFecha(Date rfoFecha) {
        this.rfoFecha = rfoFecha;
    }

    @Column(name = "RFO_OBSERVACIONES", nullable = false, length = 1500)
    public String getRfoObservaciones() {
        return rfoObservaciones;
    }

    public void setRfoObservaciones(String rfoObservaciones) {
        this.rfoObservaciones = rfoObservaciones;
    }

    @Column(name = "RFO_VALIDA", nullable = false, length = 1)
    public String getRfoValida() {
        return rfoValida;
    }

    public void setRfoValida(String rfoValida) {
        this.rfoValida = rfoValida;
    }

    @ManyToOne
    @JoinColumn(name = "OSI_CODIGO")
    public SiiOtrosi getSiiOtrosi() {
        return siiOtrosi;
    }

    public void setSiiOtrosi(SiiOtrosi siiOtrosi) {
        this.siiOtrosi = siiOtrosi;
    }

    @Column(name = "RFO_TIPO_VALIDAC", nullable = false, length = 3)
    public String getRfoTipoValidac() {
        return rfoTipoValidac;
    }

    public void setRfoTipoValidac(String rfoTipoValidac) {
        this.rfoTipoValidac = rfoTipoValidac;
    }
}
