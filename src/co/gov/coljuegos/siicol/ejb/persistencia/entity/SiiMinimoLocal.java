package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MINIMO_LOCAL")
public class SiiMinimoLocal implements Serializable {
    private static final long serialVersionUID = 5590134875363275435L;
    private Long milCodigo;
    private Long milDesde;
    private Long milHasta;
    private Integer milNumElementos;

    public SiiMinimoLocal() {
    }

    public SiiMinimoLocal(Long milCodigo, Long milDesde, Long milHasta, Integer milNumElementos) {
        this.milCodigo = milCodigo;
        this.milDesde = milDesde;
        this.milHasta = milHasta;
        this.milNumElementos = milNumElementos;
    }

    @Id
    @Column(name = "MIL_CODIGO", nullable = false)
    public Long getMilCodigo() {
        return milCodigo;
    }

    public void setMilCodigo(Long milCodigo) {
        this.milCodigo = milCodigo;
    }

    @Column(name = "MIL_DESDE", nullable = false)
    public Long getMilDesde() {
        return milDesde;
    }

    public void setMilDesde(Long milDesde) {
        this.milDesde = milDesde;
    }

    @Column(name = "MIL_HASTA", nullable = false)
    public Long getMilHasta() {
        return milHasta;
    }

    public void setMilHasta(Long milHasta) {
        this.milHasta = milHasta;
    }

    @Column(name = "MIL_NUM_ELEMENTOS", nullable = false)
    public Integer getMilNumElementos() {
        return milNumElementos;
    }

    public void setMilNumElementos(Integer milNumElementos) {
        this.milNumElementos = milNumElementos;
    }
}
