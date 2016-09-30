/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaRecibDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaRecib;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.PropuestaRecibVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminPropuestaRecibBean implements AdminPropuestaRecib 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad; 
    @EJB
    private PropuestaRecibDAO propuestaRecibDao;
    
    
    /**
     * Constructor.
     */
    public AdminPropuestaRecibBean() {
        super();
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaRecibDAO#buscarPorCodigoPropuestaRecib(java.lang.Long)
     */
    @Override
    public PropuestaRecibVO buscarPorCodigoPropuestaRecib (Long idCodigoPropuestaRecib) throws ExcepcionDAO {
        SiiPropuestaRecib pr = propuestaRecibDao.buscarPorCodigoPropuestaRecib(idCodigoPropuestaRecib);
        return ( new PropuestaRecibVO(pr) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaRecibDAO#insertarSiiPropuestaRecib(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaRecib)
     */
    @Override
    public PropuestaRecibVO insertarSiiPropuestaRecib (PropuestaRecibVO propuestaRecibVO) throws ExcepcionDAO {
        SiiPropuestaRecib pr = propuestaRecibDao.insertarSiiPropuestaRecib(conversionVoEntidad.convertir(propuestaRecibVO));
        return ( new PropuestaRecibVO(pr) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaRecibDAO#actualizarSiiPropuestaRecib(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaRecib)
     */
    @Override
    public PropuestaRecibVO actualizarSiiPropuestaRecib (PropuestaRecibVO propuestaRecibVO) throws ExcepcionDAO {
        SiiPropuestaRecib pr = propuestaRecibDao.actualizarSiiPropuestaRecib(conversionVoEntidad.convertir(propuestaRecibVO));
        return ( new PropuestaRecibVO(pr) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaRecibDAO#borrarSiiPropuestaRecib(java.lang.Long)
     */
    @Override
    public void borrarSiiPropuestaRecib (Long idCodigoPropuestaRecib) throws ExcepcionDAO {
        propuestaRecibDao.borrarSiiPropuestaRecib(idCodigoPropuestaRecib);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaRecibDAO#buscarPorCodigoRecepcionPropuestas(java.lang.Long)
     */
    @Override
    public List<PropuestaRecibVO> buscarPorCodigoRecepcionPropuestas(Long rprCodigo) throws ExcepcionDAO {
        List<PropuestaRecibVO> listaPropuestaRecibVO = null;
        List<SiiPropuestaRecib> lista = propuestaRecibDao.buscarPorCodigoRecepcionPropuestas(rprCodigo);
        
        if (lista!=null) {
            listaPropuestaRecibVO = new ArrayList<PropuestaRecibVO>();
            for (SiiPropuestaRecib siiPR: lista) {
                listaPropuestaRecibVO.add(new PropuestaRecibVO(siiPR));
            }
        }
        
        return (listaPropuestaRecibVO);
    }
}
