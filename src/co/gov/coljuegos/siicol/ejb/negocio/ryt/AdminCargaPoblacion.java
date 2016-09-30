package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CargaPoblacionVO;
import co.gov.coljuegos.siicol.ejb.vo.EnteTerritorialVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminCargaPoblacion {
    public CargaPoblacionVO buscarCargaPoblacionPorId (Long cpoCodigo) throws ExcepcionDAO;
    public CargaPoblacionVO insertarCargaPoblacion (CargaPoblacionVO cargaPoblacionVo,
                                                       UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    public CargaPoblacionVO actualizarCargaPoblacion(CargaPoblacionVO cargaPoblacionVo) throws ExcepcionDAO;
    public void borrarCargaPoblacion (Long cpoCodigo) throws ExcepcionDAO;
    public List<CargaPoblacionVO> buscarTodoCargaPoblacion () throws ExcepcionDAO;
    public EnteTerritorialVO buscarEnteTerritorialXIdUbicacion(String idUbicacion) throws ExcepcionDAO;
    public Long consultarConsecutivoCargaPoblacion() throws ExcepcionDAO;
    public Long BuscarCargaPoblacionOrdenado() throws ExcepcionDAO;
    
}
