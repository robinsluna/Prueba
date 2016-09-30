package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCuentaContableVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstadoCuentaContable {
    public EstadoCuentaContableVO buscarEstadoCuentaContablePorCodigo(Long idEstado) throws ExcepcionDAO;
    public List<EstadoCuentaContableVO> buscarTodoEstadoCuentaContable() throws ExcepcionDAO;
}
