/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcedenciaPago;

public class ProcedenciaPagoVO {
   
   private String ppaCodigo;
   private String ppaNombre;
   
   
    public ProcedenciaPagoVO(SiiProcedenciaPago siiProcedenciaPago ) {
        if(siiProcedenciaPago!= null){
           this.setPpaCodigo(siiProcedenciaPago.getPpaCodigo());
           this.setPpaNombre(siiProcedenciaPago.getPpaNombre());
        }
    }
   
    public ProcedenciaPagoVO() {
       
    }

    public void setPpaCodigo(String ppaCodigo) {
        this.ppaCodigo = ppaCodigo;
    }

    public String getPpaCodigo() {
        return ppaCodigo;
    }

    public void setPpaNombre(String ppaNombre) {
        this.ppaNombre = ppaNombre;
    }

    public String getPpaNombre() {
        return ppaNombre;
    }
}
