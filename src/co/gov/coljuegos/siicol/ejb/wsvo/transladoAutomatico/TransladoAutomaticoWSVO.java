package co.gov.coljuegos.siicol.ejb.wsvo.transladoAutomatico;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class TransladoAutomaticoWSVO {
   
    public String numeroSiito;
    public Long codigoMovimiento;
    public String modalidadJuego;
    public int tipoSolicitud;
    public Date fechaSolicitud;
    public String numeroRadicado;
    public String UsuarioColjuegos; //Login del usuari
    public String nit;
    public List<ElementoWSVO> elementoWSVo;
   
    public TransladoAutomaticoWSVO() {
        
    }
}
