/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-07-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocSopSolicPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSopSolicPago;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocSopSolicPagoVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminTipoDocSopSolicPagoBean implements AdminTipoDocSopSolicPago {

    @EJB
    private TipoDocSopSolicPagoDAO tipoDocSopSolicPagoDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminTipoDocSopSolicPagoBean() {
        super();
    }
    
    
    
    @Override
    public TipoDocSopSolicPagoVO buscarTipoDocSopSolicPagoPorId(Long tspCodigo) throws ExcepcionDAO 
    {
        TipoDocSopSolicPagoVO resultado = null;
        SiiTipoDocSopSolicPago siiTipoDocSopSolicPago = tipoDocSopSolicPagoDao.buscarPorCodigo(tspCodigo);
        if (siiTipoDocSopSolicPago!=null)
            resultado = new TipoDocSopSolicPagoVO(siiTipoDocSopSolicPago);
        
        return (resultado);
    }
}
