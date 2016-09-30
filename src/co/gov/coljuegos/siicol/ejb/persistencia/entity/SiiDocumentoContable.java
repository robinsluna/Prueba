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
@Table(name = "SII_DOCUMENTO_CONTABLE")
public class SiiDocumentoContable implements Serializable {
    private static final long serialVersionUID = 8472566787233367012L;
    private Long dcoCodigo;
    private String dcoConcepto;
    private Date dcoFechaOper;
    private String dcoMotivoAnula;
    private Integer dcoNumeroCompr;
    private List<SiiImputacionContable> siiImputacionContableList;
    private SiiObligacion siiObligacion;
    private SiiTipoDocContable siiTipoDocContable;
    private SiiOrdenPago siiOrdenPago;
    private SiiDetalleRecaudo siiDetalleRecaudo;
    private BigDecimal dcoValor;
    private SiiEstadoDocContab siiEstadoDocContab;
    private SiiInteresCuota siiInteresCuota;
    private SiiUsuario siiUsuarioAprueba;
    private SiiUsuario siiUsuarioRegistra;
    private SiiAjuste siiAjuste;
    private SiiLiquidacionMes siiLiquidacionMesDE;
    private SiiLiquidacionMes siiLiquidacionMesGA;
    private SiiCierreAnualContable siiCierreAnualContable;
    private SiiCargaDocumentoCont siiCargaDocumentoCont;
    private SiiTrasladoBancario siiTrasladoBancario;
    private SiiNotaCredito siiNotaCredito;
    private SiiReintegroIngresoPag siiReintegroIngresoPag;
    private SiiPolizaContrat siiPolizaContrat;
    private SiiTerminacionAnticip siiTerminacionAnticip;
    private SiiIncumplimientoContr siiIncumplimientoContr;
    private List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList;
    private SiiProcesoSancionatorio siiProcesoSancionatorio;
    private SiiModifEstadoDocContab siiModifEstadoDocContab;
    private SiiProcesoSancIlegalidad siiProcesoSancIlegalidad;

    public SiiDocumentoContable() {
    }

    public SiiDocumentoContable(Long dcoCodigo, Integer dcoNumeroCompr, SiiObligacion siiObligacion, Date dcoFechaOper,
                                SiiTipoDocContable siiTipoDocContable, SiiOrdenPago siiOrdenPago, SiiDetalleRecaudo siiDetalleRecaudo,
								String dcoConcepto, BigDecimal dcoValor, String dcoMotivoAnula, SiiEstadoDocContab siiEstadoDocContab) {
        this.dcoCodigo = dcoCodigo;
        this.dcoConcepto = dcoConcepto;
        this.dcoFechaOper = dcoFechaOper;
        this.dcoMotivoAnula = dcoMotivoAnula;
        this.dcoNumeroCompr = dcoNumeroCompr;
        this.siiObligacion = siiObligacion;
        this.siiTipoDocContable = siiTipoDocContable;
        this.siiOrdenPago = siiOrdenPago;
        this.siiDetalleRecaudo = siiDetalleRecaudo;
        this.dcoValor = dcoValor;
        this.siiEstadoDocContab = siiEstadoDocContab;

    }

    @Id
    @Column(name = "DCO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DOCUM_CONTABLE_COD")
    @SequenceGenerator(name = "SEQ_DOCUM_CONTABLE_COD", sequenceName = "SEQ_DOCUM_CONTABLE_COD",allocationSize=1)
    public Long getDcoCodigo() {
        return dcoCodigo;
    }

    public void setDcoCodigo(Long dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }
    @Column(name = "DCO_CONCEPTO", length = 300)
    public String getDcoConcepto() {
        return dcoConcepto;
    }

