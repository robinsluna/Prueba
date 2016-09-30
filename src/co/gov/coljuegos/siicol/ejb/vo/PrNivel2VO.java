/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 02-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel2;


import java.util.ArrayList;

public class PrNivel2VO {
    
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel1;
    private String tipoPlan;
    private Integer vigencia;
    //private ArrayList<PrNivel3VO> listaNivel3 = new ArrayList<PrNivel3VO>();
    
    public PrNivel2VO(PrNivel2 prNivel2){
        this.interno = prNivel2.getInterno();
        this.vigencia = prNivel2.getVigencia();
        this.codigo = prNivel2.getCodigo();
        this.descripcion = prNivel2.getDescripcion();
        this.tipoPlan = prNivel2.getTipoPlan();
    }
    
    public PrNivel2VO() {
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

    public void setInternoNivel1(Long internoNivel1) {
        this.internoNivel1 = internoNivel1;
    }

    public Long getInternoNivel1() {
        return internoNivel1;
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
