package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_LOG_GENERAL")
public class SiiLogGeneral implements Serializable {
    private Long lgeCodigo;
    private String lgeContenido;
    private Date lgeFecha;
    private String lgeModulo;
    private Integer lgeSeveridad;
    private Integer lgeTipoLog;
    private SiiUsuario siiUsuario;
    private Long lgeTiempoEjec;

    public SiiLogGeneral() {
    }

    public SiiLogGeneral(Long lgeCodigo, String lgeContenido, String lgeModulo, Integer lgeSeveridad,
                         Integer lgeTipoLog, SiiUsuario siiUsuario, Date lgeFecha, Long tiempoEjec) {
        this.lgeCodigo = lgeCodigo;
        this.lgeContenido = lgeContenido;
        this.lgeFecha = lgeFecha;
        this.lgeModulo = lgeModulo;
        this.lgeSeveridad = lgeSeveridad;
        this.lgeTipoLog = lgeTipoLog;
        this.siiUsuario = siiUsuario;
        this.lgeTiempoEjec = tiempoEjec;
    }

    @Id
    @Column(name = "LGE_CODIGO", nullable = false)
    public Long getLgeCodigo() {
        return lgeCodigo;
    }

    public void setLgeCodigo(Long lgeCodigo) {
        this.lgeCodigo = lgeCodigo;
    }

    @Column(name = "LGE_CONTENIDO", nullable = false, length = 1000)
    public String getLgeContenido() {
        return lgeContenido;
    }

    public void setLgeContenido(String lgeContenido) {
        this.lgeContenido = lgeContenido;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LGE_FECHA", nullable = false)
    public Date getLgeFecha() {
        return lgeFecha;
    }

    public void setLgeFecha(Date lgeFecha) {
        this.lgeFecha = lgeFecha;
    }

    @Column(name = "LGE_MODULO", nullable = false, length = 50)
    public String getLgeModulo() {
        return lgeModulo;
    }

    public void setLgeModulo(String lgeModulo) {
        this.lgeModulo = lgeModulo;
    }

    @Column(name = "LGE_SEVERIDAD", nullable = false)
    public Integer getLgeSeveridad() {
        return lgeSeveridad;
    }

    public void setLgeSeveridad(Integer lgeSeveridad) {
        this.lgeSeveridad = lgeSeveridad;
    }

    @Column(name = "LGE_TIPO_LOG", nullable = false)
    public Integer getLgeTipoLog() {
        return lgeTipoLog;
    }

    public void setLgeTipoLog(Integer lgeTipoLog) {
        this.lgeTipoLog = lgeTipoLog;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @Column(name = "LGE_TIEMPO_EJEC")
    public Long getLgeTiempoEjec() {
        return lgeTiempoEjec;
    }
    
    public void setLgeTiempoEjec(Long lgeTiempoEjec) {
        this.lgeTiempoEjec = lgeTiempoEjec;
    }
}
