package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SII_CONTRATO")
public class SiiContrato implements Serializable {
    private static final long serialVersionUID = -7538243780949787517L;
    private Long conCodigo;
    private String conDescripcion;
    private String conExpedienteUrl;
    private Date conFecha;
    private Date conFechaCitFirOpe;
    private Date conFechaFin;
    private Date conFechaFirColj;
    private Date conFechaFirOpe;
    private Date conFechaIni;
    private Date conFechaPrgFirOpe;
    private Date conFechaRegistro;
    private Date conFechaRevAbog;
    private String conNumero;
    private SiiOperador siiOperador;
    private List<SiiNovedad> siiNovedadList;
    private SiiEstadoContrato siiEstadoContrato;
    private List<SiiPolizaContrat> siiPolizaContratList3;
    private String conVigente;
    private Integer conConsecutivo;
    private String conTextoValFinan;
    private String conTextoValGct;
    private String conPermiso;
    private List<SiiRevisionFinan> siiRevisionFinanList;
    private List<SiiRevisionGct> siiRevisionGctList;
    private SiiContrato siiContratoCedente;
    private List<SiiContrato> siiContratosCedidosList;
    private Date conFechaCesion;
    private BigDecimal conValorEstimado;
    private SiiArchivoFisico siiArchivoFisico;
    private String conTextoValCca;
    private List<SiiLiquidacionContrato> siiLiquidacionContratoList;
    private String conEsRenovacion;
    private Date conFechaFinDefin;
    private List<SiiLiquidacionMes> siiLiquidacionMesList;
    private List<SiiInformeSupervision> siiInformeSupervisionList;
    private List<SiiAutoComisorio> siiAutoComisorioList;
    private List<SiiTerminacionAnticip> siiTerminacionAnticipList;
    private List<SiiSuspensionContr> siiSuspensionContrList;
    private List<SiiReporteVentas> siiReporteVentasList;
    private List<SiiProcesoSancionatorio> siiProcesoSancionatorioList;
    private List<SiiVentasMet> siiVentasMetList;
    private List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList;



    public SiiContrato() {
    }

    public SiiContrato(Long conCodigo, String conDescripcion, Date conFechaFin, Date conFechaIni, String conNumero,
                       SiiEstadoContrato siiEstadoContrato, SiiOperador siiOperador, Date conFecha) {
        this.conCodigo = conCodigo;
        this.conDescripcion = conDescripcion;
        this.conFecha = conFecha;
        this.conFechaFin = conFechaFin;
        this.conFechaIni = conFechaIni;
        this.conNumero = conNumero;
        this.siiOperador = siiOperador;
        this.siiEstadoContrato = siiEstadoContrato;
    }

    @Id
    @Column(name = "CON_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONTRATO_COD")
    @SequenceGenerator(name = "SEQ_CONTRATO_COD", sequenceName = "SEQ_CONTRATO_COD",allocationSize=1)
    public Long getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(Long conCodigo) {
        this.conCodigo = conCodigo;
    }

    @Column(name = "CON_CONSECUTIVO")
    public Integer getConConsecutivo() {
        return conConsecutivo;
    }

    public void setConConsecutivo(Integer conConsecutivo) {
        this.conConsecutivo = conConsecutivo;
    }

    @Column(name = "CON_DESCRIPCION", nullable = false, length = 400)
    public String getConDescripcion() {
        return conDescripcion;
    }

    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA")
    public Date getConFecha() {
        return conFecha;
    }

