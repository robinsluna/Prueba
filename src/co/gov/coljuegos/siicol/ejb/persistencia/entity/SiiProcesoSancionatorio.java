package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "SII_PROCESO_SANCIONATORIO")
public class SiiProcesoSancionatorio implements Serializable {
    private static final long serialVersionUID = -1748398022954055218L;
    private String psaAuprDecretaPr;
    private Integer psaAuprNumDias;
    private BigDecimal psaBorTotales;
    private Long psaCodigo;
    private Date psaComFechaRad;
    private String psaComRadicado;
    private Date psaFechaAutoArch;
    private Date psaFechaGenAuTrAl;
    private String psaMotivoInexac;
    private String psaMotivoOmision;
    private Date psaNumFechaRad;
    private String psaNumRadicado;
    private String psaPruDescripcion;
    private Date psaPruFechaRad;
    private String psaPruRadicado;
    private Date psaResulFecha;
    private String psaResulIndResp;
    private String psaResulNumGuia;
    private Date psaSnataFechaRad;
    private String psaSnataRadicado;
    private Date psaSnaupFechaRad;
    private String psaSnaupRadicado;
    private Date psaSnumaarFechaRad;
    private String psaSnumaarRadicado_;
    private List<SiiDescargoProcSan> siiDescargoProcSanList;
    private SiiResolucionProcSanc siiResolucionProcSancSanc;
    private SiiResolucionProcSanc siiResolucionProcSancSin;
    private List<SiiCuotaInexacProcSanc> siiCuotaInexacProcSancList;
    private SiiResolucionProcSanc siiResolucionProcSancRepos;
    private SiiResolucionProcSanc siiResolucionProcSancApela;
    private SiiEstadoProcesoSanc siiEstadoProcesoSanc;
    private List<SiiInventarioProcSan> siiInventarioProcSanList;
    private SiiContrato siiContrato;
    private List<SiiCuotaOmisProcSanc> siiCuotaOmisProcSancList;
    private SiiArchivoFisico siiArchivoFisicoAuto;
    private List<SiiRepartoFiscalizador> siiRepartoFiscalizadorList;
    private SiiInformeSupervision siiInformeSupervision;
    private Integer psaConsecutivo;
    private String psaInterpRecurso;
    private String psaInterpApelacion;
    private SiiUsuario siiUsuarioRegistra;
    private List<SiiInhabilidadPersona> siiInhabilidadPersonaList;
    private List<SiiRecepcionAlegatoProSan> siiRecepcionAlegatoProSanList;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private List<SiiCuotaOperador> siiCuotaOperadorList;

    public SiiProcesoSancionatorio() {
    }

