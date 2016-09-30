package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

public class InstrnoCorrespWSVO implements Serializable {
    
    public Integer inoItem;   
    public String inoSerial;
    public String inoMarca;
    public Integer inoCodApuesta;
    public Integer inoDescJuego;
    public Integer inoPlanPremios;
    public Integer inoValoresPrem; 
    public String inoIndicador;
    
    public InstrnoCorrespWSVO() {
      super(); 
    }

   

}
