package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_CARGA_NOMINA")
public class SiiCargaNomina implements Serializable {
    private static final long serialVersionUID = -2181002075521351622L;
    private Long cnoCodigo;
    private String cnoNombreArch;
    private String cnoDescripcion;
    private List<SiiObligacion> siiObligacionList;
    private SiiArchivoFisico siiArchivoFisico;
    private List<SiiDetalleContNomina> siiDetalleContNominaList;

    public SiiCargaNomina() {
    }

    public SiiCargaNomina(SiiArchivoFisico siiArchivoFisico, Long cnoCodigo, String cnoNombreArch, String cnoDescripcion) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.cnoCodigo = cnoCodigo;
        this.cnoNombreArch = cnoNombreArch;
        this.cnoDescripcion = cnoDescripcion;
    }


    @Id
    @Column(name = "CNO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CARGA_NOMINA_COD")
    @SequenceGenerator(name = "SEQ_CARGA_NOMINA_COD", sequenceName = "SEQ_CARGA_NOMINA_COD",allocationSize=1)
    public Long getCnoCodigo() {
        return cnoCodigo;
    }

    public void setCnoCodigo(Long cnoCodigo) {
        this.cnoCodigo = cnoCodigo;
    }

    @Column(name = "CNO_NOMBRE_ARCH", nullable = false, length = 10)
    public String getCnoNombreArch() {
        return cnoNombreArch;
    }

    public void setCnoNombreArch(String cnoNombreArch) {
        this.cnoNombreArch = cnoNombreArch;
    }

    public void setCnoDescripcion(String cnoDescripcion) {
        this.cnoDescripcion = cnoDescripcion;
    }
    
    @Column(name = "CNO_DESCRIPCION", nullable = false, length = 500)
    public String getCnoDescripcion() {
        return cnoDescripcion;
    }

    @OneToMany(mappedBy = "siiCargaNomina")
    public List<SiiObligacion> getSiiObligacionList() {
        return siiObligacionList;
    }

    public void setSiiObligacionList(List<SiiObligacion> siiObligacionList) {
        this.siiObligacionList = siiObligacionList;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().add(siiObligacion);
        siiObligacion.setSiiCargaNomina(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().remove(siiObligacion);
        siiObligacion.setSiiCargaNomina(null);
        return siiObligacion;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @OneToMany(mappedBy = "siiCargaNomina")
    public List<SiiDetalleContNomina> getSiiDetalleContNominaList() {
        return siiDetalleContNominaList;
    }

    public void setSiiDetalleContNominaList(List<SiiDetalleContNomina> siiDetalleContNominaList) {
        this.siiDetalleContNominaList = siiDetalleContNominaList;
    }

    public SiiDetalleContNomina addSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().add(siiDetalleContNomina);
        siiDetalleContNomina.setSiiCargaNomina(this);
        return siiDetalleContNomina;
    }

    public SiiDetalleContNomina removeSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().remove(siiDetalleContNomina);
        siiDetalleContNomina.setSiiCargaNomina(null);
        return siiDetalleContNomina;
    }
}
