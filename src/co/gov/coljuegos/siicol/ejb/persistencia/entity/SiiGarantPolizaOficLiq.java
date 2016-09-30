package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_GARANT_POLIZA_OFIC_LIQ")
public class SiiGarantPolizaOficLiq implements Serializable {
    private static final long serialVersionUID = 1633788112706737795L;
    private Long golCodigo;
    private String golDescripcion;
    private BigDecimal golValorAmparo;
    private SiiOficioLiquidacion siiOficioLiquidacion;
    private SiiGarantiaExigida siiGarantiaExigida;

    public SiiGarantPolizaOficLiq() {
    }

    public SiiGarantPolizaOficLiq(Long golCodigo, String golDescripcion, BigDecimal golValorAmparo,
                                  SiiOficioLiquidacion siiOficioLiquidacion) {
        this.golCodigo = golCodigo;
        this.golDescripcion = golDescripcion;
        this.golValorAmparo = golValorAmparo;
        this.siiOficioLiquidacion = siiOficioLiquidacion;
    }

    @Id
    @Column(name = "GOL_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GARANT_POLIZA_OFIC_LIQ")
    @SequenceGenerator(name = "SEQ_GARANT_POLIZA_OFIC_LIQ", sequenceName = "SEQ_GARANT_POLIZA_OFIC_LIQ",allocationSize=1)
    public Long getGolCodigo() {
        return golCodigo;
    }

    public void setGolCodigo(Long golCodigo) {
        this.golCodigo = golCodigo;
    }

    @Column(name = "GOL_DESCRIPCION", nullable = false, length = 200)
    public String getGolDescripcion() {
        return golDescripcion;
    }

    public void setGolDescripcion(String golDescripcion) {
        this.golDescripcion = golDescripcion;
    }

    @Column(name = "GOL_VALOR_AMPARO", nullable = false)
    public BigDecimal getGolValorAmparo() {
        return golValorAmparo;
    }

    public void setGolValorAmparo(BigDecimal golValorAmparo) {
        this.golValorAmparo = golValorAmparo;
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
    @JoinColumn(name = "GEX_CODIGO")
    public SiiGarantiaExigida getSiiGarantiaExigida() {
        return siiGarantiaExigida;
    }

    public void setSiiGarantiaExigida(SiiGarantiaExigida siiGarantiaExigida) {
        this.siiGarantiaExigida = siiGarantiaExigida;
    }
}
