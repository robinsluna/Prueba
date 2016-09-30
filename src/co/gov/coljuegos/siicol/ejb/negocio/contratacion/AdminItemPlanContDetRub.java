package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroPresupuestalConItemContratacionVigenciaVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminItemPlanContDetRub {
    public ItemPlanContDetRubVO buscarItemPlanContDetRubPorId(long idItemPlanContDetRub) throws ExcepcionDAO;
    public ItemPlanContDetRubVO insertarItemPlanContDetRub(ItemPlanContDetRubVO itemPlanContDetRubVO) throws ExcepcionDAO;
    public ItemPlanContDetRubVO actualizarItemPlanContDetRub(ItemPlanContDetRubVO itemPlanContDetRubVO) throws ExcepcionDAO;
    public void eliminarItemPlanContDetRub(long idItemPlanContDetRub) throws ExcepcionDAO;
    public List<ItemPlanContratacVO> buscarTodoItemPlanContXVigencia() throws ExcepcionDAO;
    public List<RubroPresupuestalConItemContratacionVigenciaVO> buscarRubrosPresupuestalesConItemPlanContratacionVigencia (Integer vigencia) throws ExcepcionDAO;
    public List<ItemPlanContDetRubVO> buscarItemsPlanContDetRub(Long ipcCodigo) throws ExcepcionDAO;
    public BigDecimal presupuestoItemPlan(Long ipcCodigo) throws ExcepcionDAO;
}
