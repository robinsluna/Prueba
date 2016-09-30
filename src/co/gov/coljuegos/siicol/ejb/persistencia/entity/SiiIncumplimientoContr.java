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
@Table(name = "SII_INCUMPLIMIENTO_CONTR")
public class SiiIncumplimientoContr implements Serializable {
    private static final long serialVersionUID = 3979761223866462384L;
    private Long icnCodigo;
    private Integer icnConsecutivo;
    private Date icnFechaAutoArchivo;
    private Date icnFechaCancelacion;
    private Date icnFechaCitaAud;
    private Date icnFechaComAse;
    private Date icnFechaComOpe;
    private Date icnFechaConstEjecut;
    private Date icnFechaRadCitAse;
    private Date icnFechaRadCitOpe;
    private Date icnFechaReanudAud;
    private Date icnFechaSuperaInc;
    private Date icnFechaSuspension;
    private String icnFormaComunicaAse;
    private String icnFormaComunicaOpe;
    private String icnMotivoCancelac;
    private String icnMotivoSuspen;
    private String icnNumAutoArchivo;
    private String icnNumGuiaAse;
    private String icnNumGuiaOpe;
    private String icnObservacionesSus;
    private String icnObservacCancela;
    private String icnRadicaCitaAse;
    private String icnRadicaCitaOpe;
    private SiiEstadoIncumplContract siiEstadoIncumplContract;
    private SiiArchivoFisico siiArchivoFisicoOper;
    private SiiInformeSupervision siiInformeSupervision;
    private SiiResolucionIncumContr siiResolucionIncumContrResol;
    private SiiArchivoFisico siiArchivoFisicoAuto;
    private SiiResolucionIncumContr siiResolucionIncumContrRecurso;
    private SiiArchivoFisico siiArchivoFisicoAseg;
    private List<SiiRepartoFiscalizador> siiRepartoFiscalizadorList;
    private List<SiiDireccionProcesalInc> siiDireccionProcesalIncList;
    private Integer icnDiasIncumplim;
    private BigDecimal icnValorClausulaP;
    private BigDecimal icnValorMulta;
    private List<SiiCuotaOperador> siiCuotaOperadorList;
    private Integer icnCantidadElem;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private String icnSuperoInc;
    private SiiUsuario siiUsuarioRegistra;
    private List<SiiActaSuspenAudIncumCon> siiActaSuspenAudIncumConList;
    private List<SiiInhabilidadPersona> siiInhabilidadPersonaList;
    private String icnRepLegPrimApeCitAud;
    private String icnRepLegPrimNomCitAud;
    private String icnRepLegSegApeCitAud;
    private String icnRepLegSegNomCitAud;

    public SiiIncumplimientoContr() {
    }

