package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedArchFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedArchFisico;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ExpedArchFisicoVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminExpedArchFisicoBean implements AdminExpedArchFisico{
    
    @EJB
    ExpedArchFisicoDAO expedArchFisicoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminExpedArchFisicoBean(){
    }
    
    public ExpedArchFisicoVO insertarExpedArchFisico(ExpedArchFisicoVO expedArchFisicoVO) throws ExcepcionDAO{
        SiiExpedArchFisico siiExpedArchFisico = conversionVoEntidad.convertir(expedArchFisicoVO);
        siiExpedArchFisico = expedArchFisicoDao.insertarExpedArchivoFisico(siiExpedArchFisico);
        return new ExpedArchFisicoVO(siiExpedArchFisico);
    }
    public ExpedArchFisicoVO buscarExpedArchFisicoPorId(ExpedArchFisicoVO expedArchFisicoVO) throws ExcepcionDAO{
        SiiExpedArchFisico unExpedArchFisico = expedArchFisicoDao.buscarExpedArchivoFisicoPorId(expedArchFisicoVO.getEafCodigo());
        return new ExpedArchFisicoVO(unExpedArchFisico);
    }
    
    public ExpedArchFisicoVO actualizarExpedArchFisico(ExpedArchFisicoVO expedArchFisicoVO) throws ExcepcionDAO{
        SiiExpedArchFisico unExpedArchFisico = conversionVoEntidad.convertir(expedArchFisicoVO);
        unExpedArchFisico = expedArchFisicoDao.actualizarExpedArchivoFisico(unExpedArchFisico);
        return new ExpedArchFisicoVO(unExpedArchFisico);
    }
}
