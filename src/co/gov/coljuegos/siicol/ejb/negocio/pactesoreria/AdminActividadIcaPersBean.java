/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 31-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActividadIcaPersDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActividadIcaPers;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ActividadIcaPersVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminActividadIcaPersBean implements AdminActividadIcaPers {
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ActividadIcaPersDAO actividadIcaPersDao;
    
    
    /**
     * Constructor.
     */
    public AdminActividadIcaPersBean() { }
    
    
    
    @Override
    public ActividadIcaPersVO buscarPorCodigoActividadIcaPers(Long aipCodigo) throws ExcepcionDAO {
        SiiActividadIcaPers siiActividadIcaPers = actividadIcaPersDao.buscarPorCodigo(aipCodigo);
        return ( new ActividadIcaPersVO(siiActividadIcaPers) );
    }

    @Override
    public ActividadIcaPersVO insertarActividadIcaPers(ActividadIcaPersVO actividadIcaPersVO) throws ExcepcionDAO {
        SiiActividadIcaPers siiActividadIcaPers = actividadIcaPersDao.insertar(conversionVoEntidad.convertir(actividadIcaPersVO));
        actividadIcaPersVO.setAipCodigo(siiActividadIcaPers.getAipCodigo());
        return ( new ActividadIcaPersVO(siiActividadIcaPers) );
    }

    @Override
    public ActividadIcaPersVO actualizarActividadIcaPers(ActividadIcaPersVO actividadIcaPersVO) throws ExcepcionDAO {
        SiiActividadIcaPers siiActividadIcaPers = actividadIcaPersDao.actualizar(conversionVoEntidad.convertir(actividadIcaPersVO));
        return ( new ActividadIcaPersVO(siiActividadIcaPers) );
    }

    @Override
    public void borrarActividadIcaPers(Long aipCodigo) throws ExcepcionDAO {
        actividadIcaPersDao.eliminar(aipCodigo);
    }

    @Override
    public List<ActividadIcaPersVO> buscarTodaActividadIcaPers() throws ExcepcionDAO {
        List<ActividadIcaPersVO>  listaAcitividadIcaPers = new ArrayList<ActividadIcaPersVO>();
        List<SiiActividadIcaPers> lista = actividadIcaPersDao.buscarTodo();
        
        if (lista!=null) {
            for (SiiActividadIcaPers siiActividadIcaPers : lista){
                listaAcitividadIcaPers.add(new ActividadIcaPersVO(siiActividadIcaPers));
            }
        }
        
        return (listaAcitividadIcaPers);
    }

    @Override
    public List<ActividadIcaPersVO> buscarPorCodigoPersona(Long perCodigo) throws ExcepcionDAO {
        List<ActividadIcaPersVO>  listaActividadIcaPers = new ArrayList<ActividadIcaPersVO>();
        List<SiiActividadIcaPers> lista = actividadIcaPersDao.buscarPorCodigoPersona(perCodigo);
        
        if (lista!=null) {
            for (SiiActividadIcaPers siiActividadIcaPers : lista){
                listaActividadIcaPers.add(new ActividadIcaPersVO(siiActividadIcaPers));
            }
        }
        
        return (listaActividadIcaPers);
    }

    @Override
    public ActividadIcaPersVO buscarActividadIcaPersPrincipalPorCodigoPersona(Long perCodigo) throws ExcepcionDAO {
        SiiActividadIcaPers siiActividadIcaPers = actividadIcaPersDao.buscarActividadIcaPersPrincipalPorCodigoPersona(perCodigo);
        return ( new ActividadIcaPersVO(siiActividadIcaPers) );
    }
    
    
    @Override
    public List<ActividadIcaPersVO> buscarPorTipoContribuyenteProveedor(String perTipoPersona, String perTipoProveed) 
        throws ExcepcionDAO 
    {
        List<ActividadIcaPersVO>  listaActividadIcaPers = new ArrayList<ActividadIcaPersVO>();
        List<SiiActividadIcaPers> lista = actividadIcaPersDao.buscarPorTipoContribuyenteProveedor(perTipoPersona, perTipoProveed);
        
        if (lista!=null) {
            for (SiiActividadIcaPers siiActividadIcaPers : lista){
                listaActividadIcaPers.add(new ActividadIcaPersVO(siiActividadIcaPers));
            }
        }
        
        return (listaActividadIcaPers);
    }
}
