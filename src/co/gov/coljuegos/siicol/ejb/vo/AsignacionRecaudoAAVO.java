package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsigRecaudoAaEstabl;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsignacionRecaudoAa;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class AsignacionRecaudoAAVO {
    
    private Long araCodigo;
    private Date araFecha;
    private Date araFechaPago;
    private String araResolucion;
    private BigDecimal araValor;
    private List<AsigRecaudoAaEstablVO> asigRecaudoAaEstablListVo;
    private DistribucionMesVO distribucionMesVo;
    
    
    public AsignacionRecaudoAAVO(SiiAsignacionRecaudoAa siiAsignacionRecaudoAa) {        
     this.araCodigo = siiAsignacionRecaudoAa.getAraCodigo();
     this.araFecha = siiAsignacionRecaudoAa.getAraFecha();
     this.araFechaPago = siiAsignacionRecaudoAa.getAraFechaPago();
     this.araResolucion = siiAsignacionRecaudoAa.getAraResolucion();
     this.araValor = siiAsignacionRecaudoAa.getAraValor();
     
     if(siiAsignacionRecaudoAa.getSiiDistribucionMes()!= null){
         this.distribucionMesVo = new DistribucionMesVO(siiAsignacionRecaudoAa.getSiiDistribucionMes()); 
        }
    }
    
    public AsignacionRecaudoAAVO() {        
    }


    public void setAraCodigo(Long araCodigo) {
        this.araCodigo = araCodigo;
    }

    public Long getAraCodigo() {
        return araCodigo;
    }

    public void setAraFecha(Date araFecha) {
        this.araFecha = araFecha;
    }

    public Date getAraFecha() {
        return araFecha;
    }

    public void setAraFechaPago(Date araFechaPago) {
        this.araFechaPago = araFechaPago;
    }

    public Date getAraFechaPago() {
        return araFechaPago;
    }

    public void setAraResolucion(String araResolucion) {
        this.araResolucion = araResolucion;
    }

    public String getAraResolucion() {
        return araResolucion;
    }

    public void setAraValor(BigDecimal araValor) {
        this.araValor = araValor;
    }

    public BigDecimal getAraValor() {
        return araValor;
    }

    public void setAsigRecaudoAaEstablListVo(List<AsigRecaudoAaEstablVO> asigRecaudoAaEstablListVo) {
        this.asigRecaudoAaEstablListVo = asigRecaudoAaEstablListVo;
    }

    public List<AsigRecaudoAaEstablVO> getAsigRecaudoAaEstablListVo() {
        return asigRecaudoAaEstablListVo;
    }

    public void setDistribucionMesVo(DistribucionMesVO distribucionMesVo) {
        this.distribucionMesVo = distribucionMesVo;
    }

    public DistribucionMesVO getDistribucionMesVo() {
        return distribucionMesVo;
    }

}
