package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_CARGA_ACTUACIONES_ADM")
public class SiiCargaActuacionesAdm implements Serializable {
    private static final long serialVersionUID = -8762508153571257890L;
    private Long caaCodigo;
    private Integer caaDiasPlazo;
    private String caaEstado;
    private Date caaFechaEjecut;
    private Date caaFechaFinInhab;
    private Date caaFechaIniInhab;
    private Date caaFechaMigracion;
    private Date caaFechaResoluc;
    private Long caaNumResolucion;
    private String caaTipoDias;
    private SiiContrato siiContrato;
    private List<SiiCuotaOperador> siiCuotaOperadorList;
    private List<SiiConcepCuotCarActAdm> siiConcepCuotCarActAdmList;
    private SiiPersona siiPersona;
    private List<SiiPagoCargaActAdm> siiPagoCargaActAdmList;
    private SiiDocumentoContable siiDocumentoContable;
    private SiiProcesoOriCarga siiProcesoOriCarga;
    private SiiMotivoIncumplimiento siiMotivoIncumplimiento;
    private List<SiiAjusteContCarAct> siiAjusteContCarActList;
    private SiiUsuario siiUsuarioConectado;
    private List<SiiProyeccionCargaAct> siiProyeccionCargaActList;
    private List<SiiLiquidacionEstabl> siiLiquidacionEstablList;
    private Integer caaConsecutivo;

    public SiiCargaActuacionesAdm() {
    }

    public SiiCargaActuacionesAdm(Long caaCodigo, Integer caaDiasPlazo, String caaEstado, Date caaFechaEjecut, Date caaFechaFinInhab, Date caaFechaIniInhab, Date caaFechaMigracion,
                                  Date caaFechaResoluc, Long caaNumResolucion, String caaTipoDias, SiiContrato siiContrato, SiiDocumentoContable siiDocumentoContable,
                                  SiiMotivoIncumplimiento siiMotivoIncumplimiento, SiiPersona siiPersona, SiiProcesoOriCarga siiProcesoOriCarga, SiiUsuario siiUsuarioConectado) {
        this.caaCodigo = caaCodigo;
        this.caaDiasPlazo = caaDiasPlazo;
        this.caaEstado = caaEstado;
        this.caaFechaEjecut = caaFechaEjecut;
        this.caaFechaFinInhab = caaFechaFinInhab;
        this.caaFechaIniInhab = caaFechaIniInhab;
        this.caaFechaMigracion = caaFechaMigracion;
        this.caaFechaResoluc = caaFechaResoluc;
        this.caaNumResolucion = caaNumResolucion;
        this.caaTipoDias = caaTipoDias;
        this.siiContrato = siiContrato;
        this.siiDocumentoContable = siiDocumentoContable;
        this.siiMotivoIncumplimiento = siiMotivoIncumplimiento;
        this.siiPersona = siiPersona;
        this.siiProcesoOriCarga = siiProcesoOriCarga;
        this.siiUsuarioConectado = siiUsuarioConectado;
    }

    @Id
    @Column(name = "CAA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CARGA_ACTUAC_ADM_COD")
    @SequenceGenerator(name = "SEQ_CARGA_ACTUAC_ADM_COD", sequenceName = "SEQ_CARGA_ACTUAC_ADM_COD",allocationSize=1)
    public Long getCaaCodigo() {
        return caaCodigo;
    }

    public void setCaaCodigo(Long caaCodigo) {
        this.caaCodigo = caaCodigo;
    }

    @Column(name = "CAA_DIAS_PLAZO", nullable = false)
    public Integer getCaaDiasPlazo() {
        return caaDiasPlazo;
    }

    public void setCaaDiasPlazo(Integer caaDiasPlazo) {
        this.caaDiasPlazo = caaDiasPlazo;
    }

    @Column(name = "CAA_ESTADO", nullable = false, length = 1)
    public String getCaaEstado() {
        return caaEstado;
    }

