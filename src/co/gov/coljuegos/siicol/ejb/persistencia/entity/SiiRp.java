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
@Table(name = "SII_RP")
public class SiiRp implements Serializable {
    private static final long serialVersionUID = -8206291581222802135L;
    private Long rpCodigo;
    private Date rpFechaSolic;
    private List<SiiRpDetRubroCdp> siiRpDetRubroCdpList1;
    private SiiEstadoRp siiEstadoRp;
    private Long rpConsecutivo;
    private Date rpFechaRp;
    private SiiMotivoAnulRp siiMotivoAnulRp;
    private SiiMotivoRechSolRp siiMotivoRechSolRp;
    private SiiCdp siiCdp;
    private List<SiiModificacionRp> siiModificacionRpList;
    private SiiProveedor siiProveedor;
    private List<SiiSolicitudPago> siiSolicitudPagoList;
    private List<SiiObligacionConcepto> siiObligacionConceptoList2;
    private BigDecimal rpSaldoAnterior;
    private Long rpNumeroSiif;
    private List<SiiCdpRp> siiCdpRpList;
    private List<SiiDetalleContNomina> siiDetalleContNominaList;
    private List<SiiObligacion> siiObligacionList;
    private SiiCargaRp siiCargaRp;

    public SiiRp() {
    }

    public SiiRp(SiiEstadoRp siiEstadoRp, SiiMotivoAnulRp siiMotivoAnulRp, SiiMotivoRechSolRp siiMotivoRechSolRp,
		Long rpCodigo, Long rpConsecutivo, Date rpFechaSolic, Date rpFechaRp, SiiCdp siiCdp,
		SiiProveedor siiProveedor, BigDecimal rpSaldoAnterior, Long rpNumeroSiif) {
        this.siiEstadoRp = siiEstadoRp;
        this.siiMotivoAnulRp = siiMotivoAnulRp;
        this.siiMotivoRechSolRp = siiMotivoRechSolRp;
        this.rpCodigo = rpCodigo;
        this.rpConsecutivo = rpConsecutivo;
        this.rpFechaRp = rpFechaRp;
        this.rpFechaSolic = rpFechaSolic;
        this.siiCdp = siiCdp;
        this.siiProveedor = siiProveedor;
        this.rpSaldoAnterior = rpSaldoAnterior;
        this.rpNumeroSiif = rpNumeroSiif;
    }

    @Id
    @Column(name = "RP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RP_CODIGO")
    @SequenceGenerator(name = "SEQ_RP_CODIGO", sequenceName = "SEQ_RP_CODIGO",allocationSize=1)
    public Long getRpCodigo() {
        return rpCodigo;
    }

    public void setRpCodigo(Long rpCodigo) {
        this.rpCodigo = rpCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RP_FECHA_SOLIC", nullable = false)
    public Date getRpFechaSolic() {
        return rpFechaSolic;
    }

    public void setRpFechaSolic(Date rpFechaSolic) {
        this.rpFechaSolic = rpFechaSolic;
    }

    @OneToMany(mappedBy = "siiRp")
    public List<SiiRpDetRubroCdp> getSiiRpDetRubroCdpList1() {
        return siiRpDetRubroCdpList1;
    }

    public void setSiiRpDetRubroCdpList1(List<SiiRpDetRubroCdp> siiRpDetRubroCdpList1) {
        this.siiRpDetRubroCdpList1 = siiRpDetRubroCdpList1;
    }

    public SiiRpDetRubroCdp addSiiRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) {
        getSiiRpDetRubroCdpList1().add(siiRpDetRubroCdp);
        siiRpDetRubroCdp.setSiiRp(this);
        return siiRpDetRubroCdp;
    }

