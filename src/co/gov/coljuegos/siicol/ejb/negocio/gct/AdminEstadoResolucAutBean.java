package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoResolucAutDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoResolucAutVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoResolucAutBean implements AdminEstadoResolucAut{
    @EJB
    EstadoResolucAutDAO estadoResolucAutDao;

    public AdminEstadoResolucAutBean() {
        
    }
    public EstadoResolucAutVO buscarEstadoResolucAutPorId(Long idEstado) throws ExcepcionDAO {
        return(new EstadoResolucAutVO(estadoResolucAutDao.buscarEstadoResolucAutPorId(idEstado)));
    }
    
    public EstadoResolucAutVO buscarEstadoResolucAutPorEstado(String estado) throws ExcepcionDAO{
        return(new EstadoResolucAutVO(estadoResolucAutDao.buscarEstadoResolucAutPorEstado(estado)));
    }
}