    public void setCaaEstado(String caaEstado) {
        this.caaEstado = caaEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CAA_FECHA_EJECUT", nullable = false)
    public Date getCaaFechaEjecut() {
        return caaFechaEjecut;
    }

    public void setCaaFechaEjecut(Date caaFechaEjecut) {
        this.caaFechaEjecut = caaFechaEjecut;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CAA_FECHA_FIN_INHAB")
    public Date getCaaFechaFinInhab() {
        return caaFechaFinInhab;
    }

    public void setCaaFechaFinInhab(Date caaFechaFinInhab) {
        this.caaFechaFinInhab = caaFechaFinInhab;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CAA_FECHA_INI_INHAB")
    public Date getCaaFechaIniInhab() {
        return caaFechaIniInhab;
    }

    public void setCaaFechaIniInhab(Date caaFechaIniInhab) {
        this.caaFechaIniInhab = caaFechaIniInhab;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CAA_FECHA_MIGRACION")
    public Date getCaaFechaMigracion() {
        return caaFechaMigracion;
    }

    public void setCaaFechaMigracion(Date caaFechaMigracion) {
        this.caaFechaMigracion = caaFechaMigracion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CAA_FECHA_RESOLUC", nullable = false)
    public Date getCaaFechaResoluc() {
        return caaFechaResoluc;
    }

    public void setCaaFechaResoluc(Date caaFechaResoluc) {
        this.caaFechaResoluc = caaFechaResoluc;
    }

    @Column(name = "CAA_NUM_RESOLUCION", nullable = false)
    public Long getCaaNumResolucion() {
        return caaNumResolucion;
    }

    public void setCaaNumResolucion(Long caaNumResolucion) {
        this.caaNumResolucion = caaNumResolucion;
    }

    @Column(name = "CAA_TIPO_DIAS", nullable = false, length = 1)
    public String getCaaTipoDias() {
        return caaTipoDias;
    }

    public void setCaaTipoDias(String caaTipoDias) {
        this.caaTipoDias = caaTipoDias;
    }


    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @OneToMany(mappedBy = "siiCargaActuacionesAdm")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiCargaActuacionesAdm(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiCargaActuacionesAdm(null);
        return siiCuotaOperador;
    }

    @OneToMany(mappedBy = "siiCargaActuacionesAdm")
    public List<SiiConcepCuotCarActAdm> getSiiConcepCuotCarActAdmList() {
        return siiConcepCuotCarActAdmList;
    }

    public void setSiiConcepCuotCarActAdmList(List<SiiConcepCuotCarActAdm> siiConcepCuotCarActAdmList) {
        this.siiConcepCuotCarActAdmList = siiConcepCuotCarActAdmList;
    }

    public SiiConcepCuotCarActAdm addSiiConcepCuotCarActAdm(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm) {
        getSiiConcepCuotCarActAdmList().add(siiConcepCuotCarActAdm);
        siiConcepCuotCarActAdm.setSiiCargaActuacionesAdm(this);
        return siiConcepCuotCarActAdm;
    }

    public SiiConcepCuotCarActAdm removeSiiConcepCuotCarActAdm(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm) {
        getSiiConcepCuotCarActAdmList().remove(siiConcepCuotCarActAdm);
        siiConcepCuotCarActAdm.setSiiCargaActuacionesAdm(null);
        return siiConcepCuotCarActAdm;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @OneToMany(mappedBy = "siiCargaActuacionesAdm")
    public List<SiiPagoCargaActAdm> getSiiPagoCargaActAdmList() {
        return siiPagoCargaActAdmList;
    }

    public void setSiiPagoCargaActAdmList(List<SiiPagoCargaActAdm> siiPagoCargaActAdmList) {
        this.siiPagoCargaActAdmList = siiPagoCargaActAdmList;
    }

    public SiiPagoCargaActAdm addSiiPagoCargaActAdm(SiiPagoCargaActAdm siiPagoCargaActAdm) {
        getSiiPagoCargaActAdmList().add(siiPagoCargaActAdm);
        siiPagoCargaActAdm.setSiiCargaActuacionesAdm(this);
        return siiPagoCargaActAdm;
    }

    public SiiPagoCargaActAdm removeSiiPagoCargaActAdm(SiiPagoCargaActAdm siiPagoCargaActAdm) {
        getSiiPagoCargaActAdmList().remove(siiPagoCargaActAdm);
        siiPagoCargaActAdm.setSiiCargaActuacionesAdm(null);
        return siiPagoCargaActAdm;
    }

    @ManyToOne
    @JoinColumn(name = "DCO_CODIGO")
    public SiiDocumentoContable getSiiDocumentoContable() {
        return siiDocumentoContable;
    }

    public void setSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        this.siiDocumentoContable = siiDocumentoContable;
    }

    @ManyToOne
    @JoinColumn(name = "POC_CODIGO")
    public SiiProcesoOriCarga getSiiProcesoOriCarga() {
        return siiProcesoOriCarga;
    }

    public void setSiiProcesoOriCarga(SiiProcesoOriCarga siiProcesoOriCarga) {
        this.siiProcesoOriCarga = siiProcesoOriCarga;
    }

    @ManyToOne
    @JoinColumn(name = "MIN_CODIGO")
    public SiiMotivoIncumplimiento getSiiMotivoIncumplimiento() {
        return siiMotivoIncumplimiento;
    }

    public void setSiiMotivoIncumplimiento(SiiMotivoIncumplimiento siiMotivoIncumplimiento) {
        this.siiMotivoIncumplimiento = siiMotivoIncumplimiento;
    }

    @OneToMany(mappedBy = "siiCargaActuacionesAdm")
    public List<SiiAjusteContCarAct> getSiiAjusteContCarActList() {
        return siiAjusteContCarActList;
    }

    public void setSiiAjusteContCarActList(List<SiiAjusteContCarAct> siiAjusteContCarActList) {
        this.siiAjusteContCarActList = siiAjusteContCarActList;
    }

    public SiiAjusteContCarAct addSiiAjusteContCarAct(SiiAjusteContCarAct siiAjusteContCarAct) {
        getSiiAjusteContCarActList().add(siiAjusteContCarAct);
        siiAjusteContCarAct.setSiiCargaActuacionesAdm(this);
        return siiAjusteContCarAct;
    }

    public SiiAjusteContCarAct removeSiiAjusteContCarAct(SiiAjusteContCarAct siiAjusteContCarAct) {
        getSiiAjusteContCarActList().remove(siiAjusteContCarAct);
        siiAjusteContCarAct.setSiiCargaActuacionesAdm(null);
        return siiAjusteContCarAct;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConectado() {
        return siiUsuarioConectado;
    }

    public void setSiiUsuarioConectado(SiiUsuario siiUsuarioConectado) {
        this.siiUsuarioConectado = siiUsuarioConectado;
    }

    @OneToMany(mappedBy = "siiCargaActuacionesAdm")
    public List<SiiProyeccionCargaAct> getSiiProyeccionCargaActList() {
        return siiProyeccionCargaActList;
    }

    public void setSiiProyeccionCargaActList(List<SiiProyeccionCargaAct> siiProyeccionCargaActList) {
        this.siiProyeccionCargaActList = siiProyeccionCargaActList;
    }

    public SiiProyeccionCargaAct addSiiProyeccionCargaAct(SiiProyeccionCargaAct siiProyeccionCargaAct) {
        getSiiProyeccionCargaActList().add(siiProyeccionCargaAct);
        siiProyeccionCargaAct.setSiiCargaActuacionesAdm(this);
        return siiProyeccionCargaAct;
    }

    public SiiProyeccionCargaAct removeSiiProyeccionCargaAct(SiiProyeccionCargaAct siiProyeccionCargaAct) {
        getSiiProyeccionCargaActList().remove(siiProyeccionCargaAct);
        siiProyeccionCargaAct.setSiiCargaActuacionesAdm(null);
        return siiProyeccionCargaAct;
    }

    @OneToMany(mappedBy = "siiCargaActuacionesAdm")
    public List<SiiLiquidacionEstabl> getSiiLiquidacionEstablList() {
        return siiLiquidacionEstablList;
    }

    public void setSiiLiquidacionEstablList(List<SiiLiquidacionEstabl> siiLiquidacionEstablList) {
        this.siiLiquidacionEstablList = siiLiquidacionEstablList;
    }

    public SiiLiquidacionEstabl addSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablList().add(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiCargaActuacionesAdm(this);
        return siiLiquidacionEstabl;
    }

    public SiiLiquidacionEstabl removeSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablList().remove(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiCargaActuacionesAdm(null);
        return siiLiquidacionEstabl;
    }

    @Column(name = "CAA_CONSECUTIVO")
    public Integer getCaaConsecutivo() {
        return caaConsecutivo;
    }
    
    public void setCaaConsecutivo(Integer caaConsecutivo) {
        this.caaConsecutivo = caaConsecutivo;
    }
}
