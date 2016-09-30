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
@Table(name = "SII_OBLIG_DET_RUBRO_CDP")
public class SiiObligDetRubroCdp implements Serializable {
    private static final long serialVersionUID = 8420747587825452991L;
    private String odrActivo;
    private Long odrCodigo;
    private Long odrValorPagar;
    private BigDecimal odrValorGmf;
    private SiiObligacionPago siiObligacionPago;
    private SiiDetalleRubroCdp siiDetalleRubroCdp;
    private SiiRpDetRubroCdp siiRpDetRubroCdp;

    public SiiObligDetRubroCdp() {
    }

    public SiiObligDetRubroCdp(SiiDetalleRubroCdp siiDetalleRubroCdp, Long odrCodigo, Long odrValorPagar,
                               SiiObligacionPago siiObligacionPago, String odrActivo, SiiRpDetRubroCdp siiRpDetRubroCdp) {
        this.siiDetalleRubroCdp = siiDetalleRubroCdp;
        this.odrCodigo = odrCodigo;
        this.odrValorPagar = odrValorPagar;
        this.siiObligacionPago = siiObligacionPago;
        this.odrActivo = odrActivo;
        this.siiRpDetRubroCdp = siiRpDetRubroCdp;
    }

    
    @Id
    @Column(name = "ODR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OBLIG_DET_RUBRO_CDP_COD")
    @SequenceGenerator(name = "SEQ_OBLIG_DET_RUBRO_CDP_COD", sequenceName = "SEQ_OBLIG_DET_RUBRO_CDP_COD",allocationSize=1)
    public Long getOdrCodigo() {
        return odrCodigo;
    }

    public void setOdrCodigo(Long odrCodigo) {
        this.odrCodigo = odrCodigo;
    }

    @Column(name = "ODR_VALOR_PAGAR", nullable = false)
    public Long getOdrValorPagar() {
        return odrValorPagar;
    }

    public void setOdrValorPagar(Long odrValorPagar) {
        this.odrValorPagar = odrValorPagar;
    }


    @ManyToOne
    @JoinColumn(name = "OPA_CODIGO")
    public SiiObligacionPago getSiiObligacionPago() {
        return siiObligacionPago;
    }

    public void setSiiObligacionPago(SiiObligacionPago siiObligacionPago) {
        this.siiObligacionPago = siiObligacionPago;
    }

    @ManyToOne
    @JoinColumn(name = "DRC_CODIGO")
    public SiiDetalleRubroCdp getSiiDetalleRubroCdp() {
        return siiDetalleRubroCdp;
    }

    public void setSiiDetalleRubroCdp(SiiDetalleRubroCdp siiDetalleRubroCdp) {
        this.siiDetalleRubroCdp = siiDetalleRubroCdp;
    }


    @Column(name = "ODR_ACTIVO", nullable = false, length = 1)
    public String getOdrActivo() {
        return odrActivo;
    }

    public void setOdrActivo(String odrActivo) {
        this.odrActivo = odrActivo;
    }

    @ManyToOne
    @JoinColumn(name = "RDR_CODIGO")
    public SiiRpDetRubroCdp getSiiRpDetRubroCdp() {
        return siiRpDetRubroCdp;
    }

    public void setSiiRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) {
        this.siiRpDetRubroCdp = siiRpDetRubroCdp;
    }

    @Column(name = "ODR_VALOR_GMF")
    public BigDecimal getOdrValorGmf() {
        return odrValorGmf;
    }
    
    public void setOdrValorGmf(BigDecimal odrValorGmf) {
        this.odrValorGmf = odrValorGmf;
    }
}
