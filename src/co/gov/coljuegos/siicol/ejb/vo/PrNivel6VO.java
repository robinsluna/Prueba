/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 02-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel6;

public class PrNivel6VO {
    
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel5;
    private String tipoPlan;
    private Integer vigencia;
    
    public PrNivel6VO(PrNivel6 prNivel6){
        this.interno = prNivel6.getInterno();
        this.vigencia = prNivel6.getVigencia();
        this.codigo = prNivel6.getCodigo();
        this.descripcion = prNivel6.getDescripcion();
        this.tipoPlan = prNivel6.getTipoPlan();
    }
    
    public PrNivel6VO() {
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

    public void setInternoNivel5(Long internoNivel5) {
        this.internoNivel5 = internoNivel5;
    }

    public Long getInternoNivel5() {
        return internoNivel5;
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
