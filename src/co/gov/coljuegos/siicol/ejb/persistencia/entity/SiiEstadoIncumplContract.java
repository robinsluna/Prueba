package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_INCUMPL_CONTRACT")
public class SiiEstadoIncumplContract implements Serializable {
    private static final long serialVersionUID = 8679120568187222507L;
    private Long eicCodigo;
    private String eicNombre;
    private List<SiiIncumplimientoContr> siiIncumplimientoContrList;

    public SiiEstadoIncumplContract() {
    }

    public SiiEstadoIncumplContract(Long eicCodigo, String eicNombre) {
        this.eicCodigo = eicCodigo;
        this.eicNombre = eicNombre;
    }

    @Id
    @Column(name = "EIC_CODIGO", nullable = false)
    public Long getEicCodigo() {
        return eicCodigo;
    }

    public void setEicCodigo(Long eicCodigo) {
        this.eicCodigo = eicCodigo;
    }

    @Column(name = "EIC_NOMBRE", nullable = false, length = 40)
    public String getEicNombre() {
        return eicNombre;
    }

    public void setEicNombre(String eicNombre) {
        this.eicNombre = eicNombre;
    }

    @OneToMany(mappedBy = "siiEstadoIncumplContract")
    public List<SiiIncumplimientoContr> getSiiIncumplimientoContrList() {
        return siiIncumplimientoContrList;
    }

    public void setSiiIncumplimientoContrList(List<SiiIncumplimientoContr> siiIncumplimientoContrList) {
        this.siiIncumplimientoContrList = siiIncumplimientoContrList;
    }

    public SiiIncumplimientoContr addSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrList().add(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiEstadoIncumplContract(this);
        return siiIncumplimientoContr;
    }

    public SiiIncumplimientoContr removeSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrList().remove(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiEstadoIncumplContract(null);
        return siiIncumplimientoContr;
    }
}
