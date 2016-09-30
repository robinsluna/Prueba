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
@Table(name = "SII_DISTRIBUCION_MES")
public class SiiDistribucionMes implements Serializable {
    private static final long serialVersionUID = 2748681002324492274L;
    private Integer dcnNumero;
    private Long dmeCodigo;
    private Integer dmeVigencia;
    private SiiCierreRecaudo siiCierreRecaudo;
    private SiiDocumentoConpes siiDocumentoConpes;
    private SiiEstadoDistribEnte siiEstadoDistribEnte;
    private List<SiiDetalleDistrib> siiDetalleDistribList;
    private Date dmeFechaDistrib;
    private SiiMes siiMes;
    private List<SiiDetalleDeclaracion> siiDetalleDeclaracionList;
    private List<SiiObligacion> siiObligacionList;
    private Date dmeFechaResol;
    private String dmeResolucion;
    private String dmeDescripcion;
    private BigDecimal dmeTotRendimFinanc;
    private List<SiiConsolidadoDist> siiConsolidadoDistList;
    private List<SiiAsignacionRecaudoAa> siiAsignacionRecaudoAaList;

    public SiiDistribucionMes() {
    }

    public SiiDistribucionMes(SiiCierreRecaudo siiCierreRecaudo, SiiDocumentoConpes siiDocumentoConpes,
                              Integer dcnNumero, Long dmeCodigo, SiiEstadoDistribEnte siiEstadoDistribEnte) {
        this.siiCierreRecaudo = siiCierreRecaudo;
        this.siiDocumentoConpes = siiDocumentoConpes;
        this.dcnNumero = dcnNumero;
        this.dmeCodigo = dmeCodigo;
        this.siiEstadoDistribEnte = siiEstadoDistribEnte;
    }


    @Column(name = "DCN_NUMERO", nullable = false)
    public Integer getDcnNumero() {
        return dcnNumero;
    }

    public void setDcnNumero(Integer dcnNumero) {
        this.dcnNumero = dcnNumero;
    }

    @Id
    @Column(name = "DME_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DISTRIBUCION_MES_COD")
    @SequenceGenerator(name = "SEQ_DISTRIBUCION_MES_COD", sequenceName = "SEQ_DISTRIBUCION_MES_COD",allocationSize=1)
    public Long getDmeCodigo() {
        return dmeCodigo;
    }

    public void setDmeCodigo(Long dmeCodigo) {
        this.dmeCodigo = dmeCodigo;
    }


    @Column(name = "DME_VIGENCIA", nullable = false)
    public Integer getDmeVigencia() {
        return dmeVigencia;
    }
    
    public void setDmeVigencia(Integer dmeVigencia) {
        this.dmeVigencia = dmeVigencia;
    }


    @ManyToOne
    @JoinColumn(name = "CIR_CODIGO")
    public SiiCierreRecaudo getSiiCierreRecaudo() {
        return siiCierreRecaudo;
    }

    public void setSiiCierreRecaudo(SiiCierreRecaudo siiCierreRecaudo) {
        this.siiCierreRecaudo = siiCierreRecaudo;
    }

    @ManyToOne
    @JoinColumn(name = "DCN_CODIGO")
    public SiiDocumentoConpes getSiiDocumentoConpes() {
        return siiDocumentoConpes;
    }

    public void setSiiDocumentoConpes(SiiDocumentoConpes siiDocumentoConpes) {
        this.siiDocumentoConpes = siiDocumentoConpes;
    }

    @ManyToOne
    @JoinColumn(name = "EDE_CODIGO")
    public SiiEstadoDistribEnte getSiiEstadoDistribEnte() {
        return siiEstadoDistribEnte;
    }

    public void setSiiEstadoDistribEnte(SiiEstadoDistribEnte siiEstadoDistribEnte) {
        this.siiEstadoDistribEnte = siiEstadoDistribEnte;
    }

    @OneToMany(mappedBy = "siiDistribucionMes")
    public List<SiiDetalleDistrib> getSiiDetalleDistribList() {
        return siiDetalleDistribList;
    }

    public void setSiiDetalleDistribList(List<SiiDetalleDistrib> siiDetalleDistribList) {
        this.siiDetalleDistribList = siiDetalleDistribList;
    }

    public SiiDetalleDistrib addSiiDetalleDistrib(SiiDetalleDistrib siiDetalleDistrib) {
        getSiiDetalleDistribList().add(siiDetalleDistrib);
        siiDetalleDistrib.setSiiDistribucionMes(this);
        return siiDetalleDistrib;
    }

