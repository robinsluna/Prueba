package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemSolicitud;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoDevolucion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolicitudEstMercadoVO {
    private static final long serialVersionUID = -8429877262560448220L;
    private String semCalidadEsperada;
    private String semCantidadSolicitada;
    private Long semCodigo;
    private String semCotizacionesRecib;
    private String semEstandaresOblig;
    private Date semFechaDevol;
    private Date semFechaEstInicio;
    private Date semFechaRegistro;
    private String semInformacionFuncional;
    private String semInformacionTecnica;
    private String semLugarEjecucion;   
    private String semNombreSupervExterno;
    private String semNumIdentifExterno;
    private String semTipoIdentficacionSuperExt;
    private String semObjetoContrato;
    private String semObligacionesContr;
    private String semPerfilProveedor;
    private String semProductosEntregar;
    private String semResultadosEsperados;
    private String semRiesgosIdentif;
    private String semServiciosAdicionales;
    private Integer semTiempoEstimado;
    private String semTipoSupervisor;
    private TipoIdentificacionVO tipoIdentificacionVo;
    private EstadoSolEstMercadoVO estadoSolEstMercadoVo;
    private ArchivoFisicoVO archivoFisicoVo;
    private ProcesoColjuegosVO procesoColjuegosVo;
    private UsuarioVO Usuario2Vo;
    private AreaColjuegosVO areaColjuegosVo;
    private String semUnidTiempoEstim;
    private Long semValorEstimado;
    private ProcesoContratacionVO procesoContratacionVo;
    private List<ItemSolicitudVO> itemSolicitudListVo;
    private UbicacionVO ubicacionVo;
    private ItemPlanContratacVO itemPlancontratacionVo;
    private String semObservaciones;
    private MotivoDevolucionVO motivoDevolucionVo;
    private Long idEstadoAnterior;
    private Long numeroRadicacion;
    

    public SolicitudEstMercadoVO(SiiSolicitudEstMercado solicitudEstMercado){
        this.semCalidadEsperada = solicitudEstMercado.getSemCalidadEsperada();
        this.semCodigo = solicitudEstMercado.getSemCodigo();
        this.semCotizacionesRecib = solicitudEstMercado.getSemCotizacionesRecib();
        this.semEstandaresOblig = solicitudEstMercado.getSemEstandaresOblig();
        this.semFechaDevol = solicitudEstMercado.getSemFechaDevol();
        this.semFechaEstInicio = solicitudEstMercado.getSemFechaEstInicio();
        this.semFechaRegistro = solicitudEstMercado.getSemFechaRegistro();
        this.semInformacionFuncional = solicitudEstMercado.getSemInformacionFuncional();
        this.semInformacionTecnica = solicitudEstMercado.getSemInformacionTecnica();
        this.semNombreSupervExterno = solicitudEstMercado.getSemNombreSupervExterno();
        this.semNumIdentifExterno = solicitudEstMercado.getSemNumIdentifExterno();
        this.semObjetoContrato = solicitudEstMercado.getSemObjetoContrato();
        this.semObligacionesContr = solicitudEstMercado.getSemObligacionesContr();
        this.semPerfilProveedor = solicitudEstMercado.getSemPerfilProveedor();
        this.semProductosEntregar = solicitudEstMercado.getSemProductosEntregar();
        this.semResultadosEsperados = solicitudEstMercado.getSemResultadosEsperados();
        this.semRiesgosIdentif = solicitudEstMercado.getSemRiesgosIdentif();
        this.semServiciosAdicionales = solicitudEstMercado.getSemServiciosAdicionales();
        this.semTiempoEstimado = solicitudEstMercado.getSemTiempoEstimado();
        this.semTipoSupervisor = solicitudEstMercado.getSemTipoSupervisor();
        this.semUnidTiempoEstim = solicitudEstMercado.getSemUnidTiempoEstim();
        this.semValorEstimado = solicitudEstMercado.getSemValorEstimado();
        this.semObservaciones = solicitudEstMercado.getSemObservaciones();
        
        if(solicitudEstMercado.getSiiProcesoColjuegos()!=null){
            this.procesoColjuegosVo= new ProcesoColjuegosVO(solicitudEstMercado.getSiiProcesoColjuegos());
        }
        
        if(solicitudEstMercado.getSiiArchivoFisico() != null){
            this.archivoFisicoVo = new ArchivoFisicoVO(solicitudEstMercado.getSiiArchivoFisico());
        }
        if(solicitudEstMercado.getSiiEstadoSolEstMercado()!=null){
            this.estadoSolEstMercadoVo=new EstadoSolEstMercadoVO(solicitudEstMercado.getSiiEstadoSolEstMercado());
            this.idEstadoAnterior = solicitudEstMercado.getSiiEstadoSolEstMercado().getEseCodigo();
        }
        if(solicitudEstMercado.getSiiProcesoContratacion() != null){
            this.procesoContratacionVo = new ProcesoContratacionVO(solicitudEstMercado.getSiiProcesoContratacion());
        }
        if(solicitudEstMercado.getSiiTipoIdentificacion()!=null){
            this.tipoIdentificacionVo = new TipoIdentificacionVO(solicitudEstMercado.getSiiTipoIdentificacion());
        }
        if(solicitudEstMercado.getSiiUsuario2()!= null){
            this.Usuario2Vo= new UsuarioVO(solicitudEstMercado.getSiiUsuario2());
        }
        if(solicitudEstMercado.getSiiAreaColjuegos()!=null){
            this.areaColjuegosVo = new AreaColjuegosVO(solicitudEstMercado.getSiiAreaColjuegos());
        }
        if(solicitudEstMercado.getSiiItemPlanContratac()!=null){
            this.itemPlancontratacionVo=new ItemPlanContratacVO (solicitudEstMercado.getSiiItemPlanContratac());
        }
        if(solicitudEstMercado.getSiiUbicacion1()!=null){
            this.ubicacionVo=new UbicacionVO (solicitudEstMercado.getSiiUbicacion1());
        }
        if(solicitudEstMercado.getSiiMotivoDevolucion() != null){
            this.motivoDevolucionVo = new MotivoDevolucionVO(solicitudEstMercado.getSiiMotivoDevolucion());
        }
    }
        
        

    public SolicitudEstMercadoVO(){
        }

    public void setSemFechaDevol(Date semFechaDevol) {
        this.semFechaDevol = semFechaDevol;
    }

    public Date getSemFechaDevol() {
        return semFechaDevol;
    }

    public void setMotivoDevolucionVo(MotivoDevolucionVO motivoDevolucionVo) {
        this.motivoDevolucionVo = motivoDevolucionVo;
    }

    public MotivoDevolucionVO getMotivoDevolucionVo() {
        return motivoDevolucionVo;
    }

    public void setSemObservaciones(String semObservaciones) {
        this.semObservaciones = semObservaciones;
    }

    public String getSemObservaciones() {
        return semObservaciones;
    }

    public void setSemCalidadEsperada(String semCalidadEsperada) {
        this.semCalidadEsperada = semCalidadEsperada;
    }

    public String getSemCalidadEsperada() {
        return semCalidadEsperada;
    }

    public void setSemCantidadSolicitada(String semCantidadSolicitada) {
        this.semCantidadSolicitada = semCantidadSolicitada;
    }

    public String getSemCantidadSolicitada() {
        return semCantidadSolicitada;
    }

    public void setSemCodigo(Long semCodigo) {
        this.semCodigo = semCodigo;
    }

    public void setSemTipoIdentficacionSuperExt(String semTipoIdentficacionSuperExt) {
        this.semTipoIdentficacionSuperExt = semTipoIdentficacionSuperExt;
    }

    public String getSemTipoIdentficacionSuperExt() {
        return semTipoIdentficacionSuperExt;
    }

    public Long getSemCodigo() {
        return semCodigo;
    }

    public void setSemCotizacionesRecib(String semCotizacionesRecib) {
        this.semCotizacionesRecib = semCotizacionesRecib;
    }

    public String getSemCotizacionesRecib() {
        return semCotizacionesRecib;
    }

    public void setSemLugarEjecucion(String semLugarEjecucion) {
        this.semLugarEjecucion = semLugarEjecucion;
    }

    public String getSemLugarEjecucion() {
        return semLugarEjecucion;
    }

    public void setSemEstandaresOblig(String semEstandaresOblig) {
        this.semEstandaresOblig = semEstandaresOblig;
    }

    public String getSemEstandaresOblig() {
        return semEstandaresOblig;
    }


    public void setSemFechaEstInicio(Date semFechaEstInicio) {
        this.semFechaEstInicio = semFechaEstInicio;
    }

    public Date getSemFechaEstInicio() {
        return semFechaEstInicio;
    }

    public void setItemPlancontratacionVo(ItemPlanContratacVO itemPlancontratacionVo) {
        this.itemPlancontratacionVo = itemPlancontratacionVo;
    }

    public ItemPlanContratacVO getItemPlancontratacionVo() {
        return itemPlancontratacionVo;
    }

    public void setSemFechaRegistro(Date semFechaRegistro) {
        this.semFechaRegistro = semFechaRegistro;
    }

    public Date getSemFechaRegistro() {
        return semFechaRegistro;
    }

    public void setSemInformacionFuncional(String semInformacionFuncional) {
        this.semInformacionFuncional = semInformacionFuncional;
    }

    public String getSemInformacionFuncional() {
        return semInformacionFuncional;
    }

    public void setSemInformacionTecnica(String semInformacionTecnica) {
        this.semInformacionTecnica = semInformacionTecnica;
    }

    public String getSemInformacionTecnica() {
        return semInformacionTecnica;
    }

    public void setSemNombreSupervExterno(String semNombreSupervExterno) {
        this.semNombreSupervExterno = semNombreSupervExterno;
    }

    public String getSemNombreSupervExterno() {
        return semNombreSupervExterno;
    }

    public void setSemNumIdentifExterno(String semNumIdentifExterno) {
        this.semNumIdentifExterno = semNumIdentifExterno;
    }

    public String getSemNumIdentifExterno() {
        return semNumIdentifExterno;
    }

    public void setSemObjetoContrato(String semObjetoContrato) {
        this.semObjetoContrato = semObjetoContrato;
    }

    public String getSemObjetoContrato() {
        return semObjetoContrato;
    }

    public void setSemObligacionesContr(String semObligacionesContr) {
        this.semObligacionesContr = semObligacionesContr;
    }

    public String getSemObligacionesContr() {
        return semObligacionesContr;
    }

    public void setSemPerfilProveedor(String semPerfilProveedor) {
        this.semPerfilProveedor = semPerfilProveedor;
    }

    public String getSemPerfilProveedor() {
        return semPerfilProveedor;
    }

    public void setSemProductosEntregar(String semProductosEntregar) {
        this.semProductosEntregar = semProductosEntregar;
    }

    public String getSemProductosEntregar() {
        return semProductosEntregar;
    }

    public void setSemResultadosEsperados(String semResultadosEsperados) {
        this.semResultadosEsperados = semResultadosEsperados;
    }

    public String getSemResultadosEsperados() {
        return semResultadosEsperados;
    }

    public void setSemRiesgosIdentif(String semRiesgosIdentif) {
        this.semRiesgosIdentif = semRiesgosIdentif;
    }

    public String getSemRiesgosIdentif() {
        return semRiesgosIdentif;
    }

    public void setSemServiciosAdicionales(String semServiciosAdicionales) {
        this.semServiciosAdicionales = semServiciosAdicionales;
    }

    public String getSemServiciosAdicionales() {
        return semServiciosAdicionales;
    }

    public void setSemTiempoEstimado(Integer semTiempoEstimado) {
        this.semTiempoEstimado = semTiempoEstimado;
    }

    public Integer getSemTiempoEstimado() {
        return semTiempoEstimado;
    }

    public void setSemTipoSupervisor(String semTipoSupervisor) {
        this.semTipoSupervisor = semTipoSupervisor;
    }

    public String getSemTipoSupervisor() {
        return semTipoSupervisor;
    }

    public void setTipoIdentificacionVo(TipoIdentificacionVO tipoIdentificacionVo) {
        this.tipoIdentificacionVo = tipoIdentificacionVo;
    }

    public TipoIdentificacionVO getTipoIdentificacionVo() {
        return tipoIdentificacionVo;
    }

    public void setEstadoSolEstMercadoVo(EstadoSolEstMercadoVO estadoSolEstMercadoVo) {
        this.estadoSolEstMercadoVo = estadoSolEstMercadoVo;
    }

    public EstadoSolEstMercadoVO getEstadoSolEstMercadoVo() {
        return estadoSolEstMercadoVo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setProcesoColjuegosVo(ProcesoColjuegosVO procesoColjuegosVo) {
        this.procesoColjuegosVo = procesoColjuegosVo;
    }

    public ProcesoColjuegosVO getProcesoColjuegosVo() {
        return procesoColjuegosVo;
    }

    public void setUsuario2Vo(UsuarioVO Usuario2Vo) {
        this.Usuario2Vo = Usuario2Vo;
    }

    public UsuarioVO getUsuario2Vo() {
        return Usuario2Vo;
    }

    public void setAreaColjuegosVo(AreaColjuegosVO areaColjuegosVo) {
        this.areaColjuegosVo = areaColjuegosVo;
    }

    public AreaColjuegosVO getAreaColjuegosVo() {
        return areaColjuegosVo;
    }

    public void setSemUnidTiempoEstim(String semUnidTiempoEstim) {
        this.semUnidTiempoEstim = semUnidTiempoEstim;
    }

    public String getSemUnidTiempoEstim() {
        return semUnidTiempoEstim;
    }

    public void setSemValorEstimado(Long semValorEstimado) {
        this.semValorEstimado = semValorEstimado;
    }

    public Long getSemValorEstimado() {
        return semValorEstimado;
    }

    public void setProcesoContratacionVo(ProcesoContratacionVO procesoContratacionVo) {
        this.procesoContratacionVo = procesoContratacionVo;
    }

    public ProcesoContratacionVO getProcesoContratacionVo() {
        return procesoContratacionVo;
    }


    public void setItemSolicitudListVo(List<ItemSolicitudVO> itemSolicitudListVo) {
        this.itemSolicitudListVo = itemSolicitudListVo;
    }

    public List<ItemSolicitudVO> getItemSolicitudListVo() {
        return itemSolicitudListVo;
    }

    public void setUbicacionVo(UbicacionVO ubicacionVo) {
        this.ubicacionVo = ubicacionVo;
    }

    public UbicacionVO getUbicacionVo() {
        return ubicacionVo;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }


    public void setNumeroRadicacion(Long numeroRadicacion) {
        this.numeroRadicacion = numeroRadicacion;
    }

    public Long getNumeroRadicacion() {
        return numeroRadicacion;
    }
}
