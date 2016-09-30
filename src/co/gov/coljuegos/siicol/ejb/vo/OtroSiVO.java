package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOtrosi;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class OtroSiVO {
    private Long osiCodigo;
    private Long osiConsecutivo;
    private Date osiFecha;
    private Date osiFechaCitOpe;
    private Date osiFechaFirColj;
    private Date osiFechaFirOpe;
    private Date osiFechaProgFir;
    private Date osiFechaRevAbog;
    private String osiTexValFin;
    private String osiTexValGct;
    private String osiTextoValCca;
    private EstadoOtroSiVO estadoOtroSiVo;
    private List<NovedadVO> novedadListVo;
    private List<RevisFinancOtroSiVO> revisFinancOtroSiListVo;
    private List<PolizaContratVO> polizaContratVOs;
    private ArchivoFisicoVO archivoFisicoVo;
    private Date osiFechaFin;  
    
    //campos adicionados en el VO que no vienen de la entidad 
    private SolicitudAutorizaVO solicitudAutorizaVO; 
    private ContratoVO contratoVO;
    private BigDecimal valorOtroSi;
    private Date fechaInicioEjecucion;


    public OtroSiVO() {
        
    }
    
    public OtroSiVO(SiiOtrosi otroSi) {
        this.osiCodigo = otroSi.getOsiCodigo();
        this.osiConsecutivo = otroSi.getOsiConsecutivo();
        this.osiFecha = otroSi.getOsiFecha();
        this.osiFechaCitOpe = otroSi.getOsiFechaCitOpe();
        this.osiFechaFirColj = otroSi.getOsiFechaFirColj();
        this.osiFechaFirOpe = otroSi.getOsiFechaFirOpe();
        this.osiFechaProgFir = otroSi.getOsiFechaProgFir();
        this.osiFechaRevAbog = otroSi.getOsiFechaRevAbog();
        this.osiTexValFin = otroSi.getOsiTexValFin();
        this.osiTexValGct = otroSi.getOsiTexValGct();
        this.osiTextoValCca = otroSi.getOsiTextoValCca();
        this.osiFechaFin = otroSi.getOsiFechaFin();
        
        //Padres
        if (otroSi.getSiiEstadoOtrosi()!= null) {
            this.estadoOtroSiVo = new EstadoOtroSiVO(otroSi.getSiiEstadoOtrosi());
        }
        if (otroSi.getSiiArchivoFisico() != null) {
            this.archivoFisicoVo = new ArchivoFisicoVO(otroSi.getSiiArchivoFisico());
        }
    }

    public void setOsiCodigo(Long osiCodigo) {
        this.osiCodigo = osiCodigo;
    }

    public Long getOsiCodigo() {
        return osiCodigo;
    }

    public void setOsiConsecutivo(Long osiConsecutivo) {
        this.osiConsecutivo = osiConsecutivo;
    }

    public Long getOsiConsecutivo() {
        return osiConsecutivo;
    }

    public void setOsiFecha(Date osiFecha) {
        this.osiFecha = osiFecha;
    }

    public Date getOsiFecha() {
        return osiFecha;
    }

    public void setOsiFechaCitOpe(Date osiFechaCitOpe) {
        this.osiFechaCitOpe = osiFechaCitOpe;
    }

    public Date getOsiFechaCitOpe() {
        return osiFechaCitOpe;
    }

    public void setOsiFechaFirColj(Date osiFechaFirColj) {
        this.osiFechaFirColj = osiFechaFirColj;
    }

    public Date getOsiFechaFirColj() {
        return osiFechaFirColj;
    }

    public void setOsiFechaFirOpe(Date osiFechaFirOpe) {
        this.osiFechaFirOpe = osiFechaFirOpe;
    }

    public Date getOsiFechaFirOpe() {
        return osiFechaFirOpe;
    }

    public void setOsiFechaProgFir(Date osiFechaProgFir) {
        this.osiFechaProgFir = osiFechaProgFir;
    }

    public Date getOsiFechaProgFir() {
        return osiFechaProgFir;
    }

    public void setOsiFechaRevAbog(Date osiFechaRevAbog) {
        this.osiFechaRevAbog = osiFechaRevAbog;
    }

    public Date getOsiFechaRevAbog() {
        return osiFechaRevAbog;
    }

    public void setOsiTexValFin(String osiTexValFin) {
        this.osiTexValFin = osiTexValFin;
    }

    public String getOsiTexValFin() {
        return osiTexValFin;
    }

    public void setOsiTexValGct(String osiTexValGct) {
        this.osiTexValGct = osiTexValGct;
    }

    public String getOsiTexValGct() {
        return osiTexValGct;
    }

    public void setEstadoOtroSiVo(EstadoOtroSiVO estadoOtroSiVo) {
        this.estadoOtroSiVo = estadoOtroSiVo;
    }

    public EstadoOtroSiVO getEstadoOtroSiVo() {
        return estadoOtroSiVo;
    }

    public void setNovedadListVo(List<NovedadVO> novedadListVo) {
        this.novedadListVo = novedadListVo;
    }

    public List<NovedadVO> getNovedadListVo() {
        return novedadListVo;
    }

    public void setRevisFinancOtroSiListVo(List<RevisFinancOtroSiVO> revisFinancOtroSiListVo) {
        this.revisFinancOtroSiListVo = revisFinancOtroSiListVo;
    }

    public List<RevisFinancOtroSiVO> getRevisFinancOtroSiListVo() {
        return revisFinancOtroSiListVo;
    }

    public List<PolizaContratVO> getPolizaContratVOs() {
        return polizaContratVOs;
    }

    public void setPolizaContratVOs(List<PolizaContratVO> polizaContratVOs) {
        this.polizaContratVOs = polizaContratVOs;
    }

    public SolicitudAutorizaVO getSolicitudAutorizaVO() {
        return solicitudAutorizaVO;
    }

    public void setSolicitudAutorizaVO(SolicitudAutorizaVO solicitudAutorizaVO) {
        this.solicitudAutorizaVO = solicitudAutorizaVO;
    }

    public ContratoVO getContratoVO() {
        return contratoVO;
    }

    public void setContratoVO(ContratoVO contratoVO) {
        this.contratoVO = contratoVO;
    }


    public Date getOsiFechaFin() {
        return osiFechaFin;
    }

    public void setOsiTextoValCca(String osiTextoValCca) {
        this.osiTextoValCca = osiTextoValCca;
    }

    public String getOsiTextoValCca() {
        return osiTextoValCca;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setOsiFechaFin(Date osiFechaFin) {
        this.osiFechaFin = osiFechaFin;
    }

    public void setValorOtroSi(BigDecimal valorOtroSi) {
        this.valorOtroSi = valorOtroSi;
    }

    public BigDecimal getValorOtroSi() {
        return valorOtroSi;
    }

    public void setFechaInicioEjecucion(Date fechaInicioEjecucion) {
        this.fechaInicioEjecucion = fechaInicioEjecucion;
    }

    public Date getFechaInicioEjecucion() {
        return fechaInicioEjecucion;
    }
}
