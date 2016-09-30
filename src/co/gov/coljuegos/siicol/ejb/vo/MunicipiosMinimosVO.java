package co.gov.coljuegos.siicol.ejb.vo;

import java.util.List;


public class MunicipiosMinimosVO {

    private String codigoMunicipio;
    private List<LocalesMinimosVO> localesMinimosVOs;

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public List<LocalesMinimosVO> getLocalesMinimosVOs() {
        return localesMinimosVOs;
    }

    public void setLocalesMinimosVOs(List<LocalesMinimosVO> localesMinimosVOs) {
        this.localesMinimosVOs = localesMinimosVOs;
    }
}
