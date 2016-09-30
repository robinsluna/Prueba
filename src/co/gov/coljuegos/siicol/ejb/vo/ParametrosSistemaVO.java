package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiParametrosSistema;

public class ParametrosSistemaVO {
    
    private String psiNombre;
    private String psiValor;
    
    public ParametrosSistemaVO() {
    }
    
    public ParametrosSistemaVO(SiiParametrosSistema siiParametrosSistema) {
        if (siiParametrosSistema!=null) {
            psiNombre = siiParametrosSistema.getPsiNombre();
            psiValor = siiParametrosSistema.getPsiValor();
        }
    }


    public void setPsiNombre(String psiNombre) {
        this.psiNombre = psiNombre;
    }

    public String getPsiNombre() {
        return psiNombre;
    }

    public void setPsiValor(String psiValor) {
        this.psiValor = psiValor;
    }

    public String getPsiValor() {
        return psiValor;
    }
}
