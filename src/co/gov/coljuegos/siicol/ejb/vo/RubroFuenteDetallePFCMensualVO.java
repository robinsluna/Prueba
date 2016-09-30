/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Walter becerra
 * FECHA	: 03-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.List;

public class RubroFuenteDetallePFCMensualVO {
    
    private String ffiNombre;
    private String dffDescripcion;
    private String cadena;
    private BigDecimal dpfValorPFCAnual;
    private BigDecimal dpfValorPFCMensual;
    private Integer mes;
    private String vigencia;
    private Long codigoObligacion;
    private Long codigoDistribucion;
    private Long codigoDetalleRubro;
    private BigDecimal dpfValorAnticipo;
    private BigDecimal dpfValoraplazamiento;
    private List<ModificPfcAnualVO> modificPfcAnualVoList;
    private List<ModificPfcAnualVO> insertarModificPfcAnualVoList;// se usan al actualizar
    private List<ModificPfcAnualVO> BorrarModificPfcAnualVoList;// se usan al actualizar
   
    
    
    
    public RubroFuenteDetallePFCMensualVO() {

    }


    public void setInsertarModificPfcAnualVoList(List<ModificPfcAnualVO> insertarModificPfcAnualVoList) {
        this.insertarModificPfcAnualVoList = insertarModificPfcAnualVoList;
    }

    public List<ModificPfcAnualVO> getInsertarModificPfcAnualVoList() {
        return insertarModificPfcAnualVoList;
    }

    public void setBorrarModificPfcAnualVoList(List<ModificPfcAnualVO> BorrarModificPfcAnualVoList) {
        this.BorrarModificPfcAnualVoList = BorrarModificPfcAnualVoList;
    }

    public List<ModificPfcAnualVO> getBorrarModificPfcAnualVoList() {
        return BorrarModificPfcAnualVoList;
    }

    public void setModificPfcAnualVoList(List<ModificPfcAnualVO> modificPfcAnualVoList) {
        this.modificPfcAnualVoList = modificPfcAnualVoList;
    }

    public List<ModificPfcAnualVO> getModificPfcAnualVoList() {
        return modificPfcAnualVoList;
    }

    public void setCodigoDetalleRubro(Long codigoDetalleRubro) {
        this.codigoDetalleRubro = codigoDetalleRubro;
    }

    public Long getCodigoDetalleRubro() {
        return codigoDetalleRubro;
    }

    public void setDpfValorAnticipo(BigDecimal dpfValorAnticipo) {
        this.dpfValorAnticipo = dpfValorAnticipo;
    }

    public BigDecimal getDpfValorAnticipo() {
        return dpfValorAnticipo;
    }

    public void setDpfValoraplazamiento(BigDecimal dpfValoraplazamiento) {
        this.dpfValoraplazamiento = dpfValoraplazamiento;
    }

    public BigDecimal getDpfValoraplazamiento() {
        return dpfValoraplazamiento;
    }

    public void setCodigoObligacion(Long codigoObligacion) {
        this.codigoObligacion = codigoObligacion;
    }

    public Long getCodigoObligacion() {
        return codigoObligacion;
    }


    public void setCodigoDistribucion(Long codigoDistribucion) {
        this.codigoDistribucion = codigoDistribucion;
    }

    public Long getCodigoDistribucion() {
        return codigoDistribucion;
    }


    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getMes() {
        return mes;
    }


    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setFfiNombre(String ffiNombre) {
        this.ffiNombre = ffiNombre;
    }

    public String getFfiNombre() {
        return ffiNombre;
    }

    public void setDffDescripcion(String dffDescripcion) {
        this.dffDescripcion = dffDescripcion;
    }

    public String getDffDescripcion() {
        return dffDescripcion;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }


    public void setDpfValorPFCAnual(BigDecimal dpfValorPFCAnual) {
        this.dpfValorPFCAnual = dpfValorPFCAnual;
    }

    public BigDecimal getDpfValorPFCAnual() {
        return dpfValorPFCAnual;
    }

    public void setDpfValorPFCMensual(BigDecimal dpfValorPFCMensual) {
        this.dpfValorPFCMensual = dpfValorPFCMensual;
    }

    public BigDecimal getDpfValorPFCMensual() {
        return dpfValorPFCMensual;
    }


}
