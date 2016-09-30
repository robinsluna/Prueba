package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.util.Date;

public class ActaVisitaResponseWSVO implements Serializable {
    
    //Código de error de la operación respuesta
    public Integer codigoError;
    //Mensaje de error correspondiente
    public String mensajeError;
    // Mensaje alterno para descripción error
    public String mensajeErrorAlterno;
    //Hora en la que el servicio emite respuesta
    public Date horaRegistro;

    public ActaVisitaResponseWSVO() {
        super();
    }
}
