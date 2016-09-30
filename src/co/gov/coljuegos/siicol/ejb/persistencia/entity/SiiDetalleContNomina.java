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
@Table(name = "SII_DETALLE_CONT_NOMINA")
public class SiiDetalleContNomina implements Serializable {
    private static final long serialVersionUID = 3672283765526738051L;
    private Long dcmCodigo;
    private String dcmContrato;
    private String dcmReferencia1;
    private Integer dcmTipoRetencion;
    private BigDecimal dcmValor;
    private SiiFuenteFinancContab siiFuenteFinancContab;
    private SiiPersona siiPersona;
    private SiiAreaColjuegos siiAreaColjuegos;
    private SiiObligacion siiObligacion;
    private SiiRp siiRp;
    private SiiConceptoNomina siiConceptoNomina;
    private SiiCargaNomina siiCargaNomina;
    private List<SiiNotaCredOblConcepto> siiNotaCredOblConceptoList;

    public SiiDetalleContNomina() {
    }

    public SiiDetalleContNomina(SiiAreaColjuegos siiAreaColjuegos, Long dcmCodigo,
                                String dcmReferencia1, Integer dcmTipoRetencion, BigDecimal dcmValor,
                                SiiFuenteFinancContab siiFuenteFinancContab, SiiObligacion siiObligacion,
                                SiiPersona siiPersona, SiiRp siiRp) {
        this.siiAreaColjuegos = siiAreaColjuegos;
        this.dcmCodigo = dcmCodigo;
        this.dcmReferencia1 = dcmReferencia1;
        this.dcmTipoRetencion = dcmTipoRetencion;
        this.dcmValor = dcmValor;
        this.siiFuenteFinancContab = siiFuenteFinancContab;
        this.siiObligacion = siiObligacion;
        this.siiPersona = siiPersona;
        this.siiRp = siiRp;
    }


    @Id
    @Column(name = "DCM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DETALLE_CONTR_NOMINA_COD")
    @SequenceGenerator(name = "SEQ_DETALLE_CONTR_NOMINA_COD", sequenceName = "SEQ_DETALLE_CONTR_NOMINA_COD",allocationSize=1)
    public Long getDcmCodigo() {
        return dcmCodigo;
    }

    public void setDcmCodigo(Long dcmCodigo) {
        this.dcmCodigo = dcmCodigo;
    }

    @Column(name = "DCM_CONTRATO", length = 20)
    public String getDcmContrato() {
        return dcmContrato;
    }

    public void setDcmContrato(String dcmContrato) {
        this.dcmContrato = dcmContrato;
    }

    @Column(name = "DCM_REFERENCIA1", nullable = false, length = 6)
    public String getDcmReferencia1() {
        return dcmReferencia1;
    }

    public void setDcmReferencia1(String dcmReferencia1) {
        this.dcmReferencia1 = dcmReferencia1;
    }

    @Column(name = "DCM_TIPO_RETENCION")
    public Integer getDcmTipoRetencion() {
        return dcmTipoRetencion;
    }

    public void setDcmTipoRetencion(Integer dcmTipoRetencion) {
        this.dcmTipoRetencion = dcmTipoRetencion;
    }

    @Column(name = "DCM_VALOR", nullable = false)
    public BigDecimal getDcmValor() {
        return dcmValor;
    }

    public void setDcmValor(BigDecimal dcmValor) {
        this.dcmValor = dcmValor;
    }


    @ManyToOne
    @JoinColumn(name = "FFC_CODIGO")
    public SiiFuenteFinancContab getSiiFuenteFinancContab() {
        return siiFuenteFinancContab;
    }

    public void setSiiFuenteFinancContab(SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiFuenteFinancContab = siiFuenteFinancContab;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "ACO_CODIGO")
    public SiiAreaColjuegos getSiiAreaColjuegos() {
        return siiAreaColjuegos;
    }

    public void setSiiAreaColjuegos(SiiAreaColjuegos siiAreaColjuegos) {
        this.siiAreaColjuegos = siiAreaColjuegos;
    }

    @ManyToOne
    @JoinColumn(name = "OBL_CODIGO")
    public SiiObligacion getSiiObligacion() {
        return siiObligacion;
    }

    public void setSiiObligacion(SiiObligacion siiObligacion) {
        this.siiObligacion = siiObligacion;
    }

    @ManyToOne
    @JoinColumn(name = "RP_CODIGO")
    public SiiRp getSiiRp() {
        return siiRp;
    }

    public void setSiiRp(SiiRp siiRp) {
        this.siiRp = siiRp;
    }

    @ManyToOne
    @JoinColumn(name = "CNO_CODIGO")
    public SiiConceptoNomina getSiiConceptoNomina() {
        return siiConceptoNomina;
    }

    public void setSiiConceptoNomina(SiiConceptoNomina siiConceptoNomina) {
        this.siiConceptoNomina = siiConceptoNomina;
    }

    @ManyToOne
    @JoinColumn(name = "CRN_CODIGO")
    public SiiCargaNomina getSiiCargaNomina() {
        return siiCargaNomina;
    }

    public void setSiiCargaNomina(SiiCargaNomina siiCargaNomina) {
        this.siiCargaNomina = siiCargaNomina;
    }
    
    @OneToMany(mappedBy = "siiDetalleContNomina")
    public List<SiiNotaCredOblConcepto> getSiiNotaCredOblConceptoList() {
        return siiNotaCredOblConceptoList;
    }

    public void setSiiNotaCredOblConceptoList(List<SiiNotaCredOblConcepto> siiNotaCredOblConceptoList) {
        this.siiNotaCredOblConceptoList = siiNotaCredOblConceptoList;
    }

    public SiiNotaCredOblConcepto addSiiNotaCredOblConcepto(SiiNotaCredOblConcepto siiNotaCredOblConcepto) {
        getSiiNotaCredOblConceptoList().add(siiNotaCredOblConcepto);
        siiNotaCredOblConcepto.setSiiDetalleContNomina(this);
        return siiNotaCredOblConcepto;
    }

    public SiiNotaCredOblConcepto removeSiiNotaCredOblConcepto(SiiNotaCredOblConcepto siiNotaCredOblConcepto) {
        getSiiNotaCredOblConceptoList().remove(siiNotaCredOblConcepto);
        siiNotaCredOblConcepto.setSiiDetalleContNomina(null);
        return siiNotaCredOblConcepto;
    }
}
