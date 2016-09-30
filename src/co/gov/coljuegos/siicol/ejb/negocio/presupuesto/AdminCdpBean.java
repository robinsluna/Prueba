package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifCdpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifRpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OblConcRpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrRubroPK;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifCdpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifRpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CadenaPresupuestalPDFVO;
import co.gov.coljuegos.siicol.ejb.vo.CadenaPresupuestalRpVO;
import co.gov.coljuegos.siicol.ejb.vo.CadenaPresupuestalRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.CadenaPresupuestalVO;
import co.gov.coljuegos.siicol.ejb.vo.CdpVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.PrRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudDetalleRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminCdpBean implements AdminCdp {
    @Resource
    SessionContext sessionContext;

    @EJB
    private CdpDAO cdpDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private DetalleRubroCdpDAO detalleRubroCdpDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private RubroDAO rubroDAO;
    @EJB
    private ModifCdpDetRubCdpDAO modifCdpDetRubCdpDAO;
    @EJB
    private RpDetRubroCdpDAO rpDetRubroCdpDAO;
    @EJB
    private ModifRpDetRubCdpDAO modifRpDetRubCdpDAO;
    @EJB
    private OblConcRpDetRubCdpDAO oblConcRpDetRubCdpDAO;
 
    public AdminCdpBean() {
    }

    public CdpVO buscarCdpPorId(Long idCodigoCdp) throws ExcepcionDAO {
        SiiCdp cdp = cdpDao.buscarCdpPorId(idCodigoCdp);
        return new CdpVO(cdp);
    }

    public CdpVO insertarCdp(CdpVO cdpVO) throws ExcepcionDAO {

        SiiCdp siiCdp = conversionVoEntidad.convertir(cdpVO);
        SiiCdp unCdp = cdpDao.insertarCdp(siiCdp);
        List<DetalleRubroCdpVO> listaDetalleRubroCdpVO = cdpVO.getDetalleRubroCdpListVO();

        for (DetalleRubroCdpVO unDetalleRubroCdpVO : listaDetalleRubroCdpVO) {
            SiiDetalleRubroCdp nuevoDetalleRubroCdp = conversionVoEntidad.convertir(unDetalleRubroCdpVO);
            nuevoDetalleRubroCdp.setSiiCdp(unCdp);
            detalleRubroCdpDao.insertarSiiDetalleRubroCdp(nuevoDetalleRubroCdp);
        }
        return new CdpVO(unCdp);
    }

    /**
     * @author Modifica Giovanni
     * @param cdpVO
     * @param listaInicialDetalleRubroCdpVo
     * @param listaFinalDetalleRubroCdpVo
     * @param listaActualizarDetalleRubroCdpVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public CdpVO actualizarCdp(CdpVO cdpVO, List<DetalleRubroCdpVO> listaInicialDetalleRubroCdpVo,
                               List<DetalleRubroCdpVO> listaFinalDetalleRubroCdpVo,
                               List<DetalleRubroCdpVO> listaActualizarDetalleRubroCdpVo,
                               UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {


        /*
         * Manejo de error de concurrencia
         */
        /*SiiCdp siiCdp = new SiiCdp();
        siiCdp = cdpDao.buscarCdpPorId(cdpVO.getCdpCodigo());
        if (siiCdp.getSiiEstadoCdp().getEcdCodigo() != cdpVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del cdp al actualizar fue cambiado durante la modificación. Seleccione nuevamente el cdp");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (cdpVO.getEstadoCdpVO().getEcdCodigo() != cdpVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CDP.getId(),
                                                         cdpVO.getEstadoCdpVO().getEcdCodigo(), usuarioLogueado,
                                                         cdpVO.getCdpCodigo());
        }

        SiiCdp cdp = cdpDao.actualizarCdp(conversionVoEntidad.convertir(cdpVO));

        if (listaInicialDetalleRubroCdpVo.size() > 0) {
            for (DetalleRubroCdpVO miDetalleRubroCdpVO : listaInicialDetalleRubroCdpVo) {
                SiiDetalleRubroCdp nuevoDetalleRubroCdp = conversionVoEntidad.convertir(miDetalleRubroCdpVO);
                detalleRubroCdpDao.borrarPorCodigoDetalleRubro(nuevoDetalleRubroCdp.getDrcCodigo());
            }
        } else {
            for (DetalleRubroCdpVO elDetalleRubroCdpVO : listaActualizarDetalleRubroCdpVo) {
                SiiDetalleRubroCdp nuevoDetalleRubroCdp = conversionVoEntidad.convertir(elDetalleRubroCdpVO);
                nuevoDetalleRubroCdp.setSiiCdp(cdp);
                nuevoDetalleRubroCdp.setDrcCodigo(elDetalleRubroCdpVO.getDrcCodigo());
                //nuevoDetalleRubroCdp.setDruValor(druValor);
                detalleRubroCdpDao.actualizarSiiDetalleRubroCdp(nuevoDetalleRubroCdp);
            }
        }

        if (listaFinalDetalleRubroCdpVo != null) {
            for (DetalleRubroCdpVO unDetalleRubroCdpVO : listaFinalDetalleRubroCdpVo) {
                unDetalleRubroCdpVO.setDrcCodigo(null);
                SiiDetalleRubroCdp nuevoDetalleRubroCdp = conversionVoEntidad.convertir(unDetalleRubroCdpVO);
                if (nuevoDetalleRubroCdp != null) {
                    nuevoDetalleRubroCdp.setSiiCdp(cdp);
                    detalleRubroCdpDao.insertarSiiDetalleRubroCdp(nuevoDetalleRubroCdp);
                }
            }

        } /*
        if (listaInicialDetalleRubroCdpVo.size() == 0) {
            for (DetalleRubroCdpVO unDetalleRubroCdpVO : listaActualizarDetalleRubroCdpVo) {
                SiiDetalleRubroCdp nuevoDetalleRubroCdp = conversionVoEntidad.convertir(unDetalleRubroCdpVO);
                nuevoDetalleRubroCdp.setSiiCdp(cdp);
                nuevoDetalleRubroCdp.setDrcCodigo(unDetalleRubroCdpVO.getDrcCodigo());
                //nuevoDetalleRubroCdp.setDruValor(druValor);
                detalleRubroCdpDao.actualizarSiiDetalleRubroCdp(nuevoDetalleRubroCdp);
            }

        } else {
            for (DetalleRubroCdpVO unDetalleRubroCdpVO : listaInicialDetalleRubroCdpVo) {
                SiiDetalleRubroCdp nuevoDetalleRubroCdp = conversionVoEntidad.convertir(unDetalleRubroCdpVO);
                detalleRubroCdpDao.borrarPorCodigoDetalleRubro(nuevoDetalleRubroCdp.getDrcCodigo());
            }

        }

        if (listaFinalDetalleRubroCdpVo != null) {
            for (DetalleRubroCdpVO unDetalleRubroCdpVO : listaFinalDetalleRubroCdpVo) {
                SiiDetalleRubroCdp nuevoDetalleRubroCdp = conversionVoEntidad.convertir(unDetalleRubroCdpVO);
                nuevoDetalleRubroCdp.setSiiCdp(cdp);
                detalleRubroCdpDao.insertarSiiDetalleRubroCdp(nuevoDetalleRubroCdp);
            }

        }
        */
        return new CdpVO(cdp);
    }

    /**
     * @author Modifica Giovanni
     * @param cdpVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public CdpVO actualizarEstadoCdp(CdpVO cdpVO, UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiCdp siiCdp = new SiiCdp();
        siiCdp = cdpDao.buscarCdpPorId(cdpVO.getCdpCodigo());
        if (siiCdp.getSiiEstadoCdp().getEcdCodigo() != cdpVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del cdp fue cambiado durante la modificación. Seleccione nuevamente el cdp");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (cdpVO.getEstadoCdpVO().getEcdCodigo() != cdpVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CDP.getId(),
                                                         cdpVO.getEstadoCdpVO().getEcdCodigo(), usuarioLogueado,
                                                         cdpVO.getCdpCodigo());
        }

        SiiCdp cdp = cdpDao.actualizarCdp(conversionVoEntidad.convertir(cdpVO));
        return new CdpVO(cdp);
    }

    public List<CdpVO> buscarTodoCdp() throws ExcepcionDAO {
        List<SiiCdp> listaCdp = cdpDao.buscarTodoCdp();
        List<CdpVO> listaCdpVO = new ArrayList();
        for (SiiCdp unCdp : listaCdp) {
            listaCdpVO.add(new CdpVO(unCdp));
        }
        return listaCdpVO;
    }

    public List<CdpVO> buscarCdpPorEstado(String estado) throws ExcepcionDAO {
        return convertirListaSiiCdpEnVo(cdpDao.buscarCdpPorEstado(estado));
    }

    private List<CdpVO> convertirListaSiiCdpEnVo(List<SiiCdp> listaCdp) {
        List<CdpVO> listaCdpVO = new ArrayList();
        for (SiiCdp unCdp : listaCdp) {
            listaCdpVO.add(new CdpVO(unCdp));
        }
        return listaCdpVO;
    }
    
    public List<CdpVO> buscarCdpsAprobadosSinIncrementosEnTramite() throws ExcepcionDAO {
        return convertirListaSiiCdpEnVo(cdpDao.buscarCdpsAprobadosSinIncrementosEnTramite());
    }

    public List<CdpVO> buscarCdpsAprobadosSinDecrementosEnTramite() throws ExcepcionDAO {
        return convertirListaSiiCdpEnVo(cdpDao.buscarCdpsAprobadosSinDecrementosEnTramite());
    }

    public List<SolicitudDetalleRubroCdpVO> buscarDetalleRubroCdpPorItemPlanContratIdCdp(Long idIpc,
                                                                                         Long idCdp) throws ExcepcionDAO {
        return cdpDao.buscarDetalleRubroCdpPorItemPlanContratIdCdp(idIpc, idCdp);
    }

    public List<SolicitudDetalleRubroCdpVO> buscarDetalleRubroCdpPorItemPlanContratIdCdpParaRecursosPropios(Long idIpc,
                                                                                                            Long idCdp) throws ExcepcionDAO {
        return cdpDao.buscarDetalleRubroCdpPorItemPlanContratIdCdpParaRecursosPropios(idIpc, idCdp);
    }

    public Long consultarConsecutivoCdp() throws ExcepcionDAO {
        return cdpDao.consultarConsecutivoCdp();
    }


    public List<CdpVO> buscarCdpExpedidos() throws ExcepcionDAO {
        List<SiiCdp> listaCdp = cdpDao.buscarCdpExpedidos();
        List<CdpVO> listaCdpVO = new ArrayList();
        for (SiiCdp unCdp : listaCdp) {
            listaCdpVO.add(new CdpVO(unCdp));
        }
        return listaCdpVO;
    }

    public List<CdpVO> buscarCdpSolicitados() throws ExcepcionDAO {
        List<SiiCdp> listaCdpSolicitados = cdpDao.buscarCdpSolicitados();
        List<CdpVO> listaCdpSolicitadosVO = new ArrayList();
        for (SiiCdp unCdp : listaCdpSolicitados) {
            listaCdpSolicitadosVO.add(new CdpVO(unCdp));
        }
        return listaCdpSolicitadosVO;
    }

    public List<SolicitudDetalleRubroCdpVO> calcularSaldoApropiacion(Long idItemPlanContratacion,
                                                                     Long idVigencia) throws ExcepcionDAO {
        List<SolicitudDetalleRubroCdpVO> listaSolicitudDetalleRubroCdpVo =
            cdpDao.calcularSaldoApropiacion(idItemPlanContratacion, idVigencia);
        return listaSolicitudDetalleRubroCdpVo;
    }


    public List<PrRubroVO> buscarDescricionRubroN2N3XCdp(Long idCdp) throws ExcepcionDAO {
        return cdpDao.buscarDescricionRubroN2N3XCdp(idCdp);
    }

    public BigDecimal valorActualApropiadoPorRubrosCdp(Long cdpCodigo) throws ExcepcionDAO {
        return cdpDao.valorActualApropiadoPorRubrosCdp(cdpCodigo);
    }

    public BigDecimal valorActualComprometidoPorRubrosCdp(Long cdpCodigo) throws ExcepcionDAO {
        return cdpDao.valorActualComprometidoPorRubrosCdp(cdpCodigo);
    }

    public CdpVO buscarCdpPorConsecutivo(Long cdpConsecutivo) throws ExcepcionDAO {
        return new CdpVO(cdpDao.buscarCdpPorConsecutivo(cdpConsecutivo));
    }

    public List<DetalleRubroCdpVO> buscarDetalleRubroCdpPorCdpCodigo(Long cdpCodigo) throws ExcepcionDAO {
        List<DetalleRubroCdpVO> listaDetalleRubroCdpVo = new ArrayList<DetalleRubroCdpVO>();
        List<SiiDetalleRubroCdp> listaDetalleRubroCdp = cdpDao.buscarDetalleRubroCdpPorCdpCodigo(cdpCodigo);
        for (SiiDetalleRubroCdp detalle : listaDetalleRubroCdp) {
            listaDetalleRubroCdpVo.add(new DetalleRubroCdpVO(detalle));
        }
        return listaDetalleRubroCdpVo;

    }

    public BigDecimal valorEjecutadoCdp(Long cdpConsecutivo) throws ExcepcionDAO {
        return cdpDao.valorEjecutadoCdp(cdpConsecutivo);
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<CadenaPresupuestalVO> reporteCadenaPresupuestal(Date fechaInicial, Date fechaFinal) throws ExcepcionDAO {
        List<CadenaPresupuestalVO> cadenaPresupuestalVOs = new ArrayList<CadenaPresupuestalVO>();

        List<SiiCdp> siiCdps = null;
        siiCdps = cdpDao.buscarCdpsCadenaPresupuestal(fechaInicial, fechaFinal);
        if (siiCdps != null && !siiCdps.isEmpty()) {
            for (SiiCdp siiCdp : siiCdps) {
                CadenaPresupuestalVO cadenaPresupuestalVO = new CadenaPresupuestalVO();

                /*
                 * Valor total cdp
                 */
                List<SiiDetalleRubroCdp> siiDetalleRubroCdps =
                    detalleRubroCdpDao.buscarDetalleRubroCdpPorIdCdpCadenaPresupuestal(siiCdp.getCdpCodigo());

                double valorTotalCdp = 0;
                double valorTotalModificadoCdp = 0;
                cadenaPresupuestalVO.setCADENA_PRESUPUESTAL_RUBRO_VO(new ArrayList<CadenaPresupuestalRubroVO>());
                
                /*
                 * Rubros
                 */

                for (SiiDetalleRubroCdp siiDetalleRubroCdp : siiDetalleRubroCdps) {

                    /*
                     * lllenamos la informacion del los rubros
                     */
                    //Llenamos la informacion de busqueda para el rubro
                    PrRubroPK prRubroPK = new PrRubroPK();
                    prRubroPK.setInterno(siiDetalleRubroCdp.getSiiDetalleRubro().getInterno());
                    prRubroPK.setVigencia(siiDetalleRubroCdp.getSiiDetalleRubro().getVigencia());

                    //Traemos el rubro correspondiente codigo rubro
                    Object[] infoRubro = null;
                    infoRubro = rubroDAO.buscarCodigoRubroXVigenciaXInterno(prRubroPK);

                    if (infoRubro != null) {

                        CadenaPresupuestalRubroVO cadenaPresupuestalRubroVO = new CadenaPresupuestalRubroVO();

                        //uni
                        cadenaPresupuestalRubroVO.setUNI(infoRubro[0].toString());
                        //tip
                        cadenaPresupuestalRubroVO.setTIP(infoRubro[1].toString());
                        //cta
                        cadenaPresupuestalRubroVO.setCTA(infoRubro[2].toString());
                        //scta
                        cadenaPresupuestalRubroVO.setSCTA(infoRubro[3].toString());
                        //obj
                        cadenaPresupuestalRubroVO.setOBJ(infoRubro[4].toString());
                        //ord
                        if (infoRubro[5] != null) {
                            cadenaPresupuestalRubroVO.setORD(infoRubro[5].toString());
                        }
                        //sord
                        if (infoRubro[6] != null) {
                            cadenaPresupuestalRubroVO.setSORD(infoRubro[6].toString());
                        }
                        //Fuente
                        cadenaPresupuestalRubroVO.setFUENTE(new BigDecimal(siiDetalleRubroCdp.getSiiDetalleRubro().getSiiDtlleFuenteFinanciacion().getSiiFuenteFinanciacion().getFfiCodigoFuente()));

                        //Detalle fuente
                        cadenaPresupuestalRubroVO.setDETFUENTE(new BigDecimal(siiDetalleRubroCdp.getSiiDetalleRubro().getSiiDtlleFuenteFinanciacion().getDffCodigoRecurso()));

                        //Numero del cdp
                        cadenaPresupuestalRubroVO.setCDP_CONSECUTIVO(new BigDecimal(siiCdp.getCdpConsecutivo()));

                        //Fecha de expedicion
                        cadenaPresupuestalRubroVO.setCDP_FECHA_EXPEDICION(siiCdp.getCdpFechaExpedicion());

                        //Descripcion rubro
                        cadenaPresupuestalRubroVO.setDESRUBRO(infoRubro[7].toString());

                        //Valor total rubro
                        cadenaPresupuestalRubroVO.setVALOR_RUBRO(siiDetalleRubroCdp.getDruValor());

                        //Valor total modificado rubro cdp
                        List<SiiModifCdpDetRubCdp> siiModifCdpDetRubCdps = null;
                        siiModifCdpDetRubCdps =
                            modifCdpDetRubCdpDAO.listaModifCdpRubPorDetRubCdp(siiDetalleRubroCdp.getDrcCodigo());

                        double sumaIncremento = 0;
                        double sumaDecremento = 0;
                        for (SiiModifCdpDetRubCdp siiModifCdpDetRubCdp : siiModifCdpDetRubCdps) {
                            if (siiModifCdpDetRubCdp.getSiiModificacionCdp().getMcdTipoMod().equals("I")) {
                                sumaIncremento += siiModifCdpDetRubCdp.getMcrValor().doubleValue();
                            } else {
                                sumaDecremento += siiModifCdpDetRubCdp.getMcrValor().doubleValue();
                            }
                        }

                        cadenaPresupuestalRubroVO.setVALOR_TOTAL_MODIFICADO_RUBRO(new BigDecimal(siiDetalleRubroCdp.getDruValor().doubleValue() +
                                                                                                 sumaIncremento -
                                                                                                 sumaDecremento));

                        //Valor total modificado cdp
                        valorTotalModificadoCdp +=
                            cadenaPresupuestalRubroVO.getVALOR_TOTAL_MODIFICADO_RUBRO().doubleValue();

                        /*
                         * *******RP*********
                         */
                        List<SiiRpDetRubroCdp> siiRpDetRubroCdps = null;
                        siiRpDetRubroCdps =
                            rpDetRubroCdpDAO.buscarRpDetRubroCdpPorDetRubCdp(siiDetalleRubroCdp.getDrcCodigo());

                        cadenaPresupuestalRubroVO.setCADENA_PRESUPUESTAL_RP_VOS(new ArrayList<CadenaPresupuestalRpVO>());
                        for (SiiRpDetRubroCdp siiRpDetRubroCdp : siiRpDetRubroCdps) {

                            CadenaPresupuestalRpVO cadenaPresupuestalRpVO = new CadenaPresupuestalRpVO();

                            //No. Rp
                            cadenaPresupuestalRpVO.setRP_CONSECUTIVO(new BigDecimal(siiRpDetRubroCdp.getSiiRp().getRpConsecutivo()));

                            //Fecha de expedicion RP
                            cadenaPresupuestalRpVO.setFECHEXPEDICIONRP(siiRpDetRubroCdp.getSiiRp().getRpFechaSolic());

                            //Valor rubro
                            cadenaPresupuestalRpVO.setVALOR_RUBRO_RP(siiRpDetRubroCdp.getRdrValor());

                            //Objeto gasto
                            if (siiCdp.getCdpObjeto() != null) {
                                cadenaPresupuestalRpVO.setOBJETO_GASTO(siiCdp.getCdpObjeto());
                            }

                            if (siiCdp.getCdpObjetoCont() != null) {
                                cadenaPresupuestalRpVO.setOBJETO_GASTO(siiCdp.getCdpObjetoCont());
                            }

                            if (siiCdp.getSiiProcesoContratacion() != null) {
                                if (siiCdp.getSiiProcesoContratacion().getPrcObjeto() != null) {
                                    cadenaPresupuestalRpVO.setOBJETO_GASTO(siiCdp.getSiiProcesoContratacion().getPrcObjeto());
                                }
                            }

                            //Valor total modificado RP
                            List<SiiModifRpDetRubCdp> siiModifRpDetRubCdps = null;
                            siiModifRpDetRubCdps =
                                modifRpDetRubCdpDAO.listaModifRpDetRubCdpPorRpDetRubroCdp(siiRpDetRubroCdp.getRdrCodigo());

                            double sumaIncrementoRP = 0;
                            double sumaDecrementoRP = 0;
                            for (SiiModifRpDetRubCdp siiModifRpDetRubCdp : siiModifRpDetRubCdps) {
                                if (siiModifRpDetRubCdp.getSiiModificacionRp().getMrpTipoModif().equals("I")) {
                                    sumaIncrementoRP += siiModifRpDetRubCdp.getMrdValor().doubleValue();
                                } else {
                                    sumaDecrementoRP += siiModifRpDetRubCdp.getMrdValor().doubleValue();
                                }
                            }

                            cadenaPresupuestalRpVO.setVALOR_TOTAL_MOD_RUBRO_RP(new BigDecimal(siiRpDetRubroCdp.getRdrValor().doubleValue() +
                                                                                              sumaIncrementoRP -
                                                                                              sumaDecrementoRP));

                            //Valor total obligaciones rubro rp
                            cadenaPresupuestalRpVO.setVALOR_TOTAL_OBLI_RUBRO_RP(oblConcRpDetRubCdpDAO.valorRubroRpEjecutado(siiRpDetRubroCdp.getRdrCodigo()));

                            //valor total por obligar rubor rp
                            cadenaPresupuestalRpVO.setVALOR_TOTAL_X_OBLIGAR_RUBRO_RP(new BigDecimal(cadenaPresupuestalRpVO.getVALOR_TOTAL_MOD_RUBRO_RP().doubleValue() -
                                                                                                    cadenaPresupuestalRpVO.getVALOR_TOTAL_OBLI_RUBRO_RP().doubleValue()));
                            //valor total pago rubro
                            cadenaPresupuestalRpVO.setVALOR_TOTAL_PAGOS_RUBRO_RP(oblConcRpDetRubCdpDAO.valorRubroRpEjecutadoPagos(siiRpDetRubroCdp.getRdrCodigo()));

                            //Valor total por pagar rp
                            cadenaPresupuestalRpVO.setVALOR_TOTAL_POR_PAGAR_RP(new BigDecimal(cadenaPresupuestalRpVO.getVALOR_TOTAL_MOD_RUBRO_RP().doubleValue() -
                                                                                              cadenaPresupuestalRpVO.getVALOR_TOTAL_PAGOS_RUBRO_RP().doubleValue()));

                            cadenaPresupuestalRubroVO.getCADENA_PRESUPUESTAL_RP_VOS().add(cadenaPresupuestalRpVO);
                        }

                        cadenaPresupuestalVO.getCADENA_PRESUPUESTAL_RUBRO_VO().add(cadenaPresupuestalRubroVO);
                    }

                    if (siiDetalleRubroCdp.getDruValor() != null) {
                        valorTotalCdp += siiDetalleRubroCdp.getDruValor().doubleValue();
                    }

                }

                //Valor total modificado cdp
                cadenaPresupuestalVO.setVALOR_TOTAL_MODIFICADO_CDP(new BigDecimal(valorTotalModificadoCdp));

                //Valor total CDP
                cadenaPresupuestalVO.setVALOR_TOTAL_CDP(new BigDecimal(valorTotalCdp));
                cadenaPresupuestalVOs.add(cadenaPresupuestalVO);
            }
        }
        return cadenaPresupuestalVOs;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<CadenaPresupuestalPDFVO> reporteCadenaPresupuestalPDF(Date fechaInicial,
                                                                      Date fechaFinal) throws ExcepcionDAO {
        List<CadenaPresupuestalPDFVO> cadenaPresupuestalPDFVOs = new ArrayList<CadenaPresupuestalPDFVO>();
        List<CadenaPresupuestalVO> cadenaPresupuestalVOs = new ArrayList<CadenaPresupuestalVO>();
        cadenaPresupuestalVOs = reporteCadenaPresupuestal(fechaInicial, fechaFinal);

        //CDPs
        for (CadenaPresupuestalVO cadenaPresupuestalVO : cadenaPresupuestalVOs) {

            //RUBROS
            for (CadenaPresupuestalRubroVO cadenaPresupuestalRubroVO :
                 cadenaPresupuestalVO.getCADENA_PRESUPUESTAL_RUBRO_VO()) {

                //RPs
                for (CadenaPresupuestalRpVO cadenaPresupuestalRpVO :
                     cadenaPresupuestalRubroVO.getCADENA_PRESUPUESTAL_RP_VOS()) {

                    CadenaPresupuestalPDFVO cadenaPresupuestalPDFVO = new CadenaPresupuestalPDFVO();

                    //Uni
                    cadenaPresupuestalPDFVO.setUNI(cadenaPresupuestalRubroVO.getUNI());
                    //Tip
                    cadenaPresupuestalPDFVO.setTIP(cadenaPresupuestalRubroVO.getTIP());
                    //Cta
                    cadenaPresupuestalPDFVO.setCTA(cadenaPresupuestalRubroVO.getCTA());
                    //Scta
                    cadenaPresupuestalPDFVO.setSCTA(cadenaPresupuestalRubroVO.getSCTA());
                    //Obj
                    cadenaPresupuestalPDFVO.setOBJ(cadenaPresupuestalRubroVO.getOBJ());
                    //Ord
                    cadenaPresupuestalPDFVO.setORD(cadenaPresupuestalRubroVO.getORD());
                    //Sord
                    cadenaPresupuestalPDFVO.setSORD(cadenaPresupuestalRubroVO.getSORD());
                    //Fue
                    cadenaPresupuestalPDFVO.setFUENTE(cadenaPresupuestalRubroVO.getFUENTE());
                    //Detalle
                    cadenaPresupuestalPDFVO.setDETFUENTE(cadenaPresupuestalRubroVO.getDETFUENTE());
                    //No. CDP
                    cadenaPresupuestalPDFVO.setCDP_CONSECUTIVO(cadenaPresupuestalRubroVO.getCDP_CONSECUTIVO());
                    //FECHA DE EXPEDICIÓN
                    cadenaPresupuestalPDFVO.setCDP_FECHA_EXPEDICION(cadenaPresupuestalRubroVO.getCDP_FECHA_EXPEDICION());
                    //DESCRIPCIÓN RUBRO
                    cadenaPresupuestalPDFVO.setDESRUBRO(cadenaPresupuestalRubroVO.getDESRUBRO());
                    //VALOR TOTAL RUBRO
                    cadenaPresupuestalPDFVO.setVALOR_RUBRO(cadenaPresupuestalRubroVO.getVALOR_RUBRO());
                    //VALOR TOTAL MODIFICADO CDP
                    cadenaPresupuestalPDFVO.setVALOR_TOTAL_MODIFICADO_CDP(cadenaPresupuestalVO.getVALOR_TOTAL_MODIFICADO_CDP());
                    //VALOR TOTAL MODIFICADO CDP
                    cadenaPresupuestalPDFVO.setVALOR_TOTAL_MODIFICADO_RUBRO(cadenaPresupuestalRpVO.getVALOR_TOTAL_MOD_RUBRO_RP());
                    //No. RP
                    cadenaPresupuestalPDFVO.setRP_CONSECUTIVO(cadenaPresupuestalRpVO.getRP_CONSECUTIVO());
                    //FECHA DE EXPEDICIÓN
                    cadenaPresupuestalPDFVO.setFECHEXPEDICIONRP(cadenaPresupuestalRpVO.getFECHEXPEDICIONRP());
                    //VALOR RUBRO RP
                    cadenaPresupuestalPDFVO.setVALOR_RUBRO_RP(cadenaPresupuestalRpVO.getVALOR_RUBRO_RP());
                    //VALOR TOTAL MODIFICADO RP
                    cadenaPresupuestalPDFVO.setVALOR_TOTAL_MOD_RUBRO_RP(cadenaPresupuestalRpVO.getVALOR_TOTAL_MOD_RUBRO_RP());
                    //VALOR TOTAL OBLIGACIONES RUBRO RP
                    cadenaPresupuestalPDFVO.setVALOR_TOTAL_OBLI_RUBRO_RP(cadenaPresupuestalRpVO.getVALOR_TOTAL_OBLI_RUBRO_RP());
                    //VALOR TOTAL POR OBLIGAR RUBRO RP
                    cadenaPresupuestalPDFVO.setVALOR_TOTAL_X_OBLIGAR_RUBRO_RP(cadenaPresupuestalRpVO.getVALOR_TOTAL_X_OBLIGAR_RUBRO_RP());
                    //VALOR TOTAL PAGOS RUBRO RP
                    cadenaPresupuestalPDFVO.setVALOR_TOTAL_PAGOS_RUBRO_RP(cadenaPresupuestalRpVO.getVALOR_TOTAL_PAGOS_RUBRO_RP());
                    //VALOR TOTAL POR PAGAR RP
                    cadenaPresupuestalPDFVO.setVALOR_TOTAL_X_OBLIGAR_RUBRO_RP(cadenaPresupuestalRpVO.getVALOR_TOTAL_X_OBLIGAR_RUBRO_RP());
                    //OBJETO DEL GASTO
                    cadenaPresupuestalPDFVO.setOBJETO_GASTO(cadenaPresupuestalRpVO.getOBJETO_GASTO());

                    cadenaPresupuestalPDFVOs.add(cadenaPresupuestalPDFVO);
                }
            }
        }

        return cadenaPresupuestalPDFVOs;
    }

    public List<CdpVO> buscarCdpsPorItemPlanCont(Long ipcCodigo) throws ExcepcionDAO {
        List<CdpVO> cdpsVo = new ArrayList<CdpVO>();
         for (SiiCdp cdp : cdpDao.buscarCdpsPorItemPlanCont(ipcCodigo)) {
             cdpsVo.add(new CdpVO(cdp));
         }
             
        return cdpsVo;
    }
}
