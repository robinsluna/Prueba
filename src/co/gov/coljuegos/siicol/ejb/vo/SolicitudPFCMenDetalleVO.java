
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Walter becerra
 * FECHA	: 28-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolPfcMensDetRub;
import java.math.BigDecimal;

import java.util.List;

public class SolicitudPFCMenDetalleVO {
    
    private Long sprcodigo;
    private BigDecimal sprValorAprobado; 
    private DetalleRubroVO detalleRubroVo;
    private SolicitudPfcMensualVO solicitudPfcMensualVo;
    
    public SolicitudPFCMenDetalleVO() {
      
      
    }
    public SolicitudPFCMenDetalleVO(SiiSolPfcMensDetRub siiSolPfcMensDetRub) {
        this.setSprcodigo(sprcodigo);
        this.setSprValorAprobado(siiSolPfcMensDetRub.getSprValorAprob());
        
        //padres
        if(siiSolPfcMensDetRub.getSiiDetalleRubro()!=null)
            this.detalleRubroVo= new DetalleRubroVO(siiSolPfcMensDetRub.getSiiDetalleRubro());
        if(siiSolPfcMensDetRub.getSiiSolicitudPfcMens()!=null)
            this.solicitudPfcMensualVo= new SolicitudPfcMensualVO(siiSolPfcMensDetRub.getSiiSolicitudPfcMens());
    }


    public void setSprcodigo(Long sprcodigo) {
        this.sprcodigo = sprcodigo;
    }

    public Long getSprcodigo() {
        return sprcodigo;
    }

    public void setSprValorAprobado(BigDecimal sprValorAprobado) {
        this.sprValorAprobado = sprValorAprobado;
    }

    public BigDecimal getSprValorAprobado() {
        return sprValorAprobado;
    }

    public void setDetalleRubroVo(DetalleRubroVO detalleRubroVo) {
        this.detalleRubroVo = detalleRubroVo;
    }

    public DetalleRubroVO getDetalleRubroVo() {
        return detalleRubroVo;
    }

    public void setSolicitudPfcMensualVo(SolicitudPfcMensualVO solicitudPfcMensualVo) {
        this.solicitudPfcMensualVo = solicitudPfcMensualVo;
    }

    public SolicitudPfcMensualVO getSolicitudPfcMensualVo() {
        return solicitudPfcMensualVo;
    }
}
