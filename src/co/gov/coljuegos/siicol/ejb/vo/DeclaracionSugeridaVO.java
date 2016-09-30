package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionSugerida;

import java.util.Date;

public class DeclaracionSugeridaVO {
    
    private Long dsuCodigo;
    private Integer dsuConsecutivo;
    private Date dsuFecha;
    
    public DeclaracionSugeridaVO() {
    }
    
    public DeclaracionSugeridaVO(SiiDeclaracionSugerida siiDeclaracionSugerida) {
        
            this.setDsuCodigo(siiDeclaracionSugerida.getDsuCodigo());
            this.setDsuConsecutivo(siiDeclaracionSugerida.getDsuConsecutivo());
            this.setDsuFecha(siiDeclaracionSugerida.getDsuFecha());
        
    }


    public void setDsuCodigo(Long dsuCodigo) {
        this.dsuCodigo = dsuCodigo;
    }

    public Long getDsuCodigo() {
        return dsuCodigo;
    }

    public void setDsuConsecutivo(Integer dsuConsecutivo) {
        this.dsuConsecutivo = dsuConsecutivo;
    }

    public Integer getDsuConsecutivo() {
        return dsuConsecutivo;
    }

    public void setDsuFecha(Date dsuFecha) {
        this.dsuFecha = dsuFecha;
    }

    public Date getDsuFecha() {
        return dsuFecha;
    }
}
