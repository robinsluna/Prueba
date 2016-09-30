package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAcuerdoPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAcuerdoPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoOrigen;

import java.util.Date;
import java.util.List;

public class AcuerdoPagoVO {
    private Long apaCodigo;
    private Date apaFecha;
    private Date apaFechaResol;
    private String apaNumResol;
    private Integer apaNumero;
    private List<CuotaOperadorVO> cuotaOperadorListVo;
    private TipoOrigenVO tipoOrigenVo;
    private PersonaVO personaVo;
    private EstadoAcuerdoPagoVO estadoAcuerdoPagoVo;
    private String apaDocOrigen;
    private Date apaFechaAprComite;
    private Date apaFechaFin;
    private Date apaFechaFirmaRes;
    private Date apaFechaInicio;
    private String apaNumComiteApr;
    private String apaResolucModif;
   
    public AcuerdoPagoVO() {
       
    }
    
    public AcuerdoPagoVO(SiiAcuerdoPago siiAcuerdoPago) {
       this.apaCodigo = siiAcuerdoPago.getApaCodigo();
       this.apaFecha = siiAcuerdoPago.getApaFecha();
       this.apaFechaResol = siiAcuerdoPago.getApaFechaResol();
       this.apaNumResol = siiAcuerdoPago.getApaNumResol();
       this.apaNumero = siiAcuerdoPago.getApaNumero();
       if(siiAcuerdoPago.getSiiPersona()!= null){
           this.personaVo= new PersonaVO(siiAcuerdoPago.getSiiPersona());
        }
       if(siiAcuerdoPago.getSiiTipoOrigen()!= null){
           this.tipoOrigenVo = new TipoOrigenVO(siiAcuerdoPago.getSiiTipoOrigen());
        }
       if(siiAcuerdoPago.getSiiEstadoAcuerdoPago()!= null){
           this.estadoAcuerdoPagoVo = new EstadoAcuerdoPagoVO(siiAcuerdoPago.getSiiEstadoAcuerdoPago());
        }
       this.apaDocOrigen = siiAcuerdoPago.getApaDocOrigen();
       this.apaFechaAprComite = siiAcuerdoPago.getApaFechaAprComite();
       this.apaFechaFin = siiAcuerdoPago.getApaFechaFin();
       this.apaFechaFirmaRes = siiAcuerdoPago.getApaFechaFirmaRes();
       this.apaFechaInicio =  siiAcuerdoPago.getApaFechaInicio();
       this.apaNumComiteApr = siiAcuerdoPago.getApaNumComiteApr();
       this.apaResolucModif = siiAcuerdoPago.getApaResolucModif();
       
    }

    public void setApaCodigo(Long apaCodigo) {
        this.apaCodigo = apaCodigo;
    }

    public Long getApaCodigo() {
        return apaCodigo;
    }

    public void setApaFecha(Date apaFecha) {
        this.apaFecha = apaFecha;
    }

    public Date getApaFecha() {
        return apaFecha;
    }

    public void setApaFechaResol(Date apaFechaResol) {
        this.apaFechaResol = apaFechaResol;
    }

    public Date getApaFechaResol() {
        return apaFechaResol;
    }

    public void setApaNumResol(String apaNumResol) {
        this.apaNumResol = apaNumResol;
    }

    public String getApaNumResol() {
        return apaNumResol;
    }

    public void setApaNumero(Integer apaNumero) {
        this.apaNumero = apaNumero;
    }

    public Integer getApaNumero() {
        return apaNumero;
    }

    public void setCuotaOperadorListVo(List<CuotaOperadorVO> cuotaOperadorListVo) {
        this.cuotaOperadorListVo = cuotaOperadorListVo;
    }

    public List<CuotaOperadorVO> getCuotaOperadorListVo() {
        return cuotaOperadorListVo;
    }

    public void setTipoOrigenVo(TipoOrigenVO tipoOrigenVo) {
        this.tipoOrigenVo = tipoOrigenVo;
    }

    public TipoOrigenVO getTipoOrigenVo() {
        return tipoOrigenVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setEstadoAcuerdoPagoVo(EstadoAcuerdoPagoVO estadoAcuerdoPagoVo) {
        this.estadoAcuerdoPagoVo = estadoAcuerdoPagoVo;
    }

    public EstadoAcuerdoPagoVO getEstadoAcuerdoPagoVo() {
        return estadoAcuerdoPagoVo;
    }

    public void setApaDocOrigen(String apaDocOrigen) {
        this.apaDocOrigen = apaDocOrigen;
    }

    public String getApaDocOrigen() {
        return apaDocOrigen;
    }

    public void setApaFechaAprComite(Date apaFechaAprComite) {
        this.apaFechaAprComite = apaFechaAprComite;
    }

    public Date getApaFechaAprComite() {
        return apaFechaAprComite;
    }

    public void setApaFechaFin(Date apaFechaFin) {
        this.apaFechaFin = apaFechaFin;
    }

    public Date getApaFechaFin() {
        return apaFechaFin;
    }

    public void setApaFechaFirmaRes(Date apaFechaFirmaRes) {
        this.apaFechaFirmaRes = apaFechaFirmaRes;
    }

    public Date getApaFechaFirmaRes() {
        return apaFechaFirmaRes;
    }

    public void setApaFechaInicio(Date apaFechaInicio) {
        this.apaFechaInicio = apaFechaInicio;
    }

    public Date getApaFechaInicio() {
        return apaFechaInicio;
    }

    public void setApaNumComiteApr(String apaNumComiteApr) {
        this.apaNumComiteApr = apaNumComiteApr;
    }

    public String getApaNumComiteApr() {
        return apaNumComiteApr;
    }

    public void setApaResolucModif(String apaResolucModif) {
        this.apaResolucModif = apaResolucModif;
    }

    public String getApaResolucModif() {
        return apaResolucModif;
    }
}
