package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_EST_PREV")
public class SiiEstadoEstPrev implements Serializable {
    private static final long serialVersionUID = 8267206906815140495L;
    private Long eepCodigo;
    private String eepDescripcion;
    private String eepNombre;
    private List<SiiEstudioPrevio> siiEstudioPrevioList;

    public SiiEstadoEstPrev() {
    }

    public SiiEstadoEstPrev(Long eepCodigo, String eepDescripcion, String eepNombre) {
        this.eepCodigo = eepCodigo;
        this.eepDescripcion = eepDescripcion;
        this.eepNombre = eepNombre;
    }

    @Id
    @Column(name = "EEP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTADO_EST_PREV_COD")
    @SequenceGenerator(name = "SEQ_ESTADO_EST_PREV_COD", sequenceName = "SEQ_ESTADO_EST_PREV_COD",allocationSize=1)
    public Long getEepCodigo() {
        return eepCodigo;
    }

    public void setEepCodigo(Long eepCodigo) {
        this.eepCodigo = eepCodigo;
    }

    @Column(name = "EEP_DESCRIPCION", length = 100, insertable=false, updatable = false)
    public String getEepDescripcion() {
        return eepDescripcion;
    }

    public void setEepDescripcion(String eepDescripcion) {
        this.eepDescripcion = eepDescripcion;
    }

    @Column(name = "EEP_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEepNombre() {
        return eepNombre;
    }

    public void setEepNombre(String eepNombre) {
        this.eepNombre = eepNombre;
    }

    @OneToMany(mappedBy = "siiEstadoEstPrev")
    public List<SiiEstudioPrevio> getSiiEstudioPrevioList() {
        return siiEstudioPrevioList;
    }

    public void setSiiEstudioPrevioList(List<SiiEstudioPrevio> siiEstudioPrevioList) {
        this.siiEstudioPrevioList = siiEstudioPrevioList;
    }

    public SiiEstudioPrevio addSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList().add(siiEstudioPrevio);
        siiEstudioPrevio.setSiiEstadoEstPrev(this);
        return siiEstudioPrevio;
    }

    public SiiEstudioPrevio removeSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList().remove(siiEstudioPrevio);
        siiEstudioPrevio.setSiiEstadoEstPrev(null);
        return siiEstudioPrevio;
    }
}
