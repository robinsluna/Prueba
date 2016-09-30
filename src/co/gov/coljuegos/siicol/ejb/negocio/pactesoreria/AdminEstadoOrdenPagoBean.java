/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-07-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoOrdenPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOrdenPago;
import co.gov.coljuegos.siicol.ejb.vo.EstadoOrdenPagoVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminEstadoOrdenPagoBean implements AdminEstadoOrdenPago 
{
    @EJB
    private EstadoOrdenPagoDAO estadoOrdenPagoDao;
    
    
    /**
     * Constructor.
     */
    public AdminEstadoOrdenPagoBean() {
        super();
    }
    
    
    
    @Override
    public EstadoOrdenPagoVO buscarEstadoOrdenPagoPorId(Long idOrdenPago) throws ExcepcionDAO {
        EstadoOrdenPagoVO estadoOrdenPagoVo = null;
        SiiEstadoOrdenPago siiEstadoOrdenPago = estadoOrdenPagoDao.buscarEstadoOrdenPagoPorId(idOrdenPago);
        if (siiEstadoOrdenPago!=null)
            estadoOrdenPagoVo = new EstadoOrdenPagoVO(siiEstadoOrdenPago);
        
        return (estadoOrdenPagoVo);
    }
    
    
    @Override
    public EstadoOrdenPagoVO buscarEstadoOrdenPagoXNombre(String nombreEstado) throws ExcepcionDAO {
        EstadoOrdenPagoVO estadoOrdenPagoVo = null;
        SiiEstadoOrdenPago siiEstadoOrdenPago = estadoOrdenPagoDao.buscarEstadoOrdenPagoXNombre(nombreEstado);
        if (siiEstadoOrdenPago!=null)
            estadoOrdenPagoVo = new EstadoOrdenPagoVO(siiEstadoOrdenPago);
        
        return (estadoOrdenPagoVo);
    }
}
