package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ModPlanConItemPlanDetRubVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminModPlanConItemPlanDetRub {
    public List<ModPlanConItemPlanDetRubVO> detRubrosPorModPlan(Long mpcCodigo) throws ExcepcionDAO;
    public List<ModPlanConItemPlanDetRubVO> detRubrosModPorItemDetRubPorItemPlan(Long idrCodigo, Long ipcCodigo) throws ExcepcionDAO;
}
