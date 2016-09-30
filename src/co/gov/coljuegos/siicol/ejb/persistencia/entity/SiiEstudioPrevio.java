package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_ESTUDIO_PREVIO")
public class SiiEstudioPrevio implements Serializable {
    private static final long serialVersionUID = -2614824671141533135L;
    private String epeAnalisiEcon;
    private Long epeCodigo;
    private String epeDescrJustif;
    private Date epeFecha;
    private String epeFormasAnaliz;
    private String epeFormaPago;
    private String epeObligacContrat;
    private Long epePresupEstim;
    private String epeRiesgo;
    private Integer epeTiempoDurac;
    private String epeUnidadDurac;
    private Long epeValorContrat;
    private Integer epeVigencia;
    private List<SiiAmparoEstPrev> siiAmparoEstPrevList;
    private SiiEstadoEstPrev siiEstadoEstPrev;
    private List<SiiReqEstudioPrevio> siiReqEstudioPrevioList;
    private SiiUsuario siiUsuario;
    private List<SiiEstPrevDetRubro> siiEstPrevDetRubroList1;
    private SiiTipoGarantia siiTipoGarantia;
    private SiiUbicacion siiUbicacion1;
    private SiiProcesoContratacion siiProcesoContratacion;
    private SiiItemPlanContratac siiItemPlanContratac;

    public SiiEstudioPrevio() {
    }

    public SiiEstudioPrevio(SiiEstadoEstPrev siiEstadoEstPrev, String epeAnalisiEcon, Long epeCodigo,
                            String epeDescrJustif, Date epeFecha, String epeFormaPago, String epeFormasAnaliz,
                            String epeObligacContrat, Long epePresupEstim, Integer epeTiempoDurac,
                            String epeUnidadDurac, Long epeValorContrat, Integer epeVigencia, String epeRiesgo,
                            SiiProcesoContratacion siiProcesoContratacion, SiiTipoGarantia siiTipoGarantia,
                            SiiUbicacion siiUbicacion1, SiiUsuario siiUsuario,
							SiiItemPlanContratac siiItemPlanContratac) {
        this.siiEstadoEstPrev = siiEstadoEstPrev;
        this.epeAnalisiEcon = epeAnalisiEcon;
        this.epeCodigo = epeCodigo;
        this.epeDescrJustif = epeDescrJustif;
        this.epeFecha = epeFecha;
        this.epeFormaPago = epeFormaPago;
        this.epeFormasAnaliz = epeFormasAnaliz;
        this.epeObligacContrat = epeObligacContrat;
        this.epePresupEstim = epePresupEstim;
        this.epeRiesgo = epeRiesgo;
        this.epeTiempoDurac = epeTiempoDurac;
        this.epeUnidadDurac = epeUnidadDurac;
        this.epeValorContrat = epeValorContrat;
        this.epeVigencia = epeVigencia;
        this.siiProcesoContratacion = siiProcesoContratacion;
        this.siiTipoGarantia = siiTipoGarantia;
        this.siiUbicacion1 = siiUbicacion1;
        this.siiUsuario = siiUsuario;
        this.siiItemPlanContratac = siiItemPlanContratac;
    }


    @Column(name = "EPE_ANALISI_ECO_C")
    public String getEpeAnalisiEcon() {
        return epeAnalisiEcon;
    }

    public void setEpeAnalisiEcon(String epeAnalisiEcon) {
        this.epeAnalisiEcon = epeAnalisiEcon;
    }

    @Id
    @Column(name = "EPE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTUDIO_PREVIO_COD")
    @SequenceGenerator(name = "SEQ_ESTUDIO_PREVIO_COD", sequenceName = "SEQ_ESTUDIO_PREVIO_COD",allocationSize=1)
    public Long getEpeCodigo() {
        return epeCodigo;
    }

    public void setEpeCodigo(Long epeCodigo) {
        this.epeCodigo = epeCodigo;
    }

    @Column(name = "EPE_DESCR_JUST_C", nullable = false)
    public String getEpeDescrJustif() {
        return epeDescrJustif;
    }

