package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PoblacionEnteVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

public interface AdminPoblacionEnte {
    public PoblacionEnteVO buscarPoblacionEntePorId (Long cpoCodigo) throws ExcepcionDAO;
    public PoblacionEnteVO insertarPoblacionEnte(PoblacionEnteVO poblacionEnteVo,
                                                       UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    public PoblacionEnteVO actualizarPoblacionEnte(PoblacionEnteVO poblacionEnteVo) throws ExcepcionDAO;
    public void borrarPoblacionEnte (Long cpoCodigo) throws ExcepcionDAO;
    public List<PoblacionEnteVO> buscarTodoPoblacionEnte () throws ExcepcionDAO;
    public List<PoblacionEnteVO> buscarPoblacionEntePorIdEnteTerritorial (Long etiCodigo) throws ExcepcionDAO;
    public List<PoblacionEnteVO> buscarPoblacionEntePorIdEnteTerritorial (Long etiCodigo, boolean soloVigentes) throws ExcepcionDAO;
}
