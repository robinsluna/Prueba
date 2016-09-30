package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemPlanContDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroPresupuestalConItemContratacionVigenciaVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminItemPlanContDetRubBean implements AdminItemPlanContDetRub{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ItemPlanContDetRubDAO itemPlanContDetRubDao;

    public AdminItemPlanContDetRubBean() {
    }

    public ItemPlanContDetRubVO buscarItemPlanContDetRubPorId(long idItemPlanContDetRub) throws ExcepcionDAO {
        
        return new ItemPlanContDetRubVO(itemPlanContDetRubDao.buscarItemPlanContDetRubPorId(idItemPlanContDetRub));
    }

    public ItemPlanContDetRubVO insertarItemPlanContDetRub(ItemPlanContDetRubVO itemPlanContDetRubVO) throws ExcepcionDAO {
        return new ItemPlanContDetRubVO(itemPlanContDetRubDao.insertarItemPlanContDetRub(conversionVoEntidad.convertir(itemPlanContDetRubVO)));
    }

    public ItemPlanContDetRubVO actualizarItemPlanContDetRub(ItemPlanContDetRubVO itemPlanContDetRubVO) throws ExcepcionDAO {

        return new ItemPlanContDetRubVO(itemPlanContDetRubDao.actualizarItemPlanContDetRub(conversionVoEntidad.convertir(itemPlanContDetRubVO)));
    }

    public void eliminarItemPlanContDetRub(long idItemPlanContDetRub) throws ExcepcionDAO {
        itemPlanContDetRubDao.eliminarItemPlanContDetRub(idItemPlanContDetRub);
    }

    public List<ItemPlanContratacVO> buscarTodoItemPlanContXVigencia() throws ExcepcionDAO {
        Date fecha=new Date();
        Integer  año;
        Calendar Cal = Calendar.getInstance();
        año= (Cal.get(Calendar.YEAR));
        List<SiiItemPlanContratac> listaItemPlanContDetRub = itemPlanContDetRubDao.buscarTodoItemPlanContXVigencia(2015);
        List<ItemPlanContratacVO> listaItemPlanContratacVO = new ArrayList();
        for (SiiItemPlanContratac unItemPlanContDetRub : listaItemPlanContDetRub) {
            listaItemPlanContratacVO.add(new ItemPlanContratacVO(unItemPlanContDetRub));
        }
        return listaItemPlanContratacVO;
    }
    
    public List<RubroPresupuestalConItemContratacionVigenciaVO> buscarRubrosPresupuestalesConItemPlanContratacionVigencia (Integer vigencia) throws ExcepcionDAO{
        return itemPlanContDetRubDao.buscarRubrosPresupuestalesConItemPlanContratacionVigencia(vigencia);
    }

    public List<ItemPlanContDetRubVO> buscarItemsPlanContDetRub(Long ipcCodigo) throws ExcepcionDAO {
        List<ItemPlanContDetRubVO> lista = new ArrayList<ItemPlanContDetRubVO>();
        for (SiiItemPlanContDetRub item : itemPlanContDetRubDao.buscarItemsPlanContDetRub(ipcCodigo)) {
            lista.add(new ItemPlanContDetRubVO(item));
        }
        return lista;
    }
    
    public BigDecimal presupuestoItemPlan(Long ipcCodigo) throws ExcepcionDAO {
        return itemPlanContDetRubDao.presupuestoItemPlan(ipcCodigo);
    }
}


