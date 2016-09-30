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
@Table(name = "SII_BARRIO_ORDEN")
public class SiiBarrioOrden implements Serializable {
    private static final long serialVersionUID = 564332971713086849L;
    private String borActivo;
    private Long borCodigo;
    private String borNombre;
    private SiiUbicacion siiUbicacionMunicipio;
    private SiiOrdenTrabajoVisita siiOrdenTrabajoVisita;
    private List<SiiBarrioOrdenInfVer> siiBarrioOrdenInfVerList;

    public SiiBarrioOrden() {
    }

    public SiiBarrioOrden(String borActivo, Long borCodigo, String borNombre, SiiOrdenTrabajoVisita siiOrdenTrabajoVisita, SiiUbicacion siiUbicacionMunicipio) {
        this.borActivo = borActivo;
        this.borCodigo = borCodigo;
        this.borNombre = borNombre;
        this.siiOrdenTrabajoVisita = siiOrdenTrabajoVisita;
        this.siiUbicacionMunicipio = siiUbicacionMunicipio;
    }

    @Column(name = "BOR_ACTIVO", nullable = false, length = 1)
    public String getBorActivo() {
        return borActivo;
    }

    public void setBorActivo(String borActivo) {
        this.borActivo = borActivo;
    }

    @Id
    @Column(name = "BOR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_BARRIO_ORDEN_COD")
    @SequenceGenerator(name = "SEQ_BARRIO_ORDEN_COD", sequenceName = "SEQ_BARRIO_ORDEN_COD",allocationSize=1)
    public Long getBorCodigo() {
        return borCodigo;
    }

    public void setBorCodigo(Long borCodigo) {
        this.borCodigo = borCodigo;
    }

    @Column(name = "BOR_NOMBRE", nullable = false, length = 120)
    public String getBorNombre() {
        return borNombre;
    }

    public void setBorNombre(String borNombre) {
        this.borNombre = borNombre;
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

    @OneToMany(mappedBy = "siiBarrioOrden")
    public List<SiiBarrioOrdenInfVer> getSiiBarrioOrdenInfVerList() {
        return siiBarrioOrdenInfVerList;
    }

    public void setSiiBarrioOrdenInfVerList(List<SiiBarrioOrdenInfVer> siiBarrioOrdenInfVerList) {
        this.siiBarrioOrdenInfVerList = siiBarrioOrdenInfVerList;
    }

    public SiiBarrioOrdenInfVer addSiiBarrioOrdenInfVer(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer) {
        getSiiBarrioOrdenInfVerList().add(siiBarrioOrdenInfVer);
        siiBarrioOrdenInfVer.setSiiBarrioOrden(this);
        return siiBarrioOrdenInfVer;
    }

    public SiiBarrioOrdenInfVer removeSiiBarrioOrdenInfVer(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer) {
        getSiiBarrioOrdenInfVerList().remove(siiBarrioOrdenInfVer);
        siiBarrioOrdenInfVer.setSiiBarrioOrden(null);
        return siiBarrioOrdenInfVer;
    }
}
