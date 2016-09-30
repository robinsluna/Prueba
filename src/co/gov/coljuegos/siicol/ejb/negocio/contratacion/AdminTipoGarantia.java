package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoGarantiaVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoGarantia {
    public TipoGarantiaVO buscarTipoGarantiaPorId(Long idTipoGarantia) throws ExcepcionDAO;
    public List<TipoGarantiaVO> buscarTodosTipoGarantia() throws ExcepcionDAO;    
    public List<TipoGarantiaVO> buscarTipoGarantiaPorNombre(String nombreGarantia) throws ExcepcionDAO;
}
