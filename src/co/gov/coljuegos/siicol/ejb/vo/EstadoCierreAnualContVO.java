/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-01-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCierreAnualCont;

import java.util.List;


/**
 * Value Object para el Estado del Cierre Anual Contable.
 * @author Camilo Miranda
 */
public class EstadoCierreAnualContVO 
{
    private Long ecaCodigo;
    private String ecaNombre;
    
    private List<CierreAnualContableVO> cierreAnualContableList;
    
    
    
    /**
     * Constructor.
     */
    public EstadoCierreAnualContVO() { }
    
    
    /**
     * Constructor.
     * @param siiEstadoCierreAnualCont - Entity.
     */
    public EstadoCierreAnualContVO (SiiEstadoCierreAnualCont siiEstadoCierreAnualCont) 
    {
        if (siiEstadoCierreAnualCont!=null) {
            this.ecaCodigo = siiEstadoCierreAnualCont.getEcaCodigo();
            this.ecaNombre = siiEstadoCierreAnualCont.getEcaNombre();
        }
    }


    public void setEcaCodigo(Long ecaCodigo) {
        this.ecaCodigo = ecaCodigo;
    }

    public Long getEcaCodigo() {
        return ecaCodigo;
    }

    public void setEcaNombre(String ecaNombre) {
        this.ecaNombre = ecaNombre;
    }

    public String getEcaNombre() {
        return ecaNombre;
    }

    public void setCierreAnualContableList(List<CierreAnualContableVO> cierreAnualContableList) {
        this.cierreAnualContableList = cierreAnualContableList;
    }

    public List<CierreAnualContableVO> getCierreAnualContableList() {
        return cierreAnualContableList;
    }
}
