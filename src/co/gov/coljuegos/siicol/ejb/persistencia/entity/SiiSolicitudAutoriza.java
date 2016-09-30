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
@Table(name = "SII_SOLICITUD_AUTORIZA")
public class SiiSolicitudAutoriza implements Serializable {
    private Long sauCodigo;
    private Date sauFecha;
    private Integer sauMovimientoSiito;
    private String sauNit;
    private List<SiiNovedad> siiNovedadList;
    private SiiTipoSolicAutoriza siiTipoSolicAutoriza;
    private Integer sauTiempoContr;
    private SiiEstadoSolicAutoriz siiEstadoSolicAutoriz;
    private List<SiiResolucionAutoriz> siiResolucionAutorizList;
    private List<SiiOficioLiquidacion> siiOficioLiquidacionList;
    private List<SiiDetalleFinanc> siiDetalleFinancList;
    private BigDecimal sauValorEstimado;
    private BigDecimal sauValorProrroga;
    private SiiExpedienteFisico siiExpedienteFisico;
    private SiiSolicitudAutoriza siiSolicitudAutDesistida;
    private List<SiiSolicitudAutoriza> siiSolicitudAutDesistidaPorList;
    private SiiExpedienteDocum siiExpedienteDocum;
    private List<SiiRifaPromocional> siiRifaPromocionalList;
    private SiiPersona siiPersonaRifaProm;
    private SiiUsuario siiUsuario;
    private Integer sauAmpliacion;
    private String sauNitCesionario;

    public SiiSolicitudAutoriza() {
    }

    public SiiSolicitudAutoriza(Long sauCodigo, Date sauFecha,
                                SiiEstadoSolicAutoriz siiEstadoSolicAutoriz, SiiTipoSolicAutoriza siiTipoSolicAutoriza,
                                Integer sauTiempoContr, String sauNit, Integer sauMovimientoSiito,
                                BigDecimal sauValorEstimado, BigDecimal sauValorProrroga) {
        this.sauCodigo = sauCodigo;
        this.sauFecha = sauFecha;
        this.sauMovimientoSiito = sauMovimientoSiito;
        this.sauNit = sauNit;
        this.siiTipoSolicAutoriza = siiTipoSolicAutoriza;
        this.sauTiempoContr = sauTiempoContr;
        this.siiEstadoSolicAutoriz = siiEstadoSolicAutoriz;
        this.sauValorEstimado = sauValorEstimado;
        this.sauValorProrroga = sauValorProrroga;


    }

    @Id
    @Column(name = "SAU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SOLICITUD_AUTORIZ_COD")
    @SequenceGenerator(name = "SEQ_SOLICITUD_AUTORIZ_COD", sequenceName = "SEQ_SOLICITUD_AUTORIZ_COD",
                       allocationSize = 1)
    public Long getSauCodigo() {
        return sauCodigo;
    }

    public void setSauCodigo(Long sauCodigo) {
        this.sauCodigo = sauCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SAU_FECHA", nullable = false)
    public Date getSauFecha() {
        return sauFecha;
    }

    public void setSauFecha(Date sauFecha) {
        this.sauFecha = sauFecha;
    }

    @Column(name = "SAU_MOVIMIENTO_SIITO")
    public Integer getSauMovimientoSiito() {
        return sauMovimientoSiito;
    }

    public void setSauMovimientoSiito(Integer sauMovimientoSiito) {
        this.sauMovimientoSiito = sauMovimientoSiito;
    }

    @Column(name = "SAU_NIT", length = 20)
    public String getSauNit() {
        return sauNit;
    }

    public void setSauNit(String sauNit) {
        this.sauNit = sauNit;
    }


    @OneToMany(mappedBy = "siiSolicitudAutoriza")
    public List<SiiNovedad> getSiiNovedadList() {
        return siiNovedadList;
    }

    public void setSiiNovedadList(List<SiiNovedad> siiNovedadList) {
        this.siiNovedadList = siiNovedadList;
    }

    public SiiNovedad addSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().add(siiNovedad);
        siiNovedad.setSiiSolicitudAutoriza(this);
        return siiNovedad;
    }

