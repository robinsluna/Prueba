package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioMercado;

import java.util.Date;
import java.util.List;

public class EstudioMercadoVO {
    private String emeAnalisisMercado;
    private Long emeCodigo;
    private String emeDivulAcercam;
    private Date emeDivulAcercamFec;
    private String emeDivulEmail;
    private Date emeDivulEmailFec;
    private String emeDivulOtro;
    private String emeDivulOtroEspec;
    private Date emeDivulOtroFec;
    private String emeDivulProv;
    private Date emeDivulProvFec;
    private String emeDivulTel;
    private Date emeDivulTelFec;
    private Date emeFecha;
    private String emeObservaciones;
    private String emeReqPolizas;
    private List<CotizacionEstudioVO> cotizacionEstudioListVO;
    private ProcesoContratacionVO procesoContratacionVO;
    private EstadoEstudioMercVO estadoEstudioMercVO;
    private Long idEstadoAnterior;
    
    public EstudioMercadoVO() {
        
    }

    /**
     * @author Modifica Giovanni 
     * @param estudioMercado
     */
    public EstudioMercadoVO(SiiEstudioMercado estudioMercado) {
        this.emeCodigo = estudioMercado.getEmeCodigo();
        this.emeAnalisisMercado = estudioMercado.getEmeAnalisisMercado();
        this.emeDivulAcercam = estudioMercado.getEmeDivulAcercam();
        this.emeDivulAcercamFec = estudioMercado.getEmeDivulAcercamFec();
        this.emeDivulEmail = estudioMercado.getEmeDivulEmail();
        this.emeDivulEmailFec = estudioMercado.getEmeDivulEmailFec();
        this.emeDivulOtro = estudioMercado.getEmeDivulOtro();
        this.emeDivulOtroEspec = estudioMercado.getEmeDivulOtroEspec();
        this.emeDivulOtroFec = estudioMercado.getEmeDivulOtroFec();
        this.emeDivulProv = estudioMercado.getEmeDivulProv();
        this.emeDivulProvFec = estudioMercado.getEmeDivulProvFec();
        this.emeDivulTel = estudioMercado.getEmeDivulTel();
        this.emeDivulTelFec = estudioMercado.getEmeDivulTelFec();
        this.emeFecha = estudioMercado.getEmeFecha();
        this.emeObservaciones = estudioMercado.getEmeObservaciones();
        this.emeReqPolizas = estudioMercado.getEmeReqPolizas();
        
        //Proceso contratacion
        if (estudioMercado.getSiiProcesoContratacion1() != null ) {
            this.procesoContratacionVO = new ProcesoContratacionVO(estudioMercado.getSiiProcesoContratacion1());
        }
        
        //Estado Estudio Mercado
        if (estudioMercado.getSiiEstadoEstudioMerc()!=null) {
            this.estadoEstudioMercVO = new EstadoEstudioMercVO(estudioMercado.getSiiEstadoEstudioMerc());
            this.idEstadoAnterior = estudioMercado.getSiiEstadoEstudioMerc().getEemCodigo();
        }        
    }
    
    public void setEmeAnalisisMercado(String emeAnalisisMercado) {
        this.emeAnalisisMercado = emeAnalisisMercado;
    }

    public String getEmeAnalisisMercado() {
        return emeAnalisisMercado;
    }

    public void setEmeCodigo(Long emeCodigo) {
        this.emeCodigo = emeCodigo;
    }

    public Long getEmeCodigo() {
        return emeCodigo;
    }

    public void setEmeDivulAcercam(String emeDivulAcercam) {
        this.emeDivulAcercam = emeDivulAcercam;
    }

    public String getEmeDivulAcercam() {
        return emeDivulAcercam;
    }

    public void setEmeDivulAcercamFec(Date emeDivulAcercamFec) {
        this.emeDivulAcercamFec = emeDivulAcercamFec;
    }

    public Date getEmeDivulAcercamFec() {
        return emeDivulAcercamFec;
    }

    public void setEmeDivulEmail(String emeDivulEmail) {
        this.emeDivulEmail = emeDivulEmail;
    }

