package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModifPlanContVO;

import javax.ejb.Local;

@Local
public interface AdminEstadoModifPlanCont {
    public EstadoModifPlanContVO buscarEstadoPorNombre(String estado) throws ExcepcionDAO;
}
