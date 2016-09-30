package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_RP_DET_RUBRO_CDP")
public class SiiRpDetRubroCdp implements Serializable {
    private static final long serialVersionUID = 1092587612518984069L;
    private Long rdrCodigo;
    private BigDecimal rdrValor;
    private SiiDetalleRubroCdp siiDetalleRubroCdp;
    private SiiRp siiRp;
    private List<SiiModifRpDetRubCdp> siiModifRpDetRubCdpList1;
    private BigDecimal rdrSaldoAnterior;
    private List<SiiObligDetRubroCdp> siiObligDetRubroCdpList;
    private List<SiiOblConcRpDetRubCdp> siiOblConcRpDetRubCdpList;
    private List<SiiRpDetRubReintIngPag> siiRpDetRubReintIngPagList;


    public SiiRpDetRubroCdp() {
    }

    public SiiRpDetRubroCdp(SiiDetalleRubroCdp siiDetalleRubroCdp, Long rdrCodigo, BigDecimal rdrValor, SiiRp siiRp, BigDecimal rdrSaldoAnterior) {
        this.siiDetalleRubroCdp = siiDetalleRubroCdp;
        this.rdrCodigo = rdrCodigo;
        this.rdrSaldoAnterior = rdrSaldoAnterior;
        this.rdrValor = rdrValor;
        this.siiRp = siiRp;
    }


    @Id
    @Column(name = "RDR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RP_DET_RUBRO_CDP")
    @SequenceGenerator(name = "SEQ_RP_DET_RUBRO_CDP", sequenceName = "SEQ_RP_DET_RUBRO_CDP",allocationSize=1)
    public Long getRdrCodigo() {
        return rdrCodigo;
    }

    public void setRdrCodigo(Long rdrCodigo) {
        this.rdrCodigo = rdrCodigo;
    }

    @Column(name = "RDR_SALDO_ANTERIOR")
    public BigDecimal getRdrSaldoAnterior() {
        return rdrSaldoAnterior;
    }

    public void setRdrSaldoAnterior(BigDecimal rdrSaldoAnterior) {
        this.rdrSaldoAnterior = rdrSaldoAnterior;
    }

    @Column(name = "RDR_VALOR", nullable = false)
    public BigDecimal getRdrValor() {
        return rdrValor;
    }

    public void setRdrValor(BigDecimal rdrValor) {
        this.rdrValor = rdrValor;
    }


    @ManyToOne
    @JoinColumn(name = "DRC_CODIGO")
    public SiiDetalleRubroCdp getSiiDetalleRubroCdp() {
        return siiDetalleRubroCdp;
    }

    public void setSiiDetalleRubroCdp(SiiDetalleRubroCdp siiDetalleRubroCdp) {
        this.siiDetalleRubroCdp = siiDetalleRubroCdp;
    }

    @ManyToOne
    @JoinColumn(name = "RP_CODIGO")
    public SiiRp getSiiRp() {
        return siiRp;
    }

    public void setSiiRp(SiiRp siiRp) {
        this.siiRp = siiRp;
    }

    @OneToMany(mappedBy = "siiRpDetRubroCdp")
    public List<SiiModifRpDetRubCdp> getSiiModifRpDetRubCdpList1() {
        return siiModifRpDetRubCdpList1;
    }

    public void setSiiModifRpDetRubCdpList1(List<SiiModifRpDetRubCdp> siiModifRpDetRubCdpList1) {
        this.siiModifRpDetRubCdpList1 = siiModifRpDetRubCdpList1;
    }

    public SiiModifRpDetRubCdp addSiiModifRpDetRubCdp(SiiModifRpDetRubCdp siiModifRpDetRubCdp) {
        getSiiModifRpDetRubCdpList1().add(siiModifRpDetRubCdp);
        siiModifRpDetRubCdp.setSiiRpDetRubroCdp(this);
        return siiModifRpDetRubCdp;
    }

