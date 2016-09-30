package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModPlanConItemPlanDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPlanConItemPlanDetRub;
import co.gov.coljuegos.siicol.ejb.vo.ModPlanConItemPlanDetRubVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminModPlanConItemPlanDetRubBean implements AdminModPlanConItemPlanDetRub {
    @EJB
    private ModPlanConItemPlanDetRubDAO modPlanConItemPlanDetRubDao;
    
    public AdminModPlanConItemPlanDetRubBean() {        
    }


    
    public List<ModPlanConItemPlanDetRubVO> detRubrosPorModPlan(Long mpcCodigo) throws ExcepcionDAO {
        List<ModPlanConItemPlanDetRubVO> itemsDetRubVo = new ArrayList<ModPlanConItemPlanDetRubVO>();
        for (SiiModPlanConItemPlanDetRub modItemDetRub : modPlanConItemPlanDetRubDao.detRubrosPorModPlan(mpcCodigo)) {
            itemsDetRubVo.add(new ModPlanConItemPlanDetRubVO(modItemDetRub));
        }
        return itemsDetRubVo;
    }

    public List<ModPlanConItemPlanDetRubVO> detRubrosModPorItemDetRubPorItemPlan(Long idrCodigo, Long ipcCodigo) throws ExcepcionDAO  {
        List<ModPlanConItemPlanDetRubVO> itemsDetRubVo = new ArrayList<ModPlanConItemPlanDetRubVO>();
        for (SiiModPlanConItemPlanDetRub modItemDetRub : modPlanConItemPlanDetRubDao.detRubrosModPorItemDetRubPorItemPlan(idrCodigo,ipcCodigo)) {
            itemsDetRubVo.add(new ModPlanConItemPlanDetRubVO(modItemDetRub));
        }
        return itemsDetRubVo;
    }
}
