package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsigRecaudoAaEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsignacionRecaudoAa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoEstablec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;

import java.math.BigDecimal;

import java.util.List;

public class AsigRecaudoAaEstablVO {
    private Long asrCodigo;
    private String asrNumEstablec;
    private BigDecimal asrValor;
    private UbicacionVO ubicacionVo;
    private AsignacionRecaudoAAVO asignacionRecaudoAaVo;
   
    
    public AsigRecaudoAaEstablVO(SiiAsigRecaudoAaEstabl siiAsigRecaudoAaEstabl) {
        this.asrCodigo = siiAsigRecaudoAaEstabl.getAsrCodigo();
        this.asrNumEstablec = siiAsigRecaudoAaEstabl.getAsrNumEstablec();
        this.asrValor = siiAsigRecaudoAaEstabl.getAsrValor();
        if(siiAsigRecaudoAaEstabl.getSiiUbicacion() != null){
            this.ubicacionVo = new UbicacionVO(siiAsigRecaudoAaEstabl.getSiiUbicacion());
        }
        if(siiAsigRecaudoAaEstabl.getSiiAsignacionRecaudoAa() != null){
            this.asignacionRecaudoAaVo = new AsignacionRecaudoAAVO(siiAsigRecaudoAaEstabl.getSiiAsignacionRecaudoAa());
        }
    }
    public AsigRecaudoAaEstablVO() {        
    }


    public void setAsrCodigo(Long asrCodigo) {
        this.asrCodigo = asrCodigo;
    }

    public Long getAsrCodigo() {
        return asrCodigo;
    }

    public void setAsrNumEstablec(String asrNumEstablec) {
        this.asrNumEstablec = asrNumEstablec;
    }

    public String getAsrNumEstablec() {
        return asrNumEstablec;
    }

    public void setAsrValor(BigDecimal asrValor) {
        this.asrValor = asrValor;
    }

    public BigDecimal getAsrValor() {
        return asrValor;
    }

    public void setUbicacionVo(UbicacionVO ubicacionVo) {
        this.ubicacionVo = ubicacionVo;
    }

    public UbicacionVO getUbicacionVo() {
        return ubicacionVo;
    }

    public void setAsignacionRecaudoAaVo(AsignacionRecaudoAAVO asignacionRecaudoAaVo) {
        this.asignacionRecaudoAaVo = asignacionRecaudoAaVo;
    }

    public AsignacionRecaudoAAVO getAsignacionRecaudoAaVo() {
        return asignacionRecaudoAaVo;
    }

   
}
