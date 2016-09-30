/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicPago;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicPagoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class AdminEstadoSolicPagoBean implements AdminEstadoSolicPago {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private EstadoSolicPagoDAO estadoSolicPagoDAO;
    
    
    /**
     * Constructor.
     */
    public AdminEstadoSolicPagoBean() {
        super();
    }

    @Override
    public EstadoSolicPagoVO buscarPorCodigoEstadoSolicPago(Long idEstadoSolicPago) throws ExcepcionDAO {
        SiiEstadoSolicPago siiEstadoSolicPago = estadoSolicPagoDAO.buscarPorCodigoEstadoSolicPago(idEstadoSolicPago);
        return ( new EstadoSolicPagoVO(siiEstadoSolicPago) );
    }

    @Override
    public EstadoSolicPagoVO insertarSiiEstadoSolicPago(EstadoSolicPagoVO estadoSolicPago) throws ExcepcionDAO {
        SiiEstadoSolicPago siiEstadoSolicPago = estadoSolicPagoDAO.insertarSiiEstadoSolicPago(conversionVoEntidad.convertir(estadoSolicPago));
        return ( new EstadoSolicPagoVO(siiEstadoSolicPago) );
    }

    @Override
    public EstadoSolicPagoVO actualizarSiiEstadoSolicPago(EstadoSolicPagoVO estadoSolicPago) throws ExcepcionDAO {
        SiiEstadoSolicPago siiEstadoSolicPago = estadoSolicPagoDAO.actualizarSiiEstadoSolicPago(conversionVoEntidad.convertir(estadoSolicPago));
        return ( new EstadoSolicPagoVO(siiEstadoSolicPago) );
    }

    @Override
    public void borrarSiiEstadoSolicPago(Long idEstadoSolicPago) throws ExcepcionDAO {
        estadoSolicPagoDAO.borrarSiiEstadoSolicPago(idEstadoSolicPago);
    }

    @Override
    public List<EstadoSolicPagoVO> buscarTodoSiiEstadoSolicPago() throws ExcepcionDAO {
        List<EstadoSolicPagoVO> listaEstadoSolicPago = null;
        List<SiiEstadoSolicPago> lista = estadoSolicPagoDAO.buscarTodoSiiEstadoSolicPago();
        if (lista!=null) {
            listaEstadoSolicPago = new ArrayList<EstadoSolicPagoVO>();
            for (SiiEstadoSolicPago siiEstadoSolicPago: lista) {
                listaEstadoSolicPago.add(new EstadoSolicPagoVO(siiEstadoSolicPago));
            }
        }
        return (listaEstadoSolicPago);
    }
}
