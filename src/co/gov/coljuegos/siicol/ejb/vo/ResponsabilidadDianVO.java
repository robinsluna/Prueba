/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 15-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponsabilidadDian;

import java.util.List;


/**
 * Value Object para la Responsabilidad DIAN.
 * @author Camilo Miranda
 */
public class ResponsabilidadDianVO {
    private Long rdiCodigo;
    private String rdiNombre;
    private List<ResponDianPersonaVO> siiResponDianPersonaList;
    
    
    /**
     * Constructor.
     */
    public ResponsabilidadDianVO() { }
    
    
    
    /**
     * Constructor.
     * @param siiResponsabilidadDian
     */
    public ResponsabilidadDianVO(SiiResponsabilidadDian siiResponsabilidadDian) {
        if (siiResponsabilidadDian!=null) {
            this.rdiCodigo = siiResponsabilidadDian.getRdiCodigo();
            this.rdiNombre = siiResponsabilidadDian.getRdiNombre();
        }
    }


    public void setRdiCodigo(Long rdiCodigo) {
        this.rdiCodigo = rdiCodigo;
    }

    public Long getRdiCodigo() {
        return rdiCodigo;
    }

    public void setRdiNombre(String rdiNombre) {
        this.rdiNombre = rdiNombre;
    }

    public String getRdiNombre() {
        return rdiNombre;
    }

    public void setSiiResponDianPersonaList(List<ResponDianPersonaVO> siiResponDianPersonaList) {
        this.siiResponDianPersonaList = siiResponDianPersonaList;
    }

    public List<ResponDianPersonaVO> getSiiResponDianPersonaList() {
        return siiResponDianPersonaList;
    }
    
}
