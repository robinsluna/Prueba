package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteFisico;
import co.gov.coljuegos.siicol.ejb.vo.ExpedienteFisicoVO;

import javax.ejb.Local;

@Local
public interface AdminExpedienteFisico {
    public ExpedienteFisicoVO insertarExpedienteFisico(ExpedienteFisicoVO expedienteFisicoVO) throws ExcepcionDAO;
    public ExpedienteFisicoVO buscarExpedienteFisicoPorId(ExpedienteFisicoVO expedienteFisicoVO) throws ExcepcionDAO;
    public ExpedienteFisicoVO actualizarExpedienteFisico(ExpedienteFisicoVO expedienteFisicoVO) throws ExcepcionDAO;
}
