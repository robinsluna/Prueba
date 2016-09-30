package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.wsvo.PagoRecaudoPSEWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PagoRecaudoResponseWSVO;


public interface AdminRecaudoPSEWS {
   
    public PagoRecaudoResponseWSVO registroPagoRecaudoPSE (PagoRecaudoPSEWSVO pagoRecaudoPSEWSVo) throws ExcepcionDAO,ExcepcionAplicacion ;
   
}
