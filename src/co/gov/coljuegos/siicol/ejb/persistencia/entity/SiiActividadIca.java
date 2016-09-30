package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ACTIVIDAD_ICA")
public class SiiActividadIca implements Serializable {
    private static final long serialVersionUID = -2183375883100159657L;
    private Integer aicAgrupacion;
    private String aicCodigo;
    private String aicDescripcion;
    private BigDecimal aicTarifa;
    private SiiCuentasContables siiCuentasContables;
    private List<SiiActividadIcaPers> siiActividadIcaPersList;
    private List<SiiObligacionConcepto> siiObligacionConceptoList;

    public SiiActividadIca() {
    }

    public SiiActividadIca(Integer aicAgrupacion, String aicCodigo, String aicDescripcion, BigDecimal aicTarifa,
                           Long ccoCodigo) {
        this.aicAgrupacion = aicAgrupacion;
        this.aicCodigo = aicCodigo;
        this.aicDescripcion = aicDescripcion;
        this.aicTarifa = aicTarifa;
    }

    @Column(name = "AIC_AGRUPACION", nullable = false)
    public Integer getAicAgrupacion() {
        return aicAgrupacion;
    }

    public void setAicAgrupacion(Integer aicAgrupacion) {
        this.aicAgrupacion = aicAgrupacion;
    }

    @Id
    @Column(name = "AIC_CODIGO", nullable = false, length = 8)
    public String getAicCodigo() {
        return aicCodigo;
    }

    public void setAicCodigo(String aicCodigo) {
        this.aicCodigo = aicCodigo;
    }

    @Column(name = "AIC_DESCRIPCION", nullable = false, length = 500)
    public String getAicDescripcion() {
        return aicDescripcion;
    }

    public void setAicDescripcion(String aicDescripcion) {
        this.aicDescripcion = aicDescripcion;
    }

    @Column(name = "AIC_TARIFA", nullable = false)
    public BigDecimal getAicTarifa() {
        return aicTarifa;
    }

    public void setAicTarifa(BigDecimal aicTarifa) {
        this.aicTarifa = aicTarifa;
    }


    @OneToMany(mappedBy = "siiActividadIca")
    public List<SiiActividadIcaPers> getSiiActividadIcaPersList() {
        return siiActividadIcaPersList;
    }

    public void setSiiActividadIcaPersList(List<SiiActividadIcaPers> siiActividadIcaPersList) {
        this.siiActividadIcaPersList = siiActividadIcaPersList;
    }

    public SiiActividadIcaPers addSiiActividadIcaPers(SiiActividadIcaPers siiActividadIcaPers) {
        getSiiActividadIcaPersList().add(siiActividadIcaPers);
        siiActividadIcaPers.setSiiActividadIca(this);
        return siiActividadIcaPers;
    }

    public SiiActividadIcaPers removeSiiActividadIcaPers(SiiActividadIcaPers siiActividadIcaPers) {
        getSiiActividadIcaPersList().remove(siiActividadIcaPers);
        siiActividadIcaPers.setSiiActividadIca(null);
        return siiActividadIcaPers;
    }

    @ManyToOne
    @JoinColumn(name = "CCO_CODIGO")
    public SiiCuentasContables getSiiCuentasContables() {
        return siiCuentasContables;
    }

    public void setSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        this.siiCuentasContables = siiCuentasContables;
    }

    @OneToMany(mappedBy = "siiActividadIca")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoList() {
        return siiObligacionConceptoList;
    }

    public void setSiiObligacionConceptoList(List<SiiObligacionConcepto> siiObligacionConceptoList) {
        this.siiObligacionConceptoList = siiObligacionConceptoList;
    }

    public SiiObligacionConcepto addSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList().add(siiObligacionConcepto);
        siiObligacionConcepto.setSiiActividadIca(this);
        return siiObligacionConcepto;
    }

    public SiiObligacionConcepto removeSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList().remove(siiObligacionConcepto);
        siiObligacionConcepto.setSiiActividadIca(null);
        return siiObligacionConcepto;
    }
}
