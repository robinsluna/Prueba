package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;

public class EstadoCuentaVO {

    private String contrato;
    private BigDecimal cuota;
    
    private BigDecimal anio;
    private BigDecimal mes;
    private Date fecha_vencimiento;
    private Date fecha_pago;
    private BigDecimal monto_obligacion;
    private BigDecimal monto_pago;
    private BigDecimal saldo;
    private BigDecimal recaudoPorCalsificar;
    private BigDecimal total_interes;
    private BigDecimal total_pagado;
    private BigDecimal pagado_interes;
    private BigDecimal saldo_interes;
    private BigDecimal dias_mora;
    private String descripcionConcepto;
    private BigDecimal codigoConcepto;
    private Date fecha_finContrato;
    private Date fecha_inicioContraro;
    private String razonSocial;
    private String nit;
    private String resolucion;
    private String resolucionModificatoria;
    private BigDecimal valCalcInteres;
    private BigDecimal totalPagadoInteres;
    private BigDecimal totalTodosInteres;
    private BigDecimal totalTodosSaldoInteres;
    private BigDecimal recaudoInteresPorClasificar;
    private BigDecimal valorClasificado;
    private Integer numeroAcuerdoPago;
    private String NumComiteApr;
    private Date fechaAprComite;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaFirmaRes;
    private Date fechaResolucion;
    private String abreviaturaConcepto;
    private Long copCodigo;
    private String referenciaPago;
    private String destinoCuota;
    private String cancelada;
    /*private PagoOperadoresVO pagoOperadoresVo;
    private PagoOperadoresPseVO pagoOperadoresPseVo;*/

    /*
     * Variable para el manejo del reporte de estado GTC
     */
    private boolean ingresado;


