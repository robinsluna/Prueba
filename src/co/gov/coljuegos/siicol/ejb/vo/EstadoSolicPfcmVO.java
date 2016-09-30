/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Glenis Reyes
 * FECHA	: 28-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicPfcm;

import java.util.List;

public class EstadoSolicPfcmVO {
    
    private Long espCodigo;
    private String espNombre;
    private List<SolicitudPfcMensualVO> solicitudPfcMensualVo;
    
    public EstadoSolicPfcmVO(SiiEstadoSolicPfcm siiEstadoSolicPfcm) {
        this.espCodigo = siiEstadoSolicPfcm.getEspCodigo();
        this.espNombre = siiEstadoSolicPfcm.getEspNombre();
    }
    
    public EstadoSolicPfcmVO() {
    }

    public void setEspCodigo(Long espCodigo) {
        this.espCodigo = espCodigo;
    }

    public Long getEspCodigo() {
        return espCodigo;
    }

    public void setEspNombre(String espNombre) {
        this.espNombre = espNombre;
    }

    public String getEspNombre() {
        return espNombre;
    }

    public void setSolicitudPfcMensualVo(List<SolicitudPfcMensualVO> solicitudPfcMensualVo) {
        this.solicitudPfcMensualVo = solicitudPfcMensualVo;
    }

    public List<SolicitudPfcMensualVO> getSolicitudPfcMensualVo() {
        return solicitudPfcMensualVo;
    }

}
