/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 12-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaEvaluacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaEvaluacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.PropuestaEvaluacionVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class AdminPropuestaEvaluacionBean implements AdminPropuestaEvaluacion 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private PropuestaEvaluacionDAO propuestaEvaluacionDAO;
    
    
    /**
     * Constructor.
     */
    public AdminPropuestaEvaluacionBean() {
        super();
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#buscarPorCodigo(java.lang.Long)
     */
    @Override
    public PropuestaEvaluacionVO buscarPorCodigoPropuestaRecib(Long idCodigoPropuestaEvaluacion) throws ExcepcionDAO {
        SiiPropuestaEvaluacion siiPev = propuestaEvaluacionDAO.buscarPorCodigoPropuestaEvaluacion(idCodigoPropuestaEvaluacion);
        return ( new PropuestaEvaluacionVO(siiPev) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#insertarSiiPropuestaEvaluacion(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaEvaluacion)
     */
    @Override
    public PropuestaEvaluacionVO insertarSiiPropuestaEvaluacion(PropuestaEvaluacionVO propuestaEvaluacionVO) throws ExcepcionDAO {
        SiiPropuestaEvaluacion siiPev = propuestaEvaluacionDAO.insertarSiiPropuestaEvaluacion(conversionVoEntidad.convertir(propuestaEvaluacionVO));
        return ( new PropuestaEvaluacionVO(siiPev) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#actualizarSiiPropuestaEvaluacion(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaEvaluacion)
     */
    @Override
    public PropuestaEvaluacionVO actualizarSiiPropuestaEvaluacion(PropuestaEvaluacionVO propuestaEvaluacionVO) throws ExcepcionDAO {
        SiiPropuestaEvaluacion siiPev = propuestaEvaluacionDAO.actualizarSiiPropuestaEvaluacion(conversionVoEntidad.convertir(propuestaEvaluacionVO));
        return ( new PropuestaEvaluacionVO(siiPev) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#borrarSiiPropuestaEvaluacion(java.lang.Long)
     */
    @Override
    public void borrarSiiPropuestaEvaluacion(Long idCodigoPropuestaEvaluacion) throws ExcepcionDAO {
        propuestaEvaluacionDAO.borrarSiiPropuestaEvaluacion(idCodigoPropuestaEvaluacion);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#buscarTodaPropuestaEvaluacionVO()
     */
    @Override
    public List<PropuestaEvaluacionVO> buscarTodaPropuestaEvaluacionVO() throws ExcepcionDAO {
        List<PropuestaEvaluacionVO> listaPropuestaEvaluacionVO = null;
        List<SiiPropuestaEvaluacion> lista = propuestaEvaluacionDAO.buscarTodaPropuestaEvaluacion();
        if (lista!=null) {
            listaPropuestaEvaluacionVO = new ArrayList<PropuestaEvaluacionVO>();
            for (SiiPropuestaEvaluacion siiPev: lista) {
                listaPropuestaEvaluacionVO.add(new PropuestaEvaluacionVO(siiPev));
            }
        }
        return listaPropuestaEvaluacionVO;
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#buscarPorCodigoEvaluacionJurTecFin(java.lang.Long)
     */
    @Override
    public List<PropuestaEvaluacionVO> buscarPorCodigoEvaluacionJurTecFin(Long ejtCodigo) throws ExcepcionDAO 
    {
        List<PropuestaEvaluacionVO> listaPropuestaEvaluacionVO = null;
        List<SiiPropuestaEvaluacion> lista = propuestaEvaluacionDAO.buscarPorCodigoEvaluacionJurTecFin(ejtCodigo);
        if (lista!=null) {
            listaPropuestaEvaluacionVO = new ArrayList<PropuestaEvaluacionVO>();
            for (SiiPropuestaEvaluacion siiPev: lista) {
                listaPropuestaEvaluacionVO.add(new PropuestaEvaluacionVO(siiPev));
            }
        }
        return listaPropuestaEvaluacionVO;
    }
    
}
