package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_JUEGO")
public class SiiTipoJuego implements Serializable {
    private static final long serialVersionUID = -483422153819555086L;
    private Long tjuCodigo;
    private String tjuNombre;
    private List<SiiTipoApuesta> siiTipoApuestaList1;

    public SiiTipoJuego() {
    }

    public SiiTipoJuego(Long tjuCodigo, String tjuNombre) {
        this.tjuCodigo = tjuCodigo;
        this.tjuNombre = tjuNombre;
    }

    @Id
    @Column(name = "TJU_CODIGO", nullable = false)
    public Long getTjuCodigo() {
        return tjuCodigo;
    }

    public void setTjuCodigo(Long tjuCodigo) {
        this.tjuCodigo = tjuCodigo;
    }

    @Column(name = "TJU_NOMBRE", nullable = false, length = 100)
    public String getTjuNombre() {
        return tjuNombre;
    }

    public void setTjuNombre(String tjuNombre) {
        this.tjuNombre = tjuNombre;
    }

    @OneToMany(mappedBy = "siiTipoJuego")
    public List<SiiTipoApuesta> getSiiTipoApuestaList1() {
        return siiTipoApuestaList1;
    }

    public void setSiiTipoApuestaList1(List<SiiTipoApuesta> siiTipoApuestaList1) {
        this.siiTipoApuestaList1 = siiTipoApuestaList1;
    }

    public SiiTipoApuesta addSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        getSiiTipoApuestaList1().add(siiTipoApuesta);
        siiTipoApuesta.setSiiTipoJuego(this);
        return siiTipoApuesta;
    }

    public SiiTipoApuesta removeSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        getSiiTipoApuestaList1().remove(siiTipoApuesta);
        siiTipoApuesta.setSiiTipoJuego(null);
        return siiTipoApuesta;
    }
}
