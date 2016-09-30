/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 03-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoObligacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoObligacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoObligacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminEstadoObligacionBean implements AdminEstadoObligacion 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private EstadoObligacionDAO estadoObligacionDAO;
    
    
    /**
     * Constructor.
     */
    public AdminEstadoObligacionBean() {
        super();
    }
    
    
    
    @Override
    public EstadoObligacionVO buscarPorCodigoEstadoObligacion(Long idEstadoObligacion) throws ExcepcionDAO {
        SiiEstadoObligacion siiEstadoObligacion = estadoObligacionDAO.buscarPorCodigo(idEstadoObligacion);
        return new EstadoObligacionVO(siiEstadoObligacion);
    }

    @Override
    public EstadoObligacionVO insertarSiiEstadoObligacion(EstadoObligacionVO estadoObligacionVO) throws ExcepcionDAO {
        SiiEstadoObligacion siiEstadoObligacion = estadoObligacionDAO.insertar(conversionVoEntidad.convertir(estadoObligacionVO));
        return new EstadoObligacionVO(siiEstadoObligacion);
    }

    @Override
    public EstadoObligacionVO actualizarSiiEstadoObligacion(EstadoObligacionVO estadoObligacionVO) throws ExcepcionDAO {
        SiiEstadoObligacion siiEstadoObligacion = estadoObligacionDAO.actualizar(conversionVoEntidad.convertir(estadoObligacionVO));
        return new EstadoObligacionVO(siiEstadoObligacion);
    }

    @Override
    public void borrarSiiEstadoObligacion(Long idEstadoObligacion) throws ExcepcionDAO {
        estadoObligacionDAO.eliminar(idEstadoObligacion);
    }

    @Override
    public List<EstadoObligacionVO> buscarTodoEstadoObligacion() throws ExcepcionDAO {
        List<EstadoObligacionVO> listaEstadoObligacion = null;
        List<SiiEstadoObligacion> lista = estadoObligacionDAO.buscarTodo();
        if (lista!=null) {
            listaEstadoObligacion = new ArrayList<EstadoObligacionVO>();
            for (SiiEstadoObligacion siiEstadoObligacion: lista) {
                listaEstadoObligacion.add(new EstadoObligacionVO(siiEstadoObligacion));
            }
        }
        return (listaEstadoObligacion);
    }
}
