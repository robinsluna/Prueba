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
@Table(name = "SII_ESTADO_INVITACION")
public class SiiEstadoInvitacion implements Serializable {
    private static final long serialVersionUID = -3339949373782871882L;
    private Long einCodigo;
    private String einDescripcion;
    private String einNombre;
    private List<SiiInvitacionProceso> siiInvitacionProcesoList;

    public SiiEstadoInvitacion() {
    }

    public SiiEstadoInvitacion(Long einCodigo, String einDescripcion, String einNombre) {
        this.einCodigo = einCodigo;
        this.einDescripcion = einDescripcion;
        this.einNombre = einNombre;
    }

    @Id
    @Column(name = "EIN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTADO_INVITACION_COD")
    @SequenceGenerator(name = "SEQ_ESTADO_INVITACION_COD", sequenceName = "SEQ_ESTADO_INVITACION_COD",allocationSize=1)
    public Long getEinCodigo() {
        return einCodigo;
    }

    public void setEinCodigo(Long einCodigo) {
        this.einCodigo = einCodigo;
    }

    @Column(name = "EIN_DESCRIPCION", length = 100, insertable=false, updatable = false)
    public String getEinDescripcion() {
        return einDescripcion;
    }

    public void setEinDescripcion(String einDescripcion) {
        this.einDescripcion = einDescripcion;
    }

    @Column(name = "EIN_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEinNombre() {
        return einNombre;
    }

    public void setEinNombre(String einNombre) {
        this.einNombre = einNombre;
    }

    @OneToMany(mappedBy = "siiEstadoInvitacion")
    public List<SiiInvitacionProceso> getSiiInvitacionProcesoList() {
        return siiInvitacionProcesoList;
    }

    public void setSiiInvitacionProcesoList(List<SiiInvitacionProceso> siiInvitacionProcesoList) {
        this.siiInvitacionProcesoList = siiInvitacionProcesoList;
    }

    public SiiInvitacionProceso addSiiInvitacionProceso(SiiInvitacionProceso siiInvitacionProceso) {
        getSiiInvitacionProcesoList().add(siiInvitacionProceso);
        siiInvitacionProceso.setSiiEstadoInvitacion(this);
        return siiInvitacionProceso;
    }

    public SiiInvitacionProceso removeSiiInvitacionProceso(SiiInvitacionProceso siiInvitacionProceso) {
        getSiiInvitacionProcesoList().remove(siiInvitacionProceso);
        siiInvitacionProceso.setSiiEstadoInvitacion(null);
        return siiInvitacionProceso;
    }
}
