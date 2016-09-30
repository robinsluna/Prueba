package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SII_OTROSI")
public class SiiOtrosi implements Serializable {
    private static final long serialVersionUID = 3577282957689273321L;
    private Long osiCodigo;
    private Long osiConsecutivo;
    private Date osiFecha;
    private Date osiFechaCitOpe;
    private Date osiFechaFirColj;
    private Date osiFechaFirOpe;
    private Date osiFechaProgFir;
    private Date osiFechaRevAbog;
    private String osiTexValFin;
    private String osiTexValGct;
    private SiiEstadoOtrosi siiEstadoOtrosi;
    private List<SiiNovedad> siiNovedadList;
    private List<SiiRevisFinancOtrosi> siiRevisFinancOtrosiList;
    private List<SiiValidacGctOtrosi> siiValidacGctOtrosiList;
    private List<SiiPolizaContrat> siiPolizaContratList;
    private String osiTextoValCca;
    private SiiArchivoFisico siiArchivoFisico;
    private Date osiFechaFin;

    public SiiOtrosi() {
    }

    public SiiOtrosi(SiiEstadoOtrosi siiEstadoOtrosi, Long osiCodigo, Long osiConsecutivo, Date osiFecha,
                     Date osiFechaCitOpe, Date osiFechaFirColj, Date osiFechaFirOpe, Date osiFechaProgFir,
                     Date osiFechaRevAbog, String osiTexValFin, String osiTexValGct) {
        this.siiEstadoOtrosi = siiEstadoOtrosi;
        this.osiCodigo = osiCodigo;
        this.osiConsecutivo = osiConsecutivo;
        this.osiFecha = osiFecha;
        this.osiFechaCitOpe = osiFechaCitOpe;
        this.osiFechaFirColj = osiFechaFirColj;
        this.osiFechaFirOpe = osiFechaFirOpe;
        this.osiFechaProgFir = osiFechaProgFir;
        this.osiFechaRevAbog = osiFechaRevAbog;
        this.osiTexValFin = osiTexValFin;
        this.osiTexValGct = osiTexValGct;
    }


    @Id
    @Column(name = "OSI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OTROSI_COD")
    @SequenceGenerator(name = "SEQ_OTROSI_COD", sequenceName = "SEQ_OTROSI_COD",allocationSize=1)
    public Long getOsiCodigo() {
        return osiCodigo;
    }

    public void setOsiCodigo(Long osiCodigo) {
        this.osiCodigo = osiCodigo;
    }

    @Column(name = "OSI_CONSECUTIVO")
    public Long getOsiConsecutivo() {
        return osiConsecutivo;
    }

