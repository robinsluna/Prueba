package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_SUSPENSION_CONT")
public class SiiEstadoSuspensionCont implements Serializable {
    private static final long serialVersionUID = -4251496379255881317L;
    private Long escCodigo;
    private String escNombre;
    private List<SiiSuspensionContr> siiSuspensionContrList;

    public SiiEstadoSuspensionCont() {
    }

    public SiiEstadoSuspensionCont(Long escCodigo, String escNombre) {
        this.escCodigo = escCodigo;
        this.escNombre = escNombre;
    }

    @Id
    @Column(name = "ESC_CODIGO", nullable = false)
    public Long getEscCodigo() {
        return escCodigo;
    }

    public void setEscCodigo(Long escCodigo) {
        this.escCodigo = escCodigo;
    }

    @Column(name = "ESC_NOMBRE", nullable = false, length = 20)
    public String getEscNombre() {
        return escNombre;
    }

    public void setEscNombre(String escNombre) {
        this.escNombre = escNombre;
    }

    @OneToMany(mappedBy = "siiEstadoSuspensionCont")
    public List<SiiSuspensionContr> getSiiSuspensionContrList() {
        return siiSuspensionContrList;
    }

    public void setSiiSuspensionContrList(List<SiiSuspensionContr> siiSuspensionContrList) {
        this.siiSuspensionContrList = siiSuspensionContrList;
    }

    public SiiSuspensionContr addSiiSuspensionContr(SiiSuspensionContr siiSuspensionContr) {
        getSiiSuspensionContrList().add(siiSuspensionContr);
        siiSuspensionContr.setSiiEstadoSuspensionCont(this);
        return siiSuspensionContr;
    }

    public SiiSuspensionContr removeSiiSuspensionContr(SiiSuspensionContr siiSuspensionContr) {
        getSiiSuspensionContrList().remove(siiSuspensionContr);
        siiSuspensionContr.setSiiEstadoSuspensionCont(null);
        return siiSuspensionContr;
    }
}
