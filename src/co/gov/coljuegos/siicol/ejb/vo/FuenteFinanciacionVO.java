/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 27-09-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;

import java.util.List;

public class FuenteFinanciacionVO {

    private Long ffiCodigo;
    private String ffiDescripcion;
    private String ffiNombre;

    private Integer ffiCodigoFuente;
    //private List<SiiDtlleFuenteFinanciacion> siiDtlleFuenteFinanciacionList;
    private List<DetFuenteFinanciacionVO> detFuenteFinanciacionVoList;

    public FuenteFinanciacionVO(SiiFuenteFinanciacion siiFuenteFinanciacion) {
        this.ffiCodigo = siiFuenteFinanciacion.getFfiCodigo();
        this.ffiCodigoFuente = siiFuenteFinanciacion.getFfiCodigoFuente();
        this.ffiDescripcion = siiFuenteFinanciacion.getFfiDescripcion();
        this.ffiNombre = siiFuenteFinanciacion.getFfiNombre();
    }

    public FuenteFinanciacionVO() {
    }

    public void setFficodigo(Long ffiCodigo) {
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

    public void setFfidescripcion(String ffiDescripcion) {//TODO mal deletreado
        this.ffiDescripcion = ffiDescripcion;
    }

    public String getFfidescripcion() {//TODO mal deletreado
        return ffiDescripcion;
    }

    public void setFfiDescripcion(String ffiDescripcion) {
        this.ffiDescripcion = ffiDescripcion;
    }

    public String getFfiDescripcion() {
        return ffiDescripcion;
    }

    public void setFfiNombre(String ffiNombre) {
        this.ffiNombre = ffiNombre;
    }

    public String getFfiNombre() {
        return ffiNombre;
    }

    public void setDetFuenteFinanciacionVoList(List<DetFuenteFinanciacionVO> detFuenteFinanciacionVoList) {
        this.detFuenteFinanciacionVoList = detFuenteFinanciacionVoList;
    }

    public List<DetFuenteFinanciacionVO> getDetFuenteFinanciacionVoList() {
        return detFuenteFinanciacionVoList;
    }


}
