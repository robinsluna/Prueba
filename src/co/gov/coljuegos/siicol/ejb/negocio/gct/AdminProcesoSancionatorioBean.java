package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumConceptoCuota;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoCuotaOperador;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoImputacionContable;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoProcesoSanc;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoTramResPrSan;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumIndicadorCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumMotivoIncumplimiento;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoCartera;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDecisionResolucion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocContable;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocSopCuotaOperador;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoMovimiento;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogGeneral;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminDocumentoContable;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminTipoDocContable;
import co.gov.coljuegos.siicol.ejb.negocio.ryt.AdminConceptoCuota;
import co.gov.coljuegos.siicol.ejb.negocio.ryt.AdminCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoSancionatorioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancionatorio;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.AtributosImputacionContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentaContTipoDocContVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentasContablesVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaInexacProcSancVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOmisProcSancVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.DescargoProcSanVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDocContabVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcesoSancVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoTramResPrSanVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionContableVO;
import co.gov.coljuegos.siicol.ejb.vo.InformeSupervisionVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioProcSanVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncuInfSupervVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncumplimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.OperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoSancionatorioVO;
import co.gov.coljuegos.siicol.ejb.vo.RecepcionAlegatoProSanVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionProcSancVO;

import co.gov.coljuegos.siicol.ejb.vo.TipoDocContableVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProcSanVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Procesos Sancionatorios.
 * @author Camilo Miranda
 */
@Stateless
public class AdminProcesoSancionatorioBean implements AdminProcesoSancionatorio 
{
    /** T&acute;tulo que se asociar&aacute; en los Logs. */
    private final String TITULO_APLICACION = "Proceso Sancionatorio Fiscalización";
    
    
    
    @EJB
    private ProcesoSancionatorioDAO procesoSancionatorioDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminCuotaInexacProcSanc adminCuotaInexacProcSanc;
    @EJB
    private AdminCuotaOmisProcSanc adminCuotaOmisProcSanc;
    @EJB
    private AdminDescargoProcSan adminDescargoProcSan;
    @EJB
    private AdminRecepcionAlegatoProSan adminRecepcionAlegatoProSan;
    @EJB
    private AdminInventarioProcSan adminInventarioProcSan;
    @EJB
    private AdminResolucionProcSanc adminResolucionProcSanc;
    @EJB
    private AdminLogGeneral adminLogGeneral;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private AdminEstadoTramResPrSan adminEstadoTramResPrSan;
    @EJB
    private AdminEstadoProcesoSanc adminEstadoProcesoSanc;
    @EJB
    private AdminTramiteResolProcSan adminTramiteResolProcSan;
    @EJB
    private AdminConceptoCuota adminConceptoCuota;
    @EJB
    private AdminDocumentoContable adminDocumentoContable;
    @EJB
    private AdminTipoDocContable adminTipoDocContable;
    @EJB
    private AdminEstadoDocContab adminEstadoDocContab;
    @EJB
    private AdminCuentaContTipoDocCont adminCuentaContTipoDocCont;
    @EJB
    private AdminCuotaOperador adminCuotaOperador;
    @EJB
    private AdminMotivoIncuInfSuperv adminMotivoIncuInfSuperv;
    
    
    
    
    ////////////////////////////////////////////////
    // Listas para eliminacion de entidades hijas //
    ////////////////////////////////////////////////
    private List<InventarioProcSanVO> listaInventarioProcSanEliminar;
    private List<CuotaInexacProcSancVO> listaCuotaInexacProcSancEliminar;
    
    
    /**
     * Constructor.
     */
    public AdminProcesoSancionatorioBean() {
        super();
    }
    
    
    
