package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

public class InventarioAutoComisorioWSVO implements Serializable {
    
    public String item;
    public String serial;
    public String marca;
    public String tipoApuesta; 
    public Long  codigoApuesta;
    
    
    public InventarioAutoComisorioWSVO() {
        super();
    }
}
