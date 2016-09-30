/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 31-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumDestinoRecaudoSinClasificar;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoCartera;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoMovimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;


/**
 * Value Object para la relaci&oacute;n de la Cuenta Contable con su Tipo de Documento Contable.
 * @author Camilo Miranda
 */
public class CuentaContTipoDocContVO {
    
    private Long cctCodigo;
    private String cctConcepto;
    private String cctTipoCartera;
    private String cctTipoMovim;
    private String cctTipoRetNomina;
    private String cctDestRecSinC;
    private String cctIndicador1;
    private String cctActivo;
    
    private TipoDocContableVO tipoDocContableVo;
    private AreaColjuegosVO areaColjuegosVo;
    private PersonaVO personaVo;
    private CuentasContablesVO cuentasContablesVo;
    private FuenteFinancContabVO fuenteFinancContabVo;
    
    
    /**
     * Constructor.
     */
    public CuentaContTipoDocContVO() { }
    
    
    /**
     * Constructor.
     * @param siiCuentaContTipoDocCont
     */
    public CuentaContTipoDocContVO (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) 
    {
        if (siiCuentaContTipoDocCont!=null) {
            this.cctCodigo = siiCuentaContTipoDocCont.getCctCodigo();
            this.cctConcepto = siiCuentaContTipoDocCont.getCctConcepto();
            this.cctTipoCartera = siiCuentaContTipoDocCont.getCctTipoCartera();
            this.cctTipoMovim = siiCuentaContTipoDocCont.getCctTipoMovim();
            this.cctTipoRetNomina = siiCuentaContTipoDocCont.getCctTipoRetNomina();
            this.cctDestRecSinC = siiCuentaContTipoDocCont.getCctDestRecSinC();
            this.cctIndicador1 = siiCuentaContTipoDocCont.getCctIndicador1();
            this.cctActivo = siiCuentaContTipoDocCont.getCctActivo();
            
            
            if (siiCuentaContTipoDocCont.getSiiTipoDocContable()!=null)
                this.tipoDocContableVo = new TipoDocContableVO(siiCuentaContTipoDocCont.getSiiTipoDocContable());
            
            if (siiCuentaContTipoDocCont.getSiiAreaColjuegos()!=null)
                this.areaColjuegosVo = new AreaColjuegosVO(siiCuentaContTipoDocCont.getSiiAreaColjuegos());
            
            if (siiCuentaContTipoDocCont.getSiiPersona()!=null)
                this.personaVo = new PersonaVO(siiCuentaContTipoDocCont.getSiiPersona());
            
            if (siiCuentaContTipoDocCont.getSiiCuentasContables()!=null)
                this.cuentasContablesVo = new CuentasContablesVO(siiCuentaContTipoDocCont.getSiiCuentasContables());
            
            if (siiCuentaContTipoDocCont.getSiiFuenteFinancContab()!=null)
                this.fuenteFinancContabVo = new FuenteFinancContabVO(siiCuentaContTipoDocCont.getSiiFuenteFinancContab());
        }
    }


    public void setCctCodigo(Long cctCodigo) {
        this.cctCodigo = cctCodigo;
    }

    public Long getCctCodigo() {
        return cctCodigo;
    }

    public void setCctConcepto(String cctConcepto) {
        this.cctConcepto = cctConcepto;
    }

    public String getCctConcepto() {
        return cctConcepto;
    }

    public void setCctTipoCartera(String cctTipoCartera) {
        this.cctTipoCartera = cctTipoCartera;
    }

    public String getCctTipoCartera() {
        return cctTipoCartera;
    }

    public void setCctTipoMovim(String cctTipoMovim) {
        this.cctTipoMovim = cctTipoMovim;
    }

    public String getCctTipoMovim() {
        return cctTipoMovim;
    }

    public void setCctTipoRetNomina(String cctTipoRetNomina) {
        this.cctTipoRetNomina = cctTipoRetNomina;
    }

    public String getCctTipoRetNomina() {
        return cctTipoRetNomina;
    }

    public void setTipoDocContableVo(TipoDocContableVO tipoDocContableVo) {
        this.tipoDocContableVo = tipoDocContableVo;
    }