    /**
     * <b>TAREA PROGRAMADA</b>.
     * Para c/u de las Resoluciones del Proceso Sancionatorio de Fiscalizaci&oacute;n que se encuentren en estado <i>NOTIFICADO</i>, que <i>NO interpongan recurso</i>: 
     * - Establece el estado de la Resoluci&oacute;n "<i>EN FIRME</i>".
     * - Establece el estado del Proceso Sancionatorio de Fiscalizaci&oacute;n en "<i>TERMINADO SIN SANCI&Oacute;N</i>" o "<i>TERMINADO CON SANCI&Oacute;N</i>", de acuerdo al tipo.
     */
    @Schedule(minute="45", hour="1")
    public void establecerResolucionesProcSancEnFirme () 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - establecerResolucionesProcSancEnFirme";
        UsuarioVO usuarioRegProceso = null;
        
        
        try {
            
            // Consulta todos los Procesos cuyas Resoluciones apliquen para el cambio de estado.
            List<ProcesoSancionatorioVO> listaProcesos = this.buscarProcesoSancionatorioConTramiteResolucionNotificado();
            
            if (listaProcesos!=null && !listaProcesos.isEmpty()) {
                
                int numResolucionesAProcesar = 0;
                int numResolucionesProcesadas = 0;
                
                Date fechaActual = new Date(System.currentTimeMillis());
                
                // Consultar los Estados
                EstadoTramResPrSanVO estadoTramEnFirme = adminEstadoTramResPrSan.buscarEstadoTramResPrSanPorCodigo(EnumEstadoTramResPrSan.EN_FIRME.getId());
                EstadoProcesoSancVO estadoTerminadoSinSancion = adminEstadoProcesoSanc.buscarEstadoProcesoSancPorCodigo(EnumEstadoProcesoSanc.TERMINADO_SIN_SANCION.getId());
                EstadoProcesoSancVO estadoTerminadoConSancion = adminEstadoProcesoSanc.buscarEstadoProcesoSancPorCodigo(EnumEstadoProcesoSanc.TERMINADO_CON_SANCION.getId());
                
                if (estadoTramEnFirme!=null) {
                    if (estadoTerminadoSinSancion!=null) {
                        if (estadoTerminadoConSancion!=null) {
                            for (ProcesoSancionatorioVO procesoSancionatorioVo: listaProcesos) {
                                
                                // Obtener el listado de resoluciones
                                ResolucionProcSancVO resolucionSinSancion = procesoSancionatorioVo.getResolucionProcSancSin();
                                ResolucionProcSancVO resolucionConSancion = procesoSancionatorioVo.getResolucionProcSancSanc();
                                ResolucionProcSancVO resolucionReposicion = procesoSancionatorioVo.getResolucionProcSancRepos();
                                ResolucionProcSancVO resolucionApelacion = procesoSancionatorioVo.getResolucionProcSancApela();
                                
                                InformeSupervisionVO informeSupervisionVo = procesoSancionatorioVo.getInformeSupervisionVo();
                                if (informeSupervisionVo!=null && informeSupervisionVo.getIsuCodigo()!=null) {
                                    // establecer los motivos de incumplimietno al informe de supervision
                                    List<MotivoIncuInfSupervVO> listaMI = adminMotivoIncuInfSuperv.buscarMotivoIncuPorInfSuper(informeSupervisionVo.getIsuCodigo());
                                    informeSupervisionVo.setMotivoIncuInfSupervListVo(listaMI);
                                }
                                
                                usuarioRegProceso = procesoSancionatorioVo.getUsuarioRegistraVo();
                                
                                boolean exitoso = true;
                                boolean cambiosRealizados = false;
                                
                                
                                ////////////////////////////
                                // RESOLUCION SIN SANCION //
                                ////////////////////////////
                                if (resolucionSinSancion!=null && resolucionSinSancion.getRepCodigo()!=null) 
                                {
                                    // Cargar los tramites de la resolucion
                                    List<TramiteResolProcSanVO> listaTramites = adminTramiteResolProcSan.buscarTramiteResolProcSanPorIdResolucion(resolucionSinSancion.getRepCodigo());
                                    resolucionSinSancion.setTramiteResolProcSanList(listaTramites);
                                    
                                    // Buscar el estado actual de la RESOLUCION SIN SANCION asociada al Proceso Sancionatorio de Fiscalizacion
                                    TramiteResolProcSanVO ultimoTramite = this.obtenerTramiteResolucion(resolucionSinSancion);
                                    
                                    // Verificar si el ultimo tramite de la RESOLUCION SIN SANCION corresponde al estado NOTIFICADO
                                    if (ultimoTramite!=null && ultimoTramite.getEstadoTramResPrSanVo()!=null && 
                                        EnumEstadoTramResPrSan.NOTIFICADO.getId().equals(ultimoTramite.getEstadoTramResPrSanVo().getEtrCodigo())) 
                                    {
                                        // Si NO INTERPONE RECURSO
                                        if (EnumDecision.NO.getId().equals(procesoSancionatorioVo.getPsaInterpRecurso())) {
                                            
                                            numResolucionesAProcesar++;
                                            
                                            // Establece EN FIRME la Resolucion SIN SANCION
                                            exitoso = this.cambiarEstadoResolucion(resolucionSinSancion, estadoTramEnFirme, fechaActual);
                                            
                                            if (exitoso) {
                                                // Coloca el estado del proceso en TERMINADO SIN SANCION
                                                procesoSancionatorioVo.setEstadoProcesoSancVo(estadoTerminadoSinSancion);
                                                
                                                cambiosRealizados = true;
                                                numResolucionesProcesadas++;
                                            }
                                            else {
                                                this.imprimirLog(tituloLog, "No fue posible cambiar el estado de la Resolución "+resolucionSinSancion.getRepCodigo()+" asociada al Proceso Sancionatorio "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                                            }
                                        }
                                    }
                                }
                                
                                
                                ////////////////////////////
                                // RESOLUCION CON SANCION //
                                ////////////////////////////
                                if (exitoso && resolucionConSancion!=null && resolucionConSancion.getRepCodigo()!=null) 
                                {
                                    // Cargar los tramites de la resolucion
                                    List<TramiteResolProcSanVO> listaTramites = adminTramiteResolProcSan.buscarTramiteResolProcSanPorIdResolucion(resolucionConSancion.getRepCodigo());
                                    resolucionConSancion.setTramiteResolProcSanList(listaTramites);
                                    
                                    // Buscar el estado actual de la RESOLUCION SANCIONATORIA asociada al Proceso Sancionatorio de Fiscalizacion
                                    TramiteResolProcSanVO ultimoTramite = this.obtenerTramiteResolucion(resolucionConSancion);
                                    
                                    // Verificar si el ultimo tramite de la RESOLUCION SANCIONATORIA corresponde al estado NOTIFICADO
                                    if (ultimoTramite!=null && ultimoTramite.getEstadoTramResPrSanVo()!=null && 
                                        EnumEstadoTramResPrSan.NOTIFICADO.getId().equals(ultimoTramite.getEstadoTramResPrSanVo().getEtrCodigo())) 
                                    {
                                        // Si NO INTERPONE RECURSO
                                        if (EnumDecision.NO.getId().equals(procesoSancionatorioVo.getPsaInterpRecurso())) {
                                            
                                            numResolucionesAProcesar++;
                                            
                                            // Establece EN FIRME la Resolucion CON SANCION
                                            exitoso = this.cambiarEstadoResolucion(resolucionConSancion, estadoTramEnFirme, fechaActual);
                                            
                                            if (exitoso) {
                                                // Coloca el estado del proceso en TERMINADO CON SANCION
                                                procesoSancionatorioVo.setEstadoProcesoSancVo(estadoTerminadoConSancion);
                                                
                                                
                                                //
                                                // Ejecuta el Flujo 21 – Registrar sanciones
                                                //
                                                exitoso = this.registrarSanciones(procesoSancionatorioVo);
                                                
                                                if (exitoso) {
                                                    cambiosRealizados = true;
                                                    numResolucionesProcesadas++;
                                                }
                                                else {
                                                    this.imprimirLog(tituloLog, "No fue posible registrar las Sanciones para el Proceso Sancionatorio "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                                                }
                                            }
                                            else {
                                                this.imprimirLog(tituloLog, "No fue posible cambiar el estado de la Resolución "+resolucionConSancion.getRepCodigo()+" asociada al Proceso Sancionatorio "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                                            }
                                        }
                                    }
                                }
                                
                                
                                ///////////////////////////////////
                                // RESOLUCION RECURSO REPOSICION //
                                ///////////////////////////////////
                                if (exitoso && resolucionReposicion!=null && resolucionReposicion.getRepCodigo()!=null) 
                                {
                                    // Cargar los tramites de la resolucion
                                    List<TramiteResolProcSanVO> listaTramites = adminTramiteResolProcSan.buscarTramiteResolProcSanPorIdResolucion(resolucionReposicion.getRepCodigo());
                                    resolucionReposicion.setTramiteResolProcSanList(listaTramites);
                                    
                                    // Buscar el estado actual de la RESOLUCION DE RECURSO DE REPOSICION asociada al Proceso Sancionatorio de Fiscalizacion
                                    TramiteResolProcSanVO ultimoTramite = this.obtenerTramiteResolucion(resolucionReposicion);
                                    
                                    // Verificar si el ultimo tramite de la RESOLUCION DE RECURSO DE REPOSICION corresponde al estado NOTIFICADO
                                    if (ultimoTramite!=null && ultimoTramite.getEstadoTramResPrSanVo()!=null && 
                                        EnumEstadoTramResPrSan.NOTIFICADO.getId().equals(ultimoTramite.getEstadoTramResPrSanVo().getEtrCodigo())) 
                                    {
                                        // Si NO INTERPONE RECURSO
                                        if (EnumDecision.NO.getId().equals(procesoSancionatorioVo.getPsaInterpApelacion())) {
                                            
                                            numResolucionesAProcesar++;
                                            
                                            // Si la Resolucion NO fue REVOCADA
                                            if (!EnumTipoDecisionResolucion.REVOCA.getId().equals(resolucionReposicion.getRemTipo())) {
                                            
                                                // Establece EN FIRME la Resolucion que ORIGINA EL RECURSO
                                                ResolucionProcSancVO resolucionOriginaRecurso = resolucionConSancion!=null ? resolucionConSancion : resolucionSinSancion;
                                                exitoso = this.cambiarEstadoResolucion(resolucionOriginaRecurso, estadoTramEnFirme, fechaActual);
                                                
                                                if (exitoso) {
                                                    // Coloca el estado del proceso en TERMINADO CON SANCION
                                                    procesoSancionatorioVo.setEstadoProcesoSancVo(estadoTerminadoConSancion);
                                                    
                                                    
                                                    //
                                                    // Ejecuta el Flujo 21 – Registrar sanciones
                                                    //
                                                    exitoso = this.registrarSanciones(procesoSancionatorioVo);
                                                    
                                                    if (exitoso) {
                                                        cambiosRealizados = true;
                                                        numResolucionesProcesadas++;
                                                    }
                                                    else {
                                                        this.imprimirLog(tituloLog, "No fue posible registrar las Sanciones para el Proceso Sancionatorio "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                                                    }
                                                }
                                                else {
                                                    Long repCodigo = resolucionOriginaRecurso!=null ? resolucionOriginaRecurso.getRepCodigo() : null;
                                                    this.imprimirLog(tituloLog, "No fue posible cambiar el estado de la Resolución que origina el recurso ("+repCodigo+") asociada al Proceso Sancionatorio "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                                                }
                                            }
                                        }
                                    }
                                }
                                
                                
                                //////////////////////////////////
                                // RESOLUCION RECURSO APELACION //
                                //////////////////////////////////
                                if (exitoso && resolucionApelacion!=null && resolucionApelacion.getRepCodigo()!=null) 
                                {
                                    // Cargar los tramites de la resolucion
                                    List<TramiteResolProcSanVO> listaTramites = adminTramiteResolProcSan.buscarTramiteResolProcSanPorIdResolucion(resolucionApelacion.getRepCodigo());
                                    resolucionApelacion.setTramiteResolProcSanList(listaTramites);
                                    
                                    // Buscar el estado actual de la RESOLUCION DE RECURSO DE APELACION asociada al Proceso Sancionatorio de Fiscalizacion
                                    TramiteResolProcSanVO ultimoTramite = this.obtenerTramiteResolucion(resolucionApelacion);
                                    
                                    // Verificar si el ultimo tramite de la RESOLUCION DE RECURSO DE APELACION corresponde al estado NOTIFICADO
                                    if (ultimoTramite!=null && ultimoTramite.getEstadoTramResPrSanVo()!=null && 
                                        EnumEstadoTramResPrSan.NOTIFICADO.getId().equals(ultimoTramite.getEstadoTramResPrSanVo().getEtrCodigo())) 
                                    {
                                        // Si la Resolucion NO fue REVOCADA
                                        if (!EnumTipoDecisionResolucion.REVOCA.getId().equals(resolucionApelacion.getRemTipo())) {
                                            
                                            numResolucionesAProcesar++;
                                            
                                            
                                            // Establece EN FIRME la Resolucion que ORIGINA EL RECURSO
                                            ResolucionProcSancVO resolucionOriginaRecurso = resolucionConSancion!=null ? resolucionConSancion : resolucionSinSancion;
                                            exitoso = this.cambiarEstadoResolucion(resolucionOriginaRecurso, estadoTramEnFirme, fechaActual);
                                            
                                            if (exitoso) {
                                                // Coloca el estado del proceso en TERMINADO CON SANCION
                                                procesoSancionatorioVo.setEstadoProcesoSancVo(estadoTerminadoConSancion);
                                                
                                                
                                                //
                                                // Ejecuta el Flujo 21 – Registrar sanciones
                                                //
                                                exitoso = this.registrarSanciones(procesoSancionatorioVo);
                                                
                                                if (exitoso) {
                                                    cambiosRealizados = true;
                                                    numResolucionesProcesadas++;
                                                }
                                                else {
                                                    this.imprimirLog(tituloLog, "No fue posible registrar las Sanciones para el Proceso Sancionatorio "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                                                }
                                            }
                                            else {
                                                Long repCodigo = resolucionOriginaRecurso!=null ? resolucionOriginaRecurso.getRepCodigo() : null;
                                                this.imprimirLog(tituloLog, "No fue posible cambiar el estado de la Resolución que origina el recurso ("+repCodigo+") asociada al Proceso Sancionatorio "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                                            }
                                        }
                                    }
                                }
                                
                                
                                if (exitoso && cambiosRealizados) {
                                    // Almacenar la informacion del Proceso Sancionatorio de Fiscalizacion
                                    this.actualizarProcesoSancionatorio(procesoSancionatorioVo, true);
                                    
                                    this.imprimirLog(tituloLog, "Fue actualizado satisfactoriamente el proceso "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                                }
                            }
                            
                            
                            this.imprimirLog(tituloLog, "Se procesaron correctamente "+numResolucionesProcesadas+" de "+numResolucionesAProcesar+" resoluciones.", usuarioRegProceso);
                        }
                        else {
                            this.imprimirLog(tituloLog, "No se encuentra parametrizado el estado de proceso sancionatorio de fiscalización 'TERMINADO CON SANCIÓN'.", null);
                        }
                    }
                    else {
                        this.imprimirLog(tituloLog, "No se encuentra parametrizado el estado de proceso sancionatorio de fiscalización 'TERMINADO SIN SANCIÓN'.", null);
                    }
                }
                else {
                    this.imprimirLog(tituloLog, "No se encuentra parametrizado el estado de trámite 'EN FIRME'.", null);
                }
            }
            else {
                this.imprimirLog(tituloLog, "No se encontraron procesos con trámites en estado 'NOTIFICADO'.", null);
            }
            
        }
        catch (Throwable e) {
            this.imprimirLog(tituloLog, "Error al intentar colocar 'EN FIRME' la Resolucion: "+e.getMessage(), usuarioRegProceso);
            
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * FLUJO 21: Registrar Sanciones.
     * @param procesoSancionatorioVo - Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @throws Exception
     */
    public boolean registrarSanciones (ProcesoSancionatorioVO procesoSancionatorioVo) throws Exception 
    {
        boolean exitoso = false;
        
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - registrarSanciones";
        UsuarioVO usuarioRegProceso = null;
        
        
        if (procesoSancionatorioVo!=null && procesoSancionatorioVo.getPsaCodigo()!=null) {
            
            // Obtener la resolucion que origina el recurso.
            ResolucionProcSancVO resolucionConSancion = procesoSancionatorioVo.getResolucionProcSancSanc();
            ResolucionProcSancVO resolucionSinSancion = procesoSancionatorioVo.getResolucionProcSancSin();
            ResolucionProcSancVO resolucionOriginaRecurso = resolucionConSancion!=null ? resolucionConSancion : resolucionSinSancion;
            
            
            if (resolucionOriginaRecurso!=null) {
            
                TramiteResolProcSanVO ultimoTramite = this.obtenerTramiteResolucion(resolucionOriginaRecurso);
                
                if (ultimoTramite!=null && ultimoTramite.getEstadoTramResPrSanVo()!=null && 
                    EnumEstadoTramResPrSan.EN_FIRME.getId().equals(ultimoTramite.getEstadoTramResPrSanVo().getEtrCodigo())) 
                {      
                    Date fechaResolFirme = ultimoTramite.getTrpFecha();
                    
                    if (fechaResolFirme!=null) {
                        
                        Calendar calFechaResolFirme = Calendar.getInstance();
                        calFechaResolFirme.setTime(fechaResolFirme);
                        Integer copVigencia = calFechaResolFirme.get(Calendar.YEAR);
                        Integer mes = calFechaResolFirme.get(Calendar.MONTH) + 1;
                        Calendar calDiaSiguienteRF = Calendar.getInstance();
                        calDiaSiguienteRF.setTime(fechaResolFirme); 
                        calDiaSiguienteRF.add(Calendar.DAY_OF_YEAR, 1);         
                        Date diaSiguienteRF = calDiaSiguienteRF.getTime();
                        
                        usuarioRegProceso = procesoSancionatorioVo.getUsuarioRegistraVo();
                        InformeSupervisionVO informeSupervisionVo = procesoSancionatorioVo.getInformeSupervisionVo();
                        MotivoIncumplimientoVO motivoActuacion = informeSupervisionVo!=null ? informeSupervisionVo.getMotivoIncumplimiento() : null;
                        
                        if (motivoActuacion!=null && motivoActuacion.getMinCodigo()!=null) {
                            
                            List<CuotaInexacProcSancVO> listaCuotasInexactitud = adminCuotaInexacProcSanc.buscarCuotaInexacProcSancPorIdProcesoSancionatorio(procesoSancionatorioVo.getPsaCodigo());
                            procesoSancionatorioVo.setCuotaInexacProcSancList(listaCuotasInexactitud);
                            
                            List<CuotaOmisProcSancVO> listaCuotasOmision = adminCuotaOmisProcSanc.buscarCuotaOmisProcSancPorIdProcesoSancionatorio(procesoSancionatorioVo.getPsaCodigo());
                            procesoSancionatorioVo.setCuotaOmisProcSancList(listaCuotasOmision);
                            
                            
                            
                            /////////////
                            // OMISION //
                            /////////////
                            if (EnumMotivoIncumplimiento.OMISION.getId().equals(motivoActuacion.getMinCodigo())) 
                            {
                                ConceptoCuotaVO conceptoCuotaLADE = 
                                    adminConceptoCuota.buscarConceptoCuotaXId(EnumConceptoCuota.LIQUIDACION_DE_AFORO_POR_DERECHOS_DE_EXPLOTACION_NO_DECLARADOS_OMISION.getId());
                                ConceptoCuotaVO conceptoCuotaLAGA = 
                                    adminConceptoCuota.buscarConceptoCuotaXId(EnumConceptoCuota.LIQUIDACION_DE_AFORO_POR_GASTOS_DE_ADMINISTRACION_NO_DECLARADOS_OMISION.getId());
                                ConceptoCuotaVO conceptoCuotaSAO = 
                                    adminConceptoCuota.buscarConceptoCuotaXId(EnumConceptoCuota.SANCION_DE_AFORO_POR_DERECHOS_DE_EXPLOTACION_NO_DECLARADOS_OMISION.getId());
                                
                                
                                if (conceptoCuotaLADE!=null) {
                                    if (conceptoCuotaLAGA!=null) {
                                        if (conceptoCuotaSAO!=null) {
                                            if (listaCuotasOmision!=null && !listaCuotasOmision.isEmpty()) {
                                                // Calcular los totales
                                                BigDecimal totalDE = BigDecimal.ZERO;
                                                //BigDecimal totalGA = BigDecimal.ZERO;
                                                BigDecimal totalSAO = BigDecimal.ZERO;
                                                
                                                for (CuotaOmisProcSancVO cosVo: listaCuotasOmision) {
                                                    if (cosVo!=null && cosVo.getCosValorSancion()!=null && EnumDecision.SI.getId().equals(cosVo.getCosActivo())) {
                                                        CuotaOperadorVO cuotaOperadorVo = cosVo.getCuotaOperadorVo();
                                                        if (cuotaOperadorVo!=null && cuotaOperadorVo.getConceptoCuotaVo()!=null) {
                                                            if (EnumConceptoCuota.DERECHOS_DE_EXPLOTACION.getId().equals(cuotaOperadorVo.getConceptoCuotaVo().getCcuCodigo())) {
                                                                totalDE = totalDE.add(cosVo.getCosValorDe());
                                                            }
                                                            /*
                                                            else if (EnumConceptoCuota.GASTOS_DE_ADMINISTRACION.getId().equals(cuotaOperadorVo.getConceptoCuotaVo().getCcuCodigo())) {
                                                                //totalGA = totalGA.add(cosVo.getCosValorGa());//TODO
                                                            }
                                                            */
                                                            
                                                            totalSAO = totalSAO.add(cosVo.getCosValorSancion());
                                                        }
                                                    }
                                                }
                                                
                                                
                                                List<CuotaOperadorVO> listaCuotasOperadorOmision = new ArrayList<CuotaOperadorVO>();
                                                
                                                //
                                                // 1. Almacena registro de Cuota Operador LADE
                                                //
                                                CuotaOperadorVO cuotaOperadorLADE = new CuotaOperadorVO();
                                                cuotaOperadorLADE.setProcesoSancionatorioVo(procesoSancionatorioVo);
                                                cuotaOperadorLADE.setCopNumerocuota(1);
                                                cuotaOperadorLADE.setCopCancelada(EnumEstadoCuotaOperador.ACTIVA.getId());
                                                cuotaOperadorLADE.setCopTipoCartera(EnumTipoCartera.CORRIENTE.getId());
                                                cuotaOperadorLADE.setCopTipoDocSoporte(EnumTipoDocSopCuotaOperador.RESOLUCION.getId());
                                                cuotaOperadorLADE.setCopVigencia(copVigencia);
                                                cuotaOperadorLADE.setMesCodigo(mes);
                                                cuotaOperadorLADE.setCopFechaLimitepago(diaSiguienteRF);
                                                cuotaOperadorLADE.setConceptoCuotaVo(conceptoCuotaLADE);
                                                // Suma de los saldos de las cuotas con concepto DE, incluidas en el proceso.
                                                cuotaOperadorLADE.setCopValor(totalDE);
                                                
                                                listaCuotasOperadorOmision.add(cuotaOperadorLADE);
                                                
                                                
                                                /*
                                                //
                                                // 2. Almacena registro de Cuota Operador LAGA
                                                //
                                                CuotaOperadorVO cuotaOperadorLAGA = new CuotaOperadorVO();
                                                cuotaOperadorLAGA.setProcesoSancionatorioVo(procesoSancionatorioVo);
                                                cuotaOperadorLAGA.setCopNumerocuota(1);
                                                cuotaOperadorLAGA.setCopCancelada(EnumEstadoCuotaOperador.ACTIVA.getId());
                                                cuotaOperadorLAGA.setCopTipoCartera(EnumTipoCartera.CORRIENTE.getId());
                                                cuotaOperadorLAGA.setCopTipoDocSoporte(EnumTipoDocSopCuotaOperador.RESOLUCION.getId());
                                                cuotaOperadorLAGA.setCopVigencia(copVigencia);
                                                cuotaOperadorLAGA.setMesCodigo(mes);
                                                cuotaOperadorLAGA.setCopFechaLimitepago(diaSiguienteRF);
                                                cuotaOperadorLAGA.setConceptoCuotaVo(conceptoCuotaLAGA);
                                                // Suma de los saldos de las cuotas con concepto GA, incluidas en el proceso.
                                                cuotaOperadorLAGA.setCopValor(totalGA);
                                                
                                                listaCuotasOperadorOmision.add(cuotaOperadorLAGA);
                                                */
                                                
                                                
                                                //
                                                // 3. Almacena registro de Cuota Operador SAO
                                                //
                                                CuotaOperadorVO cuotaOperadorSAO = new CuotaOperadorVO();
                                                cuotaOperadorSAO.setProcesoSancionatorioVo(procesoSancionatorioVo);
                                                cuotaOperadorSAO.setCopNumerocuota(1);
                                                cuotaOperadorSAO.setCopCancelada(EnumEstadoCuotaOperador.ACTIVA.getId());
                                                cuotaOperadorSAO.setCopTipoCartera(EnumTipoCartera.CORRIENTE.getId());
                                                cuotaOperadorSAO.setCopTipoDocSoporte(EnumTipoDocSopCuotaOperador.RESOLUCION.getId());
                                                cuotaOperadorSAO.setCopVigencia(copVigencia);
                                                cuotaOperadorSAO.setMesCodigo(mes);
                                                cuotaOperadorSAO.setCopFechaLimitepago(diaSiguienteRF);
                                                cuotaOperadorSAO.setConceptoCuotaVo(conceptoCuotaSAO);
                                                // Suma de las sanciones de las cuotas incluidas en el proceso.
                                                cuotaOperadorSAO.setCopValor(totalSAO);
                                                
                                                listaCuotasOperadorOmision.add(cuotaOperadorSAO);
                                                
                                                
                                                
                                                if (listaCuotasOperadorOmision!=null && !listaCuotasOperadorOmision.isEmpty()) {
                                                    // Asignar los registros de Cuota Operador al Proceso Sancionatorio.
                                                    procesoSancionatorioVo.setCuotaOperadorList(listaCuotasOperadorOmision);
                                                    
                                                    exitoso = true;
                                                }
                                                
                                            }
                                            else {
                                                this.imprimirLog(tituloLog, "El proceso "+procesoSancionatorioVo.getPsaConsecutivo()+" no contiene registros de Cuota de Omisión asociados.", usuarioRegProceso);
                                            }
                                        }
                                        else {
                                            this.imprimirLog(tituloLog, "No se encuentra parametrizado el Cocepto de Cuota Operador 'SAO'.", usuarioRegProceso);
                                        }
                                    }
                                    else {
                                        this.imprimirLog(tituloLog, "No se encuentra parametrizado el Cocepto de Cuota Operador 'LAGA'.", usuarioRegProceso);
                                    }
                                }
                                else {
                                    this.imprimirLog(tituloLog, "No se encuentra parametrizado el Cocepto de Cuota Operador 'LADE'.", usuarioRegProceso);
                                }
                            }
                            
                            /////////////////
                            // INEXACTITUD //
                            /////////////////
                            else if (EnumMotivoIncumplimiento.INEXACTITUD.getId().equals(motivoActuacion.getMinCodigo())) 
                            {
                                ConceptoCuotaVO conceptoCuotaLRMVDE = 
                                    adminConceptoCuota.buscarConceptoCuotaXId(EnumConceptoCuota.LIQUIDACION_DE_REVISION_POR_PAGO_DE_MENOR_VALOR_DERECHOS_DE_EXPLOTACION.getId());
                                ConceptoCuotaVO conceptoCuotaLRMVGA = 
                                    adminConceptoCuota.buscarConceptoCuotaXId(EnumConceptoCuota.LIQUIDACION_DE_REVISION_POR_PAGO_DE_MENOR_VALOR_GASTOS_DE_ADMINISTRACION.getId());
                                ConceptoCuotaVO conceptoCuotaSI = 
                                    adminConceptoCuota.buscarConceptoCuotaXId(EnumConceptoCuota.SANCION_POR_INEXACTITUD.getId());
                                
                                
                                if (conceptoCuotaLRMVDE!=null) {
                                    if (conceptoCuotaLRMVGA!=null) {
                                        if (conceptoCuotaSI!=null) {
                                            if (listaCuotasInexactitud!=null && !listaCuotasInexactitud.isEmpty()) {
                                                
                                                // Calcular los totales
                                                BigDecimal totalLRMVDE = BigDecimal.ZERO;
                                                BigDecimal totalLRMVGA = BigDecimal.ZERO;
                                                BigDecimal totalSI = BigDecimal.ZERO;
                                                for (CuotaInexacProcSancVO cipVo: listaCuotasInexactitud) {
                                                    if (cipVo!=null && EnumDecision.SI.getId().equals(cipVo.getCipActivo())) {
                                                        if (cipVo.getCipDiferenciaDe()!=null && cipVo.getCipLiquidRevisDe()!=null) {
                                                            // Suma de la Diferencia entre Valor de derechos de explotacion del mes y Liquidacion de revision Valor mensual Derechos de explotacion de todos los meses incluidos en el proceso.
                                                            totalLRMVDE = totalLRMVDE.add(cipVo.getCipDiferenciaDe());
                                                            totalLRMVDE = totalLRMVDE.add(cipVo.getCipLiquidRevisDe());
                                                        }
                                                        
                                                        if (cipVo.getCipDiferenciaGa()!=null && cipVo.getCipLiquidRevisGa()!=null) {
                                                            // Suma de la Diferencia entre Valor de gastos de administracion del mes y  Liquidacion de revision Valor mensual Gastos de administracion de todos los meses incluidos en el proceso.
                                                            totalLRMVGA = totalLRMVGA.add(cipVo.getCipDiferenciaGa());
                                                            totalLRMVGA = totalLRMVGA.add(cipVo.getCipLiquidRevisGa());
                                                        }
                                                        
                                                        if (cipVo.getCipValorSancion()!=null) {
                                                            // Suma del Valor de la Sancion por inexactitud de todos los meses incluidas en el proceso.
                                                            totalSI = totalSI.add(cipVo.getCipValorSancion());
                                                        }
                                                    }
                                                }
                                                
                                                
                                                List<CuotaOperadorVO> listaCuotasOperadorInexactitud = new ArrayList<CuotaOperadorVO>();
                                                
                                                //
                                                // 1. Almacena registro de Cuota Operador LRMVDE
                                                //
                                                CuotaOperadorVO cuotaOperadorLRMVDE = new CuotaOperadorVO();
                                                cuotaOperadorLRMVDE.setProcesoSancionatorioVo(procesoSancionatorioVo);
                                                cuotaOperadorLRMVDE.setCopNumerocuota(1);
                                                cuotaOperadorLRMVDE.setCopCancelada(EnumEstadoCuotaOperador.ACTIVA.getId());
                                                cuotaOperadorLRMVDE.setCopTipoCartera(EnumTipoCartera.CORRIENTE.getId());
                                                cuotaOperadorLRMVDE.setCopTipoDocSoporte(EnumTipoDocSopCuotaOperador.RESOLUCION.getId());
                                                cuotaOperadorLRMVDE.setCopVigencia(copVigencia);
                                                cuotaOperadorLRMVDE.setMesCodigo(mes);
                                                cuotaOperadorLRMVDE.setCopFechaLimitepago(diaSiguienteRF);
                                                cuotaOperadorLRMVDE.setConceptoCuotaVo(conceptoCuotaLRMVDE);
                                                // Suma de la Diferencia entre Valor de derechos de explotacion del mes y Liquidacion de revision Valor mensual Derechos de explotacion de todos los meses incluidos en el proceso.
                                                cuotaOperadorLRMVDE.setCopValor(totalLRMVDE);
                                                
                                                listaCuotasOperadorInexactitud.add(cuotaOperadorLRMVDE);
                                                
                                                
                                                //
                                                // 2. Almacena registro de Cuota Operador LRMVGA
                                                //
                                                CuotaOperadorVO cuotaOperadorLRMVGA = new CuotaOperadorVO();
                                                cuotaOperadorLRMVGA.setProcesoSancionatorioVo(procesoSancionatorioVo);
                                                cuotaOperadorLRMVGA.setCopNumerocuota(1);
                                                cuotaOperadorLRMVGA.setCopCancelada(EnumEstadoCuotaOperador.ACTIVA.getId());
                                                cuotaOperadorLRMVGA.setCopTipoCartera(EnumTipoCartera.CORRIENTE.getId());
                                                cuotaOperadorLRMVGA.setCopTipoDocSoporte(EnumTipoDocSopCuotaOperador.RESOLUCION.getId());
                                                cuotaOperadorLRMVGA.setCopVigencia(copVigencia);
                                                cuotaOperadorLRMVGA.setMesCodigo(mes);
                                                cuotaOperadorLRMVGA.setCopFechaLimitepago(diaSiguienteRF);
                                                cuotaOperadorLRMVGA.setConceptoCuotaVo(conceptoCuotaLRMVGA);
                                                // Suma de la Diferencia entre Valor de gastos de administracion del mes y  Liquidacion de revision Valor mensual Gastos de administracion de todos los meses incluidos en el proceso.
                                                cuotaOperadorLRMVGA.setCopValor(totalLRMVGA);
                                                
                                                listaCuotasOperadorInexactitud.add(cuotaOperadorLRMVGA);
                                                
                                                
                                                //
                                                // 3. Almacena registro de Cuota Operador SI
                                                //
                                                CuotaOperadorVO cuotaOperadorSI = new CuotaOperadorVO();
                                                cuotaOperadorSI.setProcesoSancionatorioVo(procesoSancionatorioVo);
                                                cuotaOperadorSI.setCopNumerocuota(1);
                                                cuotaOperadorSI.setCopCancelada(EnumEstadoCuotaOperador.ACTIVA.getId());
                                                cuotaOperadorSI.setCopTipoCartera(EnumTipoCartera.CORRIENTE.getId());
                                                cuotaOperadorSI.setCopTipoDocSoporte(EnumTipoDocSopCuotaOperador.RESOLUCION.getId());
                                                cuotaOperadorSI.setCopVigencia(copVigencia);
                                                cuotaOperadorSI.setMesCodigo(mes);
                                                cuotaOperadorSI.setCopFechaLimitepago(diaSiguienteRF);
                                                cuotaOperadorSI.setConceptoCuotaVo(conceptoCuotaSI);
                                                // Suma del Valor de la Sancion por inexactitud de todos los meses incluidas en el proceso.
                                                cuotaOperadorSI.setCopValor(totalSI);
                                                
                                                listaCuotasOperadorInexactitud.add(cuotaOperadorSI);
                                                
                                                
                                                if (listaCuotasOperadorInexactitud!=null && !listaCuotasOperadorInexactitud.isEmpty()) {
                                                    // Asignar los registros de Cuota Operador al Proceso Sancionatorio.
                                                    procesoSancionatorioVo.setCuotaOperadorList(listaCuotasOperadorInexactitud);
                                                    
                                                    exitoso = true;
                                                }
                                                
                                            }
                                            else {
                                                this.imprimirLog(tituloLog, "El proceso "+procesoSancionatorioVo.getPsaConsecutivo()+" no contiene registros de Cuota de Inexactitud asociados.", usuarioRegProceso);
                                            }
                                        }
                                        else {
                                            this.imprimirLog(tituloLog, "No se encuentra parametrizado el Cocepto de Cuota Operador 'SI'.", usuarioRegProceso);
                                        }
                                    }
                                    else {
                                        this.imprimirLog(tituloLog, "No se encuentra parametrizado el Cocepto de Cuota Operador 'LRMVGA'.", usuarioRegProceso);
                                    }
                                }
                                else {
                                    this.imprimirLog(tituloLog, "No se encuentra parametrizado el Cocepto de Cuota Operador 'LRMVDE'.", usuarioRegProceso);
                                }
                            }
                            else {
                                this.imprimirLog(tituloLog, "El proceso "+procesoSancionatorioVo.getPsaConsecutivo()+" contiene un Motivo de Actuación inválido ("+motivoActuacion.getMinNombre()+").", usuarioRegProceso);
                            }
                            
                            
                            
                            if (exitoso) {
                                // Ejecutar FLUJO 22 (MOVIMIENTO CONTABLE).
                                exitoso = this.generarMovimientoContable(procesoSancionatorioVo);
                            }
                            
                        }
                        else {
                            this.imprimirLog(tituloLog, "El proceso "+procesoSancionatorioVo.getPsaConsecutivo()+" no contiene Motivo de Actuación.", usuarioRegProceso);
                        }
                    }
                    else {
                        this.imprimirLog(tituloLog, "La resolución sancionatoria del proceso "+procesoSancionatorioVo.getPsaConsecutivo()+" no tiene registrada la Fecha de Resolución En Firme.", usuarioRegProceso);
                    }
                }
                else {
                    this.imprimirLog(tituloLog, "La resolución sancionatoria del proceso "+procesoSancionatorioVo.getPsaConsecutivo()+" no se encuentra en estado 'EN FIRME'.", usuarioRegProceso);
                }
            }
            else {
                this.imprimirLog(tituloLog, "El proceso "+procesoSancionatorioVo.getPsaConsecutivo()+" no contiene una Resolución Sancionatoria.", usuarioRegProceso);
            }
        }
        else {
            this.imprimirLog(tituloLog, "No ha asignado un Proceso Sancionatorio de Fiscalización para Registrar Sanciones.", usuarioRegProceso);
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * FLUJO 22: Movimiento Contable.
     * @param procesoSancionatorioVo - Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @throws Exception
     */
    public boolean generarMovimientoContable (ProcesoSancionatorioVO procesoSancionatorioVo) throws Exception 
    {
        boolean exitoso = false;
        
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - generarMovimientoContable";
        UsuarioVO usuarioRegProceso = null;
        
        if (procesoSancionatorioVo!=null) {
            if (procesoSancionatorioVo.getUsuarioRegistraVo()!=null) {
                usuarioRegProceso = procesoSancionatorioVo.getUsuarioRegistraVo();
                Date fechaActual = new Date(System.currentTimeMillis());
                
                // Obtener la resolucion que origina el recurso.
                ResolucionProcSancVO resolucionConSancion = procesoSancionatorioVo.getResolucionProcSancSanc();
                ResolucionProcSancVO resolucionSinSancion = procesoSancionatorioVo.getResolucionProcSancSin();
                ResolucionProcSancVO resolucionOriginaRecurso = resolucionConSancion!=null ? resolucionConSancion : resolucionSinSancion;
                
                InformeSupervisionVO informeSupervisionVo = procesoSancionatorioVo.getInformeSupervisionVo();
                ContratoVO contratoVo = informeSupervisionVo!=null ? informeSupervisionVo.getContratoVo() : null;
                OperadorVO operadorVo = contratoVo!=null ? contratoVo.getOperadorVo() : null;
                PersonaVO personaOperador = operadorVo!=null ? operadorVo.getPersonaVo() : null;
                MotivoIncumplimientoVO motivoActuacion = informeSupervisionVo!=null ? informeSupervisionVo.getMotivoIncumplimiento() : null;
                
                
                
                /////////////////////////////////
                //   MOVIMIENTO CONTABLE SPF   //
                // (SANCION POR FISCALIZACION) //
                /////////////////////////////////
                TipoDocContableVO tdcSPF = adminTipoDocContable.buscarPorCodigoTipoDocContable(EnumTipoDocContable.SANCION_POR_FISCALIZACION.getId());
                EstadoDocContabVO estadoDocContabVo = adminEstadoDocContab.buscarPorCodigoEstadoDocContab(EnumEstadoDocContab.BORRADOR.getId());
                
                if (tdcSPF!=null) {
                    if (estadoDocContabVo!=null) {
                        DocumentoContableVO dcoSPF = new DocumentoContableVO();
                        dcoSPF.setProcesoSancionatorioVo(procesoSancionatorioVo);
                        dcoSPF.setUsuarioRegistraVo(usuarioRegProceso);
                        dcoSPF.setTipoDocContableVo(tdcSPF);
                        dcoSPF.setDcoFechaOper(fechaActual);
                        dcoSPF.setEstadoDocContabVo(estadoDocContabVo);
                        Integer numComprMulta = adminDocumentoContable.buscarConsecutivoDocumentoContable(EnumTipoDocContable.SANCION_POR_FISCALIZACION.getId());
                        dcoSPF.setDcoNumeroCompr(numComprMulta);
                        
                        
                        List<ImputacionContableVO> listaImputacionContable = null;
                        // Por cada uno de los conceptos de las cuotas generadas en cuota operador:
                        List<CuotaOperadorVO> listaCuotasOperador = procesoSancionatorioVo.getCuotaOperadorList();
                        if (listaCuotasOperador!=null && !listaCuotasOperador.isEmpty()) {
                            
                            listaImputacionContable = new ArrayList<ImputacionContableVO>();
                            
                            boolean valido = true;
                            
                            Iterator<CuotaOperadorVO> itCOP = listaCuotasOperador.iterator();
                            while (itCOP.hasNext() && valido) {
                                CuotaOperadorVO cuotaOperadorVo = itCOP.next();
                                
                                if (cuotaOperadorVo!=null && cuotaOperadorVo.getConceptoCuotaVo()!=null && cuotaOperadorVo.getConceptoCuotaVo().getCcuAbreviatura()!=null) {
                                    String concepto = cuotaOperadorVo.getConceptoCuotaVo().getCcuAbreviatura();
                                    // Busca en la parametrizacion de documentos contables, el tipo de documento SPF y el concepto de la cuota.
                                    List<CuentaContTipoDocContVO> listaCCT = 
                                        adminCuentaContTipoDocCont.buscarSiiCuentaContTipoDocContPorTipoDocYConcepto(EnumTipoDocContable.SANCION_POR_FISCALIZACION.getId(), 
                                                                                                                     concepto);
                                    
                                    if (listaCCT!=null && !listaCCT.isEmpty()) {
                                        
                                        Iterator<CuentaContTipoDocContVO> itCCT = listaCCT.iterator();
                                        while (itCCT.hasNext() && valido) {
                                            CuentaContTipoDocContVO cctVo = itCCT.next();
                                            
                                            if (cctVo!=null && cctVo.getCuentasContablesVo()!=null && 
                                                cctVo.getCctActivo()!=null && EnumDecision.SI.getId().equals(cctVo.getCctActivo())) 
                                            {
                                                // Por cada registro encontrado en la parametrizacion en estado A, genera un registro de Imputacion contable con la siguiente informacion:
                                                CuentasContablesVO cuentasContablesVo = cctVo.getCuentasContablesVo();
                                                
                                                boolean imputacionesGeneradas = false;
                                                
                                                
                                                /////////////////////////////////////
                                                // ATRIBUTOS SEGUN PLAN DE CUENTAS //
                                                /////////////////////////////////////
                                                AtributosImputacionContableVO atributos = new AtributosImputacionContableVO();
                                                atributos.setCuentasContablesVo(cuentasContablesVo);
                                                
                                                
                                                // determinar si el tipo de movimiento de la cuenta contable es Debito o Credito
                                                String tipoMovimiento = cctVo.getCctTipoMovim();
                                                if (tipoMovimiento!=null) {
                                                    // TIPO DE MOVIMIENTO
                                                    atributos.setTipoMovimiento(tipoMovimiento);
                                                    
                                                    // OBLIGA TERCERO
                                                    if (EnumDecision.SI.getId().equals(cuentasContablesVo.getCcoObligaTerc())) {
                                                        // Operador del contrato de concesion
                                                        
                                                        
                                                        if (personaOperador!=null) {
                                                            atributos.setPersonaVo(personaOperador);
                                                            
                                                            atributos.setTercero(personaOperador.getPerNumIdentificacion());
                                                            
                                                            if (personaOperador.getTipoIdentificacionVo()!=null)
                                                                atributos.setTipoDocTercero(personaOperador.getTipoIdentificacionVo().getTidCodigo());
                                                        }
                                                    }
                                                    
                                                    // TIPO DOCUMENTO CONTABLE
                                                    if (EnumDecision.SI.getId().equals(cuentasContablesVo.getCcoTipDocConta())) {
                                                        String tdcCodigo = tdcSPF!=null ? tdcSPF.getTdcCodigo() : null;
                                                        atributos.setTipoComprobante(tdcCodigo);
                                                    }
                                                    
                                                    // NUMERO DE COMPROBANTE
                                                    if (EnumDecision.SI.getId().equals(cuentasContablesVo.getCcoNumDocConta()))
                                                        atributos.setNumeroComprobante(dcoSPF.getDcoNumeroCompr());
                                                    
                                                    // FUENTE DE FINANCIACION (No Aplica)
                                                    atributos.setFuenteFinancContabVo(null);
                                                    
                                                    // CENTRO DE COSTOS (No Aplica)
                                                    atributos.setCentroCostos(null);
                                                    atributos.setAreaColjuegosVo(null);
                                                    
                                                    // REFERENCIA 1
                                                    if (EnumDecision.SI.getId().equals(cuentasContablesVo.getCcoReferencia1())) {
                                                        String referencia1 = null;
                                                        if (EnumIndicadorCuentaContTipoDocCont.CUOTA.getId().equals(cctVo.getCctIndicador1())) {
                                                            // Referencia 1: Numero del contrato.
                                                            referencia1 = contratoVo.getConNumero();
                                                        }
                                                        else {
                                                            // Referencia 1: Numero de la resolucion sancionatoria.
                                                            if (resolucionOriginaRecurso!=null)
                                                                referencia1 = resolucionOriginaRecurso.getRemNumero();
                                                        }
                                                        
                                                        atributos.setReferencia1(referencia1);
                                                    }
                                                    
                                                    // REFERENCIA 2
                                                    if (EnumDecision.SI.getId().equals(cuentasContablesVo.getCcoReferencia2())) {
                                                        String referencia2 = null;
                                                        if (EnumIndicadorCuentaContTipoDocCont.CUOTA.getId().equals(cctVo.getCctIndicador1())) {
                                                            // Referencia 2: Numero de la Cuota.
                                                            if (cuotaOperadorVo.getCopNumerocuota()!=null)
                                                                referencia2 = cuotaOperadorVo.getCopNumerocuota().toString();
                                                        }
                                                        else {
                                                            // Referencia 2: 1.
                                                            referencia2 = "1";
                                                        }
                                                        
                                                        atributos.setReferencia2(referencia2);
                                                    }
                                                    
                                                    // DESCRIPCION DE LA OPERACION
                                                    if (motivoActuacion!=null && motivoActuacion.getMinCodigo()!=null && resolucionOriginaRecurso!=null) {
                                                        String descrOperacion = null;
                                                        
                                                        // Si el Motivo de la actuacion Omision esta marcado con SI:
                                                        if (EnumMotivoIncumplimiento.OMISION.getId().equals(motivoActuacion.getMinCodigo())) {
                                                            descrOperacion = "OMISIÓN POR PROCESOS DE FISCALIZACIÓN SEGÚN RESOLUCIÓN No. "+resolucionOriginaRecurso.getRemNumero()+".";
                                                        }
                                                        // Si el Motivo de la actuacion Inexactitud esta marcado con SI:
                                                        else if (EnumMotivoIncumplimiento.INEXACTITUD.getId().equals(motivoActuacion.getMinCodigo())) {
                                                            descrOperacion = "INEXACTITUD POR PROCESOS DE FISCALIZACIÓN SEGÚN RESOLUCIÓN NO. "+resolucionOriginaRecurso.getRemNumero()+".";
                                                        }
                                                        
                                                        atributos.setDescripcionOperacion(descrOperacion);
                                                    }
                                                    
                                                    // FECHA DE LA OPERACION
                                                    atributos.setFechaOperacion(fechaActual);
                                                    
                                                    //
                                                    // VALOR
                                                    //
                                                    if (motivoActuacion!=null && motivoActuacion.getMinCodigo()!=null) {
                                                        BigDecimal valor = null;
                                                        
                                                        // Si el Motivo de la actuacion Omision esta marcado con SI:
                                                        if (EnumMotivoIncumplimiento.OMISION.getId().equals(motivoActuacion.getMinCodigo())) {
                                                            // Si el Indicador1 es "TOTAL":
                                                            if (EnumIndicadorCuentaContTipoDocCont.TOTAL.getId().equals(cctVo.getCctIndicador1())) {
                                                                // Valor = Valor de la Cuota operador generada con el concepto que se esta procesando.
                                                                valor = cuotaOperadorVo.getCopValor();
                                                            }
                                                            // Si el Indicador1 es "CUOTA":
                                                            else if (EnumIndicadorCuentaContTipoDocCont.CUOTA.getId().equals(cctVo.getCctIndicador1())) {
                                                                // Genera un registro de Imputacion contable por cada una de las cuotas incluidas en el proceso con la misma informacion, y con el Valor de cada cuota.
                                                                List<CuotaOmisProcSancVO> listaCuotasOmision = procesoSancionatorioVo.getCuotaOmisProcSancList();
                                                                if (listaCuotasOmision!=null && !listaCuotasOmision.isEmpty()) {
                                                                    for (CuotaOmisProcSancVO cuotaOmisProcSancVo: listaCuotasOmision) {
                                                                        if (cuotaOmisProcSancVo!=null && EnumDecision.SI.getId().equals(cuotaOmisProcSancVo.getCosActivo())) {
                                                                            BigDecimal valorDE = cuotaOmisProcSancVo.getCosValorDe();
                                                                            if (valorDE!=null) {
                                                                                // Duplicar la informacion previamente registrada.
                                                                                AtributosImputacionContableVO atributosOmision = atributos.clone();
                                                                                atributosOmision.setValor(valorDE);
                                                                                
                                                                                // Adicionar el registro de Imputacion Contable
                                                                                ImputacionContableVO imcVo = generarImputacionContable(atributosOmision);
                                                                                listaImputacionContable.add(imcVo);
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                    if (!listaImputacionContable.isEmpty())
                                                                        imputacionesGeneradas = true;
                                                                }
                                                            }
                                                        }
                                                        // Si el Motivo de la actuacion Inexactitud esta marcado con SI:
                                                        else if (EnumMotivoIncumplimiento.INEXACTITUD.getId().equals(motivoActuacion.getMinCodigo())) {
                                                            // Valor = Valor de la Cuota operador generada con el concepto que se esta procesando.
                                                            valor = cuotaOperadorVo.getCopValor();
                                                        }
                                                        
                                                        
                                                        if (valor!=null) {
                                                            atributos.setValor(valor);
                                                        }
                                                        else {
                                                            atributos = null;
                                                        }
                                                    }
                                                }
                                                else {
                                                    this.imprimirLog(tituloLog, "No se encuentra la parametrización del Tipo de Movimiento para la Cuenta Contable "+cctVo.getCctCodigo()+".", usuarioRegProceso);
                                                    valido = false;
                                                }
                                                
                                                
                                                if (valido && !imputacionesGeneradas && atributos!=null) {
                                                    // Adicionar el registro de Imputacion Contable
                                                    ImputacionContableVO imcVo = generarImputacionContable(atributos);
                                                    listaImputacionContable.add(imcVo);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            
                            
                            if (!valido) {
                                listaImputacionContable = null;
                            }
                        }
                        
                        
                        if (listaImputacionContable!=null && !listaImputacionContable.isEmpty()) {
                            // Verificar la consistencia de los registros de Imputacion Contable.
                            BigDecimal debitos = BigDecimal.ZERO;
                            BigDecimal creditos = BigDecimal.ZERO;
                            for (ImputacionContableVO imcVo: listaImputacionContable) {
                                if (imcVo!=null && imcVo.getImcTipoMovim()!=null && imcVo.getImcValor()!=null) {
                                    if (EnumTipoMovimiento.DEBITO.getId().equals(imcVo.getImcTipoMovim()))
                                        debitos = debitos.add(imcVo.getImcValor());
                                    else if (EnumTipoMovimiento.CREDITO.getId().equals(imcVo.getImcTipoMovim()))
                                        creditos = creditos.add(imcVo.getImcValor());
                                }
                            }
                            
                            
                            if (debitos.compareTo(creditos) == 0) {
                                // Asociar las Imputaciones Contables al Documento Contable.
                                dcoSPF.setImputacionContableList(listaImputacionContable);
                                // Asociar el Documento Contable al Proceso Sancionatorio.
                                procesoSancionatorioVo.addDocumentoContable(dcoSPF);
                                
                                
                                exitoso = true;
                            }
                            else {
                                this.imprimirLog(tituloLog, "La suma de DEBITOS ("+Utilidades.convertirNumeroEnMoneda(debitos)+") no es igual a la suma de CREDITOS ("+Utilidades.convertirNumeroEnMoneda(creditos)+") para el Proceso Sancionatorio "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                            }
                        }
                        else {
                            this.imprimirLog(tituloLog, "No se generaron Imputaciones Contables para el Proceso Sancionatorio de Fiscalización "+procesoSancionatorioVo.getPsaConsecutivo()+".", usuarioRegProceso);
                            exitoso = false;
                        }
                    }
                    else {
                        this.imprimirLog(tituloLog, "No se encuentra parametrizado el Estado de Documento Contable 'BORRADOR'.", usuarioRegProceso);
                    }
                }
                else {
                    this.imprimirLog(tituloLog, "No se encuentra parametrizado el Tipo de Documento 'SPF'.", usuarioRegProceso);
                }
            }
            else {
                this.imprimirLog(tituloLog, "El Proceso Sancionatorio "+procesoSancionatorioVo.getPsaConsecutivo()+" no contiene un Usuario asociado.", usuarioRegProceso);
            }
        }
        else {
            this.imprimirLog(tituloLog, "No ha establecido un Proceso Sancionatorio para construir el Movimiento Contable.", usuarioRegProceso);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Genera un registro de Imputaci&oacute;n Contable, a partir del Value Object de Atributos.
     * @param atributos - Atributos de la Imputaci&oacute;n Contable.
     * @return
     */
    private ImputacionContableVO generarImputacionContable (AtributosImputacionContableVO atributos) 
    {
        ImputacionContableVO imputacionContableVo = null;
        
        if (atributos!=null) {
            //////////////////////////////////////////////
            // Crear el registro de Imputacion Contable //
            //////////////////////////////////////////////
            imputacionContableVo = new ImputacionContableVO();
            imputacionContableVo.setCuentasContablesVo(atributos.getCuentasContablesVo());
            imputacionContableVo.setImcTipoMovim(atributos.getTipoMovimiento());
            imputacionContableVo.setImcValor(atributos.getValor());
            imputacionContableVo.setImcEstado(EnumEstadoImputacionContable.ACTIVO.getId());
            imputacionContableVo.setImcReferencia1(atributos.getReferencia1());
            imputacionContableVo.setImcReferencia2(atributos.getReferencia2());
            imputacionContableVo.setAreaColjuegosVo(atributos.getAreaColjuegosVo());
            imputacionContableVo.setFuenteFinancContabVo(atributos.getFuenteFinancContabVo());
            imputacionContableVo.setPersonaVo(atributos.getPersonaVo());
            imputacionContableVo.setImcDescrOperacion(atributos.getDescripcionOperacion());
        }
        
        return (imputacionContableVo);
    }
    
    
    
    /**
     * Realiza el cambio del Estado a la Resoluci&oacute;n del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @param resolucionProcSancVo - Resoluci&oacute;n del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @param estadoTramResPrSanVo - Estado del Tr&aacute;mite que se desea adicionar.
     * @param fechaCambioEstado - Fecha del Cambio de Estado.
     * @throws Exception
     * @return Operaci&oacute;n exitosa?
     */
    private boolean cambiarEstadoResolucion (ResolucionProcSancVO resolucionProcSancVo, EstadoTramResPrSanVO estadoTramResPrSanVo, Date fechaCambioEstado) throws Exception 
    {
        boolean exitoso = false;
        
        if (resolucionProcSancVo!=null && estadoTramResPrSanVo!=null && fechaCambioEstado!=null) {
            Long etrCodigo = estadoTramResPrSanVo.getEtrCodigo();
            
            // crear un nuevo tramite para asociar el estado y la resolucion
            TramiteResolProcSanVO tramiteResolProcSanVo = new TramiteResolProcSanVO();
            tramiteResolProcSanVo.setTrpFecha(fechaCambioEstado);
            tramiteResolProcSanVo.setResolucionProcSancVo(resolucionProcSancVo);
            tramiteResolProcSanVo.setEstadoTramResPrSanVo(estadoTramResPrSanVo);
            
            // se busca el listado de tramites asociados a la resolucion del proceso de incumplimiento
            List<TramiteResolProcSanVO> listaTramitesResolProcSan = resolucionProcSancVo!=null ? resolucionProcSancVo.getTramiteResolProcSanList() : null;
            if (listaTramitesResolProcSan!=null) {
                // verificar los estados de resolucion existentes
                boolean encontrado = false;
                Iterator<TramiteResolProcSanVO> itTramites = listaTramitesResolProcSan.iterator();
                while (itTramites.hasNext() && !encontrado) {
                    TramiteResolProcSanVO tramite = itTramites.next();
                    if (tramite!=null) {
                        EstadoTramResPrSanVO estado = tramite.getEstadoTramResPrSanVo();
                        encontrado = estado!=null && etrCodigo.equals(estado.getEtrCodigo());
                    }
                }
                
                if (!encontrado) {
                    listaTramitesResolProcSan.add(tramiteResolProcSanVo);
                    
                    exitoso = true;
                }
            }
            else {
                if (resolucionProcSancVo!=null) {
                    listaTramitesResolProcSan = new ArrayList<TramiteResolProcSanVO>();
                    
                    // adicionar el tramite a la lista que se asociara a la resolucion
                    listaTramitesResolProcSan.add(tramiteResolProcSanVo);
                    resolucionProcSancVo.setTramiteResolProcSanList(listaTramitesResolProcSan);
                    
                    exitoso = true;
                }
            }
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Obtiene el tr&aacute;mite de la Resoluci&oacute;n
     * @return ultimoTramite - &Uacute;ltimo tr&aacute;mite de la resoluci&oacute;n sin sanci&oacute;n.
     * @throws Exception
     */
    private TramiteResolProcSanVO obtenerTramiteResolucion (ResolucionProcSancVO resolucion) throws Exception {
        TramiteResolProcSanVO ultimoTramite = null;
        
        if (resolucion != null) {
            List<TramiteResolProcSanVO> tramites = resolucion.getTramiteResolProcSanList();
            if (tramites != null && !tramites.isEmpty()) {
                // ordena los tramites por medio de su correspondiente estado
                Collections.sort(tramites);

                // el ultimo tramite corresponde al tramite actual de la resolucion
                ultimoTramite = tramites.get(tramites.size() - 1);
            }
        }

        return (ultimoTramite);
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
    
    
    
    
    
    /**
     * Establece las listas hijas al value object resultante del almacenamiento de la entidad.
     * @param resultado - Value Object resultante.
     * @param procesoSancionatorioVo -  Value Object base.
     */
    private void asignarHijos (ProcesoSancionatorioVO resultado, ProcesoSancionatorioVO procesoSancionatorioVo) 
    {
        if (resultado!=null && procesoSancionatorioVo!=null) {
            
            // establecer las resoluciones
            resultado.setResolucionProcSancApela(procesoSancionatorioVo.getResolucionProcSancApela());
            resultado.setResolucionProcSancRepos(procesoSancionatorioVo.getResolucionProcSancRepos());
            resultado.setResolucionProcSancSanc(procesoSancionatorioVo.getResolucionProcSancSanc());
            resultado.setResolucionProcSancSin(procesoSancionatorioVo.getResolucionProcSancSin());
            
            // establecer las listas a persistir
            resultado.setCuotaInexacProcSancList(procesoSancionatorioVo.getCuotaInexacProcSancList());
            resultado.setCuotaOmisProcSancList(procesoSancionatorioVo.getCuotaOmisProcSancList());
            resultado.setDescargoProcSanList(procesoSancionatorioVo.getDescargoProcSanList());
            resultado.setInventarioProcSanList(procesoSancionatorioVo.getInventarioProcSanList());
            resultado.setRepartoFiscalizadorList(procesoSancionatorioVo.getRepartoFiscalizadorList());
            resultado.setRecepcionAlegatoProSanList(procesoSancionatorioVo.getRecepcionAlegatoProSanList());
            resultado.setCuotaOperadorList(procesoSancionatorioVo.getCuotaOperadorList());
            resultado.setDocumentoContableList(procesoSancionatorioVo.getDocumentoContableList());
            
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de las entidades hijas del Proceso Sancionatorio.
     * @param procesoSancionatorioVo - Proceso Sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirHijos (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        this.persistirCuotaInexacProcSanc(procesoSancionatorioVo);
        this.persistirCuotaOmisProcSanc(procesoSancionatorioVo);
        this.persistirInventarioProcSan(procesoSancionatorioVo);
        this.persistirDescargoProcSan(procesoSancionatorioVo);
        this.persistirRecepcionAlegatoProSan(procesoSancionatorioVo);
        this.persistirCuotasOperador(procesoSancionatorioVo);
        this.persistirDocumentosContables(procesoSancionatorioVo);
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de la Resoluci&oacute;n especificada, junto con sus Tr&aacute;mites.
     * @param resolucionProcSancVo - Resoluci&oacute;n del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirResolucion (ResolucionProcSancVO resolucionProcSancVo) throws ExcepcionDAO 
    {
        if (resolucionProcSancVo!=null) {
            if (resolucionProcSancVo.getRepCodigo()==null) {
                // OPERACION INSERTAR
                ResolucionProcSancVO resultado = adminResolucionProcSanc.insertarResolucionProcSanc(resolucionProcSancVo, true);
                if (resultado!=null)
                    resolucionProcSancVo.setRepCodigo(resultado.getRepCodigo());
            }
            else {
                // OPERACION ACTUALIZAR
                adminResolucionProcSanc.actualizarResolucionProcSanc(resolucionProcSancVo, true);
            }
        }
    }
    
    
    /**
     * Almacena las Resoluciones asociadas al Proceso Sancionatorio.
     * @param procesoSancionatorioVo - Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirResoluciones (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO 
    {
        if (procesoSancionatorioVo!=null) {
            ResolucionProcSancVO resolucionProcSancSin = procesoSancionatorioVo.getResolucionProcSancSin();
            ResolucionProcSancVO resolucionProcSancSanc = procesoSancionatorioVo.getResolucionProcSancSanc();
            ResolucionProcSancVO resolucionProcSancRepos = procesoSancionatorioVo.getResolucionProcSancRepos();
            ResolucionProcSancVO resolucionProcSancApela = procesoSancionatorioVo.getResolucionProcSancApela();
            
            if (resolucionProcSancSin!=null)
                this.persistirResolucion(resolucionProcSancSin);
            if (resolucionProcSancSanc!=null)
                this.persistirResolucion(resolucionProcSancSanc);
            if (resolucionProcSancRepos!=null)
                this.persistirResolucion(resolucionProcSancRepos);
            if (resolucionProcSancApela!=null)
                this.persistirResolucion(resolucionProcSancApela);
        }
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de las Cuotas de Inexactitud pertenecientes al Proceso Sancionatorio especificado.
     * @param procesoSancionatorioVo - Proceso Sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirCuotaInexacProcSanc (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (procesoSancionatorioVo!=null) {
            List<CuotaInexacProcSancVO> listaCuotasInexacProcSanc = procesoSancionatorioVo.getCuotaInexacProcSancList();
            if (listaCuotasInexacProcSanc!=null && !listaCuotasInexacProcSanc.isEmpty()) {
                for (CuotaInexacProcSancVO cipVo: listaCuotasInexacProcSanc) {
                    if (cipVo!=null) {
                        cipVo.setProcesoSancionatorioVo(procesoSancionatorioVo);
                        
                        if (cipVo.getCipCodigo() == null) {
                            // OPERACION INSERTAR
                            adminCuotaInexacProcSanc.insertarCuotaInexacProcSanc(cipVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminCuotaInexacProcSanc.actualizarCuotaInexacProcSanc(cipVo);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de las Cuotas de Omisi&oacute;n pertenecientes al Proceso Sancionatorio especificado.
     * @param procesoSancionatorioVo - Proceso Sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirCuotaOmisProcSanc (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (procesoSancionatorioVo!=null) {
            List<CuotaOmisProcSancVO> listaCuotasOmisProcSanc = procesoSancionatorioVo.getCuotaOmisProcSancList();
            if (listaCuotasOmisProcSanc!=null && !listaCuotasOmisProcSanc.isEmpty()) {
                for (CuotaOmisProcSancVO cosVo: listaCuotasOmisProcSanc) {
                    if (cosVo!=null) {
                        cosVo.setProcesoSancionatorioVo(procesoSancionatorioVo);
                        
                        if (cosVo.getCosCodigo() == null) {
                            // OPERACION INSERTAR
                            adminCuotaOmisProcSanc.insertarCuotaOmisProcSanc(cosVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminCuotaOmisProcSanc.actualizarCuotaOmisProcSanc(cosVo);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n del Inventario perteneciente al Proceso Sancionatorio de Fiscalizaci&oacute;n especificado.
     * @param procesoSancionatorioVo - Proceso Sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirInventarioProcSan (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        if (procesoSancionatorioVo!=null) {
            List<InventarioProcSanVO> listaInventarioProcSan = procesoSancionatorioVo.getInventarioProcSanList();
            if (listaInventarioProcSan!=null && !listaInventarioProcSan.isEmpty()) {
                for (InventarioProcSanVO ipsVo: listaInventarioProcSan) {
                    if (ipsVo!=null) {
                        ipsVo.setProcesoSancionatorioVo(procesoSancionatorioVo);
                        
                        if (ipsVo.getIpsCodigo() == null) {
                            // OPERACION INSERTAR
                            adminInventarioProcSan.insertarInventarioProcSan(ipsVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminInventarioProcSan.actualizarInventarioProcSan(ipsVo);
                        }
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de los Descargos pertenecientes al Proceso Sancionatorio especificado.
     * @param procesoSancionatorioVo - Proceso Sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirDescargoProcSan (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (procesoSancionatorioVo!=null) {
            List<DescargoProcSanVO> listaDescargosProcSan = procesoSancionatorioVo.getDescargoProcSanList();
            if (listaDescargosProcSan!=null && !listaDescargosProcSan.isEmpty()) {
                for (DescargoProcSanVO dpsVo: listaDescargosProcSan) {
                    if (dpsVo!=null) {
                        dpsVo.setProcesoSancionatorioVo(procesoSancionatorioVo);
                        
                        if (dpsVo.getDpsCodigo() == null) {
                            // OPERACION INSERTAR
                            adminDescargoProcSan.insertarDescargoProcSan(dpsVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminDescargoProcSan.actualizarDescargoProcSan(dpsVo);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de los Alegatos pertenecientes al Proceso Sancionatorio especificado.
     * @param procesoSancionatorioVo - Proceso Sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirRecepcionAlegatoProSan (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (procesoSancionatorioVo!=null) {
            List<RecepcionAlegatoProSanVO> listaRecepcionAlegatoProSan = procesoSancionatorioVo.getRecepcionAlegatoProSanList();
            if (listaRecepcionAlegatoProSan!=null && !listaRecepcionAlegatoProSan.isEmpty()) {
                for (RecepcionAlegatoProSanVO ralVo: listaRecepcionAlegatoProSan) {
                    if (ralVo!=null) {
                        ralVo.setProcesoSancionatorioVo(procesoSancionatorioVo);
                        
                        if (ralVo.getRalCodigo() == null) {
                            // OPERACION INSERTAR
                            adminRecepcionAlegatoProSan.insertarRecepcionAlegatoProSan(ralVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminRecepcionAlegatoProSan.actualizarRecepcionAlegatoProSan(ralVo);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de los registros de Cuota Operador pertenecientes al Proceso Sancionatorio especificado.
     * @param procesoSancionatorioVo - Proceso Sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirCuotasOperador (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (procesoSancionatorioVo!=null) {
            List<CuotaOperadorVO> listaCuotaOperador = procesoSancionatorioVo.getCuotaOperadorList();
            if (listaCuotaOperador!=null && !listaCuotaOperador.isEmpty()) {
                for (CuotaOperadorVO copVo: listaCuotaOperador) {
                    if (copVo!=null) {
                        copVo.setProcesoSancionatorioVo(procesoSancionatorioVo);
                        
                        if (copVo.getCopCodigo() == null) {
                            // OPERACION INSERTAR
                            adminCuotaOperador.insertarCuotaOperador(copVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminCuotaOperador.actualizarCuotaOperador(copVo);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de los Documentos Contables pertenecientes al Proceso Sancionatorio especificado.
     * @param procesoSancionatorioVo - Proceso Sancionatorio.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirDocumentosContables (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (procesoSancionatorioVo!=null) {
            List<DocumentoContableVO> listaDocumentoContable = procesoSancionatorioVo.getDocumentoContableList();
            if (listaDocumentoContable!=null && !listaDocumentoContable.isEmpty()) {
                for (DocumentoContableVO dcoVo: listaDocumentoContable) {
                    if (dcoVo!=null) {
                        dcoVo.setProcesoSancionatorioVo(procesoSancionatorioVo);
                        
                        if (dcoVo.getDcoCodigo() == null) {
                            // OPERACION INSERTAR
                            adminDocumentoContable.insertarDocumentoContable(dcoVo, true);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminDocumentoContable.actualizarDocumentoContable(dcoVo, procesoSancionatorioVo.getUsuarioRegistraVo(), true);
                        }
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Elimina las entidades hijas que se encuentran pendientes por remover.
     * @throws ExcepcionDAO
     */
    private void eliminarHijos() throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (this.listaInventarioProcSanEliminar!=null && !listaInventarioProcSanEliminar.isEmpty()) {
            this.eliminarInventarioProcSan();
        }
        
        if (this.listaCuotaInexacProcSancEliminar!=null && !listaCuotaInexacProcSancEliminar.isEmpty()) {
            this.eliminarCuotasInexacProcSanc();
        }
    }
    
    
    /**
     * Inactiva c/u de los registros de Inventario asociados al Proceso Sancionatorio, que se encuentran pendientes por eliminar.
     * @throws ExcepcionDAO
     */
    private void eliminarInventarioProcSan () throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (listaInventarioProcSanEliminar!=null && !listaInventarioProcSanEliminar.isEmpty()) {
            for (InventarioProcSanVO ipsVO : listaInventarioProcSanEliminar) {
                if (ipsVO.getIpsCodigo()!=null) {
                    
                    // INACTIVAR el registro
                    ipsVO.setIpsActivo(EnumDecision.NO.getId());
                    adminInventarioProcSan.actualizarInventarioProcSan(ipsVO);
                    
                }
            }
            
            // establecer nulo nuevamente el listado
            this.listaInventarioProcSanEliminar = null;
        }
    }
    
    
    /**
     * Inactiva c/u de los registros de Cuota Inexactitud asociados al Proceso Sancionatorio, que se encuentran pendientes por eliminar.
     * @throws ExcepcionDAO
     */
    private void eliminarCuotasInexacProcSanc () throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (listaCuotaInexacProcSancEliminar!=null && !listaCuotaInexacProcSancEliminar.isEmpty()) {
            for (CuotaInexacProcSancVO cipVO : listaCuotaInexacProcSancEliminar) {
                if (cipVO.getCipCodigo()!=null) {
                    
                    // INACTIVAR el registro
                    cipVO.setCipActivo(EnumDecision.NO.getId());
                    adminCuotaInexacProcSanc.actualizarCuotaInexacProcSanc(cipVO);
                    
                }
            }
            
            // establecer nulo nuevamente el listado
            this.listaCuotaInexacProcSancEliminar = null;
        }
    }
    
    
    
    
    @Override
    public ProcesoSancionatorioVO buscarProcesoSancionatorioPorCodigo(Long psaCodigo) throws ExcepcionDAO {
        ProcesoSancionatorioVO resultado = null;
        SiiProcesoSancionatorio siiProcesoSancionatorio = procesoSancionatorioDao.buscarPorCodigo(psaCodigo);
        if (siiProcesoSancionatorio!=null)
            resultado = new ProcesoSancionatorioVO(siiProcesoSancionatorio);
        
        return (resultado);
    }
    
    
    @Override
    public List<ProcesoSancionatorioVO> buscarTodoProcesoSancionatorio() throws ExcepcionDAO {
        List<ProcesoSancionatorioVO> resultado = null;
        List<SiiProcesoSancionatorio> lista = procesoSancionatorioDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ProcesoSancionatorioVO>();
            for (SiiProcesoSancionatorio siiProcesoSancionatorio: lista) {
                if (siiProcesoSancionatorio!=null)
                    resultado.add(new ProcesoSancionatorioVO(siiProcesoSancionatorio));
            }
        }
        
        return (resultado);
    }
    
    
    
    @Override
    public ProcesoSancionatorioVO insertarProcesoSancionatorio(ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion {
        return ( this.insertarProcesoSancionatorio(procesoSancionatorioVo, false) );
    }
    
    
    @Override
    public ProcesoSancionatorioVO insertarProcesoSancionatorio(ProcesoSancionatorioVO procesoSancionatorioVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        ProcesoSancionatorioVO resultado = null;
        SiiProcesoSancionatorio siiProcesoSancionatorio = procesoSancionatorioDao.insertar(conversionVoEntidad.convertir(procesoSancionatorioVo));
        if (siiProcesoSancionatorio!=null) {
            resultado = new ProcesoSancionatorioVO(siiProcesoSancionatorio);
            
            if (cascadeUpdate) {
                this.asignarHijos(resultado, procesoSancionatorioVo);
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public ProcesoSancionatorioVO actualizarProcesoSancionatorio(ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion {
        return ( this.actualizarProcesoSancionatorio(procesoSancionatorioVo, false) );
    }
    
    
    @Override
    public ProcesoSancionatorioVO actualizarProcesoSancionatorio(ProcesoSancionatorioVO procesoSancionatorioVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion {
        ProcesoSancionatorioVO resultado = null;
        
        // eliminar entidades hijas pendientes por remover
        this.eliminarHijos();
        
        if (cascadeUpdate) {
            this.persistirResoluciones(procesoSancionatorioVo);
        }
        
        
        SiiProcesoSancionatorio siiProcesoSancionatorio = procesoSancionatorioDao.actualizar(conversionVoEntidad.convertir(procesoSancionatorioVo));
        if (siiProcesoSancionatorio!=null) {
            resultado = new ProcesoSancionatorioVO(siiProcesoSancionatorio);
            
            
            // Insertar Log de cambio de estado
            if (procesoSancionatorioVo.getEstadoProcesoSancVo()!=null && procesoSancionatorioVo.getEstadoProcesoSancVo().getEpsCodigo()!=null &&
                !procesoSancionatorioVo.getEstadoProcesoSancVo().getEpsCodigo().equals(procesoSancionatorioVo.getIdEstadoAnterior()) && 
                procesoSancionatorioVo.getUsuarioRegistraVo()!=null) 
            {
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.PROCESO_SANCIONATORIO_FISCALIZACION.getId(),
                                                             procesoSancionatorioVo.getEstadoProcesoSancVo().getEpsCodigo(),
                                                             procesoSancionatorioVo.getUsuarioRegistraVo(), 
                                                             resultado.getPsaCodigo());
            }
            
            if (cascadeUpdate) {
                this.asignarHijos(resultado, procesoSancionatorioVo);
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarProcesoSancionatorio(Long psaCodigo) throws ExcepcionDAO {
        procesoSancionatorioDao.eliminar(psaCodigo);
    }
    
    
    @Override
    public List<ProcesoSancionatorioVO> buscarProcesoSancionatorioPorPerCodigoSustanciador (Long perCodigo) throws ExcepcionDAO {
        List<ProcesoSancionatorioVO> resultado = null;
        List<SiiProcesoSancionatorio> lista = procesoSancionatorioDao.buscarProcesoSancionatorioPorPerCodigoSustanciador(perCodigo);
        if (lista!=null) {
            resultado = new ArrayList<ProcesoSancionatorioVO>();
            for (SiiProcesoSancionatorio siiProcesoSancionatorio: lista) {
                if (siiProcesoSancionatorio!=null)
                    resultado.add(new ProcesoSancionatorioVO(siiProcesoSancionatorio));
            }
        }
        
        return (resultado);
    }
    
    @Override
    public List<ProcesoSancionatorioVO> buscarProcesosInforme(Long psaCodigo) throws ExcepcionDAO {
        List<ProcesoSancionatorioVO> procesosVo = new ArrayList<ProcesoSancionatorioVO>();
        for (SiiProcesoSancionatorio proceso :procesoSancionatorioDao.buscarProcesosInforme(psaCodigo)) {
            procesosVo.add(new ProcesoSancionatorioVO(proceso));
        }
        return procesosVo;
    }
    
    @Override
    public boolean sustanciadorConProcesosVigentes(Long fsuCodigo) throws ExcepcionDAO {
        return procesoSancionatorioDao.sustanciadorConProcesosVigentes(fsuCodigo);
    }
    
    @Override
    public List<ProcesoSancionatorioVO> buscarProcesoSancionatorioConTramiteResolucionNotificado () throws ExcepcionDAO {
        List<ProcesoSancionatorioVO> resultado = null;
        List<SiiProcesoSancionatorio> lista = procesoSancionatorioDao.buscarProcesoSancionatorioConTramiteResolucionNotificado();
        if (lista!=null) {
            resultado = new ArrayList<ProcesoSancionatorioVO>();
            for (SiiProcesoSancionatorio siiProcesoSancionatorio: lista) {
                if (siiProcesoSancionatorio!=null)
                    resultado.add(new ProcesoSancionatorioVO(siiProcesoSancionatorio));
            }
        }
        
        return (resultado);
    }
    
    
    
    
    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    @Override
    public void setListaInventarioProcSanEliminar (List<InventarioProcSanVO> listaInventarioProcSanEliminar) {
        this.listaInventarioProcSanEliminar = listaInventarioProcSanEliminar;
    }
    
    @Override
    public void setListaCuotaInexacProcSancEliminar (List<CuotaInexacProcSancVO> listaCuotaInexacProcSancEliminar) {
        this.listaCuotaInexacProcSancEliminar = listaCuotaInexacProcSancEliminar;
    }
}
