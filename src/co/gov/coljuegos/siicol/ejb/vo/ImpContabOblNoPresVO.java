package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImpContabOblNoPres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionNoPresup;

public class ImpContabOblNoPresVO {
    
    private Long ionCodigo;
    private CuentasContablesVO cuentasContablesVo;
    private ImputacionContableVO imputacionContableVo;
    private ObligacionNoPresupVO obligacionNoPresupVo;
    private String ionEstado;
    
    public ImpContabOblNoPresVO(SiiImpContabOblNoPres siiImpContabOblNoPres) {
      this.ionCodigo = siiImpContabOblNoPres.getIonCodigo();
      this.ionEstado = siiImpContabOblNoPres.getIonEstado();
      
      if(siiImpContabOblNoPres.getSiiImputacionContable()!= null){
        this.imputacionContableVo = new ImputacionContableVO(siiImpContabOblNoPres.getSiiImputacionContable());
      }
      if(siiImpContabOblNoPres.getSiiCuentasContables()!= null){
          this.cuentasContablesVo = new CuentasContablesVO(siiImpContabOblNoPres.getSiiCuentasContables());
      }
      if(siiImpContabOblNoPres.getSiiObligacionNoPresup()!= null){
          this.obligacionNoPresupVo = new ObligacionNoPresupVO(siiImpContabOblNoPres.getSiiObligacionNoPresup());
        }
    }
    public ImpContabOblNoPresVO() {
    }
    

    public void setIonCodigo(Long ionCodigo) {
        this.ionCodigo = ionCodigo;
    }

    public Long getIonCodigo() {
        return ionCodigo;
    }

    public void setCuentasContablesVo(CuentasContablesVO cuentasContablesVo) {
        this.cuentasContablesVo = cuentasContablesVo;
    }

    public CuentasContablesVO getCuentasContablesVo() {
        return cuentasContablesVo;
    }

    public void setImputacionContableVo(ImputacionContableVO imputacionContableVo) {
        this.imputacionContableVo = imputacionContableVo;
    }

    public ImputacionContableVO getImputacionContableVo() {
        return imputacionContableVo;
    }

    public void setObligacionNoPresupVo(ObligacionNoPresupVO obligacionNoPresupVo) {
        this.obligacionNoPresupVo = obligacionNoPresupVo;
    }

    public ObligacionNoPresupVO getObligacionNoPresupVo() {
        return obligacionNoPresupVo;
    }

    public void setIonEstado(String ionEstado) {
        this.ionEstado = ionEstado;
    }

    public String getIonEstado() {
        return ionEstado;
    }
}