    public SiiIncumplimientoContr(SiiArchivoFisico siiArchivoFisicoAuto, SiiArchivoFisico siiArchivoFisicoAseg,
                                  SiiArchivoFisico siiArchivoFisicoOper,
                                  SiiEstadoIncumplContract siiEstadoIncumplContract, Long icnCodigo,
                                  Date icnFechaAutoArchivo, Date icnFechaCancelacion, Date icnFechaCitaAud,
                                  Date icnFechaComAse, Date icnFechaComOpe, Date icnFechaConstEjecut,
                                  Date icnFechaRadCitAse, Date icnFechaRadCitOpe, Date icnFechaReanudAud,
                                  Date icnFechaSuperaInc, Date icnFechaSuspension, String icnFormaComunicaAse,
                                  String icnFormaComunicaOpe, String icnMotivoCancelac, String icnMotivoSuspen,
                                  String icnNumAutoArchivo, String icnNumGuiaAse, String icnNumGuiaOpe,
                                  String icnObservacCancela, String icnObservacionesSus, String icnRadicaCitaAse,
                                  String icnRadicaCitaOpe, SiiInformeSupervision siiInformeSupervision,
                                  SiiResolucionIncumContr siiResolucionIncumContrRecurso,
                                  SiiResolucionIncumContr siiResolucionIncumContrResol) {
        this.siiArchivoFisicoAuto = siiArchivoFisicoAuto;
        this.siiArchivoFisicoAseg = siiArchivoFisicoAseg;
        this.siiArchivoFisicoOper = siiArchivoFisicoOper;
        this.siiEstadoIncumplContract = siiEstadoIncumplContract;
        this.icnCodigo = icnCodigo;
        this.icnFechaAutoArchivo = icnFechaAutoArchivo;
        this.icnFechaCancelacion = icnFechaCancelacion;
        this.icnFechaCitaAud = icnFechaCitaAud;
        this.icnFechaComAse = icnFechaComAse;
        this.icnFechaComOpe = icnFechaComOpe;
        this.icnFechaConstEjecut = icnFechaConstEjecut;
        this.icnFechaRadCitAse = icnFechaRadCitAse;
        this.icnFechaRadCitOpe = icnFechaRadCitOpe;
        this.icnFechaReanudAud = icnFechaReanudAud;
        this.icnFechaSuperaInc = icnFechaSuperaInc;
        this.icnFechaSuspension = icnFechaSuspension;
        this.icnFormaComunicaAse = icnFormaComunicaAse;
        this.icnFormaComunicaOpe = icnFormaComunicaOpe;
        this.icnMotivoCancelac = icnMotivoCancelac;
        this.icnMotivoSuspen = icnMotivoSuspen;
        this.icnNumAutoArchivo = icnNumAutoArchivo;
        this.icnNumGuiaAse = icnNumGuiaAse;
        this.icnNumGuiaOpe = icnNumGuiaOpe;
        this.icnObservacCancela = icnObservacCancela;
        this.icnObservacionesSus = icnObservacionesSus;
        this.icnRadicaCitaAse = icnRadicaCitaAse;
        this.icnRadicaCitaOpe = icnRadicaCitaOpe;
        this.siiInformeSupervision = siiInformeSupervision;
        this.siiResolucionIncumContrRecurso = siiResolucionIncumContrRecurso;
        this.siiResolucionIncumContrResol = siiResolucionIncumContrResol;
    }


    @Id
    @Column(name = "ICN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INCUMPLIMIENTO_CONTR_COD")
    @SequenceGenerator(name = "SEQ_INCUMPLIMIENTO_CONTR_COD", sequenceName = "SEQ_INCUMPLIMIENTO_CONTR_COD",allocationSize=1)
    public Long getIcnCodigo() {
        return icnCodigo;
    }

