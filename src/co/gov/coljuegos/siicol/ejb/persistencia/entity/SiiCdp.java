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
@Table(name = "SII_CDP")
public class SiiCdp implements Serializable {
    private Long cdpCodigo;
    private Date cdpFechaSolic;
    private Date cdpFechaVigFut;
    private String cdpJustificacion;
    private String cdpNumeroDocSop;
    private Long cdpNumeroSiif;
    private String cdpObjeto;
    private BigDecimal cdpSaldoAnterior;
    private BigDecimal cdpValorSolicit;
    private Integer cdpVigencia;
    private Integer cdpVigenciaAfectada;
    private SiiUsuario siiUsuario;
    private SiiProcesoContratacion siiProcesoContratacion;
    private SiiEstadoCdp siiEstadoCdp;
    private SiiAreaColjuegos siiAreaColjuegos;
    private List<SiiDetalleRubroCdp> siiDetalleRubroCdpList;
    private SiiTipoDocSoporte siiTipoDocSoporte;
    private SiiItemPlanContratac siiItemPlanContratac;
    private Long cdpConsecutivo;
    private List<SiiModificacionCdp> siiModificacionCdpList;
    private Date cdpFechaExpedicion;
    private List<SiiRp> siiRpList;
    private String cdpNumVigFut;
    private Long cdpNumContrato;
    private Date cdpFechaCont;
    private String cdpObjetoCont;
    private List<SiiCdpRp> siiCdpRpList;

    public SiiCdp() {
    }

    public SiiCdp(SiiAreaColjuegos siiAreaColjuegos, Long cdpCodigo, Long cdpConsecutivo, Date cdpFechaSolic, String cdpJustificacion,
                  String cdpNumeroDocSop, String cdpObjeto, Integer cdpVigencia, Integer cdpVigenciaAfectada, Long cdpNumeroSiif, BigDecimal cdpValorSolicit,
                  SiiEstadoCdp siiEstadoCdp, SiiProcesoContratacion siiProcesoContratacion, Date cdpFechaExpedicion, BigDecimal cdpSaldoAnterior,
                  SiiItemPlanContratac siiItemPlanContratac, SiiTipoDocSoporte siiTipoDocSoporte, SiiUsuario siiUsuario) {
        this.siiAreaColjuegos = siiAreaColjuegos;
        this.cdpCodigo = cdpCodigo;
        this.cdpConsecutivo = cdpConsecutivo;
        this.cdpFechaExpedicion = cdpFechaExpedicion;
        this.cdpFechaSolic = cdpFechaSolic;
        this.cdpJustificacion = cdpJustificacion;
        this.cdpNumeroDocSop = cdpNumeroDocSop;
        this.cdpNumeroSiif = cdpNumeroSiif;
        this.cdpObjeto = cdpObjeto;
        this.cdpSaldoAnterior = cdpSaldoAnterior;
        this.cdpVigencia = cdpVigencia;
        this.cdpVigenciaAfectada = cdpVigenciaAfectada;
        this.siiEstadoCdp = siiEstadoCdp;
        this.siiProcesoContratacion = siiProcesoContratacion;
        this.siiTipoDocSoporte = siiTipoDocSoporte;
        this.siiUsuario = siiUsuario;
        this.siiItemPlanContratac = siiItemPlanContratac;
    }


    @Id
    @Column(name = "CDP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CDP_CODIGO")
    @SequenceGenerator(name = "SEQ_CDP_CODIGO", sequenceName = "SEQ_CDP_CODIGO",allocationSize=1)
    public Long getCdpCodigo() {
        return cdpCodigo;
    }

