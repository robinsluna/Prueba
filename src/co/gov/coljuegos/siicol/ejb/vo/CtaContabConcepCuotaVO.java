package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCtaContabConcepCuota;


/**
 * Value Object para las Cuentas Contables asociadas a cada Concepto de Cuota.
 * @author Camilo Miranda
 */
public class CtaContabConcepCuotaVO 
{
    private Long cccCodigo;
    private String cccInteres;
    private String cccTipo;
    
    private CuentasContablesVO cuentasContablesVo;
    private ConceptoCuotaVO conceptoCuotaVo;
    
    
    
    /**
     * Constructor.
     */
    public CtaContabConcepCuotaVO() { }
    
    
    
    /**
     * Constructor.
     * @param siiCtaContabConcepCuota - Entidad.
     */
    public CtaContabConcepCuotaVO (SiiCtaContabConcepCuota siiCtaContabConcepCuota) 
    {
        if (siiCtaContabConcepCuota!=null) {
            this.cccCodigo = siiCtaContabConcepCuota.getCccCodigo();
            this.cccInteres = siiCtaContabConcepCuota.getCccInteres();
            this.cccTipo = siiCtaContabConcepCuota.getCccTipo();
            
            if (siiCtaContabConcepCuota.getSiiCuentasContables()!=null) {
                this.cuentasContablesVo = new CuentasContablesVO(siiCtaContabConcepCuota.getSiiCuentasContables());
            }
            
            if (siiCtaContabConcepCuota.getSiiConceptoCuota()!=null) {
                this.conceptoCuotaVo = new ConceptoCuotaVO(siiCtaContabConcepCuota.getSiiConceptoCuota());
            }
            
        }
    }


    public void setCccCodigo(Long cccCodigo) {
        this.cccCodigo = cccCodigo;
    }

    public Long getCccCodigo() {
        return cccCodigo;
    }

    public void setCccInteres(String cccInteres) {
        this.cccInteres = cccInteres;
    }

    public String getCccInteres() {
        return cccInteres;
    }

    public void setCccTipo(String cccTipo) {
        this.cccTipo = cccTipo;
    }

    public String getCccTipo() {
        return cccTipo;
    }

    public void setCuentasContablesVo(CuentasContablesVO cuentasContablesVo) {
        this.cuentasContablesVo = cuentasContablesVo;
    }

    public CuentasContablesVO getCuentasContablesVo() {
        return cuentasContablesVo;
    }

    public void setConceptoCuotaVo(ConceptoCuotaVO conceptoCuotaVo) {
        this.conceptoCuotaVo = conceptoCuotaVo;
    }

    public ConceptoCuotaVO getConceptoCuotaVo() {
        return conceptoCuotaVo;
    }
}
