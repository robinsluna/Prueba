/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 16-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCdp;

import java.util.List;

public class EstadoCdpVO {
    
    private Long ecdCodigo;
    private String ecdDescripcion;
    private String ecdNombre;
    private List<CdpVO> cdpListVO;


    public void setCdpListVO(List<CdpVO> cdpListVO) {
        this.cdpListVO = cdpListVO;
    }

    public List<CdpVO> getCdpListVO() {
        return cdpListVO;
    }

    public EstadoCdpVO(SiiEstadoCdp siiEstadoCdp){
        this.ecdCodigo = siiEstadoCdp.getEcdCodigo();
        this.ecdDescripcion = siiEstadoCdp.getEcdDescripcion();
        this.ecdNombre = siiEstadoCdp.getEcdNombre();
    }
    
    public EstadoCdpVO() {
    }

    public void setEcdCodigo(Long ecdCodigo) {
        this.ecdCodigo = ecdCodigo;
    }

    public Long getEcdCodigo() {
        return ecdCodigo;
    }

    public void setEcdDescripcion(String ecdDescripcion) {
        this.ecdDescripcion = ecdDescripcion;
    }

    public String getEcdDescripcion() {
        return ecdDescripcion;
    }

    public void setEcdNombre(String ecdNombre) {
        this.ecdNombre = ecdNombre;
    }

    public String getEcdNombre() {
        return ecdNombre;
    }

}
