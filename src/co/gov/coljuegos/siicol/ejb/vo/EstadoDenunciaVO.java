package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDenuncia;

import java.util.Date;
import java.util.List;


public class EstadoDenunciaVO {

    private Long ednCodigo;
    private String ednNombre;
    private List<DenunciaVO> denunciaList;

    public EstadoDenunciaVO() {

    }
    
    public EstadoDenunciaVO(SiiEstadoDenuncia siiEstadoDenuncia) {
        
        this.ednCodigo = siiEstadoDenuncia.getEdnCodigo();
        this.ednNombre = siiEstadoDenuncia.getEdnNombre();
    }


    public Long getEdnCodigo() {
        return ednCodigo;
    }

    public void setEdnCodigo(Long ednCodigo) {
        this.ednCodigo = ednCodigo;
    }

    public String getEdnNombre() {
        return ednNombre;
    }

    public void setEdnNombre(String ednNombre) {
        this.ednNombre = ednNombre;
    }

    public List<DenunciaVO> getDenunciaList() {
        return denunciaList;
    }

    public void setDenunciaList(List<DenunciaVO> denunciaList) {
        this.denunciaList = denunciaList;
    }
}
