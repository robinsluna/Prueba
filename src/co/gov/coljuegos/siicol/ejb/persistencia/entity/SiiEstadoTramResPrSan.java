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
@Table(name = "SII_ESTADO_TRAM_RES_PR_SAN")
public class SiiEstadoTramResPrSan implements Serializable {
    private static final long serialVersionUID = -1281527611756238143L;
    private Long etrCodigo;
    private String etrNombre;
    private List<SiiTramiteResolProcSan> siiTramiteResolProcSanList;

    public SiiEstadoTramResPrSan() {
    }

    public SiiEstadoTramResPrSan(Long etrCodigo, String etrNombre) {
        this.etrCodigo = etrCodigo;
        this.etrNombre = etrNombre;
    }

    @Id
    @Column(name = "ETR_CODIGO", nullable = false)
    public Long getEtrCodigo() {
        return etrCodigo;
    }

    public void setEtrCodigo(Long etrCodigo) {
        this.etrCodigo = etrCodigo;
    }

    @Column(name = "ETR_NOMBRE", nullable = false, length = 30)
    public String getEtrNombre() {
        return etrNombre;
    }

    public void setEtrNombre(String etrNombre) {
        this.etrNombre = etrNombre;
    }

    @OneToMany(mappedBy = "siiEstadoTramResPrSan")
    public List<SiiTramiteResolProcSan> getSiiTramiteResolProcSanList() {
        return siiTramiteResolProcSanList;
    }

    public void setSiiTramiteResolProcSanList(List<SiiTramiteResolProcSan> siiTramiteResolProcSanList) {
        this.siiTramiteResolProcSanList = siiTramiteResolProcSanList;
    }

    public SiiTramiteResolProcSan addSiiTramiteResolProcSan(SiiTramiteResolProcSan siiTramiteResolProcSan) {
        getSiiTramiteResolProcSanList().add(siiTramiteResolProcSan);
        siiTramiteResolProcSan.setSiiEstadoTramResPrSan(this);
        return siiTramiteResolProcSan;
    }

    public SiiTramiteResolProcSan removeSiiTramiteResolProcSan(SiiTramiteResolProcSan siiTramiteResolProcSan) {
        getSiiTramiteResolProcSanList().remove(siiTramiteResolProcSan);
        siiTramiteResolProcSan.setSiiEstadoTramResPrSan(null);
        return siiTramiteResolProcSan;
    }
}
