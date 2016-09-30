/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 21-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoRp;

import java.util.List;

public class EstadoRpVO {
    
    private String erpActivo;
    private Long erpCodigo;
    private String erpDescripcion;
    private String erpNombre;
    private List<RpVO> RpVoList;
    
    public EstadoRpVO(SiiEstadoRp siiEstadoRp) {
        this.erpActivo = siiEstadoRp.getErpActivo();
        this.erpCodigo = siiEstadoRp.getErpCodigo();
        this.erpDescripcion = siiEstadoRp.getErpDescripcion();
        this.erpNombre = siiEstadoRp.getErpNombre();
    }
    
    public EstadoRpVO() {
    }

    public void setErpActivo(String erpActivo) {
        this.erpActivo = erpActivo;
    }

    public String getErpActivo() {
        return erpActivo;
    }

    public void setErpCodigo(Long erpCodigo) {
        this.erpCodigo = erpCodigo;
    }

    public Long getErpCodigo() {
        return erpCodigo;
    }

    public void setErpDescripcion(String erpDescripcion) {
        this.erpDescripcion = erpDescripcion;
    }

    public String getErpDescripcion() {
        return erpDescripcion;
    }

    public void setErpNombre(String erpNombre) {
        this.erpNombre = erpNombre;
    }

    public String getErpNombre() {
        return erpNombre;
    }

    public void setRpVoList(List<RpVO> RpVoList) {
        this.RpVoList = RpVoList;
    }

    public List<RpVO> getRpVoList() {
        return RpVoList;
    }

}
