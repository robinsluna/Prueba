package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoIdentificacionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoIdentificacion {
    public TipoIdentificacionVO buscarTipoIdentificacionPorId(Long tidCodigo) throws ExcepcionDAO;
    public TipoIdentificacionVO buscarTipoIdentificacionPorId(TipoIdentificacionVO tipoIdentificacionVo) throws ExcepcionDAO;
    public List<TipoIdentificacionVO> buscarTipoIdentificacionPorNombre(TipoIdentificacionVO unTipoIdentificacionVo) throws ExcepcionDAO;
    public List<TipoIdentificacionVO> buscarTodosTipoIdentificacion() throws ExcepcionDAO;
    public TipoIdentificacionVO buscarTipoIdentificacionPorNombre(String tidNombre) throws ExcepcionDAO;
}
