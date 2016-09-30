/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoReten;

import java.util.List;


/**
 * Value Object para el Concepto de Retenci&oacute;n.
 * @author Camilo Miranda
 */
public class ConceptoRetenVO 
{
    private Long creCodigo;
    private String creNombre;
    private List<TipoRetencionVO> tipoRetencionList;
    
    
    /**
     * Constructor.
     */
    public ConceptoRetenVO() { }
    
    
    /**
     * Constructor.
     * @param siiConceptoReten - Entity
     */
    public ConceptoRetenVO (SiiConceptoReten siiConceptoReten) {
        if (siiConceptoReten!=null) {
            this.creCodigo = siiConceptoReten.getCreCodigo();
            this.creNombre = siiConceptoReten.getCreNombre();
        }
    }


    public void setCreCodigo(Long creCodigo) {
        this.creCodigo = creCodigo;
    }

    public Long getCreCodigo() {
        return creCodigo;
    }

    public void setCreNombre(String creNombre) {
        this.creNombre = creNombre;
    }

    public String getCreNombre() {
        return creNombre;
    }

    public void setTipoRetencionList(List<TipoRetencionVO> tipoRetencionList) {
        this.tipoRetencionList = tipoRetencionList;
    }

    public List<TipoRetencionVO> getTipoRetencionList() {
        return tipoRetencionList;
    }
}
