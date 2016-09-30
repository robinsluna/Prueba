package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AmparoEstPrevDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstPrevDetRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstudioPrevioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReqEstudioPrevioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoGarantiaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoEstPrev;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstPrevDetRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioPrevio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqEstudioPrevio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoGarantia;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AmparoEstPrevVO;
import co.gov.coljuegos.siicol.ejb.vo.AreaColjuegosVO;
import co.gov.coljuegos.siicol.ejb.vo.EstPrevDetRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.EstudioPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ReqEstudioPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroEstudioPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleIPCVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudDetalleRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstudioPrevioBean implements AdminEstudioPrevio {

    @EJB
    private EstudioPrevioDAO estudioPrevioDAO;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private EstPrevDetRubroDAO estPrevDetRubroDao;
    @EJB
    private ReqEstudioPrevioDAO reqEstudioPrevioDao;
    @EJB
    private AmparoEstPrevDAO amparoEstPrevDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private TipoGarantiaDAO tipoGarantiaDao;

    public AdminEstudioPrevioBean() {
    }

    public EstudioPrevioVO insertarEstudioPrevio(EstudioPrevioVO estudioPrevioVo) throws ExcepcionDAO {
        SiiEstudioPrevio siiEstudioPrevio = conversionVoEntidad.convertir(estudioPrevioVo);
        SiiEstudioPrevio siiEstudioPrevioRetorno = estudioPrevioDAO.insertarEstudioPrevio(siiEstudioPrevio);
        List<ReqEstudioPrevioVO> listaReqEstudioPrevioVo = estudioPrevioVo.getReqEstudioPrevioListVo();
        if (listaReqEstudioPrevioVo != null) {
            for (ReqEstudioPrevioVO unReqEstudioPrevioVo : listaReqEstudioPrevioVo) {
                SiiReqEstudioPrevio nuevoReqEstudioPrevio = conversionVoEntidad.convertir(unReqEstudioPrevioVo);
                nuevoReqEstudioPrevio.setSiiEstudioPrevio1(siiEstudioPrevioRetorno);
                reqEstudioPrevioDao.insertarReqEstudioPrevio(nuevoReqEstudioPrevio);
            }
        }
        List<EstPrevDetRubroVO> listaEstPrevDetRubroVo = estudioPrevioVo.getEstPrevDetRubroListVo();
        if (listaEstPrevDetRubroVo != null) {
            for (EstPrevDetRubroVO unEstPrevDetRubroVo : listaEstPrevDetRubroVo) {
                SiiEstPrevDetRubro nuevoEstPrevDetRubro = conversionVoEntidad.convertir(unEstPrevDetRubroVo);
                nuevoEstPrevDetRubro.setSiiEstudioPrevio2(siiEstudioPrevioRetorno);
                estPrevDetRubroDao.insertarEstPrevDetRubro(nuevoEstPrevDetRubro);
            }
        }

        List<AmparoEstPrevVO> listaAmparoEstPrevVo = estudioPrevioVo.getAmparoEstPrevListVo();
        if (listaAmparoEstPrevVo != null) {
            for (AmparoEstPrevVO unAmparoEstPrev : listaAmparoEstPrevVo) {
                SiiAmparoEstPrev nuevoAmparoEstPrev = conversionVoEntidad.convertir(unAmparoEstPrev);
                nuevoAmparoEstPrev.setSiiEstudioPrevio(siiEstudioPrevioRetorno);
                amparoEstPrevDao.insertarAmparoEstPrev(nuevoAmparoEstPrev);
            }
        }

        return new EstudioPrevioVO(siiEstudioPrevioRetorno);
    }

    /**
     * @author Modifica Giovanni
     * @param estudioPrevioVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     */
    public EstudioPrevioVO actualizarEstadoEstudioPrevio(EstudioPrevioVO estudioPrevioVo,
                                                         UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                           ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        SiiEstudioPrevio siiEstudioPrevioTemp = new SiiEstudioPrevio();
        siiEstudioPrevioTemp = estudioPrevioDAO.buscarEstudioPrevioPorId(estudioPrevioVo.getEpeCodigo());
        if (siiEstudioPrevioTemp.getSiiEstadoEstPrev().getEepCodigo() != estudioPrevioVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del estudio previo fue cambiado durante la modificación. Seleccione nuevamente el estudio previo");
        }

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (estudioPrevioVo.getEstadoEstPrevVo().getEepCodigo() != estudioPrevioVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ESTUDIOS_PREVIOS.getId(),
                                                         estudioPrevioVo.getEstadoEstPrevVo().getEepCodigo(),
                                                         usuarioLogueado, estudioPrevioVo.getEpeCodigo());
        }

        SiiEstudioPrevio siiEstudioPrevio = conversionVoEntidad.convertir(estudioPrevioVo);
        SiiEstudioPrevio siiEstudioPrevioRetorno = estudioPrevioDAO.actualizarEstudioPrevio(siiEstudioPrevio);
        return new EstudioPrevioVO(siiEstudioPrevioRetorno);
    }

    public EstudioPrevioVO buscarEstudioPrevioPorId(EstudioPrevioVO estudioPrevioVo) throws ExcepcionDAO {
        SiiEstudioPrevio unEstudioPrevio = estudioPrevioDAO.buscarEstudioPrevioPorId(estudioPrevioVo.getEpeCodigo());
        return new EstudioPrevioVO(unEstudioPrevio);
    }


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
                                                   UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        SiiEstudioPrevio siiEstudioPrevioTemp = new SiiEstudioPrevio();
        siiEstudioPrevioTemp = estudioPrevioDAO.buscarEstudioPrevioPorId(estudioPrevioVo.getEpeCodigo());
        if (siiEstudioPrevioTemp.getSiiEstadoEstPrev().getEepCodigo() != estudioPrevioVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del estudio previo fue cambiado durante la modificación. Seleccione nuevamente el estudio previo");
        }

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (estudioPrevioVo.getEstadoEstPrevVo().getEepCodigo() != estudioPrevioVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ESTUDIOS_PREVIOS.getId(),
                                                         estudioPrevioVo.getEstadoEstPrevVo().getEepCodigo(),
                                                         usuarioLogueado, estudioPrevioVo.getEpeCodigo());
        }

        SiiEstudioPrevio siiEstudioPrevio = conversionVoEntidad.convertir(estudioPrevioVo);
        siiEstudioPrevio = estudioPrevioDAO.actualizarEstudioPrevio(siiEstudioPrevio);
        if (listaAgregarReqEstudioPrevioVo != null) {
            for (ReqEstudioPrevioVO reqEstudioPrevioVo : listaAgregarReqEstudioPrevioVo) {
                SiiReqEstudioPrevio nuevoReqEstudioPrevio = conversionVoEntidad.convertir(reqEstudioPrevioVo);
                if (nuevoReqEstudioPrevio.getResCodigo() == null) {
                    nuevoReqEstudioPrevio.setResPuntaje(nuevoReqEstudioPrevio.getResPuntaje());
                    nuevoReqEstudioPrevio.setSiiEstudioPrevio1(nuevoReqEstudioPrevio.getSiiEstudioPrevio1());
                    nuevoReqEstudioPrevio.setSiiRequisitoCrit(nuevoReqEstudioPrevio.getSiiRequisitoCrit());
                    reqEstudioPrevioDao.insertarReqEstudioPrevio(nuevoReqEstudioPrevio);
                }
            }

            if (listaEliminarReqEstudioPrevioVo != null) {
                for (ReqEstudioPrevioVO reqEstudioPrevioVo : listaEliminarReqEstudioPrevioVo) {
                    SiiReqEstudioPrevio nuevoReqEstudioPrevio = conversionVoEntidad.convertir(reqEstudioPrevioVo);
                    if (nuevoReqEstudioPrevio.getResCodigo() != null) {
                        reqEstudioPrevioDao.eliminarReqEstudioPrevio(nuevoReqEstudioPrevio.getResCodigo());
                    }
                }
            }

            if (listaAgregarAmparoEstPrevVo != null) {
                for (AmparoEstPrevVO amparoEstPrevVo : listaAgregarAmparoEstPrevVo) {
                    SiiAmparoEstPrev nuevoAmparoEstPrev = new SiiAmparoEstPrev();
                    nuevoAmparoEstPrev = conversionVoEntidad.convertir(amparoEstPrevVo);
                    if (nuevoAmparoEstPrev.getAepCodigo() == null) {
                        nuevoAmparoEstPrev.setAepJustificacion(nuevoAmparoEstPrev.getAepJustificacion());
                        nuevoAmparoEstPrev.setAepPorcentaje(nuevoAmparoEstPrev.getAepPorcentaje());
                        nuevoAmparoEstPrev.setAepVigencia(nuevoAmparoEstPrev.getAepVigencia());
                        nuevoAmparoEstPrev.setSiiEstudioPrevio(siiEstudioPrevio);
                        nuevoAmparoEstPrev.setSiiTipoAmparo(nuevoAmparoEstPrev.getSiiTipoAmparo());

                        //Tipo Garantia
                        SiiTipoGarantia siiTipoGarantia = tipoGarantiaDao.buscarTipoGarantiaPorId(amparoEstPrevVo.getTipoGarantiaVO().getTgaCodigo());
                        nuevoAmparoEstPrev.setSiiTipoGarantia(siiTipoGarantia);
                        amparoEstPrevDao.insertarAmparoEstPrev(nuevoAmparoEstPrev);
                    }
                }
            }

            if (listaEliminarAmparoEstPrevVo != null) {
                for (AmparoEstPrevVO amparoEstPrevVo : listaEliminarAmparoEstPrevVo) {
                    SiiAmparoEstPrev nuevoAmparoEstPrev = conversionVoEntidad.convertir(amparoEstPrevVo);
                    if (nuevoAmparoEstPrev.getAepCodigo() != null) {
                        amparoEstPrevDao.eliminarAmparoEstPrev(nuevoAmparoEstPrev.getAepCodigo());
                    }
                }
            }

        }

        if (listaInicialEstPrevDetRubroVo == null) {
            for (EstPrevDetRubroVO estPrevDetRubroVo : listaActualizarEstPrevDetRubroVo) {
                SiiEstPrevDetRubro nuevoEstPrevDetRubro = conversionVoEntidad.convertir(estPrevDetRubroVo);
                nuevoEstPrevDetRubro.setEpdCodigo(nuevoEstPrevDetRubro.getEpdCodigo());
                nuevoEstPrevDetRubro.setSiiEstudioPrevio2(siiEstudioPrevio);
                nuevoEstPrevDetRubro.setEpdValor(estPrevDetRubroVo.getEpdValor());
                nuevoEstPrevDetRubro.setSiiDetalleRubro(nuevoEstPrevDetRubro.getSiiDetalleRubro());
                if (nuevoEstPrevDetRubro.getEpdValor() != null) {
                    estPrevDetRubroDao.actualizarEstPrevDetRubro(nuevoEstPrevDetRubro);
                }
            }
        } else {
            for (EstPrevDetRubroVO estPrevDetRubroVo : listaInicialEstPrevDetRubroVo) {
                SiiEstPrevDetRubro nuevoEstPrevDetRubro = conversionVoEntidad.convertir(estPrevDetRubroVo);
                estPrevDetRubroDao.eliminarEstPrevDetRubro(nuevoEstPrevDetRubro.getEpdCodigo());
            }
        }

        if (listaFinalEstPrevDetRubroVo != null) {
            for (EstPrevDetRubroVO estPrevDetRubroVo : listaFinalEstPrevDetRubroVo) {
                SiiEstPrevDetRubro nuevoEstPrevDetRubro = conversionVoEntidad.convertir(estPrevDetRubroVo);
                nuevoEstPrevDetRubro.setSiiEstudioPrevio2(siiEstudioPrevio);
                if (nuevoEstPrevDetRubro.getEpdValor() != null) {
                    estPrevDetRubroDao.insertarEstPrevDetRubro(nuevoEstPrevDetRubro);
                }
            }
        }
        return estudioPrevioVo;
    }

    public List<EstudioPrevioVO> buscarTodoEstudioPrevio() throws ExcepcionDAO {
        List<SiiEstudioPrevio> listaEstudioPrevio = estudioPrevioDAO.buscarTodosEstudioPrevio();
        List<EstudioPrevioVO> listaEstudioPrevioVo = new ArrayList();
        for (SiiEstudioPrevio unEstudioPrevio : listaEstudioPrevio) {
            EstudioPrevioVO nuevoEstudioPrevioVo = new EstudioPrevioVO(unEstudioPrevio);
            listaEstudioPrevioVo.add(nuevoEstudioPrevioVo);
        }
        return listaEstudioPrevioVo;
    }

    public List<RubroFuenteDetalleIPCVO> buscarRubroFuenteDetallePorItemPlanContratac(Long idItemPlanContratac) throws ExcepcionDAO {
        return estudioPrevioDAO.buscarRubroFuenteDetallePorItemPlanContratac(idItemPlanContratac);
    }

    public EstudioPrevioVO buscarEstudioPrevioPorCodigoProcesoContratacion(Integer idProcesoContratacion) throws ExcepcionDAO {
        SiiEstudioPrevio siiEstudioPrevio = null;
        siiEstudioPrevio = estudioPrevioDAO.buscarEstudioPrevioPorCodigoProcesoContratacion(idProcesoContratacion);
        EstudioPrevioVO estPredioVo = null;
        if (siiEstudioPrevio != null) {
            estPredioVo = new EstudioPrevioVO(siiEstudioPrevio);

            List<SolicitudEstMercadoVO> listSolEstMer = new ArrayList<SolicitudEstMercadoVO>();

            if (siiEstudioPrevio.getSiiProcesoContratacion() != null) {
                ProcesoContratacionVO procVo = new ProcesoContratacionVO(siiEstudioPrevio.getSiiProcesoContratacion());
                if (siiEstudioPrevio.getSiiProcesoContratacion().getSiiSolicitudEstMercadoList() != null) {
                    for (SiiSolicitudEstMercado siiSolEstMer :
                         siiEstudioPrevio.getSiiProcesoContratacion().getSiiSolicitudEstMercadoList()) {
                        SolicitudEstMercadoVO solEstMerVo = new SolicitudEstMercadoVO();
                        SiiAreaColjuegos siiArea = siiSolEstMer.getSiiAreaColjuegos();
                        AreaColjuegosVO areaVo = new AreaColjuegosVO(siiArea);
                        solEstMerVo.setAreaColjuegosVo(areaVo);
                        listSolEstMer.add(solEstMerVo);
                    }
                }
                procVo.setSolicitudEstMercadoListVo(listSolEstMer);
                estPredioVo.setProcesoContratacionVo(procVo);
            }
        }
        return estPredioVo;
    }

    public List<RubroEstudioPrevioVO> buscarRubroPorInterno(Long idInterno) throws ExcepcionDAO {
        return estudioPrevioDAO.buscarRubroPorInterno(idInterno);
    }

    public List<RubroFuenteDetalleIPCVO> consultarRubroFuenteDetallePorIpcIDEstudioPrevio(Long idIpc,
                                                                                          Long IdEstudioPrevio) throws ExcepcionDAO {
        return estudioPrevioDAO.consultarRubroFuenteDetallePorIpcIDEstudioPrevio(idIpc, IdEstudioPrevio);
    }

    public List<EstudioPrevioVO> buscarEstudioPrevioPorCodigoPContratacion(Long idPc) throws ExcepcionDAO {
        List<SiiEstudioPrevio> listaEstudioPrevio = estudioPrevioDAO.buscarEstudioPrevioPorCodigoPContratacion(idPc);
        List<EstudioPrevioVO> listaEstudioPrevioVo = new ArrayList();
        for (SiiEstudioPrevio unEstudioPrevio : listaEstudioPrevio) {
            EstudioPrevioVO nuevoEstudioPrevioVo = new EstudioPrevioVO(unEstudioPrevio);
            listaEstudioPrevioVo.add(nuevoEstudioPrevioVo);
        }
        return listaEstudioPrevioVo;
    }
    
    public List<SolicitudDetalleRubroCdpVO> calcularSaldoModificacionPresupuesto(Long idItemPlanContratacion,
                                                                     Long idVigencia) throws ExcepcionDAO {
        return estudioPrevioDAO.calcularSaldoModificacionPresupuesto(idItemPlanContratacion, idVigencia);                                                                 
    }
}


