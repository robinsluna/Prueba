package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoModificRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModificRp;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModificRpVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminEstadoModificRpBean implements AdminEstadoModificRp {
    @EJB
    EstadoModificRpDAO estadoModificRpDao;

    public AdminEstadoModificRpBean() {

    }

    public EstadoModificRpVO buscarEstadoModificRpPorId(Long mrpCodigo) throws ExcepcionDAO {
        SiiEstadoModificRp estadoModificRp = estadoModificRpDao.buscarEstadoModificRpPorId(mrpCodigo);
        if (estadoModificRp != null) {
            return new EstadoModificRpVO(estadoModificRp);
        } else {
            return new EstadoModificRpVO();
        }

    }

    public EstadoModificRpVO buscarEstadoModificRpPorNombre(String nombre) throws ExcepcionDAO {
        SiiEstadoModificRp estadoModificRp = estadoModificRpDao.buscarEstadoModificRpPorNombre(nombre);
        if (estadoModificRp != null) {
            return new EstadoModificRpVO(estadoModificRp);
        } else {
            return new EstadoModificRpVO();
        }

    }

}
