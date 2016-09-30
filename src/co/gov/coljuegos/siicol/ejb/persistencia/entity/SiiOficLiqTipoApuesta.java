package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_OFIC_LIQ_TIPO_APUESTA")
public class SiiOficLiqTipoApuesta implements Serializable {
    private static final long serialVersionUID = -1416017053216631154L;
    private Long otaCodigo;
    private BigDecimal otaDerExplMes;
    private BigDecimal otaGasAdmin;
    private Integer otaNumElem;
    private SiiOficioLiquidacion siiOficioLiquidacion;
    private SiiTipoApuesta siiTipoApuesta;
    private BigDecimal otaValorUnidad;
    private String otaIndicadorLiq;

    public SiiOficLiqTipoApuesta() {
    }

    public SiiOficLiqTipoApuesta(SiiOficioLiquidacion siiOficioLiquidacion, Long otaCodigo, BigDecimal otaDerExplMes,
                                 BigDecimal otaGasAdmin, Integer otaNumElem, SiiTipoApuesta siiTipoApuesta) {
        this.siiOficioLiquidacion = siiOficioLiquidacion;
        this.otaCodigo = otaCodigo;
        this.otaDerExplMes = otaDerExplMes;
        this.otaGasAdmin = otaGasAdmin;
        this.otaNumElem = otaNumElem;
        this.siiTipoApuesta = siiTipoApuesta;
    }


    @Id
    @Column(name = "OTA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OFIC_LIQ_TIPO_AP_COD")
    @SequenceGenerator(name = "SEQ_OFIC_LIQ_TIPO_AP_COD", sequenceName = "SEQ_OFIC_LIQ_TIPO_AP_COD",allocationSize=1)
    public Long getOtaCodigo() {
        return otaCodigo;
    }

    public void setOtaCodigo(Long otaCodigo) {
        this.otaCodigo = otaCodigo;
    }

    @Column(name = "OTA_DER_EXPL_MES", nullable = false)
    public BigDecimal getOtaDerExplMes() {
        return otaDerExplMes;
    }

    public void setOtaDerExplMes(BigDecimal otaDerExplMes) {
        this.otaDerExplMes = otaDerExplMes;
    }

    @Column(name = "OTA_GAS_ADMIN", nullable = false)
    public BigDecimal getOtaGasAdmin() {
        return otaGasAdmin;
    }

    public void setOtaGasAdmin(BigDecimal otaGasAdmin) {
        this.otaGasAdmin = otaGasAdmin;
    }

    @Column(name = "OTA_NUM_ELEM", nullable = false)
    public Integer getOtaNumElem() {
        return otaNumElem;
    }

    public void setOtaNumElem(Integer otaNumElem) {
        this.otaNumElem = otaNumElem;
    }


    @ManyToOne
    @JoinColumn(name = "OLI_CODIGO")
    public SiiOficioLiquidacion getSiiOficioLiquidacion() {
        return siiOficioLiquidacion;
    }

    public void setSiiOficioLiquidacion(SiiOficioLiquidacion siiOficioLiquidacion) {
        this.siiOficioLiquidacion = siiOficioLiquidacion;
    }

    @ManyToOne
    @JoinColumn(name = "TAP_CODIGO")
    public SiiTipoApuesta getSiiTipoApuesta() {
        return siiTipoApuesta;
    }

    public void setSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        this.siiTipoApuesta = siiTipoApuesta;
    }

    @Column(name = "OTA_VALOR_UNIDAD")
    public BigDecimal getOtaValorUnidad() {
        return otaValorUnidad;
    }

    public void setOtaValorUnidad(BigDecimal otaValorUnidad) {
        this.otaValorUnidad = otaValorUnidad;
    }

    @Column(name = "OTA_INDICADOR_LIQ", length = 1)
    public String getOtaIndicadorLiq() {
        return otaIndicadorLiq;
    }
    
    public void setOtaIndicadorLiq(String otaIndicadorLiq) {
        this.otaIndicadorLiq = otaIndicadorLiq;
    }
}
