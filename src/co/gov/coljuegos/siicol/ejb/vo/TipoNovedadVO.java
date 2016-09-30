/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 27-09-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoNovedad;

import java.util.List;

public class TipoNovedadVO {
     
    private Long tnoCodigo;
    private String tnoNombre;
    private List<NovedadVO> novedadVoList;
   
    
    public TipoNovedadVO(SiiTipoNovedad siiTipoNovedad){
        this.tnoCodigo = siiTipoNovedad.getTnoCodigo();
        this.tnoNombre = siiTipoNovedad.getTnoNombre();        
    }
    
    public TipoNovedadVO() {
    }


    public void setTnoCodigo(Long tnoCodigo) {
        this.tnoCodigo = tnoCodigo;
    }

    public Long getTnoCodigo() {
        return tnoCodigo;
    }

    public void setTnoNombre(String tnoNombre) {
        this.tnoNombre = tnoNombre;
    }

    public String getTnoNombre() {
        return tnoNombre;
    }

    public void setNovedadVoList(List<NovedadVO> novedadVoList) {
        this.novedadVoList = novedadVoList;
    }

    public List<NovedadVO> getNovedadVoList() {
        return novedadVoList;
    }


}
