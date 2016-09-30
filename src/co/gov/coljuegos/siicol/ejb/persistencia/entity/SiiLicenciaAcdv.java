package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_LICENCIA_ACDV")
public class SiiLicenciaAcdv implements Serializable {
    private Long lacCodigo;
    private Integer lacModalidad;
    private String lacNumero;
    private Integer lacNumeroTerm;
    private List<SiiNovedad> siiNovedadList;

    public SiiLicenciaAcdv() {
    }

    public SiiLicenciaAcdv(Long lacCodigo, Integer lacModalidad, String lacNumero, Integer lacNumeroTerm) {
        this.lacCodigo = lacCodigo;
        this.lacModalidad = lacModalidad;
        this.lacNumero = lacNumero;
        this.lacNumeroTerm = lacNumeroTerm;
    }

    @Id
    @Column(name = "LAC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_LICENCIA_ACDV_COD")
    @SequenceGenerator(name = "SEQ_LICENCIA_ACDV_COD", sequenceName = "SEQ_LICENCIA_ACDV_COD", allocationSize = 1)
    public Long getLacCodigo() {
        return lacCodigo;
    }

    public void setLacCodigo(Long lacCodigo) {
        this.lacCodigo = lacCodigo;
    }

    @Column(name = "LAC_MODALIDAD", nullable = false)
    public Integer getLacModalidad() {
        return lacModalidad;
    }

    public void setLacModalidad(Integer lacModalidad) {
        this.lacModalidad = lacModalidad;
    }

    @Column(name = "LAC_NUMERO", nullable = false, length = 20)
    public String getLacNumero() {
        return lacNumero;
    }

    public void setLacNumero(String lacNumero) {
        this.lacNumero = lacNumero;
    }

    @Column(name = "LAC_NUMERO_TERM")
    public Integer getLacNumeroTerm() {
        return lacNumeroTerm;
    }

    public void setLacNumeroTerm(Integer lacNumeroTerm) {
        this.lacNumeroTerm = lacNumeroTerm;
    }

    @OneToMany(mappedBy = "siiLicenciaAcdv")
    public List<SiiNovedad> getSiiNovedadList() {
        return siiNovedadList;
    }

    public void setSiiNovedadList(List<SiiNovedad> siiNovedadList) {
        this.siiNovedadList = siiNovedadList;
    }

    public SiiNovedad addSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().add(siiNovedad);
        siiNovedad.setSiiLicenciaAcdv(this);
        return siiNovedad;
    }

    public SiiNovedad removeSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().remove(siiNovedad);
        siiNovedad.setSiiLicenciaAcdv(null);
        return siiNovedad;
    }
}
