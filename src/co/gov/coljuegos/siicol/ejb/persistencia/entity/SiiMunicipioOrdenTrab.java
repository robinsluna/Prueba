package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MUNICIPIO_ORDEN_TRAB")
public class SiiMunicipioOrdenTrab implements Serializable {
    private static final long serialVersionUID = 8866780056857073423L;
    private String motActivo;
    private Long motCodigo;
    private SiiUbicacion siiUbicacionMunicipio;
    private SiiOrdenTrabajoVisita siiOrdenTrabajoVisita;
    private List<SiiMunicOrdTraInfVerif> siiMunicOrdTraInfVerifList;

    public SiiMunicipioOrdenTrab() {
    }

    public SiiMunicipioOrdenTrab(String motActivo, Long motCodigo, SiiOrdenTrabajoVisita siiOrdenTrabajoVisita, SiiUbicacion siiUbicacionMunicipio) {
        this.motActivo = motActivo;
        this.motCodigo = motCodigo;
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
        this.siiUbicacionMunicipio = siiUbicacionMunicipio;
    }

    @Column(name = "MOT_ACTIVO", nullable = false, length = 1)
    public String getMotActivo() {
        return motActivo;
    }

    public void setMotActivo(String motActivo) {
        this.motActivo = motActivo;
    }

    @Id
    @Column(name = "MOT_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MUNICIPIO_ORD_TRAB_COD")
    @SequenceGenerator(name = "SEQ_MUNICIPIO_ORD_TRAB_COD", sequenceName = "SEQ_MUNICIPIO_ORD_TRAB_COD",allocationSize=1)
    public Long getMotCodigo() {
        return motCodigo;
    }

    public void setMotCodigo(Long motCodigo) {
        this.motCodigo = motCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacionMunicipio() {
        return siiUbicacionMunicipio;
    }

    public void setSiiUbicacionMunicipio(SiiUbicacion siiUbicacionMunicipio) {
        this.siiUbicacionMunicipio = siiUbicacionMunicipio;
    }

    @ManyToOne
    @JoinColumn(name = "OTV_CODIGO")
    public SiiOrdenTrabajoVisita getSiiOrdenTrabajoVisita() {
        return siiOrdenTrabajoVisita;
    }

    public void setSiiOrdenTrabajoVisita(SiiOrdenTrabajoVisita siiOrdenTrabajoVisita) {
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
    }

    @OneToMany(mappedBy = "siiMunicipioOrdenTrab")
    public List<SiiMunicOrdTraInfVerif> getSiiMunicOrdTraInfVerifList() {
        return siiMunicOrdTraInfVerifList;
    }

    public void setSiiMunicOrdTraInfVerifList(List<SiiMunicOrdTraInfVerif> siiMunicOrdTraInfVerifList) {
        this.siiMunicOrdTraInfVerifList = siiMunicOrdTraInfVerifList;
    }

    public SiiMunicOrdTraInfVerif addSiiMunicOrdTraInfVerif(SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif) {
        getSiiMunicOrdTraInfVerifList().add(siiMunicOrdTraInfVerif);
        siiMunicOrdTraInfVerif.setSiiMunicipioOrdenTrab(this);
        return siiMunicOrdTraInfVerif;
    }

    public SiiMunicOrdTraInfVerif removeSiiMunicOrdTraInfVerif(SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif) {
        getSiiMunicOrdTraInfVerifList().remove(siiMunicOrdTraInfVerif);
        siiMunicOrdTraInfVerif.setSiiMunicipioOrdenTrab(null);
        return siiMunicOrdTraInfVerif;
    }
}
