package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class AnulacionRecaudoWSVO implements Serializable {

    //C�digo identificador del recaudo
    public Integer codEAN;
    // La referencia principal de la factura
    public String refererenciaPrincipal;
    //Si la factura posee otra referencia
    public String refererenciaSecundaria;
    //Si la factura posee otra referencia
    public String refererenciaTercera;
    //Si la factura posee otra referencia
    public String refererenciaCuarta;
    //Fecha de operaci�n de la consulta
    public Date fechaOperacion;
    // Datos opcionales
    public String datosAdicionales;
    // El valor de la factura
    public BigDecimal valorTotal;


    public AnulacionRecaudoWSVO() {
        super();
    }
}
