/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoCuenta;

public class TipoCuentaVO {
   
   private Long tcuCodigo;
   private String tcuNombre;
   
   
    public TipoCuentaVO(SiiTipoCuenta siiTipoCuenta ) {
        if(siiTipoCuenta!= null){
          this.setTcuCodigo(siiTipoCuenta.getTcuCodigo());
          this.setTcuNombre(siiTipoCuenta.getTcuNombre());
        }
    }
   
    public TipoCuentaVO() {
      
    }

    public void setTcuCodigo(Long tcuCodigo) {
        this.tcuCodigo = tcuCodigo;
    }

    public Long getTcuCodigo() {
        return tcuCodigo;
    }

    public void setTcuNombre(String tcuNombre) {
        this.tcuNombre = tcuNombre;
    }

    public String getTcuNombre() {
        return tcuNombre;
    }

}
