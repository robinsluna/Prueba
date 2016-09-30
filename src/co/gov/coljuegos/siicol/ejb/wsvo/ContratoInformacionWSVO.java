package co.gov.coljuegos.siicol.ejb.wsvo;


import java.math.BigDecimal;

import java.util.Date;


public class ContratoInformacionWSVO {
    
    public Long conCodigo;
    public String conDescripcion;
    public String conExpedienteUrl;
    public Date conFecha;
    public Date conFechaCitFirOpe;
    public Date conFechaFin;
    public Date conFechaFirColj;
    public Date conFechaFirOpe;
    public Date conFechaIni;
    public Date conFechaPrgFirOpe;
    public Date conFechaRegistro;
    public Date conFechaRevAbog;
    public String conNumero;
    public String conVigente;
    public Integer conConsecutivo;
    public String conTextoValFinan;
    public String conTextoValGct;
    public String conPermiso;    
    public BigDecimal valorContrato;
    
    public ContratoInformacionWSVO() {
        super();
    }
}
