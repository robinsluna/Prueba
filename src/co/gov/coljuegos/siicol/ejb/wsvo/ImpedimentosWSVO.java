package co.gov.coljuegos.siicol.ejb.wsvo;


import java.io.Serializable;

import java.util.List;


public class ImpedimentosWSVO implements Serializable{
    
    public List<ImpedimentoWSVO> impedimentosNIT;
    public List<ImpedimContratoWSVO> impedimentosContrato;
    
    public ImpedimentosWSVO() {
    }
}
