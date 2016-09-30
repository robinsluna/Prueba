package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.OtroSiVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminOtroSi {
    public OtroSiVO guardarOtroSi(OtroSiVO otroSiVo, UsuarioVO usuarioLogin, boolean cambioEstado, SolicitudAutorizaVO solicitudAutorizaVo) throws ExcepcionDAO,ExcepcionAplicacion ;
    
    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<OtroSiVO> otrosiPerfeccionadosSinPolizasPendientes() throws ExcepcionDAO;
    
    /**
     * @author Giovanni
     * @param idOtrosi
     * @return
     */
    public OtroSiVO buscarOtrosiPolizaConcesion(Long idOtrosi) throws ExcepcionDAO;
    
    public List<OtroSiVO> buscarOtroSiPorIdContrato(Long conCodigo) throws ExcepcionDAO;
}
