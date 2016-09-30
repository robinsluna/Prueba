package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_PROCESO_CONTRATACION")
public class SiiProcesoContratacion implements Serializable {
    private static final long serialVersionUID = 5811837850455567845L;
    private Long prcCodigo;
    private String prcObjeto;
    private SiiEstadoProcContrat siiEstadoProcContrat;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList;
    private List<SiiEstudioMercado> siiEstudioMercadoList;
	private List<SiiEstudioPrevio> siiEstudioPrevioList4;
	private List<SiiInvitacionProceso> siiInvitacionProcesoList;
    private List<SiiCdp> siiCdpList1;
    private List<SiiTerminosReferencia> siiTerminosReferenciaList;
    private List<SiiAlcanceInvitacion> siiAlcanceInvitacionList1;
    private List<SiiRecepcionPropuestas> siiRecepcionPropuestasList;
    private List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinList1;
    private List<SiiOficioAdjudica> siiOficioAdjudicaList;
    private SiiExpedienteFisico siiExpedienteFisico;
    private List<SiiOficioDesigSuperv> siiOficioDesigSupervList;
    private List<SiiActaIniContrato> siiActaIniContratoList;
    private List<SiiPolizaContProv> siiPolizaContProvList;

    public SiiProcesoContratacion() {
    }

    public SiiProcesoContratacion(SiiEstadoProcContrat siiEstadoProcContrat, Long prcCodigo, String prcObjeto,
								SiiExpedienteFisico siiExpedienteFisico) {
        this.siiEstadoProcContrat = siiEstadoProcContrat;
        this.prcCodigo = prcCodigo;
        this.prcObjeto = prcObjeto;
        this.siiExpedienteFisico = siiExpedienteFisico;
    }


    @Id
    @Column(name = "PRC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROC_CONTRAT_CODIGO")
    @SequenceGenerator(name = "SEQ_PROC_CONTRAT_CODIGO", sequenceName = "SEQ_PROC_CONTRAT_CODIGO",allocationSize=1)
    public Long getPrcCodigo() {
        return prcCodigo;
    }

    public void setPrcCodigo(Long prcCodigo) {
        this.prcCodigo = prcCodigo;
    }

    @Column(name = "PRC_OBJETO_C", nullable = false)
    public String getPrcObjeto() {
        return prcObjeto;
    }

    public void setPrcObjeto(String prcObjeto) {
        this.prcObjeto = prcObjeto;
    }

    @ManyToOne
    @JoinColumn(name = "EPC_CODIGO")
    public SiiEstadoProcContrat getSiiEstadoProcContrat() {
        return siiEstadoProcContrat;
    }

