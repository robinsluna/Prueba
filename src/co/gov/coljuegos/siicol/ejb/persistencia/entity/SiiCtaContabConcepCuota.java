package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CTA_CONTAB_CONCEP_CUOTA")
public class SiiCtaContabConcepCuota implements Serializable {
    private static final long serialVersionUID = -2315699810291803006L;
    private Long cccCodigo;
    private String cccInteres;
    private String cccTipo;
    private SiiCuentasContables siiCuentasContables;
    private SiiConceptoCuota siiConceptoCuota;

    public SiiCtaContabConcepCuota() {
    }

    public SiiCtaContabConcepCuota(Long cccCodigo, String cccInteres, String cccTipo,
                                   SiiCuentasContables siiCuentasContables, SiiConceptoCuota siiConceptoCuota) {
        this.cccCodigo = cccCodigo;
        this.cccInteres = cccInteres;
        this.cccTipo = cccTipo;
        this.siiCuentasContables = siiCuentasContables;
        this.siiConceptoCuota = siiConceptoCuota;
    }

    @Id
    @Column(name = "CCC_CODIGO", nullable = false)
    public Long getCccCodigo() {
        return cccCodigo;
    }

    public void setCccCodigo(Long cccCodigo) {
        this.cccCodigo = cccCodigo;
    }

    @Column(name = "CCC_INTERES", nullable = false, length = 1)
    public String getCccInteres() {
        return cccInteres;
    }

    public void setCccInteres(String cccInteres) {
        this.cccInteres = cccInteres;
    }

    @Column(name = "CCC_TIPO", nullable = false, length = 1)
    public String getCccTipo() {
        return cccTipo;
    }

    public void setCccTipo(String cccTipo) {
        this.cccTipo = cccTipo;
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
    @JoinColumn(name = "CCU_CODIGO")
    public SiiConceptoCuota getSiiConceptoCuota() {
        return siiConceptoCuota;
    }

    public void setSiiConceptoCuota(SiiConceptoCuota siiConceptoCuota) {
        this.siiConceptoCuota = siiConceptoCuota;
    }
}
