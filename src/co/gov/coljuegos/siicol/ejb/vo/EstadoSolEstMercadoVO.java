package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;

import java.util.List;

public class EstadoSolEstMercadoVO {
    private static final long serialVersionUID = -3296735777643055404L;
    private Long eseCodigo;
    private String eseDescripcion;
    private String eseNombre;
    private List<SolicitudEstMercadoVO> SolicitudEstMercadoList1Vo;

    public EstadoSolEstMercadoVO(SiiEstadoSolEstMercado estadoSolEstMercado){
        this.eseCodigo = estadoSolEstMercado.getEseCodigo();
        this.eseDescripcion = estadoSolEstMercado.getEseDescripcion();
        this.eseNombre = estadoSolEstMercado.getEseNombre();
    }

    public EstadoSolEstMercadoVO(){
        
    }
    public void setEseCodigo(Long eseCodigo) {
        this.eseCodigo = eseCodigo;
    }

    public Long getEseCodigo() {
        return eseCodigo;
    }

    public void setEseDescripcion(String eseDescripcion) {
        this.eseDescripcion = eseDescripcion;
    }

    public String getEseDescripcion() {
        return eseDescripcion;
    }

    public void setEseNombre(String eseNombre) {
        this.eseNombre = eseNombre;
    }

    public String getEseNombre() {
        return eseNombre;
    }

    public void setSiiSolicitudEstMercadoList1(List<SolicitudEstMercadoVO> siiSolicitudEstMercadoList1) {
        this.SolicitudEstMercadoList1Vo = siiSolicitudEstMercadoList1;
    }

    public List<SolicitudEstMercadoVO> getSiiSolicitudEstMercadoList1() {
        return SolicitudEstMercadoList1Vo;
    }
}
