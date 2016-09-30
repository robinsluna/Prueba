package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumConceptoCuota;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoCuotaOperador;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoProcSanIleg;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoTramResProcIleg;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoCartera;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDecisionResolucion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocSopCuotaOperador;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoMovimiento;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogGeneral;
import co.gov.coljuegos.siicol.ejb.negocio.ryt.AdminConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ComunicResolPersIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoProcesoIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcSanIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTramResProcIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaInvestProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoSancIlegalidadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionProcIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvestProIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancIlegalidad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionProcIleg;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProIle;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.AutoDecretaPrueProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.AutoFormCargProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.ComunicResolPersIleVO;
import co.gov.coljuegos.siicol.ejb.vo.ComunicacSujSancIleVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.DescargoProcIlegVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoProcesoIleVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaInvestProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoSancIlegalidadVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionProcIlegVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;


@Stateless
public class AdminProcesoSancIlegalidadBean implements AdminProcesoSancIlegalidad 
{
    /** T&acute;tulo que se asociar&aacute; en los Logs. */
    private final String TITULO_APLICACION = "Proceso Sancionatorio Ilegalidad";
    
    
    
    @EJB
    private ProcesoSancIlegalidadDAO procesoSancIlegalidadDao;
    @EJB
    private AdminPersonaInvestProIle adminPersonaInvestProIle;
    @EJB
    private TipoDocContableDAO tipoDocContableDao;
    @EJB
    private DocumentoContableDAO documentoContableDao;
    @EJB
    private EstadoDocContabDAO estadoDocContabDao;
    @EJB
    private DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ImputacionContableDAO imputacionContableDao;
    @EJB
    private TramiteResolProIleDAO tramiteResolProIleDao;
    @EJB
    private AdminConceptoCuota adminConceptoCuota;
    @EJB
    private ResolucionProcIlegDAO resolucionProcIlegDao;
    @EJB
    private AdminAutoFormCargProIle adminAutoFormCargProIle;
    @EJB
    private ElementoProcesoIleDAO elementoProcesoIleDao;
    @EJB
    private ComunicResolPersIleDAO comunicResolPersIleDao;
    @EJB
    private EstadoTramResProcIlegDAO estadoTramResProcIlegDao;
    @EJB
    private EstadoProcSanIlegDAO estadoProcSanIlegDao;
    @EJB
    private AdminAutoDecretaPrueProIle adminAutoDecretaPrueProIle;
    @EJB
    private AdminDescargoProcIleg adminDescargoProcIleg;
    @EJB
    PersonaInvestProIleDAO personaInvestProIleDao;
    @EJB
    private AdminElementoProcesoIle adminProcesoElementoIle;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private AdminComunicacSujSancIle adminComunicacSujSancIle;
    @EJB
    private CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    private AdminLogGeneral adminLogGeneral;
    @EJB
    private AdminResolucionProcIleg adminResolucionProcIleg;


    ////////////////////////////////////////////////
    // Listas para eliminacion de entidades hijas //
    ////////////////////////////////////////////////
    private List<ElementoProcesoIleVO> listaElementoProcesoIleEliminar;


    /**
     * Constructor.
     */
    public AdminProcesoSancIlegalidadBean() {
        super();
    }
    
    
    
    /**
     * Imprime un mensaje en la bandeja de notificaciones de Log.
     * @param tituloLog - T&iacute;tulo del mensaje de Log.
     * @param mensaje - Mensaje a imprimir.
     * @param usuarioVo - Usuario que genera el Log.
     */
    private void imprimirLog (String tituloLog, String mensaje, UsuarioVO usuarioVo) 
    {
        if (tituloLog!=null && usuarioVo!=null)
            adminLogGeneral.log(tituloLog, mensaje, usuarioVo);
        else
            System.err.println(mensaje);
    }
    
    

    public ProcesoSancIlegalidadVO buscarProcSancIlegalidadPorCodigo(Long prsCodigo) throws ExcepcionDAO {
        ProcesoSancIlegalidadVO procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO();
        procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(procesoSancIlegalidadDao.buscarPorCodigo(prsCodigo));
        return procesoSancIlegalidadVo;
    }

    public List<ProcesoSancIlegalidadVO> buscarTodoProcesoSancIlegalidad() throws ExcepcionDAO {
        List<ProcesoSancIlegalidadVO> listaProcesoSancIlegalidadVo = null;
        List<SiiProcesoSancIlegalidad> listaProcesoSancIlegalidad = procesoSancIlegalidadDao.buscarTodo();
        if(listaProcesoSancIlegalidad != null) {
            listaProcesoSancIlegalidadVo = new ArrayList<ProcesoSancIlegalidadVO>();
            for(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad : listaProcesoSancIlegalidad) {

                listaProcesoSancIlegalidadVo.add(new ProcesoSancIlegalidadVO(siiProcesoSancIlegalidad));
            }
        }

        return listaProcesoSancIlegalidadVo;
    }

    /**
     * Buscar todos los procesos sancionatorios de ilegalidad con datos de acción control y denuncia
     * @return listaProcesoSancIlegalidadVo - Listado de SiiProcesoSancIlegalidad.
     * @throws ExcepcionDAO
     */

    public List<ProcesoSancIlegalidadVO> buscarTodoProcesoSancIlegalidadConDenuncia() throws ExcepcionDAO {
        List<ProcesoSancIlegalidadVO> listaProcesoSancIlegalidadVo = null;
        List<SiiProcesoSancIlegalidad> listaProcesoSancIlegalidad = procesoSancIlegalidadDao.buscarTodoProcesoSancIlegalidadConDenuncia();
        if(listaProcesoSancIlegalidad != null) {
            listaProcesoSancIlegalidadVo = new ArrayList<ProcesoSancIlegalidadVO>();
            for(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad : listaProcesoSancIlegalidad) {

                listaProcesoSancIlegalidadVo.add(new ProcesoSancIlegalidadVO(siiProcesoSancIlegalidad));
            }
        }

        return listaProcesoSancIlegalidadVo;
    }

    /**
     * Obtener el consecutivo del proceso de ilegalidad
     * @return Integer - consecutivo
     * @throws ExcepcionDAO
     */

    public Integer obtenerConsecutivoProcesoSancIlegalidad() throws ExcepcionDAO {
        return procesoSancIlegalidadDao.obtenerConsecutivoProcesoSancIlegalidad();
    }

    public ProcesoSancIlegalidadVO insertarProcesoSancIlegalidad(ProcesoSancIlegalidadVO procesoSancIlegalidad) throws ExcepcionDAO {
        return new ProcesoSancIlegalidadVO(procesoSancIlegalidadDao.insertar(conversionVoEntidad.convertir(procesoSancIlegalidad)));
    }


    /**
     * Establece las listas hijas al value object resultante del almacenamiento de la entidad.
     * @param resultado - Value Object resultante.
     * @param procesoSancIlegalidadVo -  Value Object base.
     */

    private void asignarHijos(ProcesoSancIlegalidadVO resultado, ProcesoSancIlegalidadVO procesoSancIlegalidadVo) {
        if(resultado != null && procesoSancIlegalidadVo != null) {
            // establecer las listas a persistir
            resultado.setAutoDecretaPrueProIleListVo(procesoSancIlegalidadVo.getAutoDecretaPrueProIleListVo());
            resultado.setAutoFormCargProIleListVo(procesoSancIlegalidadVo.getAutoFormCargProIleListVo());
            resultado.setComunicacSujSancIleListVo(procesoSancIlegalidadVo.getComunicacSujSancIleListVo());
            resultado.setDescargoProcIlegListVo(procesoSancIlegalidadVo.getDescargoProcIlegListVo());
            resultado.setInhabilidadPersonaList(procesoSancIlegalidadVo.getInhabilidadPersonaList());
            resultado.setPersonaInvestProIleListVo(procesoSancIlegalidadVo.getPersonaInvestProIleListVo());
            resultado.setDenunciaVo(procesoSancIlegalidadVo.getDenunciaVo());
            resultado.setEstadoProcSanIlegVo(procesoSancIlegalidadVo.getEstadoProcSanIlegVo());
            resultado.setSustanciadorAuditorVo(procesoSancIlegalidadVo.getSustanciadorAuditorVo());
            resultado.setUsuarioConecVo(procesoSancIlegalidadVo.getUsuarioConecVo());
            resultado.setElementoProcesoIleListVo(procesoSancIlegalidadVo.getElementoProcesoIleListVo());
        }
    }

