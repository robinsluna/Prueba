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
@Table(name = "SII_TIPO_PRUEBA_ILEG")
public class SiiTipoPruebaIleg implements Serializable {
    private static final long serialVersionUID = -4984319062860373422L;
    private Long tpiCodigo;
    private String tpiNombre;
    private List<SiiPruebaAutoDecrPru> siiPruebaAutoDecrPruList;
    private List<SiiPruebaDescargoProIle> siiPruebaDescargoProIleList;

    public SiiTipoPruebaIleg() {
    }

    public SiiTipoPruebaIleg(Long tpiCodigo, String tpiNombre) {
        this.tpiCodigo = tpiCodigo;
        this.tpiNombre = tpiNombre;
    }

    @Id
    @Column(name = "TPI_CODIGO", nullable = false)
    public Long getTpiCodigo() {
        return tpiCodigo;
    }

    public void setTpiCodigo(Long tpiCodigo) {
        this.tpiCodigo = tpiCodigo;
    }

    @Column(name = "TPI_NOMBRE", nullable = false, length = 30)
    public String getTpiNombre() {
        return tpiNombre;
    }

    public void setTpiNombre(String tpiNombre) {
        this.tpiNombre = tpiNombre;
    }

    @OneToMany(mappedBy = "siiTipoPruebaIleg")
    public List<SiiPruebaAutoDecrPru> getSiiPruebaAutoDecrPruList() {
        return siiPruebaAutoDecrPruList;
    }

    public void setSiiPruebaAutoDecrPruList(List<SiiPruebaAutoDecrPru> siiPruebaAutoDecrPruList) {
        this.siiPruebaAutoDecrPruList = siiPruebaAutoDecrPruList;
    }

    public SiiPruebaAutoDecrPru addSiiPruebaAutoDecrPru(SiiPruebaAutoDecrPru siiPruebaAutoDecrPru) {
        getSiiPruebaAutoDecrPruList().add(siiPruebaAutoDecrPru);
        siiPruebaAutoDecrPru.setSiiTipoPruebaIleg(this);
        return siiPruebaAutoDecrPru;
    }

    public SiiPruebaAutoDecrPru removeSiiPruebaAutoDecrPru(SiiPruebaAutoDecrPru siiPruebaAutoDecrPru) {
        getSiiPruebaAutoDecrPruList().remove(siiPruebaAutoDecrPru);
        siiPruebaAutoDecrPru.setSiiTipoPruebaIleg(null);
        return siiPruebaAutoDecrPru;
    }

    @OneToMany(mappedBy = "siiTipoPruebaIleg")
    public List<SiiPruebaDescargoProIle> getSiiPruebaDescargoProIleList() {
        return siiPruebaDescargoProIleList;
    }

    public void setSiiPruebaDescargoProIleList(List<SiiPruebaDescargoProIle> siiPruebaDescargoProIleList) {
        this.siiPruebaDescargoProIleList = siiPruebaDescargoProIleList;
    }

    public SiiPruebaDescargoProIle addSiiPruebaDescargoProIle(SiiPruebaDescargoProIle siiPruebaDescargoProIle) {
        getSiiPruebaDescargoProIleList().add(siiPruebaDescargoProIle);
        siiPruebaDescargoProIle.setSiiTipoPruebaIleg(this);
        return siiPruebaDescargoProIle;
    }

    public SiiPruebaDescargoProIle removeSiiPruebaDescargoProIle(SiiPruebaDescargoProIle siiPruebaDescargoProIle) {
        getSiiPruebaDescargoProIleList().remove(siiPruebaDescargoProIle);
        siiPruebaDescargoProIle.setSiiTipoPruebaIleg(null);
        return siiPruebaDescargoProIle;
    }
}