    public SiiDetalleDistrib removeSiiDetalleDistrib(SiiDetalleDistrib siiDetalleDistrib) {
        getSiiDetalleDistribList().remove(siiDetalleDistrib);
        siiDetalleDistrib.setSiiDistribucionMes(null);
        return siiDetalleDistrib;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DME_FECHA_DISTRIB")
    public Date getDmeFechaDistrib() {
        return dmeFechaDistrib;
    }

    public void setDmeFechaDistrib(Date dmeFechaDistrib) {
        this.dmeFechaDistrib = dmeFechaDistrib;
    }

    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @OneToMany(mappedBy = "siiDistribucionMes")
    public List<SiiDetalleDeclaracion> getSiiDetalleDeclaracionList() {
        return siiDetalleDeclaracionList;
    }

    public void setSiiDetalleDeclaracionList(List<SiiDetalleDeclaracion> siiDetalleDeclaracionList) {
        this.siiDetalleDeclaracionList = siiDetalleDeclaracionList;
    }

    public SiiDetalleDeclaracion addSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        getSiiDetalleDeclaracionList().add(siiDetalleDeclaracion);
        siiDetalleDeclaracion.setSiiDistribucionMes(this);
        return siiDetalleDeclaracion;
    }

    public SiiDetalleDeclaracion removeSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        getSiiDetalleDeclaracionList().remove(siiDetalleDeclaracion);
        siiDetalleDeclaracion.setSiiDistribucionMes(null);
        return siiDetalleDeclaracion;
    }

    @OneToMany(mappedBy = "siiDistribucionMes")
    public List<SiiObligacion> getSiiObligacionList() {
        return siiObligacionList;
    }

    public void setSiiObligacionList(List<SiiObligacion> siiObligacionList) {
        this.siiObligacionList = siiObligacionList;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().add(siiObligacion);
        siiObligacion.setSiiDistribucionMes(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().remove(siiObligacion);
        siiObligacion.setSiiDistribucionMes(null);
        return siiObligacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DME_FECHA_RESOL")
    public Date getDmeFechaResol() {
        return dmeFechaResol;
    }

    public void setDmeFechaResol(Date dmeFechaResol) {
        this.dmeFechaResol = dmeFechaResol;
    }

    @Column(name = "DME_RESOLUCION", length = 10)
    public String getDmeResolucion() {
        return dmeResolucion;
    }

    public void setDmeResolucion(String dmeResolucion) {
        this.dmeResolucion = dmeResolucion;
    }

    @Column(name = "DME_DESCRIPCION", nullable = false, length = 200)
    public String getDmeDescripcion() {
        return dmeDescripcion;
    }

    public void setDmeDescripcion(String dmeDescripcion) {
        this.dmeDescripcion = dmeDescripcion;
    }
    
    @Column(name = "DME_TOT_RENDIM_FINANC")
    public BigDecimal getDmeTotRendimFinanc() {
        return dmeTotRendimFinanc;
    }

    public void setDmeTotRendimFinanc(BigDecimal dmeTotRendimFinanc) {
        this.dmeTotRendimFinanc = dmeTotRendimFinanc;
    }

    @OneToMany(mappedBy = "siiDistribucionMes")
    public List<SiiConsolidadoDist> getSiiConsolidadoDistList() {
        return siiConsolidadoDistList;
    }

    public void setSiiConsolidadoDistList(List<SiiConsolidadoDist> siiConsolidadoDistList) {
        this.siiConsolidadoDistList = siiConsolidadoDistList;
    }

    public SiiConsolidadoDist addSiiConsolidadoDist(SiiConsolidadoDist siiConsolidadoDist) {
        getSiiConsolidadoDistList().add(siiConsolidadoDist);
        siiConsolidadoDist.setSiiDistribucionMes(this);
        return siiConsolidadoDist;
    }

    public SiiConsolidadoDist removeSiiConsolidadoDist(SiiConsolidadoDist siiConsolidadoDist) {
        getSiiConsolidadoDistList().remove(siiConsolidadoDist);
        siiConsolidadoDist.setSiiDistribucionMes(null);
        return siiConsolidadoDist;
    }

    @OneToMany(mappedBy = "siiDistribucionMes")
    public List<SiiAsignacionRecaudoAa> getSiiAsignacionRecaudoAaList() {
        return siiAsignacionRecaudoAaList;
    }

    public void setSiiAsignacionRecaudoAaList(List<SiiAsignacionRecaudoAa> siiAsignacionRecaudoAaList) {
        this.siiAsignacionRecaudoAaList = siiAsignacionRecaudoAaList;
    }

    public SiiAsignacionRecaudoAa addSiiAsignacionRecaudoAa(SiiAsignacionRecaudoAa siiAsignacionRecaudoAa) {
        getSiiAsignacionRecaudoAaList().add(siiAsignacionRecaudoAa);
        siiAsignacionRecaudoAa.setSiiDistribucionMes(this);
        return siiAsignacionRecaudoAa;
    }

    public SiiAsignacionRecaudoAa removeSiiAsignacionRecaudoAa(SiiAsignacionRecaudoAa siiAsignacionRecaudoAa) {
        getSiiAsignacionRecaudoAaList().remove(siiAsignacionRecaudoAa);
        siiAsignacionRecaudoAa.setSiiDistribucionMes(null);
        return siiAsignacionRecaudoAa;
    }
}
