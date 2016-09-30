package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoResDecDes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ResultadoResDecDesVO {
    
    private Long rrdCodigo;
    private String rrdNombre;

    public ResultadoResDecDesVO() {
        super();
    }
    
    
    public ResultadoResDecDesVO(SiiResultadoResDecDes siiResultadoResDecDes){
        
        this.rrdCodigo = siiResultadoResDecDes.getRrdCodigo();
        this.rrdNombre = siiResultadoResDecDes.getRrdNombre();
        
    }

    public Long getRrdCodigo() {
        return rrdCodigo;
    }

    public void setRrdCodigo(Long rrdCodigo) {
        this.rrdCodigo = rrdCodigo;
    }

    public String getRrdNombre() {
        return rrdNombre;
    }

    public void setRrdNombre(String rrdNombre) {
        this.rrdNombre = rrdNombre;
    }
}
