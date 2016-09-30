/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 03-03-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object que contiene la informaci&oacute;n de los Filtros requeridos para una consulta de Balance de Prueba.
 * @author Camilo Miranda
 */
public class FiltrosBalancePruebaVO implements Cloneable {
    
    /** Fecha Inicial (dcoFechaOper). */
    private Date fechaInicial;
    /** Fecha Final (dcoFechaOper). */
    private Date fechaFinal;
    /** C&oacute;digo de la Fuente de Financiaci&oacute;n Contable (ffcCodigo). */
    private String ffcCodigo;
    /** Listado de C&oacute;digos asociados a las Cuentas Contables (ccoCodigo). */
    private List<Long> codigosCuentaContable;
    /** N&uacute;mero de la Cuenta Contable Inicial. */
    private String numCuentaContableInicial;
    /** N&uacute;mero de la Cuenta Contable Final. */
    private String numCuentaContableFinal;
    /** C&oacute;digos del Tercero (perCodigo). */
    private List<Long> codigosTercero;
    /** C&oacute;digos del Centro de Costos (acoCodigo). */
    private List<Long> codigosCentroCostos;
    /** Referencia 1 */
    private String referencia1;
    /** Referencia 2 */
    private String referencia2;
    
    
    
    ///////////////////////////////////////////////////////
    // Booleanos para determinar si se ha filtrado o no. //
    ///////////////////////////////////////////////////////
    private boolean filtrarPorTercero;
    private boolean filtrarPorCentroCostos;
    private boolean filtrarPorFuenteFinanciacion;
    private boolean incluyeMovPeriodoCierre;
    
    
    
    
    /**
     * Constructor.
     */
    public FiltrosBalancePruebaVO() { }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone
     */
    @Override
    public FiltrosBalancePruebaVO clone () 
    {
        FiltrosBalancePruebaVO resultado = new FiltrosBalancePruebaVO();
        resultado.fechaInicial = this.fechaInicial;
        resultado.fechaFinal = this.fechaFinal;
        resultado.ffcCodigo = this.ffcCodigo;
        
        if (this.codigosCuentaContable!=null)
            resultado.codigosCuentaContable = new ArrayList<Long>(this.codigosCuentaContable);
        
        resultado.numCuentaContableInicial = this.numCuentaContableInicial;
        resultado.numCuentaContableFinal = this.numCuentaContableFinal;
        
        if (this.codigosTercero!=null)
            resultado.codigosTercero = new ArrayList<Long>(this.codigosTercero);
        
        if (this.codigosCentroCostos!=null)
            resultado.codigosCentroCostos = new ArrayList<Long>(this.codigosCentroCostos);
        
        resultado.referencia1 = this.referencia1;
        resultado.referencia2 = this.referencia2;
        
        resultado.filtrarPorTercero = this.filtrarPorTercero;
        resultado.filtrarPorCentroCostos = this.filtrarPorCentroCostos;
        resultado.filtrarPorFuenteFinanciacion = this.filtrarPorFuenteFinanciacion;
        resultado.incluyeMovPeriodoCierre = this.incluyeMovPeriodoCierre;
        
        
        return (resultado);
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

    public void setCodigosCuentaContable(List<Long> codigosCuentaContable) {
        this.codigosCuentaContable = codigosCuentaContable;
    }

    public List<Long> getCodigosCuentaContable() {
        return codigosCuentaContable;
    }

    public void setCodigosTercero(List<Long> codigosTercero) {
        this.codigosTercero = codigosTercero;
    }

    public List<Long> getCodigosTercero() {
        return codigosTercero;
    }

    public void setCodigosCentroCostos(List<Long> codigosCentroCostos) {
        this.codigosCentroCostos = codigosCentroCostos;
    }

    public List<Long> getCodigosCentroCostos() {
        return codigosCentroCostos;
    }

    public void setFiltrarPorTercero(boolean filtrarPorTercero) {
        this.filtrarPorTercero = filtrarPorTercero;
    }

    public boolean isFiltrarPorTercero() {
        return filtrarPorTercero;
    }

    public void setFiltrarPorCentroCostos(boolean filtrarPorCentroCostos) {
        this.filtrarPorCentroCostos = filtrarPorCentroCostos;
    }

    public boolean isFiltrarPorCentroCostos() {
        return filtrarPorCentroCostos;
    }

    public void setFiltrarPorFuenteFinanciacion(boolean filtrarPorFuenteFinanciacion) {
        this.filtrarPorFuenteFinanciacion = filtrarPorFuenteFinanciacion;
    }

    public boolean isFiltrarPorFuenteFinanciacion() {
        return filtrarPorFuenteFinanciacion;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setIncluyeMovPeriodoCierre(boolean incluyeMovPeriodoCierre) {
        this.incluyeMovPeriodoCierre = incluyeMovPeriodoCierre;
    }

    public boolean isIncluyeMovPeriodoCierre() {
        return incluyeMovPeriodoCierre;
    }

    public void setNumCuentaContableInicial(String numCuentaContableInicial) {
        this.numCuentaContableInicial = numCuentaContableInicial;
    }

    public String getNumCuentaContableInicial() {
        return numCuentaContableInicial;
    }

    public void setNumCuentaContableFinal(String numCuentaContableFinal) {
        this.numCuentaContableFinal = numCuentaContableFinal;
    }

    public String getNumCuentaContableFinal() {
        return numCuentaContableFinal;
    }
}
