package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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
@Table(name = "SII_ORDEN_PAGO")
public class SiiOrdenPago implements Serializable {
    private static final long serialVersionUID = -4385056164001235950L;
    private Long orpCodigo;
    private Date orpFecha;
    private String orpMotivoAnula;
    private String orpPagDestFinal;
    private SiiObligacion siiObligacion;
    private SiiCuentaBancaria siiCuentaBancaria;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private SiiEstadoOrdenPago siiEstadoOrdenPago;
    private SiiUsuario siiUsuarioRegistra;
    private SiiUsuario siiUsuarioAprueba;
    private Long oblNumeroRp;
    private SiiProveedor siiProveedor;
    private String orpTipoGasto;
    private BigDecimal orpValorGasto;
    private SiiTipoDocSopSolicPago siiTipoDocSopSolicPago;
    private String orpNumDocSop;
    private SiiObligacionNoPresup siiObligacionNoPresup;
    private SiiTipoDocContable siiTipoDocContable;
    private Integer orpConsecutivo;
    private SiiFuenteFinancContab siiFuenteFinancContab;
    private SiiPersona siiPersonaEndoso;

    public SiiOrdenPago() {
    }

    public SiiOrdenPago(SiiCuentaBancaria siiCuentaBancaria, SiiEstadoOrdenPago siiEstadoOrdenPago, String orpMotivoAnula,
                        SiiObligacion siiObligacion, Long orpCodigo, Date orpFecha, String orpPagDestFinal, SiiUsuario siiUsuarioAprueba,
                        SiiUsuario siiUsuarioRegistra) {
        this.siiCuentaBancaria = siiCuentaBancaria;
        this.siiEstadoOrdenPago = siiEstadoOrdenPago;
        this.siiObligacion = siiObligacion;
        this.orpCodigo = orpCodigo;
        this.orpFecha = orpFecha;
        this.orpMotivoAnula = orpMotivoAnula;
        this.orpPagDestFinal = orpPagDestFinal;
        this.siiUsuarioAprueba = siiUsuarioAprueba;
        this.siiUsuarioRegistra = siiUsuarioRegistra;

    }


    @Id
    @Column(name = "ORP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ORDEN_PAGO_COD")
    @SequenceGenerator(name = "SEQ_ORDEN_PAGO_COD", sequenceName = "SEQ_ORDEN_PAGO_COD",allocationSize=1)
    public Long getOrpCodigo() {
        return orpCodigo;
    }

