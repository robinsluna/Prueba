/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Mónica Pabón
 * FECHA	: 23-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCdp;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;

import java.util.List;

public class EstadoSolicAutorizVO {
    
    private Long esaCodigo;
    private String esaNombre;
    private List<SolicitudAutorizaVO> solicitudAutorizaList;

   

    public EstadoSolicAutorizVO(SiiEstadoSolicAutoriz siiEstadoSolicAutoriz){
        this.esaCodigo = siiEstadoSolicAutoriz.getEsaCodigo();
        this.esaNombre = siiEstadoSolicAutoriz.getEsaNombre();
    }
    
    public EstadoSolicAutorizVO() {
    }

    public void setEsaCodigo(Long esaCodigo) {
        this.esaCodigo = esaCodigo;
    }

    public Long getEsaCodigo() {
        return esaCodigo;
    }

    public void setEsaNombre(String esaNombre) {
        this.esaNombre = esaNombre;
    }

    public String getEsaNombre() {
        return esaNombre;
    }

    public void setSolicitudAutorizaList(List<SolicitudAutorizaVO> solicitudAutorizaList) {
        this.solicitudAutorizaList = solicitudAutorizaList;
    }

    public List<SolicitudAutorizaVO> getSolicitudAutorizaList() {
        return solicitudAutorizaList;
    }


}
