package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CONCEPTO_GASTO")
public class SiiConceptoGasto implements Serializable {
    private static final long serialVersionUID = 6238126765579626751L;
    private Long cgaCodigo;
    private String cgaCodigoSiicol;
    private SiiComprobAsociado siiComprobAsociado;
    private String cgaModulo;
    private String cgaNombre;
    private List<SiiObligacionConcepto> siiObligacionConceptoList1;
    private SiiCuentasContables siiCuentasContablesDeb;
    private SiiCuentasContables siiCuentasContablesCred;

    public SiiConceptoGasto() {
    }

    public SiiConceptoGasto(Long cgaCodigo, String cgaCodigoSiicol, SiiComprobAsociado siiComprobAsociado,
                            String cgaModulo, String cgaNombre,
                            SiiCuentasContables siiCuentasContablesDeb, SiiCuentasContables siiCuentasContablesCred) {
        this.cgaCodigo = cgaCodigo;
        this.cgaCodigoSiicol = cgaCodigoSiicol;
        this.cgaModulo = cgaModulo;
        this.cgaNombre = cgaNombre;
        this.siiCuentasContablesDeb = siiCuentasContablesDeb;
        this.siiCuentasContablesCred = siiCuentasContablesCred;
        this.siiComprobAsociado = siiComprobAsociado;        
    }


    @Id
    @Column(name = "CGA_CODIGO", nullable = false)
    public Long getCgaCodigo() {
        return cgaCodigo;
    }

    public void setCgaCodigo(Long cgaCodigo) {
        this.cgaCodigo = cgaCodigo;
    }

    @Column(name = "CGA_CODIGO_SIICOL", nullable = false, length = 5)
    public String getCgaCodigoSiicol() {
        return cgaCodigoSiicol;
    }

    public void setCgaCodigoSiicol(String cgaCodigoSiicol) {
        this.cgaCodigoSiicol = cgaCodigoSiicol;
    }

    @Column(name = "CGA_MODULO", nullable = false, length = 2)
    public String getCgaModulo() {
        return cgaModulo;
    }

    public void setCgaModulo(String cgaModulo) {
        this.cgaModulo = cgaModulo;
    }

    @Column(name = "CGA_NOMBRE", nullable = false, length = 100)
    public String getCgaNombre() {
        return cgaNombre;
    }

    public void setCgaNombre(String cgaNombre) {
        this.cgaNombre = cgaNombre;
    }

    @OneToMany(mappedBy = "siiConceptoGasto")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoList1() {
        return siiObligacionConceptoList1;
    }

    public void setSiiObligacionConceptoList1(List<SiiObligacionConcepto> siiObligacionConceptoList1) {
        this.siiObligacionConceptoList1 = siiObligacionConceptoList1;
    }

    public SiiObligacionConcepto addSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList1().add(siiObligacionConcepto);
        siiObligacionConcepto.setSiiConceptoGasto(this);
        return siiObligacionConcepto;
    }

    public SiiObligacionConcepto removeSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList1().remove(siiObligacionConcepto);
        siiObligacionConcepto.setSiiConceptoGasto(null);
        return siiObligacionConcepto;
    }

    @ManyToOne
    @JoinColumn(name = "CCO_CODIGO_DEBITO")
    public SiiCuentasContables getSiiCuentasContablesDeb() {
        return siiCuentasContablesDeb;
    }

    public void setSiiCuentasContablesDeb(SiiCuentasContables siiCuentasContablesDeb) {
        this.siiCuentasContablesDeb = siiCuentasContablesDeb;
    }

    @ManyToOne
    @JoinColumn(name = "CCO_CODIGO_CREDITO")
    public SiiCuentasContables getSiiCuentasContablesCred() {
        return siiCuentasContablesCred;
    }

    public void setSiiCuentasContablesCred(SiiCuentasContables siiCuentasContablesCred) {
        this.siiCuentasContablesCred = siiCuentasContablesCred;
    }

    @ManyToOne
    @JoinColumn(name = "CAS_CODIGO")
    public SiiComprobAsociado getSiiComprobAsociado() {
        return siiComprobAsociado;
    }

    public void setSiiComprobAsociado(SiiComprobAsociado siiComprobAsociado) {
        this.siiComprobAsociado = siiComprobAsociado;
    }
}
