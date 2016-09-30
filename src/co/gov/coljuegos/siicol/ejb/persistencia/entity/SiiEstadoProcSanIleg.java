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
@Table(name = "SII_ESTADO_PROC_SAN_ILEG")
public class SiiEstadoProcSanIleg implements Serializable {
    private static final long serialVersionUID = 1107598269777234627L;
    private Long epiCodigo;
    private String epiNombre;
    private List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadList;
    private List<SiiTerminosProcesales> siiTerminosProcesalesList;

    public SiiEstadoProcSanIleg() {
    }

    public SiiEstadoProcSanIleg(Long epiCodigo, String epiNombre) {
        this.epiCodigo = epiCodigo;
        this.epiNombre = epiNombre;
    }

    @Id
    @Column(name = "EPI_CODIGO", nullable = false)
    public Long getEpiCodigo() {
        return epiCodigo;
    }

    public void setEpiCodigo(Long epiCodigo) {
        this.epiCodigo = epiCodigo;
    }

    @Column(name = "EPI_NOMBRE", nullable = false, length = 70)
    public String getEpiNombre() {
        return epiNombre;
    }

    public void setEpiNombre(String epiNombre) {
        this.epiNombre = epiNombre;
    }

    @OneToMany(mappedBy = "siiEstadoProcSanIleg")
    public List<SiiProcesoSancIlegalidad> getSiiProcesoSancIlegalidadList() {
        return siiProcesoSancIlegalidadList;
    }

    public void setSiiProcesoSancIlegalidadList(List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadList) {
        this.siiProcesoSancIlegalidadList = siiProcesoSancIlegalidadList;
    }

    public SiiProcesoSancIlegalidad addSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        getSiiProcesoSancIlegalidadList().add(siiProcesoSancIlegalidad);
        siiProcesoSancIlegalidad.setSiiEstadoProcSanIleg(this);
        return siiProcesoSancIlegalidad;
    }

    public SiiProcesoSancIlegalidad removeSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        getSiiProcesoSancIlegalidadList().remove(siiProcesoSancIlegalidad);
        siiProcesoSancIlegalidad.setSiiEstadoProcSanIleg(null);
        return siiProcesoSancIlegalidad;
    }


    @OneToMany(mappedBy = "siiEstadoProcSanIleg")
    public List<SiiTerminosProcesales> getSiiTerminosProcesalesList() {
        return siiTerminosProcesalesList;
    }

    public void setSiiTerminosProcesalesList(List<SiiTerminosProcesales> siiTerminosProcesalesList) {
        this.siiTerminosProcesalesList = siiTerminosProcesalesList;
    }

    public SiiTerminosProcesales addSiiTerminosProcesales(SiiTerminosProcesales siiTerminosProcesales) {
        getSiiTerminosProcesalesList().add(siiTerminosProcesales);
        siiTerminosProcesales.setSiiEstadoProcSanIleg(this);
        return siiTerminosProcesales;
    }

    public SiiTerminosProcesales removeSiiTerminosProcesales(SiiTerminosProcesales siiTerminosProcesales) {
        getSiiTerminosProcesalesList().remove(siiTerminosProcesales);
        siiTerminosProcesales.setSiiEstadoProcSanIleg(null);
        return siiTerminosProcesales;
    }
}
