package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CONCEPTO_NOMINA")
public class SiiConceptoNomina implements Serializable {
    private static final long serialVersionUID = 5174883494016856393L;
    private String cnoActivo;
    private String cnoCodigo;
    private String cnoNombre;
    private String cnoRubro;
    private String cnoReintegro;
    private List<SiiDetalleContNomina> siiDetalleContNominaList;

    public SiiConceptoNomina() {
    }

    public SiiConceptoNomina(String cnoActivo, String cnoCodigo, String cnoNombre) {
        this.cnoActivo = cnoActivo;
        this.cnoCodigo = cnoCodigo;
        this.cnoNombre = cnoNombre;
    }

    @Column(name = "CNO_ACTIVO", nullable = false, length = 1)
    public String getCnoActivo() {
        return cnoActivo;
    }

    public void setCnoActivo(String cnoActivo) {
        this.cnoActivo = cnoActivo;
    }

    @Id
    @Column(name = "CNO_CODIGO", nullable = false, length = 10)
    public String getCnoCodigo() {
        return cnoCodigo;
    }

    public void setCnoCodigo(String cnoCodigo) {
        this.cnoCodigo = cnoCodigo;
    }

    @Column(name = "CNO_NOMBRE", nullable = false, length = 60)
    public String getCnoNombre() {
        return cnoNombre;
    }

    public void setCnoNombre(String cnoNombre) {
        this.cnoNombre = cnoNombre;
    }

    @OneToMany(mappedBy = "siiConceptoNomina")
    public List<SiiDetalleContNomina> getSiiDetalleContNominaList() {
        return siiDetalleContNominaList;
    }

    public void setSiiDetalleContNominaList(List<SiiDetalleContNomina> siiDetalleContNominaList) {
        this.siiDetalleContNominaList = siiDetalleContNominaList;
    }

    public SiiDetalleContNomina addSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().add(siiDetalleContNomina);
        siiDetalleContNomina.setSiiConceptoNomina(this);
        return siiDetalleContNomina;
    }

    public SiiDetalleContNomina removeSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().remove(siiDetalleContNomina);
        siiDetalleContNomina.setSiiConceptoNomina(null);
        return siiDetalleContNomina;
    }

    @Column(name = "CNO_RUBRO", nullable = false, length = 20)
    public String getCnoRubro() {
        return cnoRubro;
    }
    
    public void setCnoRubro(String cnoRubro) {
        this.cnoRubro = cnoRubro;
    }

    @Column(name = "CNO_REINTEGRO", nullable = false, length = 1)
    public String getCnoReintegro() {
        return cnoReintegro;
    }
    
    public void setCnoReintegro(String cnoReintegro) {
        this.cnoReintegro = cnoReintegro;
    }

}
