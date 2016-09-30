/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 02-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel8;

public class PrNivel8VO {
    
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel7;
    private String tipoPlan;
    private Integer vigencia;
    
    public PrNivel8VO(PrNivel8 prNivel8){
        this.interno = prNivel8.getInterno();
        this.vigencia = prNivel8.getVigencia();
        this.codigo = prNivel8.getCodigo();
        this.descripcion = prNivel8.getDescripcion();
        this.tipoPlan = prNivel8.getTipoPlan();
    }
    
    public PrNivel8VO() {
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

    public void setInternoNivel7(Long internoNivel7) {
        this.internoNivel7 = internoNivel7;
    }

    public Long getInternoNivel7() {
        return internoNivel7;
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
