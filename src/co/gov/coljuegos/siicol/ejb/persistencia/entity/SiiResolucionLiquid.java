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
@Table(name = "SII_RESOLUCION_LIQUID")
public class SiiResolucionLiquid implements Serializable {
    private static final long serialVersionUID = 7481105790054288491L;
    private Long rliCodigo;
    private Date rliFecha;
    private Date rliFechaFirme;
    private String rliNumero;
    private String rliTipoRes;
    private SiiArchivoFisico siiArchivoFisico;
    private SiiEstadoResolucLiq siiEstadoResolucLiq;
    private SiiLiquidacionContrato siiLiquidacionContrato;
    private String rliResultadoRec;
    private Date rliFechaNotifica;

    public SiiResolucionLiquid() {
    }

    public SiiResolucionLiquid(SiiArchivoFisico siiArchivoFisico, SiiEstadoResolucLiq siiEstadoResolucLiq,
                               SiiLiquidacionContrato siiLiquidacionContrato, Long rliCodigo, Date rliFecha,
                               Date rliFechaFirme, String rliNumero, String rliTipoRes) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.siiEstadoResolucLiq = siiEstadoResolucLiq;
        this.siiLiquidacionContrato = siiLiquidacionContrato;
        this.rliCodigo = rliCodigo;
        this.rliFecha = rliFecha;
        this.rliFechaFirme = rliFechaFirme;
        this.rliNumero = rliNumero;
        this.rliTipoRes = rliTipoRes;
    }


    @Id
    @Column(name = "RLI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESOLUCION_LIQUID_COD")
    @SequenceGenerator(name = "SEQ_RESOLUCION_LIQUID_COD", sequenceName = "SEQ_RESOLUCION_LIQUID_COD",allocationSize=1)
    public Long getRliCodigo() {
        return rliCodigo;
    }

    public void setRliCodigo(Long rliCodigo) {
        this.rliCodigo = rliCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RLI_FECHA", nullable = false)
    public Date getRliFecha() {
        return rliFecha;
    }

    public void setRliFecha(Date rliFecha) {
        this.rliFecha = rliFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RLI_FECHA_FIRME")
    public Date getRliFechaFirme() {
        return rliFechaFirme;
    }

    public void setRliFechaFirme(Date rliFechaFirme) {
        this.rliFechaFirme = rliFechaFirme;
    }

    @Column(name = "RLI_NUMERO", nullable = false, length = 30)
    public String getRliNumero() {
        return rliNumero;
    }

    public void setRliNumero(String rliNumero) {
        this.rliNumero = rliNumero;
    }

    @Column(name = "RLI_TIPO_RES", nullable = false, length = 1)
    public String getRliTipoRes() {
        return rliTipoRes;
    }

    public void setRliTipoRes(String rliTipoRes) {
        this.rliTipoRes = rliTipoRes;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @ManyToOne
    @JoinColumn(name = "ERL_CODIGO")
    public SiiEstadoResolucLiq getSiiEstadoResolucLiq() {
        return siiEstadoResolucLiq;
    }

    public void setSiiEstadoResolucLiq(SiiEstadoResolucLiq siiEstadoResolucLiq) {
        this.siiEstadoResolucLiq = siiEstadoResolucLiq;
    }

    @ManyToOne
    @JoinColumn(name = "LCO_CODIGO")
    public SiiLiquidacionContrato getSiiLiquidacionContrato() {
        return siiLiquidacionContrato;
    }

    public void setSiiLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) {
        this.siiLiquidacionContrato = siiLiquidacionContrato;
    }

    @Column(name = "RLI_RESULTADO_REC", length = 2)
    public String getRliResultadoRec() {
        return rliResultadoRec;
    }

    public void setRliResultadoRec(String rliResultadoRec) {
        this.rliResultadoRec = rliResultadoRec;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RLI_FECHA_NOTIFICA")
    public Date getRliFechaNotifica() {
        return rliFechaNotifica;
    }
    
    public void setRliFechaNotifica(Date rliFechaNotifica) {
        this.rliFechaNotifica = rliFechaNotifica;
    }

}
