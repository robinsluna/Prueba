/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */



package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMedioPago;

public class MedioPagoVO {
  
    private Long mepCodigo;
    private String mepNombre;
  
  
    public MedioPagoVO(SiiMedioPago siiMedioPago) {
        if(siiMedioPago!=null ){
           this.setMepCodigo(siiMedioPago.getMepCodigo());
           this.setMepNombre(siiMedioPago.getMepNombre());
        }
    }
  
    public MedioPagoVO() {
       
    }


    public void setMepCodigo(Long mepCodigo) {
        this.mepCodigo = mepCodigo;
    }

    public Long getMepCodigo() {
        return mepCodigo;
    }

    public void setMepNombre(String mepNombre) {
        this.mepNombre = mepNombre;
    }

    public String getMepNombre() {
        return mepNombre;
    }
}
