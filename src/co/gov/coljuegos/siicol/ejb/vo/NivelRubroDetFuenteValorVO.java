/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 23-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.List;

public class NivelRubroDetFuenteValorVO {
    
    private String codigoNive1;
    private String codigoNive2;
    private String codigoNive3;
    private String codigoNive4;
    private String codigoNive5;
    private String codigoNive6;
    private String codigoNive7;
    private String desRubro;
    private String nivelAut;
    private BigDecimal valor;
    private Integer fuente;
    private Integer dtlleFuente;
    private Long idRubro;
    private Long idDetalleFuente;
    private Long idDetalleRubro;
    private String cadenaNiveles;
    //Agregado para convertir en árbol y realizar las sumas:
    private List<NivelRubroDetFuenteValorVO> listaNodosHijo;
    
    public NivelRubroDetFuenteValorVO() {
    }

    public void setListaNodosHijo(List<NivelRubroDetFuenteValorVO> listaNodosHijo) {
        this.listaNodosHijo = listaNodosHijo;
    }

    public List<NivelRubroDetFuenteValorVO> getListaNodosHijo() {
        return listaNodosHijo;
    }

    public void setCodigoNive1(String codigoNive1) {
        this.codigoNive1 = codigoNive1;
    }

    public String getCodigoNive1() {
        return codigoNive1;
    }

    public void setCodigoNive2(String codigoNive2) {
        this.codigoNive2 = codigoNive2;
    }

    public String getCodigoNive2() {
        return codigoNive2;
    }

    public void setCodigoNive3(String codigoNive3) {
        this.codigoNive3 = codigoNive3;
    }

    public String getCodigoNive3() {
        return codigoNive3;
    }

    public void setCodigoNive4(String codigoNive4) {
        this.codigoNive4 = codigoNive4;
    }

    public String getCodigoNive4() {
        return codigoNive4;
    }

    public void setCodigoNive5(String codigoNive5) {
        this.codigoNive5 = codigoNive5;
    }

    public String getCodigoNive5() {
        return codigoNive5;
    }

    public void setCodigoNive6(String codigoNive6) {
        this.codigoNive6 = codigoNive6;
    }

    public String getCodigoNive6() {
        return codigoNive6;
    }

    public void setCodigoNive7(String codigoNive7) {
        this.codigoNive7 = codigoNive7;
    }

    public String getCodigoNive7() {
        return codigoNive7;
    }

    public void setDesRubro(String desRubro) {
        this.desRubro = desRubro;
    }

    public String getDesRubro() {
        return desRubro;
    }

    public void setNivelAut(String nivelAut) {
        this.nivelAut = nivelAut;
    }

    public String getNivelAut() {
        return nivelAut;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setFuente(Integer fuente) {
        this.fuente = fuente;
    }

    public Integer getFuente() {
        return fuente;
    }

    public void setDtlleFuente(Integer dtlleFuente) {
        this.dtlleFuente = dtlleFuente;
    }

    public Integer getDtlleFuente() {
        return dtlleFuente;
    }


    public void setIdRubro(Long idRubro) {
        this.idRubro = idRubro;
    }

    public Long getIdRubro() {
        return idRubro;
    }

    public void setIdDetalleFuente(Long idDetalleFuente) {
        this.idDetalleFuente = idDetalleFuente;
    }

    public void setCadenaNiveles(String cadenaNiveles) {
        this.cadenaNiveles = cadenaNiveles;
    }

    public String getCadenaNiveles() {
        return cadenaNiveles;
    }

    public Long getIdDetalleFuente() {
        return idDetalleFuente;
    }

    public void setIdDetalleRubro(Long idDetalleRubro) {
        this.idDetalleRubro = idDetalleRubro;
    }

    public Long getIdDetalleRubro() {
        return idDetalleRubro;
    }

}
