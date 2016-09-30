/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrRubro;


import java.util.List;

public class PrRubroVO {
    
    private String administracion;
    private Long ainCodigo;
    private Integer costos;
    private String descripcion;
    private Long interno;
    private Long internoNivel1;
    private Long internoNivel2;
    private Long internoNivel3;
    private Long internoNivel4;
    private Long internoNivel5;
    private Long internoNivel6;
    private Long internoNivel7;
    private Long internoNivel8;
    private String inversion;
    private Integer programacion;
    private String tipoPlan;
    private Integer vigencia;
    //Se incluyen todos los campos del archivo 09/10/2013
    private String nombreRubro;
    private String fuenteFinanciacion;
    private String detFuenteFinanciacion;
    private Long valor;
    private String nivelAutorizacion;
    private String fuenteContable;
    
    public PrRubroVO(PrRubro prRubro){
        this.administracion = prRubro.getAdministracion();
        ainCodigo = prRubro.getAinCodigo();
        costos = prRubro.getCostos();
        this.descripcion = prRubro.getDescripcion();
        this.interno = prRubro.getInterno();
        this.internoNivel1 = prRubro.getInternoNivel1();
        this.internoNivel2 = prRubro.getInternoNivel2();
        this.internoNivel3 = prRubro.getInternoNivel3();
        this.internoNivel4 = prRubro.getInternoNivel4();
        this.internoNivel5 = prRubro.getInternoNivel5();
        this.internoNivel6 = prRubro.getInternoNivel6();
        this.internoNivel7 = prRubro.getInternoNivel7();
        this.internoNivel8 = prRubro.getInternoNivel8();
        this.vigencia=prRubro.getVigencia();
        this.fuenteContable = prRubro.getFuenteContable();
    }
    
    public PrRubroVO() {
    }

    public void setFuenteContable(String fuenteContable) {
        this.fuenteContable = fuenteContable;
    }

    public String getFuenteContable() {
        return fuenteContable;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setFuenteFinanciacion(String fuenteFinanciacion) {
        this.fuenteFinanciacion = fuenteFinanciacion;
    }

    public String getFuenteFinanciacion() {
        return fuenteFinanciacion;
    }

    public void setDetFuenteFinanciacion(String detFuenteFinanciacion) {
        this.detFuenteFinanciacion = detFuenteFinanciacion;
    }

    public String getDetFuenteFinanciacion() {
        return detFuenteFinanciacion;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }

    public void setNivelAutorizacion(String nivelAutorizacion) {
        this.nivelAutorizacion = nivelAutorizacion;
    }

    public String getNivelAutorizacion() {
        return nivelAutorizacion;
    }

    /* public void setNivel1Vo(PrNivel1VO nivel1Vo) {
        this.nivel1Vo = nivel1Vo;
    }

    public PrNivel1VO getNivel1Vo() {
        return nivel1Vo;
    }

    public void setNivel2Vo(PrNivel2VO nivel2Vo) {
        this.nivel2Vo = nivel2Vo;
    }

    public PrNivel2VO getNivel2Vo() {
        return nivel2Vo;
    }

    public void setNivel3Vo(PrNivel3VO nivel3Vo) {
        this.nivel3Vo = nivel3Vo;
    }

    public PrNivel3VO getNivel3Vo() {
        return nivel3Vo;
    }

    public void setNivel4Vo(PrNivel4VO nivel4Vo) {
        this.nivel4Vo = nivel4Vo;
    }

    public PrNivel4VO getNivel4Vo() {
        return nivel4Vo;
    }

    public void setNivel5Vo(PrNivel5VO nivel5Vo) {
        this.nivel5Vo = nivel5Vo;
    }

    public PrNivel5VO getNivel5Vo() {
        return nivel5Vo;
    }

    public void setNivel6Vo(PrNivel6VO nivel6Vo) {
        this.nivel6Vo = nivel6Vo;
    }

    public PrNivel6VO getNivel6Vo() {
        return nivel6Vo;
    }

    public void setNivel7Vo(PrNivel7VO nivel7Vo) {
        this.nivel7Vo = nivel7Vo;
    }

    public PrNivel7VO getNivel7Vo() {
        return nivel7Vo;
    }

    public void setNivel8Vo(PrNivel8VO nivel8Vo) {
        this.nivel8Vo = nivel8Vo;
    }

    public PrNivel8VO getNivel8Vo() {
        return nivel8Vo;
    } */

    public void setAdministracion(String administracion) {
        this.administracion = administracion;
    }

    public String getAdministracion() {
        return administracion;
    }

    public void setAinCodigo(Long ainCodigo) {
        this.ainCodigo = ainCodigo;
    }

    public Long getAinCodigo() {
        return ainCodigo;
    }

    public void setCostos(Integer costos) {
        this.costos = costos;
    }

    public Integer getCostos() {
        return costos;
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

    public void setInternoNivel2(Long internoNivel2) {
        this.internoNivel2 = internoNivel2;
    }

    public Long getInternoNivel2() {
        return internoNivel2;
    }

    public void setInternoNivel3(Long internoNivel3) {
        this.internoNivel3 = internoNivel3;
    }

    public Long getInternoNivel3() {
        return internoNivel3;
    }

    public void setInternoNivel4(Long internoNivel4) {
        this.internoNivel4 = internoNivel4;
    }

    public Long getInternoNivel4() {
        return internoNivel4;
    }

    public void setInternoNivel5(Long internoNivel5) {
        this.internoNivel5 = internoNivel5;
    }

    public Long getInternoNivel5() {
        return internoNivel5;
    }

    public void setInternoNivel6(Long internoNivel6) {
        this.internoNivel6 = internoNivel6;
    }

    public Long getInternoNivel6() {
        return internoNivel6;
    }

    public void setInternoNivel7(Long internoNivel7) {
        this.internoNivel7 = internoNivel7;
    }

    public Long getInternoNivel7() {
        return internoNivel7;
    }

    public void setInternoNivel8(Long internoNivel8) {
        this.internoNivel8 = internoNivel8;
    }

    public Long getInternoNivel8() {
        return internoNivel8;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public String getInversion() {
        return inversion;
    }

    public void setProgramacion(Integer programacion) {
        this.programacion = programacion;
    }

    public Integer getProgramacion() {
        return programacion;
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
