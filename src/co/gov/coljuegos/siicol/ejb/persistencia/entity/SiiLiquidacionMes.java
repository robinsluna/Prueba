package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_LIQUIDACION_MES")
public class SiiLiquidacionMes implements Serializable {
    private static final long serialVersionUID = -709925238718969632L;
    private String liqConcepto;
    private Date liqFecha;
    private Date liqFechaLimPago;
    private BigDecimal liqValor;
    private Long lmeCodigo;
    private Integer lmeNumCuota;
    private Integer lmeVigencia;
    private SiiSmmlv siiSmmlv;
    private SiiMes siiMes;
    private SiiContrato siiContrato;
    private List<SiiCuotaOperador> siiCuotaOperadorList;
    private List<SiiLiquidacionEstabl> siiLiquidacionEstablList;
    private List<SiiDocumentoContable> siiDocumentoContableDEList;
    private List<SiiDocumentoContable> siiDocumentoContableGAList;
    private SiiReporteVentas siiReporteVentas;
    private String lmeManual;

    public SiiLiquidacionMes() {
    }

    public SiiLiquidacionMes(SiiContrato siiContrato, String liqConcepto, Date liqFecha, Date liqFechaLimPago,
                             BigDecimal liqValor, Long lmeCodigo, Integer lmeNumCuota, Integer lmeVigencia, SiiMes siiMes,
                             SiiSmmlv siiSmmlv) {
        this.siiContrato = siiContrato;
        this.liqConcepto = liqConcepto;
        this.liqFecha = liqFecha;
        this.liqFechaLimPago = liqFechaLimPago;
        this.liqValor = liqValor;
        this.lmeCodigo = lmeCodigo;
        this.lmeNumCuota = lmeNumCuota;
        this.lmeVigencia = lmeVigencia;
        this.siiMes = siiMes;
        this.siiSmmlv = siiSmmlv;
    }


    @Column(name = "LIQ_CONCEPTO", nullable = false, length = 2)
    public String getLiqConcepto() {
        return liqConcepto;
    }

    public void setLiqConcepto(String liqConcepto) {
        this.liqConcepto = liqConcepto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LIQ_FECHA", nullable = false)
    public Date getLiqFecha() {
        return liqFecha;
    }

    public void setLiqFecha(Date liqFecha) {
        this.liqFecha = liqFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LIQ_FECHA_LIM_PAGO", nullable = false)
    public Date getLiqFechaLimPago() {
        return liqFechaLimPago;
    }

    public void setLiqFechaLimPago(Date liqFechaLimPago) {
        this.liqFechaLimPago = liqFechaLimPago;
    }

    @Column(name = "LIQ_VALOR", nullable = false)
    public BigDecimal getLiqValor() {
        return liqValor;
    }

    public void setLiqValor(BigDecimal liqValor) {
        this.liqValor = liqValor;
    }

    @Id
    @Column(name = "LME_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_LIQUIDACION_MES_COD")
    @SequenceGenerator(name = "SEQ_LIQUIDACION_MES_COD", sequenceName = "SEQ_LIQUIDACION_MES_COD",allocationSize=1)
    public Long getLmeCodigo() {
        return lmeCodigo;
    }

    public void setLmeCodigo(Long lmeCodigo) {
        this.lmeCodigo = lmeCodigo;
    }

    @Column(name = "LME_MANUAL", length = 1)
    public String getLmeManual(){
        return lmeManual;
    }

    public void setLmeManual(String lmeManual){
        this.lmeManual = lmeManual;
    }

    @Column(name = "LME_NUM_CUOTA", nullable = false)
    public Integer getLmeNumCuota() {
        return lmeNumCuota;
    }

    public void setLmeNumCuota(Integer lmeNumCuota) {
        this.lmeNumCuota = lmeNumCuota;
    }

    @Column(name = "LME_VIGENCIA", nullable = false)
    public Integer getLmeVigencia() {
        return lmeVigencia;
    }

    public void setLmeVigencia(Integer lmeVigencia) {
        this.lmeVigencia = lmeVigencia;
    }


    @ManyToOne
    @JoinColumn(name = "SMM_VIGENCIA")
    public SiiSmmlv getSiiSmmlv() {
        return siiSmmlv;
    }

    public void setSiiSmmlv(SiiSmmlv siiSmmlv) {
        this.siiSmmlv = siiSmmlv;
    }

    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @OneToMany(mappedBy = "siiLiquidacionMes")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiLiquidacionMes(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiLiquidacionMes(null);
        return siiCuotaOperador;
    }

    @OneToMany(mappedBy = "siiLiquidacionMes")
    public List<SiiLiquidacionEstabl> getSiiLiquidacionEstablList() {
        return siiLiquidacionEstablList;
    }

    public void setSiiLiquidacionEstablList(List<SiiLiquidacionEstabl> siiLiquidacionEstablList) {
        this.siiLiquidacionEstablList = siiLiquidacionEstablList;
    }

    public SiiLiquidacionEstabl addSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablList().add(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiLiquidacionMes(this);
        return siiLiquidacionEstabl;
    }

    public SiiLiquidacionEstabl removeSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablList().remove(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiLiquidacionMes(null);
        return siiLiquidacionEstabl;
    }

    @OneToMany(mappedBy = "siiLiquidacionMesDE")
    public List<SiiDocumentoContable> getSiiDocumentoContableDEList() {
        return siiDocumentoContableDEList;
    }

    public void setSiiDocumentoContableDEList(List<SiiDocumentoContable> siiDocumentoContableDEList) {
        this.siiDocumentoContableDEList = siiDocumentoContableDEList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableDEList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiLiquidacionMesDE(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableDEList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiLiquidacionMesDE(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiLiquidacionMesGA")
    public List<SiiDocumentoContable> getSiiDocumentoContableGAList() {
        return siiDocumentoContableGAList;
    }

    public void setSiiDocumentoContableGAList(List<SiiDocumentoContable> siiDocumentoContableGAList) {
        this.siiDocumentoContableGAList = siiDocumentoContableGAList;
    }

    @ManyToOne
    @JoinColumn(name = "RVE_CODIGO")
    public SiiReporteVentas getSiiReporteVentas(){
        return siiReporteVentas;
    }

    public void setSiiReporteVentas(SiiReporteVentas siiReporteVentas){
        this.siiReporteVentas = siiReporteVentas;
    }
}
