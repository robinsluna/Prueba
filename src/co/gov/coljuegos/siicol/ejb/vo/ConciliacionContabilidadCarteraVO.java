package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;


/**
 * Value Object para las Conciliaciones de Contabilidad y Cartera.
 * @author Camilo Miranda
 */
public class ConciliacionContabilidadCarteraVO implements Cloneable
{
    /** NIT del Operador */
    private String nit;
    /** Raz&oacute;n Social del Operador */
    private String razonSocial;
    /** C&oacute;digo del Concepto Cuota */
    private Long ccuCodigo;
    /** Nombre del Concepto Cuota */
    private String ccuNombre;
    /** Saldo de Cartera */
    private BigDecimal saldoCartera;
    /** Saldo de Contabilidad */
    private BigDecimal saldoContabilidad;
    
    /** C&oacute;digo de la Cuenta Contable */
    private Long ccoCodigo;
    /** Descripci&oacute;n de la Cuenta Contable */
    private String ccoDescripcion;
    /** N&uacute;mero de la Cuenta Contable */
    private String numeroCuentaContable;
    /** C&oacute;digo del Contrato */
    private Long conCodigo;
    /** N&uacute;mero del Contrato */
    private String conNumero;
    /** Descripci&oacute;n del Contrato */
    private String conDescripcion;
    
    /** Operador */
    private OperadorVO operadorVo;
    
    /** Flag que determina si los saldos de la conciliaci&oacute;n pertenecen a cuentas de Intereses. */
    private boolean saldoParaIntereses;
    
    
    
