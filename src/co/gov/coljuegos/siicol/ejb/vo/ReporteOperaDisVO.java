package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.List;

public class ReporteOperaDisVO {
    private Long codConcepto;
    private BigDecimal totalConcepto;
    private String abreviaturaConcepto;
    private List<ReporteOperadorVO> listaDetalleOpera;
    
    public ReporteOperaDisVO() {
    }

    public void setCodConcepto(Long codConcepto) {
        this.codConcepto = codConcepto;
    }

    public Long getCodConcepto() {
        return codConcepto;
    }

    public void setTotalConcepto(BigDecimal totalConcepto) {
        this.totalConcepto = totalConcepto;
    }

    public BigDecimal getTotalConcepto() {
        return totalConcepto;
    }

    public void setListaDetalleOpera(List<ReporteOperadorVO> listaDetalleOpera) {
        this.listaDetalleOpera = listaDetalleOpera;
    }

    public List<ReporteOperadorVO> getListaDetalleOpera() {
        return listaDetalleOpera;
    }

    public void setAbreviaturaConcepto(String abreviaturaConcepto) {
        this.abreviaturaConcepto = abreviaturaConcepto;
    }

    public String getAbreviaturaConcepto() {
        return abreviaturaConcepto;
    }
}