    /**
     * Guardar la persona investigada en la BD
     * @param procesoSancIlegalidadVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    private void persistirPersonaInvestProIle(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion {
        if(procesoSancIlegalidadVo != null) {
            List<PersonaInvestProIleVO> listaPersonaInvestProIle = procesoSancIlegalidadVo.getPersonaInvestProIleListVo();
            if(listaPersonaInvestProIle != null && !listaPersonaInvestProIle.isEmpty()) {
                for(PersonaInvestProIleVO peripVo : listaPersonaInvestProIle) {
                    if(peripVo != null) {
                        peripVo.setProcesoSancIlegalidadVo(procesoSancIlegalidadVo);

                        if(peripVo.getPipCodigo() == null) {
                            // OPERACION INSERTAR
                            adminPersonaInvestProIle.insertarPersonaInvestProIle(peripVo, cascade);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            adminPersonaInvestProIle.actualizarPersonaInvestProIle(peripVo, cascade);
                        }
                    }
                }
            }
        }
    }

    /**
     * Almacena la informaci&oacute;n del Auto de Formulaci&oacute;n de Cargos.
     * @param procesoSancIlegalidadVo - Proceso Sancionatorio de Ilegalidad.
     * @param cascade - Flag que determina si es requerido almacenar la informaci&oacute;n en Cascada.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirAutoFormCargProIle(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion {
        if(procesoSancIlegalidadVo != null) {
            List<AutoFormCargProIleVO> listaAutoFormCargProIle = procesoSancIlegalidadVo.getAutoFormCargProIleListVo();
            if(listaAutoFormCargProIle != null && !listaAutoFormCargProIle.isEmpty()) {
                for(AutoFormCargProIleVO afcVo : listaAutoFormCargProIle) {
                    if(afcVo != null) {
                        afcVo.setProcesoSancIlegalidadVo(procesoSancIlegalidadVo);

                        if(afcVo.getAfcCodigo() == null) {
                            // OPERACION INSERTAR
                            adminAutoFormCargProIle.insertarAutoFormCargProIle(afcVo, cascade);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            adminAutoFormCargProIle.actualizarAutoFormCargProIle(afcVo, cascade);
                        }
                    }
                }
            }
        }
    }


    /**
     * Almacena la informaci&oacute;n del Auto que Decreta Pruebas.
     * @param procesoSancIlegalidadVo - Proceso Sancionatorio de Ilegalidad.
     * @param cascade - Flag que determina si es requerido almacenar la informaci&oacute;n en Cascada.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirAutoDecretaPrueProIle(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion {
        if(procesoSancIlegalidadVo != null) {
            List<AutoDecretaPrueProIleVO> listaAutoDecretaPrueProIle = procesoSancIlegalidadVo.getAutoDecretaPrueProIleListVo();
            if(listaAutoDecretaPrueProIle != null && !listaAutoDecretaPrueProIle.isEmpty()) {
                for(AutoDecretaPrueProIleVO atpVo : listaAutoDecretaPrueProIle) {
                    if(atpVo != null) {
                        atpVo.setProcesoSancIlegalidadVo(procesoSancIlegalidadVo);

                        if(atpVo.getAtpCodigo() == null) {
                            // OPERACION INSERTAR
                            adminAutoDecretaPrueProIle.insertarAutoDecretaPrueProIle(atpVo, cascade);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            adminAutoDecretaPrueProIle.actualizarAutoDecretaPrueProIle(atpVo, cascade);
                        }
                    }
                }
            }
        }
    }


    /**
     * Almacena la informaci&oacute;n del Descargo del Proceso Sancionatorio de Ilegalidad.
     * @param procesoSancIlegalidadVo - Proceso Sancionatorio de Ilegalidad.
     * @param cascade - Flag que determina si es requerido almacenar la informaci&oacute;n en Cascada.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirDescargoProcIleg(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion {
        if(procesoSancIlegalidadVo != null) {
            List<DescargoProcIlegVO> listaDescargoProcIleg = procesoSancIlegalidadVo.getDescargoProcIlegListVo();
            if(listaDescargoProcIleg != null && !listaDescargoProcIleg.isEmpty()) {
                for(DescargoProcIlegVO dprVo : listaDescargoProcIleg) {
                    if(dprVo != null) {
                        dprVo.setProcesoSancIlegalidadVo(procesoSancIlegalidadVo);

                        if(dprVo.getDprCodigo() == null) {
                            // OPERACION INSERTAR
                            adminDescargoProcIleg.insertarDescargoProcIleg(dprVo, cascade);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            adminDescargoProcIleg.actualizarDescargoProcIleg(dprVo, cascade);
                        }
                    }
                }
            }
        }
    }


    /**
     * Almacena la informaci&oacute;n de los Elementos del Proceso Sancionatorio de Ilegalidad.
     * @param procesoSancIlegalidadVo - Proceso Sancionatorio de Ilegalidad.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirElementoProcesoIle(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) throws ExcepcionDAO, ExcepcionAplicacion {
        if(procesoSancIlegalidadVo != null) {
            List<ElementoProcesoIleVO> listaElementoProcesoIle = procesoSancIlegalidadVo.getElementoProcesoIleListVo();
            if(listaElementoProcesoIle != null && !listaElementoProcesoIle.isEmpty()) {
                for(ElementoProcesoIleVO eprVo : listaElementoProcesoIle) {
                    if(eprVo != null) {
                        eprVo.setProcesoSancIlegalidadVo(procesoSancIlegalidadVo);

                        if(eprVo.getEprCodigo() == null) {
                            // OPERACION INSERTAR
                            adminProcesoElementoIle.insertarElementoProcesoIle(eprVo);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            adminProcesoElementoIle.actualizarElementoProcesoIle(eprVo);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Persistir las comunicaciones para sujeto sancionable de ilegalidad
     * @param procesoSancIlegalidadVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    private void persistirComunicacSujSancIle(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) throws ExcepcionDAO, ExcepcionAplicacion {
        if(procesoSancIlegalidadVo != null) {
            List<ComunicacSujSancIleVO> listaComunicacSujSancIleVO = procesoSancIlegalidadVo.getComunicacSujSancIleListVo();
            if(listaComunicacSujSancIleVO != null && !listaComunicacSujSancIleVO.isEmpty()) {
                for(ComunicacSujSancIleVO cssiVo : listaComunicacSujSancIleVO) {
                    if(cssiVo != null) {
                        cssiVo.setProcesoSancIlegalidadVo(procesoSancIlegalidadVo);

                        if(cssiVo.getCssCodigo() == null) {
                            // OPERACION INSERTAR
                            adminComunicacSujSancIle.insertarComunicacSujSancIle(cssiVo);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            //TODO
                        }
                    }
                }
            }
        }
    }


    /**
     * Persiste las entidades hijas del Proceso Sancionatorio de Ilegalidad.
     * @param procesoSancIlegalidadVo - Proceso Sancionatorio de Ilegalidad.
     * @param cascade - Flag para determinar si se realizar&aacute; actualizaci&oacute;n en cascada.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirHijos(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        this.persistirPersonaInvestProIle(procesoSancIlegalidadVo, cascade);
        this.persistirAutoFormCargProIle(procesoSancIlegalidadVo, cascade);
        this.persistirAutoDecretaPrueProIle(procesoSancIlegalidadVo, cascade);
        this.persistirDescargoProcIleg(procesoSancIlegalidadVo, cascade);
        this.persistirElementoProcesoIle(procesoSancIlegalidadVo);
    }
    
    
    @Override
    public ProcesoSancIlegalidadVO insertarProcesoSancIlegalidad(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion {
        ProcesoSancIlegalidadVO resultado = null;
        SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = procesoSancIlegalidadDao.insertar(conversionVoEntidad.convertir(procesoSancIlegalidadVo));
        if(siiProcesoSancIlegalidad != null) {
            resultado = new ProcesoSancIlegalidadVO(siiProcesoSancIlegalidad);

            // eliminar entidades hijas pendientes por remover
            this.eliminarHijos();

            if(cascadeUpdate) {
                this.asignarHijos(resultado, procesoSancIlegalidadVo);
                this.persistirHijos(resultado, true);
            }else{
                if(procesoSancIlegalidadVo.getComunicacSujSancIleListVo()!=null && !procesoSancIlegalidadVo.getComunicacSujSancIleListVo().isEmpty()){
                    resultado.setComunicacSujSancIleListVo(procesoSancIlegalidadVo.getComunicacSujSancIleListVo());
                    this.persistirComunicacSujSancIle(resultado);
                }
            }
        }

        return (resultado);
    }


    @Override
    public ProcesoSancIlegalidadVO actualizarProcesoSancIlegalidad(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, boolean cascadeUpdate, boolean doComunicacionesResol) throws ExcepcionDAO,
                                                                                                                                                                                 ExcepcionAplicacion {
        ProcesoSancIlegalidadVO resultadoProcesoVo = null;
        List<ComunicResolPersIleVO> comunicacionesVo = null;
        if(doComunicacionesResol) {
            if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RESOLUCION_SIN_SANCION.getId())) {
                if(procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo() != null) {
                    comunicacionesVo = procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo().getComunicResolPersIleListVo();
                }
            }
            if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RESOLUCION_CON_SANCION.getId())) {
                if(procesoSancIlegalidadVo.getResolucionProcIlegResolVo() != null) {
                    comunicacionesVo = procesoSancIlegalidadVo.getResolucionProcIlegResolVo().getComunicResolPersIleListVo();
                }
            }
            if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RECURSO_REPOSICION.getId())) {
                if(procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo() != null) {
                    comunicacionesVo = procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo().getComunicResolPersIleListVo();
                }
            }
            if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RECURSO_APELACION.getId())) {
                if(procesoSancIlegalidadVo.getResolucionProcIlegApelaVo() != null) {
                    comunicacionesVo = procesoSancIlegalidadVo.getResolucionProcIlegApelaVo().getComunicResolPersIleListVo();
                }
            }

        }
        
        
        // Persistir las resoluciones que se asociaran al Proceso.
        this.persistirResoluciones(procesoSancIlegalidadVo);
        
        // Persistir el proceso junto a sus Resoluciones.
        SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = procesoSancIlegalidadDao.actualizar(conversionVoEntidad.convertir(procesoSancIlegalidadVo));

        if(siiProcesoSancIlegalidad != null) {
            resultadoProcesoVo = new ProcesoSancIlegalidadVO(siiProcesoSancIlegalidad);

            // eliminar entidades hijas pendientes por remover
            this.eliminarHijos();


            // Insertar Log de cambio de estado
            if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo() != null && procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo() != null &&
               !procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(procesoSancIlegalidadVo.getIdEstadoAnterior()) && procesoSancIlegalidadVo.getUsuarioConecVo() != null) {
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.PROCESO_SANCIONATORIO_ILEGALIDAD.getId(), procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo(),
                                                             procesoSancIlegalidadVo.getUsuarioConecVo(), resultadoProcesoVo.getPrsCodigo());
            }


            if(cascadeUpdate) {
                this.asignarHijos(resultadoProcesoVo, procesoSancIlegalidadVo);
                this.persistirHijos(resultadoProcesoVo, true);
            }
            if(doComunicacionesResol) {
                guardarComunicResolPersIle(procesoSancIlegalidadVo, comunicacionesVo);
            }


        }

        return (resultadoProcesoVo);
    }

    private void guardarComunicResolPersIle(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, List<ComunicResolPersIleVO> comunicacionesVo) throws ExcepcionDAO, ExcepcionAplicacion {

        if(comunicacionesVo != null) {
            for(ComunicResolPersIleVO comunicacionVo : comunicacionesVo) {
                if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RESOLUCION_SIN_SANCION.getId())) {
                    comunicacionVo.setResolucionProcIlegVo(procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo());
                }
                if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RESOLUCION_CON_SANCION.getId())) {
                    comunicacionVo.setResolucionProcIlegVo(procesoSancIlegalidadVo.getResolucionProcIlegResolVo());
                }
                if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RECURSO_APELACION.getId())) {
                    comunicacionVo.setResolucionProcIlegVo(procesoSancIlegalidadVo.getResolucionProcIlegApelaVo());
                }
                if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RECURSO_REPOSICION.getId())) {
                    comunicacionVo.setResolucionProcIlegVo(procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo());
                }

                if(comunicacionVo.getCorCodigo() == null) {
                    comunicResolPersIleDao.insertar(conversionVoEntidad.convertir(comunicacionVo));
                }
                else {
                    comunicResolPersIleDao.actualizar(conversionVoEntidad.convertir(comunicacionVo));
                }
            }
        }
        else {
            throw new ExcepcionAplicacion("Falta la lista de comunicaciones de la resolucion.");
        }

    }

    
    /**
     * <b>FLUJO 18</b>: MOVIMIENTO CONTABLE.
     * @param siiProcesoSancIlegalidad - Proceso Sancionatorio de Ilegalidad.
     * @param siiResolucionProcIleg - Resoluci&oacute;n que se desea asociar al Movimiento Contable.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public boolean generarMovimientoContable (SiiProcesoSancIlegalidad siiProcesoSancIlegalidad, SiiResolucionProcIleg siiResolucionProcIleg) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - generarMovimientoContable";
        
        boolean exitoso = false;
        
        
        if (siiProcesoSancIlegalidad!=null) {
            if (siiResolucionProcIleg!=null) {
                String numeroResolucion = siiResolucionProcIleg.getRpiNumeroResol();
                
                if (numeroResolucion!=null) {
                    BigDecimal valorTotalSancion = procesoSancIlegalidadDao.obtenerValorTotalSancionElementosProceso(siiProcesoSancIlegalidad.getPrsCodigo());
                    
                    if (valorTotalSancion!=null && valorTotalSancion.compareTo(BigDecimal.ZERO)>0) {
                    
                        Date fechaRegistro = new Date();
                        SiiDocumentoContable insertSiiDocContable = new SiiDocumentoContable();
                        SiiTipoDocContable unsiiTipoDocContable = tipoDocContableDao.buscarPorCodigo("MCI");
                        
                        if (unsiiTipoDocContable!=null) {
                            Integer unConsecutivo = documentoContableDao.buscarConsecutivoDocumentoContable("MCI");
                            
                            if (unConsecutivo!=null) {
                                insertSiiDocContable.setDcoNumeroCompr(unConsecutivo);
                                insertSiiDocContable.setDcoFechaOper(fechaRegistro);
                                insertSiiDocContable.setSiiProcesoSancIlegalidad(siiProcesoSancIlegalidad);
                                insertSiiDocContable.setSiiTipoDocContable(unsiiTipoDocContable);
                                SiiEstadoDocContab unSiiEstadoDocContab = estadoDocContabDao.buscarPorCodigo(EnumEstadoDocContab.BORRADOR.getId());
                                
                                if (unSiiEstadoDocContab!=null) {
                                    insertSiiDocContable.setSiiEstadoDocContab(unSiiEstadoDocContab);
                            
                                    //imputacion contable
                                    List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocContOtroSi = detalleRecaudoDao.BuscarCuentaContTipoDocContable(null, "MCI");
                                    
                                    if (listaSiiCuentaContTipoDocContOtroSi!=null && !listaSiiCuentaContTipoDocContOtroSi.isEmpty()) {
                                        
                                        List<SiiImputacionContable> listaImputaciones = new ArrayList<SiiImputacionContable>();
                                        
                                        BigDecimal sumaDebitos = BigDecimal.ZERO;
                                        BigDecimal sumaCreditos = BigDecimal.ZERO;
                                        
                                        for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont : listaSiiCuentaContTipoDocContOtroSi) {
                                            SiiImputacionContable siiImputacionCont = new SiiImputacionContable();
                                            SiiCuentasContables siiCuentasContables = unSiiCuentaContTipoDocCont.getSiiCuentasContables();
                                            
                                            if (siiCuentasContables!=null) {
                                                siiImputacionCont.setSiiCuentasContables(siiCuentasContables);
                                                
                                                //validaciones
                                                if(siiCuentasContables.getCcoObligaTerc().equals("S")) {
                                                    //primera persona investigada
                                                    List<SiiPersonaInvestProIle> listaPersonas = personaInvestProIleDao.buscarPersonasInvestPorProcesoIleId(siiProcesoSancIlegalidad.getPrsCodigo());
                                                    if (listaPersonas!=null && !listaPersonas.isEmpty()) {
                                                        SiiPersonaInvestProIle primeraPersonaInvest = listaPersonas.get(0);
                                                        if (primeraPersonaInvest!=null)
                                                            siiImputacionCont.setSiiPersona(primeraPersonaInvest.getSiiPersona());
                                                    }
                                                }
                                                if(siiCuentasContables.getCcoNumDocConta().equals("S")) {
                                                    siiImputacionCont.setSiiDocumentoContable(insertSiiDocContable);
                                                }
                                                if(siiCuentasContables.getCcoReferencia1().equals("S")) {
                                                    siiImputacionCont.setImcReferencia1(numeroResolucion);
                                                }
                                                if(siiCuentasContables.getCcoReferencia2().equals("S")) {
                                                    siiImputacionCont.setImcReferencia2("1");
                                                }
                                                siiImputacionCont.setImcDescrOperacion("MULTA POR PROCESOS DE CONTROL A OPERACIONES ILEGALES SEGÚN RESOLUCIÓN NO. " +numeroResolucion);
                                                
                                                String tipoMovimiento = unSiiCuentaContTipoDocCont.getCctTipoMovim();
                                                siiImputacionCont.setImcTipoMovim(tipoMovimiento);
                                                BigDecimal imcValor = valorTotalSancion;
                                                siiImputacionCont.setImcValor(imcValor);
                                                siiImputacionCont.setImcEstado("A");
                                                
                                                listaImputaciones.add(siiImputacionCont);
                                                
                                                
                                                if (EnumTipoMovimiento.DEBITO.getId().equals(tipoMovimiento))
                                                    sumaDebitos = sumaDebitos.add(imcValor);
                                                else if (EnumTipoMovimiento.CREDITO.getId().equals(tipoMovimiento))
                                                    sumaCreditos = sumaCreditos.add(imcValor);
                                            }
                                        }
                                        
                                        
                                        // Verificar que hayan sido adicionadas las Imputaciones Contables.
                                        if (listaImputaciones!=null && !listaImputaciones.isEmpty()) {
                                            if (sumaCreditos.compareTo(sumaDebitos) == 0) {
                                                insertSiiDocContable = documentoContableDao.insertarDocumentoContable(insertSiiDocContable);
                                                
                                                if (insertSiiDocContable!=null) {
                                                    for (SiiImputacionContable siiImputacionContable: listaImputaciones) {
                                                        if (siiImputacionContable!=null) {
                                                            // Sobreescribir el documento contable, para asociarle el que tiene el ID.
                                                            if (siiImputacionContable.getSiiDocumentoContable()!=null)
                                                                siiImputacionContable.setSiiDocumentoContable(insertSiiDocContable);
                                                            
                                                            imputacionContableDao.insertarInputacionContable(siiImputacionContable);
                                                        }
                                                    }
                                                    
                                                    exitoso = true;
                                                }
                                                else {
                                                    this.imprimirLog(tituloLog, "No fue insertado el Documento Contable para el Proceso "+siiProcesoSancIlegalidad.getPrsCodigo()+".", null);
                                                }
                                            }
                                            else {
                                                this.imprimirLog(tituloLog, "La Suma de Creditos ("+Utilidades.convertirNumeroEnMoneda(sumaCreditos)+") no es igual a la Suma de Debitos ("+Utilidades.convertirNumeroEnMoneda(sumaDebitos)+").", null);
                                            }
                                        }
                                        else {
                                            this.imprimirLog(tituloLog, "No se han registrado Imputaciones Contables para el Proceso "+siiProcesoSancIlegalidad.getPrsCodigo()+".", null);
                                        }
                                        
                                    }
                                    else {
                                        this.imprimirLog(tituloLog, "No se han encontrado Cuentas Contables asociadas al tipo de documento contable MCI.", null);
                                    }
                                }
                                else {
                                    this.imprimirLog(tituloLog, "No se ha establecido el Estado BORRADOR de Documentos Contables.", null);
                                }
                            }
                            else {
                                this.imprimirLog(tituloLog, "No se ha podido establecer un concecutivo para el tipo de documento contable MCI.", null);
                            }
                        }
                        else {
                            this.imprimirLog(tituloLog, "No existe el tipo de Documento Contable MCI.", null);
                        }
                    }
                    else {
                        this.imprimirLog(tituloLog, "No pudo ser calculado el Valor Total de la Sanción para el Proceso "+siiProcesoSancIlegalidad.getPrsCodigo()+".", null);
                    }
                }
                else {
                    this.imprimirLog(tituloLog, "La Resolución "+siiResolucionProcIleg.getRpiCodigo()+" no contiene un número de resolución asociado.", null);
                }
            }
            else {
                this.imprimirLog(tituloLog, "No ha establecido la Resolución para generar el Movimiento Contable.", null);
            }
        }
        else {
            this.imprimirLog(tituloLog, "No ha establecido un Proceso para generar el Movimiento Contable.", null);
        }
        
        
        return (exitoso);
    }
    
    
    
    private SiiResolucionProcIleg persistirResolucion (ProcesoSancIlegalidadVO procesoSancIlegalidadVo) throws ExcepcionDAO {
        SiiResolucionProcIleg resolucion = null;
        
        if (procesoSancIlegalidadVo!=null && procesoSancIlegalidadVo.getEstadoProcSanIlegVo()!=null) {
            if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RESOLUCION_SIN_SANCION.getId())) {
                resolucion = persisitirResolSinSancion(procesoSancIlegalidadVo);
            }
            if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RESOLUCION_CON_SANCION.getId())) {
                resolucion = persisitirResolSancionatoria(procesoSancIlegalidadVo);
            }
            if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RECURSO_APELACION.getId())) {
                resolucion = persistirResolApel(procesoSancIlegalidadVo);
            }
            if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RECURSO_REPOSICION.getId())) {
                resolucion = persisitirResolRepo(procesoSancIlegalidadVo);
            }
        }
        
        return resolucion;
    }
    
    
    /**
     * Almacena en cascada c/u de las Resoluciones del Proceso Sancionatorio de Ilegalidad especificado.
     * @param procesoSancIlegalidadVo - Proceso Sancionatorio de Ilegalidad.
     * @throws ExcepcionDAO
     */
    private boolean persistirResoluciones (ProcesoSancIlegalidadVO procesoSancIlegalidadVo) throws ExcepcionDAO 
    {
        boolean exitoso = true;
        
        if (procesoSancIlegalidadVo!=null) {
            ResolucionProcIlegVO resolucionSinSancion = procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo();
            ResolucionProcIlegVO resolucionSancionatoria = procesoSancIlegalidadVo.getResolucionProcIlegResolVo();
            ResolucionProcIlegVO resolucionReposicion = procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo();
            ResolucionProcIlegVO resolucionApelacion = procesoSancIlegalidadVo.getResolucionProcIlegApelaVo();
            
            if (resolucionSinSancion!=null) {
                ResolucionProcIlegVO resultado = this.persistirResolucion(resolucionSinSancion);
                if (resultado!=null)
                    resolucionSinSancion.setRpiCodigo(resultado.getRpiCodigo());
                else
                    exitoso = false;
            }
            
            if (resolucionSancionatoria!=null) {
                ResolucionProcIlegVO resultado = this.persistirResolucion(resolucionSancionatoria);
                if (resultado!=null)
                    resolucionSancionatoria.setRpiCodigo(resultado.getRpiCodigo());
                else
                    exitoso = false;
            }
            
            if (resolucionReposicion!=null) {
                ResolucionProcIlegVO resultado = this.persistirResolucion(resolucionReposicion);
                if (resultado!=null)
                    resolucionReposicion.setRpiCodigo(resultado.getRpiCodigo());
                else
                    exitoso = false;
            }
            
            if (resolucionApelacion!=null) {
                ResolucionProcIlegVO resultado = this.persistirResolucion(resolucionApelacion);
                if (resultado!=null)
                    resolucionApelacion.setRpiCodigo(resultado.getRpiCodigo());
                else
                    exitoso = false;
            }
        }
        
        return (exitoso);
    }
    
    
    /**
     * Almacena la informaci&oacute;n de la Resoluci&oacute;n especificada.
     * @param resolucionProcIlegVo - Resoluci&oacute;n del Proceso Sancionatorio de Ilegalidad.
     * @throws ExcepcionDAO
     */
    private ResolucionProcIlegVO persistirResolucion (ResolucionProcIlegVO resolucionProcIlegVo) throws ExcepcionDAO
    {
        ResolucionProcIlegVO resultado = null;
        
        if (resolucionProcIlegVo!=null) {
            if (resolucionProcIlegVo.getRpiCodigo()==null) {
                // Operacion INSERTAR
                resultado = adminResolucionProcIleg.insertarResolucionProcSanc(resolucionProcIlegVo, true);
            }
            else {
                // Operacion ACTUALIZAR
                resultado = adminResolucionProcIleg.actualizarResolucionProcSanc(resolucionProcIlegVo, true);
            }
        }
        
        return (resultado);
    }
    
    
    private SiiResolucionProcIleg persistirResolApel(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) throws ExcepcionDAO {
        SiiResolucionProcIleg resolucion = new SiiResolucionProcIleg();
        if(procesoSancIlegalidadVo.getResolucionProcIlegApelaVo().getRpiCodigo() == null) {
            resolucion =
                resolucionProcIlegDao.insertar(conversionVoEntidad.convertir(iniciarResolucion(procesoSancIlegalidadVo.getResolucionProcIlegApelaVo(), procesoSancIlegalidadVo.getUsuarioConecVo())));
        }
        else {
            resolucion = resolucionProcIlegDao.actualizar(conversionVoEntidad.convertir(procesoSancIlegalidadVo.getResolucionProcIlegApelaVo()));
        }
        List<TramiteResolProIleVO> tramites = procesoSancIlegalidadVo.getResolucionProcIlegApelaVo().getTramiteResolProIleListVo();
        persistirTramiteResol(procesoSancIlegalidadVo, resolucion, tramites);
        procesoSancIlegalidadVo.setResolucionProcIlegApelaVo(new ResolucionProcIlegVO(resolucion));
        return resolucion;
    }

