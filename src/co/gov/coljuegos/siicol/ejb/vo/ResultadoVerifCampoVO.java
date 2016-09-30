package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoVerifCampo;

import java.util.List;

public class ResultadoVerifCampoVO {
    
    private Long rvcCodigo;
    private String rvcNombre;
    private List<DenuncOrdTraInfVerVO> listDenuncOrdTraInfVer;

    
    public ResultadoVerifCampoVO(SiiResultadoVerifCampo siiResultadoVerifCampo) {
        
        this.rvcCodigo = siiResultadoVerifCampo.getRvcCodigo();
        this.rvcNombre = siiResultadoVerifCampo.getRvcNombre();
    }
    
    public ResultadoVerifCampoVO() {
        
    }


    public void setRvcCodigo(Long rvcCodigo) {
        this.rvcCodigo = rvcCodigo;
    }

    public Long getRvcCodigo() {
        return rvcCodigo;
    }

    public void setRvcNombre(String rvcNombre) {
        this.rvcNombre = rvcNombre;
    }

    public String getRvcNombre() {
        return rvcNombre;
    }

    public void setListDenuncOrdTraInfVer(List<DenuncOrdTraInfVerVO> listDenuncOrdTraInfVer) {
        this.listDenuncOrdTraInfVer = listDenuncOrdTraInfVer;
    }

    public List<DenuncOrdTraInfVerVO> getListDenuncOrdTraInfVer() {
        return listDenuncOrdTraInfVer;
    }

}
