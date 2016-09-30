package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_NOTA_CREDITO")
public class SiiNotaCredito implements Serializable {
    private static final long serialVersionUID = -7331373740224433646L;
    private Long ncrCodigo;
    private Date ncrFecha;
    private Integer ncrNumero;
    private String ncrRcIndepend;
    private String ncrTipoNota;
    private List<SiiNotaCredOblConcepto> siiNotaCredOblConceptoList;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private SiiObligacion siiObligacion;
    private List<SiiReintegroIngresoPag> siiReintegroIngresoPagList;
    private SiiFuenteFinancContab siiFuenteFinancContab;
    private String ncrEstado;
    private List<SiiNotaCredOblConcDetRub> siiNotaCredOblConcDetRubList;
    private SiiUsuario siiUsuarioRegistra;
    private SiiUsuario siiUsuarioAprueba;
    private String ncrMotivoAnula;
    private String ncrConcepto;



    public SiiNotaCredito() {
    }

    public SiiNotaCredito(Long ncrCodigo, Date ncrFecha, Integer ncrNumero, String ncrRcIndepend, String ncrTipoNota,
                          SiiObligacion siiObligacion) {
        this.ncrCodigo = ncrCodigo;
        this.ncrFecha = ncrFecha;
        this.ncrNumero = ncrNumero;
        this.ncrRcIndepend = ncrRcIndepend;
        this.ncrTipoNota = ncrTipoNota;
        this.siiObligacion = siiObligacion;
    }

    @Id
    @Column(name = "NCR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_NOTA_CREDITO_COD")
    @SequenceGenerator(name = "SEQ_NOTA_CREDITO_COD", sequenceName = "SEQ_NOTA_CREDITO_COD",allocationSize=1)
    public Long getNcrCodigo() {
        return ncrCodigo;
    }

    public void setNcrCodigo(Long ncrCodigo) {
        this.ncrCodigo = ncrCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NCR_FECHA", nullable = false)
    public Date getNcrFecha() {
        return ncrFecha;
    }

    public void setNcrFecha(Date ncrFecha) {
        this.ncrFecha = ncrFecha;
    }

    @Column(name = "NCR_NUMERO", nullable = false)
    public Integer getNcrNumero() {
        return ncrNumero;
    }

    public void setNcrNumero(Integer ncrNumero) {
        this.ncrNumero = ncrNumero;
    }

    @Column(name = "NCR_RC_INDEPEND", length = 1)
    public String getNcrRcIndepend() {
        return ncrRcIndepend;
    }

    public void setNcrRcIndepend(String ncrRcIndepend) {
        this.ncrRcIndepend = ncrRcIndepend;
    }

    @Column(name = "NCR_TIPO_NOTA", nullable = false, length = 3)
    public String getNcrTipoNota() {
        return ncrTipoNota;
    }

    public void setNcrTipoNota(String ncrTipoNota) {
        this.ncrTipoNota = ncrTipoNota;
    }


    @OneToMany(mappedBy = "siiNotaCredito")
    public List<SiiNotaCredOblConcepto> getSiiNotaCredOblConceptoList() {
        return siiNotaCredOblConceptoList;
    }

    public void setSiiNotaCredOblConceptoList(List<SiiNotaCredOblConcepto> siiNotaCredOblConceptoList) {
        this.siiNotaCredOblConceptoList = siiNotaCredOblConceptoList;
    }

    public SiiNotaCredOblConcepto addSiiNotaCredOblConcepto(SiiNotaCredOblConcepto siiNotaCredOblConcepto) {
        getSiiNotaCredOblConceptoList().add(siiNotaCredOblConcepto);
        siiNotaCredOblConcepto.setSiiNotaCredito(this);
        return siiNotaCredOblConcepto;
    }

    public SiiNotaCredOblConcepto removeSiiNotaCredOblConcepto(SiiNotaCredOblConcepto siiNotaCredOblConcepto) {
        getSiiNotaCredOblConceptoList().remove(siiNotaCredOblConcepto);
        siiNotaCredOblConcepto.setSiiNotaCredito(null);
        return siiNotaCredOblConcepto;
    }

    @OneToMany(mappedBy = "siiNotaCredito")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiNotaCredito(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiNotaCredito(null);
        return siiDocumentoContable;
    }

    @ManyToOne
    @JoinColumn(name = "OBL_CODIGO")
    public SiiObligacion getSiiObligacion() {
        return siiObligacion;
    }

    public void setSiiObligacion(SiiObligacion siiObligacion) {
        this.siiObligacion = siiObligacion;
    }

    @OneToMany(mappedBy = "siiNotaCredito")
    public List<SiiReintegroIngresoPag> getSiiReintegroIngresoPagList() {
        return siiReintegroIngresoPagList;
    }

    public void setSiiReintegroIngresoPagList(List<SiiReintegroIngresoPag> siiReintegroIngresoPagList) {
        this.siiReintegroIngresoPagList = siiReintegroIngresoPagList;
    }

    public SiiReintegroIngresoPag addSiiReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) {
        getSiiReintegroIngresoPagList().add(siiReintegroIngresoPag);
        siiReintegroIngresoPag.setSiiNotaCredito(this);
        return siiReintegroIngresoPag;
    }

