package co.gov.coljuegos.siicol.ejb.vo;


import java.util.Date;
import java.util.List;

public class FiltrosReporteRelacionOperacionesVO {
    
    private Long dcoCodigo;
    /** Fecha Inicial (dcoFechaOper). */
    private Date fechaInicial;
    /** Fecha Final (dcoFechaOper). */
    private Date fechaFinal;
    /** C&oacute;digo de la Fuente de Financiaci&oacute;n Contable (ffcCodigo). */
    private String ffcCodigo;
   
    
    ///////////////////////////////////////////////////////
    // Booleanos para determinar si se ha filtrado o no. //
    ///////////////////////////////////////////////////////
    private boolean filtrarPorTercero;
    private boolean filtrarPorFuenteFinanciacion;
    
    
    public FiltrosReporteRelacionOperacionesVO() {
        super();
    }

    public void setDcoCodigo(Long dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }

    public Long getDcoCodigo() {
        return dcoCodigo;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFfcCodigo(String ffcCodigo) {
        this.ffcCodigo = ffcCodigo;
    }

    public String getFfcCodigo() {
        return ffcCodigo;
    }

    public void setFiltrarPorTercero(boolean filtrarPorTercero) {
        this.filtrarPorTercero = filtrarPorTercero;
    }

    public boolean isFiltrarPorTercero() {
        return filtrarPorTercero;
    }

    public void setFiltrarPorFuenteFinanciacion(boolean filtrarPorFuenteFinanciacion) {
        this.filtrarPorFuenteFinanciacion = filtrarPorFuenteFinanciacion;
    }

    public boolean isFiltrarPorFuenteFinanciacion() {
        return filtrarPorFuenteFinanciacion;
    }
}
