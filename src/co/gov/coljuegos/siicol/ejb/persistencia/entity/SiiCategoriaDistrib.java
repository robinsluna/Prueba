package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CATEGORIA_DISTRIB")
public class SiiCategoriaDistrib implements Serializable {
    private static final long serialVersionUID = 3412572315111530016L;
    private Long cadCodigo;
    private String cadNombre;
    private List<SiiDetalleDistrib> siiDetalleDistribList;
        private List<SiiConceptoCuota> siiConceptoCuotaList;


    public SiiCategoriaDistrib() {
    }

    public SiiCategoriaDistrib(Long cadCodigo, String cadNombre) {
        this.cadCodigo = cadCodigo;
        this.cadNombre = cadNombre;
    }

    @Id
    @Column(name = "CAD_CODIGO", nullable = false)
    public Long getCadCodigo() {
        return cadCodigo;
    }

    public void setCadCodigo(Long cadCodigo) {
        this.cadCodigo = cadCodigo;
    }

    @Column(name = "CAD_NOMBRE", nullable = false, length = 30)
    public String getCadNombre() {
        return cadNombre;
    }

    public void setCadNombre(String cadNombre) {
        this.cadNombre = cadNombre;
    }

    @OneToMany(mappedBy = "siiCategoriaDistrib")
    public List<SiiDetalleDistrib> getSiiDetalleDistribList() {
        return siiDetalleDistribList;
    }

    public void setSiiDetalleDistribList(List<SiiDetalleDistrib> siiDetalleDistribList) {
        this.siiDetalleDistribList = siiDetalleDistribList;
    }

    public SiiDetalleDistrib addSiiDetalleDistrib(SiiDetalleDistrib siiDetalleDistrib) {
        getSiiDetalleDistribList().add(siiDetalleDistrib);
        siiDetalleDistrib.setSiiCategoriaDistrib(this);
        return siiDetalleDistrib;
    }

    public SiiDetalleDistrib removeSiiDetalleDistrib(SiiDetalleDistrib siiDetalleDistrib) {
        getSiiDetalleDistribList().remove(siiDetalleDistrib);
        siiDetalleDistrib.setSiiCategoriaDistrib(null);
        return siiDetalleDistrib;
    }
    
    @OneToMany(mappedBy = "siiCategoriaDistrib")
    public List<SiiConceptoCuota> getSiiConceptoCuotaList() {
        return siiConceptoCuotaList;
    }

    public void setSiiConceptoCuotaList(List<SiiConceptoCuota> siiConceptoCuotaList) {
        this.siiConceptoCuotaList = siiConceptoCuotaList;
    }

    public SiiConceptoCuota addSiiConceptoCuota(SiiConceptoCuota siiConceptoCuota) {
        getSiiConceptoCuotaList().add(siiConceptoCuota);
        siiConceptoCuota.setSiiCategoriaDistrib(this);
        return siiConceptoCuota;
    }

    public SiiConceptoCuota removeSiiConceptoCuota(SiiConceptoCuota siiConceptoCuota) {
        getSiiConceptoCuotaList().remove(siiConceptoCuota);
        siiConceptoCuota.setSiiCategoriaDistrib(null);
        return siiConceptoCuota;
    }

}