    public SiiReintegroIngresoPag removeSiiReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) {
        getSiiReintegroIngresoPagList().remove(siiReintegroIngresoPag);
        siiReintegroIngresoPag.setSiiNotaCredito(null);
        return siiReintegroIngresoPag;
    }

    @ManyToOne
    @JoinColumn(name = "FFC_CODIGO")
    public SiiFuenteFinancContab getSiiFuenteFinancContab() {
        return siiFuenteFinancContab;
    }

    public void setSiiFuenteFinancContab(SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiFuenteFinancContab = siiFuenteFinancContab;
    }

    @Column(name = "NCR_ESTADO", length = 1)
    public String getNcrEstado() {
        return ncrEstado;
    }
    
    public void setNcrEstado(String ncrEstado) {
        this.ncrEstado = ncrEstado;
    }
    
    @OneToMany(mappedBy = "siiNotaCredito")
    public List<SiiNotaCredOblConcDetRub> getSiiNotaCredOblConcDetRubList() {
        return siiNotaCredOblConcDetRubList;
    }

    public void setSiiNotaCredOblConcDetRubList(List<SiiNotaCredOblConcDetRub> siiNotaCredOblConcDetRubList) {
        this.siiNotaCredOblConcDetRubList = siiNotaCredOblConcDetRubList;
    }

    public SiiNotaCredOblConcDetRub addSiiNotaCredOblConcDetRub(SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub) {
        getSiiNotaCredOblConcDetRubList().add(siiNotaCredOblConcDetRub);
        siiNotaCredOblConcDetRub.setSiiNotaCredito(this);
        return siiNotaCredOblConcDetRub;
    }

    public SiiNotaCredOblConcDetRub removeSiiNotaCredOblConcDetRub(SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub) {
        getSiiNotaCredOblConcDetRubList().remove(siiNotaCredOblConcDetRub);
        siiNotaCredOblConcDetRub.setSiiNotaCredito(null);
        return siiNotaCredOblConcDetRub;
    }
    
    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_REGIST")
    public SiiUsuario getSiiUsuarioRegistra() {
        return siiUsuarioRegistra;
    }

    public void setSiiUsuarioRegistra(SiiUsuario siiUsuarioRegistra) {
        this.siiUsuarioRegistra = siiUsuarioRegistra;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_APRUEBA")
    public SiiUsuario getSiiUsuarioAprueba() {
        return siiUsuarioAprueba;
    }

    public void setSiiUsuarioAprueba(SiiUsuario siiUsuarioAprueba) {
        this.siiUsuarioAprueba = siiUsuarioAprueba;
    }
    
    @Column(name = "NCR_MOTIVO_ANULA", length = 500)
    public String getNcrMotivoAnula() {
        return ncrMotivoAnula;
    }

    public void setNcrMotivoAnula(String ncrMotivoAnula) {
        this.ncrMotivoAnula = ncrMotivoAnula;
    }

    @Column(name = "NCR_CONCEPTO", length = 600)
    public String getNcrConcepto() {
        return ncrConcepto;
    }

    public void setNcrConcepto(String ncrConcepto) {
        this.ncrConcepto = ncrConcepto;
    }

    

}
