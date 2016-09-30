package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_EST_PREV_DET_RUBRO")
public class SiiEstPrevDetRubro implements Serializable {
    private static final long serialVersionUID = 2648018629307072833L;
    private Long epdCodigo;
    private Long epdValor;
    private SiiDetalleRubro siiDetalleRubro;
    private SiiEstudioPrevio siiEstudioPrevio2;

    public SiiEstPrevDetRubro() {
    }

    public SiiEstPrevDetRubro(SiiDetalleRubro siiDetalleRubro, Long epdCodigo, Long epdValor,
                              SiiEstudioPrevio siiEstudioPrevio2) {
        this.siiDetalleRubro = siiDetalleRubro;
        this.epdCodigo = epdCodigo;
        this.epdValor = epdValor;
        this.siiEstudioPrevio2 = siiEstudioPrevio2;
    }


    @Id
    @Column(name = "EPD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_EST_PREV_DET_RUBRO_COD")
    @SequenceGenerator(name = "SEQ_EST_PREV_DET_RUBRO_COD", sequenceName = "SEQ_EST_PREV_DET_RUBRO_COD",allocationSize=1)
    public Long getEpdCodigo() {
        return epdCodigo;
    }

    public void setEpdCodigo(Long epdCodigo) {
        this.epdCodigo = epdCodigo;
    }

    @Column(name = "EPD_VALOR", nullable = false)
    public Long getEpdValor() {
        return epdValor;
    }

    public void setEpdValor(Long epdValor) {
        this.epdValor = epdValor;
    }


    @ManyToOne
    @JoinColumn(name = "DRU_CODIGO")
    public SiiDetalleRubro getSiiDetalleRubro() {
        return siiDetalleRubro;
    }

    public void setSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) {
        this.siiDetalleRubro = siiDetalleRubro;
    }

    @ManyToOne
    @JoinColumn(name = "EPE_CODIGO")
    public SiiEstudioPrevio getSiiEstudioPrevio2() {
        return siiEstudioPrevio2;
    }

    public void setSiiEstudioPrevio2(SiiEstudioPrevio siiEstudioPrevio2) {
        this.siiEstudioPrevio2 = siiEstudioPrevio2;
    }
}