    public void setOsiConsecutivo(Long osiConsecutivo) {
        this.osiConsecutivo = osiConsecutivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OSI_FECHA")
    public Date getOsiFecha() {
        return osiFecha;
    }

    public void setOsiFecha(Date osiFecha) {
        this.osiFecha = osiFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OSI_FECHA_CIT_OPE")
    public Date getOsiFechaCitOpe() {
        return osiFechaCitOpe;
    }

    public void setOsiFechaCitOpe(Date osiFechaCitOpe) {
        this.osiFechaCitOpe = osiFechaCitOpe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OSI_FECHA_FIR_COLJ")
    public Date getOsiFechaFirColj() {
        return osiFechaFirColj;
    }

    public void setOsiFechaFirColj(Date osiFechaFirColj) {
        this.osiFechaFirColj = osiFechaFirColj;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OSI_FECHA_FIR_OPE")
    public Date getOsiFechaFirOpe() {
        return osiFechaFirOpe;
    }

    public void setOsiFechaFirOpe(Date osiFechaFirOpe) {
        this.osiFechaFirOpe = osiFechaFirOpe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OSI_FECHA_PROG_FIR")
    public Date getOsiFechaProgFir() {
        return osiFechaProgFir;
    }

    public void setOsiFechaProgFir(Date osiFechaProgFir) {
        this.osiFechaProgFir = osiFechaProgFir;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OSI_FECHA_REV_ABOG")
    public Date getOsiFechaRevAbog() {
        return osiFechaRevAbog;
    }

    public void setOsiFechaRevAbog(Date osiFechaRevAbog) {
        this.osiFechaRevAbog = osiFechaRevAbog;
    }

    @Column(name = "OSI_TEX_VAL_FIN", length = 1500)
    public String getOsiTexValFin() {
        return osiTexValFin;
    }

    public void setOsiTexValFin(String osiTexValFin) {
        this.osiTexValFin = osiTexValFin;
    }

    @Column(name = "OSI_TEX_VAL_GCT", length = 1500)
    public String getOsiTexValGct() {
        return osiTexValGct;
    }

    public void setOsiTexValGct(String osiTexValGct) {
        this.osiTexValGct = osiTexValGct;
    }

    @ManyToOne
    @JoinColumn(name = "EOS_CODIGO")
    public SiiEstadoOtrosi getSiiEstadoOtrosi() {
        return siiEstadoOtrosi;
    }

    public void setSiiEstadoOtrosi(SiiEstadoOtrosi siiEstadoOtrosi) {
        this.siiEstadoOtrosi = siiEstadoOtrosi;
    }

    @OneToMany(mappedBy = "siiOtrosi")
    public List<SiiNovedad> getSiiNovedadList() {
        return siiNovedadList;
    }

    public void setSiiNovedadList(List<SiiNovedad> siiNovedadList) {
        this.siiNovedadList = siiNovedadList;
    }

    public SiiNovedad addSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().add(siiNovedad);
        siiNovedad.setSiiOtrosi(this);
        return siiNovedad;
    }

    public SiiNovedad removeSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().remove(siiNovedad);
        siiNovedad.setSiiOtrosi(null);
        return siiNovedad;
    }

    @OneToMany(mappedBy = "siiOtrosi")
    public List<SiiRevisFinancOtrosi> getSiiRevisFinancOtrosiList() {
        return siiRevisFinancOtrosiList;
    }

    public void setSiiRevisFinancOtrosiList(List<SiiRevisFinancOtrosi> siiRevisFinancOtrosiList) {
        this.siiRevisFinancOtrosiList = siiRevisFinancOtrosiList;
    }

    public SiiRevisFinancOtrosi addSiiRevisFinancOtrosi(SiiRevisFinancOtrosi siiRevisFinancOtrosi) {
        getSiiRevisFinancOtrosiList().add(siiRevisFinancOtrosi);
        siiRevisFinancOtrosi.setSiiOtrosi(this);
        return siiRevisFinancOtrosi;
    }

    public SiiRevisFinancOtrosi removeSiiRevisFinancOtrosi(SiiRevisFinancOtrosi siiRevisFinancOtrosi) {
        getSiiRevisFinancOtrosiList().remove(siiRevisFinancOtrosi);
        siiRevisFinancOtrosi.setSiiOtrosi(null);
        return siiRevisFinancOtrosi;
    }

    @OneToMany(mappedBy = "siiOtrosi")
    public List<SiiValidacGctOtrosi> getSiiValidacGctOtrosiList() {
        return siiValidacGctOtrosiList;
    }

    public void setSiiValidacGctOtrosiList(List<SiiValidacGctOtrosi> siiValidacGctOtrosiList) {
        this.siiValidacGctOtrosiList = siiValidacGctOtrosiList;
    }

    public SiiValidacGctOtrosi addSiiValidacGctOtrosi(SiiValidacGctOtrosi siiValidacGctOtrosi) {
        getSiiValidacGctOtrosiList().add(siiValidacGctOtrosi);
        siiValidacGctOtrosi.setSiiOtrosi(this);
        return siiValidacGctOtrosi;
    }

    public SiiValidacGctOtrosi removeSiiValidacGctOtrosi(SiiValidacGctOtrosi siiValidacGctOtrosi) {
        getSiiValidacGctOtrosiList().remove(siiValidacGctOtrosi);
        siiValidacGctOtrosi.setSiiOtrosi(null);
        return siiValidacGctOtrosi;
    }

    @OneToMany(mappedBy = "siiOtrosi")
    public List<SiiPolizaContrat> getSiiPolizaContratList() {
        return siiPolizaContratList;
    }

    public void setSiiPolizaContratList(List<SiiPolizaContrat> siiPolizaContratList) {
        this.siiPolizaContratList = siiPolizaContratList;
    }

    public SiiPolizaContrat addSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList().add(siiPolizaContrat);
        siiPolizaContrat.setSiiOtrosi(this);
        return siiPolizaContrat;
    }

    public SiiPolizaContrat removeSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList().remove(siiPolizaContrat);
        siiPolizaContrat.setSiiOtrosi(null);
        return siiPolizaContrat;
    }

    @Column(name = "OSI_TEXTO_VAL_CCA", length = 1500)
    public String getOsiTextoValCca() {
        return osiTextoValCca;
    }

    public void setOsiTextoValCca(String osiTextoValCca) {
        this.osiTextoValCca = osiTextoValCca;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OSI_FECHA_FIN", nullable = false)
    public Date getOsiFechaFin() {
        return osiFechaFin;
    }

    public void setOsiFechaFin(Date osiFechaFin) {
        this.osiFechaFin = osiFechaFin;
    }
}
