package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MODIF_CDP_DET_RUB_CDP")
public class SiiModifCdpDetRubCdp implements Serializable {
    private static final long serialVersionUID = 439278807252739592L;
    private Long mcrCodigo;
    private BigDecimal mcrValor;
    private SiiModificacionCdp siiModificacionCdp;
    private SiiDetalleRubroCdp siiDetalleRubroCdp;

    public SiiModifCdpDetRubCdp() {
    }

    public SiiModifCdpDetRubCdp(SiiDetalleRubroCdp siiDetalleRubroCdp, SiiModificacionCdp siiModificacionCdp,
                                Long mcrCodigo, BigDecimal mcrValor) {
        this.siiDetalleRubroCdp = siiDetalleRubroCdp;
        this.siiModificacionCdp = siiModificacionCdp;
        this.mcrCodigo = mcrCodigo;
        this.mcrValor = mcrValor;
    }


    @Id
    @Column(name = "MCR_CODIGO", nullable = false)
    public Long getMcrCodigo() {
        return mcrCodigo;
    }

    public void setMcrCodigo(Long mcrCodigo) {
        this.mcrCodigo = mcrCodigo;
    }

    @Column(name = "MCR_VALOR", nullable = false)
    public BigDecimal getMcrValor() {
        return mcrValor;
    }

    public void setMcrValor(BigDecimal mcrValor) {
        this.mcrValor = mcrValor;
    }

    @ManyToOne
    @JoinColumn(name = "MCD_CODIGO")
    public SiiModificacionCdp getSiiModificacionCdp() {
        return siiModificacionCdp;
    }

    public void setSiiModificacionCdp(SiiModificacionCdp siiModificacionCdp) {
        this.siiModificacionCdp = siiModificacionCdp;
    }

    @ManyToOne
    @JoinColumn(name = "DRC_CODIGO")
    public SiiDetalleRubroCdp getSiiDetalleRubroCdp() {
        return siiDetalleRubroCdp;
    }

    public void setSiiDetalleRubroCdp(SiiDetalleRubroCdp siiDetalleRubroCdp) {
        this.siiDetalleRubroCdp = siiDetalleRubroCdp;
    }
}
