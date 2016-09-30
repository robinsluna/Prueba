/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 02-10-2013
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel4;

public class PrNivel4VO {
    
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel3;
    private String tipoPlan;
    private Integer vigencia;
    
    public PrNivel4VO(PrNivel4 prNivel4){
        this.interno = prNivel4.getInterno();
        this.vigencia = prNivel4.getVigencia();
        this.codigo = prNivel4.getCodigo();
        this.descripcion = prNivel4.getDescripcion();
        this.tipoPlan = prNivel4.getTipoPlan();
    }
    
    public PrNivel4VO() {
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

    public void setInternoNivel3(Long internoNivel3) {
        this.internoNivel3 = internoNivel3;
    }

    public Long getInternoNivel3() {
        return internoNivel3;
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
