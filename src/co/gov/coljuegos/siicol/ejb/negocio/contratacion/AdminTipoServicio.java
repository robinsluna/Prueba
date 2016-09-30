package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoServicioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoServicio {
    //public TipoServicioVO insertarTipoServicio(TipoServicioVO tipoServicioVO) throws ExcepcionDAO;

    public TipoServicioVO buscarTipoServicioPorId(Long idTipoServicio) throws ExcepcionDAO;

    //public TipoServicioVO actualizarTipoServicio(TipoServicioVO tipoServicioVO) throws ExcepcionDAO;

    public List<TipoServicioVO> buscarTodoTipoServicio() throws ExcepcionDAO;
    
    public TipoServicioVO buscarTipoServicioPorNombre(String nombreServicio) throws ExcepcionDAO;
}
