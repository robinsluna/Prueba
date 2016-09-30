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
@Table(name = "SII_DETALLE_RUBRO_CDP")
public class SiiDetalleRubroCdp implements Serializable {
    private static final long serialVersionUID = -7678993331804595286L;
    private Long drcCodigo;
    private BigDecimal druValor;
    private List<SiiRpDetRubroCdp> siiRpDetRubroCdpList;
    private SiiCdp siiCdp;
    private List<SiiObligDetRubroCdp> siiObligDetRubroCdpList;
    private SiiDetalleRubro siiDetalleRubro;
    private List<SiiModifCdpDetRubCdp> siiModifCdpDetRubCdpList1;
    private BigDecimal drcSaldoAnterior;
    private String drcAplicaGmf;
    private SiiGravamenMovFinanc siiGravamenMovFinanc;


    public SiiDetalleRubroCdp() {
    }

    public SiiDetalleRubroCdp(SiiCdp siiCdp, Long drcCodigo, BigDecimal druValor, SiiDetalleRubro siiDetalleRubro,
					BigDecimal drcSaldoAnterior, String drcAplicaGmf, SiiGravamenMovFinanc siiGravamenMovFinanc) {
        this.siiCdp = siiCdp;
        this.drcSaldoAnterior = drcSaldoAnterior;
        this.drcCodigo = drcCodigo;
        this.siiDetalleRubro = siiDetalleRubro;
        this.druValor = druValor;
        this.drcAplicaGmf = drcAplicaGmf;
        this.siiGravamenMovFinanc = siiGravamenMovFinanc;

    }
    

    @Id
    @Column(name = "DRC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DETALLE_RUBRO_CDP")
    @SequenceGenerator(name = "SEQ_DETALLE_RUBRO_CDP", sequenceName = "SEQ_DETALLE_RUBRO_CDP",allocationSize=1)
    public Long getDrcCodigo() {
        return drcCodigo;
    }

    public void setDrcCodigo(Long drcCodigo) {
        this.drcCodigo = drcCodigo;
    }

    @Column(name = "DRU_VALOR")
    public BigDecimal getDruValor() {
        return druValor;
    }

    public void setDruValor(BigDecimal druValor) {
        this.druValor = druValor;
    }

    @OneToMany(mappedBy = "siiDetalleRubroCdp")
    public List<SiiRpDetRubroCdp> getSiiRpDetRubroCdpList() {
        return siiRpDetRubroCdpList;
    }

    public void setSiiRpDetRubroCdpList(List<SiiRpDetRubroCdp> siiRpDetRubroCdpList) {
        this.siiRpDetRubroCdpList = siiRpDetRubroCdpList;
    }

    public SiiRpDetRubroCdp addSiiRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) {
        getSiiRpDetRubroCdpList().add(siiRpDetRubroCdp);
        siiRpDetRubroCdp.setSiiDetalleRubroCdp(this);
        return siiRpDetRubroCdp;
    }

    public SiiRpDetRubroCdp removeSiiRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) {
        getSiiRpDetRubroCdpList().remove(siiRpDetRubroCdp);
        siiRpDetRubroCdp.setSiiDetalleRubroCdp(null);
        return siiRpDetRubroCdp;
    }

    @ManyToOne
    @JoinColumn(name = "CDP_CODIGO")
    public SiiCdp getSiiCdp() {
        return siiCdp;
    }

    public void setSiiCdp(SiiCdp siiCdp) {
        this.siiCdp = siiCdp;
    }

    @OneToMany(mappedBy = "siiDetalleRubroCdp")
    public List<SiiObligDetRubroCdp> getSiiObligDetRubroCdpList() {
        return siiObligDetRubroCdpList;
    }

    public void setSiiObligDetRubroCdpList(List<SiiObligDetRubroCdp> siiObligDetRubroCdpList) {
        this.siiObligDetRubroCdpList = siiObligDetRubroCdpList;
    }

    public SiiObligDetRubroCdp addSiiObligDetRubroCdp(SiiObligDetRubroCdp siiObligDetRubroCdp) {
        getSiiObligDetRubroCdpList().add(siiObligDetRubroCdp);
        siiObligDetRubroCdp.setSiiDetalleRubroCdp(this);
        return siiObligDetRubroCdp;
    }

    public SiiObligDetRubroCdp removeSiiObligDetRubroCdp(SiiObligDetRubroCdp siiObligDetRubroCdp) {
        getSiiObligDetRubroCdpList().remove(siiObligDetRubroCdp);
        siiObligDetRubroCdp.setSiiDetalleRubroCdp(null);
        return siiObligDetRubroCdp;
    }

    @ManyToOne
    @JoinColumn(name = "DRU_CODIGO")
    public SiiDetalleRubro getSiiDetalleRubro() {
        return siiDetalleRubro;
    }

    public void setSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) {
        this.siiDetalleRubro = siiDetalleRubro;
    }

    @OneToMany(mappedBy = "siiDetalleRubroCdp")
    public List<SiiModifCdpDetRubCdp> getSiiModifCdpDetRubCdpList1() {
        return siiModifCdpDetRubCdpList1;
    }

    public void setSiiModifCdpDetRubCdpList1(List<SiiModifCdpDetRubCdp> siiModifCdpDetRubCdpList1) {
        this.siiModifCdpDetRubCdpList1 = siiModifCdpDetRubCdpList1;
    }

    public SiiModifCdpDetRubCdp addSiiModifCdpDetRubCdp(SiiModifCdpDetRubCdp siiModifCdpDetRubCdp) {
        getSiiModifCdpDetRubCdpList1().add(siiModifCdpDetRubCdp);
        siiModifCdpDetRubCdp.setSiiDetalleRubroCdp(this);
        return siiModifCdpDetRubCdp;
    }

    public SiiModifCdpDetRubCdp removeSiiModifCdpDetRubCdp(SiiModifCdpDetRubCdp siiModifCdpDetRubCdp) {
        getSiiModifCdpDetRubCdpList1().remove(siiModifCdpDetRubCdp);
        siiModifCdpDetRubCdp.setSiiDetalleRubroCdp(null);
        return siiModifCdpDetRubCdp;
    }

    @Column(name = "DRC_SALDO_ANTERIOR")
    public BigDecimal getDrcSaldoAnterior() {
        return drcSaldoAnterior;
    }

    public void setDrcSaldoAnterior(BigDecimal drcSaldoAnterior) {
        this.drcSaldoAnterior = drcSaldoAnterior;
    }

    @ManyToOne
    @JoinColumn(name = "GMF_CODIGO")
    public SiiGravamenMovFinanc getSiiGravamenMovFinanc() {
        return siiGravamenMovFinanc;
    }

    public void setSiiGravamenMovFinanc(SiiGravamenMovFinanc siiGravamenMovFinanc) {
        this.siiGravamenMovFinanc = siiGravamenMovFinanc;
    }

    @Column(name = "DRC_APLICA_GMF", nullable = false, length = 1)
    public String getDrcAplicaGmf() {
        return drcAplicaGmf;
    }

    public void setDrcAplicaGmf(String drcAplicaGmf) {
        this.drcAplicaGmf = drcAplicaGmf;
    }
}
