/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 30-04-2015
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaDocumentoCont;

import java.util.ArrayList;
import java.util.List;


/**
 * Value Object para el manejo de archivos de Cargue de Documentos Contables.
 * @author Camilo Miranda
 */
public class CargaDocumentoContVO 
{
    private Long cdcCodigo;
    private String cdcDescripcion;
    
    private ArchivoFisicoVO archivoFisicoVo;
    
    private List<DocumentoContableVO> documentoContableList;
    
    
    
    /**
     * Constructor.
     */
    public CargaDocumentoContVO() { }

    
    
    /**
     * Constructor.
     * @param siiCargaDocumentoCont - Entity.
     */
    public CargaDocumentoContVO (SiiCargaDocumentoCont siiCargaDocumentoCont) 
    {
        if (siiCargaDocumentoCont!=null) {
            this.cdcCodigo = siiCargaDocumentoCont.getCdcCodigo();
            this.cdcDescripcion = siiCargaDocumentoCont.getCdcDescripcion();
            
            if (siiCargaDocumentoCont.getSiiArchivoFisico()!=null)
                this.archivoFisicoVo = new ArchivoFisicoVO(siiCargaDocumentoCont.getSiiArchivoFisico());
        }
    }
    
    
    

    public void setCdcCodigo(Long cdcCodigo) {
        this.cdcCodigo = cdcCodigo;
    }

    public Long getCdcCodigo() {
        return cdcCodigo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setDocumentoContableList(List<DocumentoContableVO> documentoContableList) {
        this.documentoContableList = documentoContableList;
    }

    public List<DocumentoContableVO> getDocumentoContableList() {
        return documentoContableList;
    }

    public void setCdcDescripcion(String cdcDescripcion) {
        this.cdcDescripcion = cdcDescripcion;
    }

    public String getCdcDescripcion() {
        return cdcDescripcion;
    }
    
    
    

    /**
     * Adiciona un registro al listado de Documentos Contables.
     * @param documentoContableVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addDocumentoContable (DocumentoContableVO documentoContableVo) 
    {
        boolean exitoso = false;
        
        if (documentoContableList==null)
            documentoContableList = new ArrayList<DocumentoContableVO>();
        
        exitoso = documentoContableList.add(documentoContableVo);
        
        if (exitoso)
            documentoContableVo.setCargaDocumentoContVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado de Documentos Contables.
     * @param documentoContableVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeDocumentoContable (DocumentoContableVO documentoContableVo) {
        boolean exitoso = false;
        
        if (documentoContableList!=null) {
            exitoso = documentoContableList.remove(documentoContableVo);
            
            if (exitoso)
                documentoContableVo.setCargaDocumentoContVo(null);
        }
        
        return (exitoso);
    }
}
