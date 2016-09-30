package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsignacionRecaudo;

import java.util.List;

public class AsignacionRecaudoVO {
    
    private Long areCodigo;
    private String areEstado;
    private DetalleDeclaracionVO detalleDeclaracionVo;    
    private List<LiquidacionEstablVO> listLiquidacionEstablVo;
    
    
    public AsignacionRecaudoVO() {
           
    }
    public AsignacionRecaudoVO(SiiAsignacionRecaudo siiAsignacionRecaudo) {
        
        this.areCodigo = siiAsignacionRecaudo.getAreCodigo();
        this.areEstado = siiAsignacionRecaudo.getAreEstado();
        
        if(siiAsignacionRecaudo.getSiiDetalleDeclaracion() != null) {
            this.detalleDeclaracionVo = new DetalleDeclaracionVO(siiAsignacionRecaudo.getSiiDetalleDeclaracion());
        }
           
    }
    


    public void setAreCodigo(Long areCodigo) {
        this.areCodigo = areCodigo;
    }

    public Long getAreCodigo() {
        return areCodigo;
    }


    public void setAreEstado(String areEstado) {
        this.areEstado = areEstado;
    }

    public String getAreEstado() {
        return areEstado;
    }

    public void setDetalleDeclaracionVo(DetalleDeclaracionVO detalleDeclaracionVo) {
        this.detalleDeclaracionVo = detalleDeclaracionVo;
    }

    public DetalleDeclaracionVO getDetalleDeclaracionVo() {
        return detalleDeclaracionVo;
    }

    public void setListLiquidacionEstablVo(List<LiquidacionEstablVO> listLiquidacionEstablVo) {
        this.listLiquidacionEstablVo = listLiquidacionEstablVo;
    }

    public List<LiquidacionEstablVO> getListLiquidacionEstablVo() {
        return listLiquidacionEstablVo;
    }


}