    private SiiResolucionProcIleg persisitirResolRepo(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) throws ExcepcionDAO {
        SiiResolucionProcIleg resolucion = new SiiResolucionProcIleg();
        if(procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo().getRpiCodigo() == null) {
            resolucion =
                resolucionProcIlegDao.insertar(conversionVoEntidad.convertir(iniciarResolucion(procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo(),
                                                                                               procesoSancIlegalidadVo.getUsuarioConecVo())));
        }
        else {
            resolucion = resolucionProcIlegDao.actualizar(conversionVoEntidad.convertir(procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo()));
        }
        List<TramiteResolProIleVO> tramites = procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo().getTramiteResolProIleListVo();
        persistirTramiteResol(procesoSancIlegalidadVo, resolucion, tramites);
        procesoSancIlegalidadVo.setResolucionProcIlegReposicionVo(new ResolucionProcIlegVO(resolucion));
        return resolucion;
    }

    private SiiResolucionProcIleg persisitirResolSancionatoria(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) throws ExcepcionDAO {
        SiiResolucionProcIleg resolucion = new SiiResolucionProcIleg();
        if(procesoSancIlegalidadVo.getResolucionProcIlegResolVo().getRpiCodigo() == null) {
            resolucion =
                resolucionProcIlegDao.insertar(conversionVoEntidad.convertir(iniciarResolucion(procesoSancIlegalidadVo.getResolucionProcIlegResolVo(), procesoSancIlegalidadVo.getUsuarioConecVo())));
        }
        else {
            resolucion = resolucionProcIlegDao.actualizar(conversionVoEntidad.convertir(procesoSancIlegalidadVo.getResolucionProcIlegResolVo()));
        }
        List<TramiteResolProIleVO> tramites = procesoSancIlegalidadVo.getResolucionProcIlegResolVo().getTramiteResolProIleListVo();
        persistirTramiteResol(procesoSancIlegalidadVo, resolucion, tramites);
        procesoSancIlegalidadVo.setResolucionProcIlegResolVo(new ResolucionProcIlegVO(resolucion));
        return resolucion;
    }

