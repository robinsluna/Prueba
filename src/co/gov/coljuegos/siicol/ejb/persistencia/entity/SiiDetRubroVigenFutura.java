package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_DET_RUBRO_VIGEN_FUTURA")
public class SiiDetRubroVigenFutura implements Serializable {
    private static final long serialVersionUID = -6378191002863345894L;
    private Long drvCodigo;
    private String drvEstado;
    private BigDecimal drvValor;
    private Integer drvVigencia;
    private SiiVigenciaFutura siiVigenciaFutura;
    private SiiDetalleRubro siiDetalleRubro;

    public SiiDetRubroVigenFutura() {
    }

    public SiiDetRubroVigenFutura(SiiDetalleRubro siiDetalleRubro, Long drvCodigo, String drvEstado, BigDecimal drvValor,
                                  Integer drvVigencia, SiiVigenciaFutura siiVigenciaFutura) {
        this.siiDetalleRubro = siiDetalleRubro;
        this.drvCodigo = drvCodigo;
        this.drvEstado = drvEstado;
        this.drvValor = drvValor;
        this.drvVigencia = drvVigencia;
        this.siiVigenciaFutura = siiVigenciaFutura;
    }


    @Id
    @Column(name = "DRV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DET_RUB_VIGEN_FUTURA_COD")
    @SequenceGenerator(name = "SEQ_DET_RUB_VIGEN_FUTURA_COD", sequenceName = "SEQ_DET_RUB_VIGEN_FUTURA_COD",allocationSize=1)
    public Long getDrvCodigo() {
        return drvCodigo;
    }

    public void setDrvCodigo(Long drvCodigo) {
        this.drvCodigo = drvCodigo;
    }

    @Column(name = "DRV_ESTADO", nullable = false, length = 1)
    public String getDrvEstado() {
        return drvEstado;
    }

    public void setDrvEstado(String drvEstado) {
        this.drvEstado = drvEstado;
    }

    @Column(name = "DRV_VALOR", nullable = false)
    public BigDecimal getDrvValor() {
        return drvValor;
    }

    public void setDrvValor(BigDecimal drvValor) {
        this.drvValor = drvValor;
    }

    @Column(name = "DRV_VIGENCIA", nullable = false)
    public Integer getDrvVigencia() {
        return drvVigencia;
    }

    public void setDrvVigencia(Integer drvVigencia) {
        this.drvVigencia = drvVigencia;
    }


    @ManyToOne
    @JoinColumn(name = "VFU_CODIGO")
    public SiiVigenciaFutura getSiiVigenciaFutura() {
        return siiVigenciaFutura;
    }

    public void setSiiVigenciaFutura(SiiVigenciaFutura siiVigenciaFutura) {
        this.siiVigenciaFutura = siiVigenciaFutura;
    }

    @ManyToOne
    @JoinColumn(name = "DRU_CODIGO")
    public SiiDetalleRubro getSiiDetalleRubro() {
        return siiDetalleRubro;
    }

    public void setSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) {
        this.siiDetalleRubro = siiDetalleRubro;
    }
}
