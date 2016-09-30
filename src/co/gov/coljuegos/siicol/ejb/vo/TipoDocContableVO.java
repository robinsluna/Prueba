/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;

import java.util.List;


/**
 * Value Object para el Tipo de Documento Contable.
 * @author Camilo Miranda
 */
public class TipoDocContableVO 
{
    private String tdcCodigo;
    private String tdcNombre;
    private String tdcPermiteManual;
    private String tdcActivo;
    private List<DocumentoContableVO> documentoContableList;
    private List<CuentaContTipoDocContVO> cuentaContTipoDocContList;
    private List<OrdenPagoVO> ordenPagoList;
    
    
    
    /**
     * Constructor.
     */
    public TipoDocContableVO() { }
    
    
    /**
     * Constructor.
     * @param siiTipoDocContable
     */
    public TipoDocContableVO (SiiTipoDocContable siiTipoDocContable) {
        if (siiTipoDocContable!=null) {
            this.tdcCodigo = siiTipoDocContable.getTdcCodigo();
            this.tdcNombre = siiTipoDocContable.getTdcNombre();
            this.tdcPermiteManual = siiTipoDocContable.getTdcPermiteManual();
            this.tdcActivo = siiTipoDocContable.getTdcActivo();
        }
    }


    public void setTdcCodigo(String tdcCodigo) {
        this.tdcCodigo = tdcCodigo;
    }

    public String getTdcCodigo() {
        return tdcCodigo;
    }

    public void setTdcNombre(String tdcNombre) {
        this.tdcNombre = tdcNombre;
    }

    public String getTdcNombre() {
        return tdcNombre;
    }

    public void setDocumentoContableList(List<DocumentoContableVO> documentoContableList) {
        this.documentoContableList = documentoContableList;
    }

    public List<DocumentoContableVO> getDocumentoContableList() {
        return documentoContableList;
    }

    public void setTdcPermiteManual(String tdcPermiteManual) {
        this.tdcPermiteManual = tdcPermiteManual;
    }

    public String getTdcPermiteManual() {
        return tdcPermiteManual;
    }

    public void setCuentaContTipoDocContList(List<CuentaContTipoDocContVO> cuentaContTipoDocContList) {
        this.cuentaContTipoDocContList = cuentaContTipoDocContList;
    }

    public List<CuentaContTipoDocContVO> getCuentaContTipoDocContList() {
        return cuentaContTipoDocContList;
    }

    public void setOrdenPagoList(List<OrdenPagoVO> ordenPagoList) {
        this.ordenPagoList = ordenPagoList;
    }

    public List<OrdenPagoVO> getOrdenPagoList() {
        return ordenPagoList;
    }

    public String getTdcActivo() {
        return tdcActivo;
    }

    public void setTdcActivo(String tdcActivo) {
        this.tdcActivo = tdcActivo;
    }
}
