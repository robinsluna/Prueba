package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSoporteModif;

import java.util.List;

public class TipoDocSoporteModifVO {
    private Long tdmCodigo;
    private String tdmNombre;
    private List<DocumSoporModifVO> documSoporModifListVo;
    
    public TipoDocSoporteModifVO() {
        
    }
    public TipoDocSoporteModifVO(SiiTipoDocSoporteModif t) {
        this.tdmCodigo = t.getTdmCodigo();
        this.tdmNombre = t.getTdmNombre();
        
    }

    public void setTdmCodigo(Long tdmCodigo) {
        this.tdmCodigo = tdmCodigo;
    }

    public Long getTdmCodigo() {
        return tdmCodigo;
    }

    public void setTdmNombre(String tdmNombre) {
        this.tdmNombre = tdmNombre;
    }

    public String getTdmNombre() {
        return tdmNombre;
    }

    public void setDocumSoporModifListVo(List<DocumSoporModifVO> documSoporModifListVo) {
        this.documSoporModifListVo = documSoporModifListVo;
    }

    public List<DocumSoporModifVO> getDocumSoporModifListVo() {
        return documSoporModifListVo;
    }
}
