package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_SMMLV")
public class SiiSmmlv implements Serializable {
    private static final long serialVersionUID = -2080559065295557899L;
    private Long smmValor;
    private Integer smmVigencia;
    private List<SiiLiquidacionMes> siiLiquidacionMesList;
    private BigDecimal smmIpc;
    private List<SiiActualizacionMulta> siiActualizacionMultaList;

    public SiiSmmlv() {
    }

    public SiiSmmlv(Long smmValor, Integer smmVigencia) {
        this.smmValor = smmValor;
        this.smmVigencia = smmVigencia;
    }

    @Column(name = "SMM_VALOR", nullable = false)
    public Long getSmmValor() {
        return smmValor;
    }

    public void setSmmValor(Long smmValor) {
        this.smmValor = smmValor;
    }

    @Id
    @Column(name = "SMM_VIGENCIA", nullable = false)
    public Integer getSmmVigencia() {
        return smmVigencia;
    }

    public void setSmmVigencia(Integer smmVigencia) {
        this.smmVigencia = smmVigencia;
    }

    @OneToMany(mappedBy = "siiSmmlv")
    public List<SiiLiquidacionMes> getSiiLiquidacionMesList() {
        return siiLiquidacionMesList;
    }

    public void setSiiLiquidacionMesList(List<SiiLiquidacionMes> siiLiquidacionMesList) {
        this.siiLiquidacionMesList = siiLiquidacionMesList;
    }

    public SiiLiquidacionMes addSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) {
        getSiiLiquidacionMesList().add(siiLiquidacionMes);
        siiLiquidacionMes.setSiiSmmlv(this);
        return siiLiquidacionMes;
    }

    public SiiLiquidacionMes removeSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) {
        getSiiLiquidacionMesList().remove(siiLiquidacionMes);
        siiLiquidacionMes.setSiiSmmlv(null);
        return siiLiquidacionMes;
    }

    @Column(name = "SMM_IPC")
    public BigDecimal getSmmIpc() {
        return smmIpc;
    }

    public void setSmmIpc(BigDecimal smmIpc) {
        this.smmIpc = smmIpc;
    }

    @OneToMany(mappedBy = "siiSmmlv")
    public List<SiiActualizacionMulta> getSiiActualizacionMultaList() {
        return siiActualizacionMultaList;
    }

    public void setSiiActualizacionMultaList(List<SiiActualizacionMulta> siiActualizacionMultaList) {
        this.siiActualizacionMultaList = siiActualizacionMultaList;
    }

    public SiiActualizacionMulta addSiiActualizacionMulta(SiiActualizacionMulta siiActualizacionMulta) {
        getSiiActualizacionMultaList().add(siiActualizacionMulta);
        siiActualizacionMulta.setSiiSmmlv(this);
        return siiActualizacionMulta;
    }

    public SiiActualizacionMulta removeSiiActualizacionMulta(SiiActualizacionMulta siiActualizacionMulta) {
        getSiiActualizacionMultaList().remove(siiActualizacionMulta);
        siiActualizacionMulta.setSiiSmmlv(null);
        return siiActualizacionMulta;
    }
}
