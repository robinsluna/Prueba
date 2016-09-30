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
@Table(name = "SII_ACTUALIZAC_CUOTA_OPE")
public class SiiActualizacCuotaOpe implements Serializable {
    private static final long serialVersionUID = -3014368379031082777L;
    private Long aopCodigo;
    private BigDecimal aopIncremento;
    private BigDecimal aopSaldo;
    private SiiActualizacionMulta siiActualizacionMulta;
    private SiiCuotaOperador siiCuotaOperador;

    public SiiActualizacCuotaOpe() {
    }

    public SiiActualizacCuotaOpe(SiiActualizacionMulta siiActualizacionMulta, Long aopCodigo, BigDecimal aopIncremento, BigDecimal aopSaldo, SiiCuotaOperador siiCuotaOperador) {
        this.siiActualizacionMulta = siiActualizacionMulta;
        this.aopCodigo = aopCodigo;
        this.aopIncremento = aopIncremento;
        this.aopSaldo = aopSaldo;
        this.siiCuotaOperador = siiCuotaOperador;
    }


    @Id
    @Column(name = "AOP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACTUALIZAC_CUOTA_OPE_COD")
    @SequenceGenerator(name = "SEQ_ACTUALIZAC_CUOTA_OPE_COD", sequenceName = "SEQ_ACTUALIZAC_CUOTA_OPE_COD",allocationSize=1)
    public Long getAopCodigo() {
        return aopCodigo;
    }

    public void setAopCodigo(Long aopCodigo) {
        this.aopCodigo = aopCodigo;
    }

    @Column(name = "AOP_INCREMENTO", nullable = false)
    public BigDecimal getAopIncremento() {
        return aopIncremento;
    }

    public void setAopIncremento(BigDecimal aopIncremento) {
        this.aopIncremento = aopIncremento;
    }

    @Column(name = "AOP_SALDO", nullable = false)
    public BigDecimal getAopSaldo() {
        return aopSaldo;
    }

    public void setAopSaldo(BigDecimal aopSaldo) {
        this.aopSaldo = aopSaldo;
    }


    @ManyToOne
    @JoinColumn(name = "AMU_CODIGO")
    public SiiActualizacionMulta getSiiActualizacionMulta() {
        return siiActualizacionMulta;
    }

    public void setSiiActualizacionMulta(SiiActualizacionMulta siiActualizacionMulta) {
        this.siiActualizacionMulta = siiActualizacionMulta;
    }

    @ManyToOne
    @JoinColumn(name = "COP_CODIGO")
    public SiiCuotaOperador getSiiCuotaOperador() {
        return siiCuotaOperador;
    }

    public void setSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        this.siiCuotaOperador = siiCuotaOperador;
    }
}
