package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ExpedArchFisicoVO;

import javax.ejb.Local;

@Local
public interface AdminExpedArchFisico {
    
    public ExpedArchFisicoVO insertarExpedArchFisico(ExpedArchFisicoVO expedArchFisicoVO) throws ExcepcionDAO;
    public ExpedArchFisicoVO buscarExpedArchFisicoPorId(ExpedArchFisicoVO expedArchFisicoVO) throws ExcepcionDAO;
    public ExpedArchFisicoVO actualizarExpedArchFisico(ExpedArchFisicoVO expedArchFisicoVO) throws ExcepcionDAO;
}
