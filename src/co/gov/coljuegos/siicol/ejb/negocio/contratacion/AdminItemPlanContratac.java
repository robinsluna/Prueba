package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacionCdpVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminItemPlanContratac {
    public ItemPlanContratacVO insertarItemPlanContratac(ItemPlanContratacVO itemPlanContratacVO) throws ExcepcionDAO;
    public ItemPlanContratacVO buscarItemPlanContratacPorId(Long idItemPlanContratac) throws ExcepcionDAO;
    public ItemPlanContratacVO actualizarItemPlanContratac(ItemPlanContratacVO itemPlanContratacVO) throws ExcepcionDAO;
    public List<ItemPlanContratacVO> buscarTodoItemPlanContratac() throws ExcepcionDAO;
    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorSEMArea(Long idArea, Long anoVigencia) throws ExcepcionDAO;
    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorArea (Long idArea, Long anoVigencia) throws ExcepcionDAO;
    public void insertarItemsPlanContratacionTotal(List<ItemPlanContratacVO> listaItemsPlanContratac) throws ExcepcionDAO, ExcepcionAplicacion;
    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorVigencia (Long anoVigencia) throws ExcepcionDAO;
    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorSEM(Long anoVigencia) throws ExcepcionDAO;
    public List<ItemPlanContratacVO> buscarItemPlanContratacVigencia(Long anoVigencia) throws ExcepcionDAO; 
    public List<ItemPlanContratacVO> itemsPlanContratacionPorModificacion(Long mpcCodigo) throws ExcepcionDAO;
}
