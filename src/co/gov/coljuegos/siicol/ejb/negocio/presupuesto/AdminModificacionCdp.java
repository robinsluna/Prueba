package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;


public interface AdminModificacionCdp {
    public ModificacionCdpVO buscarUltimaModificacionCdp(Long idCdp) throws ExcepcionDAO;

    public List<ModificacionCdpVO> decrementosTramitados() throws ExcepcionDAO;

    public List<ModificacionCdpVO> incrementosTramitados() throws ExcepcionDAO;

    public List<ModificacionCdpVO> buscarModificacionesCdpPorCdp(Long id) throws ExcepcionDAO;

    public List<ModificacionCdpVO> buscarDecrementosCdpEnTramite() throws ExcepcionDAO; // Excluye a los INCREMENTADO DECREMENTADO Y RECHAZADO

    public ModificacionCdpVO guardarDecrementoCdp(ModificacionCdpVO decrementoCdpVo, UsuarioVO usuarioLogueado,
                                                  boolean cambioEstado) throws ExcepcionDAO, ExcepcionAplicacion;

    public ModificacionCdpVO guardarIncrementoCdp(ModificacionCdpVO incrementoCdpVo, UsuarioVO usuarioLogueado,
                                                  boolean cambioEstado) throws ExcepcionDAO, ExcepcionAplicacion;

    public List<ModificacionCdpVO> buscarIncrementosCdpEnTramite() throws ExcepcionDAO;

    public ModificacionCdpVO actualizarModifiacionCdp(ModificacionCdpVO modificacionCdpVo) throws ExcepcionDAO;
    
    public List<ModificacionCdpVO> incrementosExistentes() throws ExcepcionDAO;
    
    public List<ModificacionCdpVO> decrementosExistentes() throws ExcepcionDAO;

}
