package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcContrat;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcContratVO;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminEstadoProcContratBean implements AdminEstadoProcContrat {
    @Resource
    SessionContext sessionContext;
    
    @EJB 
    EstadoProcContratDAO estadoProcContratDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    
    public AdminEstadoProcContratBean() {
    }

    public EstadoProcContratVO BuscarEstadoProcContratPorId(Long id) throws ExcepcionDAO {
        return new EstadoProcContratVO(estadoProcContratDao.BuscarEstadoProcContratPorId(id));
    }

    public EstadoProcContratVO insertarEstadoProcContrat(EstadoProcContratVO estadoProcContratVO) throws ExcepcionDAO {
        return new EstadoProcContratVO(estadoProcContratDao.insertarEstadoProcContrat(conversionVoEntidad.convertir(estadoProcContratVO)));
    }

    public EstadoProcContratVO actualizarEstadoProcContrat(EstadoProcContratVO estadoProcContratVO) throws ExcepcionDAO {
        return new EstadoProcContratVO(estadoProcContratDao.actualizarEstadoProcContrat(conversionVoEntidad.convertir(estadoProcContratVO)));
    }

    public void eliminarEstadoProcContrat(Long id) throws ExcepcionDAO {
        estadoProcContratDao.eliminarEstadoProcContrat(id);
        
    }

    public EstadoProcContratVO buscarEstadoProcContratPorEstado(String estado) throws ExcepcionDAO {
        SiiEstadoProcContrat estadoProcContrat = estadoProcContratDao.buscarEstadoProcContratPorEstado(estado);
        EstadoProcContratVO estadoProcContratVO = new EstadoProcContratVO(estadoProcContrat);
        return estadoProcContratVO;
    }
}