    public SiiProcesoSancionatorio(SiiContrato siiContrato, SiiEstadoProcesoSanc siiEstadoProcesoSanc, String psaAuprDecretaPr, Integer psaAuprNumDias, BigDecimal psaBorTotales, Long psaCodigo,
                                   Date psaComFechaRad, String psaComRadicado, Date psaFechaAutoArch, Date psaFechaGenAuTrAl, String psaMotivoInexac, String psaMotivoOmision, Date psaNumFechaRad,
                                   String psaNumRadicado, String psaPruDescripcion, Date psaPruFechaRad, String psaPruRadicado,
                                   Date psaResulFecha, String psaResulIndResp, String psaResulNumGuia, Date psaSnataFechaRad,
                                   String psaSnataRadicado, Date psaSnaupFechaRad, String psaSnaupRadicado, Date psaSnumaarFechaRad, String psaSnumaarRadicado_,
                                   SiiResolucionProcSanc siiResolucionProcSancApela, SiiResolucionProcSanc siiResolucionProcSancRepos, SiiResolucionProcSanc siiResolucionProcSancSanc,
                                   SiiResolucionProcSanc siiResolucionProcSancSin) {
        this.siiContrato = siiContrato;
        this.siiEstadoProcesoSanc = siiEstadoProcesoSanc;
        this.psaAuprDecretaPr = psaAuprDecretaPr;
        this.psaAuprNumDias = psaAuprNumDias;
        this.psaBorTotales = psaBorTotales;
        this.psaCodigo = psaCodigo;
        this.psaComFechaRad = psaComFechaRad;
        this.psaComRadicado = psaComRadicado;
        this.psaFechaAutoArch = psaFechaAutoArch;
        this.psaFechaGenAuTrAl = psaFechaGenAuTrAl;
        this.psaMotivoInexac = psaMotivoInexac;
        this.psaMotivoOmision = psaMotivoOmision;
        this.psaNumFechaRad = psaNumFechaRad;
        this.psaNumRadicado = psaNumRadicado;
        this.psaPruDescripcion = psaPruDescripcion;
        this.psaPruFechaRad = psaPruFechaRad;
        this.psaPruRadicado = psaPruRadicado;
        this.psaResulFecha = psaResulFecha;
        this.psaResulIndResp = psaResulIndResp;
        this.psaResulNumGuia = psaResulNumGuia;
        this.psaSnataFechaRad = psaSnataFechaRad;
        this.psaSnataRadicado = psaSnataRadicado;
        this.psaSnaupFechaRad = psaSnaupFechaRad;
        this.psaSnaupRadicado = psaSnaupRadicado;
        this.psaSnumaarFechaRad = psaSnumaarFechaRad;
        this.psaSnumaarRadicado_ = psaSnumaarRadicado_;
        this.siiResolucionProcSancApela = siiResolucionProcSancApela;
        this.siiResolucionProcSancRepos = siiResolucionProcSancRepos;
        this.siiResolucionProcSancSanc = siiResolucionProcSancSanc;
        this.siiResolucionProcSancSin = siiResolucionProcSancSin;
    }


    @Column(name = "PSA_AUPR_DECRETA_PR", length = 1)
    public String getPsaAuprDecretaPr() {
        return psaAuprDecretaPr;
    }

    public void setPsaAuprDecretaPr(String psaAuprDecretaPr) {
        this.psaAuprDecretaPr = psaAuprDecretaPr;
    }

    @Column(name = "PSA_AUPR_NUM_DIAS")
    public Integer getPsaAuprNumDias() {
        return psaAuprNumDias;
    }

    public void setPsaAuprNumDias(Integer psaAuprNumDias) {
        this.psaAuprNumDias = psaAuprNumDias;
    }

    @Column(name = "PSA_BOR_TOTALES")
    public BigDecimal getPsaBorTotales() {
        return psaBorTotales;
    }

    public void setPsaBorTotales(BigDecimal psaBorTotales) {
        this.psaBorTotales = psaBorTotales;
    }

    @Id
    @Column(name = "PSA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROCESO_SANCIONAT_COD")
    @SequenceGenerator(name = "SEQ_PROCESO_SANCIONAT_COD", sequenceName = "SEQ_PROCESO_SANCIONAT_COD",allocationSize=1)
    public Long getPsaCodigo() {
        return psaCodigo;
    }

