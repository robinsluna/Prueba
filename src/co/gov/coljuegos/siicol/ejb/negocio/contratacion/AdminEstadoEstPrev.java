package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoEstPrevVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstadoEstPrev {
    public EstadoEstPrevVO buscarEstadoEstPrevPorId(Long idEstadoEstPrev) throws ExcepcionDAO;
    public EstadoEstPrevVO insertarEstadoEstPrevPorId(EstadoEstPrevVO estadoEstPrevVo) throws ExcepcionDAO;    
    public EstadoEstPrevVO actualizarEstadoEstPrevPorId(EstadoEstPrevVO estadoEstPrevVo) throws ExcepcionDAO;
    public List<EstadoEstPrevVO> buscarTodoEstadoEstPrev() throws ExcepcionDAO;
}
