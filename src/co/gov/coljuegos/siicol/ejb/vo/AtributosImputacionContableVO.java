/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 24-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;


/**
 * Value Object para los Atributos de Imputaci&oacute;n Contable.
 * @author Camilo Miranda
 */
public class AtributosImputacionContableVO implements Cloneable
{
    private Long tipoDocTercero;
    private String tercero;
    private String tipoComprobante;
    private Integer numeroComprobante;
    private String centroCostos;
    private String referencia1;
    private String referencia2;
    private String descripcionOperacion;
    private Date fechaOperacion;
    private BigDecimal valor;
    private String tipoMovimiento;
    
    private FuenteFinancContabVO fuenteFinancContabVo;
    private AreaColjuegosVO areaColjuegosVo;
    private PersonaVO personaVo;
    private CuentasContablesVO cuentasContablesVo;
    
    
    
    /**
     * Constructor.
     */
    public AtributosImputacionContableVO() { }

    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public AtributosImputacionContableVO clone () 
    {
        AtributosImputacionContableVO atributosImputacionContableVo = new AtributosImputacionContableVO();
        
        atributosImputacionContableVo.tipoDocTercero = this.tipoDocTercero;
        atributosImputacionContableVo.tercero = this.tercero;
        atributosImputacionContableVo.tipoComprobante = this.tipoComprobante;
        atributosImputacionContableVo.numeroComprobante = this.numeroComprobante;
        atributosImputacionContableVo.centroCostos = this.centroCostos;
        atributosImputacionContableVo.referencia1 = this.referencia1;
        atributosImputacionContableVo.referencia2 = this.referencia2;
        atributosImputacionContableVo.descripcionOperacion = this.descripcionOperacion;
        atributosImputacionContableVo.fechaOperacion = this.fechaOperacion;
        atributosImputacionContableVo.valor = this.valor;
        atributosImputacionContableVo.tipoMovimiento = this.tipoMovimiento;
        
        if (this.fuenteFinancContabVo!=null)
            atributosImputacionContableVo.fuenteFinancContabVo = this.fuenteFinancContabVo.clone();
        
        if (this.areaColjuegosVo!=null)
            atributosImputacionContableVo.areaColjuegosVo = this.areaColjuegosVo.clone();
        
        atributosImputacionContableVo.personaVo = this.personaVo;
        
        if (this.cuentasContablesVo!=null)
            atributosImputacionContableVo.cuentasContablesVo = this.cuentasContablesVo.clone();
        
        
        return (atributosImputacionContableVo);
    }
    
    
    
    public void setTipoDocTercero(Long tipoDocTercero) {
        this.tipoDocTercero = tipoDocTercero;
    }

    public Long getTipoDocTercero() {
        return tipoDocTercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }

    public String getTercero() {
        return tercero;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setNumeroComprobante(Integer numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public Integer getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setCentroCostos(String centroCostos) {
        this.centroCostos = centroCostos;
    }

    public String getCentroCostos() {
        return centroCostos;
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

    public void setDescripcionOperacion(String descripcionOperacion) {
        this.descripcionOperacion = descripcionOperacion;
    }

    public String getDescripcionOperacion() {
        return descripcionOperacion;
    }

    public void setFuenteFinancContabVo(FuenteFinancContabVO fuenteFinancContabVo) {
        this.fuenteFinancContabVo = fuenteFinancContabVo;
    }

    public FuenteFinancContabVO getFuenteFinancContabVo() {
        return fuenteFinancContabVo;
    }

    public void setAreaColjuegosVo(AreaColjuegosVO areaColjuegosVo) {
        this.areaColjuegosVo = areaColjuegosVo;
    }

    public AreaColjuegosVO getAreaColjuegosVo() {
        return areaColjuegosVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setCuentasContablesVo(CuentasContablesVO cuentasContablesVo) {
        this.cuentasContablesVo = cuentasContablesVo;
    }

    public CuentasContablesVO getCuentasContablesVo() {
        return cuentasContablesVo;
    }
}
