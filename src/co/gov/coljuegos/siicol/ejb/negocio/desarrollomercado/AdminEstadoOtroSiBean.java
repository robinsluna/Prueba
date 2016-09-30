package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoOtrosiDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoOtroSiVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoOtroSiBean implements AdminEstadoOtroSi  {
    @EJB
    EstadoOtrosiDAO estadoOtroSiDao;
    
    public AdminEstadoOtroSiBean() {
        
    }
    
    public EstadoOtroSiVO buscarEstadoOtroSiPorNombre(String eosNombre) throws ExcepcionDAO {
        return new EstadoOtroSiVO(estadoOtroSiDao.buscarEstadoOtroSiPorNombre(eosNombre));
    }
    
    public EstadoOtroSiVO buscarEstadoOtroSiPorId(Long eosCodigo)  throws ExcepcionDAO  {
        return new EstadoOtroSiVO(estadoOtroSiDao.buscarPorCodigo(eosCodigo));
    }
    
}



