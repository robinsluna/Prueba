package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RequisitosPolizaConVO;

import java.util.List;


public interface AdminRequisitosPolizaCon {
    public List<RequisitosPolizaConVO> buscarTodoRequisitoPoliza() throws ExcepcionDAO;
}
