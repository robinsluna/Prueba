package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_LIQUID_CONT")
public class SiiEstadoLiquidCont implements Serializable {
    private static final long serialVersionUID = -4606693863577683418L;
    private Long elcCodigo;
    private String elcNombre;
    private List<SiiLiquidacionContrato> siiLiquidacionContratoList;

    public SiiEstadoLiquidCont() {
    }

    public SiiEstadoLiquidCont(Long elcCodigo, String elcNombre) {
        this.elcCodigo = elcCodigo;
        this.elcNombre = elcNombre;
    }

    @Id
    @Column(name = "ELC_CODIGO", nullable = false)
    public Long getElcCodigo() {
        return elcCodigo;
    }

    public void setElcCodigo(Long elcCodigo) {
        this.elcCodigo = elcCodigo;
    }

    @Column(name = "ELC_NOMBRE", nullable = false, length = 60)
    public String getElcNombre() {
        return elcNombre;
    }

    public void setElcNombre(String elcNombre) {
        this.elcNombre = elcNombre;
    }

    @OneToMany(mappedBy = "siiEstadoLiquidCont")
    public List<SiiLiquidacionContrato> getSiiLiquidacionContratoList() {
        return siiLiquidacionContratoList;
    }

    public void setSiiLiquidacionContratoList(List<SiiLiquidacionContrato> siiLiquidacionContratoList) {
        this.siiLiquidacionContratoList = siiLiquidacionContratoList;
    }

    public SiiLiquidacionContrato addSiiLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) {
        getSiiLiquidacionContratoList().add(siiLiquidacionContrato);
        siiLiquidacionContrato.setSiiEstadoLiquidCont(this);
        return siiLiquidacionContrato;
    }

    public SiiLiquidacionContrato removeSiiLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) {
        getSiiLiquidacionContratoList().remove(siiLiquidacionContrato);
        siiLiquidacionContrato.setSiiEstadoLiquidCont(null);
        return siiLiquidacionContrato;
    }
}
