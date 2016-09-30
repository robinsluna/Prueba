package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemPlanContratacDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PlanContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPlanContratacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacVO;

import co.gov.coljuegos.siicol.ejb.vo.PlanContratacionVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminPlanContratacionBean implements AdminPlanContratacion {
    
    @EJB
    PlanContratacionDAO planContratacionDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminPlanContratacionBean() {
    }
    
    public PlanContratacionVO insertarItemPlanContratac(PlanContratacionVO planContratacionVo) throws ExcepcionDAO {
        SiiPlanContratacion planContratacion = conversionVoEntidad.convertir(planContratacionVo);
        planContratacion = planContratacionDao.insertarPlanContratacion(planContratacion);
        return new PlanContratacionVO(planContratacion);
    }

    public PlanContratacionVO buscarItemPlanContratacPorId(Long idPlanContratacion) throws ExcepcionDAO {
        SiiPlanContratacion planContratacion = planContratacionDao.buscarPlanContratacionPorId(idPlanContratacion);
        return new PlanContratacionVO(planContratacion);
    }

    public PlanContratacionVO actualizarPlanContratacion(PlanContratacionVO planContratacionVo) throws ExcepcionDAO {
        SiiPlanContratacion planContratacion = conversionVoEntidad.convertir(planContratacionVo);
        planContratacion = planContratacionDao.actualizarPlanContratacion(planContratacion);
        return new PlanContratacionVO(planContratacion);
    }
    
}
