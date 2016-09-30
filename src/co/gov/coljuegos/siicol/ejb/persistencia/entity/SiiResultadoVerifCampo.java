package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_RESULTADO_VERIF_CAMPO")
public class SiiResultadoVerifCampo implements Serializable {
    private static final long serialVersionUID = 7794187093559360875L;
    private Long rvcCodigo;
    private String rvcNombre;
    private List<SiiDenuncOrdTraInfVer> siiDenuncOrdTraInfVerList;

    public SiiResultadoVerifCampo() {
    }

    public SiiResultadoVerifCampo(Long rvcCodigo, String rvcNombre) {
        this.rvcCodigo = rvcCodigo;
        this.rvcNombre = rvcNombre;
    }

    @Id
    @Column(name = "RVC_CODIGO", nullable = false)
    public Long getRvcCodigo() {
        return rvcCodigo;
    }

    public void setRvcCodigo(Long rvcCodigo) {
        this.rvcCodigo = rvcCodigo;
    }

    @Column(name = "RVC_NOMBRE", nullable = false, length = 30)
    public String getRvcNombre() {
        return rvcNombre;
    }

    public void setRvcNombre(String rvcNombre) {
        this.rvcNombre = rvcNombre;
    }

    @OneToMany(mappedBy = "siiResultadoVerifCampo")
    public List<SiiDenuncOrdTraInfVer> getSiiDenuncOrdTraInfVerList() {
        return siiDenuncOrdTraInfVerList;
    }

    public void setSiiDenuncOrdTraInfVerList(List<SiiDenuncOrdTraInfVer> siiDenuncOrdTraInfVerList) {
        this.siiDenuncOrdTraInfVerList = siiDenuncOrdTraInfVerList;
    }

    public SiiDenuncOrdTraInfVer addSiiDenuncOrdTraInfVer(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) {
        getSiiDenuncOrdTraInfVerList().add(siiDenuncOrdTraInfVer);
        siiDenuncOrdTraInfVer.setSiiResultadoVerifCampo(this);
        return siiDenuncOrdTraInfVer;
    }

    public SiiDenuncOrdTraInfVer removeSiiDenuncOrdTraInfVer(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) {
        getSiiDenuncOrdTraInfVerList().remove(siiDenuncOrdTraInfVer);
        siiDenuncOrdTraInfVer.setSiiResultadoVerifCampo(null);
        return siiDenuncOrdTraInfVer;
    }
}
