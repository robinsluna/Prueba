package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

public class FiscalizadorWSVO     implements Serializable{
    
    public String nombre;
    public String numeroIdent;
    public String cargo;
    public String login;

    public FiscalizadorWSVO() {
        super();
    }
}
