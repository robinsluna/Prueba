package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsigRecaudoAaEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoEstablec;

import java.math.BigDecimal;

public class RecaudoEstablecVO {
    private Long reeCodigo;
    private BigDecimal reeValorPagado;
    private BigDecimal reeValorPropio;
    private BigDecimal reeValorTodos;
    private DetalleDeclaracionVO detalleDeclaracionVo;
    private LiquidacionEstablVO liquidacionEstablVo;
    private BigDecimal reeValorPagInter;
   
    
    public RecaudoEstablecVO(SiiRecaudoEstablec siiRecaudoEstablec) {
        this.reeCodigo = siiRecaudoEstablec.getReeCodigo();
        this.reeValorPagado = siiRecaudoEstablec.getReeValorPagado();
        this.reeValorPropio = siiRecaudoEstablec.getReeValorPropio();
        this.reeValorTodos = siiRecaudoEstablec.getReeValorTodos();
        this.reeValorPagInter = siiRecaudoEstablec.getReeValorPagInter();
        if(siiRecaudoEstablec.getSiiDetalleDeclaracion() != null){
            this.detalleDeclaracionVo = new DetalleDeclaracionVO(siiRecaudoEstablec.getSiiDetalleDeclaracion());
        }
        
    }
    public RecaudoEstablecVO() {        
    }


    public void setReeCodigo(Long reeCodigo) {
        this.reeCodigo = reeCodigo;
    }

    public Long getReeCodigo() {
        return reeCodigo;
    }

    public void setReeValorPagado(BigDecimal reeValorPagado) {
        this.reeValorPagado = reeValorPagado;
    }

    public BigDecimal getReeValorPagado() {
        return reeValorPagado;
    }

    public void setReeValorPropio(BigDecimal reeValorPropio) {
        this.reeValorPropio = reeValorPropio;
    }

    public BigDecimal getReeValorPropio() {
        return reeValorPropio;
    }

    public void setReeValorTodos(BigDecimal reeValorTodos) {
        this.reeValorTodos = reeValorTodos;
    }

    public BigDecimal getReeValorTodos() {
        return reeValorTodos;
    }

    public void setDetalleDeclaracionVo(DetalleDeclaracionVO detalleDeclaracionVo) {
        this.detalleDeclaracionVo = detalleDeclaracionVo;
    }

    public DetalleDeclaracionVO getDetalleDeclaracionVo() {
        return detalleDeclaracionVo;
    }

    public void setLiquidacionEstablVo(LiquidacionEstablVO liquidacionEstablVo) {
        this.liquidacionEstablVo = liquidacionEstablVo;
    }

    public LiquidacionEstablVO getLiquidacionEstablVo() {
        return liquidacionEstablVo;
    }

    public void setReeValorPagInter(BigDecimal reeValorPagInter) {
        this.reeValorPagInter = reeValorPagInter;
    }

    public BigDecimal getReeValorPagInter() {
        return reeValorPagInter;
    }

   
}
