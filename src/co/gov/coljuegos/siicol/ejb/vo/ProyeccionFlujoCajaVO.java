/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Diana Caro
 * FECHA	: 20-09-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPfc;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionFlujoCaja;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ProyeccionFlujoCajaVO {

    private Long pfcCodigo;
    private Date pfcFechaSolicitud;
    private Integer pfcVigencia;
    private EstadoPfcVO estadoPfcVo;
    private List<DistribucionPfcVO> siiDistribucionPfcVOList;

    public ProyeccionFlujoCajaVO(SiiProyeccionFlujoCaja unSiiProyeccionFlujoCaja) {
        this.pfcCodigo = unSiiProyeccionFlujoCaja.getPfcCodigo();
        this.pfcFechaSolicitud = unSiiProyeccionFlujoCaja.getPfcFechaSolicitud();
        this.pfcVigencia = unSiiProyeccionFlujoCaja.getPfcVigencia();
        //Padres:
        this.estadoPfcVo = new EstadoPfcVO(unSiiProyeccionFlujoCaja.getSiiEstadoPfc());
    }

    public void setEstadoPfcVo(EstadoPfcVO siiEstadoPfcVo) {
        this.estadoPfcVo = siiEstadoPfcVo;
    }

    public EstadoPfcVO getEstadoPfcVo() {
        return estadoPfcVo;
    }

    public ProyeccionFlujoCajaVO() {

    }

    public void setPfcCodigo(Long pfcCodigo) {
        this.pfcCodigo = pfcCodigo;
    }

    public Long getPfcCodigo() {
        return pfcCodigo;
    }


    public void setPfcFechaSolicitud(Date pfcFechaSolicitud) {
        this.pfcFechaSolicitud = pfcFechaSolicitud;
    }

    public Date getPfcFechaSolicitud() {
        return pfcFechaSolicitud;
    }

    public void setPfcVigencia(Integer pfcVigencia) {
        this.pfcVigencia = pfcVigencia;
    }

    public Integer getPfcVigencia() {
        return pfcVigencia;
    }


    public void setSiiDistribucionPfcVOList(List<DistribucionPfcVO> siiDistribucionPfcVOList) {
        this.siiDistribucionPfcVOList = siiDistribucionPfcVOList;
    }

    public List<DistribucionPfcVO> getSiiDistribucionPfcVOList() {
        return siiDistribucionPfcVOList;
    }
}