    public SiiModifRpDetRubCdp removeSiiModifRpDetRubCdp(SiiModifRpDetRubCdp siiModifRpDetRubCdp) {
        getSiiModifRpDetRubCdpList1().remove(siiModifRpDetRubCdp);
        siiModifRpDetRubCdp.setSiiRpDetRubroCdp(null);
        return siiModifRpDetRubCdp;
    }

    @OneToMany(mappedBy = "siiRpDetRubroCdp")
    public List<SiiObligDetRubroCdp> getSiiObligDetRubroCdpList() {
        return siiObligDetRubroCdpList;
    }

    public void setSiiObligDetRubroCdpList(List<SiiObligDetRubroCdp> siiObligDetRubroCdpList) {
        this.siiObligDetRubroCdpList = siiObligDetRubroCdpList;
    }

    public SiiObligDetRubroCdp addSiiObligDetRubroCdp(SiiObligDetRubroCdp siiObligDetRubroCdp) {
        getSiiObligDetRubroCdpList().add(siiObligDetRubroCdp);
        siiObligDetRubroCdp.setSiiRpDetRubroCdp(this);
        return siiObligDetRubroCdp;
    }

    public SiiObligDetRubroCdp removeSiiObligDetRubroCdp(SiiObligDetRubroCdp siiObligDetRubroCdp) {
        getSiiObligDetRubroCdpList().remove(siiObligDetRubroCdp);
        siiObligDetRubroCdp.setSiiRpDetRubroCdp(null);
        return siiObligDetRubroCdp;
    }

    @OneToMany(mappedBy = "siiRpDetRubroCdp")
    public List<SiiOblConcRpDetRubCdp> getSiiOblConcRpDetRubCdpList() {
        return siiOblConcRpDetRubCdpList;
    }

    public void setSiiOblConcRpDetRubCdpList(List<SiiOblConcRpDetRubCdp> siiOblConcRpDetRubCdpList) {
        this.siiOblConcRpDetRubCdpList = siiOblConcRpDetRubCdpList;
    }

    public SiiOblConcRpDetRubCdp addSiiOblConcRpDetRubCdp(SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp) {
        getSiiOblConcRpDetRubCdpList().add(siiOblConcRpDetRubCdp);
        siiOblConcRpDetRubCdp.setSiiRpDetRubroCdp(this);
        return siiOblConcRpDetRubCdp;
    }

    public SiiOblConcRpDetRubCdp removeSiiOblConcRpDetRubCdp(SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp) {
        getSiiOblConcRpDetRubCdpList().remove(siiOblConcRpDetRubCdp);
        siiOblConcRpDetRubCdp.setSiiRpDetRubroCdp(null);
        return siiOblConcRpDetRubCdp;
    }

    @OneToMany(mappedBy = "siiRpDetRubroCdp")
    public List<SiiRpDetRubReintIngPag> getSiiRpDetRubReintIngPagList() {
        return siiRpDetRubReintIngPagList;
    }

    public void setSiiRpDetRubReintIngPagList(List<SiiRpDetRubReintIngPag> siiRpDetRubReintIngPagList) {
        this.siiRpDetRubReintIngPagList = siiRpDetRubReintIngPagList;
    }

    public SiiRpDetRubReintIngPag addSiiRpDetRubReintIngPag(SiiRpDetRubReintIngPag siiRpDetRubReintIngPag) {
        getSiiRpDetRubReintIngPagList().add(siiRpDetRubReintIngPag);
        siiRpDetRubReintIngPag.setSiiRpDetRubroCdp(this);
        return siiRpDetRubReintIngPag;
    }

    public SiiRpDetRubReintIngPag removeSiiRpDetRubReintIngPag(SiiRpDetRubReintIngPag siiRpDetRubReintIngPag) {
        getSiiRpDetRubReintIngPagList().remove(siiRpDetRubReintIngPag);
        siiRpDetRubReintIngPag.setSiiRpDetRubroCdp(null);
        return siiRpDetRubReintIngPag;
    }
}
