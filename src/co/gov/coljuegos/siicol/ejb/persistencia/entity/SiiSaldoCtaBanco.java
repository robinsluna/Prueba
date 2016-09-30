package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_SALDO_CTA_BANCO")
public class SiiSaldoCtaBanco implements Serializable {
    private static final long serialVersionUID = 1770615935551165465L;
    private Long scbCodigo;
    private String scbEstado;
    private Date scbFecha;
    private BigDecimal scbSaldo;
    private SiiCuentaBancaria siiCuentaBancaria;

    public SiiSaldoCtaBanco() {
    }

    public SiiSaldoCtaBanco(SiiCuentaBancaria siiCuentaBancaria, Long scbCodigo, String scbEstado, Date scbFecha,
                            BigDecimal scbSaldo) {
        this.siiCuentaBancaria = siiCuentaBancaria;
        this.scbCodigo = scbCodigo;
        this.scbEstado = scbEstado;
        this.scbFecha = scbFecha;
        this.scbSaldo = scbSaldo;
    }


    @Id
    @Column(name = "SCB_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SALDO_CTA_BANCO_COD")
    @SequenceGenerator(name = "SEQ_SALDO_CTA_BANCO_COD", sequenceName = "SEQ_SALDO_CTA_BANCO_COD",allocationSize=1)
    public Long getScbCodigo() {
        return scbCodigo;
    }

    public void setScbCodigo(Long scbCodigo) {
        this.scbCodigo = scbCodigo;
    }

    @Column(name = "SCB_ESTADO", nullable = false, length = 1)
    public String getScbEstado() {
        return scbEstado;
    }

    public void setScbEstado(String scbEstado) {
        this.scbEstado = scbEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCB_FECHA", nullable = false)
    public Date getScbFecha() {
        return scbFecha;
    }

    public void setScbFecha(Date scbFecha) {
        this.scbFecha = scbFecha;
    }

    @Column(name = "SCB_SALDO", nullable = false)
    public BigDecimal getScbSaldo() {
        return scbSaldo;
    }

    public void setScbSaldo(BigDecimal scbSaldo) {
        this.scbSaldo = scbSaldo;
    }

    @ManyToOne
    @JoinColumn(name = "CBA_CODIGO")
    public SiiCuentaBancaria getSiiCuentaBancaria() {
        return siiCuentaBancaria;
    }

    public void setSiiCuentaBancaria(SiiCuentaBancaria siiCuentaBancaria) {
        this.siiCuentaBancaria = siiCuentaBancaria;
    }
}
