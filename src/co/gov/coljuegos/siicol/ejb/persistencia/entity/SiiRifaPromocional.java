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
@Table(name = "SII_RIFA_PROMOCIONAL")
public class SiiRifaPromocional implements Serializable {
    private static final long serialVersionUID = 8463945242115754032L;
    private Long rfpCodigo;
    private Date rfpFechaFin;
    private Date rfpFechaInicio;
    private String rfpNombre;
    private BigDecimal rfpValorDe;
    private BigDecimal rfpValorGa;
    private BigDecimal rfpValorTotal;
    private List<SiiCuotaOperador> siiCuotaOperadorList;
    private SiiSolicitudAutoriza siiSolicitudAutoriza;
    private SiiTipoApuesta siiTipoApuesta;
    private Date rfpFechaResol;
    private String rfpResolucion;
    private Date rfpFechaResDesExp;
    private Date rfpFechaResDesTaci;
    private String rfpResolDesistExpr;
    private String rfpResolDesistTaci;
    private Integer rfpConsecutivo;


    public SiiRifaPromocional() {
    }

    public SiiRifaPromocional(Long rfpCodigo, Date rfpFechaFin, Date rfpFechaInicio, String rfpNombre, BigDecimal rfpValorDe,
                              BigDecimal rfpValorGa, BigDecimal rfpValorTotal, SiiSolicitudAutoriza siiSolicitudAutoriza,
                              SiiTipoApuesta siiTipoApuesta) {
        this.rfpCodigo = rfpCodigo;
        this.rfpFechaFin = rfpFechaFin;
        this.rfpFechaInicio = rfpFechaInicio;
        this.rfpNombre = rfpNombre;
        this.rfpValorDe = rfpValorDe;
        this.rfpValorGa = rfpValorGa;
        this.rfpValorTotal = rfpValorTotal;
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
        this.siiTipoApuesta = siiTipoApuesta;
    }

    @Id
    @Column(name = "RFP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RIFA_PROMOCIONAL_COD")
    @SequenceGenerator(name = "SEQ_RIFA_PROMOCIONAL_COD", sequenceName = "SEQ_RIFA_PROMOCIONAL_COD",allocationSize=1)
    public Long getRfpCodigo() {
        return rfpCodigo;
    }

    public void setRfpCodigo(Long rfpCodigo) {
        this.rfpCodigo = rfpCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RFP_FECHA_FIN", nullable = false)
    public Date getRfpFechaFin() {
        return rfpFechaFin;
    }

    public void setRfpFechaFin(Date rfpFechaFin) {
        this.rfpFechaFin = rfpFechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RFP_FECHA_INICIO", nullable = false)
    public Date getRfpFechaInicio() {
        return rfpFechaInicio;
    }

    public void setRfpFechaInicio(Date rfpFechaInicio) {
        this.rfpFechaInicio = rfpFechaInicio;
    }

    @Column(name = "RFP_NOMBRE", nullable = false, length = 550)
    public String getRfpNombre() {
        return rfpNombre;
    }

    public void setRfpNombre(String rfpNombre) {
        this.rfpNombre = rfpNombre;
    }

    @Column(name = "RFP_VALOR_DE", nullable = false)
    public BigDecimal getRfpValorDe() {
        return rfpValorDe;
    }

    public void setRfpValorDe(BigDecimal rfpValorDe) {
        this.rfpValorDe = rfpValorDe;
    }

    @Column(name = "RFP_VALOR_GA", nullable = false)
    public BigDecimal getRfpValorGa() {
        return rfpValorGa;
    }

    public void setRfpValorGa(BigDecimal rfpValorGa) {
        this.rfpValorGa = rfpValorGa;
    }

    @Column(name = "RFP_VALOR_TOTAL", nullable = false)
    public BigDecimal getRfpValorTotal() {
        return rfpValorTotal;
    }

    public void setRfpValorTotal(BigDecimal rfpValorTotal) {
        this.rfpValorTotal = rfpValorTotal;
    }


    @OneToMany(mappedBy = "siiRifaPromocional")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiRifaPromocional(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiRifaPromocional(null);
        return siiCuotaOperador;
    }

    @ManyToOne
    @JoinColumn(name = "SAU_CODIGO")
    public SiiSolicitudAutoriza getSiiSolicitudAutoriza() {
        return siiSolicitudAutoriza;
    }

    public void setSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
    }

    @ManyToOne
    @JoinColumn(name = "TAP_CODIGO")
    public SiiTipoApuesta getSiiTipoApuesta() {
        return siiTipoApuesta;
    }

    public void setSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        this.siiTipoApuesta = siiTipoApuesta;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RFP_FECHA_RESOL")
    public Date getRfpFechaResol() {
        return rfpFechaResol;
    }

    public void setRfpFechaResol(Date rfpFechaResol) {
        this.rfpFechaResol = rfpFechaResol;
    }

    @Column(name = "RFP_RESOLUCION", length = 10)
    public String getRfpResolucion() {
        return rfpResolucion;
    }

    public void setRfpResolucion(String rfpResolucion) {
        this.rfpResolucion = rfpResolucion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RFP_FECHA_RES_DES_EXP")
    public Date getRfpFechaResDesExp() {
        return rfpFechaResDesExp;
    }

    public void setRfpFechaResDesExp(Date rfpFechaResDesExp) {
        this.rfpFechaResDesExp = rfpFechaResDesExp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RFP_FECHA_RES_DES_TACI")
    public Date getRfpFechaResDesTaci() {
        return rfpFechaResDesTaci;
    }

    public void setRfpFechaResDesTaci(Date rfpFechaResDesTaci) {
        this.rfpFechaResDesTaci = rfpFechaResDesTaci;
    }

    @Column(name = "RFP_RESOL_DESIST_EXPR", length = 30)
    public String getRfpResolDesistExpr() {
        return rfpResolDesistExpr;
    }

    public void setRfpResolDesistExpr(String rfpResolDesistExpr) {
        this.rfpResolDesistExpr = rfpResolDesistExpr;
    }

    @Column(name = "RFP_RESOL_DESIST_TACI", length = 10)
    public String getRfpResolDesistTaci() {
        return rfpResolDesistTaci;
    }

    public void setRfpResolDesistTaci(String rfpResolDesistTaci) {
        this.rfpResolDesistTaci = rfpResolDesistTaci;
    }

    @Column(name = "RFP_CONSECUTIVO")
    public Integer getRfpConsecutivo() {
        return rfpConsecutivo;
    }

    public void setRfpConsecutivo(Integer rfpConsecutivo) {
        this.rfpConsecutivo = rfpConsecutivo;
    }

}
