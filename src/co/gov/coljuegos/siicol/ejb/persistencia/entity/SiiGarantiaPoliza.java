package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_GARANTIA_POLIZA")
public class SiiGarantiaPoliza implements Serializable {
    private static final long serialVersionUID = -5017227715970722496L;
    private Long gpoCodigo;
    private BigDecimal gpoMontoValor;
    private BigDecimal gpoValorAsegurado;
    private Date gpoVigenciaDesde;
    private Date gpoVigenciaHasta;
    private SiiGarantiaExigida siiGarantiaExigida;
    private SiiPolizaContrat siiPolizaContrat;
    private Date gpoAntVigenciaDesde;
    private Date gpoAntVigenciaHasta;
    private BigDecimal gpoAntValAsegurado;

    public SiiGarantiaPoliza() {
    }

    public SiiGarantiaPoliza(SiiGarantiaExigida siiGarantiaExigida, Long gpoCodigo, BigDecimal gpoValorAsegurado,
                             Date gpoVigenciaDesde, Date gpoVigenciaHasta, SiiPolizaContrat siiPolizaContrat, BigDecimal gpoMontoValor) {
        this.siiGarantiaExigida = siiGarantiaExigida;
        this.gpoCodigo = gpoCodigo;
        this.gpoMontoValor = gpoMontoValor;
        this.gpoValorAsegurado = gpoValorAsegurado;
        this.gpoVigenciaDesde = gpoVigenciaDesde;
        this.gpoVigenciaHasta = gpoVigenciaHasta;
        this.siiPolizaContrat = siiPolizaContrat;
    }


    @Id
    @Column(name = "GPO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GARANTIA_POLIZA_COD")
    @SequenceGenerator(name = "SEQ_GARANTIA_POLIZA_COD", sequenceName = "SEQ_GARANTIA_POLIZA_COD",allocationSize=1)
    public Long getGpoCodigo() {
        return gpoCodigo;
    }

    public void setGpoCodigo(Long gpoCodigo) {
        this.gpoCodigo = gpoCodigo;
    }

    @Column(name = "GPO_MONTO_VALOR")
    public BigDecimal getGpoMontoValor() {
        return gpoMontoValor;
    }

    public void setGpoMontoValor(BigDecimal gpoMontoValor) {
        this.gpoMontoValor = gpoMontoValor;
    }

    @Column(name = "GPO_VALOR_ASEGURADO", nullable = false)
    public BigDecimal getGpoValorAsegurado() {
        return gpoValorAsegurado;
    }

    public void setGpoValorAsegurado(BigDecimal gpoValorAsegurado) {
        this.gpoValorAsegurado = gpoValorAsegurado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GPO_VIGENCIA_DESDE", nullable = false)
    public Date getGpoVigenciaDesde() {
        return gpoVigenciaDesde;
    }

    public void setGpoVigenciaDesde(Date gpoVigenciaDesde) {
        this.gpoVigenciaDesde = gpoVigenciaDesde;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GPO_VIGENCIA_HASTA", nullable = false)
    public Date getGpoVigenciaHasta() {
        return gpoVigenciaHasta;
    }

    public void setGpoVigenciaHasta(Date gpoVigenciaHasta) {
        this.gpoVigenciaHasta = gpoVigenciaHasta;
    }


    @ManyToOne
    @JoinColumn(name = "GEX_CODIGO")
    public SiiGarantiaExigida getSiiGarantiaExigida() {
        return siiGarantiaExigida;
    }

    public void setSiiGarantiaExigida(SiiGarantiaExigida siiGarantiaExigida) {
        this.siiGarantiaExigida = siiGarantiaExigida;
    }

    @ManyToOne
    @JoinColumn(name = "PCC_CODIGO")
    public SiiPolizaContrat getSiiPolizaContrat() {
        return siiPolizaContrat;
    }

    public void setSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        this.siiPolizaContrat = siiPolizaContrat;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GPO_ANT_VIGENCIA_DESDE")
    public Date getGpoAntVigenciaDesde() {
        return gpoAntVigenciaDesde;
    }
    
    public void setGpoAntVigenciaDesde(Date gpoAntVigenciaDesde) {
        this.gpoAntVigenciaDesde = gpoAntVigenciaDesde;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GPO_ANT_VIGENCIA_HASTA")
    public Date getGpoAntVigenciaHasta() {
        return gpoAntVigenciaHasta;
    }
    
    public void setGpoAntVigenciaHasta(Date gpoAntVigenciaHasta) {
        this.gpoAntVigenciaHasta = gpoAntVigenciaHasta;
    }

    @Column(name = "GPO_ANT_VAL_ASEGURADO")
    public BigDecimal getGpoAntValAsegurado() {
        return gpoAntValAsegurado;
    }
    
    public void setGpoAntValAsegurado(BigDecimal gpoAntValAsegurado) {
        this.gpoAntValAsegurado = gpoAntValAsegurado;
    }
}