    /**
     * Constructor.
     */
    public ConciliacionContabilidadCarteraVO() { }

    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) 
    {
        boolean igual = false;
        
        if (o instanceof ConciliacionContabilidadCarteraVO) {
            ConciliacionContabilidadCarteraVO cccVo = (ConciliacionContabilidadCarteraVO) o;
            
            if (cccVo!=null) {
                // los saldos no seran considerados para determinar si los dos objetos son iguales, ya que estos deben totalizarse.
                igual = ((cccVo.nit != null && cccVo.nit.equals(this.nit)) || (cccVo.nit == null && this.nit == null)) &&
                        ((cccVo.razonSocial != null && cccVo.razonSocial.equals(this.razonSocial)) || (cccVo.razonSocial == null && this.razonSocial == null)) &&
                        ((cccVo.ccuCodigo != null && cccVo.ccuCodigo.equals(this.ccuCodigo)) || (cccVo.ccuCodigo == null && this.ccuCodigo == null)) &&
                        ((cccVo.ccuNombre != null && cccVo.ccuNombre.equals(this.ccuNombre)) || (cccVo.ccuNombre == null && this.ccuNombre == null)) &&
                        ((cccVo.ccoCodigo != null && cccVo.ccoCodigo.equals(this.ccoCodigo)) || (cccVo.ccoCodigo == null && this.ccoCodigo == null)) &&
                        ((cccVo.ccoDescripcion != null && cccVo.ccoDescripcion.equals(this.ccoDescripcion)) || (cccVo.ccoDescripcion == null && this.ccoDescripcion == null)) &&
                        ((cccVo.numeroCuentaContable != null && cccVo.numeroCuentaContable.equals(this.numeroCuentaContable)) || (cccVo.numeroCuentaContable == null && this.numeroCuentaContable == null)) &&
                        ((cccVo.conCodigo != null && cccVo.conCodigo.equals(this.conCodigo)) || (cccVo.conCodigo == null && this.conCodigo == null)) &&
                        ((cccVo.conNumero != null && cccVo.conNumero.equals(this.conNumero)) || (cccVo.conNumero == null && this.conNumero == null)) &&
                        ((cccVo.conDescripcion != null && cccVo.conDescripcion.equals(this.conDescripcion)) || (cccVo.conDescripcion == null && this.conDescripcion == null)) &&
                        ((cccVo.operadorVo != null && cccVo.operadorVo.equals(this.operadorVo)) || (cccVo.operadorVo == null && this.operadorVo == null)) && 
                        ((cccVo.saldoParaIntereses == this.saldoParaIntereses));
            }
        }
        
        return (igual);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () 
    {
        String resultado = "";
        if (numeroCuentaContable!=null) resultado += "CuentaContable="+numeroCuentaContable+" ";
        if (nit!=null) resultado += "NIT="+nit+" ";
        if (ccuCodigo!=null) resultado += "ConceptoCuota="+ccuCodigo+" ";
        if (operadorVo!=null) resultado += "Operador="+operadorVo.toString();
        
        return (resultado.trim());
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode () 
    {
        return ( this.toString().hashCode() );
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public ConciliacionContabilidadCarteraVO clone () throws CloneNotSupportedException
    {
        ConciliacionContabilidadCarteraVO cccVo = new ConciliacionContabilidadCarteraVO();
        
        cccVo.setNit(nit);
        cccVo.setRazonSocial(razonSocial);
        cccVo.setCcuCodigo(ccuCodigo);
        cccVo.setCcuNombre(ccuNombre);
        
        if (saldoCartera!=null)
            cccVo.setSaldoCartera(saldoCartera);
        
        if (saldoContabilidad!=null)
            cccVo.setSaldoContabilidad(saldoContabilidad);
        
        cccVo.setCcoCodigo(ccoCodigo);
        cccVo.setCcoDescripcion(ccoDescripcion);
        cccVo.setNumeroCuentaContable(numeroCuentaContable);
        cccVo.setConCodigo(conCodigo);
        cccVo.setConNumero(conNumero);
        cccVo.setConDescripcion(conDescripcion);
        cccVo.setSaldoParaIntereses(saldoParaIntereses);
        
        
        return (cccVo);
    }
    
    
    
    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setCcuCodigo(Long ccuCodigo) {
        this.ccuCodigo = ccuCodigo;
    }

    public Long getCcuCodigo() {
        return ccuCodigo;
    }

    public void setCcuNombre(String ccuNombre) {
        this.ccuNombre = ccuNombre;
    }

    public String getCcuNombre() {
        return ccuNombre;
    }

    public void setSaldoCartera(BigDecimal saldoCartera) {
        this.saldoCartera = saldoCartera;
    }

    public BigDecimal getSaldoCartera() {
        return saldoCartera;
    }

    public void setSaldoContabilidad(BigDecimal saldoContabilidad) {
        this.saldoContabilidad = saldoContabilidad;
    }

    public BigDecimal getSaldoContabilidad() {
        return saldoContabilidad;
    }

    public void setOperadorVo(OperadorVO operadorVo) {
        this.operadorVo = operadorVo;
    }

    public void setCcoCodigo(Long ccoCodigo) {
        this.ccoCodigo = ccoCodigo;
    }

    public Long getCcoCodigo() {
        return ccoCodigo;
    }

    public void setCcoDescripcion(String ccoDescripcion) {
        this.ccoDescripcion = ccoDescripcion;
    }

    public String getCcoDescripcion() {
        return ccoDescripcion;
    }

    public void setNumeroCuentaContable(String numeroCuentaContable) {
        this.numeroCuentaContable = numeroCuentaContable;
    }

    public String getNumeroCuentaContable() {
        return numeroCuentaContable;
    }

    public OperadorVO getOperadorVo() {
        return operadorVo;
    }

    public void setConCodigo(Long conCodigo) {
        this.conCodigo = conCodigo;
    }

    public Long getConCodigo() {
        return conCodigo;
    }

    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
    }

    public String getConDescripcion() {
        return conDescripcion;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setSaldoParaIntereses(boolean saldoParaIntereses) {
        this.saldoParaIntereses = saldoParaIntereses;
    }

    public boolean isSaldoParaIntereses() {
        return saldoParaIntereses;
    }
}
