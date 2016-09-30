package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.wsvo.AnulacionRecaudoResponseWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.AnulacionRecaudoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ConsultaRecaudoResponseWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ConsultaRecaudoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PagoRecaudoResponseWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PagoRecaudoWSVO;

public interface AdminRecaudoBancoWS {

    /**
     *Metodo encargado de hacer la consulta por la referencia para consultar los datos de pago que
     * debe hacer el operador
     * @author David Tafur
     * @param consultaRecaudoWSVO
     * @return ConsultaRecaudoResponseWSVO
     */
    public ConsultaRecaudoResponseWSVO consultaPagoRecaudo(ConsultaRecaudoWSVO consultaRecaudoWSVO) throws ExcepcionDAO;

    /**
     *Metodo encargado de hacer el registor de un recaudo que llega por medio del web services
     * @author David Tafur
     * @param pagoRecaudoWSVO
     * @return PagoRecaudoResponseWSVO
     */
    public PagoRecaudoResponseWSVO registroPagoRecaudo(PagoRecaudoWSVO pagoRecaudoWSVO) throws ExcepcionDAO,ExcepcionAplicacion;

    /**
     *Metodo encargado de hacer la anulacion de un pago recaudo registrado por medio del ws
     * @author David Tafur
     * @param anulacionRecaudoWSVO
     * @return AnulacionRecaudoResponseWSVO
     */
    public AnulacionRecaudoResponseWSVO anulacionPagoRecaudo(AnulacionRecaudoWSVO anulacionRecaudoWSVO)throws ExcepcionDAO,ExcepcionAplicacion;
}
