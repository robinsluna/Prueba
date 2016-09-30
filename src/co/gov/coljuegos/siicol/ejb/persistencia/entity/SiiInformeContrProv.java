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
@Table(name = "SII_INFORME_CONTR_PROV")
public class SiiInformeContrProv implements Serializable {
    private static final long serialVersionUID = 5407701852555804276L;
    private Long incCodigo;
    private Date incFecha;
    private String incPago;
    private String incTipoInforme;
    private BigDecimal incValor;
    private SiiActaIniContrato siiActaIniContrato;

    public SiiInformeContrProv() {
    }

    public SiiInformeContrProv(SiiActaIniContrato siiActaIniContrato, Long incCodigo, Date incFecha, String incPago,
                               String incTipoInforme, BigDecimal incValor) {
        this.siiActaIniContrato = siiActaIniContrato;
        this.incCodigo = incCodigo;
        this.incFecha = incFecha;
        this.incPago = incPago;
        this.incTipoInforme = incTipoInforme;
        this.incValor = incValor;
    }


    @Id
    @Column(name = "INC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INF_CONTR_PROV_COD")
    @SequenceGenerator(name = "SEQ_INF_CONTR_PROV_COD", sequenceName = "SEQ_INF_CONTR_PROV_COD",allocationSize=1)
    public Long getIncCodigo() {
        return incCodigo;
    }

    public void setIncCodigo(Long incCodigo) {
        this.incCodigo = incCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INC_FECHA", nullable = false)
    public Date getIncFecha() {
        return incFecha;
    }

    public void setIncFecha(Date incFecha) {
        this.incFecha = incFecha;
    }

    @Column(name = "INC_PAGO", nullable = false, length = 1)
    public String getIncPago() {
        return incPago;
    }

    public void setIncPago(String incPago) {
        this.incPago = incPago;
    }

    @Column(name = "INC_TIPO_INFORME", nullable = false, length = 1)
    public String getIncTipoInforme() {
        return incTipoInforme;
    }

    public void setIncTipoInforme(String incTipoInforme) {
        this.incTipoInforme = incTipoInforme;
    }

    @Column(name = "INC_VALOR", nullable = false)
    public BigDecimal getIncValor() {
        return incValor;
    }

    public void setIncValor(BigDecimal incValor) {
        this.incValor = incValor;
    }

    @ManyToOne
    @JoinColumn(name = "ACN_CODIGO")
    public SiiActaIniContrato getSiiActaIniContrato() {
        return siiActaIniContrato;
    }

    public void setSiiActaIniContrato(SiiActaIniContrato siiActaIniContrato) {
        this.siiActaIniContrato = siiActaIniContrato;
    }
}
