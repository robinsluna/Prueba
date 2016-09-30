/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Mónica Pabón
 * FECHA	: 26-11-2013
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiApropiacionInicial;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoRechSolRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;

import java.util.List;

public class MotivoRechSolRpVO {
    private Long mrsCodigo;
    private String mrsNombre;
    private List<RpVO> rpList1;
    
    public MotivoRechSolRpVO(SiiMotivoRechSolRp siiMotivoRechSolRp){
        this.mrsCodigo = siiMotivoRechSolRp.getMrsCodigo();
        this.mrsNombre = siiMotivoRechSolRp.getMrsNombre();
    }
    
    public MotivoRechSolRpVO(){
    }

    public void setMrsCodigo(Long mrsCodigo) {
        this.mrsCodigo = mrsCodigo;
    }

    public Long getMrsCodigo() {
        return mrsCodigo;
    }

    public void setMrsNombre(String mrsNombre) {
        this.mrsNombre = mrsNombre;
    }

    public String getMrsNombre() {
        return mrsNombre;
    }

    public void setRpList1(List<RpVO> rpList1) {
        this.rpList1 = rpList1;
    }

    public List<RpVO> getRpList1() {
        return rpList1;
    }

}
