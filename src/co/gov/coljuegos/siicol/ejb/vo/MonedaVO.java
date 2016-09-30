package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMoneda;

import java.util.ArrayList;
import java.util.List;

/**
 * author Giovanni
 */
public class MonedaVO {
    
    private String monAbreviatura;
    private Long monCodigo;
    private String monNombre;
    private List<DetalleFinancVO> detalleFinancVOs;
    
    public MonedaVO() {
        this.detalleFinancVOs = new ArrayList<DetalleFinancVO>();
    }
    
    public MonedaVO(SiiMoneda siiMoneda) {
        this.monAbreviatura = siiMoneda.getMonAbreviatura();
        this.monCodigo = siiMoneda.getMonCodigo();
        this.monNombre = siiMoneda.getMonNombre();
                
        this.detalleFinancVOs = new ArrayList<DetalleFinancVO>();
    }

    public String getMonAbreviatura() {
        return monAbreviatura;
    }

    public void setMonAbreviatura(String monAbreviatura) {
        this.monAbreviatura = monAbreviatura;
    }

    public Long getMonCodigo() {
        return monCodigo;
    }

    public void setMonCodigo(Long monCodigo) {
        this.monCodigo = monCodigo;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public List<DetalleFinancVO> getDetalleFinancVOs() {
        return detalleFinancVOs;
    }

    public void setDetalleFinancVOs(List<DetalleFinancVO> detalleFinancVOs) {
        this.detalleFinancVOs = detalleFinancVOs;
    }
}
