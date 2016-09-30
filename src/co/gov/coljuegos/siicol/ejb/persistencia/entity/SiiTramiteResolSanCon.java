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
@Table(name = "SII_TRAMITE_RESOL_SAN_CON")
public class SiiTramiteResolSanCon implements Serializable {
    private static final long serialVersionUID = 5990211869350429035L;
    private Long trsCodigo;
    private Date trsFecha;
    private SiiResolucionIncumContr siiResolucionIncumContr;
    private SiiEstadoResolucSanCon siiEstadoResolucSanCon;

    public SiiTramiteResolSanCon() {
    }

    public SiiTramiteResolSanCon(SiiEstadoResolucSanCon siiEstadoResolucSanCon,
                                 SiiResolucionIncumContr siiResolucionIncumContr, Long trsCodigo, Date trsFecha) {
        this.siiEstadoResolucSanCon = siiEstadoResolucSanCon;
        this.siiResolucionIncumContr = siiResolucionIncumContr;
        this.trsCodigo = trsCodigo;
        this.trsFecha = trsFecha;
    }


    @Id
    @Column(name = "TRS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TRAMITE_RESOL_SAN_CON_COD")
    @SequenceGenerator(name = "SEQ_TRAMITE_RESOL_SAN_CON_COD", sequenceName = "SEQ_TRAMITE_RESOL_SAN_CON_COD",allocationSize=1)
    public Long getTrsCodigo() {
        return trsCodigo;
    }

    public void setTrsCodigo(Long trsCodigo) {
        this.trsCodigo = trsCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRS_FECHA", nullable = false)
    public Date getTrsFecha() {
        return trsFecha;
    }

    public void setTrsFecha(Date trsFecha) {
        this.trsFecha = trsFecha;
    }

    @ManyToOne
    @JoinColumn(name = "RCO_CODIGO")
    public SiiResolucionIncumContr getSiiResolucionIncumContr() {
        return siiResolucionIncumContr;
    }

    public void setSiiResolucionIncumContr(SiiResolucionIncumContr siiResolucionIncumContr) {
        this.siiResolucionIncumContr = siiResolucionIncumContr;
    }

    @ManyToOne
    @JoinColumn(name = "ERS_CODIGO")
    public SiiEstadoResolucSanCon getSiiEstadoResolucSanCon() {
        return siiEstadoResolucSanCon;
    }

    public void setSiiEstadoResolucSanCon(SiiEstadoResolucSanCon siiEstadoResolucSanCon) {
        this.siiEstadoResolucSanCon = siiEstadoResolucSanCon;
    }
}
