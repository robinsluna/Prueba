/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 29-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;

import java.util.List;

public class EstablecimientoVO {
    private Long estCodigo;
    private String estCodInterno;
    private String estDireccion;
    private UbicacionVO ubicacionVo;
    private OperadorVO operador;
    private List<InventarioVO> inventarioVoList;
    private String estNombre;
   
   //datos para grilla
   private UbicacionVO ubicacionVo2;
    
    public EstablecimientoVO(SiiEstablecimiento siiEstablecimiento){
       this.estCodigo = siiEstablecimiento.getEstCodigo();
       this.estCodInterno = siiEstablecimiento.getEstCodInterno();
       this.estDireccion = siiEstablecimiento.getEstDireccion();
       this.estNombre = siiEstablecimiento.getEstNombre();
       if(siiEstablecimiento.getSiiUbicacion1()!= null){
           this.ubicacionVo = new UbicacionVO(siiEstablecimiento.getSiiUbicacion1());
           }
       if(siiEstablecimiento.getSiiOperador2()!= null){
           this.operador = new OperadorVO(siiEstablecimiento.getSiiOperador2());
           }
    }
    
    public EstablecimientoVO() {
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodInterno(String estCodInterno) {
        this.estCodInterno = estCodInterno;
    }

    public String getEstCodInterno() {
        return estCodInterno;
    }

    public void setEstDireccion(String estDireccion) {
        this.estDireccion = estDireccion;
    }

    public String getEstDireccion() {
        return estDireccion;
    }

    public void setUbicacionVo(UbicacionVO ubicacionVo) {
        this.ubicacionVo = ubicacionVo;
    }

    public UbicacionVO getUbicacionVo() {
        return ubicacionVo;
    }

    public void setOperador(OperadorVO operador) {
        this.operador = operador;
    }

    public OperadorVO getOperador() {
        return operador;
    }

    public void setInventarioVoList(List<InventarioVO> inventarioVoList) {
        this.inventarioVoList = inventarioVoList;
    }

    public List<InventarioVO> getInventarioVoList() {
        return inventarioVoList;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    public String getEstNombre() {
        return estNombre;
    }

    public void setUbicacionVo2(UbicacionVO ubicacionVo2) {
        this.ubicacionVo2 = ubicacionVo2;
    }

    public UbicacionVO getUbicacionVo2() {
        return ubicacionVo2;
    }

}
