/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Camilo Miranda
 * FECHA	: 18-02-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;


/**
 * Value Object para la Informaci&oacute;n Detallada de un Rubro.
 * (Datos del Rubro, la Fuente de Financiaci&oacute;n y el Detalle Rubro).
 */
public class InfoDetalladaRubroVO 
{
    private String rubro;
    private String descRubro;
    private Integer vigencia;
    private Long druCodigo;
    private Long druValor;
    private Long interno;
    private Long dffCodigo;
    private Long ffiCodigo;
    private Integer ffiCodigoFuente;
    private String ffiDescripcion;
    private String ffcCodigo;
    private String fccNombre;
    private Long creditos;
    private Long contracreditos;
    private Long adiciones;
    private Long reducciones;
    private Integer dffCodigoRecurso;
    private String dffDescripcion;
    
    private DetalleRubroVO detalleRubroVo;
    
    
    
    
    //////////////////////////////////////////////////////
    // Atributos propios de la Imputacion Presupuestal. //
    //////////////////////////////////////////////////////
    /**
     * Detalle Rubro CDP del Concepto de la Obligaci&oacute;n.
     * - Usado para la Imputaci&oacute;n Presupuestal.
     */
    private OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo;
    
    /**
     * Detalle Rubro CDP de la Nota de Cr&eacute;dito de la Obligaci&oacute;n.
     * - Usado para la Imputaci&oacute;n Presupuestal.
     */
    private NotaCredOblConcDetRubVO notaCredOblConcDetRubVo;
    
    
    /** Valor del RP. */
    private BigDecimal valorRP;
    /** Incrementos RP */
    private BigDecimal incrementosRP;
    /** Decrementos RP */
    private BigDecimal decrementosRP;
    /** Valor de las Obligaciones */
    private BigDecimal valorObligaciones;
    /** Valor de las Notas de Cr&eacute;dito. */
    private BigDecimal valorNotasCredito;
    /** C&oacute;digo del RP */
    private Long rpCodigo;
    /** Consecutivo del RP */
    private Long rpConsecutivo;
    /** C&oacute;digo del RP Detalle Rubro CDP */
    private Long rdrCodigo;
    
    
    
    
    /**
     * Constructor.
     */
    public InfoDetalladaRubroVO() { }


    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setDescRubro(String descRubro) {
        this.descRubro = descRubro;
    }