    public void setCdpCodigo(Long cdpCodigo) {
        this.cdpCodigo = cdpCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CDP_FECHA_SOLIC", nullable = false)
    public Date getCdpFechaSolic() {
        return cdpFechaSolic;
    }

    public void setCdpFechaSolic(Date cdpFechaSolic) {
        this.cdpFechaSolic = cdpFechaSolic;
    }

    @Column(name = "CDP_JUSTIFICACION", length = 500)
    public String getCdpJustificacion() {
        return cdpJustificacion;
    }

    public void setCdpJustificacion(String cdpJustificacion) {
        this.cdpJustificacion = cdpJustificacion;
    }

    @Column(name = "CDP_NUMERO_DOC_SOP", length = 20)
    public String getCdpNumeroDocSop() {
        return cdpNumeroDocSop;
    }

    public void setCdpNumeroDocSop(String cdpNumeroDocSop) {
        this.cdpNumeroDocSop = cdpNumeroDocSop;
    }

    @Column(name = "CDP_NUMERO_SIIF")
    public Long getCdpNumeroSiif() {
        return cdpNumeroSiif;
    }

    public void setCdpNumeroSiif(Long cdpNumeroSiif) {
        this.cdpNumeroSiif = cdpNumeroSiif;
    }

    @Column(name = "CDP_OBJETO", length = 500)
    public String getCdpObjeto() {
        return cdpObjeto;
    }

    public void setCdpObjeto(String cdpObjeto) {
        this.cdpObjeto = cdpObjeto;
    }

    @Column(name = "CDP_SALDO_ANTERIOR")
    public BigDecimal getCdpSaldoAnterior() {
        return cdpSaldoAnterior;
    }

    public void setCdpSaldoAnterior(BigDecimal cdpSaldoAnterior) {
        this.cdpSaldoAnterior = cdpSaldoAnterior;
    }

    @Column(name = "CDP_VALOR_SOLICIT")
    public BigDecimal getCdpValorSolicit() {
        return cdpValorSolicit;
    }

    public void setCdpValorSolicit(BigDecimal cdpValorSolicit) {
        this.cdpValorSolicit = cdpValorSolicit;
    }

    @Column(name = "CDP_VIGENCIA", nullable = false)
    public Integer getCdpVigencia() {
        return cdpVigencia;
    }

    public void setCdpVigencia(Integer cdpVigencia) {
        this.cdpVigencia = cdpVigencia;
    }

    @Column(name = "CDP_VIGENCIA_AFECTADA", nullable = false)
    public Integer getCdpVigenciaAfectada() {
        return cdpVigenciaAfectada;
    }

    public void setCdpVigenciaAfectada(Integer cdpVigenciaAfectada) {
        this.cdpVigenciaAfectada = cdpVigenciaAfectada;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_SOLIC")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion() {
        return siiProcesoContratacion;
    }

    public void setSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        this.siiProcesoContratacion = siiProcesoContratacion;
    }

    @ManyToOne
    @JoinColumn(name = "ECD_CODIGO")
    public SiiEstadoCdp getSiiEstadoCdp() {
        return siiEstadoCdp;
    }

    public void setSiiEstadoCdp(SiiEstadoCdp siiEstadoCdp) {
        this.siiEstadoCdp = siiEstadoCdp;
    }

    @ManyToOne
    @JoinColumn(name = "ACO_CODIGO")
    public SiiAreaColjuegos getSiiAreaColjuegos() {
        return siiAreaColjuegos;
    }

    public void setSiiAreaColjuegos(SiiAreaColjuegos siiAreaColjuegos) {
        this.siiAreaColjuegos = siiAreaColjuegos;
    }

    @OneToMany(mappedBy = "siiCdp")
    public List<SiiDetalleRubroCdp> getSiiDetalleRubroCdpList() {
        return siiDetalleRubroCdpList;
    }

    public void setSiiDetalleRubroCdpList(List<SiiDetalleRubroCdp> siiDetalleRubroCdpList) {
        this.siiDetalleRubroCdpList = siiDetalleRubroCdpList;
    }

    public SiiDetalleRubroCdp addSiiDetalleRubroCdp(SiiDetalleRubroCdp siiDetalleRubroCdp) {
        getSiiDetalleRubroCdpList().add(siiDetalleRubroCdp);
        siiDetalleRubroCdp.setSiiCdp(this);
        return siiDetalleRubroCdp;
    }

    public SiiDetalleRubroCdp removeSiiDetalleRubroCdp(SiiDetalleRubroCdp siiDetalleRubroCdp) {
        getSiiDetalleRubroCdpList().remove(siiDetalleRubroCdp);
        siiDetalleRubroCdp.setSiiCdp(null);
        return siiDetalleRubroCdp;
    }

    @ManyToOne
    @JoinColumn(name = "TDS_CODIGO")
    public SiiTipoDocSoporte getSiiTipoDocSoporte() {
        return siiTipoDocSoporte;
    }

    public void setSiiTipoDocSoporte(SiiTipoDocSoporte siiTipoDocSoporte) {
        this.siiTipoDocSoporte = siiTipoDocSoporte;
    }

    @ManyToOne
    @JoinColumn(name = "IPC_CODIGO")
    public SiiItemPlanContratac getSiiItemPlanContratac() {
        return siiItemPlanContratac;
    }

