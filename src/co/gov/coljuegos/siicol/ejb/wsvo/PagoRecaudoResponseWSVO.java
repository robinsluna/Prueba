package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.util.Date;

public class PagoRecaudoResponseWSVO implements Serializable {

    //C�digo de error de la operaci�n respuesta
    public Integer codigoError;
    //Mensaje de error correspondiente
    public String mensajeError;
    // Mensaje alterno para descripci�n error
    public String mensajeErrorAlterno;
    //Hora en la que el servicio emite respuesta
    public Date horaPago;


    public PagoRecaudoResponseWSVO() {
        super();
    }
}
