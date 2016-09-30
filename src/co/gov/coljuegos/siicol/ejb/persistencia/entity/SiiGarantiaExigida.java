package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_GARANTIA_EXIGIDA")
public class SiiGarantiaExigida implements Serializable {
    private static final long serialVersionUID = -7319111048506350287L;
    private String gexActivo;
    private Long gexCodigo;
    private String gexDescripcion;
    private BigDecimal gexMontoPorc;
    private Long gexMontoValor;
    private String gexVigenciaGar;
    private List<SiiGarantiaPoliza> siiGarantiaPolizaList;
    private List<SiiGarantPolizaOficLiq> siiGarantPolizaOficLiqList;

    public SiiGarantiaExigida() {
    }

    public SiiGarantiaExigida(String gexActivo, Long gexCodigo, String gexDescripcion, BigDecimal gexMontoPorc,
                              Long gexMontoValor, String gexVigenciaGar) {
        this.gexActivo = gexActivo;
        this.gexCodigo = gexCodigo;
        this.gexDescripcion = gexDescripcion;
        this.gexMontoPorc = gexMontoPorc;
        this.gexMontoValor = gexMontoValor;
        this.gexVigenciaGar = gexVigenciaGar;
    }

    @Column(name = "GEX_ACTIVO", nullable = false, length = 1)
    public String getGexActivo() {
        return gexActivo;
    }

    public void setGexActivo(String gexActivo) {
        this.gexActivo = gexActivo;
    }

    @Id
    @Column(name = "GEX_CODIGO", nullable = false)
    public Long getGexCodigo() {
        return gexCodigo;
    }

    public void setGexCodigo(Long gexCodigo) {
        this.gexCodigo = gexCodigo;
    }

    @Column(name = "GEX_DESCRIPCION", nullable = false, length = 50)
    public String getGexDescripcion() {
        return gexDescripcion;
    }

    public void setGexDescripcion(String gexDescripcion) {
        this.gexDescripcion = gexDescripcion;
    }

    @Column(name = "GEX_MONTO_PORC", nullable = false)
    public BigDecimal getGexMontoPorc() {
        return gexMontoPorc;
    }

    public void setGexMontoPorc(BigDecimal gexMontoPorc) {
        this.gexMontoPorc = gexMontoPorc;
    }

    @Column(name = "GEX_MONTO_VALOR", nullable = false)
    public Long getGexMontoValor() {
        return gexMontoValor;
    }

    public void setGexMontoValor(Long gexMontoValor) {
        this.gexMontoValor = gexMontoValor;
    }

    @Column(name = "GEX_VIGENCIA_GAR", nullable = false, length = 20)
    public String getGexVigenciaGar() {
        return gexVigenciaGar;
    }

    public void setGexVigenciaGar(String gexVigenciaGar) {
        this.gexVigenciaGar = gexVigenciaGar;
    }

    @OneToMany(mappedBy = "siiGarantiaExigida")
    public List<SiiGarantiaPoliza> getSiiGarantiaPolizaList() {
        return siiGarantiaPolizaList;
    }

    public void setSiiGarantiaPolizaList(List<SiiGarantiaPoliza> siiGarantiaPolizaList) {
        this.siiGarantiaPolizaList = siiGarantiaPolizaList;
    }

    public SiiGarantiaPoliza addSiiGarantiaPoliza(SiiGarantiaPoliza siiGarantiaPoliza) {
        getSiiGarantiaPolizaList().add(siiGarantiaPoliza);
        siiGarantiaPoliza.setSiiGarantiaExigida(this);
        return siiGarantiaPoliza;
    }

    public SiiGarantiaPoliza removeSiiGarantiaPoliza(SiiGarantiaPoliza siiGarantiaPoliza) {
        getSiiGarantiaPolizaList().remove(siiGarantiaPoliza);
        siiGarantiaPoliza.setSiiGarantiaExigida(null);
        return siiGarantiaPoliza;
    }

    @OneToMany(mappedBy = "siiGarantiaExigida")
    public List<SiiGarantPolizaOficLiq> getSiiGarantPolizaOficLiqList() {
        return siiGarantPolizaOficLiqList;
    }

    public void setSiiGarantPolizaOficLiqList(List<SiiGarantPolizaOficLiq> siiGarantPolizaOficLiqList) {
        this.siiGarantPolizaOficLiqList = siiGarantPolizaOficLiqList;
    }

    public SiiGarantPolizaOficLiq addSiiGarantPolizaOficLiq(SiiGarantPolizaOficLiq siiGarantPolizaOficLiq) {
        getSiiGarantPolizaOficLiqList().add(siiGarantPolizaOficLiq);
        siiGarantPolizaOficLiq.setSiiGarantiaExigida(this);
        return siiGarantPolizaOficLiq;
    }

    public SiiGarantPolizaOficLiq removeSiiGarantPolizaOficLiq(SiiGarantPolizaOficLiq siiGarantPolizaOficLiq) {
        getSiiGarantPolizaOficLiqList().remove(siiGarantPolizaOficLiq);
        siiGarantPolizaOficLiq.setSiiGarantiaExigida(null);
        return siiGarantPolizaOficLiq;
    }
}
