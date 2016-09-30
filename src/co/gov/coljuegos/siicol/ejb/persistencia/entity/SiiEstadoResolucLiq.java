package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_RESOLUC_LIQ")
public class SiiEstadoResolucLiq implements Serializable {
    private static final long serialVersionUID = 6973036355927285443L;
    private Long erlCodigo;
    private String erlNombre;
    private List<SiiResolucionLiquid> siiResolucionLiquidList;

    public SiiEstadoResolucLiq() {
    }

    public SiiEstadoResolucLiq(Long erlCodigo, String erlNombre) {
        this.erlCodigo = erlCodigo;
        this.erlNombre = erlNombre;
    }

    @Id
    @Column(name = "ERL_CODIGO", nullable = false)
    public Long getErlCodigo() {
        return erlCodigo;
    }

    public void setErlCodigo(Long erlCodigo) {
        this.erlCodigo = erlCodigo;
    }

    @Column(name = "ERL_NOMBRE", nullable = false, length = 30)
    public String getErlNombre() {
        return erlNombre;
    }

    public void setErlNombre(String erlNombre) {
        this.erlNombre = erlNombre;
    }

    @OneToMany(mappedBy = "siiEstadoResolucLiq")
    public List<SiiResolucionLiquid> getSiiResolucionLiquidList() {
        return siiResolucionLiquidList;
    }

    public void setSiiResolucionLiquidList(List<SiiResolucionLiquid> siiResolucionLiquidList) {
        this.siiResolucionLiquidList = siiResolucionLiquidList;
    }

    public SiiResolucionLiquid addSiiResolucionLiquid(SiiResolucionLiquid siiResolucionLiquid) {
        getSiiResolucionLiquidList().add(siiResolucionLiquid);
        siiResolucionLiquid.setSiiEstadoResolucLiq(this);
        return siiResolucionLiquid;
    }

    public SiiResolucionLiquid removeSiiResolucionLiquid(SiiResolucionLiquid siiResolucionLiquid) {
        getSiiResolucionLiquidList().remove(siiResolucionLiquid);
        siiResolucionLiquid.setSiiEstadoResolucLiq(null);
        return siiResolucionLiquid;
    }
}
