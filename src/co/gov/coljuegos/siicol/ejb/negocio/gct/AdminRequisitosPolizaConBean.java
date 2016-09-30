package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RequisitosPolizaConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRequisitosPolizaCon;
import co.gov.coljuegos.siicol.ejb.vo.RequisitosPolizaConVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRequisitosPolizaConBean implements AdminRequisitosPolizaCon {
    @EJB 
    private RequisitosPolizaConDAO requisitosPolizaDao;
    
    public AdminRequisitosPolizaConBean() {
        
    }
    
    public List<RequisitosPolizaConVO> buscarTodoRequisitoPoliza() throws ExcepcionDAO {
         List<SiiRequisitosPolizaCon> requisitos;
         List<RequisitosPolizaConVO> requisitosVo = new ArrayList<RequisitosPolizaConVO>();
         requisitos = requisitosPolizaDao.buscarTodoRequisitoPoliza();
         for (SiiRequisitosPolizaCon requisito : requisitos) {
             requisitosVo.add(new RequisitosPolizaConVO(requisito));
             
         }
         return requisitosVo;

    }
}
