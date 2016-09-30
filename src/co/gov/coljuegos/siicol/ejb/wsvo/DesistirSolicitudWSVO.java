package co.gov.coljuegos.siicol.ejb.wsvo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class DesistirSolicitudWSVO implements Serializable {
    public String numeroSolicitudSiito;
    public Integer codigoMovSolicitud;
    public Long tipoSolicitud;
    public Date  fechaSolicitud;
    public String numeroRadGesDoc;
    
    public String nit;
    public String numeroSiito;
    public String modalidadJuego;
    public Date fecha;
    public String radicado;
    public Long codigoMovimiento;
    public String UsuarioColjuegos; //Login del usuario
    public int tiempoContratoMeses;
    public String numeroContrato;
    public BigDecimal valorContrato;
    public BigDecimal valorProrroga;
    public List<ElementoWSVO> elementoWSVo;
    
    
    public DesistirSolicitudWSVO() {
      
    }
}
