package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocSoporteVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoDocSoporte {
    public TipoDocSoporteVO buscarTipoDocumentoSoportePorId(Long idTipoDocSoporte) throws ExcepcionDAO;
    public List<TipoDocSoporteVO>  buscarTodoTipoDocumentoSoporte() throws ExcepcionDAO;
}
