package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_LIQUIDACION_CONTRATO")
public class SiiLiquidacionContrato implements Serializable {
    private static final long serialVersionUID = -428362294434253762L;
    private Long lcoCodigo;
    private Date lcoFechaCita;
    private String lcoIndicaEstCta;
    private SiiContrato siiContrato;
    private SiiCausalTermContr siiCausalTermContr;
    private SiiEstadoLiquidCont siiEstadoLiquidCont;
    private List<SiiResolucionLiquid> siiResolucionLiquidList;
    private Date lcoFechaGenInfFin;
    private Date lcoFechaBorrCit;
    private Date lcoFechaGenOfiCit;
    private Date lcoFechaLiq;
    private SiiArchivoFisico siiArchivoFisicoInfFinal;
    private SiiArchivoFisico siiArchivoFisicoOficioCita;
    private SiiArchivoFisico siiArchivoFisicoActaLiq;
    private String lcoRadicadoInfFin;
    private String lcoRadicadoOfiCit;

    public SiiLiquidacionContrato() {
    }

    public SiiLiquidacionContrato(SiiContrato siiContrato, SiiCausalTermContr siiCausalTermContr,
                                  SiiEstadoLiquidCont siiEstadoLiquidCont, Long lcoCodigo, Date lcoFechaCita,
                                  String lcoIndicaEstCta) {
        this.siiContrato = siiContrato;
        this.siiCausalTermContr = siiCausalTermContr;
        this.siiEstadoLiquidCont = siiEstadoLiquidCont;
        this.lcoCodigo = lcoCodigo;
        this.lcoFechaCita = lcoFechaCita;
        this.lcoIndicaEstCta = lcoIndicaEstCta;
    }


    @Id
    @Column(name = "LCO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_LIQUIDACION_CONTRATO_COD")
    @SequenceGenerator(name = "SEQ_LIQUIDACION_CONTRATO_COD", sequenceName = "SEQ_LIQUIDACION_CONTRATO_COD",allocationSize=1)
    public Long getLcoCodigo() {
        return lcoCodigo;
    }

    public void setLcoCodigo(Long lcoCodigo) {
        this.lcoCodigo = lcoCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LCO_FECHA_CITA")
    public Date getLcoFechaCita() {
        return lcoFechaCita;
    }

    public void setLcoFechaCita(Date lcoFechaCita) {
        this.lcoFechaCita = lcoFechaCita;
    }

    @Column(name = "LCO_INDICA_EST_CTA", nullable = false, length = 2)
    public String getLcoIndicaEstCta() {
        return lcoIndicaEstCta;
    }

    public void setLcoIndicaEstCta(String lcoIndicaEstCta) {
        this.lcoIndicaEstCta = lcoIndicaEstCta;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @ManyToOne
    @JoinColumn(name = "CTC_CODIGO")
    public SiiCausalTermContr getSiiCausalTermContr() {
        return siiCausalTermContr;
    }

    public void setSiiCausalTermContr(SiiCausalTermContr siiCausalTermContr) {
        this.siiCausalTermContr = siiCausalTermContr;
    }

    @ManyToOne
    @JoinColumn(name = "ELC_CODIGO")
    public SiiEstadoLiquidCont getSiiEstadoLiquidCont() {
        return siiEstadoLiquidCont;
    }

    public void setSiiEstadoLiquidCont(SiiEstadoLiquidCont siiEstadoLiquidCont) {
        this.siiEstadoLiquidCont = siiEstadoLiquidCont;
    }

    @OneToMany(mappedBy = "siiLiquidacionContrato")
    public List<SiiResolucionLiquid> getSiiResolucionLiquidList() {
        return siiResolucionLiquidList;
    }

    public void setSiiResolucionLiquidList(List<SiiResolucionLiquid> siiResolucionLiquidList) {
        this.siiResolucionLiquidList = siiResolucionLiquidList;
    }

    public SiiResolucionLiquid addSiiResolucionLiquid(SiiResolucionLiquid siiResolucionLiquid) {
        getSiiResolucionLiquidList().add(siiResolucionLiquid);
        siiResolucionLiquid.setSiiLiquidacionContrato(this);
        return siiResolucionLiquid;
    }

    public SiiResolucionLiquid removeSiiResolucionLiquid(SiiResolucionLiquid siiResolucionLiquid) {
        getSiiResolucionLiquidList().remove(siiResolucionLiquid);
        siiResolucionLiquid.setSiiLiquidacionContrato(null);
        return siiResolucionLiquid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LCO_FECHA_GEN_INF_FIN")
    public Date getLcoFechaGenInfFin() {
        return lcoFechaGenInfFin;
    }

    public void setLcoFechaGenInfFin(Date lcoFechaGenInfFin) {
        this.lcoFechaGenInfFin = lcoFechaGenInfFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LCO_FECHA_BORR_CIT")
    public Date getLcoFechaBorrCit() {
        return lcoFechaBorrCit;
    }
    
    public void setLcoFechaBorrCit(Date lcoFechaBorrCit) {
        this.lcoFechaBorrCit = lcoFechaBorrCit;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LCO_FECHA_GEN_OFI_CIT")
    public Date getLcoFechaGenOfiCit() {
        return lcoFechaGenOfiCit;
    }
    
    public void setLcoFechaGenOfiCit(Date lcoFechaGenOfiCit) {
        this.lcoFechaGenOfiCit = lcoFechaGenOfiCit;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LCO_FECHA_LIQ")
    public Date getLcoFechaLiq() {
        return lcoFechaLiq;
    }
    
    public void setLcoFechaLiq(Date lcoFechaLiq) {
        this.lcoFechaLiq = lcoFechaLiq;
    }
    
    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO_INFORME")
    public SiiArchivoFisico getSiiArchivoFisicoInfFinal() {
        return siiArchivoFisicoInfFinal;
    }

    public void setSiiArchivoFisicoInfFinal(SiiArchivoFisico siiArchivoFisicoInfFinal) {
        this.siiArchivoFisicoInfFinal = siiArchivoFisicoInfFinal;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO_OFICIO_CIT")
    public SiiArchivoFisico getSiiArchivoFisicoOficioCita() {
        return siiArchivoFisicoOficioCita;
    }

    public void setSiiArchivoFisicoOficioCita(SiiArchivoFisico siiArchivoFisicoOficioCita) {
        this.siiArchivoFisicoOficioCita = siiArchivoFisicoOficioCita;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO_ACTA_LIQ")
    public SiiArchivoFisico getSiiArchivoFisicoActaLiq() {
        return siiArchivoFisicoActaLiq;
    }

    public void setSiiArchivoFisicoActaLiq(SiiArchivoFisico siiArchivoFisicoActaLiq) {
        this.siiArchivoFisicoActaLiq = siiArchivoFisicoActaLiq;
    }

    @Column(name = "LCO_RADICADO_INF_FIN", nullable = false, length = 30)
    public String getLcoRadicadoInfFin() {
        return lcoRadicadoInfFin;
    }
    
    public void setLcoRadicadoInfFin(String lcoRadicadoInfFin) {
        this.lcoRadicadoInfFin = lcoRadicadoInfFin;
    }

    @Column(name = "LCO_RADICADO_OFI_CIT", nullable = false, length = 30)
    public String getLcoRadicadoOfiCit() {
        return lcoRadicadoOfiCit;
    }
    
    public void setLcoRadicadoOfiCit(String lcoRadicadoOfiCit) {
        this.lcoRadicadoOfiCit = lcoRadicadoOfiCit;
    }

}
