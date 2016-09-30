package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_CUENTA_CONT_TIPO_DOC_CONT")
public class SiiCuentaContTipoDocCont implements Serializable {
    private static final long serialVersionUID = -7761541906880901046L;
    private Long cctCodigo;
    private String cctConcepto;
    private String cctTipoCartera;
    private String cctTipoMovim;
    private SiiTipoDocContable siiTipoDocContable;
    private SiiAreaColjuegos siiAreaColjuegos;
    private SiiPersona siiPersona;
    private SiiCuentasContables siiCuentasContables;
    private SiiFuenteFinancContab siiFuenteFinancContab;
    private String cctTipoRetNomina;
    private String cctDestRecSinC;
    private String cctIndicador1;
    private String cctActivo;

    public SiiCuentaContTipoDocCont() {
    }

    public SiiCuentaContTipoDocCont(SiiAreaColjuegos siiAreaColjuegos, SiiCuentasContables siiCuentasContables,
                                    Long cctCodigo, String cctConcepto, String cctTipoCartera, String cctTipoMovim,
                                    SiiFuenteFinancContab siiFuenteFinancContab, SiiPersona siiPersona,
                                    SiiTipoDocContable siiTipoDocContable) {
        this.siiAreaColjuegos = siiAreaColjuegos;
        this.siiCuentasContables = siiCuentasContables;
        this.cctCodigo = cctCodigo;
        this.cctConcepto = cctConcepto;
        this.cctTipoCartera = cctTipoCartera;
        this.cctTipoMovim = cctTipoMovim;
        this.siiFuenteFinancContab = siiFuenteFinancContab;
        this.siiPersona = siiPersona;
        this.siiTipoDocContable = siiTipoDocContable;
    }


    @Id
    @Column(name = "CCT_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUEN_CONT_TIP_DOC_CONT_COD")
    @SequenceGenerator(name = "SEQ_CUEN_CONT_TIP_DOC_CONT_COD", sequenceName = "SEQ_CUEN_CONT_TIP_DOC_CONT_COD",allocationSize=1)
    public Long getCctCodigo() {
        return cctCodigo;
    }

    public void setCctCodigo(Long cctCodigo) {
        this.cctCodigo = cctCodigo;
    }

    @Column(name = "CCT_CONCEPTO", length = 2)
    public String getCctConcepto() {
        return cctConcepto;
    }

    public void setCctConcepto(String cctConcepto) {
        this.cctConcepto = cctConcepto;
    }

    @Column(name = "CCT_TIPO_CARTERA", length = 1)
    public String getCctTipoCartera() {
        return cctTipoCartera;
    }

    public void setCctTipoCartera(String cctTipoCartera) {
        this.cctTipoCartera = cctTipoCartera;
    }

    @Column(name = "CCT_TIPO_MOVIM", nullable = false, length = 1)
    public String getCctTipoMovim() {
        return cctTipoMovim;
    }

    public void setCctTipoMovim(String cctTipoMovim) {
        this.cctTipoMovim = cctTipoMovim;
    }


    @ManyToOne
    @JoinColumn(name = "TDC_CODIGO")
    public SiiTipoDocContable getSiiTipoDocContable() {
        return siiTipoDocContable;
    }

    public void setSiiTipoDocContable(SiiTipoDocContable siiTipoDocContable) {
        this.siiTipoDocContable = siiTipoDocContable;
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
    @JoinColumn(name = "PER_CODIGO_TERCERO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "CCO_CODIGO")
    public SiiCuentasContables getSiiCuentasContables() {
        return siiCuentasContables;
    }

    public void setSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        this.siiCuentasContables = siiCuentasContables;
    }

    @ManyToOne
    @JoinColumn(name = "FFC_CODIGO")
    public SiiFuenteFinancContab getSiiFuenteFinancContab() {
        return siiFuenteFinancContab;
    }

    public void setSiiFuenteFinancContab(SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiFuenteFinancContab = siiFuenteFinancContab;
    }

    @Column(name = "CCT_TIPO_RET_NOMINA", length = 5)
    public String getCctTipoRetNomina() {
        return cctTipoRetNomina;
    }

    public void setCctTipoRetNomina(String cctTipoRetNomina) {
        this.cctTipoRetNomina = cctTipoRetNomina;
    }

    @Column(name = "CCT_DEST_REC_SIN_C", length = 2)
    public String getCctDestRecSinC() {
        return cctDestRecSinC;
    }

    public void setCctDestRecSinC(String cctDestRecSinC) {
        this.cctDestRecSinC = cctDestRecSinC;
    }

    @Column(name = "CCT_INDICADOR1", length = 20)
    public String getCctIndicador1() {
        return cctIndicador1;
    }

    public void setCctIndicador1(String cctIndicador1) {
        this.cctIndicador1 = cctIndicador1;
    }

    @Column(name = "CCT_ACTIVO", nullable = false, length = 20)
    public String getCctActivo() {
        return cctActivo;
    }

    public void setCctActivo(String cctActivo) {
        this.cctActivo = cctActivo;
    }
}
