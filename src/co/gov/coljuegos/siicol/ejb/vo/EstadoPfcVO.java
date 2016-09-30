/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Diana Caro
 * FECHA	: 20-09-2013
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionFlujoCaja;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

public class EstadoPfcVO {
    private Long epfCodigo;
    private String epfDescripcion;
    private String epfNombre;
    private List<ProyeccionFlujoCajaVO> siiProyeccionFlujoCajaVOList;
    
    public EstadoPfcVO(SiiEstadoPfc siiEstadoPfc){
        this.epfCodigo = siiEstadoPfc.getEpfCodigo();
        this.epfDescripcion = siiEstadoPfc.getEpfDescripcion();
        this.epfNombre = siiEstadoPfc.getEpfNombre();
    }
    public EstadoPfcVO( ){
    }
  
    public void setEpfCodigo(Long epfCodigo) {
        this.epfCodigo = epfCodigo;
    }
    
    public Long getEpfCodigo() {
        return epfCodigo;
    }
    
    public void setEpfDescripcion(String epfDescripcion) {
        this.epfDescripcion = epfDescripcion;
    }

     public String getEpfDescripcion() {
        return epfDescripcion;
    }

    public void setEpfNombre(String epfNombre) {
        this.epfNombre = epfNombre;
    }

  public String getEpfNombre() {
        return epfNombre;
    }


    public void setSiiProyeccionFlujoCajaVOList(List<ProyeccionFlujoCajaVO> siiProyeccionFlujoCajaVOList) {
        this.siiProyeccionFlujoCajaVOList = siiProyeccionFlujoCajaVOList;
    }

    public List<ProyeccionFlujoCajaVO> getSiiProyeccionFlujoCajaVOList() {
        return siiProyeccionFlujoCajaVOList;
    }
}
