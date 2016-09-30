package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPlanContratacion;
import co.gov.coljuegos.siicol.ejb.vo.PlanContratacionVO;

import javax.ejb.Local;

@Local
public interface AdminPlanContratacion {
    public PlanContratacionVO insertarItemPlanContratac(PlanContratacionVO planContratacionVo) throws ExcepcionDAO;
    public PlanContratacionVO buscarItemPlanContratacPorId(Long idPlanContratacion) throws ExcepcionDAO;
    public PlanContratacionVO actualizarPlanContratacion(PlanContratacionVO planContratacionVo) throws ExcepcionDAO;
}
