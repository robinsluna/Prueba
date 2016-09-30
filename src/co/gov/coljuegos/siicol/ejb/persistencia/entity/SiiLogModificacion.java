package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_LOG_MODIFICACION")
public class SiiLogModificacion implements Serializable {
    private static final long serialVersionUID = -22445216418835399L;
    private Long lmoCodigo;
    private String lmoDescripcionTabla;
    private Date lmoFecha;
    private String lmoIpUsuarioBd;
    private String lmoTabla;
    private String lmoUsuarioBd;
    private String usuTipoModific;
    private SiiUsuario siiUsuarioConec;
    private List<SiiLogCampoModificacion> siiLogCampoModificacionList;

    public SiiLogModificacion() {
    }

    public SiiLogModificacion(Long lmoCodigo, String lmoDescripcionTabla, Date lmoFecha, String lmoIpUsuarioBd, String lmoTabla, String lmoUsuarioBd, SiiUsuario siiUsuarioConec,
                              String usuTipoModific) {
        this.lmoCodigo = lmoCodigo;
        this.lmoDescripcionTabla = lmoDescripcionTabla;
        this.lmoFecha = lmoFecha;
        this.lmoIpUsuarioBd = lmoIpUsuarioBd;
        this.lmoTabla = lmoTabla;
        this.lmoUsuarioBd = lmoUsuarioBd;
        this.siiUsuarioConec = siiUsuarioConec;
        this.usuTipoModific = usuTipoModific;
    }

    @Id
    @Column(name = "LMO_CODIGO", nullable = false)
    public Long getLmoCodigo() {
        return lmoCodigo;
    }

    public void setLmoCodigo(Long lmoCodigo) {
        this.lmoCodigo = lmoCodigo;
    }

    @Column(name = "LMO_DESCRIPCION_TABLA", nullable = false, length = 100)
    public String getLmoDescripcionTabla() {
        return lmoDescripcionTabla;
    }

    public void setLmoDescripcionTabla(String lmoDescripcionTabla) {
        this.lmoDescripcionTabla = lmoDescripcionTabla;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LMO_FECHA", nullable = false)
    public Date getLmoFecha() {
        return lmoFecha;
    }

    public void setLmoFecha(Date lmoFecha) {
        this.lmoFecha = lmoFecha;
    }

    @Column(name = "LMO_IP_USUARIO_BD", length = 20)
    public String getLmoIpUsuarioBd() {
        return lmoIpUsuarioBd;
    }

    public void setLmoIpUsuarioBd(String lmoIpUsuarioBd) {
        this.lmoIpUsuarioBd = lmoIpUsuarioBd;
    }

    @Column(name = "LMO_TABLA", nullable = false, length = 50)
    public String getLmoTabla() {
        return lmoTabla;
    }

    public void setLmoTabla(String lmoTabla) {
        this.lmoTabla = lmoTabla;
    }

    @Column(name = "LMO_USUARIO_BD", nullable = false, length = 50)
    public String getLmoUsuarioBd() {
        return lmoUsuarioBd;
    }

    public void setLmoUsuarioBd(String lmoUsuarioBd) {
        this.lmoUsuarioBd = lmoUsuarioBd;
    }


    @Column(name = "USU_TIPO_MODIFIC", nullable = false, length = 1)
    public String getUsuTipoModific() {
        return usuTipoModific;
    }

    public void setUsuTipoModific(String usuTipoModific) {
        this.usuTipoModific = usuTipoModific;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiLogModificacion")
    public List<SiiLogCampoModificacion> getSiiLogCampoModificacionList() {
        return siiLogCampoModificacionList;
    }

    public void setSiiLogCampoModificacionList(List<SiiLogCampoModificacion> siiLogCampoModificacionList) {
        this.siiLogCampoModificacionList = siiLogCampoModificacionList;
    }

    public SiiLogCampoModificacion addSiiLogCampoModificacion(SiiLogCampoModificacion siiLogCampoModificacion) {
        getSiiLogCampoModificacionList().add(siiLogCampoModificacion);
        siiLogCampoModificacion.setSiiLogModificacion(this);
        return siiLogCampoModificacion;
    }

    public SiiLogCampoModificacion removeSiiLogCampoModificacion(SiiLogCampoModificacion siiLogCampoModificacion) {
        getSiiLogCampoModificacionList().remove(siiLogCampoModificacion);
        siiLogCampoModificacion.setSiiLogModificacion(null);
        return siiLogCampoModificacion;
    }
}
