package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.List;

public class RubroDetalleFuenteVO {
       
        private String detRubro;
        private BigDecimal valor;
        private String desFuente;
        private String dtlleFuente;
        private Long idRubro;
        private Long idDetalleFuente;
        private Long idDetalleRubro;
        private Long valorLong;
        private boolean check;
        private List<DistribucionPfcVO> listaDistribucionPfcVo;
    
    
    public RubroDetalleFuenteVO() {
      
    }

    public void setListaDistribucionPfcVo(List<DistribucionPfcVO> listaDistribucionPfcVo) {
        this.listaDistribucionPfcVo = listaDistribucionPfcVo;
    }

    public List<DistribucionPfcVO> getListaDistribucionPfcVo() {
        return listaDistribucionPfcVo;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    public void setValorLong(Long valorLong) {
        this.valor = new BigDecimal(valorLong);
    }

    public Long getValorLong() {
        return valor.longValue();
    }

    public void setDetRubro(String detRubro) {
        this.detRubro = detRubro;
    }

    public String getDetRubro() {
        return detRubro;
    }


    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setDesFuente(String desFuente) {
            this.desFuente = desFuente;
    }

    public String getDesFuente() {
        return desFuente;
    }

    public void setDtlleFuente(String dtlleFuente) {
        this.dtlleFuente = dtlleFuente;
    }

    public String getDtlleFuente() {
        return dtlleFuente;
    }


    public void setIdRubro(Long idRubro) {
        this.idRubro = idRubro;
    }

    public Long getIdRubro() {
        return idRubro;
    }

    public void setIdDetalleFuente(Long idDetalleFuente) {
        this.idDetalleFuente = idDetalleFuente;
    }

    public Long getIdDetalleFuente() {
        return idDetalleFuente;
    }

    public void setIdDetalleRubro(Long idDetalleRubro) {
        this.idDetalleRubro = idDetalleRubro;
    }

    public Long getIdDetalleRubro() {
        return idDetalleRubro;
    }
}


