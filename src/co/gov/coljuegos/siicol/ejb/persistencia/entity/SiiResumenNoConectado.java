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
@Table(name = "SII_RESUMEN_NO_CONECTADO")
public class SiiResumenNoConectado implements Serializable {
    private static final long serialVersionUID = -6540382895185081000L;
    private Long rncCodigo;
    private Integer rncNumElemen;
    private BigDecimal rncValorDe;
    private BigDecimal rncValorTarifa;
    private SiiCuotaOperador siiCuotaOperador;
    private SiiTipoApuesta siiTipoApuesta;

    public SiiResumenNoConectado() {
    }

    public SiiResumenNoConectado(SiiCuotaOperador siiCuotaOperador, Long rncCodigo, Integer rncNumElemen, BigDecimal rncValorDe, BigDecimal rncValorTarifa) {
        this.siiCuotaOperador = siiCuotaOperador;
        this.rncCodigo = rncCodigo;
        this.rncNumElemen = rncNumElemen;
        this.rncValorDe = rncValorDe;
        this.rncValorTarifa = rncValorTarifa;
    }


    @Id
    @Column(name = "RNC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESUMEN_NO_CONECTADO_COD")
    @SequenceGenerator(name = "SEQ_RESUMEN_NO_CONECTADO_COD", sequenceName = "SEQ_RESUMEN_NO_CONECTADO_COD",allocationSize=1)public Long getRncCodigo() {
        return rncCodigo;
    }

    public void setRncCodigo(Long rncCodigo) {
        this.rncCodigo = rncCodigo;
    }

    @Column(name = "RNC_NUM_ELEMEN", nullable = false)
    public Integer getRncNumElemen() {
        return rncNumElemen;
    }

    public void setRncNumElemen(Integer rncNumElemen) {
        this.rncNumElemen = rncNumElemen;
    }

    @Column(name = "RNC_VALOR_DE", nullable = false)
    public BigDecimal getRncValorDe() {
        return rncValorDe;
    }

    public void setRncValorDe(BigDecimal rncValorDe) {
        this.rncValorDe = rncValorDe;
    }

    @Column(name = "RNC_VALOR_TARIFA", nullable = false)
    public BigDecimal getRncValorTarifa() {
        return rncValorTarifa;
    }

    public void setRncValorTarifa(BigDecimal rncValorTarifa) {
        this.rncValorTarifa = rncValorTarifa;
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
    @JoinColumn(name = "TAP_CODIGO")
    public SiiTipoApuesta getSiiTipoApuesta() {
        return siiTipoApuesta;
    }

    public void setSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        this.siiTipoApuesta = siiTipoApuesta;
    }
}
