/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 13-031-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class RecaudoEnteVO {
    private BigDecimal totalRecaudo;
    private String ubicacion;
    private BigDecimal poblacion;
    private String distribucion;    
    private String tipoConceptoCuota; 
    private Long conceptoCuota;
    private Long ddeCodigo;
    
    public RecaudoEnteVO() {        
    }

    public void setTotalRecaudo(BigDecimal totalRecaudo) {
        this.totalRecaudo = totalRecaudo;
    }

    public BigDecimal getTotalRecaudo() {
        return totalRecaudo;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setPoblacion(BigDecimal poblacion) {
        this.poblacion = poblacion;
    }

    public BigDecimal getPoblacion() {
        return poblacion;
    }

    public void setDistribucion(String distribucion) {
        this.distribucion = distribucion;
    }

    public String getDistribucion() {
        return distribucion;
    }

    public void setTipoConceptoCuota(String tipoConceptoCuota) {
        this.tipoConceptoCuota = tipoConceptoCuota;
    }

    public String getTipoConceptoCuota() {
        return tipoConceptoCuota;
    }

    public void setConceptoCuota(Long conceptoCuota) {
        this.conceptoCuota = conceptoCuota;
    }

    public Long getConceptoCuota() {
        return conceptoCuota;
    }

    public void setDdeCodigo(Long ddeCodigo) {
        this.ddeCodigo = ddeCodigo;
    }

    public Long getDdeCodigo() {
        return ddeCodigo;
    }

}
