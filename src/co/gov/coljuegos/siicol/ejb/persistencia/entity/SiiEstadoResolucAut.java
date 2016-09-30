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
@Table(name = "SII_ESTADO_RESOLUC_AUT")
public class SiiEstadoResolucAut implements Serializable {
    private static final long serialVersionUID = -5413007880578710603L;
    private Long eraCodigo;
    private String eraNombre;
    private List<SiiResolucionAutoriz> siiResolucionAutorizList;

    public SiiEstadoResolucAut() {
    }

    public SiiEstadoResolucAut(Long eraCodigo, String eraNombre) {
        this.eraCodigo = eraCodigo;
        this.eraNombre = eraNombre;
    }

    @Id
    @Column(name = "ERA_CODIGO", nullable = false)
    public Long getEraCodigo() {
        return eraCodigo;
    }

    public void setEraCodigo(Long eraCodigo) {
        this.eraCodigo = eraCodigo;
    }

    @Column(name = "ERA_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEraNombre() {
        return eraNombre;
    }

    public void setEraNombre(String eraNombre) {
        this.eraNombre = eraNombre;
    }

    @OneToMany(mappedBy = "siiEstadoResolucAut")
    public List<SiiResolucionAutoriz> getSiiResolucionAutorizList() {
        return siiResolucionAutorizList;
    }

    public void setSiiResolucionAutorizList(List<SiiResolucionAutoriz> siiResolucionAutorizList) {
        this.siiResolucionAutorizList = siiResolucionAutorizList;
    }

    public SiiResolucionAutoriz addSiiResolucionAutoriz(SiiResolucionAutoriz siiResolucionAutoriz) {
        getSiiResolucionAutorizList().add(siiResolucionAutoriz);
        siiResolucionAutoriz.setSiiEstadoResolucAut(this);
        return siiResolucionAutoriz;
    }

    public SiiResolucionAutoriz removeSiiResolucionAutoriz(SiiResolucionAutoriz siiResolucionAutoriz) {
        getSiiResolucionAutorizList().remove(siiResolucionAutoriz);
        siiResolucionAutoriz.setSiiEstadoResolucAut(null);
        return siiResolucionAutoriz;
    }
}
