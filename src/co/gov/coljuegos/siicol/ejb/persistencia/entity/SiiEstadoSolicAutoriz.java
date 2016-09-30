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
@Table(name = "SII_ESTADO_SOLIC_AUTORIZ")
public class SiiEstadoSolicAutoriz implements Serializable {
    private static final long serialVersionUID = -7258426342975695126L;
    private Long esaCodigo;
    private String esaNombre;
    private List<SiiSolicitudAutoriza> siiSolicitudAutorizaList;

    public SiiEstadoSolicAutoriz() {
    }

    public SiiEstadoSolicAutoriz(Long esaCodigo, String esaNombre) {
        this.esaCodigo = esaCodigo;
        this.esaNombre = esaNombre;
    }

    @Id
    @Column(name = "ESA_CODIGO", nullable = false)
    public Long getEsaCodigo() {
        return esaCodigo;
    }

    public void setEsaCodigo(Long esaCodigo) {
        this.esaCodigo = esaCodigo;
    }

    @Column(name = "ESA_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEsaNombre() {
        return esaNombre;
    }

    public void setEsaNombre(String esaNombre) {
        this.esaNombre = esaNombre;
    }

    @OneToMany(mappedBy = "siiEstadoSolicAutoriz")
    public List<SiiSolicitudAutoriza> getSiiSolicitudAutorizaList() {
        return siiSolicitudAutorizaList;
    }

    public void setSiiSolicitudAutorizaList(List<SiiSolicitudAutoriza> siiSolicitudAutorizaList) {
        this.siiSolicitudAutorizaList = siiSolicitudAutorizaList;
    }

    public SiiSolicitudAutoriza addSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().add(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(this);
        return siiSolicitudAutoriza;
    }

    public SiiSolicitudAutoriza removeSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().remove(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(null);
        return siiSolicitudAutoriza;
    }
}
