package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_INSTR_NO_CORRESP")
public class SiiInstrNoCorresp implements Serializable {
    private static final long serialVersionUID = 3635697391834375040L;
    private Long inoCodigo;
    private Integer inoCodApuesta;
    private String inoDescJuego;
    private String inoIndicador;
    private Integer inoItem;
    private String inoMarca;
    private String inoPlanPremios;
    private String inoSerial;
    private String inoTipo;
    private String inoValoresPrem;
    private SiiActaVisita siiActaVisita;

    public SiiInstrNoCorresp() {
    }

    public SiiInstrNoCorresp(SiiActaVisita siiActaVisita, Integer inoCodApuesta, Long inoCodigo, String inoDescJuego, String inoIndicador, Integer inoItem, String inoMarca, String inoPlanPremios,
                             String inoSerial, String inoTipo, String inoValoresPrem) {
        this.siiActaVisita = siiActaVisita;
        this.inoCodApuesta = inoCodApuesta;
        this.inoCodigo = inoCodigo;
        this.inoDescJuego = inoDescJuego;
        this.inoIndicador = inoIndicador;
        this.inoItem = inoItem;
        this.inoMarca = inoMarca;
        this.inoPlanPremios = inoPlanPremios;
        this.inoSerial = inoSerial;
        this.inoTipo = inoTipo;
        this.inoValoresPrem = inoValoresPrem;
    }


    @Id
    @Column(name = "INO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INSTR_NO_CORRESP_COD")
    @SequenceGenerator(name = "SEQ_INSTR_NO_CORRESP_COD", sequenceName = "SEQ_INSTR_NO_CORRESP_COD",allocationSize=1)
    public Long getInoCodigo() {
        return inoCodigo;
    }

    public void setInoCodigo(Long inoCodigo) {
        this.inoCodigo = inoCodigo;
    }

    @Column(name = "INO_COD_APUESTA")
    public Integer getInoCodApuesta() {
        return inoCodApuesta;
    }

    public void setInoCodApuesta(Integer inoCodApuesta) {
        this.inoCodApuesta = inoCodApuesta;
    }

    @Column(name = "INO_DESC_JUEGO", nullable = false, length = 1)
    public String getInoDescJuego() {
        return inoDescJuego;
    }

    public void setInoDescJuego(String inoDescJuego) {
        this.inoDescJuego = inoDescJuego;
    }

    @Column(name = "INO_INDICADOR", length = 1)
    public String getInoIndicador() {
        return inoIndicador;
    }

    public void setInoIndicador(String inoIndicador) {
        this.inoIndicador = inoIndicador;
    }

    @Column(name = "INO_ITEM")
    public Integer getInoItem() {
        return inoItem;
    }

    public void setInoItem(Integer inoItem) {
        this.inoItem = inoItem;
    }

    @Column(name = "INO_MARCA", length = 50)
    public String getInoMarca() {
        return inoMarca;
    }

    public void setInoMarca(String inoMarca) {
        this.inoMarca = inoMarca;
    }

    @Column(name = "INO_PLAN_PREMIOS", length = 1)
    public String getInoPlanPremios() {
        return inoPlanPremios;
    }

    public void setInoPlanPremios(String inoPlanPremios) {
        this.inoPlanPremios = inoPlanPremios;
    }

    @Column(name = "INO_SERIAL", length = 50)
    public String getInoSerial() {
        return inoSerial;
    }

    public void setInoSerial(String inoSerial) {
        this.inoSerial = inoSerial;
    }

    @Column(name = "INO_TIPO", nullable = false, length = 1)
    public String getInoTipo() {
        return inoTipo;
    }

    public void setInoTipo(String inoTipo) {
        this.inoTipo = inoTipo;
    }

    @Column(name = "INO_VALORES_PREM", length = 1)
    public String getInoValoresPrem() {
        return inoValoresPrem;
    }

    public void setInoValoresPrem(String inoValoresPrem) {
        this.inoValoresPrem = inoValoresPrem;
    }

    @ManyToOne
    @JoinColumn(name = "AVI_CODIGO")
    public SiiActaVisita getSiiActaVisita() {
        return siiActaVisita;
    }

    public void setSiiActaVisita(SiiActaVisita siiActaVisita) {
        this.siiActaVisita = siiActaVisita;
    }
}
