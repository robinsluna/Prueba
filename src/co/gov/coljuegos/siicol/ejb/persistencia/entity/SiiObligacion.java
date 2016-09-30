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
@Table(name = "SII_OBLIGACION")
public class SiiObligacion implements Serializable {
    private static final long serialVersionUID = 558001954979238780L;
    private SiiEstadoObligacion siiEstadoObligacion;
    private Long oblCodigo;
    private Date oblFecha;
    private BigDecimal oblIva;
    private Integer oblNumero;
    private BigDecimal oblSubtotal;
    private SiiSolicitudPago siiSolicitudPago;
    private SiiUsuario siiUsuarioReg;
    private List<SiiObligacionConcepto> siiObligacionConceptoList;
    private SiiUsuario siiUsuarioApr;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private List<SiiOrdenPago> siiOrdenPagoList;
    private SiiTipoDocContable siiTipoDocContable;
    private List<SiiOblConcRpDetRubCdp> siiOblConcRpDetRubCdpList;
    private SiiCargaNomina siiCargaNomina;
    private List<SiiDetalleContNomina> siiDetalleContNominaList;
    private String oblMotivoAnula;
    private SiiRp siiRp;
    private SiiDistribucionMes siiDistribucionMes;
    private SiiPersona siiPersonaBenefic;
    private SiiDetalleDistrib siiDetalleDistrib;
    private SiiConsolidadoDist siiConsolidadoDist;
    private List<SiiNotaCredito> siiNotaCreditoList;

    public SiiObligacion() {
    }

    public SiiObligacion(SiiEstadoObligacion siiEstadoObligacion, Long oblCodigo, Date oblFecha, Integer oblNumero,
                         SiiSolicitudPago siiSolicitudPago, SiiUsuario siiUsuarioApr, SiiUsuario siiUsuarioReg,
						BigDecimal oblIva, BigDecimal oblSubtotal, SiiTipoDocContable siiTipoDocContable) {
        this.siiEstadoObligacion = siiEstadoObligacion;
        this.oblCodigo = oblCodigo;
        this.oblFecha = oblFecha;
        this.oblIva = oblIva;
        this.oblNumero = oblNumero;
        this.oblSubtotal = oblSubtotal;
        this.siiSolicitudPago = siiSolicitudPago;
        this.siiUsuarioApr = siiUsuarioApr;
        this.siiUsuarioReg = siiUsuarioReg;
        this.siiTipoDocContable = siiTipoDocContable;
    }


    @ManyToOne
    @JoinColumn(name = "EOB_CODIGO")
    public SiiEstadoObligacion getSiiEstadoObligacion() {
        return siiEstadoObligacion;
    }

    public void setSiiEstadoObligacion(SiiEstadoObligacion siiEstadoObligacion) {
        this.siiEstadoObligacion = siiEstadoObligacion;
    }

    @Id
    @Column(name = "OBL_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OBLIGACION_COD")
    @SequenceGenerator(name = "SEQ_OBLIGACION_COD", sequenceName = "SEQ_OBLIGACION_COD",allocationSize=1)
    public Long getOblCodigo() {
        return oblCodigo;
    }

