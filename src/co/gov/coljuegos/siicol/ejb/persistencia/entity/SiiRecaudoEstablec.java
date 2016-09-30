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
@Table(name = "SII_RECAUDO_ESTABLEC")
public class SiiRecaudoEstablec implements Serializable {
    private static final long serialVersionUID = -3592702396329685660L;
    private Long reeCodigo;
    private BigDecimal reeValorPagado;
    private BigDecimal reeValorPropio;
    private BigDecimal reeValorTodos;
    private SiiDetalleDeclaracion siiDetalleDeclaracion;
    private SiiLiquidacionEstabl siiLiquidacionEstabl;
    private BigDecimal reeValorPagInter;

    public SiiRecaudoEstablec() {
    }

    public SiiRecaudoEstablec(SiiDetalleDeclaracion siiDetalleDeclaracion, SiiLiquidacionEstabl siiLiquidacionEstabl,
                              Long reeCodigo, BigDecimal reeValorPagado, BigDecimal reeValorPropio,
                              BigDecimal reeValorTodos) {
        this.siiDetalleDeclaracion = siiDetalleDeclaracion;
        this.siiLiquidacionEstabl = siiLiquidacionEstabl;
        this.reeCodigo = reeCodigo;
        this.reeValorPagado = reeValorPagado;
        this.reeValorPropio = reeValorPropio;
        this.reeValorTodos = reeValorTodos;
    }


    @Id
    @Column(name = "REE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RECAUDO_ESTABLEC_COD")
    @SequenceGenerator(name = "SEQ_RECAUDO_ESTABLEC_COD", sequenceName = "SEQ_RECAUDO_ESTABLEC_COD",allocationSize=1)
    public Long getReeCodigo() {
        return reeCodigo;
    }

    public void setReeCodigo(Long reeCodigo) {
        this.reeCodigo = reeCodigo;
    }

    @Column(name = "REE_VALOR_PAGADO", nullable = false)
    public BigDecimal getReeValorPagado() {
        return reeValorPagado;
    }

    public void setReeValorPagado(BigDecimal reeValorPagado) {
        this.reeValorPagado = reeValorPagado;
    }

    @Column(name = "REE_VALOR_PROPIO")
    public BigDecimal getReeValorPropio() {
        return reeValorPropio;
    }

    public void setReeValorPropio(BigDecimal reeValorPropio) {
        this.reeValorPropio = reeValorPropio;
    }

    @Column(name = "REE_VALOR_TODOS")
    public BigDecimal getReeValorTodos() {
        return reeValorTodos;
    }

    public void setReeValorTodos(BigDecimal reeValorTodos) {
        this.reeValorTodos = reeValorTodos;
    }

    @ManyToOne
    @JoinColumn(name = "DDE_CODIGO")
    public SiiDetalleDeclaracion getSiiDetalleDeclaracion() {
        return siiDetalleDeclaracion;
    }

    public void setSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        this.siiDetalleDeclaracion = siiDetalleDeclaracion;
    }

    @ManyToOne
    @JoinColumn(name = "LES_CODIGO")
    public SiiLiquidacionEstabl getSiiLiquidacionEstabl() {
        return siiLiquidacionEstabl;
    }

    public void setSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        this.siiLiquidacionEstabl = siiLiquidacionEstabl;
    }

    @Column(name = "REE_VALOR_PAG_INTER")
    public BigDecimal getReeValorPagInter() {
        return reeValorPagInter;
    }
    
    public void setReeValorPagInter(BigDecimal reeValorPagInter) {
        this.reeValorPagInter = reeValorPagInter;
    }
}
