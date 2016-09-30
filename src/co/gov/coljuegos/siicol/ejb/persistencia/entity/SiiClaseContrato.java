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
@Table(name = "SII_CLASE_CONTRATO")
public class SiiClaseContrato implements Serializable {
    private static final long serialVersionUID = 3103651955288505764L;
    private Long clcCodigo;
    private String clcNombre;
    private List<SiiActaIniContrato> siiActaIniContratoList;

    public SiiClaseContrato() {
    }

    public SiiClaseContrato(Long clcCodigo, String clcNombre) {
        this.clcCodigo = clcCodigo;
        this.clcNombre = clcNombre;
    }

    @Id
    @Column(name = "CLC_CODIGO", nullable = false)
    public Long getClcCodigo() {
        return clcCodigo;
    }

    public void setClcCodigo(Long clcCodigo) {
        this.clcCodigo = clcCodigo;
    }

    @Column(name = "CLC_NOMBRE", nullable = false, length = 50)
    public String getClcNombre() {
        return clcNombre;
    }

    public void setClcNombre(String clcNombre) {
        this.clcNombre = clcNombre;
    }

    @OneToMany(mappedBy = "siiClaseContrato")
    public List<SiiActaIniContrato> getSiiActaIniContratoList() {
        return siiActaIniContratoList;
    }

    public void setSiiActaIniContratoList(List<SiiActaIniContrato> siiActaIniContratoList) {
        this.siiActaIniContratoList = siiActaIniContratoList;
    }

    public SiiActaIniContrato addSiiActaIniContrato(SiiActaIniContrato siiActaIniContrato) {
        getSiiActaIniContratoList().add(siiActaIniContrato);
        siiActaIniContrato.setSiiClaseContrato(this);
        return siiActaIniContrato;
    }

    public SiiActaIniContrato removeSiiActaIniContrato(SiiActaIniContrato siiActaIniContrato) {
        getSiiActaIniContratoList().remove(siiActaIniContrato);
        siiActaIniContrato.setSiiClaseContrato(null);
        return siiActaIniContrato;
    }
}
