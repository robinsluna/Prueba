package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ConsultaWebContratVO;

import java.util.List;

import javax.ejb.Local;
@Local
public interface AdminConsultaWebContrat {
    public ConsultaWebContratVO buscarConsultaWebContratPorId(ConsultaWebContratVO consultaWebContratVO) throws ExcepcionDAO;

    public ConsultaWebContratVO insertarConsultaWebContrat(ConsultaWebContratVO consultaWebContratVO) throws ExcepcionDAO;

    public ConsultaWebContratVO actualizarConsultaWebContrat(ConsultaWebContratVO consultaWebContratVO) throws ExcepcionDAO;

    public void eliminarConsultaWebContratPorId(ConsultaWebContratVO consultaWebContratVO) throws ExcepcionDAO;

    public List<ConsultaWebContratVO> buscarTodoConsultaWebContrat() throws ExcepcionDAO;
}
