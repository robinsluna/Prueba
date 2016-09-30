/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Gestión contractual
 * AUTOR	: Walter Becerra
 * FECHA	: 05-02-2015
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoLiquidCont;

public class EstadoLiquidacionContratoVO {
   
   private Long elcCodigo;
   private String elcNombre;
   
   
   
    public EstadoLiquidacionContratoVO() {
   
    }
    public EstadoLiquidacionContratoVO(SiiEstadoLiquidCont siiEstadoLiquidCont) {
       this.elcCodigo=siiEstadoLiquidCont.getElcCodigo();
       this.elcNombre=siiEstadoLiquidCont.getElcNombre();
    
    }

    public void setElcCodigo(Long elcCodigo) {
        this.elcCodigo = elcCodigo;
    }

    public Long getElcCodigo() {
        return elcCodigo;
    }

    public void setElcNombre(String elcNombre) {
        this.elcNombre = elcNombre;
    }

    public String getElcNombre() {
        return elcNombre;
    }

}
