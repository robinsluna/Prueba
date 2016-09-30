package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class ElementoAsociadoVO {
    
    private long tipoApuesta;
    private long cantidadElemento;
    private long conectadas;
    private long noConectadas;
    private BigDecimal ingresos;
    private BigDecimal ventas;
    private BigDecimal premiosPagados;
    private double IVA;
    private Integer tarifaAplicablePorcentaje;
    private BigDecimal ventasMet;
    private BigDecimal valorDerechosExp;
    private BigDecimal valorGastosAdm;
    private String nombreApuesta;
    
    public ElementoAsociadoVO() {
        super();
    }


    public void setTipoApuesta(long tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public long getTipoApuesta() {
        return tipoApuesta;
    }

    public void setCantidadElemento(long cantidadElemento) {
        this.cantidadElemento = cantidadElemento;
    }

    public long getCantidadElemento() {
        return cantidadElemento;
    }

    public void setConectadas(long conectadas) {
        this.conectadas = conectadas;
    }

    public long getConectadas() {
        return conectadas;
    }

    public void setNoConectadas(long noConectadas) {
        this.noConectadas = noConectadas;
    }

    public long getNoConectadas() {
        return noConectadas;
    }

    public void setIngresos(BigDecimal ingresos) {
        this.ingresos = ingresos;
    }

    public BigDecimal getIngresos() {
        return ingresos;
    }

    public void setVentas(BigDecimal ventas) {
        this.ventas = ventas;
    }

    public BigDecimal getVentas() {
        return ventas;
    }

    public void setPremiosPagados(BigDecimal premiosPagados) {
        this.premiosPagados = premiosPagados;
    }

    public BigDecimal getPremiosPagados() {
        return premiosPagados;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getIVA() {
        return IVA;
    }

    public void setTarifaAplicablePorcentaje(Integer tarifaAplicablePorcentaje) {
        this.tarifaAplicablePorcentaje = tarifaAplicablePorcentaje;
    }

    public Integer getTarifaAplicablePorcentaje() {
        return tarifaAplicablePorcentaje;
    }

    public void setVentasMet(BigDecimal ventasMet) {
        this.ventasMet = ventasMet;
    }

    public BigDecimal getVentasMet() {
        return ventasMet;
    }

    public void setValorDerechosExp(BigDecimal valorDerechosExp) {
        this.valorDerechosExp = valorDerechosExp;
    }

    public BigDecimal getValorDerechosExp() {
        return valorDerechosExp;
    }

    public void setNombreApuesta(String nombreApuesta) {
        this.nombreApuesta = nombreApuesta;
    }

    public String getNombreApuesta() {
        return nombreApuesta;
    }

    public void setValorGastosAdm(BigDecimal valorGastosAdm) {
        this.valorGastosAdm = valorGastosAdm;
    }

    public BigDecimal getValorGastosAdm() {
        return valorGastosAdm;
    }
}
