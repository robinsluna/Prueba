package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_CONTRATO")
public class SiiEstadoContrato implements Serializable {
    private static final long serialVersionUID = 1759726179497356178L;
    private Long ecoCodigo;
    private String ecoEstEjecucion;
    private String ecoNombre;
    private List<SiiContrato> siiContratoList;

    public SiiEstadoContrato() {
    }

    public SiiEstadoContrato(Long ecoCodigo, String ecoEstEjecucion, String ecoNombre) {
        this.ecoCodigo = ecoCodigo;
        this.ecoEstEjecucion = ecoEstEjecucion;
        this.ecoNombre = ecoNombre;
    }

    @Id
    @Column(name = "ECO_CODIGO", nullable = false)
    public Long getEcoCodigo() {
        return ecoCodigo;
    }

    public void setEcoCodigo(Long ecoCodigo) {
        this.ecoCodigo = ecoCodigo;
    }

    @Column(name = "ECO_EST_EJECUCION", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEcoEstEjecucion() {
        return ecoEstEjecucion;
    }

    public void setEcoEstEjecucion(String ecoEstEjecucion) {
        this.ecoEstEjecucion = ecoEstEjecucion;
    }

    @Column(name = "ECO_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEcoNombre() {
        return ecoNombre;
    }

    public void setEcoNombre(String ecoNombre) {
        this.ecoNombre = ecoNombre;
    }

    @OneToMany(mappedBy = "siiEstadoContrato")
    public List<SiiContrato> getSiiContratoList() {
        return siiContratoList;
    }

    public void setSiiContratoList(List<SiiContrato> siiContratoList) {
        this.siiContratoList = siiContratoList;
    }

    public SiiContrato addSiiContrato(SiiContrato siiContrato) {
        getSiiContratoList().add(siiContrato);
        siiContrato.setSiiEstadoContrato(this);
        return siiContrato;
    }

    public SiiContrato removeSiiContrato(SiiContrato siiContrato) {
        getSiiContratoList().remove(siiContrato);
        siiContrato.setSiiEstadoContrato(null);
        return siiContrato;
    }
}
