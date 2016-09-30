package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoVerifDenun;

import java.util.Date;
import java.util.List;


    public class ResultadoVerifDenunVO implements Comparable{
    
    
    private Long revCodigo;
    private String revNombre;
    private List<DenunciaVO> denunciaList;
    
    public ResultadoVerifDenunVO() {

    }
    
    public ResultadoVerifDenunVO(SiiResultadoVerifDenun siiResultadoVerifDenun) {
        this.revCodigo = siiResultadoVerifDenun.getRevCodigo();
        this.revNombre = siiResultadoVerifDenun.getRevNombre();
    }


    public Long getRevCodigo() {
        return revCodigo;
    }

    public void setRevCodigo(Long revCodigo) {
        this.revCodigo = revCodigo;
    }

    public String getRevNombre() {
        return revNombre;
    }

    public void setRevNombre(String revNombre) {
        this.revNombre = revNombre;
    }

    public List<DenunciaVO> getDenunciaList() {
        return denunciaList;
    }

    public void setDenunciaList(List<DenunciaVO> denunciaList) {
        this.denunciaList = denunciaList;
    }
    
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof ResultadoVerifDenunVO) {
            ResultadoVerifDenunVO ac = (ResultadoVerifDenunVO) o;
            if (ac!=null && this.revNombre!=null && ac.revNombre!=null)
                resultado = this.revNombre.compareTo(ac.revNombre);
        }
        return resultado;
    }

}
