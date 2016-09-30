/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-07-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSopSolicPago;

import java.util.List;


/**
 * Value Object para el Tipo de Documento de Soporte para las Solicitudes de Pago.
 * @author Camilo Miranda
 */
public class TipoDocSopSolicPagoVO {
    
    private Long tspCodigo;
    private String tspNombre;
    
    private List<SolicitudPagoVO> solicitudPagoList;
    private List<OrdenPagoVO> ordenPagoList;
    
    
    
    /**
     * Constructor.
     */
    public TipoDocSopSolicPagoVO() { }
    
    
    /**
     * Constructor.
     * @param siiTipoDocSopSolicPago - Entity.
     */
    public TipoDocSopSolicPagoVO(SiiTipoDocSopSolicPago siiTipoDocSopSolicPago) 
    {
        if (siiTipoDocSopSolicPago!=null) {
            this.tspCodigo = siiTipoDocSopSolicPago.getTspCodigo();
            this.tspNombre = siiTipoDocSopSolicPago.getTspCombre();
        }
    }


    public void setTspCodigo(Long tspCodigo) {
        this.tspCodigo = tspCodigo;
    }

    public Long getTspCodigo() {
        return tspCodigo;
    }

    public void setTspNombre(String tspNombre) {
        this.tspNombre = tspNombre;
    }

    public String getTspNombre() {
        return tspNombre;
    }

    public void setSolicitudPagoList(List<SolicitudPagoVO> solicitudPagoList) {
        this.solicitudPagoList = solicitudPagoList;
    }

    public List<SolicitudPagoVO> getSolicitudPagoList() {
        return solicitudPagoList;
    }

    public void setOrdenPagoList(List<OrdenPagoVO> ordenPagoList) {
        this.ordenPagoList = ordenPagoList;
    }

    public List<OrdenPagoVO> getOrdenPagoList() {
        return ordenPagoList;
    }
}
