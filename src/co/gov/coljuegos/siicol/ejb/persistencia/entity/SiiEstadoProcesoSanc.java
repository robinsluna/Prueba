package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_PROCESO_SANC")
public class SiiEstadoProcesoSanc implements Serializable {
    private static final long serialVersionUID = -8334238025036046926L;
    private Long epsCodigo;
    private String epsNombre;
    private List<SiiProcesoSancionatorio> siiProcesoSancionatorioList;
    private List<SiiTerminosProcesales> siiTerminosProcesalesList;

    public SiiEstadoProcesoSanc() {
    }

    public SiiEstadoProcesoSanc(Long epsCodigo, String epsNombre) {
        this.epsCodigo = epsCodigo;
        this.epsNombre = epsNombre;
    }

    @Id
    @Column(name = "EPS_CODIGO", nullable = false)
    public Long getEpsCodigo() {
        return epsCodigo;
    }

    public void setEpsCodigo(Long epsCodigo) {
        this.epsCodigo = epsCodigo;
    }

    @Column(name = "EPS_NOMBRE", nullable = false, length = 50)
    public String getEpsNombre() {
        return epsNombre;
    }

    public void setEpsNombre(String epsNombre) {
        this.epsNombre = epsNombre;
    }

    @OneToMany(mappedBy = "siiEstadoProcesoSanc")
    public List<SiiProcesoSancionatorio> getSiiProcesoSancionatorioList() {
        return siiProcesoSancionatorioList;
    }

    public void setSiiProcesoSancionatorioList(List<SiiProcesoSancionatorio> siiProcesoSancionatorioList) {
        this.siiProcesoSancionatorioList = siiProcesoSancionatorioList;
    }

    public SiiProcesoSancionatorio addSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioList().add(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiEstadoProcesoSanc(this);
        return siiProcesoSancionatorio;
    }

    public SiiProcesoSancionatorio removeSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioList().remove(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiEstadoProcesoSanc(null);
        return siiProcesoSancionatorio;
    }

    @OneToMany(mappedBy = "siiEstadoProcesoSanc")
    public List<SiiTerminosProcesales> getSiiTerminosProcesalesList() {
        return siiTerminosProcesalesList;
    }

    public void setSiiTerminosProcesalesList(List<SiiTerminosProcesales> siiTerminosProcesalesList) {
        this.siiTerminosProcesalesList = siiTerminosProcesalesList;
    }

    public SiiTerminosProcesales addSiiTerminosProcesales(SiiTerminosProcesales siiTerminosProcesales) {
        getSiiTerminosProcesalesList().add(siiTerminosProcesales);
        siiTerminosProcesales.setSiiEstadoProcesoSanc(this);
        return siiTerminosProcesales;
    }

    public SiiTerminosProcesales removeSiiTerminosProcesales(SiiTerminosProcesales siiTerminosProcesales) {
        getSiiTerminosProcesalesList().remove(siiTerminosProcesales);
        siiTerminosProcesales.setSiiEstadoProcesoSanc(null);
        return siiTerminosProcesales;
    }
}
