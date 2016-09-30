package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_ASIGNACION_RECAUDO")
public class SiiAsignacionRecaudo implements Serializable {
    private static final long serialVersionUID = -3617151076705448305L;
    private Long areCodigo;
    private String areEstado;
    private List<SiiLiquidacionEstabl> siiLiquidacionEstablList;
    private SiiDetalleDeclaracion siiDetalleDeclaracion;

    public SiiAsignacionRecaudo() {
    }

    public SiiAsignacionRecaudo(Long areCodigo, String areEstado, SiiDetalleDeclaracion siiDetalleDeclaracion) {
        this.areCodigo = areCodigo;
        this.areEstado = areEstado;
        this.siiDetalleDeclaracion = siiDetalleDeclaracion;
    }

    @Id
    @Column(name = "ARE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ASIGNACION_RECAUDO_COD")
    @SequenceGenerator(name = "SEQ_ASIGNACION_RECAUDO_COD", sequenceName = "SEQ_ASIGNACION_RECAUDO_COD",allocationSize=1)
    public Long getAreCodigo() {
        return areCodigo;
    }

    public void setAreCodigo(Long areCodigo) {
        this.areCodigo = areCodigo;
    }

    @Column(name = "ARE_ESTADO", nullable = false, length = 1)
    public String getAreEstado() {
        return areEstado;
    }

    public void setAreEstado(String areEstado) {
        this.areEstado = areEstado;
    }

    @OneToMany(mappedBy = "siiAsignacionRecaudo")
    public List<SiiLiquidacionEstabl> getSiiLiquidacionEstablList() {
        return siiLiquidacionEstablList;
    }

    public void setSiiLiquidacionEstablList(List<SiiLiquidacionEstabl> siiLiquidacionEstablList) {
        this.siiLiquidacionEstablList = siiLiquidacionEstablList;
    }

    public SiiLiquidacionEstabl addSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablList().add(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiAsignacionRecaudo(this);
        return siiLiquidacionEstabl;
    }

    public SiiLiquidacionEstabl removeSiiLiquidacionEstabl(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        getSiiLiquidacionEstablList().remove(siiLiquidacionEstabl);
        siiLiquidacionEstabl.setSiiAsignacionRecaudo(null);
        return siiLiquidacionEstabl;
    }

    @ManyToOne
    @JoinColumn(name = "DDE_CODIGO")
    public SiiDetalleDeclaracion getSiiDetalleDeclaracion() {
        return siiDetalleDeclaracion;
    }

    public void setSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        this.siiDetalleDeclaracion = siiDetalleDeclaracion;
    }
}