    public void setEpeDescrJustif(String epeDescrJustif) {
        this.epeDescrJustif = epeDescrJustif;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EPE_FECHA", nullable = false)
    public Date getEpeFecha() {
        return epeFecha;
    }

    public void setEpeFecha(Date epeFecha) {
        this.epeFecha = epeFecha;
    }

    @Column(name = "EPE_FORMAS_ANALI_C", nullable = false)
    public String getEpeFormasAnaliz() {
        return epeFormasAnaliz;
    }

    public void setEpeFormasAnaliz(String epeFormasAnaliz) {
        this.epeFormasAnaliz = epeFormasAnaliz;
    }

    @Column(name = "EPE_FORMA_PAG_C", nullable = false)
    public String getEpeFormaPago() {
        return epeFormaPago;
    }

    public void setEpeFormaPago(String epeFormaPago) {
        this.epeFormaPago = epeFormaPago;
    }

    @Column(name = "EPE_OBLIGAC_CONTRA_C", nullable = false)
    public String getEpeObligacContrat() {
        return epeObligacContrat;
    }

    public void setEpeObligacContrat(String epeObligacContrat) {
        this.epeObligacContrat = epeObligacContrat;
    }

    @Column(name = "EPE_PRESUP_ESTIM", nullable = false)
    public Long getEpePresupEstim() {
        return epePresupEstim;
    }

    public void setEpePresupEstim(Long epePresupEstim) {
        this.epePresupEstim = epePresupEstim;
    }

    @Column(name = "EPE_RIESGO")
    public String getEpeRiesgo() {
        return epeRiesgo;
    }

    public void setEpeRiesgo(String epeRiesgo) {
        this.epeRiesgo = epeRiesgo;
    }

    @Column(name = "EPE_TIEMPO_DURAC", nullable = false)
    public Integer getEpeTiempoDurac() {
        return epeTiempoDurac;
    }

    public void setEpeTiempoDurac(Integer epeTiempoDurac) {
        this.epeTiempoDurac = epeTiempoDurac;
    }

    @Column(name = "EPE_UNIDAD_DURAC", nullable = false, length = 1)
    public String getEpeUnidadDurac() {
        return epeUnidadDurac;
    }

    public void setEpeUnidadDurac(String epeUnidadDurac) {
        this.epeUnidadDurac = epeUnidadDurac;
    }

    @Column(name = "EPE_VALOR_CONTRAT", nullable = false)
    public Long getEpeValorContrat() {
        return epeValorContrat;
    }

    public void setEpeValorContrat(Long epeValorContrat) {
        this.epeValorContrat = epeValorContrat;
    }

    @Column(name = "EPE_VIGENCIA")
    public Integer getEpeVigencia() {
        return epeVigencia;
    }

    public void setEpeVigencia(Integer epeVigencia) {
        this.epeVigencia = epeVigencia;
    }


    @OneToMany(mappedBy = "siiEstudioPrevio")
    public List<SiiAmparoEstPrev> getSiiAmparoEstPrevList() {
        return siiAmparoEstPrevList;
    }

    public void setSiiAmparoEstPrevList(List<SiiAmparoEstPrev> siiAmparoEstPrevList) {
        this.siiAmparoEstPrevList = siiAmparoEstPrevList;
    }

    public SiiAmparoEstPrev addSiiAmparoEstPrev(SiiAmparoEstPrev siiAmparoEstPrev) {
        getSiiAmparoEstPrevList().add(siiAmparoEstPrev);
        siiAmparoEstPrev.setSiiEstudioPrevio(this);
        return siiAmparoEstPrev;
    }

    public SiiAmparoEstPrev removeSiiAmparoEstPrev(SiiAmparoEstPrev siiAmparoEstPrev) {
        getSiiAmparoEstPrevList().remove(siiAmparoEstPrev);
        siiAmparoEstPrev.setSiiEstudioPrevio(null);
        return siiAmparoEstPrev;
    }

    @ManyToOne
    @JoinColumn(name = "EEP_CODIGO")
    public SiiEstadoEstPrev getSiiEstadoEstPrev() {
        return siiEstadoEstPrev;
    }

    public void setSiiEstadoEstPrev(SiiEstadoEstPrev siiEstadoEstPrev) {
        this.siiEstadoEstPrev = siiEstadoEstPrev;
    }

    @OneToMany(mappedBy = "siiEstudioPrevio1")
    public List<SiiReqEstudioPrevio> getSiiReqEstudioPrevioList() {
        return siiReqEstudioPrevioList;
    }

    public void setSiiReqEstudioPrevioList(List<SiiReqEstudioPrevio> siiReqEstudioPrevioList) {
        this.siiReqEstudioPrevioList = siiReqEstudioPrevioList;
    }

    public SiiReqEstudioPrevio addSiiReqEstudioPrevio(SiiReqEstudioPrevio siiReqEstudioPrevio) {
        getSiiReqEstudioPrevioList().add(siiReqEstudioPrevio);
        siiReqEstudioPrevio.setSiiEstudioPrevio1(this);
        return siiReqEstudioPrevio;
    }

    public SiiReqEstudioPrevio removeSiiReqEstudioPrevio(SiiReqEstudioPrevio siiReqEstudioPrevio) {
        getSiiReqEstudioPrevioList().remove(siiReqEstudioPrevio);
        siiReqEstudioPrevio.setSiiEstudioPrevio1(null);
        return siiReqEstudioPrevio;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CREA")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @OneToMany(mappedBy = "siiEstudioPrevio2")
    public List<SiiEstPrevDetRubro> getSiiEstPrevDetRubroList1() {
        return siiEstPrevDetRubroList1;
    }

    public void setSiiEstPrevDetRubroList1(List<SiiEstPrevDetRubro> siiEstPrevDetRubroList1) {
        this.siiEstPrevDetRubroList1 = siiEstPrevDetRubroList1;
    }

    public SiiEstPrevDetRubro addSiiEstPrevDetRubro(SiiEstPrevDetRubro siiEstPrevDetRubro) {
        getSiiEstPrevDetRubroList1().add(siiEstPrevDetRubro);
        siiEstPrevDetRubro.setSiiEstudioPrevio2(this);
        return siiEstPrevDetRubro;
    }

    public SiiEstPrevDetRubro removeSiiEstPrevDetRubro(SiiEstPrevDetRubro siiEstPrevDetRubro) {
        getSiiEstPrevDetRubroList1().remove(siiEstPrevDetRubro);
        siiEstPrevDetRubro.setSiiEstudioPrevio2(null);
        return siiEstPrevDetRubro;
    }

    @ManyToOne
    @JoinColumn(name = "TGA_CODIGO")
    public SiiTipoGarantia getSiiTipoGarantia() {
        return siiTipoGarantia;
    }

    public void setSiiTipoGarantia(SiiTipoGarantia siiTipoGarantia) {
        this.siiTipoGarantia = siiTipoGarantia;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_EJEC")
    public SiiUbicacion getSiiUbicacion1() {
        return siiUbicacion1;
    }

    public void setSiiUbicacion1(SiiUbicacion siiUbicacion1) {
        this.siiUbicacion1 = siiUbicacion1;
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
    @JoinColumn(name = "IPC_CODIGO")
    public SiiItemPlanContratac getSiiItemPlanContratac() {
        return siiItemPlanContratac;
    }

    public void setSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        this.siiItemPlanContratac = siiItemPlanContratac;
    }
}
