package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoImputacionContable;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumFuenteFinancContab;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoGastoOrdenPago;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminNotaCredOblConcepto;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AreaColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoGastoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleContNominaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoOrdenPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuenteFinancContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImpContabOblNoPresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionConceptoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionNoPresupDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OrdenPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProveedorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoIdentificacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoGasto;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleContNomina;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOrdenPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinancContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImpContabOblNoPres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionConcepto;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionNoPresup;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.DetalleContNominaVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoOrdenPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.ImpContabOblNoPresVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionContableVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionNoPresupVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionVO;
import co.gov.coljuegos.siicol.ejb.vo.OrdenPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminOrdenPagoBean implements AdminOrdenPago {

    @EJB
    OrdenPagoDAO ordenPagoDAO;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    SolicitudPagoDAO solicitudPagoDao;
    @EJB
    TipoDocContableDAO tipoDocContableDao;
    @EJB
    DocumentoContableDAO documentoContableDao;
    @EJB
    AdminDocumentoContable adminDocumentoContable;
    @EJB
    EstadoDocContabDAO estadoDocContabDao;
    @EJB
    DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    CuentasContablesDAO cuentasContablesDao;
    @EJB
    ImputacionContableDAO imputacionContableDao;
    @EJB
    PersonaDAO personaDao;
    @EJB
    TipoIdentificacionDAO tipoIdentificacionDao;
    @EJB
    ConceptoGastoDAO conceptoGastoDao;
    @EJB
    AreaColjuegosDAO areaColjuegosDao;
    @EJB
    FuenteFinancContabDAO fuenteFinancContabDao;
    @EJB
    ObligacionConceptoDAO obligacionConceptoDao;
    @EJB
    EstadoOrdenPagoDAO estadoOrdenPagoDao;
    @EJB
    private ProveedorDAO proveedorDAO;
    @EJB
    private ObligacionDAO obligacionDAO;
    @EJB
    private RpDAO rpDAO;
    @EJB
    private ObligacionNoPresupDAO obligacionNoPresupDAO;
    @EJB
    private ImpContabOblNoPresDAO impContabOblNoPresDAO;
    @EJB
    private DetalleContNominaDAO detalleContNominaDAO;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private AdminNotaCredOblConcepto adminNotaCredOblConcepto;
    
    
    /**
     * Constructor.
     */
    public AdminOrdenPagoBean() {
    }


    /**
     * Almacena la informaci&oacute;n de los hijos de la Orden de Pago.
     * @param ordenPagoVo - Orden de Pago.
     */
    private void persistirHijos(OrdenPagoVO ordenPagoVo) throws Exception {
        this.persistirDocumentosContables(ordenPagoVo);
    }


    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de los Documentos Contables asociados a la Orden de Pago.
     * @param ordenPagoVo - Orden de Pago.
     * @throws ExcepcionDAO
     */
    private void persistirDocumentosContables(OrdenPagoVO ordenPagoVo) throws Exception {
        if (ordenPagoVo != null) {
            List<DocumentoContableVO> listaDocumentoContable = ordenPagoVo.getDocumentoContableList();
            if (listaDocumentoContable != null) {
                for (DocumentoContableVO documentoContableVo : listaDocumentoContable) {
                    if (documentoContableVo != null) {
                        documentoContableVo.setOrdenPagoVo(ordenPagoVo);

                        if (documentoContableVo.getDcoCodigo() == null) {
                            // OPERACION INSERTAR
                            adminDocumentoContable.insertarDocumentoContable(documentoContableVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminDocumentoContable.actualizarDocumentoContable(documentoContableVo,
                                                                               ordenPagoVo.getUsuarioRegistraVo());
                        }
                    }
                }
            }
        }
    }


    public List<OrdenPagoVO> buscarTodoOrdenPago() throws ExcepcionDAO {

        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarTodoSiiOrdenPago();
        List<OrdenPagoVO> listaOrdenPagoVo = new ArrayList();
        for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
            listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
        }
        return listaOrdenPagoVo;
    }

    public List<OrdenPagoVO> buscarTodasOrdenPagoCuentasXPagar() throws ExcepcionDAO {

        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarTodasOrdenPagoCuentasXPagar();
        List<OrdenPagoVO> listaOrdenPagoVo = new ArrayList();
        for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
            listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
        }
        return listaOrdenPagoVo;
    }


    public List<OrdenPagoVO> buscarTodoSiiOrdenPagoAprobadas() throws ExcepcionDAO {

        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarTodoSiiOrdenPagoAprobadas();

        List<OrdenPagoVO> listaOrdenPagoVo = new ArrayList();
        SiiEstadoOrdenPago siiEstadoOrdenPago = new SiiEstadoOrdenPago();
        for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
            siiEstadoOrdenPago = estadoOrdenPagoDao.buscarEstadoOrdenPagoPorId(unaOrdenPago.getSiiEstadoOrdenPago().getEopCodigo());
            unaOrdenPago.setSiiEstadoOrdenPago(siiEstadoOrdenPago);
            listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
        }
        return listaOrdenPagoVo;
    }

    public List<OrdenPagoVO> buscarTodoSiiOrdenPagoCuentasXPagar() throws ExcepcionDAO {

        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarTodoSiiOrdenPagoCuentasXPagar();
        List<OrdenPagoVO> listaOrdenPagoVo = new ArrayList();
        for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
            listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
        }
        return listaOrdenPagoVo;
    }


    /**
     * Inserta un registro de Orden de Pago (no persiste las entidades hijas en cascada).
     * @param ordenPagoVO
     * @return instance of OrdenPagoVO
     * @throws Exception
     */
    public OrdenPagoVO insertarOrdenPago(OrdenPagoVO ordenPagoVO) throws Exception {
        return (this.insertarOrdenPago(ordenPagoVO, false));
    }


    /**
     * Inserta un registro de Orden de Pago.
     * @param ordenPagoVO - Orden de Pago a insertar.
     * @param persistirHijos - Flag que determina si los hijos ser&aacute;n insertados en cascada.
     * @return instance of OrdenPagoVO.
     * @throws Exception
     */
    public OrdenPagoVO insertarOrdenPago(OrdenPagoVO ordenPagoVO, boolean persistirHijos) throws Exception {
        OrdenPagoVO retorno = null;
        SiiOrdenPago siiOrdenPagoVO = conversionVoEntidad.convertir(ordenPagoVO);
        siiOrdenPagoVO = ordenPagoDAO.insertarSiiOrdenPago(siiOrdenPagoVO);

        if (siiOrdenPagoVO != null) {
            retorno = new OrdenPagoVO(siiOrdenPagoVO);

            if (persistirHijos) {
                // establecer hijos a persistir
                retorno.setDocumentoContableList(ordenPagoVO.getDocumentoContableList());

                this.persistirHijos(retorno);
            }
        }

        return retorno;
    }


    public Integer buscarConsecutivoOrdenPago() throws ExcepcionDAO {
        return ordenPagoDAO.getConsecutivo();
    }
    
    
    public Integer buscarConsecutivoOrdenPago(String tdcCodigo) throws ExcepcionDAO {
        return ( ordenPagoDAO.getConsecutivo(tdcCodigo) );
    }
    
    
    /**
     * Actualiza la informaci&oacute;n de una Orden de Pago (no persiste los hijos en cascada).
     * @param ordenPagoVO - Orden de Pago
     * @return instance of OrdenPagoVO
     * @throws ExcepcionDAO
     */
    public OrdenPagoVO actualizarOrdenPago(OrdenPagoVO ordenPagoVO) throws Exception {
        return (this.actualizarOrdenPago(ordenPagoVO, false));
    }


    /**
     * Actualiza la informaci&oacute;n de una Orden de Pago.
     * @param ordenPagoVO - Orden de Pago
     * @param persistirHijos - Flag que determina si los hijos ser&aacute;n insertados en cascada.
     * @return instance of OrdenPagoVO
     * @throws ExcepcionDAO
     */
    public OrdenPagoVO actualizarOrdenPago(OrdenPagoVO ordenPagoVO, boolean persistirHijos) throws Exception {
        OrdenPagoVO retorno = null;

        SiiOrdenPago siiOrdenPago = conversionVoEntidad.convertir(ordenPagoVO);
        siiOrdenPago = ordenPagoDAO.actualizarSiiOrdenPago(siiOrdenPago);

        if (siiOrdenPago != null) {
            retorno = new OrdenPagoVO(siiOrdenPago);

            if (persistirHijos) {
                // establecer hijos a persistir
                retorno.setDocumentoContableList(ordenPagoVO.getDocumentoContableList());

                this.persistirHijos(retorno);
            }
        }

        return retorno;
    }


    /**
     * Actualiza el estado de la Orden de Pago y coloca cada Documento Contable en estado ANULADO.
     * @param ordenPagoVO
     * @return instance of OrdenPagoVO
     * @throws ExcepcionDAO
     */
    public OrdenPagoVO anularOrdenPago(OrdenPagoVO ordenPagoVO,UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        SiiOrdenPago siiOrdenPagoVO = conversionVoEntidad.convertir(ordenPagoVO);
        siiOrdenPagoVO = ordenPagoDAO.actualizarSiiOrdenPago(siiOrdenPagoVO);
       
       //insertar log 
       if(ordenPagoVO.getEstadoOrdenPagoVo().getEopCodigo() != null){
           adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ORDEN_DE_PAGO.getId(), ordenPagoVO.getEstadoOrdenPagoVo().getEopCodigo(), usuarioLogueado,ordenPagoVO.getOrpCodigo());
       }

        //actualiza documento contable

        List<SiiDocumentoContable> listaSiiDocumentoContable = new ArrayList<SiiDocumentoContable>();
        listaSiiDocumentoContable = documentoContableDao.buscarPorCodigoOrdenPago(siiOrdenPagoVO.getOrpCodigo());
        for (SiiDocumentoContable siiDocumentoContable : listaSiiDocumentoContable) {
            SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarPorCodigo(EnumEstadoDocContab.ANULADO.getId());
            siiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
            documentoContableDao.actualizar(siiDocumentoContable);
        }
        OrdenPagoVO retorno = new OrdenPagoVO(siiOrdenPagoVO);
        return retorno;
    }


    public OrdenPagoVO buscarOrdenPagoPorCodigo(long codOrdenPagoVO) throws ExcepcionDAO {
        OrdenPagoVO resultado = null;
        SiiOrdenPago ordenPago = ordenPagoDAO.buscarOrdenPagoPorCodigo(codOrdenPagoVO);
        if (ordenPago != null)
            resultado = new OrdenPagoVO(ordenPago);

        return (resultado);
    }


    public EstadoOrdenPagoVO buscarEstadoOrdenPagoPorId(long codEstadoOrdenPagoVo) throws ExcepcionDAO {
        SiiEstadoOrdenPago siiEstadoOrdenPago = estadoOrdenPagoDao.buscarEstadoOrdenPagoPorId(codEstadoOrdenPagoVo);
        return new EstadoOrdenPagoVO(siiEstadoOrdenPago);
    }

    public EstadoOrdenPagoVO buscarEstadoOrdenPagoXNombre(String nombreEstado) throws ExcepcionDAO {
        SiiEstadoOrdenPago siiEstadoOrdenPago = estadoOrdenPagoDao.buscarEstadoOrdenPagoXNombre(nombreEstado);
        return new EstadoOrdenPagoVO(siiEstadoOrdenPago);
    }


    public List<OrdenPagoVO> buscarRangoOrdenPagoPorCodigo(Integer inicio, Integer fin) throws ExcepcionDAO {
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarRangoOrdenPagoPorCodigo(inicio, fin);
        List<OrdenPagoVO> listaOrdenPagoVo = new ArrayList();
        for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
            listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
        }
        return listaOrdenPagoVo;
    }

    public OrdenPagoVO actualizarOrdenPagoMovimientoContable(OrdenPagoVO ordenPagoVo) throws ExcepcionDAO {
        SiiOrdenPago siiOrdenPagoVO = conversionVoEntidad.convertir(ordenPagoVo);
        Date fechaActual = new Date();
        String nombreEstado = "BORRADOR";
        //SiiTipoIdentificacion  siiTipoIdentificacion  =  new SiiTipoIdentificacion ();
        SiiPersona siiPersona = new SiiPersona();
        //siiTipoIdentificacion.setTidCodigo("Número de Identificación Tributario");
        SiiTipoIdentificacion unaIdentificacion = tipoIdentificacionDao.buscarTipoIdentificacionPorId(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId());
        siiPersona = personaDao.buscarPersonaPorNumeroIdYTipoId("899999090", unaIdentificacion.getTidNombreCorto());
        BigDecimal cuatroXMil = new BigDecimal(4);
        BigDecimal mil = new BigDecimal(1000);
        BigDecimal temp =new BigDecimal(0);

        if (ordenPagoVo.getOrpPagDestFinal().equals("S")) {
            siiOrdenPagoVO = ordenPagoDAO.actualizarSiiOrdenPago(siiOrdenPagoVO);

            //Movimiento contable
            SiiDocumentoContable insertSiiDocumentoContable = new SiiDocumentoContable();

            SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo("PPR");
            Integer consecutivo = documentoContableDao.buscarConsecutivoDocumentoContable("PPR");
            insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
            Date dcoFechaOper = siiOrdenPagoVO.getOrpFecha()!=null ? siiOrdenPagoVO.getOrpFecha() : fechaActual;
            insertSiiDocumentoContable.setDcoFechaOper(dcoFechaOper);
            insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
            SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
            insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
            insertSiiDocumentoContable.setSiiOrdenPago(siiOrdenPagoVO);
            //SiiObligacion siiObligacion = conversionVoEntidad.convertir(ordenPagoVo.getObligacionVo());
            //insertSiiDocumentoContable.setSiiObligacion(siiObligacion);
            insertSiiDocumentoContable = documentoContableDao.insertar(insertSiiDocumentoContable);

            //conceptos contables
            List<SiiObligacionConcepto> ListaObligacionConceptoVo = new ArrayList<SiiObligacionConcepto>();
            ListaObligacionConceptoVo =
                detalleRecaudoDao.BuscarConceptocontableXObligacion(ordenPagoVo.getObligacionVo().getOblCodigo());


            for (SiiObligacionConcepto unSiiObligacionConcepto : ListaObligacionConceptoVo) {
                
                // validar la correspondencia de la fuente de financiacion contable del concepto con el tipo de gasto de la orden de pago
                if (unSiiObligacionConcepto!=null && ordenPagoVo.getOrpTipoGasto()!=null && unSiiObligacionConcepto.getSiiFuenteFinancContab()!=null && 
                    this.validarTipoGastoConFFC(ordenPagoVo.getOrpTipoGasto(), unSiiObligacionConcepto.getSiiFuenteFinancContab().getFfcCodigo())) 
                {
                    ObligacionConceptoVO ocoVo = new ObligacionConceptoVO(unSiiObligacionConcepto);
                    if (ocoVo.getOcoCodigo()!=null) {
                        // valor a girar proveniente de la Obligacion.
                        BigDecimal valorGirarOblig = ocoVo.getValorAGirar();
                        
                        // valor a descontar proveniente de la Nota de Credito.
                        BigDecimal valorDescontarNotaCred = new BigDecimal(0);
                        List<NotaCredOblConceptoVO> listaNotaCredOblConcepto = adminNotaCredOblConcepto.buscarNotaCredOblConceptoPorObligacionConcepto(ocoVo.getOcoCodigo());
                        if (listaNotaCredOblConcepto!=null && !listaNotaCredOblConcepto.isEmpty()) {
                            for (NotaCredOblConceptoVO ncocoVo: listaNotaCredOblConcepto) {
                                if (ncocoVo!=null && ncocoVo.getValorADescontar()!=null)
                                    valorDescontarNotaCred = valorDescontarNotaCred.add(ncocoVo.getValorADescontar());
                            }
                        }
                        
                        temp = new BigDecimal(0);
                        if (valorGirarOblig!=null)
                            temp = temp.add(valorGirarOblig);
                        if (valorDescontarNotaCred!=null)
                            temp = temp.subtract(valorDescontarNotaCred);
                        
                        
                        SiiImputacionContable siiImputacionContable = new SiiImputacionContable();
                        siiImputacionContable.setSiiCuentasContables(unSiiObligacionConcepto.getSiiConceptoGasto().getSiiCuentasContablesCred());
                        siiImputacionContable.setImcTipoMovim("D");
                        SiiConceptoGasto siiConceptoGasto =
                            conceptoGastoDao.buscarPorCodigo(unSiiObligacionConcepto.getSiiConceptoGasto().getCgaCodigo());
                        SiiCuentasContables siiCuentasContables =
                            cuentasContablesDao.buscarPorCodigo(siiConceptoGasto.getSiiCuentasContablesCred().getCcoCodigo());
                        //validaciones
                        if (siiCuentasContables.getCcoObligaTerc().equals("S")) {
                            SiiPersona siiPersonac =
                                conversionVoEntidad.convertir(ordenPagoVo.getBeneficiario().getPersonaVo());
                            siiImputacionContable.setSiiPersona(siiPersonac);
                        }
                        if (siiCuentasContables.getCcoNumDocConta().equals("S"))
                            siiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
                        if (siiCuentasContables.getCcoFteFinanc().equals("S"))
                            siiImputacionContable.setSiiFuenteFinancContab(unSiiObligacionConcepto.getSiiFuenteFinancContab());
                        /* if(siiCuentasContables.getCcoCentroCost().equals("S") ){
                                  SiiAreaColjuegos unaArecaColjuegos= areaColjuegosDao.buscarAreaColjuegosPorId(Long.parseLong(siiCuentasContables.getCcoCentroCost()));
                                  siiImputacionContable.setSiiAreaColjuegos(unaArecaColjuegos);
                        }*/
                        if (siiCuentasContables.getCcoReferencia1().equals("S"))
                            siiImputacionContable.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());
                        if (siiCuentasContables.getCcoReferencia2().equals("S"))
                            siiImputacionContable.setImcReferencia2(ordenPagoVo.getNumeroRP().toString());
                        
                        //interesCuotaVo.setIcuValor(Utilidades.redondear (interesCuotaVo.getIcuValor(), 0))
                            
                        siiImputacionContable.setImcDescrOperacion("PAGO FACTURA || " +
                                                                   ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                        
                        
                        
                        
                        
                        siiImputacionContable.setImcValor(Utilidades.redondear(temp) );
                        siiImputacionContable.setImcEstado(EnumEstadoImputacionContable.ACTIVO.getId());
                        imputacionContableDao.insertarImputacionContable(siiImputacionContable);
                    }
                }
            }
            
            
            // si el valor seleccionado es gastos de personal >0

            if (ordenPagoVo.getValorGasto().compareTo(BigDecimal.ZERO) > 0 &&
                ordenPagoVo.getIndicadorPago().equals("GP")) {
                List<SiiCuentaContTipoDocCont> listaSiiCuentaContfuenteFin = new ArrayList<SiiCuentaContTipoDocCont>();
                listaSiiCuentaContfuenteFin = detalleRecaudoDao.BuscarCuentaContTipoDocContFuenteFinSinTercero("PPR","RNP");
                for (SiiCuentaContTipoDocCont unSiiCuentaContTipoDocContFuenteFin : listaSiiCuentaContfuenteFin) {
                    SiiImputacionContable siiImputacionContableFuente = new SiiImputacionContable();
                    siiImputacionContableFuente.setSiiCuentasContables(unSiiCuentaContTipoDocContFuenteFin.getSiiCuentasContables());
                    siiImputacionContableFuente.setImcTipoMovim(unSiiCuentaContTipoDocContFuenteFin.getCctTipoMovim());
                    SiiCuentasContables siiCuentasContables =
                        cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocContFuenteFin.getSiiCuentasContables().getCcoCodigo());
                    //validaciones
                    if (siiCuentasContables.getCcoObligaTerc().equals("S")) {
                        SiiPersona siiPersonaf =
                            conversionVoEntidad.convertir(ordenPagoVo.getBeneficiario().getPersonaVo());
                        siiImputacionContableFuente.setSiiPersona(siiPersonaf);
                    }
                    if (siiCuentasContables.getCcoNumDocConta().equals("S"))
                        siiImputacionContableFuente.setSiiDocumentoContable(insertSiiDocumentoContable);
                    /* if(siiCuentasContables.getCcoCentroCost().equals("S") ){
                              SiiAreaColjuegos unaArecaColjuegos= areaColjuegosDao.buscarAreaColjuegosPorId(Long.parseLong(siiCuentasContables.getCcoCentroCost()));
                              siiImputacionContableFuente.setSiiAreaColjuegos(unaArecaColjuegos);
                    }*/
                    if (siiCuentasContables.getCcoFteFinanc().equals("S"))
                        siiImputacionContableFuente.setSiiFuenteFinancContab(unSiiCuentaContTipoDocContFuenteFin.getSiiFuenteFinancContab());
                    if (siiCuentasContables.getCcoReferencia1().equals("S"))
                        siiImputacionContableFuente.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());

                    siiImputacionContableFuente.setImcDescrOperacion("PAGO FACTURA || " +
                                                                     ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                    siiImputacionContableFuente.setImcValor(ordenPagoVo.getValorGasto());
                    siiImputacionContableFuente.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContableFuente);

                    // Tipo de movimiento D
                    SiiImputacionContable siiImputacionContableFuenteD = new SiiImputacionContable();
                    siiImputacionContableFuenteD.setSiiCuentasContables(unSiiCuentaContTipoDocContFuenteFin.getSiiCuentasContables());
                    siiImputacionContableFuenteD.setImcTipoMovim("D");
                    SiiCuentasContables siiCuentasContablesF =
                        cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocContFuenteFin.getSiiCuentasContables().getCcoCodigo());
                    //validaciones
                    if (siiCuentasContablesF.getCcoObligaTerc().equals("S")) {
                        SiiPersona siiPersonaD =
                            conversionVoEntidad.convertir(ordenPagoVo.getBeneficiario().getPersonaVo());
                        siiImputacionContableFuenteD.setSiiPersona(siiPersonaD);
                    }
                    if (siiCuentasContablesF.getCcoNumDocConta().equals("S"))
                        siiImputacionContableFuenteD.setSiiDocumentoContable(insertSiiDocumentoContable);
                    /* if(siiCuentasContablesF.getCcoCentroCost().equals("S") ){
                              SiiAreaColjuegos unaArecaColjuegos= areaColjuegosDao.buscarAreaColjuegosPorId(Long.parseLong(siiCuentasContablesF.getCcoCentroCost()));
                              siiImputacionContableFuenteD.setSiiAreaColjuegos(unaArecaColjuegos);
                    }*/
                    if (siiCuentasContablesF.getCcoReferencia1().equals("S"))
                        siiImputacionContableFuenteD.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());


                    siiImputacionContableFuenteD.setImcDescrOperacion("PAGO FACTURA || " +
                                                                      ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                    siiImputacionContableFuenteD.setImcValor(ordenPagoVo.getValorGasto());
                    siiImputacionContableFuenteD.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContableFuenteD);
                }

                //genera la tercera imputación
                List<SiiCuentaContTipoDocCont> listaSiiCuentaContTercero = new ArrayList<SiiCuentaContTipoDocCont>();
                listaSiiCuentaContTercero =
                    detalleRecaudoDao.BuscarCuentaContTipoDocContFuenteFin(siiPersona.getPerCodigo(), "PPR","RNP");

                for (SiiCuentaContTipoDocCont unSiiCuentaContTipoDocContTercero : listaSiiCuentaContTercero) {

                    SiiImputacionContable siiImputacionContableTercero = new SiiImputacionContable();
                    siiImputacionContableTercero.setSiiCuentasContables(unSiiCuentaContTipoDocContTercero.getSiiCuentasContables());
                    siiImputacionContableTercero.setImcTipoMovim(unSiiCuentaContTipoDocContTercero.getCctTipoMovim());

                    SiiCuentasContables siiCuentasContablesTercero =
                        cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocContTercero.getSiiCuentasContables().getCcoCodigo());
                    //validaciones

                    if (siiCuentasContablesTercero.getCcoObligaTerc().equals("S")) {
                        siiImputacionContableTercero.setSiiPersona(siiPersona);
                    }
                    if (siiCuentasContablesTercero.getCcoNumDocConta().equals("S"))
                        siiImputacionContableTercero.setSiiDocumentoContable(insertSiiDocumentoContable);
                    if (siiCuentasContablesTercero.getCcoFteFinanc().equals("S"))
                        siiImputacionContableTercero.setSiiFuenteFinancContab(unSiiCuentaContTipoDocContTercero.getSiiFuenteFinancContab());
                    /* if(siiCuentasContablesTercero.getCcoCentroCost().equals("S") ){
                                    SiiAreaColjuegos unaArecaColjuegos= areaColjuegosDao.buscarAreaColjuegosPorId(Long.parseLong(siiCuentasContablesTercero.getCcoCentroCost()));
                                    siiImputacionContableTercero.setSiiAreaColjuegos(unaArecaColjuegos);
                          }*/
                    if (siiCuentasContablesTercero.getCcoReferencia1().equals("S"))
                        siiImputacionContableTercero.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());

                    siiImputacionContableTercero.setImcDescrOperacion("PAGO FACTURA || " +
                                                                      ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                    siiImputacionContableTercero.setImcValor(ordenPagoVo.getValorGasto());
                    siiImputacionContableTercero.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContableTercero);

                }
            }

            // si el valor seleccionado en gastos generales >0
            if (ordenPagoVo.getValorGasto().compareTo(BigDecimal.ZERO) > 0 &&
                ordenPagoVo.getIndicadorPago().equals("GG")) {

                List<SiiCuentaContTipoDocCont> listaSiiCuentaContGastosG = new ArrayList<SiiCuentaContTipoDocCont>();
                listaSiiCuentaContGastosG = detalleRecaudoDao.BuscarCuentaContTipoDocContFuenteFinSinTercero("PPR","RNG");
                for (SiiCuentaContTipoDocCont unSiiCuentaContTipoDocContFuenteFin : listaSiiCuentaContGastosG) {

                    SiiImputacionContable siiImputacionContGastosG = new SiiImputacionContable();
                    siiImputacionContGastosG.setSiiCuentasContables(unSiiCuentaContTipoDocContFuenteFin.getSiiCuentasContables());
                    siiImputacionContGastosG.setImcTipoMovim("C");

                    SiiCuentasContables siiCuentasContablesTercero =
                        cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocContFuenteFin.getSiiCuentasContables().getCcoCodigo());
                    //validaciones

                    if (siiCuentasContablesTercero.getCcoObligaTerc().equals("S")) {
                        SiiPersona siiPersonat =
                            conversionVoEntidad.convertir(ordenPagoVo.getBeneficiario().getPersonaVo());
                        siiImputacionContGastosG.setSiiPersona(siiPersonat);
                    }
                    if (siiCuentasContablesTercero.getCcoNumDocConta().equals("S"))
                        siiImputacionContGastosG.setSiiDocumentoContable(insertSiiDocumentoContable);
                    if (siiCuentasContablesTercero.getCcoFteFinanc().equals("S"))
                        siiImputacionContGastosG.setSiiFuenteFinancContab(unSiiCuentaContTipoDocContFuenteFin.getSiiFuenteFinancContab());
                    /* if(siiCuentasContablesTercero.getCcoCentroCost().equals("S") ){
                                    SiiAreaColjuegos unaArecaColjuegos= areaColjuegosDao.buscarAreaColjuegosPorId(Long.parseLong(siiCuentasContablesTercero.getCcoCentroCost()));
                                    siiImputacionContGastosG.setSiiAreaColjuegos(unaArecaColjuegos);
                          }*/
                    if (siiCuentasContablesTercero.getCcoReferencia1().equals("S"))
                        siiImputacionContGastosG.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());

                    siiImputacionContGastosG.setImcDescrOperacion("PAGO FACTURA || " +
                                                                  ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                    siiImputacionContGastosG.setImcValor(ordenPagoVo.getValorGasto());
                    siiImputacionContGastosG.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContGastosG);

                    //con tipo movimiento D

                    SiiImputacionContable siiImputacionContGastosGd = new SiiImputacionContable();
                    siiImputacionContGastosGd.setSiiCuentasContables(unSiiCuentaContTipoDocContFuenteFin.getSiiCuentasContables());
                    siiImputacionContGastosGd.setImcTipoMovim("D");

                    SiiCuentasContables siiCuentasContablesTercerod =
                        cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocContFuenteFin.getSiiCuentasContables().getCcoCodigo());
                    //validaciones

                    if (siiCuentasContablesTercerod.getCcoObligaTerc().equals("S")) {
                        SiiPersona siiPersonat =
                            conversionVoEntidad.convertir(ordenPagoVo.getBeneficiario().getPersonaVo());
                        siiImputacionContGastosGd.setSiiPersona(siiPersonat);
                    }
                    if (siiCuentasContablesTercerod.getCcoNumDocConta().equals("S"))
                        siiImputacionContGastosGd.setSiiDocumentoContable(insertSiiDocumentoContable);
                    if (siiCuentasContablesTercerod.getCcoFteFinanc().equals("S"))
                        siiImputacionContGastosGd.setSiiFuenteFinancContab(unSiiCuentaContTipoDocContFuenteFin.getSiiFuenteFinancContab());
                    /* if(siiCuentasContablesTercerod.getCcoCentroCost().equals("S") ){
                                    SiiAreaColjuegos unaArecaColjuegos= areaColjuegosDao.buscarAreaColjuegosPorId(Long.parseLong(siiCuentasContablesTercerod.getCcoCentroCost()));
                                    siiImputacionContGastosGd.setSiiAreaColjuegos(unaArecaColjuegos);
                          }*/
                    if (siiCuentasContablesTercerod.getCcoReferencia1().equals("S"))
                        siiImputacionContGastosGd.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());

                    siiImputacionContGastosGd.setImcDescrOperacion("PAGO FACTURA || " +
                                                                   ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                    siiImputacionContGastosGd.setImcValor(ordenPagoVo.getValorGasto());
                    siiImputacionContGastosGd.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContGastosGd);

                }

                List<SiiCuentaContTipoDocCont> listaSiiCuentaContGastosGenerales =
                    new ArrayList<SiiCuentaContTipoDocCont>();
                listaSiiCuentaContGastosGenerales =
                    detalleRecaudoDao.BuscarCuentaContTipoDocContFuenteFin(siiPersona.getPerCodigo(), "PPR","RNG");
                for (SiiCuentaContTipoDocCont unSiiCueContTipoDocContFuenteFin : listaSiiCuentaContGastosGenerales) {

                    SiiImputacionContable siiImputacionContGastosGen = new SiiImputacionContable();
                    siiImputacionContGastosGen.setSiiCuentasContables(unSiiCueContTipoDocContFuenteFin.getSiiCuentasContables());
                    siiImputacionContGastosGen.setImcTipoMovim(unSiiCueContTipoDocContFuenteFin.getCctTipoMovim());

                    SiiCuentasContables siiCuentasContablesTercero =
                        cuentasContablesDao.buscarPorCodigo(unSiiCueContTipoDocContFuenteFin.getSiiCuentasContables().getCcoCodigo());
                    //validaciones

                    if (siiCuentasContablesTercero.getCcoObligaTerc().equals("S")) {
                        siiImputacionContGastosGen.setSiiPersona(siiPersona);
                    }
                    if (siiCuentasContablesTercero.getCcoNumDocConta().equals("S"))
                        siiImputacionContGastosGen.setSiiDocumentoContable(insertSiiDocumentoContable);
                    if (siiCuentasContablesTercero.getCcoFteFinanc().equals("S"))
                        siiImputacionContGastosGen.setSiiFuenteFinancContab(unSiiCueContTipoDocContFuenteFin.getSiiFuenteFinancContab());
                    /* if(siiCuentasContablesTercero.getCcoCentroCost().equals("S") ){
                                      SiiAreaColjuegos unaArecaColjuegos= areaColjuegosDao.buscarAreaColjuegosPorId(Long.parseLong(siiCuentasContablesTercero.getCcoCentroCost()));
                                      siiImputacionContGastosGen.setSiiAreaColjuegos(unaArecaColjuegos);
                             }*/
                    if (siiCuentasContablesTercero.getCcoReferencia1().equals("S"))
                        siiImputacionContGastosGen.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());


                    siiImputacionContGastosGen.setImcDescrOperacion("PAGO FACTURA || " +
                                                                    ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                    siiImputacionContGastosGen.setImcValor(ordenPagoVo.getValorGasto());
                    siiImputacionContGastosGen.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContGastosGen);


                }


            }
            if (ordenPagoVo.getValorGasto().compareTo(BigDecimal.ZERO) > 0 &&
                ordenPagoVo.getIndicadorPago().equals("RP")) {

                SiiImputacionContable siiImputacionContRecursosP = new SiiImputacionContable();

                SiiCuentasContables siiCuentasContablesTercero =
                    cuentasContablesDao.BuscarCuentaContableXCuentaBancaria(ordenPagoVo.getCuentaBancariaVo().getCbaCodigo());
                siiImputacionContRecursosP.setSiiCuentasContables(siiCuentasContablesTercero);
                siiImputacionContRecursosP.setImcTipoMovim("C");


                //validaciones
                if (siiCuentasContablesTercero.getCcoObligaTerc().equals("S")) {
                    SiiPersona siiPersonaot =
                        conversionVoEntidad.convertir(ordenPagoVo.getBeneficiario().getPersonaVo());
                    siiImputacionContRecursosP.setSiiPersona(siiPersonaot);
                }
                if (siiCuentasContablesTercero.getCcoNumDocConta().equals("S"))
                    siiImputacionContRecursosP.setSiiDocumentoContable(insertSiiDocumentoContable);
                /*if(siiCuentasContablesTercero.getCcoFteFinanc().equals("S") )
                                   siiImputacionContRecursosP.setSiiFuenteFinancContab(siiCuentasContablesTercero.getSiiFuenteFinancContab()); falta validar */
                if (siiCuentasContablesTercero.getCcoReferencia1().equals("S"))
                    siiImputacionContRecursosP.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());
                /*  if(siiCuentasContablesTercero.getCcoCentroCost().equals("S") ){
                                  SiiAreaColjuegos unaArecaColjuegos= areaColjuegosDao.buscarAreaColjuegosPorId(Long.parseLong(siiCuentasContablesTercero.getCcoCentroCost()));
                                  siiImputacionContRecursosP.setSiiAreaColjuegos(unaArecaColjuegos);
                         }*/

                siiImputacionContRecursosP.setImcDescrOperacion("PAGO FACTURA || " +
                                                                ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                siiImputacionContRecursosP.setImcValor(ordenPagoVo.getValorGasto());
                siiImputacionContRecursosP.setImcEstado("A");
                imputacionContableDao.insertarImputacionContable(siiImputacionContRecursosP);


                if (ordenPagoVo.getCuentaBancariaVo().getCbaAplicaGmf().equals("S")) {
                    BigDecimal temp2= new BigDecimal (0); 
                      
                    List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont =
                        new ArrayList<SiiCuentaContTipoDocCont>();
                    listaSiiCuentaContTipoDocCont = detalleRecaudoDao.BuscarCuentaContXPpr4XMil();
                    SiiImputacionContable siiImputacionContCuentaBan = new SiiImputacionContable();

                    SiiCuentasContables siiCuentasContables =
                        cuentasContablesDao.BuscarCuentaContableXCuentaBancaria(ordenPagoVo.getCuentaBancariaVo().getCbaCodigo());
                    siiImputacionContCuentaBan.setSiiCuentasContables(siiCuentasContables);
                    siiImputacionContCuentaBan.setImcTipoMovim("C");
                    //validaciones
                    SiiPersona siiPersonata =
                        conversionVoEntidad.convertir(ordenPagoVo.getCuentaBancariaVo().getSiiBanco().getPersona());
                    siiImputacionContCuentaBan.setSiiPersona(siiPersonata);

                    if (siiCuentasContables.getCcoNumDocConta().equals("S"))
                        siiImputacionContCuentaBan.setSiiDocumentoContable(insertSiiDocumentoContable);
                    if (siiCuentasContables.getCcoFteFinanc().equals("S"))
                        siiImputacionContCuentaBan.setSiiFuenteFinancContab(listaSiiCuentaContTipoDocCont.get(0).getSiiFuenteFinancContab());
                    if (siiCuentasContables.getCcoReferencia1().equals("S"))
                        siiImputacionContCuentaBan.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());

                    siiImputacionContCuentaBan.setImcDescrOperacion("CONTRIBUCIÓN 4x1000  || " +
                                                                    ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                    temp2=ordenPagoVo.getValorGasto().multiply(cuatroXMil).divide(mil);
                    
                    siiImputacionContCuentaBan.setImcValor(Utilidades.redondear (temp2, 0));
                    siiImputacionContCuentaBan.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContCuentaBan);


                    //imputacion 4*1000

                    SiiImputacionContable siiImputacionContCuenta4XMil = new SiiImputacionContable();
                    siiImputacionContCuenta4XMil.setSiiCuentasContables(listaSiiCuentaContTipoDocCont.get(0).getSiiCuentasContables());
                    siiImputacionContCuenta4XMil.setImcTipoMovim("D");
                    siiImputacionContCuenta4XMil.setSiiPersona(siiPersonata);
                    siiImputacionContCuenta4XMil.setSiiDocumentoContable(insertSiiDocumentoContable);
                    if (siiCuentasContables.getCcoNumDocConta().equals("S"))
                        siiImputacionContCuenta4XMil.setSiiDocumentoContable(insertSiiDocumentoContable);

                    if (siiCuentasContables.getCcoFteFinanc().equals("S"))
                        siiImputacionContCuenta4XMil.setSiiFuenteFinancContab(listaSiiCuentaContTipoDocCont.get(0).getSiiFuenteFinancContab());
                    if (siiCuentasContables.getCcoReferencia1().equals("S"))
                        siiImputacionContCuenta4XMil.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());

                    siiImputacionContCuenta4XMil.setImcDescrOperacion("CONTRIBUCIÓN 4x1000  || " +
                                                                      ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                    siiImputacionContCuenta4XMil.setImcValor(Utilidades.redondear (temp2, 0));
                    siiImputacionContCuenta4XMil.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContCuenta4XMil);

                }

            }
        }
        //Indicador de pago Destinatario Final N
        else {
            siiOrdenPagoVO = ordenPagoDAO.actualizarSiiOrdenPago(siiOrdenPagoVO);
            //Movimiento contable TPE
            SiiDocumentoContable insertSiiDocumentoContableTpe = new SiiDocumentoContable();
            SiiTipoDocContable siiTipoDocContableTpe = tipoDocContableDao.buscarPorCodigo("TPE");
            Integer consecutivoTpe = documentoContableDao.buscarConsecutivoDocumentoContable("TPE");

            insertSiiDocumentoContableTpe.setDcoNumeroCompr(consecutivoTpe);
            Date dcoFechaOper = siiOrdenPagoVO.getOrpFecha()!=null ? siiOrdenPagoVO.getOrpFecha() : fechaActual;
            insertSiiDocumentoContableTpe.setDcoFechaOper(dcoFechaOper);
            insertSiiDocumentoContableTpe.setSiiTipoDocContable(siiTipoDocContableTpe);

            SiiEstadoDocContab siiEstadoDocContabTpe = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
            insertSiiDocumentoContableTpe.setSiiEstadoDocContab(siiEstadoDocContabTpe);
            insertSiiDocumentoContableTpe.setSiiOrdenPago(siiOrdenPagoVO);
            SiiObligacion siiObligacion = conversionVoEntidad.convertir(ordenPagoVo.getObligacionVo());
            //insertSiiDocumentoContableTpe.setSiiObligacion(siiObligacion);
            insertSiiDocumentoContableTpe = documentoContableDao.insertar(insertSiiDocumentoContableTpe);

            if (ordenPagoVo.getIndicadorPago().equals("GP")) { // gastos personales
                List<SiiCuentaContTipoDocCont> listaSiiCuentaContble = new ArrayList<SiiCuentaContTipoDocCont>();
                listaSiiCuentaContble = detalleRecaudoDao.BuscarCuentaContTipoDocContFuenteFinSinTer("TPE","RNP");
                for (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont : listaSiiCuentaContble) {

                    SiiImputacionContable siiImputacionContGastosPersonal = new SiiImputacionContable();
                    siiImputacionContGastosPersonal.setSiiCuentasContables(siiCuentaContTipoDocCont.getSiiCuentasContables());
                    siiImputacionContGastosPersonal.setImcTipoMovim(siiCuentaContTipoDocCont.getCctTipoMovim());

                    SiiCuentasContables siiCuentasContablesTercero =
                        cuentasContablesDao.buscarPorCodigo(siiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                    //validaciones

                    if (siiCuentasContablesTercero.getCcoObligaTerc().equals("S")) {
                        siiImputacionContGastosPersonal.setSiiPersona(siiPersona);
                    }
                    if (siiCuentasContablesTercero.getCcoNumDocConta().equals("S"))
                        siiImputacionContGastosPersonal.setSiiDocumentoContable(insertSiiDocumentoContableTpe);
                    if (siiCuentasContablesTercero.getCcoFteFinanc().equals("S")) {
                        siiImputacionContGastosPersonal.setSiiFuenteFinancContab(siiCuentaContTipoDocCont.getSiiFuenteFinancContab());
                    }
                    if (siiCuentasContablesTercero.getCcoReferencia1().equals("S"))
                        siiImputacionContGastosPersonal.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());


                    siiImputacionContGastosPersonal.setImcDescrOperacion("TRANSLADO A PAGADURIA ENTIDAD");
                    siiImputacionContGastosPersonal.setImcValor(ordenPagoVo.getValorGasto());
                    siiImputacionContGastosPersonal.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContGastosPersonal);

                }

                //IMPUTACION 2

                SiiImputacionContable siiImputacionContGastosPersonal2 = new SiiImputacionContable();
                SiiCuentasContables siiCuentasContab =
                    cuentasContablesDao.BuscarCuentaContableXCuentaBancaria(ordenPagoVo.getCuentaBancariaVo().getCbaCodigo());
                siiImputacionContGastosPersonal2.setSiiCuentasContables(siiCuentasContab);
                siiImputacionContGastosPersonal2.setImcTipoMovim("D");

                SiiCuentasContables siiCuentasContable =
                    cuentasContablesDao.buscarPorCodigo(siiCuentasContab.getCcoCodigo());
                //validaciones

                if (siiCuentasContable.getCcoObligaTerc().equals("S")) {
                    siiImputacionContGastosPersonal2.setSiiPersona(siiPersona);
                }
                if (siiCuentasContable.getCcoNumDocConta().equals("S"))
                    siiImputacionContGastosPersonal2.setSiiDocumentoContable(insertSiiDocumentoContableTpe);
                if (siiCuentasContable.getCcoFteFinanc().equals("S")) {
                    SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDao.buscarPorCodigo("RNP");
                    siiImputacionContGastosPersonal2.setSiiFuenteFinancContab(siiFuenteFinancContab);
                }
                if (siiCuentasContable.getCcoReferencia1().equals("S"))
                    siiImputacionContGastosPersonal2.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());


                siiImputacionContGastosPersonal2.setImcDescrOperacion("TRANSLADO A PAGADURIA ENTIDAD");
                siiImputacionContGastosPersonal2.setImcValor(ordenPagoVo.getValorGasto());
                siiImputacionContGastosPersonal2.setImcEstado("A");
                imputacionContableDao.insertarImputacionContable(siiImputacionContGastosPersonal2);

            }

            if (ordenPagoVo.getIndicadorPago().equals("GG")) {

                List<SiiCuentaContTipoDocCont> listaSiiCuentaContble = new ArrayList<SiiCuentaContTipoDocCont>();
                listaSiiCuentaContble = detalleRecaudoDao.BuscarCuentaContTipoDocContFuenteFinSinTer("TPE","RNG");
                for (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont : listaSiiCuentaContble) {
                    SiiImputacionContable siiImputacionContGastosGenerales = new SiiImputacionContable();
                    siiImputacionContGastosGenerales.setSiiCuentasContables(siiCuentaContTipoDocCont.getSiiCuentasContables());
                    siiImputacionContGastosGenerales.setImcTipoMovim("C");

                    SiiCuentasContables siiCuentasContablesTercero =
                        cuentasContablesDao.buscarPorCodigo(siiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                    //validaciones

                    if (siiCuentasContablesTercero.getCcoObligaTerc().equals("S")) {
                        siiImputacionContGastosGenerales.setSiiPersona(siiPersona);
                    }
                    if (siiCuentasContablesTercero.getCcoNumDocConta().equals("S"))
                        siiImputacionContGastosGenerales.setSiiDocumentoContable(insertSiiDocumentoContableTpe);
                    if (siiCuentasContablesTercero.getCcoFteFinanc().equals("S")) {
                        SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDao.buscarPorCodigo("RNG");
                        siiImputacionContGastosGenerales.setSiiFuenteFinancContab(siiFuenteFinancContab);
                    }
                    if (siiCuentasContablesTercero.getCcoReferencia1().equals("S"))
                        siiImputacionContGastosGenerales.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());


                    siiImputacionContGastosGenerales.setImcDescrOperacion("TRANSLADO A PAGADURIA ENTIDAD");
                    siiImputacionContGastosGenerales.setImcValor(ordenPagoVo.getValorGasto());
                    siiImputacionContGastosGenerales.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContGastosGenerales);

                }

                //IMPUTACION 2
                SiiImputacionContable siiImputacionContGastosGen = new SiiImputacionContable();
                SiiCuentasContables siiCuentasContab =
                    cuentasContablesDao.BuscarCuentaContableXCuentaBancaria(ordenPagoVo.getCuentaBancariaVo().getCbaCodigo());
                siiImputacionContGastosGen.setSiiCuentasContables(siiCuentasContab);
                siiImputacionContGastosGen.setImcTipoMovim("D");
                siiImputacionContGastosGen.setSiiPersona(siiPersona);
                siiImputacionContGastosGen.setSiiDocumentoContable(insertSiiDocumentoContableTpe);
                SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDao.buscarPorCodigo("RNP");
                siiImputacionContGastosGen.setSiiFuenteFinancContab(siiFuenteFinancContab);
                siiImputacionContGastosGen.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());

                siiImputacionContGastosGen.setImcDescrOperacion("TRANSLADO A PAGADURIA ENTIDAD");
                siiImputacionContGastosGen.setImcValor(ordenPagoVo.getValorGasto());
                siiImputacionContGastosGen.setImcEstado("A");
                imputacionContableDao.insertarImputacionContable(siiImputacionContGastosGen);
            }

        }

        OrdenPagoVO retorno = new OrdenPagoVO(siiOrdenPagoVO);
        return retorno;

    }

    
    
    
    /**
     * Valida la correspondencia del Tipo de Gasto de la Orden de Pago con la Fuente de Financiaci&oacute;n Contable.
     * @param orpTipoGasto - Tipo de Gasto de la Orden de Pago.
     * @param ffcCodigo - Fuente de Financiaci&oacute;n Contable
     * @return ¿dupla valida?
     */
    private boolean validarTipoGastoConFFC (String orpTipoGasto, String ffcCodigo) 
    {
        return ( (EnumTipoGastoOrdenPago.GASTOS_GENERALES.getId().equals(orpTipoGasto) && EnumFuenteFinancContab.RECURSOS_NACION_GENERALES.getId().equals(ffcCodigo) ) || 
                 (EnumTipoGastoOrdenPago.GASTOS_PERSONAL.getId().equals(orpTipoGasto) && EnumFuenteFinancContab.RECURSOS_NACION_PERSONALES.getId().equals(ffcCodigo) ) || 
                 (EnumTipoGastoOrdenPago.RECURSOS_PROPIOS.getId().equals(orpTipoGasto) && EnumFuenteFinancContab.RECURSOS_PROPIOS_ENTIDAD.getId().equals(ffcCodigo) ) || 
                 (EnumTipoGastoOrdenPago.RECURSOS_PROPIOS.getId().equals(orpTipoGasto) && EnumFuenteFinancContab.RECURSOS_CONTROL_ILEGALIDAD.getId().equals(ffcCodigo) ) || 
                 (EnumTipoGastoOrdenPago.GASTOS_GENERALES.getId().equals(orpTipoGasto) && EnumFuenteFinancContab.RECURSOS_NACION_TRANSFERENCIAS.getId().equals(ffcCodigo) ) 
        );
    }
    
    
    
    public List<OrdenPagoVO> confirmarOrdenPago(List<OrdenPagoVO> listaOrdenPagoVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        for (OrdenPagoVO ordenPagoVo : listaOrdenPagoVo) {
            SiiOrdenPago siiOrdenPagoVO = conversionVoEntidad.convertir(ordenPagoVo);
            siiOrdenPagoVO = ordenPagoDAO.actualizarSiiOrdenPago(siiOrdenPagoVO);
            String nombreEstado = "BORRADOR";
            SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
            List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont = new ArrayList<SiiCuentaContTipoDocCont>();
            List<SiiObligacionConcepto> listaSiiObligacionConcepto = new ArrayList<SiiObligacionConcepto>();
            BigDecimal temp= new BigDecimal (0);
            
            //insertar log 
            if(ordenPagoVo.getEstadoOrdenPagoVo().getEopCodigo() != null){
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ORDEN_DE_PAGO.getId(), ordenPagoVo.getEstadoOrdenPagoVo().getEopCodigo(), usuarioLogueado,ordenPagoVo.getOrpCodigo());
            }

            if (ordenPagoVo.getOrpPagDestFinal().equals("N")) {
                Integer consecutivo = documentoContableDao.buscarConsecutivoDocumentoContable("PPR");

                //Movimiento contable
                SiiDocumentoContable insertSiiDocumentoContable = new SiiDocumentoContable();

                SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo("PPR");
                insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                insertSiiDocumentoContable.setDcoFechaOper(ordenPagoVo.getOrpFecha());
                insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                insertSiiDocumentoContable.setSiiOrdenPago(siiOrdenPagoVO);
                SiiObligacion siiObligacion = conversionVoEntidad.convertir(ordenPagoVo.getObligacionVo());
                //insertSiiDocumentoContable.setSiiObligacion(siiObligacion);
                insertSiiDocumentoContable = documentoContableDao.insertar(insertSiiDocumentoContable);

                //Imputacion Contable
                listaSiiObligacionConcepto =
                    obligacionConceptoDao.buscarPorCodigoObligacion(ordenPagoVo.getObligacionVo().getOblCodigo());
                for (SiiObligacionConcepto unaSiiObligacionConcepto : listaSiiObligacionConcepto) {
                    SiiImputacionContable siiImputacionContble = new SiiImputacionContable();

                    SiiCuentasContables siiCuentasContab =
                        cuentasContablesDao.BuscarCuentaContableXCuentaBancaria(ordenPagoVo.getCuentaBancariaVo().getCbaCodigo());
                    siiImputacionContble.setSiiCuentasContables(unaSiiObligacionConcepto.getSiiConceptoGasto().getSiiCuentasContablesCred());
                    siiImputacionContble.setImcTipoMovim("D");

                    SiiCuentasContables siiCuentasContable =
                        cuentasContablesDao.buscarPorCodigo(siiCuentasContab.getCcoCodigo());
                    //validaciones

                    if (siiCuentasContable.getCcoObligaTerc().equals("S")) {
                        SiiPersona siiPersonat =
                            conversionVoEntidad.convertir(ordenPagoVo.getBeneficiario().getPersonaVo());
                        siiImputacionContble.setSiiPersona(siiPersonat);
                    }
                    if (siiCuentasContable.getCcoNumDocConta().equals("S"))
                        siiImputacionContble.setSiiDocumentoContable(insertSiiDocumentoContable);
                    if (siiCuentasContable.getCcoFteFinanc().equals("S"))
                        siiImputacionContble.setSiiFuenteFinancContab(unaSiiObligacionConcepto.getSiiFuenteFinancContab());
                    if (siiCuentasContable.getCcoReferencia1().equals("S"))
                        siiImputacionContble.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());
                    if (siiCuentasContable.getCcoReferencia2().equals("S"))
                        siiImputacionContble.setImcReferencia2(ordenPagoVo.getNumeroRP().toString());

                    siiImputacionContble.setImcDescrOperacion("PAGO FACTURA ||" +
                                                              ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                    temp=(unaSiiObligacionConcepto.getOcoSubtotal().add(unaSiiObligacionConcepto.getOcoIva()))
                                                      .subtract(unaSiiObligacionConcepto.getOcoValorRenta()).subtract(unaSiiObligacionConcepto.getOcoValorIva()).subtract(unaSiiObligacionConcepto.getOcoValorIca());
                    
                    
                    siiImputacionContble.setImcValor(Utilidades.redondear (temp, 0) );
                    siiImputacionContble.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContble);

                }


                //si el valor pagado fue por gastos de Personal
                if (ordenPagoVo.getValorGasto().compareTo(BigDecimal.ZERO) > 0 &&
                    ordenPagoVo.getIndicadorPago().equals("GP")) {
                    List<SiiCuentaContTipoDocCont> listaSiiCuentaContble = new ArrayList<SiiCuentaContTipoDocCont>();
                    listaSiiCuentaContble = detalleRecaudoDao.BuscarCuentaContTipoDocContFuenteFinSinTercero("PPR","RNP");
                    for (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont : listaSiiCuentaContble) {
                        SiiImputacionContable siiImputacionContbleGastos = new SiiImputacionContable();

                        siiImputacionContbleGastos.setSiiCuentasContables(siiCuentaContTipoDocCont.getSiiCuentasContables());
                        siiImputacionContbleGastos.setImcTipoMovim("C");


                        SiiCuentasContables siiCuentasContable =
                            cuentasContablesDao.buscarPorCodigo(siiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                        //validaciones

                        if (siiCuentasContable.getCcoObligaTerc().equals("S")) {
                            SiiPersona siiPersonat =
                                conversionVoEntidad.convertir(ordenPagoVo.getBeneficiario().getPersonaVo());
                            siiImputacionContbleGastos.setSiiPersona(siiPersonat);

                        }
                        if (siiCuentasContable.getCcoNumDocConta().equals("S")) {
                            siiImputacionContbleGastos.setSiiDocumentoContable(insertSiiDocumentoContable);

                        }
                        if (siiCuentasContable.getCcoFteFinanc().equals("S")) {
                            siiImputacionContbleGastos.setSiiFuenteFinancContab(siiCuentaContTipoDocCont.getSiiFuenteFinancContab());
                        }
                        if (siiCuentasContable.getCcoReferencia1().equals("S")) {
                            siiImputacionContbleGastos.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());

                        }
                        if (siiCuentasContable.getCcoCentroCost().equals("S")) {
                            siiImputacionContbleGastos.setSiiAreaColjuegos(siiCuentaContTipoDocCont.getSiiAreaColjuegos());
                        }

                        siiImputacionContbleGastos.setImcDescrOperacion("PAGO FACTURA ||" +
                                                                        ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                        siiImputacionContbleGastos.setImcValor(ordenPagoVo.getValorGasto());
                        siiImputacionContbleGastos.setImcEstado("A");
                        imputacionContableDao.insertarImputacionContable(siiImputacionContbleGastos);


                    }


                }

                //si el valor pagado fue por gastos Generales
                if (ordenPagoVo.getValorGasto().compareTo(BigDecimal.ZERO) > 0 &&
                    ordenPagoVo.getIndicadorPago().equals("GG")) {
                    List<SiiCuentaContTipoDocCont> listaSiiCuentaContble = new ArrayList<SiiCuentaContTipoDocCont>();
                    listaSiiCuentaContble = detalleRecaudoDao.BuscarCuentaContTipoDocContFuenteFinSinTercero("PPR","RNG");
                    for (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont : listaSiiCuentaContble) {
                        SiiImputacionContable siiImputacionContbleGastos = new SiiImputacionContable();

                        siiImputacionContbleGastos.setSiiCuentasContables(siiCuentaContTipoDocCont.getSiiCuentasContables());
                        siiImputacionContbleGastos.setImcTipoMovim("C");

                        SiiCuentasContables siiCuentasContable =
                            cuentasContablesDao.buscarPorCodigo(siiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                        //validaciones

                        if (siiCuentasContable.getCcoObligaTerc().equals("S")) {
                            SiiPersona siiPersonat =
                                conversionVoEntidad.convertir(ordenPagoVo.getBeneficiario().getPersonaVo());
                            siiImputacionContbleGastos.setSiiPersona(siiPersonat);
                        }
                        if (siiCuentasContable.getCcoNumDocConta().equals("S"))
                            siiImputacionContbleGastos.setSiiDocumentoContable(insertSiiDocumentoContable);
                        if (siiCuentasContable.getCcoFteFinanc().equals("S"))
                            siiImputacionContbleGastos.setSiiFuenteFinancContab(siiCuentaContTipoDocCont.getSiiFuenteFinancContab());
                        if (siiCuentasContable.getCcoReferencia1().equals("S"))
                            siiImputacionContbleGastos.setImcReferencia1(ordenPagoVo.getNumeroDocCobro());
                        if (siiCuentasContable.getCcoCentroCost().equals("S")) {
                            siiImputacionContbleGastos.setSiiAreaColjuegos(siiCuentaContTipoDocCont.getSiiAreaColjuegos());
                        }

                        siiImputacionContbleGastos.setImcDescrOperacion("PAGO FACTURA ||" +
                                                                        ordenPagoVo.getBeneficiario().getPersonaVo().getNombreCompleto());
                        siiImputacionContbleGastos.setImcValor(ordenPagoVo.getValorGasto());
                        siiImputacionContbleGastos.setImcEstado("A");
                        imputacionContableDao.insertarImputacionContable(siiImputacionContbleGastos);
                    }


                }


            }

        }


        return listaOrdenPagoVo;

    }


    public List<OrdenPagoVO> buscarTodoSiiOrdenPagoCuentarPagar() throws ExcepcionDAO {
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarTodoSiiOrdenPagoCuentarPagar();

        List<OrdenPagoVO> listaOrdenPagoVo = new ArrayList();
        SiiEstadoOrdenPago siiEstadoOrdenPago = new SiiEstadoOrdenPago();
        for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
            siiEstadoOrdenPago = estadoOrdenPagoDao.buscarEstadoOrdenPagoPorId(unaOrdenPago.getSiiEstadoOrdenPago().getEopCodigo());
            unaOrdenPago.setSiiEstadoOrdenPago(siiEstadoOrdenPago);
            listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
        }
        return listaOrdenPagoVo;
    }


    public List<OrdenPagoVO> buscarOrdenPagoPorObligacion(Long oblCodigo) throws ExcepcionDAO {
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarOrdenPagoPorObligacion(oblCodigo);

        List<OrdenPagoVO> listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
        for (SiiOrdenPago opVo : listaOrdenPago) {
            listaOrdenPagoVo.add(new OrdenPagoVO(opVo));
        }
        return listaOrdenPagoVo;
    }


    public List<OrdenPagoVO> buscarOrdenPagoPorObligacionTipoGasto(Long oblCodigo,
                                                                   String orpTipoGasto) throws ExcepcionDAO {
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarOrdenPagoPorObligacionTipoGasto(oblCodigo, orpTipoGasto);

        List<OrdenPagoVO> listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
        for (SiiOrdenPago opVo : listaOrdenPago) {
            listaOrdenPagoVo.add(new OrdenPagoVO(opVo));
        }
        return listaOrdenPagoVo;
    }

    public List<OrdenPagoVO> buscarTodoSiiOrdenPagoNoPresupuestal() throws ExcepcionDAO {

        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarTodoSiiOrdenPagoNoPresupuestal();
        List<OrdenPagoVO> listaOrdenPagoVo = new ArrayList();

        for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
            listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
        }

        return listaOrdenPagoVo;
    }


    /**
     * Almacena la informaci&oacute;n de las Ordenes de Pago suministradas, una a una.
     * @param listaOrdenesPago
     */
    public void persistirOrdenesPago(List<OrdenPagoVO> listaOrdenesPago) throws Exception {
        if (listaOrdenesPago != null) {

            for (OrdenPagoVO ordenPagoVo : listaOrdenesPago) {
                if (ordenPagoVo != null) {

                    // verificar si la Orden de Pago ya existe en base de datos
                    OrdenPagoVO temp = null;
                    if (ordenPagoVo.getOrpCodigo() != null)
                        temp = this.buscarOrdenPagoPorCodigo(ordenPagoVo.getOrpCodigo());

                    if (temp != null && temp.getOrpCodigo() != null) {
                        // ACTUALIZAR la Orden de Pago junto a sus entidades hijas
                        this.actualizarOrdenPago(ordenPagoVo, true);
                    } else {
                        // INSERTAR la Orden de Pago junto a sus entidades hijas
                        this.insertarOrdenPago(ordenPagoVo, true);
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de las Ordenes de Pago suministradas, una a una, junto a su Movimiento Contable.
     * @param listaOrdenesPago
     */
    public void actualizarOrdenesPagoMovimientoContable (List<OrdenPagoVO> listaOrdenesPago) throws Exception {
        if (listaOrdenesPago != null) {

            for (OrdenPagoVO ordenPagoVo : listaOrdenesPago) {
                if (ordenPagoVo != null) {
                    this.actualizarOrdenPagoMovimientoContable(ordenPagoVo);
                }
            }
        }
    }
    
    

    public List<OrdenPagoVO> buscarOrdenPagoPorEstado(Long eopCodigo) throws ExcepcionDAO {
        List<OrdenPagoVO> listaOrdenPagoVo = null;
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarOrdenPagoPorEstado(eopCodigo);

        if (listaOrdenPago != null) {
            listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
            for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
                if (unaOrdenPago != null)
                    listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
            }
        }

        return listaOrdenPagoVo;
    }

    public List<OrdenPagoVO> buscarOrdenPagoPorTipoDocContable(String tdcCodigo) throws ExcepcionDAO {
        List<OrdenPagoVO> listaOrdenPagoVo = null;
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarOrdenPagoPorTipoDocContable(tdcCodigo);

        if (listaOrdenPago != null) {
            listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
            for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
                if (unaOrdenPago != null)
                    listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
            }
        }

        return listaOrdenPagoVo;
    }
    
    
    @Override
    public List<OrdenPagoVO> buscarOrdenPagoPorTipoDocContableYEstado (String tdcCodigo, Long eopCodigo) throws ExcepcionDAO {
        List<OrdenPagoVO> listaOrdenPagoVo = null;
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarOrdenPagoPorTipoDocContableYEstado(tdcCodigo, eopCodigo);

        if (listaOrdenPago != null) {
            listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
            for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
                if (unaOrdenPago != null)
                    listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
            }
        }

        return listaOrdenPagoVo;
    }
    
    
    public List<OrdenPagoVO> buscarOrdenPagoPorTipoDocContableObligacion (String tdcCodigo) throws ExcepcionDAO {
        List<OrdenPagoVO> listaOrdenPagoVo = null;
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarOrdenPagoPorTipoDocContableObligacion(tdcCodigo);

        if (listaOrdenPago != null) {
            listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
            for (SiiOrdenPago unaOrdenPago : listaOrdenPago) {
                if (unaOrdenPago != null)
                    listaOrdenPagoVo.add(new OrdenPagoVO(unaOrdenPago));
            }
        }

        return listaOrdenPagoVo;
    }
    
    
    public OrdenPagoVO buscarOrdenPagoPorConsecutivoYTipoDocContable (Integer orpConsecutivo, String tdcCodigo) throws ExcepcionDAO {
        OrdenPagoVO ordenPagoVo = null;
        SiiOrdenPago siiOrdenPago = ordenPagoDAO.buscarOrdenPagoPorConsecutivoYTipoDocContable(orpConsecutivo, tdcCodigo);
        if (siiOrdenPago!=null)
            ordenPagoVo = new OrdenPagoVO(siiOrdenPago);
        
        return (ordenPagoVo);
    }
    
    

    /**
     * @author Giovanni
     * @param codOrdenPago
     * @return
     * @throws ExcepcionDAO
     */
    public OrdenPagoVO imprimirOrdenPagoPorCodigo(Long codOrdenPago) throws ExcepcionDAO {
        SiiOrdenPago siiOrdenPago = new SiiOrdenPago();
        siiOrdenPago = ordenPagoDAO.buscarOrdenPagoPorCodigo(codOrdenPago);
        OrdenPagoVO ordenPagoVO = new OrdenPagoVO(siiOrdenPago);

        /*
         * Consultamos el documento contable para esta orden de pago
         */
        List<SiiDocumentoContable> siiDocumentoContables = new ArrayList<SiiDocumentoContable>();
        siiDocumentoContables = documentoContableDao.buscarPorCodigoOrdenPago(ordenPagoVO.getOrpCodigo());
        if (siiDocumentoContables != null && !siiDocumentoContables.isEmpty()) {
            ordenPagoVO.setDocumentoContable(new DocumentoContableVO(siiDocumentoContables.get(0)));

            /*
         * Consultamos las imputaciones contables para este documento contable de la orden de pago
         */
            List<SiiImputacionContable> siiImputacionContables = new ArrayList<SiiImputacionContable>();
            siiImputacionContables =
                imputacionContableDao.buscarPorCodigoDocumentoContable(ordenPagoVO.getDocumentoContable().getDcoCodigo());

            ordenPagoVO.getDocumentoContable().setImputacionContableList(new ArrayList<ImputacionContableVO>());
            for (SiiImputacionContable siiImputacionContable : siiImputacionContables) {
                ImputacionContableVO imputacionContableVO = new ImputacionContableVO(siiImputacionContable);
                ordenPagoVO.getDocumentoContable().getImputacionContableList().add(imputacionContableVO);
            }
        }

        /*
         *Consultamos la solicitud de pago para la obligacion correspondiente para esta orden de pago
         */
        if (ordenPagoVO.getObligacionVo() != null) {
            SiiObligacion siiObligacion = new SiiObligacion();
            siiObligacion = obligacionDAO.buscarPorCodigo(ordenPagoVO.getObligacionVo().getOblCodigo());
            if (siiObligacion != null) {
                ObligacionVO obligacionVO = new ObligacionVO(siiObligacion);
                ordenPagoVO.setObligacionVo(obligacionVO);

                //Solicitud Pago
                if (ordenPagoVO.getObligacionVo().getSiiSolicitudPago() != null) {
                    SiiSolicitudPago siiSolicitudPago = new SiiSolicitudPago();
                    siiSolicitudPago = solicitudPagoDao.buscarSolicitudPagoPorId(ordenPagoVO.getObligacionVo().getSiiSolicitudPago().getSpaCodigo());
                    SolicitudPagoVO solicitudPagoVO = new SolicitudPagoVO(siiSolicitudPago);
                    ordenPagoVO.getObligacionVo().setSiiSolicitudPago(solicitudPagoVO);

                    /*
                     * Proveedor beneficiario por RP
                     */
                    //Obligacion
                    if (ordenPagoVO.getObligacionVo().getSiiSolicitudPago().getRpVo() != null) {
                        SiiRp siiRp = new SiiRp();
                        siiRp = rpDAO.buscarPorCodigoRp(ordenPagoVO.getObligacionVo().getSiiSolicitudPago().getRpVo().getRpCodigo());
                        RpVO rpVO = new RpVO(siiRp);
                        ordenPagoVO.getObligacionVo().getSiiSolicitudPago().setRpVo(rpVO);

                        //Obligacion
                        if (ordenPagoVO.getObligacionVo().getSiiSolicitudPago().getRpVo().getProveedorVo() != null) {
                            SiiProveedor siiProveedor = new SiiProveedor();
                            siiProveedor = proveedorDAO.buscarProveedorPorId(ordenPagoVO.getObligacionVo().getSiiSolicitudPago().getRpVo().getProveedorVo().getProCodigo());
                            ProveedorVO proveedorVO = new ProveedorVO(siiProveedor);
                            ordenPagoVO.getObligacionVo().getSiiSolicitudPago().getRpVo().setProveedorVo(proveedorVO);
                        }
                    }
                }
            }


            /*
             * Consulta persona para nomina funcionarios planta
             */
            List<SiiDetalleContNomina> siiDetalleContNominas = new ArrayList<SiiDetalleContNomina>();
            siiDetalleContNominas =
                detalleContNominaDAO.buscarPorCodigoObligacion(ordenPagoVO.getObligacionVo().getOblCodigo());
            ordenPagoVO.getObligacionVo().setDetalleContNominaList(new ArrayList<DetalleContNominaVO>());
            if (siiDetalleContNominas != null && !siiDetalleContNominas.isEmpty()) {
                for (SiiDetalleContNomina siiDetalleContNomina : siiDetalleContNominas) {
                    DetalleContNominaVO detalleContNominaVO = new DetalleContNominaVO(siiDetalleContNomina);
                    ordenPagoVO.getObligacionVo().getDetalleContNominaList().add(detalleContNominaVO);
                }
            }
        }

        /*
         * Consultamos las No presupuestales
         */
        if (ordenPagoVO.getObligacionNoPresupVo() != null) {
            SiiObligacionNoPresup siiObligacionNoPresup = new SiiObligacionNoPresup();
            siiObligacionNoPresup = obligacionNoPresupDAO.buscarPorCodigoObligacionNoPres(ordenPagoVO.getObligacionNoPresupVo().getOnpCodigo());
            if (siiObligacionNoPresup != null) {
                ObligacionNoPresupVO obligacionNoPresupVO = new ObligacionNoPresupVO(siiObligacionNoPresup);
                obligacionNoPresupVO.setImpContabOblNoPresListVo(new ArrayList<ImpContabOblNoPresVO>());
                List<SiiImpContabOblNoPres> siiImpContabOblNoPress = new ArrayList<SiiImpContabOblNoPres>();
                siiImpContabOblNoPress =
                    impContabOblNoPresDAO.buscarImputaContableNoPresPorIdObligacion(obligacionNoPresupVO.getOnpCodigo());

                for (SiiImpContabOblNoPres siiImpContabOblNoPres : siiImpContabOblNoPress) {
                    ImpContabOblNoPresVO impContabOblNoPresVO = new ImpContabOblNoPresVO(siiImpContabOblNoPres);
                    obligacionNoPresupVO.getImpContabOblNoPresListVo().add(impContabOblNoPresVO);
                }

                ordenPagoVO.setObligacionNoPresupVo(obligacionNoPresupVO);
            }
        }

        return ordenPagoVO;
    }
    
    
    @Override
    public List<OrdenPagoVO> buscarOrdenPagoPorObligacionFFC (Long oblCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        List<OrdenPagoVO> listaOrdenPagoVo = null;
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarOrdenPagoPorObligacionFFC(oblCodigo, ffcCodigo);
        
        if (listaOrdenPago!=null) {
            listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
            for (SiiOrdenPago siiOrdenPago : listaOrdenPago) {
                if (siiOrdenPago!=null)
                    listaOrdenPagoVo.add(new OrdenPagoVO(siiOrdenPago));
            }
        }
        
        return (listaOrdenPagoVo);
    }
    
    
    @Override
    public List<OrdenPagoVO> buscarOrdenPagoPorRangoPaginacion (Integer first, Integer last, String sortField, String sortOrder) throws ExcepcionDAO {
        List<OrdenPagoVO> listaOrdenPagoVo = null;
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarOrdenPagoPorRangoPaginacion(first, last, sortField, sortOrder);
        
        if (listaOrdenPago!=null) {
            listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
            for (SiiOrdenPago siiOrdenPago : listaOrdenPago) {
                if (siiOrdenPago!=null)
                    listaOrdenPagoVo.add(new OrdenPagoVO(siiOrdenPago));
            }
        }
        
        return (listaOrdenPagoVo);
    }
    
    
    @Override
    public List<OrdenPagoVO> buscarOrdenPagoPorRangoPaginacion (String tdcCodigo, Integer first, Integer last, String sortField, String sortOrder) throws ExcepcionDAO {
        List<OrdenPagoVO> listaOrdenPagoVo = null;
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarOrdenPagoPorRangoPaginacion(tdcCodigo, first, last, sortField, sortOrder);
        
        if (listaOrdenPago!=null) {
            listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
            for (SiiOrdenPago siiOrdenPago : listaOrdenPago) {
                if (siiOrdenPago!=null)
                    listaOrdenPagoVo.add(new OrdenPagoVO(siiOrdenPago));
            }
        }
        
        return (listaOrdenPagoVo);
    }
    
    
    @Override
    public List<OrdenPagoVO> buscarPorFiltros (Map<String,Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO {
        List<OrdenPagoVO> listaOrdenPagoVo = null;
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarPorFiltros(filtros, sortField, sortOrder);
        
        if (listaOrdenPago!=null) {
            listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
            for (SiiOrdenPago siiOrdenPago : listaOrdenPago) {
                if (siiOrdenPago!=null)
                    listaOrdenPagoVo.add(new OrdenPagoVO(siiOrdenPago));
            }
        }
        
        return (listaOrdenPagoVo);
    }
    
    
    @Override
    public List<OrdenPagoVO> buscarPorFiltros (String tdcCodigo, Map<String,Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO {
        List<OrdenPagoVO> listaOrdenPagoVo = null;
        List<SiiOrdenPago> listaOrdenPago = ordenPagoDAO.buscarPorFiltros(tdcCodigo, filtros, sortField, sortOrder);
        
        if (listaOrdenPago!=null) {
            listaOrdenPagoVo = new ArrayList<OrdenPagoVO>();
            for (SiiOrdenPago siiOrdenPago : listaOrdenPago) {
                if (siiOrdenPago!=null)
                    listaOrdenPagoVo.add(new OrdenPagoVO(siiOrdenPago));
            }
        }
        
        return (listaOrdenPagoVo);
    }
    
    
    @Override
    public Integer obtenerRowCount () throws ExcepcionDAO {
        return ( ordenPagoDAO.obtenerRowCount() );
    }
    
    
    @Override
    public Integer obtenerRowCount (String tdcCodigo) throws ExcepcionDAO {
        return ( ordenPagoDAO.obtenerRowCount(tdcCodigo) );
    }
}
