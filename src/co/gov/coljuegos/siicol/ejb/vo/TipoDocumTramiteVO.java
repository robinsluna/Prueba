package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocumTramite;

public class TipoDocumTramiteVO {
    private Long tdtCodigo;
    private String tdtNombre;
    private String tdtTrd;

    public TipoDocumTramiteVO(SiiTipoDocumTramite tipoDocumTramite) {
        this.tdtCodigo = tipoDocumTramite.getTdtCodigo();
        this.tdtNombre = tipoDocumTramite.getTdtNombre();
        this.tdtTrd = tipoDocumTramite.getTdtTrd();
    }

    public TipoDocumTramiteVO() {

    }
    
    public void setTdtCodigo(Long tdtCodigo) {
        this.tdtCodigo = tdtCodigo;
    }

    public Long getTdtCodigo() {
        return tdtCodigo;
    }

    public void setTdtNombre(String tdtNombre) {
        this.tdtNombre = tdtNombre;
    }

    public String getTdtNombre() {
        return tdtNombre;
    }

    public void setTdtTrd(String tdtTrd) {
        this.tdtTrd = tdtTrd;
    }

    public String getTdtTrd() {
        return tdtTrd;
    }

   
}
