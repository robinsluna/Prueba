package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracionSug;

import java.math.BigDecimal;

public class DetalleDeclaracionSugVO implements Comparable {
    
    private Long ddsCodigo;
    private BigDecimal ddsValor;
    private BigDecimal ddsValorInteres;
    private CuotaOperadorVO cuotaOperadorVo;
    private DeclaracionSugeridaVO declaracionSugeridaVo;
    private BigDecimal porcentajePago;
    
    
    public DetalleDeclaracionSugVO() {
    }
    
    public DetalleDeclaracionSugVO(SiiDetalleDeclaracionSug siiDetalleDeclaracionSug) {
        this.ddsCodigo = siiDetalleDeclaracionSug.getDdsCodigo();
        this.ddsValor = siiDetalleDeclaracionSug.getDdsValor();
        this.ddsValorInteres = siiDetalleDeclaracionSug.getDdsValorInteres();
        if(siiDetalleDeclaracionSug.getSiiCuotaOperador() != null){
            this.cuotaOperadorVo = new CuotaOperadorVO(siiDetalleDeclaracionSug.getSiiCuotaOperador());
        }
        if(siiDetalleDeclaracionSug.getSiiDeclaracionSugerida() != null){
            this.declaracionSugeridaVo = new DeclaracionSugeridaVO(siiDetalleDeclaracionSug.getSiiDeclaracionSugerida());
        }
    }


    public void setDdsCodigo(Long ddsCodigo) {
        this.ddsCodigo = ddsCodigo;
    }

    public Long getDdsCodigo() {
        return ddsCodigo;
    }

    public void setDdsValor(BigDecimal ddsValor) {
        this.ddsValor = ddsValor;
    }

    public BigDecimal getDdsValor() {
        return ddsValor;
    }

    public void setDdsValorInteres(BigDecimal ddsValorInteres) {
        this.ddsValorInteres = ddsValorInteres;
    }

    public BigDecimal getDdsValorInteres() {
        return ddsValorInteres;
    }

    public void setCuotaOperadorVo(CuotaOperadorVO cuotaOperadorVo) {
        this.cuotaOperadorVo = cuotaOperadorVo;
    }

    public CuotaOperadorVO getCuotaOperadorVo() {
        return cuotaOperadorVo;
    }

    public void setDeclaracionSugeridaVo(DeclaracionSugeridaVO declaracionSugeridaVo) {
        this.declaracionSugeridaVo = declaracionSugeridaVo;
    }

    public DeclaracionSugeridaVO getDeclaracionSugeridaVo() {
        return declaracionSugeridaVo;
    }

    public void setPorcentajePago(BigDecimal porcentajePago) {
        this.porcentajePago = porcentajePago;
    }

    public BigDecimal getPorcentajePago() {
        return porcentajePago;
    }
    
    
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (ddsValor!=null && o!=null && o instanceof DetalleDeclaracionSugVO) {
            DetalleDeclaracionSugVO ddsVo = (DetalleDeclaracionSugVO) o;
            resultado = ddsValor.compareTo(ddsVo.ddsValor);
        }
        return resultado;
    }
}
