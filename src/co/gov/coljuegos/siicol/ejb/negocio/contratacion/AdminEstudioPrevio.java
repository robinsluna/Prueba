package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AmparoEstPrevVO;
import co.gov.coljuegos.siicol.ejb.vo.EstPrevDetRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.EstudioPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.ReqEstudioPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroEstudioPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleIPCVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudDetalleRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstudioPrevio {
    public EstudioPrevioVO insertarEstudioPrevio(EstudioPrevioVO estudioPrevioVo) throws ExcepcionDAO;

    public EstudioPrevioVO buscarEstudioPrevioPorId(EstudioPrevioVO estudioPrevioVo) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param estudioPrevioVo
     * @param listaAgregarReqEstudioPrevioVo
     * @param listaEliminarReqEstudioPrevioVo
     * @param listaAgregarAmparoEstPrevVo
     * @param listaEliminarAmparoEstPrevVo
     * @param listaInicialEstPrevDetRubroVo
     * @param listaFinalEstPrevDetRubroVo
     * @param listaActualizarEstPrevDetRubroVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public EstudioPrevioVO actualizarEstudioPrevio(EstudioPrevioVO estudioPrevioVo,
                                                   List<ReqEstudioPrevioVO> listaAgregarReqEstudioPrevioVo,
                                                   List<ReqEstudioPrevioVO> listaEliminarReqEstudioPrevioVo,
                                                   List<AmparoEstPrevVO> listaAgregarAmparoEstPrevVo,
                                                   List<AmparoEstPrevVO> listaEliminarAmparoEstPrevVo,
                                                   List<EstPrevDetRubroVO> listaInicialEstPrevDetRubroVo,
                                                   List<EstPrevDetRubroVO> listaFinalEstPrevDetRubroVo,
                                                   List<EstPrevDetRubroVO> listaActualizarEstPrevDetRubroVo,
                                                   UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion;

    public List<EstudioPrevioVO> buscarTodoEstudioPrevio() throws ExcepcionDAO;

    public List<RubroFuenteDetalleIPCVO> buscarRubroFuenteDetallePorItemPlanContratac(Long idItemPlanContratac) throws ExcepcionDAO;

    public EstudioPrevioVO buscarEstudioPrevioPorCodigoProcesoContratacion(Integer idProcesoContratacion) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param estudioPrevioVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     */
    public EstudioPrevioVO actualizarEstadoEstudioPrevio(EstudioPrevioVO estudioPrevioVo,
                                                         UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                           ExcepcionAplicacion;

    public List<RubroEstudioPrevioVO> buscarRubroPorInterno(Long idInterno) throws ExcepcionDAO;

    public List<RubroFuenteDetalleIPCVO> consultarRubroFuenteDetallePorIpcIDEstudioPrevio(Long idIpc,
                                                                                          Long IdEstudioPrevio) throws ExcepcionDAO;

    public List<EstudioPrevioVO> buscarEstudioPrevioPorCodigoPContratacion(Long idPc) throws ExcepcionDAO;
    
    public List<SolicitudDetalleRubroCdpVO> calcularSaldoModificacionPresupuesto(Long idItemPlanContratacion,
                                                                     Long idVigencia) throws ExcepcionDAO; 
}

