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
@Table(name = "SII_DTLLE_FUENTE_FINANCIACION")
public class SiiDtlleFuenteFinanciacion implements Serializable {
    private static final long serialVersionUID = 6960695796299691027L;
    private Long dffCodigo;
    private Integer dffCodigoRecurso;
    private String dffDescripcion;
    private List<SiiDetalleRubro> siiDetalleRubroList;
    private SiiFuenteFinanciacion siiFuenteFinanciacion;

    public SiiDtlleFuenteFinanciacion() {
    }

    public SiiDtlleFuenteFinanciacion(Long dffCodigo, Integer dffCodigoRecurso, String dffDescripcion,
                                      SiiFuenteFinanciacion siiFuenteFinanciacion) {
        this.dffCodigo = dffCodigo;
        this.dffCodigoRecurso = dffCodigoRecurso;
        this.dffDescripcion = dffDescripcion;
        this.siiFuenteFinanciacion = siiFuenteFinanciacion;
    }

    @Id
    @Column(name = "DFF_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DETLLE_FUENTE_FIN_COD")
    @SequenceGenerator(name = "SEQ_DETLLE_FUENTE_FIN_COD", sequenceName = "SEQ_DETLLE_FUENTE_FIN_COD",allocationSize=1)
    public Long getDffCodigo() {
        return dffCodigo;
    }

    public void setDffCodigo(Long dffCodigo) {
        this.dffCodigo = dffCodigo;
    }

    @Column(name = "DFF_CODIGO_RECURSO")
    public Integer getDffCodigoRecurso() {
        return dffCodigoRecurso;
    }

    public void setDffCodigoRecurso(Integer dffCodigoRecurso) {
        this.dffCodigoRecurso = dffCodigoRecurso;
    }

    @Column(name = "DFF_DESCRIPCION", nullable = false, length = 50)
    public String getDffDescripcion() {
        return dffDescripcion;
    }

    public void setDffDescripcion(String dffDescripcion) {
        this.dffDescripcion = dffDescripcion;
    }


    @OneToMany(mappedBy = "siiDtlleFuenteFinanciacion")
    public List<SiiDetalleRubro> getSiiDetalleRubroList() {
        return siiDetalleRubroList;
    }

    public void setSiiDetalleRubroList(List<SiiDetalleRubro> siiDetalleRubroList) {
        this.siiDetalleRubroList = siiDetalleRubroList;
    }

    public SiiDetalleRubro addSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) {
        getSiiDetalleRubroList().add(siiDetalleRubro);
        siiDetalleRubro.setSiiDtlleFuenteFinanciacion(this);
        return siiDetalleRubro;
    }

    public SiiDetalleRubro removeSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) {
        getSiiDetalleRubroList().remove(siiDetalleRubro);
        siiDetalleRubro.setSiiDtlleFuenteFinanciacion(null);
        return siiDetalleRubro;
    }

    @ManyToOne
    @JoinColumn(name = "FFI_CODIGO")
    public SiiFuenteFinanciacion getSiiFuenteFinanciacion() {
        return siiFuenteFinanciacion;
    }

    public void setSiiFuenteFinanciacion(SiiFuenteFinanciacion siiFuenteFinanciacion) {
        this.siiFuenteFinanciacion = siiFuenteFinanciacion;
    }
}
