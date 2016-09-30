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
@Table(name = "SII_OFICIO_LIQUIDACION")
public class SiiOficioLiquidacion implements Serializable {
    private static final long serialVersionUID = -5782898178479596015L;
    private Long oliCodigo;
    private Integer oliConsecutivo;
    private Date oliFechaOficio;
    private List<SiiOficLiqTipoApuesta> siiOficLiqTipoApuestaList;
    private SiiSolicitudAutoriza siiSolicitudAutoriza;
    private SiiEstadoOficioLiq siiEstadoOficioLiq;
    private BigDecimal oliValorDerExpl;
    private BigDecimal oliValorGastAdm;
    private List<SiiGarantPolizaOficLiq> siiGarantPolizaOficLiqList;
    private BigDecimal oliMesesEjecutar;


    public SiiOficioLiquidacion() {
    }

    public SiiOficioLiquidacion(SiiEstadoOficioLiq siiEstadoOficioLiq, Long oliCodigo, Integer oliConsecutivo,
                                Date oliFechaOficio, SiiSolicitudAutoriza siiSolicitudAutoriza,
							BigDecimal oliValorDerExpl, BigDecimal oliValorGastAdm) {
        this.siiEstadoOficioLiq = siiEstadoOficioLiq;
        this.oliCodigo = oliCodigo;
        this.oliConsecutivo = oliConsecutivo;
        this.oliFechaOficio = oliFechaOficio;
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
        this.oliValorDerExpl = oliValorDerExpl;
        this.oliValorGastAdm = oliValorGastAdm;

    }


    @Id
    @Column(name = "OLI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OFICIO_LIQUIDACION_COD")
    @SequenceGenerator(name = "SEQ_OFICIO_LIQUIDACION_COD", sequenceName = "SEQ_OFICIO_LIQUIDACION_COD",allocationSize=1)
    public Long getOliCodigo() {
        return oliCodigo;
    }

    public void setOliCodigo(Long oliCodigo) {
        this.oliCodigo = oliCodigo;
    }

    @Column(name = "OLI_CONSECUTIVO", nullable = false)
    public Integer getOliConsecutivo() {
        return oliConsecutivo;
    }

    public void setOliConsecutivo(Integer oliConsecutivo) {
        this.oliConsecutivo = oliConsecutivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OLI_FECHA_OFICIO", nullable = false)
    public Date getOliFechaOficio() {
        return oliFechaOficio;
    }

    public void setOliFechaOficio(Date oliFechaOficio) {
        this.oliFechaOficio = oliFechaOficio;
    }


    @OneToMany(mappedBy = "siiOficioLiquidacion")
    public List<SiiOficLiqTipoApuesta> getSiiOficLiqTipoApuestaList() {
        return siiOficLiqTipoApuestaList;
    }

    public void setSiiOficLiqTipoApuestaList(List<SiiOficLiqTipoApuesta> siiOficLiqTipoApuestaList) {
        this.siiOficLiqTipoApuestaList = siiOficLiqTipoApuestaList;
    }

    public SiiOficLiqTipoApuesta addSiiOficLiqTipoApuesta(SiiOficLiqTipoApuesta siiOficLiqTipoApuesta) {
        getSiiOficLiqTipoApuestaList().add(siiOficLiqTipoApuesta);
        siiOficLiqTipoApuesta.setSiiOficioLiquidacion(this);
        return siiOficLiqTipoApuesta;
    }

    public SiiOficLiqTipoApuesta removeSiiOficLiqTipoApuesta(SiiOficLiqTipoApuesta siiOficLiqTipoApuesta) {
        getSiiOficLiqTipoApuestaList().remove(siiOficLiqTipoApuesta);
        siiOficLiqTipoApuesta.setSiiOficioLiquidacion(null);
        return siiOficLiqTipoApuesta;
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
    @JoinColumn(name = "EOL_CODIGO")
    public SiiEstadoOficioLiq getSiiEstadoOficioLiq() {
        return siiEstadoOficioLiq;
    }

    public void setSiiEstadoOficioLiq(SiiEstadoOficioLiq siiEstadoOficioLiq) {
        this.siiEstadoOficioLiq = siiEstadoOficioLiq;
    }

    @Column(name = "OLI_VALOR_DER_EXPL", nullable = false)
    public BigDecimal getOliValorDerExpl() {
        return oliValorDerExpl;
    }

    public void setOliValorDerExpl(BigDecimal oliValorDerExpl) {
        this.oliValorDerExpl = oliValorDerExpl;
    }

    @Column(name = "OLI_VALOR_GAST_ADM", nullable = false)
    public BigDecimal getOliValorGastAdm() {
        return oliValorGastAdm;
    }

    public void setOliValorGastAdm(BigDecimal oliValorGastAdm) {
        this.oliValorGastAdm = oliValorGastAdm;
    }

    @OneToMany(mappedBy = "siiOficioLiquidacion")
    public List<SiiGarantPolizaOficLiq> getSiiGarantPolizaOficLiqList() {
        return siiGarantPolizaOficLiqList;
    }

    public void setSiiGarantPolizaOficLiqList(List<SiiGarantPolizaOficLiq> siiGarantPolizaOficLiqList) {
        this.siiGarantPolizaOficLiqList = siiGarantPolizaOficLiqList;
    }

    public SiiGarantPolizaOficLiq addSiiGarantPolizaOficLiq(SiiGarantPolizaOficLiq siiGarantPolizaOficLiq) {
        getSiiGarantPolizaOficLiqList().add(siiGarantPolizaOficLiq);
        siiGarantPolizaOficLiq.setSiiOficioLiquidacion(this);
        return siiGarantPolizaOficLiq;
    }

    public SiiGarantPolizaOficLiq removeSiiGarantPolizaOficLiq(SiiGarantPolizaOficLiq siiGarantPolizaOficLiq) {
        getSiiGarantPolizaOficLiqList().remove(siiGarantPolizaOficLiq);
        siiGarantPolizaOficLiq.setSiiOficioLiquidacion(null);
        return siiGarantPolizaOficLiq;
    }

    @Column(name = "OLI_MESES_EJECUTAR")
    public BigDecimal getOliMesesEjecutar() {
        return oliMesesEjecutar;
    }
    
    public void setOliMesesEjecutar(BigDecimal oliMesesEjecutar) {
        this.oliMesesEjecutar = oliMesesEjecutar;
    }
}
