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
@Table(name = "SII_AJUSTE")
public class SiiAjuste implements Serializable {
    private Long ajuCodigo;
    private Date ajuFecha;
    private List<SiiInteresCuota> siiInteresCuotaList;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private SiiUsuario siiUsuario;
    private SiiTipoAjuste siiTipoAjuste;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoList;
    private List<SiiAjusteCuota> siiAjusteCuotaList;
    private List<SiiAmpliacionTemporal> siiAmpliacionTemporalList;
    private List<SiiAjusteDetRecaudo> siiAjusteDetRecaudoList;
    private Integer ajuConsecutivo;

    public SiiAjuste() {
    }

    public SiiAjuste(Long ajuCodigo, Date ajuFecha, SiiTipoAjuste siiTipoAjuste, SiiUsuario siiUsuario) {
        this.ajuCodigo = ajuCodigo;
        this.ajuFecha = ajuFecha;
        this.siiTipoAjuste = siiTipoAjuste;
        this.siiUsuario = siiUsuario;
    }

    @Id
    @Column(name = "AJU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AJUSTE_SEQ")
    @SequenceGenerator(name = "SEQ_AJUSTE_SEQ", sequenceName = "SEQ_AJUSTE_SEQ",allocationSize=1)
    public Long getAjuCodigo() {
        return ajuCodigo;
    }

    public void setAjuCodigo(Long ajuCodigo) {
        this.ajuCodigo = ajuCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AJU_FECHA", nullable = false)
    public Date getAjuFecha() {
        return ajuFecha;
    }

    public void setAjuFecha(Date ajuFecha) {
        this.ajuFecha = ajuFecha;
    }


    @OneToMany(mappedBy = "siiAjuste")
    public List<SiiInteresCuota> getSiiInteresCuotaList() {
        return siiInteresCuotaList;
    }

    public void setSiiInteresCuotaList(List<SiiInteresCuota> siiInteresCuotaList) {
        this.siiInteresCuotaList = siiInteresCuotaList;
    }

    public SiiInteresCuota addSiiInteresCuota(SiiInteresCuota siiInteresCuota) {
        getSiiInteresCuotaList().add(siiInteresCuota);
        siiInteresCuota.setSiiAjuste(this);
        return siiInteresCuota;
    }

    public SiiInteresCuota removeSiiInteresCuota(SiiInteresCuota siiInteresCuota) {
        getSiiInteresCuotaList().remove(siiInteresCuota);
        siiInteresCuota.setSiiAjuste(null);
        return siiInteresCuota;
    }

    @OneToMany(mappedBy = "siiAjuste")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiAjuste(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiAjuste(null);
        return siiDocumentoContable;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "TAJ_CODIGO")
    public SiiTipoAjuste getSiiTipoAjuste() {
        return siiTipoAjuste;
    }

    public void setSiiTipoAjuste(SiiTipoAjuste siiTipoAjuste) {
        this.siiTipoAjuste = siiTipoAjuste;
    }

    @OneToMany(mappedBy = "siiAjuste")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoList() {
        return siiDetalleRecaudoList;
    }

    public void setSiiDetalleRecaudoList(List<SiiDetalleRecaudo> siiDetalleRecaudoList) {
        this.siiDetalleRecaudoList = siiDetalleRecaudoList;
    }

    public SiiDetalleRecaudo addSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().add(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiAjuste(this);
        return siiDetalleRecaudo;
    }

    public SiiDetalleRecaudo removeSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().remove(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiAjuste(null);
        return siiDetalleRecaudo;
    }

    @OneToMany(mappedBy = "siiAjuste")
    public List<SiiAjusteCuota> getSiiAjusteCuotaList() {
        return siiAjusteCuotaList;
    }

    public void setSiiAjusteCuotaList(List<SiiAjusteCuota> siiAjusteCuotaList) {
        this.siiAjusteCuotaList = siiAjusteCuotaList;
    }

    public SiiAjusteCuota addSiiAjusteCuota(SiiAjusteCuota siiAjusteCuota) {
        getSiiAjusteCuotaList().add(siiAjusteCuota);
        siiAjusteCuota.setSiiAjuste(this);
        return siiAjusteCuota;
    }

    public SiiAjusteCuota removeSiiAjusteCuota(SiiAjusteCuota siiAjusteCuota) {
        getSiiAjusteCuotaList().remove(siiAjusteCuota);
        siiAjusteCuota.setSiiAjuste(null);
        return siiAjusteCuota;
    }

    @OneToMany(mappedBy = "siiAjuste")
    public List<SiiAmpliacionTemporal> getSiiAmpliacionTemporalList() {
        return siiAmpliacionTemporalList;
    }

    public void setSiiAmpliacionTemporalList(List<SiiAmpliacionTemporal> siiAmpliacionTemporalList) {
        this.siiAmpliacionTemporalList = siiAmpliacionTemporalList;
    }

    public SiiAmpliacionTemporal addSiiAmpliacionTemporal(SiiAmpliacionTemporal siiAmpliacionTemporal) {
        getSiiAmpliacionTemporalList().add(siiAmpliacionTemporal);
        siiAmpliacionTemporal.setSiiAjuste(this);
        return siiAmpliacionTemporal;
    }

    public SiiAmpliacionTemporal removeSiiAmpliacionTemporal(SiiAmpliacionTemporal siiAmpliacionTemporal) {
        getSiiAmpliacionTemporalList().remove(siiAmpliacionTemporal);
        siiAmpliacionTemporal.setSiiAjuste(null);
        return siiAmpliacionTemporal;
    }

    @OneToMany(mappedBy = "siiAjuste")
    public List<SiiAjusteDetRecaudo> getSiiAjusteDetRecaudoList() {
        return siiAjusteDetRecaudoList;
    }

    public void setSiiAjusteDetRecaudoList(List<SiiAjusteDetRecaudo> siiAjusteDetRecaudoList) {
        this.siiAjusteDetRecaudoList = siiAjusteDetRecaudoList;
    }

    public SiiAjusteDetRecaudo addSiiAjusteDetRecaudo(SiiAjusteDetRecaudo siiAjusteDetRecaudo) {
        getSiiAjusteDetRecaudoList().add(siiAjusteDetRecaudo);
        siiAjusteDetRecaudo.setSiiAjuste(this);
        return siiAjusteDetRecaudo;
    }

    public SiiAjusteDetRecaudo removeSiiAjusteDetRecaudo(SiiAjusteDetRecaudo siiAjusteDetRecaudo) {
        getSiiAjusteDetRecaudoList().remove(siiAjusteDetRecaudo);
        siiAjusteDetRecaudo.setSiiAjuste(null);
        return siiAjusteDetRecaudo;
    }

    @Column(name = "AJU_CONSECUTIVO", nullable = false)
    public Integer getAjuConsecutivo() {
        return ajuConsecutivo;
    }

    public void setAjuConsecutivo(Integer ajuConsecutivo) {
        this.ajuConsecutivo = ajuConsecutivo;
    }
}