    public SiiRpDetRubroCdp removeSiiRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) {
        getSiiRpDetRubroCdpList1().remove(siiRpDetRubroCdp);
        siiRpDetRubroCdp.setSiiRp(null);
        return siiRpDetRubroCdp;
    }

    @ManyToOne
    @JoinColumn(name = "ERP_CODIGO")
    public SiiEstadoRp getSiiEstadoRp() {
        return siiEstadoRp;
    }

    public void setSiiEstadoRp(SiiEstadoRp siiEstadoRp) {
        this.siiEstadoRp = siiEstadoRp;
    }

    @Column(name = "RP_CONSECUTIVO")
    public Long getRpConsecutivo() {
        return rpConsecutivo;
    }

    public void setRpConsecutivo(Long rpConsecutivo) {
        this.rpConsecutivo = rpConsecutivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RP_FECHA_RP")
    public Date getRpFechaRp() {
        return rpFechaRp;
    }

    public void setRpFechaRp(Date rpFechaRp) {
        this.rpFechaRp = rpFechaRp;
    }

    @ManyToOne
    @JoinColumn(name = "MAN_CODIGO")
    public SiiMotivoAnulRp getSiiMotivoAnulRp() {
        return siiMotivoAnulRp;
    }

    public void setSiiMotivoAnulRp(SiiMotivoAnulRp siiMotivoAnulRp) {
        this.siiMotivoAnulRp = siiMotivoAnulRp;
    }

    @ManyToOne
    @JoinColumn(name = "MRS_CODIGO")
    public SiiMotivoRechSolRp getSiiMotivoRechSolRp() {
        return siiMotivoRechSolRp;
    }

    public void setSiiMotivoRechSolRp(SiiMotivoRechSolRp siiMotivoRechSolRp) {
        this.siiMotivoRechSolRp = siiMotivoRechSolRp;
    }

    @ManyToOne
    @JoinColumn(name = "CDP_CODIGO")
    public SiiCdp getSiiCdp() {
        return siiCdp;
    }

    public void setSiiCdp(SiiCdp siiCdp) {
        this.siiCdp = siiCdp;
    }

    @OneToMany(mappedBy = "siiRp1")
    public List<SiiModificacionRp> getSiiModificacionRpList() {
        return siiModificacionRpList;
    }

    public void setSiiModificacionRpList(List<SiiModificacionRp> siiModificacionRpList) {
        this.siiModificacionRpList = siiModificacionRpList;
    }

    public SiiModificacionRp addSiiModificacionRp(SiiModificacionRp siiModificacionRp) {
        getSiiModificacionRpList().add(siiModificacionRp);
        siiModificacionRp.setSiiRp1(this);
        return siiModificacionRp;
    }

    public SiiModificacionRp removeSiiModificacionRp(SiiModificacionRp siiModificacionRp) {
        getSiiModificacionRpList().remove(siiModificacionRp);
        siiModificacionRp.setSiiRp1(null);
        return siiModificacionRp;
    }

    @ManyToOne
    @JoinColumn(name = "PRO_CODIGO")
    public SiiProveedor getSiiProveedor() {
        return siiProveedor;
    }

    public void setSiiProveedor(SiiProveedor siiProveedor) {
        this.siiProveedor = siiProveedor;
    }

    @OneToMany(mappedBy = "siiRp")
    public List<SiiSolicitudPago> getSiiSolicitudPagoList() {
        return siiSolicitudPagoList;
    }

    public void setSiiSolicitudPagoList(List<SiiSolicitudPago> siiSolicitudPagoList) {
        this.siiSolicitudPagoList = siiSolicitudPagoList;
    }

    public SiiSolicitudPago addSiiSolicitudPago(SiiSolicitudPago siiSolicitudPago) {
        getSiiSolicitudPagoList().add(siiSolicitudPago);
        siiSolicitudPago.setSiiRp(this);
        return siiSolicitudPago;
    }

    public SiiSolicitudPago removeSiiSolicitudPago(SiiSolicitudPago siiSolicitudPago) {
        getSiiSolicitudPagoList().remove(siiSolicitudPago);
        siiSolicitudPago.setSiiRp(null);
        return siiSolicitudPago;
    }

    @OneToMany(mappedBy = "siiRp")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoList2() {
        return siiObligacionConceptoList2;
    }

    public void setSiiObligacionConceptoList2(List<SiiObligacionConcepto> siiObligacionConceptoList2) {
        this.siiObligacionConceptoList2 = siiObligacionConceptoList2;
    }

    public SiiObligacionConcepto addSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList2().add(siiObligacionConcepto);
        siiObligacionConcepto.setSiiRp(this);
        return siiObligacionConcepto;
    }

    public SiiObligacionConcepto removeSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList2().remove(siiObligacionConcepto);
        siiObligacionConcepto.setSiiRp(null);
        return siiObligacionConcepto;
    }

    @Column(name = "RP_SALDO_ANTERIOR")
    public BigDecimal getRpSaldoAnterior() {
        return rpSaldoAnterior;
    }

    public void setRpSaldoAnterior(BigDecimal rpSaldoAnterior) {
        this.rpSaldoAnterior = rpSaldoAnterior;
    }

    @Column(name = "RP_NUMERO_SIIF")
    public Long getRpNumeroSiif() {
        return rpNumeroSiif;
    }

    public void setRpNumeroSiif(Long rpNumeroSiif) {
        this.rpNumeroSiif = rpNumeroSiif;
    }

    @OneToMany(mappedBy = "siiRp")
    public List<SiiCdpRp> getSiiCdpRpList() {
        return siiCdpRpList;
    }

    public void setSiiCdpRpList(List<SiiCdpRp> siiCdpRpList) {
        this.siiCdpRpList = siiCdpRpList;
    }

    public SiiCdpRp addSiiCdpRp(SiiCdpRp siiCdpRp) {
        getSiiCdpRpList().add(siiCdpRp);
        siiCdpRp.setSiiRp(this);
        return siiCdpRp;
    }

    public SiiCdpRp removeSiiCdpRp(SiiCdpRp siiCdpRp) {
        getSiiCdpRpList().remove(siiCdpRp);
        siiCdpRp.setSiiRp(null);
        return siiCdpRp;
    }

    @OneToMany(mappedBy = "siiRp")
    public List<SiiDetalleContNomina> getSiiDetalleContNominaList() {
        return siiDetalleContNominaList;
    }

    public void setSiiDetalleContNominaList(List<SiiDetalleContNomina> siiDetalleContNominaList) {
        this.siiDetalleContNominaList = siiDetalleContNominaList;
    }

    public SiiDetalleContNomina addSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().add(siiDetalleContNomina);
        siiDetalleContNomina.setSiiRp(this);
        return siiDetalleContNomina;
    }

    public SiiDetalleContNomina removeSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().remove(siiDetalleContNomina);
        siiDetalleContNomina.setSiiRp(null);
        return siiDetalleContNomina;
    }

    @OneToMany(mappedBy = "siiRp")
    public List<SiiObligacion> getSiiObligacionList() {
        return siiObligacionList;
    }

    public void setSiiObligacionList(List<SiiObligacion> siiObligacionList) {
        this.siiObligacionList = siiObligacionList;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().add(siiObligacion);
        siiObligacion.setSiiRp(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().remove(siiObligacion);
        siiObligacion.setSiiRp(null);
        return siiObligacion;
    }

    @ManyToOne
    @JoinColumn(name = "CRP_CODIGO")
    public SiiCargaRp getSiiCargaRp() {
        return siiCargaRp;
    }

    public void setSiiCargaRp(SiiCargaRp siiCargaRp) {
        this.siiCargaRp = siiCargaRp;
    }
}
