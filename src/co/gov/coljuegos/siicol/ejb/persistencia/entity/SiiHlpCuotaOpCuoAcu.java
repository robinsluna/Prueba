package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_HLP_CUOTA_OP_CUO_ACU")
public class SiiHlpCuotaOpCuoAcu implements Serializable {
    private static final long serialVersionUID = 6250845139720082618L;
    private BigDecimal hcaValor;
    private BigDecimal hcaValorAbono;
    private BigDecimal hcaValorAbInt;
    private BigDecimal hcaValorInt;
    private Long hcoCodigo;
    private SiiCuotaOperador siiCuotaOperador;
    private SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo;
    private BigDecimal hcaSaldoCapital;
    private BigDecimal hcaSaldoInteres;

    public SiiHlpCuotaOpCuoAcu() {
    }

    public SiiHlpCuotaOpCuoAcu(SiiCuotaOperador siiCuotaOperador, SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo, BigDecimal hcaValor,
                               BigDecimal hcaValorAbInt, BigDecimal hcaValorAbono, BigDecimal hcaValorInt, Long hcoCodigo) {
        this.siiCuotaOperador = siiCuotaOperador;
        this.siiHlpCuotaAcuerdo = siiHlpCuotaAcuerdo;
        this.hcaValor = hcaValor;
        this.hcaValorAbInt = hcaValorAbInt;
        this.hcaValorAbono = hcaValorAbono;
        this.hcaValorInt = hcaValorInt;
        this.hcoCodigo = hcoCodigo;
    }

    @Column(name = "HCA_SALDO_CAPITAL")
    public BigDecimal getHcaSaldoCapital() {
        return hcaSaldoCapital;
    }

    public void setHcaSaldoCapital(BigDecimal hcaSaldoCapital) {
        this.hcaSaldoCapital = hcaSaldoCapital;
    }

    @Column(name = "HCA_SALDO_INTERES")
    public BigDecimal getHcaSaldoInteres() {
        return hcaSaldoInteres;
    }

    public void setHcaSaldoInteres(BigDecimal hcaSaldoInteres) {
        this.hcaSaldoInteres = hcaSaldoInteres;
    }

    @Column(name = "HCA_VALOR")
    public BigDecimal getHcaValor() {
        return hcaValor;
    }

    public void setHcaValor(BigDecimal hcaValor) {
        this.hcaValor = hcaValor;
    }

    @Column(name = "HCA_VALOR_ABONO")
    public BigDecimal getHcaValorAbono() {
        return hcaValorAbono;
    }

    public void setHcaValorAbono(BigDecimal hcaValorAbono) {
        this.hcaValorAbono = hcaValorAbono;
    }

    @Column(name = "HCA_VALOR_AB_INT")
    public BigDecimal getHcaValorAbInt() {
        return hcaValorAbInt;
    }

    public void setHcaValorAbInt(BigDecimal hcaValorAbInt) {
        this.hcaValorAbInt = hcaValorAbInt;
    }

    @Column(name = "HCA_VALOR_INT")
    public BigDecimal getHcaValorInt() {
        return hcaValorInt;
    }

    public void setHcaValorInt(BigDecimal hcaValorInt) {
        this.hcaValorInt = hcaValorInt;
    }

    @Id
    @Column(name = "HCO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HLP_CUO_OP_CUO_ACU_COD")
    @SequenceGenerator(name = "SEQ_HLP_CUO_OP_CUO_ACU_COD", sequenceName = "SEQ_HLP_CUO_OP_CUO_ACU_COD",allocationSize=1)
    public Long getHcoCodigo() {
        return hcoCodigo;
    }

    public void setHcoCodigo(Long hcoCodigo) {
        this.hcoCodigo = hcoCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "COP_CODIGO")
    public SiiCuotaOperador getSiiCuotaOperador() {
        return siiCuotaOperador;
    }

    public void setSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        this.siiCuotaOperador = siiCuotaOperador;
    }

    @ManyToOne
    @JoinColumn(name = "HCA_CODIGO")
    public SiiHlpCuotaAcuerdo getSiiHlpCuotaAcuerdo() {
        return siiHlpCuotaAcuerdo;
    }

    public void setSiiHlpCuotaAcuerdo(SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo) {
        this.siiHlpCuotaAcuerdo = siiHlpCuotaAcuerdo;
    }
}
