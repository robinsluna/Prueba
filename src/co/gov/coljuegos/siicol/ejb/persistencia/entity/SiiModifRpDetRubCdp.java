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
@Table(name = "SII_MODIF_RP_DET_RUB_CDP")
public class SiiModifRpDetRubCdp implements Serializable {
    private static final long serialVersionUID = -5860217858606518171L;
    private Long mrdCodigo;
    private BigDecimal mrdValor;
    private SiiModificacionRp siiModificacionRp;
    private SiiRpDetRubroCdp siiRpDetRubroCdp;

    public SiiModifRpDetRubCdp() {
    }

    public SiiModifRpDetRubCdp(Long mrdCodigo, BigDecimal mrdValor, SiiModificacionRp siiModificacionRp,
                               SiiRpDetRubroCdp siiRpDetRubroCdp) {
        this.mrdCodigo = mrdCodigo;
        this.mrdValor = mrdValor;
        this.siiModificacionRp = siiModificacionRp;
        this.siiRpDetRubroCdp = siiRpDetRubroCdp;
    }

    @Id
    @Column(name = "MRD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODIF_RP_DET_RUB_CDP")
    @SequenceGenerator(name = "SEQ_MODIF_RP_DET_RUB_CDP", sequenceName = "SEQ_MODIF_RP_DET_RUB_CDP",allocationSize=1)
    public Long getMrdCodigo() {
        return mrdCodigo;
    }

    public void setMrdCodigo(Long mrdCodigo) {
        this.mrdCodigo = mrdCodigo;
    }

    @Column(name = "MRD_VALOR", nullable = false)
    public BigDecimal getMrdValor() {
        return mrdValor;
    }

    public void setMrdValor(BigDecimal mrdValor) {
        this.mrdValor = mrdValor;
    }


    @ManyToOne
    @JoinColumn(name = "MRP_CODIGO")
    public SiiModificacionRp getSiiModificacionRp() {
        return siiModificacionRp;
    }

    public void setSiiModificacionRp(SiiModificacionRp siiModificacionRp) {
        this.siiModificacionRp = siiModificacionRp;
    }

    @ManyToOne
    @JoinColumn(name = "RDR_CODIGO")
    public SiiRpDetRubroCdp getSiiRpDetRubroCdp() {
        return siiRpDetRubroCdp;
    }

    public void setSiiRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) {
        this.siiRpDetRubroCdp = siiRpDetRubroCdp;
    }
}
