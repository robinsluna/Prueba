package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSolicAutoriza;

public class TipoSolicAutorizaVO {
    
    private Long tsaCodigo;
    private String tsaNombre;
    
    public TipoSolicAutorizaVO(SiiTipoSolicAutoriza siiTipoSolicAutoriza) {
        this.tsaCodigo = siiTipoSolicAutoriza.getTsaCodigo();
        this.tsaNombre = siiTipoSolicAutoriza.getTsaNombre();
    }
    
    public TipoSolicAutorizaVO() {
    }

    public void setTsaCodigo(Long tsaCodigo) {
        this.tsaCodigo = tsaCodigo;
    }

    public Long getTsaCodigo() {
        return tsaCodigo;
    }

    public void setTsaNombre(String tsaNombre) {
        this.tsaNombre = tsaNombre;
    }

    public String getTsaNombre() {
        return tsaNombre;
    }
}
