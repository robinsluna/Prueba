package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SII_OFICIO_DESIG_SUPERV")
public class SiiOficioDesigSuperv implements Serializable {
    private static final long serialVersionUID = 2659554140282282500L;
    private Long odsCodgo;
    private String odsEstado;
    private Date odsFechaDesig;
    private String odsNombreExterno;
    private String odsNumIdentExt;
    private SiiUsuario siiUsuario;
    private SiiProcesoContratacion siiProcesoContratacion;
    private SiiArchivoFisico siiArchivoFisico;
    private SiiTipoIdentificacion siiTipoIdentificacion;

    public SiiOficioDesigSuperv() {
    }

    public SiiOficioDesigSuperv(SiiArchivoFisico siiArchivoFisico, Long odsCodgo, String odsEstado, Date odsFechaDesig,
                                String odsNumIdentExt, SiiProcesoContratacion siiProcesoContratacion, String odsNombreExterno,
                                SiiTipoIdentificacion siiTipoIdentificacion, SiiUsuario siiUsuario) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.odsCodgo = odsCodgo;
        this.odsEstado = odsEstado;
        this.odsFechaDesig = odsFechaDesig;
        this.odsNombreExterno = odsNombreExterno;
        this.odsNumIdentExt = odsNumIdentExt;
        this.siiProcesoContratacion = siiProcesoContratacion;
        this.siiTipoIdentificacion = siiTipoIdentificacion;
        this.siiUsuario = siiUsuario;
    }


    @Id
    @Column(name = "ODS_CODGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OFIC_DESIG_SUPERV_COD")
    @SequenceGenerator(name = "SEQ_OFIC_DESIG_SUPERV_COD", sequenceName = "SEQ_OFIC_DESIG_SUPERV_COD",allocationSize=1)
    public Long getOdsCodgo() {
        return odsCodgo;
    }

    public void setOdsCodgo(Long odsCodgo) {
        this.odsCodgo = odsCodgo;
    }

    @Column(name = "ODS_ESTADO", nullable = false, length = 1)
    public String getOdsEstado() {
        return odsEstado;
    }

    public void setOdsEstado(String odsEstado) {
        this.odsEstado = odsEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ODS_FECHA_DESIG")
    public Date getOdsFechaDesig() {
        return odsFechaDesig;
    }

    public void setOdsFechaDesig(Date odsFechaDesig) {
        this.odsFechaDesig = odsFechaDesig;
    }

    @Column(name = "ODS_NOMBRE_EXTERNO", length = 120)
    public String getOdsNombreExterno() {
        return odsNombreExterno;
    }

    public void setOdsNombreExterno(String odsNombreExterno) {
        this.odsNombreExterno = odsNombreExterno;
    }

    @Column(name = "ODS_NUM_IDENT_EXT", length = 20)
    public String getOdsNumIdentExt() {
        return odsNumIdentExt;
    }

    public void setOdsNumIdentExt(String odsNumIdentExt) {
        this.odsNumIdentExt = odsNumIdentExt;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_SUP")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
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
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @ManyToOne
    @JoinColumn(name = "TID_CODIGO_EXT")
    public SiiTipoIdentificacion getSiiTipoIdentificacion() {
        return siiTipoIdentificacion;
    }

    public void setSiiTipoIdentificacion(SiiTipoIdentificacion siiTipoIdentificacion) {
        this.siiTipoIdentificacion = siiTipoIdentificacion;
    }
}
