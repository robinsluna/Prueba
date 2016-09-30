/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Gestión contractual
 * AUTOR	: Walter Becerra
 * FECHA	: 05-02-2015
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCausalTermContr;

public class CausalTerminacionContratoVO {
    
    private Long ctcCodigo;
    private String ctcNombre;
    
    
    public CausalTerminacionContratoVO() {
       
    }
    
    public CausalTerminacionContratoVO(SiiCausalTermContr siiCausalTermContr) {
       this.ctcCodigo=siiCausalTermContr.getCtcCodigo();
       this.ctcNombre=siiCausalTermContr.getCtcNombre();       
       
    }
    
    

    public void setCtcCodigo(Long ctcCodigo) {
        this.ctcCodigo = ctcCodigo;
    }

    public Long getCtcCodigo() {
        return ctcCodigo;
    }

    public void setCtcNombre(String ctcNombre) {
        this.ctcNombre = ctcNombre;
    }

    public String getCtcNombre() {
        return ctcNombre;
    }


}
