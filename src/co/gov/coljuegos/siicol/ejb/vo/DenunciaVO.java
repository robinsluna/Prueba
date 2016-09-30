package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Value Object para la gestión de las denuncias
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class DenunciaVO {
    
    private String denBarrio;
    private Long denCodigo;
    private String denDenunDireccion;
    private DireccionVO denDenunDireccionVo; //direccionDenunVo
    private Integer denDenunEdad;
    private String denDenunEmail;
    private String denDenunGenero;
    private String denDenunNumIden;
    private String denDenunPrimApe;
    private String denDenunPrimNom;
    private String denDenunRazonSoc;
    private String denDenunSegApe;
    private String denDenunSegNom;
    private String denDenunTelef;
    private String denDetalle;
    private String denDireccion;
    private DireccionVO denDireccionVo; //direccionVo
    private Date denFechaDescarte;
    private Date denFechaRadicado;
    private String denFuente;
    private String denTipoSoporte;
    private Integer denNumeroSoporte;
    private String denLocal;
    private String denLocalidad;
    private String denMotivoDescarte;
    private Integer denNumero;
    private Integer denNumOrdenAuto;
    private String denOrigen;
    private String denRadicado;
    private String denRtaCanal;
    private String denRtaDescripcion;
    private String denRtaEstado;
    private Date denRtaFechaRadic;
    private Date denRtaFechaRadAl;
    private Date denRtaFechaRadFis;
    private String denRtaRadicado;
    private String denRtaRadicAlcal;
    private String denRtaRadicFisc;
    private String denTipoDenunciante;
    private String denTipJuegoLoc;
    private String denTipJuegoNov;
    private String denTipJuegoOtros;
    private String denTipJuegoSinIden;  
    private Date denVerfesFecha;
    private String denVerfesObserv;
    private String denVerfesVerCon;
    private String denVerfesVerTra;
    private Long usuCodigo;
    private UbicacionVO ubicacionLocalVO;
    private AreaColjuegosVO areaColjuegosVO;
    private ResultadoVerifDenunVO resultadoVerifDenunVO;
    private EstadoDenunciaVO estadoDenunciaVO;
    private UbicacionVO ubicacionDenuncianteVO;
    private TipoIdentificacionVO tipoIdentificacionVO;
    private List<DenunciaOrdenTrabVO> denunciaOrdenTrabListVO;
    private List<ElementoIlegDenunVO> elementoIlegDenunListVo;
    private String denDnadoNumIden;
    private String denDnadoPrimApe;
    private String denDnadoPrimNom;
    private String denDnadoSegApe;
    private String denDnadoSegNom;
    private String denDnadoTelef;
    private String denDnadoDireccion;
    private DireccionVO denDnadoDireccionVo;  //direccionDnadoVo
    private TipoIdentificacionVO tipoIdentificacionDenunciado;
    private UbicacionVO ubicacionMunicDenunciado;
    private MedioDenunciaVO medioDenunciaVO;
    private List<AutoComisorioAccConVO> autoComisorioAccConListVo;
    private AutoComisorioAccConVO autoComisorioAccConVo;
    
//
    private UsuarioVO usuarioResDenVo;
    private String departamento;
    private String municipio;
    private String denPaginaWeb;


    /**
     * Constructor
     */
    public DenunciaVO() {
       
    }

    /**
     * Constructor
     * @param siiDenuncia
     */
    public DenunciaVO(SiiDenuncia siiDenuncia) {
        
        this.denBarrio = siiDenuncia.getDenBarrio();
        this.denCodigo = siiDenuncia.getDenCodigo();
        this.denDenunEdad = siiDenuncia.getDenDenunEdad();
        this.denDenunEmail = siiDenuncia.getDenDenunEmail();
        this.denDenunGenero = siiDenuncia.getDenDenunGenero();
        this.denDenunNumIden = siiDenuncia.getDenDenunNumIden();
        this.denDenunPrimApe = siiDenuncia.getDenDenunPrimApe();
        this.denDenunPrimNom = siiDenuncia.getDenDenunPrimNom();
        this.denDenunRazonSoc = siiDenuncia.getDenDenunRazonSoc();
        this.denDenunSegApe = siiDenuncia.getDenDenunSegApe();
        this.denDenunSegNom = siiDenuncia.getDenDenunSegNom();
        this.denDenunTelef = siiDenuncia.getDenDenunTelef();
        this.denDetalle = siiDenuncia.getDenDetalle();
        this.denFechaDescarte = siiDenuncia.getDenFechaDescarte();
        this.denFechaRadicado = siiDenuncia.getDenFechaRadicado();
        this.denFuente = siiDenuncia.getDenFuente();
        this.denLocal = siiDenuncia.getDenLocal();
        this.denLocalidad = siiDenuncia.getDenLocalidad();
        this.denMotivoDescarte = siiDenuncia.getDenMotivoDescarte();
        this.denNumero = siiDenuncia.getDenNumero();
        this.denRadicado = siiDenuncia.getDenRadicado();
        this.denRtaCanal = siiDenuncia.getDenRtaCanal();
        this.denRtaDescripcion = siiDenuncia.getDenRtaDescripcion();
        this.denRtaEstado = siiDenuncia.getDenRtaEstado();
        this.denRtaFechaRadic = siiDenuncia.getDenRtaFechaRadic();
        this.denRtaFechaRadAl = siiDenuncia.getDenRtaFechaRadAl();
        this.denRtaFechaRadFis = siiDenuncia.getDenRtaFechaRadFis();
        this.denRtaRadicado = siiDenuncia.getDenRtaRadicado();
        this.denRtaRadicAlcal = siiDenuncia.getDenRtaRadicAlcal();
        this.denRtaRadicFisc = siiDenuncia.getDenRtaRadicFisc();
        this.denTipoDenunciante = siiDenuncia.getDenTipoDenunciante();
        this.denTipJuegoLoc = siiDenuncia.getDenTipJuegoLoc();
        this.denTipJuegoNov = siiDenuncia.getDenTipJuegoNov();
        this.denTipJuegoOtros = siiDenuncia.getDenTipJuegoOtros();
        this.denTipJuegoSinIden = siiDenuncia.getDenTipJuegoSinIden();
        this.denVerfesFecha = siiDenuncia.getDenVerfesFecha();
        this.denVerfesObserv = siiDenuncia.getDenVerfesObserv();
        this.denVerfesVerCon = siiDenuncia.getDenVerfesVerCon();
        this.denVerfesVerTra = siiDenuncia.getDenVerfesVerTra();
        this.usuCodigo = siiDenuncia.getUsuCodigo();
        this.denDnadoNumIden = siiDenuncia.getDenDnadoNumIden();
        this.denDnadoPrimApe = siiDenuncia.getDenDnadoPrimApe();
        this.denDnadoPrimNom = siiDenuncia.getDenDnadoPrimNom();
        this.denDnadoSegApe = siiDenuncia.getDenDnadoSegApe();
        this.denDnadoSegNom = siiDenuncia.getDenDnadoSegNom();
        this.denDnadoTelef = siiDenuncia.getDenDnadoTelef();
        this.denTipoSoporte = siiDenuncia.getDenTipoSoporte();
        this.denNumeroSoporte = siiDenuncia.getDenNumeroSoporte();
        this.denPaginaWeb = siiDenuncia.getDenPaginaWeb();
        
        if(siiDenuncia.getSiiUbicacionLocal() != null)
            this.ubicacionLocalVO = new UbicacionVO(siiDenuncia.getSiiUbicacionLocal()); 
        
        if (siiDenuncia.getSiiAreaColjuegos()!=null)
            this.areaColjuegosVO = new AreaColjuegosVO(siiDenuncia.getSiiAreaColjuegos());
        
        if(siiDenuncia.getSiiUbicacionDenunciante() != null)
            this.ubicacionDenuncianteVO = new UbicacionVO(siiDenuncia.getSiiUbicacionDenunciante()); 
        
        if (siiDenuncia.getSiiTipoIdentificacion()!=null)
            this.tipoIdentificacionVO = new TipoIdentificacionVO(siiDenuncia.getSiiTipoIdentificacion());
        
        if (siiDenuncia.getSiiTipoIdentificacionDenunciado()!=null)
            this.tipoIdentificacionDenunciado = new TipoIdentificacionVO(siiDenuncia.getSiiTipoIdentificacionDenunciado());
        
        if (siiDenuncia.getSiiUbicacionMunicDenunciado()!=null)
            this.ubicacionMunicDenunciado = new UbicacionVO(siiDenuncia.getSiiUbicacionMunicDenunciado());
        
        if (siiDenuncia.getSiiEstadoDenuncia()!=null)
            this.estadoDenunciaVO = new EstadoDenunciaVO(siiDenuncia.getSiiEstadoDenuncia());
        
        if (siiDenuncia.getSiiMedioDenuncia()!= null)
            this.medioDenunciaVO = new MedioDenunciaVO(siiDenuncia.getSiiMedioDenuncia());
        
        if (siiDenuncia.getSiiDireccion()!= null)
            this.denDireccionVo = new DireccionVO(siiDenuncia.getSiiDireccion());
        
        if (siiDenuncia.getSiiDireccionDenun()!= null)
            this.denDenunDireccionVo = new DireccionVO(siiDenuncia.getSiiDireccionDenun());
        
        if (siiDenuncia.getSiiDireccionDnado()!= null)
            this.denDnadoDireccionVo = new DireccionVO(siiDenuncia.getSiiDireccionDnado());
        
        if (siiDenuncia.getSiiResultadoVerifDenun() != null) {
            this.resultadoVerifDenunVO = new ResultadoVerifDenunVO(siiDenuncia.getSiiResultadoVerifDenun());
        }
            
        
    }
    
    
    
    /**
     * Adiciona un registro al listado de ElementoIlegDenunVO.
     * @param elementoIlegDenunVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addElementoIlegDenun (ElementoIlegDenunVO elementoIlegDenunVo) 
    {
        boolean exitoso = false;
        if (elementoIlegDenunListVo==null)
            elementoIlegDenunListVo = new ArrayList<ElementoIlegDenunVO>();
        
        exitoso = elementoIlegDenunListVo.add(elementoIlegDenunVo);
        
        if (exitoso)
            elementoIlegDenunVo.setDenunciaVo(this);
        
        return (exitoso);
        
    }
    
    
    /**
     * Elimina un registro del listado ElementoIlegDenunVO.
     * @param elementoIlegDenunVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeElementoIlegDenun (ElementoIlegDenunVO elementoIlegDenunVo) {
        boolean exitoso = false;
        
        if (elementoIlegDenunListVo!=null) {
            exitoso = elementoIlegDenunListVo.remove(elementoIlegDenunVo);
            
            if (exitoso)
                elementoIlegDenunVo.setDenunciaVo(null);
        }
        
        return (exitoso);
    }
        

    public String getDenBarrio() {
        return denBarrio;
    }

    public void setDenBarrio(String denBarrio) {
        this.denBarrio = denBarrio;
    }

    public Long getDenCodigo() {
        return denCodigo;
    }

    public void setDenCodigo(Long denCodigo) {
        this.denCodigo = denCodigo;
    }

    public DireccionVO getDenDenunDireccionVo() {
        return denDenunDireccionVo;
    }

    public void setDenDenunDireccionVo(DireccionVO denDenunDireccion) {
        this.denDenunDireccionVo = denDenunDireccion;
    }

    public Integer getDenDenunEdad() {
        return denDenunEdad;
    }

    public void setDenDenunEdad(Integer denDenunEdad) {
        this.denDenunEdad = denDenunEdad;
    }

    public String getDenDenunEmail() {
        return denDenunEmail;
    }

    public void setDenDenunEmail(String denDenunEmail) {
        this.denDenunEmail = denDenunEmail;
    }

    public String getDenDenunGenero() {
        return denDenunGenero;
    }

    public void setDenDenunGenero(String denDenunGenero) {
        this.denDenunGenero = denDenunGenero;
    }

    public String getDenDenunNumIden() {
        return denDenunNumIden;
    }

    public void setDenDenunNumIden(String denDenunNumIden) {
        this.denDenunNumIden = denDenunNumIden;
    }

    public String getDenDenunPrimApe() {
        return denDenunPrimApe;
    }

    public void setDenDenunPrimApe(String denDenunPrimApe) {
        this.denDenunPrimApe = denDenunPrimApe;
    }

    public String getDenDenunPrimNom() {
        return denDenunPrimNom;
    }

    public void setDenDenunPrimNom(String denDenunPrimNom) {
        this.denDenunPrimNom = denDenunPrimNom;
    }

    public String getDenDenunRazonSoc() {
        return denDenunRazonSoc;
    }

    public void setDenDenunRazonSoc(String denDenunRazonSoc) {
        this.denDenunRazonSoc = denDenunRazonSoc;
    }

    public String getDenDenunSegApe() {
        return denDenunSegApe;
    }

    public void setDenDenunSegApe(String denDenunSegApe) {
        this.denDenunSegApe = denDenunSegApe;
    }

    public String getDenDenunSegNom() {
        return denDenunSegNom;
    }

    public void setDenDenunSegNom(String denDenunSegNom) {
        this.denDenunSegNom = denDenunSegNom;
    }

    public String getDenDenunTelef() {
        return denDenunTelef;
    }

    public void setDenDenunTelef(String denDenunTelef) {
        this.denDenunTelef = denDenunTelef;
    }

    public String getDenDetalle() {
        return denDetalle;
    }

    public void setDenDetalle(String denDetalle) {
        this.denDetalle = denDetalle;
    }

    public DireccionVO getDenDireccionVo() {
        return denDireccionVo;
    }

    public void setDenDireccionVo(DireccionVO denDireccion) {
        this.denDireccionVo = denDireccion;
    }

    public Date getDenFechaDescarte() {
        return denFechaDescarte;
    }

    public void setDenFechaDescarte(Date denFechaDescarte) {
        this.denFechaDescarte = denFechaDescarte;
    }

    public Date getDenFechaRadicado() {
        return denFechaRadicado;
    }

    public void setDenFechaRadicado(Date denFechaRadicado) {
        this.denFechaRadicado = denFechaRadicado;
    }

    public String getDenFuente() {
        return denFuente;
    }

    public void setDenFuente(String denFuente) {
        this.denFuente = denFuente;
    }

    public String getDenLocal() {
        return denLocal;
    }

    public void setDenLocal(String denLocal) {
        this.denLocal = denLocal;
    }

    public String getDenLocalidad() {
        return denLocalidad;
    }

    public void setDenLocalidad(String denLocalidad) {
        this.denLocalidad = denLocalidad;
    }

    public String getDenMotivoDescarte() {
        return denMotivoDescarte;
    }

    public void setDenMotivoDescarte(String denMotivoDescarte) {
        this.denMotivoDescarte = denMotivoDescarte;
    }

    public Integer getDenNumero() {
        return denNumero;
    }

    public void setDenNumero(Integer denNumero) {
        this.denNumero = denNumero;
    }

    public Integer getDenNumOrdenAuto() {
        return denNumOrdenAuto;
    }

    public void setDenNumOrdenAuto(Integer denNumOrdenAuto) {
        this.denNumOrdenAuto = denNumOrdenAuto;
    }

    public String getDenOrigen() {
        return denOrigen;
    }

    public void setDenOrigen(String denOrigen) {
        this.denOrigen = denOrigen;
    }

    public String getDenRadicado() {
        return denRadicado;
    }

    public void setDenRadicado(String denRadicado) {
        this.denRadicado = denRadicado;
    }

    public String getDenRtaCanal() {
        return denRtaCanal;
    }

    public void setDenRtaCanal(String denRtaCanal) {
        this.denRtaCanal = denRtaCanal;
    }

    public String getDenRtaDescripcion() {
        return denRtaDescripcion;
    }

    public void setDenRtaDescripcion(String denRtaDescripcion) {
        this.denRtaDescripcion = denRtaDescripcion;
    }

    public String getDenRtaEstado() {
        return denRtaEstado;
    }

    public void setDenRtaEstado(String denRtaEstado) {
        this.denRtaEstado = denRtaEstado;
    }

    public Date getDenRtaFechaRadic() {
        return denRtaFechaRadic;
    }

    public void setDenRtaFechaRadic(Date denRtaFechaRadic) {
        this.denRtaFechaRadic = denRtaFechaRadic;
    }

    public Date getDenRtaFechaRadAl() {
        return denRtaFechaRadAl;
    }

    public void setDenRtaFechaRadAl(Date denRtaFechaRadAl) {
        this.denRtaFechaRadAl = denRtaFechaRadAl;
    }

    public Date getDenRtaFechaRadFis() {
        return denRtaFechaRadFis;
    }

    public void setDenRtaFechaRadFis(Date denRtaFechaRadFis) {
        this.denRtaFechaRadFis = denRtaFechaRadFis;
    }

    public String getDenRtaRadicado() {
        return denRtaRadicado;
    }

    public void setDenRtaRadicado(String denRtaRadicado) {
        this.denRtaRadicado = denRtaRadicado;
    }

    public String getDenRtaRadicAlcal() {
        return denRtaRadicAlcal;
    }

    public void setDenRtaRadicAlcal(String denRtaRadicAlcal) {
        this.denRtaRadicAlcal = denRtaRadicAlcal;
    }

    public String getDenRtaRadicFisc() {
        return denRtaRadicFisc;
    }

    public void setDenRtaRadicFisc(String denRtaRadicFisc) {
        this.denRtaRadicFisc = denRtaRadicFisc;
    }

    public String getDenTipoDenunciante() {
        return denTipoDenunciante;
    }

    public void setDenTipoDenunciante(String denTipoDenunciante) {
        this.denTipoDenunciante = denTipoDenunciante;
    }

    public String getDenTipJuegoLoc() {
        return denTipJuegoLoc;
    }

    public void setDenTipJuegoLoc(String denTipJuegoLoc) {
        this.denTipJuegoLoc = denTipJuegoLoc;
    }

    public String getDenTipJuegoNov() {
        return denTipJuegoNov;
    }

    public void setDenTipJuegoNov(String denTipJuegoNov) {
        this.denTipJuegoNov = denTipJuegoNov;
    }

    public String getDenTipJuegoOtros() {
        return denTipJuegoOtros;
    }

    public void setDenTipJuegoOtros(String denTipJuegoOtros) {
        this.denTipJuegoOtros = denTipJuegoOtros;
    }

    public String getDenTipJuegoSinIden() {
        return denTipJuegoSinIden;
    }

    public void setDenTipJuegoSinIden(String denTipJuegoSinIden) {
        this.denTipJuegoSinIden = denTipJuegoSinIden;
    }

    public Date getDenVerfesFecha() {
        return denVerfesFecha;
    }

    public void setDenVerfesFecha(Date denVerfesFecha) {
        this.denVerfesFecha = denVerfesFecha;
    }

    public String getDenVerfesObserv() {
        return denVerfesObserv;
    }

    public void setDenVerfesObserv(String denVerfesObserv) {
        this.denVerfesObserv = denVerfesObserv;
    }

    public String getDenVerfesVerCon() {
        return denVerfesVerCon;
    }

    public void setDenVerfesVerCon(String denVerfesVerCon) {
        this.denVerfesVerCon = denVerfesVerCon;
    }

    public String getDenVerfesVerTra() {
        return denVerfesVerTra;
    }

    public void setDenVerfesVerTra(String denVerfesVerTra) {
        this.denVerfesVerTra = denVerfesVerTra;
    }

    public Long getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Long usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public UbicacionVO getUbicacionLocalVO() {
        return ubicacionLocalVO;
    }

    public void setUbicacionLocalVO(UbicacionVO ubicacionLocalVO) {
        this.ubicacionLocalVO = ubicacionLocalVO;
    }

    public AreaColjuegosVO getAreaColjuegosVO() {
        return areaColjuegosVO;
    }

    public void setAreaColjuegosVO(AreaColjuegosVO areaColjuegosVO) {
        this.areaColjuegosVO = areaColjuegosVO;
    }

    public UbicacionVO getUbicacionDenuncianteVO() {
        return ubicacionDenuncianteVO;
    }

    public void setUbicacionDenuncianteVO(UbicacionVO ubicacionDenuncianteVO) {
        this.ubicacionDenuncianteVO = ubicacionDenuncianteVO;
    }

    public TipoIdentificacionVO getTipoIdentificacionVO() {
        return tipoIdentificacionVO;
    }

    public void setTipoIdentificacionVO(TipoIdentificacionVO tipoIdentificacionVO) {
        this.tipoIdentificacionVO = tipoIdentificacionVO;
    }

    public List<DenunciaOrdenTrabVO> getDenunciaOrdenTrabListVO() {
        return denunciaOrdenTrabListVO;
    }

    public void setDenunciaOrdenTrabListVO(List<DenunciaOrdenTrabVO> denunciaOrdenTrabListVO) {
        this.denunciaOrdenTrabListVO = denunciaOrdenTrabListVO;
    }

    public String getDenDnadoNumIden() {
        return denDnadoNumIden;
    }

    public void setDenDnadoNumIden(String denDnadoNumIden) {
        this.denDnadoNumIden = denDnadoNumIden;
    }

    public String getDenDnadoPrimApe() {
        return denDnadoPrimApe;
    }

    public void setDenDnadoPrimApe(String denDnadoPrimApe) {
        this.denDnadoPrimApe = denDnadoPrimApe;
    }

    public String getDenDnadoPrimNom() {
        return denDnadoPrimNom;
    }

    public void setDenDnadoPrimNom(String denDnadoPrimNom) {
        this.denDnadoPrimNom = denDnadoPrimNom;
    }

    public String getDenDnadoSegApe() {
        return denDnadoSegApe;
    }

    public void setDenDnadoSegApe(String denDnadoSegApe) {
        this.denDnadoSegApe = denDnadoSegApe;
    }

    public String getDenDnadoSegNom() {
        return denDnadoSegNom;
    }

    public void setDenDnadoSegNom(String denDnadoSegNom) {
        this.denDnadoSegNom = denDnadoSegNom;
    }

    public String getDenDnadoTelef() {
        return denDnadoTelef;
    }

    public void setDenDnadoTelef(String denDnadoTelef) {
        this.denDnadoTelef = denDnadoTelef;
    }

    public TipoIdentificacionVO getTipoIdentificacionDenunciado() {
        return tipoIdentificacionDenunciado;
    }

    public void setTipoIdentificacionDenunciado(TipoIdentificacionVO tipoIdentificacionDenunciado) {
        this.tipoIdentificacionDenunciado = tipoIdentificacionDenunciado;
    }

    public UbicacionVO getUbicacionMunicDenunciado() {
        return ubicacionMunicDenunciado;
    }

    public void setUbicacionMunicDenunciado(UbicacionVO ubicacionMunicDenunciado) {
        this.ubicacionMunicDenunciado = ubicacionMunicDenunciado;
    }


    public void setElementoIlegDenunListVo(List<ElementoIlegDenunVO> elementoIlegDenunListVo) {
        this.elementoIlegDenunListVo = elementoIlegDenunListVo;
    }

    public List<ElementoIlegDenunVO> getElementoIlegDenunListVo() {
        return elementoIlegDenunListVo;
    }

    public ResultadoVerifDenunVO getResultadoVerifDenunVO() {
        return resultadoVerifDenunVO;
    }

    public void setResultadoVerifDenunVO(ResultadoVerifDenunVO resultadoVerifDenunVO) {
        this.resultadoVerifDenunVO = resultadoVerifDenunVO;
    }

    public EstadoDenunciaVO getEstadoDenunciaVO() {
        return estadoDenunciaVO;
    }

    public void setEstadoDenunciaVO(EstadoDenunciaVO estadoDenunciaVO) {
        this.estadoDenunciaVO = estadoDenunciaVO;
    }

    public String getDenTipoSoporte() {
        return denTipoSoporte;
    }

    public void setDenTipoSoporte(String denTipoSoporte) {
        this.denTipoSoporte = denTipoSoporte;
    }

    public Integer getDenNumeroSoporte() {
        return denNumeroSoporte;
    }

    public void setDenNumeroSoporte(Integer denNumeroSoporte) {
        this.denNumeroSoporte = denNumeroSoporte;
    }

    public MedioDenunciaVO getMedioDenunciaVO() {
        return medioDenunciaVO;
    }

    public void setMedioDenunciaVO(MedioDenunciaVO medioDenunciaVO) {
        this.medioDenunciaVO = medioDenunciaVO;
    }

    public void setAutoComisorioAccConListVo(List<AutoComisorioAccConVO> autoComisorioAccConListVo) {
        this.autoComisorioAccConListVo = autoComisorioAccConListVo;
    }

    public List<AutoComisorioAccConVO> getAutoComisorioAccConListVo() {
        return autoComisorioAccConListVo;
    }
    
    public DireccionVO getDenDnadoDireccionVo() {
        return denDnadoDireccionVo;
    }

    public void setDenDnadoDireccionVo(DireccionVO denDnadoDireccion) {
        this.denDnadoDireccionVo = denDnadoDireccion;
    }

    public void setAutoComisorioAccConVo(AutoComisorioAccConVO autoComisorioAccConVo) {
        this.autoComisorioAccConVo = autoComisorioAccConVo;
    }
    
    public AutoComisorioAccConVO getAutoComisorioAccConVo() {
        if (autoComisorioAccConListVo != null && autoComisorioAccConListVo.size()!= 0) {
            return this.autoComisorioAccConListVo.get(0);            
        } else {
            return new AutoComisorioAccConVO();
        }
    }

    public String getDenDenunDireccion() {
        return denDenunDireccion;
    }

    public void setDenDenunDireccion(String denDenunDireccion) {
        this.denDenunDireccion = denDenunDireccion;
    }

    public String getDenDireccion() {
        return denDireccion;
    }

    public void setDenDireccion(String denDireccion) {
        this.denDireccion = denDireccion;
    }

    public String getDenDnadoDireccion() {
        return denDnadoDireccion;
    }

    public void setDenDnadoDireccion(String denDnadoDireccion) {
        this.denDnadoDireccion = denDnadoDireccion;
    }

    public void setUsuarioResDenVo(UsuarioVO usuarioResDenVo) {
        this.usuarioResDenVo = usuarioResDenVo;
    }

    public UsuarioVO getUsuarioResDenVo() {
        return usuarioResDenVo;
    }

    public void setDenPaginaWeb(String denPaginaWeb) {
        this.denPaginaWeb = denPaginaWeb;
    }

    public String getDenPaginaWeb() {
        return denPaginaWeb;
    }

    public AutoComisorioAccConVO getAutoComisorioAccConVo1(){
        return autoComisorioAccConVo;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public String getDepartamento(){
        return departamento;
    }

    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }

    public String getMunicipio(){
        return municipio;
    }

}
