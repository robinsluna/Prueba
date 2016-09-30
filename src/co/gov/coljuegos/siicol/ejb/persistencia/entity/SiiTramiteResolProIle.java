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
@Table(name = "SII_TRAMITE_RESOL_PRO_ILE")
public class SiiTramiteResolProIle implements Serializable {
    private static final long serialVersionUID = 4688661120160979435L;
    private Long tpiCodigo;
    private Date tpiFecha;
    private SiiResolucionProcIleg siiResolucionProcIleg;
    private SiiUsuario siiUsuarioConec;
    private SiiEstadoTramResProcIleg siiEstadoTramResProcIleg;

    public SiiTramiteResolProIle() {
    }

    public SiiTramiteResolProIle(SiiEstadoTramResProcIleg siiEstadoTramResProcIleg, SiiResolucionProcIleg siiResolucionProcIleg, Long tpiCodigo, Date tpiFecha, SiiUsuario siiUsuarioConec) {
        this.siiEstadoTramResProcIleg = siiEstadoTramResProcIleg;
        this.siiResolucionProcIleg = siiResolucionProcIleg;
        this.tpiCodigo = tpiCodigo;
        this.tpiFecha = tpiFecha;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "TPI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TRAM_RESOL_PRO_ILE_COD")
    @SequenceGenerator(name = "SEQ_TRAM_RESOL_PRO_ILE_COD", sequenceName = "SEQ_TRAM_RESOL_PRO_ILE_COD",allocationSize=1)
    public Long getTpiCodigo() {
        return tpiCodigo;
    }

    public void setTpiCodigo(Long tpiCodigo) {
        this.tpiCodigo = tpiCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TPI_FECHA", nullable = false)
    public Date getTpiFecha() {
        return tpiFecha;
    }

    public void setTpiFecha(Date tpiFecha) {
        this.tpiFecha = tpiFecha;
    }


    @ManyToOne
    @JoinColumn(name = "RPI_CODIGO")
    public SiiResolucionProcIleg getSiiResolucionProcIleg() {
        return siiResolucionProcIleg;
    }

    public void setSiiResolucionProcIleg(SiiResolucionProcIleg siiResolucionProcIleg) {
        this.siiResolucionProcIleg = siiResolucionProcIleg;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @ManyToOne
    @JoinColumn(name = "ETR_CODIGO")
    public SiiEstadoTramResProcIleg getSiiEstadoTramResProcIleg() {
        return siiEstadoTramResProcIleg;
    }

    public void setSiiEstadoTramResProcIleg(SiiEstadoTramResProcIleg siiEstadoTramResProcIleg) {
        this.siiEstadoTramResProcIleg = siiEstadoTramResProcIleg;
    }
}
