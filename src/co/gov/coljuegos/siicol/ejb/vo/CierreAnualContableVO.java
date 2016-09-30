package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreAnualContable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para el Cierre Anual Contable.
 * @author Camilo Miranda
 */
public class CierreAnualContableVO 
{
    private String cacBancarias;
    private Long cacCodigo;
    private Date cacFechaCierre;
    private String cacImpuestos;
    private String cacVigFiscal;
    private Integer cacVigencia;
    
    private EstadoCierreAnualContVO estadoCierreAnualContVo;
    
    private List<DocumentoContableVO> documentoContableList;
    
    
    /**
     * Constructor.
     */
    public CierreAnualContableVO() { }
    

    /**
     * Constructor.
     * @param siiCierreAnualContable - Entity.
     */
    public CierreAnualContableVO (SiiCierreAnualContable siiCierreAnualContable) 
    {
        if (siiCierreAnualContable!=null) {
            this.cacBancarias = siiCierreAnualContable.getCacBancarias();
            this.cacCodigo = siiCierreAnualContable.getCacCodigo();
            this.cacFechaCierre = siiCierreAnualContable.getCacFechaCierre();
            this.cacImpuestos = siiCierreAnualContable.getCacImpuestos();
            this.cacVigFiscal = siiCierreAnualContable.getCacVigFiscal();
            this.cacVigencia = siiCierreAnualContable.getCacVigencia();
            
            if (siiCierreAnualContable.getSiiEstadoCierreAnualCont()!=null) {
                this.estadoCierreAnualContVo = new EstadoCierreAnualContVO(siiCierreAnualContable.getSiiEstadoCierreAnualCont());
            }
        }
    }


    public void setCacBancarias(String cacBancarias) {
        this.cacBancarias = cacBancarias;
    }

    public String getCacBancarias() {
        return cacBancarias;
    }

    public void setCacCodigo(Long cacCodigo) {
        this.cacCodigo = cacCodigo;
    }

    public Long getCacCodigo() {
        return cacCodigo;
    }

    public void setCacFechaCierre(Date cacFechaCierre) {
        this.cacFechaCierre = cacFechaCierre;
    }

    public Date getCacFechaCierre() {
        return cacFechaCierre;
    }

    public void setCacImpuestos(String cacImpuestos) {
        this.cacImpuestos = cacImpuestos;
    }

    public String getCacImpuestos() {
        return cacImpuestos;
    }

    public void setCacVigFiscal(String cacVigFiscal) {
        this.cacVigFiscal = cacVigFiscal;
    }

    public String getCacVigFiscal() {
        return cacVigFiscal;
    }

    public void setCacVigencia(Integer cacVigencia) {
        this.cacVigencia = cacVigencia;
    }

    public Integer getCacVigencia() {
        return cacVigencia;
    }

    public void setEstadoCierreAnualContVo(EstadoCierreAnualContVO estadoCierreAnualContVo) {
        this.estadoCierreAnualContVo = estadoCierreAnualContVo;
    }

    public EstadoCierreAnualContVO getEstadoCierreAnualContVo() {
        return estadoCierreAnualContVo;
    }

    public void setDocumentoContableList(List<DocumentoContableVO> documentoContableList) {
        this.documentoContableList = documentoContableList;
    }

    public List<DocumentoContableVO> getDocumentoContableList() {
        return documentoContableList;
    }
    
    
    /**
     * Adiciona un Documento Contable a la lista.
     * @param documentoContableVo
     */
    public void addDocumentoContable (DocumentoContableVO documentoContableVo)     
    {
        if (documentoContableVo!=null) {
            if (documentoContableList == null)
                documentoContableList = new ArrayList<DocumentoContableVO>();
            
            documentoContableVo.setCierreAnualContableVo(this);
            documentoContableList.add(documentoContableVo);
        }
    }
    
    
    /**
     * Elimina un Documento Contable.
     * @param documentoContableVo
     * @return eliminado?
     */
    public boolean removeDocumentoContable (DocumentoContableVO documentoContableVo) 
    {
        boolean eliminado = false;
        if (documentoContableList!=null && documentoContableVo!=null) {
            eliminado = documentoContableList.remove(documentoContableVo);
            
            if (eliminado)
                documentoContableVo.setCierreAnualContableVo(null);
        }
        
        return (eliminado);
    }
    
    
    /**
     * Obtiene el Estado del Cierre Anual Contable.
     * @return estadoCierreAnualContVo.cacEstado
     */
    public String getEstado () 
    {
        String estado = null;
        if (estadoCierreAnualContVo!=null)
            estado = estadoCierreAnualContVo.getEcaNombre();
        
        return (estado);
    }
}