    public EstadoCuentaVO() {

    }


    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getContrato() {
        return contrato;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setAnio(BigDecimal anio) {
        this.anio = anio;
    }

    public BigDecimal getAnio() {
        return anio;
    }

    public void setMes(BigDecimal mes) {
        this.mes = mes;
    }

    public BigDecimal getMes() {
        return mes;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setMonto_obligacion(BigDecimal monto_obligacion) {
        this.monto_obligacion = monto_obligacion;
    }

    public BigDecimal getMonto_obligacion() {
        return monto_obligacion;
    }

    public void setMonto_pago(BigDecimal monto_pago) {
        this.monto_pago = monto_pago;
    }

    public BigDecimal getMonto_pago() {
        return monto_pago;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setTotal_interes(BigDecimal total_interes) {
        this.total_interes = total_interes;
    }

    public BigDecimal getTotal_interes() {
        return total_interes;
    }

    public void setDias_mora(BigDecimal dias_mora) {
        this.dias_mora = dias_mora;
    }

    public BigDecimal getDias_mora() {
        return dias_mora;
    }

    public void setDescripcionConcepto(String descripcionConcepto) {
        this.descripcionConcepto = descripcionConcepto;
    }

    public String getDescripcionConcepto() {
        return descripcionConcepto;
    }


    public void setPagado_interes(BigDecimal pagado_interes) {
        this.pagado_interes = pagado_interes;
    }

    public BigDecimal getPagado_interes() {
        return pagado_interes;
    }

    public void setSaldo_interes(BigDecimal saldo_interes) {
        this.saldo_interes = saldo_interes;
    }

    public BigDecimal getSaldo_interes() {
        return saldo_interes;
    }


    public void setCodigoConcepto(BigDecimal codigoConcepto) {
        this.codigoConcepto = codigoConcepto;
    }

    public BigDecimal getCodigoConcepto() {
        return codigoConcepto;
    }


    public void setFecha_finContrato(Date fecha_finContrato) {
        this.fecha_finContrato = fecha_finContrato;
    }

    public Date getFecha_finContrato() {
        return fecha_finContrato;
    }

    public void setFecha_inicioContraro(Date fecha_inicioContraro) {
        this.fecha_inicioContraro = fecha_inicioContraro;
    }

    public Date getFecha_inicioContraro() {
        return fecha_inicioContraro;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setValCalcInteres(BigDecimal valCalcInteres) {
        this.valCalcInteres = valCalcInteres;
    }

    public BigDecimal getValCalcInteres() {
        return valCalcInteres;
    }


    public void setTotal_pagado(BigDecimal total_pagado) {
        this.total_pagado = total_pagado;
    }

    public BigDecimal getTotal_pagado() {
        return total_pagado;
    }

    public void setTotalPagadoInteres(BigDecimal totalPagadoInteres) {
        this.totalPagadoInteres = totalPagadoInteres;
    }

    public BigDecimal getTotalPagadoInteres() {
        return totalPagadoInteres;
    }


    public void setTotalTodosInteres(BigDecimal totalTodosInteres) {
        this.totalTodosInteres = totalTodosInteres;
    }

    public BigDecimal getTotalTodosInteres() {
        return totalTodosInteres;
    }

    public void setTotalTodosSaldoInteres(BigDecimal totalTodosSaldoInteres) {
        this.totalTodosSaldoInteres = totalTodosSaldoInteres;
    }

    public BigDecimal getTotalTodosSaldoInteres() {
        return totalTodosSaldoInteres;
    }

    public void setRecaudoPorCalsificar(BigDecimal recaudoPorCalsificar) {
        this.recaudoPorCalsificar = recaudoPorCalsificar;
    }

    public BigDecimal getRecaudoPorCalsificar() {
        return recaudoPorCalsificar;
    }

    public void setRecaudoInteresPorClasificar(BigDecimal recaudoInteresPorClasificar) {
        this.recaudoInteresPorClasificar = recaudoInteresPorClasificar;
    }

    public BigDecimal getRecaudoInteresPorClasificar() {
        return recaudoInteresPorClasificar;
    }

    public void setValorClasificado(BigDecimal valorClasificado) {
        this.valorClasificado = valorClasificado;
    }

    public BigDecimal getValorClasificado() {
        return valorClasificado;
    }

    public boolean isIngresado() {
        return ingresado;
    }

    public void setIngresado(boolean ingresado) {
        this.ingresado = ingresado;
    }

    public void setNumeroAcuerdoPago(Integer numeroAcuerdoPago) {
        this.numeroAcuerdoPago = numeroAcuerdoPago;
    }

    public Integer getNumeroAcuerdoPago() {
        return numeroAcuerdoPago;
    }

    public void setResolucionModificatoria(String resolucionModificatoria) {
        this.resolucionModificatoria = resolucionModificatoria;
    }

    public String getResolucionModificatoria() {
        return resolucionModificatoria;
    }


    public void setNumComiteApr(String NumComiteApr) {
        this.NumComiteApr = NumComiteApr;
    }

    public String getNumComiteApr() {
        return NumComiteApr;
    }

    public void setFechaAprComite(Date fechaAprComite) {
        this.fechaAprComite = fechaAprComite;
    }

    public Date getFechaAprComite() {
        return fechaAprComite;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFirmaRes(Date fechaFirmaRes) {
        this.fechaFirmaRes = fechaFirmaRes;
    }

    public Date getFechaFirmaRes() {
        return fechaFirmaRes;
    }

    public void setAbreviaturaConcepto(String abreviaturaConcepto) {
        this.abreviaturaConcepto = abreviaturaConcepto;
    }

    public String getAbreviaturaConcepto() {
        return abreviaturaConcepto;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }


    public Long getCopCodigo() {
        return copCodigo;
    }

    public void setCopCodigo(Long copCodigo) {
        this.copCodigo = copCodigo;
    }

    public void setReferenciaPago(String referenciaPago) {
        this.referenciaPago = referenciaPago;
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }


    public void setDestinoCuota(String destinoCuota) {
        this.destinoCuota = destinoCuota;
    }

    public String getDestinoCuota() {
        return destinoCuota;
    }

    public void setCancelada(String cancelada) {
        this.cancelada = cancelada;
    }

    public String getCancelada() {
        return cancelada;
    }
}