    public String getEmeDivulEmail() {
        return emeDivulEmail;
    }

    public void setEmeDivulEmailFec(Date emeDivulEmailFec) {
        this.emeDivulEmailFec = emeDivulEmailFec;
    }

    public Date getEmeDivulEmailFec() {
        return emeDivulEmailFec;
    }

    public void setEmeDivulOtro(String emeDivulOtro) {
        this.emeDivulOtro = emeDivulOtro;
    }

    public String getEmeDivulOtro() {
        return emeDivulOtro;
    }

    public void setEmeDivulOtroEspec(String emeDivulOtroEspec) {
        this.emeDivulOtroEspec = emeDivulOtroEspec;
    }

    public String getEmeDivulOtroEspec() {
        return emeDivulOtroEspec;
    }

    public void setEmeDivulOtroFec(Date emeDivulOtroFec) {
        this.emeDivulOtroFec = emeDivulOtroFec;
    }

    public Date getEmeDivulOtroFec() {
        return emeDivulOtroFec;
    }

    public void setEmeDivulProv(String emeDivulProv) {
        this.emeDivulProv = emeDivulProv;
    }

    public String getEmeDivulProv() {
        return emeDivulProv;
    }

    public void setEmeDivulProvFec(Date emeDivulProvFec) {
        this.emeDivulProvFec = emeDivulProvFec;
    }

    public Date getEmeDivulProvFec() {
        return emeDivulProvFec;
    }

    public void setEmeDivulTel(String emeDivulTel) {
        this.emeDivulTel = emeDivulTel;
    }

    public String getEmeDivulTel() {
        return emeDivulTel;
    }

    public void setEmeDivulTelFec(Date emeDivulTelFec) {
        this.emeDivulTelFec = emeDivulTelFec;
    }

    public Date getEmeDivulTelFec() {
        return emeDivulTelFec;
    }

    public void setEmeFecha(Date emeFecha) {
        this.emeFecha = emeFecha;
    }

    public Date getEmeFecha() {
        return emeFecha;
    }

    public void setEmeObservaciones(String emeObservaciones) {
        this.emeObservaciones = emeObservaciones;
    }

    public String getEmeObservaciones() {
        return emeObservaciones;
    }

    public void setEmeReqPolizas(String emeReqPolizas) {
        this.emeReqPolizas = emeReqPolizas;
    }

    public String getEmeReqPolizas() {
        return emeReqPolizas;
    }


    public void setCotizacionEstudioListVO(List<CotizacionEstudioVO> cotizacionEstudioListVO) {
        this.cotizacionEstudioListVO = cotizacionEstudioListVO;
    }

    public List<CotizacionEstudioVO> getCotizacionEstudioListVO() {
        return cotizacionEstudioListVO;
    }
    //    public void setSiiCotizacionEstudioList(List<SiiCotizacionEstudio> siiCotizacionEstudioList) {
//        this.siiCotizacionEstudioList = siiCotizacionEstudioList;
//    }

//    public List<SiiCotizacionEstudio> getSiiCotizacionEstudioList() {
//        return siiCotizacionEstudioList;
//    }

    public void setProcesoContratacionVO(ProcesoContratacionVO procesoContratacionVO) {
        this.procesoContratacionVO = procesoContratacionVO;
    }

    public ProcesoContratacionVO getProcesoContratacionVO() {
        return procesoContratacionVO;
    }
    //    public void setSiiProcesoContratacion1(SiiProcesoContratacion siiProcesoContratacion1) {
  //      this.siiProcesoContratacion1 = siiProcesoContratacion1;
    //}

//    public SiiProcesoContratacion getSiiProcesoContratacion1() {
  //      return siiProcesoContratacion1;
    //}

    public void setEstadoEstudioMercVO(EstadoEstudioMercVO estadoEstudioMercVO) {
        this.estadoEstudioMercVO = estadoEstudioMercVO;
    }

    public EstadoEstudioMercVO getEstadoEstudioMercVO() {
        return estadoEstudioMercVO;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}
