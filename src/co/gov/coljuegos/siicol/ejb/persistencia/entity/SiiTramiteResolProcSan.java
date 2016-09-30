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
@Table(name = "SII_TRAMITE_RESOL_PROC_SAN")
public class SiiTramiteResolProcSan implements Serializable {
    private static final long serialVersionUID = 679248927488777170L;
    private Long trpCodigo;
    private Date trpFecha;
    private SiiResolucionProcSanc siiResolucionProcSanc;
    private SiiEstadoTramResPrSan siiEstadoTramResPrSan;
    private String trpNumeracRadicado;
    private Date trpNumeracFecRad;

    public SiiTramiteResolProcSan() {
    }

    public SiiTramiteResolProcSan(SiiEstadoTramResPrSan siiEstadoTramResPrSan, SiiResolucionProcSanc siiResolucionProcSanc, Long trpCodigo, Date trpFecha) {
        this.siiEstadoTramResPrSan = siiEstadoTramResPrSan;
        this.siiResolucionProcSanc = siiResolucionProcSanc;
        this.trpCodigo = trpCodigo;
        this.trpFecha = trpFecha;
    }


    @Id
    @Column(name = "TRP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TRAM_RES_PROC_SAN_COD")
    @SequenceGenerator(name = "SEQ_TRAM_RES_PROC_SAN_COD", sequenceName = "SEQ_TRAM_RES_PROC_SAN_COD",allocationSize=1)
    public Long getTrpCodigo() {
        return trpCodigo;
    }

    public void setTrpCodigo(Long trpCodigo) {
        this.trpCodigo = trpCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRP_FECHA")
    public Date getTrpFecha() {
        return trpFecha;
    }

    public void setTrpFecha(Date trpFecha) {
        this.trpFecha = trpFecha;
    }

    @ManyToOne
    @JoinColumn(name = "REP_CODIGO")
    public SiiResolucionProcSanc getSiiResolucionProcSanc() {
        return siiResolucionProcSanc;
    }

    public void setSiiResolucionProcSanc(SiiResolucionProcSanc siiResolucionProcSanc) {
        this.siiResolucionProcSanc = siiResolucionProcSanc;
    }

    @ManyToOne
    @JoinColumn(name = "ETR_CODIGO")
    public SiiEstadoTramResPrSan getSiiEstadoTramResPrSan() {
        return siiEstadoTramResPrSan;
    }

    public void setSiiEstadoTramResPrSan(SiiEstadoTramResPrSan siiEstadoTramResPrSan) {
        this.siiEstadoTramResPrSan = siiEstadoTramResPrSan;
    }

    @Column(name = "TRP_NUMERAC_RADICADO", length = 30)
    public String getTrpNumeracRadicado() {
        return trpNumeracRadicado;
    }
    
    public void setTrpNumeracRadicado(String trpNumeracRadicado) {
        this.trpNumeracRadicado = trpNumeracRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRP_NUMERAC_FEC_RAD")
    public Date getTrpNumeracFecRad() {
        return trpNumeracFecRad;
    }
    
    public void setTrpNumeracFecRad(Date trpNumeracFecRad) {
        this.trpNumeracFecRad = trpNumeracFecRad;
    }
}
