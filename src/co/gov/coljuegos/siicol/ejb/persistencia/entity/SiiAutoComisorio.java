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
@Table(name = "SII_AUTO_COMISORIO")
public class SiiAutoComisorio implements Serializable {
    private static final long serialVersionUID = 1313742930198719715L;
    private Long aucCodigo;
    private String aucEstado;
    private Date aucFecha;
    private Date aucFechaAnulac;
    private Date aucFechaVisita;
    private String aucMotivoAnulac;
    private Integer aucNumero;
    private String aucTipoVisita;
    private SiiEstablecimiento siiEstablecimiento;
    private SiiContrato siiContrato;
    private SiiGrupoFiscalizacion siiGrupoFiscalizacion;
    private List<SiiInventarioAutoComis> siiInventarioAutoComisList;
    private List<SiiActaVisita> siiActaVisitaList;



    public SiiAutoComisorio() {
    }

    public SiiAutoComisorio(Long aucCodigo, String aucEstado, Date aucFecha, Date aucFechaAnulac, Date aucFechaVisita, String aucMotivoAnulac, Integer aucNumero, String aucTipoVisita,
                            SiiContrato siiContrato, SiiEstablecimiento siiEstablecimiento, SiiGrupoFiscalizacion siiGrupoFiscalizacion) {
        this.aucCodigo = aucCodigo;
        this.aucEstado = aucEstado;
        this.aucFecha = aucFecha;
        this.aucFechaAnulac = aucFechaAnulac;
        this.aucFechaVisita = aucFechaVisita;
        this.aucMotivoAnulac = aucMotivoAnulac;
        this.aucNumero = aucNumero;
        this.aucTipoVisita = aucTipoVisita;
        this.siiContrato = siiContrato;
        this.siiEstablecimiento = siiEstablecimiento;
        this.siiGrupoFiscalizacion = siiGrupoFiscalizacion;
    }

    @Id
    @Column(name = "AUC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AUTO_COMISORIO_COD")
    @SequenceGenerator(name = "SEQ_AUTO_COMISORIO_COD", sequenceName = "SEQ_AUTO_COMISORIO_COD",allocationSize=1)
    public Long getAucCodigo() {
        return aucCodigo;
    }

    public void setAucCodigo(Long aucCodigo) {
        this.aucCodigo = aucCodigo;
    }

    @Column(name = "AUC_ESTADO", nullable = false, length = 1)
    public String getAucEstado() {
        return aucEstado;
    }

    public void setAucEstado(String aucEstado) {
        this.aucEstado = aucEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUC_FECHA", nullable = false)
    public Date getAucFecha() {
        return aucFecha;
    }

    public void setAucFecha(Date aucFecha) {
        this.aucFecha = aucFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUC_FECHA_ANULAC")
    public Date getAucFechaAnulac() {
        return aucFechaAnulac;
    }

    public void setAucFechaAnulac(Date aucFechaAnulac) {
        this.aucFechaAnulac = aucFechaAnulac;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUC_FECHA_VISITA")
    public Date getAucFechaVisita() {
        return aucFechaVisita;
    }

    public void setAucFechaVisita(Date aucFechaVisita) {
        this.aucFechaVisita = aucFechaVisita;
    }

    @Column(name = "AUC_MOTIVO_ANULAC", length = 550)
    public String getAucMotivoAnulac() {
        return aucMotivoAnulac;
    }

    public void setAucMotivoAnulac(String aucMotivoAnulac) {
        this.aucMotivoAnulac = aucMotivoAnulac;
    }

    @Column(name = "AUC_NUMERO", nullable = false)
    public Integer getAucNumero() {
        return aucNumero;
    }

    public void setAucNumero(Integer aucNumero) {
        this.aucNumero = aucNumero;
    }

    @Column(name = "AUC_TIPO_VISITA", nullable = false, length = 1)
    public String getAucTipoVisita() {
        return aucTipoVisita;
    }

    public void setAucTipoVisita(String aucTipoVisita) {
        this.aucTipoVisita = aucTipoVisita;
    }


    @ManyToOne
    @JoinColumn(name = "EST_CODIGO")
    public SiiEstablecimiento getSiiEstablecimiento() {
        return siiEstablecimiento;
    }

    public void setSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        this.siiEstablecimiento = siiEstablecimiento;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @ManyToOne
    @JoinColumn(name = "GFI_CODIGO")
    public SiiGrupoFiscalizacion getSiiGrupoFiscalizacion() {
        return siiGrupoFiscalizacion;
    }

    public void setSiiGrupoFiscalizacion(SiiGrupoFiscalizacion siiGrupoFiscalizacion) {
        this.siiGrupoFiscalizacion = siiGrupoFiscalizacion;
    }
    
    @OneToMany(mappedBy = "siiAutoComisorio")
    public List<SiiInventarioAutoComis> getSiiInventarioAutoComisList() {
        return siiInventarioAutoComisList;
    }

    public void setSiiInventarioAutoComisList(List<SiiInventarioAutoComis> siiInventarioAutoComisList) {
        this.siiInventarioAutoComisList = siiInventarioAutoComisList;
    }

    public SiiInventarioAutoComis addSiiInventarioAutoComis(SiiInventarioAutoComis siiInventarioAutoComis) {
        getSiiInventarioAutoComisList().add(siiInventarioAutoComis);
        siiInventarioAutoComis.setSiiAutoComisorio(this);
        return siiInventarioAutoComis;
    }

    public SiiInventarioAutoComis removeSiiInventarioAutoComis(SiiInventarioAutoComis siiInventarioAutoComis) {
        getSiiInventarioAutoComisList().remove(siiInventarioAutoComis);
        siiInventarioAutoComis.setSiiAutoComisorio(null);
        return siiInventarioAutoComis;
    }
    
    @OneToMany(mappedBy = "siiAutoComisorio")
    public List<SiiActaVisita> getSiiActaVisitaList() {
        return siiActaVisitaList;
    }

    public void setSiiActaVisitaList(List<SiiActaVisita> siiActaVisitaList) {
        this.siiActaVisitaList = siiActaVisitaList;
    }

    public SiiActaVisita addSiiActaVisita(SiiActaVisita siiActaVisita) {
        getSiiActaVisitaList().add(siiActaVisita);
        siiActaVisita.setSiiAutoComisorio(this);
        return siiActaVisita;
    }

    public SiiActaVisita removeSiiActaVisita(SiiActaVisita siiActaVisita) {
        getSiiActaVisitaList().remove(siiActaVisita);
        siiActaVisita.setSiiAutoComisorio(null);
        return siiActaVisita;
    }


}
