package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_OBL_CONC_RP_DET_RUB_CDP")
public class SiiOblConcRpDetRubCdp implements Serializable {
    private static final long serialVersionUID = 2250237852547964903L;
    private Long ocrCodigo;
    private BigDecimal ocrValor;
    private SiiObligacionConcepto siiObligacionConcepto;
    private SiiRpDetRubroCdp siiRpDetRubroCdp;
    private SiiObligacion siiObligacion;
    private List<SiiNotaCredOblConcDetRub> siiNotaCredOblConcDetRubList;

    public SiiOblConcRpDetRubCdp() {
    }

    public SiiOblConcRpDetRubCdp(SiiObligacionConcepto siiObligacionConcepto, Long ocrCodigo, BigDecimal ocrValor,
                                 SiiRpDetRubroCdp siiRpDetRubroCdp) {
        this.siiObligacionConcepto = siiObligacionConcepto;
        this.ocrCodigo = ocrCodigo;
        this.ocrValor = ocrValor;
        this.siiRpDetRubroCdp = siiRpDetRubroCdp;
    }


    @Id
    @Column(name = "OCR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OBL_CON_RP_DET_RUB_COD")
    @SequenceGenerator(name = "SEQ_OBL_CON_RP_DET_RUB_COD", sequenceName = "SEQ_OBL_CON_RP_DET_RUB_COD",allocationSize=1)
    public Long getOcrCodigo() {
        return ocrCodigo;
    }

    public void setOcrCodigo(Long ocrCodigo) {
        this.ocrCodigo = ocrCodigo;
    }

    @Column(name = "OCR_VALOR", nullable = false)
    public BigDecimal getOcrValor() {
        return ocrValor;
    }

    public void setOcrValor(BigDecimal ocrValor) {
        this.ocrValor = ocrValor;
    }


    @ManyToOne
    @JoinColumn(name = "OCO_CODIGO")
    public SiiObligacionConcepto getSiiObligacionConcepto() {
        return siiObligacionConcepto;
    }

    public void setSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        this.siiObligacionConcepto = siiObligacionConcepto;
    }

    @ManyToOne
    @JoinColumn(name = "RDR_CODIGO")
    public SiiRpDetRubroCdp getSiiRpDetRubroCdp() {
        return siiRpDetRubroCdp;
    }

    public void setSiiRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) {
        this.siiRpDetRubroCdp = siiRpDetRubroCdp;
    }

    @ManyToOne
    @JoinColumn(name = "OBL_CODIGO")
    public SiiObligacion getSiiObligacion() {
        return siiObligacion;
    }

    public void setSiiObligacion(SiiObligacion siiObligacion) {
        this.siiObligacion = siiObligacion;
    }

    @OneToMany(mappedBy = "siiOblConcRpDetRubCdp")
    public List<SiiNotaCredOblConcDetRub> getSiiNotaCredOblConcDetRubList() {
        return siiNotaCredOblConcDetRubList;
    }

    public void setSiiNotaCredOblConcDetRubList(List<SiiNotaCredOblConcDetRub> siiNotaCredOblConcDetRubList) {
        this.siiNotaCredOblConcDetRubList = siiNotaCredOblConcDetRubList;
    }

    public SiiNotaCredOblConcDetRub addSiiNotaCredOblConcDetRub(SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub) {
        getSiiNotaCredOblConcDetRubList().add(siiNotaCredOblConcDetRub);
        siiNotaCredOblConcDetRub.setSiiOblConcRpDetRubCdp(this);
        return siiNotaCredOblConcDetRub;
    }

    public SiiNotaCredOblConcDetRub removeSiiNotaCredOblConcDetRub(SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub) {
        getSiiNotaCredOblConcDetRubList().remove(siiNotaCredOblConcDetRub);
        siiNotaCredOblConcDetRub.setSiiOblConcRpDetRubCdp(null);
        return siiNotaCredOblConcDetRub;
    }
}
