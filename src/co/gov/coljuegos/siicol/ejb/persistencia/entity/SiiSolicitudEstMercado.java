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
@Table(name = "SII_SOLICITUD_EST_MERCADO")
public class SiiSolicitudEstMercado implements Serializable {
    private static final long serialVersionUID = -8429877262560448220L;
    private String semCalidadEsperada;
    private Long semCodigo;
    private String semCotizacionesRecib;
    private String semEstandaresOblig;
    private Date semFechaDevol;
    private Date semFechaEstInicio;
    private Date semFechaRegistro;
    private String semInformacionFuncional;
    private String semInformacionTecnica;
    private String semNombreSupervExterno;
    private String semNumIdentifExterno;
    private String semObjetoContrato;
    private String semObligacionesContr;
    private String semObservaciones;
    private String semPerfilProveedor;
    private String semProductosEntregar;
    private String semResultadosEsperados;
    private String semRiesgosIdentif;
    private String semServiciosAdicionales;
    private Integer semTiempoEstimado;
    private String semTipoSupervisor;
    private String semUnidTiempoEstim;
    private Long semValorEstimado;
    private SiiTipoIdentificacion siiTipoIdentificacion;
    private SiiEstadoSolEstMercado siiEstadoSolEstMercado;
    private SiiArchivoFisico siiArchivoFisico;
    private SiiProcesoColjuegos siiProcesoColjuegos;
    private SiiUsuario siiUsuario2;
    private SiiAreaColjuegos siiAreaColjuegos;
    private SiiProcesoContratacion siiProcesoContratacion;
    private List<SiiItemSolicitud> siiItemSolicitudList;
    private SiiUbicacion siiUbicacion1;
    private SiiItemPlanContratac siiItemPlanContratac;
    private SiiMotivoDevolucion siiMotivoDevolucion;

    public SiiSolicitudEstMercado() {
    }

    public SiiSolicitudEstMercado(SiiAreaColjuegos siiAreaColjuegos, SiiArchivoFisico siiArchivoFisico,
                                  SiiItemPlanContratac siiItemPlanContratac,SiiProcesoContratacion siiProcesoContratacion,
								  SiiEstadoSolEstMercado siiEstadoSolEstMercado,
                                  Date semFechaDevol, SiiProcesoColjuegos siiProcesoColjuegos,
                                  String semCalidadEsperada, Long semCodigo,
                                  String semCotizacionesRecib, String semEstandaresOblig, Date semFechaEstInicio,
                                  Date semFechaRegistro, String semInformacionFuncional, String semInformacionTecnica,
                                  String semLugarEjecucion, String semNombreSupervExterno, String semNumIdentifExterno,
                                  String semObjetoContrato, String semObligacionesContr, String semPerfilProveedor,
                                  String semProductosEntregar, String semResultadosEsperados, String semRiesgosIdentif,
                                  String semServiciosAdicionales, Integer semTiempoEstimado, String semTipoSupervisor,
                                  String semUnidTiempoEstim, Long semValorEstimado, String semObservaciones,
                                  SiiTipoIdentificacion siiTipoIdentificacion, SiiUbicacion siiUbicacion1,
                                  SiiMotivoDevolucion siiMotivoDevolucion, SiiUsuario siiUsuario2) {
        this.siiAreaColjuegos = siiAreaColjuegos;
        this.siiArchivoFisico = siiArchivoFisico;
        this.siiEstadoSolEstMercado = siiEstadoSolEstMercado;
        this.siiItemPlanContratac = siiItemPlanContratac;
        this.siiProcesoColjuegos = siiProcesoColjuegos;
        this.siiProcesoContratacion = siiProcesoContratacion;
        this.semCalidadEsperada = semCalidadEsperada;
        this.semCodigo = semCodigo;
        this.semCotizacionesRecib = semCotizacionesRecib;
        this.semEstandaresOblig = semEstandaresOblig;
        this.semFechaDevol = semFechaDevol;
        this.semFechaEstInicio = semFechaEstInicio;
        this.semFechaRegistro = semFechaRegistro;
        this.semInformacionFuncional = semInformacionFuncional;
        this.semInformacionTecnica = semInformacionTecnica;
        this.semNombreSupervExterno = semNombreSupervExterno;
        this.semNumIdentifExterno = semNumIdentifExterno;
        this.semObjetoContrato = semObjetoContrato;
        this.semObligacionesContr = semObligacionesContr;
        this.semObservaciones = semObservaciones;
        this.semPerfilProveedor = semPerfilProveedor;
        this.semProductosEntregar = semProductosEntregar;
        this.semResultadosEsperados = semResultadosEsperados;
        this.semRiesgosIdentif = semRiesgosIdentif;
        this.semServiciosAdicionales = semServiciosAdicionales;
        this.semTiempoEstimado = semTiempoEstimado;
        this.semTipoSupervisor = semTipoSupervisor;
        this.semUnidTiempoEstim = semUnidTiempoEstim;
        this.semValorEstimado = semValorEstimado;
        this.siiTipoIdentificacion = siiTipoIdentificacion;
        this.siiUsuario2 = siiUsuario2;
		this.siiUbicacion1 = siiUbicacion1;
        this.siiMotivoDevolucion = siiMotivoDevolucion;
    }


