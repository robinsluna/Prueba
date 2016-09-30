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
@Table(name = "SII_AJUSTE_CUOTA")
public class SiiAjusteCuota implements Serializable {
    private static final long serialVersionUID = -1129555154915078434L;
    private Long acuCodigo;
    private BigDecimal ajuValor;
    private SiiCuotaOperador siiCuotaOperador;
    private SiiAjuste siiAjuste;

    public SiiAjusteCuota() {
    }

    public SiiAjusteCuota(Long acuCodigo, SiiAjuste siiAjuste, BigDecimal ajuValor, SiiCuotaOperador siiCuotaOperador) {
        this.acuCodigo = acuCodigo;
        this.siiAjuste = siiAjuste;
        this.ajuValor = ajuValor;
        this.siiCuotaOperador = siiCuotaOperador;
    }

    @Id
    @Column(name = "ACU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AJUSTE_CUOTA_COD")
    @SequenceGenerator(name = "SEQ_AJUSTE_CUOTA_COD", sequenceName = "SEQ_AJUSTE_CUOTA_COD",allocationSize=1)
    public Long getAcuCodigo() {
        return acuCodigo;
    }

    public void setAcuCodigo(Long acuCodigo) {
        this.acuCodigo = acuCodigo;
    }


    @Column(name = "AJU_VALOR", nullable = false)
    public BigDecimal getAjuValor() {
        return ajuValor;
    }

    public void setAjuValor(BigDecimal ajuValor) {
        this.ajuValor = ajuValor;
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
    @JoinColumn(name = "AJU_CODIGO")
    public SiiAjuste getSiiAjuste() {
        return siiAjuste;
    }

    public void setSiiAjuste(SiiAjuste siiAjuste) {
        this.siiAjuste = siiAjuste;
    }
}
