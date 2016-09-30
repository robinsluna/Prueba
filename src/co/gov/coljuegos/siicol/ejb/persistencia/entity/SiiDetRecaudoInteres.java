package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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

@Entity
@Table(name = "SII_DET_RECAUDO_INTER")
public class SiiDetRecaudoInteres implements Serializable {
    private static final long serialVersionUID = 2449073499482069273L;
    private Long driCodigo;
    private SiiDetalleRecaudo siiDetalleRecaudo;
    private SiiInteresCuota siiInteresCuota;
    private BigDecimal driValorPagado;

    public SiiDetRecaudoInteres() {
    }

    public SiiDetRecaudoInteres(SiiDetalleRecaudo siiDetalleRecaudo, Long driCodigo, SiiInteresCuota siiInteresCuota) {
        this.siiDetalleRecaudo = siiDetalleRecaudo;
        this.driCodigo = driCodigo;
        this.siiInteresCuota = siiInteresCuota;
    }


    @Id
    @Column(name = "DRI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DET_RECAU_INTER_COD")
    @SequenceGenerator(name = "SEQ_DET_RECAU_INTER_COD", sequenceName = "SEQ_DET_RECAU_INTER_COD",allocationSize=1)
    public Long getDriCodigo() {
        return driCodigo;
    }

    public void setDriCodigo(Long driCodigo) {
        this.driCodigo = driCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "DRE_CODIGO")
    public SiiDetalleRecaudo getSiiDetalleRecaudo() {
        return siiDetalleRecaudo;
    }

    public void setSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        this.siiDetalleRecaudo = siiDetalleRecaudo;
    }

    @ManyToOne
    @JoinColumn(name = "ICU_CODIGO")
    public SiiInteresCuota getSiiInteresCuota() {
        return siiInteresCuota;
    }

    public void setSiiInteresCuota(SiiInteresCuota siiInteresCuota) {
        this.siiInteresCuota = siiInteresCuota;
    }

    @Column(name = "DRI_VALOR_PAGADO")
    public BigDecimal getDriValorPagado() {
        return driValorPagado;
    }

    public void setDriValorPagado(BigDecimal driValorPagado) {
        this.driValorPagado = driValorPagado;
    }
}
