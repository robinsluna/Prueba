/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 29-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMarca;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;

import java.util.List;

public class MarcaVO {
    private Long marCodigo;
    private String marNombre;
    
    private List<MetVO> metVoList;    
    
    public MarcaVO(SiiMarca siiMarca){
        this.marCodigo = siiMarca.getMarCodigo();
        this.marNombre = siiMarca.getMarNombre();
        
    }
    
    public MarcaVO() {
    }

    public void setMarCodigo(Long marCodigo) {
        this.marCodigo = marCodigo;
    }

    public Long getMarCodigo() {
        return marCodigo;
    }

    public void setMarNombre(String marNombre) {
        this.marNombre = marNombre;
    }

    public String getMarNombre() {
        return marNombre;
    }

   


    public void setMetVoList(List<MetVO> metVoList) {
        this.metVoList = metVoList;
    }

    public List<MetVO> getMetVoList() {
        return metVoList;
    }

}
