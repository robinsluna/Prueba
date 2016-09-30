package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_COMUNICAC_SUJ_SANC_ILE")
public class SiiComunicacSujSancIle implements Serializable {
    private static final long serialVersionUID = -5793497299586319995L;
    private String cssActivo;
    private Long cssCodigo;
    private Date cssFechaRad;
    private String cssRadicado;
    private SiiProcesoSancIlegalidad siiProcesoSancIlegalidad;
    private SiiUsuario siiUsuarioConec;

    public SiiComunicacSujSancIle() {
    }

    public SiiComunicacSujSancIle(String cssActivo, Long cssCodigo, Date cssFechaRad, String cssRadicado, SiiProcesoSancIlegalidad siiProcesoSancIlegalidad, SiiUsuario siiUsuarioConec) {
        this.cssActivo = cssActivo;
        this.cssCodigo = cssCodigo;
        this.cssFechaRad = cssFechaRad;
        this.cssRadicado = cssRadicado;
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Column(name = "CSS_ACTIVO", nullable = false, length = 1)
    public String getCssActivo() {
        return cssActivo;
    }

    public void setCssActivo(String cssActivo) {
        this.cssActivo = cssActivo;
    }

    @Id
    @Column(name = "CSS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_COMUNIC_SUJ_SANC_ILE_COD")
    @SequenceGenerator(name = "SEQ_COMUNIC_SUJ_SANC_ILE_COD", sequenceName = "SEQ_COMUNIC_SUJ_SANC_ILE_COD",allocationSize=1)
    public Long getCssCodigo() {
        return cssCodigo;
    }

    public void setCssCodigo(Long cssCodigo) {
        this.cssCodigo = cssCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CSS_FECHA_RAD", nullable = false)
    public Date getCssFechaRad() {
        return cssFechaRad;
    }

    public void setCssFechaRad(Date cssFechaRad) {
        this.cssFechaRad = cssFechaRad;
    }

    @Column(name = "CSS_RADICADO", nullable = false, length = 30)
    public String getCssRadicado() {
        return cssRadicado;
    }

    public void setCssRadicado(String cssRadicado) {
        this.cssRadicado = cssRadicado;
    }


    @ManyToOne
    @JoinColumn(name = "PRS_CODIGO")
    public SiiProcesoSancIlegalidad getSiiProcesoSancIlegalidad() {
        return siiProcesoSancIlegalidad;
    }

    public void setSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }
}
