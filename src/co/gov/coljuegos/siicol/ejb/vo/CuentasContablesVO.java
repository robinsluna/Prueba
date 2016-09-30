package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoCuentaContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;

import java.util.List;


public class CuentasContablesVO  implements Cloneable 
{
    /** Cantidad m&aacute;xima de niveles que puede contener una cuenta contable. */
    public final static Integer MAX_CANTIDAD_NIVELES_CCO = 5;
    
    
    private String ccoAcumTerc;
    private String ccoCentroCost;
    private Long ccoCodigo;
    private String ccoConcInfExog;
    private String ccoCtaBalance;
    private String ccoCtaImpuestos;
    private String ccoCtaResult;
    private String ccoDescripcion;
    private String ccoFteFinanc;
    private String ccoNaturaleza;
    private String ccoNivel1;
    private String ccoNivel2;
    private String ccoNivel3;
    private String ccoNivel4;
    private String ccoNivel5;
    private String ccoNumDocConta;
    private String ccoObligaTerc;
    private String ccoReferencia1;
    private String ccoReferencia2;
    private String ccoTipoCuenta;
    private String ccoTipDocConta;
    private String ccoPermiteObl;
    private String ccoCtaAcreedora;
    
    private EstadoCuentaContableVO estadoCuentaContableVo;
    /** Persona que realiza la Cancelaci&oacute;n del saldo. */
    private PersonaVO personaVo;
    
