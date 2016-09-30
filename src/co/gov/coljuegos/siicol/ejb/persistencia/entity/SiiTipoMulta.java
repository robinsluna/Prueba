package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_MULTA")
public class SiiTipoMulta implements Serializable {
    private static final long serialVersionUID = 3432229231834655241L;
    private String tmuClase;
    private Long tmuCodigo;
    private String tmuDescripcion;
    private BigDecimal tmuFactor;
    private Integer tmuLimite;
    private Integer tmuMaximo;
    private String tmuNombre;
    private List<SiiMotivoIncumplimiento> siiMotivoIncumplimientoList;

    public SiiTipoMulta() {
    }

    public SiiTipoMulta(String tmuClase, Long tmuCodigo, String tmuDescripcion, BigDecimal tmuFactor, Integer tmuLimite, Integer tmuMaximo, String tmuNombre) {
        this.tmuClase = tmuClase;
        this.tmuCodigo = tmuCodigo;
        this.tmuDescripcion = tmuDescripcion;
        this.tmuFactor = tmuFactor;
        this.tmuLimite = tmuLimite;
        this.tmuMaximo = tmuMaximo;
        this.tmuNombre = tmuNombre;
    }

    @Column(name = "TMU_CLASE", nullable = false, length = 1)
    public String getTmuClase() {
        return tmuClase;
    }

    public void setTmuClase(String tmuClase) {
        this.tmuClase = tmuClase;
    }

    @Id
    @Column(name = "TMU_CODIGO", nullable = false)
    public Long getTmuCodigo() {
        return tmuCodigo;
    }

    public void setTmuCodigo(Long tmuCodigo) {
        this.tmuCodigo = tmuCodigo;
    }

    @Column(name = "TMU_DESCRIPCION", nullable = false, length = 50)
    public String getTmuDescripcion() {
        return tmuDescripcion;
    }

    public void setTmuDescripcion(String tmuDescripcion) {
        this.tmuDescripcion = tmuDescripcion;
    }

    @Column(name = "TMU_FACTOR", nullable = false)
    public BigDecimal getTmuFactor() {
        return tmuFactor;
    }

    public void setTmuFactor(BigDecimal tmuFactor) {
        this.tmuFactor = tmuFactor;
    }

    @Column(name = "TMU_LIMITE")
    public Integer getTmuLimite() {
        return tmuLimite;
    }

    public void setTmuLimite(Integer tmuLimite) {
        this.tmuLimite = tmuLimite;
    }

    @Column(name = "TMU_MAXIMO")
    public Integer getTmuMaximo() {
        return tmuMaximo;
    }

    public void setTmuMaximo(Integer tmuMaximo) {
        this.tmuMaximo = tmuMaximo;
    }

    @Column(name = "TMU_NOMBRE", nullable = false, length = 20)
    public String getTmuNombre() {
        return tmuNombre;
    }

    public void setTmuNombre(String tmuNombre) {
        this.tmuNombre = tmuNombre;
    }

    @OneToMany(mappedBy = "siiTipoMulta")
    public List<SiiMotivoIncumplimiento> getSiiMotivoIncumplimientoList() {
        return siiMotivoIncumplimientoList;
    }

    public void setSiiMotivoIncumplimientoList(List<SiiMotivoIncumplimiento> siiMotivoIncumplimientoList) {
        this.siiMotivoIncumplimientoList = siiMotivoIncumplimientoList;
    }

    public SiiMotivoIncumplimiento addSiiMotivoIncumplimiento(SiiMotivoIncumplimiento siiMotivoIncumplimiento) {
        getSiiMotivoIncumplimientoList().add(siiMotivoIncumplimiento);
        siiMotivoIncumplimiento.setSiiTipoMulta(this);
        return siiMotivoIncumplimiento;
    }

    public SiiMotivoIncumplimiento removeSiiMotivoIncumplimiento(SiiMotivoIncumplimiento siiMotivoIncumplimiento) {
        getSiiMotivoIncumplimientoList().remove(siiMotivoIncumplimiento);
        siiMotivoIncumplimiento.setSiiTipoMulta(null);
        return siiMotivoIncumplimiento;
    }
}
