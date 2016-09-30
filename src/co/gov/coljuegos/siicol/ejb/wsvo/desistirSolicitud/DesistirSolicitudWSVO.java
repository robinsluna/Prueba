package co.gov.coljuegos.siicol.ejb.wsvo.desistirSolicitud;

import co.gov.coljuegos.siicol.ejb.wsvo.transladoAutomatico.ElementoWSVO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class DesistirSolicitudWSVO {
    
    public String nit;
    public String numeroSiito;
    public String modalidadJuego;
    public int tipoSolicitud;
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