    public void setDcoConcepto(String dcoConcepto) {
        this.dcoConcepto = dcoConcepto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DCO_FECHA_OPER", nullable = false)
    public Date getDcoFechaOper() {
        return dcoFechaOper;
    }

    public void setDcoFechaOper(Date dcoFechaOper) {
        this.dcoFechaOper = dcoFechaOper;
    }

    @Column(name = "DCO_MOTIVO_ANULA", length = 600)
    public String getDcoMotivoAnula() {
        return dcoMotivoAnula;
    }

    public void setDcoMotivoAnula(String dcoMotivoAnula) {
        this.dcoMotivoAnula = dcoMotivoAnula;
    }

    @Column(name = "DCO_NUMERO_COMPR", nullable = false)
    public Integer getDcoNumeroCompr() {
        return dcoNumeroCompr;
    }

    public void setDcoNumeroCompr(Integer dcoNumeroCompr) {
        this.dcoNumeroCompr = dcoNumeroCompr;
    }

    @Column(name = "DCO_VALOR")
    public BigDecimal getDcoValor() {
        return dcoValor;
    }

    public void setDcoValor(BigDecimal dcoValor) {
        this.dcoValor = dcoValor;
    }

    @OneToMany(mappedBy = "siiDocumentoContable")
    public List<SiiImputacionContable> getSiiImputacionContableList() {
        return siiImputacionContableList;
    }

    public void setSiiImputacionContableList(List<SiiImputacionContable> siiImputacionContableList) {
        this.siiImputacionContableList = siiImputacionContableList;
    }

    public SiiImputacionContable addSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().add(siiImputacionContable);
        siiImputacionContable.setSiiDocumentoContable(this);
        return siiImputacionContable;
    }

    public SiiImputacionContable removeSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().remove(siiImputacionContable);
        siiImputacionContable.setSiiDocumentoContable(null);
        return siiImputacionContable;
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
    @JoinColumn(name = "TDC_CODIGO")
    public SiiTipoDocContable getSiiTipoDocContable() {
        return siiTipoDocContable;
    }

    public void setSiiTipoDocContable(SiiTipoDocContable siiTipoDocContable) {
        this.siiTipoDocContable = siiTipoDocContable;
    }

    @ManyToOne
    @JoinColumn(name = "ORP_CODIGO")
    public SiiOrdenPago getSiiOrdenPago() {
        return siiOrdenPago;
    }

