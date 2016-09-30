package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MonedaVO;

import java.util.List;

/**
 * @author Giovanni
 */
public interface AdminMoneda {
    /**
     * Metodo para traer todas las monedas
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<MonedaVO> buscarMonedas() throws ExcepcionDAO;

}
