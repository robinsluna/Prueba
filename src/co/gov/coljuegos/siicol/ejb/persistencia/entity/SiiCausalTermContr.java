package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CAUSAL_TERM_CONTR")
public class SiiCausalTermContr implements Serializable {
    private static final long serialVersionUID = -466214264429910000L;
    private Long ctcCodigo;
    private String ctcNombre;
    private List<SiiLiquidacionContrato> siiLiquidacionContratoList;

    public SiiCausalTermContr() {
    }

    public SiiCausalTermContr(Long ctcCodigo, String ctcNombre) {
        this.ctcCodigo = ctcCodigo;
        this.ctcNombre = ctcNombre;
    }

    @Id
    @Column(name = "CTC_CODIGO", nullable = false)
    public Long getCtcCodigo() {
        return ctcCodigo;
    }

    public void setCtcCodigo(Long ctcCodigo) {
        this.ctcCodigo = ctcCodigo;
    }

    @Column(name = "CTC_NOMBRE", nullable = false, length = 30)
    public String getCtcNombre() {
        return ctcNombre;
    }

    public void setCtcNombre(String ctcNombre) {
        this.ctcNombre = ctcNombre;
    }

    @OneToMany(mappedBy = "siiCausalTermContr")
    public List<SiiLiquidacionContrato> getSiiLiquidacionContratoList() {
        return siiLiquidacionContratoList;
    }

    public void setSiiLiquidacionContratoList(List<SiiLiquidacionContrato> siiLiquidacionContratoList) {
        this.siiLiquidacionContratoList = siiLiquidacionContratoList;
    }

    public SiiLiquidacionContrato addSiiLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) {
        getSiiLiquidacionContratoList().add(siiLiquidacionContrato);
        siiLiquidacionContrato.setSiiCausalTermContr(this);
        return siiLiquidacionContrato;
    }

    public SiiLiquidacionContrato removeSiiLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) {
        getSiiLiquidacionContratoList().remove(siiLiquidacionContrato);
        siiLiquidacionContrato.setSiiCausalTermContr(null);
        return siiLiquidacionContrato;
    }
}