    public void setSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        this.siiOrdenPago = siiOrdenPago;
    }

    @ManyToOne
    @JoinColumn(name = "DRE_CODIGO")
    public SiiDetalleRecaudo getSiiDetalleRecaudo() {
        return siiDetalleRecaudo;
    }

    public void setSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        this.siiDetalleRecaudo = siiDetalleRecaudo;
    }

    @ManyToOne
    @JoinColumn(name = "EDO_CODIGO")
    public SiiEstadoDocContab getSiiEstadoDocContab() {
        return siiEstadoDocContab;
    }

    public void setSiiEstadoDocContab(SiiEstadoDocContab siiEstadoDocContab) {
        this.siiEstadoDocContab = siiEstadoDocContab;
    }

    @ManyToOne
    @JoinColumn(name = "ICU_CODIGO")
    public SiiInteresCuota getSiiInteresCuota() {
        return siiInteresCuota;
    }

    public void setSiiInteresCuota(SiiInteresCuota siiInteresCuota) {
        this.siiInteresCuota = siiInteresCuota;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_APR")
    public SiiUsuario getSiiUsuarioAprueba() {
        return siiUsuarioAprueba;
    }

    public void setSiiUsuarioAprueba(SiiUsuario siiUsuarioAprueba) {
        this.siiUsuarioAprueba = siiUsuarioAprueba;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_REG")
    public SiiUsuario getSiiUsuarioRegistra() {
        return siiUsuarioRegistra;
    }

    public void setSiiUsuarioRegistra(SiiUsuario siiUsuarioRegistra) {
        this.siiUsuarioRegistra = siiUsuarioRegistra;
    }

    @ManyToOne
    @JoinColumn(name = "AJU_CODIGO")
    public SiiAjuste getSiiAjuste() {
        return siiAjuste;
    }

    public void setSiiAjuste(SiiAjuste siiAjuste) {
        this.siiAjuste = siiAjuste;
    }

    @ManyToOne
    @JoinColumn(name = "LME_CODIGO_DE")
    public SiiLiquidacionMes getSiiLiquidacionMesDE() {
        return siiLiquidacionMesDE;
    }

    public void setSiiLiquidacionMesDE(SiiLiquidacionMes siiLiquidacionMesDE) {
        this.siiLiquidacionMesDE = siiLiquidacionMesDE;
    }

    @ManyToOne
    @JoinColumn(name = "LME_CODIGO_GA")
    public SiiLiquidacionMes getSiiLiquidacionMesGA() {
        return siiLiquidacionMesGA;
    }

    public void setSiiLiquidacionMesGA(SiiLiquidacionMes siiLiquidacionMesGA) {
        this.siiLiquidacionMesGA = siiLiquidacionMesGA;
    }

    @ManyToOne
    @JoinColumn(name = "CAC_CODIGO")
    public SiiCierreAnualContable getSiiCierreAnualContable() {
        return siiCierreAnualContable;
    }

    public void setSiiCierreAnualContable(SiiCierreAnualContable siiCierreAnualContable) {
        this.siiCierreAnualContable = siiCierreAnualContable;
    }
    
    @ManyToOne
    @JoinColumn(name = "CDC_CODIGO")
    public SiiCargaDocumentoCont getSiiCargaDocumentoCont() {
        return siiCargaDocumentoCont;
    }

    public void setSiiCargaDocumentoCont(SiiCargaDocumentoCont siiCargaDocumentoCont) {
        this.siiCargaDocumentoCont = siiCargaDocumentoCont;
    }

    @ManyToOne
    @JoinColumn(name = "TBA_CODIGO")
    public SiiTrasladoBancario getSiiTrasladoBancario() {
        return siiTrasladoBancario;
    }

    public void setSiiTrasladoBancario(SiiTrasladoBancario siiTrasladoBancario) {
        this.siiTrasladoBancario = siiTrasladoBancario;
    }

    @ManyToOne
    @JoinColumn(name = "NCR_CODIGO")
    public SiiNotaCredito getSiiNotaCredito() {
        return siiNotaCredito;
    }

    public void setSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        this.siiNotaCredito = siiNotaCredito;
    }

    @ManyToOne
    @JoinColumn(name = "RIP_CODIGO")
    public SiiReintegroIngresoPag getSiiReintegroIngresoPag() {
        return siiReintegroIngresoPag;
    }

    public void setSiiReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) {
        this.siiReintegroIngresoPag = siiReintegroIngresoPag;
    }
    
    @ManyToOne
    @JoinColumn(name = "PCC_CODIGO")
    public SiiPolizaContrat getSiiPolizaContrat() {
        return siiPolizaContrat;
    }

    public void setSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        this.siiPolizaContrat = siiPolizaContrat;
    }

    @ManyToOne
    @JoinColumn(name = "TAN_CODIGO")
    public SiiTerminacionAnticip getSiiTerminacionAnticip() {
        return siiTerminacionAnticip;
    }

    public void setSiiTerminacionAnticip(SiiTerminacionAnticip siiTerminacionAnticip) {
        this.siiTerminacionAnticip = siiTerminacionAnticip;
    }

    @ManyToOne
    @JoinColumn(name = "ICN_CODIGO")
    public SiiIncumplimientoContr getSiiIncumplimientoContr() {
        return siiIncumplimientoContr;
    }

    public void setSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        this.siiIncumplimientoContr = siiIncumplimientoContr;
    }
    
    @OneToMany(mappedBy = "siiDocumentoContable")
    public List<SiiCargaActuacionesAdm> getSiiCargaActuacionesAdmList() {
        return siiCargaActuacionesAdmList;
    }

    public void setSiiCargaActuacionesAdmList(List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList) {
        this.siiCargaActuacionesAdmList = siiCargaActuacionesAdmList;
    }

    public SiiCargaActuacionesAdm addSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().add(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiDocumentoContable(this);
        return siiCargaActuacionesAdm;
    }

    public SiiCargaActuacionesAdm removeSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().remove(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiDocumentoContable(null);
        return siiCargaActuacionesAdm;
    }

    @ManyToOne
    @JoinColumn(name = "PSA_CODIGO")
    public SiiProcesoSancionatorio getSiiProcesoSancionatorio() {
        return siiProcesoSancionatorio;
    }

    public void setSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }

    @ManyToOne
    @JoinColumn(name = "MEC_CODIGO")
    public SiiModifEstadoDocContab getSiiModifEstadoDocContab() {
        return siiModifEstadoDocContab;
    }

    public void setSiiModifEstadoDocContab(SiiModifEstadoDocContab siiModifEstadoDocContab) {
        this.siiModifEstadoDocContab = siiModifEstadoDocContab;
    }

    @ManyToOne
    @JoinColumn(name = "PRS_CODIGO")
    public SiiProcesoSancIlegalidad getSiiProcesoSancIlegalidad() {
        return siiProcesoSancIlegalidad;
    }

    public void setSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
    }
}
