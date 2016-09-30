package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


public class DistribucionMesVO {
    
    private Integer dcnNumero;
    private Long dmeCodigo;
    private CierreRecaudoVO cierreRecaudoVo;
    private DocumentoConpesVO documentoConpesVo;
    private EstadoDistribEnteVO estadoDistribEnteVo;
    private Date dmeFechaDistrib;
    private MesVO mesVo;  
    private Integer dmeVigencia;
    private Date dmeFechaResol;
    private String dmeResolucion;
    private String dmeDescripcion;
    private Long idEstadoAnterior;
    private BigDecimal dmeTotRendimFinanc;
    
    private List<DetalleDistribVO> detalleDistribListVo;
    private List<DetalleDeclaracionVO> detalleDeclaracionList;
    private List<ObligacionVO> obligacionList;
    private List<ConsolidadoDistVO> consolidadoDistList;
    
    
    
    /**
     * Constructor.
     * @param siiDistribucionMes
     */
    public DistribucionMesVO(SiiDistribucionMes siiDistribucionMes) {
        if (siiDistribucionMes!=null) {
           this.dcnNumero = siiDistribucionMes.getDcnNumero();
           this.dmeCodigo = siiDistribucionMes.getDmeCodigo();
           this.dmeFechaDistrib = siiDistribucionMes.getDmeFechaDistrib();
           this.dmeVigencia = siiDistribucionMes.getDmeVigencia();
           this.dmeFechaResol = siiDistribucionMes.getDmeFechaResol();
           this.dmeResolucion = siiDistribucionMes.getDmeResolucion();
           this.dmeDescripcion = siiDistribucionMes.getDmeDescripcion();
           this.dmeTotRendimFinanc = siiDistribucionMes.getDmeTotRendimFinanc();
           
           if(siiDistribucionMes.getSiiCierreRecaudo()!= null){
                this.cierreRecaudoVo = new CierreRecaudoVO(siiDistribucionMes.getSiiCierreRecaudo());
           }
           if(siiDistribucionMes.getSiiDocumentoConpes()!= null){
               this.documentoConpesVo = new DocumentoConpesVO(siiDistribucionMes.getSiiDocumentoConpes());
            }
           if(siiDistribucionMes.getSiiEstadoDistribEnte()!= null){
               this.estadoDistribEnteVo = new EstadoDistribEnteVO(siiDistribucionMes.getSiiEstadoDistribEnte());
            }
           if(siiDistribucionMes.getSiiMes()!= null){
               this.mesVo = new MesVO (siiDistribucionMes.getSiiMes());
            }
        }
    }
    
    
    /**
     * Constructor.
     */
    public DistribucionMesVO() {
       
    }

    public void setDcnNumero(Integer dcnNumero) {
        this.dcnNumero = dcnNumero;
    }

    public Integer getDcnNumero() {
        return dcnNumero;
    }

    public void setDmeCodigo(Long dmeCodigo) {
        this.dmeCodigo = dmeCodigo;
    }

    public Long getDmeCodigo() {
        return dmeCodigo;
    }

    public void setCierreRecaudoVo(CierreRecaudoVO cierreRecaudoVo) {
        this.cierreRecaudoVo = cierreRecaudoVo;
    }

    public CierreRecaudoVO getCierreRecaudoVo() {
        return cierreRecaudoVo;
    }

    public void setDocumentoConpesVo(DocumentoConpesVO documentoConpesVo) {
        this.documentoConpesVo = documentoConpesVo;
    }

    public DocumentoConpesVO getDocumentoConpesVo() {
        return documentoConpesVo;
    }

    public void setEstadoDistribEnteVo(EstadoDistribEnteVO estadoDistribEnteVo) {
        this.estadoDistribEnteVo = estadoDistribEnteVo;
    }

    public EstadoDistribEnteVO getEstadoDistribEnteVo() {
        return estadoDistribEnteVo;
    }

    public void setDetalleDistribListVo(List<DetalleDistribVO> detalleDistribListVo) {
        this.detalleDistribListVo = detalleDistribListVo;
    }

    public List<DetalleDistribVO> getDetalleDistribListVo() {
        return detalleDistribListVo;
    }

