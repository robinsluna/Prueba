package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_LOG_ACTIVIDAD")
public class SiiLogActividad implements Serializable {
    private static final long serialVersionUID = -1249560510110426791L;
    private Long loaCodigo;
    private Date loaFecha;
    private String loaIdSesion;
    private String loaPermisoAcc;
    private String loaUrl;
    private SiiUsuario siiUsuario;

    public SiiLogActividad() {
    }

    public SiiLogActividad(Long loaCodigo, Date loaFecha, String loaIdSesion, String loaPermisoAcc, String loaUrl, SiiUsuario siiUsuario) {
        this.loaCodigo = loaCodigo;
        this.loaFecha = loaFecha;
        this.loaIdSesion = loaIdSesion;
        this.loaPermisoAcc = loaPermisoAcc;
        this.loaUrl = loaUrl;
        this.siiUsuario = siiUsuario;
    }

    @Id
    @Column(name = "LOA_CODIGO", nullable = false)
    /* Comentariado. No se necesita conocer el id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_LOG_ACTIVIDAD_COD")
    @SequenceGenerator(name = "SEQ_LOG_ACTIVIDAD_COD", sequenceName = "SEQ_LOG_ACTIVIDAD_COD",allocationSize=1) */
    public Long getLoaCodigo() {
        return loaCodigo;
    }

    public void setLoaCodigo(Long loaCodigo) {
        this.loaCodigo = loaCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOA_FECHA", nullable = false)
    public Date getLoaFecha() {
        return loaFecha;
    }

    public void setLoaFecha(Date loaFecha) {
        this.loaFecha = loaFecha;
    }

    @Column(name = "LOA_ID_SESION", length = 200)
    public String getLoaIdSesion() {
        return loaIdSesion;
    }

    public void setLoaIdSesion(String loaIdSesion) {
        this.loaIdSesion = loaIdSesion;
    }

    @Column(name = "LOA_PERMISO_ACC", nullable = false, length = 1)
    public String getLoaPermisoAcc() {
        return loaPermisoAcc;
    }

    public void setLoaPermisoAcc(String loaPermisoAcc) {
        this.loaPermisoAcc = loaPermisoAcc;
    }

    @Column(name = "LOA_URL", nullable = false, length = 100)
    public String getLoaUrl() {
        return loaUrl;
    }

    public void setLoaUrl(String loaUrl) {
        this.loaUrl = loaUrl;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }
}
