package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_TERM_ANTICIP")
public class SiiEstadoTermAnticip implements Serializable {
    private static final long serialVersionUID = -5191559727467276461L;
    private Long etaCodigo;
    private String etaNombre;
    private List<SiiTerminacionAnticip> siiTerminacionAnticipList;

    public SiiEstadoTermAnticip() {
    }

    public SiiEstadoTermAnticip(Long etaCodigo, String etaNombre) {
        this.etaCodigo = etaCodigo;
        this.etaNombre = etaNombre;
    }

    @Id
    @Column(name = "ETA_CODIGO", nullable = false)
    public Long getEtaCodigo() {
        return etaCodigo;
    }

    public void setEtaCodigo(Long etaCodigo) {
        this.etaCodigo = etaCodigo;
    }

    @Column(name = "ETA_NOMBRE", nullable = false, length = 20)
    public String getEtaNombre() {
        return etaNombre;
    }

    public void setEtaNombre(String etaNombre) {
        this.etaNombre = etaNombre;
    }

    @OneToMany(mappedBy = "siiEstadoTermAnticip")
    public List<SiiTerminacionAnticip> getSiiTerminacionAnticipList() {
        return siiTerminacionAnticipList;
    }

    public void setSiiTerminacionAnticipList(List<SiiTerminacionAnticip> siiTerminacionAnticipList) {
        this.siiTerminacionAnticipList = siiTerminacionAnticipList;
    }

    public SiiTerminacionAnticip addSiiTerminacionAnticip(SiiTerminacionAnticip siiTerminacionAnticip) {
        getSiiTerminacionAnticipList().add(siiTerminacionAnticip);
        siiTerminacionAnticip.setSiiEstadoTermAnticip(this);
        return siiTerminacionAnticip;
    }

    public SiiTerminacionAnticip removeSiiTerminacionAnticip(SiiTerminacionAnticip siiTerminacionAnticip) {
        getSiiTerminacionAnticipList().remove(siiTerminacionAnticip);
        siiTerminacionAnticip.setSiiEstadoTermAnticip(null);
        return siiTerminacionAnticip;
    }
}
