package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteFisicoDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteFisico;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.ExpedienteFisicoVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminExpedienteFisicoBean implements AdminExpedienteFisico{
    
    @EJB
    ExpedienteFisicoDAO expedienteFisicoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminExpedienteFisicoBean() {
    }
    
    public ExpedienteFisicoVO insertarExpedienteFisico(ExpedienteFisicoVO expedienteFisicoVO) throws ExcepcionDAO{
        SiiExpedienteFisico siiExpedienteFisico = conversionVoEntidad.convertir(expedienteFisicoVO);
        siiExpedienteFisico = expedienteFisicoDao.insertarExpedienteFisico(siiExpedienteFisico);
        return new ExpedienteFisicoVO(siiExpedienteFisico);
    }
    public ExpedienteFisicoVO buscarExpedienteFisicoPorId(ExpedienteFisicoVO expedienteFisicoVO) throws ExcepcionDAO{
        SiiExpedienteFisico unExpedienteFisico = expedienteFisicoDao.buscarExpedienteFisicoPorId(expedienteFisicoVO.getEfiCodigo());
        return new ExpedienteFisicoVO(unExpedienteFisico);
    }
    
    public ExpedienteFisicoVO actualizarExpedienteFisico(ExpedienteFisicoVO expedienteFisicoVO) throws ExcepcionDAO{
        SiiExpedienteFisico unExpedienteFisico = conversionVoEntidad.convertir(expedienteFisicoVO);
        unExpedienteFisico = expedienteFisicoDao.actualizarExpedienteFisico(unExpedienteFisico);
        return new ExpedienteFisicoVO(unExpedienteFisico);
    }
}
