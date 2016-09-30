package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoSolicAutorizaVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoSolicAutoriza {
    
    public TipoSolicAutorizaVO buscarTipoSolicAutorizaPorId (Long tsaCodigo) throws ExcepcionDAO;
    public TipoSolicAutorizaVO insertarTipoSolicAutoriza (TipoSolicAutorizaVO tipoSolicAutorizaVo) throws ExcepcionDAO;
    public TipoSolicAutorizaVO actualizarTipoSolicAutoriza (TipoSolicAutorizaVO tipoSolicAutorizaVo) throws ExcepcionDAO;
    public void eliminarTipoSolicAutoriza (Long tsaCodigo) throws ExcepcionDAO;
    public List<TipoSolicAutorizaVO> buscarTodaTipoSolicAutoriza() throws ExcepcionDAO;
}
