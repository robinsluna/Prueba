package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SII_HLP_CUOTA_ACUERDO")
public class SiiHlpCuotaAcuerdo implements Serializable {
    private static final long serialVersionUID = -446612745483699423L;
    private Long ccuCodigo;
    /*private BigDecimal hcaAbonoIni;
    private BigDecimal hcaAbonoIniInt;*/
    private Long hcaCodigo;
    private BigDecimal hcaInterFinanc;
    private BigDecimal hcaInterNoFin;
    private Integer hcaNumCuota;
    private BigDecimal hcaValor;
    private BigDecimal hcaValorInicial;
    private Integer hcaVigencia;
    private SiiMes siiMes;
    private List<SiiHlpCuotaOpCuoAcu> siiHlpCuotaOpCuoAcuList;
    private SiiAcuerdoPago siiAcuerdoPago;
    private Date hcaFechaPago;
    private BigDecimal hcaTotalCuota;

    public SiiHlpCuotaAcuerdo() {
    }

    public SiiHlpCuotaAcuerdo(SiiAcuerdoPago siiAcuerdoPago, Long ccuCodigo, /*BigDecimal hcaAbonoIni, BigDecimal hcaAbonoIniInt,*/
                              Long hcaCodigo, Integer hcaNumCuota, BigDecimal hcaValor, Integer hcaVigencia, SiiMes siiMes) {
        this.siiAcuerdoPago = siiAcuerdoPago;
        this.ccuCodigo = ccuCodigo;
        //this.hcaAbonoIni = hcaAbonoIni;
        //this.hcaAbonoIniInt = hcaAbonoIniInt;
        this.hcaCodigo = hcaCodigo;
        this.hcaNumCuota = hcaNumCuota;
        this.hcaValor = hcaValor;
        this.hcaVigencia = hcaVigencia;
        this.siiMes = siiMes;
    }


    @Column(name = "CCU_CODIGO", nullable = false)
    public Long getCcuCodigo() {
        return ccuCodigo;
    }

    public void setCcuCodigo(Long ccuCodigo) {
        this.ccuCodigo = ccuCodigo;
    }
/*
    @Column(name = "HCA_ABONO_INI")
    public BigDecimal getHcaAbonoIni() {
        return hcaAbonoIni;
    }

    public void setHcaAbonoIni(BigDecimal hcaAbonoIni) {
        this.hcaAbonoIni = hcaAbonoIni;
    }

    @Column(name = "HCA_ABONO_INI_INT")
    public BigDecimal getHcaAbonoIniInt() {
        return hcaAbonoIniInt;
    }

    public void setHcaAbonoIniInt(BigDecimal hcaAbonoIniInt) {
        this.hcaAbonoIniInt = hcaAbonoIniInt;
    }
*/
    @Id
    @Column(name = "HCA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HITOS_EMPRESA_COD")
    @SequenceGenerator(name = "SEQ_HITOS_EMPRESA_COD", sequenceName = "SEQ_HITOS_EMPRESA_COD",allocationSize=1)
    public Long getHcaCodigo() {
        return hcaCodigo;
    }

    public void setHcaCodigo(Long hcaCodigo) {
        this.hcaCodigo = hcaCodigo;
    }

    @Column(name = "HCA_INTER_FINANC")
    public BigDecimal getHcaInterFinanc() {
        return hcaInterFinanc;
    }

    public void setHcaInterFinanc(BigDecimal hcaInterFinanc) {
        this.hcaInterFinanc = hcaInterFinanc;
    }

    @Column(name = "HCA_INTER_NO_FIN")
    public BigDecimal getHcaInterNoFin() {
        return hcaInterNoFin;
    }

    public void setHcaInterNoFin(BigDecimal hcaInterNoFin) {
        this.hcaInterNoFin = hcaInterNoFin;
    }
    @Column(name = "HCA_NUM_CUOTA", nullable = false)
    public Integer getHcaNumCuota() {
        return hcaNumCuota;
    }

    public void setHcaNumCuota(Integer hcaNumCuota) {
        this.hcaNumCuota = hcaNumCuota;
    }

    @Column(name = "HCA_TOTAL_CUOTA")
    public BigDecimal getHcaTotalCuota() {
        return hcaTotalCuota;
    }

    public void setHcaTotalCuota(BigDecimal hcaTotalCuota) {
        this.hcaTotalCuota = hcaTotalCuota;
    }
    @Column(name = "HCA_VALOR")
    public BigDecimal getHcaValor() {
        return hcaValor;
    }

    public void setHcaValor(BigDecimal hcaValor) {
        this.hcaValor = hcaValor;
    }

    @Column(name = "HCA_VIGENCIA", nullable = false)
    public Integer getHcaVigencia() {
        return hcaVigencia;
    }

    public void setHcaVigencia(Integer hcaVigencia) {
        this.hcaVigencia = hcaVigencia;
    }


    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @OneToMany(mappedBy = "siiHlpCuotaAcuerdo")
    public List<SiiHlpCuotaOpCuoAcu> getSiiHlpCuotaOpCuoAcuList() {
        return siiHlpCuotaOpCuoAcuList;
    }

    public void setSiiHlpCuotaOpCuoAcuList(List<SiiHlpCuotaOpCuoAcu> siiHlpCuotaOpCuoAcuList) {
        this.siiHlpCuotaOpCuoAcuList = siiHlpCuotaOpCuoAcuList;
    }

    public SiiHlpCuotaOpCuoAcu addSiiHlpCuotaOpCuoAcu(SiiHlpCuotaOpCuoAcu siiHlpCuotaOpCuoAcu) {
        getSiiHlpCuotaOpCuoAcuList().add(siiHlpCuotaOpCuoAcu);
        siiHlpCuotaOpCuoAcu.setSiiHlpCuotaAcuerdo(this);
        return siiHlpCuotaOpCuoAcu;
    }

    public SiiHlpCuotaOpCuoAcu removeSiiHlpCuotaOpCuoAcu(SiiHlpCuotaOpCuoAcu siiHlpCuotaOpCuoAcu) {
        getSiiHlpCuotaOpCuoAcuList().remove(siiHlpCuotaOpCuoAcu);
        siiHlpCuotaOpCuoAcu.setSiiHlpCuotaAcuerdo(null);
        return siiHlpCuotaOpCuoAcu;
    }

    @ManyToOne
    @JoinColumn(name = "APA_CODIGO")
    public SiiAcuerdoPago getSiiAcuerdoPago() {
        return siiAcuerdoPago;
    }

    public void setSiiAcuerdoPago(SiiAcuerdoPago siiAcuerdoPago) {
        this.siiAcuerdoPago = siiAcuerdoPago;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HCA_FECHA_PAGO", nullable = false)
    public Date getHcaFechaPago() {
        return hcaFechaPago;
    }

    public void setHcaFechaPago(Date hcaFechaPago) {
        this.hcaFechaPago = hcaFechaPago;
    }

    @Column(name = "HCA_VALOR_INICIAL")
    public BigDecimal getHcaValorInicial() {
        return hcaValorInicial;
    }

    public void setHcaValorInicial(BigDecimal hcaValorInicial) {
        this.hcaValorInicial = hcaValorInicial;
    }
}
