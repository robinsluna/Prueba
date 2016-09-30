/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoModifPresupDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifPresup;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModifPresupVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminEstadoModifPresupBean implements AdminEstadoModifPresup {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private EstadoModifPresupDAO estadoModifPresupDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminEstadoModifPresupBean() { }

    
    public EstadoModifPresupVO buscarEstadoModifPresupPorId (Long idMprCodigo) throws ExcepcionDAO {
        SiiEstadoModifPresup siiEstadoModifPresup = estadoModifPresupDao.buscarEstadoModifPresupPorId(idMprCodigo);
        return ( new EstadoModifPresupVO(siiEstadoModifPresup) );
    }

    
    public EstadoModifPresupVO actualizarEstadoModifPresup(EstadoModifPresupVO estadoModifPresupVo) throws ExcepcionDAO {
        SiiEstadoModifPresup siiEstadoModifPresup = estadoModifPresupDao.actualizarEstadoModifPresup(conversionVoEntidad.convertir(estadoModifPresupVo));
        return ( new EstadoModifPresupVO(siiEstadoModifPresup) );
    }

    
    public EstadoModifPresupVO insertarEstadoModifPresup(EstadoModifPresupVO estadoModifPresupVo) throws ExcepcionDAO {
        SiiEstadoModifPresup siiEstadoModifPresup = estadoModifPresupDao.insertarEstadoModifPresup(conversionVoEntidad.convertir(estadoModifPresupVo));
        if (siiEstadoModifPresup!=null)
            estadoModifPresupVo.setEmpCodigo(siiEstadoModifPresup.getEmpCodigo());
        
        return ( new EstadoModifPresupVO(siiEstadoModifPresup) );
    }
}
