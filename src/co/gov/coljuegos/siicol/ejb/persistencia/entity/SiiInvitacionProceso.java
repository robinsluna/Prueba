package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_INVITACION_PROCESO")
public class SiiInvitacionProceso implements Serializable {
    private static final long serialVersionUID = -3864600790309863970L;
    private Long iprCodigo;
    private Date iprFecha;
    private SiiProcesoContratacion siiProcesoContratacion;
    private SiiUsuario siiUsuario;
    private List<SiiProveedorInvitacion> siiProveedorInvitacionList1;
    private SiiEstadoInvitacion siiEstadoInvitacion;
    private Date iprFechaVenc;

    public SiiInvitacionProceso() {
    }

    public SiiInvitacionProceso(SiiEstadoInvitacion siiEstadoInvitacion, Long iprCodigo, Date iprFecha, Date iprFechaVenc, SiiProcesoContratacion siiProcesoContratacion,
                                SiiUsuario siiUsuario) {
        this.siiEstadoInvitacion = siiEstadoInvitacion;
        this.iprCodigo = iprCodigo;
        this.iprFecha = iprFecha;
        this.siiProcesoContratacion = siiProcesoContratacion;
        this.siiUsuario = siiUsuario;
        this.iprFechaVenc = iprFechaVenc;
    }


    @Id
    @Column(name = "IPR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INVIT_PROCESO_COD")
    @SequenceGenerator(name = "SEQ_INVIT_PROCESO_COD", sequenceName = "SEQ_INVIT_PROCESO_COD",allocationSize=1)
    public Long getIprCodigo() {
        return iprCodigo;
    }

    public void setIprCodigo(Long iprCodigo) {
        this.iprCodigo = iprCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IPR_FECHA", nullable = false)
    public Date getIprFecha() {
        return iprFecha;
    }

    public void setIprFecha(Date iprFecha) {
        this.iprFecha = iprFecha;
    }

    @OneToMany(mappedBy = "siiInvitacionProceso")
    public List<SiiProveedorInvitacion> getSiiProveedorInvitacionList1() {
        return siiProveedorInvitacionList1;
    }

    public void setSiiProveedorInvitacionList1(List<SiiProveedorInvitacion> siiProveedorInvitacionList1) {
        this.siiProveedorInvitacionList1 = siiProveedorInvitacionList1;
    }

    public SiiProveedorInvitacion addSiiProveedorInvitacion(SiiProveedorInvitacion siiProveedorInvitacion) {
        getSiiProveedorInvitacionList1().add(siiProveedorInvitacion);
        siiProveedorInvitacion.setSiiInvitacionProceso(this);
        return siiProveedorInvitacion;
    }

    public SiiProveedorInvitacion removeSiiProveedorInvitacion(SiiProveedorInvitacion siiProveedorInvitacion) {
        getSiiProveedorInvitacionList1().remove(siiProveedorInvitacion);
        siiProveedorInvitacion.setSiiInvitacionProceso(null);
        return siiProveedorInvitacion;
    }

    @ManyToOne
    @JoinColumn(name = "EIN_CODIGO")
    public SiiEstadoInvitacion getSiiEstadoInvitacion() {
        return siiEstadoInvitacion;
    }

    public void setSiiEstadoInvitacion(SiiEstadoInvitacion siiEstadoInvitacion) {
        this.siiEstadoInvitacion = siiEstadoInvitacion;
    }

    @ManyToOne
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion() {
        return siiProcesoContratacion;
    }

    public void setSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        this.siiProcesoContratacion = siiProcesoContratacion;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CREA")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IPR_FECHA_VENC", nullable = false)
    public Date getIprFechaVenc() {
        return iprFechaVenc;
    }

    public void setIprFechaVenc(Date iprFechaVenc) {
        this.iprFechaVenc = iprFechaVenc;
    }
}
