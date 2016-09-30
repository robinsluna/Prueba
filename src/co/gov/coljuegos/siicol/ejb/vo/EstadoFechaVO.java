package co.gov.coljuegos.siicol.ejb.vo;

import java.util.Date;

public class EstadoFechaVO {
    private String estado;
    private Date fecha;
    
    public EstadoFechaVO() {
        
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }
}
