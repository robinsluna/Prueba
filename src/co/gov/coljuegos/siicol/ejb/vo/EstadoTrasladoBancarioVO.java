/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTraslBancario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTrasladoBancario;

public class EstadoTrasladoBancarioVO {
    
    private Long estCodigo;
    private String estNombre;
    
    
    public EstadoTrasladoBancarioVO() {
        
    }
    
    public EstadoTrasladoBancarioVO(SiiEstadoTraslBancario siiEstadoTansladoBancario) {
        this.estCodigo=siiEstadoTansladoBancario.getEtbCodigo();
        this.estNombre=siiEstadoTansladoBancario.getEtbNombre();
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    public String getEstNombre() {
        return estNombre;
    }


}
