package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaExigida;

import java.math.BigDecimal;

import java.util.List;

public class GarantiaExigidaVO {
    private String gexActivo;
    private Long gexCodigo;
    private String gexDescripcion;
    private BigDecimal gexMontoPorc;
    private Long gexMontoValor;
    private String gexVigenciaGar;
    private List<GarantiaPolizaVO> garantiaPolizaListVo;
    
    public GarantiaExigidaVO(){
        
    }
    
    public GarantiaExigidaVO(SiiGarantiaExigida garantia) {
        this.gexActivo = garantia.getGexActivo();
        this.gexCodigo = garantia.getGexCodigo();
        this.gexDescripcion = garantia.getGexDescripcion();
        this.gexMontoPorc = garantia.getGexMontoPorc();
        this.gexMontoValor = garantia.getGexMontoValor();
        this.gexVigenciaGar = garantia.getGexVigenciaGar();
        
    }

    public void setGexActivo(String gexActivo) {
        this.gexActivo = gexActivo;
    }

    public String getGexActivo() {
        return gexActivo;
    }

    public void setGexCodigo(Long gexCodigo) {
        this.gexCodigo = gexCodigo;
    }

    public Long getGexCodigo() {
        return gexCodigo;
    }

    public void setGexDescripcion(String gexDescripcion) {
        this.gexDescripcion = gexDescripcion;
    }

    public String getGexDescripcion() {
        return gexDescripcion;
    }

    public void setGexMontoPorc(BigDecimal gexMontoPorc) {
        this.gexMontoPorc = gexMontoPorc;
    }

    public BigDecimal getGexMontoPorc() {
        return gexMontoPorc;
    }

    public void setGexMontoValor(Long gexMontoValor) {
        this.gexMontoValor = gexMontoValor;
    }

    public Long getGexMontoValor() {
        return gexMontoValor;
    }

    public void setGexVigenciaGar(String gexVigenciaGar) {
        this.gexVigenciaGar = gexVigenciaGar;
    }

    public String getGexVigenciaGar() {
        return gexVigenciaGar;
    }

    public void setGarantiaPolizaListVo(List<GarantiaPolizaVO> garantiaPolizaListVo) {
        this.garantiaPolizaListVo = garantiaPolizaListVo;
    }

    public List<GarantiaPolizaVO> getGarantiaPolizaListVo() {
        return garantiaPolizaListVo;
    }
}
