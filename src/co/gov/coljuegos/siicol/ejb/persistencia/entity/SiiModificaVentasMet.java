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
@Table(name = "SII_MODIFICA_VENTAS_MET")
public class SiiModificaVentasMet implements Serializable {
    private static final long serialVersionUID = 9027561713623304082L;
    private Long mvmCodigo;
    private Date mvmFecha;
    private BigDecimal mvmValorVentas;
    private SiiReporteVentas siiReporteVentas;
    private SiiVentasMet siiVentasMet;
    private BigDecimal mvmLiqTarifaFija;
    private BigDecimal mvmLiqTarifaVar;
    private BigDecimal mvmLiqEfectiva;
    //private Long vmeMovimiento;

    public SiiModificaVentasMet() {
    }

    public SiiModificaVentasMet(Long mvmCodigo, Date mvmFecha, BigDecimal mvmValorVentas, SiiReporteVentas siiReporteVentas, SiiVentasMet siiVentasMet) {
        this.mvmCodigo = mvmCodigo;
        this.mvmFecha = mvmFecha;
        this.mvmValorVentas = mvmValorVentas;
        this.siiReporteVentas = siiReporteVentas;
        this.siiVentasMet = siiVentasMet;
    }

    @Id
    @Column(name = "MVM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODIFICA_VENTAS_MET_COD")
    @SequenceGenerator(name = "SEQ_MODIFICA_VENTAS_MET_COD", sequenceName = "SEQ_MODIFICA_VENTAS_MET_COD",allocationSize=1)
    public Long getMvmCodigo() {
        return mvmCodigo;
    }

    public void setMvmCodigo(Long mvmCodigo) {
        this.mvmCodigo = mvmCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MVM_FECHA", nullable = false)
    public Date getMvmFecha() {
        return mvmFecha;
    }

    public void setMvmFecha(Date mvmFecha) {
        this.mvmFecha = mvmFecha;
    }

    @Column(name = "MVM_VALOR_VENTAS", nullable = false)
    public BigDecimal getMvmValorVentas() {
        return mvmValorVentas;
    }

    public void setMvmValorVentas(BigDecimal mvmValorVentas) {
        this.mvmValorVentas = mvmValorVentas;
    }


    @ManyToOne
    @JoinColumn(name = "RVE_CODIGO")
    public SiiReporteVentas getSiiReporteVentas() {
        return siiReporteVentas;
    }

    public void setSiiReporteVentas(SiiReporteVentas siiReporteVentas) {
        this.siiReporteVentas = siiReporteVentas;
    }

    @ManyToOne
    @JoinColumn(name = "VME_CODIGO")
    public SiiVentasMet getSiiVentasMet() {
        return siiVentasMet;
    }

    public void setSiiVentasMet(SiiVentasMet siiVentasMet) {
        this.siiVentasMet = siiVentasMet;
    }

    @Column(name = "MVM_LIQ_TARIFA_FIJA")
    public BigDecimal getMvmLiqTarifaFija() {
        return mvmLiqTarifaFija;
    }
    
    public void setMvmLiqTarifaFija(BigDecimal mvmLiqTarifaFija) {
        this.mvmLiqTarifaFija = mvmLiqTarifaFija;
    }

    
    @Column(name = "MVM_LIQ_TARIFA_VAR")
    public BigDecimal getMvmLiqTarifaVar() {
        return mvmLiqTarifaVar;
    }
    
    public void setMvmLiqTarifaVar(BigDecimal mvmLiqTarifaVar) {
        this.mvmLiqTarifaVar = mvmLiqTarifaVar;
    }

    
    @Column(name = "MVM_LIQ_EFECTIVA")
    public BigDecimal getMvmLiqEfectiva() {
        return mvmLiqEfectiva;
    }
    
    public void setMvmLiqEfectiva(BigDecimal mvmLiqEfectiva) {
        this.mvmLiqEfectiva = mvmLiqEfectiva;
    }

    /* @Column(name = "MVM_MOVIMIENTO")
    public Long getVmeMovimiento() {
        return vmeMovimiento;
    }
    
    public void setVmeMovimiento(Long vmeMovimiento) {
        this.vmeMovimiento = vmeMovimiento;
    } */

    

}
