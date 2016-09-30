/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y Transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 29-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrato;

import java.util.List;

public class EstadoContratoVO {
    private Long ecoCodigo;
    private String ecoEstEjecucion;
    private String ecoNombre;
    private List<ContratoVO> contratoVoList;   
    
    
    public EstadoContratoVO(SiiEstadoContrato siiEstadoContrato){
        this.ecoCodigo = siiEstadoContrato.getEcoCodigo();
        this.ecoEstEjecucion = siiEstadoContrato.getEcoEstEjecucion();
        this.ecoNombre = siiEstadoContrato.getEcoNombre();
    }
    
    public EstadoContratoVO() {
    }

    public void setEcoCodigo(Long ecoCodigo) {
        this.ecoCodigo = ecoCodigo;
    }

    public Long getEcoCodigo() {
        return ecoCodigo;
    }

    public void setEcoEstEjecucion(String ecoEstEjecucion) {
        this.ecoEstEjecucion = ecoEstEjecucion;
    }

    public String getEcoEstEjecucion() {
        return ecoEstEjecucion;
    }

    public void setEcoNombre(String ecoNombre) {
        this.ecoNombre = ecoNombre;
    }

    public String getEcoNombre() {
        return ecoNombre;
    }

    public void setContratoVoList(List<ContratoVO> contratoVoList) {
        this.contratoVoList = contratoVoList;
    }

    public List<ContratoVO> getContratoVoList() {
        return contratoVoList;
    }

}
