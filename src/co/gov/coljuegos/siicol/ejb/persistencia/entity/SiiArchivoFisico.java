package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_ARCHIVO_FISICO")
public class SiiArchivoFisico implements Serializable {
    private static final long serialVersionUID = -1176750989255610442L;
    private Long afiCodigo;
    private Date afiFecha;
    private String afiNombreFs;
    private String afiNombreOrignal;
    private String afiPathRelativo;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList2;
    private List<SiiConsultaWebContrat> siiConsultaWebContratList;
    private List<SiiAlcanceInvitacion> siiAlcanceInvitacionList;
    private List<SiiApropiacionInicial> siiApropiacionInicialList;
    private List<SiiRecepcionPropuestas> siiRecepcionPropuestasList;
    private String afiActivo;
    private List<SiiExpedArchFisico> siiExpedArchFisicoList1;
    private List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinJurList;
    private List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinTecList;
    private List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinFinList;
    private List<SiiOficInfPoliza> siiOficInfPolizaList;
    private List<SiiPolizaContrat> siiPolizaContratList2;
    private List<SiiAdendaTdr> siiAdendaTdrList;
    private List<SiiRecaudoBanco> siiRecaudoBancoList;
    private List<SiiContratoProveedor> siiContratoProveedorList;
    private List<SiiDocumentoConpes> siiDocumentoConpesList;
    private List<SiiPolizaContProv> siiPolizaContProvList;
    private List<SiiOficioDesigSuperv> siiOficioDesigSupervList;
    private List<SiiActaIniContrato> siiActaIniContratoList;
    private List<SiiModificacionCdp> siiModificacionCdpList;
    private List<SiiResolucionAutoriz> siiResolucionAutorizList;
    private List<SiiCargaNomina> siiCargaNominaList;
    private List<SiiCargaRp> siiCargaRpList;
    private List<SiiContrato> siiContratoList;
    private List<SiiResolucionLiquid> siiResolucionLiquidList;
    private List<SiiOtrosi> siiOtrosiList;
    private List<SiiLiquidacionContrato> siiLiquidacionContratoInfFinalList;
    private List<SiiLiquidacionContrato> siiLiquidacionContratoOficioCitaList;
    private List<SiiCargaDocumentoCont> siiCargaDocumentoContList;
    private List<SiiInformeSupervision> siiInformeSupervisionList;
    private List<SiiIncumplimientoContr> siiIncumplimientoContrAsegList;
    private List<SiiIncumplimientoContr> siiIncumplimientoContrOperList;
    private List<SiiIncumplimientoContr> siiIncumplimientoContrAutoList;
    private List<SiiResolucionIncumContr> siiResolucionIncumContrList;
    private List<SiiResolucionProcSanc> siiResolucionProcSancList;
    private List<SiiProcesoSancionatorio> siiProcesoSancionatorioAutoList;
    private List<SiiCargaPoblacion> siiCargaPoblacionList;

    public SiiArchivoFisico() {
    }

    public SiiArchivoFisico(Long afiCodigo, String afiNombreFs, String afiNombreOrignal, String afiPathRelativo,
							String afiActivo) {
        this.afiCodigo = afiCodigo;
        this.afiNombreFs = afiNombreFs;
        this.afiNombreOrignal = afiNombreOrignal;
        this.afiPathRelativo = afiPathRelativo;
        this.afiActivo = afiActivo;
    }

    @Id
    @Column(name = "AFI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ARCHIVO_FISICO_COD")
    @SequenceGenerator(name = "SEQ_ARCHIVO_FISICO_COD", sequenceName = "SEQ_ARCHIVO_FISICO_COD",allocationSize=1)
    public Long getAfiCodigo() {
        return afiCodigo;
    }

