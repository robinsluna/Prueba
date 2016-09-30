package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoMovimiento;

import java.math.BigDecimal;


/**
 * Value Object relacionada con la Imputaci&oacute;n Contable para reportes.
 * @author Camilo Miranda
 */
public class ImputacionResultVO {
    
    String cuenta;
    String nombreCuenta;
    String centroCosto;
    String fuenteFinanciacion;
    String ref1;
    String ref2;
    String naturaleza;
    BigDecimal valor;
    
    private String imcTipoMovim;
    private String ffcCodigo;
    private Long acoCodigo;
    private String descripcionOperacion;
    
    ///////////////////////
    // Datos del Tercero //
    ///////////////////////
    private PersonaVO personaVo;
    
    
    
    /**
     * Constructor.
     */
    public ImputacionResultVO() { }
    
    

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
    }

    public String getCentroCosto() {
        return centroCosto;
    }

    public void setFuenteFinanciacion(String fuenteFinanciacion) {
        this.fuenteFinanciacion = fuenteFinanciacion;
    }

    public String getFuenteFinanciacion() {
        return fuenteFinanciacion;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public String getRef2() {
        return ref2;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setImcTipoMovim(String imcTipoMovim) {
        this.imcTipoMovim = imcTipoMovim;
    }

    public String getImcTipoMovim() {
        return imcTipoMovim;
    }

    public void setFfcCodigo(String ffcCodigo) {
        this.ffcCodigo = ffcCodigo;
    }

    public String getFfcCodigo() {
        return ffcCodigo;
    }

    public void setAcoCodigo(Long acoCodigo) {
        this.acoCodigo = acoCodigo;
    }

    public Long getAcoCodigo() {
        return acoCodigo;
    }

    public void setDescripcionOperacion(String descripcionOperacion) {
        this.descripcionOperacion = descripcionOperacion;
    }

    public String getDescripcionOperacion() {
        return descripcionOperacion;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }
    
    

    /**
     * Obtiene el valor correspondiente a los D&eacute;bitos.
     * @return valor
     */
    public BigDecimal getDebito () {
        BigDecimal debito = new BigDecimal(0);
        if (EnumTipoMovimiento.DEBITO.getId().equals(imcTipoMovim))
            debito = valor;
        
        return (debito);
    }
    
    
    /**
     * Obtiene el valor correspondiente a los Cr&eacute;ditos.
     * @return valor
     */
    public BigDecimal getCredito () {
        BigDecimal credito = new BigDecimal(0);
        if (EnumTipoMovimiento.CREDITO.getId().equals(imcTipoMovim))
            credito = valor;
        
        return (credito);
    }
    
    
    /**
     * Obtiene el D&iacute;gito de Verificaci&oacute;n del tercero.
     * @return personaVo.perDigitoVerif
     */
    public Integer getDigitoVerif () {
        Integer digitoVerif = null;
        if (personaVo!=null)
            digitoVerif = personaVo.getPerDigitoVerif();
        
        return (digitoVerif);
    }
    
    /**
     * Obtiene la Raz&oacute;n Social del tercero.
     * @return personaVo.nombreCompleto
     */
    public String getRazonSocial () {
        String razonSocial = null;
        if (personaVo!=null)
            razonSocial = personaVo.getNombreCompleto();
        
        return (razonSocial);
    }
    
    /**
     * Obtiene el N&uacute;mero de Documento del tercero.
     * @return personaVo.perNumIdentificacion
     */
    public String getNumeroDocumento () {
        String numeroDocumento = null;
        if (personaVo!=null)
            numeroDocumento = personaVo.getPerNumIdentificacion();
        
        return (numeroDocumento);
    }
}
