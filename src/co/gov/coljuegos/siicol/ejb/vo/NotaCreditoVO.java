/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-06-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoNotaCredito;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para el manejo de Notas de Cr&eacute;dito.
 * @author Camilo Miranda
 */
public class NotaCreditoVO 
{
    private Long ncrCodigo;
    private Date ncrFecha;
    private Integer ncrNumero;
    private String ncrRcIndepend;
    private String ncrTipoNota;
    private String ncrEstado;
    private String ncrMotivoAnula;
    private String ncrConcepto;
    
    private ObligacionVO obligacionVo;
    private FuenteFinancContabVO fuenteFinancContabVo;
    private UsuarioVO usuarioRegistraVo;
    private UsuarioVO usuarioApruebaVo;
    
    private List<NotaCredOblConceptoVO> notaCredOblConceptoList;
    private List<DocumentoContableVO> documentoContableList;
    private List<NotaCredOblConcDetRubVO> notaCredOblConcDetRubList;
    
    private BigDecimal totalConcepNotaCredito;
    private BigDecimal saldoNotaCredito;
    
    
    
    /**
     * Constructor.
     */
    public NotaCreditoVO() { }
    
    
    /**
     * Constructor.
     * @param siiNotaCredito - Entity.
     */
    public NotaCreditoVO (SiiNotaCredito siiNotaCredito) 
    {
        if (siiNotaCredito!=null) {
            this.ncrCodigo = siiNotaCredito.getNcrCodigo();
            this.ncrFecha = siiNotaCredito.getNcrFecha();
            this.ncrNumero = siiNotaCredito.getNcrNumero();
            this.ncrRcIndepend = siiNotaCredito.getNcrRcIndepend();
            this.ncrTipoNota = siiNotaCredito.getNcrTipoNota();
            this.ncrEstado = siiNotaCredito.getNcrEstado();
            this.ncrMotivoAnula = siiNotaCredito.getNcrMotivoAnula();
            this.ncrConcepto = siiNotaCredito.getNcrConcepto();
    
            if (siiNotaCredito.getSiiObligacion()!=null)
                this.obligacionVo = new ObligacionVO(siiNotaCredito.getSiiObligacion());
            
            if (siiNotaCredito.getSiiFuenteFinancContab()!=null)
                this.fuenteFinancContabVo = new FuenteFinancContabVO(siiNotaCredito.getSiiFuenteFinancContab());
            
            if (siiNotaCredito.getSiiUsuarioRegistra()!=null)
                this.usuarioRegistraVo = new UsuarioVO(siiNotaCredito.getSiiUsuarioRegistra());
            
            if (siiNotaCredito.getSiiUsuarioAprueba()!=null)
                this.usuarioApruebaVo = new UsuarioVO(siiNotaCredito.getSiiUsuarioAprueba());
        }
    }

    
    
    
    /**
     * Adiciona un registro al listado de NotaCredOblConceptoVO.
     * @param notaCredOblConceptoVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addNotaCredOblConcepto (NotaCredOblConceptoVO notaCredOblConceptoVo) 
    {
        boolean exitoso = false;
        
        if (notaCredOblConceptoList==null)
            notaCredOblConceptoList = new ArrayList<NotaCredOblConceptoVO>();
        
        exitoso = notaCredOblConceptoList.add(notaCredOblConceptoVo);
        
        if (exitoso)
            notaCredOblConceptoVo.setNotaCreditoVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado NotaCredOblConceptoVO.
     * @param notaCredOblConceptoVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeNotaCredOblConcepto (NotaCredOblConceptoVO notaCredOblConceptoVo) {
        boolean exitoso = false;
        
        if (notaCredOblConceptoList!=null) {
            exitoso = notaCredOblConceptoList.remove(notaCredOblConceptoVo);
            
            if (exitoso)
                notaCredOblConceptoVo.setNotaCreditoVo(null);
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Adiciona un registro al listado de NotaCredOblConcDetRubVO.
     * @param notaCredOblConcDetRubVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addNotaCredOblConcDetRub (NotaCredOblConcDetRubVO notaCredOblConcDetRubVo) 
    {
        boolean exitoso = false;
        
        if (notaCredOblConcDetRubList==null)
            notaCredOblConcDetRubList = new ArrayList<NotaCredOblConcDetRubVO>();
        
        exitoso = notaCredOblConcDetRubList.add(notaCredOblConcDetRubVo);
        
        if (exitoso)
            notaCredOblConcDetRubVo.setNotaCreditoVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado NotaCredOblConcDetRubVO.
     * @param notaCredOblConcDetRubVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeNotaCredOblConcDetRub (NotaCredOblConcDetRubVO notaCredOblConcDetRubVo) {
        boolean exitoso = false;
        
        if (notaCredOblConcDetRubList!=null) {
            exitoso = notaCredOblConcDetRubList.remove(notaCredOblConcDetRubVo);
            
            if (exitoso)
                notaCredOblConcDetRubVo.setNotaCreditoVo(null);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Adiciona un registro al listado de Documentos Contables.
     * @param documentoContableVo - Documento Contable a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addDocumentoContable (DocumentoContableVO documentoContableVo) 
    {
        boolean exitoso = false;
        
        if (documentoContableList==null)
            documentoContableList = new ArrayList<DocumentoContableVO>();
        
        exitoso = documentoContableList.add(documentoContableVo);
        
        if (exitoso)
            documentoContableVo.setNotaCreditoVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado de Documentos Contables.
     * @param documentoContableVo - Documento Contable a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeDocumentoContable (DocumentoContableVO documentoContableVo) {
        boolean exitoso = false;
        
        if (documentoContableList!=null) {
            exitoso = documentoContableList.remove(documentoContableVo);
            
            if (exitoso)
                documentoContableVo.setNotaCreditoVo(null);
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Obtiene el primer registro del listado de Documentos Contables asociados a la Nota de Cr&eacute;dito.
     * (En la pr&aacute;ctica, debe existir un &uacute;nico Documento Contable por Nota de Cr&eacute;dito).
     * @return documentoContableList.first
     */
    public DocumentoContableVO getDocumentoContable () 
    {
        DocumentoContableVO documentoContableVo = null;
        if (documentoContableList!=null && !documentoContableList.isEmpty())
            documentoContableVo = documentoContableList.get(0);
        
        return (documentoContableVo);
    }
    
    
    /**
     * Adiciona un &uacute;nico registro de Documento Contable a la lista.
     * @param documentoContableVo
     */
    public void setDocumentoContable (DocumentoContableVO documentoContableVo) 
    {
        if (documentoContableList!=null)
            documentoContableList.clear();
        
        this.addDocumentoContable(documentoContableVo);
    }
    
    
    