    public void setAfiCodigo(Long afiCodigo) {
        this.afiCodigo = afiCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AFI_FECHA")
    public Date getAfiFecha() {
        return afiFecha;
    }

    public void setAfiFecha(Date afiFecha) {
        this.afiFecha = afiFecha;
    }

    @Column(name = "AFI_NOMBRE_FS", nullable = false)
    public String getAfiNombreFs() {
        return afiNombreFs;
    }

    public void setAfiNombreFs(String afiNombreFs) {
        this.afiNombreFs = afiNombreFs;
    }

    @Column(name = "AFI_NOMBRE_ORIGNAL", nullable = false)
    public String getAfiNombreOrignal() {
        return afiNombreOrignal;
    }

    public void setAfiNombreOrignal(String afiNombreOrignal) {
        this.afiNombreOrignal = afiNombreOrignal;
    }

    @Column(name = "AFI_PATH_RELATIVO", nullable = false)
    public String getAfiPathRelativo() {
        return afiPathRelativo;
    }

    public void setAfiPathRelativo(String afiPathRelativo) {
        this.afiPathRelativo = afiPathRelativo;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList2() {
        return siiSolicitudEstMercadoList2;
    }

    public void setSiiSolicitudEstMercadoList2(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList2) {
        this.siiSolicitudEstMercadoList2 = siiSolicitudEstMercadoList2;
    }

    public SiiSolicitudEstMercado addSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList2().add(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiArchivoFisico(this);
        return siiSolicitudEstMercado;
    }

    public SiiSolicitudEstMercado removeSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList2().remove(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiArchivoFisico(null);
        return siiSolicitudEstMercado;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiConsultaWebContrat> getSiiConsultaWebContratList() {
        return siiConsultaWebContratList;
    }

    public void setSiiConsultaWebContratList(List<SiiConsultaWebContrat> siiConsultaWebContratList) {
        this.siiConsultaWebContratList = siiConsultaWebContratList;
    }

    public SiiConsultaWebContrat addSiiConsultaWebContrat(SiiConsultaWebContrat siiConsultaWebContrat) {
        getSiiConsultaWebContratList().add(siiConsultaWebContrat);
        siiConsultaWebContrat.setSiiArchivoFisico(this);
        return siiConsultaWebContrat;
    }

    public SiiConsultaWebContrat removeSiiConsultaWebContrat(SiiConsultaWebContrat siiConsultaWebContrat) {
        getSiiConsultaWebContratList().remove(siiConsultaWebContrat);
        siiConsultaWebContrat.setSiiArchivoFisico(null);
        return siiConsultaWebContrat;
    }

    @OneToMany(mappedBy = "siiArchivoFisico1")
    public List<SiiAlcanceInvitacion> getSiiAlcanceInvitacionList() {
        return siiAlcanceInvitacionList;
    }

    public void setSiiAlcanceInvitacionList(List<SiiAlcanceInvitacion> siiAlcanceInvitacionList) {
        this.siiAlcanceInvitacionList = siiAlcanceInvitacionList;
    }

    public SiiAlcanceInvitacion addSiiAlcanceInvitacion(SiiAlcanceInvitacion siiAlcanceInvitacion) {
        getSiiAlcanceInvitacionList().add(siiAlcanceInvitacion);
        siiAlcanceInvitacion.setSiiArchivoFisico1(this);
        return siiAlcanceInvitacion;
    }

    public SiiAlcanceInvitacion removeSiiAlcanceInvitacion(SiiAlcanceInvitacion siiAlcanceInvitacion) {
        getSiiAlcanceInvitacionList().remove(siiAlcanceInvitacion);
        siiAlcanceInvitacion.setSiiArchivoFisico1(null);
        return siiAlcanceInvitacion;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiApropiacionInicial> getSiiApropiacionInicialList() {
        return siiApropiacionInicialList;
    }

    public void setSiiApropiacionInicialList(List<SiiApropiacionInicial> siiApropiacionInicialList) {
        this.siiApropiacionInicialList = siiApropiacionInicialList;
    }

    public SiiApropiacionInicial addSiiApropiacionInicial(SiiApropiacionInicial siiApropiacionInicial) {
        getSiiApropiacionInicialList().add(siiApropiacionInicial);
        siiApropiacionInicial.setSiiArchivoFisico(this);
        return siiApropiacionInicial;
    }

    public SiiApropiacionInicial removeSiiApropiacionInicial(SiiApropiacionInicial siiApropiacionInicial) {
        getSiiApropiacionInicialList().remove(siiApropiacionInicial);
        siiApropiacionInicial.setSiiArchivoFisico(null);
        return siiApropiacionInicial;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiRecepcionPropuestas> getSiiRecepcionPropuestasList() {
        return siiRecepcionPropuestasList;
    }

    public void setSiiRecepcionPropuestasList(List<SiiRecepcionPropuestas> siiRecepcionPropuestasList) {
        this.siiRecepcionPropuestasList = siiRecepcionPropuestasList;
    }

    public SiiRecepcionPropuestas addSiiRecepcionPropuestas(SiiRecepcionPropuestas siiRecepcionPropuestas) {
        getSiiRecepcionPropuestasList().add(siiRecepcionPropuestas);
        siiRecepcionPropuestas.setSiiArchivoFisico(this);
        return siiRecepcionPropuestas;
    }

    public SiiRecepcionPropuestas removeSiiRecepcionPropuestas(SiiRecepcionPropuestas siiRecepcionPropuestas) {
        getSiiRecepcionPropuestasList().remove(siiRecepcionPropuestas);
        siiRecepcionPropuestas.setSiiArchivoFisico(null);
        return siiRecepcionPropuestas;
    }

    @Column(name = "AFI_ACTIVO", length = 1)
    public String getAfiActivo() {
        return afiActivo;
    }

    public void setAfiActivo(String afiActivo) {
        this.afiActivo = afiActivo;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiExpedArchFisico> getSiiExpedArchFisicoList1() {
        return siiExpedArchFisicoList1;
    }

    public void setSiiExpedArchFisicoList1(List<SiiExpedArchFisico> siiExpedArchFisicoList1) {
        this.siiExpedArchFisicoList1 = siiExpedArchFisicoList1;
    }

    public SiiExpedArchFisico addSiiExpedArchFisico(SiiExpedArchFisico siiExpedArchFisico) {
        getSiiExpedArchFisicoList1().add(siiExpedArchFisico);
        siiExpedArchFisico.setSiiArchivoFisico(this);
        return siiExpedArchFisico;
    }

    public SiiExpedArchFisico removeSiiExpedArchFisico(SiiExpedArchFisico siiExpedArchFisico) {
        getSiiExpedArchFisicoList1().remove(siiExpedArchFisico);
        siiExpedArchFisico.setSiiArchivoFisico(null);
        return siiExpedArchFisico;
    }

    @OneToMany(mappedBy = "siiArchivoFisicoJur")
    public List<SiiEvaluacionJurTecFin> getSiiEvaluacionJurTecFinJurList() {
        return siiEvaluacionJurTecFinJurList;
    }

    public void setSiiEvaluacionJurTecFinJurList(List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinJurList) {
        this.siiEvaluacionJurTecFinJurList = siiEvaluacionJurTecFinJurList;
    }

    public SiiEvaluacionJurTecFin addSiiEvaluacionJurTecFinJur(SiiEvaluacionJurTecFin siiEvaluacionJurTecFinJur) {
        getSiiEvaluacionJurTecFinJurList().add(siiEvaluacionJurTecFinJur);
        siiEvaluacionJurTecFinJur.setSiiArchivoFisicoJur(this);
        return siiEvaluacionJurTecFinJur;
    }

    public SiiEvaluacionJurTecFin removeSiiEvaluacionJurTecFinJur(SiiEvaluacionJurTecFin siiEvaluacionJurTecFinJur) {
        getSiiEvaluacionJurTecFinJurList().remove(siiEvaluacionJurTecFinJur);
        siiEvaluacionJurTecFinJur.setSiiArchivoFisicoJur(null);
        return siiEvaluacionJurTecFinJur;
    }

    @OneToMany(mappedBy = "siiArchivoFisicoTec")
    public List<SiiEvaluacionJurTecFin> getSiiEvaluacionJurTecFinTecList() {
        return siiEvaluacionJurTecFinTecList;
    }

    public void setSiiEvaluacionJurTecFinTecList(List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinTecList) {
        this.siiEvaluacionJurTecFinTecList = siiEvaluacionJurTecFinTecList;
    }

    @OneToMany(mappedBy = "siiArchivoFisicoFin")
    public List<SiiEvaluacionJurTecFin> getSiiEvaluacionJurTecFinFinList() {
        return siiEvaluacionJurTecFinFinList;
    }

    public void setSiiEvaluacionJurTecFinFinList(List<SiiEvaluacionJurTecFin> siiEvaluacionJurTecFinFinList) {
        this.siiEvaluacionJurTecFinFinList = siiEvaluacionJurTecFinFinList;
    }
    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiOficInfPoliza> getSiiOficInfPolizaList() {
        return siiOficInfPolizaList;
    }

    public void setSiiOficInfPolizaList(List<SiiOficInfPoliza> siiOficInfPolizaList) {
        this.siiOficInfPolizaList = siiOficInfPolizaList;
    }

    public SiiOficInfPoliza addSiiOficInfPoliza(SiiOficInfPoliza siiOficInfPoliza) {
        getSiiOficInfPolizaList().add(siiOficInfPoliza);
        siiOficInfPoliza.setSiiArchivoFisico(this);
        return siiOficInfPoliza;
    }

    public SiiOficInfPoliza removeSiiOficInfPoliza(SiiOficInfPoliza siiOficInfPoliza) {
        getSiiOficInfPolizaList().remove(siiOficInfPoliza);
        siiOficInfPoliza.setSiiArchivoFisico(null);
        return siiOficInfPoliza;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiPolizaContrat> getSiiPolizaContratList2() {
        return siiPolizaContratList2;
    }

    public void setSiiPolizaContratList2(List<SiiPolizaContrat> siiPolizaContratList2) {
        this.siiPolizaContratList2 = siiPolizaContratList2;
    }

    public SiiPolizaContrat addSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList2().add(siiPolizaContrat);
        siiPolizaContrat.setSiiArchivoFisico(this);
        return siiPolizaContrat;
    }

    public SiiPolizaContrat removeSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList2().remove(siiPolizaContrat);
        siiPolizaContrat.setSiiArchivoFisico(null);
        return siiPolizaContrat;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiAdendaTdr> getSiiAdendaTdrList() {
        return siiAdendaTdrList;
    }

    public void setSiiAdendaTdrList(List<SiiAdendaTdr> siiAdendaTdrList) {
        this.siiAdendaTdrList = siiAdendaTdrList;
    }

    public SiiAdendaTdr addSiiAdendaTdr(SiiAdendaTdr siiAdendaTdr) {
        getSiiAdendaTdrList().add(siiAdendaTdr);
        siiAdendaTdr.setSiiArchivoFisico(this);
        return siiAdendaTdr;
    }

    public SiiAdendaTdr removeSiiAdendaTdr(SiiAdendaTdr siiAdendaTdr) {
        getSiiAdendaTdrList().remove(siiAdendaTdr);
        siiAdendaTdr.setSiiArchivoFisico(null);
        return siiAdendaTdr;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiRecaudoBanco> getSiiRecaudoBancoList() {
        return siiRecaudoBancoList;
    }

    public void setSiiRecaudoBancoList(List<SiiRecaudoBanco> siiRecaudoBancoList) {
        this.siiRecaudoBancoList = siiRecaudoBancoList;
    }

    public SiiRecaudoBanco addSiiRecaudoBanco(SiiRecaudoBanco siiRecaudoBanco) {
        getSiiRecaudoBancoList().add(siiRecaudoBanco);
        siiRecaudoBanco.setSiiArchivoFisico(this);
        return siiRecaudoBanco;
    }

    public SiiRecaudoBanco removeSiiRecaudoBanco(SiiRecaudoBanco siiRecaudoBanco) {
        getSiiRecaudoBancoList().remove(siiRecaudoBanco);
        siiRecaudoBanco.setSiiArchivoFisico(null);
        return siiRecaudoBanco;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiContratoProveedor> getSiiContratoProveedorList() {
        return siiContratoProveedorList;
    }

    public void setSiiContratoProveedorList(List<SiiContratoProveedor> siiContratoProveedorList) {
        this.siiContratoProveedorList = siiContratoProveedorList;
    }

    public SiiContratoProveedor addSiiContratoProveedor(SiiContratoProveedor siiContratoProveedor) {
        getSiiContratoProveedorList().add(siiContratoProveedor);
        siiContratoProveedor.setSiiArchivoFisico(this);
        return siiContratoProveedor;
    }

    public SiiContratoProveedor removeSiiContratoProveedor(SiiContratoProveedor siiContratoProveedor) {
        getSiiContratoProveedorList().remove(siiContratoProveedor);
        siiContratoProveedor.setSiiArchivoFisico(null);
        return siiContratoProveedor;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiDocumentoConpes> getSiiDocumentoConpesList() {
        return siiDocumentoConpesList;
    }

    public void setSiiDocumentoConpesList(List<SiiDocumentoConpes> siiDocumentoConpesList) {
        this.siiDocumentoConpesList = siiDocumentoConpesList;
    }

    public SiiDocumentoConpes addSiiDocumentoConpes(SiiDocumentoConpes siiDocumentoConpes) {
        getSiiDocumentoConpesList().add(siiDocumentoConpes);
        siiDocumentoConpes.setSiiArchivoFisico(this);
        return siiDocumentoConpes;
    }

    public SiiDocumentoConpes removeSiiDocumentoConpes(SiiDocumentoConpes siiDocumentoConpes) {
        getSiiDocumentoConpesList().remove(siiDocumentoConpes);
        siiDocumentoConpes.setSiiArchivoFisico(null);
        return siiDocumentoConpes;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiPolizaContProv> getSiiPolizaContProvList() {
        return siiPolizaContProvList;
    }

    public void setSiiPolizaContProvList(List<SiiPolizaContProv> siiPolizaContProvList) {
        this.siiPolizaContProvList = siiPolizaContProvList;
    }

    public SiiPolizaContProv addSiiPolizaContProv(SiiPolizaContProv siiPolizaContProv) {
        getSiiPolizaContProvList().add(siiPolizaContProv);
        siiPolizaContProv.setSiiArchivoFisico(this);
        return siiPolizaContProv;
    }

    public SiiPolizaContProv removeSiiPolizaContProv(SiiPolizaContProv siiPolizaContProv) {
        getSiiPolizaContProvList().remove(siiPolizaContProv);
        siiPolizaContProv.setSiiArchivoFisico(null);
        return siiPolizaContProv;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiOficioDesigSuperv> getSiiOficioDesigSupervList() {
        return siiOficioDesigSupervList;
    }

    public void setSiiOficioDesigSupervList(List<SiiOficioDesigSuperv> siiOficioDesigSupervList) {
        this.siiOficioDesigSupervList = siiOficioDesigSupervList;
    }

    public SiiOficioDesigSuperv addSiiOficioDesigSuperv(SiiOficioDesigSuperv siiOficioDesigSuperv) {
        getSiiOficioDesigSupervList().add(siiOficioDesigSuperv);
        siiOficioDesigSuperv.setSiiArchivoFisico(this);
        return siiOficioDesigSuperv;
    }

    public SiiOficioDesigSuperv removeSiiOficioDesigSuperv(SiiOficioDesigSuperv siiOficioDesigSuperv) {
        getSiiOficioDesigSupervList().remove(siiOficioDesigSuperv);
        siiOficioDesigSuperv.setSiiArchivoFisico(null);
        return siiOficioDesigSuperv;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiActaIniContrato> getSiiActaIniContratoList() {
        return siiActaIniContratoList;
    }

    public void setSiiActaIniContratoList(List<SiiActaIniContrato> siiActaIniContratoList) {
        this.siiActaIniContratoList = siiActaIniContratoList;
    }

    public SiiActaIniContrato addSiiActaIniContrato(SiiActaIniContrato siiActaIniContrato) {
        getSiiActaIniContratoList().add(siiActaIniContrato);
        siiActaIniContrato.setSiiArchivoFisico(this);
        return siiActaIniContrato;
    }

    public SiiActaIniContrato removeSiiActaIniContrato(SiiActaIniContrato siiActaIniContrato) {
        getSiiActaIniContratoList().remove(siiActaIniContrato);
        siiActaIniContrato.setSiiArchivoFisico(null);
        return siiActaIniContrato;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiModificacionCdp> getSiiModificacionCdpList() {
        return siiModificacionCdpList;
    }

    public void setSiiModificacionCdpList(List<SiiModificacionCdp> siiModificacionCdpList) {
        this.siiModificacionCdpList = siiModificacionCdpList;
    }

    public SiiModificacionCdp addSiiModificacionCdp(SiiModificacionCdp siiModificacionCdp) {
        getSiiModificacionCdpList().add(siiModificacionCdp);
        siiModificacionCdp.setSiiArchivoFisico(this);
        return siiModificacionCdp;
    }

    public SiiModificacionCdp removeSiiModificacionCdp(SiiModificacionCdp siiModificacionCdp) {
        getSiiModificacionCdpList().remove(siiModificacionCdp);
        siiModificacionCdp.setSiiArchivoFisico(null);
        return siiModificacionCdp;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiResolucionAutoriz> getSiiResolucionAutorizList() {
        return siiResolucionAutorizList;
    }

    public void setSiiResolucionAutorizList(List<SiiResolucionAutoriz> siiResolucionAutorizList) {
        this.siiResolucionAutorizList = siiResolucionAutorizList;
    }

    public SiiResolucionAutoriz addSiiResolucionAutoriz(SiiResolucionAutoriz siiResolucionAutoriz) {
        getSiiResolucionAutorizList().add(siiResolucionAutoriz);
        siiResolucionAutoriz.setSiiArchivoFisico(this);
        return siiResolucionAutoriz;
    }

    public SiiResolucionAutoriz removeSiiResolucionAutoriz(SiiResolucionAutoriz siiResolucionAutoriz) {
        getSiiResolucionAutorizList().remove(siiResolucionAutoriz);
        siiResolucionAutoriz.setSiiArchivoFisico(null);
        return siiResolucionAutoriz;
    }


    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiCargaNomina> getSiiCargaNominaList() {
        return siiCargaNominaList;
    }

    public void setSiiCargaNominaList(List<SiiCargaNomina> siiCargaNominaList) {
        this.siiCargaNominaList = siiCargaNominaList;
    }

    public SiiCargaNomina addSiiCargaNomina(SiiCargaNomina siiCargaNomina) {
        getSiiCargaNominaList().add(siiCargaNomina);
        siiCargaNomina.setSiiArchivoFisico(this);
        return siiCargaNomina;
    }

    public SiiCargaNomina removeSiiCargaNomina(SiiCargaNomina siiCargaNomina) {
        getSiiCargaNominaList().remove(siiCargaNomina);
        siiCargaNomina.setSiiArchivoFisico(null);
        return siiCargaNomina;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiCargaRp> getSiiCargaRpList() {
        return siiCargaRpList;
    }

    public void setSiiCargaRpList(List<SiiCargaRp> siiCargaRpList) {
        this.siiCargaRpList = siiCargaRpList;
    }

    public SiiCargaRp addSiiCargaRp(SiiCargaRp siiCargaRp) {
        getSiiCargaRpList().add(siiCargaRp);
        siiCargaRp.setSiiArchivoFisico(this);
        return siiCargaRp;
    }

    public SiiCargaRp removeSiiCargaRp(SiiCargaRp siiCargaRp) {
        getSiiCargaRpList().remove(siiCargaRp);
        siiCargaRp.setSiiArchivoFisico(null);
        return siiCargaRp;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiContrato> getSiiContratoList() {
        return siiContratoList;
    }

    public void setSiiContratoList(List<SiiContrato> siiContratoList) {
        this.siiContratoList = siiContratoList;
    }

    public SiiContrato addSiiContrato(SiiContrato siiContrato) {
        getSiiContratoList().add(siiContrato);
        siiContrato.setSiiArchivoFisico(this);
        return siiContrato;
    }

    public SiiContrato removeSiiContrato(SiiContrato siiContrato) {
        getSiiContratoList().remove(siiContrato);
        siiContrato.setSiiArchivoFisico(null);
        return siiContrato;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiResolucionLiquid> getSiiResolucionLiquidList() {
        return siiResolucionLiquidList;
    }

    public void setSiiResolucionLiquidList(List<SiiResolucionLiquid> siiResolucionLiquidList) {
        this.siiResolucionLiquidList = siiResolucionLiquidList;
    }

    public SiiResolucionLiquid addSiiResolucionLiquid(SiiResolucionLiquid siiResolucionLiquid) {
        getSiiResolucionLiquidList().add(siiResolucionLiquid);
        siiResolucionLiquid.setSiiArchivoFisico(this);
        return siiResolucionLiquid;
    }

    public SiiResolucionLiquid removeSiiResolucionLiquid(SiiResolucionLiquid siiResolucionLiquid) {
        getSiiResolucionLiquidList().remove(siiResolucionLiquid);
        siiResolucionLiquid.setSiiArchivoFisico(null);
        return siiResolucionLiquid;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiOtrosi> getSiiOtrosiList() {
        return siiOtrosiList;
    }

    public void setSiiOtrosiList(List<SiiOtrosi> siiOtrosiList) {
        this.siiOtrosiList = siiOtrosiList;
    }

    public SiiOtrosi addSiiOtrosi(SiiOtrosi siiOtrosi) {
        getSiiOtrosiList().add(siiOtrosi);
        siiOtrosi.setSiiArchivoFisico(this);
        return siiOtrosi;
    }

    public SiiOtrosi removeSiiOtrosi(SiiOtrosi siiOtrosi) {
        getSiiOtrosiList().remove(siiOtrosi);
        siiOtrosi.setSiiArchivoFisico(null);
        return siiOtrosi;
    }
    
    @OneToMany(mappedBy = "siiArchivoFisicoInfFinal")
    public List<SiiLiquidacionContrato> getSiiLiquidacionContratoInfFinalList() {
        return siiLiquidacionContratoInfFinalList;
    }

    public void setSiiLiquidacionContratoInfFinalList(List<SiiLiquidacionContrato> siiLiquidacionContratoInfFinalList) {
        this.siiLiquidacionContratoInfFinalList = siiLiquidacionContratoInfFinalList;
    }

    public SiiLiquidacionContrato addSiiLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) {
        getSiiLiquidacionContratoInfFinalList().add(siiLiquidacionContrato);
        siiLiquidacionContrato.setSiiArchivoFisicoInfFinal(this);
        return siiLiquidacionContrato;
    }

    public SiiLiquidacionContrato removeSiiLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) {
        getSiiLiquidacionContratoInfFinalList().remove(siiLiquidacionContrato);
        siiLiquidacionContrato.setSiiArchivoFisicoInfFinal(null);
        return siiLiquidacionContrato;
    }

    @OneToMany(mappedBy = "siiArchivoFisicoOficioCita")
    public List<SiiLiquidacionContrato> getSiiLiquidacionContratoOficioCitaList() {
        return siiLiquidacionContratoOficioCitaList;
    }

    public void setSiiLiquidacionContratoOficioCitaList(List<SiiLiquidacionContrato> siiLiquidacionContratoOficioCitaList) {
        this.siiLiquidacionContratoOficioCitaList = siiLiquidacionContratoOficioCitaList;
    }
    
    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiCargaDocumentoCont> getSiiCargaDocumentoContList() {
        return siiCargaDocumentoContList;
    }

    public void setSiiCargaDocumentoContList(List<SiiCargaDocumentoCont> siiCargaDocumentoContList) {
        this.siiCargaDocumentoContList = siiCargaDocumentoContList;
    }

    public SiiCargaDocumentoCont addSiiCargaDocumentoCont(SiiCargaDocumentoCont siiCargaDocumentoCont) {
        getSiiCargaDocumentoContList().add(siiCargaDocumentoCont);
        siiCargaDocumentoCont.setSiiArchivoFisico(this);
        return siiCargaDocumentoCont;
    }

    public SiiCargaDocumentoCont removeSiiCargaDocumentoCont(SiiCargaDocumentoCont siiCargaDocumentoCont) {
        getSiiCargaDocumentoContList().remove(siiCargaDocumentoCont);
        siiCargaDocumentoCont.setSiiArchivoFisico(null);
        return siiCargaDocumentoCont;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiInformeSupervision> getSiiInformeSupervisionList() {
        return siiInformeSupervisionList;
    }

    public void setSiiInformeSupervisionList(List<SiiInformeSupervision> siiInformeSupervisionList) {
        this.siiInformeSupervisionList = siiInformeSupervisionList;
    }

    public SiiInformeSupervision addSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        getSiiInformeSupervisionList().add(siiInformeSupervision);
        siiInformeSupervision.setSiiArchivoFisico(this);
        return siiInformeSupervision;
    }

    public SiiInformeSupervision removeSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        getSiiInformeSupervisionList().remove(siiInformeSupervision);
        siiInformeSupervision.setSiiArchivoFisico(null);
        return siiInformeSupervision;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiResolucionIncumContr> getSiiResolucionIncumContrList() {
        return siiResolucionIncumContrList;
    }

    public void setSiiResolucionIncumContrList(List<SiiResolucionIncumContr> siiResolucionIncumContrList) {
        this.siiResolucionIncumContrList = siiResolucionIncumContrList;
    }

    public SiiResolucionIncumContr addSiiResolucionIncumContr(SiiResolucionIncumContr siiResolucionIncumContr) {
        getSiiResolucionIncumContrList().add(siiResolucionIncumContr);
        siiResolucionIncumContr.setSiiArchivoFisico(this);
        return siiResolucionIncumContr;
    }

    public SiiResolucionIncumContr removeSiiResolucionIncumContr(SiiResolucionIncumContr siiResolucionIncumContr) {
        getSiiResolucionIncumContrList().remove(siiResolucionIncumContr);
        siiResolucionIncumContr.setSiiArchivoFisico(null);
        return siiResolucionIncumContr;
    }

    @OneToMany(mappedBy = "siiArchivoFisicoAseg")
    public List<SiiIncumplimientoContr> getSiiIncumplimientoContrAsegList() {
        return siiIncumplimientoContrAsegList;
    }

    public void setSiiIncumplimientoContrAsegList(List<SiiIncumplimientoContr> siiIncumplimientoContrAsegList) {
        this.siiIncumplimientoContrAsegList = siiIncumplimientoContrAsegList;
    }

    @OneToMany(mappedBy = "siiArchivoFisicoAuto")
    public List<SiiIncumplimientoContr> getSiiIncumplimientoContrAutoList() {
        return siiIncumplimientoContrAutoList;
    }

    public void setSiiIncumplimientoContrAutoList(List<SiiIncumplimientoContr> siiIncumplimientoContrAutoList) {
        this.siiIncumplimientoContrAutoList = siiIncumplimientoContrAutoList;
    }

    @OneToMany(mappedBy = "siiArchivoFisicoOper")
    public List<SiiIncumplimientoContr> getSiiIncumplimientoContrOperList() {
        return siiIncumplimientoContrOperList;
    }

    public void setSiiIncumplimientoContrOperList(List<SiiIncumplimientoContr> siiIncumplimientoContrOperList) {
        this.siiIncumplimientoContrOperList = siiIncumplimientoContrOperList;
    }

    public SiiIncumplimientoContr addSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrOperList().add(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiArchivoFisicoOper(this);
        return siiIncumplimientoContr;
    }

    public SiiIncumplimientoContr removeSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrOperList().remove(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiArchivoFisicoOper(null);
        return siiIncumplimientoContr;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiResolucionProcSanc> getSiiResolucionProcSancList() {
        return siiResolucionProcSancList;
    }

    public void setSiiResolucionProcSancList(List<SiiResolucionProcSanc> siiResolucionProcSancList) {
        this.siiResolucionProcSancList = siiResolucionProcSancList;
    }

    public SiiResolucionProcSanc addSiiResolucionProcSanc(SiiResolucionProcSanc siiResolucionProcSanc) {
        getSiiResolucionProcSancList().add(siiResolucionProcSanc);
        siiResolucionProcSanc.setSiiArchivoFisico(this);
        return siiResolucionProcSanc;
    }

    public SiiResolucionProcSanc removeSiiResolucionProcSanc(SiiResolucionProcSanc siiResolucionProcSanc) {
        getSiiResolucionProcSancList().remove(siiResolucionProcSanc);
        siiResolucionProcSanc.setSiiArchivoFisico(null);
        return siiResolucionProcSanc;
    }

    @OneToMany(mappedBy = "siiArchivoFisicoAuto")
    public List<SiiProcesoSancionatorio> getSiiProcesoSancionatorioAutoList() {
        return siiProcesoSancionatorioAutoList;
    }

    public void setSiiProcesoSancionatorioAutoList(List<SiiProcesoSancionatorio> siiProcesoSancionatorioAutoList) {
        this.siiProcesoSancionatorioAutoList = siiProcesoSancionatorioAutoList;
    }

    public SiiProcesoSancionatorio addSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioAutoList().add(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiArchivoFisicoAuto(this);
        return siiProcesoSancionatorio;
    }

    public SiiProcesoSancionatorio removeSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioAutoList().remove(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiArchivoFisicoAuto(null);
        return siiProcesoSancionatorio;
    }

    @OneToMany(mappedBy = "siiArchivoFisico")
    public List<SiiCargaPoblacion> getSiiCargaPoblacionList() {
        return siiCargaPoblacionList;
    }

    public void setSiiCargaPoblacionList(List<SiiCargaPoblacion> siiCargaPoblacionList) {
        this.siiCargaPoblacionList = siiCargaPoblacionList;
    }

    public SiiCargaPoblacion addSiiCargaPoblacion(SiiCargaPoblacion siiCargaPoblacion) {
        getSiiCargaPoblacionList().add(siiCargaPoblacion);
        siiCargaPoblacion.setSiiArchivoFisico(this);
        return siiCargaPoblacion;
    }

    public SiiCargaPoblacion removeSiiCargaPoblacion(SiiCargaPoblacion siiCargaPoblacion) {
        getSiiCargaPoblacionList().remove(siiCargaPoblacion);
        siiCargaPoblacion.setSiiArchivoFisico(null);
        return siiCargaPoblacion;
    }
}
