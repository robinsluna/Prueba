package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CLASE_JUEGO")
public class SiiClaseJuego implements Serializable {
    private static final long serialVersionUID = 3972088915551946158L;
    private Long cjuCodigo;
    private String cjuNombre;
    private List<SiiTipoApuesta> siiTipoApuestaList;
    private List<SiiTarifaIlegalidad> siiTarifaIlegalidadList;
    private List<SiiElementoProcesoIle> siiElementoProcesoIleList;

    public SiiClaseJuego() {
    }

    public SiiClaseJuego(Long cjuCodigo, String cjuNombre) {
        this.cjuCodigo = cjuCodigo;
        this.cjuNombre = cjuNombre;
    }

    @Id
    @Column(name = "CJU_CODIGO", nullable = false)
    public Long getCjuCodigo() {
        return cjuCodigo;
    }

    public void setCjuCodigo(Long cjuCodigo) {
        this.cjuCodigo = cjuCodigo;
    }

    @Column(name = "CJU_NOMBRE", nullable = false, length = 50)
    public String getCjuNombre() {
        return cjuNombre;
    }

    public void setCjuNombre(String cjuNombre) {
        this.cjuNombre = cjuNombre;
    }

    @OneToMany(mappedBy = "siiClaseJuego")
    public List<SiiTipoApuesta> getSiiTipoApuestaList() {
        return siiTipoApuestaList;
    }

    public void setSiiTipoApuestaList(List<SiiTipoApuesta> siiTipoApuestaList) {
        this.siiTipoApuestaList = siiTipoApuestaList;
    }

    public SiiTipoApuesta addSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        getSiiTipoApuestaList().add(siiTipoApuesta);
        siiTipoApuesta.setSiiClaseJuego(this);
        return siiTipoApuesta;
    }

    public SiiTipoApuesta removeSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        getSiiTipoApuestaList().remove(siiTipoApuesta);
        siiTipoApuesta.setSiiClaseJuego(null);
        return siiTipoApuesta;
    }

    @OneToMany(mappedBy = "siiClaseJuego")
    public List<SiiTarifaIlegalidad> getSiiTarifaIlegalidadList() {
        return siiTarifaIlegalidadList;
    }

    public void setSiiTarifaIlegalidadList(List<SiiTarifaIlegalidad> siiTarifaIlegalidadList) {
        this.siiTarifaIlegalidadList = siiTarifaIlegalidadList;
    }

    public SiiTarifaIlegalidad addSiiTarifaIlegalidad(SiiTarifaIlegalidad siiTarifaIlegalidad) {
        getSiiTarifaIlegalidadList().add(siiTarifaIlegalidad);
        siiTarifaIlegalidad.setSiiClaseJuego(this);
        return siiTarifaIlegalidad;
    }

    public SiiTarifaIlegalidad removeSiiTarifaIlegalidad(SiiTarifaIlegalidad siiTarifaIlegalidad) {
        getSiiTarifaIlegalidadList().remove(siiTarifaIlegalidad);
        siiTarifaIlegalidad.setSiiClaseJuego(null);
        return siiTarifaIlegalidad;
    }

    @OneToMany(mappedBy = "siiClaseJuego")
    public List<SiiElementoProcesoIle> getSiiElementoProcesoIleList() {
        return siiElementoProcesoIleList;
    }

    public void setSiiElementoProcesoIleList(List<SiiElementoProcesoIle> siiElementoProcesoIleList) {
        this.siiElementoProcesoIleList = siiElementoProcesoIleList;
    }

    public SiiElementoProcesoIle addSiiElementoProcesoIle(SiiElementoProcesoIle siiElementoProcesoIle) {
        getSiiElementoProcesoIleList().add(siiElementoProcesoIle);
        siiElementoProcesoIle.setSiiClaseJuego(this);
        return siiElementoProcesoIle;
    }

    public SiiElementoProcesoIle removeSiiElementoProcesoIle(SiiElementoProcesoIle siiElementoProcesoIle) {
        getSiiElementoProcesoIleList().remove(siiElementoProcesoIle);
        siiElementoProcesoIle.setSiiClaseJuego(null);
        return siiElementoProcesoIle;
    }
}