    public void setOblCodigo(Long oblCodigo) {
        this.oblCodigo = oblCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OBL_FECHA", nullable = false)
    public Date getOblFecha() {
        return oblFecha;
    }

    public void setOblFecha(Date oblFecha) {
        this.oblFecha = oblFecha;
    }

    @Column(name = "OBL_IVA")
    public BigDecimal getOblIva() {
        return oblIva;
    }

    public void setOblIva(BigDecimal oblIva) {
        this.oblIva = oblIva;
    }

    @Column(name = "OBL_NUMERO", nullable = false)
    public Integer getOblNumero() {
        return oblNumero;
    }

    public void setOblNumero(Integer oblNumero) {
        this.oblNumero = oblNumero;
    }

    @Column(name = "OBL_SUBTOTAL")
    public BigDecimal getOblSubtotal() {
        return oblSubtotal;
    }

    public void setOblSubtotal(BigDecimal oblSubtotal) {
        this.oblSubtotal = oblSubtotal;
    }


    @ManyToOne
    @JoinColumn(name = "SPA_CODIGO")
    public SiiSolicitudPago getSiiSolicitudPago() {
        return siiSolicitudPago;
    }

    public void setSiiSolicitudPago(SiiSolicitudPago siiSolicitudPago) {
        this.siiSolicitudPago = siiSolicitudPago;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_REGISTRA")
    public SiiUsuario getSiiUsuarioReg() {
        return siiUsuarioReg;
    }

    public void setSiiUsuarioReg(SiiUsuario siiUsuarioReg) {
        this.siiUsuarioReg = siiUsuarioReg;
    }

    @OneToMany(mappedBy = "siiObligacion")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoList() {
        return siiObligacionConceptoList;
    }

    public void setSiiObligacionConceptoList(List<SiiObligacionConcepto> siiObligacionConceptoList) {
        this.siiObligacionConceptoList = siiObligacionConceptoList;
    }

    public SiiObligacionConcepto addSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList().add(siiObligacionConcepto);
        siiObligacionConcepto.setSiiObligacion(this);
        return siiObligacionConcepto;
    }

    public SiiObligacionConcepto removeSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList().remove(siiObligacionConcepto);
        siiObligacionConcepto.setSiiObligacion(null);
        return siiObligacionConcepto;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_APRUEBA", insertable=false, updatable=false)
    public SiiUsuario getSiiUsuarioApr() {
        return siiUsuarioApr;
    }

    public void setSiiUsuarioApr(SiiUsuario siiUsuarioApr) {
        this.siiUsuarioApr = siiUsuarioApr;
    }

    @OneToMany(mappedBy = "siiObligacion")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiObligacion(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiObligacion(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiObligacion")
    public List<SiiOrdenPago> getSiiOrdenPagoList() {
        return siiOrdenPagoList;
    }

    public void setSiiOrdenPagoList(List<SiiOrdenPago> siiOrdenPagoList) {
        this.siiOrdenPagoList = siiOrdenPagoList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().add(siiOrdenPago);
        siiOrdenPago.setSiiObligacion(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().remove(siiOrdenPago);
        siiOrdenPago.setSiiObligacion(null);
        return siiOrdenPago;
    }

    @ManyToOne
    @JoinColumn(name = "TDC_CODIGO")
    public SiiTipoDocContable getSiiTipoDocContable() {
        return siiTipoDocContable;
    }

    public void setSiiTipoDocContable(SiiTipoDocContable siiTipoDocContable) {
        this.siiTipoDocContable = siiTipoDocContable;
    }

    @OneToMany(mappedBy = "siiObligacion")
    public List<SiiOblConcRpDetRubCdp> getSiiOblConcRpDetRubCdpList() {
        return siiOblConcRpDetRubCdpList;
    }

    public void setSiiOblConcRpDetRubCdpList(List<SiiOblConcRpDetRubCdp> siiOblConcRpDetRubCdpList) {
        this.siiOblConcRpDetRubCdpList = siiOblConcRpDetRubCdpList;
    }

    public SiiOblConcRpDetRubCdp addSiiOblConcRpDetRubCdp(SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp) {
        getSiiOblConcRpDetRubCdpList().add(siiOblConcRpDetRubCdp);
        siiOblConcRpDetRubCdp.setSiiObligacion(this);
        return siiOblConcRpDetRubCdp;
    }

    public SiiOblConcRpDetRubCdp removeSiiOblConcRpDetRubCdp(SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp) {
        getSiiOblConcRpDetRubCdpList().remove(siiOblConcRpDetRubCdp);
        siiOblConcRpDetRubCdp.setSiiObligacion(null);
        return siiOblConcRpDetRubCdp;
    }

    @ManyToOne
    @JoinColumn(name = "CNO_CODIGO")
    public SiiCargaNomina getSiiCargaNomina() {
        return siiCargaNomina;
    }

    public void setSiiCargaNomina(SiiCargaNomina siiCargaNomina) {
        this.siiCargaNomina = siiCargaNomina;
    }

    @OneToMany(mappedBy = "siiObligacion")
    public List<SiiDetalleContNomina> getSiiDetalleContNominaList() {
        return siiDetalleContNominaList;
    }

    public void setSiiDetalleContNominaList(List<SiiDetalleContNomina> siiDetalleContNominaList) {
        this.siiDetalleContNominaList = siiDetalleContNominaList;
    }

    public SiiDetalleContNomina addSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().add(siiDetalleContNomina);
        siiDetalleContNomina.setSiiObligacion(this);
        return siiDetalleContNomina;
    }

    public SiiDetalleContNomina removeSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().remove(siiDetalleContNomina);
        siiDetalleContNomina.setSiiObligacion(null);
        return siiDetalleContNomina;
    }

    @Column(name = "OBL_MOTIVO_ANULA", length = 700)
    public String getOblMotivoAnula() {
        return oblMotivoAnula;
    }

    public void setOblMotivoAnula(String oblMotivoAnula) {
        this.oblMotivoAnula = oblMotivoAnula;
    }

    @ManyToOne
    @JoinColumn(name = "RP_CODIGO_TRANSF")
    public SiiRp getSiiRp() {
        return siiRp;
    }

    public void setSiiRp(SiiRp siiRp) {
        this.siiRp = siiRp;
    }

    @ManyToOne
    @JoinColumn(name = "DME_CODIGO")
    public SiiDistribucionMes getSiiDistribucionMes() {
        return siiDistribucionMes;
    }

    public void setSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        this.siiDistribucionMes = siiDistribucionMes;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO_BENEFIC")
    public SiiPersona getSiiPersonaBenefic() {
        return siiPersonaBenefic;
    }

    public void setSiiPersonaBenefic(SiiPersona siiPersonaBenefic) {
        this.siiPersonaBenefic = siiPersonaBenefic;
    }

    @ManyToOne
    @JoinColumn(name = "DDI_CODIGO")
    public SiiDetalleDistrib getSiiDetalleDistrib() {
        return siiDetalleDistrib;
    }

    public void setSiiDetalleDistrib(SiiDetalleDistrib siiDetalleDistrib) {
        this.siiDetalleDistrib = siiDetalleDistrib;
    }

    @ManyToOne
    @JoinColumn(name = "COD_CODIGO")
    public SiiConsolidadoDist getSiiConsolidadoDist() {
        return siiConsolidadoDist;
    }

    public void setSiiConsolidadoDist(SiiConsolidadoDist siiConsolidadoDist) {
        this.siiConsolidadoDist = siiConsolidadoDist;
    }

    @OneToMany(mappedBy = "siiObligacion")
    public List<SiiNotaCredito> getSiiNotaCreditoList() {
        return siiNotaCreditoList;
    }

    public void setSiiNotaCreditoList(List<SiiNotaCredito> siiNotaCreditoList) {
        this.siiNotaCreditoList = siiNotaCreditoList;
    }

    public SiiNotaCredito addSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        getSiiNotaCreditoList().add(siiNotaCredito);
        siiNotaCredito.setSiiObligacion(this);
        return siiNotaCredito;
    }

    public SiiNotaCredito removeSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        getSiiNotaCreditoList().remove(siiNotaCredito);
        siiNotaCredito.setSiiObligacion(null);
        return siiNotaCredito;
    }

}
