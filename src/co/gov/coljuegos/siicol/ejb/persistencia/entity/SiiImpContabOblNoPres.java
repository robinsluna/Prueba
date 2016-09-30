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
@Table(name = "SII_IMP_CONTAB_OBL_NO_PRES")
public class SiiImpContabOblNoPres implements Serializable {
    private static final long serialVersionUID = 6165393390280276367L;
    private Long ionCodigo;
    private SiiCuentasContables siiCuentasContables;
    private SiiImputacionContable siiImputacionContable;
    private SiiObligacionNoPresup siiObligacionNoPresup;
    private String ionEstado;

    public SiiImpContabOblNoPres() {
    }

    public SiiImpContabOblNoPres(SiiCuentasContables siiCuentasContables, SiiImputacionContable siiImputacionContable,
                                 Long ionCodigo, SiiObligacionNoPresup siiObligacionNoPresup) {
        this.siiCuentasContables = siiCuentasContables;
        this.siiImputacionContable = siiImputacionContable;
        this.ionCodigo = ionCodigo;
        this.siiObligacionNoPresup = siiObligacionNoPresup;
    }


    @Id
    @Column(name = "ION_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_IMP_CONT_OBL_NO_PRES_COD")
    @SequenceGenerator(name = "SEQ_IMP_CONT_OBL_NO_PRES_COD", sequenceName = "SEQ_IMP_CONT_OBL_NO_PRES_COD",allocationSize=1)
    public Long getIonCodigo() {
        return ionCodigo;
    }

    public void setIonCodigo(Long ionCodigo) {
        this.ionCodigo = ionCodigo;
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
    @JoinColumn(name = "IMC_CODIGO")
    public SiiImputacionContable getSiiImputacionContable() {
        return siiImputacionContable;
    }

    public void setSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        this.siiImputacionContable = siiImputacionContable;
    }

    @ManyToOne
    @JoinColumn(name = "ONP_CODIGO")
    public SiiObligacionNoPresup getSiiObligacionNoPresup() {
        return siiObligacionNoPresup;
    }

    public void setSiiObligacionNoPresup(SiiObligacionNoPresup siiObligacionNoPresup) {
        this.siiObligacionNoPresup = siiObligacionNoPresup;
    }

    @Column(name = "ION_ESTADO", nullable = false, length = 1)
    public String getIonEstado() {
        return ionEstado;
    }

    public void setIonEstado(String ionEstado) {
        this.ionEstado = ionEstado;
    }
}