    public void setIcnCodigo(Long icnCodigo) {
        this.icnCodigo = icnCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_AUTO_ARCHIVO")
    public Date getIcnFechaAutoArchivo() {
        return icnFechaAutoArchivo;
    }

    public void setIcnFechaAutoArchivo(Date icnFechaAutoArchivo) {
        this.icnFechaAutoArchivo = icnFechaAutoArchivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_CANCELACION")
    public Date getIcnFechaCancelacion() {
        return icnFechaCancelacion;
    }

    public void setIcnFechaCancelacion(Date icnFechaCancelacion) {
        this.icnFechaCancelacion = icnFechaCancelacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_CITA_AUD")
    public Date getIcnFechaCitaAud() {
        return icnFechaCitaAud;
    }

    public void setIcnFechaCitaAud(Date icnFechaCitaAud) {
        this.icnFechaCitaAud = icnFechaCitaAud;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_COM_ASE")
    public Date getIcnFechaComAse() {
        return icnFechaComAse;
    }

    public void setIcnFechaComAse(Date icnFechaComAse) {
        this.icnFechaComAse = icnFechaComAse;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_COM_OPE")
    public Date getIcnFechaComOpe() {
        return icnFechaComOpe;
    }

    public void setIcnFechaComOpe(Date icnFechaComOpe) {
        this.icnFechaComOpe = icnFechaComOpe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_CONST_EJECUT")
    public Date getIcnFechaConstEjecut() {
        return icnFechaConstEjecut;
    }

    public void setIcnFechaConstEjecut(Date icnFechaConstEjecut) {
        this.icnFechaConstEjecut = icnFechaConstEjecut;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_RAD_CIT_ASE")
    public Date getIcnFechaRadCitAse() {
        return icnFechaRadCitAse;
    }

    public void setIcnFechaRadCitAse(Date icnFechaRadCitAse) {
        this.icnFechaRadCitAse = icnFechaRadCitAse;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_RAD_CIT_OPE")
    public Date getIcnFechaRadCitOpe() {
        return icnFechaRadCitOpe;
    }

    public void setIcnFechaRadCitOpe(Date icnFechaRadCitOpe) {
        this.icnFechaRadCitOpe = icnFechaRadCitOpe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_REANUD_AUD")
    public Date getIcnFechaReanudAud() {
        return icnFechaReanudAud;
    }

    public void setIcnFechaReanudAud(Date icnFechaReanudAud) {
        this.icnFechaReanudAud = icnFechaReanudAud;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_SUPERA_INC")
    public Date getIcnFechaSuperaInc() {
        return icnFechaSuperaInc;
    }

    public void setIcnFechaSuperaInc(Date icnFechaSuperaInc) {
        this.icnFechaSuperaInc = icnFechaSuperaInc;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICN_FECHA_SUSPENSION")
    public Date getIcnFechaSuspension() {
        return icnFechaSuspension;
    }

    public void setIcnFechaSuspension(Date icnFechaSuspension) {
        this.icnFechaSuspension = icnFechaSuspension;
    }

    @Column(name = "ICN_FORMA_COMUNICA_ASE", length = 1)
    public String getIcnFormaComunicaAse() {
        return icnFormaComunicaAse;
    }

    public void setIcnFormaComunicaAse(String icnFormaComunicaAse) {
        this.icnFormaComunicaAse = icnFormaComunicaAse;
    }

    @Column(name = "ICN_FORMA_COMUNICA_OPE", length = 1)
    public String getIcnFormaComunicaOpe() {
        return icnFormaComunicaOpe;
    }

    public void setIcnFormaComunicaOpe(String icnFormaComunicaOpe) {
        this.icnFormaComunicaOpe = icnFormaComunicaOpe;
    }

    @Column(name = "ICN_MOTIVO_CANCELAC", length = 55)
    public String getIcnMotivoCancelac() {
        return icnMotivoCancelac;
    }

    public void setIcnMotivoCancelac(String icnMotivoCancelac) {
        this.icnMotivoCancelac = icnMotivoCancelac;
    }

    @Column(name = "ICN_MOTIVO_SUSPEN", length = 55)
    public String getIcnMotivoSuspen() {
        return icnMotivoSuspen;
    }

    public void setIcnMotivoSuspen(String icnMotivoSuspen) {
        this.icnMotivoSuspen = icnMotivoSuspen;
    }

    @Column(name = "ICN_NUM_AUTO_ARCHIVO", length = 30)
    public String getIcnNumAutoArchivo() {
        return icnNumAutoArchivo;
    }

    public void setIcnNumAutoArchivo(String icnNumAutoArchivo) {
        this.icnNumAutoArchivo = icnNumAutoArchivo;
    }

    @Column(name = "ICN_NUM_GUIA_ASE", length = 20)
    public String getIcnNumGuiaAse() {
        return icnNumGuiaAse;
    }

    public void setIcnNumGuiaAse(String icnNumGuiaAse) {
        this.icnNumGuiaAse = icnNumGuiaAse;
    }

    @Column(name = "ICN_NUM_GUIA_OPE", length = 20)
    public String getIcnNumGuiaOpe() {
        return icnNumGuiaOpe;
    }

    public void setIcnNumGuiaOpe(String icnNumGuiaOpe) {
        this.icnNumGuiaOpe = icnNumGuiaOpe;
    }

    @Column(name = "ICN_OBSERVACIONES_SUS", length = 550)
    public String getIcnObservacionesSus() {
        return icnObservacionesSus;
    }

    public void setIcnObservacionesSus(String icnObservacionesSus) {
        this.icnObservacionesSus = icnObservacionesSus;
    }

    @Column(name = "ICN_OBSERVAC_CANCELA", length = 550)
    public String getIcnObservacCancela() {
        return icnObservacCancela;
    }

    public void setIcnObservacCancela(String icnObservacCancela) {
        this.icnObservacCancela = icnObservacCancela;
    }

    @Column(name = "ICN_RADICA_CITA_ASE", length = 30)
    public String getIcnRadicaCitaAse() {
        return icnRadicaCitaAse;
    }

    public void setIcnRadicaCitaAse(String icnRadicaCitaAse) {
        this.icnRadicaCitaAse = icnRadicaCitaAse;
    }

    @Column(name = "ICN_RADICA_CITA_OPE", length = 30)
    public String getIcnRadicaCitaOpe() {
        return icnRadicaCitaOpe;
    }

    public void setIcnRadicaCitaOpe(String icnRadicaCitaOpe) {
        this.icnRadicaCitaOpe = icnRadicaCitaOpe;
    }


    @ManyToOne
    @JoinColumn(name = "EIC_CODIGO")
    public SiiEstadoIncumplContract getSiiEstadoIncumplContract() {
        return siiEstadoIncumplContract;
    }

    public void setSiiEstadoIncumplContract(SiiEstadoIncumplContract siiEstadoIncumplContract) {
        this.siiEstadoIncumplContract = siiEstadoIncumplContract;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO_CIT_OPE")
    public SiiArchivoFisico getSiiArchivoFisicoOper() {
        return siiArchivoFisicoOper;
    }

    public void setSiiArchivoFisicoOper(SiiArchivoFisico siiArchivoFisicoOper) {
        this.siiArchivoFisicoOper = siiArchivoFisicoOper;
    }

    @ManyToOne
    @JoinColumn(name = "ISU_CODIGO")
    public SiiInformeSupervision getSiiInformeSupervision() {
        return siiInformeSupervision;
    }

    public void setSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        this.siiInformeSupervision = siiInformeSupervision;
    }

    @ManyToOne
    @JoinColumn(name = "RCO_CODIGO_RESOL")
    public SiiResolucionIncumContr getSiiResolucionIncumContrResol() {
        return siiResolucionIncumContrResol;
    }

    public void setSiiResolucionIncumContrResol(SiiResolucionIncumContr siiResolucionIncumContrResol) {
        this.siiResolucionIncumContrResol = siiResolucionIncumContrResol;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO_AUTO")
    public SiiArchivoFisico getSiiArchivoFisicoAuto() {
        return siiArchivoFisicoAuto;
    }

    public void setSiiArchivoFisicoAuto(SiiArchivoFisico siiArchivoFisicoAuto) {
        this.siiArchivoFisicoAuto = siiArchivoFisicoAuto;
    }

    @ManyToOne
    @JoinColumn(name = "RCO_CODIGO_RECURSO")
    public SiiResolucionIncumContr getSiiResolucionIncumContrRecurso() {
        return siiResolucionIncumContrRecurso;
    }

    public void setSiiResolucionIncumContrRecurso(SiiResolucionIncumContr siiResolucionIncumContrRecurso) {
        this.siiResolucionIncumContrRecurso = siiResolucionIncumContrRecurso;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO_CIT_ASE")
    public SiiArchivoFisico getSiiArchivoFisicoAseg() {
        return siiArchivoFisicoAseg;
    }

    public void setSiiArchivoFisicoAseg(SiiArchivoFisico siiArchivoFisicoAseg) {
        this.siiArchivoFisicoAseg = siiArchivoFisicoAseg;
    }


    @Column(name = "ICN_CONSECUTIVO", nullable = false)
    public Integer getIcnConsecutivo() {
        return icnConsecutivo;
    }

    public void setIcnConsecutivo(Integer icnConsecutivo) {
        this.icnConsecutivo = icnConsecutivo;
    }
    
    @OneToMany(mappedBy = "siiIncumplimientoContr")
    public List<SiiRepartoFiscalizador> getSiiRepartoFiscalizadorList() {
        return siiRepartoFiscalizadorList;
    }

    public void setSiiRepartoFiscalizadorList(List<SiiRepartoFiscalizador> siiRepartoFiscalizadorList) {
        this.siiRepartoFiscalizadorList = siiRepartoFiscalizadorList;
    }

    public SiiRepartoFiscalizador addSiiRepartoFiscalizador(SiiRepartoFiscalizador siiRepartoFiscalizador) {
        getSiiRepartoFiscalizadorList().add(siiRepartoFiscalizador);
        siiRepartoFiscalizador.setSiiIncumplimientoContr(this);
        return siiRepartoFiscalizador;
    }

    public SiiRepartoFiscalizador removeSiiRepartoFiscalizador(SiiRepartoFiscalizador siiRepartoFiscalizador) {
        getSiiRepartoFiscalizadorList().remove(siiRepartoFiscalizador);
        siiRepartoFiscalizador.setSiiIncumplimientoContr(null);
        return siiRepartoFiscalizador;
    }

    @OneToMany(mappedBy = "siiIncumplimientoContr")
    public List<SiiDireccionProcesalInc> getSiiDireccionProcesalIncList() {
        return siiDireccionProcesalIncList;
    }

    public void setSiiDireccionProcesalIncList(List<SiiDireccionProcesalInc> siiDireccionProcesalIncList) {
        this.siiDireccionProcesalIncList = siiDireccionProcesalIncList;
    }

    public SiiDireccionProcesalInc addSiiDireccionProcesalInc(SiiDireccionProcesalInc siiDireccionProcesalInc) {
        getSiiDireccionProcesalIncList().add(siiDireccionProcesalInc);
        siiDireccionProcesalInc.setSiiIncumplimientoContr(this);
        return siiDireccionProcesalInc;
    }

    public SiiDireccionProcesalInc removeSiiDireccionProcesalInc(SiiDireccionProcesalInc siiDireccionProcesalInc) {
        getSiiDireccionProcesalIncList().remove(siiDireccionProcesalInc);
        siiDireccionProcesalInc.setSiiIncumplimientoContr(null);
        return siiDireccionProcesalInc;
    }

    @Column(name = "ICN_VALOR_CLAUSULA_P")
    public BigDecimal getIcnValorClausulaP() {
        return icnValorClausulaP;
    }

    public void setIcnValorClausulaP(BigDecimal icnValorClausulaP) {
        this.icnValorClausulaP = icnValorClausulaP;
    }

    @Column(name = "ICN_VALOR_MULTA")
    public BigDecimal getIcnValorMulta() {
        return icnValorMulta;
    }

    public void setIcnValorMulta(BigDecimal icnValorMulta) {
        this.icnValorMulta = icnValorMulta;
    }

    @Column(name = "ICN_DIAS_INCUMPLIM")
    public Integer getIcnDiasIncumplim() {
        return icnDiasIncumplim;
    }

    public void setIcnDiasIncumplim(Integer icnDiasIncumplim) {
        this.icnDiasIncumplim = icnDiasIncumplim;
    }

    @OneToMany(mappedBy = "siiIncumplimientoContr")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiIncumplimientoContr(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiIncumplimientoContr(null);
        return siiCuotaOperador;
    }

    @Column(name = "ICN_CANTIDAD_ELEM")
    public Integer getIcnCantidadElem() {
        return icnCantidadElem;
    }
    
    public void setIcnCantidadElem(Integer icnCantidadElem) {
        this.icnCantidadElem = icnCantidadElem;
    }

    @OneToMany(mappedBy = "siiIncumplimientoContr")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiIncumplimientoContr(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiIncumplimientoContr(null);
        return siiDocumentoContable;
    }

    @Column(name = "ICN_SUPERO_INC", length = 1)
    public String getIcnSuperoInc() {
        return icnSuperoInc;
    }
    
    public void setIcnSuperoInc(String icnSuperoInc) {
        this.icnSuperoInc = icnSuperoInc;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_REG")
    public SiiUsuario getSiiUsuarioRegistra() {
        return siiUsuarioRegistra;
    }

    public void setSiiUsuarioRegistra(SiiUsuario siiUsuarioRegistra) {
        this.siiUsuarioRegistra = siiUsuarioRegistra;
    }

    @OneToMany(mappedBy = "siiIncumplimientoContr")
    public List<SiiActaSuspenAudIncumCon> getSiiActaSuspenAudIncumConList() {
        return siiActaSuspenAudIncumConList;
    }

    public void setSiiActaSuspenAudIncumConList(List<SiiActaSuspenAudIncumCon> siiActaSuspenAudIncumConList) {
        this.siiActaSuspenAudIncumConList = siiActaSuspenAudIncumConList;
    }

    public SiiActaSuspenAudIncumCon addSiiActaSuspenAudIncumCon(SiiActaSuspenAudIncumCon siiActaSuspenAudIncumCon) {
        getSiiActaSuspenAudIncumConList().add(siiActaSuspenAudIncumCon);
        siiActaSuspenAudIncumCon.setSiiIncumplimientoContr(this);
        return siiActaSuspenAudIncumCon;
    }

    public SiiActaSuspenAudIncumCon removeSiiActaSuspenAudIncumCon(SiiActaSuspenAudIncumCon siiActaSuspenAudIncumCon) {
        getSiiActaSuspenAudIncumConList().remove(siiActaSuspenAudIncumCon);
        siiActaSuspenAudIncumCon.setSiiIncumplimientoContr(null);
        return siiActaSuspenAudIncumCon;
    }

    @OneToMany(mappedBy = "siiIncumplimientoContr")
    public List<SiiInhabilidadPersona> getSiiInhabilidadPersonaList() {
        return siiInhabilidadPersonaList;
    }

    public void setSiiInhabilidadPersonaList(List<SiiInhabilidadPersona> siiInhabilidadPersonaList) {
        this.siiInhabilidadPersonaList = siiInhabilidadPersonaList;
    }

    public SiiInhabilidadPersona addSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaList().add(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiIncumplimientoContr(this);
        return siiInhabilidadPersona;
    }

    public SiiInhabilidadPersona removeSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaList().remove(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiIncumplimientoContr(null);
        return siiInhabilidadPersona;
    }

    @Column(name = "ICN_REP_LEG_PRIM_APE_CIT_AUD", length = 20)
    public String getIcnRepLegPrimApeCitAud() {
        return icnRepLegPrimApeCitAud;
    }

    public void setIcnRepLegPrimApeCitAud(String icnRepLegPrimApeCitAud) {
        this.icnRepLegPrimApeCitAud = icnRepLegPrimApeCitAud;
    }

    @Column(name = "ICN_REP_LEG_PRIM_NOM_CIT_AUD", length = 20)
    public String getIcnRepLegPrimNomCitAud() {
        return icnRepLegPrimNomCitAud;
    }

    public void setIcnRepLegPrimNomCitAud(String icnRepLegPrimNomCitAud) {
        this.icnRepLegPrimNomCitAud = icnRepLegPrimNomCitAud;
    }

    @Column(name = "ICN_REP_LEG_SEG_APE_CIT_AUD", length = 20)
    public String getIcnRepLegSegApeCitAud() {
        return icnRepLegSegApeCitAud;
    }

    public void setIcnRepLegSegApeCitAud(String icnRepLegSegApeCitAud) {
        this.icnRepLegSegApeCitAud = icnRepLegSegApeCitAud;
    }

    @Column(name = "ICN_REP_LEG_SEG_NOM_CIT_AUD", length = 20)
    public String getIcnRepLegSegNomCitAud() {
        return icnRepLegSegNomCitAud;
    }

    public void setIcnRepLegSegNomCitAud(String icnRepLegSegNomCitAud) {
        this.icnRepLegSegNomCitAud = icnRepLegSegNomCitAud;
    }
}
