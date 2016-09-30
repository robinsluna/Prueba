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
@Table(name = "SII_USUARIO")
public class SiiUsuario implements Serializable {
    private static final long serialVersionUID = -1801940839862312665L;
    private Long usuCodigo;
    private String usuContrasena;
    private String usuEmail;
    private Date usuFechaCreacion;
    private Date usuFechaUltimoLogin;
    private String usuNombreUsuario;
    private String usuSalt;
    private List<SiiUsuarioRol> siiUsuarioRolList;
    private SiiPersona siiPersona;
    private List<SiiFirmaDocumento> siiFirmaDocumentoList;
    private List<SiiApropiacionInicial> siiApropiacionInicialList;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList6;
    private SiiEstadoUsuario siiEstadoUsuario;
    private List<SiiApropiacionInicial> siiApropiacionInicialList1;
    private List<SiiApropiacionInicial> siiApropiacionInicialList2;
    private SiiFuncion siiFuncion1;
    private SiiAreaColjuegos siiAreaColjuegos1;
    private List<SiiEstudioPrevio> siiEstudioPrevioList1;
    private List<SiiInvitacionProceso> siiInvitacionProcesoList1;
    private List<SiiCdp> siiCdpList;
    private List<SiiLogCambioEstado> siiLogCambioEstadoList;
    private List<SiiObligacion> siiObligacionList1;
    private List<SiiObligacion> siiObligacionList2;
    private List<SiiOficioDesigSuperv> siiOficioDesigSupervList;
    private List<SiiLogGeneral> siiLogGeneralList;
    private List<SiiOrdenPago> siiOrdenPagoRegistraList;
    private List<SiiOrdenPago> siiOrdenPagoApruebaList;
    private List<SiiDocumentoContable> siiDocumentoContableApruebaList;
    private List<SiiDocumentoContable> siiDocumentoContableRegistraList;
    private List<SiiAjuste> siiAjusteList;
    private List<SiiCorteCartera> siiCorteCarteraList;
    private List<SiiObligacionNoPresup> siiObligNoPresUsuRegList;
    private List<SiiObligacionNoPresup> siiObligNoPresUsuAprList;
    private String usuUsuSistema;
    private List<SiiSolicitudAutoriza> siiSolicitudAutorizaList;
    private List<SiiInformeSupervision> siiInformeSupervisionList;
    private List<SiiNotaCredito> siiNotaCreditoApruebaList;
    private List<SiiNotaCredito> siiNotaCreditoRegistraList;
    private List<SiiDireccionPersonaAtien> siiDireccionPersonaAtienUsuConectList;
    private List<SiiAccionControl> siiAccionControlUsuConectList;
    private List<SiiPersonaAtiendeAcc> siiPersonaAtiendeAccUsuConectList;
    private List<SiiElementoRetiradoAcc> siiElementoRetiradoAccUsuConectList;
    private List<SiiTramiteResolDecDes> siiTramiteResolDecDesUsuConList;
    private List<SiiResolucionDecomDest> siiResolucionDecomDestUsuConList;
    private List<SiiActaDestruccion> siiActaDestruccionUsuarioConList;
    private List<SiiEmpresaDestruye> siiEmpresaDestruyeUsuarioConList;
    private List<SiiResolucionDesisSolAut> siiResolucionDesisSolAutUsuConectList;
    private List<SiiInventarioResolDesis> siiInventarioResolDesisUsuConectList;
    private List<SiiDireccion> siiDireccionUsuConecList;
    private List<SiiPagoCargaActAdm> siiPagoCargaActAdmUsuConecList;
    private List<SiiAjusteContCarAct> siiAjusteContCarActUsuConList;
    private List<SiiEstablecConCuoCar> siiEstablecConCuoCarUsuConList;
    private List<SiiConceptoProyeccionCar> siiConceptoProyeccionCarUsuConList;
    private List<SiiConcepCuotCarActAdm> siiConcepCuotCarActAdmUsuConList;
    private List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmUsuConList;
    private List<SiiProyeccionCargaAct> siiProyeccionCargaActUsuConList;
    private List<SiiProcesoSancionatorio> siiProcesoSancionatorioUsuRegList;
    private List<SiiIncumplimientoContr> siiIncumplimientoContrUsuRegList;
    private List<SiiDescargoProcIleg> siiDescargoProcIlegList;
    private List<SiiPruebaAutoDecrPru> siiPruebaAutoDecrPruUsuConecList;
    private List<SiiAutoFormCargProIle> siiAutoFormCargProIleUsuConecList;
    private List<SiiPersonaInvProIleAuto> siiPersonaInvProIleAutoUsuConecList;
    private List<SiiPersonaInvestProIle> siiPersonaInvestProIleUsuConecList;
    private List<SiiTramiteResolProIle> siiTramiteResolProIleUsuConecList;
    private List<SiiResolucionProcIleg> siiResolucionProcIlegUsuConecList;
    private List<SiiDireccionPersona> siiDireccionPersonaUsuConecList;
    private List<SiiComunicResolPersIle> siiComunicResolPersIleUsuConecList;
    private List<SiiAutoDecretaPrueProIle> siiAutoDecretaPrueProIleUsuConList;
    private List<SiiTramiteAutoPrueTras> siiTramiteAutoPrueTrasUsuConList;
    private List<SiiTramiteAutoForCarIle> siiTramiteAutoForCarIleUsuConList;
    private List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadUsuConList;
    private List<SiiDireccionProcePerIle> siiDireccionProcePerIleUsuConList;
    private List<SiiComunicacSujSancIle> siiComunicacSujSancIleUsuConList;
    private List<SiiInhabilidadPersona> siiInhabilidadPersonaUsuConList;
    private List<SiiTasaInteres> siiTasaInteresUsuConList;
    private List<SiiRecepcionAlegatoProSan> siiRecepcionAlegatoProSanUsuConList;
    private List<SiiLogActividad> siiLogActividadList;
    private List<SiiEnteTerritorial> siiEnteTerritorialUsuConList;
    private List<SiiPoblacionEnte> siiPoblacionEnteUsuConList;
    private List<SiiCargaPoblacion> siiCargaPoblacionUsuConList;
    private List<SiiAbonoIniAcuerdoPago> siiAbonoIniAcuerdoPagoUsuConList;
    private List<SiiItemPlanContratac> siiItemPlanContratacUsuConList;
    private List<SiiRpDetRubReintIngPag> siiRpDetRubReintIngPagUsuConList;
    private List<SiiModifEstadoDocContab> siiModifEstadoDocContabUsuConList;
    private List<SiiPerInvesProIleAutoPru> siiPerInvesProIleAutoPruUsuConList;
    private List<SiiPruebaDescargoProIle> siiPruebaDescargoProIleUsuConList;
    private List<SiiElementoProcesoIle> siiElementoProcesoIleUsuConList;
    private List<SiiTipoApuestPolizaRenovac> siiTipoApuestPolizaRenovacUsuConList;
    private List<SiiModificPresup> siiModificPresupUsuConList;
    private List<SiiModPresDetRubro> siiModPresDetRubroUsuConList;
    private List<SiiHistorialPermiso> siiHistorialPermisoUsuConList;
    private List<SiiHistorialPermiso> siiHistorialPermisoList;
    private List<SiiHistorialRol> siiHistorialRolUsuConList;
    private List<SiiLogModificacion> siiLogModificacionUsuConList;
    private List<SiiReintegroIngresoPag> siiReintegroIngresoPagUsuConList;

    public SiiUsuario() {
    }

    public SiiUsuario(SiiAreaColjuegos siiAreaColjuegos1, SiiEstadoUsuario siiEstadoUsuario, SiiFuncion siiFuncion1,
                      SiiPersona siiPersona, Long usuCodigo, String usuContrasena, String usuEmail,
                      Date usuFechaUltimoLogin, String usuNombreUsuario, String usuSalt, Date usuFechaCreacion) {
        this.siiAreaColjuegos1 = siiAreaColjuegos1;
        this.siiEstadoUsuario = siiEstadoUsuario;
        this.siiFuncion1 = siiFuncion1;
        this.siiPersona = siiPersona;
        this.usuCodigo = usuCodigo;
        this.usuContrasena = usuContrasena;
        this.usuEmail = usuEmail;
        this.usuFechaCreacion = usuFechaCreacion;
        this.usuFechaUltimoLogin = usuFechaUltimoLogin;
        this.usuNombreUsuario = usuNombreUsuario;
        this.usuSalt = usuSalt;
    }


