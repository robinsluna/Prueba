package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SII_AJUSTE_DET_RECAUDO")
public class SiiAjusteDetRecaudo implements Serializable {
    private static final long serialVersionUID = -1951770250491969598L;
    private Long adrCodigo;
    private BigDecimal adrValor;
    private BigDecimal adrValorInteres;
    private SiiAjuste siiAjuste;
    private SiiDetalleRecaudo siiDetalleRecaudo;

    public SiiAjusteDetRecaudo() {
    }

    public SiiAjusteDetRecaudo(Long adrCodigo, BigDecimal adrValor, BigDecimal adrValorInteres, SiiAjuste siiAjuste,
                               SiiDetalleRecaudo siiDetalleRecaudo) {
        this.adrCodigo = adrCodigo;
        this.adrValor = adrValor;
        this.adrValorInteres = adrValorInteres;
        this.siiAjuste = siiAjuste;
        this.siiDetalleRecaudo = siiDetalleRecaudo;
    }

    @Id
    @Column(name = "ADR_CODIGO", nullable = false)
    public Long getAdrCodigo() {
        return adrCodigo;
    }

    public void setAdrCodigo(Long adrCodigo) {
        this.adrCodigo = adrCodigo;
    }

    @Column(name = "ADR_VALOR")
    public BigDecimal getAdrValor() {
        return adrValor;
    }

    public void setAdrValor(BigDecimal adrValor) {
        this.adrValor = adrValor;
    }

    @Column(name = "ADR_VALOR_INTERES")
    public BigDecimal getAdrValorInteres() {
        return adrValorInteres;
    }

    public void setAdrValorInteres(BigDecimal adrValorInteres) {
        this.adrValorInteres = adrValorInteres;
    }


    @ManyToOne
    @JoinColumn(name = "AJU_CODIGO")
    public SiiAjuste getSiiAjuste() {
        return siiAjuste;
    }

    public void setSiiAjuste(SiiAjuste siiAjuste) {
        this.siiAjuste = siiAjuste;
    }

    @ManyToOne
    @JoinColumn(name = "DRE_CODIGO")
    public SiiDetalleRecaudo getSiiDetalleRecaudo() {
        return siiDetalleRecaudo;
    }

    public void setSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        this.siiDetalleRecaudo = siiDetalleRecaudo;
    }
}
