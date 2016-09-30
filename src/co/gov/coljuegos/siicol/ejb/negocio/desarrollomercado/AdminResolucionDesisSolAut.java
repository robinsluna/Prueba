package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioResolDesisVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionDesisSolAutVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminResolucionDesisSolAut {
    public ResolucionDesisSolAutVO buscarResolucionDesisSolAutPorId (Long rdsCodigo) throws ExcepcionDAO;
    public ResolucionDesisSolAutVO insertarResolucionDesisSolAut (ResolucionDesisSolAutVO resolucionDesisSolAutVo, UsuarioVO usuarioVo) throws ExcepcionDAO;
    public ResolucionDesisSolAutVO actualizarResolucionDesisSolAut (ResolucionDesisSolAutVO resolucionDesisSolAutVo, UsuarioVO usuarioVo) throws ExcepcionDAO;
    public void eliminarResolucionDesisSolAut (Long rdsCodigo) throws ExcepcionDAO;
    public List<ResolucionDesisSolAutVO> buscarTodaResolucionDesisSolAut() throws ExcepcionDAO;
    
    public void setListaInvResDesVoEliminar(List<InventarioResolDesisVO> listaInvResDesVoEliminar);
    public List<InventarioResolDesisVO> getListaInvResDesVoEliminar();
}
