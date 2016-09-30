package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoActuacionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoActuacion {
    
    public List<TipoActuacionVO> buscarTodoTipoActuacion() throws ExcepcionDAO;
    
    public TipoActuacionVO buscarTipoActuacionPorNombre(String tipoActuacion) throws ExcepcionDAO;
    
    public TipoActuacionVO buscarTipoActuacionPorCodigo(Long tacCodigo) throws ExcepcionDAO;
}
