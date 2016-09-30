package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_DETALLE_DISTRIB")
public class SiiDetalleDistrib implements Serializable {
    private static final long serialVersionUID = 7587376652602600115L;
    private Long ddiCodigo;
    private BigDecimal ddiValorDetod;
    private BigDecimal ddiValorProp;
    private BigDecimal ddiValorRec;
    private BigDecimal ddiValorTodos;
    private SiiDistribucionMes siiDistribucionMes;
    private SiiEnteTerritorial siiEnteTerritorial;
    private List<SiiObligacion> siiObligacionList;
    private String ddiEsInteres;
    private SiiCategoriaDistrib siiCategoriaDistrib;
    private BigDecimal ddiPorcentParticip;
    private BigDecimal ddiSubtotalTranf;
    private BigDecimal ddiValColciencias;
    private BigDecimal ddiValRendimFinanc;
    private BigDecimal ddiValTotMunicipios;
    private BigDecimal ddiValTotSaypFosiga;
    private BigDecimal ddiValTotalControl;
    private BigDecimal ddiValTotalTranfer;



    public SiiDetalleDistrib() {
    }

    public SiiDetalleDistrib(Long ddiCodigo, BigDecimal ddiValorDetod,
                             BigDecimal ddiValorProp, BigDecimal ddiValorRec, BigDecimal ddiValorTodos,
                             SiiDistribucionMes siiDistribucionMes, SiiEnteTerritorial siiEnteTerritorial) {
        this.ddiCodigo = ddiCodigo;
        this.ddiValorDetod = ddiValorDetod;
        this.ddiValorProp = ddiValorProp;
        this.ddiValorRec = ddiValorRec;
        this.ddiValorTodos = ddiValorTodos;
        this.siiDistribucionMes = siiDistribucionMes;
        this.siiEnteTerritorial = siiEnteTerritorial;
    }


    @Id
    @Column(name = "DDI_CODIGO", nullable = false)
    public Long getDdiCodigo() {
        return ddiCodigo;
    }

    public void setDdiCodigo(Long ddiCodigo) {
        this.ddiCodigo = ddiCodigo;
    }

    @Column(name = "DDI_VALOR_DETOD", nullable = false)
    public BigDecimal getDdiValorDetod() {
        return ddiValorDetod;
    }

    public void setDdiValorDetod(BigDecimal ddiValorDetod) {
        this.ddiValorDetod = ddiValorDetod;
    }

    @Column(name = "DDI_VALOR_PROP", nullable = false)
    public BigDecimal getDdiValorProp() {
        return ddiValorProp;
    }

    public void setDdiValorProp(BigDecimal ddiValorProp) {
        this.ddiValorProp = ddiValorProp;
    }

    @Column(name = "DDI_VALOR_REC", nullable = false)
    public BigDecimal getDdiValorRec() {
        return ddiValorRec;
    }

    public void setDdiValorRec(BigDecimal ddiValorRec) {
        this.ddiValorRec = ddiValorRec;
    }

    @Column(name = "DDI_VALOR_TODOS", nullable = false)
    public BigDecimal getDdiValorTodos() {
        return ddiValorTodos;
    }

    public void setDdiValorTodos(BigDecimal ddiValorTodos) {
        this.ddiValorTodos = ddiValorTodos;
    }


    @ManyToOne
    @JoinColumn(name = "DME_CODIGO")
    public SiiDistribucionMes getSiiDistribucionMes() {
        return siiDistribucionMes;
    }

    public void setSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        this.siiDistribucionMes = siiDistribucionMes;
    }

    @ManyToOne
    @JoinColumn(name = "ETI_CODIGO")
    public SiiEnteTerritorial getSiiEnteTerritorial() {
        return siiEnteTerritorial;
    }

    public void setSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        this.siiEnteTerritorial = siiEnteTerritorial;
    }

    @OneToMany(mappedBy = "siiDetalleDistrib")
    public List<SiiObligacion> getSiiObligacionList() {
        return siiObligacionList;
    }

    public void setSiiObligacionList(List<SiiObligacion> siiObligacionList) {
        this.siiObligacionList = siiObligacionList;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().add(siiObligacion);
        siiObligacion.setSiiDetalleDistrib(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().remove(siiObligacion);
        siiObligacion.setSiiDetalleDistrib(null);
        return siiObligacion;
    }

    @Column(name = "DDI_ES_INTERES", nullable = true, length = 1)
    public String getDdiEsInteres() {
        return ddiEsInteres;
    }
    
    public void setDdiEsInteres(String ddiEsInteres) {
        this.ddiEsInteres = ddiEsInteres;
    }
    
    @ManyToOne
    @JoinColumn(name = "CAD_CODIGO")
    public SiiCategoriaDistrib getSiiCategoriaDistrib() {
        return siiCategoriaDistrib;
    }

    public void setSiiCategoriaDistrib(SiiCategoriaDistrib siiCategoriaDistrib) {
        this.siiCategoriaDistrib = siiCategoriaDistrib;
    }
    
        @Column(name = "DDI_PORCENT_PARTICIP")
    public BigDecimal getDdiPorcentParticip() {
        return ddiPorcentParticip;
    }

    public void setDdiPorcentParticip(BigDecimal ddiPorcentParticip) {
        this.ddiPorcentParticip = ddiPorcentParticip;
    }

    @Column(name = "DDI_SUBTOTAL_TRANF")
    public BigDecimal getDdiSubtotalTranf() {
        return ddiSubtotalTranf;
    }

    public void setDdiSubtotalTranf(BigDecimal ddiSubtotalTranf) {
        this.ddiSubtotalTranf = ddiSubtotalTranf;
    }

    @Column(name = "DDI_VAL_COLCIENCIAS")
    public BigDecimal getDdiValColciencias() {
        return ddiValColciencias;
    }

    public void setDdiValColciencias(BigDecimal ddiValColciencias) {
        this.ddiValColciencias = ddiValColciencias;
    }

    @Column(name = "DDI_VAL_RENDIM_FINANC")
    public BigDecimal getDdiValRendimFinanc() {
        return ddiValRendimFinanc;
    }

    public void setDdiValRendimFinanc(BigDecimal ddiValRendimFinanc) {
        this.ddiValRendimFinanc = ddiValRendimFinanc;
    }

    @Column(name = "DDI_VAL_TOT_MUNICIPIOS")
    public BigDecimal getDdiValTotMunicipios() {
        return ddiValTotMunicipios;
    }

    public void setDdiValTotMunicipios(BigDecimal ddiValTotMunicipios) {
        this.ddiValTotMunicipios = ddiValTotMunicipios;
    }

    @Column(name = "DDI_VAL_TOT_SAYP_FOSIGA")
    public BigDecimal getDdiValTotSaypFosiga() {
        return ddiValTotSaypFosiga;
    }

    public void setDdiValTotSaypFosiga(BigDecimal ddiValTotSaypFosiga) {
        this.ddiValTotSaypFosiga = ddiValTotSaypFosiga;
    }

    @Column(name = "DDI_VAL_TOTAL_CONTROL")
    public BigDecimal getDdiValTotalControl() {
        return ddiValTotalControl;
    }

    public void setDdiValTotalControl(BigDecimal ddiValTotalControl) {
        this.ddiValTotalControl = ddiValTotalControl;
    }

    @Column(name = "DDI_VAL_TOTAL_TRANFER")
    public BigDecimal getDdiValTotalTranfer() {
        return ddiValTotalTranfer;
    }

    public void setDdiValTotalTranfer(BigDecimal ddiValTotalTranfer) {
        this.ddiValTotalTranfer = ddiValTotalTranfer;
    }

}
