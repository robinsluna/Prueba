package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoDevolucion;

public class MotivoDevolucionVO {
    
    private Long mdeCodigo;
    private String mdeNombre;
    
    public MotivoDevolucionVO() {
        
    }
    
    public MotivoDevolucionVO(SiiMotivoDevolucion siiMotivoDevolucion) {
        this.mdeCodigo = siiMotivoDevolucion.getMdeCodigo();
        this.mdeNombre = siiMotivoDevolucion.getMdeNombre();
    }


    public void setMdeCodigo(Long mdeCodigo) {
        this.mdeCodigo = mdeCodigo;
    }

    public Long getMdeCodigo() {
        return mdeCodigo;
    }

    public void setMdeNombre(String mdeNombre) {
        this.mdeNombre = mdeNombre;
    }

    public String getMdeNombre() {
        return mdeNombre;
    }
}
