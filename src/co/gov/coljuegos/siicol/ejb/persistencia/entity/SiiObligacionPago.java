package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_OBLIGACION_PAGO")
public class SiiObligacionPago implements Serializable {
    private static final long serialVersionUID = -6522759016681309414L;
    private Long opaCodigo;
    private String opaNumeroDocSop;
    private Integer opaVigencia;
    private Long tdsCodigo;
    private SiiMes siiMes;
    private SiiMes siiMes1;
	private SiiTipoDocSoporte siiTipoDocSoporte;
    private List<SiiObligDetRubroCdp> siiObligDetRubroCdpList;

    public SiiObligacionPago() {
    }

    public SiiObligacionPago(SiiMes siiMes1, SiiMes siiMes, Long opaCodigo, String opaNumeroDocSop, Integer opaVigencia,
                             Long tdsCodigo, SiiTipoDocSoporte siiTipoDocSoporte) {
        this.siiMes1 = siiMes1;
        this.siiMes = siiMes;
        this.opaCodigo = opaCodigo;
        this.opaNumeroDocSop = opaNumeroDocSop;
        this.opaVigencia = opaVigencia;
        this.tdsCodigo = tdsCodigo;
		this.siiTipoDocSoporte = siiTipoDocSoporte;
    }


    @Id
    @Column(name = "OPA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OBLIG_PAGO_CODIGO")
    @SequenceGenerator(name = "SEQ_OBLIG_PAGO_CODIGO", sequenceName = "SEQ_OBLIG_PAGO_CODIGO",allocationSize=1)
    public Long getOpaCodigo() {
        return opaCodigo;
    }

    public void setOpaCodigo(Long opaCodigo) {
        this.opaCodigo = opaCodigo;
    }

    @Column(name = "OPA_NUMERO_DOC_SOP", nullable = false, length = 20)
    public String getOpaNumeroDocSop() {
        return opaNumeroDocSop;
    }

    public void setOpaNumeroDocSop(String opaNumeroDocSop) {
        this.opaNumeroDocSop = opaNumeroDocSop;
    }

    @Column(name = "OPA_VIGENCIA", nullable = false)
    public Integer getOpaVigencia() {
        return opaVigencia;
    }

    public void setOpaVigencia(Integer opaVigencia) {
        this.opaVigencia = opaVigencia;
    }

    @Column(name = "TDS_CODIGO", nullable = false)
    public Long getTdsCodigo() {
        return tdsCodigo;
    }

    public void setTdsCodigo(Long tdsCodigo) {
        this.tdsCodigo = tdsCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "MES_CODIGO_PAGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes1() {
        return siiMes1;
    }

    public void setSiiMes1(SiiMes siiMes1) {
        this.siiMes1 = siiMes1;
    }

    @ManyToOne
    @JoinColumn(name = "TDS_CODIGO", insertable = false, updatable = false)
    public SiiTipoDocSoporte getSiiTipoDocSoporte() {
        return siiTipoDocSoporte;
    }

    public void setSiiTipoDocSoporte(SiiTipoDocSoporte siiTipoDocSoporte) {
        this.siiTipoDocSoporte = siiTipoDocSoporte;
    }

    @OneToMany(mappedBy = "siiObligacionPago")
    public List<SiiObligDetRubroCdp> getSiiObligDetRubroCdpList() {
        return siiObligDetRubroCdpList;
    }

    public void setSiiObligDetRubroCdpList(List<SiiObligDetRubroCdp> siiObligDetRubroCdpList) {
        this.siiObligDetRubroCdpList = siiObligDetRubroCdpList;
    }

    public SiiObligDetRubroCdp addSiiObligDetRubroCdp(SiiObligDetRubroCdp siiObligDetRubroCdp) {
        getSiiObligDetRubroCdpList().add(siiObligDetRubroCdp);
        siiObligDetRubroCdp.setSiiObligacionPago(this);
        return siiObligDetRubroCdp;
    }

    public SiiObligDetRubroCdp removeSiiObligDetRubroCdp(SiiObligDetRubroCdp siiObligDetRubroCdp) {
        getSiiObligDetRubroCdpList().remove(siiObligDetRubroCdp);
        siiObligDetRubroCdp.setSiiObligacionPago(null);
        return siiObligDetRubroCdp;
    }
}
