package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoPolizaContDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoPolizaContVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoPolizaContBean implements AdminEstadoPolizaCont {
    @EJB
    private EstadoPolizaContDAO estadoPolizaContDao;

    public AdminEstadoPolizaContBean() {

    }

    public EstadoPolizaContVO buscarEstadoPolizaContPorEstado(String estado) throws ExcepcionDAO {
        return new EstadoPolizaContVO(estadoPolizaContDao.buscarEstadoPolizaContPorEstado(estado));
    }
    
    public EstadoPolizaContVO buscarEstadoPolizaContPorId(Long epoCodigo) throws ExcepcionDAO {
        return new EstadoPolizaContVO(estadoPolizaContDao.buscarEstadoPolizaContPorId(epoCodigo));
    }
}
