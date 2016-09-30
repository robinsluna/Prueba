package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionPago;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSoporte;

import java.util.List;

public class TipoDocSoporteVO {
    private static final long serialVersionUID = -8906016547862210479L;
    private Long tdsCodigo;
    private String tdsNombre;

    public TipoDocSoporteVO (SiiTipoDocSoporte siiTipoDocSoporte){
        this.tdsCodigo = siiTipoDocSoporte.getTdsCodigo();
        this.tdsNombre = siiTipoDocSoporte.getTdsNombre();
    } 

    public TipoDocSoporteVO () {
        
    }
    public void setTdsCodigo(Long tdsCodigo) {
        this.tdsCodigo = tdsCodigo;
    }

    public Long getTdsCodigo() {
        return tdsCodigo;
    }

    public void setTdsNombre(String tdsNombre) {
        this.tdsNombre = tdsNombre;
    }

    public String getTdsNombre() {
        return tdsNombre;
    }
}
