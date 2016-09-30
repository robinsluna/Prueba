package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.List;

public class ReporteMunicipioDisVO {
    private String depto;
    private BigDecimal totalDepto;
    private List<ReporteOperadorVO> listaDetalleMuni;
    private String codDepto;
    
    
    public ReporteMunicipioDisVO() {
       
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getDepto() {
        return depto;
    }

    public void setTotalDepto(BigDecimal totalDepto) {
        this.totalDepto = totalDepto;
    }

    public BigDecimal getTotalDepto() {
        return totalDepto;
    }

    public void setListaDetalleMuni(List<ReporteOperadorVO> listaDetalleMuni) {
        this.listaDetalleMuni = listaDetalleMuni;
    }

    public List<ReporteOperadorVO> getListaDetalleMuni() {
        return listaDetalleMuni;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodDepto() {
        return codDepto;
    }

   
}
