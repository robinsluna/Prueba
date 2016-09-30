package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_DETALLE_CIERRE_CONT")
public class SiiDetalleCierreCont implements Serializable {
    private static final long serialVersionUID = 1504082974987059648L;
    private Long decCodigo;
    private Date decFechaCierre;
    private BigDecimal decSaldo;
    private SiiPersona siiPersona;
    private SiiCierreContable siiCierreContable;
    private SiiCuentasContables siiCuentasContables;

    public SiiDetalleCierreCont() {
    }

    public SiiDetalleCierreCont(SiiCuentasContables siiCuentasContables, SiiCierreContable siiCierreContable,
                                Long decCodigo, Date decFechaCierre, BigDecimal decSaldo, SiiPersona siiPersona) {
        this.siiCuentasContables = siiCuentasContables;
        this.siiCierreContable = siiCierreContable;
        this.decCodigo = decCodigo;
        this.decFechaCierre = decFechaCierre;
        this.decSaldo = decSaldo;
        this.siiPersona = siiPersona;
    }


    @Id
    @Column(name = "DEC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DET_CIERRE_CONT_COD")
    @SequenceGenerator(name = "SEQ_DET_CIERRE_CONT_COD", sequenceName = "SEQ_DET_CIERRE_CONT_COD",allocationSize=1)
    public Long getDecCodigo() {
        return decCodigo;
    }

    public void setDecCodigo(Long decCodigo) {
        this.decCodigo = decCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEC_FECHA_CIERRE", nullable = false)
    public Date getDecFechaCierre() {
        return decFechaCierre;
    }

    public void setDecFechaCierre(Date decFechaCierre) {
        this.decFechaCierre = decFechaCierre;
    }

    @Column(name = "DEC_SALDO", nullable = false, length = 20)
    public BigDecimal getDecSaldo() {
        return decSaldo;
    }

    public void setDecSaldo(BigDecimal decSaldo) {
        this.decSaldo = decSaldo;
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
    @JoinColumn(name = "CIC_CODIGO")
    public SiiCierreContable getSiiCierreContable() {
        return siiCierreContable;
    }

    public void setSiiCierreContable(SiiCierreContable siiCierreContable) {
        this.siiCierreContable = siiCierreContable;
    }

    @ManyToOne
    @JoinColumn(name = "CCO_CODIGO")
    public SiiCuentasContables getSiiCuentasContables() {
        return siiCuentasContables;
    }

    public void setSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        this.siiCuentasContables = siiCuentasContables;
    }
}
