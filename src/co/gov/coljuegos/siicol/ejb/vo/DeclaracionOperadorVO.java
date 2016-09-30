package co.gov.coljuegos.siicol.ejb.vo;

import java.util.Date;

public class DeclaracionOperadorVO {
    
    private Long dopCodigo;
    private Date dopFecha;
    private Long dopTipo;
    
    
    public DeclaracionOperadorVO() {
       
    }


    public void setDopCodigo(Long dopCodigo) {
        this.dopCodigo = dopCodigo;
    }

    public Long getDopCodigo() {
        return dopCodigo;
    }

    public void setDopFecha(Date dopFecha) {
        this.dopFecha = dopFecha;
    }

    public Date getDopFecha() {
        return dopFecha;
    }

    public void setDopTipo(Long dopTipo) {
        this.dopTipo = dopTipo;
    }

    public Long getDopTipo() {
        return dopTipo;
    }

}