    private SiiResolucionProcIleg persisitirResolSinSancion(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) throws ExcepcionDAO {
        SiiResolucionProcIleg resolucion = new SiiResolucionProcIleg();
        if(procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo().getRpiCodigo() == null) {
            resolucion =
                resolucionProcIlegDao.insertar(conversionVoEntidad.convertir(iniciarResolucion(procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo(),
                                                                                               procesoSancIlegalidadVo.getUsuarioConecVo())));
        }
        else {
            resolucion = resolucionProcIlegDao.actualizar(conversionVoEntidad.convertir(procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo()));
        }
        List<TramiteResolProIleVO> tramites = procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo().getTramiteResolProIleListVo();
        persistirTramiteResol(procesoSancIlegalidadVo, resolucion, tramites);
        procesoSancIlegalidadVo.setResolucionProcIlegSinSancionVo(new ResolucionProcIlegVO(resolucion));
        return resolucion;
    }

    private ResolucionProcIlegVO iniciarResolucion(ResolucionProcIlegVO resolucionVo, UsuarioVO usuarioVo) {
        resolucionVo.setUsuarioConecVo(usuarioVo);
        resolucionVo.setRpiPresQueja("N");
        resolucionVo.setRpiComunFiscalia("N");
        resolucionVo.setRpiFechaGenera(new Date());
        return resolucionVo;
    }
    
    
    
