/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 01-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel3;


import java.util.ArrayList;

public class PrNivel3VO {
    
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel2;
    private String tipoPlan;
    private Integer vigencia;
    //private ArrayList<PrNivel4VO> listaNivel4 = new ArrayList<PrNivel4VO>();
    
    public PrNivel3VO(PrNivel3 prNivel3){
        this.interno = prNivel3.getInterno();
        this.vigencia = prNivel3.getVigencia();
        this.codigo = prNivel3.getCodigo();
        this.descripcion = prNivel3.getDescripcion();
        this.tipoPlan = prNivel3.getTipoPlan();
    }
    
    public PrNivel3VO() {
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

    public void setInternoNivel2(Long internoNivel2) {
        this.internoNivel2 = internoNivel2;
    }

    public Long getInternoNivel2() {
        return internoNivel2;
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
