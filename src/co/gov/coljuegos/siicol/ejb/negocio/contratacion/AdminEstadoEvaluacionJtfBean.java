/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 12-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEvaluacionJtf;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoEvaluacionJtfVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminEstadoEvaluacionJtfBean implements AdminEstadoEvaluacionJtf 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private EstadoEvaluacionJtfDAO estadoEvaluacionJtfDAO;
    
    
    /**
     * Constructor.
     */
    public AdminEstadoEvaluacionJtfBean() {
        super();
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#buscarPorCodigo(java.lang.Long)
     */
    @Override
    public EstadoEvaluacionJtfVO buscarPorCodigoEstadoEvaluacionJtf(Long idEstadoEvaluacionJtf) throws ExcepcionDAO {
        SiiEstadoEvaluacionJtf eejtf = estadoEvaluacionJtfDAO.buscarPorCodigo(idEstadoEvaluacionJtf);
        return ( new EstadoEvaluacionJtfVO(eejtf) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#insertar(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEvaluacionJtf)
     */
    @Override
    public EstadoEvaluacionJtfVO insertarSiiEstadoEvaluacionJtf(EstadoEvaluacionJtfVO estadoEvaluacionJtfVO) throws ExcepcionDAO {
        SiiEstadoEvaluacionJtf eejtf = estadoEvaluacionJtfDAO.insertar(conversionVoEntidad.convertir(estadoEvaluacionJtfVO));
        return ( new EstadoEvaluacionJtfVO(eejtf) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#actualizar(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEvaluacionJtf)
     */
    @Override
    public EstadoEvaluacionJtfVO actualizarSiiEstadoEvaluacionJtf(EstadoEvaluacionJtfVO estadoEvaluacionJtfVO) throws ExcepcionDAO {
        SiiEstadoEvaluacionJtf eejtf = estadoEvaluacionJtfDAO.actualizar(conversionVoEntidad.convertir(estadoEvaluacionJtfVO));
        return ( new EstadoEvaluacionJtfVO(eejtf) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#eliminar(java.lang.Long)
     */
    @Override
    public void borrarSiiEstadoEvaluacionJtf(Long idEstadoEvaluacionJtf) throws ExcepcionDAO {
        estadoEvaluacionJtfDAO.eliminar(idEstadoEvaluacionJtf);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO#buscarTodo()
     */
    @Override
    public List<EstadoEvaluacionJtfVO> buscarTodoEstadoEvaluacionJtf() throws ExcepcionDAO {
        List<EstadoEvaluacionJtfVO> listaEstadoEvaluacionJtfVO = null;
        List<SiiEstadoEvaluacionJtf> lista = estadoEvaluacionJtfDAO.buscarTodo();
        if (lista!=null) {
            listaEstadoEvaluacionJtfVO = new ArrayList<EstadoEvaluacionJtfVO>();
            for (SiiEstadoEvaluacionJtf siiEstadoEvaluacionJtf: lista) {
                listaEstadoEvaluacionJtfVO.add(new EstadoEvaluacionJtfVO(siiEstadoEvaluacionJtf));
            }
        }
        return listaEstadoEvaluacionJtfVO;
    }
    
}
