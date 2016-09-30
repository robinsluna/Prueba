package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionRpVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;


public interface AdminModificacionRp {
    public ModificacionRpVO buscarUltimaModificacionRp(Long rpCodigo) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param decrementoRpVo
     * @param usuarioLogueado
     * @param cambioEstado
     * @return
     * @throws ExcepcionDAO
     */
    public ModificacionRpVO guardarDecrementoRp(ModificacionRpVO decrementoRpVo, UsuarioVO usuarioLogueado,
                                                boolean cambioEstado) throws ExcepcionDAO, ExcepcionAplicacion;

    public ModificacionRpVO guardarIncrementoRp(ModificacionRpVO incrementoRpVo, UsuarioVO usuarioLogueado,
                                                boolean cambioEstado) throws ExcepcionDAO, ExcepcionAplicacion;

    public List<ModificacionRpVO> decrementosTramitados() throws ExcepcionDAO;

    public List<ModificacionRpVO> incrementosTramitados() throws ExcepcionDAO;

}
