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
@Table(name = "SII_INFORME_ACTA_INI")
public class SiiInformeActaIni implements Serializable {
    private static final long serialVersionUID = 5523302258009056593L;
    private Long iaiCodigo;
    private Date iaiFecha;
    private String iaiPago;
    private String iaiTipoInforme;
    private BigDecimal iaiValor;
    private SiiActaIniContrato siiActaIniContrato;

    public SiiInformeActaIni() {
    }

    public SiiInformeActaIni(Long iaiCodigo, Date iaiFecha, String iaiPago, String iaiTipoInforme,
                             BigDecimal iaiValor) {
        this.iaiCodigo = iaiCodigo;
        this.iaiFecha = iaiFecha;
        this.iaiPago = iaiPago;
        this.iaiTipoInforme = iaiTipoInforme;
        this.iaiValor = iaiValor;
    }


    @Id
    @Column(name = "IAI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INFORME_ACTA_INI_COD")
    @SequenceGenerator(name = "SEQ_INFORME_ACTA_INI_COD", sequenceName = "SEQ_INFORME_ACTA_INI_COD",allocationSize=1)
    public Long getIaiCodigo() {
        return iaiCodigo;
    }

    public void setIaiCodigo(Long iaiCodigo) {
        this.iaiCodigo = iaiCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IAI_FECHA", nullable = false)
    public Date getIaiFecha() {
        return iaiFecha;
    }

    public void setIaiFecha(Date iaiFecha) {
        this.iaiFecha = iaiFecha;
    }

    @Column(name = "IAI_PAGO", nullable = false, length = 1)
    public String getIaiPago() {
        return iaiPago;
    }

    public void setIaiPago(String iaiPago) {
        this.iaiPago = iaiPago;
    }

    @Column(name = "IAI_TIPO_INFORME", nullable = false, length = 1)
    public String getIaiTipoInforme() {
        return iaiTipoInforme;
    }

    public void setIaiTipoInforme(String iaiTipoInforme) {
        this.iaiTipoInforme = iaiTipoInforme;
    }

    @Column(name = "IAI_VALOR", nullable = false)
    public BigDecimal getIaiValor() {
        return iaiValor;
    }

    public void setIaiValor(BigDecimal iaiValor) {
        this.iaiValor = iaiValor;
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
