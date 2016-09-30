/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Glenis Reyes
 * FECHA	: 28-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPfcMens;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class SolicitudPfcMensualVO {

    private Long spfCodigo;
    private Date spfFecha;
    private Integer spfVigencia;
    private List<SolicPfcmDetalleVO> solicPfcmDetalleVo;
    private MesVO mesVo;
    private EstadoSolicPfcmVO estadoSolicPfcmVo;
    private List<SolicitudPFCMenDetalleVO> listSolicitudPFCMenDetalleVo;
    private BigDecimal spfValorAprobado;
    private List<ModificPfcAnualVO> InsertarModificPfcAnualVo; //se usa para la actualizaciòn
    private List<ModificPfcAnualVO> borrarModificPfcAnualVo; //se usa para la actualizaciòn
    private Long idEstadoAnterior;

    public SolicitudPfcMensualVO(SiiSolicitudPfcMens siiSolicitudPfcMens) {
        if (siiSolicitudPfcMens != null) {
            this.spfCodigo = siiSolicitudPfcMens.getSpfCodigo();
            this.spfFecha = siiSolicitudPfcMens.getSpfFecha();
            this.spfVigencia = siiSolicitudPfcMens.getSpfVigencia();
            this.mesVo = new MesVO(siiSolicitudPfcMens.getSiiMes1());

            //Estado
            if (siiSolicitudPfcMens.getSiiEstadoSolicPfcm() != null) {
                this.estadoSolicPfcmVo = new EstadoSolicPfcmVO(siiSolicitudPfcMens.getSiiEstadoSolicPfcm());
                this.idEstadoAnterior = siiSolicitudPfcMens.getSiiEstadoSolicPfcm().getEspCodigo();
            }
        }
    }


    public void setInsertarModificPfcAnualVo(List<ModificPfcAnualVO> InsertarModificPfcAnualVo) {
        this.InsertarModificPfcAnualVo = InsertarModificPfcAnualVo;
    }

    public List<ModificPfcAnualVO> getInsertarModificPfcAnualVo() {
        return InsertarModificPfcAnualVo;
    }

    public void setBorrarModificPfcAnualVo(List<ModificPfcAnualVO> borrarModificPfcAnualVo) {
        this.borrarModificPfcAnualVo = borrarModificPfcAnualVo;
    }

    public List<ModificPfcAnualVO> getBorrarModificPfcAnualVo() {
        return borrarModificPfcAnualVo;
    }


    public void setSpfValorAprobado(BigDecimal spfValorAprobado) {
        this.spfValorAprobado = spfValorAprobado;
    }

    public BigDecimal getSpfValorAprobado() {
        return spfValorAprobado;
    }

    public void setListSolicitudPFCMenDetalleVo(List<SolicitudPFCMenDetalleVO> listSolicitudPFCMenDetalleVo) {
        this.listSolicitudPFCMenDetalleVo = listSolicitudPFCMenDetalleVo;
    }

    public List<SolicitudPFCMenDetalleVO> getListSolicitudPFCMenDetalleVo() {
        return listSolicitudPFCMenDetalleVo;
    }

    public SolicitudPfcMensualVO() {
    }

    public void setSpfCodigo(Long spfCodigo) {
        this.spfCodigo = spfCodigo;
    }

    public Long getSpfCodigo() {
        return spfCodigo;
    }

    public void setSpfFecha(Date spfFecha) {
        this.spfFecha = spfFecha;
    }

    public Date getSpfFecha() {
        return spfFecha;
    }

    public void setSpfVigencia(Integer spfVigencia) {
        this.spfVigencia = spfVigencia;
    }

    public Integer getSpfVigencia() {
        return spfVigencia;
    }

    public void setSolicPfcmDetalleVo(List<SolicPfcmDetalleVO> solicPfcmDetalleVo) {
        this.solicPfcmDetalleVo = solicPfcmDetalleVo;
    }

    public List<SolicPfcmDetalleVO> getSolicPfcmDetalleVo() {
        return solicPfcmDetalleVo;
    }


    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setEstadoSolicPfcmVo(EstadoSolicPfcmVO estadoSolicPfcmVo) {
        this.estadoSolicPfcmVo = estadoSolicPfcmVo;
    }

    public EstadoSolicPfcmVO getEstadoSolicPfcmVo() {
        return estadoSolicPfcmVo;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}