    public SiiNovedad removeSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().remove(siiNovedad);
        siiNovedad.setSiiSolicitudAutoriza(null);
        return siiNovedad;
    }

    @ManyToOne
    @JoinColumn(name = "TSA_CODIGO")
    public SiiTipoSolicAutoriza getSiiTipoSolicAutoriza() {
        return siiTipoSolicAutoriza;
    }

    public void setSiiTipoSolicAutoriza(SiiTipoSolicAutoriza siiTipoSolicAutoriza) {
        this.siiTipoSolicAutoriza = siiTipoSolicAutoriza;
    }

    @Column(name = "SAU_TIEMPO_CONTR")
    public Integer getSauTiempoContr() {
        return sauTiempoContr;
    }

    public void setSauTiempoContr(Integer sauTiempoContr) {
        this.sauTiempoContr = sauTiempoContr;
    }

    @ManyToOne
    @JoinColumn(name = "ESA_CODIGO")
    public SiiEstadoSolicAutoriz getSiiEstadoSolicAutoriz() {
        return siiEstadoSolicAutoriz;
    }

    public void setSiiEstadoSolicAutoriz(SiiEstadoSolicAutoriz siiEstadoSolicAutoriz) {
        this.siiEstadoSolicAutoriz = siiEstadoSolicAutoriz;
    }

    @OneToMany(mappedBy = "siiSolicitudAutoriza")
    public List<SiiResolucionAutoriz> getSiiResolucionAutorizList() {
        return siiResolucionAutorizList;
    }

    public void setSiiResolucionAutorizList(List<SiiResolucionAutoriz> siiResolucionAutorizList) {
        this.siiResolucionAutorizList = siiResolucionAutorizList;
    }

    public SiiResolucionAutoriz addSiiResolucionAutoriz(SiiResolucionAutoriz siiResolucionAutoriz) {
        getSiiResolucionAutorizList().add(siiResolucionAutoriz);
        siiResolucionAutoriz.setSiiSolicitudAutoriza(this);
        return siiResolucionAutoriz;
    }

    public SiiResolucionAutoriz removeSiiResolucionAutoriz(SiiResolucionAutoriz siiResolucionAutoriz) {
        getSiiResolucionAutorizList().remove(siiResolucionAutoriz);
        siiResolucionAutoriz.setSiiSolicitudAutoriza(null);
        return siiResolucionAutoriz;
    }

    @OneToMany(mappedBy = "siiSolicitudAutoriza")
    public List<SiiOficioLiquidacion> getSiiOficioLiquidacionList() {
        return siiOficioLiquidacionList;
    }

    public void setSiiOficioLiquidacionList(List<SiiOficioLiquidacion> siiOficioLiquidacionList) {
        this.siiOficioLiquidacionList = siiOficioLiquidacionList;
    }

    public SiiOficioLiquidacion addSiiOficioLiquidacion(SiiOficioLiquidacion siiOficioLiquidacion) {
        getSiiOficioLiquidacionList().add(siiOficioLiquidacion);
        siiOficioLiquidacion.setSiiSolicitudAutoriza(this);
        return siiOficioLiquidacion;
    }

    public SiiOficioLiquidacion removeSiiOficioLiquidacion(SiiOficioLiquidacion siiOficioLiquidacion) {
        getSiiOficioLiquidacionList().remove(siiOficioLiquidacion);
        siiOficioLiquidacion.setSiiSolicitudAutoriza(null);
        return siiOficioLiquidacion;
    }

    @OneToMany(mappedBy = "siiSolicitudAutoriza")
    public List<SiiDetalleFinanc> getSiiDetalleFinancList() {
        return siiDetalleFinancList;
    }

    public void setSiiDetalleFinancList(List<SiiDetalleFinanc> siiDetalleFinancList) {
        this.siiDetalleFinancList = siiDetalleFinancList;
    }

    public SiiDetalleFinanc addSiiDetalleFinanc(SiiDetalleFinanc siiDetalleFinanc) {
        getSiiDetalleFinancList().add(siiDetalleFinanc);
        siiDetalleFinanc.setSiiSolicitudAutoriza(this);
        return siiDetalleFinanc;
    }

    public SiiDetalleFinanc removeSiiDetalleFinanc(SiiDetalleFinanc siiDetalleFinanc) {
        getSiiDetalleFinancList().remove(siiDetalleFinanc);
        siiDetalleFinanc.setSiiSolicitudAutoriza(null);
        return siiDetalleFinanc;
    }

    @Column(name = "SAU_VALOR_ESTIMADO")
    public BigDecimal getSauValorEstimado() {
        return sauValorEstimado;
    }

    public void setSauValorEstimado(BigDecimal sauValorEstimado) {
        this.sauValorEstimado = sauValorEstimado;
    }

    @Column(name = "SAU_VALOR_PRORROGA")
    public BigDecimal getSauValorProrroga() {
        return sauValorProrroga;
    }

    public void setSauValorProrroga(BigDecimal sauValorProrroga) {
        this.sauValorProrroga = sauValorProrroga;
    }

    @ManyToOne
    @JoinColumn(name = "EFI_CODIGO")
    public SiiExpedienteFisico getSiiExpedienteFisico() {
        return siiExpedienteFisico;
    }

    public void setSiiExpedienteFisico(SiiExpedienteFisico siiExpedienteFisico) {
        this.siiExpedienteFisico = siiExpedienteFisico;
    }


    @ManyToOne
    @JoinColumn(name = "SAU_CODIGO_DESISTIDA")
    public SiiSolicitudAutoriza getSiiSolicitudAutDesistida() {
        return siiSolicitudAutDesistida;
    }

    public void setSiiSolicitudAutDesistida(SiiSolicitudAutoriza siiSolicitudAutDesistida) {
        this.siiSolicitudAutDesistida = siiSolicitudAutDesistida;
    }
    
    @OneToMany(mappedBy = "siiSolicitudAutDesistida")
    public List<SiiSolicitudAutoriza> getSiiSolicitudAutDesistidaPorList() {
        return siiSolicitudAutDesistidaPorList;
    }

    public void setSiiSolicitudAutDesistidaPorList(List<SiiSolicitudAutoriza> siiSolicitudAutDesistidaPorList) {
        this.siiSolicitudAutDesistidaPorList = siiSolicitudAutDesistidaPorList;
    }

    @ManyToOne
    @JoinColumn(name = "EDO_CODIGO")
    public SiiExpedienteDocum getSiiExpedienteDocum() {
        return siiExpedienteDocum;
    }

    public void setSiiExpedienteDocum(SiiExpedienteDocum siiExpedienteDocum) {
        this.siiExpedienteDocum = siiExpedienteDocum;
    }

    @OneToMany(mappedBy = "siiSolicitudAutoriza")
    public List<SiiRifaPromocional> getSiiRifaPromocionalList() {
        return siiRifaPromocionalList;
    }

    public void setSiiRifaPromocionalList(List<SiiRifaPromocional> siiRifaPromocionalList) {
        this.siiRifaPromocionalList = siiRifaPromocionalList;
    }

    public SiiRifaPromocional addSiiRifaPromocional(SiiRifaPromocional siiRifaPromocional) {
        getSiiRifaPromocionalList().add(siiRifaPromocional);
        siiRifaPromocional.setSiiSolicitudAutoriza(this);
        return siiRifaPromocional;
    }

    public SiiRifaPromocional removeSiiRifaPromocional(SiiRifaPromocional siiRifaPromocional) {
        getSiiRifaPromocionalList().remove(siiRifaPromocional);
        siiRifaPromocional.setSiiSolicitudAutoriza(null);
        return siiRifaPromocional;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO_RIF")
    public SiiPersona getSiiPersonaRifaProm() {
        return siiPersonaRifaProm;
    }

    public void setSiiPersonaRifaProm(SiiPersona siiPersonaRifaProm) {
        this.siiPersonaRifaProm = siiPersonaRifaProm;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @Column(name = "SAU_AMPLIACION")
    public Integer getSauAmpliacion() {
        return sauAmpliacion;
    }
    
    public void setSauAmpliacion(Integer sauAmpliacion) {
        this.sauAmpliacion = sauAmpliacion;
    }

    @Column(name = "SAU_NIT_CESIONARIO", length = 20)
    public String getSauNitCesionario() {
        return sauNitCesionario;
    }
    
    public void setSauNitCesionario(String sauNitCesionario) {
        this.sauNitCesionario = sauNitCesionario;
    }
}
