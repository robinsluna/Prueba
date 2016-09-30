package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;


import java.util.List;

public class ProcesoColjuegosVO {
    private static final long serialVersionUID = -4211935879174153748L;
    private Long pcoCodigo;
    private String pcoDescripcion;
    private String pcoNombre;
    private List<SolicitudEstMercadoVO> solicitudEstMercadoList4Vo;

    public ProcesoColjuegosVO(SiiProcesoColjuegos procesoColjuegos){
        this.pcoCodigo = procesoColjuegos.getPcoCodigo();
        this.pcoDescripcion = procesoColjuegos.getPcoDescripcion();
        this.pcoNombre = procesoColjuegos.getPcoNombre();
    }

    public ProcesoColjuegosVO(){
          
    
    }
    
    public void setPcoCodigo(Long pcoCodigo) {
        this.pcoCodigo = pcoCodigo;
    }

    public Long getPcoCodigo() {
        return pcoCodigo;
    }

    public void setPcoDescripcion(String pcoDescripcion) {
        this.pcoDescripcion = pcoDescripcion;
    }

    public String getPcoDescripcion() {
        return pcoDescripcion;
    }

    public void setPcoNombre(String pcoNombre) {
        this.pcoNombre = pcoNombre;
    }

    public String getPcoNombre() {
        return pcoNombre;
    }

    public void setSiiSolicitudEstMercadoList4(List<SolicitudEstMercadoVO> siiSolicitudEstMercadoList4) {
        this.solicitudEstMercadoList4Vo = siiSolicitudEstMercadoList4;
    }

    public List<SolicitudEstMercadoVO> getSiiSolicitudEstMercadoList4() {
        return solicitudEstMercadoList4Vo;
    }
}
