package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_RESOLUC_SAN_CON")
public class SiiEstadoResolucSanCon implements Serializable {
    private static final long serialVersionUID = -4145778781191011905L;
    private Long ersCodigo;
    private String ersNombre;
    private List<SiiTramiteResolSanCon> siiTramiteResolSanConList;

    public SiiEstadoResolucSanCon() {
    }

    public SiiEstadoResolucSanCon(Long ersCodigo, String ersNombre) {
        this.ersCodigo = ersCodigo;
        this.ersNombre = ersNombre;
    }

    @Id
    @Column(name = "ERS_CODIGO", nullable = false)
    public Long getErsCodigo() {
        return ersCodigo;
    }

    public void setErsCodigo(Long ersCodigo) {
        this.ersCodigo = ersCodigo;
    }

    @Column(name = "ERS_NOMBRE", nullable = false, length = 30)
    public String getErsNombre() {
        return ersNombre;
    }

    public void setErsNombre(String ersNombre) {
        this.ersNombre = ersNombre;
    }

    @OneToMany(mappedBy = "siiEstadoResolucSanCon")
    public List<SiiTramiteResolSanCon> getSiiTramiteResolSanConList() {
        return siiTramiteResolSanConList;
    }

    public void setSiiTramiteResolSanConList(List<SiiTramiteResolSanCon> siiTramiteResolSanConList) {
        this.siiTramiteResolSanConList = siiTramiteResolSanConList;
    }

    public SiiTramiteResolSanCon addSiiTramiteResolSanCon(SiiTramiteResolSanCon siiTramiteResolSanCon) {
        getSiiTramiteResolSanConList().add(siiTramiteResolSanCon);
        siiTramiteResolSanCon.setSiiEstadoResolucSanCon(this);
        return siiTramiteResolSanCon;
    }

    public SiiTramiteResolSanCon removeSiiTramiteResolSanCon(SiiTramiteResolSanCon siiTramiteResolSanCon) {
        getSiiTramiteResolSanConList().remove(siiTramiteResolSanCon);
        siiTramiteResolSanCon.setSiiEstadoResolucSanCon(null);
        return siiTramiteResolSanCon;
    }
}
