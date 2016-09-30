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
@Table(name = "SII_SOL_PFC_MENS_DET_RUB")
public class SiiSolPfcMensDetRub implements Serializable {
    private static final long serialVersionUID = -8893685457098298414L;
    private Long sprCodigo;
    private BigDecimal sprValorAprob;
    private SiiSolicitudPfcMens siiSolicitudPfcMens;
    private SiiDetalleRubro siiDetalleRubro;

    public SiiSolPfcMensDetRub() {
    }

    public SiiSolPfcMensDetRub(SiiDetalleRubro siiDetalleRubro, SiiSolicitudPfcMens siiSolicitudPfcMens, Long sprCodigo,
                               BigDecimal sprValorAprob) {
        this.siiDetalleRubro = siiDetalleRubro;
        this.siiSolicitudPfcMens = siiSolicitudPfcMens;
        this.sprCodigo = sprCodigo;
        this.sprValorAprob = sprValorAprob;
    }


    @Id
    @Column(name = "SPR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SOL_PFCMENS_DRU_COD")
    @SequenceGenerator(name = "SEQ_SOL_PFCMENS_DRU_COD", sequenceName = "SEQ_SOL_PFCMENS_DRU_COD",allocationSize=1)
    public Long getSprCodigo() {
        return sprCodigo;
    }

    public void setSprCodigo(Long sprCodigo) {
        this.sprCodigo = sprCodigo;
    }

    @Column(name = "SPR_VALOR_APROB", nullable = false)
    public BigDecimal getSprValorAprob() {
        return sprValorAprob;
    }

    public void setSprValorAprob(BigDecimal sprValorAprob) {
        this.sprValorAprob = sprValorAprob;
    }

    @ManyToOne
    @JoinColumn(name = "SPF_CODIGO")
    public SiiSolicitudPfcMens getSiiSolicitudPfcMens() {
        return siiSolicitudPfcMens;
    }

    public void setSiiSolicitudPfcMens(SiiSolicitudPfcMens siiSolicitudPfcMens) {
        this.siiSolicitudPfcMens = siiSolicitudPfcMens;
    }

    @ManyToOne
    @JoinColumn(name = "DRU_CODIGO")
    public SiiDetalleRubro getSiiDetalleRubro() {
        return siiDetalleRubro;
    }

    public void setSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) {
        this.siiDetalleRubro = siiDetalleRubro;
    }
}
