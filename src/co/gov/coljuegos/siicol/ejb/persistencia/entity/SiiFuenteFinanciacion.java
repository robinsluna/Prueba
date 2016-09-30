package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_FUENTE_FINANCIACION")
public class SiiFuenteFinanciacion implements Serializable {
    private static final long serialVersionUID = 7633292578024551368L;
    private Long ffiCodigo;
    private Integer ffiCodigoFuente;
    private String ffiDescripcion;
    private String ffiNombre;
    private List<SiiDtlleFuenteFinanciacion> siiDtlleFuenteFinanciacionList;

    public SiiFuenteFinanciacion() {
    }

    public SiiFuenteFinanciacion(Long ffiCodigo, Integer ffiCodigoFuente, String ffiDescripcion, String ffiNombre) {
        this.ffiCodigo = ffiCodigo;
        this.ffiCodigoFuente = ffiCodigoFuente;
        this.ffiDescripcion = ffiDescripcion;
        this.ffiNombre = ffiNombre;
    }

    @Id
    @Column(name = "FFI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_FUENTE_FIN_COD")
    @SequenceGenerator(name = "SEQ_FUENTE_FIN_COD", sequenceName = "SEQ_FUENTE_FIN_COD",allocationSize=1)
    public Long getFfiCodigo() {
        return ffiCodigo;
    }

    public void setFfiCodigo(Long ffiCodigo) {
        this.ffiCodigo = ffiCodigo;
    }

    @Column(name = "FFI_CODIGO_FUENTE", nullable = false)
    public Integer getFfiCodigoFuente() {
        return ffiCodigoFuente;
    }

    public void setFfiCodigoFuente(Integer ffiCodigoFuente) {
        this.ffiCodigoFuente = ffiCodigoFuente;
    }

    @Column(name = "FFI_DESCRIPCION", nullable = false, length = 50)
    public String getFfiDescripcion() {
        return ffiDescripcion;
    }

    public void setFfiDescripcion(String ffiDescripcion) {
        this.ffiDescripcion = ffiDescripcion;
    }

    @Column(name = "FFI_NOMBRE", length = 20)
    public String getFfiNombre() {
        return ffiNombre;
    }

    public void setFfiNombre(String ffiNombre) {
        this.ffiNombre = ffiNombre;
    }

    @OneToMany(mappedBy = "siiFuenteFinanciacion")
    public List<SiiDtlleFuenteFinanciacion> getSiiDtlleFuenteFinanciacionList() {
        return siiDtlleFuenteFinanciacionList;
    }

    public void setSiiDtlleFuenteFinanciacionList(List<SiiDtlleFuenteFinanciacion> siiDtlleFuenteFinanciacionList) {
        this.siiDtlleFuenteFinanciacionList = siiDtlleFuenteFinanciacionList;
    }

    public SiiDtlleFuenteFinanciacion addSiiDtlleFuenteFinanciacion(SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion) {
        getSiiDtlleFuenteFinanciacionList().add(siiDtlleFuenteFinanciacion);
        siiDtlleFuenteFinanciacion.setSiiFuenteFinanciacion(this);
        return siiDtlleFuenteFinanciacion;
    }

    public SiiDtlleFuenteFinanciacion removeSiiDtlleFuenteFinanciacion(SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion) {
        getSiiDtlleFuenteFinanciacionList().remove(siiDtlleFuenteFinanciacion);
        siiDtlleFuenteFinanciacion.setSiiFuenteFinanciacion(null);
        return siiDtlleFuenteFinanciacion;
    }
}
