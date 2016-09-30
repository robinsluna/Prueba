package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class ConsultaRecaudoResponseWSVO implements Serializable {

    //C�digo de error de la operaci�n respuesta
    public Integer codigoError;
    //Mensaje de error correspondiente
    public String mensajeError;
    // Mensaje alterno para descripci�n error
    public String mensajeErrorAlterno;
    //Valor correspondiente de la factura
    public BigDecimal valorFactura;
    //Fecha Vencimiento
    public Date fechaVencimiento;


    public ConsultaRecaudoResponseWSVO() {
        super();
    }
}
