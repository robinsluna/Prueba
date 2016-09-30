package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_CDP")
public class SiiEstadoCdp implements Serializable {
    private static final long serialVersionUID = 2535707796317160706L;
    private Long ecdCodigo;
    private String ecdDescripcion;
    private String ecdNombre;
    private List<SiiCdp> siiCdpList2;

    public SiiEstadoCdp() {
    }

    public SiiEstadoCdp(Long ecdCodigo, String ecdDescripcion, String ecdNombre) {
        this.ecdCodigo = ecdCodigo;
        this.ecdDescripcion = ecdDescripcion;
        this.ecdNombre = ecdNombre;
    }

    @Id
    @Column(name = "ECD_CODIGO", nullable = false)
    public Long getEcdCodigo() {
        return ecdCodigo;
    }

    public void setEcdCodigo(Long ecdCodigo) {
        this.ecdCodigo = ecdCodigo;
    }

    @Column(name = "ECD_DESCRIPCION", length = 100)
    public String getEcdDescripcion() {
        return ecdDescripcion;
    }

    public void setEcdDescripcion(String ecdDescripcion) {
        this.ecdDescripcion = ecdDescripcion;
    }

    @Column(name = "ECD_NOMBRE", nullable = false, length = 20)
    public String getEcdNombre() {
        return ecdNombre;
    }

    public void setEcdNombre(String ecdNombre) {
        this.ecdNombre = ecdNombre;
    }

    @OneToMany(mappedBy = "siiEstadoCdp")
    public List<SiiCdp> getSiiCdpList2() {
        return siiCdpList2;
    }

    public void setSiiCdpList2(List<SiiCdp> siiCdpList2) {
        this.siiCdpList2 = siiCdpList2;
    }

    public SiiCdp addSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList2().add(siiCdp);
        siiCdp.setSiiEstadoCdp(this);
        return siiCdp;
    }

    public SiiCdp removeSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList2().remove(siiCdp);
        siiCdp.setSiiEstadoCdp(null);
        return siiCdp;
    }
}
