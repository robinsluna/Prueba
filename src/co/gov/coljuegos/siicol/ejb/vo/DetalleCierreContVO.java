package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleCierreCont;

import java.math.BigDecimal;

import java.util.Date;

public class DetalleCierreContVO {
    private Long decCodigo;
    private Date decFechaCierre;
    private BigDecimal decSaldo;
    private PersonaVO personaVo;
    private CierreMensualVO cierreMensualVo;
    private CuentasContablesVO cuentasContablesVo;
    
    public DetalleCierreContVO() {
        
    }
    
    public DetalleCierreContVO(SiiDetalleCierreCont detalleCierreCont) {
        this.decCodigo = detalleCierreCont.getDecCodigo();
        this.decFechaCierre = detalleCierreCont.getDecFechaCierre();
        this.decSaldo = detalleCierreCont.getDecSaldo();
        //Padres:
        if (detalleCierreCont.getSiiPersona() != null) {
            this.personaVo = new PersonaVO(detalleCierreCont.getSiiPersona());            
        }
        if (detalleCierreCont.getSiiCierreContable() != null) {
            this.cierreMensualVo = new CierreMensualVO(detalleCierreCont.getSiiCierreContable());
        }
        if (detalleCierreCont.getSiiCuentasContables() != null) {
            this.cuentasContablesVo = new CuentasContablesVO(detalleCierreCont.getSiiCuentasContables());
        }
        
    }

    public void setDecCodigo(Long decCodigo) {
        this.decCodigo = decCodigo;
    }

    public Long getDecCodigo() {
        return decCodigo;
    }

    public void setDecFechaCierre(Date decFechaCierre) {
        this.decFechaCierre = decFechaCierre;
    }

    public Date getDecFechaCierre() {
        return decFechaCierre;
    }

    public void setDecSaldo(BigDecimal decSaldo) {
        this.decSaldo = decSaldo;
    }

    public BigDecimal getDecSaldo() {
        return decSaldo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setCierreMensualVo(CierreMensualVO cierreMensualVo) {
        this.cierreMensualVo = cierreMensualVo;
    }

    public CierreMensualVO getCierreMensualVo() {
        return cierreMensualVo;
    }

    public void setCuentasContablesVo(CuentasContablesVO cuentasContablesVo) {
        this.cuentasContablesVo = cuentasContablesVo;
    }

    public CuentasContablesVO getCuentasContablesVo() {
        return cuentasContablesVo;
    }
}

