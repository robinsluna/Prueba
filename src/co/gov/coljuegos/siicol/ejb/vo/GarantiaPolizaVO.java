package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaPoliza;

import java.math.BigDecimal;

import java.util.Date;

public class GarantiaPolizaVO {
    private Long gpoCodigo;
    private BigDecimal gpoValorAsegurado;
    private Date gpoVigenciaDesde;
    private Date gpoVigenciaHasta;
    private GarantiaExigidaVO garantiaExigidaVo;
    private PolizaContratVO polizaContratVo;
    private BigDecimal gpoMontoValor;
    private Date gpoAntVigenciaDesde;
    private Date gpoAntVigenciaHasta;
    private BigDecimal gpoAntValAsegurado;
    
    public GarantiaPolizaVO () {
        
    }
    
    public GarantiaPolizaVO(SiiGarantiaPoliza garantia) {
        this.gpoValorAsegurado = garantia.getGpoValorAsegurado();
        this.gpoCodigo = garantia.getGpoCodigo();
        this.gpoVigenciaDesde = garantia.getGpoVigenciaDesde();
        this.gpoVigenciaHasta = garantia.getGpoVigenciaHasta();
        this.gpoMontoValor = garantia.getGpoMontoValor();
        this.gpoAntVigenciaDesde = garantia.getGpoAntVigenciaDesde();
        this.gpoAntVigenciaHasta = garantia.getGpoAntVigenciaHasta();
        this.gpoAntValAsegurado = garantia.getGpoAntValAsegurado();
        //Padres:
        this.garantiaExigidaVo = new GarantiaExigidaVO(garantia.getSiiGarantiaExigida());
        this.polizaContratVo = new PolizaContratVO(garantia.getSiiPolizaContrat());
    }

    public void setGpoCodigo(Long gpoCodigo) {
        this.gpoCodigo = gpoCodigo;
    }

    public Long getGpoCodigo() {
        return gpoCodigo;
    }

    public void setGpoValorAsegurado(BigDecimal gpoValorAsegurado) {
        this.gpoValorAsegurado = gpoValorAsegurado;
    }

    public BigDecimal getGpoValorAsegurado() {
        return gpoValorAsegurado;
    }

    public void setGpoVigenciaDesde(Date gpoVigenciaDesde) {
        this.gpoVigenciaDesde = gpoVigenciaDesde;
    }

    public Date getGpoVigenciaDesde() {
        return gpoVigenciaDesde;
    }

    public void setGpoVigenciaHasta(Date gpoVigenciaHasta) {
        this.gpoVigenciaHasta = gpoVigenciaHasta;
    }

    public Date getGpoVigenciaHasta() {
        return gpoVigenciaHasta;
    }

    public void setGarantiaExigidaVo(GarantiaExigidaVO garantiaExigidaVo) {
        this.garantiaExigidaVo = garantiaExigidaVo;
    }

    public GarantiaExigidaVO getGarantiaExigidaVo() {
        return garantiaExigidaVo;
    }

    public void setPolizaContratVo(PolizaContratVO polizaContratVo) {
        this.polizaContratVo = polizaContratVo;
    }

    public PolizaContratVO getPolizaContratVo() {
        return polizaContratVo;
    }

    public void setGpoMontoValor(BigDecimal gpoMontoValor) {
        this.gpoMontoValor = gpoMontoValor;
    }

    public BigDecimal getGpoMontoValor() {
        return gpoMontoValor;
    }

    public void setGpoAntVigenciaDesde(Date gpoAntVigenciaDesde) {
        this.gpoAntVigenciaDesde = gpoAntVigenciaDesde;
    }

    public Date getGpoAntVigenciaDesde() {
        return gpoAntVigenciaDesde;
    }

    public void setGpoAntVigenciaHasta(Date gpoAntVigenciaHasta) {
        this.gpoAntVigenciaHasta = gpoAntVigenciaHasta;
    }

    public Date getGpoAntVigenciaHasta() {
        return gpoAntVigenciaHasta;
    }

    public void setGpoAntValAsegurado(BigDecimal gpoAntValAsegurado) {
        this.gpoAntValAsegurado = gpoAntValAsegurado;
    }

    public BigDecimal getGpoAntValAsegurado() {
        return gpoAntValAsegurado;
    }
}
