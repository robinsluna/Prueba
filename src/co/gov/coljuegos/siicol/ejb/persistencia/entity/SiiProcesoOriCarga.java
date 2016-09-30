package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_PROCESO_ORI_CARGA")
public class SiiProcesoOriCarga implements Serializable {
    private static final long serialVersionUID = -3817820783509984032L;
    private Long pocCodigo;
    private String pocNombre;
    private List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList;

    public SiiProcesoOriCarga() {
    }

    public SiiProcesoOriCarga(Long pocCodigo, String pocNombre) {
        this.pocCodigo = pocCodigo;
        this.pocNombre = pocNombre;
    }

    @Id
    @Column(name = "POC_CODIGO", nullable = false)
    public Long getPocCodigo() {
        return pocCodigo;
    }

    public void setPocCodigo(Long pocCodigo) {
        this.pocCodigo = pocCodigo;
    }

    @Column(name = "POC_NOMBRE", nullable = false, length = 40)
    public String getPocNombre() {
        return pocNombre;
    }

    public void setPocNombre(String pocNombre) {
        this.pocNombre = pocNombre;
    }

    @OneToMany(mappedBy = "siiProcesoOriCarga")
    public List<SiiCargaActuacionesAdm> getSiiCargaActuacionesAdmList() {
        return siiCargaActuacionesAdmList;
    }

    public void setSiiCargaActuacionesAdmList(List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmList) {
        this.siiCargaActuacionesAdmList = siiCargaActuacionesAdmList;
    }

    public SiiCargaActuacionesAdm addSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().add(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiProcesoOriCarga(this);
        return siiCargaActuacionesAdm;
    }

    public SiiCargaActuacionesAdm removeSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmList().remove(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiProcesoOriCarga(null);
        return siiCargaActuacionesAdm;
    }
}
