/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-02-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;

import java.util.List;


/**
 * Value Object para el Estado del Documento Contable.
 * @author Camilo Miranda
 */
public class EstadoDocContabVO {
    
    private Long edoCodigo;
    private String edoNombre;
    
    private List<DocumentoContableVO> documentoContableList;
    
    
    /**
     * Constructor.
     */
    public EstadoDocContabVO() { }
    
    
    /**
     * Constructor.
     * @param siiEstadoDocContab - Entity.
     */
    public EstadoDocContabVO (SiiEstadoDocContab siiEstadoDocContab) {
        if (siiEstadoDocContab!=null) {
            this.edoCodigo = siiEstadoDocContab.getEdoCodigo();
            this.edoNombre = siiEstadoDocContab.getEdoNombre();
        }
    }


    public void setEdoCodigo(Long edoCodigo) {
        this.edoCodigo = edoCodigo;
    }

    public Long getEdoCodigo() {
        return edoCodigo;
    }

    public void setEdoNombre(String edoNombre) {
        this.edoNombre = edoNombre;
    }

    public String getEdoNombre() {
        return edoNombre;
    }

    public void setDocumentoContableList(List<DocumentoContableVO> documentoContableList) {
        this.documentoContableList = documentoContableList;
    }

    public List<DocumentoContableVO> getDocumentoContableList() {
        return documentoContableList;
    }
}
