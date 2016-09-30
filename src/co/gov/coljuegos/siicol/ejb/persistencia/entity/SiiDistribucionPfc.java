package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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

@Entity
@Table(name = "SII_DISTRIBUCION_PFC")
public class SiiDistribucionPfc implements Serializable {
    private static final long serialVersionUID = -8773054356616805044L;
    private Long dpfCodigo;
    private BigDecimal dpfSobranteAnt;
    private Long dpfValor;
    private SiiDetalleRubro siiDetalleRubro;
    private SiiProyeccionFlujoCaja siiProyeccionFlujoCaja;
    private SiiMes siiMes;
    private Long dpfValorAprobado;
    private List<SiiModificPfcAnual> siiModificPfcAnualList;

    public SiiDistribucionPfc() {
    }

    public SiiDistribucionPfc(Long dpfCodigo, Long dpfValor, Long dpfValorAprobado,
                              SiiDetalleRubro siiDetalleRubro, SiiProyeccionFlujoCaja siiProyeccionFlujoCaja,
                              BigDecimal dpfSobranteAnt) {
        this.dpfCodigo = dpfCodigo;
        this.dpfSobranteAnt = dpfSobranteAnt;
        this.dpfValor = dpfValor;
        this.dpfValorAprobado = dpfValorAprobado;
        this.siiDetalleRubro = siiDetalleRubro;
        this.siiProyeccionFlujoCaja = siiProyeccionFlujoCaja;
    }

    @Id
    @Column(name = "DPF_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DISTRIBUCION_PFC_CODIGO")
    @SequenceGenerator(name = "SEQ_DISTRIBUCION_PFC_CODIGO", sequenceName = "SEQ_DISTRIBUCION_PFC_CODIGO",allocationSize=1)
    public Long getDpfCodigo() {
        return dpfCodigo;
    }

    public void setDpfCodigo(Long dpfCodigo) {
        this.dpfCodigo = dpfCodigo;
    }

    @Column(name = "DPF_SOBRANTE_ANT")
    public BigDecimal getDpfSobranteAnt() {
        return dpfSobranteAnt;
    }

    public void setDpfSobranteAnt(BigDecimal dpfSobranteAnt) {
        this.dpfSobranteAnt = dpfSobranteAnt;
    }

    @Column(name = "DPF_VALOR", nullable = false)
    public Long getDpfValor() {
        return dpfValor;
    }

    public void setDpfValor(Long dpfValor) {
        this.dpfValor = dpfValor;
    }

    @Column(name = "DPF_VALOR_APROBADO", nullable = false)
    public Long getDpfValorAprobado() {
        return dpfValorAprobado;
    }

    public void setDpfValorAprobado(Long dpfValorAprobado) {
        this.dpfValorAprobado = dpfValorAprobado;
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
    @JoinColumn(name = "PFC_CODIGO")
    public SiiProyeccionFlujoCaja getSiiProyeccionFlujoCaja() {
        return siiProyeccionFlujoCaja;
    }

    public void setSiiProyeccionFlujoCaja(SiiProyeccionFlujoCaja siiProyeccionFlujoCaja) {
        this.siiProyeccionFlujoCaja = siiProyeccionFlujoCaja;
    }

	@ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @OneToMany(mappedBy = "siiDistribucionPfc")
    public List<SiiModificPfcAnual> getSiiModificPfcAnualList() {
        return siiModificPfcAnualList;
    }

    public void setSiiModificPfcAnualList(List<SiiModificPfcAnual> siiModificPfcAnualList) {
        this.siiModificPfcAnualList = siiModificPfcAnualList;
    }
}