    public void setConFecha(Date conFecha) {
        this.conFecha = conFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_FIN", nullable = false)
    public Date getConFechaFin() {
        return conFechaFin;
    }

    public void setConFechaFin(Date conFechaFin) {
        this.conFechaFin = conFechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_INI", nullable = false)
    public Date getConFechaIni() {
        return conFechaIni;
    }

    public void setConFechaIni(Date conFechaIni) {
        this.conFechaIni = conFechaIni;
    }

    @Column(name = "CON_NUMERO", nullable = false, length = 100)
    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }


    @ManyToOne
    @JoinColumn(name = "OPE_CODIGO")
    public SiiOperador getSiiOperador() {
        return siiOperador;
    }

    public void setSiiOperador(SiiOperador siiOperador) {
        this.siiOperador = siiOperador;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiNovedad> getSiiNovedadList() {
        return siiNovedadList;
    }

    public void setSiiNovedadList(List<SiiNovedad> siiNovedadList) {
        this.siiNovedadList = siiNovedadList;
    }

    public SiiNovedad addSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().add(siiNovedad);
        siiNovedad.setSiiContrato(this);
        return siiNovedad;
    }

    public SiiNovedad removeSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().remove(siiNovedad);
        siiNovedad.setSiiContrato(null);
        return siiNovedad;
    }

    @ManyToOne
    @JoinColumn(name = "ECO_CODIGO")
    public SiiEstadoContrato getSiiEstadoContrato() {
        return siiEstadoContrato;
    }

    public void setSiiEstadoContrato(SiiEstadoContrato siiEstadoContrato) {
        this.siiEstadoContrato = siiEstadoContrato;
    }
    @OneToMany(mappedBy = "siiContrato")
    public List<SiiPolizaContrat> getSiiPolizaContratList3() {
        return siiPolizaContratList3;
    }

    public void setSiiPolizaContratList3(List<SiiPolizaContrat> siiPolizaContratList3) {
        this.siiPolizaContratList3 = siiPolizaContratList3;
    }

