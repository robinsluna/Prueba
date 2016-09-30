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
@Table(name = "SII_ESTADO_ESTUDIO_MERC")
public class SiiEstadoEstudioMerc implements Serializable {
    private static final long serialVersionUID = -6488921509824211899L;
    private Long eemCodigo;
    private String eemDescripcion;
    private String eemNombre;
    private List<SiiEstudioMercado> siiEstudioMercadoList;

    public SiiEstadoEstudioMerc() {
    }

    public SiiEstadoEstudioMerc(Long eemCodigo, String eemDescripcion, String eemNombre) {
        this.eemCodigo = eemCodigo;
        this.eemDescripcion = eemDescripcion;
        this.eemNombre = eemNombre;
    }

    @Id
    @Column(name = "EEM_CODIGO", nullable = false)
    public Long getEemCodigo() {
        return eemCodigo;
    }

    public void setEemCodigo(Long eemCodigo) {
        this.eemCodigo = eemCodigo;
    }

    @Column(name = "EEM_DESCRIPCION", nullable = false, length = 100)
    public String getEemDescripcion() {
        return eemDescripcion;
    }

    public void setEemDescripcion(String eemDescripcion) {
        this.eemDescripcion = eemDescripcion;
    }

    @Column(name = "EEM_NOMBRE", nullable = false, length = 20)
    public String getEemNombre() {
        return eemNombre;
    }

    public void setEemNombre(String eemNombre) {
        this.eemNombre = eemNombre;
    }

    @OneToMany(mappedBy = "siiEstadoEstudioMerc")
    public List<SiiEstudioMercado> getSiiEstudioMercadoList() {
        return siiEstudioMercadoList;
    }

    public void setSiiEstudioMercadoList(List<SiiEstudioMercado> siiEstudioMercadoList) {
        this.siiEstudioMercadoList = siiEstudioMercadoList;
    }

    public SiiEstudioMercado addSiiEstudioMercado(SiiEstudioMercado siiEstudioMercado) {
        getSiiEstudioMercadoList().add(siiEstudioMercado);
        siiEstudioMercado.setSiiEstadoEstudioMerc(this);
        return siiEstudioMercado;
    }

    public SiiEstudioMercado removeSiiEstudioMercado(SiiEstudioMercado siiEstudioMercado) {
        getSiiEstudioMercadoList().remove(siiEstudioMercado);
        siiEstudioMercado.setSiiEstadoEstudioMerc(null);
        return siiEstudioMercado;
    }
}
