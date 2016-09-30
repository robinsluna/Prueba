package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.util.List;

public class ImpedimentoWSVO implements Serializable{
    
    public int codigo;
    public String descripcion;
    public String tieneImpedimento;
    
    public List<EstadoSolicAutorizWSVO> listaEstadoSolicitudes;
    
    public ImpedimentoWSVO() {
    }
}
