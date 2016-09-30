package co.gov.coljuegos.siicol.ejb.wsvo;

import java.math.BigDecimal;


/**
 *Objeto usado para transportar la informacion por el web services de los elementos del inventario su tipo de apuesta
 * y la cantidad de dicho elemento encontrado en el inventario
 * @author David Tafur
 */
public class ElementoAsociadoWSVO {

    public long tipoApuesta;
    public long cantidadElemento;
    //Aplica para mets
    public long conectadas;
    public long noConectadas;
    //Este lo uso para guardar los ingresos brutos menos los premios pagados
    public BigDecimal ingresos;
    //ACDVC
    public BigDecimal ventas;
    public BigDecimal premiosPagados;
    public double IVA;
    public Integer tarifaAplicablePorcentaje;
    //
    public BigDecimal ventasMet;
    public BigDecimal valorDerechosExp;
    public String nombreApuesta;
    public ElementoAsociadoWSVO() {
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
}
