/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 24-01-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocConpes;

public class EstadoDocConpesVO {
    
    private Long edcCodigo;
    private String edcNombre;
    
    
    public EstadoDocConpesVO() {
       
    }

    public EstadoDocConpesVO(SiiEstadoDocConpes siiEstadoDocConpes) {
   
        this.setEdcCodigo(siiEstadoDocConpes.getEdcCodigo());
        this.setEdcNombre(siiEstadoDocConpes.getEdcNombre());
    }


    public void setEdcCodigo(Long edcCodigo) {
        this.edcCodigo = edcCodigo;
    }

    public Long getEdcCodigo() {
        return edcCodigo;
    }

    public void setEdcNombre(String edcNombre) {
        this.edcNombre = edcNombre;
    }

    public String getEdcNombre() {
        return edcNombre;
    }


}
