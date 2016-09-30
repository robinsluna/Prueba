package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoModifPlanContDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModifPlanContVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoModifPlanContBean implements AdminEstadoModifPlanCont {

    @EJB
    private EstadoModifPlanContDAO estadoModifPlanContDao;
    
    public AdminEstadoModifPlanContBean() {
        
    }

    public EstadoModifPlanContVO buscarEstadoPorNombre(String estado) throws ExcepcionDAO {
        
        return new EstadoModifPlanContVO(estadoModifPlanContDao.buscarEstadoPorNombre(estado));
    }
}