    /**
     * Obtiene el nombre del Estado de la Nota de Cr&eacute;dito.
     * @return nombre[ncrEstado].
     */
    public String getEstado () 
    {
        String estado = null;
        
        if (this.ncrEstado!=null) {
            estado = EnumEstadoNotaCredito.getNombreById(this.ncrEstado);
        }
        
        return (estado);
    }
    
    
    
    public void setNcrCodigo(Long ncrCodigo) {
        this.ncrCodigo = ncrCodigo;
    }

    public Long getNcrCodigo() {
        return ncrCodigo;
    }

    public void setNcrFecha(Date ncrFecha) {
        this.ncrFecha = ncrFecha;
    }

    public Date getNcrFecha() {
        return ncrFecha;
    }

    public void setNcrNumero(Integer ncrNumero) {
        this.ncrNumero = ncrNumero;
    }

    public Integer getNcrNumero() {
        return ncrNumero;
    }

    public void setNcrRcIndepend(String ncrRcIndepend) {
        this.ncrRcIndepend = ncrRcIndepend;
    }

    public String getNcrRcIndepend() {
        return ncrRcIndepend;
    }

    public void setNcrTipoNota(String ncrTipoNota) {
        this.ncrTipoNota = ncrTipoNota;
    }

    public String getNcrTipoNota() {
        return ncrTipoNota;
    }

    public void setObligacionVo(ObligacionVO obligacionVo) {
        this.obligacionVo = obligacionVo;
    }

    public ObligacionVO getObligacionVo() {
        return obligacionVo;
    }

    public void setNotaCredOblConceptoList(List<NotaCredOblConceptoVO> notaCredOblConceptoList) {
        this.notaCredOblConceptoList = notaCredOblConceptoList;
    }

    public List<NotaCredOblConceptoVO> getNotaCredOblConceptoList() {
        return notaCredOblConceptoList;
    }

    public void setDocumentoContableList(List<DocumentoContableVO> documentoContableList) {
        this.documentoContableList = documentoContableList;
    }

    public List<DocumentoContableVO> getDocumentoContableList() {
        return documentoContableList;
    }

    public void setNcrEstado(String ncrEstado) {
        this.ncrEstado = ncrEstado;
    }

    public String getNcrEstado() {
        return ncrEstado;
    }

    public void setFuenteFinancContabVo(FuenteFinancContabVO fuenteFinancContabVo) {
        this.fuenteFinancContabVo = fuenteFinancContabVo;
    }

    public FuenteFinancContabVO getFuenteFinancContabVo() {
        return fuenteFinancContabVo;
    }

    public void setNotaCredOblConcDetRubList(List<NotaCredOblConcDetRubVO> notaCredOblConcDetRubList) {
        this.notaCredOblConcDetRubList = notaCredOblConcDetRubList;
    }

    public List<NotaCredOblConcDetRubVO> getNotaCredOblConcDetRubList() {
        return notaCredOblConcDetRubList;
    }

    public void setUsuarioRegistraVo(UsuarioVO usuarioRegistraVo) {
        this.usuarioRegistraVo = usuarioRegistraVo;
    }

    public UsuarioVO getUsuarioRegistraVo() {
        return usuarioRegistraVo;
    }

    public void setUsuarioApruebaVo(UsuarioVO usuarioApruebaVo) {
        this.usuarioApruebaVo = usuarioApruebaVo;
    }

    public UsuarioVO getUsuarioApruebaVo() {
        return usuarioApruebaVo;
    }

    public void setNcrMotivoAnula(String ncrMotivoAnula) {
        this.ncrMotivoAnula = ncrMotivoAnula;
    }

    public String getNcrMotivoAnula() {
        return ncrMotivoAnula;
    }

    public void setNcrConcepto(String ncrConcepto) {
        this.ncrConcepto = ncrConcepto;
    }

    public String getNcrConcepto() {
        return ncrConcepto;
    }

    public void setTotalConcepNotaCredito(BigDecimal totalConcepNotaCredito) {
        this.totalConcepNotaCredito = totalConcepNotaCredito;
    }

    public BigDecimal getTotalConcepNotaCredito() {
        return totalConcepNotaCredito;
    }

    public void setSaldoNotaCredito(BigDecimal saldoNotaCredito) {
        this.saldoNotaCredito = saldoNotaCredito;
    }

    public BigDecimal getSaldoNotaCredito() {
        return saldoNotaCredito;
    }
}
