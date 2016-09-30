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
@Table(name = "SII_ESTADO_PFC")
public class SiiEstadoPfc implements Serializable {
    private static final long serialVersionUID = -6138491137137277548L;
    private Long epfCodigo;
    private String epfDescripcion;
    private String epfNombre;
    private List<SiiProyeccionFlujoCaja> siiProyeccionFlujoCajaList;

    public SiiEstadoPfc() {
    }

    public SiiEstadoPfc(Long epfCodigo, String epfDescripcion, String epfNombre) {
        this.epfCodigo = epfCodigo;
        this.epfDescripcion = epfDescripcion;
        this.epfNombre = epfNombre;
    }

    @Id
    @Column(name = "EPF_CODIGO", nullable = false)
    public Long getEpfCodigo() {
        return epfCodigo;
    }

    public void setEpfCodigo(Long epfCodigo) {
        this.epfCodigo = epfCodigo;
    }

    @Column(name = "EPF_DESCRIPCION", nullable = false, length = 100, insertable=false, updatable = false)
    public String getEpfDescripcion() {
        return epfDescripcion;
    }

    public void setEpfDescripcion(String epfDescripcion) {
        this.epfDescripcion = epfDescripcion;
    }

    @Column(name = "EPF_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEpfNombre() {
        return epfNombre;
    }

    public void setEpfNombre(String epfNombre) {
        this.epfNombre = epfNombre;
    }

    @OneToMany(mappedBy = "siiEstadoPfc")
    public List<SiiProyeccionFlujoCaja> getSiiProyeccionFlujoCajaList() {
        return siiProyeccionFlujoCajaList;
    }

    public void setSiiProyeccionFlujoCajaList(List<SiiProyeccionFlujoCaja> siiProyeccionFlujoCajaList) {
        this.siiProyeccionFlujoCajaList = siiProyeccionFlujoCajaList;
    }

    public SiiProyeccionFlujoCaja addSiiProyeccionFlujoCaja(SiiProyeccionFlujoCaja siiProyeccionFlujoCaja) {
        getSiiProyeccionFlujoCajaList().add(siiProyeccionFlujoCaja);
        siiProyeccionFlujoCaja.setSiiEstadoPfc(this);
        return siiProyeccionFlujoCaja;
    }

    public SiiProyeccionFlujoCaja removeSiiProyeccionFlujoCaja(SiiProyeccionFlujoCaja siiProyeccionFlujoCaja) {
        getSiiProyeccionFlujoCajaList().remove(siiProyeccionFlujoCaja);
        siiProyeccionFlujoCaja.setSiiEstadoPfc(null);
        return siiProyeccionFlujoCaja;
    }
}
