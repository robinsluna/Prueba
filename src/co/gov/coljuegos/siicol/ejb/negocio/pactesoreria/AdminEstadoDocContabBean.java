/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDocContabVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminEstadoDocContabBean implements AdminEstadoDocContab {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private EstadoDocContabDAO estadoDocContabDao;
    
    
    /**
     * Constructor.
     */
    public AdminEstadoDocContabBean() {
        super();
    }

    @Override
    public EstadoDocContabVO buscarPorCodigoEstadoDocContab(Long idEstadoDocContab) throws ExcepcionDAO {
        SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarPorCodigo(idEstadoDocContab);
        return ( new EstadoDocContabVO(siiEstadoDocContab) );
    }

    @Override
    public EstadoDocContabVO insertarEstadoDocContab(EstadoDocContabVO estadoDocContabVO) throws ExcepcionDAO {
        SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.insertar(conversionVoEntidad.convertir(estadoDocContabVO));
        return ( new EstadoDocContabVO(siiEstadoDocContab) );
    }

    @Override
    public EstadoDocContabVO actualizarEstadoDocContab(EstadoDocContabVO estadoDocContabVO) throws ExcepcionDAO {
        SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.actualizar(conversionVoEntidad.convertir(estadoDocContabVO));
        return ( new EstadoDocContabVO(siiEstadoDocContab) );
    }

    @Override
    public void borrarEstadoDocContab(Long idEstadoDocContab) throws ExcepcionDAO {
        estadoDocContabDao.eliminar(idEstadoDocContab);
    }

    @Override
    public List<EstadoDocContabVO> buscarTodoEstadoDocContab() throws ExcepcionDAO {
        List<EstadoDocContabVO> listaEstadoDocContab = null;
        List<SiiEstadoDocContab> lista = estadoDocContabDao.buscarTodo();
        if (lista!=null) {
            listaEstadoDocContab = new ArrayList<EstadoDocContabVO>();
            for (SiiEstadoDocContab siiEstadoDocContab: lista) {
                listaEstadoDocContab.add(new EstadoDocContabVO(siiEstadoDocContab));
            }
        }
        return (listaEstadoDocContab);
    }
}
