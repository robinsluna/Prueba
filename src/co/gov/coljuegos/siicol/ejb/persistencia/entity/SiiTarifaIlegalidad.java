package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TARIFA_ILEGALIDAD")
public class SiiTarifaIlegalidad implements Serializable {
    private static final long serialVersionUID = 5905983664814952359L;
    private Long tleCodigo;
    private Integer tleHabitDesde;
    private Long tleHabitHasta;
    private Integer tleMinSillas;
    private Integer tleSmmlvUni;
    private String tleUnidad;
    private SiiClaseJuego siiClaseJuego;
    private SiiTipoInstrumento siiTipoInstrumento;

    public SiiTarifaIlegalidad() {
    }

    public SiiTarifaIlegalidad(SiiClaseJuego siiClaseJuego, SiiTipoInstrumento siiTipoInstrumento, Long tleCodigo, Integer tleHabitDesde, Long tleHabitHasta, Integer tleMinSillas, Integer tleSmmlvUni,
                               String tleUnidad) {
        this.siiClaseJuego = siiClaseJuego;
        this.siiTipoInstrumento = siiTipoInstrumento;
        this.tleCodigo = tleCodigo;
        this.tleHabitDesde = tleHabitDesde;
        this.tleHabitHasta = tleHabitHasta;
        this.tleMinSillas = tleMinSillas;
        this.tleSmmlvUni = tleSmmlvUni;
        this.tleUnidad = tleUnidad;
    }


    @Id
    @Column(name = "TLE_CODIGO", nullable = false)
    public Long getTleCodigo() {
        return tleCodigo;
    }

    public void setTleCodigo(Long tleCodigo) {
        this.tleCodigo = tleCodigo;
    }

    @Column(name = "TLE_HABIT_DESDE")
    public Integer getTleHabitDesde() {
        return tleHabitDesde;
    }

    public void setTleHabitDesde(Integer tleHabitDesde) {
        this.tleHabitDesde = tleHabitDesde;
    }

    @Column(name = "TLE_HABIT_HASTA")
    public Long getTleHabitHasta() {
        return tleHabitHasta;
    }

    public void setTleHabitHasta(Long tleHabitHasta) {
        this.tleHabitHasta = tleHabitHasta;
    }

    @Column(name = "TLE_MIN_SILLAS")
    public Integer getTleMinSillas() {
        return tleMinSillas;
    }

    public void setTleMinSillas(Integer tleMinSillas) {
        this.tleMinSillas = tleMinSillas;
    }

    @Column(name = "TLE_SMMLV_UNI", nullable = false)
    public Integer getTleSmmlvUni() {
        return tleSmmlvUni;
    }

    public void setTleSmmlvUni(Integer tleSmmlvUni) {
        this.tleSmmlvUni = tleSmmlvUni;
    }

    @Column(name = "TLE_UNIDAD", nullable = false, length = 2)
    public String getTleUnidad() {
        return tleUnidad;
    }

    public void setTleUnidad(String tleUnidad) {
        this.tleUnidad = tleUnidad;
    }

    @ManyToOne
    @JoinColumn(name = "CJU_CODIGO")
    public SiiClaseJuego getSiiClaseJuego() {
        return siiClaseJuego;
    }

    public void setSiiClaseJuego(SiiClaseJuego siiClaseJuego) {
        this.siiClaseJuego = siiClaseJuego;
    }

    @ManyToOne
    @JoinColumn(name = "TIN_CODIGO")
    public SiiTipoInstrumento getSiiTipoInstrumento() {
        return siiTipoInstrumento;
    }

    public void setSiiTipoInstrumento(SiiTipoInstrumento siiTipoInstrumento) {
        this.siiTipoInstrumento = siiTipoInstrumento;
    }
}
