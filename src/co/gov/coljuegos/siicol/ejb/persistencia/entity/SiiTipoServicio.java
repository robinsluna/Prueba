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
@Table(name = "SII_TIPO_SERVICIO")
public class SiiTipoServicio implements Serializable {
    private static final long serialVersionUID = -4719355680024916746L;
    private String tseActivo;
    private Long tseCodigo;
    private String tseNombre;
    private List<SiiCotizacionEstudio> siiCotizacionEstudioList;

    public SiiTipoServicio() {
    }

    public SiiTipoServicio(String tseActivo, Long tseCodigo, String tseNombre) {
        this.tseActivo = tseActivo;
        this.tseCodigo = tseCodigo;
        this.tseNombre = tseNombre;
    }

    @Column(name = "TSE_ACTIVO", length = 1)
    public String getTseActivo() {
        return tseActivo;
    }

    public void setTseActivo(String tseActivo) {
        this.tseActivo = tseActivo;
    }

    @Id
    @Column(name = "TSE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TIPO_SERVICIO_COD")
    @SequenceGenerator(name = "SEQ_TIPO_SERVICIO_COD", sequenceName = "SEQ_TIPO_SERVICIO_COD",allocationSize=1)
    public Long getTseCodigo() {
        return tseCodigo;
    }

    public void setTseCodigo(Long tseCodigo) {
        this.tseCodigo = tseCodigo;
    }

    @Column(name = "TSE_NOMBRE", length = 20)
    public String getTseNombre() {
        return tseNombre;
    }

    public void setTseNombre(String tseNombre) {
        this.tseNombre = tseNombre;
    }

    @OneToMany(mappedBy = "siiTipoServicio")
    public List<SiiCotizacionEstudio> getSiiCotizacionEstudioList() {
        return siiCotizacionEstudioList;
    }

    public void setSiiCotizacionEstudioList(List<SiiCotizacionEstudio> siiCotizacionEstudioList) {
        this.siiCotizacionEstudioList = siiCotizacionEstudioList;
    }

    public SiiCotizacionEstudio addSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList().add(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiTipoServicio(this);
        return siiCotizacionEstudio;
    }

    public SiiCotizacionEstudio removeSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList().remove(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiTipoServicio(null);
        return siiCotizacionEstudio;
    }
}
