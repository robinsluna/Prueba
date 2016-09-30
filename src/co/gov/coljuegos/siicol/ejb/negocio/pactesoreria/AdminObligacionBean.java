package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminDetalleContNomina;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OblConcRpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionConceptoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOblConcRpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionConcepto;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetalleContNominaVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.OblConcRpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminObligacionBean implements AdminObligacion {

    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ObligacionDAO obligacionDao;
    @EJB
    ObligacionConceptoDAO obligacionConceptoDao;
    @EJB
    AdminObligacionConcepto adminObligacionConcepto;
    @EJB
    OblConcRpDetRubCdpDAO oblConcRpDetRubCdpDAO;
    @EJB
    AdminDocumentoContable adminDocumentoContable;
    @EJB
    AdminDetalleContNomina adminDetalleContNomina;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;


    ////////////////////////////////////////////////
    // Listas para eliminacion de entidades hijas //
    ////////////////////////////////////////////////
    private List<ObligacionConceptoVO> listaObligacionConceptoEliminar;
    private List<OblConcRpDetRubCdpVO> listaOblConcRpDetRubCdpEliminar;


    public ObligacionVO buscarPorCodigoObligacion(Long idObligacion) throws ExcepcionDAO {
        SiiObligacion siiObligacion = obligacionDao.buscarPorCodigo(idObligacion);
        return (new ObligacionVO(siiObligacion));
    }


    public ObligacionVO insertarObligacion(ObligacionVO obligacionVO) throws ExcepcionDAO, ExcepcionAplicacion {
        ObligacionVO resultado = null;

        // eliminar entidades hijas pendientes por remover
        this.eliminarHijos();


        // persistir la entidad padre
        SiiObligacion siiObligacion = obligacionDao.insertar(conversionVoEntidad.convertir(obligacionVO));
        if (siiObligacion != null) {
            resultado = new ObligacionVO(siiObligacion);
            // establecer los hijos que deben ser persistidos
            resultado.setSiiObligacionConceptoList(obligacionVO.getSiiObligacionConceptoList());
            resultado.setDocumentoContableList(obligacionVO.getDocumentoContableList());
            resultado.setOrdenPagoList(obligacionVO.getOrdenPagoList());
            resultado.setOblConcRpDetRubCdpList(obligacionVO.getOblConcRpDetRubCdpList());
            resultado.setDetalleContNominaList(obligacionVO.getDetalleContNominaList());

            this.persistirHijos(siiObligacion, resultado);
        }

        return (resultado);
    }


    /**
     * Almacena la informaci&oacute;n de los hijos de la Obligaci&oacute;n.
     */
    private void persistirHijos(SiiObligacion siiObligacion, ObligacionVO obligacionVO) throws ExcepcionDAO,
                                                                                               ExcepcionAplicacion {
        this.persistirObligacionConceptos(obligacionVO);
        this.persistirOblConcRpDetRubCdp(siiObligacion, obligacionVO.getOblConcRpDetRubCdpList());
        this.persistirDetallesContNomina(obligacionVO);
        this.persistirDocumentoContable(obligacionVO);
    }


    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de los conceptos asociados a la Obligación.
     * @param siiObligacion - Entidad Obligaci&oacute;n.
     * @param conceptosList - Listado de conceptos.
     * @throws ExcepcionDAO
     */
    private void persistirObligacionConceptos(SiiObligacion siiObligacion,
                                              List<ObligacionConceptoVO> conceptosList) throws ExcepcionDAO {
        if (conceptosList != null) {
            for (ObligacionConceptoVO conceptoVO : conceptosList) {
                SiiObligacionConcepto siiObliConceptov = conversionVoEntidad.convertir(conceptoVO);
                if (siiObliConceptov != null) {
                    siiObliConceptov.setSiiObligacion(siiObligacion);
                    if (siiObliConceptov.getOcoCodigo() == null) {
                        // OPERACION INSERTAR
                        obligacionConceptoDao.insertar(siiObliConceptov);
                    } else {
                        // OPERACION ACTUALIZAR
                        obligacionConceptoDao.actualizar(siiObliConceptov);
                    }
                }
            }
        }
    }


    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de los registros de conceptos RP Detalle Rubro, asociados al Concepto de la Obligación.
     * @param siiObligacion - Entidad Obligaci&oacute;n.
     * @param oblConcRpDetRubCdpList - Listado de OblConcRpDetRubCdpVO.
     * @throws ExcepcionDAO
     */
    private void persistirOblConcRpDetRubCdp(SiiObligacion siiObligacion,
                                             List<OblConcRpDetRubCdpVO> oblConcRpDetRubCdpList) throws ExcepcionDAO {
        if (oblConcRpDetRubCdpList != null) {
            for (OblConcRpDetRubCdpVO oblConcRpDetRubCdpVO : oblConcRpDetRubCdpList) {
                SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp = conversionVoEntidad.convertir(oblConcRpDetRubCdpVO);
                if (siiOblConcRpDetRubCdp != null) {
                    siiOblConcRpDetRubCdp.setSiiObligacion(siiObligacion);
                    if (siiOblConcRpDetRubCdp.getOcrCodigo() == null) {
                        // OPERACION INSERTAR
                        oblConcRpDetRubCdpDAO.insertar(siiOblConcRpDetRubCdp);
                    } else {
                        // OPERACION ACTUALIZAR
                        oblConcRpDetRubCdpDAO.actualizar(siiOblConcRpDetRubCdp);
                    }
                }

            }
        }
    }


    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de los conceptos asociados a la Obligación.
     * @param obligacionVo - Entidad Obligaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirObligacionConceptos(ObligacionVO obligacionVo) throws ExcepcionDAO {
        if (obligacionVo != null && obligacionVo.getSiiObligacionConceptoList() != null) {
            for (ObligacionConceptoVO conceptoVO : obligacionVo.getSiiObligacionConceptoList()) {
                if (conceptoVO != null) {
                    conceptoVO.setObligacionVo(obligacionVo);

                    if (conceptoVO.getOcoCodigo() == null) {
                        // OPERACION INSERTAR
                        adminObligacionConcepto.insertarObligacionConcepto(conceptoVO);
                    } else {
                        // OPERACION ACTUALIZAR
                        adminObligacionConcepto.actualizarObligacionConcepto(conceptoVO);
                    }
                }
            }
        }
    }


    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n del Documento Contable asociado a la Obligación.
     * @param obligacionVo - Entidad Obligaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirDocumentoContable(ObligacionVO obligacionVo) throws ExcepcionDAO, ExcepcionAplicacion {
        if (obligacionVo != null) {
            DocumentoContableVO documentoContableVo = obligacionVo.getDocumentoContable();
            if (documentoContableVo != null) {
                documentoContableVo.setObligacionVo(obligacionVo);

                if (documentoContableVo.getDcoCodigo() == null) {
                    // OPERACION INSERTAR
                    adminDocumentoContable.insertarDocumentoContable(documentoContableVo);
                } else {
                    // OPERACION ACTUALIZAR
                    adminDocumentoContable.actualizarDocumentoContable(documentoContableVo,
                                                                       obligacionVo.getSiiUsuarioReg());
                }
            }
        }
    }


    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de los Detalles de Cargue de N&oacute;mina asociado a la Obligación.
     * @param obligacionVo - Entidad Obligaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirDetallesContNomina(ObligacionVO obligacionVo) throws ExcepcionDAO {
        if (obligacionVo != null && obligacionVo.getDetalleContNominaList() != null &&
            !obligacionVo.getDetalleContNominaList().isEmpty()) {

            for (DetalleContNominaVO detalleContNominaVo : obligacionVo.getDetalleContNominaList()) {
                if (detalleContNominaVo != null) {
                    detalleContNominaVo.setObligacionVo(obligacionVo);

                    if (detalleContNominaVo.getDcmCodigo() == null) {
                        // OPERACION INSERTAR
                        adminDetalleContNomina.insertarDetalleContNomina(detalleContNominaVo);
                    } else {
                        // OPERACION ACTUALIZAR
                        adminDetalleContNomina.actualizarDetalleContNomina(detalleContNominaVo);
                    }
                }
            }
        }
    }


    /**
     * Actualiza un registro de Obligaci&oacute;n.
     * @param obligacionVO
     * @return Obligaci&oacute;n modificada.
     * @throws ExcepcionDAO
     */
    public ObligacionVO actualizarObligacion(ObligacionVO obligacionVO) throws ExcepcionDAO, ExcepcionAplicacion {
        // controlar la concurrencia, para validar que el estado de la Obligacion no haya cambiado
        SiiObligacion siiObligacionActual = obligacionDao.buscarPorCodigo(obligacionVO.getOblCodigo());
        if (siiObligacionActual != null && obligacionVO.getIdEstadoAnterior() != null &&
            siiObligacionActual.getSiiEstadoObligacion() != null &&
            siiObligacionActual.getSiiEstadoObligacion().getEobCodigo() != null &&
            !siiObligacionActual.getSiiEstadoObligacion().getEobCodigo().equals(obligacionVO.getIdEstadoAnterior())) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de la Obligación fue cambiado durante la modificación. Seleccione nuevamente la Obligación.");
        }


        // eliminar entidades hijas pendientes por remover
        this.eliminarHijos();


        SiiObligacion siiObligacion = obligacionDao.actualizar(conversionVoEntidad.convertir(obligacionVO));

        this.persistirHijos(siiObligacion, obligacionVO);


        // manejo del log de cambio de estado
        try {
            if (obligacionVO != null && obligacionVO.getEstadoObligacionVo() != null &&
                obligacionVO.getEstadoObligacionVo().getEobCodigo() != null &&
                !obligacionVO.getEstadoObligacionVo().getEobCodigo().equals(obligacionVO.getIdEstadoAnterior())) {
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.OBLIGACION.getId(),
                                                             obligacionVO.getEstadoObligacionVo().getEobCodigo(),
                                                             obligacionVO.getSiiUsuarioReg(),
                                                             obligacionVO.getOblCodigo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (new ObligacionVO(siiObligacion));
    }


    public void borrarObligacion(Long idObligacion) throws ExcepcionDAO {
        obligacionDao.eliminar(idObligacion);
    }


    public List<ObligacionVO> buscarTodaObligacion() throws ExcepcionDAO {
        List<ObligacionVO> listaObligacionVO = null;
        List<SiiObligacion> lista = obligacionDao.buscarTodo();
        if (lista != null) {
            listaObligacionVO = new ArrayList<ObligacionVO>();
            for (SiiObligacion siiObligacion : lista) {
                listaObligacionVO.add(new ObligacionVO(siiObligacion));
            }
        }
        return listaObligacionVO;
    }

    public List<ObligacionVO> buscarObligacionesRegistradasVigenciaActual() throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarObligacionesRegistradasVigenciaActual();
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion unaObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(unaObligacion));
        }
        return listaObligacionVo;
    }

    public List<ObligacionVO> buscarObligacionesRegistradasVigencia() throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarObligacionesRegistradasVigencia();
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion unaObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(unaObligacion));
        }
        return listaObligacionVo;
    }

    public Integer buscarConsecutivoObligacion() throws ExcepcionDAO {
        return (obligacionDao.buscarConsecutivoObligacion());
    }

    public Integer buscarConsecutivoObligacion(String tdcCodigo) throws ExcepcionDAO {
        return (obligacionDao.buscarConsecutivoObligacion(tdcCodigo));
    }


    /**
     * Obtiene la &uacute;ltima Obligaci&oacute;n insertada.
     * @return obligaciones.last
     * @throws ExcepcionDAO
     */
    public ObligacionVO obtenerUltimaObligacion() throws ExcepcionDAO {
        ObligacionVO obligacionVo = null;
        SiiObligacion siiObligacion = obligacionDao.obtenerUltimaObligacion();
        if (siiObligacion != null)
            obligacionVo = new ObligacionVO(siiObligacion);

        return (obligacionVo);
    }

    /**
     * Obtiene la &uacute;ltima Obligaci&oacute;n insertada.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return obligaciones.last
     * @throws ExcepcionDAO
     */
    public ObligacionVO obtenerUltimaObligacion(String tdcCodigo) throws ExcepcionDAO {
        ObligacionVO obligacionVo = null;
        SiiObligacion siiObligacion = obligacionDao.obtenerUltimaObligacion(tdcCodigo);
        if (siiObligacion != null)
            obligacionVo = new ObligacionVO(siiObligacion);

        return (obligacionVo);
    }


    /**
     * Obtiene la &uacute;ltima Obligaci&oacute;n insertada.
     * @param oblCodigoOmision - C&oacute;digo de la Obligaci&oacute;n que debe ser omitida en el resultado (generalmente es la &uacute;ltima obligaci&oacute;n que a&acute;n se encuentra en estado BORRADOR).
     * @return obligaciones.last
     * @throws ExcepcionDAO
     */
    public ObligacionVO obtenerUltimaObligacion(Long oblCodigoOmision) throws ExcepcionDAO {
        ObligacionVO obligacionVo = null;
        SiiObligacion siiObligacion = obligacionDao.obtenerUltimaObligacion(oblCodigoOmision);
        if (siiObligacion != null)
            obligacionVo = new ObligacionVO(siiObligacion);

        return (obligacionVo);
    }

    /**
     * Obtiene la &uacute;ltima Obligaci&oacute;n insertada.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @param oblCodigoOmision - C&oacute;digo de la Obligaci&oacute;n que debe ser omitida en el resultado (generalmente es la &uacute;ltima obligaci&oacute;n que a&acute;n se encuentra en estado BORRADOR).
     * @return obligaciones.last
     * @throws ExcepcionDAO
     */
    public ObligacionVO obtenerUltimaObligacion(String tdcCodigo, Long oblCodigoOmision) throws ExcepcionDAO {
        ObligacionVO obligacionVo = null;
        SiiObligacion siiObligacion = obligacionDao.obtenerUltimaObligacion(tdcCodigo, oblCodigoOmision);
        if (siiObligacion != null)
            obligacionVo = new ObligacionVO(siiObligacion);

        return (obligacionVo);
    }


    /**
     * Realiza la consulta de Obligaciones que se encuentran asociadas al RP especificado.
     * @param rpCodigo - C&oacute;digo del RP.
     * @return List of ObligacionVO
     * @throws ExcepcionDAO
     */
    public List<ObligacionVO> buscarObligacionPorRP(Long rpCodigo) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarObligacionPorRP(rpCodigo);
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }


    /**
     * Realiza la consulta de Obligaciones que se encuentran en el Estado especificado y est&aacute;n asociadas al RP suministrado.
     * @param rpCodigo - C&oacute;digo del RP
     * @param idEstadoObligacion - Estado de la Obligaci&oacute;n
     * @return List of ObligacionVO
     * @throws ExcepcionDAO
     */
    public List<ObligacionVO> buscarObligacionPorRPYEstado(Long rpCodigo, Long idEstadoObligacion) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarObligacionPorRPYEstado(rpCodigo, idEstadoObligacion);
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }


    /**
     * Realiza la consulta de las Obligaciones que se encuentran asociadas al Beneficiario (Proveedor) especificado.
     * @param idBeneficiario - C&oacute;digo del Beneficiario/Proveedor
     * @return List of ObligacionVO
     * @throws ExcepcionDAO
     */
    public List<ObligacionVO> buscarObligacionPorBeneficiario(Long idBeneficiario) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarObligacionPorBeneficiario(idBeneficiario);
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }

    public List<ObligacionVO> buscarObligacionPorBeneficiarioYEstado(Long idBeneficiario,
                                                                     Long idEstadoObligacion) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion =
            obligacionDao.buscarObligacionPorBeneficiarioYEstado(idBeneficiario, idEstadoObligacion);
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }


    /**
     * Realiza la consulta de las Obligaciones del Mes elegido, que se encuentran asociadas al Beneficiario (Proveedor) especificado, correspondientes al Estado de la Obligaci&oacute;n suministrado.
     * @param idBeneficiario - C&oacute;digo del Beneficiario/Proveedor
     * @param idEstadoObligacion - C&oacute;digo del Estado de la Obligaci&oacute;n.
     * @param fecha - Fecha que se utilizar&aacute; para filtrar el Mes de la Obligaci&oacute;n.
     * @return List of ObligacionVO
     * @throws ExcepcionDAO
     */
    public List<ObligacionVO> buscarObligacionPorBeneficiarioMesYEstado(Long idBeneficiario, Long idEstadoObligacion,
                                                                        Date fecha) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion =
            obligacionDao.buscarObligacionPorBeneficiarioMesYEstado(idBeneficiario, idEstadoObligacion, fecha);
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }


    /**
     * Calcula el TOTAL de la Obligaci&oacute;n (sumatoria de los totales de los Conceptos de la Obligaci&oacute;n).
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @return Sumatoria de los totales de los Conceptos que componenen la Obligaci&oacute;n.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerValorTotalObligacion(Long oblCodigo) throws ExcepcionDAO {
        return (obligacionDao.obtenerValorTotalObligacion(oblCodigo));
    }

    public List<ObligacionVO> buscarObligacionesSinOrdenDePago() throws ExcepcionDAO {

        List<SiiObligacion> listaObligacion = obligacionDao.buscarObligacionesSinOrdenDePago();
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion unaObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(unaObligacion));
        }
        return listaObligacionVo;
    }


    public BigDecimal obtenerValorObligacionesBeneficiarioMes(Long proCodigo) throws ExcepcionDAO {
        return (obligacionDao.obtenerValorObligacionesBeneficiarioMes(proCodigo));
    }

    public BigDecimal obtenerValorObligacionesBeneficiarioMes(Long proCodigo, Date fecha) throws ExcepcionDAO {
        return (obligacionDao.obtenerValorObligacionesBeneficiarioMes(proCodigo, fecha));
    }

    public BigDecimal obtenerValorObligacionesBeneficiarioMes(Long proCodigo, Date fecha,
                                                              boolean ivaIncluido) throws ExcepcionDAO {
        return (obligacionDao.obtenerValorObligacionesBeneficiarioMes(proCodigo, fecha, ivaIncluido));
    }

    public BigDecimal obtenerTotalPagoAntRfteObligacionesBeneficiarioMes(Long proCodigo) throws ExcepcionDAO {
        return (obligacionDao.obtenerTotalPagoAntRfteObligacionesBeneficiarioMes(proCodigo));
    }

    public BigDecimal obtenerTotalPagoAntRfteObligacionesBeneficiarioMes(Long proCodigo,
                                                                         Date fecha) throws ExcepcionDAO {
        return (obligacionDao.obtenerTotalPagoAntRfteObligacionesBeneficiarioMes(proCodigo, fecha));
    }

    public List<ObligacionVO> buscarObligacionesNoCubiertasPorOrdenPago() throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarObligacionesNoCubiertasPorOrdenPago();
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }

    public List<ObligacionVO> buscarObligacionesNoCubiertasPorOrdenPagoCuentasPagar() throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarObligacionesNoCubiertasPorOrdenPagoCuentasPagar();
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }


    /**
     * Realiza la inserci&oacute;n de las Obligaciones una a una.
     * @param obligaciones - Listado de Obligaciones.
     * @throws ExcepcionDAO
     */
    public void insertarObligaciones(List<ObligacionVO> obligaciones) throws ExcepcionDAO, ExcepcionAplicacion {
        if (obligaciones != null) {
            for (ObligacionVO obligacionVo : obligaciones) {
                this.insertarObligacion(obligacionVo);
            }
        }
    }

    public List<ObligacionVO> buscarObligacionesNoCubiertasPorOrdenPago(boolean mostrarObligacionesCuentasPorPagar) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion =
            obligacionDao.buscarObligacionesNoCubiertasPorOrdenPago(mostrarObligacionesCuentasPorPagar);
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }

    public List<ObligacionVO> buscarPorCodigoCargaNomina(Long cnoCodigo) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarPorCodigoCargaNomina(cnoCodigo);
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }


    public List<ObligacionVO> buscarPorTipoDocContable(String tdcCodigo) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarPorTipoDocContable(tdcCodigo);
        List<ObligacionVO> listaObligacionVo = new ArrayList();
        for (SiiObligacion siiObligacion : listaObligacion) {
            listaObligacionVo.add(new ObligacionVO(siiObligacion));
        }
        return listaObligacionVo;
    }
    
    
    public List<ObligacionVO> buscarPorIdDistribucionMes (Long dmeCodigo) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarPorIdDistribucionMes(dmeCodigo);
        List<ObligacionVO> listaObligacionVo = null;
        if (listaObligacion!=null) {
            listaObligacionVo = new ArrayList<ObligacionVO>();
            for (SiiObligacion siiObligacion : listaObligacion) {
                if (siiObligacion!=null)
                    listaObligacionVo.add(new ObligacionVO(siiObligacion));
            }
        }
        return listaObligacionVo;
    }
    
    
    
    @Override
    public List<ObligacionVO> buscarObligacionConConceptoReintegro (Long eobCodigo) throws ExcepcionDAO {
        List<SiiObligacion> listaObligacion = obligacionDao.buscarObligacionConConceptoReintegro(eobCodigo);
        List<ObligacionVO> listaObligacionVo = null;
        if (listaObligacion!=null) {
            listaObligacionVo = new ArrayList<ObligacionVO>();
            for (SiiObligacion siiObligacion : listaObligacion) {
                if (siiObligacion!=null)
                    listaObligacionVo.add(new ObligacionVO(siiObligacion));
            }
        }
        return listaObligacionVo;
    }
    
    
    

    /**
     * Elimina las entidades hijas que se encuentran pendientes por remover.
     * @throws ExcepcionDAO
     */
    private void eliminarHijos() throws ExcepcionDAO {
        ///////////////
        // Conceptos //
        ///////////////
        if (listaObligacionConceptoEliminar != null)
            this.eliminarConceptosObligacion();

        //////////////////////////
        // RP Detalle Rubro CDP //
        //////////////////////////
        if (listaOblConcRpDetRubCdpEliminar != null)
            this.eliminarListadoOblConcRpDetRubCdp();
    }


    /**
     * Elimina c/u de los Conceptos que se encuentran asociados a la Obligaci&oacute;n, pero que est&aacute;n pendientes por eliminar.
     * @throws ExcepcionDAO
     */
    private void eliminarConceptosObligacion() throws ExcepcionDAO {
        try {
            if (listaObligacionConceptoEliminar != null && !listaObligacionConceptoEliminar.isEmpty()) {
                for (ObligacionConceptoVO obligacionConceptoVo : listaObligacionConceptoEliminar) {
                    if (obligacionConceptoVo != null && obligacionConceptoVo.getOcoCodigo() != null) {
                        obligacionConceptoDao.eliminar(obligacionConceptoVo.getOcoCodigo());
                    }
                }

                listaObligacionConceptoEliminar = null;
            }
        } catch (ExcepcionDAO e) {
            throw new ExcepcionDAO("Error al momento de eliminar los Conceptos.", e);
        }
    }


    /**
     * Elimina c/u de las entidades de RP Detalle Rubro CDP que se encuentran asociados a la Obligaci&oacute;n, pero que est&aacute;n pendientes por eliminar.
     * @throws ExcepcionDAO
     */
    private void eliminarListadoOblConcRpDetRubCdp() throws ExcepcionDAO {
        try {
            if (listaOblConcRpDetRubCdpEliminar != null && !listaOblConcRpDetRubCdpEliminar.isEmpty()) {
                for (OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo : listaOblConcRpDetRubCdpEliminar) {
                    if (oblConcRpDetRubCdpVo != null && oblConcRpDetRubCdpVo.getOcrCodigo() != null) {
                        oblConcRpDetRubCdpDAO.eliminar(oblConcRpDetRubCdpVo.getOcrCodigo());
                    }
                }

                listaOblConcRpDetRubCdpEliminar = null;
            }
        } catch (ExcepcionDAO e) {
            throw new ExcepcionDAO("Error al momento de eliminar los Conceptos.", e);
        }
    }
    
    
   


    ///////////////////
    // Modificadores //
    ///////////////////
    public void setListaObligacionConceptoEliminar(List<ObligacionConceptoVO> listaObligacionConceptoEliminar) {
        this.listaObligacionConceptoEliminar = listaObligacionConceptoEliminar;
    }

    public List<ObligacionConceptoVO> getListaObligacionConceptoEliminar() {
        return listaObligacionConceptoEliminar;
    }

    public void setListaOblConcRpDetRubCdpEliminar(List<OblConcRpDetRubCdpVO> listaOblConcRpDetRubCdpEliminar) {
        this.listaOblConcRpDetRubCdpEliminar = listaOblConcRpDetRubCdpEliminar;
    }

    public List<OblConcRpDetRubCdpVO> getListaOblConcRpDetRubCdpEliminar() {
        return listaOblConcRpDetRubCdpEliminar;
    }
}
