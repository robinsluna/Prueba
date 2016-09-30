/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 02-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel7;

public class PrNivel7VO {
    
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel6;
    private String tipoPlan;
    private Integer vigencia;
    
    public PrNivel7VO(PrNivel7 prNivel7){
        this.interno = prNivel7.getInterno();
        this.vigencia = prNivel7.getVigencia();
        this.codigo = prNivel7.getCodigo();
        this.descripcion = prNivel7.getDescripcion();
        this.tipoPlan = prNivel7.getTipoPlan();
    }
    
    public PrNivel7VO() {
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

    public void setInternoNivel6(Long internoNivel6) {
        this.internoNivel6 = internoNivel6;
    }

    public Long getInternoNivel6() {
        return internoNivel6;
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
