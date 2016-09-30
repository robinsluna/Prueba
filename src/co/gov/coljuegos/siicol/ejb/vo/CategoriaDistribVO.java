package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCategoriaDistrib;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDistrib;

import java.util.List;

public class CategoriaDistribVO {
    
    private Long cadCodigo;
    private String cadNombre;
    private List<DetalleDistribVO> detalleDistribListVo;
    
    public CategoriaDistribVO(SiiCategoriaDistrib siiCategoriaDistrib) {
        this.cadCodigo = siiCategoriaDistrib.getCadCodigo();
        this.cadNombre = siiCategoriaDistrib.getCadNombre();
    }
    public CategoriaDistribVO(){
    }

    public void setCadCodigo(Long cadCodigo) {
        this.cadCodigo = cadCodigo;
    }

    public Long getCadCodigo() {
        return cadCodigo;
    }

    public void setCadNombre(String cadNombre) {
        this.cadNombre = cadNombre;
    }

    public String getCadNombre() {
        return cadNombre;
    }

    public void setDetalleDistribListVo(List<DetalleDistribVO> detalleDistribListVo) {
        this.detalleDistribListVo = detalleDistribListVo;
    }

    public List<DetalleDistribVO> getDetalleDistribListVo() {
        return detalleDistribListVo;
    }
}