    public TipoDocContableVO getTipoDocContableVo() {
        return tipoDocContableVo;
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

    public void setCuentasContablesVo(CuentasContablesVO cuentasContablesVo) {
        this.cuentasContablesVo = cuentasContablesVo;
    }

    public CuentasContablesVO getCuentasContablesVo() {
        return cuentasContablesVo;
    }

    public void setFuenteFinancContabVo(FuenteFinancContabVO fuenteFinancContabVo) {
        this.fuenteFinancContabVo = fuenteFinancContabVo;
    }

    public FuenteFinancContabVO getFuenteFinancContabVo() {
        return fuenteFinancContabVo;
    }

    public void setCctDestRecSinC(String cctDestRecSinC) {
        this.cctDestRecSinC = cctDestRecSinC;
    }

    public String getCctDestRecSinC() {
        return cctDestRecSinC;
    }

    public void setCctIndicador1(String cctIndicador1) {
        this.cctIndicador1 = cctIndicador1;
    }

    public String getCctIndicador1() {
        return cctIndicador1;
    }

    public void setCctActivo(String cctActivo) {
        this.cctActivo = cctActivo;
    }

    public String getCctActivo() {
        return cctActivo;
    }
    
    
    
    
    ///////////////////////////
    // Getters para Reportes //
    ///////////////////////////
    /**
     * Obtiene el nombre del Tipo de Movimiento.
     * @return Nombre[cctTipoMovim]
     */
    public String getTipoMovimiento() 
    {
        String tipoMovimiento = null;
        
        if (this.cctTipoMovim!=null) {
            tipoMovimiento = EnumTipoMovimiento.getNombreById(this.cctTipoMovim);
        }
        
        return (tipoMovimiento);
    }
    
    
    /**
     * Obtiene el estado.
     * @return Estado[cctActivo]
     */
    public String getEstado() {
        String estado = null;
        
        if (this.cctActivo!=null) {
            if (EnumDecision.SI.getId().equals(cctActivo))
                estado = "ACTIVO";
            else if (EnumDecision.NO.getId().equals(cctActivo))
                estado = "INACTIVO";
        }
        
        return (estado);
    }
    
    
    /**
     * Obtiene el c&oacute;digo del Tipo de Documento Contable.
     * @return tipoDocContableVo.tdcCodigo
     */
    public String getTdcCodigo () {
        return ( tipoDocContableVo!=null ? tipoDocContableVo.getTdcCodigo(): null );
    }
    
    /**
     * Obtiene el nombre del Tipo de Documento Contable.
     * @return tipoDocContableVo.tdcNombre
     */
    public String getTdcNombre () {
        return ( tipoDocContableVo!=null ? tipoDocContableVo.getTdcNombre(): null );
    }
    
    /**
     * Obtiene el Tipo de Cartera.
     * @return nombre[cctTipoCartera]
     */
    public String getTipoCartera () {
        return ( cctTipoCartera!=null ? EnumTipoCartera.getNombreById(cctTipoCartera) : null );
    }
    
    /**
     * Obtiene el c&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return fuenteFinancContabVo.ffcCodigo
     */
    public String getFfcCodigo () {
        return ( fuenteFinancContabVo!=null ? fuenteFinancContabVo.getFfcCodigo() : null );
    }
    
    /**
     * Obtiene la abreviatura y el nombre del Centro de Costos.
     * @return areaColjuegosVo.acoAbreviatura - areaColjuegosVo.acoNombre
     */
    public String getCentroCostos () {
        return ( areaColjuegosVo!=null ? areaColjuegosVo.getAcoAbreviatura()+" - "+areaColjuegosVo.getAcoNombre() : null );
    }
    
    /**
     * Obtiene el nombre del Tercero.
     * @return personaVo.nombreCompleto
     */
    public String getNombreTercero () {
        return ( personaVo!=null ? personaVo.getNombreCompleto() : null );
    }
    
    /**
     * Obtiene el NIT del Tercero.
     * @return personaVo.perNumIdentificacion
     */
    public String getNitTercero () {
        return ( personaVo!=null ? personaVo.getPerNumIdentificacion() : null );
    }
    
    /**
     * Obtiene el n&uacute;mero de la Cuenta Contable.
     * @return cuentasContablesVo.numeroCuenta
     */
    public String getCuentaContable () {
        return ( cuentasContablesVo!=null ? cuentasContablesVo.getNumeroCuenta() : null );
    }
    
    /**
     * Obtiene el Destino del Recaudo Sin Clasificar.
     * @return nombre[cctDestRecSinC]
     */
    public String getDestRecaudoSinClasificar () {
        return ( cctDestRecSinC!=null ? EnumDestinoRecaudoSinClasificar.getNombreById(cctDestRecSinC) : null );
    }
}
