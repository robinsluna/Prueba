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
@Table(name = "SII_CONSULTA_WEB_CONTRAT")
public class SiiConsultaWebContrat implements Serializable {
    private static final long serialVersionUID = 5186659353979046661L;
    private SiiArchivoFisico siiArchivoFisico;
    private Long cwcCodigo;
    private String cwcEntidad;
    private Date cwcFecha;
    private String cwcObjetoCont;
    private List<SiiCotizacionEstudio> siiCotizacionEstudioList2;

    public SiiConsultaWebContrat() {
    }

    public SiiConsultaWebContrat(SiiArchivoFisico siiArchivoFisico, Long cwcCodigo, String cwcEntidad, Date cwcFecha,
                                 String cwcObjetoCont) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.cwcCodigo = cwcCodigo;
        this.cwcEntidad = cwcEntidad;
        this.cwcFecha = cwcFecha;
        this.cwcObjetoCont = cwcObjetoCont;
    }


    @Id
    @Column(name = "CWC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONS_WEB_CONTRAT_COD")
    @SequenceGenerator(name = "SEQ_CONS_WEB_CONTRAT_COD", sequenceName = "SEQ_CONS_WEB_CONTRAT_COD",allocationSize=1)
    public Long getCwcCodigo() {
        return cwcCodigo;
    }

    public void setCwcCodigo(Long cwcCodigo) {
        this.cwcCodigo = cwcCodigo;
    }

    @Column(name = "CWC_ENTIDAD", nullable = false, length = 50)
    public String getCwcEntidad() {
        return cwcEntidad;
    }

    public void setCwcEntidad(String cwcEntidad) {
        this.cwcEntidad = cwcEntidad;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CWC_FECHA", nullable = false)
    public Date getCwcFecha() {
        return cwcFecha;
    }

    public void setCwcFecha(Date cwcFecha) {
        this.cwcFecha = cwcFecha;
    }

    @Column(name = "CWC_OBJETO_CONT", nullable = false, length = 500)
    public String getCwcObjetoCont() {
        return cwcObjetoCont;
    }

    public void setCwcObjetoCont(String cwcObjetoCont) {
        this.cwcObjetoCont = cwcObjetoCont;
    }

    @OneToMany(mappedBy = "siiConsultaWebContrat")
    public List<SiiCotizacionEstudio> getSiiCotizacionEstudioList2() {
        return siiCotizacionEstudioList2;
    }

    public void setSiiCotizacionEstudioList2(List<SiiCotizacionEstudio> siiCotizacionEstudioList2) {
        this.siiCotizacionEstudioList2 = siiCotizacionEstudioList2;
    }

    public SiiCotizacionEstudio addSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList2().add(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiConsultaWebContrat(this);
        return siiCotizacionEstudio;
    }

    public SiiCotizacionEstudio removeSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList2().remove(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiConsultaWebContrat(null);
        return siiCotizacionEstudio;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }
}