    private List<ConceptoGastoVO> conceptoGastoDebList;
    private List<ConceptoGastoVO> conceptoGastoCredList;
    private List<TipoRetencionVO> tipoRetencionList;
    private List<ImputacionContableVO> imputacionContableList;
    private List<ActividadIcaVO> actividadIcaList;
    private List<CuentaContTipoDocContVO> cuentaContTipoDocContListVo;
    
    
    /**
     * Constructor.
     */
    public CuentasContablesVO() { }
    
    
    /**
     * Constructor.
     * @param siiCuentasContables
     */
    public CuentasContablesVO( SiiCuentasContables siiCuentasContables) {
        if (siiCuentasContables!=null) {
            this.ccoAcumTerc = siiCuentasContables.getCcoAcumTerc();
            this.ccoCentroCost = siiCuentasContables.getCcoCentroCost();
            this.ccoCodigo = siiCuentasContables.getCcoCodigo();
            this.ccoConcInfExog = siiCuentasContables.getCcoConcInfExog();
            this.ccoCtaBalance = siiCuentasContables.getCcoCtaBalance();
            this.ccoCtaImpuestos = siiCuentasContables.getCcoCtaImpuestos();
            this.ccoCtaResult = siiCuentasContables.getCcoCtaResult();
            this.ccoDescripcion = siiCuentasContables.getCcoDescripcion();
            this.ccoFteFinanc = siiCuentasContables.getCcoFteFinanc();
            this.ccoNaturaleza = siiCuentasContables.getCcoNaturaleza();
            this.ccoNivel1 = siiCuentasContables.getCcoNivel1();
            this.ccoNivel2 = siiCuentasContables.getCcoNivel2();
            this.ccoNivel3 = siiCuentasContables.getCcoNivel3();
            this.ccoNivel4 = siiCuentasContables.getCcoNivel4();
            this.ccoNivel5 = siiCuentasContables.getCcoNivel5();
            this.ccoNumDocConta = siiCuentasContables.getCcoNumDocConta();
            this.ccoObligaTerc = siiCuentasContables.getCcoObligaTerc();
            this.ccoReferencia1 = siiCuentasContables.getCcoReferencia1();
            this.ccoReferencia2 = siiCuentasContables.getCcoReferencia2();
            this.ccoTipoCuenta = siiCuentasContables.getCcoTipoCuenta();
            this.ccoTipDocConta = siiCuentasContables.getCcoTipDocConta();
            this.ccoPermiteObl = siiCuentasContables.getCcoPermiteObl();
            this.ccoCtaAcreedora = siiCuentasContables.getCcoCtaAcreedora();
            
            if (siiCuentasContables.getSiiEstadoCuentaContable() != null ){
                this.estadoCuentaContableVo = new EstadoCuentaContableVO (siiCuentasContables.getSiiEstadoCuentaContable());
            }
            
            if (siiCuentasContables.getSiiPersonaCancSaldo() != null){
                this.personaVo = new PersonaVO (siiCuentasContables.getSiiPersonaCancSaldo());
            }
        }
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public CuentasContablesVO clone() 
    {
        CuentasContablesVO cuentasContablesVo = new CuentasContablesVO();
        cuentasContablesVo.ccoAcumTerc = this.ccoAcumTerc;
        cuentasContablesVo.ccoCentroCost = this.ccoCentroCost;
        cuentasContablesVo.ccoCodigo = this.ccoCodigo;
        cuentasContablesVo.ccoConcInfExog = this.ccoConcInfExog;
        cuentasContablesVo.ccoCtaBalance = this.ccoCtaBalance;
        cuentasContablesVo.ccoCtaImpuestos = this.ccoCtaImpuestos;
        cuentasContablesVo.ccoCtaResult = this.ccoCtaResult;
        cuentasContablesVo.ccoDescripcion = this.ccoDescripcion;
        cuentasContablesVo.ccoFteFinanc = this.ccoFteFinanc;
        cuentasContablesVo.ccoNaturaleza = this.ccoNaturaleza;
        cuentasContablesVo.ccoNivel1 = this.ccoNivel1;
        cuentasContablesVo.ccoNivel2 = this.ccoNivel2;
        cuentasContablesVo.ccoNivel3 = this.ccoNivel3;
        cuentasContablesVo.ccoNivel4 = this.ccoNivel4;
        cuentasContablesVo.ccoNivel5 = this.ccoNivel5;
        cuentasContablesVo.ccoNumDocConta = this.ccoNumDocConta;
        cuentasContablesVo.ccoObligaTerc = this.ccoObligaTerc;
        cuentasContablesVo.ccoReferencia1 = this.ccoReferencia1;
        cuentasContablesVo.ccoReferencia2 = this.ccoReferencia2;
        cuentasContablesVo.ccoTipoCuenta = this.ccoTipoCuenta;
        cuentasContablesVo.ccoTipDocConta = this.ccoTipDocConta;
        cuentasContablesVo.ccoPermiteObl = this.ccoPermiteObl;
        cuentasContablesVo.ccoCtaAcreedora = this.ccoCtaAcreedora;
        
        if (this.estadoCuentaContableVo!=null)
            cuentasContablesVo.estadoCuentaContableVo = this.estadoCuentaContableVo.clone();
        
        if (this.personaVo != null)
            cuentasContablesVo.personaVo = this.personaVo.clone() ;        
        return (cuentasContablesVo);
    }
    
    

    public void setCcoAcumTerc(String ccoAcumTerc) {
        this.ccoAcumTerc = ccoAcumTerc;
    }

    public String getCcoAcumTerc() {
        return ccoAcumTerc;
    }

    public void setCcoCentroCost(String ccoCentroCost) {
        this.ccoCentroCost = ccoCentroCost;
    }

    public String getCcoCentroCost() {
        return ccoCentroCost;
    }

    public void setCcoCodigo(Long ccoCodigo) {
        this.ccoCodigo = ccoCodigo;
    }

    public Long getCcoCodigo() {
        return ccoCodigo;
    }

    public void setCcoConcInfExog(String ccoConcInfExog) {
        this.ccoConcInfExog = ccoConcInfExog;
    }

    public String getCcoConcInfExog() {
        return ccoConcInfExog;
    }

    public void setCcoCtaBalance(String ccoCtaBalance) {
        this.ccoCtaBalance = ccoCtaBalance;
    }

    public String getCcoCtaBalance() {
        return ccoCtaBalance;
    }

    public void setCcoCtaImpuestos(String ccoCtaImpuestos) {
        this.ccoCtaImpuestos = ccoCtaImpuestos;
    }

    public String getCcoCtaImpuestos() {
        return ccoCtaImpuestos;
    }

    public void setCcoCtaResult(String ccoCtaResult) {
        this.ccoCtaResult = ccoCtaResult;
    }

    public String getCcoCtaResult() {
        return ccoCtaResult;
    }

    public void setCcoDescripcion(String ccoDescripcion) {
        this.ccoDescripcion = ccoDescripcion;
    }

    public String getCcoDescripcion() {
        return ccoDescripcion;
    }

    public void setCcoFteFinanc(String ccoFteFinanc) {
        this.ccoFteFinanc = ccoFteFinanc;
    }

    public String getCcoFteFinanc() {
        return ccoFteFinanc;
    }

    public void setCcoNaturaleza(String ccoNaturaleza) {
        this.ccoNaturaleza = ccoNaturaleza;
    }

    public String getCcoNaturaleza() {
        return ccoNaturaleza;
    }

    public void setCcoNivel1(String ccoNivel1) {
        this.ccoNivel1 = ccoNivel1;
    }

    public String getCcoNivel1() {
        return ccoNivel1;
    }

    public void setCcoNivel2(String ccoNivel2) {
        this.ccoNivel2 = ccoNivel2;
    }

    public String getCcoNivel2() {
        return ccoNivel2;
    }

    public void setCcoNivel3(String ccoNivel3) {
        this.ccoNivel3 = ccoNivel3;
    }

    public String getCcoNivel3() {
        return ccoNivel3;
    }

    public void setCcoNivel4(String ccoNivel4) {
        this.ccoNivel4 = ccoNivel4;
    }

    public String getCcoNivel4() {
        return ccoNivel4;
    }

    public void setCcoNivel5(String ccoNivel5) {
        this.ccoNivel5 = ccoNivel5;
    }

    public String getCcoNivel5() {
        return ccoNivel5;
    }

    public void setCcoNumDocConta(String ccoNumDocConta) {
        this.ccoNumDocConta = ccoNumDocConta;
    }

    public String getCcoNumDocConta() {
        return ccoNumDocConta;
    }

    public void setCcoObligaTerc(String ccoObligaTerc) {
        this.ccoObligaTerc = ccoObligaTerc;
    }

    public String getCcoObligaTerc() {
        return ccoObligaTerc;
    }

    public void setCcoReferencia1(String ccoReferencia1) {
        this.ccoReferencia1 = ccoReferencia1;
    }

    public String getCcoReferencia1() {
        return ccoReferencia1;
    }

    public void setCcoReferencia2(String ccoReferencia2) {
        this.ccoReferencia2 = ccoReferencia2;
    }

    public String getCcoReferencia2() {
        return ccoReferencia2;
    }

    public void setCcoTipoCuenta(String ccoTipoCuenta) {
        this.ccoTipoCuenta = ccoTipoCuenta;
    }

    public String getCcoTipoCuenta() {
        return ccoTipoCuenta;
    }

    public void setCcoTipDocConta(String ccoTipDocConta) {
        this.ccoTipDocConta = ccoTipDocConta;
    }

    public String getCcoTipDocConta() {
        return ccoTipDocConta;
    }


    public void setConceptoGastoDebList(List<ConceptoGastoVO> conceptoGastoDebList) {
        this.conceptoGastoDebList = conceptoGastoDebList;
    }

    public List<ConceptoGastoVO> getConceptoGastoDebList() {
        return conceptoGastoDebList;
    }

    public void setConceptoGastoCredList(List<ConceptoGastoVO> conceptoGastoCredList) {
        this.conceptoGastoCredList = conceptoGastoCredList;
    }

    public List<ConceptoGastoVO> getConceptoGastoCredList() {
        return conceptoGastoCredList;
    }

    public void setTipoRetencionList(List<TipoRetencionVO> tipoRetencionList) {
        this.tipoRetencionList = tipoRetencionList;
    }

    public List<TipoRetencionVO> getTipoRetencionList() {
        return tipoRetencionList;
    }

    public void setImputacionContableList(List<ImputacionContableVO> imputacionContableList) {
        this.imputacionContableList = imputacionContableList;
    }

    public List<ImputacionContableVO> getImputacionContableList() {
        return imputacionContableList;
    }

    public void setActividadIcaList(List<ActividadIcaVO> actividadIcaList) {
        this.actividadIcaList = actividadIcaList;
    }

    public List<ActividadIcaVO> getActividadIcaList() {
        return actividadIcaList;
    }


    public void setCuentaContTipoDocContListVo(List<CuentaContTipoDocContVO> cuentaContTipoDocContListVo) {
        this.cuentaContTipoDocContListVo = cuentaContTipoDocContListVo;
    }

    public List<CuentaContTipoDocContVO> getCuentaContTipoDocContListVo() {
        return cuentaContTipoDocContListVo;
    }

    public void setCcoPermiteObl(String ccoPermiteObl) {
        this.ccoPermiteObl = ccoPermiteObl;
    }

    public String getCcoPermiteObl() {
        return ccoPermiteObl;
    }


    public void setEstadoCuentaContableVo(EstadoCuentaContableVO estadoCuentaContableVo) {
        this.estadoCuentaContableVo = estadoCuentaContableVo;
    }

    public EstadoCuentaContableVO getEstadoCuentaContableVo() {
        return estadoCuentaContableVo;
    }

    public void setPersonaVo (PersonaVO personaVo){
        this.personaVo = personaVo;
    }
    
    public PersonaVO getPersonaVo(){
        return personaVo;
    }
    
    public void setCcoCtaAcreedora(String ccoCtaAcreedora) {
        this.ccoCtaAcreedora = ccoCtaAcreedora;
    }

    public String getCcoCtaAcreedora() {
        return ccoCtaAcreedora;
    }


    

  
    /**
     * Obtiene el N&uacute;mero de la Cuenta a trav&eacute;s de los Niveles 1-5.
     * @return Identificador construido concatenando los distintos niveles.
     */
    public String getNumeroCuenta () {
        String cuenta = null;
        if (this.ccoNivel1!=null && !this.ccoNivel1.isEmpty()) {
            cuenta = this.ccoNivel1;
            if (this.ccoNivel2!=null && !this.ccoNivel2.isEmpty()) {
                cuenta += "."+this.ccoNivel2;
                if (this.ccoNivel3!=null && !this.ccoNivel3.isEmpty()) {
                    cuenta += "."+this.ccoNivel3;
                    if (this.ccoNivel4!=null && !this.ccoNivel4.isEmpty()) {
                        cuenta += "."+this.ccoNivel4;
                        if (this.ccoNivel5!=null && !this.ccoNivel5.isEmpty()) {
                            cuenta += "."+this.ccoNivel5;
                        }
                    }
                }
            }
        }
        return (cuenta);
    }
    
    
    /**
     * Obtiene el Nombre del Estado de la Cuenta Contable.
     * @return (estadoCuentaContableVo.eccCodigo)->nombre.
     */
    public String getEstado () {
        String estado = null;
        
        if (this.estadoCuentaContableVo!=null && estadoCuentaContableVo.getEccCodigo()!=null)
            estado = EnumEstadoCuentaContable.getNombreById(estadoCuentaContableVo.getEccCodigo());
        
        return (estado);
    }
    
    public String getPersona (){
        String persona = null;
        if (this.personaVo != null && personaVo.getNombreCompleto() != null)
            persona = personaVo.getNombreCompleto() ;
        return persona;
    }
}
