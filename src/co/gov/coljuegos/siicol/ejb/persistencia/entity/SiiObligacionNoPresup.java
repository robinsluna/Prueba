package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_OBLIGACION_NO_PRESUP")
public class SiiObligacionNoPresup implements Serializable {
    private static final long serialVersionUID = -2106513131067354882L;
    private Long onpCodigo;
    private Date onpFecha;
    private Integer onpNumero;
    private List<SiiImpContabOblNoPres> siiImpContabOblNoPresList;
    private SiiEstadoObligNoPres siiEstadoObligNoPres;
    private SiiPersona siiPersona;
    private String onpMotivoAnul;
    private List<SiiOrdenPago> siiOrdenPagoList;
    private SiiUsuario siiUsuarioRegistra;
    private SiiUsuario siiUsuarioAprueba;
    private String onpConcepto;

    public SiiObligacionNoPresup() {
    }

    public SiiObligacionNoPresup(SiiEstadoObligNoPres siiEstadoObligNoPres, Long onpCodigo, Date onpFecha,
                                 Integer onpNumero) {
        this.siiEstadoObligNoPres = siiEstadoObligNoPres;
        this.onpCodigo = onpCodigo;
        this.onpFecha = onpFecha;
        this.onpNumero = onpNumero;
    }


    @Id
    @Column(name = "ONP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OBLIGA_NO_PRESUP_COD")
    @SequenceGenerator(name = "SEQ_OBLIGA_NO_PRESUP_COD", sequenceName = "SEQ_OBLIGA_NO_PRESUP_COD",allocationSize=1)
    public Long getOnpCodigo() {
        return onpCodigo;
    }

    public void setOnpCodigo(Long onpCodigo) {
        this.onpCodigo = onpCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ONP_FECHA", nullable = false)
    public Date getOnpFecha() {
        return onpFecha;
    }

    public void setOnpFecha(Date onpFecha) {
        this.onpFecha = onpFecha;
    }

    @Column(name = "ONP_MOTIVO_ANUL", length = 1000)
    public String getOnpMotivoAnul() {
        return onpMotivoAnul;
    }

    public void setOnpMotivoAnul(String onpMotivoAnul) {
        this.onpMotivoAnul = onpMotivoAnul;
    }

    @Column(name = "ONP_NUMERO")
    public Integer getOnpNumero() {
        return onpNumero;
    }

    public void setOnpNumero(Integer onpNumero) {
        this.onpNumero = onpNumero;
    }

    @OneToMany(mappedBy = "siiObligacionNoPresup")
    public List<SiiImpContabOblNoPres> getSiiImpContabOblNoPresList() {
        return siiImpContabOblNoPresList;
    }

    public void setSiiImpContabOblNoPresList(List<SiiImpContabOblNoPres> siiImpContabOblNoPresList) {
        this.siiImpContabOblNoPresList = siiImpContabOblNoPresList;
    }

    public SiiImpContabOblNoPres addSiiImpContabOblNoPres(SiiImpContabOblNoPres siiImpContabOblNoPres) {
        getSiiImpContabOblNoPresList().add(siiImpContabOblNoPres);
        siiImpContabOblNoPres.setSiiObligacionNoPresup(this);
        return siiImpContabOblNoPres;
    }

    public SiiImpContabOblNoPres removeSiiImpContabOblNoPres(SiiImpContabOblNoPres siiImpContabOblNoPres) {
        getSiiImpContabOblNoPresList().remove(siiImpContabOblNoPres);
        siiImpContabOblNoPres.setSiiObligacionNoPresup(null);
        return siiImpContabOblNoPres;
    }

    @ManyToOne
    @JoinColumn(name = "EON_CODIGO")
    public SiiEstadoObligNoPres getSiiEstadoObligNoPres() {
        return siiEstadoObligNoPres;
    }

    public void setSiiEstadoObligNoPres(SiiEstadoObligNoPres siiEstadoObligNoPres) {
        this.siiEstadoObligNoPres = siiEstadoObligNoPres;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @OneToMany(mappedBy = "siiObligacionNoPresup")
    public List<SiiOrdenPago> getSiiOrdenPagoList() {
        return siiOrdenPagoList;
    }

    public void setSiiOrdenPagoList(List<SiiOrdenPago> siiOrdenPagoList) {
        this.siiOrdenPagoList = siiOrdenPagoList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().add(siiOrdenPago);
        siiOrdenPago.setSiiObligacionNoPresup(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().remove(siiOrdenPago);
        siiOrdenPago.setSiiObligacionNoPresup(null);
        return siiOrdenPago;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_REGISTRA")
    public SiiUsuario getSiiUsuarioRegistra() {
        return siiUsuarioRegistra;
    }

    public void setSiiUsuarioRegistra(SiiUsuario siiUsuarioRegistra) {
        this.siiUsuarioRegistra = siiUsuarioRegistra;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_APRUEBA")
    public SiiUsuario getSiiUsuarioAprueba() {
        return siiUsuarioAprueba;
    }

    public void setSiiUsuarioAprueba(SiiUsuario siiUsuarioAprueba) {
        this.siiUsuarioAprueba = siiUsuarioAprueba;
    }

    @Column(name = "ONP_CONCEPTO", length = 500)
    public String getOnpConcepto() {
        return onpConcepto;
    }

    public void setOnpConcepto(String onpConcepto) {
        this.onpConcepto = onpConcepto;
    }
}