    @Id
    @Column(name = "USU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USUARIO_CODIGO")
    @SequenceGenerator(name = "SEQ_USUARIO_CODIGO", sequenceName = "SEQ_USUARIO_CODIGO",allocationSize=1)
    public Long getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Long usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    @Column(name = "USU_CONTRASENA", length = 50)
    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    @Column(name = "USU_EMAIL", length = 100)
    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "USU_FECHA_ULTIMO_LOGIN")
    public Date getUsuFechaUltimoLogin() {
        return usuFechaUltimoLogin;
    }

    public void setUsuFechaUltimoLogin(Date usuFechaUltimoLogin) {
        this.usuFechaUltimoLogin = usuFechaUltimoLogin;
    }

    @Column(name = "USU_NOMBRE_USUARIO", nullable = false, length = 20)
    public String getUsuNombreUsuario() {
        return usuNombreUsuario;
    }

    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }

    @Column(name = "USU_SALT", length = 40)
    public String getUsuSalt() {
        return usuSalt;
    }

    public void setUsuSalt(String usuSalt) {
        this.usuSalt = usuSalt;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiFirmaDocumento> getSiiFirmaDocumentoList() {
        return siiFirmaDocumentoList;
    }


    public void setSiiFirmaDocumentoList(List<SiiFirmaDocumento> siiFirmaDocumentoList) {
        this.siiFirmaDocumentoList = siiFirmaDocumentoList;
    }

    public SiiFirmaDocumento addSiiFirmaDocumento(SiiFirmaDocumento siiFirmaDocumento) {
        getSiiFirmaDocumentoList().add(siiFirmaDocumento);
        siiFirmaDocumento.setSiiUsuario(this);
        return siiFirmaDocumento;
    }

    public SiiFirmaDocumento removeSiiFirmaDocumento(SiiFirmaDocumento siiFirmaDocumento) {
        getSiiFirmaDocumentoList().remove(siiFirmaDocumento);
        siiFirmaDocumento.setSiiUsuario(null);
        return siiFirmaDocumento;
    }

    @OneToMany(mappedBy = "siiUsuario1")
    public List<SiiApropiacionInicial> getSiiApropiacionInicialList() {
        return siiApropiacionInicialList;
    }

    public void setSiiApropiacionInicialList(List<SiiApropiacionInicial> siiApropiacionInicialList) {
        this.siiApropiacionInicialList = siiApropiacionInicialList;
    }

    public SiiApropiacionInicial addSiiApropiacionInicial(SiiApropiacionInicial siiApropiacionInicial) {
        getSiiApropiacionInicialList().add(siiApropiacionInicial);
        siiApropiacionInicial.setSiiUsuario1(this);
        return siiApropiacionInicial;
    }

    public SiiApropiacionInicial removeSiiApropiacionInicial(SiiApropiacionInicial siiApropiacionInicial) {
        getSiiApropiacionInicialList().remove(siiApropiacionInicial);
        siiApropiacionInicial.setSiiUsuario1(null);
        return siiApropiacionInicial;
    }

    @OneToMany(mappedBy = "siiUsuario2")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList6() {
        return siiSolicitudEstMercadoList6;
    }

    public void setSiiSolicitudEstMercadoList6(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList6) {
        this.siiSolicitudEstMercadoList6 = siiSolicitudEstMercadoList6;
    }

    public SiiSolicitudEstMercado addSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList6().add(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiUsuario2(this);
        return siiSolicitudEstMercado;
    }

    public SiiSolicitudEstMercado removeSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList6().remove(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiUsuario2(null);
        return siiSolicitudEstMercado;
    }

    @ManyToOne
    @JoinColumn(name = "EUS_CODIGO")
    public SiiEstadoUsuario getSiiEstadoUsuario() {
        return siiEstadoUsuario;
    }

    public void setSiiEstadoUsuario(SiiEstadoUsuario siiEstadoUsuario) {
        this.siiEstadoUsuario = siiEstadoUsuario;
    }

    @OneToMany(mappedBy = "siiUsuario3")
    public List<SiiApropiacionInicial> getSiiApropiacionInicialList1() {
        return siiApropiacionInicialList1;
    }

    public void setSiiApropiacionInicialList1(List<SiiApropiacionInicial> siiApropiacionInicialList1) {
        this.siiApropiacionInicialList1 = siiApropiacionInicialList1;
    }

    @OneToMany(mappedBy = "siiUsuario4")
    public List<SiiApropiacionInicial> getSiiApropiacionInicialList2() {
        return siiApropiacionInicialList2;
    }

    public void setSiiApropiacionInicialList2(List<SiiApropiacionInicial> siiApropiacionInicialList2) {
        this.siiApropiacionInicialList2 = siiApropiacionInicialList2;
    }

    @ManyToOne
    @JoinColumn(name = "FUN_CODIGO")
    public SiiFuncion getSiiFuncion1() {
        return siiFuncion1;
    }

    public void setSiiFuncion1(SiiFuncion siiFuncion1) {
        this.siiFuncion1 = siiFuncion1;
    }

    @ManyToOne
    @JoinColumn(name = "ACO_CODIGO")
    public SiiAreaColjuegos getSiiAreaColjuegos1() {
        return siiAreaColjuegos1;
    }

    public void setSiiAreaColjuegos1(SiiAreaColjuegos siiAreaColjuegos1) {
        this.siiAreaColjuegos1 = siiAreaColjuegos1;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiUsuarioRol> getSiiUsuarioRolList() {
        return siiUsuarioRolList;
    }
    
    public void setSiiUsuarioRolList(List<SiiUsuarioRol> siiUsuarioRolList) {
        this.siiUsuarioRolList = siiUsuarioRolList;
    }

    public SiiUsuarioRol addSiiUsuarioRol(SiiUsuarioRol siiUsuarioRol) {
        getSiiUsuarioRolList().add(siiUsuarioRol);
        siiUsuarioRol.setSiiUsuario(this);
        return siiUsuarioRol;
    }

    public SiiUsuarioRol removeSiiUsuarioRol(SiiUsuarioRol siiUsuarioRol) {
        getSiiUsuarioRolList().remove(siiUsuarioRol);
        siiUsuarioRol.setSiiUsuario(null);
        return siiUsuarioRol;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiEstudioPrevio> getSiiEstudioPrevioList1() {
        return siiEstudioPrevioList1;
    }

    public void setSiiEstudioPrevioList1(List<SiiEstudioPrevio> siiEstudioPrevioList1) {
        this.siiEstudioPrevioList1 = siiEstudioPrevioList1;
    }

    public SiiEstudioPrevio addSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList1().add(siiEstudioPrevio);
        siiEstudioPrevio.setSiiUsuario(this);
        return siiEstudioPrevio;
    }

    public SiiEstudioPrevio removeSiiEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio) {
        getSiiEstudioPrevioList1().remove(siiEstudioPrevio);
        siiEstudioPrevio.setSiiUsuario(null);
        return siiEstudioPrevio;
    }
    
    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiInvitacionProceso> getSiiInvitacionProcesoList1() {
    return siiInvitacionProcesoList1;
    }

    public void setSiiInvitacionProcesoList1(List<SiiInvitacionProceso> siiInvitacionProcesoList1) {
    this.siiInvitacionProcesoList1 = siiInvitacionProcesoList1;
    }

    public SiiInvitacionProceso addSiiInvitacionProceso(SiiInvitacionProceso siiInvitacionProceso) {
    getSiiInvitacionProcesoList1().add(siiInvitacionProceso);
    siiInvitacionProceso.setSiiUsuario(this);
    return siiInvitacionProceso;
    }

    public SiiInvitacionProceso removeSiiInvitacionProceso(SiiInvitacionProceso siiInvitacionProceso) {
    getSiiInvitacionProcesoList1().remove(siiInvitacionProceso);
    siiInvitacionProceso.setSiiUsuario(null);
    return siiInvitacionProceso;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiCdp> getSiiCdpList() {
        return siiCdpList;
    }

    public void setSiiCdpList(List<SiiCdp> siiCdpList) {
        this.siiCdpList = siiCdpList;
    }

    public SiiCdp addSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList().add(siiCdp);
        siiCdp.setSiiUsuario(this);
        return siiCdp;
    }

    public SiiCdp removeSiiCdp(SiiCdp siiCdp) {
        getSiiCdpList().remove(siiCdp);
        siiCdp.setSiiUsuario(null);
        return siiCdp;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiLogCambioEstado> getSiiLogCambioEstadoList() {
        return siiLogCambioEstadoList;
    }

    public void setSiiLogCambioEstadoList(List<SiiLogCambioEstado> siiLogCambioEstadoList) {
        this.siiLogCambioEstadoList = siiLogCambioEstadoList;
    }

    public SiiLogCambioEstado addSiiLogCambioEstado(SiiLogCambioEstado siiLogCambioEstado) {
        getSiiLogCambioEstadoList().add(siiLogCambioEstado);
        siiLogCambioEstado.setSiiUsuario(this);
        return siiLogCambioEstado;
    }

    public SiiLogCambioEstado removeSiiLogCambioEstado(SiiLogCambioEstado siiLogCambioEstado) {
        getSiiLogCambioEstadoList().remove(siiLogCambioEstado);
        siiLogCambioEstado.setSiiUsuario(null);
        return siiLogCambioEstado;
    }

    @OneToMany(mappedBy = "siiUsuarioReg")
    public List<SiiObligacion> getSiiObligacionList1() {
        return siiObligacionList1;
    }

    public void setSiiObligacionList1(List<SiiObligacion> siiObligacionList1) {
        this.siiObligacionList1 = siiObligacionList1;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList1().add(siiObligacion);
        siiObligacion.setSiiUsuarioReg(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList1().remove(siiObligacion);
        siiObligacion.setSiiUsuarioReg(null);
        return siiObligacion;
    }

    @OneToMany(mappedBy = "siiUsuarioApr")
    public List<SiiObligacion> getSiiObligacionList2() {
        return siiObligacionList2;
    }

    public void setSiiObligacionList2(List<SiiObligacion> siiObligacionList2) {
        this.siiObligacionList2 = siiObligacionList2;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiOficioDesigSuperv> getSiiOficioDesigSupervList() {
        return siiOficioDesigSupervList;
    }

    public void setSiiOficioDesigSupervList(List<SiiOficioDesigSuperv> siiOficioDesigSupervList) {
        this.siiOficioDesigSupervList = siiOficioDesigSupervList;
    }

    public SiiOficioDesigSuperv addSiiOficioDesigSuperv(SiiOficioDesigSuperv siiOficioDesigSuperv) {
        getSiiOficioDesigSupervList().add(siiOficioDesigSuperv);
        siiOficioDesigSuperv.setSiiUsuario(this);
        return siiOficioDesigSuperv;
    }

    public SiiOficioDesigSuperv removeSiiOficioDesigSuperv(SiiOficioDesigSuperv siiOficioDesigSuperv) {
        getSiiOficioDesigSupervList().remove(siiOficioDesigSuperv);
        siiOficioDesigSuperv.setSiiUsuario(null);
        return siiOficioDesigSuperv;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiLogGeneral> getSiiLogGeneralList() {
        return siiLogGeneralList;
    }

    public void setSiiLogGeneralList(List<SiiLogGeneral> siiLogGeneralList) {
        this.siiLogGeneralList = siiLogGeneralList;
    }

    public SiiLogGeneral addSiiLogGeneral(SiiLogGeneral siiLogGeneral) {
        getSiiLogGeneralList().add(siiLogGeneral);
        siiLogGeneral.setSiiUsuario(this);
        return siiLogGeneral;
    }

    public SiiLogGeneral removeSiiLogGeneral(SiiLogGeneral siiLogGeneral) {
        getSiiLogGeneralList().remove(siiLogGeneral);
        siiLogGeneral.setSiiUsuario(null);
        return siiLogGeneral;
    }

    @OneToMany(mappedBy = "siiUsuarioRegistra")
    public List<SiiOrdenPago> getSiiOrdenPagoRegistraList() {
        return siiOrdenPagoRegistraList;
    }

    public void setSiiOrdenPagoRegistraList(List<SiiOrdenPago> siiOrdenPagoRegistraList) {
        this.siiOrdenPagoRegistraList = siiOrdenPagoRegistraList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoRegistraList().add(siiOrdenPago);
        siiOrdenPago.setSiiUsuarioRegistra(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoRegistraList().remove(siiOrdenPago);
        siiOrdenPago.setSiiUsuarioRegistra(null);
        return siiOrdenPago;
    }

    @OneToMany(mappedBy = "siiUsuarioAprueba")
    public List<SiiOrdenPago> getSiiOrdenPagoApruebaList() {
        return siiOrdenPagoApruebaList;
    }

    public void setSiiOrdenPagoApruebaList(List<SiiOrdenPago> siiOrdenPagoApruebaList) {
        this.siiOrdenPagoApruebaList = siiOrdenPagoApruebaList;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "USU_FECHA_CREACION", nullable = false)
    public Date getUsuFechaCreacion() {
        return usuFechaCreacion;
    }

    public void setUsuFechaCreacion(Date usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

    @OneToMany(mappedBy = "siiUsuarioAprueba")
    public List<SiiDocumentoContable> getSiiDocumentoContableApruebaList() {
        return siiDocumentoContableApruebaList;
    }

    public void setSiiDocumentoContableApruebaList(List<SiiDocumentoContable> siiDocumentoContableApruebaList) {
        this.siiDocumentoContableApruebaList = siiDocumentoContableApruebaList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableApruebaList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiUsuarioAprueba(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableApruebaList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiUsuarioAprueba(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiUsuarioRegistra")
    public List<SiiDocumentoContable> getSiiDocumentoContableRegistraList() {
        return siiDocumentoContableRegistraList;
    }

    public void setSiiDocumentoContableRegistraList(List<SiiDocumentoContable> siiDocumentoContableRegistraList) {
        this.siiDocumentoContableRegistraList = siiDocumentoContableRegistraList;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiAjuste> getSiiAjusteList() {
        return siiAjusteList;
    }

    public void setSiiAjusteList(List<SiiAjuste> siiAjusteList) {
        this.siiAjusteList = siiAjusteList;
    }

    public SiiAjuste addSiiAjuste(SiiAjuste siiAjuste) {
        getSiiAjusteList().add(siiAjuste);
        siiAjuste.setSiiUsuario(this);
        return siiAjuste;
    }

    public SiiAjuste removeSiiAjuste(SiiAjuste siiAjuste) {
        getSiiAjusteList().remove(siiAjuste);
        siiAjuste.setSiiUsuario(null);
        return siiAjuste;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiCorteCartera> getSiiCorteCarteraList() {
        return siiCorteCarteraList;
    }

    public void setSiiCorteCarteraList(List<SiiCorteCartera> siiCorteCarteraList) {
        this.siiCorteCarteraList = siiCorteCarteraList;
    }

    public SiiCorteCartera addSiiCorteCartera(SiiCorteCartera siiCorteCartera) {
        getSiiCorteCarteraList().add(siiCorteCartera);
        siiCorteCartera.setSiiUsuario(this);
        return siiCorteCartera;
    }

    public SiiCorteCartera removeSiiCorteCartera(SiiCorteCartera siiCorteCartera) {
        getSiiCorteCarteraList().remove(siiCorteCartera);
        siiCorteCartera.setSiiUsuario(null);
        return siiCorteCartera;
    }

    @OneToMany(mappedBy = "siiUsuarioRegistra")
    public List<SiiObligacionNoPresup> getSiiObligNoPresUsuRegList() {
        return siiObligNoPresUsuRegList;
    }

    public void setSiiObligNoPresUsuRegList(List<SiiObligacionNoPresup> siiObligNoPresUsuRegList) {
        this.siiObligNoPresUsuRegList = siiObligNoPresUsuRegList;
    }

    public SiiObligacionNoPresup addSiiObligacionNoPresup(SiiObligacionNoPresup siiObligacionNoPresup) {
        getSiiObligNoPresUsuRegList().add(siiObligacionNoPresup);
        siiObligacionNoPresup.setSiiUsuarioRegistra(this);
        return siiObligacionNoPresup;
    }

    public SiiObligacionNoPresup removeSiiObligacionNoPresup(SiiObligacionNoPresup siiObligacionNoPresup) {
        getSiiObligNoPresUsuRegList().remove(siiObligacionNoPresup);
        siiObligacionNoPresup.setSiiUsuarioRegistra(null);
        return siiObligacionNoPresup;
    }

    @OneToMany(mappedBy = "siiUsuarioAprueba")
    public List<SiiObligacionNoPresup> getSiiObligNoPresUsuAprList() {
        return siiObligNoPresUsuAprList;
    }

    public void setSiiObligNoPresUsuAprList(List<SiiObligacionNoPresup> siiObligNoPresUsuAprList) {
        this.siiObligNoPresUsuAprList = siiObligNoPresUsuAprList;
    }
    
    @Column(name = "USU_USU_SISTEMA", length = 1)
    public String getUsuUsuSistema() {
        return usuUsuSistema;
    }

    public void setUsuUsuSistema(String usuUsuSistema) {
        this.usuUsuSistema = usuUsuSistema;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiSolicitudAutoriza> getSiiSolicitudAutorizaList() {
        return siiSolicitudAutorizaList;
    }

    public void setSiiSolicitudAutorizaList(List<SiiSolicitudAutoriza> siiSolicitudAutorizaList) {
        this.siiSolicitudAutorizaList = siiSolicitudAutorizaList;
    }

    public SiiSolicitudAutoriza addSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().add(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiUsuario(this);
        return siiSolicitudAutoriza;
    }

    public SiiSolicitudAutoriza removeSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().remove(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiUsuario(null);
        return siiSolicitudAutoriza;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiInformeSupervision> getSiiInformeSupervisionList() {
        return siiInformeSupervisionList;
    }

    public void setSiiInformeSupervisionList(List<SiiInformeSupervision> siiInformeSupervisionList) {
        this.siiInformeSupervisionList = siiInformeSupervisionList;
    }

    public SiiInformeSupervision addSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        getSiiInformeSupervisionList().add(siiInformeSupervision);
        siiInformeSupervision.setSiiUsuario(this);
        return siiInformeSupervision;
    }

    public SiiInformeSupervision removeSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        getSiiInformeSupervisionList().remove(siiInformeSupervision);
        siiInformeSupervision.setSiiUsuario(null);
        return siiInformeSupervision;
    }
    
    @OneToMany(mappedBy = "siiUsuarioRegistra")
    public List<SiiNotaCredito> getSiiNotaCreditoApruebaList() {
        return siiNotaCreditoApruebaList;
    }

    public void setSiiNotaCreditoApruebaList(List<SiiNotaCredito> siiNotaCreditoApruebaList) {
        this.siiNotaCreditoApruebaList = siiNotaCreditoApruebaList;
    }

    public SiiNotaCredito addSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        getSiiNotaCreditoApruebaList().add(siiNotaCredito);
        siiNotaCredito.setSiiUsuarioRegistra(this);
        return siiNotaCredito;
    }

    public SiiNotaCredito removeSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        getSiiNotaCreditoApruebaList().remove(siiNotaCredito);
        siiNotaCredito.setSiiUsuarioRegistra(null);
        return siiNotaCredito;
    }

    @OneToMany(mappedBy = "siiUsuarioAprueba")
    public List<SiiNotaCredito> getSiiNotaCreditoRegistraList() {
        return siiNotaCreditoRegistraList;
    }

    public void setSiiNotaCreditoRegistraList(List<SiiNotaCredito> siiNotaCreditoRegistraList) {
        this.siiNotaCreditoRegistraList = siiNotaCreditoRegistraList;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiDireccionPersonaAtien> getSiiDireccionPersonaAtienUsuConectList(){
        return siiDireccionPersonaAtienUsuConectList;
    }

    public void setSiiDireccionPersonaAtienUsuConectList(List<SiiDireccionPersonaAtien> siiDireccionPersonaAtienUsuConectList){
        this.siiDireccionPersonaAtienUsuConectList = siiDireccionPersonaAtienUsuConectList;
    }

    public SiiDireccionPersonaAtien addSiiDireccionPersonaAtien(SiiDireccionPersonaAtien siiDireccionPersonaAtien){
        getSiiDireccionPersonaAtienUsuConectList().add(siiDireccionPersonaAtien);
        siiDireccionPersonaAtien.setSiiUsuarioConect(this);
        return siiDireccionPersonaAtien;
    }

    public SiiDireccionPersonaAtien removeSiiDireccionPersonaAtien(SiiDireccionPersonaAtien siiDireccionPersonaAtien){
        getSiiDireccionPersonaAtienUsuConectList().remove(siiDireccionPersonaAtien);
        siiDireccionPersonaAtien.setSiiUsuarioConect(null);
        return siiDireccionPersonaAtien;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiAccionControl> getSiiAccionControlUsuConectList(){
        return siiAccionControlUsuConectList;
    }

    public void setSiiAccionControlUsuConectList(List<SiiAccionControl> siiAccionControlUsuConectList){
        this.siiAccionControlUsuConectList = siiAccionControlUsuConectList;
    }

    public SiiAccionControl addSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlUsuConectList().add(siiAccionControl);
        siiAccionControl.setSiiUsuarioConect(this);
        return siiAccionControl;
    }

    public SiiAccionControl removeSiiAccionControl(SiiAccionControl siiAccionControl){
        getSiiAccionControlUsuConectList().remove(siiAccionControl);
        siiAccionControl.setSiiUsuarioConect(null);
        return siiAccionControl;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiPersonaAtiendeAcc> getSiiPersonaAtiendeAccUsuConectList(){
        return siiPersonaAtiendeAccUsuConectList;
    }

    public void setSiiPersonaAtiendeAccUsuConectList(List<SiiPersonaAtiendeAcc> siiPersonaAtiendeAccUsuConectList){
        this.siiPersonaAtiendeAccUsuConectList = siiPersonaAtiendeAccUsuConectList;
    }

    public SiiPersonaAtiendeAcc addSiiPersonaAtiendeAcc(SiiPersonaAtiendeAcc siiPersonaAtiendeAcc){
        getSiiPersonaAtiendeAccUsuConectList().add(siiPersonaAtiendeAcc);
        siiPersonaAtiendeAcc.setSiiUsuarioConect(this);
        return siiPersonaAtiendeAcc;
    }

    public SiiPersonaAtiendeAcc removeSiiPersonaAtiendeAcc(SiiPersonaAtiendeAcc siiPersonaAtiendeAcc){
        getSiiPersonaAtiendeAccUsuConectList().remove(siiPersonaAtiendeAcc);
        siiPersonaAtiendeAcc.setSiiUsuarioConect(null);
        return siiPersonaAtiendeAcc;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiElementoRetiradoAcc> getSiiElementoRetiradoAccUsuConectList(){
        return siiElementoRetiradoAccUsuConectList;
    }

    public void setSiiElementoRetiradoAccUsuConectList(List<SiiElementoRetiradoAcc> siiElementoRetiradoAccUsuConectList){
        this.siiElementoRetiradoAccUsuConectList = siiElementoRetiradoAccUsuConectList;
    }

    public SiiElementoRetiradoAcc addSiiElementoRetiradoAcc(SiiElementoRetiradoAcc siiElementoRetiradoAcc){
        getSiiElementoRetiradoAccUsuConectList().add(siiElementoRetiradoAcc);
        siiElementoRetiradoAcc.setSiiUsuarioConect(this);
        return siiElementoRetiradoAcc;
    }

    public SiiElementoRetiradoAcc removeSiiElementoRetiradoAcc(SiiElementoRetiradoAcc siiElementoRetiradoAcc){
        getSiiElementoRetiradoAccUsuConectList().remove(siiElementoRetiradoAcc);
        siiElementoRetiradoAcc.setSiiUsuarioConect(null);
        return siiElementoRetiradoAcc;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiTramiteResolDecDes> getSiiTramiteResolDecDesUsuConList(){
        return siiTramiteResolDecDesUsuConList;
    }

    public void setSiiTramiteResolDecDesUsuConList(List<SiiTramiteResolDecDes> siiTramiteResolDecDesUsuConList){
        this.siiTramiteResolDecDesUsuConList = siiTramiteResolDecDesUsuConList;
    }

    public SiiTramiteResolDecDes addSiiTramiteResolDecDes(SiiTramiteResolDecDes siiTramiteResolDecDes){
        getSiiTramiteResolDecDesUsuConList().add(siiTramiteResolDecDes);
        siiTramiteResolDecDes.setSiiUsuarioConect(this);
        return siiTramiteResolDecDes;
    }

    public SiiTramiteResolDecDes removeSiiTramiteResolDecDes(SiiTramiteResolDecDes siiTramiteResolDecDes){
        getSiiTramiteResolDecDesUsuConList().remove(siiTramiteResolDecDes);
        siiTramiteResolDecDes.setSiiUsuarioConect(null);
        return siiTramiteResolDecDes;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiResolucionDecomDest> getSiiResolucionDecomDestUsuConList(){
        return siiResolucionDecomDestUsuConList;
    }

    public void setSiiResolucionDecomDestUsuConList(List<SiiResolucionDecomDest> siiResolucionDecomDestUsuConList){
        this.siiResolucionDecomDestUsuConList = siiResolucionDecomDestUsuConList;
    }

    public SiiResolucionDecomDest addSiiResolucionDecomDest(SiiResolucionDecomDest siiResolucionDecomDest){
        getSiiResolucionDecomDestUsuConList().add(siiResolucionDecomDest);
        siiResolucionDecomDest.setSiiUsuarioConect(this);
        return siiResolucionDecomDest;
    }

    public SiiResolucionDecomDest removeSiiResolucionDecomDest(SiiResolucionDecomDest siiResolucionDecomDest){
        getSiiResolucionDecomDestUsuConList().remove(siiResolucionDecomDest);
        siiResolucionDecomDest.setSiiUsuarioConect(null);
        return siiResolucionDecomDest;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiActaDestruccion> getSiiActaDestruccionUsuarioConList(){
        return siiActaDestruccionUsuarioConList;
    }

    public void setSiiActaDestruccionUsuarioConList(List<SiiActaDestruccion> siiActaDestruccionUsuarioConList){
        this.siiActaDestruccionUsuarioConList = siiActaDestruccionUsuarioConList;
    }

    public SiiActaDestruccion addSiiActaDestruccion(SiiActaDestruccion siiActaDestruccion){
        getSiiActaDestruccionUsuarioConList().add(siiActaDestruccion);
        siiActaDestruccion.setSiiUsuarioConect(this);
        return siiActaDestruccion;
    }

    public SiiActaDestruccion removeSiiActaDestruccion(SiiActaDestruccion siiActaDestruccion){
        getSiiActaDestruccionUsuarioConList().remove(siiActaDestruccion);
        siiActaDestruccion.setSiiUsuarioConect(null);
        return siiActaDestruccion;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiEmpresaDestruye> getSiiEmpresaDestruyeUsuarioConList(){
        return siiEmpresaDestruyeUsuarioConList;
    }

    public void setSiiEmpresaDestruyeUsuarioConList(List<SiiEmpresaDestruye> siiEmpresaDestruyeUsuarioConList){
        this.siiEmpresaDestruyeUsuarioConList = siiEmpresaDestruyeUsuarioConList;
    }

    public SiiEmpresaDestruye addSiiEmpresaDestruye(SiiEmpresaDestruye siiEmpresaDestruye){
        getSiiEmpresaDestruyeUsuarioConList().add(siiEmpresaDestruye);
        siiEmpresaDestruye.setSiiUsuarioConect(this);
        return siiEmpresaDestruye;
    }

    public SiiEmpresaDestruye removeSiiEmpresaDestruye(SiiEmpresaDestruye siiEmpresaDestruye){
        getSiiEmpresaDestruyeUsuarioConList().remove(siiEmpresaDestruye);
        siiEmpresaDestruye.setSiiUsuarioConect(null);
        return siiEmpresaDestruye;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiResolucionDesisSolAut> getSiiResolucionDesisSolAutUsuConectList(){
        return siiResolucionDesisSolAutUsuConectList;
    }

    public void setSiiResolucionDesisSolAutUsuConectList(List<SiiResolucionDesisSolAut> siiResolucionDesisSolAutUsuConectList){
        this.siiResolucionDesisSolAutUsuConectList = siiResolucionDesisSolAutUsuConectList;
    }

    public SiiResolucionDesisSolAut addSiiResolucionDesisSolAut(SiiResolucionDesisSolAut siiResolucionDesisSolAut){
        getSiiResolucionDesisSolAutUsuConectList().add(siiResolucionDesisSolAut);
        siiResolucionDesisSolAut.setSiiUsuarioConect(this);
        return siiResolucionDesisSolAut;
    }

    public SiiResolucionDesisSolAut removeSiiResolucionDesisSolAut(SiiResolucionDesisSolAut siiResolucionDesisSolAut){
        getSiiResolucionDesisSolAutUsuConectList().remove(siiResolucionDesisSolAut);
        siiResolucionDesisSolAut.setSiiUsuarioConect(null);
        return siiResolucionDesisSolAut;
    }

    @OneToMany(mappedBy = "siiUsuarioConect")
    public List<SiiInventarioResolDesis> getSiiInventarioResolDesisUsuConectList(){
        return siiInventarioResolDesisUsuConectList;
    }

    public void setSiiInventarioResolDesisUsuConectList(List<SiiInventarioResolDesis> siiInventarioResolDesisUsuConectList){
        this.siiInventarioResolDesisUsuConectList = siiInventarioResolDesisUsuConectList;
    }

    public SiiInventarioResolDesis addSiiInventarioResolDesis(SiiInventarioResolDesis siiInventarioResolDesis){
        getSiiInventarioResolDesisUsuConectList().add(siiInventarioResolDesis);
        siiInventarioResolDesis.setSiiUsuarioConect(this);
        return siiInventarioResolDesis;
    }

    public SiiInventarioResolDesis removeSiiInventarioResolDesis(SiiInventarioResolDesis siiInventarioResolDesis){
        getSiiInventarioResolDesisUsuConectList().remove(siiInventarioResolDesis);
        siiInventarioResolDesis.setSiiUsuarioConect(null);
        return siiInventarioResolDesis;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiDireccion> getSiiDireccionUsuConecList() {
        return siiDireccionUsuConecList;
    }

    public void setSiiDireccionUsuConecList(List<SiiDireccion> siiDireccionUsuConecList) {
        this.siiDireccionUsuConecList = siiDireccionUsuConecList;
    }

    public SiiDireccion addSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionUsuConecList().add(siiDireccion);
        siiDireccion.setSiiUsuarioConec(this);
        return siiDireccion;
    }

    public SiiDireccion removeSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionUsuConecList().remove(siiDireccion);
        siiDireccion.setSiiUsuarioConec(null);
        return siiDireccion;
    }

    @OneToMany(mappedBy = "siiUsuarioConectado")
    public List<SiiPagoCargaActAdm> getSiiPagoCargaActAdmUsuConecList() {
        return siiPagoCargaActAdmUsuConecList;
    }

    public void setSiiPagoCargaActAdmUsuConecList(List<SiiPagoCargaActAdm> siiPagoCargaActAdmUsuConecList) {
        this.siiPagoCargaActAdmUsuConecList = siiPagoCargaActAdmUsuConecList;
    }

    public SiiPagoCargaActAdm addSiiPagoCargaActAdm(SiiPagoCargaActAdm siiPagoCargaActAdm) {
        getSiiPagoCargaActAdmUsuConecList().add(siiPagoCargaActAdm);
        siiPagoCargaActAdm.setSiiUsuarioConectado(this);
        return siiPagoCargaActAdm;
    }

    public SiiPagoCargaActAdm removeSiiPagoCargaActAdm(SiiPagoCargaActAdm siiPagoCargaActAdm) {
        getSiiPagoCargaActAdmUsuConecList().remove(siiPagoCargaActAdm);
        siiPagoCargaActAdm.setSiiUsuarioConectado(null);
        return siiPagoCargaActAdm;
    }

    @OneToMany(mappedBy = "siiUsuarioConectado")
    public List<SiiAjusteContCarAct> getSiiAjusteContCarActUsuConList() {
        return siiAjusteContCarActUsuConList;
    }

    public void setSiiAjusteContCarActUsuConList(List<SiiAjusteContCarAct> siiAjusteContCarActUsuConList) {
        this.siiAjusteContCarActUsuConList = siiAjusteContCarActUsuConList;
    }

    public SiiAjusteContCarAct addSiiAjusteContCarAct(SiiAjusteContCarAct siiAjusteContCarAct) {
        getSiiAjusteContCarActUsuConList().add(siiAjusteContCarAct);
        siiAjusteContCarAct.setSiiUsuarioConectado(this);
        return siiAjusteContCarAct;
    }

    public SiiAjusteContCarAct removeSiiAjusteContCarAct(SiiAjusteContCarAct siiAjusteContCarAct) {
        getSiiAjusteContCarActUsuConList().remove(siiAjusteContCarAct);
        siiAjusteContCarAct.setSiiUsuarioConectado(null);
        return siiAjusteContCarAct;
    }

    @OneToMany(mappedBy = "siiUsuarioConectado")
    public List<SiiEstablecConCuoCar> getSiiEstablecConCuoCarUsuConList() {
        return siiEstablecConCuoCarUsuConList;
    }

    public void setSiiEstablecConCuoCarUsuConList(List<SiiEstablecConCuoCar> siiEstablecConCuoCarUsuConList) {
        this.siiEstablecConCuoCarUsuConList = siiEstablecConCuoCarUsuConList;
    }

    public SiiEstablecConCuoCar addSiiEstablecConCuoCar(SiiEstablecConCuoCar siiEstablecConCuoCar) {
        getSiiEstablecConCuoCarUsuConList().add(siiEstablecConCuoCar);
        siiEstablecConCuoCar.setSiiUsuarioConectado(this);
        return siiEstablecConCuoCar;
    }

    public SiiEstablecConCuoCar removeSiiEstablecConCuoCar(SiiEstablecConCuoCar siiEstablecConCuoCar) {
        getSiiEstablecConCuoCarUsuConList().remove(siiEstablecConCuoCar);
        siiEstablecConCuoCar.setSiiUsuarioConectado(null);
        return siiEstablecConCuoCar;
    }

    @OneToMany(mappedBy = "siiUsuarioConectado")
    public List<SiiConceptoProyeccionCar> getSiiConceptoProyeccionCarUsuConList() {
        return siiConceptoProyeccionCarUsuConList;
    }

    public void setSiiConceptoProyeccionCarUsuConList(List<SiiConceptoProyeccionCar> siiConceptoProyeccionCarUsuConList) {
        this.siiConceptoProyeccionCarUsuConList = siiConceptoProyeccionCarUsuConList;
    }

    public SiiConceptoProyeccionCar addSiiConceptoProyeccionCar(SiiConceptoProyeccionCar siiConceptoProyeccionCar) {
        getSiiConceptoProyeccionCarUsuConList().add(siiConceptoProyeccionCar);
        siiConceptoProyeccionCar.setSiiUsuarioConectado(this);
        return siiConceptoProyeccionCar;
    }

    public SiiConceptoProyeccionCar removeSiiConceptoProyeccionCar(SiiConceptoProyeccionCar siiConceptoProyeccionCar) {
        getSiiConceptoProyeccionCarUsuConList().remove(siiConceptoProyeccionCar);
        siiConceptoProyeccionCar.setSiiUsuarioConectado(null);
        return siiConceptoProyeccionCar;
    }

    @OneToMany(mappedBy = "siiUsuarioConectado")
    public List<SiiConcepCuotCarActAdm> getSiiConcepCuotCarActAdmUsuConList() {
        return siiConcepCuotCarActAdmUsuConList;
    }

    public void setSiiConcepCuotCarActAdmUsuConList(List<SiiConcepCuotCarActAdm> siiConcepCuotCarActAdmUsuConList) {
        this.siiConcepCuotCarActAdmUsuConList = siiConcepCuotCarActAdmUsuConList;
    }

    public SiiConcepCuotCarActAdm addSiiConcepCuotCarActAdm(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm) {
        getSiiConcepCuotCarActAdmUsuConList().add(siiConcepCuotCarActAdm);
        siiConcepCuotCarActAdm.setSiiUsuarioConectado(this);
        return siiConcepCuotCarActAdm;
    }

    public SiiConcepCuotCarActAdm removeSiiConcepCuotCarActAdm(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm) {
        getSiiConcepCuotCarActAdmUsuConList().remove(siiConcepCuotCarActAdm);
        siiConcepCuotCarActAdm.setSiiUsuarioConectado(null);
        return siiConcepCuotCarActAdm;
    }

    @OneToMany(mappedBy = "siiUsuarioConectado")
    public List<SiiCargaActuacionesAdm> getSiiCargaActuacionesAdmUsuConList() {
        return siiCargaActuacionesAdmUsuConList;
    }

    public void setSiiCargaActuacionesAdmUsuConList(List<SiiCargaActuacionesAdm> siiCargaActuacionesAdmUsuConList) {
        this.siiCargaActuacionesAdmUsuConList = siiCargaActuacionesAdmUsuConList;
    }

    public SiiCargaActuacionesAdm addSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmUsuConList().add(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiUsuarioConectado(this);
        return siiCargaActuacionesAdm;
    }

    public SiiCargaActuacionesAdm removeSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        getSiiCargaActuacionesAdmUsuConList().remove(siiCargaActuacionesAdm);
        siiCargaActuacionesAdm.setSiiUsuarioConectado(null);
        return siiCargaActuacionesAdm;
    }

    @OneToMany(mappedBy = "siiUsuarioConectado")
    public List<SiiProyeccionCargaAct> getSiiProyeccionCargaActUsuConList() {
        return siiProyeccionCargaActUsuConList;
    }

    public void setSiiProyeccionCargaActUsuConList(List<SiiProyeccionCargaAct> siiProyeccionCargaActUsuConList) {
        this.siiProyeccionCargaActUsuConList = siiProyeccionCargaActUsuConList;
    }

    public SiiProyeccionCargaAct addSiiProyeccionCargaAct(SiiProyeccionCargaAct siiProyeccionCargaAct) {
        getSiiProyeccionCargaActUsuConList().add(siiProyeccionCargaAct);
        siiProyeccionCargaAct.setSiiUsuarioConectado(this);
        return siiProyeccionCargaAct;
    }

    public SiiProyeccionCargaAct removeSiiProyeccionCargaAct(SiiProyeccionCargaAct siiProyeccionCargaAct) {
        getSiiProyeccionCargaActUsuConList().remove(siiProyeccionCargaAct);
        siiProyeccionCargaAct.setSiiUsuarioConectado(null);
        return siiProyeccionCargaAct;
    }

    @OneToMany(mappedBy = "siiUsuarioRegistra")
    public List<SiiProcesoSancionatorio> getSiiProcesoSancionatorioUsuRegList() {
        return siiProcesoSancionatorioUsuRegList;
    }

    public void setSiiProcesoSancionatorioUsuRegList(List<SiiProcesoSancionatorio> siiProcesoSancionatorioUsuRegList) {
        this.siiProcesoSancionatorioUsuRegList = siiProcesoSancionatorioUsuRegList;
    }

    public SiiProcesoSancionatorio addSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioUsuRegList().add(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiUsuarioRegistra(this);
        return siiProcesoSancionatorio;
    }

    public SiiProcesoSancionatorio removeSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        getSiiProcesoSancionatorioUsuRegList().remove(siiProcesoSancionatorio);
        siiProcesoSancionatorio.setSiiUsuarioRegistra(null);
        return siiProcesoSancionatorio;
    }

    @OneToMany(mappedBy = "siiUsuarioRegistra")
    public List<SiiIncumplimientoContr> getSiiIncumplimientoContrUsuRegList() {
        return siiIncumplimientoContrUsuRegList;
    }

    public void setSiiIncumplimientoContrUsuRegList(List<SiiIncumplimientoContr> siiIncumplimientoContrUsuRegList) {
        this.siiIncumplimientoContrUsuRegList = siiIncumplimientoContrUsuRegList;
    }

    public SiiIncumplimientoContr addSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrUsuRegList().add(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiUsuarioRegistra(this);
        return siiIncumplimientoContr;
    }

    public SiiIncumplimientoContr removeSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrUsuRegList().remove(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiUsuarioRegistra(null);
        return siiIncumplimientoContr;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiDescargoProcIleg> getSiiDescargoProcIlegList() {
        return siiDescargoProcIlegList;
    }

    public void setSiiDescargoProcIlegList(List<SiiDescargoProcIleg> siiDescargoProcIlegList) {
        this.siiDescargoProcIlegList = siiDescargoProcIlegList;
    }

    public SiiDescargoProcIleg addSiiDescargoProcIleg(SiiDescargoProcIleg siiDescargoProcIleg) {
        getSiiDescargoProcIlegList().add(siiDescargoProcIleg);
        siiDescargoProcIleg.setSiiUsuario(this);
        return siiDescargoProcIleg;
    }

    public SiiDescargoProcIleg removeSiiDescargoProcIleg(SiiDescargoProcIleg siiDescargoProcIleg) {
        getSiiDescargoProcIlegList().remove(siiDescargoProcIleg);
        siiDescargoProcIleg.setSiiUsuario(null);
        return siiDescargoProcIleg;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiPruebaAutoDecrPru> getSiiPruebaAutoDecrPruUsuConecList() {
        return siiPruebaAutoDecrPruUsuConecList;
    }

    public void setSiiPruebaAutoDecrPruUsuConecList(List<SiiPruebaAutoDecrPru> siiPruebaAutoDecrPruUsuConecList) {
        this.siiPruebaAutoDecrPruUsuConecList = siiPruebaAutoDecrPruUsuConecList;
    }

    public SiiPruebaAutoDecrPru addSiiPruebaAutoDecrPru(SiiPruebaAutoDecrPru siiPruebaAutoDecrPru) {
        getSiiPruebaAutoDecrPruUsuConecList().add(siiPruebaAutoDecrPru);
        siiPruebaAutoDecrPru.setSiiUsuarioConec(this);
        return siiPruebaAutoDecrPru;
    }

    public SiiPruebaAutoDecrPru removeSiiPruebaAutoDecrPru(SiiPruebaAutoDecrPru siiPruebaAutoDecrPru) {
        getSiiPruebaAutoDecrPruUsuConecList().remove(siiPruebaAutoDecrPru);
        siiPruebaAutoDecrPru.setSiiUsuarioConec(null);
        return siiPruebaAutoDecrPru;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiAutoFormCargProIle> getSiiAutoFormCargProIleUsuConecList() {
        return siiAutoFormCargProIleUsuConecList;
    }

    public void setSiiAutoFormCargProIleUsuConecList(List<SiiAutoFormCargProIle> siiAutoFormCargProIleUsuConecList) {
        this.siiAutoFormCargProIleUsuConecList = siiAutoFormCargProIleUsuConecList;
    }

    public SiiAutoFormCargProIle addSiiAutoFormCargProIle(SiiAutoFormCargProIle siiAutoFormCargProIle) {
        getSiiAutoFormCargProIleUsuConecList().add(siiAutoFormCargProIle);
        siiAutoFormCargProIle.setSiiUsuarioConec(this);
        return siiAutoFormCargProIle;
    }

    public SiiAutoFormCargProIle removeSiiAutoFormCargProIle(SiiAutoFormCargProIle siiAutoFormCargProIle) {
        getSiiAutoFormCargProIleUsuConecList().remove(siiAutoFormCargProIle);
        siiAutoFormCargProIle.setSiiUsuarioConec(null);
        return siiAutoFormCargProIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiPersonaInvProIleAuto> getSiiPersonaInvProIleAutoUsuConecList() {
        return siiPersonaInvProIleAutoUsuConecList;
    }

    public void setSiiPersonaInvProIleAutoUsuConecList(List<SiiPersonaInvProIleAuto> siiPersonaInvProIleAutoUsuConecList) {
        this.siiPersonaInvProIleAutoUsuConecList = siiPersonaInvProIleAutoUsuConecList;
    }

    public SiiPersonaInvProIleAuto addSiiPersonaInvProIleAuto(SiiPersonaInvProIleAuto siiPersonaInvProIleAuto) {
        getSiiPersonaInvProIleAutoUsuConecList().add(siiPersonaInvProIleAuto);
        siiPersonaInvProIleAuto.setSiiUsuarioConec(this);
        return siiPersonaInvProIleAuto;
    }

    public SiiPersonaInvProIleAuto removeSiiPersonaInvProIleAuto(SiiPersonaInvProIleAuto siiPersonaInvProIleAuto) {
        getSiiPersonaInvProIleAutoUsuConecList().remove(siiPersonaInvProIleAuto);
        siiPersonaInvProIleAuto.setSiiUsuarioConec(null);
        return siiPersonaInvProIleAuto;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiPersonaInvestProIle> getSiiPersonaInvestProIleUsuConecList() {
        return siiPersonaInvestProIleUsuConecList;
    }

    public void setSiiPersonaInvestProIleUsuConecList(List<SiiPersonaInvestProIle> siiPersonaInvestProIleUsuConecList) {
        this.siiPersonaInvestProIleUsuConecList = siiPersonaInvestProIleUsuConecList;
    }

    public SiiPersonaInvestProIle addSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        getSiiPersonaInvestProIleUsuConecList().add(siiPersonaInvestProIle);
        siiPersonaInvestProIle.setSiiUsuarioConec(this);
        return siiPersonaInvestProIle;
    }

    public SiiPersonaInvestProIle removeSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        getSiiPersonaInvestProIleUsuConecList().remove(siiPersonaInvestProIle);
        siiPersonaInvestProIle.setSiiUsuarioConec(null);
        return siiPersonaInvestProIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiTramiteResolProIle> getSiiTramiteResolProIleUsuConecList() {
        return siiTramiteResolProIleUsuConecList;
    }

    public void setSiiTramiteResolProIleUsuConecList(List<SiiTramiteResolProIle> siiTramiteResolProIleUsuConecList) {
        this.siiTramiteResolProIleUsuConecList = siiTramiteResolProIleUsuConecList;
    }

    public SiiTramiteResolProIle addSiiTramiteResolProIle(SiiTramiteResolProIle siiTramiteResolProIle) {
        getSiiTramiteResolProIleUsuConecList().add(siiTramiteResolProIle);
        siiTramiteResolProIle.setSiiUsuarioConec(this);
        return siiTramiteResolProIle;
    }

    public SiiTramiteResolProIle removeSiiTramiteResolProIle(SiiTramiteResolProIle siiTramiteResolProIle) {
        getSiiTramiteResolProIleUsuConecList().remove(siiTramiteResolProIle);
        siiTramiteResolProIle.setSiiUsuarioConec(null);
        return siiTramiteResolProIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiResolucionProcIleg> getSiiResolucionProcIlegUsuConecList() {
        return siiResolucionProcIlegUsuConecList;
    }

    public void setSiiResolucionProcIlegUsuConecList(List<SiiResolucionProcIleg> siiResolucionProcIlegUsuConecList) {
        this.siiResolucionProcIlegUsuConecList = siiResolucionProcIlegUsuConecList;
    }

    public SiiResolucionProcIleg addSiiResolucionProcIleg(SiiResolucionProcIleg siiResolucionProcIleg) {
        getSiiResolucionProcIlegUsuConecList().add(siiResolucionProcIleg);
        siiResolucionProcIleg.setSiiUsuarioConec(this);
        return siiResolucionProcIleg;
    }

    public SiiResolucionProcIleg removeSiiResolucionProcIleg(SiiResolucionProcIleg siiResolucionProcIleg) {
        getSiiResolucionProcIlegUsuConecList().remove(siiResolucionProcIleg);
        siiResolucionProcIleg.setSiiUsuarioConec(null);
        return siiResolucionProcIleg;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiDireccionPersona> getSiiDireccionPersonaUsuConecList() {
        return siiDireccionPersonaUsuConecList;
    }

    public void setSiiDireccionPersonaUsuConecList(List<SiiDireccionPersona> siiDireccionPersonaUsuConecList) {
        this.siiDireccionPersonaUsuConecList = siiDireccionPersonaUsuConecList;
    }

    public SiiDireccionPersona addSiiDireccionPersona(SiiDireccionPersona siiDireccionPersona) {
        getSiiDireccionPersonaUsuConecList().add(siiDireccionPersona);
        siiDireccionPersona.setSiiUsuarioConec(this);
        return siiDireccionPersona;
    }

    public SiiDireccionPersona removeSiiDireccionPersona(SiiDireccionPersona siiDireccionPersona) {
        getSiiDireccionPersonaUsuConecList().remove(siiDireccionPersona);
        siiDireccionPersona.setSiiUsuarioConec(null);
        return siiDireccionPersona;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiComunicResolPersIle> getSiiComunicResolPersIleUsuConecList() {
        return siiComunicResolPersIleUsuConecList;
    }

    public void setSiiComunicResolPersIleUsuConecList(List<SiiComunicResolPersIle> siiComunicResolPersIleUsuConecList) {
        this.siiComunicResolPersIleUsuConecList = siiComunicResolPersIleUsuConecList;
    }

    public SiiComunicResolPersIle addSiiComunicResolPersIle(SiiComunicResolPersIle siiComunicResolPersIle) {
        getSiiComunicResolPersIleUsuConecList().add(siiComunicResolPersIle);
        siiComunicResolPersIle.setSiiUsuarioConec(this);
        return siiComunicResolPersIle;
    }

    public SiiComunicResolPersIle removeSiiComunicResolPersIle(SiiComunicResolPersIle siiComunicResolPersIle) {
        getSiiComunicResolPersIleUsuConecList().remove(siiComunicResolPersIle);
        siiComunicResolPersIle.setSiiUsuarioConec(null);
        return siiComunicResolPersIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiAutoDecretaPrueProIle> getSiiAutoDecretaPrueProIleUsuConList() {
        return siiAutoDecretaPrueProIleUsuConList;
    }

    public void setSiiAutoDecretaPrueProIleUsuConList(List<SiiAutoDecretaPrueProIle> siiAutoDecretaPrueProIleUsuConList) {
        this.siiAutoDecretaPrueProIleUsuConList = siiAutoDecretaPrueProIleUsuConList;
    }

    public SiiAutoDecretaPrueProIle addSiiAutoDecretaPrueProIle(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle) {
        getSiiAutoDecretaPrueProIleUsuConList().add(siiAutoDecretaPrueProIle);
        siiAutoDecretaPrueProIle.setSiiUsuarioConec(this);
        return siiAutoDecretaPrueProIle;
    }

    public SiiAutoDecretaPrueProIle removeSiiAutoDecretaPrueProIle(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle) {
        getSiiAutoDecretaPrueProIleUsuConList().remove(siiAutoDecretaPrueProIle);
        siiAutoDecretaPrueProIle.setSiiUsuarioConec(null);
        return siiAutoDecretaPrueProIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiTramiteAutoPrueTras> getSiiTramiteAutoPrueTrasUsuConList() {
        return siiTramiteAutoPrueTrasUsuConList;
    }

    public void setSiiTramiteAutoPrueTrasUsuConList(List<SiiTramiteAutoPrueTras> siiTramiteAutoPrueTrasUsuConList) {
        this.siiTramiteAutoPrueTrasUsuConList = siiTramiteAutoPrueTrasUsuConList;
    }

    public SiiTramiteAutoPrueTras addSiiTramiteAutoPrueTras(SiiTramiteAutoPrueTras siiTramiteAutoPrueTras) {
        getSiiTramiteAutoPrueTrasUsuConList().add(siiTramiteAutoPrueTras);
        siiTramiteAutoPrueTras.setSiiUsuarioConec(this);
        return siiTramiteAutoPrueTras;
    }

    public SiiTramiteAutoPrueTras removeSiiTramiteAutoPrueTras(SiiTramiteAutoPrueTras siiTramiteAutoPrueTras) {
        getSiiTramiteAutoPrueTrasUsuConList().remove(siiTramiteAutoPrueTras);
        siiTramiteAutoPrueTras.setSiiUsuarioConec(null);
        return siiTramiteAutoPrueTras;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiTramiteAutoForCarIle> getSiiTramiteAutoForCarIleUsuConList() {
        return siiTramiteAutoForCarIleUsuConList;
    }

    public void setSiiTramiteAutoForCarIleUsuConList(List<SiiTramiteAutoForCarIle> siiTramiteAutoForCarIleUsuConList) {
        this.siiTramiteAutoForCarIleUsuConList = siiTramiteAutoForCarIleUsuConList;
    }

    public SiiTramiteAutoForCarIle addSiiTramiteAutoForCarIle(SiiTramiteAutoForCarIle siiTramiteAutoForCarIle) {
        getSiiTramiteAutoForCarIleUsuConList().add(siiTramiteAutoForCarIle);
        siiTramiteAutoForCarIle.setSiiUsuarioConec(this);
        return siiTramiteAutoForCarIle;
    }

    public SiiTramiteAutoForCarIle removeSiiTramiteAutoForCarIle(SiiTramiteAutoForCarIle siiTramiteAutoForCarIle) {
        getSiiTramiteAutoForCarIleUsuConList().remove(siiTramiteAutoForCarIle);
        siiTramiteAutoForCarIle.setSiiUsuarioConec(null);
        return siiTramiteAutoForCarIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiProcesoSancIlegalidad> getSiiProcesoSancIlegalidadUsuConList() {
        return siiProcesoSancIlegalidadUsuConList;
    }

    public void setSiiProcesoSancIlegalidadUsuConList(List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadUsuConList) {
        this.siiProcesoSancIlegalidadUsuConList = siiProcesoSancIlegalidadUsuConList;
    }

    public SiiProcesoSancIlegalidad addSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        getSiiProcesoSancIlegalidadUsuConList().add(siiProcesoSancIlegalidad);
        siiProcesoSancIlegalidad.setSiiUsuarioConec(this);
        return siiProcesoSancIlegalidad;
    }

    public SiiProcesoSancIlegalidad removeSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        getSiiProcesoSancIlegalidadUsuConList().remove(siiProcesoSancIlegalidad);
        siiProcesoSancIlegalidad.setSiiUsuarioConec(null);
        return siiProcesoSancIlegalidad;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiDireccionProcePerIle> getSiiDireccionProcePerIleUsuConList() {
        return siiDireccionProcePerIleUsuConList;
    }

    public void setSiiDireccionProcePerIleUsuConList(List<SiiDireccionProcePerIle> siiDireccionProcePerIleUsuConList) {
        this.siiDireccionProcePerIleUsuConList = siiDireccionProcePerIleUsuConList;
    }

    public SiiDireccionProcePerIle addSiiDireccionProcePerIle(SiiDireccionProcePerIle siiDireccionProcePerIle) {
        getSiiDireccionProcePerIleUsuConList().add(siiDireccionProcePerIle);
        siiDireccionProcePerIle.setSiiUsuarioConec(this);
        return siiDireccionProcePerIle;
    }

    public SiiDireccionProcePerIle removeSiiDireccionProcePerIle(SiiDireccionProcePerIle siiDireccionProcePerIle) {
        getSiiDireccionProcePerIleUsuConList().remove(siiDireccionProcePerIle);
        siiDireccionProcePerIle.setSiiUsuarioConec(null);
        return siiDireccionProcePerIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiComunicacSujSancIle> getSiiComunicacSujSancIleUsuConList() {
        return siiComunicacSujSancIleUsuConList;
    }

    public void setSiiComunicacSujSancIleUsuConList(List<SiiComunicacSujSancIle> siiComunicacSujSancIleUsuConList) {
        this.siiComunicacSujSancIleUsuConList = siiComunicacSujSancIleUsuConList;
    }

    public SiiComunicacSujSancIle addSiiComunicacSujSancIle(SiiComunicacSujSancIle siiComunicacSujSancIle) {
        getSiiComunicacSujSancIleUsuConList().add(siiComunicacSujSancIle);
        siiComunicacSujSancIle.setSiiUsuarioConec(this);
        return siiComunicacSujSancIle;
    }

    public SiiComunicacSujSancIle removeSiiComunicacSujSancIle(SiiComunicacSujSancIle siiComunicacSujSancIle) {
        getSiiComunicacSujSancIleUsuConList().remove(siiComunicacSujSancIle);
        siiComunicacSujSancIle.setSiiUsuarioConec(null);
        return siiComunicacSujSancIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiInhabilidadPersona> getSiiInhabilidadPersonaUsuConList() {
        return siiInhabilidadPersonaUsuConList;
    }

    public void setSiiInhabilidadPersonaUsuConList(List<SiiInhabilidadPersona> siiInhabilidadPersonaUsuConList) {
        this.siiInhabilidadPersonaUsuConList = siiInhabilidadPersonaUsuConList;
    }

    public SiiInhabilidadPersona addSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaUsuConList().add(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiUsuarioConec(this);
        return siiInhabilidadPersona;
    }

    public SiiInhabilidadPersona removeSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaUsuConList().remove(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiUsuarioConec(null);
        return siiInhabilidadPersona;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiTasaInteres> getSiiTasaInteresUsuConList() {
        return siiTasaInteresUsuConList;
    }

    public void setSiiTasaInteresUsuConList(List<SiiTasaInteres> siiTasaInteresUsuConList) {
        this.siiTasaInteresUsuConList = siiTasaInteresUsuConList;
    }

    public SiiTasaInteres addSiiTasaInteres(SiiTasaInteres siiTasaInteres) {
        getSiiTasaInteresUsuConList().add(siiTasaInteres);
        siiTasaInteres.setSiiUsuarioConec(this);
        return siiTasaInteres;
    }

    public SiiTasaInteres removeSiiTasaInteres(SiiTasaInteres siiTasaInteres) {
        getSiiTasaInteresUsuConList().remove(siiTasaInteres);
        siiTasaInteres.setSiiUsuarioConec(null);
        return siiTasaInteres;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiRecepcionAlegatoProSan> getSiiRecepcionAlegatoProSanUsuConList() {
        return siiRecepcionAlegatoProSanUsuConList;
    }

    public void setSiiRecepcionAlegatoProSanUsuConList(List<SiiRecepcionAlegatoProSan> siiRecepcionAlegatoProSanUsuConList) {
        this.siiRecepcionAlegatoProSanUsuConList = siiRecepcionAlegatoProSanUsuConList;
    }

    public SiiRecepcionAlegatoProSan addSiiRecepcionAlegatoProSan(SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan) {
        getSiiRecepcionAlegatoProSanUsuConList().add(siiRecepcionAlegatoProSan);
        siiRecepcionAlegatoProSan.setSiiUsuarioConec(this);
        return siiRecepcionAlegatoProSan;
    }

    public SiiRecepcionAlegatoProSan removeSiiRecepcionAlegatoProSan(SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan) {
        getSiiRecepcionAlegatoProSanUsuConList().remove(siiRecepcionAlegatoProSan);
        siiRecepcionAlegatoProSan.setSiiUsuarioConec(null);
        return siiRecepcionAlegatoProSan;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiLogActividad> getSiiLogActividadList() {
        return siiLogActividadList;
    }

    public void setSiiLogActividadList(List<SiiLogActividad> siiLogActividadList) {
        this.siiLogActividadList = siiLogActividadList;
    }

    public SiiLogActividad addSiiLogActividad(SiiLogActividad siiLogActividad) {
        getSiiLogActividadList().add(siiLogActividad);
        siiLogActividad.setSiiUsuario(this);
        return siiLogActividad;
    }

    public SiiLogActividad removeSiiLogActividad(SiiLogActividad siiLogActividad) {
        getSiiLogActividadList().remove(siiLogActividad);
        siiLogActividad.setSiiUsuario(null);
        return siiLogActividad;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiEnteTerritorial> getSiiEnteTerritorialUsuConList() {
        return siiEnteTerritorialUsuConList;
    }

    public void setSiiEnteTerritorialUsuConList(List<SiiEnteTerritorial> siiEnteTerritorialUsuConList) {
        this.siiEnteTerritorialUsuConList = siiEnteTerritorialUsuConList;
    }

    public SiiEnteTerritorial addSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        getSiiEnteTerritorialUsuConList().add(siiEnteTerritorial);
        siiEnteTerritorial.setSiiUsuarioConec(this);
        return siiEnteTerritorial;
    }

    public SiiEnteTerritorial removeSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        getSiiEnteTerritorialUsuConList().remove(siiEnteTerritorial);
        siiEnteTerritorial.setSiiUsuarioConec(null);
        return siiEnteTerritorial;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiPoblacionEnte> getSiiPoblacionEnteUsuConList() {
        return siiPoblacionEnteUsuConList;
    }

    public void setSiiPoblacionEnteUsuConList(List<SiiPoblacionEnte> siiPoblacionEnteUsuConList) {
        this.siiPoblacionEnteUsuConList = siiPoblacionEnteUsuConList;
    }

    public SiiPoblacionEnte addSiiPoblacionEnte(SiiPoblacionEnte siiPoblacionEnte) {
        getSiiPoblacionEnteUsuConList().add(siiPoblacionEnte);
        siiPoblacionEnte.setSiiUsuarioConec(this);
        return siiPoblacionEnte;
    }

    public SiiPoblacionEnte removeSiiPoblacionEnte(SiiPoblacionEnte siiPoblacionEnte) {
        getSiiPoblacionEnteUsuConList().remove(siiPoblacionEnte);
        siiPoblacionEnte.setSiiUsuarioConec(null);
        return siiPoblacionEnte;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiCargaPoblacion> getSiiCargaPoblacionUsuConList() {
        return siiCargaPoblacionUsuConList;
    }

    public void setSiiCargaPoblacionUsuConList(List<SiiCargaPoblacion> siiCargaPoblacionUsuConList) {
        this.siiCargaPoblacionUsuConList = siiCargaPoblacionUsuConList;
    }

    public SiiCargaPoblacion addSiiCargaPoblacion(SiiCargaPoblacion siiCargaPoblacion) {
        getSiiCargaPoblacionUsuConList().add(siiCargaPoblacion);
        siiCargaPoblacion.setSiiUsuarioConec(this);
        return siiCargaPoblacion;
    }

    public SiiCargaPoblacion removeSiiCargaPoblacion(SiiCargaPoblacion siiCargaPoblacion) {
        getSiiCargaPoblacionUsuConList().remove(siiCargaPoblacion);
        siiCargaPoblacion.setSiiUsuarioConec(null);
        return siiCargaPoblacion;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiAbonoIniAcuerdoPago> getSiiAbonoIniAcuerdoPagoUsuConList() {
        return siiAbonoIniAcuerdoPagoUsuConList;
    }

    public void setSiiAbonoIniAcuerdoPagoUsuConList(List<SiiAbonoIniAcuerdoPago> siiAbonoIniAcuerdoPagoUsuConList) {
        this.siiAbonoIniAcuerdoPagoUsuConList = siiAbonoIniAcuerdoPagoUsuConList;
    }

    public SiiAbonoIniAcuerdoPago addSiiAbonoIniAcuerdoPago(SiiAbonoIniAcuerdoPago siiAbonoIniAcuerdoPago) {
        getSiiAbonoIniAcuerdoPagoUsuConList().add(siiAbonoIniAcuerdoPago);
        siiAbonoIniAcuerdoPago.setSiiUsuarioConec(this);
        return siiAbonoIniAcuerdoPago;
    }

    public SiiAbonoIniAcuerdoPago removeSiiAbonoIniAcuerdoPago(SiiAbonoIniAcuerdoPago siiAbonoIniAcuerdoPago) {
        getSiiAbonoIniAcuerdoPagoUsuConList().remove(siiAbonoIniAcuerdoPago);
        siiAbonoIniAcuerdoPago.setSiiUsuarioConec(null);
        return siiAbonoIniAcuerdoPago;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiItemPlanContratac> getSiiItemPlanContratacUsuConList() {
        return siiItemPlanContratacUsuConList;
    }

    public void setSiiItemPlanContratacUsuConList(List<SiiItemPlanContratac> siiItemPlanContratacUsuConList) {
        this.siiItemPlanContratacUsuConList = siiItemPlanContratacUsuConList;
    }

    public SiiItemPlanContratac addSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        getSiiItemPlanContratacUsuConList().add(siiItemPlanContratac);
        siiItemPlanContratac.setSiiUsuarioConec(this);
        return siiItemPlanContratac;
    }

    public SiiItemPlanContratac removeSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        getSiiItemPlanContratacUsuConList().remove(siiItemPlanContratac);
        siiItemPlanContratac.setSiiUsuarioConec(null);
        return siiItemPlanContratac;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiRpDetRubReintIngPag> getSiiRpDetRubReintIngPagUsuConList() {
        return siiRpDetRubReintIngPagUsuConList;
    }

    public void setSiiRpDetRubReintIngPagUsuConList(List<SiiRpDetRubReintIngPag> siiRpDetRubReintIngPagUsuConList) {
        this.siiRpDetRubReintIngPagUsuConList = siiRpDetRubReintIngPagUsuConList;
    }

    public SiiRpDetRubReintIngPag addSiiRpDetRubReintIngPag(SiiRpDetRubReintIngPag siiRpDetRubReintIngPag) {
        getSiiRpDetRubReintIngPagUsuConList().add(siiRpDetRubReintIngPag);
        siiRpDetRubReintIngPag.setSiiUsuarioConec(this);
        return siiRpDetRubReintIngPag;
    }

    public SiiRpDetRubReintIngPag removeSiiRpDetRubReintIngPag(SiiRpDetRubReintIngPag siiRpDetRubReintIngPag) {
        getSiiRpDetRubReintIngPagUsuConList().remove(siiRpDetRubReintIngPag);
        siiRpDetRubReintIngPag.setSiiUsuarioConec(null);
        return siiRpDetRubReintIngPag;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiModifEstadoDocContab> getSiiModifEstadoDocContabUsuConList() {
        return siiModifEstadoDocContabUsuConList;
    }

    public void setSiiModifEstadoDocContabUsuConList(List<SiiModifEstadoDocContab> siiModifEstadoDocContabUsuConList) {
        this.siiModifEstadoDocContabUsuConList = siiModifEstadoDocContabUsuConList;
    }

    public SiiModifEstadoDocContab addSiiModifEstadoDocContab(SiiModifEstadoDocContab siiModifEstadoDocContab) {
        getSiiModifEstadoDocContabUsuConList().add(siiModifEstadoDocContab);
        siiModifEstadoDocContab.setSiiUsuarioConec(this);
        return siiModifEstadoDocContab;
    }

    public SiiModifEstadoDocContab removeSiiModifEstadoDocContab(SiiModifEstadoDocContab siiModifEstadoDocContab) {
        getSiiModifEstadoDocContabUsuConList().remove(siiModifEstadoDocContab);
        siiModifEstadoDocContab.setSiiUsuarioConec(null);
        return siiModifEstadoDocContab;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiPerInvesProIleAutoPru> getSiiPerInvesProIleAutoPruUsuConList() {
        return siiPerInvesProIleAutoPruUsuConList;
    }

    public void setSiiPerInvesProIleAutoPruUsuConList(List<SiiPerInvesProIleAutoPru> siiPerInvesProIleAutoPruUsuConList) {
        this.siiPerInvesProIleAutoPruUsuConList = siiPerInvesProIleAutoPruUsuConList;
    }

    public SiiPerInvesProIleAutoPru addSiiPerInvesProIleAutoPru(SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru) {
        getSiiPerInvesProIleAutoPruUsuConList().add(siiPerInvesProIleAutoPru);
        siiPerInvesProIleAutoPru.setSiiUsuarioConec(this);
        return siiPerInvesProIleAutoPru;
    }

    public SiiPerInvesProIleAutoPru removeSiiPerInvesProIleAutoPru(SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru) {
        getSiiPerInvesProIleAutoPruUsuConList().remove(siiPerInvesProIleAutoPru);
        siiPerInvesProIleAutoPru.setSiiUsuarioConec(null);
        return siiPerInvesProIleAutoPru;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiPruebaDescargoProIle> getSiiPruebaDescargoProIleUsuConList() {
        return siiPruebaDescargoProIleUsuConList;
    }

    public void setSiiPruebaDescargoProIleUsuConList(List<SiiPruebaDescargoProIle> siiPruebaDescargoProIleUsuConList) {
        this.siiPruebaDescargoProIleUsuConList = siiPruebaDescargoProIleUsuConList;
    }

    public SiiPruebaDescargoProIle addSiiPruebaDescargoProIle(SiiPruebaDescargoProIle siiPruebaDescargoProIle) {
        getSiiPruebaDescargoProIleUsuConList().add(siiPruebaDescargoProIle);
        siiPruebaDescargoProIle.setSiiUsuarioConec(this);
        return siiPruebaDescargoProIle;
    }

    public SiiPruebaDescargoProIle removeSiiPruebaDescargoProIle(SiiPruebaDescargoProIle siiPruebaDescargoProIle) {
        getSiiPruebaDescargoProIleUsuConList().remove(siiPruebaDescargoProIle);
        siiPruebaDescargoProIle.setSiiUsuarioConec(null);
        return siiPruebaDescargoProIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiElementoProcesoIle> getSiiElementoProcesoIleUsuConList() {
        return siiElementoProcesoIleUsuConList;
    }

    public void setSiiElementoProcesoIleUsuConList(List<SiiElementoProcesoIle> siiElementoProcesoIleUsuConList) {
        this.siiElementoProcesoIleUsuConList = siiElementoProcesoIleUsuConList;
    }

    public SiiElementoProcesoIle addSiiElementoProcesoIle(SiiElementoProcesoIle siiElementoProcesoIle) {
        getSiiElementoProcesoIleUsuConList().add(siiElementoProcesoIle);
        siiElementoProcesoIle.setSiiUsuarioConec(this);
        return siiElementoProcesoIle;
    }

    public SiiElementoProcesoIle removeSiiElementoProcesoIle(SiiElementoProcesoIle siiElementoProcesoIle) {
        getSiiElementoProcesoIleUsuConList().remove(siiElementoProcesoIle);
        siiElementoProcesoIle.setSiiUsuarioConec(null);
        return siiElementoProcesoIle;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiTipoApuestPolizaRenovac> getSiiTipoApuestPolizaRenovacUsuConList() {
        return siiTipoApuestPolizaRenovacUsuConList;
    }

    public void setSiiTipoApuestPolizaRenovacUsuConList(List<SiiTipoApuestPolizaRenovac> siiTipoApuestPolizaRenovacUsuConList) {
        this.siiTipoApuestPolizaRenovacUsuConList = siiTipoApuestPolizaRenovacUsuConList;
    }

    public SiiTipoApuestPolizaRenovac addSiiTipoApuestPolizaRenovac(SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac) {
        getSiiTipoApuestPolizaRenovacUsuConList().add(siiTipoApuestPolizaRenovac);
        siiTipoApuestPolizaRenovac.setSiiUsuarioConec(this);
        return siiTipoApuestPolizaRenovac;
    }

    public SiiTipoApuestPolizaRenovac removeSiiTipoApuestPolizaRenovac(SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac) {
        getSiiTipoApuestPolizaRenovacUsuConList().remove(siiTipoApuestPolizaRenovac);
        siiTipoApuestPolizaRenovac.setSiiUsuarioConec(null);
        return siiTipoApuestPolizaRenovac;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiModificPresup> getSiiModificPresupUsuConList() {
        return siiModificPresupUsuConList;
    }

    public void setSiiModificPresupUsuConList(List<SiiModificPresup> siiModificPresupUsuConList) {
        this.siiModificPresupUsuConList = siiModificPresupUsuConList;
    }

    public SiiModificPresup addSiiModificPresup(SiiModificPresup siiModificPresup) {
        getSiiModificPresupUsuConList().add(siiModificPresup);
        siiModificPresup.setSiiUsuarioConec(this);
        return siiModificPresup;
    }

    public SiiModificPresup removeSiiModificPresup(SiiModificPresup siiModificPresup) {
        getSiiModificPresupUsuConList().remove(siiModificPresup);
        siiModificPresup.setSiiUsuarioConec(null);
        return siiModificPresup;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiModPresDetRubro> getSiiModPresDetRubroUsuConList() {
        return siiModPresDetRubroUsuConList;
    }

    public void setSiiModPresDetRubroUsuConList(List<SiiModPresDetRubro> siiModPresDetRubroUsuConList) {
        this.siiModPresDetRubroUsuConList = siiModPresDetRubroUsuConList;
    }

    public SiiModPresDetRubro addSiiModPresDetRubro(SiiModPresDetRubro siiModPresDetRubro) {
        getSiiModPresDetRubroUsuConList().add(siiModPresDetRubro);
        siiModPresDetRubro.setSiiUsuarioConec(this);
        return siiModPresDetRubro;
    }

    public SiiModPresDetRubro removeSiiModPresDetRubro(SiiModPresDetRubro siiModPresDetRubro) {
        getSiiModPresDetRubroUsuConList().remove(siiModPresDetRubro);
        siiModPresDetRubro.setSiiUsuarioConec(null);
        return siiModPresDetRubro;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiHistorialPermiso> getSiiHistorialPermisoUsuConList() {
        return siiHistorialPermisoUsuConList;
    }

    public void setSiiHistorialPermisoUsuConList(List<SiiHistorialPermiso> siiHistorialPermisoUsuConList) {
        this.siiHistorialPermisoUsuConList = siiHistorialPermisoUsuConList;
    }

    public SiiHistorialPermiso addSiiHistorialPermiso(SiiHistorialPermiso siiHistorialPermiso) {
        getSiiHistorialPermisoUsuConList().add(siiHistorialPermiso);
        siiHistorialPermiso.setSiiUsuarioConec(this);
        return siiHistorialPermiso;
    }

    public SiiHistorialPermiso removeSiiHistorialPermiso(SiiHistorialPermiso siiHistorialPermiso) {
        getSiiHistorialPermisoUsuConList().remove(siiHistorialPermiso);
        siiHistorialPermiso.setSiiUsuarioConec(null);
        return siiHistorialPermiso;
    }

    @OneToMany(mappedBy = "siiUsuario")
    public List<SiiHistorialPermiso> getSiiHistorialPermisoList() {
        return siiHistorialPermisoList;
    }

    public void setSiiHistorialPermisoList(List<SiiHistorialPermiso> siiHistorialPermisoList) {
        this.siiHistorialPermisoList = siiHistorialPermisoList;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiHistorialRol> getSiiHistorialRolUsuConList() {
        return siiHistorialRolUsuConList;
    }

    public void setSiiHistorialRolUsuConList(List<SiiHistorialRol> siiHistorialRolUsuConList) {
        this.siiHistorialRolUsuConList = siiHistorialRolUsuConList;
    }

    public SiiHistorialRol addSiiHistorialRol(SiiHistorialRol siiHistorialRol) {
        getSiiHistorialRolUsuConList().add(siiHistorialRol);
        siiHistorialRol.setSiiUsuarioConec(this);
        return siiHistorialRol;
    }

    public SiiHistorialRol removeSiiHistorialRol(SiiHistorialRol siiHistorialRol) {
        getSiiHistorialRolUsuConList().remove(siiHistorialRol);
        siiHistorialRol.setSiiUsuarioConec(null);
        return siiHistorialRol;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiLogModificacion> getSiiLogModificacionUsuConList() {
        return siiLogModificacionUsuConList;
    }

    public void setSiiLogModificacionUsuConList(List<SiiLogModificacion> siiLogModificacionUsuConList) {
        this.siiLogModificacionUsuConList = siiLogModificacionUsuConList;
    }

    public SiiLogModificacion addSiiLogModificacion(SiiLogModificacion siiLogModificacion) {
        getSiiLogModificacionUsuConList().add(siiLogModificacion);
        siiLogModificacion.setSiiUsuarioConec(this);
        return siiLogModificacion;
    }

    public SiiLogModificacion removeSiiLogModificacion(SiiLogModificacion siiLogModificacion) {
        getSiiLogModificacionUsuConList().remove(siiLogModificacion);
        siiLogModificacion.setSiiUsuarioConec(null);
        return siiLogModificacion;
    }

    @OneToMany(mappedBy = "siiUsuarioConec")
    public List<SiiReintegroIngresoPag> getSiiReintegroIngresoPagUsuConList() {
        return siiReintegroIngresoPagUsuConList;
    }

    public void setSiiReintegroIngresoPagUsuConList(List<SiiReintegroIngresoPag> siiReintegroIngresoPagUsuConList) {
        this.siiReintegroIngresoPagUsuConList = siiReintegroIngresoPagUsuConList;
    }

    public SiiReintegroIngresoPag addSiiReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) {
        getSiiReintegroIngresoPagUsuConList().add(siiReintegroIngresoPag);
        siiReintegroIngresoPag.setSiiUsuarioConec(this);
        return siiReintegroIngresoPag;
    }

    public SiiReintegroIngresoPag removeSiiReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) {
        getSiiReintegroIngresoPagUsuConList().remove(siiReintegroIngresoPag);
        siiReintegroIngresoPag.setSiiUsuarioConec(null);
        return siiReintegroIngresoPag;
    }
}
