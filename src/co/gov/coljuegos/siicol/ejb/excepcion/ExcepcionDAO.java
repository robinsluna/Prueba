package co.gov.coljuegos.siicol.ejb.excepcion;

import javax.ejb.ApplicationException;


@ApplicationException(rollback = true)
public class ExcepcionDAO extends Exception{
    
    public ExcepcionDAO(){
        super();
    }
    
    public ExcepcionDAO(String unMensaje){
        super(unMensaje);
    }
    
    public ExcepcionDAO(String unMensaje, String unComponente){
       super (unComponente + " : " + unMensaje);
    }
    
    public ExcepcionDAO(String unMensaje, Throwable e) {
        super (unMensaje, e);
    }
    
    public ExcepcionDAO(String unMensaje, String unComponente, Throwable e){
        super (unMensaje + " : " + unComponente, e);
    }
}
