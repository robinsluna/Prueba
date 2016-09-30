/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 07-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;

import java.util.List;

public class DetalleRubroVO {

    private Long druCodigo;
    private Long druValor;
    private Long interno;
    private Integer vigencia;
    private List<DistribucionPfcVO> distribucionPfcListVo;
    private DetFuenteFinanciacionVO detFuenteFinanciacionVo;
    private FuenteFinancContabVO fuenteFinancContabVo;
    
    
    public DetalleRubroVO(){
        
    }
    
    
    public DetalleRubroVO(SiiDetalleRubro siiDetalleRubro){
        this.druCodigo = siiDetalleRubro.getDruCodigo();
        this.druValor = siiDetalleRubro.getDruValor();
        this.interno = siiDetalleRubro.getInterno();
        this.vigencia = siiDetalleRubro.getVigencia();
        if(siiDetalleRubro.getSiiDtlleFuenteFinanciacion() != null){
            this.detFuenteFinanciacionVo = new DetFuenteFinanciacionVO(siiDetalleRubro.getSiiDtlleFuenteFinanciacion());
        }
        
        if (siiDetalleRubro.getSiiFuenteFinancContab()!=null) {
            this.fuenteFinancContabVo = new FuenteFinancContabVO(siiDetalleRubro.getSiiFuenteFinancContab());
        }
    }
   

    public void setDruCodigo(Long druCodigo) {
        this.druCodigo = druCodigo;
    }

    public Long getDruCodigo() {
        return druCodigo;
    }

    public void setDruValor(Long druValor) {
        this.druValor = druValor;
    }

    public Long getDruValor() {
        return druValor;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    public Long getInterno() {
        return interno;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setDistribucionPfcListVo(List<DistribucionPfcVO> distribucionPfcListVo) {
        this.distribucionPfcListVo = distribucionPfcListVo;
    }

    public List<DistribucionPfcVO> getDistribucionPfcListVo() {
        return distribucionPfcListVo;
    }

    public void setDetFuenteFinanciacionVo(DetFuenteFinanciacionVO detFuenteFinanciacionVo) {
        this.detFuenteFinanciacionVo = detFuenteFinanciacionVo;
    }

    public DetFuenteFinanciacionVO getDetFuenteFinanciacionVo() {
        return detFuenteFinanciacionVo;
    }


    public void setFuenteFinancContabVo(FuenteFinancContabVO fuenteFinancContabVo) {
        this.fuenteFinancContabVo = fuenteFinancContabVo;
    }

    public FuenteFinancContabVO getFuenteFinancContabVo() {
        return fuenteFinancContabVo;
    }
}
