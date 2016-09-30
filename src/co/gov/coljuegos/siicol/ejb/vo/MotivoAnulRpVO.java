/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Mónica Pabón
 * FECHA	: 26-11-2013
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiApropiacionInicial;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;

import java.util.List;

public class MotivoAnulRpVO {
    private Long manCodigo;
    private String manNombre;
    private List<RpVO> rpList;
    
    public MotivoAnulRpVO(SiiMotivoAnulRp siiMotivoAnulacionRp){
        this.manCodigo = siiMotivoAnulacionRp.getManCodigo();
        this.manNombre = siiMotivoAnulacionRp.getManNombre();
    }
    
    public MotivoAnulRpVO(){
    }
    


    public void setManCodigo(Long manCodigo) {
        this.manCodigo = manCodigo;
    }

    public Long getManCodigo() {
        return manCodigo;
    }

    public void setManNombre(String manNombre) {
        this.manNombre = manNombre;
    }

    public String getManNombre() {
        return manNombre;
    }

    public void setRpList(List<RpVO> rpList) {
        this.rpList = rpList;
    }

    public List<RpVO> getRpList() {
        return rpList;
    }
    
}
