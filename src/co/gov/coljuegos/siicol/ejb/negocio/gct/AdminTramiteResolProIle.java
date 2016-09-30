package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProIleVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface  AdminTramiteResolProIle {
    public TramiteResolProIleVO buscarTramiteResolProIlePorCodigo (Long trpCodigo) throws ExcepcionDAO;
    public List<TramiteResolProIleVO> buscarTodoTramiteResolProIle() throws ExcepcionDAO;
    public List<TramiteResolProIleVO> buscarTramiteResolProIlePorIdResolucion (Long repCodigo) throws ExcepcionDAO;
    public TramiteResolProIleVO insertarTramiteResolProIle (TramiteResolProIleVO tramiteVo) throws ExcepcionDAO;
    public TramiteResolProIleVO actualizarTramiteResolProIle (TramiteResolProIleVO tramiteVo) throws ExcepcionDAO;
    public void eliminarTramiteResolProIle (Long trpCodigo) throws ExcepcionDAO;

}