    public void setSiiEstadoProcContrat(SiiEstadoProcContrat siiEstadoProcContrat) {
        this.siiEstadoProcContrat = siiEstadoProcContrat;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList() {
        return siiSolicitudEstMercadoList;
    }

    public void setSiiSolicitudEstMercadoList(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList) {
        this.siiSolicitudEstMercadoList = siiSolicitudEstMercadoList;
    }

    public SiiSolicitudEstMercado addSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList().add(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiProcesoContratacion(this);
        return siiSolicitudEstMercado;
    }

    public SiiSolicitudEstMercado removeSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList().remove(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiProcesoContratacion(null);
        return siiSolicitudEstMercado;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion1")
    public List<SiiEstudioMercado> getSiiEstudioMercadoList() {
        return siiEstudioMercadoList;
    }

    public void setSiiEstudioMercadoList(List<SiiEstudioMercado> siiEstudioMercadoList) {
        this.siiEstudioMercadoList = siiEstudioMercadoList;
    }

    public SiiEstudioMercado addSiiEstudioMercado(SiiEstudioMercado siiEstudioMercado) {
        getSiiEstudioMercadoList().add(siiEstudioMercado);
        siiEstudioMercado.setSiiProcesoContratacion1(this);
        return siiEstudioMercado;
    }

    public SiiEstudioMercado removeSiiEstudioMercado(SiiEstudioMercado siiEstudioMercado) {
        getSiiEstudioMercadoList().remove(siiEstudioMercado);
        siiEstudioMercado.setSiiProcesoContratacion1(null);
        return siiEstudioMercado;
    }

	@OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiEstudioPrevio> getSiiEstudioPrevioList4() {
        return siiEstudioPrevioList4;
    }

    public void setSiiEstudioPrevioList4(List<SiiEstudioPrevio> siiEstudioPrevioList4) {
        this.siiEstudioPrevioList4 = siiEstudioPrevioList4;
    }

    public SiiEstudioPrevio addSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList4().add(siiEstudioPrevio);
        siiEstudioPrevio.setSiiProcesoContratacion(this);
        return siiEstudioPrevio;
    }

    public SiiEstudioPrevio removeSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList4().remove(siiEstudioPrevio);
        siiEstudioPrevio.setSiiProcesoContratacion(null);
        return siiEstudioPrevio;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiInvitacionProceso> getSiiInvitacionProcesoList() {
        return siiInvitacionProcesoList;
    }

    public void setSiiInvitacionProcesoList(List<SiiInvitacionProceso> siiInvitacionProcesoList) {
        this.siiInvitacionProcesoList = siiInvitacionProcesoList;
    }

    public SiiInvitacionProceso addSiiInvitacionProceso(SiiInvitacionProceso siiInvitacionProceso) {
        getSiiInvitacionProcesoList().add(siiInvitacionProceso);
        siiInvitacionProceso.setSiiProcesoContratacion(this);
        return siiInvitacionProceso;
    }

    public SiiInvitacionProceso removeSiiInvitacionProceso(SiiInvitacionProceso siiInvitacionProceso) {
        getSiiInvitacionProcesoList().remove(siiInvitacionProceso);
        siiInvitacionProceso.setSiiProcesoContratacion(null);
        return siiInvitacionProceso;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiCdp> getSiiCdpList1() {
        return siiCdpList1;
    }

    public void setSiiCdpList1(List<SiiCdp> siiCdpList1) {
        this.siiCdpList1 = siiCdpList1;
    }

    public SiiCdp addSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList1().add(siiCdp);
        siiCdp.setSiiProcesoContratacion(this);
        return siiCdp;
    }

    public SiiCdp removeSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList1().remove(siiCdp);
        siiCdp.setSiiProcesoContratacion(null);
        return siiCdp;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiTerminosReferencia> getSiiTerminosReferenciaList() {
        return siiTerminosReferenciaList;
    }

    public void setSiiTerminosReferenciaList(List<SiiTerminosReferencia> siiTerminosReferenciaList) {
        this.siiTerminosReferenciaList = siiTerminosReferenciaList;
    }

    public SiiTerminosReferencia addSiiTerminosReferencia(SiiTerminosReferencia siiTerminosReferencia) {
        getSiiTerminosReferenciaList().add(siiTerminosReferencia);
        siiTerminosReferencia.setSiiProcesoContratacion(this);
        return siiTerminosReferencia;
    }

    public SiiTerminosReferencia removeSiiTerminosReferencia(SiiTerminosReferencia siiTerminosReferencia) {
        getSiiTerminosReferenciaList().remove(siiTerminosReferencia);
        siiTerminosReferencia.setSiiProcesoContratacion(null);
        return siiTerminosReferencia;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiAlcanceInvitacion> getSiiAlcanceInvitacionList1() {
        return siiAlcanceInvitacionList1;
    }

    public void setSiiAlcanceInvitacionList1(List<SiiAlcanceInvitacion> siiAlcanceInvitacionList1) {
        this.siiAlcanceInvitacionList1 = siiAlcanceInvitacionList1;
    }

    public SiiAlcanceInvitacion addSiiAlcanceInvitacion(SiiAlcanceInvitacion siiAlcanceInvitacion) {
        getSiiAlcanceInvitacionList1().add(siiAlcanceInvitacion);
        siiAlcanceInvitacion.setSiiProcesoContratacion(this);
        return siiAlcanceInvitacion;
    }

    public SiiAlcanceInvitacion removeSiiAlcanceInvitacion(SiiAlcanceInvitacion siiAlcanceInvitacion) {
        getSiiAlcanceInvitacionList1().remove(siiAlcanceInvitacion);
        siiAlcanceInvitacion.setSiiProcesoContratacion(null);
        return siiAlcanceInvitacion;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiRecepcionPropuestas> getSiiRecepcionPropuestasList() {
        return siiRecepcionPropuestasList;
    }

    public void setSiiRecepcionPropuestasList(List<SiiRecepcionPropuestas> siiRecepcionPropuestasList) {
        this.siiRecepcionPropuestasList = siiRecepcionPropuestasList;
    }

    public SiiRecepcionPropuestas addSiiRecepcionPropuestas(SiiRecepcionPropuestas siiRecepcionPropuestas) {
        getSiiRecepcionPropuestasList().add(siiRecepcionPropuestas);
        siiRecepcionPropuestas.setSiiProcesoContratacion(this);
        return siiRecepcionPropuestas;
    }

    public SiiRecepcionPropuestas removeSiiRecepcionPropuestas(SiiRecepcionPropuestas siiRecepcionPropuestas) {
        getSiiRecepcionPropuestasList().remove(siiRecepcionPropuestas);
        siiRecepcionPropuestas.setSiiProcesoContratacion(null);
        return siiRecepcionPropuestas;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiEvaluacionJurTecFin> getSiiEvaluacionJurTecFinList1() {
        return siiEvaluacionJurTecFinList1;
    }

    public void setSiiEvaluacionJurTecFinList1(List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinList1) {
        this.siiEvaluacionJurTecFinList1 = siiEvaluacionJurTecFinList1;
    }

    public SiiEvaluacionJurTecFin addSiiEvaluacionJurTecFin(SiiEvaluacionJurTecFin siiEvaluacionJurTecFin) {
        getSiiEvaluacionJurTecFinList1().add(siiEvaluacionJurTecFin);
        siiEvaluacionJurTecFin.setSiiProcesoContratacion(this);
        return siiEvaluacionJurTecFin;
    }

    public SiiEvaluacionJurTecFin removeSiiEvaluacionJurTecFin(SiiEvaluacionJurTecFin siiEvaluacionJurTecFin) {
        getSiiEvaluacionJurTecFinList1().remove(siiEvaluacionJurTecFin);
        siiEvaluacionJurTecFin.setSiiProcesoContratacion(null);
        return siiEvaluacionJurTecFin;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiOficioAdjudica> getSiiOficioAdjudicaList() {
        return siiOficioAdjudicaList;
    }

    public void setSiiOficioAdjudicaList(List<SiiOficioAdjudica> siiOficioAdjudicaList) {
        this.siiOficioAdjudicaList = siiOficioAdjudicaList;
    }

    public SiiOficioAdjudica addSiiOficioAdjudica(SiiOficioAdjudica siiOficioAdjudica) {
        getSiiOficioAdjudicaList().add(siiOficioAdjudica);
        siiOficioAdjudica.setSiiProcesoContratacion(this);
        return siiOficioAdjudica;
    }

    public SiiOficioAdjudica removeSiiOficioAdjudica(SiiOficioAdjudica siiOficioAdjudica) {
        getSiiOficioAdjudicaList().remove(siiOficioAdjudica);
        siiOficioAdjudica.setSiiProcesoContratacion(null);
        return siiOficioAdjudica;
    }

    @ManyToOne
    @JoinColumn(name = "EFI_CODIGO")
    public SiiExpedienteFisico getSiiExpedienteFisico() {
        return siiExpedienteFisico;
    }

    public void setSiiExpedienteFisico(SiiExpedienteFisico siiExpedienteFisico) {
        this.siiExpedienteFisico = siiExpedienteFisico;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiOficioDesigSuperv> getSiiOficioDesigSupervList() {
        return siiOficioDesigSupervList;
    }

    public void setSiiOficioDesigSupervList(List<SiiOficioDesigSuperv> siiOficioDesigSupervList) {
        this.siiOficioDesigSupervList = siiOficioDesigSupervList;
    }

    public SiiOficioDesigSuperv addSiiOficioDesigSuperv(SiiOficioDesigSuperv siiOficioDesigSuperv) {
        getSiiOficioDesigSupervList().add(siiOficioDesigSuperv);
        siiOficioDesigSuperv.setSiiProcesoContratacion(this);
        return siiOficioDesigSuperv;
    }

    public SiiOficioDesigSuperv removeSiiOficioDesigSuperv(SiiOficioDesigSuperv siiOficioDesigSuperv) {
        getSiiOficioDesigSupervList().remove(siiOficioDesigSuperv);
        siiOficioDesigSuperv.setSiiProcesoContratacion(null);
        return siiOficioDesigSuperv;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiActaIniContrato> getSiiActaIniContratoList() {
        return siiActaIniContratoList;
    }

    public void setSiiActaIniContratoList(List<SiiActaIniContrato> siiActaIniContratoList) {
        this.siiActaIniContratoList = siiActaIniContratoList;
    }

    public SiiActaIniContrato addSiiActaIniContrato(SiiActaIniContrato siiActaIniContrato) {
        getSiiActaIniContratoList().add(siiActaIniContrato);
        siiActaIniContrato.setSiiProcesoContratacion(this);
        return siiActaIniContrato;
    }

    public SiiActaIniContrato removeSiiActaIniContrato(SiiActaIniContrato siiActaIniContrato) {
        getSiiActaIniContratoList().remove(siiActaIniContrato);
        siiActaIniContrato.setSiiProcesoContratacion(null);
        return siiActaIniContrato;
    }

    @OneToMany(mappedBy = "siiProcesoContratacion")
    public List<SiiPolizaContProv> getSiiPolizaContProvList() {
        return siiPolizaContProvList;
    }

    public void setSiiPolizaContProvList(List<SiiPolizaContProv> siiPolizaContProvList) {
        this.siiPolizaContProvList = siiPolizaContProvList;
    }

    public SiiPolizaContProv addSiiPolizaContProv(SiiPolizaContProv siiPolizaContProv) {
        getSiiPolizaContProvList().add(siiPolizaContProv);
        siiPolizaContProv.setSiiProcesoContratacion(this);
        return siiPolizaContProv;
    }

    public SiiPolizaContProv removeSiiPolizaContProv(SiiPolizaContProv siiPolizaContProv) {
        getSiiPolizaContProvList().remove(siiPolizaContProv);
        siiPolizaContProv.setSiiProcesoContratacion(null);
        return siiPolizaContProv;
    }
}
