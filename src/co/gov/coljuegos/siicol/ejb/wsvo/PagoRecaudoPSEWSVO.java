package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class PagoRecaudoPSEWSVO implements Serializable {
   
   
    //Código identificador del recaudo
    public Long id;
    // La fecha de inicio del pago
    public Date fechaInicio;
    //La fecha del ultimo estado 
    public Date fechaEstado;
    //Codigo de la transacción 
    public String codigoTransaccion;
    //referencia en esta se recibe DE y GA
    public String referencia1;
    //Valor del pago 
    public BigDecimal valorPagado;
    // Estado del pago 
    public String transaccionPagoEstado ;

   
   
    public PagoRecaudoPSEWSVO() {
        super();
    }
}
