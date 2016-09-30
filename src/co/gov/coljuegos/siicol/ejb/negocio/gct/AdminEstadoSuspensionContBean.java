package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSuspensionContDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSuspensionContVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoSuspensionContBean implements AdminEstadoSuspensionCont {
    @EJB
    private EstadoSuspensionContDAO estadoSuspensionDao;

    public AdminEstadoSuspensionContBean() {

    }

    public EstadoSuspensionContVO buscarEstadoPorNombre(String string) throws ExcepcionDAO {
        return new EstadoSuspensionContVO(estadoSuspensionDao.buscarEstadoPorNombre(string));
    }
}
