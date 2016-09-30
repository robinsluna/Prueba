package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MONEDA")
public class SiiMoneda implements Serializable {
    private static final long serialVersionUID = -6677137676139961611L;
    private String monAbreviatura;
    private Long monCodigo;
    private String monNombre;
    private List<SiiDetalleFinanc> siiDetalleFinancList;

    public SiiMoneda() {
    }

    public SiiMoneda(String monAbreviatura, Long monCodigo, String monNombre) {
        this.monAbreviatura = monAbreviatura;
        this.monCodigo = monCodigo;
        this.monNombre = monNombre;
    }

    @Column(name = "MON_ABREVIATURA", nullable = false, length = 5)
    public String getMonAbreviatura() {
        return monAbreviatura;
    }

    public void setMonAbreviatura(String monAbreviatura) {
        this.monAbreviatura = monAbreviatura;
    }

    @Id
    @Column(name = "MON_CODIGO", nullable = false)
    public Long getMonCodigo() {
        return monCodigo;
    }

    public void setMonCodigo(Long monCodigo) {
        this.monCodigo = monCodigo;
    }

    @Column(name = "MON_NOMBRE", nullable = false, length = 30)
    public String getMonNombre() {
        return monNombre;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    @OneToMany(mappedBy = "siiMoneda")
    public List<SiiDetalleFinanc> getSiiDetalleFinancList() {
        return siiDetalleFinancList;
    }

    public void setSiiDetalleFinancList(List<SiiDetalleFinanc> siiDetalleFinancList) {
        this.siiDetalleFinancList = siiDetalleFinancList;
    }

    public SiiDetalleFinanc addSiiDetalleFinanc(SiiDetalleFinanc siiDetalleFinanc) {
        getSiiDetalleFinancList().add(siiDetalleFinanc);
        siiDetalleFinanc.setSiiMoneda(this);
        return siiDetalleFinanc;
    }

    public SiiDetalleFinanc removeSiiDetalleFinanc(SiiDetalleFinanc siiDetalleFinanc) {
        getSiiDetalleFinancList().remove(siiDetalleFinanc);
        siiDetalleFinanc.setSiiMoneda(null);
        return siiDetalleFinanc;
    }
}
