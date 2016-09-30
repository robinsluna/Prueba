package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoNovedadVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoNovedad {
    public TipoNovedadVO buscarTipoNovedadPorId (Long tnoCodigo) throws ExcepcionDAO;
    public TipoNovedadVO insertarTipoNovedad (TipoNovedadVO TipoNovedadVo) throws ExcepcionDAO;
    public TipoNovedadVO actualizarTipoNovedad (TipoNovedadVO TipoNovedadVo) throws ExcepcionDAO;
    public void eliminarTipoNovedad (Long rdsCodigo) throws ExcepcionDAO;
    public List<TipoNovedadVO> buscarTodaTipoNovedad() throws ExcepcionDAO;
       
}