    /**
     * <b>FLUJO 17</b>: REGISTRAR SANCI&Oacute;N.
     * @param siiProcesoSancIlegalidad - Proceso Sancionatorio de Ilegalidad.
     * @param siiResolucionProcIleg - Resoluci&oacute;n que se desea asociar al Movimiento Contable.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     * @return Operaci&oacute;n exitosa?
     */
    public boolean registrarSancion (SiiProcesoSancIlegalidad siiProcesoSancIlegalidad, SiiResolucionProcIleg siiResolucionProcIleg) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - registrarSancion";
        
        
        boolean exitoso = false;
        
        
        if (siiProcesoSancIlegalidad!=null) {
            ProcesoSancIlegalidadVO procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(siiProcesoSancIlegalidad);
            
            BigDecimal valorTotalSancion = this.obtenerValorTotalSancionElementosProceso(procesoSancIlegalidadVo.getPrsCodigo());
            
            if (valorTotalSancion!=null) {
                
                // Obtener la Resolucion que Origina el Recurso
                ResolucionProcIlegVO resolucionSinSancion = procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo();
                ResolucionProcIlegVO resolucionSancionatoria = procesoSancIlegalidadVo.getResolucionProcIlegResolVo();
                ResolucionProcIlegVO resolucionOriginaRecurso = resolucionSinSancion!=null ? resolucionSinSancion : resolucionSancionatoria;
                
                if (resolucionOriginaRecurso!=null) {
                    
                    Date fechaResolFirme = tramiteResolProIleDao.fechaResolucionSancionatoriaPorEstado(resolucionOriginaRecurso.getRpiCodigo(), EnumEstadoTramResProcIleg.EN_FIRME.getId());
                    
                    if (fechaResolFirme!=null) {
                    
                        CuotaOperadorVO cuotaOperadorVo = new CuotaOperadorVO();
                        cuotaOperadorVo.setProcesoSancIlegalidadVo(procesoSancIlegalidadVo);
                        cuotaOperadorVo.setCopNumerocuota(1);
                        cuotaOperadorVo.setCopCancelada(EnumEstadoCuotaOperador.ACTIVA.getId());
                        cuotaOperadorVo.setCopTipoCartera(EnumTipoCartera.CORRIENTE.getId());
                        cuotaOperadorVo.setCopTipoDocSoporte(EnumTipoDocSopCuotaOperador.RESOLUCION.getId());
                
                        Calendar calFechaResolFirme = Calendar.getInstance();
                        calFechaResolFirme.setTime(fechaResolFirme);
                        cuotaOperadorVo.setCopVigencia(calFechaResolFirme.get(Calendar.YEAR));
                        cuotaOperadorVo.setMesCodigo(calFechaResolFirme.get(Calendar.MONTH) + 1);
                
                        Calendar calDiaSiguienteRF = Calendar.getInstance();
                        calDiaSiguienteRF.setTime(fechaResolFirme);
                        calDiaSiguienteRF.add(Calendar.DAY_OF_YEAR, 1);
                        cuotaOperadorVo.setCopFechaLimitepago(calDiaSiguienteRF.getTime());
                        
                        cuotaOperadorVo.setConceptoCuotaVo(adminConceptoCuota.buscarConceptoCuotaXId(EnumConceptoCuota.SANCION_DE_MULTA_POR_OPERACION_ILEGAL_.getId()));
                        cuotaOperadorVo.setCopValor(valorTotalSancion);
                
                        // Almacenar la Cuota Operador
                        SiiCuotaOperador siiCuotaOperador = cuotaOperadorDao.insertarSiiCuotaOperador(conversionVoEntidad.convertir(cuotaOperadorVo));
                        
                        if (siiCuotaOperador!=null && siiCuotaOperador.getCopCodigo()!=null) {
                            
                            // EJECUTA FLUJO 18: MOVIMIENTO CONTABLE
                            exitoso = this.generarMovimientoContable(siiProcesoSancIlegalidad, siiResolucionProcIleg);
                            
                        }
                        else {
                            this.imprimirLog(tituloLog, "No fue posible crear la Cuota Operador para el Proceso "+procesoSancIlegalidadVo.getPrsCodigo()+".", null);
                        }
                    }
                    else {
                        this.imprimirLog(tituloLog, "La Resolución "+resolucionOriginaRecurso.getRpiNumeroResol()+" no tiene establecida la Fecha de Resolución en Firme.", null);
                    }
                }
                else {
                    this.imprimirLog(tituloLog, "El Proceso "+procesoSancIlegalidadVo.getPrsCodigo()+" no tiene asociada una Resolución que Origine el Recurso.", null);
                }
            }
            else {
                this.imprimirLog(tituloLog, "El Proceso "+procesoSancIlegalidadVo.getPrsCodigo()+" no contiene Elementos asociados para calcular el Valor Total de la Sanción.", null);
            }
        }
        else {
            this.imprimirLog(tituloLog, "No ha establecido el Proceso al cual se le quiere registrar la Sanción.", null);
        }
        
        
        return (exitoso);
    }

    private void persistirTramiteResol(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, SiiResolucionProcIleg resolucion, List<TramiteResolProIleVO> tramites) throws ExcepcionDAO {
        if(tramites == null || tramites.size() == 0) {
            tramites = new ArrayList<TramiteResolProIleVO>();
            tramites.add(new TramiteResolProIleVO());
        }
        for(TramiteResolProIleVO tramite : tramites) {
            if(tramite.getTpiCodigo() == null) {
                tramite.setUsuarioConecVo(procesoSancIlegalidadVo.getUsuarioConecVo());
                if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RESOLUCION_SIN_SANCION.getId())) {
                    tramite.setResolucionProcIlegVo(procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo());
                }
                if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RESOLUCION_CON_SANCION.getId())) {
                    tramite.setResolucionProcIlegVo(procesoSancIlegalidadVo.getResolucionProcIlegResolVo());
                }
                if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RECURSO_APELACION.getId())) {
                    tramite.setResolucionProcIlegVo(procesoSancIlegalidadVo.getResolucionProcIlegApelaVo());
                }
                if(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo().equals(EnumEstadoProcSanIleg.TRAMITE_RECURSO_REPOSICION.getId())) {
                    tramite.setResolucionProcIlegVo(procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo());
                }
                SiiTramiteResolProIle siiTramite = conversionVoEntidad.convertir(tramite);
                siiTramite.setSiiResolucionProcIleg(resolucion);
                tramiteResolProIleDao.insertar(siiTramite);
            }

        }
    }


    /**
     * Elimina las entidades hijas que se encuentran pendientes por remover.
     * @throws ExcepcionDAO
     */
    private void eliminarHijos() throws ExcepcionDAO {
        if(this.listaElementoProcesoIleEliminar != null && !listaElementoProcesoIleEliminar.isEmpty()) {
            this.eliminarElementosProcesoIle();
        }
    }


    /**
     * Elimina el listado de Elementos del Proceso Sancionatorio de Ilegalidad.
     * @throws ExcepcionDAO
     */
    private void eliminarElementosProcesoIle() throws ExcepcionDAO {
        if(this.listaElementoProcesoIleEliminar != null && !listaElementoProcesoIleEliminar.isEmpty()) {
            for(ElementoProcesoIleVO eprVo : listaElementoProcesoIleEliminar) {
                if(eprVo != null && eprVo.getEprCodigo() != null) {
                    //elementoProcesoIleDao.eliminar(eprVo.getEprCodigo());

                    // Cambiar el estado a INACTIVO
                    eprVo.setEprActivo(EnumDecision.NO.getId());
                    elementoProcesoIleDao.actualizar(conversionVoEntidad.convertir(eprVo));
                }
            }


            // establecer nulo nuevamente el listado
            this.listaElementoProcesoIleEliminar = null;
        }
    }


    /////////////////////////////////////
    // Asignacion Listas para Eliminar //
    /////////////////////////////////////
    @Override
    public void setListaElementoProcesoIleEliminar(List<ElementoProcesoIleVO> listaElementoProcesoIleEliminar) {
        this.listaElementoProcesoIleEliminar = listaElementoProcesoIleEliminar;
    }

    
    
    /**
     * Establece las Resoluciones <i>EN FIRME</i>.
     * @throws Exception
     */
    public void establecerResolucionesProcSancIleEnFirme() throws Exception 
    {
        this.terminarProcesosIlegalidadSinSancion();
        this.terminarProcesosIlegalidadConSancion();
        this.terminarProcesosIlegalidadConRecursoReposicion();
        this.terminarProcesosIlegalidadConRecursoApelacion();
    }
    
    
    @Schedule(second = "1", minute = "0", hour = "0")
    public void terminarProcesosIlegalidadSinSancionTask() 
    {
        try {
            this.terminarProcesosIlegalidadSinSancion();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    
    @Schedule(second = "1", minute = "2", hour = "0")
    public void terminarProcesosIlegalidadConSancionTask() 
    {
        try {
            this.terminarProcesosIlegalidadConSancion();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    
    @Schedule(second = "1", minute = "4", hour = "0")
    public void terminarProcesosIlegalidadConRecursoReposicionTask() 
    {
        try {
            this.terminarProcesosIlegalidadConRecursoReposicion();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    
    @Schedule(second = "1", minute = "6", hour = "0")
    public void terminarProcesosIlegalidadConRecursoApelacionTask() 
    {
        try {
            this.terminarProcesosIlegalidadConRecursoApelacion();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * Finaliza los Procesos Sancionatorios de Ilegalidad relacionados con Resoluciones Sin Sanci&oacute;n.
     * @throws Exception
     */
    public void terminarProcesosIlegalidadSinSancion() throws Exception 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - terminarProcesosIlegalidadSinSancion";
        
        
        //      Al día siguiente a la fecha de notificación de la Resolución sancionatoria:
        //       Coloca la Resolución sin sanción en estado EN FIRME.
        //       Coloca el estado del proceso en TERMINADO SIN SANCIÓN.
        //       Genera la Constancia de ejecutoria.
        
        
        List<Long> listaCodigosProcesos = procesoSancIlegalidadDao.procesosIlegalidadSinSancionPorTerminar();
        if (listaCodigosProcesos!=null && !listaCodigosProcesos.isEmpty()) {
            boolean exitoso = actualizarEstadoTerminadoProcesosIlegalidad(listaCodigosProcesos, EnumEstadoProcSanIleg.TERMINADO_SIN_SANCION.getId(),
                                                            "Resolucion Sin Sancion");
            
            if (!exitoso) {
                throw new Exception("Fallo al momento de finalizar los Procesos Sancionatorios de Ilegalidad Sin Sanción.");
            }
            else {
                this.imprimirLog(tituloLog, "Se procesaron correctamente los Procesos de Resolución Sin Sanción.", null);
            }
        }
        else {
            this.imprimirLog(tituloLog, "No se encontraron procesos de Resolución Sin Sanción para procesar.", null);
        }
    }
    
    
    /**
     * Finaliza los Procesos Sancionatorios de Ilegalidad relacionados con Resoluciones Sancionatorias.
     * @throws Exception
     */
    public void terminarProcesosIlegalidadConSancion() throws Exception 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - terminarProcesosIlegalidadConSancion";
        
        
        //      •	Si el estado de la Resolución con sanción es NOTIFICADO:
        //      -	Registra el indicador de Interpone recurso.
        //      -	 Si  el Indicador interpone recurso de reposición es SI:
        //      o	Ejecuta el Flujo 11 – Registrar trámite recurso reposición.
        //      -	Si  el Indicador interpone recurso de reposición es NO:
        //      o	Al día siguiente a la fecha de notificación de la Resolución sancionatoria:
        //      ?	Coloca la Resolución sancionatoria en estado EN FIRME.
        //      ?	Coloca el estado del proceso en TERMINADO CON SANCIÓN.

        
        List<Long> listaCodigosProcesos = procesoSancIlegalidadDao.procesosIlegalidadConSancionPorTerminar();
        if (listaCodigosProcesos!=null && !listaCodigosProcesos.isEmpty()) {
            boolean exitoso = actualizarEstadoTerminadoProcesosIlegalidad(listaCodigosProcesos, EnumEstadoProcSanIleg.TERMINADO_CON_SANCION.getId(),
                                                            "Resolucion Con Sancion");
            
            if (!exitoso) {
                throw new Exception("Fallo al momento de finalizar los Procesos Sancionatorios de Ilegalidad Sancionatorios.");
            }
            else {
                this.imprimirLog(tituloLog, "Se procesaron correctamente los Procesos de Resolución Sancionatoria.", null);
            }
        }
        else {
            this.imprimirLog(tituloLog, "No se encontraron procesos de Resolución Sancionatoria para procesar.", null);
        }
    }

    
    /**
     * Finaliza los Procesos Sancionatorios de Ilegalidad relacionados con Resoluciones de Recurso de Reposici&oacute;n.
     * @throws Exception
     */
    public void terminarProcesosIlegalidadConRecursoReposicion() throws Exception 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - terminarProcesosIlegalidadConRecursoReposicion";
        
        
        /*
        •    Si el estado de la Resolución sancionatoria es NOTIFICADO:
        -       Si  el Indicador interpone recurso de apelación es NO:
        o       Si la Resolución fue revocada:
        ?       Coloca el estado del proceso en TERMINADO SIN SANCIÓN.
        ?       Coloca la Resolución sancionatoria en estado EN FIRME
        ?       Coloca el estado del proceso en TERMINADO CON SANCIÓN

         */
        
        List<Long> listaCodigosProcesos = procesoSancIlegalidadDao.procesosConReposicionPorTerminar();
        if (listaCodigosProcesos!=null && !listaCodigosProcesos.isEmpty()) {
            boolean exitoso = actualizarEstadoTerminadoProcesosIlegalidad(listaCodigosProcesos, EnumEstadoProcSanIleg.TERMINADO_CON_SANCION.getId(), "Recurso Reposicion");
            
            if (!exitoso) {
                throw new Exception("Fallo al momento de finalizar los Procesos Sancionatorios de Ilegalidad de Recurso de Reposición.");
            }
            else {
                this.imprimirLog(tituloLog, "Se procesaron correctamente los Procesos de Recurso de Reposición.", null);
            }
        }
        else {
            this.imprimirLog(tituloLog, "No se encontraron procesos de Recurso de Reposición para procesar.", null);
        }
    }

    
    /**
     * Finaliza los Procesos Sancionatorios de Ilegalidad relacionados con Resoluciones de Recurso de Apelaci&oacute;n.
     * @throws Exception
     */
    public void terminarProcesosIlegalidadConRecursoApelacion() throws Exception 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - terminarProcesosIlegalidadConRecursoApelacion";
        
        
        /*
        •    Si el estado de la Resolución sancionatoria es NOTIFICADO:
        -       Si  el Indicador interpone recurso de apelación es NO:
        o       Si la Resolución fue revocada:
        ?       Coloca el estado del proceso en TERMINADO SIN SANCIÓN.
        ?       Coloca la Resolución sancionatoria en estado EN FIRME
        ?       Coloca el estado del proceso en TERMINADO CON SANCIÓN

         */
        
        List<Long> listaCodigosProcesos = procesoSancIlegalidadDao.procesosConApelacionPorTerminar();
        if (listaCodigosProcesos!=null && !listaCodigosProcesos.isEmpty()) {
            boolean exitoso = actualizarEstadoTerminadoProcesosIlegalidad(listaCodigosProcesos, EnumEstadoProcSanIleg.TERMINADO_CON_SANCION.getId(), "Recurso Apelacion");
            
            if (!exitoso) {
                throw new Exception("Fallo al momento de finalizar los Procesos Sancionatorios de Ilegalidad de Recurso de Apelación.");
            }
            else {
                this.imprimirLog(tituloLog, "Se procesaron correctamente los Procesos de Recurso de Apelación.", null);
            }
        }
        else {
            this.imprimirLog(tituloLog, "No se encontraron procesos de Recurso de Apelación para procesar.", null);
        }
    }
    
    

    private boolean actualizarEstadoTerminadoProcesosIlegalidad(List<Long> listaProcesos, Long estadoTerminado, String tipo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        boolean exitoso = false;
        
        SiiResolucionProcIleg resolucion = null;
        if (listaProcesos!=null) {
            for(Long prsCodigo : listaProcesos) {
                if (prsCodigo!=null) {
                    SiiProcesoSancIlegalidad proceso = procesoSancIlegalidadDao.buscarPorCodigo(prsCodigo);
                    if (proceso!=null) {
                    
                        if(tipo.equals("Resolucion Sin Sancion")) {
                            resolucion = proceso.getSiiResolucionProcIlegSinSancion();
                            exitoso = this.guardarProcesoEnFirme(estadoTerminado, resolucion, proceso);
                        }
                        else if(tipo.equals("Resolucion Con Sancion")) {
                            resolucion = proceso.getSiiResolucionProcIlegResol();
                            
                            exitoso = this.guardarProcesoEnFirme(estadoTerminado, resolucion, proceso);
                            if (exitoso) {
                                exitoso = this.registrarSancion(proceso, resolucion);
                            }
                        }
                        else if(tipo.equals("Recurso Reposicion")) {
                            resolucion = proceso.getSiiResolucionProcIlegReposicion();
                            if (EnumTipoDecisionResolucion.REVOCA_PARCIALMENTE.getId().equals(resolucion.getRpiTipoResol()) || 
                                EnumTipoDecisionResolucion.CONFIRMA.getId().equals(resolucion.getRpiTipoResol())) 
                            {
                                // Buscar la Resolucion que Origina el Recurso.
                                SiiResolucionProcIleg resolucionSinSancion = proceso.getSiiResolucionProcIlegSinSancion();
                                SiiResolucionProcIleg resolucionSancionatoria = proceso.getSiiResolucionProcIlegResol();
                                SiiResolucionProcIleg resolucionOriginaRecurso = resolucionSinSancion!=null ? resolucionSinSancion : resolucionSancionatoria;
                                
                                exitoso = this.guardarProcesoEnFirme(estadoTerminado, resolucionOriginaRecurso, proceso);
                                if (exitoso) {
                                    exitoso = this.registrarSancion(proceso, resolucion);
                                }
                            }
                        }
                        else if(tipo.equals("Recurso Apelacion")) {
                            resolucion = proceso.getSiiResolucionProcIlegApela();
                            if(EnumTipoDecisionResolucion.REVOCA_PARCIALMENTE.getId().equals(resolucion.getRpiTipoResol()) || 
                               EnumTipoDecisionResolucion.CONFIRMA.getId().equals(resolucion.getRpiTipoResol())) 
                            {
                                // Buscar la Resolucion que Origina el Recurso.
                                SiiResolucionProcIleg resolucionSinSancion = proceso.getSiiResolucionProcIlegSinSancion();
                                SiiResolucionProcIleg resolucionSancionatoria = proceso.getSiiResolucionProcIlegResol();
                                SiiResolucionProcIleg resolucionOriginaRecurso = resolucionSinSancion!=null ? resolucionSinSancion : resolucionSancionatoria;
                                
                                exitoso = this.guardarProcesoEnFirme(estadoTerminado, resolucionOriginaRecurso, proceso);
                                if (exitoso) {
                                    exitoso = this.registrarSancion(proceso, resolucion);
                                }
                            }
                        }
                    }
                }
    
            }
        }
        
        return (exitoso);
    }
    
    
    /**
     * Almacena la informaci&oacute;n del cambio de Estado de la Resoluci&oacute;n <i>EN FIRME</i> y del Proceso <i>TERMINADO</i>.
     * @param estadoTerminado - Estado del Proceso.
     * @param resolucion - Resoluci&oacute;n.
     * @param proceso - Proceso Sancionatorio de Ilegalidad.
     * @return Operaci&oacute;n Exitosa?
     * @throws ExcepcionDAO
     */
    private boolean guardarProcesoEnFirme (Long estadoTerminado, SiiResolucionProcIleg resolucion, SiiProcesoSancIlegalidad proceso) throws ExcepcionDAO 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - guardarProcesoEnFirme";
        
        
        boolean exitoso = false;
        
        if (estadoTerminado!=null) {
            if (resolucion!=null) {
                if (proceso!=null) {
                    // 1. Actualizar la Resolucion para adicionar nuevo Tramite.
                    SiiTramiteResolProIle tramite = new SiiTramiteResolProIle();
                    tramite.setTpiFecha(new Date());
                    tramite.setSiiUsuarioConec(proceso.getSiiUsuarioConec());
                    tramite.setSiiResolucionProcIleg(resolucion);
            
                    tramite.setSiiEstadoTramResProcIleg(estadoTramResProcIlegDao.buscarPorCodigo(EnumEstadoTramResProcIleg.EN_FIRME.getId()));
                    SiiTramiteResolProIle resultado1 = tramiteResolProIleDao.insertar(tramite);
                    
                    
                    // 2. Actualizar el Proceso.
                    proceso.setSiiEstadoProcSanIleg(estadoProcSanIlegDao.buscarPorCodigo(estadoTerminado));
                    SiiProcesoSancIlegalidad resultado2 = procesoSancIlegalidadDao.actualizar(proceso);
                    
                    exitoso = resultado1!=null && resultado2!=null;
                }
                else {
                    this.imprimirLog(tituloLog, "No ha establecido el Proceso Sancionatorio de Ilegalidad para finalizar el Proceso.", null);
                }
            }
            else {
                this.imprimirLog(tituloLog, "No ha establecido la Resolución para finalizar el Proceso.", null);
            }
        }
        else {
            this.imprimirLog(tituloLog, "No ha establecido el Estado del Proceso para finalizar el Proceso.", null);
        }
        
        return (exitoso);
    }
    
    
    @Override
    public boolean actualizarResolucionSoportaRecurso(ProcesoSancIlegalidadVO procesoSancionatorio, ResolucionProcIlegVO resolucionOriginaRecurso,
                                                      List<PersonaInvestProIleVO> listaPersonaInvestProIle) throws ExcepcionDAO, ExcepcionAplicacion {
        boolean resultado = true;

        if(resolucionProcIlegDao.actualizar(conversionVoEntidad.convertir(resolucionOriginaRecurso)) != null) {
            for(PersonaInvestProIleVO persona : listaPersonaInvestProIle) {
                resultado = resultado && personaInvestProIleDao.actualizar(conversionVoEntidad.convertir(persona)) != null;
            }
        }
        return resultado;
    }
    
    
    
    @Override
    public BigDecimal obtenerValorTotalSancionElementosProceso (Long prsCodigo) throws ExcepcionDAO {
        return ( procesoSancIlegalidadDao.obtenerValorTotalSancionElementosProceso(prsCodigo) );
    }
    
    public List<PersonaInvestProIleVO> buscarPersonasInvestPorNumeroId(String identificacion) throws ExcepcionDAO{
        List<PersonaInvestProIleVO> listaPersonaInvestProIleVo = new ArrayList();
        List<SiiPersonaInvestProIle> listaPersonaInvestProIle = null;
        listaPersonaInvestProIle = personaInvestProIleDao.buscarPersonasInvestPorNumeroId(identificacion);
        if (listaPersonaInvestProIle != null){
            for ( SiiPersonaInvestProIle siiPersonaInvestProIle: listaPersonaInvestProIle){
                listaPersonaInvestProIleVo.add(new PersonaInvestProIleVO(siiPersonaInvestProIle));
            }
        }
        return listaPersonaInvestProIleVo;
        
    }
}