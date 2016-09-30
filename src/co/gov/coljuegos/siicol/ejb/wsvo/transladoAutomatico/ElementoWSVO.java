package co.gov.coljuegos.siicol.ejb.wsvo.transladoAutomatico;


import java.io.Serializable;

public class ElementoWSVO implements Serializable {
    
    public String contrato;
    public String codLocal;
    public String munDaneLocal;
    public String codLocalDestinoo;
    public String munDaneDestino;
    public Long tipoElemento;
    public Long tipoJuego;
    public Long idColjuegosMet;
    public String idDigitalMet;
    public Long serialMet;
    public Long cantSillas;
    public Long valorCaton;

    public ElementoWSVO() {
   
    }
}
