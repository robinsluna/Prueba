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
@Table(name = "SII_DETALLE_DECLARACION_SUG")
public class SiiDetalleDeclaracionSug implements Serializable {
    private static final long serialVersionUID = -2597591604872422451L;
    private Long ddsCodigo;
    private BigDecimal ddsValor;
    private BigDecimal ddsValorInteres;
    private SiiCuotaOperador siiCuotaOperador;
    private SiiDeclaracionSugerida siiDeclaracionSugerida;

    public SiiDetalleDeclaracionSug() {
    }

    public SiiDetalleDeclaracionSug(SiiCuotaOperador siiCuotaOperador, Long ddsCodigo, BigDecimal ddsValor,
                                    Long BigDecimal, SiiDeclaracionSugerida siiDeclaracionSugerida) {
        this.siiCuotaOperador = siiCuotaOperador;
        this.ddsCodigo = ddsCodigo;
        this.ddsValor = ddsValor;
        this.ddsValorInteres = ddsValorInteres;
        this.siiDeclaracionSugerida = siiDeclaracionSugerida;
    }


    @Id
    @Column(name = "DDS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DET_DECLARAC_SUG_COD")
    @SequenceGenerator(name = "SEQ_DET_DECLARAC_SUG_COD", sequenceName = "SEQ_DET_DECLARAC_SUG_COD",allocationSize=1)
    public Long getDdsCodigo() {
        return ddsCodigo;
    }

    public void setDdsCodigo(Long ddsCodigo) {
        this.ddsCodigo = ddsCodigo;
    }

    @Column(name = "DDS_VALOR", nullable = false)
    public BigDecimal getDdsValor() {
        return ddsValor;
    }

    public void setDdsValor(BigDecimal ddsValor) {
        this.ddsValor = ddsValor;
    }

    @Column(name = "DDS_VALOR_INTERES", nullable = false)
    public BigDecimal getDdsValorInteres() {
        return ddsValorInteres;
    }

    public void setDdsValorInteres(BigDecimal ddsValorInteres) {
        this.ddsValorInteres = ddsValorInteres;
    }


    @ManyToOne
    @JoinColumn(name = "COP_CODIGO")
    public SiiCuotaOperador getSiiCuotaOperador() {
        return siiCuotaOperador;
    }

    public void setSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        this.siiCuotaOperador = siiCuotaOperador;
    }

    @ManyToOne
    @JoinColumn(name = "DSU_CODIGO")
    public SiiDeclaracionSugerida getSiiDeclaracionSugerida() {
        return siiDeclaracionSugerida;
    }

    public void setSiiDeclaracionSugerida(SiiDeclaracionSugerida siiDeclaracionSugerida) {
        this.siiDeclaracionSugerida = siiDeclaracionSugerida;
    }
}