    public String getDescRubro() {
        return descRubro;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setDruCodigo(Long druCodigo) {
        this.druCodigo = druCodigo;
    }

    public Long getDruCodigo() {
        return druCodigo;
    }

    public void setDruValor(Long druValor) {
        this.druValor = druValor;
    }

    public Long getDruValor() {
        return druValor;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    public Long getInterno() {
        return interno;
    }

    public void setDffCodigo(Long dffCodigo) {
        this.dffCodigo = dffCodigo;
    }

    public Long getDffCodigo() {
        return dffCodigo;
    }

    public void setFfiCodigo(Long ffiCodigo) {
        this.ffiCodigo = ffiCodigo;
    }

    public Long getFfiCodigo() {
        return ffiCodigo;
    }

    public void setFfiCodigoFuente(Integer ffiCodigoFuente) {
        this.ffiCodigoFuente = ffiCodigoFuente;
    }

    public Integer getFfiCodigoFuente() {
        return ffiCodigoFuente;
    }

    public void setFfiDescripcion(String ffiDescripcion) {
        this.ffiDescripcion = ffiDescripcion;
    }

    public String getFfiDescripcion() {
        return ffiDescripcion;
    }

    public void setFfcCodigo(String ffcCodigo) {
        this.ffcCodigo = ffcCodigo;
    }

    public String getFfcCodigo() {
        return ffcCodigo;
    }

    public void setFccNombre(String fccNombre) {
        this.fccNombre = fccNombre;
    }

    public String getFccNombre() {
        return fccNombre;
    }


    public void setDetalleRubroVo(DetalleRubroVO detalleRubroVo) {
        this.detalleRubroVo = detalleRubroVo;
    }

    public DetalleRubroVO getDetalleRubroVo() {
        return detalleRubroVo;
    }

    public void setCreditos(Long creditos) {
        this.creditos = creditos;
    }

    public Long getCreditos() {
        return creditos;
    }

    public void setContracreditos(Long contracreditos) {
        this.contracreditos = contracreditos;
    }

    public Long getContracreditos() {
        return contracreditos;
    }

    public void setAdiciones(Long adiciones) {
        this.adiciones = adiciones;
    }

    public Long getAdiciones() {
        return adiciones;
    }

    public void setReducciones(Long reducciones) {
        this.reducciones = reducciones;
    }

    public Long getReducciones() {
        return reducciones;
    }


    public void setOblConcRpDetRubCdpVo(OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) {
        this.oblConcRpDetRubCdpVo = oblConcRpDetRubCdpVo;
    }

    public OblConcRpDetRubCdpVO getOblConcRpDetRubCdpVo() {
        return oblConcRpDetRubCdpVo;
    }

    public void setNotaCredOblConcDetRubVo(NotaCredOblConcDetRubVO notaCredOblConcDetRubVo) {
        this.notaCredOblConcDetRubVo = notaCredOblConcDetRubVo;
    }

    public NotaCredOblConcDetRubVO getNotaCredOblConcDetRubVo() {
        return notaCredOblConcDetRubVo;
    }

    public void setValorNotasCredito(BigDecimal valorNotasCredito) {
        this.valorNotasCredito = valorNotasCredito;
    }

    public BigDecimal getValorNotasCredito() {
        return valorNotasCredito;
    }
    
    
    

    /**
     * Calcula el Saldo del Rubro.
     * @return valor + creditos - contracr&eacute;ditos + adiciones - reducciones.
     */
    public Long getSaldo() {
        Long saldo = 0L;
        if (druValor!=null) saldo += druValor;
        if (creditos!=null) saldo += creditos;
        if (contracreditos!=null) saldo -= contracreditos;
        if (adiciones!=null) saldo += adiciones;
        if (reducciones!=null) saldo -= reducciones;
        return (saldo);
    }
    
    
    /**
     * Obtiene el c&oacute;digo del RP a partir del OblConcRpDetRubCdpVO.
     * @return oblConcRpDetRubCdpVo->rpDetRubroCdpVo->rpVo->rpCodigo
     */
   /* public Long getRpCodigo() {
        return (oblConcRpDetRubCdpVo!=null && oblConcRpDetRubCdpVo.getRpDetRubroCdpVo()!=null && oblConcRpDetRubCdpVo.getRpDetRubroCdpVo().getRpVo()!=null ? oblConcRpDetRubCdpVo.getRpDetRubroCdpVo().getRpVo().getRpCodigo() : null);
    }*/
    
    
    /**
     * Obtiene el Consecutivo del RP a partir del OblConcRpDetRubCdpVO.
     * @return oblConcRpDetRubCdpVo->rpDetRubroCdpVo->rpVo->rpConsecutivo
     */
    /*public Long getRpConsecutivo() {
        return (oblConcRpDetRubCdpVo!=null && oblConcRpDetRubCdpVo.getRpDetRubroCdpVo()!=null && oblConcRpDetRubCdpVo.getRpDetRubroCdpVo().getRpVo()!=null ? oblConcRpDetRubCdpVo.getRpDetRubroCdpVo().getRpVo().getRpConsecutivo() : null);
    }*/
    
    
    /**
     * Obtiene el valor correspondiente a la Imputaci&oacute;n Presupuestal de la Obligaci&oacute;n.
     * @return ocrValoblConcRpDetRubCdpVo->ocrValor
     */
    public BigDecimal getValorImpPresup() {
        return (oblConcRpDetRubCdpVo!=null ? oblConcRpDetRubCdpVo.getOcrValor() : null);
    }
    
    
    /**
     * Obtiene el valor correspondiente a la Imputaci&oacute;n Presupuestal de la Nota de Cr&eacute;dito.
     * @return notaCredOblConcDetRubVo->ndrValor
     */
    public BigDecimal getValorNotaCredito() {
        BigDecimal valor = new BigDecimal(0);
        if (this.notaCredOblConcDetRubVo!=null && this.notaCredOblConcDetRubVo.getNdrValor()!=null)
            valor = this.notaCredOblConcDetRubVo.getNdrValor();
        return (valor);
    }
    
    
    public void setValorRP(BigDecimal valorRP) {
        this.valorRP = valorRP;
    }

    public BigDecimal getValorRP() {
        return valorRP;
    }
    


    public void setDecrementosRP(BigDecimal decrementosRP) {
        this.decrementosRP = decrementosRP;
    }

    public BigDecimal getDecrementosRP() {
        return decrementosRP;
    }

    public void setRpCodigo(Long rpCodigo) {
        this.rpCodigo = rpCodigo;
    }

    public Long getRpCodigo() {
        return rpCodigo;
    }

    public void setRpConsecutivo(Long rpConsecutivo) {
        this.rpConsecutivo = rpConsecutivo;
    }

    public Long getRpConsecutivo() {
        return rpConsecutivo;
    }

    public void setValorObligaciones(BigDecimal valorObligaciones) {
        this.valorObligaciones = valorObligaciones;
    }

    public BigDecimal getValorObligaciones() {
        return valorObligaciones;
    }

    public void setRdrCodigo(Long rdrCodigo) {
        this.rdrCodigo = rdrCodigo;
    }

    public Long getRdrCodigo() {
        return rdrCodigo;
    }

    public void setDffCodigoRecurso(Integer dffCodigoRecurso) {
        this.dffCodigoRecurso = dffCodigoRecurso;
    }

    public Integer getDffCodigoRecurso() {
        return dffCodigoRecurso;
    }

    public void setDffDescripcion(String dffDescripcion) {
        this.dffDescripcion = dffDescripcion;
    }

    public String getDffDescripcion() {
        return dffDescripcion;
    }

    public void setIncrementosRP(BigDecimal incrementosRP) {
        this.incrementosRP = incrementosRP;
    }

    public BigDecimal getIncrementosRP() {
        return incrementosRP;
    }

    
    
    /**
     * Obtiene el valor correspondiente al Saldo del RP.
     * @return
     */
    public BigDecimal getSaldoRP() {
        BigDecimal saldo = new BigDecimal(0);
        if (valorRP!=null) saldo = saldo.add(valorRP);
        if (incrementosRP!=null) saldo = saldo.add(incrementosRP);
        if (decrementosRP!=null) saldo = saldo.subtract(decrementosRP);
        if (valorObligaciones!=null) saldo = saldo.subtract(valorObligaciones);
        if (valorNotasCredito!=null) saldo = saldo.add(valorNotasCredito);
        return (saldo);
    }
}
