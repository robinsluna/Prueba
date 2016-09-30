/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 02-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel5;

public class PrNivel5VO {
    
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel4;
    private String tipoPlan;
    private Integer vigencia;
    
    public PrNivel5VO(PrNivel5 prNivel5){
        this.interno = prNivel5.getInterno();
        this.vigencia = prNivel5.getVigencia();
        this.codigo = prNivel5.getCodigo();
        this.descripcion = prNivel5.getDescripcion();
        this.tipoPlan = prNivel5.getTipoPlan();
    }
    
    public PrNivel5VO() {
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    public Long getInterno() {
        return interno;
    }

    public void setInternoNivel4(Long internoNivel4) {
        this.internoNivel4 = internoNivel4;
    }

    public Long getInternoNivel4() {
        return internoNivel4;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }
    



}
