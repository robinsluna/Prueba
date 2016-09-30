package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "SII_RESOLUCION_PROC_SANC")
public class SiiResolucionProcSanc implements Serializable {
    private static final long serialVersionUID = -7618322149294344613L;
    private Date remFecha;
    private String remNumero;
    private Date remSnumFechaRad;
    private String remSnumRadicado;
    private String remTipo;
    private BigDecimal remValorSancion;
    private Long repCodigo;
    private String repConceptoSancion;
    private Date repFecha;
    private List<SiiProcesoSancionatorio> siiProcesoSancionatorioSancList;
    private List<SiiProcesoSancionatorio> siiProcesoSancionatorioSinList;
    private List<SiiProcesoSancionatorio> siiProcesoSancionatorioReposList;
    private List<SiiProcesoSancionatorio> siiProcesoSancionatorioApelaList;
    private SiiArchivoFisico siiArchivoFisico;
    private List<SiiTramiteResolProcSan> siiTramiteResolProcSanList;
    private BigDecimal remValClausulaPen;

    public SiiResolucionProcSanc() {
    }

    public SiiResolucionProcSanc(SiiArchivoFisico siiArchivoFisico, Date remFecha, String remNumero, Date remSnumFechaRad, String remSnumRadicado, String remTipo, BigDecimal remValorSancion,
                                 Long repCodigo, String repConceptoSancion, Date repFecha) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.remFecha = remFecha;
        this.remNumero = remNumero;
        this.remSnumFechaRad = remSnumFechaRad;
        this.remSnumRadicado = remSnumRadicado;
        this.remTipo = remTipo;
        this.remValorSancion = remValorSancion;
        this.repCodigo = repCodigo;
        this.repConceptoSancion = repConceptoSancion;
        this.repFecha = repFecha;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REM_FECHA")
    public Date getRemFecha() {
        return remFecha;
    }

    public void setRemFecha(Date remFecha) {
        this.remFecha = remFecha;
    }

    @Column(name = "REM_NUMERO", length = 30)
    public String getRemNumero() {
        return remNumero;
    }

    public void setRemNumero(String remNumero) {
        this.remNumero = remNumero;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REM_SNUM_FECHA_RAD")
    public Date getRemSnumFechaRad() {
        return remSnumFechaRad;
    }

    public void setRemSnumFechaRad(Date remSnumFechaRad) {
        this.remSnumFechaRad = remSnumFechaRad;
    }

    @Column(name = "REM_SNUM_RADICADO", length = 30)
    public String getRemSnumRadicado() {
        return remSnumRadicado;
    }

    public void setRemSnumRadicado(String remSnumRadicado) {
        this.remSnumRadicado = remSnumRadicado;
    }

    @Column(name = "REM_TIPO", length = 1)
    public String getRemTipo() {
        return remTipo;
    }

    public void setRemTipo(String remTipo) {
        this.remTipo = remTipo;
    }

    @Column(name = "REM_VALOR_SANCION")
    public BigDecimal getRemValorSancion() {
        return remValorSancion;
    }

    public void setRemValorSancion(BigDecimal remValorSancion) {
        this.remValorSancion = remValorSancion;
    }

    @Id
    @Column(name = "REP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESOLUCION_PROC_SANC_COD")
    @SequenceGenerator(name = "SEQ_RESOLUCION_PROC_SANC_COD", sequenceName = "SEQ_RESOLUCION_PROC_SANC_COD",allocationSize=1)
    public Long getRepCodigo() {
        return repCodigo;
    }

    public void setRepCodigo(Long repCodigo) {
        this.repCodigo = repCodigo;
    }

    @Column(name = "REP_CONCEPTO_SANCION", length = 5)
    public String getRepConceptoSancion() {
        return repConceptoSancion;
    }

    public void setRepConceptoSancion(String repConceptoSancion) {
        this.repConceptoSancion = repConceptoSancion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REP_FECHA", nullable = false)
    public Date getRepFecha() {
        return repFecha;
    }

    public void setRepFecha(Date repFecha) {
        this.repFecha = repFecha;
    }

    @OneToMany(mappedBy = "siiResolucionProcSancSanc")
    public List<SiiProcesoSancionatorio> getSiiProcesoSancionatorioSancList() {
        return siiProcesoSancionatorioSancList;
    }

    public void setSiiProcesoSancionatorioSancList(List<SiiProcesoSancionatorio> siiProcesoSancionatorioSancList) {
        this.siiProcesoSancionatorioSancList = siiProcesoSancionatorioSancList;
    }

    public SiiProcesoSancionatorio addSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioSancList().add(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiResolucionProcSancSanc(this);
        return siiProcesoSancionatorio;
    }

    public SiiProcesoSancionatorio removeSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioSancList().remove(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiResolucionProcSancSanc(null);
        return siiProcesoSancionatorio;
    }

    @OneToMany(mappedBy = "siiResolucionProcSancSin")
    public List<SiiProcesoSancionatorio> getSiiProcesoSancionatorioSinList() {
        return siiProcesoSancionatorioSinList;
    }

    public void setSiiProcesoSancionatorioSinList(List<SiiProcesoSancionatorio> siiProcesoSancionatorioSinList) {
        this.siiProcesoSancionatorioSinList = siiProcesoSancionatorioSinList;
    }

    @OneToMany(mappedBy = "siiResolucionProcSancRepos")
    public List<SiiProcesoSancionatorio> getSiiProcesoSancionatorioReposList() {
        return siiProcesoSancionatorioReposList;
    }

    public void setSiiProcesoSancionatorioReposList(List<SiiProcesoSancionatorio> siiProcesoSancionatorioReposList) {
        this.siiProcesoSancionatorioReposList = siiProcesoSancionatorioReposList;
    }

    @OneToMany(mappedBy = "siiResolucionProcSancApela")
    public List<SiiProcesoSancionatorio> getSiiProcesoSancionatorioApelaList() {
        return siiProcesoSancionatorioApelaList;
    }

    public void setSiiProcesoSancionatorioApelaList(List<SiiProcesoSancionatorio> siiProcesoSancionatorioApelaList) {
        this.siiProcesoSancionatorioApelaList = siiProcesoSancionatorioApelaList;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @OneToMany(mappedBy = "siiResolucionProcSanc")
    public List<SiiTramiteResolProcSan> getSiiTramiteResolProcSanList() {
        return siiTramiteResolProcSanList;
    }

    public void setSiiTramiteResolProcSanList(List<SiiTramiteResolProcSan> siiTramiteResolProcSanList) {
        this.siiTramiteResolProcSanList = siiTramiteResolProcSanList;
    }

    public SiiTramiteResolProcSan addSiiTramiteResolProcSan(SiiTramiteResolProcSan siiTramiteResolProcSan) {
        getSiiTramiteResolProcSanList().add(siiTramiteResolProcSan);
        siiTramiteResolProcSan.setSiiResolucionProcSanc(this);
        return siiTramiteResolProcSan;
    }

    public SiiTramiteResolProcSan removeSiiTramiteResolProcSan(SiiTramiteResolProcSan siiTramiteResolProcSan) {
        getSiiTramiteResolProcSanList().remove(siiTramiteResolProcSan);
        siiTramiteResolProcSan.setSiiResolucionProcSanc(null);
        return siiTramiteResolProcSan;
    }

    @Column(name = "REM_VAL_CLAUSULA_PEN")
    public BigDecimal getRemValClausulaPen() {
        return remValClausulaPen;
    }
    
    public void setRemValClausulaPen(BigDecimal remValClausulaPen) {
        this.remValClausulaPen = remValClausulaPen;
    }
    
}
