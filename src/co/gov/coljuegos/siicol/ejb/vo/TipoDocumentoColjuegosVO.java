package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocumentoColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmaDocumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocumentoColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmasRequeridas;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuncion;

import java.util.List;

public class TipoDocumentoColjuegosVO {
    private Long tdoCodigo;
    private String tdoDescripcion;
    private String tdoNombre;
    private List<SiiFirmasRequeridas> siiFirmasRequeridasList1;

    public TipoDocumentoColjuegosVO(SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos) {
        this.tdoCodigo = siiTipoDocumentoColjuegos.getTdoCodigo();
        this.tdoDescripcion = siiTipoDocumentoColjuegos.getTdoDescripcion();
        this.tdoNombre = siiTipoDocumentoColjuegos.getTdoNombre();
    }

    public TipoDocumentoColjuegosVO() {
    }

    public void setTdoCodigo(Long tdoCodigo) {
        this.tdoCodigo = tdoCodigo;
    }

    public Long getTdoCodigo() {
        return tdoCodigo;
    }

    public void setTdoDescripcion(String tdoDescripcion) {
        this.tdoDescripcion = tdoDescripcion;
    }

    public String getTdoDescripcion() {
        return tdoDescripcion;
    }

    public void setTdoNombre(String tdoNombre) {
        this.tdoNombre = tdoNombre;
    }

    public String getTdoNombre() {
        return tdoNombre;
    }

    public void setSiiFirmasRequeridasList1(List<SiiFirmasRequeridas> siiFirmasRequeridasList1) {
        this.siiFirmasRequeridasList1 = siiFirmasRequeridasList1;
    }

    public List<SiiFirmasRequeridas> getSiiFirmasRequeridasList1() {
        return siiFirmasRequeridasList1;
    }
}
