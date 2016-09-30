package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_TASA_INTERES")
public class SiiTipoTasaInteres implements Serializable {
    private static final long serialVersionUID = 4040567257443817729L;
    private String ttiAbreviatura;
    private Long ttiCodigo;
    private String ttiNombre;
    private List<SiiTasaInteres> siiTasaInteresList;

    public SiiTipoTasaInteres() {
    }

    public SiiTipoTasaInteres(String ttiAbreviatura, Long ttiCodigo, String ttiNombre) {
        this.ttiAbreviatura = ttiAbreviatura;
        this.ttiCodigo = ttiCodigo;
        this.ttiNombre = ttiNombre;
    }

    @Column(name = "TTI_ABREVIATURA", nullable = false, length = 10)
    public String getTtiAbreviatura() {
        return ttiAbreviatura;
    }

    public void setTtiAbreviatura(String ttiAbreviatura) {
        this.ttiAbreviatura = ttiAbreviatura;
    }

    @Id
    @Column(name = "TTI_CODIGO", nullable = false)
    public Long getTtiCodigo() {
        return ttiCodigo;
    }

    public void setTtiCodigo(Long ttiCodigo) {
        this.ttiCodigo = ttiCodigo;
    }

    @Column(name = "TTI_NOMBRE", nullable = false, length = 20)
    public String getTtiNombre() {
        return ttiNombre;
    }

    public void setTtiNombre(String ttiNombre) {
        this.ttiNombre = ttiNombre;
    }

    @OneToMany(mappedBy = "siiTipoTasaInteres")
    public List<SiiTasaInteres> getSiiTasaInteresList() {
        return siiTasaInteresList;
    }

    public void setSiiTasaInteresList(List<SiiTasaInteres> siiTasaInteresList) {
        this.siiTasaInteresList = siiTasaInteresList;
    }

    public SiiTasaInteres addSiiTasaInteres(SiiTasaInteres siiTasaInteres) {
        getSiiTasaInteresList().add(siiTasaInteres);
        siiTasaInteres.setSiiTipoTasaInteres(this);
        return siiTasaInteres;
    }

    public SiiTasaInteres removeSiiTasaInteres(SiiTasaInteres siiTasaInteres) {
        getSiiTasaInteresList().remove(siiTasaInteres);
        siiTasaInteres.setSiiTipoTasaInteres(null);
        return siiTasaInteres;
    }
}
