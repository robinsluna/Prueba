package co.gov.coljuegos.siicol.ejb.excepcion;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ExcepcionAplicacion extends Exception {


    public ExcepcionAplicacion() {
        super();
    }

    public ExcepcionAplicacion(String unMensaje) {
        super(unMensaje);
    }

    public ExcepcionAplicacion(String unMensaje, String unComponente) {
        super(unMensaje + " : " + unComponente);
    }
}
