package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MOTIVO_ANUL_RP")
public class SiiMotivoAnulRp implements Serializable {
    private static final long serialVersionUID = -3392161501133416547L;
    private Long manCodigo;
    private String manNombre;
    private List<SiiRp> siiRpList;

    public SiiMotivoAnulRp() {
    }

    public SiiMotivoAnulRp(Long manCodigo, String manNombre) {
        this.manCodigo = manCodigo;
        this.manNombre = manNombre;
    }

    @Id
    @Column(name = "MAN_CODIGO", nullable = false)
    public Long getManCodigo() {
        return manCodigo;
    }

    public void setManCodigo(Long manCodigo) {
        this.manCodigo = manCodigo;
    }

    @Column(name = "MAN_NOMBRE", nullable = false, length = 100)
    public String getManNombre() {
        return manNombre;
    }

    public void setManNombre(String manNombre) {
        this.manNombre = manNombre;
    }

    @OneToMany(mappedBy = "siiMotivoAnulRp")
    public List<SiiRp> getSiiRpList() {
        return siiRpList;
    }

    public void setSiiRpList(List<SiiRp> siiRpList) {
        this.siiRpList = siiRpList;
    }

    public SiiRp addSiiRp(SiiRp siiRp) {
        getSiiRpList().add(siiRp);
        siiRp.setSiiMotivoAnulRp(this);
        return siiRp;
    }

    public SiiRp removeSiiRp(SiiRp siiRp) {
        getSiiRpList().remove(siiRp);
        siiRp.setSiiMotivoAnulRp(null);
        return siiRp;
    }
}
