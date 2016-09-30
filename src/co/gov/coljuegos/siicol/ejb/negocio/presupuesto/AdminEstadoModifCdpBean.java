package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoModifCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifCdp;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModifCdpVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminEstadoModifCdpBean implements AdminEstadoModifCdp {
    @EJB 
    EstadoModifCdpDAO estadoModifCdpDao;

    public AdminEstadoModifCdpBean() {

    }
    
    public EstadoModifCdpVO buscarEstadoModifCdpPorId(Long emcCodigo) throws ExcepcionDAO {
        SiiEstadoModifCdp estadoModifCdp = estadoModifCdpDao.buscarEstadoModifCdpPorId(emcCodigo);
        if (estadoModifCdp != null) {
            return new EstadoModifCdpVO(estadoModifCdp);
        } else {
            return new EstadoModifCdpVO();
        }
    }
    
    public EstadoModifCdpVO buscarEstadoModifCdpPorNombre(String nombre) throws ExcepcionDAO {
        SiiEstadoModifCdp estadoModifCdp = estadoModifCdpDao.buscarEstadoModifCdpPorNombre(nombre);
        if (estadoModifCdp != null) {
            return new EstadoModifCdpVO(estadoModifCdp);
        } else {
            return new EstadoModifCdpVO();
        }
    }
}