    public void setOrpCodigo(Long orpCodigo) {
        this.orpCodigo = orpCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ORP_FECHA", nullable = false)
    public Date getOrpFecha() {
        return orpFecha;
    }

    public void setOrpFecha(Date orpFecha) {
        this.orpFecha = orpFecha;
    }

    @Column(name = "ORP_MOTIVO_ANULA", length = 600)
    public String getOrpMotivoAnula() {
        return orpMotivoAnula;
    }

    public void setOrpMotivoAnula(String orpMotivoAnula) {
        this.orpMotivoAnula = orpMotivoAnula;
    }

    @Column(name = "ORP_PAG_DEST_FINAL", nullable = false, length = 1)
    public String getOrpPagDestFinal() {
        return orpPagDestFinal;
    }

    public void setOrpPagDestFinal(String orpPagDestFinal) {
        this.orpPagDestFinal = orpPagDestFinal;
    }

    @ManyToOne
    @JoinColumn(name = "OBL_CODIGO")
    public SiiObligacion getSiiObligacion() {
        return siiObligacion;
    }

    public void setSiiObligacion(SiiObligacion siiObligacion) {
        this.siiObligacion = siiObligacion;
    }

    @ManyToOne
    @JoinColumn(name = "CBA_CODIGO")
    public SiiCuentaBancaria getSiiCuentaBancaria() {
        return siiCuentaBancaria;
    }

    public void setSiiCuentaBancaria(SiiCuentaBancaria siiCuentaBancaria) {
        this.siiCuentaBancaria = siiCuentaBancaria;
    }

    @OneToMany(mappedBy = "siiOrdenPago")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiOrdenPago(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiOrdenPago(null);
        return siiDocumentoContable;
    }

    @ManyToOne
    @JoinColumn(name = "EOP_CODIGO")
    public SiiEstadoOrdenPago getSiiEstadoOrdenPago() {
        return siiEstadoOrdenPago;
    }

    public void setSiiEstadoOrdenPago(SiiEstadoOrdenPago siiEstadoOrdenPago) {
        this.siiEstadoOrdenPago = siiEstadoOrdenPago;
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

    @ManyToOne
    @JoinColumn(name = "PRO_CODIGO")
    public SiiProveedor getSiiProveedor() {
        return siiProveedor;
    }

    public void setSiiProveedor(SiiProveedor siiProveedor) {
        this.siiProveedor = siiProveedor;
    }

    @Column(name = "ORP_NUMERO_RP")
    public Long getOblNumeroRp() {
        return oblNumeroRp;
    }

    public void setOblNumeroRp(Long oblNumeroRp) {
        this.oblNumeroRp = oblNumeroRp;
    }

    @Column(name = "ORP_TIPO_GASTO", nullable = false, length = 2)
    public String getOrpTipoGasto() {
        return orpTipoGasto;
    }

    public void setOrpTipoGasto(String orpTipoGasto) {
        this.orpTipoGasto = orpTipoGasto;
    }

    @Column(name = "ORP_VALOR_GASTO", nullable = false)
    public BigDecimal getOrpValorGasto() {
        return orpValorGasto;
    }

    public void setOrpValorGasto(BigDecimal orpValorGasto) {
        this.orpValorGasto = orpValorGasto;
    }

    @ManyToOne
    @JoinColumn(name = "TSP_CODIGO")
    public SiiTipoDocSopSolicPago getSiiTipoDocSopSolicPago() {
        return siiTipoDocSopSolicPago;
    }

    public void setSiiTipoDocSopSolicPago(SiiTipoDocSopSolicPago siiTipoDocSopSolicPago) {
        this.siiTipoDocSopSolicPago = siiTipoDocSopSolicPago;
    }

    @Column(name = "ORP_NUM_DOC_SOP", nullable = false, length = 20)
    public String getOrpNumDocSop() {
        return orpNumDocSop;
    }

    public void setOrpNumDocSop(String orpNumDocSop) {
        this.orpNumDocSop = orpNumDocSop;
    }

    @ManyToOne
    @JoinColumn(name = "ONP_CODIGO")
    public SiiObligacionNoPresup getSiiObligacionNoPresup() {
        return siiObligacionNoPresup;
    }

    public void setSiiObligacionNoPresup(SiiObligacionNoPresup siiObligacionNoPresup) {
        this.siiObligacionNoPresup = siiObligacionNoPresup;
    }

    @Column(name = "ORP_CONSECUTIVO")
    public Integer getOrpConsecutivo() {
        return orpConsecutivo;
    }

    public void setOrpConsecutivo(Integer orpConsecutivo) {
        this.orpConsecutivo = orpConsecutivo;
    }

    @ManyToOne
    @JoinColumn(name = "TDC_CODIGO")
    public SiiTipoDocContable getSiiTipoDocContable() {
        return siiTipoDocContable;
    }

    public void setSiiTipoDocContable(SiiTipoDocContable siiTipoDocContable) {
        this.siiTipoDocContable = siiTipoDocContable;
    }
    
    @ManyToOne
    @JoinColumn(name = "FFC_CODIGO")
    public SiiFuenteFinancContab getSiiFuenteFinancContab() {
        return siiFuenteFinancContab;
    }

    public void setSiiFuenteFinancContab(SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiFuenteFinancContab = siiFuenteFinancContab;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO_ENDOSO")
    public SiiPersona getSiiPersonaEndoso() {
        return siiPersonaEndoso;
    }

    public void setSiiPersonaEndoso(SiiPersona siiPersonaEndoso) {
        this.siiPersonaEndoso = siiPersonaEndoso;
    }
}