    public SiiPolizaContrat addSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList3().add(siiPolizaContrat);
        siiPolizaContrat.setSiiContrato(this);
        return siiPolizaContrat;
    }

    public SiiPolizaContrat removeSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList3().remove(siiPolizaContrat);
        siiPolizaContrat.setSiiContrato(null);
        return siiPolizaContrat;
    }

    @Column(name = "CON_VIGENTE", length = 1)
    public String getConVigente() {
        return conVigente;
    }

    public void setConVigente(String conVigente) {
        this.conVigente = conVigente;
    }

    @Column(name = "CON_EXPEDIENTE_URL", length = 200)
    public String getConExpedienteUrl() {
        return conExpedienteUrl;
    }

    public void setConExpedienteUrl(String conExpedienteUrl) {
        this.conExpedienteUrl = conExpedienteUrl;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_CIT_FIR_OPE")
    public Date getConFechaCitFirOpe() {
        return conFechaCitFirOpe;
    }

    public void setConFechaCitFirOpe(Date conFechaCitFirOpe) {
        this.conFechaCitFirOpe = conFechaCitFirOpe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_FIR_COLJ")
    public Date getConFechaFirColj() {
        return conFechaFirColj;
    }

    public void setConFechaFirColj(Date conFechaFirColj) {
        this.conFechaFirColj = conFechaFirColj;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_FIR_OPE")
    public Date getConFechaFirOpe() {
        return conFechaFirOpe;
    }

    public void setConFechaFirOpe(Date conFechaFirOpe) {
        this.conFechaFirOpe = conFechaFirOpe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_PRG_FIR_OPE")
    public Date getConFechaPrgFirOpe() {
        return conFechaPrgFirOpe;
    }

    public void setConFechaPrgFirOpe(Date conFechaPrgFirOpe) {
        this.conFechaPrgFirOpe = conFechaPrgFirOpe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_REGISTRO", nullable = false)
    public Date getConFechaRegistro() {
        return conFechaRegistro;
    }

    public void setConFechaRegistro(Date conFechaRegistro) {
        this.conFechaRegistro = conFechaRegistro;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_REV_ABOG")
    public Date getConFechaRevAbog() {
        return conFechaRevAbog;
    }

    public void setConFechaRevAbog(Date conFechaRevAbog) {
        this.conFechaRevAbog = conFechaRevAbog;
    }

    @Column(name = "CON_PERMISO", length = 10)
    public String getConPermiso() {
        return conPermiso;
    }

    public void setConPermiso(String conPermiso) {
        this.conPermiso = conPermiso;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiRevisionFinan> getSiiRevisionFinanList() {
        return siiRevisionFinanList;
    }

    public void setSiiRevisionFinanList(List<SiiRevisionFinan> siiRevisionFinanList) {
        this.siiRevisionFinanList = siiRevisionFinanList;
    }

    public SiiRevisionFinan addSiiRevisionFinan(SiiRevisionFinan siiRevisionFinan) {
        getSiiRevisionFinanList().add(siiRevisionFinan);
        siiRevisionFinan.setSiiContrato(this);
        return siiRevisionFinan;
    }

    public SiiRevisionFinan removeSiiRevisionFinan(SiiRevisionFinan siiRevisionFinan) {
        getSiiRevisionFinanList().remove(siiRevisionFinan);
        siiRevisionFinan.setSiiContrato(null);
        return siiRevisionFinan;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiRevisionGct> getSiiRevisionGctList() {
        return siiRevisionGctList;
    }

    public void setSiiRevisionGctList(List<SiiRevisionGct> siiRevisionGctList) {
        this.siiRevisionGctList = siiRevisionGctList;
    }

    public SiiRevisionGct addSiiRevisionGct(SiiRevisionGct siiRevisionGct) {
        getSiiRevisionGctList().add(siiRevisionGct);
        siiRevisionGct.setSiiContrato(this);
        return siiRevisionGct;
    }

    public SiiRevisionGct removeSiiRevisionGct(SiiRevisionGct siiRevisionGct) {
        getSiiRevisionGctList().remove(siiRevisionGct);
        siiRevisionGct.setSiiContrato(null);
        return siiRevisionGct;
    }
    @Column(name = "CON_TEXTO_VAL_FINAN", length = 1500)
    public String getConTextoValFinan() {
        return conTextoValFinan;
    }

    public void setConTextoValFinan(String conTextoValFinan) {
        this.conTextoValFinan = conTextoValFinan;
    }

    @Column(name = "CON_TEXTO_VAL_GCT", length = 1500)
    public String getConTextoValGct() {
        return conTextoValGct;
    }

    public void setConTextoValGct(String conTextoValGct) {
        this.conTextoValGct = conTextoValGct;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO_CEDENTE")
    public SiiContrato getSiiContratoCedente() {
        return siiContratoCedente;
    }

    public void setSiiContratoCedente(SiiContrato siiContratoCedente) {
        this.siiContratoCedente = siiContratoCedente;
    }

    @OneToMany(mappedBy = "siiContratoCedente")
    public List<SiiContrato> getSiiContratosCedidosList() {
        return siiContratosCedidosList;
    }

    public void setSiiContratosCedidosList(List<SiiContrato> siiContratosCedidosList) {
        this.siiContratosCedidosList = siiContratosCedidosList;
    }

    public SiiContrato addSiiContrato(SiiContrato siiContrato) {
        getSiiContratosCedidosList().add(siiContrato);
        siiContrato.setSiiContratoCedente(this);
        return siiContrato;
    }

    public SiiContrato removeSiiContrato(SiiContrato siiContrato) {
        getSiiContratosCedidosList().remove(siiContrato);
        siiContrato.setSiiContratoCedente(null);
        return siiContrato;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_CESION")
    public Date getConFechaCesion() {
        return conFechaCesion;
    }
    
    public void setConFechaCesion(Date conFechaCesion) {
        this.conFechaCesion = conFechaCesion;
    }

    @Column(name = "CON_VALOR_ESTIMADO")
    public BigDecimal getConValorEstimado() {
        return conValorEstimado;
    }

    public void setConValorEstimado(BigDecimal conValorEstimado) {
        this.conValorEstimado = conValorEstimado;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @Column(name = "CON_TEXTO_VAL_CCA", length = 1500)
    public String getConTextoValCca() {
        return conTextoValCca;
    }

    public void setConTextoValCca(String conTextoValCca) {
        this.conTextoValCca = conTextoValCca;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiLiquidacionContrato> getSiiLiquidacionContratoList() {
        return siiLiquidacionContratoList;
    }

    public void setSiiLiquidacionContratoList(List<SiiLiquidacionContrato> siiLiquidacionContratoList) {
        this.siiLiquidacionContratoList = siiLiquidacionContratoList;
    }

    public SiiLiquidacionContrato addSiiLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) {
        getSiiLiquidacionContratoList().add(siiLiquidacionContrato);
        siiLiquidacionContrato.setSiiContrato(this);
        return siiLiquidacionContrato;
    }

    public SiiLiquidacionContrato removeSiiLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) {
        getSiiLiquidacionContratoList().remove(siiLiquidacionContrato);
        siiLiquidacionContrato.setSiiContrato(null);
        return siiLiquidacionContrato;
    }
    
    @Column(name = "CON_ES_RENOVACION", length = 1)
    public String getConEsRenovacion() {
        return conEsRenovacion;
    }

    public void setConEsRenovacion(String conEsRenovacion) {
        this.conEsRenovacion = conEsRenovacion;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CON_FECHA_FIN_DEFIN", nullable = false)
    public Date getConFechaFinDefin() {
        return conFechaFinDefin;
    }

    public void setConFechaFinDefin(Date conFechaFinDefin) {
        this.conFechaFinDefin = conFechaFinDefin;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiLiquidacionMes> getSiiLiquidacionMesList() {
        return siiLiquidacionMesList;
    }

    public void setSiiLiquidacionMesList(List<SiiLiquidacionMes> siiLiquidacionMesList) {
        this.siiLiquidacionMesList = siiLiquidacionMesList;
    }

    public SiiLiquidacionMes addSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) {
        getSiiLiquidacionMesList().add(siiLiquidacionMes);
        siiLiquidacionMes.setSiiContrato(this);
        return siiLiquidacionMes;
    }

    public SiiLiquidacionMes removeSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) {
        getSiiLiquidacionMesList().remove(siiLiquidacionMes);
        siiLiquidacionMes.setSiiContrato(null);
        return siiLiquidacionMes;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiInformeSupervision> getSiiInformeSupervisionList() {
        return siiInformeSupervisionList;
    }

    public void setSiiInformeSupervisionList(List<SiiInformeSupervision> siiInformeSupervisionList) {
        this.siiInformeSupervisionList = siiInformeSupervisionList;
    }

    public SiiInformeSupervision addSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        getSiiInformeSupervisionList().add(siiInformeSupervision);
        siiInformeSupervision.setSiiContrato(this);
        return siiInformeSupervision;
    }

    public SiiInformeSupervision removeSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        getSiiInformeSupervisionList().remove(siiInformeSupervision);
        siiInformeSupervision.setSiiContrato(null);
        return siiInformeSupervision;
    }
    
        @OneToMany(mappedBy = "siiContrato")
    public List<SiiAutoComisorio> getSiiAutoComisorioList() {
        return siiAutoComisorioList;
    }

    public void setSiiAutoComisorioList(List<SiiAutoComisorio> siiAutoComisorioList) {
        this.siiAutoComisorioList = siiAutoComisorioList;
    }

    public SiiAutoComisorio addSiiAutoComisorio(SiiAutoComisorio siiAutoComisorio) {
        getSiiAutoComisorioList().add(siiAutoComisorio);
        siiAutoComisorio.setSiiContrato(this);
        return siiAutoComisorio;
    }

    public SiiAutoComisorio removeSiiAutoComisorio(SiiAutoComisorio siiAutoComisorio) {
        getSiiAutoComisorioList().remove(siiAutoComisorio);
        siiAutoComisorio.setSiiContrato(null);
        return siiAutoComisorio;
    }
    
    @OneToMany(mappedBy = "siiContrato")
    public List<SiiTerminacionAnticip> getSiiTerminacionAnticipList() {
        return siiTerminacionAnticipList;
    }

    public void setSiiTerminacionAnticipList(List<SiiTerminacionAnticip> siiTerminacionAnticipList) {
        this.siiTerminacionAnticipList = siiTerminacionAnticipList;
    }

    public SiiTerminacionAnticip addSiiTerminacionAnticip(SiiTerminacionAnticip siiTerminacionAnticip) {
        getSiiTerminacionAnticipList().add(siiTerminacionAnticip);
        siiTerminacionAnticip.setSiiContrato(this);
        return siiTerminacionAnticip;
    }

    public SiiTerminacionAnticip removeSiiTerminacionAnticip(SiiTerminacionAnticip siiTerminacionAnticip) {
        getSiiTerminacionAnticipList().remove(siiTerminacionAnticip);
        siiTerminacionAnticip.setSiiContrato(null);
        return siiTerminacionAnticip;
    }
    
    @OneToMany(mappedBy = "siiContrato")
    public List<SiiSuspensionContr> getSiiSuspensionContrList() {
        return siiSuspensionContrList;
    }

    public void setSiiSuspensionContrList(List<SiiSuspensionContr> siiSuspensionContrList) {
        this.siiSuspensionContrList = siiSuspensionContrList;
    }

    public SiiSuspensionContr addSiiSuspensionContr(SiiSuspensionContr siiSuspensionContr) {
        getSiiSuspensionContrList().add(siiSuspensionContr);
        siiSuspensionContr.setSiiContrato(this);
        return siiSuspensionContr;
    }

    public SiiSuspensionContr removeSiiSuspensionContr(SiiSuspensionContr siiSuspensionContr) {
        getSiiSuspensionContrList().remove(siiSuspensionContr);
        siiSuspensionContr.setSiiContrato(null);
        return siiSuspensionContr;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiReporteVentas> getSiiReporteVentasList() {
        return siiReporteVentasList;
    }

    public void setSiiReporteVentasList(List<SiiReporteVentas> siiReporteVentasList) {
        this.siiReporteVentasList = siiReporteVentasList;
    }

    public SiiReporteVentas addSiiReporteVentas(SiiReporteVentas siiReporteVentas) {
        getSiiReporteVentasList().add(siiReporteVentas);
        siiReporteVentas.setSiiContrato(this);
        return siiReporteVentas;
    }

    public SiiReporteVentas removeSiiReporteVentas(SiiReporteVentas siiReporteVentas) {
        getSiiReporteVentasList().remove(siiReporteVentas);
        siiReporteVentas.setSiiContrato(null);
        return siiReporteVentas;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiProcesoSancionatorio> getSiiProcesoSancionatorioList() {
        return siiProcesoSancionatorioList;
    }

    public void setSiiProcesoSancionatorioList(List<SiiProcesoSancionatorio> siiProcesoSancionatorioList) {
        this.siiProcesoSancionatorioList = siiProcesoSancionatorioList;
    }

    public SiiProcesoSancionatorio addSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioList().add(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiContrato(this);
        return siiProcesoSancionatorio;
    }

    public SiiProcesoSancionatorio removeSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioList().remove(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiContrato(null);
        return siiProcesoSancionatorio;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiVentasMet> getSiiVentasMetList(){
        return siiVentasMetList;
    }

    public void setSiiVentasMetList(List<SiiVentasMet> siiVentasMetList){
        this.siiVentasMetList = siiVentasMetList;
    }

    public SiiVentasMet addSiiVentasMet(SiiVentasMet siiVentasMet){
        getSiiVentasMetList().add(siiVentasMet);
        siiVentasMet.setSiiContrato(this);
        return siiVentasMet;
    }

    public SiiVentasMet removeSiiVentasMet(SiiVentasMet siiVentasMet){
        getSiiVentasMetList().remove(siiVentasMet);
        siiVentasMet.setSiiContrato(null);
        return siiVentasMet;
    }

    @OneToMany(mappedBy = "siiContrato")
    public List<SiiCargaActuacionesAdm> getSiiCargaActuacionesAdmList() {
        return siiCargaActuacionesAdmList;
    }

    public void setSiiCargaActuacionesAdmList(List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList) {
        this.siiCargaActuacionesAdmList = siiCargaActuacionesAdmList;
    }

    public SiiCargaActuacionesAdm addSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().add(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiContrato(this);
        return siiCargaActuacionesAdm;
    }

    public SiiCargaActuacionesAdm removeSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().remove(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiContrato(null);
        return siiCargaActuacionesAdm;
    }
}
