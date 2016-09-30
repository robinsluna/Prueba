package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFinancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MonedaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMoneda;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.MonedaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Giovanni
 */
@Stateless
public class AdminMonedaBean implements AdminMoneda {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private MonedaDAO monedaDAO;

    /**
     * Metodo para traer todas las monedas
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<MonedaVO> buscarMonedas() throws ExcepcionDAO {
        List<MonedaVO> monedaVOs = new ArrayList<MonedaVO>();
        List<SiiMoneda> siiMonedas = new ArrayList<SiiMoneda>();
        siiMonedas = monedaDAO.buscarMonedas();
        for (SiiMoneda siiMoneda : siiMonedas) {
            MonedaVO monedaVO = new MonedaVO(siiMoneda);
            monedaVOs.add(monedaVO);
        }
        return monedaVOs;
    }

}
