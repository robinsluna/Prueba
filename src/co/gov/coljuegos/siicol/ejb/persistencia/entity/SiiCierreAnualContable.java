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
@Table(name = "SII_CIERRE_ANUAL_CONT")
public class SiiCierreAnualContable implements Serializable {
    private static final long serialVersionUID = -896076656941589553L;
    private String cacBancarias;
    private Long cacCodigo;
    private Date cacFechaCierre;
    private String cacImpuestos;
    private String cacVigFiscal;
    private Integer cacVigencia;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private SiiEstadoCierreAnualCont siiEstadoCierreAnualCont;

    public SiiCierreAnualContable() {
    }

    public SiiCierreAnualContable(String cacBancarias, Long cacCodigo, Date cacFechaCierre, String cacImpuestos,
                                  String cacVigFiscal, Integer cacVigencia,
                                  SiiEstadoCierreAnualCont siiEstadoCierreAnualCont) {
        this.cacBancarias = cacBancarias;
        this.cacCodigo = cacCodigo;
        this.cacFechaCierre = cacFechaCierre;
        this.cacImpuestos = cacImpuestos;
        this.cacVigFiscal = cacVigFiscal;
        this.cacVigencia = cacVigencia;
        this.siiEstadoCierreAnualCont = siiEstadoCierreAnualCont;
    }

    @Column(name = "CAC_BANCARIAS", nullable = false, length = 1)
    public String getCacBancarias() {
        return cacBancarias;
    }

    public void setCacBancarias(String cacBancarias) {
        this.cacBancarias = cacBancarias;
    }

    @Id
    @Column(name = "CAC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CIERRE_ANUAL_CONT_COD")
    @SequenceGenerator(name = "SEQ_CIERRE_ANUAL_CONT_COD", sequenceName = "SEQ_CIERRE_ANUAL_CONT_COD",allocationSize=1)
    public Long getCacCodigo() {
        return cacCodigo;
    }

    public void setCacCodigo(Long cacCodigo) {
        this.cacCodigo = cacCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CAC_FECHA_CIERRE")
    public Date getCacFechaCierre() {
        return cacFechaCierre;
    }

    public void setCacFechaCierre(Date cacFechaCierre) {
        this.cacFechaCierre = cacFechaCierre;
    }

    @Column(name = "CAC_IMPUESTOS", nullable = false, length = 1)
    public String getCacImpuestos() {
        return cacImpuestos;
    }

    public void setCacImpuestos(String cacImpuestos) {
        this.cacImpuestos = cacImpuestos;
    }

    @Column(name = "CAC_VIG_FISCAL", nullable = false, length = 1)
    public String getCacVigFiscal() {
        return cacVigFiscal;
    }

    public void setCacVigFiscal(String cacVigFiscal) {
        this.cacVigFiscal = cacVigFiscal;
    }

    @Column(name = "CAC_VIGENCIA", nullable = false)
    public Integer getCacVigencia() {
        return cacVigencia;
    }

    public void setCacVigencia(Integer cacVigencia) {
        this.cacVigencia = cacVigencia;
    }


    @OneToMany(mappedBy = "siiCierreAnualContable")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiCierreAnualContable(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiCierreAnualContable(null);
        return siiDocumentoContable;
    }

    @ManyToOne
    @JoinColumn(name = "ECA_CODIGO")
    public SiiEstadoCierreAnualCont getSiiEstadoCierreAnualCont() {
        return siiEstadoCierreAnualCont;
    }

    public void setSiiEstadoCierreAnualCont(SiiEstadoCierreAnualCont siiEstadoCierreAnualCont) {
        this.siiEstadoCierreAnualCont = siiEstadoCierreAnualCont;
    }
}