    public void setPsaCodigo(Long psaCodigo) {
        this.psaCodigo = psaCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSA_COM_FECHA_RAD")
    public Date getPsaComFechaRad() {
        return psaComFechaRad;
    }

    public void setPsaComFechaRad(Date psaComFechaRad) {
        this.psaComFechaRad = psaComFechaRad;
    }

    @Column(name = "PSA_COM_RADICADO", length = 30)
    public String getPsaComRadicado() {
        return psaComRadicado;
    }

    public void setPsaComRadicado(String psaComRadicado) {
        this.psaComRadicado = psaComRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSA_FECHA_AUTO_ARCH")
    public Date getPsaFechaAutoArch() {
        return psaFechaAutoArch;
    }

    public void setPsaFechaAutoArch(Date psaFechaAutoArch) {
        this.psaFechaAutoArch = psaFechaAutoArch;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSA_FECHA_GEN_AU_TR_AL")
    public Date getPsaFechaGenAuTrAl() {
        return psaFechaGenAuTrAl;
    }

    public void setPsaFechaGenAuTrAl(Date psaFechaGenAuTrAl) {
        this.psaFechaGenAuTrAl = psaFechaGenAuTrAl;
    }

    @Column(name = "PSA_MOTIVO_INEXAC", nullable = false, length = 1)
    public String getPsaMotivoInexac() {
        return psaMotivoInexac;
    }

    public void setPsaMotivoInexac(String psaMotivoInexac) {
        this.psaMotivoInexac = psaMotivoInexac;
    }

    @Column(name = "PSA_MOTIVO_OMISION", nullable = false, length = 1)
    public String getPsaMotivoOmision() {
        return psaMotivoOmision;
    }

    public void setPsaMotivoOmision(String psaMotivoOmision) {
        this.psaMotivoOmision = psaMotivoOmision;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSA_NUM_FECHA_RAD")
    public Date getPsaNumFechaRad() {
        return psaNumFechaRad;
    }

    public void setPsaNumFechaRad(Date psaNumFechaRad) {
        this.psaNumFechaRad = psaNumFechaRad;
    }

    @Column(name = "PSA_NUM_RADICADO", length = 30)
    public String getPsaNumRadicado() {
        return psaNumRadicado;
    }

    public void setPsaNumRadicado(String psaNumRadicado) {
        this.psaNumRadicado = psaNumRadicado;
    }

    @Column(name = "PSA_PRU_DESCRIPCION")
    public String getPsaPruDescripcion() {
        return psaPruDescripcion;
    }

    public void setPsaPruDescripcion(String psaPruDescripcion) {
        this.psaPruDescripcion = psaPruDescripcion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSA_PRU_FECHA_RAD")
    public Date getPsaPruFechaRad() {
        return psaPruFechaRad;
    }

    public void setPsaPruFechaRad(Date psaPruFechaRad) {
        this.psaPruFechaRad = psaPruFechaRad;
    }

    @Column(name = "PSA_PRU_RADICADO", length = 30)
    public String getPsaPruRadicado() {
        return psaPruRadicado;
    }

    public void setPsaPruRadicado(String psaPruRadicado) {
        this.psaPruRadicado = psaPruRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSA_RESUL_FECHA")
    public Date getPsaResulFecha() {
        return psaResulFecha;
    }

    public void setPsaResulFecha(Date psaResulFecha) {
        this.psaResulFecha = psaResulFecha;
    }

    @Column(name = "PSA_RESUL_IND_RESP", length = 1)
    public String getPsaResulIndResp() {
        return psaResulIndResp;
    }

    public void setPsaResulIndResp(String psaResulIndResp) {
        this.psaResulIndResp = psaResulIndResp;
    }

    @Column(name = "PSA_RESUL_NUM_GUIA", length = 30)
    public String getPsaResulNumGuia() {
        return psaResulNumGuia;
    }

    public void setPsaResulNumGuia(String psaResulNumGuia) {
        this.psaResulNumGuia = psaResulNumGuia;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSA_SNATA_FECHA_RAD")
    public Date getPsaSnataFechaRad() {
        return psaSnataFechaRad;
    }

    public void setPsaSnataFechaRad(Date psaSnataFechaRad) {
        this.psaSnataFechaRad = psaSnataFechaRad;
    }

    @Column(name = "PSA_SNATA_RADICADO", length = 30)
    public String getPsaSnataRadicado() {
        return psaSnataRadicado;
    }

    public void setPsaSnataRadicado(String psaSnataRadicado) {
        this.psaSnataRadicado = psaSnataRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSA_SNAUP_FECHA_RAD")
    public Date getPsaSnaupFechaRad() {
        return psaSnaupFechaRad;
    }

    public void setPsaSnaupFechaRad(Date psaSnaupFechaRad) {
        this.psaSnaupFechaRad = psaSnaupFechaRad;
    }

    @Column(name = "PSA_SNAUP_RADICADO", length = 30)
    public String getPsaSnaupRadicado() {
        return psaSnaupRadicado;
    }

    public void setPsaSnaupRadicado(String psaSnaupRadicado) {
        this.psaSnaupRadicado = psaSnaupRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PSA_SNUMAAR_FECHA_RAD")
    public Date getPsaSnumaarFechaRad() {
        return psaSnumaarFechaRad;
    }

    public void setPsaSnumaarFechaRad(Date psaSnumaarFechaRad) {
        this.psaSnumaarFechaRad = psaSnumaarFechaRad;
    }

    @Column(name = "PSA_SNUMAAR_RADICADO_", length = 30)
    public String getPsaSnumaarRadicado_() {
        return psaSnumaarRadicado_;
    }

    public void setPsaSnumaarRadicado_(String psaSnumaarRadicado_) {
        this.psaSnumaarRadicado_ = psaSnumaarRadicado_;
    }


    @OneToMany(mappedBy = "siiProcesoSancionatorio")
    public List<SiiDescargoProcSan> getSiiDescargoProcSanList() {
        return siiDescargoProcSanList;
    }

    public void setSiiDescargoProcSanList(List<SiiDescargoProcSan> siiDescargoProcSanList) {
        this.siiDescargoProcSanList = siiDescargoProcSanList;
    }

    public SiiDescargoProcSan addSiiDescargoProcSan(SiiDescargoProcSan siiDescargoProcSan) {
        getSiiDescargoProcSanList().add(siiDescargoProcSan);
        siiDescargoProcSan.setSiiProcesoSancionatorio(this);
        return siiDescargoProcSan;
    }

    public SiiDescargoProcSan removeSiiDescargoProcSan(SiiDescargoProcSan siiDescargoProcSan) {
        getSiiDescargoProcSanList().remove(siiDescargoProcSan);
        siiDescargoProcSan.setSiiProcesoSancionatorio(null);
        return siiDescargoProcSan;
    }

    @ManyToOne
    @JoinColumn(name = "REP_CODIGO_SANCION")
    public SiiResolucionProcSanc getSiiResolucionProcSancSanc() {
        return siiResolucionProcSancSanc;
    }

    public void setSiiResolucionProcSancSanc(SiiResolucionProcSanc siiResolucionProcSancSanc) {
        this.siiResolucionProcSancSanc = siiResolucionProcSancSanc;
    }

    @ManyToOne
    @JoinColumn(name = "REP_CODIGO_SIN_SANC")
    public SiiResolucionProcSanc getSiiResolucionProcSancSin() {
        return siiResolucionProcSancSin;
    }

    public void setSiiResolucionProcSancSin(SiiResolucionProcSanc siiResolucionProcSancSin) {
        this.siiResolucionProcSancSin = siiResolucionProcSancSin;
    }

    @OneToMany(mappedBy = "siiProcesoSancionatorio")
    public List<SiiCuotaInexacProcSanc> getSiiCuotaInexacProcSancList() {
        return siiCuotaInexacProcSancList;
    }

    public void setSiiCuotaInexacProcSancList(List<SiiCuotaInexacProcSanc> siiCuotaInexacProcSancList) {
        this.siiCuotaInexacProcSancList = siiCuotaInexacProcSancList;
    }

    public SiiCuotaInexacProcSanc addSiiCuotaInexacProcSanc(SiiCuotaInexacProcSanc siiCuotaInexacProcSanc) {
        getSiiCuotaInexacProcSancList().add(siiCuotaInexacProcSanc);
        siiCuotaInexacProcSanc.setSiiProcesoSancionatorio(this);
        return siiCuotaInexacProcSanc;
    }

    public SiiCuotaInexacProcSanc removeSiiCuotaInexacProcSanc(SiiCuotaInexacProcSanc siiCuotaInexacProcSanc) {
        getSiiCuotaInexacProcSancList().remove(siiCuotaInexacProcSanc);
        siiCuotaInexacProcSanc.setSiiProcesoSancionatorio(null);
        return siiCuotaInexacProcSanc;
    }

    @ManyToOne
    @JoinColumn(name = "REP_CODIGO_REPOSIC")
    public SiiResolucionProcSanc getSiiResolucionProcSancRepos() {
        return siiResolucionProcSancRepos;
    }

    public void setSiiResolucionProcSancRepos(SiiResolucionProcSanc siiResolucionProcSancRepos) {
        this.siiResolucionProcSancRepos = siiResolucionProcSancRepos;
    }

    @ManyToOne
    @JoinColumn(name = "REP_CODIGO_APELAC")
    public SiiResolucionProcSanc getSiiResolucionProcSancApela() {
        return siiResolucionProcSancApela;
    }

    public void setSiiResolucionProcSancApela(SiiResolucionProcSanc siiResolucionProcSancApela) {
        this.siiResolucionProcSancApela = siiResolucionProcSancApela;
    }

    @ManyToOne
    @JoinColumn(name = "EPS_CODIGO")
    public SiiEstadoProcesoSanc getSiiEstadoProcesoSanc() {
        return siiEstadoProcesoSanc;
    }

    public void setSiiEstadoProcesoSanc(SiiEstadoProcesoSanc siiEstadoProcesoSanc) {
        this.siiEstadoProcesoSanc = siiEstadoProcesoSanc;
    }

    @OneToMany(mappedBy = "siiProcesoSancionatorio")
    public List<SiiInventarioProcSan> getSiiInventarioProcSanList() {
        return siiInventarioProcSanList;
    }

    public void setSiiInventarioProcSanList(List<SiiInventarioProcSan> siiInventarioProcSanList) {
        this.siiInventarioProcSanList = siiInventarioProcSanList;
    }

    public SiiInventarioProcSan addSiiInventarioProcSan(SiiInventarioProcSan siiInventarioProcSan) {
        getSiiInventarioProcSanList().add(siiInventarioProcSan);
        siiInventarioProcSan.setSiiProcesoSancionatorio(this);
        return siiInventarioProcSan;
    }

    public SiiInventarioProcSan removeSiiInventarioProcSan(SiiInventarioProcSan siiInventarioProcSan) {
        getSiiInventarioProcSanList().remove(siiInventarioProcSan);
        siiInventarioProcSan.setSiiProcesoSancionatorio(null);
        return siiInventarioProcSan;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @OneToMany(mappedBy = "siiProcesoSancionatorio")
    public List<SiiCuotaOmisProcSanc> getSiiCuotaOmisProcSancList() {
        return siiCuotaOmisProcSancList;
    }

    public void setSiiCuotaOmisProcSancList(List<SiiCuotaOmisProcSanc> siiCuotaOmisProcSancList) {
        this.siiCuotaOmisProcSancList = siiCuotaOmisProcSancList;
    }

    public SiiCuotaOmisProcSanc addSiiCuotaOmisProcSanc(SiiCuotaOmisProcSanc siiCuotaOmisProcSanc) {
        getSiiCuotaOmisProcSancList().add(siiCuotaOmisProcSanc);
        siiCuotaOmisProcSanc.setSiiProcesoSancionatorio(this);
        return siiCuotaOmisProcSanc;
    }

    public SiiCuotaOmisProcSanc removeSiiCuotaOmisProcSanc(SiiCuotaOmisProcSanc siiCuotaOmisProcSanc) {
        getSiiCuotaOmisProcSancList().remove(siiCuotaOmisProcSanc);
        siiCuotaOmisProcSanc.setSiiProcesoSancionatorio(null);
        return siiCuotaOmisProcSanc;
    }

    @ManyToOne
    @JoinColumn(name = "PSA_SNUMAAR_AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisicoAuto() {
        return siiArchivoFisicoAuto;
    }

    public void setSiiArchivoFisicoAuto(SiiArchivoFisico siiArchivoFisicoAuto) {
        this.siiArchivoFisicoAuto = siiArchivoFisicoAuto;
    }

    @OneToMany(mappedBy = "siiProcesoSancionatorio")
    public List<SiiRepartoFiscalizador> getSiiRepartoFiscalizadorList(){
        return siiRepartoFiscalizadorList;
    }

    public void setSiiRepartoFiscalizadorList(List<SiiRepartoFiscalizador> siiRepartoFiscalizadorList){
        this.siiRepartoFiscalizadorList = siiRepartoFiscalizadorList;
    }

    public SiiRepartoFiscalizador addSiiRepartoFiscalizador(SiiRepartoFiscalizador siiRepartoFiscalizador){
        getSiiRepartoFiscalizadorList().add(siiRepartoFiscalizador);
        siiRepartoFiscalizador.setSiiProcesoSancionatorio(this);
        return siiRepartoFiscalizador;
    }

    public SiiRepartoFiscalizador removeSiiRepartoFiscalizador(SiiRepartoFiscalizador siiRepartoFiscalizador){
        getSiiRepartoFiscalizadorList().remove(siiRepartoFiscalizador);
        siiRepartoFiscalizador.setSiiProcesoSancionatorio(null);
        return siiRepartoFiscalizador;
    }

    @ManyToOne
    @JoinColumn(name = "ISU_CODIGO")
    public SiiInformeSupervision getSiiInformeSupervision(){
        return siiInformeSupervision;
    }

    public void setSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision){
        this.siiInformeSupervision = siiInformeSupervision;
    }

    @Column(name = "PSA_CONSECUTIVO")
    public Integer getPsaConsecutivo(){
        return psaConsecutivo;
    }
    
    public void setPsaConsecutivo(Integer psaConsecutivo){
        this.psaConsecutivo = psaConsecutivo;
    }
    
    @Column(name = "PSA_INTERP_RECURSO", length = 1)
    public String getPsaInterpRecurso() {
        return psaInterpRecurso;
    }
    
    public void setPsaInterpRecurso(String psaInterpRecurso) {
        this.psaInterpRecurso = psaInterpRecurso;
    }
    
    @Column(name = "PSA_INTERP_APELACION", length = 1)
    public String getPsaInterpApelacion() {
        return psaInterpApelacion;
    }
    
    public void setPsaInterpApelacion(String psaInterpApelacion) {
        this.psaInterpApelacion = psaInterpApelacion;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_REG")
    public SiiUsuario getSiiUsuarioRegistra() {
        return siiUsuarioRegistra;
    }

    public void setSiiUsuarioRegistra(SiiUsuario siiUsuarioRegistra) {
        this.siiUsuarioRegistra = siiUsuarioRegistra;
    }

    @OneToMany(mappedBy = "siiProcesoSancionatorio")
    public List<SiiInhabilidadPersona> getSiiInhabilidadPersonaList() {
        return siiInhabilidadPersonaList;
    }

    public void setSiiInhabilidadPersonaList(List<SiiInhabilidadPersona> siiInhabilidadPersonaList) {
        this.siiInhabilidadPersonaList = siiInhabilidadPersonaList;
    }

    public SiiInhabilidadPersona addSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaList().add(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiProcesoSancionatorio(this);
        return siiInhabilidadPersona;
    }

    public SiiInhabilidadPersona removeSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaList().remove(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiProcesoSancionatorio(null);
        return siiInhabilidadPersona;
    }

    @OneToMany(mappedBy = "siiProcesoSancionatorio")
    public List<SiiRecepcionAlegatoProSan> getSiiRecepcionAlegatoProSanList() {
        return siiRecepcionAlegatoProSanList;
    }

    public void setSiiRecepcionAlegatoProSanList(List<SiiRecepcionAlegatoProSan> siiRecepcionAlegatoProSanList) {
        this.siiRecepcionAlegatoProSanList = siiRecepcionAlegatoProSanList;
    }

    public SiiRecepcionAlegatoProSan addSiiRecepcionAlegatoProSan(SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan) {
        getSiiRecepcionAlegatoProSanList().add(siiRecepcionAlegatoProSan);
        siiRecepcionAlegatoProSan.setSiiProcesoSancionatorio(this);
        return siiRecepcionAlegatoProSan;
    }

    public SiiRecepcionAlegatoProSan removeSiiRecepcionAlegatoProSan(SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan) {
        getSiiRecepcionAlegatoProSanList().remove(siiRecepcionAlegatoProSan);
        siiRecepcionAlegatoProSan.setSiiProcesoSancionatorio(null);
        return siiRecepcionAlegatoProSan;
    }

    @OneToMany(mappedBy = "siiProcesoSancionatorio")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiProcesoSancionatorio(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiProcesoSancionatorio(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiProcesoSancionatorio")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiProcesoSancionatorio(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiProcesoSancionatorio(null);
        return siiCuotaOperador;
    }
}
