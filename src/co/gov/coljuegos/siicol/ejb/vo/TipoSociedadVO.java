package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSociedad;

public class TipoSociedadVO {

    private Long tsoCodigo;
    private String tsoNombre;

    public TipoSociedadVO() {

    }

    public TipoSociedadVO(SiiTipoSociedad siiTipoSociedad) {

        this.tsoCodigo = siiTipoSociedad.getTsoCodigo();
        this.tsoNombre = siiTipoSociedad.getTsoNombre();

    }

    public Long getTsoCodigo() {
        return tsoCodigo;
    }

    public void setTsoCodigo(Long tsoCodigo) {
        this.tsoCodigo = tsoCodigo;
    }

    public String getTsoNombre() {
        return tsoNombre;
    }

    public void setTsoNombre(String tsoNombre) {
        this.tsoNombre = tsoNombre;
    }
}