    @Column(name = "SEM_CALIDAD_ESPERA_C", nullable = false, length = 500)
    public String getSemCalidadEsperada() {
        return semCalidadEsperada;
    }

    public void setSemCalidadEsperada(String semCalidadEsperada) {
        this.semCalidadEsperada = semCalidadEsperada;
    }

    @Id
    @Column(name = "SEM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SOLICITUD_EST_MERCADO")
    @SequenceGenerator(name = "SEQ_SOLICITUD_EST_MERCADO", sequenceName = "SEQ_SOLICITUD_EST_MERCADO",allocationSize=1)
    public Long getSemCodigo() {
        return semCodigo;
    }

    public void setSemCodigo(Long semCodigo) {
        this.semCodigo = semCodigo;
    }

    @Column(name = "SEM_COTIZACIONES_REC_C", nullable = false)
    public String getSemCotizacionesRecib() {
        return semCotizacionesRecib;
    }

    public void setSemCotizacionesRecib(String semCotizacionesRecib) {
        this.semCotizacionesRecib = semCotizacionesRecib;
    }

    @Column(name = "SEM_ESTANDARES_OBL_C", nullable = false, length = 500)
    public String getSemEstandaresOblig() {
        return semEstandaresOblig;
    }

    public void setSemEstandaresOblig(String semEstandaresOblig) {
        this.semEstandaresOblig = semEstandaresOblig;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SEM_FECHA_DEVOL")
    public Date getSemFechaDevol() {
        return semFechaDevol;
    }

    public void setSemFechaDevol(Date semFechaDevol) {
        this.semFechaDevol = semFechaDevol;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SEM_FECHA_EST_INICIO", nullable = false)
    public Date getSemFechaEstInicio() {
        return semFechaEstInicio;
    }

    public void setSemFechaEstInicio(Date semFechaEstInicio) {
        this.semFechaEstInicio = semFechaEstInicio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SEM_FECHA_REGISTRO", nullable = false)
    public Date getSemFechaRegistro() {
        return semFechaRegistro;
    }

    public void setSemFechaRegistro(Date semFechaRegistro) {
        this.semFechaRegistro = semFechaRegistro;
    }

    @Column(name = "SEM_INFORMACION_FUNCION_C", nullable = false)
    public String getSemInformacionFuncional() {
        return semInformacionFuncional;
    }

    public void setSemInformacionFuncional(String semInformacionFuncional) {
        this.semInformacionFuncional = semInformacionFuncional;
    }

    @Column(name = "SEM_INFORMACION_TECNI_C", nullable = false)
    public String getSemInformacionTecnica() {
        return semInformacionTecnica;
    }

    public void setSemInformacionTecnica(String semInformacionTecnica) {
        this.semInformacionTecnica = semInformacionTecnica;
    }

    @Column(name = "SEM_NOMBRE_SUPERV_EXTERNO", length = 100)
    public String getSemNombreSupervExterno() {
        return semNombreSupervExterno;
    }

    public void setSemNombreSupervExterno(String semNombreSupervExterno) {
        this.semNombreSupervExterno = semNombreSupervExterno;
    }

    @Column(name = "SEM_NUM_IDENTIF_EXTERNO", length = 20)
    public String getSemNumIdentifExterno() {
        return semNumIdentifExterno;
    }

    public void setSemNumIdentifExterno(String semNumIdentifExterno) {
        this.semNumIdentifExterno = semNumIdentifExterno;
    }

    @Column(name = "SEM_OBJETO_CONTRA_C", nullable = false)
    public String getSemObjetoContrato() {
        return semObjetoContrato;
    }

    public void setSemObjetoContrato(String semObjetoContrato) {
        this.semObjetoContrato = semObjetoContrato;
    }

    @Column(name = "SEM_OBLIGACIONES_CON_C", nullable = false)
    public String getSemObligacionesContr() {
        return semObligacionesContr;
    }

    public void setSemObligacionesContr(String semObligacionesContr) {
        this.semObligacionesContr = semObligacionesContr;
    }

    @Column(name = "SEM_OBSERVACION_C")
    public String getSemObservaciones() {
        return semObservaciones;
    }

    public void setSemObservaciones(String semObservaciones) {
        this.semObservaciones = semObservaciones;
    }

    @Column(name = "SEM_PERFIL_PROVEED_C", nullable = false, length = 500)
    public String getSemPerfilProveedor() {
        return semPerfilProveedor;
    }

    public void setSemPerfilProveedor(String semPerfilProveedor) {
        this.semPerfilProveedor = semPerfilProveedor;
    }

    @Column(name = "SEM_PRODUCTOS_ENTREG_C", nullable = false)
    public String getSemProductosEntregar() {
        return semProductosEntregar;
    }

    public void setSemProductosEntregar(String semProductosEntregar) {
        this.semProductosEntregar = semProductosEntregar;
    }

    @Column(name = "SEM_RESULTADOS_ESPERAD_C", nullable = false)
    public String getSemResultadosEsperados() {
        return semResultadosEsperados;
    }

    public void setSemResultadosEsperados(String semResultadosEsperados) {
        this.semResultadosEsperados = semResultadosEsperados;
    }

    @Column(name = "SEM_RIESGOS_IDENT_C", nullable = false)
    public String getSemRiesgosIdentif() {
        return semRiesgosIdentif;
    }

    public void setSemRiesgosIdentif(String semRiesgosIdentif) {
        this.semRiesgosIdentif = semRiesgosIdentif;
    }

    @Column(name = "SEM_SERVICIOS_ADICIONAL_C")
    public String getSemServiciosAdicionales() {
        return semServiciosAdicionales;
    }

    public void setSemServiciosAdicionales(String semServiciosAdicionales) {
        this.semServiciosAdicionales = semServiciosAdicionales;
    }

    @Column(name = "SEM_TIEMPO_ESTIMADO", nullable = false)
    public Integer getSemTiempoEstimado() {
        return semTiempoEstimado;
    }

    public void setSemTiempoEstimado(Integer semTiempoEstimado) {
        this.semTiempoEstimado = semTiempoEstimado;
    }

    @Column(name = "SEM_TIPO_SUPERVISOR", nullable = false, length = 1)
    public String getSemTipoSupervisor() {
        return semTipoSupervisor;
    }

    public void setSemTipoSupervisor(String semTipoSupervisor) {
        this.semTipoSupervisor = semTipoSupervisor;
    }

    @Column(name = "SEM_UNID_TIEMPO_ESTIM", nullable = false, length = 1)
    public String getSemUnidTiempoEstim() {
        return semUnidTiempoEstim;
    }

    public void setSemUnidTiempoEstim(String semUnidTiempoEstim) {
        this.semUnidTiempoEstim = semUnidTiempoEstim;
    }

    @Column(name = "SEM_VALOR_ESTIMADO")
    public Long getSemValorEstimado() {
        return semValorEstimado;
    }

    public void setSemValorEstimado(Long semValorEstimado) {
        this.semValorEstimado = semValorEstimado;
    }


    @ManyToOne
    @JoinColumn(name = "TID_CODIGO_EXTERNO")
    public SiiTipoIdentificacion getSiiTipoIdentificacion() {
        return siiTipoIdentificacion;
    }

    public void setSiiTipoIdentificacion(SiiTipoIdentificacion siiTipoIdentificacion) {
        this.siiTipoIdentificacion = siiTipoIdentificacion;
    }

    @ManyToOne
    @JoinColumn(name = "ESE_CODIGO")
    public SiiEstadoSolEstMercado getSiiEstadoSolEstMercado() {
        return siiEstadoSolEstMercado;
    }

    public void setSiiEstadoSolEstMercado(SiiEstadoSolEstMercado siiEstadoSolEstMercado) {
        this.siiEstadoSolEstMercado = siiEstadoSolEstMercado;
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
    @JoinColumn(name = "PCO_CODIGO_SOLICITANTE")
    public SiiProcesoColjuegos getSiiProcesoColjuegos() {
        return siiProcesoColjuegos;
    }

    public void setSiiProcesoColjuegos(SiiProcesoColjuegos siiProcesoColjuegos) {
        this.siiProcesoColjuegos = siiProcesoColjuegos;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_SUPERVISOR")
    public SiiUsuario getSiiUsuario2() {
        return siiUsuario2;
    }

    public void setSiiUsuario2(SiiUsuario siiUsuario2) {
        this.siiUsuario2 = siiUsuario2;
    }

    @OneToMany(mappedBy = "siiSolicitudEstMercado")
    public List<SiiItemSolicitud> getSiiItemSolicitudList() {
        return siiItemSolicitudList;
    }

    public void setSiiItemSolicitudList(List<SiiItemSolicitud> siiItemSolicitudList) {
        this.siiItemSolicitudList = siiItemSolicitudList;
    }

    public SiiItemSolicitud addSiiItemSolicitud(SiiItemSolicitud siiItemSolicitud) {
        getSiiItemSolicitudList().add(siiItemSolicitud);
        siiItemSolicitud.setSiiSolicitudEstMercado(this);
        return siiItemSolicitud;
    }

    public SiiItemSolicitud removeSiiItemSolicitud(SiiItemSolicitud siiItemSolicitud) {
        getSiiItemSolicitudList().remove(siiItemSolicitud);
        siiItemSolicitud.setSiiSolicitudEstMercado(null);
        return siiItemSolicitud;
    }

    @ManyToOne
    @JoinColumn(name = "ACO_CODIGO_RESPONSABLE")
    public SiiAreaColjuegos getSiiAreaColjuegos() {
        return siiAreaColjuegos;
    }

    public void setSiiAreaColjuegos(SiiAreaColjuegos siiAreaColjuegos) {
        this.siiAreaColjuegos = siiAreaColjuegos;
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
    @JoinColumn(name = "UBI_CODIGO_EJECUCION")
    public SiiUbicacion getSiiUbicacion1() {
        return siiUbicacion1;
    }

    public void setSiiUbicacion1(SiiUbicacion siiUbicacion1) {
        this.siiUbicacion1 = siiUbicacion1;
    }

	@ManyToOne
    @JoinColumn(name = "IPC_CODIGO")
    public SiiItemPlanContratac getSiiItemPlanContratac() {
        return siiItemPlanContratac;
    }

    public void setSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        this.siiItemPlanContratac = siiItemPlanContratac;
    }

    @ManyToOne
    @JoinColumn(name = "MDE_CODIGO")
    public SiiMotivoDevolucion getSiiMotivoDevolucion() {
        return siiMotivoDevolucion;
    }

    public void setSiiMotivoDevolucion(SiiMotivoDevolucion siiMotivoDevolucion) {
        this.siiMotivoDevolucion = siiMotivoDevolucion;
    }
}
