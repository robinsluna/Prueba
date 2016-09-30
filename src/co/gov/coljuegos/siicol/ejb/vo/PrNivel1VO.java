/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 01-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;

import java.util.ArrayList;

public class PrNivel1VO {
    
    private String codigo;
    private String descripcion;
    private Long interno;
    private String tipoPlan;
    private Integer vigencia;
    //private ArrayList<PrNivel2VO> listaNivel2 = new ArrayList<PrNivel2VO>();
    
    public PrNivel1VO(PrNivel1 prNivel1){
        this.interno = prNivel1.getInterno();
        this.vigencia = prNivel1.getVigencia();
        this.codigo = prNivel1.getCodigo();
        this.descripcion = prNivel1.getDescripcion();
        this.tipoPlan = prNivel1.getTipoPlan();
    }
    
    public PrNivel1VO() {    
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
