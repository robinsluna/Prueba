package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoEstablec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReferenciaPagoDecl;

import java.math.BigDecimal;

import java.util.List;

public class DetalleDeclaracionVO {
    
    private Long ddeCodigo;
    private BigDecimal ddeValorPagado;
    private BigDecimal ddeValorInter;
    private BigDecimal  ddeValorPagadoInter;
    private Long ddeBaseCalInt;
    private BigDecimal ddeValorDeclarado;
    private Long rpdCodigo;
    private DetalleRecaudoVO  detalleRecaudoVo;
    private CuotaOperadorVO cuotaOperadorVo;
    private DeclaracionOperadorVO declaracionOperadorVo;
    private ReferenciaPagoDeclVO referenciaPagoDeclVo;
    private DistribucionMesVO distribucionMesVo;
    
    public DetalleDeclaracionVO(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        this.ddeCodigo = siiDetalleDeclaracion.getDdeCodigo();
        this.ddeValorPagado = siiDetalleDeclaracion.getDdeValorPagado();
        this.ddeValorInter = siiDetalleDeclaracion.getDdeValorInter();
        this.ddeBaseCalInt = siiDetalleDeclaracion.getDdeBaseCalcInt();
        this.ddeValorDeclarado = siiDetalleDeclaracion.getDdeValorDeclarado();
        if(siiDetalleDeclaracion.getSiiDistribucionMes()!= null){
            this.distribucionMesVo = new DistribucionMesVO(siiDetalleDeclaracion.getSiiDistribucionMes());
        }
    }  
    
    public DetalleDeclaracionVO() {
    
    }
    
    

    public void setDdeCodigo(Long ddeCodigo) {
        this.ddeCodigo = ddeCodigo;
    }

    public Long getDdeCodigo() {
        return ddeCodigo;
    }

    public void setCuotaOperadorVo(CuotaOperadorVO cuotaOperadorVo) {
        this.cuotaOperadorVo = cuotaOperadorVo;
    }

    public CuotaOperadorVO getCuotaOperadorVo() {
        return cuotaOperadorVo;
    }

    public void setDdeValorPagado(BigDecimal ddeValorPagado) {
        this.ddeValorPagado = ddeValorPagado;
    }

    public BigDecimal getDdeValorPagado() {
        return ddeValorPagado;
    }

    public void setDdeValorInter(BigDecimal ddeValorInter) {
        this.ddeValorInter = ddeValorInter;
    }

    public BigDecimal getDdeValorInter() {
        return ddeValorInter;
    }

    public void setDdeValorPagadoInter(BigDecimal ddeValorPagadoInter) {
        this.ddeValorPagadoInter = ddeValorPagadoInter;
    }

    public BigDecimal getDdeValorPagadoInter() {
        return ddeValorPagadoInter;
    }

    public void setDdeBaseCalInt(Long ddeBaseCalInt) {
        this.ddeBaseCalInt = ddeBaseCalInt;
    }

    public Long getDdeBaseCalInt() {
        return ddeBaseCalInt;
    }

    public void setDdeValorDeclarado(BigDecimal ddeValorDeclarado) {
        this.ddeValorDeclarado = ddeValorDeclarado;
    }

    public BigDecimal getDdeValorDeclarado() {
        return ddeValorDeclarado;
    }

    public void setRpdCodigo(Long rpdCodigo) {
        this.rpdCodigo = rpdCodigo;
    }

    public Long getRpdCodigo() {
        return rpdCodigo;
    }

    public void setDetalleRecaudoVo(DetalleRecaudoVO detalleRecaudoVo) {
        this.detalleRecaudoVo = detalleRecaudoVo;
    }

    public DetalleRecaudoVO getDetalleRecaudoVo() {
        return detalleRecaudoVo;
    }

    public void setDistribucionMesVo(DistribucionMesVO distribucionMesVo) {
        this.distribucionMesVo = distribucionMesVo;
    }

    public DistribucionMesVO getDistribucionMesVo() {
        return distribucionMesVo;
    }

}
