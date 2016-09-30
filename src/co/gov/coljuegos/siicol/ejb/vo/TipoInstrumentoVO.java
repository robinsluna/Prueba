/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 29-11-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoInstrumento;

import java.util.List;

public class TipoInstrumentoVO {
    private Long tinCodigo;
    private String tinNombre;
    
    private List<InstrumentoVO> instrumentoVoList;
    private List<TarifaIlegalidadVO> tarifaIlegalidadList;
    private List<ElementoProcesoIleVO> elementoProcesoIleList;
   
    
    public TipoInstrumentoVO(SiiTipoInstrumento siiTipoInstrumento){
       this.tinCodigo = siiTipoInstrumento.getTinCodigo();
       this.tinNombre = siiTipoInstrumento.getTinNombre();
    }
    public TipoInstrumentoVO(){
        }

    public void setTinCodigo(Long tinCodigo) {
        this.tinCodigo = tinCodigo;
    }

    public Long getTinCodigo() {
        return tinCodigo;
    }

    public void setTinNombre(String tinNombre) {
        this.tinNombre = tinNombre;
    }

    public String getTinNombre() {
        return tinNombre;
    }

    public void setInstrumentoVoList(List<InstrumentoVO> instrumentoVoList) {
        this.instrumentoVoList = instrumentoVoList;
    }

    public List<InstrumentoVO> getInstrumentoVoList() {
        return instrumentoVoList;
    }

    public void setTarifaIlegalidadList(List<TarifaIlegalidadVO> tarifaIlegalidadList) {
        this.tarifaIlegalidadList = tarifaIlegalidadList;
    }

    public List<TarifaIlegalidadVO> getTarifaIlegalidadList() {
        return tarifaIlegalidadList;
    }

    public void setElementoProcesoIleList(List<ElementoProcesoIleVO> elementoProcesoIleList) {
        this.elementoProcesoIleList = elementoProcesoIleList;
    }

    public List<ElementoProcesoIleVO> getElementoProcesoIleList() {
        return elementoProcesoIleList;
    }
}
