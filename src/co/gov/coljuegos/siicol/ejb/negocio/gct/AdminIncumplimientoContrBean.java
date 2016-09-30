package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumCategoriaResolucionIncumContr;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumConceptoLiquidacion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoContrato;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoCuotaOperador;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoImputacionContable;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoIncumplContract;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoInventario;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoOperador;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoResolucSanCon;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumParametrosSistema;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDecisionResolucion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocContable;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoMovimiento;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoMulta;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoProcesoGCT;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoResolucion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado.AdminEstadoContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;


import co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado.AdminInventario;
import co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado.AdminOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogGeneral;

import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminDocumentoContable;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminTipoDocContable;
import co.gov.coljuegos.siicol.ejb.negocio.parametros.AdminSmmlv;
import co.gov.coljuegos.siicol.ejb.negocio.ryt.AdminCuotaOperador;

import co.gov.coljuegos.siicol.ejb.negocio.ryt.AdminLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.negocio.sistema.AdminParametrosSistema;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.IncumplimientoContrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiIncumplimientoContr;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.ActaSuspenAudIncumConVO;
import co.gov.coljuegos.siicol.ejb.vo.AtributosImputacionContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentaContTipoDocContVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentasContablesVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionProcesalIncVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDocContabVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoIncumplContractVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoResolucSanConVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionContableVO;
import co.gov.coljuegos.siicol.ejb.vo.IncumplimientoContrVO;

import co.gov.coljuegos.siicol.ejb.vo.InformeSupervisionVO;
import co.gov.coljuegos.siicol.ejb.vo.InhabilidadPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionMesVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncuInfSupervVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncumplimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.OperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.ParametrosSistemaVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionIncumContrVO;

import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocContableVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoMultaVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolSanConVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.math.RoundingMode;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.Date;
import java.util.Iterator;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;


@Stateless
public class AdminIncumplimientoContrBean implements AdminIncumplimientoContr 
{
    /** T&acute;tulo que se asociar&aacute; en los Logs. */
    private final String TITULO_APLICACION = "Incumplimiento Contractual";
    
    
    @EJB 
    IncumplimientoContrDAO incumplimientoContrDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private AdminDireccionProcesalInc adminDireccionProcesalInc;
    @EJB
    private AdminTramiteResolSanCon adminTramiteResolSanCon;

    @EJB
    private ConceptoCuotaDAO conceptoCuotaDao;

    @EJB
    private AdminResolucionIncumContr adminResolucionIncumContr;
    @EJB
    private AdminEstadoResolucSanCon adminEstadoResolucSanCon;
    @EJB
    private AdminEstadoIncumplContract adminEstadoIncumplContract;
    @EJB
    private AdminLogGeneral adminLogGeneral;

