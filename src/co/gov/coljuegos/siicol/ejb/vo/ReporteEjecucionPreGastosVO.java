/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Walter Becerra
 * FECHA	: 18-02-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class ReporteEjecucionPreGastosVO {
    private String rubro;
    private String rec;
    private String concepto;
    private BigDecimal preAprobado;
    private BigDecimal prePorEjecutar;
    private BigDecimal cerExpedidos;
    private BigDecimal cerPorEjecutar;
    private BigDecimal regExpedidos;
    private BigDecimal regPorEjecutar;
    private BigDecimal obliExpedidos;
    private BigDecimal obliPorEjecutar;
    private BigDecimal totalPago;
    private String fechaCorte;
    private String cadenaNiveles;
    private List<ReporteEjecucionPreGastosVO> listaNodosHijo;
    private Integer dtlleFuente;


    public ReporteEjecucionPreGastosVO() {
    }


    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getRec() {
        return rec;
    }


    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setPreAprobado(BigDecimal preAprobado) {
        this.preAprobado = preAprobado;
    }

    public BigDecimal getPreAprobado() {
        return preAprobado;
    }

    public void setPrePorEjecutar(BigDecimal prePorEjecutar) {
        this.prePorEjecutar = prePorEjecutar;
    }

    public BigDecimal getPrePorEjecutar() {
        return prePorEjecutar;
    }

    public void setCerExpedidos(BigDecimal cerExpedidos) {
        this.cerExpedidos = cerExpedidos;
    }

    public BigDecimal getCerExpedidos() {
        return cerExpedidos;
    }

    public void setCerPorEjecutar(BigDecimal cerPorEjecutar) {
        this.cerPorEjecutar = cerPorEjecutar;
    }

    public BigDecimal getCerPorEjecutar() {
        return cerPorEjecutar;
    }

    public void setRegExpedidos(BigDecimal regExpedidos) {
        this.regExpedidos = regExpedidos;
    }

    public BigDecimal getRegExpedidos() {
        return regExpedidos;
    }

    public void setRegPorEjecutar(BigDecimal regPorEjecutar) {
        this.regPorEjecutar = regPorEjecutar;
    }

    public BigDecimal getRegPorEjecutar() {
        return regPorEjecutar;
    }

    public void setObliExpedidos(BigDecimal obliExpedidos) {
        this.obliExpedidos = obliExpedidos;
    }

    public BigDecimal getObliExpedidos() {
        return obliExpedidos;
    }

    public void setObliPorEjecutar(BigDecimal obliPorEjecutar) {
        this.obliPorEjecutar = obliPorEjecutar;
    }

    public BigDecimal getObliPorEjecutar() {
        return obliPorEjecutar;
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }

    public BigDecimal getTotalPago() {
        return totalPago;
    }


    public void setFechaCorte(String fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public String getFechaCorte() {
        return fechaCorte;
    }

    public void setCadenaNiveles(String cadenaNiveles) {
        this.cadenaNiveles = cadenaNiveles;
    }

    public String getCadenaNiveles() {
        return cadenaNiveles;
    }

    public void setListaNodosHijo(List<ReporteEjecucionPreGastosVO> listaNodosHijo) {
        this.listaNodosHijo = listaNodosHijo;
    }

    public List<ReporteEjecucionPreGastosVO> getListaNodosHijo() {
        return listaNodosHijo;
    }

    public void setDtlleFuente(Integer dtlleFuente) {
        this.dtlleFuente = dtlleFuente;
    }

    public Integer getDtlleFuente() {
        return dtlleFuente;
    }
}
