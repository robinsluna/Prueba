package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreRecaudo;

import java.util.Date;
import java.util.List;

public class CierreRecaudoVO {
    
    private Long cirCodigo;
    private Integer cirVigencia;
    private Integer mesCodigo;
    private Integer cirConsecutivo;
    private Date cirFechaCieCar;
    private Date cirFechaCieCont;
    private Date cirFechaCierre;
    private List<DistribucionMesVO> distribucionMesList;
    private EstadoCierrreRecVO estadoCierrreRecVo;
    private Long idEstadoAnterior;
    private String mesNombre;
    
    public CierreRecaudoVO(SiiCierreRecaudo siiCierreRecaudo) {
       this.cirCodigo = siiCierreRecaudo.getCirCodigo();
       this.cirVigencia = siiCierreRecaudo.getCirVigencia();
       this.mesCodigo = siiCierreRecaudo.getMesCodigo();
       this.cirConsecutivo = siiCierreRecaudo.getCirConsecutivo();
       this.cirFechaCieCar = siiCierreRecaudo.getCirFechaCieCar();
       this.cirFechaCieCont = siiCierreRecaudo.getCirFechaCieCont();
       this.cirFechaCierre = siiCierreRecaudo.getCirFechaCierre();
       
       //Estado
       if(siiCierreRecaudo.getSiiEstadoCierrreRec()!= null){
           this.estadoCierrreRecVo = new EstadoCierrreRecVO(siiCierreRecaudo.getSiiEstadoCierrreRec());
            this.idEstadoAnterior = siiCierreRecaudo.getSiiEstadoCierrreRec().getEcrCodigo();
        }
    }
    
    
    public CierreRecaudoVO() {
       
    }

    public void setCirCodigo(Long cirCodigo) {
        this.cirCodigo = cirCodigo;
    }

    public Long getCirCodigo() {
        return cirCodigo;
    }

    public void setCirVigencia(Integer cirVigencia) {
        this.cirVigencia = cirVigencia;
    }

    public Integer getCirVigencia() {
        return cirVigencia;
    }

    public void setMesCodigo(Integer mesCodigo) {
        this.mesCodigo = mesCodigo;
    }

    public Integer getMesCodigo() {
        return mesCodigo;
    }

    public void setDistribucionMesList(List<DistribucionMesVO> distribucionMesList) {
        this.distribucionMesList = distribucionMesList;
    }

    public List<DistribucionMesVO> getDistribucionMesList() {
        return distribucionMesList;
    }

    public void setEstadoCierrreRecVo(EstadoCierrreRecVO estadoCierrreRecVo) {
        this.estadoCierrreRecVo = estadoCierrreRecVo;
    }

    public EstadoCierrreRecVO getEstadoCierrreRecVo() {
        return estadoCierrreRecVo;
    }

    public void setCirConsecutivo(Integer cirConsecutivo) {
        this.cirConsecutivo = cirConsecutivo;
    }

    public Integer getCirConsecutivo() {
        return cirConsecutivo;
    }

    public void setCirFechaCieCar(Date cirFechaCieCar) {
        this.cirFechaCieCar = cirFechaCieCar;
    }

    public Date getCirFechaCieCar() {
        return cirFechaCieCar;
    }

    public void setCirFechaCieCont(Date cirFechaCieCont) {
        this.cirFechaCieCont = cirFechaCieCont;
    }

    public Date getCirFechaCieCont() {
        return cirFechaCieCont;
    }

    public void setCirFechaCierre(Date cirFechaCierre) {
        this.cirFechaCierre = cirFechaCierre;
    }

    public Date getCirFechaCierre() {
        return cirFechaCierre;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public void setMesNombre(String mesNombre) {
        this.mesNombre = mesNombre;
    }

    public String getMesNombre() {
        return mesNombre;
    }
}