    public void setDmeFechaDistrib(Date dmeFechaDistrib) {
        this.dmeFechaDistrib = dmeFechaDistrib;
    }

    public Date getDmeFechaDistrib() {
        return dmeFechaDistrib;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setDmeVigencia(Integer dmeVigencia) {
        this.dmeVigencia = dmeVigencia;
    }

    public Integer getDmeVigencia() {
        return dmeVigencia;
    }

    public void setDetalleDeclaracionList(List<DetalleDeclaracionVO> detalleDeclaracionList) {
        this.detalleDeclaracionList = detalleDeclaracionList;
    }

    public List<DetalleDeclaracionVO> getDetalleDeclaracionList() {
        return detalleDeclaracionList;
    }

    public void setObligacionList(List<ObligacionVO> obligacionList) {
        this.obligacionList = obligacionList;
    }

    public List<ObligacionVO> getObligacionList() {
        return obligacionList;
    }

    public void setDmeFechaResol(Date dmeFechaResol) {
        this.dmeFechaResol = dmeFechaResol;
    }

    public Date getDmeFechaResol() {
        return dmeFechaResol;
    }

    public void setDmeResolucion(String dmeResolucion) {
        this.dmeResolucion = dmeResolucion;
    }

    public String getDmeResolucion() {
        return dmeResolucion;
    }


    public void setDmeDescripcion(String dmeDescripcion) {
        this.dmeDescripcion = dmeDescripcion;
    }

    public String getDmeDescripcion() {
        return dmeDescripcion;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setDmeTotRendimFinanc(BigDecimal dmeTotRendimFinanc) {
        this.dmeTotRendimFinanc = dmeTotRendimFinanc;
    }

    public BigDecimal getDmeTotRendimFinanc() {
        return dmeTotRendimFinanc;
    }

    public void setConsolidadoDistList(List<ConsolidadoDistVO> consolidadoDistList) {
        this.consolidadoDistList = consolidadoDistList;
    }

    public List<ConsolidadoDistVO> getConsolidadoDistList() {
        return consolidadoDistList;
    }
    
    
    
    
    /**
     * Obtiene el Valor a Pagar a partir de los valores contenidos en el listado de Detalles de Distribuci&oacute;n.
     * @return Valor a Pagar.
     */
    public BigDecimal getTotalTransferir() {
        BigDecimal totalTransferir = new BigDecimal(0);
        
        if (detalleDistribListVo!=null) {
            for (DetalleDistribVO detalleDistribVo: detalleDistribListVo) {
                if (detalleDistribVo!=null) {
                    if (detalleDistribVo.getDdiValorProp()!=null)
                        totalTransferir = totalTransferir.add(detalleDistribVo.getDdiValorProp());
                    if (detalleDistribVo.getDdiValorDetod()!=null)
                        totalTransferir = totalTransferir.add(detalleDistribVo.getDdiValorDetod());
                }
            }
        }
        
        return (totalTransferir);
    }
    
    
    
    /**
     * Obtiene el Valor a Pagar a partir de los valores contenidos en el listado de Detalles de Distribuci&oacute;n, asociados al Ente Territorial.
     * @param etiCodigo - C&oacute;digo del Ente Territorial.
     * @return Valor a Pagar.
     */
    public BigDecimal getTotalTransferir (Long etiCodigo) {
        BigDecimal totalTransferir = new BigDecimal(0);
        
        if (detalleDistribListVo!=null) {
            for (DetalleDistribVO detalleDistribVo: detalleDistribListVo) {
                if (detalleDistribVo!=null && etiCodigo!=null && 
                    detalleDistribVo.getEnteTerritorialVo()!=null && detalleDistribVo.getEnteTerritorialVo().getEtiCodigo()!=null &&
                    etiCodigo.equals(detalleDistribVo.getEnteTerritorialVo().getEtiCodigo())) 
                {
                    if (detalleDistribVo.getDdiValorProp()!=null)
                        totalTransferir = totalTransferir.add(detalleDistribVo.getDdiValorProp());
                    if (detalleDistribVo.getDdiValorDetod()!=null)
                        totalTransferir = totalTransferir.add(detalleDistribVo.getDdiValorDetod());
                }
            }
        }
        
        return (totalTransferir);
    }
}
