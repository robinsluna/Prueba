package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InteresCuotaVO {
    
    private BigDecimal icuBaseCalc;
    private String icuCancelado;
    private Long icuCodigo;
    private Date icuFecha;
    private BigDecimal icuTasaAplic;
    private BigDecimal icuValor;
    private BigDecimal icuValorPagado;
    private CuotaOperadorVO cuotaOperadorVo;
    private List<DocumentoContableVO> documentoContableList;
    private String concepto;
    
    private PersonaVO personaVo;
    private Long numeroCuota;
    private String  numeroContrato;
    private String   numeroResolucion;
    private BigDecimal valorTotalInteresXRefPago;
    
    public InteresCuotaVO() {
        
    }
    
    public InteresCuotaVO(SiiInteresCuota interesCuota) {
        this.icuBaseCalc = interesCuota.getIcuBaseCalc();
        this.icuCancelado = interesCuota.getIcuCancelado();
        this.icuCodigo = interesCuota.getIcuCodigo();
        this.icuFecha = interesCuota.getIcuFecha();
        this.icuTasaAplic = interesCuota.getIcuTasaAplic();
        this.icuValor = interesCuota.getIcuValor();
        this.icuValorPagado = interesCuota.getIcuValorPagado();
        if (interesCuota.getSiiCuotaOperador()!=null)
            this.cuotaOperadorVo = new CuotaOperadorVO(interesCuota.getSiiCuotaOperador());
    }


    public void setIcuBaseCalc(BigDecimal icuBaseCalc) {
        this.icuBaseCalc = icuBaseCalc;
    }

    public BigDecimal getIcuBaseCalc() {
        return icuBaseCalc;
    }

    public void setIcuCancelado(String icuCancelado) {
        this.icuCancelado = icuCancelado;
    }

    public String getIcuCancelado() {
        return icuCancelado;
    }

    public void setIcuCodigo(Long icuCodigo) {
        this.icuCodigo = icuCodigo;
    }

    public Long getIcuCodigo() {
        return icuCodigo;
    }

    public void setIcuFecha(Date icuFecha) {
        this.icuFecha = icuFecha;
    }

    public Date getIcuFecha() {
        return icuFecha;
    }

    public void setIcuTasaAplic(BigDecimal icuTasaAplic) {
        this.icuTasaAplic = icuTasaAplic;
    }

    public BigDecimal getIcuTasaAplic() {
        return icuTasaAplic;
    }

    public void setIcuValor(BigDecimal icuValor) {
        this.icuValor = icuValor;
    }

    public BigDecimal getIcuValor() {
        return icuValor;
    }

    public void setIcuValorPagado(BigDecimal icuValorPagado) {
        this.icuValorPagado = icuValorPagado;
    }

    public BigDecimal getIcuValorPagado() {
        return icuValorPagado;
    }

    public void setCuotaOperadorVo(CuotaOperadorVO cuotaOperadorVo) {
        this.cuotaOperadorVo = cuotaOperadorVo;
    }

    public CuotaOperadorVO getCuotaOperadorVo() {
        return cuotaOperadorVo;
    }


    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setNumeroCuota(Long numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Long getNumeroCuota() {
        return numeroCuota;
    }


    public void setValorTotalInteresXRefPago(BigDecimal valorTotalInteresXRefPago) {
        this.valorTotalInteresXRefPago = valorTotalInteresXRefPago;
    }

    public BigDecimal getValorTotalInteresXRefPago() {
        return valorTotalInteresXRefPago;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroResolucion(String numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    public String getNumeroResolucion() {
        return numeroResolucion;
    }

    /**
     * Obtiene el Documento Contable.
     * (En la pr&aacute;ctica, s&oacute;lamente existe un (1) Documento Contable por Interes Cuota)
     * @return documentoContableList.first
     */
    public DocumentoContableVO getDocumentoContable () {
        return ( documentoContableList!=null && !documentoContableList.isEmpty()?documentoContableList.get(0):null );
    }
    
    
    /**
     * Establece el Documento Contable.
     * (En la pr&aacute;ctica, s&oacute;lamente existe un (1) Documento Contable por Interes Cuota)
     * @param documentoContableVO
     */
    public void setDocumentoContable (DocumentoContableVO documentoContableVO) {
        if (documentoContableList==null)
            documentoContableList = new ArrayList<DocumentoContableVO>();
        else
            documentoContableList.clear();
        
        documentoContableList.add(documentoContableVO);
    }
}