    public void setSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        this.siiItemPlanContratac = siiItemPlanContratac;
    }
    
    @Column(name = "CDP_CONSECUTIVO")
    public Long getCdpConsecutivo() {
        return cdpConsecutivo;
    }

    public void setCdpConsecutivo(Long cdpConsecutivo) {
        this.cdpConsecutivo = cdpConsecutivo;
    }

    @OneToMany(mappedBy = "siiCdp")
    public List<SiiModificacionCdp> getSiiModificacionCdpList() {
        return siiModificacionCdpList;
    }

    public void setSiiModificacionCdpList(List<SiiModificacionCdp> siiModificacionCdpList) {
        this.siiModificacionCdpList = siiModificacionCdpList;
    }

    public SiiModificacionCdp addSiiModificacionCdp(SiiModificacionCdp siiModificacionCdp) {
        getSiiModificacionCdpList().add(siiModificacionCdp);
        siiModificacionCdp.setSiiCdp(this);
        return siiModificacionCdp;
    }

    public SiiModificacionCdp removeSiiModificacionCdp(SiiModificacionCdp siiModificacionCdp) {
        getSiiModificacionCdpList().remove(siiModificacionCdp);
        siiModificacionCdp.setSiiCdp(null);
        return siiModificacionCdp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CDP_FECHA_EXPEDICION")
    public Date getCdpFechaExpedicion() {
        return cdpFechaExpedicion;
    }

    public void setCdpFechaExpedicion(Date cdpFechaExpedicion) {
        this.cdpFechaExpedicion = cdpFechaExpedicion;
    }

    @OneToMany(mappedBy = "siiCdp")
    public List<SiiRp> getSiiRpList() {
        return siiRpList;
    }

    public void setSiiRpList(List<SiiRp> siiRpList) {
        this.siiRpList = siiRpList;
    }

    public SiiRp addSiiRp(SiiRp siiRp) {
        getSiiRpList().add(siiRp);
        siiRp.setSiiCdp(this);
        return siiRp;
    }

    public SiiRp removeSiiRp(SiiRp siiRp) {
        getSiiRpList().remove(siiRp);
        siiRp.setSiiCdp(null);
        return siiRp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CDP_FECHA_CONT")
    public Date getCdpFechaCont() {
        return cdpFechaCont;
    }

    public void setCdpFechaCont(Date cdpFechaCont) {
        this.cdpFechaCont = cdpFechaCont;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CDP_FECHA_VIG_FUT")
    public Date getCdpFechaVigFut() {
        return cdpFechaVigFut;
    }

    public void setCdpFechaVigFut(Date cdpFechaVigFut) {
        this.cdpFechaVigFut = cdpFechaVigFut;
    }

    @Column(name = "CDP_NUM_VIG_FUT", length = 20)
    public String getCdpNumVigFut() {
        return cdpNumVigFut;
    }

    public void setCdpNumVigFut(String cdpNumVigFut) {
        this.cdpNumVigFut = cdpNumVigFut;
    }

    @Column(name = "CDP_NUM_CONTRATO")
    public Long getCdpNumContrato() {
        return cdpNumContrato;
    }

    public void setCdpNumContrato(Long cdpNumContrato) {
        this.cdpNumContrato = cdpNumContrato;
    }
    @Column(name = "CDP_OBJETO_CONT", length = 2500)
    public String getCdpObjetoCont() {
        return cdpObjetoCont;
    }

    public void setCdpObjetoCont(String cdpObjetoCont) {
        this.cdpObjetoCont = cdpObjetoCont;
    }

    @OneToMany(mappedBy = "siiCdp")
    public List<SiiCdpRp> getSiiCdpRpList() {
        return siiCdpRpList;
    }

    public void setSiiCdpRpList(List<SiiCdpRp> siiCdpRpList) {
        this.siiCdpRpList = siiCdpRpList;
    }

    public SiiCdpRp addSiiCdpRp(SiiCdpRp siiCdpRp) {
        getSiiCdpRpList().add(siiCdpRp);
        siiCdpRp.setSiiCdp(this);
        return siiCdpRp;
    }

    public SiiCdpRp removeSiiCdpRp(SiiCdpRp siiCdpRp) {
        getSiiCdpRpList().remove(siiCdpRp);
        siiCdpRp.setSiiCdp(null);
        return siiCdpRp;
    }
}
