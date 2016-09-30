/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 04-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;

import java.util.List;

public class DetFuenteFinanciacionVO {
    
    private Long dffCodigo;
    private Integer dffCodigoRecurso;
    private String dffDescripcion;
    private List<DetalleRubroVO> detalleRubroListVo;
    private FuenteFinanciacionVO fuenteFinanciacionVo;

   
    public DetFuenteFinanciacionVO(SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion){
        this.dffCodigo = siiDtlleFuenteFinanciacion.getDffCodigo();
        this.dffCodigoRecurso = siiDtlleFuenteFinanciacion.getDffCodigoRecurso();
        this.dffDescripcion = siiDtlleFuenteFinanciacion.getDffDescripcion();
        //Padres:
        //////siiDtlleFuenteFinanciacionVo.setFuenteFinanciacionVo(unaFuenteFinVo.convertirEntidadAVO(siiDtlleFuenteFinanciacion.getSiiFuenteFinanciacion()));
        if (siiDtlleFuenteFinanciacion.getSiiFuenteFinanciacion() != null) {
            this.fuenteFinanciacionVo = new FuenteFinanciacionVO(siiDtlleFuenteFinanciacion.getSiiFuenteFinanciacion());
        }

    }
    
    public DetFuenteFinanciacionVO(){
    }


    public void setDffCodigo(Long dffCodigo) {
        this.dffCodigo = dffCodigo;
    }

    public Long getDffCodigo() {
        return dffCodigo;
    }

    public void setDffCodigoRecurso(Integer dffCodigoRecurso) {
        this.dffCodigoRecurso = dffCodigoRecurso;
    }

    public Integer getDffCodigoRecurso() {
        return dffCodigoRecurso;
    }

    public void setDffDescripcion(String dffDescripcion) {
        this.dffDescripcion = dffDescripcion;
    }

    public String getDffDescripcion() {
        return dffDescripcion;
    }

    public void setDetalleRubroListVo(List<DetalleRubroVO> detalleRubroListVo) {
        this.detalleRubroListVo = detalleRubroListVo;
    }

    public List<DetalleRubroVO> getDetalleRubroListVo() {
        return detalleRubroListVo;
    }

    public void setFuenteFinanciacionVo(FuenteFinanciacionVO fuenteFinanciacionVo) {
        this.fuenteFinanciacionVo = fuenteFinanciacionVo;
    }

    public FuenteFinanciacionVO getFuenteFinanciacionVo() {
        return fuenteFinanciacionVo;
    } 
}
