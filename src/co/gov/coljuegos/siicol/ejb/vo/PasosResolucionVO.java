package co.gov.coljuegos.siicol.ejb.vo;

import java.util.Date;

public class PasosResolucionVO {
    
    private Long trdCodigo;
    private String paso;
    private String estado;
    private Date fecha;
        
    public PasosResolucionVO() {
        super();
    }

    public String getPaso() {
        return paso;
    }

    public void setPaso(String paso) {
        this.paso = paso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getTrdCodigo() {
        return trdCodigo;
    }

    public void setTrdCodigo(Long trdCodigo) {
        this.trdCodigo = trdCodigo;
    }
}
