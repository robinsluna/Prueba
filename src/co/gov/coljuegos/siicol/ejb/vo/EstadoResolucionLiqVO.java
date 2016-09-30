package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucLiq;

public class EstadoResolucionLiqVO {
    
    private long erlCodigo;
    private String erlNombre;
    
    
    public EstadoResolucionLiqVO() {
        
    }
    
    public EstadoResolucionLiqVO(SiiEstadoResolucLiq siiEstadoResolucLiq  ) {
        this.erlCodigo= siiEstadoResolucLiq.getErlCodigo();
        this.erlNombre= siiEstadoResolucLiq.getErlNombre();
        
    }


    public void setErlCodigo(long erlCodigo) {
        this.erlCodigo = erlCodigo;
    }

    public long getErlCodigo() {
        return erlCodigo;
    }

    public void setErlNombre(String erlNombre) {
        this.erlNombre = erlNombre;
    }

    public String getErlNombre() {
        return erlNombre;
    }
}