    @EJB
    private AdminDocumentoContable adminDocumentoContable;
    @EJB
    private AdminInventario adminInventario;
    @EJB
    private AdminContrato adminContrato;
    @EJB
    private AdminCuotaOperador adminCuotaOperador;
    @EJB
    private AdminOficioLiquidacion adminOficioLiquidacion;
    @EJB
    private AdminTipoMulta adminTipoMulta;
    @EJB
    private AdminSmmlv adminSMMLV;
    @EJB
    private AdminEstadoContrato adminEstadoContrato;
    @EJB
    private AdminParametrosSistema adminParametrosSistema;
    @EJB
    private AdminTipoDocContable adminTipoDocContable;
    @EJB
    private AdminEstadoDocContab adminEstadoDocContab;
    @EJB
    private AdminCuentaContTipoDocCont adminCuentaContTipoDocCont;
    @EJB
    private AdminActaSuspenAudIncumCon adminActaSuspenAudIncumCon;
    @EJB
    private AdminLiquidacionMes adminLiquidacionMes;
    @EJB
    private AdminMotivoIncuInfSuperv adminMotivoIncuInfSuperv;
    @EJB
    private AdminInhabilidadPersona adminInhabilidadPersona;
    
    

    
    /////////////////////////////////////////////////////////////
    // Objetos a persistir junto al proceso de Incumplimiento. //
    /////////////////////////////////////////////////////////////
    private List<InventarioVO> listaInventarioPersistir;
    private ContratoVO contratoVoPersistir;
    /** Listado de registros de Cuota Operador, que no hacen parte del proceso de Incumplimiento, pero que deben persistirse. */
    private List<CuotaOperadorVO> listaCuotaOperadorPersistir;
    
    
    
    
    /**
     * Constructor.
     */
    public AdminIncumplimientoContrBean() {
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
    
	
	
	/**
	 * Redondea un n&uacute;mero a CERO decimales.
	 * @param numero - N&uacute;mero que se desea redondear.
	 * @return N&uacute;mero redondeado a CERO decimales.
	 */
	private BigDecimal redondear (BigDecimal numero) 
	{
		return ( Utilidades.redondear(numero) );
	}
    
	
    
    
    /**
     * <b>TAREA PROGRAMADA</b>.
     * Para c/u de las Resoluciones de Incumplimiento Contractual que se encuentren en estado <i>NOTIFICADO</i>, que <i>NO interpongan recurso</i>, 
     * - Establece el estado de la Resoluci&oacute;n "<i>EN FIRME</i>".
     * - Establece el estado del Proceso de Incumplimiento Contractual "<i>TERMINADO SIN SANCI&Oacute;N</i> o <i>TERMINADO CON SANCI&Oacute;N</i>", de acuerdo al tipo.
     */
    @Schedule(minute="30", hour="1")
    public void establecerResolucionesIncumContrEnFirme () 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - establecerResolucionesIncumContrEnFirme";
        UsuarioVO usuarioRegProceso = null;
        
        
        try {
            // Consulta todas las resoluciones que apliquen para el cambio de estado.
            List<ResolucionIncumContrVO> listaResoluciones = 
                adminResolucionIncumContr.buscarResolucionIncumContrPorEstadoTramite(EnumEstadoResolucSanCon.NOTIFICADO.getId());
            
            
            int numResolucionesAProcesar = 0;
            int numResolucionesProcesadas = 0;
            
            
            
            if (listaResoluciones!=null && !listaResoluciones.isEmpty()) {
                // Consultar el estado de la Resolucion "EN FIRME"
                EstadoResolucSanConVO estadoResolucSanConVo = adminEstadoResolucSanCon.buscarEstadoResolucSanConPorCodigo(EnumEstadoResolucSanCon.EN_FIRME.getId());
                // Consultar el estado del Proceso "TERMINADO SIN SANCION"
                EstadoIncumplContractVO estadoIncumplContractSinSancion = adminEstadoIncumplContract.buscarEstadoIncumplContractPorCodigo(EnumEstadoIncumplContract.TERMINADO_SIN_SANCION.getId());
                // Consultar el estado del Proceso "TERMINADO CON SANCION"
                EstadoIncumplContractVO estadoIncumplContractConSancion = adminEstadoIncumplContract.buscarEstadoIncumplContractPorCodigo(EnumEstadoIncumplContract.TERMINADO_CON_SANCION.getId());
                
                
                if (estadoResolucSanConVo!=null && estadoResolucSanConVo.getErsCodigo()!=null && estadoIncumplContractSinSancion!=null && estadoIncumplContractConSancion!=null) {
                    
                    Date fechaActual = new Date(System.currentTimeMillis());
                    
                    
                    for (ResolucionIncumContrVO resolucion: listaResoluciones) {
                        if (resolucion!=null && resolucion.getRcoCodigo()!=null && resolucion.getRcoSinSancion()!=null) {
                            
                            // Para FLUJOS 5 y 7: Flag SIN SANCION IN ("SI", "NO"), y NO debe Interponer Recurso.
                            // Para FLUJO 8: El flag SIN SANCION debe ser igual a "NO APLICA" (Procesar todas las resoluciones en estado NOTIFICADO).
                            
                            boolean permitida = false;
                            // Flag que determina si la resolucion que se esta procesando corresponde a la que ORIGINA EL RECURSO (Flujos 5 y 7).
                            boolean originaRecurso = false;
                            
                            
                            IncumplimientoContrVO incumplimientoContrVo = null;
                            ResolucionIncumContrVO resolucionOriginaRecurso = null;
                            ResolucionIncumContrVO resolucionResuelveRecurso = null;
                                
                            // FLUJOS 5 Y 7
                            if ( (EnumDecision.NO.getId().equals(resolucion.getRcoSinSancion()) || 
                                  EnumDecision.SI.getId().equals(resolucion.getRcoSinSancion())) &&
                                  resolucion.getRcoReponeRecurso()!=null &&
                                  EnumDecision.NO.getId().equals(resolucion.getRcoReponeRecurso()) )
                            {
                                resolucionOriginaRecurso = resolucion;
                                
                                // Obtener el Proceso de Incumplimiento asociados a la resolucion que ORIGINA EL RECURSO.
                                incumplimientoContrVo = 
                                    this.buscarIncumplimientoPorIdResolucionYCategoria(resolucionOriginaRecurso.getRcoCodigo(), 
                                                                                       EnumCategoriaResolucionIncumContr.ORIGINA_RECURSO.getId());
                                
                                if (incumplimientoContrVo!=null && incumplimientoContrVo.getEstadoIncumplContractVo()!=null) {
                                    incumplimientoContrVo.setResolucionIncumContrResolVo(resolucionOriginaRecurso);
                                    resolucionResuelveRecurso = incumplimientoContrVo.getResolucionIncumContrRecursoVo();
                                    
                                    EstadoIncumplContractVO estadoActualProceso = incumplimientoContrVo.getEstadoIncumplContractVo();
                                    if (EnumEstadoIncumplContract.TRAMITE_RESOLUCION_SIN_SANCION.getId().equals(estadoActualProceso.getEicCodigo()) ||
                                        EnumEstadoIncumplContract.TRAMITE_RESOLUCION_INCUMPLIMIENTO.getId().equals(estadoActualProceso.getEicCodigo()))
                                    {
                                        permitida = true;
                                    }
                                }
                                
                                originaRecurso = true;
                            }
                            // FLUJO 8
                            else if ( EnumDecision.NO_APLICA.getId().equals(resolucion.getRcoSinSancion()) ) 
                            {
                                resolucionResuelveRecurso = resolucion;
                                
                                // Obtener el Proceso de Incumplimiento asociados a la resolucion que RESUELVE EL RECURSO.
                                incumplimientoContrVo = 
                                    this.buscarIncumplimientoPorIdResolucionYCategoria(resolucion.getRcoCodigo(), 
                                                                                       EnumCategoriaResolucionIncumContr.RESUELVE_RECURSO.getId());
                                
                                if (incumplimientoContrVo!=null && incumplimientoContrVo.getEstadoIncumplContractVo()!=null) {
                                    incumplimientoContrVo.setResolucionIncumContrRecursoVo(resolucionResuelveRecurso);
                                    resolucionOriginaRecurso = incumplimientoContrVo.getResolucionIncumContrResolVo();
                                    
                                    EstadoIncumplContractVO estadoActualProceso = incumplimientoContrVo.getEstadoIncumplContractVo();
                                    if (EnumEstadoIncumplContract.TRAMITE_RESOLUCION_RESUELVE_RECURSO_SIN_SANCION.getId().equals(estadoActualProceso.getEicCodigo()) ||
                                        EnumEstadoIncumplContract.TRAMITE_RESOLUCION_RESUELVE_RECURSO_INCUMPLIMIENTO.getId().equals(estadoActualProceso.getEicCodigo()))
                                    {
                                        permitida = true;
                                    }
                                }
                                
                                originaRecurso = false;
                            }
                            
                            
                            
                            permitida = permitida && resolucionOriginaRecurso!=null;
                            
                            
                            if (permitida) {
                                
                                // crear un nuevo tramite "EN FIRME" para asociar el estado y la resolucion que ORIGINA RECURSO
                                TramiteResolSanConVO tramiteResolSanConVo = new TramiteResolSanConVO();
                                tramiteResolSanConVo.setTrsFecha(fechaActual);
                                tramiteResolSanConVo.setResolucionIncumContrVo(resolucion);
                                tramiteResolSanConVo.setEstadoResolucSanConVo(estadoResolucSanConVo);
                                
                                // obtener el listado de tramites actuales de la resolucion que ORIGINA RECURSO-
                                List<TramiteResolSanConVO> listaTramites = adminTramiteResolSanCon.buscarTramiteResolSanConPorIdResolucion(resolucionOriginaRecurso.getRcoCodigo());
                                if (listaTramites!=null) {
                                    // verificar los estados de resolucion existentes
                                    boolean encontrado = false;
                                    Iterator<TramiteResolSanConVO> itTramites = listaTramites.iterator();
                                    while (itTramites.hasNext() && !encontrado) {
                                        TramiteResolSanConVO tramite = itTramites.next();
                                        if (tramite!=null) {
                                            EstadoResolucSanConVO estado = tramite.getEstadoResolucSanConVo();
                                            encontrado = estado!=null && estadoResolucSanConVo.getErsCodigo().equals(estado.getErsCodigo());
                                        }
                                    }
                                    
                                    if (!encontrado) {
                                        
                                        //
                                        // 1. Colocar EN FIRME la resolucion
                                        //
                                        listaTramites.add(tramiteResolSanConVo);
                                    }
                                    else {
                                        // adicionar unicamente las que no poseen tramite en estado "EN FIRME" en la resolucion que ORIGINA RECURSO.
                                        permitida = false;
                                    }
                                }
                                else {
                                    permitida = false;
                                }
                                
                                
                                if (permitida)
                                    resolucionOriginaRecurso.setTramiteResolSanConList(listaTramites);
                            }
                            
                            
                            if (permitida) {
                                
                                numResolucionesAProcesar++;
                                
                                    
                                // Establecer fecha de resolucion EN FIRME
                                resolucionOriginaRecurso.setRcoFechaResolFirme(fechaActual);
                                
                                
                                // Obtener el Motivo de Incumplimiento
                                InformeSupervisionVO informeSupervisionVo = incumplimientoContrVo.getInformeSupervisionVo();
                                if (informeSupervisionVo!=null && informeSupervisionVo.getIsuCodigo()!=null) {
                                    // establecer los motivos de incumplimietno al informe de supervision
                                    List<MotivoIncuInfSupervVO> listaMI = adminMotivoIncuInfSuperv.buscarMotivoIncuPorInfSuper(informeSupervisionVo.getIsuCodigo());
                                    informeSupervisionVo.setMotivoIncuInfSupervListVo(listaMI);
                                }
                                
                                
                                
                                //
                                // 3. Cambia el estado del Proceso
                                //
                                boolean procesoActualizado = false;
                                
                                //========================================================//
                                // 3.1 Para resolucion que ORIGINA RECURSO (FLUJOS 5 Y 7) //
                                //========================================================//
                                if (originaRecurso) {
                                    usuarioRegProceso = incumplimientoContrVo.getUsuarioRegistraVo();
                                    
                                    // consultar el estado actual del proceso
                                    EstadoIncumplContractVO estadoActualProceso = incumplimientoContrVo.getEstadoIncumplContractVo();
                                    if (estadoActualProceso!=null && estadoActualProceso.getEicCodigo()!=null) {
                                        if (EnumEstadoIncumplContract.TRAMITE_RESOLUCION_SIN_SANCION.getId().equals(estadoActualProceso.getEicCodigo())) {
                                            // Coloca el proceso en estado TERMINADO SIN SANCION
                                            incumplimientoContrVo.setEstadoIncumplContractVo(estadoIncumplContractSinSancion);
                                        }
                                        else if (EnumEstadoIncumplContract.TRAMITE_RESOLUCION_INCUMPLIMIENTO.getId().equals(estadoActualProceso.getEicCodigo())) {
                                            // Coloca el proceso en estado TERMINADO CON SANCION
                                            incumplimientoContrVo.setEstadoIncumplContractVo(estadoIncumplContractConSancion);
                                        }
                                        
                                        
                                        
                                        
                                        /////////////////////////////////////////////
                                        // Para Flujo 7: Resolucion INCUMPLIMIENTO //
                                        /////////////////////////////////////////////
                                        if (EnumDecision.NO.getId().equals(resolucionOriginaRecurso.getRcoSinSancion())) {
                                            // Si el Tipo de Resolucion es MULTA
                                            if (EnumTipoResolucion.MULTA.getId().equals(resolucionOriginaRecurso.getRcoTipoResol())) {
                                                
                                                // Ejecutar Flujo 12: Liquidar el Valor de la Multa
                                                String mensajeError = this.liquidarValorMulta(incumplimientoContrVo, resolucionOriginaRecurso.getRcoTipoResol());
                                                boolean liquidacionExitosa = mensajeError==null || mensajeError.isEmpty();
                                                procesoActualizado = liquidacionExitosa;
                                                
                                            }
                                            else if (EnumTipoResolucion.CADUCIDAD.getId().equals(resolucionOriginaRecurso.getRcoTipoResol())) {
                                                
                                                // Inhabilitar Operador
                                                this.inhabilitarOperador(incumplimientoContrVo, resolucionOriginaRecurso.getRcoFechaResolFirme());
                                                
                                                // Ejecutar Flujo 17: Registrar Caducidad
                                                boolean registroCaducidadExitoso = this.registrarCaducidad(incumplimientoContrVo);
                                                procesoActualizado = registroCaducidadExitoso;
                                                
                                            }
                                            else if (EnumTipoResolucion.INCUMPLIMIENTO.getId().equals(resolucionOriginaRecurso.getRcoTipoResol())) {
                                                procesoActualizado = true;
                                            }
                                            else {
                                                this.imprimirLog(tituloLog, "El tipo de resolución "+resolucionOriginaRecurso.getRcoTipoResol()+" asociado al proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+" no permite generar el trámite de resolución En Firme.", usuarioRegProceso);
                                            }
                                        }
                                        /////////////////////////////////////////////
                                        
                                        
                                        //////////////////////////////////////////
                                        // Para Flujo 5: Resolucion SIN SANCION //
                                        //////////////////////////////////////////
                                        else if (EnumDecision.SI.getId().equals(resolucionOriginaRecurso.getRcoSinSancion())) {
                                            procesoActualizado = true;
                                        }
                                        //////////////////////////////////////////
                                        
                                        
                                        
                                        if (procesoActualizado) {
                                            // Para CADUCIDAD, la informacion del proceso es almacenada en la logica del metodo registrarCaducidad.
                                            if (!EnumTipoResolucion.CADUCIDAD.getId().equals(resolucionOriginaRecurso.getRcoTipoResol())) {
                                                // 3.1.1 ALMACENAR LOS CAMBIOS EN EL PROCESO
                                                this.actualizarIncumplimientoContr(incumplimientoContrVo, true);
                                                
                                                procesoActualizado = true;
                                            }
                                        }
                                    }
                                    else {
                                        this.imprimirLog(tituloLog, "El Proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+" no posee Estado asociado.", usuarioRegProceso);
                                    }
                                }
                                
                                //====================================================//
                                // 3.2 Para resolucion que RESUELVE RECURSO (FLUJO 8) //
                                //====================================================//
                                else if (!originaRecurso) {
                                    usuarioRegProceso = incumplimientoContrVo.getUsuarioRegistraVo();
                                    
                                    
                                    if (resolucionOriginaRecurso!=null) {
                                        
                                        // consultar el estado actual del proceso
                                        EstadoIncumplContractVO estadoActualProceso = incumplimientoContrVo.getEstadoIncumplContractVo();
                                        if (estadoActualProceso!=null && estadoActualProceso.getEicCodigo()!=null) {
                                            
                                            // Si la resolucion que origino el recurso es Resolucion SIN SANCION, 
                                            // o es CON SANCION y la Resolucion que resuelve recurso determino REVOCAR la resolucion Con Sancion.
                                            if ( ( EnumEstadoIncumplContract.TRAMITE_RESOLUCION_RESUELVE_RECURSO_SIN_SANCION.getId().equals(estadoActualProceso.getEicCodigo()) ) || 
                                                 ( EnumEstadoIncumplContract.TRAMITE_RESOLUCION_RESUELVE_RECURSO_INCUMPLIMIENTO.getId().equals(estadoActualProceso.getEicCodigo()) && 
                                                   EnumTipoDecisionResolucion.REVOCA.getId().equals(resolucionResuelveRecurso.getRcoTipoDecision()) ) ) 
                                            {
                                                
                                                // Coloca el proceso en estado TERMINADO SIN SANCION
                                                incumplimientoContrVo.setEstadoIncumplContractVo(estadoIncumplContractSinSancion);
                                                
                                            }
                                            
                                            // Si la resolucion que origino el recurso es Resolucion de INCUMPLIMIENTO y la resolucion que resolvio recurso determino CONFIRMAR la Resolucion Con Sancion o REVOCARLA PARCIALMENTE.
                                            else if ( ( EnumEstadoIncumplContract.TRAMITE_RESOLUCION_RESUELVE_RECURSO_INCUMPLIMIENTO.getId().equals(estadoActualProceso.getEicCodigo()) && 
                                                        ( EnumTipoDecisionResolucion.CONFIRMA.getId().equals(resolucionResuelveRecurso.getRcoTipoDecision()) || 
                                                          EnumTipoDecisionResolucion.REVOCA_PARCIALMENTE.getId().equals(resolucionResuelveRecurso.getRcoTipoDecision()) ) ) ) 
                                            {
                                                
                                                // Coloca el proceso en estado TERMINADO CON SANCION
                                                incumplimientoContrVo.setEstadoIncumplContractVo(estadoIncumplContractConSancion);
                                                
                                                
                                                // Si el Tipo de la Resolucion que Origina el Recurso es CADUCIDAD
                                                if (EnumTipoResolucion.CADUCIDAD.getId().equals(resolucionOriginaRecurso.getRcoTipoResol())) {
                                                    
                                                    // Inhabilitar Operador
                                                    this.inhabilitarOperador(incumplimientoContrVo, resolucionOriginaRecurso.getRcoFechaResolFirme());
                                                    
                                                }
                                                // Si el Tipo de la Resolucion que Origina el Recurso es MULTA
                                                else if (EnumTipoResolucion.MULTA.getId().equals(resolucionOriginaRecurso.getRcoTipoResol())) {
                                                    
                                                    // Ejecutar Flujo 12: Liquidar Valor Multa
                                                    this.liquidarValorMulta(incumplimientoContrVo, resolucionOriginaRecurso.getRcoTipoResol());
                                                    
                                                }
                                                
                                            }
                                            
                                            
                                            // 3.2.1 ALMACENAR LOS CAMBIOS EN EL PROCESO
                                            this.actualizarIncumplimientoContr(incumplimientoContrVo, true);
                                            procesoActualizado = true;
                                        }
                                        else {
                                            this.imprimirLog(tituloLog, "El Proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+" no posee Estado asociado.", usuarioRegProceso);
                                        }
                                    }
                                    else {
                                        this.imprimirLog(tituloLog, "El Proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+" no posee relación con la Resolución que Origina el Recurso.", usuarioRegProceso);
                                    }
                                }
                                
                                
                                
                                if (procesoActualizado) {
                                    this.imprimirLog(tituloLog, "Se procesó satisfactoriamente la resolución "+resolucion.getRcoNumeroResol()+" ("+resolucion.getRcoCodigo()+").", usuarioRegProceso);
                                    numResolucionesProcesadas++;
                                }
                                
                            }
                        }
                        else {
                            if (resolucion!=null)
                                this.imprimirLog(tituloLog, "La resolución "+resolucion.getRcoNumeroResol()+" no contiene ID.", usuarioRegProceso);
                        }
                    }
                    
                    
                    this.imprimirLog(tituloLog, "Se procesaron correctamente "+numResolucionesProcesadas+" de "+numResolucionesAProcesar+" resoluciones.", usuarioRegProceso);
                }
                else {
                    this.imprimirLog(tituloLog, "Verifique en el sistema los parámetros de los estados de proceso incumplimiento 'TERMINADO SIN SANCIÓN', 'TERMINADO CON SANCIÓN' y el estado de la Resolución 'EN FIRME'.", usuarioRegProceso);
                }
                
            }
            else {
                this.imprimirLog(tituloLog, "No fueron encontradas resoluciones pendientes para procesar.", usuarioRegProceso);
            }
            
        }
        catch (Exception e) {
            this.imprimirLog(tituloLog, "Error al intentar colocar 'EN FIRME' la Resolucion: "+e.getMessage(), usuarioRegProceso);
            
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * Inhabilita el Operador asociado al proceso de Incumplimiento, a partir de la Fecha de Inicio de la Inhabilidad suministrada.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @param fechaInicioInhabilidad - Fecha de Inicio de la Inhabilidad.
     * @return Operaci&oacute;n exitosa?
     * @throws Exception
     */
    private boolean inhabilitarOperador (IncumplimientoContrVO incumplimientoContrVo, Date fechaInicioInhabilidad) throws Exception
    {
        boolean exitoso = false;
        
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - inhabilitarOperador";
        UsuarioVO usuarioRegProceso = null;
        
        
        if (incumplimientoContrVo!=null && incumplimientoContrVo.getIcnCodigo()!=null) {
            usuarioRegProceso = incumplimientoContrVo.getUsuarioRegistraVo();
            
            OperadorVO operadorVo = incumplimientoContrVo.getOperadorVo();
            
            if (operadorVo!=null) {
                // Obtener Parametro Sistema Tiempo Inhabilidad
                Integer DURACION_INHABILIDADES = null;
                ParametrosSistemaVO parametro = adminParametrosSistema.buscarParametroPorId(EnumParametrosSistema.DURACION_INHABILIDADES.getId());
                if (parametro!=null && parametro.getPsiValor()!=null) {
                    DURACION_INHABILIDADES = Integer.parseInt(parametro.getPsiValor());
                }
                else {
                    this.imprimirLog(tituloLog, "No se encuentra el parámetro de DURACION_INHABILIDADES.", usuarioRegProceso);
                }
                
                
                if (DURACION_INHABILIDADES!=null) {
                    PersonaVO personaOperador = operadorVo.getPersonaVo();
                    
                    if (personaOperador!=null && personaOperador.getPerCodigo()!=null) {
                        // Buscar si ya existe una inhabilidad para la Persona
                        InhabilidadPersonaVO inhabilidadPersonaVo = 
                            adminInhabilidadPersona.buscarInhabilidadPersonaPorIdPersonaYTipoProceso(personaOperador.getPerCodigo(), 
                                                                                                     incumplimientoContrVo.getIcnCodigo(), 
                                                                                                     EnumTipoProcesoGCT.INCUMPLIMIENTO_CONTRACTUAL.getId());
                        
                        if (inhabilidadPersonaVo==null) {
                            // Crear un nuevo registro de Inhabilidad Persona.
                            inhabilidadPersonaVo = new InhabilidadPersonaVO();
                        }
                        
                        
                        if (!EnumDecision.SI.getId().equals(inhabilidadPersonaVo.getIpeActivo())) {
                            
                            // Establecer la fecha de Inicio Inhabilidad.
                            Date fechaIniInhab = fechaInicioInhabilidad;
                            
                            // Establecer la fecha de Fin de Inhabilidad
                            Calendar calendarFin = Calendar.getInstance();
                            calendarFin.setTime(fechaIniInhab);
                            calendarFin.add(Calendar.MONTH, DURACION_INHABILIDADES);
                            calendarFin.add(Calendar.DAY_OF_MONTH, -1);
                            Date fechaFinInhab = calendarFin.getTime();
                            
                            inhabilidadPersonaVo.setIncumplimientoContrVo(incumplimientoContrVo);
                            inhabilidadPersonaVo.setPersonaVo(personaOperador);
                            inhabilidadPersonaVo.setIpeActivo(EnumDecision.SI.getId());
                            inhabilidadPersonaVo.setUsuarioConecVo(incumplimientoContrVo.getUsuarioRegistraVo());
                            inhabilidadPersonaVo.setIpeFechaIni(fechaIniInhab);
                            inhabilidadPersonaVo.setIpeFechaFin(fechaFinInhab);
                            
                            
                            // Almacenar el registro de Inhabilidad Persona
                            exitoso = this.almacenarInhabilidadPersona(inhabilidadPersonaVo);
                        }
                        else {
                            this.imprimirLog(tituloLog, "El operador con NIT "+personaOperador.getPerNumIdentificacion()+" ya se encontraba Inhabilitado.", usuarioRegProceso);
                        }
                    }
                }
            }
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * <b>FLUJO 12</b>: <i>Liquidar Valor Multa</i>.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual al cual se le liquidar&aacute; el valor de la multa.
     * @param tipoResolucion - Tipo de Resoluci&oacute;n (<i>OPCIONAL</i>: Por defecto toma el tipo de resoluci&oacute;n a partir de la resoluci&oacute;n asociada al proceso de incumplimiento).
     * @throws Exception
     */
    @Override
    public String liquidarValorMulta(IncumplimientoContrVO incumplimientoContrVo, String tipoResolucion) throws ExcepcionDAO 
    {
        String mensajeError = null;
        
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - liquidarValorMulta";
        
        
        if (incumplimientoContrVo!=null) {
            
            InformeSupervisionVO informeSupervisionVo = incumplimientoContrVo.getInformeSupervisionVo();
            ResolucionIncumContrVO resolucion = incumplimientoContrVo.getResolucionIncumContrResolVo();
            
            if (informeSupervisionVo!=null) {
                
                if (tipoResolucion==null && resolucion!=null)
                    tipoResolucion = resolucion.getRcoTipoResol();
                    
                
                if (tipoResolucion!=null) {
                    ///////////
                    // MULTA //
                    ///////////
                    if (EnumTipoResolucion.MULTA.getId().equals(tipoResolucion)) {
                        MotivoIncumplimientoVO motivoIncumplimientoVo = informeSupervisionVo.getMotivoIncumplimiento();
                        
                        
                        // ********************************* //
                        // * Liquidacion Valor de la Multa * //
                        // ********************************* //
                        
                        if (motivoIncumplimientoVo!=null) {
                            // Busca el Tipo de multa asociado al motivo del incumplimiento en la tabla Motivos incumplimiento.
                            TipoMultaVO tipoMultaVo = motivoIncumplimientoVo.getTipoMultaVo();
                            
                            if (tipoMultaVo!=null && tipoMultaVo.getTmuCodigo()!=null) {
                                Long tmuCodigo = tipoMultaVo.getTmuCodigo();
                                
                                BigDecimal valorTotalContrato = new BigDecimal(0);
                                BigDecimal multaDia = new BigDecimal(0);
                                BigDecimal multaTotal = new BigDecimal(0);
                                
                                
                                
                                // validar el Tipo de Multa
                                if ( EnumTipoMulta.GENERAL.getId().equals(tmuCodigo) || 
                                     EnumTipoMulta.POLIZA.getId().equals(tmuCodigo) ) 
                                {
                                    //
                                    // 1. Halla el valor total del contrato.
                                    //
                                    ContratoVO contratoVo = informeSupervisionVo.getContratoVo();
                                    if (contratoVo!=null && contratoVo.getEstadoContratoVo()!=null && contratoVo.getConCodigo()!=null) {
                                        // valida el estado del contrato
                                        if (EnumEstadoContrato.PERFECCIONADO.getId().equals(contratoVo.getEstadoContratoVo().getEcoCodigo())) {
                                            // Toma el valor total del contrato del oficio de liquidacion asociado a la solicitud de autorizacion que dio origen al contrato.
                                            SolicitudAutorizaVO solicitudAutorizaVo = contratoVo.getSolicitudAutorizaVo();
                                            
                                            if (solicitudAutorizaVo!=null && solicitudAutorizaVo.getSauCodigo()!=null) {
                                                // Carga la informacion del oficio de liquidacion relacionada en la solicitud de autorizacion
                                                List<OficioLiquidacionVO> oficioLiquidacionListVo = adminOficioLiquidacion.buscarOficioLiquidacionPorSolicitudAutorizacion(solicitudAutorizaVo.getSauCodigo());
                                                solicitudAutorizaVo.setOficioLiquidacionListVo(oficioLiquidacionListVo);
                                                
                                                if (solicitudAutorizaVo.getOficioLiquidacionListVo()!=null) {
                                                    valorTotalContrato = solicitudAutorizaVo.getTotalOficioLiquidacion();
                                                }
                                            }
                                        }
                                        else {
                                            // Invoca el metodo para calcular el Valor total del contrato.
                                            valorTotalContrato = adminContrato.calculoValorContratoConcesion(contratoVo.getConCodigo());
                                        }
                                    }
                                    
                                    
                                    //
                                    // 2. Calcula la multa diaria.
                                    //
                                    if (tipoMultaVo.getTmuFactor()!=null) {
                                        BigDecimal factor = tipoMultaVo.getTmuFactor().divide(new BigDecimal("100"));
                                        
                                        if (EnumTipoMulta.GENERAL.getId().equals(tmuCodigo)) {
                                            // Multa Dia = Valor total del contrato * Factor asociado a Tipo multa en la tabla Tipos multa.
                                            multaDia = valorTotalContrato.multiply(factor);
                                        }
                                        else if (EnumTipoMulta.POLIZA.getId().equals(tmuCodigo)) {
                                            // Multa Dia = (Valor total del contrato * Factor asociado a Tipo multa en la tabla Tipos multa) / (Duración del contrato en annos * 360)
                                            int duracionMeses = contratoVo.getDuracionEnMeses();
                                            
                                            if (duracionMeses>0) {
                                                BigDecimal duracionAnnos = new BigDecimal( String.valueOf( ((double)duracionMeses) / 12D) );
                                                duracionAnnos = this.redondear(duracionAnnos);
                                                if (duracionAnnos.compareTo(BigDecimal.ZERO)!=0)
                                                    multaDia = ( valorTotalContrato.multiply(factor) ).divide( (duracionAnnos.multiply(new BigDecimal("360"))), 2, RoundingMode.HALF_UP );
                                            }
                                        }
                                        
                                        
                                        // Asignar Valor Multa
                                        multaDia = this.redondear(multaDia);
                                        incumplimientoContrVo.setIcnValorMulta(multaDia);
                                    }
                                }
                                
                                else if (EnumTipoMulta.TRASLADO.getId().equals(tmuCodigo)) {
                                    // Multa Total = (Salario minimo mensual legal vigente / 30) * Factor asociado a Tipo multa en la tabla Tipos multa * Cantidad de elementos trasladados segun el Informe de supervision.
                                    
                                    // Consultar el Salario Minimo Mensual Legal Vigente
                                    Calendar calendar = Calendar.getInstance();
                                    Integer vigencia = calendar.get(Calendar.YEAR);
                                    Long SMMLV = adminSMMLV.buscarSmmlvPorVigencia(vigencia);
                                    
                                    
                                    // Obtener la cantidad de elementos trasladados del informe de supervision
                                    Integer icnCantidadElem = incumplimientoContrVo.getIcnCantidadElem();
                                    
                                    if (icnCantidadElem!=null && tipoMultaVo.getTmuFactor()!=null && SMMLV!=null) {
                                        BigDecimal smmlvDiario = new BigDecimal(SMMLV+"").divide(new BigDecimal("30"), 2, RoundingMode.HALF_UP);
                                        smmlvDiario = this.redondear(smmlvDiario);
                                        BigDecimal factor = tipoMultaVo.getTmuFactor();
                                        
                                        multaTotal = smmlvDiario.multiply(factor).multiply(new BigDecimal(icnCantidadElem+""));
                                        
                                        
                                        // Asignar Valor Multa
                                        multaTotal = this.redondear(multaTotal);
                                        incumplimientoContrVo.setIcnValorMulta(multaTotal);
                                    }
                                    else {
                                        if (SMMLV==null)
                                            mensajeError = "No se ha establecido el valor del Salario Mínimo para la Vigencia "+vigencia+".";
                                        if (tipoMultaVo.getTmuFactor()==null)
                                            mensajeError = "No se ha establecido el Factor para el Tipo de Multa "+tipoMultaVo.getTmuNombre()+".";
                                        if (icnCantidadElem==null)
                                            mensajeError = "No se ha establecido la Cantidad de Elementos para el proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".";
                                    }
                                }
                                else {
                                    mensajeError = "El Tipo de Multa "+tipoMultaVo.getTmuNombre()+" no es válido para liquidar el valor de multa del proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".";
                                }
                            }
                            else {
                                mensajeError = "No se encuentra asociado un Tipo de Multa asociado al Motivo de Incumplimiento "+motivoIncumplimientoVo.getMinNombre()+" no es válido para liquidar el valor de multa del proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".";
                            }
                        }
                        else {
                            mensajeError = "No se ha establecido un Motivo de Incumplimiento para el informe de supervisión "+informeSupervisionVo.getConsecutivo()+" ("+informeSupervisionVo.getIsuCodigo()+").";
                        }
                        
                        
                        if (mensajeError==null || mensajeError.isEmpty()) {
                            
                            // ************************************ //
                            // * Liquidacion Valor Clausula Penal * //
                            // ************************************ //
                            ContratoVO contratoVo = informeSupervisionVo.getContratoVo();
                            if (contratoVo!=null && contratoVo.getConCodigo()!=null) {
                                
                                // Buscar el Tipo de Multa CLAUSULA PENAL para obtener el factor.
                                TipoMultaVO tipoMultaCPenal = adminTipoMulta.buscarTipoMultaPorId(EnumTipoMulta.CLAUSULA_PENAL.getId());
                                
                                
                                if (tipoMultaCPenal!=null && tipoMultaCPenal.getTmuFactor()!=null) {
                                    BigDecimal factor = tipoMultaCPenal.getTmuFactor().divide(new BigDecimal("100"));
                                    
                                    // Calcula el valor ejecutado del contrato
                                    BigDecimal valorEjecutadoContrato = adminContrato.calcularValorEjecutadoContrato(contratoVo);
                                    
                                    if (valorEjecutadoContrato!=null) {
                                        BigDecimal valorClausulaPenal = valorEjecutadoContrato.multiply(factor);
                                        
                                        
                                        // Asignar Valor Clausula Penal
                                        valorClausulaPenal = this.redondear(valorClausulaPenal);
                                        incumplimientoContrVo.setIcnValorClausulaP(valorClausulaPenal);
                                    }
                                    else {
                                        mensajeError = "No fue posible calcular el Valor Ejecutado del Contrato "+contratoVo.getConNumero()+".";
                                    }
                                }
                                else {
                                    mensajeError = "No existe el Tipo de Multa CLÁUSULA PENAL.";
                                }
                            }
                            else {
                                mensajeError = "No existe Contrato asociado al Informe de Supervisión "+informeSupervisionVo.getConsecutivo()+" ("+informeSupervisionVo.getIsuCodigo()+").";
                            }
                        }
                    }
                    else {
                        mensajeError = "No se liquida el valor de la Multa si el Tipo de Resolución No es MULTA.";
                    }
                }
                else {
                    mensajeError = "No existe un Tipo de Resolución asociado al proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".";
                }
            }
            else {
                mensajeError = "No se encuentra un Informe de Supervisión asociado al proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".";
            }
        }
        else {
            mensajeError = "Debe especificar un proceso de Incumplimiento al cual liquidarle el valor de la multa.";
        }
        
        
        
        if (mensajeError!=null)
            this.imprimirLog(tituloLog, mensajeError, incumplimientoContrVo.getUsuarioRegistraVo());
        
        
        return (mensajeError);
    }
    
    
    
    /**
     * <b>FLUJO 17</b>: <i>Registrar Caducidad</i>.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @throws Exception
     */
    public boolean registrarCaducidad(IncumplimientoContrVO incumplimientoContrVo) throws Exception 
    {
        boolean exitoso = false;
        
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - registrarCaducidad";
        
        
        
        Integer PORCENTAJE_GASTOS_ADMINISTRACION = null;
        ParametrosSistemaVO parametro = adminParametrosSistema.buscarParametroPorId(EnumParametrosSistema.PORCENTAJE_GASTOS_ADMINISTRACION.getId());
        if (parametro!=null && parametro.getPsiValor()!=null) {
            PORCENTAJE_GASTOS_ADMINISTRACION = Integer.parseInt(parametro.getPsiValor());
        }
        
        if (incumplimientoContrVo!=null && PORCENTAJE_GASTOS_ADMINISTRACION!=null) {
            
            ContratoVO contratoVo = incumplimientoContrVo.getContratoVo();
            ResolucionIncumContrVO resolucionIncumplimiento = incumplimientoContrVo.getResolucionIncumContrResolVo();
            Date fechaResolFirme = resolucionIncumplimiento!=null ? resolucionIncumplimiento.getRcoFechaResolFirme() : null;
            
            if (contratoVo!=null && contratoVo.getConCodigo()!=null && contratoVo.getConNumero()!=null && fechaResolFirme!=null) {
                // 1. Toma todos los elementos del contrato que se encuentren en estado ACTIVO.
                List<InventarioVO> nuevoInventario = new ArrayList<InventarioVO>();
                List<InventarioVO> listaInventario = adminInventario.buscarInventarioActivoPorContrato(contratoVo.getConNumero());
                
                if (listaInventario!=null && !listaInventario.isEmpty()) {
                    for (InventarioVO invVo: listaInventario) {
                        if (invVo!=null) {
                            // Crear una copia del registro de inventario
                            InventarioVO inventarioVo = invVo.clone();
                            inventarioVo.setInvCodigo(null);
                            inventarioVo.setInvFechaFinLiq(fechaResolFirme);
                            
                            // Coloca INACTIVO el registro original del inventario
                            invVo.setInvEstado(EnumEstadoInventario.INACTIVO.getId());
                            
                            // Adicionar ambos registros al nuevo inventario
                            nuevoInventario.add(inventarioVo);
                            nuevoInventario.add(invVo);
                        }
                    }
                }
                else {
                    //this.imprimirLog(tituloLog, "El Contrato "+contratoVo.getConNumero()+" no posee elementos de Inventario.", incumplimientoContrVo.getUsuarioRegistraVo());
					
                    nuevoInventario = null;
                }
                
                
                
                
                // 2. Invoca el metodo para calcular el valor por ejecutar del contrato
                BigDecimal valorPorEjecutar = adminContrato.calculoValorXEjecutarContratoConc(contratoVo.getConCodigo());
                
                if (valorPorEjecutar!=null) {
                    BigDecimal cien = new BigDecimal("100");
                    // POR_EJEC_DE = VALOR POR EJECUTAR * 100 / (100 + PARAMETRO PORCENTAJE GASTOS DE ADMINISTRACION)
                    BigDecimal POR_EJEC_DE = ( valorPorEjecutar.multiply(cien) ).divide( cien.add(new BigDecimal(PORCENTAJE_GASTOS_ADMINISTRACION+"")), 2, RoundingMode.HALF_UP );
                    POR_EJEC_DE = this.redondear(POR_EJEC_DE);
                    
                    // POR_EJEC_GA = POR_EJEC_DE * PARAMETRO PORCENTAJE GASTOS DE ADMINISTRACION
                    BigDecimal POR_EJEC_GA = POR_EJEC_DE.multiply( new BigDecimal(( ((double)PORCENTAJE_GASTOS_ADMINISTRACION) / 100D )+"") );
                    POR_EJEC_GA = this.redondear(POR_EJEC_GA);
                    
                    
                    
                    // 3. Coloca el Contrato en Estado Ejecucion CADUCIDAD.
                    EstadoContratoVO estadoContratoVo = adminEstadoContrato.buscarEstadoContratoPorId(EnumEstadoContrato.CADUCIDAD.getId());
                    contratoVo.setEstadoContratoVo(estadoContratoVo);
                    
                    
                    
                    if (estadoContratoVo!=null) {
                    
                        // 4. Coloca la Fecha en firme de la Resolucion de Incumplimiento en Fecha Final definitiva del Contrato.
                        contratoVo.setConFechaFinDefin(fechaResolFirme);
                        
                        // 5. Actualiza el Contrato colocando el dato Vigente = NO
                        contratoVo.setConVigente(EnumDecision.NO.getId());
                        
                        
                        // 6. Busca las cuotas generadas por los conceptos DE y GA, correspondientes al contrato y al mes de fecha en firme de la resolucion de incumplimiento,
                        //    y los meses posteriores hasta la ultima liquidacion mensual realizada.
                        List<String> conceptos = new ArrayList<String>();
                        conceptos.add(EnumConceptoLiquidacion.DERECHOS_DE_EXPLOTACION.getId());
                        conceptos.add(EnumConceptoLiquidacion.GASTOS_DE_ADMINISTRACION.getId());
                        
                        List<CuotaOperadorVO> listaCuotaOperador = null;
                        
                        // buscar la fecha de laa liquidacion mensual realizada para el contrato en mencion
                        Date fechaActual = new Date(System.currentTimeMillis());
                        List<LiquidacionMesVO> liquidaciones = adminLiquidacionMes.obtenerLiquidacionPorContratoYConceptos(contratoVo.getConCodigo(), contratoVo.getConFechaIni(), fechaActual);
                        
                        if (liquidaciones!=null && !liquidaciones.isEmpty()) {
                            // el primer registro de las liquidaciones obtenidas corresponde al ultimo registro de liquidacion mes realizado.
                            LiquidacionMesVO ultimaLiquidacion = liquidaciones.get(0);
                            Date fechaUltimaLiquidacion = ultimaLiquidacion!=null ? ultimaLiquidacion.getLiqFecha() : null;
                            
                            if (fechaUltimaLiquidacion!=null) {
                                listaCuotaOperador = 
                                        adminCuotaOperador.buscarCuotaOperadorXContratoXFechaXConcepto(contratoVo.getConCodigo(), 
                                                                                                        fechaResolFirme, 
                                                                                                        fechaUltimaLiquidacion, // Fecha de la ultima liquidacion
                                                                                                        conceptos);
                            }
                        }
                        
                        if (listaCuotaOperador!=null && !listaCuotaOperador.isEmpty()) {
                            for (CuotaOperadorVO cuotaOperadorVo: listaCuotaOperador) {
                                if (cuotaOperadorVo!=null) {
                                    // Inactivar la Cuota Operador
                                    cuotaOperadorVo.setCopCancelada(EnumEstadoCuotaOperador.INACTIVA.getId());
                                }
                            }
                        }
                        else {
                            this.imprimirLog(tituloLog, "No se encontraron registros de Cuota Operador para el Contrato "+contratoVo.getConNumero()+" para Inactivar.", incumplimientoContrVo.getUsuarioRegistraVo());
                        }
                        
                        
                        // 7. Ejecuta el Flujo 18: Movimiento Contable Caducidad
                        List<DocumentoContableVO> listaDocumentoContable = 
                            this.generarMovimientoContableCaducidad(incumplimientoContrVo, listaCuotaOperador, POR_EJEC_DE, POR_EJEC_GA);
                        
                        
                        if (listaDocumentoContable!=null && !listaDocumentoContable.isEmpty()) 
                        {
                            // Adicionar los Documentos Contables al Proceso de Incumplimiento.
                            for (DocumentoContableVO dcoVo: listaDocumentoContable) {
                                if (dcoVo!=null)
                                    incumplimientoContrVo.addDocumentoContable(dcoVo);
                            }
                            
                            
                            // Almacenar el Proceso de Incumplimiento junto a sus Documentos Contables, Inventario, Cuotas y Contrato.
                            this.almacenarIncumplimientoContractual(incumplimientoContrVo, true, nuevoInventario, contratoVo, listaCuotaOperador);
                            
                            exitoso = true;
                        }
                        else {
                            this.imprimirLog(tituloLog, "No fueron creados los documentos contables de Caducidad para el proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".", incumplimientoContrVo.getUsuarioRegistraVo());
                        }
                    }
                    else {
                        this.imprimirLog(tituloLog, "No se encuentra parametrizado el tipo de documento de Caducidad.", incumplimientoContrVo.getUsuarioRegistraVo());
                    }
                }
                else {
                    this.imprimirLog(tituloLog, "No fue posible calcular el Valor por Ejecutar para el Contrato "+contratoVo.getConNumero()+".", incumplimientoContrVo.getUsuarioRegistraVo());
                }
            }
            else {
                this.imprimirLog(tituloLog, "No se encuentra la información asociada al Contrato para el proceso "+incumplimientoContrVo.getIcnConsecutivo()+".", incumplimientoContrVo.getUsuarioRegistraVo());
            }
        }
        else {
            this.imprimirLog(tituloLog, "No se encuentra el proceso al cual realizarle el proceso de Caducidad.", incumplimientoContrVo.getUsuarioRegistraVo());
        }
        
        return (exitoso);
    }
    
    
    
    
    /**
     * <b>FLUJO 18</b>: <i>Movimiento Contable CADUCIDAD</i>.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @param listaCuotaOperador - Listado de Cuota Operador.
     * @param valorPorEjecutarDE - Valor Por Ejecutar (Derechos Explotaci&oacute;n).
     * @param valorPorEjecutarGA - Valor Por Ejecutar (Gastos Administraci&oacute;n).
     * @throws Exception
     */
    private List<DocumentoContableVO> generarMovimientoContableCaducidad (IncumplimientoContrVO incumplimientoContrVo, List<CuotaOperadorVO> listaCuotaOperador, BigDecimal valorPorEjecutarDE, BigDecimal valorPorEjecutarGA) throws Exception 
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - generarMovimientoContableCaducidad";
        
        
        
        List<DocumentoContableVO> resultado = null;
        boolean consistente = true;
        
        
        if (incumplimientoContrVo!=null && 
            valorPorEjecutarDE!=null && valorPorEjecutarGA!=null) 
        {
            TipoDocContableVO tdcACC = adminTipoDocContable.buscarPorCodigoTipoDocContable(EnumTipoDocContable.AMORTIZACION_CONTRATOS_DE_CONCESION.getId());
            TipoDocContableVO tdcCCD = adminTipoDocContable.buscarPorCodigoTipoDocContable(EnumTipoDocContable.CADUCIDAD.getId());
            
			// redondear cifras
			valorPorEjecutarDE = this.redondear(valorPorEjecutarDE);
			valorPorEjecutarGA = this.redondear(valorPorEjecutarGA);
			
            
            Date fechaActual = new Date(System.currentTimeMillis());
            
            // obtener el estado BORRADOR del Documento Contable.
            EstadoDocContabVO estadoDocContabVo = adminEstadoDocContab.buscarPorCodigoEstadoDocContab(EnumEstadoDocContab.BORRADOR.getId());
            
            
            if (tdcACC!=null) {
                if (tdcCCD!=null) {
                    if (estadoDocContabVo!=null) {
                        
                        resultado = new ArrayList<DocumentoContableVO>();
                        
                        if (listaCuotaOperador!=null && !listaCuotaOperador.isEmpty()) {
                            
                            ////////////////////////////////////////////////////////////////
                            // 1. REVERSION MOVIMIENTO CONTABLE CUOTAS QUE SE INACTIVARON //
                            ////////////////////////////////////////////////////////////////
                            
                            // obtener el primer consecutivo del tipo de documento contable
                            Integer consecutivoACC = adminDocumentoContable.buscarConsecutivoDocumentoContable(EnumTipoDocContable.AMORTIZACION_CONTRATOS_DE_CONCESION.getId());
                            
                            if (consecutivoACC!=null) {
                                // Por c/u de las liquidaciones mensuales que se encuentran Inactivas
                                Iterator<CuotaOperadorVO> itCOP = listaCuotaOperador.iterator();
                                while (itCOP.hasNext() && consistente) {
                                    CuotaOperadorVO cuotaOperadorVo = itCOP.next();
                                    if (cuotaOperadorVo!=null && cuotaOperadorVo.getLiquidacionMesVo()!=null) {
                                        
                                        //////////////////////////////////////////////////////
                                        // MOVIMIENTO CONTABLE DE CUOTAS QUE SE INACTIVARON //
                                        //////////////////////////////////////////////////////
                                        DocumentoContableVO dcoCuotasInactivas = new DocumentoContableVO();
                                        dcoCuotasInactivas.setIncumplimientoContrVo(incumplimientoContrVo);
                                        dcoCuotasInactivas.setUsuarioRegistraVo(incumplimientoContrVo.getUsuarioRegistraVo());
                                        dcoCuotasInactivas.setTipoDocContableVo(tdcACC);
                                        dcoCuotasInactivas.setDcoFechaOper(fechaActual);
                                        dcoCuotasInactivas.setEstadoDocContabVo(estadoDocContabVo);
                                        // buscar el consecutivo del documento contable
                                        Integer numComprACC = consecutivoACC++;
                                        dcoCuotasInactivas.setDcoNumeroCompr(numComprACC);
                                        List<ImputacionContableVO> listaImpContabCaducidad = this.generarImputacionContableCaducidadCuotasInactivas(incumplimientoContrVo, dcoCuotasInactivas, cuotaOperadorVo);
                                        dcoCuotasInactivas.setImputacionContableList(listaImpContabCaducidad);
                                        
                                        consistente = Utilidades.isConsistenteDocumentoContable(dcoCuotasInactivas);
                                        
                                        if (consistente)
                                            resultado.add(dcoCuotasInactivas);
                                    }
                                }
                            }
                        }
                        
                        
                        
                        if (consistente) {
                        
                            ///////////////////////////////////////////////////////////
                            // 2. REVERSION VALOR ESTIMADO DEL CONTRATO POR EJECUTAR //
                            ///////////////////////////////////////////////////////////
                            
                            /////////////////////////////////////////////////////////////
                            // MOVIMIENTO CONTABLE DEL VALOR DEL CONTRATO POR EJECUTAR //
                            /////////////////////////////////////////////////////////////
                            DocumentoContableVO dcoValorEjecutar = new DocumentoContableVO();
                            dcoValorEjecutar.setIncumplimientoContrVo(incumplimientoContrVo);
                            dcoValorEjecutar.setUsuarioRegistraVo(incumplimientoContrVo.getUsuarioRegistraVo());
                            dcoValorEjecutar.setTipoDocContableVo(tdcCCD);
                            dcoValorEjecutar.setDcoFechaOper(fechaActual);
                            dcoValorEjecutar.setEstadoDocContabVo(estadoDocContabVo);
                            // buscar el consecutivo del documento contable
                            Integer numComprCCD = adminDocumentoContable.buscarConsecutivoDocumentoContable(EnumTipoDocContable.CADUCIDAD.getId());
                            dcoValorEjecutar.setDcoNumeroCompr(numComprCCD);
                            List<ImputacionContableVO> listaImpContabCaducidad = this.generarImputacionContableCaducidadValorPorEjecutar(incumplimientoContrVo, dcoValorEjecutar, valorPorEjecutarDE, valorPorEjecutarGA);
                            dcoValorEjecutar.setImputacionContableList(listaImpContabCaducidad);
                            
                            
                            consistente = Utilidades.isConsistenteDocumentoContable(dcoValorEjecutar);
                            
                            
                            if (consistente)
                                resultado.add(dcoValorEjecutar);
                            else
                                this.imprimirLog(tituloLog, "Inconsistencias en el Documento Contable del Valor del Contrato por Ejecutar para el proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".", incumplimientoContrVo.getUsuarioRegistraVo());
                            
                        }
                        else {
                            this.imprimirLog(tituloLog, "Inconsistencias en el Documento Contable de Cuotas que se Inactivaron para el proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".", incumplimientoContrVo.getUsuarioRegistraVo());
                        }
                    }
                    else {
                        this.imprimirLog(tituloLog, "No se encuentra parametrizado el estado de Documento Contable BORRADOR.", incumplimientoContrVo.getUsuarioRegistraVo());
                        
                        consistente = false;
                    }
                }
                else {
                    this.imprimirLog(tituloLog, "No se encuentra parametrizado el tipo de documento contable "+EnumTipoDocContable.CADUCIDAD.getId()+".", incumplimientoContrVo.getUsuarioRegistraVo());
                    
                    consistente = false;
                }
            }
            else {
                this.imprimirLog(tituloLog, "No se encuentra parametrizado el tipo de documento contable "+EnumTipoDocContable.AMORTIZACION_CONTRATOS_DE_CONCESION.getId()+".", incumplimientoContrVo.getUsuarioRegistraVo());
                
                consistente = false;
            }
            
            
        }
        else {
            if (incumplimientoContrVo!=null) {
                if (valorPorEjecutarDE==null)
                    this.imprimirLog(tituloLog, "No se ha calculado el Valor por Ejecutar de Derechos de Explotación para el proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".", incumplimientoContrVo.getUsuarioRegistraVo());
                else if (valorPorEjecutarGA==null)
                    this.imprimirLog(tituloLog, "No se ha calculado el Valor por Ejecutar de Gastos de Administración para el proceso de Incumplimiento "+incumplimientoContrVo.getIcnConsecutivo()+".", incumplimientoContrVo.getUsuarioRegistraVo());
            }
            else {
                this.imprimirLog(tituloLog, "No se ha especificado el proceso de Incumplimiento para generar el movimiento contable de Caducidad.", incumplimientoContrVo.getUsuarioRegistraVo());
            }
            
            consistente = false;
        }
        
        
        if (!consistente)
            resultado = null;
        
        return (resultado);
    }
    
    
    
    /**
     * Genera el listado de Imputaciones Contables asociados a un Documento Contable de Caducidad. (Flujo 18).
     * - PARTE 1: <i>Reversi&oacute;n Movimiento Contable Cuotas que se Inactivaron</i>.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @param documentoContableVo - Documento Contable.
     * @param cuotaOperadorVo - Cuota Operador.
     * @return Listado de Imputaciones Contables.
     * @throws Exception
     */
    private List<ImputacionContableVO> generarImputacionContableCaducidadCuotasInactivas (IncumplimientoContrVO incumplimientoContrVo, DocumentoContableVO documentoContableVo, CuotaOperadorVO cuotaOperadorVo) throws Exception
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - generarImputacionContableCaducidadCuotasInactivas";
        
        
        
        List<ImputacionContableVO> resultado = null;
        boolean valido = true;
        
        
        if (incumplimientoContrVo!=null) {
            if (documentoContableVo!=null && documentoContableVo.getTipoDocContableVo()!=null && 
                cuotaOperadorVo!=null && cuotaOperadorVo.getCopNumerocuota()!=null && 
                cuotaOperadorVo.getLiquidacionMesVo()!=null && cuotaOperadorVo.getLiquidacionMesVo().getLmeCodigo()!=null) 
            {
                LiquidacionMesVO liquidacionMesVo = cuotaOperadorVo.getLiquidacionMesVo();
                String numeroCuota = String.valueOf(cuotaOperadorVo.getCopNumerocuota());
                
                String tdcCodigo = documentoContableVo.getTipoDocContableVo().getTdcCodigo();
                if (tdcCodigo!=null) {
                    
                    InformeSupervisionVO informeSupervisionVo = incumplimientoContrVo.getInformeSupervisionVo();
                    ContratoVO contratoVo = informeSupervisionVo!=null ? informeSupervisionVo.getContratoVo() : null;
                    String numeroContrato = contratoVo!=null ? contratoVo.getConNumero() : null;
                    
                    
                    if (contratoVo!=null && numeroContrato!=null) {
                        // Busca el Documento Contable ACC asociado a la Liquidacion Mensual especificada.
                        List<DocumentoContableVO> listaDocContabLM = adminDocumentoContable.buscarPorIdLiquidacionMes(liquidacionMesVo.getLmeCodigo(), tdcCodigo);
                        DocumentoContableVO documentoContableLM = listaDocContabLM!=null && !listaDocContabLM.isEmpty() ? listaDocContabLM.get(0) : null;
                        
                        if (documentoContableLM!=null) {
                            List<ImputacionContableVO> listaImputacionContableLM = documentoContableLM.getImputacionContableList();
                            
                            if (listaImputacionContableLM!=null && !listaImputacionContableLM.isEmpty()) {
                                resultado = new ArrayList<ImputacionContableVO>();
                                
                                for (ImputacionContableVO imcVo: listaImputacionContableLM) {
                                    // Buscar unicamente los registros cuya Referencia 1 corresponda al Numero de Contrato, y Referencia 2 corresponda al Numero de Cuota.
                                    if (imcVo!=null && imcVo.getImcReferencia1()!=null && imcVo.getImcReferencia2()!=null && 
                                        numeroContrato.equals(imcVo.getImcReferencia1()) && 
                                        numeroCuota.equals(imcVo.getImcReferencia2())) 
                                    {
                                        //////////////////////////////////////////////
                                        // Crear el registro de Imputacion Contable //
                                        //////////////////////////////////////////////
                                        ImputacionContableVO imputacionContableVo = new ImputacionContableVO();
                                        imputacionContableVo.setCuentasContablesVo(imcVo.getCuentasContablesVo());
                                        
                                        // Establecer Movimiento contrario al que proviene de la Liquidacion Mensual.
                                        String tipoMovimiento = null;
                                        if (EnumTipoMovimiento.DEBITO.getId().equals(imcVo.getImcTipoMovim()))
                                            tipoMovimiento = EnumTipoMovimiento.CREDITO.getId();
                                        else if (EnumTipoMovimiento.CREDITO.getId().equals(imcVo.getImcTipoMovim()))
                                            tipoMovimiento = EnumTipoMovimiento.DEBITO.getId();
                                        
                                        imputacionContableVo.setImcTipoMovim(tipoMovimiento);
                                        imputacionContableVo.setImcValor(imcVo.getImcValor());
                                        imputacionContableVo.setImcEstado(imcVo.getImcEstado());
                                        imputacionContableVo.setImcReferencia1(imcVo.getImcReferencia1());
                                        imputacionContableVo.setImcReferencia2(imcVo.getImcReferencia2());
                                        imputacionContableVo.setAreaColjuegosVo(imcVo.getAreaColjuegosVo());
                                        imputacionContableVo.setFuenteFinancContabVo(imcVo.getFuenteFinancContabVo());
                                        imputacionContableVo.setPersonaVo(imcVo.getPersonaVo());
                                        imputacionContableVo.setImcDescrOperacion("REVERSIÓN CUOTA No. "+numeroCuota+".");
                                        
                                        resultado.add(imputacionContableVo);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Genera el listado de Imputaciones Contables asociados a un Documento Contable de Caducidad. (Flujo 18).
     * - PARTE 2: <i>Reversi&oacute;n Valor Estimado del Contrato Por Ejecutar</i>.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @param documentoContableVo - Documento Contable.
     * @param valorPorEjecutarDE - Valor Por Ejecutar (Derechos Explotaci&oacute;n).
     * @param valorPorEjecutarGA - Valor Por Ejecutar (Gastos Administraci&oacute;n).
     * @return Listado de Imputaciones Contables.
     * @throws Exception
     */
    private List<ImputacionContableVO> generarImputacionContableCaducidadValorPorEjecutar (IncumplimientoContrVO incumplimientoContrVo, DocumentoContableVO documentoContableVo, BigDecimal valorPorEjecutarDE, BigDecimal valorPorEjecutarGA) throws Exception
    {
        // Etiqueta que se colocara en el log
        String tituloLog = TITULO_APLICACION+" - generarImputacionContableCaducidadValorPorEjecutar";
        
        
        
        List<ImputacionContableVO> resultado = null;
        
        
        if (incumplimientoContrVo!=null && documentoContableVo!=null && 
            valorPorEjecutarDE!=null && valorPorEjecutarGA!=null) 
        {
            ContratoVO contratoVo = incumplimientoContrVo.getContratoVo();
            String tdcCodigo = documentoContableVo.getIdTipoDocumentoContable();
            
            
            // Busca en la parametrizacion de documentos contables, el tipo de documento CCD
            List<CuentaContTipoDocContVO> listaCCT = adminCuentaContTipoDocCont.buscarSiiCuentaContTipoDocContPorTipoDoc(tdcCodigo);
            
            if (listaCCT!=null && !listaCCT.isEmpty()) {
                
                resultado = new ArrayList<ImputacionContableVO>();
                
                
                for (CuentaContTipoDocContVO cctVo: listaCCT) {
                    if (cctVo!=null && EnumDecision.SI.getId().equals(cctVo.getCctActivo()) && cctVo.getCctConcepto()!=null) {
                        String cctConcepto = cctVo.getCctConcepto();
                        
                        // Por cada registro ACTIVO genera un registro de Imputacion Contable
                        CuentasContablesVO cuentasContablesVo = cctVo.getCuentasContablesVo();
                        
                        if (cuentasContablesVo!=null) {
                            
                            /////////////////////////////////////
                            // ATRIBUTOS SEGUN PLAN DE CUENTAS //
                            /////////////////////////////////////
                            AtributosImputacionContableVO atributos = new AtributosImputacionContableVO();
                            
                            // determinar si el tipo de movimiento de la cuenta contable es Debito o Credito
                            String tipoMovimiento = cctVo.getCctTipoMovim();
                            if (tipoMovimiento!=null) {
                                // TIPO DE MOVIMIENTO
                                atributos.setTipoMovimiento(tipoMovimiento);
                                
                                // OBLIGA TERCERO
                                if (EnumDecision.SI.getId().equals(cuentasContablesVo.getCcoObligaTerc())) {
                                    // Operador del contrato de concesion
                                    OperadorVO operadorVo = contratoVo!=null ? contratoVo.getOperadorVo() : null;
                                    PersonaVO personaVo = operadorVo!=null ? operadorVo.getPersonaVo() : null;
                                    
                                    if (personaVo!=null) {
                                        atributos.setPersonaVo(personaVo);
                                        
                                        atributos.setTercero(personaVo.getPerNumIdentificacion());
                                        
                                        if (personaVo.getTipoIdentificacionVo()!=null)
                                            atributos.setTipoDocTercero(personaVo.getTipoIdentificacionVo().getTidCodigo());
                                    }
                                }
                                
                                // TIPO DOCUMENTO CONTABLE
                                if (EnumDecision.SI.getId().equals(cuentasContablesVo.getCcoTipDocConta())) {
                                    atributos.setTipoComprobante(tdcCodigo);
                                }
                                
                                // NUMERO DE COMPROBANTE
                                if (EnumDecision.SI.getId().equals(cuentasContablesVo.getCcoNumDocConta()))
                                    atributos.setNumeroComprobante(documentoContableVo.getDcoNumeroCompr());
                                
                                // FUENTE DE FINANCIACION (No Aplica)
                                atributos.setFuenteFinancContabVo(null);
                                
                                // CENTRO DE COSTOS (No Aplica)
                                atributos.setCentroCostos(null);
                                atributos.setAreaColjuegosVo(null);
                                
                                // REFERENCIA 1
                                if (EnumDecision.SI.getId().equals(cuentasContablesVo.getCcoReferencia1())) {
                                    if (contratoVo!=null) {
                                        // Referencia 1: Numero del Contrato de concesion
                                        atributos.setReferencia1(contratoVo.getConNumero());
                                    }
                                }
                                
                                // REFERENCIA 2 (No aplica)
                                atributos.setReferencia2(null);
                                
                                
                                // DESCRIPCION DE LA OPERACION
                                String descrOperacion = "NULIDAD ABSOLUTA DE CONTRATO.";
                                atributos.setDescripcionOperacion(descrOperacion);
                                
                                
                                // FECHA DE LA OPERACION
                                atributos.setFechaOperacion(documentoContableVo.getDcoFechaOper());
                                
                                //
                                // VALOR
                                //
                                if (EnumConceptoLiquidacion.DERECHOS_DE_EXPLOTACION.getId().equals(cctConcepto)) 
                                    atributos.setValor(valorPorEjecutarDE);
                                else if (EnumConceptoLiquidacion.GASTOS_DE_ADMINISTRACION.getId().equals(cctConcepto))
                                    atributos.setValor(valorPorEjecutarGA);
                                
                                
                                
                                
                                //////////////////////////////////////////////
                                // Crear el registro de Imputacion Contable //
                                //////////////////////////////////////////////
                                ImputacionContableVO imputacionContableVo = new ImputacionContableVO();
                                imputacionContableVo.setCuentasContablesVo(cuentasContablesVo);
                                imputacionContableVo.setImcTipoMovim(atributos.getTipoMovimiento());
                                imputacionContableVo.setImcValor(atributos.getValor());
                                imputacionContableVo.setImcEstado(EnumEstadoImputacionContable.ACTIVO.getId());
                                imputacionContableVo.setImcReferencia1(atributos.getReferencia1());
                                imputacionContableVo.setImcReferencia2(atributos.getReferencia2());
                                imputacionContableVo.setAreaColjuegosVo(atributos.getAreaColjuegosVo());
                                imputacionContableVo.setFuenteFinancContabVo(atributos.getFuenteFinancContabVo());
                                imputacionContableVo.setPersonaVo(atributos.getPersonaVo());
                                imputacionContableVo.setImcDescrOperacion(atributos.getDescripcionOperacion());
                                
                                resultado.add(imputacionContableVo);
                            }
                        }
                    }
                }
            }
        }
        
        
        return (resultado);
    }
    
    
    /**
     * Almacena la informaci&oacute;n del Proceso de Incumplimiento Contractual, junto con la informaci&oacute;n del Contrato, las Cuotas y el Inventario..
     * @param doCascade - Flag que determina si se persistir&aacute; en cascada la informaci&oacute;n asociada al Proceso de Incumplimiento Contractual.
     * @param listaInventario - Listado de Inventario para persistir.
     * @param contratoVo - Contrato a persistir.
     * @param listaCuotaOperador - Listado de Cuota Operador, que no pertenecen al proceso de Incumplimiento, y que deben persistirse.
     * @return Almacenado?
     * @throws Exception
     */
    private boolean almacenarIncumplimientoContractual (IncumplimientoContrVO incumplimientoContrVo, boolean doCascade, List<InventarioVO> listaInventario, ContratoVO contratoVo, List<CuotaOperadorVO> listaCuotaOperador) throws Exception 
    {
        boolean almacenado = false;
        if (incumplimientoContrVo!=null) {
            
            // Establecer los elementos a persistir junto al proceso de Incumplimiento Contractual.
            if (listaInventario!=null && !listaInventario.isEmpty())
                this.setListaInventarioPersistir(listaInventario);
            if (contratoVo!=null)
                this.setContratoVoPersistir(contratoVo);
            if (listaCuotaOperador!=null)
                this.listaCuotaOperadorPersistir = listaCuotaOperador;
            
            
            
            if (incumplimientoContrVo.getIcnCodigo()==null) {
                // Operacion INSERTAR
                IncumplimientoContrVO icVo = this.insertarIncumplimientoContr(incumplimientoContrVo, doCascade);
                almacenado = icVo!=null;
            }
            else {
                // Operacion ACTUALIZAR
                IncumplimientoContrVO icVo = this.actualizarIncumplimientoContr(incumplimientoContrVo, doCascade);
                almacenado = icVo!=null;
            }
        }
        
        return (almacenado);
    }
    
    
    
    
    /**
     * Establece las listas hijas al value object resultante del almacenamiento de la entidad.
     * @param resultado - Value Object resultante.
     * @param incumplimientoContrVo
     */
    private void asignarHijos (IncumplimientoContrVO resultado, IncumplimientoContrVO incumplimientoContrVo) 
    {
        if (resultado!=null && incumplimientoContrVo!=null) {
            // establecer las resoluciones
            resultado.setResolucionIncumContrRecursoVo(incumplimientoContrVo.getResolucionIncumContrRecursoVo());
            resultado.setResolucionIncumContrResolVo(incumplimientoContrVo.getResolucionIncumContrResolVo());
            
            // establecer las listas a persistir
            resultado.setDireccionProcesalIncListVo(incumplimientoContrVo.getDireccionProcesalIncListVo());
            resultado.setDocumentoContableListVo(incumplimientoContrVo.getDocumentoContableListVo());
            resultado.setActaSuspenAudIncumConListVo(incumplimientoContrVo.getActaSuspenAudIncumConListVo());
            resultado.setCuotaOperadorListVo(incumplimientoContrVo.getCuotaOperadorListVo());
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de las entidades hijas del proceso de Incumplimiento Contractual.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @throws ExcepcionDAO
     */
    private void persistirHijos (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        this.persistirDireccionesProcesales(incumplimientoContrVo);
        this.persistirDocumentosContables(incumplimientoContrVo);
        this.persistirActasSuspAudIncumCon(incumplimientoContrVo);
        this.persistirCuotasOperador(incumplimientoContrVo);
    }
    
    
    /**
     * Almacena la informaci&oacute;n de las Direcciones Procesales pertenecientes al proceso de Incumplimiento Contractual especificado.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @throws ExcepcionDAO
     */
    private void persistirDireccionesProcesales (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO 
    {
        if (incumplimientoContrVo!=null) {
            List<DireccionProcesalIncVO> listaDireccionesProcesales = incumplimientoContrVo.getDireccionProcesalIncListVo();
            if (listaDireccionesProcesales!=null && !listaDireccionesProcesales.isEmpty()) {
                for (DireccionProcesalIncVO dpiVo: listaDireccionesProcesales) {
                    if (dpiVo!=null) {
                        dpiVo.setIncumplimientoContrVo(incumplimientoContrVo);
                        
                        if (dpiVo.getDpiCodigo() == null) {
                            // OPERACION INSERTAR
                            adminDireccionProcesalInc.insertarDireccionProcesalInc(dpiVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminDireccionProcesalInc.actualizarDireccionProcesalInc(dpiVo);
                        }
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de las Resoluciones de Proceso de Incumplimiento Contractual que Originan y Resuelven el Recurso.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @throws ExcepcionDAO
     */
    private void persistirResoluciones (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO {
        if (incumplimientoContrVo!=null) {
            ResolucionIncumContrVO resolucionOriginaRecurso = incumplimientoContrVo.getResolucionIncumContrResolVo();
            ResolucionIncumContrVO resolucionResuelveRecurso = incumplimientoContrVo.getResolucionIncumContrRecursoVo();
            
            if (resolucionOriginaRecurso!=null) {
                if (resolucionOriginaRecurso.getRcoCodigo()==null) {
                    // OPERACION INSERTAR
                    ResolucionIncumContrVO resultado = adminResolucionIncumContr.insertarResolucionIncumContr(resolucionOriginaRecurso, true);
                    resolucionOriginaRecurso.setRcoCodigo(resultado.getRcoCodigo());
                }
                else {
                    // OPERACION ACTUALIZAR
                    adminResolucionIncumContr.actualizarResolucionIncumContr(resolucionOriginaRecurso, true);
                }
            }
            
            
            if (resolucionResuelveRecurso!=null) {
                if (resolucionResuelveRecurso.getRcoCodigo()==null) {
                    // OPERACION INSERTAR
                    ResolucionIncumContrVO resultado = adminResolucionIncumContr.insertarResolucionIncumContr(resolucionResuelveRecurso, true);
                    resolucionResuelveRecurso.setRcoCodigo(resultado.getRcoCodigo());
                }
                else {
                    // OPERACION ACTUALIZAR
                    adminResolucionIncumContr.actualizarResolucionIncumContr(resolucionResuelveRecurso, true);
                }
            }
        }
    }
    
    
    
    /**
     * Almacena los Tr&aacute;mites de la Resoluci&oacute;n asociada al proceso de Incumplimiento Contractual.
     * @param incumplimientoContrVo
     * @throws ExcepcionDAO
     */
    private void persistirTramitesResolSanCon (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO 
    {
        if (incumplimientoContrVo!=null) {
            //
            // Tramites para Resolucion que Resuelve Recurso
            //
            ResolucionIncumContrVO resIncumContrRecurso = incumplimientoContrVo.getResolucionIncumContrRecursoVo();
            if (resIncumContrRecurso!=null && resIncumContrRecurso.getTramiteResolSanConList()!=null) {
                for (TramiteResolSanConVO trsVo: resIncumContrRecurso.getTramiteResolSanConList()) {
                    if (trsVo!=null) {
                        trsVo.setResolucionIncumContrVo(resIncumContrRecurso);
                        
                        if (trsVo.getTrsCodigo() == null) {
                            // OPERACION INSERTAR
                            adminTramiteResolSanCon.insertarTramiteResolSanCon(trsVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminTramiteResolSanCon.actualizarTramiteResolSanCon(trsVo);
                        }
                    }
                }
            }
            
            
            //
            // Tramites para Resolucion de Incumplimiento o Sin Sancion
            //
            ResolucionIncumContrVO resIncumContrResol = incumplimientoContrVo.getResolucionIncumContrResolVo();
            if (resIncumContrResol!=null && resIncumContrResol.getTramiteResolSanConList()!=null) {
                for (TramiteResolSanConVO trsVo: resIncumContrResol.getTramiteResolSanConList()) {
                    if (trsVo!=null) {
                        trsVo.setResolucionIncumContrVo(resIncumContrResol);
                        
                        if (trsVo.getTrsCodigo() == null) {
                            // OPERACION INSERTAR
                            adminTramiteResolSanCon.insertarTramiteResolSanCon(trsVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminTramiteResolSanCon.actualizarTramiteResolSanCon(trsVo);
                        }
                    }
                }
            }
        }
    }
    
    
    
    
    /**
     * Almacena la informaci&oacute;n de los Documentos Contables pertenecientes al proceso de Incumplimiento Contractual especificado.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @throws ExcepcionDAO
     */
    private void persistirDocumentosContables (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        if (incumplimientoContrVo!=null) {
            List<DocumentoContableVO> listaDocumentosContables = incumplimientoContrVo.getDocumentoContableListVo();
            if (listaDocumentosContables!=null && !listaDocumentosContables.isEmpty()) {
                for (DocumentoContableVO dcoVo: listaDocumentosContables) {
                    if (dcoVo!=null) {
                        dcoVo.setIncumplimientoContrVo(incumplimientoContrVo);
                        
                        if (dcoVo.getDcoCodigo() == null) {
                            // OPERACION INSERTAR
                            adminDocumentoContable.insertarDocumentoContable(dcoVo, true);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminDocumentoContable.actualizarDocumentoContable(dcoVo, dcoVo.getUsuarioRegistraVo(), true);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de las Actas de Suspensi&oacute;n de Audiencia pertenecientes al proceso de Incumplimiento Contractual especificado.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual.
     * @throws ExcepcionDAO
     */
    private void persistirActasSuspAudIncumCon (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        if (incumplimientoContrVo!=null) {
            List<ActaSuspenAudIncumConVO> listaActasSuspenAudIncumCon = incumplimientoContrVo.getActaSuspenAudIncumConListVo();
            if (listaActasSuspenAudIncumCon!=null && !listaActasSuspenAudIncumCon.isEmpty()) {
                for (ActaSuspenAudIncumConVO asaVo: listaActasSuspenAudIncumCon) {
                    if (asaVo!=null) {
                        asaVo.setIncumplimientoContrVo(incumplimientoContrVo);
                        
                        if (asaVo.getAsaCodigo() == null) {
                            // OPERACION INSERTAR
                            adminActaSuspenAudIncumCon.insertarActaSuspenAud(asaVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminActaSuspenAudIncumCon.actualizarActaSuspenAud(asaVo);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n del Inventario que se encuentra relacionado con el Proceso de Incumplimiento Contractual.
     * @throws ExcepcionDAO
     */
    private void persistirInventario () throws ExcepcionDAO 
    {
        if (listaInventarioPersistir!=null && !listaInventarioPersistir.isEmpty()) {
            for (InventarioVO invVo: listaInventarioPersistir) {
                if (invVo!=null) {
                    if (invVo.getInvCodigo() == null) {
                        // OPERACION INSERTAR
                        adminInventario.insertarInventario(invVo);
                    } else {
                        // OPERACION ACTUALIZAR
                        adminInventario.actualizarInventario(invVo);
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n del Contrato que se encuentra relacionado con el Proceso de Incumplimiento Contractual.
     * @throws ExcepcionDAO
     */
    private void persistirContrato () throws ExcepcionDAO 
    {
        if (contratoVoPersistir!=null) {
            if (contratoVoPersistir.getConCodigo() == null) {
                // OPERACION INSERTAR
                adminContrato.insertarContrato(contratoVoPersistir);
            } else {
                // OPERACION ACTUALIZAR
                adminContrato.actualizarContrato(contratoVoPersistir);
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de las Cuotas Operador que han sido marcadas para persistir.
     * @throws ExcepcionDAO
     */
    private void persistirCuotasOperador () throws ExcepcionDAO 
    {
        if (listaCuotaOperadorPersistir!=null && !listaCuotaOperadorPersistir.isEmpty()) {
            for (CuotaOperadorVO copVo: listaCuotaOperadorPersistir) {
                if (copVo!=null) {
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
    
    
    
    /**
     * Almacena en CASCADA la informaci&oacute;n de las Cuotas Operador que se encuentran relacionadas con el Proceso de Incumplimiento Contractual.
     * @param incumplimientoContrVo - Proceso de Incumplimiento Contractual que posee el listado de Cuotas Operador.
     * @throws ExcepcionDAO
     */
    private void persistirCuotasOperador (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO 
    {
        if (incumplimientoContrVo!=null) {
            List<CuotaOperadorVO> listaCuotaOperador = incumplimientoContrVo.getCuotaOperadorListVo();
            if (listaCuotaOperador!=null && !listaCuotaOperador.isEmpty()) {
                for (CuotaOperadorVO copVo: listaCuotaOperador) {
                    if (copVo!=null) {
                        copVo.setIncumplimientoContrVo(incumplimientoContrVo);
                        
                        if (copVo.getCopCodigo() == null) {
                            // OPERACION INSERTAR
                            adminCuotaOperador.insertarCuotaOperador(copVo, true);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminCuotaOperador.actualizarCuotaOperador(copVo, true);
                        }
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Almacena los registros de Inhabilidad Persona asociados al proceso de Incumplimiento.
     * @param incumplimientoContrVo - Proceso de Incumplimiento.
     * @throws ExcepcionDAO
     */
    private void almacenarInhabilidadesPersona (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO 
    {
        if (incumplimientoContrVo!=null) {
            List<InhabilidadPersonaVO> listaInhabilidadPersona = incumplimientoContrVo.getInhabilidadPersonaListVo();
            if (listaInhabilidadPersona!=null && !listaInhabilidadPersona.isEmpty()) {
                for (InhabilidadPersonaVO ipeVo: listaInhabilidadPersona) {
                    if (ipeVo!=null) {
                        ipeVo.setIncumplimientoContrVo(incumplimientoContrVo);
                        
                        if (ipeVo.getIpeCodigo() == null) {
                            // OPERACION INSERTAR
                            adminInhabilidadPersona.insertarInhabilidadPersona(ipeVo);
                        } else {
                            // OPERACION ACTUALIZAR
                            adminInhabilidadPersona.actualizarInhabilidadPersona(ipeVo);
                        }
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Almacena los registros de Inhabilidad Persona.
     * @param inhabilidadPersonaVo - Registro de Inhabilidad Persona.
     * @throws ExcepcionDAO
     */
    private boolean almacenarInhabilidadPersona (InhabilidadPersonaVO inhabilidadPersonaVo) throws ExcepcionDAO 
    {
        boolean exitoso = false;
        
        if (inhabilidadPersonaVo!=null) {
            InhabilidadPersonaVO resultado = null;
            if (inhabilidadPersonaVo.getIpeCodigo() == null) {
                // OPERACION INSERTAR
                resultado = adminInhabilidadPersona.insertarInhabilidadPersona(inhabilidadPersonaVo);
            } else {
                // OPERACION ACTUALIZAR
                resultado = adminInhabilidadPersona.actualizarInhabilidadPersona(inhabilidadPersonaVo);
            }
            
            exitoso = resultado!=null;
        }
        
        return (exitoso);
    }
    
    
    

    public List<IncumplimientoContrVO> buscarIncumplimientosInforme(Long isuCodigo) throws ExcepcionDAO {
        List<IncumplimientoContrVO> incumplimientosVo = new ArrayList<IncumplimientoContrVO>();
        for (SiiIncumplimientoContr incumplimiento : incumplimientoContrDao.buscarIncumplimientosInforme(isuCodigo)) {
            incumplimientosVo.add(new IncumplimientoContrVO(incumplimiento));            
        }
        return incumplimientosVo;
         
    }

    public boolean sustanciadorConIncumplimientosVigentes(Long fsuCodigo) throws ExcepcionDAO {
        return incumplimientoContrDao.sustanciadorConIncumplimientosVigentes( fsuCodigo);
    }
    
    
    @Override
    public List<IncumplimientoContrVO> buscarIncumplimientoPorPerCodigoSustanciador (Long perCodigo) throws ExcepcionDAO 
    {
        List<IncumplimientoContrVO> resultado = null;
        List<SiiIncumplimientoContr> lista = incumplimientoContrDao.buscarIncumplimientoPorPerCodigoSustanciador(perCodigo);
        if (lista!=null) {
            resultado = new ArrayList<IncumplimientoContrVO>();
            for (SiiIncumplimientoContr siiIncumplimientoContr: lista) {
                if (siiIncumplimientoContr!=null)
                    resultado.add(new IncumplimientoContrVO(siiIncumplimientoContr));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public IncumplimientoContrVO buscarIncumplimientoContrPorCodigo (Long icnCodigo) throws ExcepcionDAO {
        IncumplimientoContrVO resultado = null;
        if (icnCodigo!=null) {
            SiiIncumplimientoContr siiIncumplimientoContr = incumplimientoContrDao.buscarPorCodigo(icnCodigo);
            if (siiIncumplimientoContr!=null)
                resultado = new IncumplimientoContrVO(siiIncumplimientoContr);
        }
        
        return (resultado);
    }
    
    
    
    @Override
    public IncumplimientoContrVO insertarIncumplimientoContr (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO, ExcepcionAplicacion {
        return ( this.insertarIncumplimientoContr(incumplimientoContrVo, false) );
    }
    
    
    @Override
    public IncumplimientoContrVO insertarIncumplimientoContr (IncumplimientoContrVO incumplimientoContrVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion {
        IncumplimientoContrVO resultado = null;
        if (incumplimientoContrVo!=null) {
            if (cascadeUpdate) {
                this.persistirResoluciones(incumplimientoContrVo);
                
                if (this.listaInventarioPersistir!=null && !listaInventarioPersistir.isEmpty()) {
                    // Persistir Listado de Inventario
                    this.persistirInventario();
                }
                
                if (this.contratoVoPersistir!=null) {
                    // Persistir el Contrato
                    this.persistirContrato();
                }
                
                if (this.listaCuotaOperadorPersistir!=null && !listaCuotaOperadorPersistir.isEmpty()) {
                    // Persistir el Listado de Cuota Operador
                    this.persistirCuotasOperador();
                }
            }
            
            
            SiiIncumplimientoContr siiIncumplimientoContr = incumplimientoContrDao.insertar(conversionVoEntidad.convertir(incumplimientoContrVo));
            if (siiIncumplimientoContr!=null) {
                resultado = new IncumplimientoContrVO(siiIncumplimientoContr);
                
                if (cascadeUpdate) {
                    this.asignarHijos(resultado, incumplimientoContrVo);
                    this.persistirHijos(resultado);
                }
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public IncumplimientoContrVO actualizarIncumplimientoContr (IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO, ExcepcionAplicacion {
        if (incumplimientoContrVo.getIcnFechaSuperaInc()!=null) {
            List<SiiConceptoCuota> listasiiConceptoCuota = new ArrayList();
            //Calcula días de incumplimiento
            long diferenciaen_ms = incumplimientoContrVo.getIcnFechaSuperaInc().getTime()-
                                   incumplimientoContrVo.getResolucionIncumContrResolVo().getRcoFechaResolFirme().getTime();
            long dias = diferenciaen_ms/(1000*60*60*24);
            
            
            //Crea cuota operador 
            SiiCuotaOperador  siiCuotaOperador= new SiiCuotaOperador();
            Calendar resolucionFirme = Calendar.getInstance();
            resolucionFirme.setTime(  incumplimientoContrVo.getResolucionIncumContrResolVo().getRcoFechaResolFirme());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime( incumplimientoContrVo.getIcnFechaSuperaInc()); 
            calendar.add(Calendar.DAY_OF_YEAR, 1);         
            siiCuotaOperador.setCopFechaLimPag(calendar.getTime());
            siiCuotaOperador.setCopNumCuota(1);
            siiCuotaOperador.setCopTipoDocSopor("RE"); //Re para Resolución 
            //segun tipo de clase 
            //siiCuotaOperador.setCopValor(solicitudPromocionalesVo.getValorDE());
            siiCuotaOperador.setCopVigencia(resolucionFirme.get(Calendar.YEAR));
            siiCuotaOperador.setMesCodigo(resolucionFirme.get(Calendar.MONTH));
            siiCuotaOperador.setCopCancelada("N");
            siiCuotaOperador.setCopTipoCartera("C");
            SiiConceptoCuota siiConceptoCuota = new SiiConceptoCuota();
            listasiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXAbreviatura("MU");
            siiCuotaOperador.setSiiConceptoCuota(listasiiConceptoCuota.get(0));
            //siiCuotaOperador.setSiiRifaPromocional(siiRifaPromocional);
                        
            //if(tipo calse diaria){
             // BigDecimal saldo =  incumplimientoContrVo.getResolucionIncumContrResolVo().  
            //}
            
            //else 
            
            
            
        }
        
        return ( this.actualizarIncumplimientoContr(incumplimientoContrVo, false) );
    }
    
    
    @Override
    public IncumplimientoContrVO actualizarIncumplimientoContr (IncumplimientoContrVO incumplimientoContrVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion {
        IncumplimientoContrVO resultado = null;
        if (incumplimientoContrVo!=null) {
            if (cascadeUpdate) {
                this.persistirResoluciones(incumplimientoContrVo);
                
                if (this.listaInventarioPersistir!=null && !listaInventarioPersistir.isEmpty()) {
                    // Persistir Listado de Inventario
                    this.persistirInventario();
                }
                
                if (this.contratoVoPersistir!=null) {
                    // Persistir el Contrato
                    this.persistirContrato();
                }
                
                if (this.listaCuotaOperadorPersistir!=null && !listaCuotaOperadorPersistir.isEmpty()) {
                    // Persistir el Listado de Cuota Operador
                    this.persistirCuotasOperador();
                }
            }
            
            
            SiiIncumplimientoContr siiIncumplimientoContr = incumplimientoContrDao.actualizar(conversionVoEntidad.convertir(incumplimientoContrVo));
            if (siiIncumplimientoContr!=null) {
                
                resultado = new IncumplimientoContrVO(siiIncumplimientoContr);
                
                
                // Insertar Log de cambio de estado
                if (incumplimientoContrVo.getEstadoIncumplContractVo()!=null && incumplimientoContrVo.getEstadoIncumplContractVo().getEicCodigo()!=null &&
                    !incumplimientoContrVo.getEstadoIncumplContractVo().getEicCodigo().equals(incumplimientoContrVo.getIdEstadoAnterior()) && 
                    incumplimientoContrVo.getUsuarioRegistraVo()!=null) 
                {
                    adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.PROCESO_INCUMPLIMIENTO_CONTRACTUAL.getId(),
                                                                 incumplimientoContrVo.getEstadoIncumplContractVo().getEicCodigo(),
                                                                 incumplimientoContrVo.getUsuarioRegistraVo(), 
                                                                 resultado.getIcnCodigo());
                }
                
                
                
                if (cascadeUpdate) {
                    this.asignarHijos(resultado, incumplimientoContrVo);
                    this.persistirHijos(resultado);
                }
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarIncumplimientoContr (Long icnCodigo) throws ExcepcionDAO {
        incumplimientoContrDao.eliminar(icnCodigo);
    }
    
    
    @Override
    public IncumplimientoContrVO buscarIncumplimientoPorIdResolucionYCategoria (Long rcoCodigo, Long categoriaResolucion) throws ExcepcionDAO {
        IncumplimientoContrVO resultado = null;
        if (rcoCodigo!=null && categoriaResolucion!=null) {
            SiiIncumplimientoContr siiIncumplimientoContr = incumplimientoContrDao.buscarIncumplimientoPorIdResolucionYCategoria(rcoCodigo, categoriaResolucion);
            if (siiIncumplimientoContr!=null)
                resultado = new IncumplimientoContrVO(siiIncumplimientoContr);
        }
        
        return (resultado);
    }
    
    
    
    
    /////////////////////////////////////////////////////////////
    // Objetos a persistir junto al proceso de Incumplimiento. //
    /////////////////////////////////////////////////////////////

    public void setListaInventarioPersistir(List<InventarioVO> listaInventarioPersistir) {
        this.listaInventarioPersistir = listaInventarioPersistir;
    }

    public List<InventarioVO> getListaInventarioPersistir() {
        return listaInventarioPersistir;
    }

    public void setContratoVoPersistir(ContratoVO contratoVoPersistir) {
        this.contratoVoPersistir = contratoVoPersistir;
    }

    public ContratoVO getContratoVoPersistir() {
        return contratoVoPersistir;
    }
}
