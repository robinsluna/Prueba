package co.gov.coljuegos.siicol.ejb.util;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AccionControlDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActaDestruccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActaIniContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActaSuspenAudIncumConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActividadIcaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActividadIcaPersDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AcuerdoPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AdendaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AjusteContCarActDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AlcanceInvitacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AmparoEstPrevDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AmparoPolContProvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ApropiacionInicialDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AreaColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AseguradoraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AsigRecaudoAaEstablDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AsignacionRecaudoAaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AsignacionRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AuditorOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoComisorioAccConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoComisorioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoDecretaPrueProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoFormCargProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BarrioOrdenDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BarrioOrdenInfVerDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BeneficiarioEnteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaActuacionesAdmDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaDocumentoContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaNominaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaPoblacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CategoriaDistribDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CausalTermContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CdpRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CierreAnualContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CierreMensualDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CierreRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ClaseContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ClaseJuegoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ComprobAsociadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ComunicResolPersIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ComunicacSujSancIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConcepCuotCarActAdmDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConcepInfExogenaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoGastoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoNominaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoRetenDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConsolidadoDistDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConsultaWebContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoProveedorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CorteCarteraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CotizacionEstudioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CtaContabConcepCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuadranteOrdTraInfVerDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuadranteOrdenTraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaBancariaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaBancoPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaContTipoDocContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaInexacProcSancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOmisProcSancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DeclaracionSugeridaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenuncOrdTraInfVerDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DescargoProcIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DescargoProcSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetRubroVigenFuturaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleContNominaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionSugDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDistribDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFinancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFuenteFinanciacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionPersonaAtienDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionProcePerIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionProcesalIncDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DistribucionMesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DistribucionPfcDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DistribucionUbicaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumSoporModifDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoConpesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoTdrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoIlegDenunDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoIlegInfVerDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoProcesoIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoRetiradoAccDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EmpresaDestruyeDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EnteTerritorialDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstPrevDetRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecConCuoCarDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecSuspensionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoAcuerdoPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoAlcanceInvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoCierreAnualContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoCierreRecDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoContrProvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoCuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDistribEnteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocConpesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEstPrevDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEstudioMercDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEvaluacionJtfDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoIncumplContractDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoInvitacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoLiqContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoModifCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoModifPlanContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoModifPresupDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoModificRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoObligNoPresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoObligacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoOficioLiqDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoOrdenPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoOtrosiDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoPfcDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoPolizaContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcSanIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcesoSancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoResolucAutDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoResolucSanConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoResolucionLiqDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolEstMercadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicPfcmDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSuspensionContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTansladoBancarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTermAnticipDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTramResDecDesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTramResPrSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTramResProcIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoUsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstudioMercadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstudioPrevioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EvaluacionJurTecFinDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedArchFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FirmaDocumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FirmasRequeridasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FiscalizadorSustancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuenteFinancContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuenteFinanciacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuncionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantPolizaOficLiqDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantiaExigidaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantiaPolizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GravamenMovFinancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GrupoAccionControlDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GrupoFiscalizadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GrupoRetencDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistEstadoFiscalizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistEstadoSustanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistPersonalEmpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HitosEmpresaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HlpCuotaAcuerdoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HlpCuotaOpCuoAcuDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImpContabOblNoPresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.IncumplimientoContrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InformeActaIniDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InformeSupervisionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InformeVerificCampoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InhabilidadPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InstrumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InteresCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioProcSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioResolDesisDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InvitacionProcesoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemCotizacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemPlanContDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemPlanContratacDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemSolicitudDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.JuegoMesaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionEstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionMesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LogActividadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MarcaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MedioDenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MedioPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MesaCasinoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModPlanConItemPlanDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModPresDetRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifCdpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifEstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifRpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificPfcAnualDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificPresupDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificacionCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificacionPlanContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificacionRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModuloDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MonedaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoAnulAuComAcConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoAnulaAccContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoAnulacionRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoDevolucionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoIncuInfSupervDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoIncumplimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoNoDestruccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoRechSolRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MunicOrdTraInfVerifDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MunicipioOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.Nivel1DAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NotaCredOblConcDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NotaCredOblConceptoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NotaCreditoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OblConcRpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligDetRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionConceptoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionNoPresupDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficInfPolizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficLiqTipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioAdjudicaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioDesigSupervDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioLiquidacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OrdenPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OrdenTrabajoVisitaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OtroSiDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PagoCargaActAdmDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PagoOpePseDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PagoOperadoresPSE.PagoOperadoresPseDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PerInvesProIleAutoPruDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PermisoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PermisoRolModuloDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaAtiendeAccDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaCtaBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaInvProIleAutoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaInvestProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonalEmpresaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PlanContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PoblacionEnteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PolizaContProvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PolizaContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PolizaRequisitosPolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcedenciaPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoOriCargaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoSancIlegalidadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoSancionatorioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaEvaluacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaRecibDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProveedorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProveedorInvitacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProyeccionFlujoCajaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PruebaAutoDecrPruDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PruebaDescargoProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecaudoBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecepcionAlegatoProSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecepcionPropuestasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReintegroPagaduriaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RepartoFiscalizadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReporteVentasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReqAlcanceInvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReqEstudioPrevioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RequisitoCritDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RequisitosPolizaConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionDecomDestDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionDesisSolAutDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionIncumContrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionLiquidacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionProcIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionProcSancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResponDianPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResponsabilidadDianDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResultadoResDecDesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResultadoVerifDenunDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResumenNoConectadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionFinanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionFinanOtroSiDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionFinancResolAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionGctDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionGctResolucAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RifaPromocionalDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SaldoCtaBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicPfcmDetalleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudEstMercadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudPFCMenDetalleRDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudPfcMensualDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SuspensionContrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SustanciadorAuditorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TarifaIlegalidadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaIntSuperbanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaInteresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminacionAnticipContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminoReferenciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoActuacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoAmparoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestPolizaRenovacDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoCalleDireccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoCuentaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocSopSolicPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocSoporteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocSoporteModifDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocumentoColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoElemenIlegalidadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoGarantiaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoIdentificacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoInstrumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoJuegoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoMultaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoNovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoOrigenDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoPersonalDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoPruebaIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoRetencionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSectorDirecDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoServicioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSociedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSolicAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSufijo1CalleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSufijo2CalleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoTasaInteresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoUbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteAutoForCarIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteAutoPrueTrasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolDecDesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolProcSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolSanConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TrasladoCuentasBancariasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UvtDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.VigenciaFuturaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel2;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel3;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel4;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel5;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel6;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel7;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel8;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAccionControl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaDestruccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaIniContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaSuspenAudIncumCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActividadIca;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActividadIcaPers;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAcuerdoPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjusteContCarAct;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAlcanceInvitacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoEstPrev;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoPolContProv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiApropiacionInicial;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAseguradora;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsigRecaudoAaEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsignacionRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsignacionRecaudoAa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAuditorOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorioAccCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoDecretaPrueProIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoFormCargProIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrden;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrdenInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBeneficiarioEnte;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaActuacionesAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaDocumentoCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaNomina;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaPoblacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCategoriaDistrib;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCausalTermContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdpRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreAnualContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiClaseContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiClaseJuego;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComprobAsociado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComunicResolPersIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComunicacSujSancIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepCuotCarActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepInfExogena;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoGasto;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoNomina;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoReten;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsolidadoDist;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsultaWebContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContratoProveedor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCorteCartera;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCtaContabConcepCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdTraInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdenTra;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancaria;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancoPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaInexacProcSanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOmisProcSanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionSugerida;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncOrdTraInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenunciaOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDescargoProcIleg;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDescargoProcSan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetRubroVigenFutura;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleContNomina;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracionSug;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDistrib;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionPersonaAtien;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionProcePerIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionProcesalInc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionUbica;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumSoporModif;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoConpes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegDenun;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoProcesoIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoRetiradoAcc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEmpresaDestruye;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEnteTerritorial;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstPrevDetRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecConCuoCar;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecSuspension;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAcuerdoPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAlcanceInv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCierreAnualCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCierrreRec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrProv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCuentaContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDistribEnte;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocConpes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstPrev;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstudioMerc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEvaluacionJtf;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoInvitacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoLiquidCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifPlanCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifPresup;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModificRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoObligNoPres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoObligacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOficioLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOrdenPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOtrosi;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPolizaCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcSanIleg;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcesoSanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucAut;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucSanCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicPfcm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTermAnticip;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResDecDes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResPrSan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTraslBancario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoUsuario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioPrevio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEvaluacionJurTecFin;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedArchFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteDocum;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmaDocumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmasRequeridas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFiscalizadorSustanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinancContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuncion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantPolizaOficLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaExigida;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaPoliza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGravamenMovFinanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoAccionControl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoFiscalizacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoRetenc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoFiscaliz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoSustan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistPersonalEmp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHitosEmpresa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaAcuerdo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaOpCuoAcu;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImpContabOblNoPres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiIncumplimientoContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeActaIni;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeSupervision;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeVerificCampo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInhabilidadPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioProcSan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioResolDesis;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemCotizacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemSolicitud;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiJuegoMesa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogActividad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMarca;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMedioPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMesaCasino;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPlanConItemPlanDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPresDetRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifCdpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifRpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificPfcAnual;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificPresup;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionPlanCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMoneda;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulAuComAcCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoDevolucion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoIncuInfSuperv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoIncumplimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoNoDestruccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoRechSolRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicOrdTraInfVerif;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicipioOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcepto;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOblConcRpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionConcepto;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionNoPresup;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficInfPoliza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficLiqTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioAdjudica;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioDesigSuperv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenTrabajoVisita;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOtrosi;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPagoCargaActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPerInvesProIleAutoPru;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermiso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaAtiendeAcc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaCtaBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvProIleAuto;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvestProIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonalEmpresa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPlanContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPoblacionEnte;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContProv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaRequisitosPol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcedenciaPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoOriCarga;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancIlegalidad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancionatorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaEvaluacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaRecib;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedorInvitacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionFlujoCaja;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPruebaAutoDecrPru;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPruebaDescargoProIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoPse;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionAlegatoProSan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionPropuestas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReintegroIngresoPag;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRepartoFiscalizador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqAlcanceInv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqEstudioPrevio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRequisitoCrit;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRequisitosPolizaCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionDecomDest;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionDesisSolAut;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionIncumContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionLiquid;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionProcIleg;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionProcSanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponDianPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponsabilidadDian;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoResDecDes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResumenNoConectado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisFinancOtrosi;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionFinan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionFinancResolAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionGct;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionGctResolucAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRifaPromocional;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSaldoCtaBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolPfcMensDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicPfcmDetalle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPfcMens;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSuspensionContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSustanciadorAuditor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTarifaIlegalidad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaIntSuperban;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminacionAnticip;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoActuacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoAmparo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuestPolizaRenovac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoCuenta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSopSolicPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSoporte;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocumentoColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoElemenIlegalidad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoGarantia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoJuego;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoMulta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoOrigen;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPersonal;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPruebaIleg;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoRetencion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoServicio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSociedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSolicAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoTasaInteres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoUbicacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteAutoForCarIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteAutoPrueTras;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolDecDes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProIle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProcSan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolSanCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTrasladoBancario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUvt;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVigenciaFutura;
import co.gov.coljuegos.siicol.ejb.vo.AccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.ActaDestruccionVO;
import co.gov.coljuegos.siicol.ejb.vo.ActaIniContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.ActaSuspenAudIncumConVO;
import co.gov.coljuegos.siicol.ejb.vo.ActividadIcaPersVO;
import co.gov.coljuegos.siicol.ejb.vo.ActividadIcaVO;
import co.gov.coljuegos.siicol.ejb.vo.AcuerdoPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.AdendaVO;
import co.gov.coljuegos.siicol.ejb.vo.AjusteContCarActVO;
import co.gov.coljuegos.siicol.ejb.vo.AlcanceInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.AmparoEstPrevVO;
import co.gov.coljuegos.siicol.ejb.vo.AmparoPolContProvVO;
import co.gov.coljuegos.siicol.ejb.vo.ApropiacionInicialVO;
import co.gov.coljuegos.siicol.ejb.vo.ArchivoFisicoVO;
import co.gov.coljuegos.siicol.ejb.vo.AreaColjuegosVO;
import co.gov.coljuegos.siicol.ejb.vo.AsigRecaudoAaEstablVO;
import co.gov.coljuegos.siicol.ejb.vo.AsignacionRecaudoVO;
import co.gov.coljuegos.siicol.ejb.vo.AuditorOrdenTrabVO;
import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioAccConVO;
import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioVO;
import co.gov.coljuegos.siicol.ejb.vo.AutoDecretaPrueProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.AutoFormCargProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.BarrioOrdenInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.BarrioOrdenVO;
import co.gov.coljuegos.siicol.ejb.vo.BeneficiarioEnteVO;
import co.gov.coljuegos.siicol.ejb.vo.CargaActuacionesAdmVO;
import co.gov.coljuegos.siicol.ejb.vo.CargaDocumentoContVO;
import co.gov.coljuegos.siicol.ejb.vo.CargaNominaVO;
import co.gov.coljuegos.siicol.ejb.vo.CargaPoblacionVO;
import co.gov.coljuegos.siicol.ejb.vo.CargaRpVO;
import co.gov.coljuegos.siicol.ejb.vo.CdpRpVO;
import co.gov.coljuegos.siicol.ejb.vo.CdpVO;
import co.gov.coljuegos.siicol.ejb.vo.CierreAnualContableVO;
import co.gov.coljuegos.siicol.ejb.vo.CierreMensualVO;
import co.gov.coljuegos.siicol.ejb.vo.CierreRecaudoVO;
import co.gov.coljuegos.siicol.ejb.vo.ClaseJuegoVO;
import co.gov.coljuegos.siicol.ejb.vo.ComunicResolPersIleVO;
import co.gov.coljuegos.siicol.ejb.vo.ComunicacSujSancIleVO;
import co.gov.coljuegos.siicol.ejb.vo.ConcepCuotCarActAdmVO;
import co.gov.coljuegos.siicol.ejb.vo.ConcepInfExogenaVO;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoGastoVO;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoNominaVO;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoRetenVO;
import co.gov.coljuegos.siicol.ejb.vo.ConsolidadoDistVO;
import co.gov.coljuegos.siicol.ejb.vo.ConsultaWebContratVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.CorteCarteraVO;
import co.gov.coljuegos.siicol.ejb.vo.CotizacionEstudioVO;
import co.gov.coljuegos.siicol.ejb.vo.CtaContabConcepCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.CuadranteOrdTraInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.CuadranteOrdenTraVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentaBancariaVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentaBancoPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentaContTipoDocContVO;
import co.gov.coljuegos.siicol.ejb.vo.CuentasContablesVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaInexacProcSancVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOmisProcSancVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.DenuncOrdTraInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaOrdenTrabVO;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaVO;
import co.gov.coljuegos.siicol.ejb.vo.DescargoProcIlegVO;
import co.gov.coljuegos.siicol.ejb.vo.DescargoProcSanVO;
import co.gov.coljuegos.siicol.ejb.vo.DetFuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.DetRubroVigenFuturaVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleContNominaVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionSugVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDistribVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRecaudoVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionPersonaAtienVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionProcePerIleVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionProcesalIncVO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionVO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionMesVO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionUbicaVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumSoporModifVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoConpesVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoTdrVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoIlegDenunVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoIlegInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoProcesoIleVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoRetiradoAccVO;
import co.gov.coljuegos.siicol.ejb.vo.EmpresaDestruyeVO;
import co.gov.coljuegos.siicol.ejb.vo.EstPrevDetRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecConCuoCarVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecSuspensionVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoAlcanceInvVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoContrProvVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDocContabVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoEstPrevVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoEstudioMercVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoEvaluacionJtfVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModifCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModifPresupVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModificRpVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoObligacionVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcContratVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoRpVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicPfcmVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoUsuarioVO;
import co.gov.coljuegos.siicol.ejb.vo.EstudioMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstudioPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.EvaluacionJurTecFinVO;
import co.gov.coljuegos.siicol.ejb.vo.ExpedArchFisicoVO;
import co.gov.coljuegos.siicol.ejb.vo.ExpedienteDocumVO;
import co.gov.coljuegos.siicol.ejb.vo.ExpedienteFisicoVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmaDocumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmasRequeridasVO;
import co.gov.coljuegos.siicol.ejb.vo.FiscalizadorSustancVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinancContabVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.FuncionVO;
import co.gov.coljuegos.siicol.ejb.vo.GarantPolizaOficLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.GarantiaPolizaVO;
import co.gov.coljuegos.siicol.ejb.vo.GravamenMovFinancVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoAccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoFiscalizacionVO;
import co.gov.coljuegos.siicol.ejb.vo.HistEstadoFiscalizVO;
import co.gov.coljuegos.siicol.ejb.vo.HistEstadoSustanVO;
import co.gov.coljuegos.siicol.ejb.vo.HistPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.HistPersonalEmpVO;
import co.gov.coljuegos.siicol.ejb.vo.HitosEmpresaVO;
import co.gov.coljuegos.siicol.ejb.vo.HlpCuotaAcuerdoVO;
import co.gov.coljuegos.siicol.ejb.vo.HlpCuotaOpCuoAcuVO;
import co.gov.coljuegos.siicol.ejb.vo.ImpContabOblNoPresVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionContableVO;
import co.gov.coljuegos.siicol.ejb.vo.IncumplimientoContrVO;
import co.gov.coljuegos.siicol.ejb.vo.InformeActaIniVO;
import co.gov.coljuegos.siicol.ejb.vo.InformeSupervisionVO;
import co.gov.coljuegos.siicol.ejb.vo.InhabilidadPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.InstrumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.InteresCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioProcSanVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioResolDesisVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.InvitacionProcesoVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemCotizacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemSolicitudVO;
import co.gov.coljuegos.siicol.ejb.vo.JuegoMesaVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionEstablVO;
import co.gov.coljuegos.siicol.ejb.vo.LogActividadVO;
import co.gov.coljuegos.siicol.ejb.vo.MarcaVO;
import co.gov.coljuegos.siicol.ejb.vo.MesVO;
import co.gov.coljuegos.siicol.ejb.vo.MesaCasinoVO;
import co.gov.coljuegos.siicol.ejb.vo.MetVO;
import co.gov.coljuegos.siicol.ejb.vo.ModPlanConItemPlanDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.ModPresDetRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.ModifCdpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ModifEstadoDocContabVO;
import co.gov.coljuegos.siicol.ejb.vo.ModifRpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificPfcAnualVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificPresupVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionPlanContVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionRpVO;
import co.gov.coljuegos.siicol.ejb.vo.ModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoAnulRpVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoDevolucionVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncuInfSupervVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncumplimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoNoDestruccionVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoRechSolRpVO;
import co.gov.coljuegos.siicol.ejb.vo.MunicOrdTraInfVerifVO;
import co.gov.coljuegos.siicol.ejb.vo.MunicipioOrdenTrabVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConcDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.OblConcRpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligDetRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionNoPresupVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionVO;
import co.gov.coljuegos.siicol.ejb.vo.OficInfPolizaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficLiqTipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioAdjudicaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioDesigSupervVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.OperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.OrdenPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.OrdenTrabajoVisitaVO;
import co.gov.coljuegos.siicol.ejb.vo.OtroSiVO;
import co.gov.coljuegos.siicol.ejb.vo.PagoCargaActAdmVO;
import co.gov.coljuegos.siicol.ejb.vo.PagoOperadoresVO;
import co.gov.coljuegos.siicol.ejb.vo.PerInvesProIleAutoPruVO;
import co.gov.coljuegos.siicol.ejb.vo.PermisoRolModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.PermisoVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaAtiendeAccVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaCtaBancoVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaInvProIleAutoVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaInvestProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonalEmpresaVO;
import co.gov.coljuegos.siicol.ejb.vo.PlanContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.PoblacionEnteVO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaContProvVO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaContratVO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaRequisitosPolVO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel1VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel2VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel3VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel4VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel5VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel6VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel7VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel8VO;
import co.gov.coljuegos.siicol.ejb.vo.PrRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoColjuegosVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoSancIlegalidadVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoSancionatorioVO;
import co.gov.coljuegos.siicol.ejb.vo.PropuestaEvaluacionVO;
import co.gov.coljuegos.siicol.ejb.vo.PropuestaRecibVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.ProyeccionFlujoCajaVO;
import co.gov.coljuegos.siicol.ejb.vo.PruebaAutoDecrPruVO;
import co.gov.coljuegos.siicol.ejb.vo.PruebaDescargoProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.RecepcionAlegatoProSanVO;
import co.gov.coljuegos.siicol.ejb.vo.RecepcionPropuestasVO;
import co.gov.coljuegos.siicol.ejb.vo.ReintegroPagaduriaVO;
import co.gov.coljuegos.siicol.ejb.vo.RepartoFiscalizadorVO;
import co.gov.coljuegos.siicol.ejb.vo.ReqAlcanceInvVO;
import co.gov.coljuegos.siicol.ejb.vo.ReqEstudioPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.RequisitoCritVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionDecomDestVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionDesisSolAutVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionIncumContrVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionProcIlegVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionProcSancVO;
import co.gov.coljuegos.siicol.ejb.vo.ResponDianPersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.ResponsabilidadDianVO;
import co.gov.coljuegos.siicol.ejb.vo.ResumenNoConectadoVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisFinancOtroSiVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionFinanVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionFinancResolAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionGctResolucAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionGctVO;
import co.gov.coljuegos.siicol.ejb.vo.RolVO;
import co.gov.coljuegos.siicol.ejb.vo.RpDetRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;
import co.gov.coljuegos.siicol.ejb.vo.SaldoCuentaBancoVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicPfcmDetalleVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPFCMenDetalleVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPfcMensualVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPromocionalesVO;
import co.gov.coljuegos.siicol.ejb.vo.SuspensionContrVO;
import co.gov.coljuegos.siicol.ejb.vo.SustanciadorAuditorVO;
import co.gov.coljuegos.siicol.ejb.vo.TarifaIlegalidadVO;
import co.gov.coljuegos.siicol.ejb.vo.TasaIntSuperbanVO;
import co.gov.coljuegos.siicol.ejb.vo.TasaInteresVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminacionAnticipContVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoAmparoVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestPolizaRenovacVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocContableVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocSoporteVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocumentoColjuegosVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoElemenIlegalidadVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoGarantiaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoIdentificacionVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoInstrumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoJuegoVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoMultaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoPersonalVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoRetencionVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoServicioVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoSolicAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoUbicacionVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteAutoForCarIleVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteAutoPrueTrasVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolDecDesVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProcSanVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolSanConVO;
import co.gov.coljuegos.siicol.ejb.vo.TrasladoCuentasBancariasVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;
import co.gov.coljuegos.siicol.ejb.vo.UvtVO;
import co.gov.coljuegos.siicol.ejb.vo.VigenciaFuturaVO;
import co.gov.coljuegos.siicol.ejb.vo.pagoOperadoresPSE.PagoOperadoresPseVO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class ConversionVOEntidad {

    private static Object establecimientoSuspension;

    @EJB
    EstadoDenunciaDAO estadoDenunciaDao;
    @EJB
    UsuarioDAO usuarioDao;
    @EJB
    SolicitudPfcMensualDAO solicitudPfcMensualDao;
    @EJB
    EstadoSolicPfcmDAO estadoSolicPfcmDao;
    @EJB
    RpDAO rpDao;
    @EJB
    EstadoRpDAO estadoRpDao;
    @EJB
    RpDetRubroCdpDAO rpDetRubroCdpDao;
    @EJB
    ApropiacionInicialDAO apropiacionInicialDao;
    @EJB
    Nivel1DAO nivel1Dao;
    @EJB
    FuenteFinanciacionDAO fuenteFinanciacionDao;
    @EJB
    DetalleFuenteFinanciacionDAO detalleFuenteFinanciacionDao;
    @EJB
    DetalleRubroDAO detalleRubroDao;
    @EJB
    DistribucionPfcDAO distribucionPfcDao;
    @EJB
    ProyeccionFlujoCajaDAO proyeccionFlujoCajaDao;
    @EJB
    TipoDocSoporteDAO tipoDocSoporteDao;
    @EJB
    ObligacionPagoDAO obligacionPagoDao;
    @EJB
    MesDAO mesDao;
    @EJB
    EstadoPfcDAO estadoPfcDao;
    @EJB
    ProveedorInvitacionDAO proveedorInvitacionDao;
    @EJB
    FirmasRequeridasDAO firmasRequeridasDao;
    @EJB
    FirmaDocumentoDAO firmaDocumentoDao;
    @EJB
    ProveedorDAO proveedorDao;
    @EJB
    EstadoEstudioMercDAO estadoEstudioMercDao;
    @EJB
    EstudioMercadoDAO estudioMercadoDao;
    @EJB
    EstudioPrevioDAO estudioPrevioDao;
    @EJB
    FuncionDAO funcionDao;
    @EJB
    EstadoUsuarioDAO estadoUsuarioDao;
    @EJB
    PersonaDAO personaDao;
    @EJB
    ArchivoFisicoDAO archivoFisicoDao;
    @EJB
    ProcesoColjuegosDAO procesoColjuegosDao;
    @EJB
    EstadoSolEstMercadoDAO estadoSolEstMercadoDao;
    @EJB
    TipoIdentificacionDAO tipoIdentificacionDao;
    @EJB
    TipoGarantiaDAO tipoGarantiaDao;
    @EJB
    SolicitudEstMercadoDAO solicitudEstMercadoDao;
    @EJB
    AreaColjuegosDAO areaColjuegosDao;
    @EJB
    PolizaContratDAO polizaContratDao;
    @EJB
    ProcesoContratacionDAO procesoContratacionDao;
    @EJB
    ConsultaWebContratDAO consultaWebContratDao;
    @EJB
    CotizacionEstudioDAO cotizacionEstudioDao;
    @EJB
    ItemCotizacionDAO itemCotizacionDao;
    @EJB
    ItemPlanContratacDAO itemPlanContratacionDao;
    @EJB
    ItemSolicitudDAO itemSolicitudDao;
    @EJB
    TipoDocumentoColjuegosDAO tipoDocumentoColjuegosDao;
    @EJB
    EstadoInvitacionDAO estadoInvitacionDao;
    @EJB
    CdpDAO cdpDao;
    @EJB
    EstadoCdpDAO estadoCdpDao;
    @EJB
    DetalleRubroCdpDAO detalleRubroCdpDao;
    @EJB
    EstadoProcContratDAO estadoProcContratDao;
    @EJB
    UbicacionDAO ubicacionDao;
    @EJB
    TipoUbicacionDAO tipoUbicacionDao;
    @EJB
    EstadoEstPrevDAO estadoEstPrevDao;
    @EJB
    ObligDetRubroCdpDAO ObligDetRubroCdpDao;
    @EJB
    TipoServicioDAO tipoServicioDao;
    @EJB
    ItemPlanContDetRubDAO itemPlanContDetRubDao;
    @EJB
    EstPrevDetRubroDAO estPrevDetRubroDao;
    @EJB
    ReqEstudioPrevioDAO reqEstudioPrevioDao;
    @EJB
    AmparoEstPrevDAO amparoEstPrevDao;
    @EJB
    TipoAmparoDAO tipoAmparoDao;
    @EJB
    TerminoReferenciaDAO terminoReferenciaDao;
    @EJB
    RolDAO rolDao;
    @EJB
    PermisoRolModuloDAO permisoRolModuloDao;
    @EJB
    PermisoDAO permisoDao;
    @EJB
    ModuloDAO moduloDao;
    @EJB
    AdendaDAO adendaDao;
    @EJB
    InvitacionProcesoDAO invitacionProcesoDao;
    @EJB
    EstadoAlcanceInvDAO estadoAlcanceInvDao;
    @EJB
    AlcanceInvitacionDAO alcanceInvitacionDao;
    @EJB
    ReqAlcanceInvDAO reqAlcanceInvDao;
    @EJB
    RecepcionPropuestasDAO recepcionPropuestasDao;
    @EJB
    PropuestaRecibDAO propuestaRecibDao;
    @EJB
    ModificacionCdpDAO modificacionCdpDao;
    @EJB
    EstadoModifCdpDAO estadoModifCdpDao;
    @EJB
    ModifCdpDetRubCdpDAO modifCdpDetRubCdpDao;
    @EJB
    SolicPfcmDetalleDAO solicPfcmDetalleDao;
    @EJB
    ModificPfcAnualDAO modificPfcAnualDao;
    @EJB
    EvaluacionJurTecFinDAO evaluacionJurTecFinDAO;
    @EJB
    PropuestaEvaluacionDAO propuestaEvaluacionDAO;
    @EJB
    EstadoEvaluacionJtfDAO estadoEvaluacionJtfDAO;
    @EJB
    ExpedienteFisicoDAO expedienteFisicoDao;
    @EJB
    ExpedArchFisicoDAO expedArchFisicoDao;
    @EJB
    ModificacionRpDAO modificacionRpDao;
    @EJB
    EstadoModificRpDAO estadoModificRpDao;
    @EJB
    ModifRpDetRubCdpDAO modifRpDetRubCdpDao;
    @EJB
    PersonalEmpresaDAO personalEmpresaDao;
    @EJB
    TipoPersonalDAO tipoPersonalDao;
    @EJB
    DetalleFinancDAO detalleFinancDao;
    @EJB
    SolicitudAutorizaDAO solicitudAutorizaDao;
    @EJB
    TipoSolicAutorizaDAO tipoSolicAutorizaDao;
    @EJB
    SolicitudPFCMenDetalleRDAO solicitudPFCMenDetalleRDao;
    @EJB
    OficioAdjudicaDAO oficioAdjudicaDao;
    @EJB
    ObligacionDAO obligacionDao;
    @EJB
    EstadoObligacionDAO estadoObligacionDao;
    @EJB
    DocumentoTdrDAO documentoTdrDao;
    @EJB
    InstrumentoDAO instrumentoDao;
    @EJB
    ObligacionConceptoDAO obligacionConceptoDao;

    @EJB
    ContratoDAO contratoDao;

    @EJB
    ConceptoGastoDAO conceptoGastoDao;
    @EJB
    PlanContratacionDAO planContratacionDao;
    @EJB
    OperadorDAO operadorDao;
    @EJB
    TipoInstrumentoDAO tipoInstrumentoDao;
    @EJB
    MetDAO metDao;
    @EJB
    MarcaDAO marcaDao;
    @EJB
    MesaCasinoDAO mesaCasinoDao;
    @EJB
    JuegoMesaDAO juegoMesaDao;
    @EJB
    TipoApuestaDAO tipoApuestaDao;
    @EJB
    ContratoProveedorDAO contratoProveedorDao;
    @EJB
    EstadoContrProvDAO estadoContrProvDao;

    @EJB
    RecaudoBancoDAO recaudoBancoDao;
    @EJB
    DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    OficioLiquidacionDAO oficioLiquidacionDao;

    @EJB
    OficLiqTipoApuestaDAO oficLiqTipoApuestaDao;
    @EJB
    FuenteFinancContabDAO fuenteFinancContabDao;
    @EJB
    GarantiaPolizaDAO garantiaPolizaDao;
    @EJB
    OficInfPolizaDAO oficInfPolizaDao;
    @EJB
    PolizaRequisitosPolDAO polizaRequisitoDao;
    @EJB
    GarantPolizaOficLiqDAO garantPolizaOficLiqDao;
    @EJB
    PolizaContProvDAO polizaConrProvDao;

    @EJB
    AmparoPolContProvDAO amparoPolContProvDao;

    @EJB
    TipoRetencionDAO tipoRetencionDao;
    @EJB
    ConceptoRetenDAO conceptoRetenDao;
    @EJB
    ConcepInfExogenaDAO concepInfExogenaDao;
    @EJB
    DocumentoContableDAO documentoContableDao;
    @EJB
    ImputacionContableDAO imputacionContableDao;
    @EJB
    TipoDocContableDAO tipoDocContableDao;
    @EJB
    OrdenPagoDAO ordenPagoDao;
    @EJB
    DocumentoConpesDAO documentoConpesDao;
    @EJB
    DistribucionUbicaDAO distribucionUbicaDao;
    @EJB
    OficioDesigSupervDAO oficioDesigSupervDao;
    @EJB
    ActividadIcaPersDAO actividadIcaPersDao;
    @EJB
    PagoOperadoresPseDAO pagoOperadoresPseDao;
    @EJB
    EstadoDocContabDAO estadoDocContabDao;
    @EJB
    GravamenMovFinancDAO gravamenMovFinancDao;
    @EJB
    ResolucionAutorizDAO resolucionAutorizDao;
    @EJB
    ResolucionDesisSolAutDAO resolucionDesisSolAutDao;
    @EJB
    InventarioResolDesisDAO inventarioResolDesisDao;
    @EJB
    ModificPresupDAO modificPresupDao;
    @EJB
    ModPresDetRubroDAO modPresDetRubroDao;
    @EJB
    EstadoModifPresupDAO estadoModifPresupDao;
    @EJB
    SaldoCtaBancoDAO saldoCtaBancoDao;
    @EJB
    CuentaBancariaDAO cuentaBancariaDao;
    @EJB
    InventarioDAO inventarioDao;
    @EJB
    TrasladoCuentasBancariasDAO trasladoCuentasBancariasDao;
    @EJB
    OblConcRpDetRubCdpDAO oblConcRpDetRubCdpDao;
    @EJB
    CdpRpDAO cdpRpDao;

    @EJB
    CierreMensualDAO cierreMensualDao;
    @EJB
    CierreRecaudoDAO cierreRecaudoDao;

    @EJB
    ActividadIcaDAO actividadIcaDao;
    @EJB
    ResponsabilidadDianDAO responsabilidadDianDao;

    @EJB
    ResponDianPersonaDAO responDianPersonaDao;

    @EJB
    ObligacionNoPresupDAO obligacionNoPresupDao;
    @EJB
    ImpContabOblNoPresDAO impContabOblNoPresDao;

    @EJB
    NovedadDAO novedadDAO;

    @EJB
    DistribucionMesDAO distribucionMesDao;
    @EJB
    DetalleDistribDAO detalleDistribDao;
    @EJB
    OtroSiDAO otroSiDao;
    @EJB
    UvtDAO uvtDao;
    @EJB
    CargaNominaDAO cargaNominaDao;
    @EJB
    DetalleContNominaDAO detalleContNominaDao;
    @EJB
    ActaIniContratoDAO actaIniContratoDao;
    @EJB
    InformeActaIniDAO informeActaIniDao;
    @EJB
    private CorteCarteraDAO corteCarteraDao;
    @EJB
    CargaRpDAO cargaRpDao;
    @EJB
    MotivoAnulacionRpDAO motivoAnulacionRpDao;
    @EJB
    MotivoRechSolRpDAO motivoRechSolRpDao;
    @EJB
    SolicitudPfcMensualDAO solicitudPfcMensualao;
    @EJB
    EstadoEvaluacionJtfDAO estadoEvaluacionJtfDao;
    @EJB
    MonedaDAO monedaDao;
    @EJB
    EstadoSolicPagoDAO estadoSolicPagoDao;
    @EJB
    SolicitudPagoDAO solicitudPagoDao;
    @EJB
    EstadoSolicAutorizDAO estadoSolicAutorizDao;
    @EJB
    EstadoContratoDAO estadoContratoDao;
    @EJB
    CuentasContablesDAO cuentasContablesDao;
    @EJB
    BancoDAO bancoDao;
    @EJB
    TipoCuentaDAO tipoCuentaDao;
    @EJB
    MedioPagoDAO medioPagoDao;
    @EJB
    ProcedenciaPagoDAO procedenciaPagoDao;
    @EJB
    AseguradoraDAO aseguradoraDao;
    @EJB
    EstadoPolizaContDAO estadoPolizaContDao;
    @EJB
    GarantiaExigidaDAO garantiaExigidaDao;
    @EJB
    RequisitosPolizaConDAO requisitosPolizaConDao;
    @EJB
    PolizaContProvDAO polizaContProvDao;
    @EJB
    PersonaCtaBancoDAO personaCtaBancoDao;
    @EJB
    InteresCuotaDAO interesCuotaDao;
    @EJB
    EstadoOrdenPagoDAO estadoOrdenPagoDao;
    @EJB
    TipoDocSopSolicPagoDAO tipoDocSopSolicPagoDao;
    @EJB
    EstadoDocConpesDAO estadoDocConpesDao;
    @EJB
    EnteTerritorialDAO enteTerritorialDao;
    @EJB
    EstadoResolucAutDAO estadoResolucAutDao;
    @EJB
    EstablecimientoDAO establecimientoDao;
    @EJB
    NovedadDAO novedadDao;
    @EJB
    CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    EstadoTansladoBancarioDAO estadoTansladoBancarioDao;
    @EJB
    ConceptoCuotaDAO conceptoCuotaDao;
    @EJB
    HistPersonaDAO histPersonaDao;
    @EJB
    ClaseContratoDAO claseContratoDao;
    @EJB
    MotivoDevolucionDAO motivoDevolucionDao;
    @EJB
    ComprobAsociadoDAO comprobAsociadoDao;
    @EJB
    private TipoJuegoDAO tipoJuegoDao;
    @EJB
    private ClaseJuegoDAO claseJuegoDao;
    @EJB
    private EstadoOficioLiqDAO estadoOficioLiqDao;
    @EJB
    private GrupoRetencDAO grupoRetencDao;
    @EJB
    private EstadoObligNoPresDAO estadoObligNoPresDao;
    @EJB
    private EstadoDistribEnteDAO estadoDistribEnteDao;
    @EJB
    private TipoNovedadDAO tipoNovedadDao;
    @EJB
    private EstadoOtrosiDAO estadoOtrosiDao;
    @EJB
    private EstadoCierreRecDAO estadoCierreRecDao;
    @EJB
    private CtaContabConcepCuotaDAO ctaContabConcepCuotaDao;
    @EJB
    private RifaPromocionalDAO rifaPromocionalDao;
    @EJB
    private VigenciaFuturaDAO vigenciaFuturaDao;
    @EJB
    private DetRubroVigenFuturaDAO detRubroVigenFuturaDao;
    @EJB
    RequisitoCritDAO requisitoCritDao;
    @EJB
    RevisionFinanDAO revisionFinanDao;
    @EJB
    RevisionGctDAO revisionGctDao;
    @EJB
    CierreAnualContableDAO cierreAnualContableDao;
    @EJB
    EstadoCierreAnualContDAO estadoCierreAnualContDao;
    @EJB
    private CuentaBancoPersonaDAO cuentaBancoPersonaDao;
    @EJB
    private HistPersonalEmpDAO histPersonalEmpDao;
    @EJB
    private TasaIntSuperbanDAO tasaIntSuperbanDao;
    @EJB
    private HitosEmpresaDAO hitosEmpresaDao;
    @EJB
    private PagoOpePseDAO pagoOpePseDao;
    @EJB
    private AcuerdoPagoDAO acuerdoPagoDao;
    @EJB
    private EstadoAcuerdoPagoDAO estadoAcuerdoPagoDao;
    @EJB
    private TipoOrigenDAO tipoOrigenDao;
    @EJB
    RevisionFinancResolAutorizDAO revisionFinancResolAutorizDao;
    @EJB
    RevisionGctResolucAutorizaDAO revisionGctResolucAutorizaDao;
    @EJB
    HlpCuotaAcuerdoDAO hlpCuotaAcuerdoDao;
    @EJB
    HlpCuotaOpCuoAcuDAO hlpCuotaOpCuoAcuDao;
    @EJB
    private LiquidacionContratoDAO liquidacionContratoDao;
    @EJB
    private CausalTermContratoDAO causalTermContratoDao;
    @EJB
    private EstadoLiqContratoDAO estadoLiqContratoDao;
    @EJB
    BeneficiarioEnteDAO beneficiarioEnteDao;
    @EJB
    TipoSociedadDAO tipoSociedadDao;
    @EJB
    ModificacionPlanContDAO modificacionPlanContDao;
    @EJB
    EstadoModifPlanContDAO estadoModifPlanContDao;

    @EJB
    EstadoCuentasContablesDAO estadoCuentasContablesDao;

    @EJB
    DocumSoporModifDAO documSoporModifDao;
    @EJB
    TipoDocSoporteModifDAO tipoDocSoporteModifDao;
    @EJB
    ModPlanConItemPlanDetRubDAO modPlanConItemPlanDetRubDao;
    @EJB
    ItemPlanContDetRubDAO itemPlanContDetRubDesDao;
    @EJB
    CuentaContTipoDocContDAO cuentaContTipoDocContDao;
    @EJB
    ConceptoNominaDAO conceptoNominaDao;
    @EJB
    CategoriaDistribDAO categoriaDistribDao;
    @EJB
    DetalleDeclaracionSugDAO detalleDeclaracionSugDao;
    @EJB
    DeclaracionSugeridaDAO declaracionSugeridaDao;
    @EJB
    private CargaDocumentoContDAO cargaDocumentoContDao;
    @EJB
    private FiscalizadorSustancDAO fiscalizadorSustancDao;
    @EJB
    private TipoActuacionDAO tipoActuacionDao;
    @EJB
    private ConsolidadoDistDAO consolidadoDistDao;
    @EJB
    private HistEstadoFiscalizDAO histEstadoFiscalizDao;
    @EJB
    private ResolucionLiquidacionDAO resolucionLiquidacionDao;
    @EJB
    private EstadoResolucionLiqDAO estadoResolucionLiqDao;
    @EJB
    private RevisionFinanOtroSiDAO revisFinancOtrosiDao;
    @EJB
    private DescargoProcSanDAO descargoProcSanDao;
    @EJB
    private CuotaInexacProcSancDAO cuotaInexacProcSancDao;
    @EJB
    private InventarioProcSanDAO inventarioProcSanDao;
    @EJB
    private CuotaOmisProcSancDAO cuotaOmisProcSancDao;
    @EJB
    private OrdenTrabajoVisitaDAO ordenTrabajoVisitaDao;
    @EJB
    private DenunciaDAO denunciaDao;
    @EJB
    private SustanciadorAuditorDAO sustanciadorAuditorDao;
    @EJB
    private AuditorOrdenTrabDAO auditorOrdenTrabDao;
    @EJB
    private BarrioOrdenDAO barrioOrdenDao;
    @EJB
    private CuadranteOrdenTraDAO cuadranteOrdenTraDAO;
    @EJB
    private DenunciaOrdenTrabDAO denunciaOrdenTrabDao;
    @EJB
    private MunicipioOrdenTrabDAO municipioOrdenTrabDao;
    @EJB
    private ActaDestruccionDAO actaDestruccionDao;
    @EJB
    private EmpresaDestruyeDAO empresaDestruyeDao;
    @EJB
    private MotivoNoDestruccionDAO motivoNoDestruccionDao;
    @EJB
    private ResolucionDecomDestDAO resolucionDecomDestDao;
    @EJB
    private ResultadoResDecDesDAO resultadoResDecDesDao;
    @EJB
    private TramiteResolDecDesDAO tramiteResolDecDesDao;
    @EJB
    private EstadoTramResDecDesDAO estadoTramResDecDesDao;
    @EJB
    private ComunicResolPersIleDAO comunicResolPersIleDao;
    @EJB
    private PersonaInvestProIleDAO personaInvestProIleDao;
    @EJB
    private DireccionProcePerIleDAO direccionProcePerIleDao;
    @EJB
    private ResolucionProcIlegDAO resolucionProcIlegDao;
    @EJB
    private DireccionPersonaDAO direccionPersonaDao;
    @EJB
    private NotaCreditoDAO notaCreditoDao;
    @EJB
    private NotaCredOblConceptoDAO notaCredOblConceptoDao;
    @EJB
    private NotaCredOblConcDetRubDAO notaCredOblConcDetRubDao;
    @EJB
    private ReintegroPagaduriaDAO reintegroPagaduriaDao;
    @EJB
    private InformeSupervisionDAO informeSupervisionDao;
    @EJB
    private MotivoIncuInfSupervDAO motivoIncuInfSupervDao;
    @EJB
    private MotivoIncumplimientoDAO motivoIncumplimientoDao;
    @EJB
    private AutoComisorioDAO autoComisorioDao;
    @EJB
    private IncumplimientoContrDAO incumplimientoContrDao;
    @EJB
    private EstadoIncumplContractDAO estadoIncumplContractDao;
    @EJB
    private RepartoFiscalizadorDAO repartoFiscalizadorDao;
    @EJB
    private SuspensionContrDAO suspensionContrDao;
    @EJB
    private EstadoSuspensionContDAO estadoSuspensionContDao;
    @EJB
    private TerminacionAnticipContDAO terminacionAnticipContDao;
    @EJB
    private EstadoTermAnticipDAO estadoTermAnticipDao;
    @EJB
    private GrupoFiscalizadorDAO grupoFiscalizadorDao;
    @EJB
    private TramiteResolSanConDAO tramiteResolSanConDao;
    @EJB
    private EstadoResolucSanConDAO estadoResolucSanConDao;
    @EJB
    private ResolucionIncumContrDAO resolucionIncumContrDao;
    @EJB
    private ReporteVentasDAO reporteVentasDao;
    @EJB
    private EstablecSuspensionDAO establecimientoSuspensionDao;
    @EJB
    private ResumenNoConectadoDAO resumenNoConectadoDao;
    @EJB
    private AsignacionRecaudoDAO asignacionRecaudoDao;
    @EJB
    private DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    private LiquidacionEstablecimientoDAO liquidacionEstablecimientoDao;
    @EJB
    private LiquidacionMesDAO liquidacionMesDao;
    @EJB
    private UbicacionDAO ubicaDao;
    @EJB
    private TipoIdentificacionDAO tipoIdDao;
    @EJB
    private DireccionProcesalIncDAO direccionProcesalIncDao;
    @EJB
    private AsigRecaudoAaEstablDAO asigRecaudoAaEstablDao;
    @EJB
    private AsignacionRecaudoAaDAO asignacionRecaudoAaDao;
    @EJB
    private ProcesoSancionatorioDAO procesoSancionatorioDao;
    @EJB
    private TramiteResolProcSanDAO tramiteResolProcSanDao;
    @EJB
    private ResolucionProcSancDAO resolucionProcSancDao;
    @EJB
    private EstadoProcesoSancDAO estadoProcesoSancDao;
    @EJB
    private EstadoTramResPrSanDAO estadoTramResPrSanDao;
    @EJB
    private InformeVerificCampoDAO informeVerificCampoDao;
    @EJB
    private BarrioOrdenInfVerDAO barrioOrdenInfVerDao;
    @EJB
    private ElementoIlegInfVerDAO elementoIlegInfVerDao;
    @EJB
    private DenuncOrdTraInfVerDAO denuncOrdTraInfVerDao;
    @EJB
    private MunicOrdTraInfVerifDAO municOrdTraInfVerifDao;
    @EJB
    private CuadranteOrdTraInfVerDAO cuadranteOrdTraInfVerDao;
    @EJB
    private GrupoAccionControlDAO grupoAccionControlDao;
    @EJB 
    private AutoComisorioAccConDAO autoComisorioAccConDao;
    @EJB
    private MotivoAnulAuComAcConDAO motivoAnulAuComAcConDao;    
    @EJB
    private AccionControlDAO accionControlDao;
    @EJB
    private MotivoAnulaAccContDAO motivoAnulaAccContDao;    
    @EJB
    private CuadranteOrdenTraDAO cuadranteOrdenTraDao;
    @EJB
    private ElementoRetiradoAccDAO elementoRetiradoAccDao;
    @EJB
    private TipoElemenIlegalidadDAO tipoElemenIlegalidadDao;
    @EJB
    private PersonaAtiendeAccDAO personaAtiendeAccDao;
    @EJB
    private ResultadoVerifDenunDAO resultadoVerifDenunDao; 
    @EJB
    private DireccionPersonaAtienDAO direccionPersonaAtienDao;
    @EJB
    private MedioDenunciaDAO medioDenunciaDao;
    @EJB
    private ResolucionDecomDestDAO resolucionDecomDestDAO;
    @EJB
    private TipoMultaDAO tipoMultaDao;
    @EJB
    private DireccionDAO direccionDao;
    @EJB
    private TipoCalleDireccionDAO tipoCalleDireccionDao;
    @EJB
    private TipoSectorDirecDAO tipoSectorDireDao;
    @EJB
    private TipoSufijo1CalleDAO tipoSufijo1CalleDao;
    @EJB
    private TipoSufijo2CalleDAO tipoSufijo2CalleDao;
    @EJB
    private HistEstadoSustanDAO histEstadoSustanDao;
    @EJB
    private ActaSuspenAudIncumConDAO actaSuspenAudIncumConDao;
    @EJB
    private ElementoIlegDenunDAO elementoIlegDenunDao;
    @EJB
    private InhabilidadPersonaDAO inhabilidadPersonaDao;
    @EJB
    private ProcesoSancIlegalidadDAO procesoSancIlegalidadDao;
    @EJB
    private CargaActuacionesAdmDAO cargaActuacionesAdmDao;
    @EJB
    private ProcesoOriCargaDAO procesoOriCargaDao;
    @EJB
    private ConcepCuotCarActAdmDAO concepCuotCarActAdmDao;
    @EJB
    private PagoCargaActAdmDAO pagoCargaActAdmDao;
    @EJB
    private EstablecConCuoCarDAO establecConCuoCaDao;
    @EJB
    private TasaInteresDAO tasaInteresDao;
    @EJB
    private  TipoTasaInteresDAO tipoTasaInteresDao;
    @EJB
    private RecepcionAlegatoProSanDAO recepcionAlegatoProSanDao;
    @EJB
    private LogActividadDAO logActividadDao;
    @EJB
    private AjusteContCarActDAO ajusteContCarActDao;
    @EJB
    private ProcesoSancIlegalidadDAO procSancIlegalDao;
    @EJB
    private ResolucionProcIlegDAO resolucionProcIlegalDao;
    @EJB
    private EstadoProcSanIlegDAO estadoProcSanIlegDao;
    @EJB
    private PoblacionEnteDAO poblacionEnteDao;
    @EJB
    private CargaPoblacionDAO cargaPoblacionDao;
    @EJB
    private AutoFormCargProIleDAO autoFormCargProIleDao;
    @EJB
    private ModifEstadoDocContabDAO modifEstadoDocContabDao;
    @EJB
    private TarifaIlegalidadDAO tarifaIlegalidadDao;
    @EJB
    private TramiteResolProIleDAO tramiteResolProIleDao;
    @EJB
    private EstadoTramResProcIlegDAO estadoTramResProcDao;
    @EJB
    private PersonaInvProIleAutoDAO personaInvProIleAutoDao;
    @EJB
    private TramiteAutoForCarIleDAO tramiteAutoForCarIleDao;
    @EJB
    private DescargoProcIlegDAO descargoProcIlegDao;
    @EJB
    private PruebaDescargoProIleDAO pruebaDescargoProIleDao;
    @EJB
    private TipoPruebaIlegDAO tipoPruebaIlegDao;
    @EJB
    private AutoDecretaPrueProIleDAO autoDecretaPrueProIleDao;
    @EJB
    private PerInvesProIleAutoPruDAO perInvesProIleAutoPruDao;
    @EJB
    private PruebaAutoDecrPruDAO pruebaAutoDecrPruDao;
    @EJB
    private TramiteAutoPrueTrasDAO tramiteAutoPrueTrasDao;
    @EJB
    private ElementoProcesoIleDAO elementoProcesoIleDao;
    @EJB
    private ComunicacSujSancIleDAO comunicacSujSancIleDao;
    @EJB
    TipoApuestPolizaRenovacDAO tipoApuestPolizaRenovacDao;
    


    /**
     * Constructor.
     */
    public ConversionVOEntidad() {
    }

    public SiiUsuario convertir(UsuarioVO usuarioVo) throws ExcepcionDAO {
        SiiUsuario siiUsuario = new SiiUsuario();
        if (usuarioVo.getUsuCodigo() != null && usuarioVo.getUsuCodigo() > 0) {
            siiUsuario = usuarioDao.buscarUsuarioPorId(usuarioVo.getUsuCodigo());
        }
        siiUsuario.setUsuCodigo(usuarioVo.getUsuCodigo());
        siiUsuario.setUsuContrasena(usuarioVo.getUsuContrasena());
        siiUsuario.setUsuEmail(usuarioVo.getUsuEmail());
        siiUsuario.setUsuFechaUltimoLogin(usuarioVo.getUsuFechaUltimoLogin());
        siiUsuario.setUsuNombreUsuario(usuarioVo.getUsuNombreUsuario());
        siiUsuario.setUsuSalt(usuarioVo.getUsuSalt());
        siiUsuario.setUsuFechaCreacion(usuarioVo.getUsuFechaCreacion());

        if (usuarioVo.getEstadoUsuarioVo() != null) {
            SiiEstadoUsuario estadoUsuario =
                estadoUsuarioDao.buscarEstadoUsuarioPorId(usuarioVo.getEstadoUsuarioVo().getEusCodigo());
            siiUsuario.setSiiEstadoUsuario(estadoUsuario);
        }
        if (usuarioVo.getPersonaVo() != null && usuarioVo.getPersonaVo().getPerCodigo() != null && usuarioVo.getPersonaVo().getPerCodigo() > 0) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(usuarioVo.getPersonaVo().getPerCodigo());
            siiUsuario.setSiiPersona(siiPersona);
        }
        if (usuarioVo.getAreaColjuegosVo() != null && usuarioVo.getAreaColjuegosVo().getAcoCodigo() > 0) {
            SiiAreaColjuegos siiAreaColjuegos =
                areaColjuegosDao.buscarAreaColjuegosPorId(usuarioVo.getAreaColjuegosVo().getAcoCodigo());
            siiUsuario.setSiiAreaColjuegos1(siiAreaColjuegos);
        }
        if (usuarioVo.getFuncionVo() != null && usuarioVo.getFuncionVo().getFunCodigo() > 0) {
            SiiFuncion siiFuncion = funcionDao.buscarFuncionPorId(usuarioVo.getFuncionVo().getFunCodigo());
            siiUsuario.setSiiFuncion1(siiFuncion);
        }
        return siiUsuario;
    }

    public SiiEstadoUsuario convertir(EstadoUsuarioVO estadoUsuarioVo) throws ExcepcionDAO {
        SiiEstadoUsuario siiEstadoUsuario = new SiiEstadoUsuario();
        if (estadoUsuarioVo.getEusCodigo() != null && estadoUsuarioVo.getEusCodigo() > 0) {
            siiEstadoUsuario = estadoUsuarioDao.buscarEstadoUsuarioPorId(estadoUsuarioVo.getEusCodigo());
        }
        siiEstadoUsuario.setEusCodigo(estadoUsuarioVo.getEusCodigo());
        siiEstadoUsuario.setEusDescripcion(estadoUsuarioVo.getEusDescripcion());
        siiEstadoUsuario.setEusNombre(estadoUsuarioVo.getEusNombre());
        return siiEstadoUsuario;
    }

    public SiiFuncion convertir(FuncionVO funcionVo) throws ExcepcionDAO {
        SiiFuncion siiFuncion = new SiiFuncion();
        if (funcionVo.getFunCodigo() != null && funcionVo.getFunCodigo() > 0) {
            siiFuncion = funcionDao.buscarFuncionPorId(funcionVo.getFunCodigo());
        }
        siiFuncion.setFunActivo(funcionVo.getFunActivo());
        siiFuncion.setFunCodigo(funcionVo.getFunCodigo());
        siiFuncion.setFunDescripcion(funcionVo.getFunDescripcion());
        siiFuncion.setFunNombre(funcionVo.getFunNombre());
        return siiFuncion;
    }


    /**
     * Giovanni //Modificacion
     * @param personaVo
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPersona convertir(PersonaVO personaVo) throws ExcepcionDAO {
        SiiPersona siiPersona = new SiiPersona();
        if (personaVo.getPerCodigo() != null && personaVo.getPerCodigo() > 0) {
            siiPersona = personaDao.buscarPersonaPorId(personaVo.getPerCodigo());
        }
        siiPersona.setPerCelular(personaVo.getPerCelular());
        siiPersona.setPerDireccion(personaVo.getPerDireccion());
        siiPersona.setPerEmail(personaVo.getPerEmail());
        siiPersona.setPerFax(personaVo.getPerFax());
        siiPersona.setPerJurNombreCorto(personaVo.getPerJurNombreCorto());
        siiPersona.setPerJurNombreLargo(personaVo.getPerJurNombreLargo());
        siiPersona.setPerNumIdentificacion(personaVo.getPerNumIdentificacion());
        siiPersona.setPerPrimerApellido(personaVo.getPerPrimerApellido());
        siiPersona.setPerSegundoApellido(personaVo.getPerSegundoApellido());
        siiPersona.setPerPrimerNombre(personaVo.getPerPrimerNombre());
        siiPersona.setPerSegundoNombre(personaVo.getPerSegundoNombre());
        siiPersona.setPerTelefono(personaVo.getPerTelefono());
        siiPersona.setPerTelefono2(personaVo.getPerTelefono2());
        siiPersona.setPerTipoPersona(personaVo.getPerTipoPersona());
        siiPersona.setPerDigitoVerif(personaVo.getPerDigitoVerif());
        siiPersona.setPerTipoProveedor(personaVo.getPerTipoProveedor());
        siiPersona.setPerCiudadExt(personaVo.getPerCiudadExt());
        siiPersona.setPerProdServ(personaVo.getPerProdServ());
        siiPersona.setPerObservProd(personaVo.getPerObservProd());
        siiPersona.setPerPaginaWeb(personaVo.getPerPaginaWeb());
        siiPersona.setPerTarjetaPro(personaVo.getPerNumTarjetaProfesional());
        siiPersona.setPerRifaPromo(personaVo.getPerRifaPromo());
        siiPersona.setPerEstampUnal(personaVo.getPerEstampUnal());
        siiPersona.setPerPlazo(personaVo.getPerPlazo());

        //Tipo Identificacion
        if (personaVo.getTipoIdentificacionVo() != null && personaVo.getTipoIdentificacionVo().getTidCodigo() != null) {
            SiiTipoIdentificacion unTipoId =
                tipoIdentificacionDao.buscarTipoIdentificacionPorId(personaVo.getTipoIdentificacionVo().getTidCodigo());
            siiPersona.setSiiTipoIdentificacion1(unTipoId);
        }

        //Tipo Retencion Rentas
        if (personaVo.getTipoRetencionRentasVo() != null) {
            SiiTipoRetencion siiTipoRetencionRentas =
                tipoRetencionDao.buscarPorCodigo(personaVo.getTipoRetencionRentasVo().getTreCodigo());
            siiPersona.setSiiTipoRetencionRentas(siiTipoRetencionRentas);
        }

        //Tipo Retencion Ventas
        if (personaVo.getTipoRetencionVentasVo() != null) {
            SiiTipoRetencion siiTipoRetencionVentas =
                tipoRetencionDao.buscarPorCodigo(personaVo.getTipoRetencionVentasVo().getTreCodigo());
            siiPersona.setSiiTipoRetencionVentas(siiTipoRetencionVentas);
        }

        //Ubicacion
        if (personaVo.getUbicacionVo() != null && personaVo.getUbicacionVo().getUbiCodigo() != null &&
            !personaVo.getUbicacionVo().getUbiCodigo().equals("")) {
            SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId(personaVo.getUbicacionVo().getUbiCodigo());
            siiPersona.setSiiUbicacion1(siiUbicacion);
        }
        //Tipo de sociedad
        if (personaVo.getTipoSociedadVO() != null && personaVo.getTipoSociedadVO().getTsoCodigo() != null) {
            SiiTipoSociedad siiTipoSociedad =
                tipoSociedadDao.buscarPorCodigo(personaVo.getTipoSociedadVO().getTsoCodigo());
            siiPersona.setSiiTipoSociedad(siiTipoSociedad);
        }
        //Representante Legal
        if (personaVo.getPersonaRepresentanteVo() != null &&
            personaVo.getPersonaRepresentanteVo().getPerCodigo() != null) {
            SiiPersona siiPersonaRepLegal =
                personaDao.buscarPersonaPorId(personaVo.getPersonaRepresentanteVo().getPerCodigo());
            siiPersona.setSiiPersona(siiPersonaRepLegal);
        }
        return siiPersona;
    }

    public SiiArchivoFisico convertir(ArchivoFisicoVO archivoFisicoVo) throws ExcepcionDAO {
        SiiArchivoFisico archivoFisico = new SiiArchivoFisico();
        if (archivoFisicoVo.getAfiCodigo() != null && archivoFisicoVo.getAfiCodigo() > 0) {
            archivoFisico = archivoFisicoDao.buscarArchivoFisicoPorId(archivoFisicoVo.getAfiCodigo());
        }
        archivoFisico.setAfiCodigo(archivoFisicoVo.getAfiCodigo());
        archivoFisico.setAfiNombreFs(archivoFisicoVo.getAfiNombreFs());
        archivoFisico.setAfiNombreOrignal(archivoFisicoVo.getAfiNombreOrignal());
        archivoFisico.setAfiPathRelativo(archivoFisicoVo.getAfiPathRelativo());
        archivoFisico.setAfiActivo(archivoFisicoVo.getAfiActivo());
        return archivoFisico;
    }

    public SiiEstadoSolEstMercado convertir(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO {
        SiiEstadoSolEstMercado estadoSolEstMercado = new SiiEstadoSolEstMercado();
        if (estadoSolEstMercadoVo.getEseCodigo() != null && estadoSolEstMercadoVo.getEseCodigo() > 0) {
            estadoSolEstMercado =
                estadoSolEstMercadoDao.buscarEstadoSolEstMercadoPorId(estadoSolEstMercadoVo.getEseCodigo());
        }
        estadoSolEstMercado.setEseCodigo(estadoSolEstMercadoVo.getEseCodigo());
        estadoSolEstMercado.setEseDescripcion(estadoSolEstMercadoVo.getEseDescripcion());
        estadoSolEstMercado.setEseNombre(estadoSolEstMercadoVo.getEseNombre());
        return estadoSolEstMercado;
    }


    public SiiProcesoColjuegos convertir(ProcesoColjuegosVO procesoColjuegosVo) throws ExcepcionDAO {
        SiiProcesoColjuegos procesoColjuegos = new SiiProcesoColjuegos();
        if (procesoColjuegosVo.getPcoCodigo() != null && procesoColjuegosVo.getPcoCodigo() > 0) {
            procesoColjuegos = procesoColjuegosDao.buscarProcesoColjuegosPorId(procesoColjuegosVo.getPcoCodigo());
        }
        procesoColjuegos.setPcoCodigo(procesoColjuegosVo.getPcoCodigo());
        procesoColjuegos.setPcoDescripcion(procesoColjuegosVo.getPcoDescripcion());
        procesoColjuegos.setPcoNombre(procesoColjuegosVo.getPcoNombre());
        return procesoColjuegos;
    }

    public SiiTipoIdentificacion convertir(TipoIdentificacionVO tipoIdentificacionVo) throws ExcepcionDAO {
        SiiTipoIdentificacion tipoIdentificacion = new SiiTipoIdentificacion();
        if (tipoIdentificacionVo.getTidCodigo() != null && tipoIdentificacionVo.getTidCodigo() > 0) {
            tipoIdentificacion =
                tipoIdentificacionDao.buscarTipoIdentificacionPorId(tipoIdentificacionVo.getTidCodigo());
        }
        tipoIdentificacion.setTidActivo(tipoIdentificacionVo.getTidActivo());
        tipoIdentificacion.setTidCodigo(tipoIdentificacionVo.getTidCodigo());
        tipoIdentificacion.setTidNombre(tipoIdentificacionVo.getTidNombre());
        tipoIdentificacion.setTidNombreCorto(tipoIdentificacionVo.getTidNombreCorto());
        return tipoIdentificacion;
    }

    public SiiSolicitudEstMercado convertir(SolicitudEstMercadoVO solicitudEstMercadoVo) throws ExcepcionDAO {
        SiiSolicitudEstMercado solicitudEstMercado = new SiiSolicitudEstMercado();
        if (solicitudEstMercadoVo.getSemCodigo() != null && solicitudEstMercadoVo.getSemCodigo() > 0) {
            solicitudEstMercadoDao.buscarSolicitudEstMercadoPorId(solicitudEstMercadoVo.getSemCodigo());
        }
        solicitudEstMercado.setSemCalidadEsperada(solicitudEstMercadoVo.getSemCalidadEsperada());
        solicitudEstMercado.setSemCodigo(solicitudEstMercadoVo.getSemCodigo());
        solicitudEstMercado.setSemCotizacionesRecib(solicitudEstMercadoVo.getSemCotizacionesRecib());
        solicitudEstMercado.setSemEstandaresOblig(solicitudEstMercadoVo.getSemEstandaresOblig());
        solicitudEstMercado.setSemFechaEstInicio(solicitudEstMercadoVo.getSemFechaEstInicio());
        solicitudEstMercado.setSemFechaRegistro(solicitudEstMercadoVo.getSemFechaRegistro());
        solicitudEstMercado.setSemInformacionFuncional(solicitudEstMercadoVo.getSemInformacionFuncional());
        solicitudEstMercado.setSemInformacionTecnica(solicitudEstMercadoVo.getSemInformacionTecnica());
        solicitudEstMercado.setSemNombreSupervExterno(solicitudEstMercadoVo.getSemNombreSupervExterno());
        solicitudEstMercado.setSemNumIdentifExterno(solicitudEstMercadoVo.getSemNumIdentifExterno());
        solicitudEstMercado.setSemObjetoContrato(solicitudEstMercadoVo.getSemObjetoContrato());
        solicitudEstMercado.setSemObligacionesContr(solicitudEstMercadoVo.getSemObligacionesContr());
        solicitudEstMercado.setSemPerfilProveedor(solicitudEstMercadoVo.getSemPerfilProveedor());
        solicitudEstMercado.setSemProductosEntregar(solicitudEstMercadoVo.getSemProductosEntregar());
        solicitudEstMercado.setSemResultadosEsperados(solicitudEstMercadoVo.getSemResultadosEsperados());
        solicitudEstMercado.setSemRiesgosIdentif(solicitudEstMercadoVo.getSemRiesgosIdentif());
        solicitudEstMercado.setSemServiciosAdicionales(solicitudEstMercadoVo.getSemServiciosAdicionales());
        solicitudEstMercado.setSemTiempoEstimado(solicitudEstMercadoVo.getSemTiempoEstimado());
        solicitudEstMercado.setSemTipoSupervisor(solicitudEstMercadoVo.getSemTipoSupervisor());
        solicitudEstMercado.setSemUnidTiempoEstim(solicitudEstMercadoVo.getSemUnidTiempoEstim());
        solicitudEstMercado.setSemValorEstimado(solicitudEstMercadoVo.getSemValorEstimado());
        solicitudEstMercado.setSemObservaciones(solicitudEstMercadoVo.getSemObservaciones());
        solicitudEstMercado.setSemFechaDevol(solicitudEstMercadoVo.getSemFechaDevol());

        //Padres
        if (solicitudEstMercadoVo.getAreaColjuegosVo() != null) {
            SiiAreaColjuegos siiAreaColjuegos =
                areaColjuegosDao.buscarAreaColjuegosPorId(solicitudEstMercadoVo.getAreaColjuegosVo().getAcoCodigo());
            solicitudEstMercado.setSiiAreaColjuegos(siiAreaColjuegos);
        }

        if (solicitudEstMercadoVo.getEstadoSolEstMercadoVo() != null) {
            SiiEstadoSolEstMercado unEstadoEM =
                estadoSolEstMercadoDao.buscarEstadoSolEstMercadoPorId(solicitudEstMercadoVo.getEstadoSolEstMercadoVo().getEseCodigo());
            solicitudEstMercado.setSiiEstadoSolEstMercado(unEstadoEM);
        }
        if (solicitudEstMercadoVo.getProcesoColjuegosVo() != null) {
            SiiProcesoColjuegos unProceso =
                procesoColjuegosDao.buscarProcesoColjuegosPorId(solicitudEstMercadoVo.getProcesoColjuegosVo().getPcoCodigo());
            solicitudEstMercado.setSiiProcesoColjuegos(unProceso);
        }

        if (solicitudEstMercadoVo.getTipoIdentificacionVo() != null) {
            SiiTipoIdentificacion unTipoIdentificacion =
                tipoIdentificacionDao.buscarTipoIdentificacionPorId(solicitudEstMercadoVo.getTipoIdentificacionVo().getTidCodigo());
            solicitudEstMercado.setSiiTipoIdentificacion(unTipoIdentificacion);

        }
        if (solicitudEstMercadoVo.getUsuario2Vo() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(solicitudEstMercadoVo.getUsuario2Vo().getUsuCodigo());
            solicitudEstMercado.setSiiUsuario2(siiUsuario);
        }
        if (solicitudEstMercadoVo.getProcesoContratacionVo() != null) {
            SiiProcesoContratacion siiProcesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(solicitudEstMercadoVo.getProcesoContratacionVo().getPrcCodigo());
            solicitudEstMercado.setSiiProcesoContratacion(siiProcesoContratacion);
        }
        if (solicitudEstMercadoVo.getUbicacionVo() != null) {
            SiiUbicacion siiUbicacion =
                ubicacionDao.buscarUbicacionPorId(solicitudEstMercadoVo.getUbicacionVo().getUbiCodigo());
            solicitudEstMercado.setSiiUbicacion1(siiUbicacion);
        }
        if (solicitudEstMercadoVo.getItemPlancontratacionVo() != null) {
            SiiItemPlanContratac siiItemPlanContratac =
                itemPlanContratacionDao.buscarItemPlanContratacPorId(solicitudEstMercadoVo.getItemPlancontratacionVo().getIpcCodigo());
            solicitudEstMercado.setSiiItemPlanContratac(siiItemPlanContratac);
        }
        return solicitudEstMercado;
    }


    public SiiEstudioPrevio convertir(EstudioPrevioVO estudioPrevioVo) throws ExcepcionDAO {
        SiiEstudioPrevio siiEstudioPrevio = new SiiEstudioPrevio();
        if (estudioPrevioVo.getEpeCodigo() != null && estudioPrevioVo.getEpeCodigo() > 0) {
            estudioPrevioDao.buscarEstudioPrevioPorId(estudioPrevioVo.getEpeCodigo());
        }
        siiEstudioPrevio.setEpeCodigo(estudioPrevioVo.getEpeCodigo());
        siiEstudioPrevio.setEpeAnalisiEcon(estudioPrevioVo.getEpeAnalisiEcon());
        siiEstudioPrevio.setEpeDescrJustif(estudioPrevioVo.getEpeDescrJustif());
        siiEstudioPrevio.setEpeFecha(estudioPrevioVo.getEpeFecha());
        siiEstudioPrevio.setEpeFormaPago(estudioPrevioVo.getEpeFormaPago());
        siiEstudioPrevio.setEpeFormasAnaliz(estudioPrevioVo.getEpeFormasAnaliz());
        siiEstudioPrevio.setEpeObligacContrat(estudioPrevioVo.getEpeObligacContrat());
        siiEstudioPrevio.setEpePresupEstim(estudioPrevioVo.getEpePresupEstim());
        siiEstudioPrevio.setEpeTiempoDurac(estudioPrevioVo.getEpeTiempoDurac());
        siiEstudioPrevio.setEpeUnidadDurac(estudioPrevioVo.getEpeUnidadDurac());
        siiEstudioPrevio.setEpeValorContrat(estudioPrevioVo.getEpeValorContrat());
        siiEstudioPrevio.setEpeVigencia(estudioPrevioVo.getEpeVigencia());
        siiEstudioPrevio.setEpeRiesgo(estudioPrevioVo.getEpeRiesgo());
        //Padres
        if (estudioPrevioVo.getUsuarioVo() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(estudioPrevioVo.getUsuarioVo().getUsuCodigo());
            siiEstudioPrevio.setSiiUsuario(siiUsuario);
        }
        if (estudioPrevioVo.getUbicacionVo() != null) {
            SiiUbicacion siiUbicacion =
                ubicacionDao.buscarUbicacionPorId(estudioPrevioVo.getUbicacionVo().getUbiCodigo());
            siiEstudioPrevio.setSiiUbicacion1(siiUbicacion);
        }
        if (estudioPrevioVo.getProcesoContratacionVo() != null) {
            SiiProcesoContratacion siiProcesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(estudioPrevioVo.getProcesoContratacionVo().getPrcCodigo());
            siiEstudioPrevio.setSiiProcesoContratacion(siiProcesoContratacion);
        }
        if (estudioPrevioVo.getTipoGarantiaVo() != null) {
            SiiTipoGarantia siiTipoGarantia =
                tipoGarantiaDao.buscarTipoGarantiaPorId(estudioPrevioVo.getTipoGarantiaVo().getTgaCodigo());
            siiEstudioPrevio.setSiiTipoGarantia(siiTipoGarantia);
        }
        if (estudioPrevioVo.getEstadoEstPrevVo() != null && estudioPrevioVo.getEstadoEstPrevVo().getEepCodigo() > 0) {
            SiiEstadoEstPrev siiEstadoEstPrev =
                estadoEstPrevDao.buscarEstadoEstPrevPorId(estudioPrevioVo.getEstadoEstPrevVo().getEepCodigo());
            siiEstudioPrevio.setSiiEstadoEstPrev(siiEstadoEstPrev);
        }
        if (estudioPrevioVo.getItemPlanContratacVo() != null) {
            SiiItemPlanContratac siiItemPlanContratac = new SiiItemPlanContratac();
            siiItemPlanContratac.setIpcCodigo(estudioPrevioVo.getItemPlanContratacVo().getIpcCodigo());
            siiEstudioPrevio.setSiiItemPlanContratac(siiItemPlanContratac);
        }
        return siiEstudioPrevio;
    }

    public SiiAreaColjuegos convertir(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO {
        SiiAreaColjuegos siiAreaColjuegos = null;
        if (areaColjuegosVo.getAcoCodigo() != null && areaColjuegosVo.getAcoCodigo() > 0) {
            siiAreaColjuegos = areaColjuegosDao.buscarAreaColjuegosPorId(areaColjuegosVo.getAcoCodigo());
        }

        if (siiAreaColjuegos == null)
            siiAreaColjuegos = new SiiAreaColjuegos();


        siiAreaColjuegos.setAcoCodigo(areaColjuegosVo.getAcoCodigo());
        siiAreaColjuegos.setAcoCodigoPadre(areaColjuegosVo.getAcoCodigoPadre());
        siiAreaColjuegos.setAcoNombre(areaColjuegosVo.getAcoNombre());
        siiAreaColjuegos.setAcoAbreviatura(areaColjuegosVo.getAcoAbreviatura());
        siiAreaColjuegos.setAcoActivo(areaColjuegosVo.getAcoActivo());
        siiAreaColjuegos.setAcoDescripcion(areaColjuegosVo.getAcoDescripcion());
        return siiAreaColjuegos;
    }

    public SiiProcesoContratacion convertir(ProcesoContratacionVO procesoContratacionVo) throws ExcepcionDAO {
        SiiProcesoContratacion siiProcesoContratacion = new SiiProcesoContratacion();

        if (procesoContratacionVo.getPrcCodigo() != null && procesoContratacionVo.getPrcCodigo() > 0) {
            procesoContratacionDao.buscarProcesoContratacionPorId(procesoContratacionVo.getPrcCodigo());
        }
        siiProcesoContratacion.setPrcCodigo(procesoContratacionVo.getPrcCodigo());
        siiProcesoContratacion.setPrcObjeto(procesoContratacionVo.getPrcObjeto());

        // padres
        if (procesoContratacionVo.getEstadoProcContrat() != null) {
            SiiEstadoProcContrat siiEstProCon =
                estadoProcContratDao.BuscarEstadoProcContratPorId(procesoContratacionVo.getEstadoProcContrat().getEpcCodigo());
            siiProcesoContratacion.setSiiEstadoProcContrat(siiEstProCon);
        }
        if (procesoContratacionVo.getExpedienteFisicoVo() != null) {
            SiiExpedienteFisico siiExpedienteFisico =
                expedienteFisicoDao.buscarExpedienteFisicoPorId(procesoContratacionVo.getExpedienteFisicoVo().getEfiCodigo());
            siiProcesoContratacion.setSiiExpedienteFisico(siiExpedienteFisico);
        }


        return siiProcesoContratacion;
    }


    public SiiConsultaWebContrat convertir(ConsultaWebContratVO consultaWebContratVo) throws ExcepcionDAO {
        SiiConsultaWebContrat consultaWebContrat = new SiiConsultaWebContrat();
        if (consultaWebContratVo.getCwcCodigo() != null && consultaWebContratVo.getCwcCodigo() > 0) {
            consultaWebContrat =
                consultaWebContratDao.buscarConsultaWebContratPorId(consultaWebContratVo.getCwcCodigo());
        }
        consultaWebContrat.setCwcEntidad(consultaWebContratVo.getCwcEntidad());
        consultaWebContrat.setCwcFecha(consultaWebContratVo.getCwcFecha());
        consultaWebContrat.setCwcObjetoCont(consultaWebContratVo.getCwcObjetoCont());
        consultaWebContrat.setCwcCodigo(consultaWebContratVo.getCwcCodigo());
        //Padres:
        if (consultaWebContratVo.getArchivoFisicoVO() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(consultaWebContratVo.getArchivoFisicoVO().getAfiCodigo());
            consultaWebContrat.setSiiArchivoFisico(siiArchivoFisico);
        }
        return consultaWebContrat;
    }


    public SiiCotizacionEstudio convertir(CotizacionEstudioVO cotizacionEstudioVO) throws ExcepcionDAO {
        SiiCotizacionEstudio cotizacionEstudio = new SiiCotizacionEstudio();
        if (cotizacionEstudioVO.getCesCodigo() != null && cotizacionEstudioVO.getCesCodigo() > 0) {
            cotizacionEstudio = cotizacionEstudioDao.buscarCotizacionEstudioPorId(cotizacionEstudioVO.getCesCodigo());
        }
        cotizacionEstudio.setCesCodigo(cotizacionEstudioVO.getCesCodigo());
        cotizacionEstudio.setCesCondPago(cotizacionEstudioVO.getCesCondPago());
        cotizacionEstudio.setCesDescPronto(cotizacionEstudioVO.getCesDescPronto());
        cotizacionEstudio.setCesGarantia(cotizacionEstudioVO.getCesGarantia());
        cotizacionEstudio.setCesIva(cotizacionEstudioVO.getCesIva());
        cotizacionEstudio.setCesTiempoEntrega(cotizacionEstudioVO.getCesTiempoEntrega());
        cotizacionEstudio.setCesValorTotal(cotizacionEstudioVO.getCesValorTotal());
        cotizacionEstudio.setCesVigPolizas(cotizacionEstudioVO.getCesVigPolizas());
        cotizacionEstudio.setCesVigencia(cotizacionEstudioVO.getCesVigencia());
        cotizacionEstudio.setCesEspecificac(cotizacionEstudioVO.getCesEspecificac());
        //Padres:

        if (cotizacionEstudioVO.getConsultaWebContratVO() != null) {
            SiiConsultaWebContrat consultaWebContrat =
                consultaWebContratDao.buscarConsultaWebContratPorId(cotizacionEstudioVO.getConsultaWebContratVO().getCwcCodigo());
            cotizacionEstudio.setSiiConsultaWebContrat(consultaWebContrat);
        }

        //        cotizacionEstudio.setSiiConsultaWebContrat(convetir(cotizacionEstudioVO.getConsultaWebContratVO()));

        if (cotizacionEstudioVO.getEstudioMercadoVO() != null) {
            SiiEstudioMercado estudioMercado =
                estudioMercadoDao.buscarEstudioMercadoPorId(cotizacionEstudioVO.getEstudioMercadoVO().getEmeCodigo());
            cotizacionEstudio.setSiiEstudioMercado(estudioMercado);
        }

        //        cotizacionEstudio.setSiiEstudioMercado(convertir(cotizacionEstudioVO.getEstudioMercadoVO()));

        if (cotizacionEstudioVO.getProveedorVO() != null) {
            SiiProveedor siiProveedor =
                proveedorDao.buscarProveedorPorId(cotizacionEstudioVO.getProveedorVO().getProCodigo());
            cotizacionEstudio.setSiiProveedor(siiProveedor);
        }

        //        cotizacionEstudio.setSiiProveedor(convertir(cotizacionEstudioVO.getProveedorVO()));
        //
        if (cotizacionEstudioVO.getTipoServicioVO() != null) {
            SiiTipoServicio tipoServicio =
                tipoServicioDao.buscarTipoServicioPorId(cotizacionEstudioVO.getTipoServicioVO().getTseCodigo());
            cotizacionEstudio.setSiiTipoServicio(tipoServicio);
        }

        //        cotizacionEstudio.setSiiTipoServicio(convertir(cotizacionEstudioVO.getTipoServicioVO()));
        if (cotizacionEstudioVO.getUbicacionVO() != null) {
            SiiUbicacion siiUbicacion =
                ubicacionDao.buscarUbicacionPorId(cotizacionEstudioVO.getUbicacionVO().getUbiCodigo());
            cotizacionEstudio.setSiiUbicacion1(siiUbicacion);
        }
        //        cotizacionEstudio.setSiiUbicacion1(convertir(cotizacionEstudioVO.getUbicacionVO()));

        return cotizacionEstudio;
    }

    public SiiItemCotizacion convertir(ItemCotizacionVO itemCotizacionVo) throws ExcepcionDAO {
        SiiItemCotizacion itemCotizacion = new SiiItemCotizacion();
        if (itemCotizacionVo.getIcoCodigo() != null && itemCotizacionVo.getIcoCodigo() > 0) {
            itemCotizacion = itemCotizacionDao.buscarItemCotizacionPorId(itemCotizacionVo.getIcoCodigo());
        }
        itemCotizacion.setIcoCodigo(itemCotizacionVo.getIcoCodigo());
        itemCotizacion.setIcoValorUnit(itemCotizacionVo.getIcoValorUnit());
        itemCotizacion.setIcoIva(itemCotizacionVo.getIcoIva());
        itemCotizacion.setIcoEspecificac(itemCotizacionVo.getIcoEspecificac());
        //Padres:
        if (itemCotizacionVo.getItemSolicitudVo() != null) {
            SiiItemSolicitud siiItemSolicitud =
                itemSolicitudDao.buscarItemSolicitudPorId(itemCotizacionVo.getItemSolicitudVo().getIsoCodigo());
            itemCotizacion.setSiiItemSolicitud(siiItemSolicitud);

        }
        if (itemCotizacionVo.getCotizacionEstudioVo() != null) {
            SiiCotizacionEstudio siiCotizacionEstudio =
                cotizacionEstudioDao.buscarCotizacionEstudioPorId(itemCotizacionVo.getCotizacionEstudioVo().getCesCodigo());
            itemCotizacion.setSiiCotizacionEstudio(siiCotizacionEstudio);
        }

        return itemCotizacion;
    }

    public SiiItemPlanContratac convertir(ItemPlanContratacVO itemPlanContratacVo) throws ExcepcionDAO {
        SiiItemPlanContratac itemPlanContratac = new SiiItemPlanContratac();
        if (itemPlanContratacVo.getIpcCodigo() != null && itemPlanContratacVo.getIpcCodigo() > 0) {
            itemPlanContratac =
                itemPlanContratacionDao.buscarItemPlanContratacPorId(itemPlanContratacVo.getIpcCodigo());
        }
        itemPlanContratac.setIpcCodigo(itemPlanContratacVo.getIpcCodigo());
        itemPlanContratac.setIpcDescripcion(itemPlanContratacVo.getIpcDescripcion());
        itemPlanContratac.setIpcFechaFinCon(itemPlanContratacVo.getIpcFechaFinCon());
        itemPlanContratac.setIpcFechaIniCon(itemPlanContratacVo.getIpcFechaIniCon());
        itemPlanContratac.setIpcFechaIniProc(itemPlanContratacVo.getIpcFechaIniProc());
        itemPlanContratac.setIpcModContrat(itemPlanContratacVo.getIpcModContrat());
        itemPlanContratac.setIpcNombre(itemPlanContratacVo.getIpcNombre());
        itemPlanContratac.setIpcTipologia(itemPlanContratacVo.getIpcTipologia());
        itemPlanContratac.setIpcValorEst(itemPlanContratacVo.getIpcValorEst());
        itemPlanContratac.setIpcValorNacion(itemPlanContratacVo.getIpcValorNacion());
        itemPlanContratac.setIpcValorPropios(itemPlanContratacVo.getIpcValorPropios());
        itemPlanContratac.setIpcValorVigFut(itemPlanContratacVo.getIpcValorVigFut());
        if (itemPlanContratacVo.getAreaColjuegosVo() != null) {
            SiiAreaColjuegos siiAreaColjuegos =
                areaColjuegosDao.buscarAreaColjuegosPorId(itemPlanContratacVo.getAreaColjuegosVo().getAcoCodigo());
            itemPlanContratac.setSiiAreaColjuegos(siiAreaColjuegos);
        }
        if (itemPlanContratacVo.getPlanContratacionVo() != null &&
            itemPlanContratacVo.getPlanContratacionVo().getPcnCodigo() != null &&
            itemPlanContratacVo.getPlanContratacionVo().getPcnCodigo() > 0) {
            SiiPlanContratacion siiPlanContratacion =
                planContratacionDao.buscarPlanContratacionPorId(itemPlanContratacVo.getPlanContratacionVo().getPcnCodigo());
            itemPlanContratac.setSiiPlanContratacion(siiPlanContratacion);
        }
        return itemPlanContratac;
    }

    public SiiItemSolicitud convertir(ItemSolicitudVO itemSolicitudVO) throws ExcepcionDAO {
        SiiItemSolicitud itemSolicitud = new SiiItemSolicitud();
        if (itemSolicitudVO.getIsoCodigo() != null && itemSolicitudVO.getIsoCodigo() > 0) {
            itemSolicitud = itemSolicitudDao.buscarItemSolicitudPorId(itemSolicitudVO.getIsoCodigo());
        }
        itemSolicitud.setIsoCantidad(itemSolicitudVO.getIsoCantidad());
        itemSolicitud.setIsoCodigo(itemSolicitudVO.getIsoCodigo());
        itemSolicitud.setIsoDescripcion(itemSolicitudVO.getIsoDescripcion());
        itemSolicitud.setIsoNombre(itemSolicitudVO.getIsoNombre());
        itemSolicitud.setIsoUnidad(itemSolicitudVO.getIsoUnidad());
        itemSolicitud.setIsoValorUnitUltima(itemSolicitudVO.getIsoValorUnitUltima());
        //Padres:
        if (itemSolicitudVO.getSolicitudEstMercadoVO() != null) {
            SiiSolicitudEstMercado siiSolicitudEstMercado =
                solicitudEstMercadoDao.buscarSolicitudEstMercadoPorId(itemSolicitudVO.getSolicitudEstMercadoVO().getSemCodigo());
            itemSolicitud.setSiiSolicitudEstMercado(siiSolicitudEstMercado);
        }
        return itemSolicitud;
    }

    public SiiProveedor convertir(ProveedorVO proveedorVO) throws ExcepcionDAO {
        SiiProveedor proveedor = new SiiProveedor();
        if (proveedorVO.getProCodigo() != null && proveedorVO.getProCodigo() > 0) {
            proveedor = proveedorDao.buscarProveedorPorId(proveedorVO.getProCodigo());
        }
        proveedor.setProCodigo(proveedorVO.getProCodigo());
        proveedor.setProEjecutivoCuenta(proveedorVO.getProEjecutivoCuenta());
        //Padres:
        if (proveedorVO.getPersonaVo() != null) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(proveedorVO.getPersonaVo().getPerCodigo());
            proveedor.setSiiPersona(siiPersona);
        }

        return proveedor;
    }

    public SiiEstudioMercado convertir(EstudioMercadoVO estudioMercadoVO) throws ExcepcionDAO {
        SiiEstudioMercado estudioMercado = new SiiEstudioMercado();
        if (estudioMercadoVO.getEmeCodigo() != null && estudioMercadoVO.getEmeCodigo() > 0) {
            estudioMercado = estudioMercadoDao.buscarEstudioMercadoPorId(estudioMercadoVO.getEmeCodigo());
        }
        estudioMercado.setEmeCodigo(estudioMercadoVO.getEmeCodigo());
        estudioMercado.setEmeAnalisisMercado(estudioMercadoVO.getEmeAnalisisMercado());
        estudioMercado.setEmeDivulAcercam(estudioMercadoVO.getEmeDivulAcercam());
        estudioMercado.setEmeDivulAcercamFec(estudioMercadoVO.getEmeDivulAcercamFec());
        estudioMercado.setEmeDivulEmail(estudioMercadoVO.getEmeDivulEmail());
        estudioMercado.setEmeDivulEmailFec(estudioMercadoVO.getEmeDivulEmailFec());
        estudioMercado.setEmeDivulOtroFec(estudioMercadoVO.getEmeDivulOtroFec());
        estudioMercado.setEmeDivulOtro(estudioMercadoVO.getEmeDivulOtro());
        estudioMercado.setEmeDivulOtroEspec(estudioMercadoVO.getEmeDivulOtroEspec());
        estudioMercado.setEmeDivulProv(estudioMercadoVO.getEmeDivulProv());
        estudioMercado.setEmeDivulProvFec(estudioMercadoVO.getEmeDivulProvFec());
        estudioMercado.setEmeDivulTel(estudioMercadoVO.getEmeDivulTel());
        estudioMercado.setEmeDivulTelFec(estudioMercadoVO.getEmeDivulTelFec());
        estudioMercado.setEmeFecha(estudioMercadoVO.getEmeFecha());
        estudioMercado.setEmeObservaciones(estudioMercadoVO.getEmeObservaciones());
        estudioMercado.setEmeReqPolizas(estudioMercadoVO.getEmeReqPolizas());
        //Padres:
        //estudioMercado.setSiiProcesoContratacion1(procesoContratacionDao.buscarProcesoContratacionPorId(estudioMercadoVO.getProcesoContratacionVO().getPrcCodigo()));
        if (estudioMercadoVO.getProcesoContratacionVO() != null) {
            SiiProcesoContratacion siiProcesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(estudioMercadoVO.getProcesoContratacionVO().getPrcCodigo());
            estudioMercado.setSiiProcesoContratacion1(siiProcesoContratacion);
        }
        //estudioMercado.setSiiEstadoEstudioMerc(estadoEstudioMercDao.buscarEstadoEstudioMercPorId(estudioMercadoVO.getEstadoEstudioMercVO().getEemCodigo()));

        if (estudioMercadoVO.getEstadoEstudioMercVO() != null) {
            SiiEstadoEstudioMerc estadoEstudioMerc =
                estadoEstudioMercDao.buscarEstadoEstudioMercPorId(estudioMercadoVO.getEstadoEstudioMercVO().getEemCodigo());
            estudioMercado.setSiiEstadoEstudioMerc(estadoEstudioMerc);

        }

        return estudioMercado;
    }

    public SiiEstadoEstudioMerc convertir(EstadoEstudioMercVO estadoEstudioMercVO) throws ExcepcionDAO {
        SiiEstadoEstudioMerc estadoEstudioMerc = new SiiEstadoEstudioMerc();
        if (estadoEstudioMercVO.getEemCodigo() != null && estadoEstudioMercVO.getEemCodigo() > 0) {
            estadoEstudioMerc = estadoEstudioMercDao.buscarEstadoEstudioMercPorId(estadoEstudioMercVO.getEemCodigo());
        }
        estadoEstudioMerc.setEemCodigo(estadoEstudioMercVO.getEemCodigo());
        estadoEstudioMerc.setEemDescripcion(estadoEstudioMercVO.getEemDescripcion());
        estadoEstudioMerc.setEemNombre(estadoEstudioMercVO.getEemNombre());
        return estadoEstudioMerc;
    }

    public SiiEstadoEstPrev convertir(EstadoEstPrevVO estadoEstPrevVo) throws ExcepcionDAO {
        SiiEstadoEstPrev estadoEstPrev = new SiiEstadoEstPrev();
        estadoEstPrev.setEepCodigo(estadoEstPrevVo.getEepCodigo());
        estadoEstPrev.setEepDescripcion(estadoEstPrevVo.getEepDescripcion());
        estadoEstPrev.setEepNombre(estadoEstPrevVo.getEepNombre());
        return estadoEstPrev;
    }

    public SiiEstadoInvitacion convertir(EstadoInvitacionVO estadoInvitacionVO) throws ExcepcionDAO {
        SiiEstadoInvitacion estadoInvitacion = new SiiEstadoInvitacion();
        estadoInvitacion.setEinCodigo(estadoInvitacionVO.getEinCodigo());
        estadoInvitacion.setEinDescripcion(estadoInvitacionVO.getEinDescripcion());
        estadoInvitacion.setEinNombre(estadoInvitacionVO.getEinNombre());
        return estadoInvitacion;
    }

    public SiiEstadoProcContrat convertir(EstadoProcContratVO estadoProcContratVO) throws ExcepcionDAO {
        SiiEstadoProcContrat siiEstadoProcContrat = new SiiEstadoProcContrat();
        if (estadoProcContratVO.getEpcCodigo() != null && estadoProcContratVO.getEpcCodigo() > 0) {
            estadoProcContratDao.BuscarEstadoProcContratPorId(estadoProcContratVO.getEpcCodigo());
        }
        siiEstadoProcContrat.setEpcCodigo(estadoProcContratVO.getEpcCodigo());
        siiEstadoProcContrat.setEpcDescripcion(estadoProcContratVO.getEpcDescripcion());
        siiEstadoProcContrat.setEpcNombre(estadoProcContratVO.getEpcNombre());
        return siiEstadoProcContrat;
    }


    public SiiTipoDocumentoColjuegos convertir(TipoDocumentoColjuegosVO tipoDocumentoColjuegosVo) throws ExcepcionDAO {
        SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos = new SiiTipoDocumentoColjuegos();
        if (tipoDocumentoColjuegosVo.getTdoCodigo() != null && tipoDocumentoColjuegosVo.getTdoCodigo() > 0) {
            siiTipoDocumentoColjuegos =
                tipoDocumentoColjuegosDao.buscarTipoDocumentoColjuegosPorId(tipoDocumentoColjuegosVo.getTdoCodigo());
        }
        siiTipoDocumentoColjuegos.setTdoCodigo(tipoDocumentoColjuegosVo.getTdoCodigo());
        siiTipoDocumentoColjuegos.setTdoDescripcion(tipoDocumentoColjuegosVo.getTdoDescripcion());
        siiTipoDocumentoColjuegos.setTdoNombre(tipoDocumentoColjuegosVo.getTdoNombre());

        return siiTipoDocumentoColjuegos;
    }

    public SiiFirmaDocumento convertirVoAEntidad(FirmaDocumentoVO firmaDocumentoVo) throws ExcepcionDAO {
        SiiFirmaDocumento firmaDocumento = new SiiFirmaDocumento();
        if (firmaDocumentoVo.getFdoCodigo() != null && firmaDocumentoVo.getFdoCodigo() > 0) {
            firmaDocumento = firmaDocumentoDao.buscarFirmaDocumentoPorId(firmaDocumentoVo.getFdoCodigo());
        }
        firmaDocumento.setFdoCodigo(firmaDocumentoVo.getFdoCodigo());
        firmaDocumento.setFdoIdDocumento(firmaDocumentoVo.getFdoIdDocumento());
        firmaDocumento.setTdoFechaFirma(firmaDocumentoVo.getFdoFechaFirma());
        //Padres
        if (firmaDocumentoVo.getFirmasRequeridasVo() != null) {
            SiiFirmasRequeridas siiFirmasRequeridas =
                firmasRequeridasDao.buscarFirmasRequeridasPorId(firmaDocumentoVo.getFirmasRequeridasVo().getFreCodigo());
            firmaDocumento.setSiiFirmasRequeridas(siiFirmasRequeridas);
        }
        if (firmaDocumentoVo.getUsuarioVo() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(firmaDocumentoVo.getUsuarioVo().getUsuCodigo());
            firmaDocumento.setSiiUsuario(siiUsuario);
        }
        return firmaDocumento;
    }

    public SiiFirmasRequeridas convertir(FirmasRequeridasVO firmasRequeridasVo) throws ExcepcionDAO {
        SiiFirmasRequeridas firmasRequeridas = new SiiFirmasRequeridas();
        if (firmasRequeridasVo.getFreCodigo() != null && firmasRequeridasVo.getFreCodigo() > 0) {
            firmasRequeridasDao.buscarFirmasRequeridasPorId(firmasRequeridasVo.getFreCodigo());
        }
        firmasRequeridas.setFreCodigo(firmasRequeridasVo.getFreCodigo());
        firmasRequeridas.setFreEtiqueta(firmasRequeridasVo.getFreEtiqueta());
        firmasRequeridas.setFreActivo(firmasRequeridasVo.getFreActivo());
        //Padres:
        if (firmasRequeridasVo.getFuncionVO() != null) {
            SiiFuncion siiFuncion = funcionDao.buscarFuncionPorId(firmasRequeridasVo.getFuncionVO().getFunCodigo());
            firmasRequeridas.setSiiFuncion(siiFuncion);
        }
        if (firmasRequeridasVo.getTipoDocumentoColjuegosVo() != null) {
            SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos =
                tipoDocumentoColjuegosDao.buscarTipoDocumentoColjuegosPorId(firmasRequeridasVo.getTipoDocumentoColjuegosVo().getTdoCodigo());
            firmasRequeridas.setSiiTipoDocumentoColjuegos1(siiTipoDocumentoColjuegos);
        }
        return firmasRequeridas;

    }

    public SiiInvitacionProceso convertir(InvitacionProcesoVO invitacionProcesoVO) throws ExcepcionDAO {
        SiiInvitacionProceso invitacionProceso = new SiiInvitacionProceso();

        if (invitacionProcesoVO.getIprCodigo() != null && invitacionProcesoVO.getIprCodigo() > 0) {
            invitacionProceso = invitacionProcesoDao.buscarInvitacionProcesoPorId(invitacionProcesoVO.getIprCodigo());
        }

        invitacionProceso.setIprCodigo(invitacionProcesoVO.getIprCodigo());
        invitacionProceso.setIprFecha(invitacionProcesoVO.getIprFecha());
        invitacionProceso.setIprFechaVenc(invitacionProcesoVO.getIprFechaVenc());

        if (invitacionProcesoVO.getProcesoContratacionVO() != null) {
            SiiProcesoContratacion procesoContra =
                procesoContratacionDao.buscarProcesoContratacionPorId(invitacionProcesoVO.getProcesoContratacionVO().getPrcCodigo());
            invitacionProceso.setSiiProcesoContratacion(procesoContra);
        }
        if (invitacionProcesoVO.getEstadoInvitacionVO() != null) {
            SiiEstadoInvitacion siiEstadoInvitacion =
                estadoInvitacionDao.buscarEstadoInvitacionPorId(invitacionProcesoVO.getEstadoInvitacionVO().getEinCodigo());
            invitacionProceso.setSiiEstadoInvitacion(siiEstadoInvitacion);
        }
        if (invitacionProcesoVO.getUsuarioVO() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(invitacionProcesoVO.getUsuarioVO().getUsuCodigo());
            invitacionProceso.setSiiUsuario(siiUsuario);
        }

        return invitacionProceso;
    }

    public SiiProveedorInvitacion convertir(ProveedorInvitacionVO proveedorInvitacionVO) throws ExcepcionDAO {
        SiiProveedorInvitacion proveedorInvitacion = new SiiProveedorInvitacion();
        if (proveedorInvitacionVO.getPinCodigo() != null && proveedorInvitacionVO.getPinCodigo() > 0) {
            proveedorInvitacion =
                proveedorInvitacionDao.buscarProveedorInvitacionPorId(proveedorInvitacionVO.getPinCodigo());
        }

        proveedorInvitacion.setPinCodigo(proveedorInvitacionVO.getPinCodigo());

        // padres
        if (proveedorInvitacionVO.getInvitacionProcesoVO() != null) {
            SiiInvitacionProceso siiInvitacionProceso =
                invitacionProcesoDao.buscarInvitacionProcesoPorId(proveedorInvitacionVO.getInvitacionProcesoVO().getIprCodigo());
            proveedorInvitacion.setSiiInvitacionProceso(siiInvitacionProceso);
        }

        if (proveedorInvitacionVO.getProveedorVO() != null) {
            SiiProveedor siiProveedor =
                proveedorDao.buscarProveedorPorId(proveedorInvitacionVO.getProveedorVO().getProCodigo());
            proveedorInvitacion.setSiiProveedor(siiProveedor);
        }
        return proveedorInvitacion;
    }

    public SiiEstadoPfc convertir(EstadoPfcVO siiEstadoPfcVo) throws ExcepcionDAO {
        SiiEstadoPfc siiEstadoPfc = new SiiEstadoPfc();
        if (siiEstadoPfcVo.getEpfCodigo() != null && siiEstadoPfcVo.getEpfCodigo() > 0) {
            siiEstadoPfc = estadoPfcDao.buscarPorEpfCodigo(siiEstadoPfcVo.getEpfCodigo());
        }
        siiEstadoPfc.setEpfCodigo(siiEstadoPfcVo.getEpfCodigo());
        siiEstadoPfc.setEpfNombre(siiEstadoPfcVo.getEpfNombre());
        siiEstadoPfc.setEpfDescripcion(siiEstadoPfcVo.getEpfDescripcion());
        return siiEstadoPfc;
    }

    public SiiMes convertir(MesVO mesVo) throws ExcepcionDAO {
        SiiMes siiMes = new SiiMes();
        if (mesVo.getMesCodigo() != null && mesVo.getMesCodigo() > 0) {
            siiMes = mesDao.buscarMesPorId(mesVo.getMesCodigo());
        }
        siiMes.setMesCodigo(mesVo.getMesCodigo());
        siiMes.setMesNombre(mesVo.getMesNombre());
        siiMes.setMesNombreCorto(mesVo.getMesNombreCorto());
        return siiMes;
    }

    /**
     * @author Modifica Giovanni
     * @param tipoGarantiaVo
     * @return
     */
    public SiiTipoGarantia convertir(TipoGarantiaVO tipoGarantiaVo) {
        SiiTipoGarantia siiTipoGarantia = new SiiTipoGarantia();
        if (tipoGarantiaVo.getTgaCodigo() != null) {
            siiTipoGarantia.setTgaCodigo(tipoGarantiaVo.getTgaCodigo());
        }

        siiTipoGarantia.setTgaActivo(tipoGarantiaVo.getTgaActivo());
        siiTipoGarantia.setTgaDescripciom(tipoGarantiaVo.getTgaDescripciom());
        siiTipoGarantia.setTgaNombre(tipoGarantiaVo.getTgaNombre());
        return siiTipoGarantia;
    }

    public SiiObligacionPago convertir(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO {
        SiiObligacionPago siiObligacionPago = new SiiObligacionPago();
        if (obligacionPagoVo.getOpaCodigo() != null && obligacionPagoVo.getOpaCodigo() > 0) {
            siiObligacionPago = obligacionPagoDao.buscarObligacionPagoPorId(obligacionPagoVo.getOpaCodigo());
        }
        siiObligacionPago.setOpaCodigo(obligacionPagoVo.getOpaCodigo());
        siiObligacionPago.setOpaNumeroDocSop(obligacionPagoVo.getOpaNumeroDocSop());
        siiObligacionPago.setOpaVigencia(obligacionPagoVo.getOpaVigencia());
        siiObligacionPago.setTdsCodigo(obligacionPagoVo.getTdsCodigo());

        if (obligacionPagoVo.getMesVo() != null) {
            SiiMes siiMes = mesDao.buscarMesPorId(obligacionPagoVo.getMesVo().getMesCodigo());
            siiObligacionPago.setSiiMes(siiMes);
        }
        if (obligacionPagoVo.getMes1Vo() != null) {
            SiiMes siiMes = mesDao.buscarMesPorId(obligacionPagoVo.getMes1Vo().getMesCodigo());
            siiObligacionPago.setSiiMes1(siiMes);
        }
        if (obligacionPagoVo.getTipoDocSoporteVo() != null) {
            SiiTipoDocSoporte siiTipoDocSoporte =
                tipoDocSoporteDao.buscarTipoDocumentoSoportePorId(obligacionPagoVo.getTipoDocSoporteVo().getTdsCodigo());
            siiObligacionPago.setSiiTipoDocSoporte(siiTipoDocSoporte);
        }
        return siiObligacionPago;
    }

    public SiiObligDetRubroCdp converir(ObligDetRubroCdpVO obligDetRubroCdpVo) throws ExcepcionDAO {
        SiiObligDetRubroCdp obligDetRubroCdp = new SiiObligDetRubroCdp();
        if (obligDetRubroCdpVo.getOdrCodigo() != null && obligDetRubroCdpVo.getOdrCodigo() > 0) {
            obligDetRubroCdp = ObligDetRubroCdpDao.buscarObligDetRubroCdpPorId(obligDetRubroCdpVo.getOdrCodigo());
        }
        obligDetRubroCdp.setOdrValorPagar(obligDetRubroCdpVo.getOdrValorPagar());
        obligDetRubroCdp.setOdrValorGmf(obligDetRubroCdpVo.getCuatroXMil());
        obligDetRubroCdp.setOdrActivo(obligDetRubroCdpVo.getOdrActivo());

        if (obligDetRubroCdpVo.getDetalleRubroCdpVo() != null &&
            obligDetRubroCdpVo.getDetalleRubroCdpVo().getDrcCodigo() != null &&
            obligDetRubroCdpVo.getDetalleRubroCdpVo().getDrcCodigo() > 0) {
            SiiDetalleRubroCdp siidetalleRubroCdp =
                detalleRubroCdpDao.buscarPorCodigoDetalleRubro(obligDetRubroCdpVo.getDetalleRubroCdpVo().getDrcCodigo());
            obligDetRubroCdp.setSiiDetalleRubroCdp(siidetalleRubroCdp);
        }

        if (obligDetRubroCdpVo.getRpDetRubroCdpVo() != null &&
            obligDetRubroCdpVo.getRpDetRubroCdpVo().getRdrCodigo() != null &&
            obligDetRubroCdpVo.getRpDetRubroCdpVo().getRdrCodigo() > 0) {
            SiiRpDetRubroCdp siiRpDetRubroCdp =
                rpDetRubroCdpDao.buscarCodigoRpDetRubroCdp(obligDetRubroCdpVo.getRpDetRubroCdpVo().getRdrCodigo());
            obligDetRubroCdp.setSiiRpDetRubroCdp(siiRpDetRubroCdp);
        }

        return obligDetRubroCdp;
    }

    public SiiTipoDocSoporte convertir(TipoDocSoporteVO tipoDocSoporteVo) throws ExcepcionDAO {
        SiiTipoDocSoporte siiTipoDocSoporte = new SiiTipoDocSoporte();
        if (tipoDocSoporteVo.getTdsCodigo() != null && tipoDocSoporteVo.getTdsCodigo() > 0) {
            siiTipoDocSoporte = tipoDocSoporteDao.buscarTipoDocumentoSoportePorId(tipoDocSoporteVo.getTdsCodigo());
        }
        siiTipoDocSoporte.setTdsCodigo(tipoDocSoporteVo.getTdsCodigo());
        siiTipoDocSoporte.setTdsNombre(tipoDocSoporteVo.getTdsNombre());
        return siiTipoDocSoporte;
    }

    public SiiDetalleRubro convertir(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubro = new SiiDetalleRubro();
        if (detalleRubroVo.getDruCodigo() != null && detalleRubroVo.getDruCodigo() > 0) {
            detalleRubroDao.buscarPorCodigoDetalleRubro(detalleRubroVo.getDruCodigo());
        }
        siiDetalleRubro.setDruCodigo(detalleRubroVo.getDruCodigo());
        siiDetalleRubro.setDruValor(detalleRubroVo.getDruValor());
        siiDetalleRubro.setInterno(detalleRubroVo.getInterno());
        siiDetalleRubro.setVigencia(detalleRubroVo.getVigencia());
        //Padres
        if (detalleRubroVo.getDetFuenteFinanciacionVo() != null) {
            SiiDtlleFuenteFinanciacion siiDtlleFuenteDinanciacion =
                detalleFuenteFinanciacionDao.buscarDtlleFuenteFinanciacionPorId(detalleRubroVo.getDetFuenteFinanciacionVo().getDffCodigo());
            siiDetalleRubro.setSiiDtlleFuenteFinanciacion(siiDtlleFuenteDinanciacion);
        }

        if (detalleRubroVo.getFuenteFinancContabVo() != null) {
            SiiFuenteFinancContab unSiiFuenteFinancContab =
                fuenteFinancContabDao.buscarPorCodigo(detalleRubroVo.getFuenteFinancContabVo().getFfcCodigo());
            siiDetalleRubro.setSiiFuenteFinancContab(unSiiFuenteFinancContab);
        }

        return siiDetalleRubro;
    }

    public SiiDtlleFuenteFinanciacion convertir(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO {
        if (siiDtlleFuenteFinanciacionVo == null) {
            return null;
        }
        SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion = new SiiDtlleFuenteFinanciacion();
        if (siiDtlleFuenteFinanciacionVo.getDffCodigo() != null && siiDtlleFuenteFinanciacionVo.getDffCodigo() > 0) {
            siiDtlleFuenteFinanciacion =
                detalleFuenteFinanciacionDao.buscarDtlleFuenteFinanciacionPorId(siiDtlleFuenteFinanciacionVo.getDffCodigo());
        }
        siiDtlleFuenteFinanciacion.setDffCodigo(siiDtlleFuenteFinanciacionVo.getDffCodigo());
        siiDtlleFuenteFinanciacion.setDffCodigoRecurso(siiDtlleFuenteFinanciacionVo.getDffCodigoRecurso());
        siiDtlleFuenteFinanciacion.setDffDescripcion(siiDtlleFuenteFinanciacionVo.getDffDescripcion());
        return siiDtlleFuenteFinanciacion;
    }

    public SiiProyeccionFlujoCaja convertir(ProyeccionFlujoCajaVO unProyeccionFlujoCajaVo) throws ExcepcionDAO {
        SiiProyeccionFlujoCaja siiProyeccionFlujoCaja = new SiiProyeccionFlujoCaja();
        if (unProyeccionFlujoCajaVo.getPfcCodigo() != null && unProyeccionFlujoCajaVo.getPfcCodigo() > 0) {
            siiProyeccionFlujoCaja = proyeccionFlujoCajaDao.buscarPorCodigoPFC(unProyeccionFlujoCajaVo.getPfcCodigo());
        }
        siiProyeccionFlujoCaja.setPfcCodigo(unProyeccionFlujoCajaVo.getPfcCodigo());
        siiProyeccionFlujoCaja.setPfcFechaSolicitud(unProyeccionFlujoCajaVo.getPfcFechaSolicitud());
        siiProyeccionFlujoCaja.setPfcVigencia(unProyeccionFlujoCajaVo.getPfcVigencia());
        //Padres:
        if (unProyeccionFlujoCajaVo.getEstadoPfcVo() != null) {
            SiiEstadoPfc siiEstadoPfc =
                estadoPfcDao.buscarPorEpfCodigo(unProyeccionFlujoCajaVo.getEstadoPfcVo().getEpfCodigo());
            siiProyeccionFlujoCaja.setSiiEstadoPfc(siiEstadoPfc);
        }
        return siiProyeccionFlujoCaja;
    }

    public SiiDistribucionPfc convertir(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO {
        SiiDistribucionPfc siiDistribucionPfc = new SiiDistribucionPfc();
        if (distribucionPfcVo.getDpfCodigo() != null && distribucionPfcVo.getDpfCodigo() > 0) {
            siiDistribucionPfc = distribucionPfcDao.buscarDistribucionPfcPorId(distribucionPfcVo.getDpfCodigo());
        }
        siiDistribucionPfc.setDpfCodigo(distribucionPfcVo.getDpfCodigo());
        siiDistribucionPfc.setDpfValor(distribucionPfcVo.getDpfValor());
        siiDistribucionPfc.setDpfValorAprobado(distribucionPfcVo.getDpfValorAprobado());
        //Padres
        SiiDetalleRubro unSiiDetalleRubro = new SiiDetalleRubro();
        unSiiDetalleRubro.setDruCodigo(distribucionPfcVo.getDetalleRubroVo().getDruCodigo());
        siiDistribucionPfc.setSiiDetalleRubro(unSiiDetalleRubro);

        if (distribucionPfcVo.getProyeccionFlujoCajaVo() != null) {
            SiiProyeccionFlujoCaja unSiiProyeccionFlujoCaja =
                proyeccionFlujoCajaDao.buscarPfcPorId(distribucionPfcVo.getProyeccionFlujoCajaVo().getPfcCodigo());
            siiDistribucionPfc.setSiiProyeccionFlujoCaja(unSiiProyeccionFlujoCaja);
        }

        if (distribucionPfcVo.getMesVo() != null) {
            SiiMes unSiiMes = mesDao.buscarMesPorId(distribucionPfcVo.getMesVo().getMesCodigo());
            siiDistribucionPfc.setSiiMes(unSiiMes);
        }

        return siiDistribucionPfc;
    }

    public SiiFuenteFinanciacion convertir(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO {
        SiiFuenteFinanciacion siiFuenteFinanciacion = new SiiFuenteFinanciacion();
        if (siiFuenteFinanciacionVo.getFfiCodigo() != null && siiFuenteFinanciacionVo.getFfiCodigo() > 0) {
            fuenteFinanciacionDao.buscarFuenteFinanciacionPorId(siiFuenteFinanciacionVo.getFfiCodigo());
        }
        siiFuenteFinanciacion.setFfiCodigo(siiFuenteFinanciacionVo.getFfiCodigo());
        siiFuenteFinanciacion.setFfiCodigoFuente(siiFuenteFinanciacionVo.getFfiCodigoFuente());
        siiFuenteFinanciacion.setFfiDescripcion(siiFuenteFinanciacionVo.getFfidescripcion());
        siiFuenteFinanciacion.setFfiNombre(siiFuenteFinanciacionVo.getFfiNombre());
        return siiFuenteFinanciacion;
    }

    public SiiTipoUbicacion convertir(TipoUbicacionVO tipoUbicacionVo) throws ExcepcionDAO {
        SiiTipoUbicacion siiTipoUbicacion = new SiiTipoUbicacion();
        if (tipoUbicacionVo != null) {
            tipoUbicacionDao.buscarTipoUbicacionPorId(tipoUbicacionVo.getTiuCodigo());
        }
        siiTipoUbicacion.setTiuCodigo(tipoUbicacionVo.getTiuCodigo());
        siiTipoUbicacion.setTiuNombre(tipoUbicacionVo.getTiuNombre());
        return siiTipoUbicacion;
    }

    public SiiUbicacion convertir(UbicacionVO ubicacionVo) throws ExcepcionDAO {
        SiiUbicacion siiUbicacion = new SiiUbicacion();
        if (ubicacionVo.getUbiCodigo() != null) {
            ubicacionDao.buscarUbicacionPorId(ubicacionVo.getUbiCodigo());
        }
        siiUbicacion.setUbiCodigo(ubicacionVo.getUbiCodigo());
        siiUbicacion.setUbiCodigoPadre(ubicacionVo.getUbiCodigoPadre());
        siiUbicacion.setUbiDescripcion(ubicacionVo.getUbiDescripcion());
        siiUbicacion.setUbiNombre(ubicacionVo.getUbiNombre());
        if (ubicacionVo.getTipoUbicacionVo() != null) {
            SiiTipoUbicacion siiTipoUbicacion =
                tipoUbicacionDao.buscarTipoUbicacionPorId(ubicacionVo.getTipoUbicacionVo().getTiuCodigo());
            siiUbicacion.setSiiTipoUbicacion(siiTipoUbicacion);
        }
        return siiUbicacion;
    }


    //Falta la busqueda por id
    public PrNivel1 convertir(PrNivel1VO prNivel1Vo) throws ExcepcionDAO {
        PrNivel1 prNivel1 = new PrNivel1();
        prNivel1.setInterno(prNivel1Vo.getInterno());
        prNivel1.setVigencia(prNivel1Vo.getVigencia());
        prNivel1.setCodigo(prNivel1Vo.getCodigo());
        prNivel1.setDescripcion(prNivel1Vo.getDescripcion());
        prNivel1.setTipoPlan(prNivel1Vo.getTipoPlan());
        return prNivel1;
    }

    public PrNivel2 convertir(PrNivel2VO prNivel2Vo) throws ExcepcionDAO {
        PrNivel2 prNivel2 = new PrNivel2();
        prNivel2.setCodigo(prNivel2Vo.getCodigo());
        prNivel2.setDescripcion(prNivel2Vo.getDescripcion());
        prNivel2.setInterno(prNivel2Vo.getInterno());
        prNivel2.setInternoNivel1(prNivel2Vo.getInternoNivel1());
        prNivel2.setTipoPlan(prNivel2Vo.getTipoPlan());
        prNivel2.setVigencia(prNivel2Vo.getVigencia());
        return prNivel2;
    }

    public PrNivel3 convertir(PrNivel3VO prNivel3Vo) throws ExcepcionDAO {
        PrNivel3 prNivel3 = new PrNivel3();
        prNivel3.setCodigo(prNivel3Vo.getCodigo());
        prNivel3.setDescripcion(prNivel3Vo.getDescripcion());
        prNivel3.setInterno(prNivel3Vo.getInterno());
        prNivel3.setInternoNivel2(prNivel3Vo.getInternoNivel2());
        prNivel3.setTipoPlan(prNivel3Vo.getTipoPlan());
        prNivel3.setVigencia(prNivel3Vo.getVigencia());
        return prNivel3;
    }

    public PrNivel4 convertir(PrNivel4VO prNivel4Vo) {
        PrNivel4 prNivel4 = new PrNivel4();
        prNivel4.setCodigo(prNivel4Vo.getCodigo());
        prNivel4.setDescripcion(prNivel4Vo.getDescripcion());
        prNivel4.setInterno(prNivel4Vo.getInterno());
        prNivel4.setInternoNivel3(prNivel4Vo.getInternoNivel3());
        prNivel4.setTipoPlan(prNivel4Vo.getTipoPlan());
        prNivel4.setVigencia(prNivel4Vo.getVigencia());
        return prNivel4;
    }

    public PrNivel5 convertir(PrNivel5VO prNivel5Vo) throws ExcepcionDAO {
        PrNivel5 prNivel5 = new PrNivel5();
        prNivel5.setCodigo(prNivel5Vo.getCodigo());
        prNivel5.setDescripcion(prNivel5Vo.getDescripcion());
        prNivel5.setInterno(prNivel5Vo.getInterno());
        prNivel5.setInternoNivel4(prNivel5Vo.getInternoNivel4());
        prNivel5.setTipoPlan(prNivel5Vo.getTipoPlan());
        prNivel5.setVigencia(prNivel5Vo.getVigencia());
        return prNivel5;
    }

    public PrNivel6 convertir(PrNivel6VO prNivel6Vo) throws ExcepcionDAO {
        PrNivel6 prNivel6 = new PrNivel6();
        prNivel6.setCodigo(prNivel6Vo.getCodigo());
        prNivel6.setDescripcion(prNivel6Vo.getDescripcion());
        prNivel6.setInterno(prNivel6Vo.getInterno());
        prNivel6.setInternoNivel5(prNivel6Vo.getInternoNivel5());
        prNivel6.setTipoPlan(prNivel6Vo.getTipoPlan());
        prNivel6.setVigencia(prNivel6Vo.getVigencia());
        return prNivel6;
    }

    public PrNivel7 convertir(PrNivel7VO prNivel7Vo) throws ExcepcionDAO {
        PrNivel7 prNivel7 = new PrNivel7();
        prNivel7.setCodigo(prNivel7Vo.getCodigo());
        prNivel7.setDescripcion(prNivel7Vo.getDescripcion());
        prNivel7.setInterno(prNivel7Vo.getInterno());
        prNivel7.setInternoNivel6(prNivel7Vo.getInternoNivel6());
        prNivel7.setTipoPlan(prNivel7Vo.getTipoPlan());
        prNivel7.setVigencia(prNivel7Vo.getVigencia());
        return prNivel7;
    }

    public PrNivel8 convertir(PrNivel8VO prNivel8Vo) throws ExcepcionDAO {
        PrNivel8 prNivel8 = new PrNivel8();
        prNivel8.setCodigo(prNivel8Vo.getCodigo());
        prNivel8.setDescripcion(prNivel8Vo.getDescripcion());
        prNivel8.setInterno(prNivel8Vo.getInterno());
        prNivel8.setInternoNivel7(prNivel8Vo.getInternoNivel7());
        prNivel8.setTipoPlan(prNivel8Vo.getTipoPlan());
        prNivel8.setVigencia(prNivel8Vo.getVigencia());
        return prNivel8;
    }

    public PrRubro convertir(PrRubroVO prRubroVo) throws ExcepcionDAO {
        PrRubro prRubro = new PrRubro();
        prRubro.setAdministracion(prRubroVo.getAdministracion());
        prRubro.setAinCodigo(prRubroVo.getAinCodigo());
        prRubro.setCostos(prRubroVo.getCostos());
        prRubro.setDescripcion(prRubroVo.getDescripcion());
        prRubro.setInterno(prRubroVo.getInterno());
        prRubro.setVigencia(prRubroVo.getVigencia());
        prRubro.setInternoNivel1(prRubroVo.getInternoNivel1());
        prRubro.setInternoNivel2(prRubroVo.getInternoNivel2());
        prRubro.setInternoNivel3(prRubroVo.getInternoNivel3());
        prRubro.setInternoNivel4(prRubroVo.getInternoNivel4());
        prRubro.setInternoNivel5(prRubroVo.getInternoNivel5());
        prRubro.setInternoNivel6(prRubroVo.getInternoNivel6());
        prRubro.setInternoNivel7(prRubroVo.getInternoNivel7());
        prRubro.setInternoNivel8(prRubroVo.getInternoNivel8());
        prRubro.setTipoPlan(prRubroVo.getTipoPlan());
        prRubro.setFuenteContable(prRubroVo.getFuenteContable());
        return prRubro;
    }


    public SiiCdp convertir(CdpVO cdpVO) throws ExcepcionDAO {
        SiiCdp cdp = new SiiCdp();
        if (cdpVO.getCdpCodigo() != null && cdpVO.getCdpCodigo() > 0) {
            cdp = cdpDao.buscarCdpPorId(cdpVO.getCdpCodigo());
        }
        cdp.setCdpCodigo(cdpVO.getCdpCodigo());
        cdp.setCdpFechaSolic(cdpVO.getCdpFechaSolic());
        cdp.setCdpFechaExpedicion(cdpVO.getCdpFechaExpedicion());
        cdp.setCdpJustificacion(cdpVO.getCdpJustificacion());
        cdp.setCdpNumeroDocSop(cdpVO.getCdpNumeroDocSop());
        cdp.setCdpObjeto(cdpVO.getCdpObjeto());
        cdp.setCdpSaldoAnterior(cdpVO.getCdpSaldoAnterior());
        cdp.setCdpValorSolicit(cdpVO.getCdpValorSolicit());
        cdp.setCdpVigencia(cdpVO.getCdpVigencia());
        cdp.setCdpVigenciaAfectada(cdpVO.getCdpVigenciaAfectada());
        cdp.setCdpConsecutivo(cdpVO.getCdpConsecutivo());
        cdp.setCdpFechaExpedicion(cdpVO.getCdpFechaExpedicion());
        cdp.setCdpNumeroSiif(cdpVO.getCdpNumeroSiif());
        cdp.setCdpNumContrato(cdpVO.getCdpNumContrato());
        cdp.setCdpFechaCont(cdpVO.getCdpFechaCont());
        cdp.setCdpObjetoCont(cdpVO.getCdpObjetoCont());
        cdp.setCdpFechaVigFut(cdpVO.getCdpFechaVigFut());
        cdp.setCdpNumVigFut(cdpVO.getCdpNumVigFut());

        if (cdpVO.getUsuarioVO() != null) {
            SiiUsuario unSiiUsuario = usuarioDao.buscarUsuarioPorId(cdpVO.getUsuarioVO().getUsuCodigo());
            cdp.setSiiUsuario(unSiiUsuario);
        }
        if (cdpVO.getProcesoContratacionVO() != null) {
            SiiProcesoContratacion unProcesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(cdpVO.getProcesoContratacionVO().getPrcCodigo());
            cdp.setSiiProcesoContratacion(unProcesoContratacion);
        }
        if (cdpVO.getEstadoCdpVO() != null) {
            SiiEstadoCdp unEstadoCdp = estadoCdpDao.buscarEstadoCdpPorId(cdpVO.getEstadoCdpVO().getEcdCodigo());
            cdp.setSiiEstadoCdp(unEstadoCdp);
        }
        if (cdpVO.getAreaColjuegosVO() != null) {
            SiiAreaColjuegos unAreaColjuegos =
                areaColjuegosDao.buscarAreaColjuegosPorId(cdpVO.getAreaColjuegosVO().getAcoCodigo());
            cdp.setSiiAreaColjuegos(unAreaColjuegos);
        }
        if (cdpVO.getTipoDocSoporteVO() != null) {
            SiiTipoDocSoporte unTipoDocSoporte =
                tipoDocSoporteDao.buscarTipoDocumentoSoportePorId(cdpVO.getTipoDocSoporteVO().getTdsCodigo());
            cdp.setSiiTipoDocSoporte(unTipoDocSoporte);
        }
        if (cdpVO.getItemPlanContratacVO() != null) {
            SiiItemPlanContratac unItemPlanContratac =
                itemPlanContratacionDao.buscarItemPlanContratacPorId(cdpVO.getItemPlanContratacVO().getIpcCodigo());
            cdp.setSiiItemPlanContratac(unItemPlanContratac);
        }
        return cdp;

    }


    public SiiEstadoCdp convertir(EstadoCdpVO estadoCdpVO) throws ExcepcionDAO {
        SiiEstadoCdp estadoCdp = new SiiEstadoCdp();
        if (estadoCdpVO.getEcdCodigo() != null && estadoCdpVO.getEcdCodigo() > 0) {
            estadoCdp = estadoCdpDao.buscarEstadoCdpPorId(estadoCdpVO.getEcdCodigo());
        }
        estadoCdp.setEcdCodigo(estadoCdpVO.getEcdCodigo());
        estadoCdp.setEcdDescripcion(estadoCdpVO.getEcdDescripcion());
        estadoCdp.setEcdNombre(estadoCdpVO.getEcdNombre());
        return estadoCdp;
    }

    public SiiDetalleRubroCdp convertir(DetalleRubroCdpVO detalleRubroCdpVo) throws ExcepcionDAO {
        SiiDetalleRubroCdp siidetalleRubroCdp = new SiiDetalleRubroCdp();

        if (detalleRubroCdpVo.getDrcCodigo() != null && detalleRubroCdpVo.getDrcCodigo() > 0) {
            siidetalleRubroCdp = detalleRubroCdpDao.buscarPorCodigoDetalleRubro(detalleRubroCdpVo.getDrcCodigo());
        }

        siidetalleRubroCdp.setDruValor(detalleRubroCdpVo.getDruValor());
        siidetalleRubroCdp.setDrcSaldoAnterior(detalleRubroCdpVo.getDrcSaldoAnterior());
        siidetalleRubroCdp.setDrcAplicaGmf(detalleRubroCdpVo.getDrcAplicaGmf());


        //Padres
        if (detalleRubroCdpVo.getCdpVO() != null) {
            SiiCdp siiCdp = cdpDao.buscarCdpPorId(detalleRubroCdpVo.getCdpVO().getCdpCodigo());
            siidetalleRubroCdp.setSiiCdp(siiCdp);
        }
        if (detalleRubroCdpVo.getDetalleRubroVO() != null) {
            SiiDetalleRubro unDetalleRubro =
                detalleRubroDao.buscarPorCodigoDetalleRubro(detalleRubroCdpVo.getDetalleRubroVO().getDruCodigo());
            siidetalleRubroCdp.setSiiDetalleRubro(unDetalleRubro);
        }
        if (detalleRubroCdpVo.getGravamenMovFinancVo() != null &&
            detalleRubroCdpVo.getGravamenMovFinancVo().getGmfCodigo() != null) {
            SiiGravamenMovFinanc siiGravamenMovFinanc =
                gravamenMovFinancDao.buscarGravamenMovFinancPorId(detalleRubroCdpVo.getGravamenMovFinancVo().getGmfCodigo());
            siidetalleRubroCdp.setSiiGravamenMovFinanc(siiGravamenMovFinanc);
        }

        return siidetalleRubroCdp;

    }

    public SiiApropiacionInicial convertir(ApropiacionInicialVO apropiacionInicialVo) throws ExcepcionDAO {
        SiiApropiacionInicial siiApropiacionInicial = new SiiApropiacionInicial();
        if (apropiacionInicialVo.getAinCodigo() != null && apropiacionInicialVo.getAinCodigo() > 0) {
            apropiacionInicialDao.buscarApropiacionInicialPorId(apropiacionInicialVo.getAinCodigo());
        }

        siiApropiacionInicial.setAinAutorizado(apropiacionInicialVo.getAinAutorizado());
        siiApropiacionInicial.setAinCerrado(apropiacionInicialVo.getAinCerrado());
        siiApropiacionInicial.setAinCodigo(apropiacionInicialVo.getAinCodigo());
        siiApropiacionInicial.setAinElaborado(apropiacionInicialVo.getAinElaborado());
        siiApropiacionInicial.setAinFechaAcuerdoJunta(apropiacionInicialVo.getAinFechaAcuerdoJunta());
        siiApropiacionInicial.setAinFechaAutorizacion(apropiacionInicialVo.getAinFechaAutorizacion());
        siiApropiacionInicial.setAinFechaCierre(apropiacionInicialVo.getAinFechaCierre());
        siiApropiacionInicial.setAinFechaDecreto(apropiacionInicialVo.getAinFechaDecreto());
        siiApropiacionInicial.setAinFechaElaboracion(apropiacionInicialVo.getAinFechaElaboracion());
        siiApropiacionInicial.setAinFechaOficioDesagregacion(apropiacionInicialVo.getAinFechaOficioDesagregacion());
        siiApropiacionInicial.setAinNumOficioDesagregacion(apropiacionInicialVo.getAinNumOficioDesagregacion());
        siiApropiacionInicial.setAinNumeroAcuerdoJunta(apropiacionInicialVo.getAinNumeroAcuerdoJunta());
        siiApropiacionInicial.setAinNumeroDecreto(apropiacionInicialVo.getAinNumeroDecreto());
        siiApropiacionInicial.setAinVigencia(apropiacionInicialVo.getAinVigencia());
        //Padres
        if (apropiacionInicialVo.getUsuarioVo1() != null) {
            SiiUsuario unSiiUsuario =
                usuarioDao.buscarUsuarioPorId(apropiacionInicialVo.getUsuarioVo1().getUsuCodigo());
            siiApropiacionInicial.setSiiUsuario1(unSiiUsuario);
        }
        if (apropiacionInicialVo.getUsuarioVo3() != null) {
            SiiUsuario unSiiUsuario =
                usuarioDao.buscarUsuarioPorId(apropiacionInicialVo.getUsuarioVo3().getUsuCodigo());
            siiApropiacionInicial.setSiiUsuario3(unSiiUsuario);
        }
        if (apropiacionInicialVo.getUsuarioVo4() != null) {
            SiiUsuario unSiiUsuario =
                usuarioDao.buscarUsuarioPorId(apropiacionInicialVo.getUsuarioVo4().getUsuCodigo());
            siiApropiacionInicial.setSiiUsuario4(unSiiUsuario);
        }
        if (apropiacionInicialVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(apropiacionInicialVo.getArchivoFisicoVo().getAfiCodigo());
            siiApropiacionInicial.setSiiArchivoFisico(siiArchivoFisico);
        }

        return siiApropiacionInicial;
    }

    public SiiRp convertir(RpVO rpVo) throws ExcepcionDAO {
        SiiRp siiRp = new SiiRp();
        if (rpVo.getRpCodigo() != null && rpVo.getRpCodigo() > 0) {
            siiRp = rpDao.buscarPorCodigoRp(rpVo.getRpCodigo());
        }

        siiRp.setRpCodigo(rpVo.getRpCodigo());
        siiRp.setRpFechaSolic(rpVo.getRpFechaSolic());
        siiRp.setRpConsecutivo(rpVo.getRpConsecutivo());
        siiRp.setRpFechaRp(rpVo.getRpFechaRp());
        //Padres
        if (rpVo.getEstadoRpVo() != null) {
            SiiEstadoRp unEstadoRp = estadoRpDao.buscarEstadoRpPorId(rpVo.getEstadoRpVo().getErpCodigo());
            siiRp.setSiiEstadoRp(unEstadoRp);
        }

        if (rpVo.getProveedorVo() != null) {
            SiiProveedor unProveedor = proveedorDao.buscarProveedorPorId(rpVo.getProveedorVo().getProCodigo());
            siiRp.setSiiProveedor(unProveedor);
        }

        if (rpVo.getMotivoAnulRpVo() != null) {
            SiiMotivoAnulRp unMotivoAnul =
                motivoAnulacionRpDao.buscarPorCodigoMotivoAnulacion(rpVo.getMotivoAnulRpVo().getManCodigo());
            siiRp.setSiiMotivoAnulRp(unMotivoAnul);
        }

        if (rpVo.getMotivoRechSolRpVO() != null) {
            SiiMotivoRechSolRp unMotivoRech =
                motivoRechSolRpDao.buscarPorCodigoMotivoRechSolRp(rpVo.getMotivoRechSolRpVO().getMrsCodigo());
            siiRp.setSiiMotivoRechSolRp(unMotivoRech);
        }
        if (rpVo.getCargaRpVo() != null) {
            SiiCargaRp cargaRp = cargaRpDao.buscarCargaRpPorId(rpVo.getCargaRpVo().getCrpCodigo());
            siiRp.setSiiCargaRp(cargaRp);
        }
        return siiRp;
    }

    public SiiEstadoRp convertir(EstadoRpVO estadoRpVo) throws ExcepcionDAO {
        SiiEstadoRp siiEstadoRp = new SiiEstadoRp();
        if (estadoRpVo.getErpCodigo() != null && estadoRpVo.getErpCodigo() > 0) {
            siiEstadoRp = estadoRpDao.buscarEstadoRpPorId(estadoRpVo.getErpCodigo());
        }

        siiEstadoRp.setErpActivo(estadoRpVo.getErpActivo());
        siiEstadoRp.setErpCodigo(estadoRpVo.getErpCodigo());
        siiEstadoRp.setErpDescripcion(estadoRpVo.getErpDescripcion());
        siiEstadoRp.setErpNombre(estadoRpVo.getErpNombre());

        return siiEstadoRp;
    }

    public SiiRpDetRubroCdp convertir(RpDetRubroCdpVO rpDetRubroCdpVo) throws ExcepcionDAO {
        SiiRpDetRubroCdp siiRpDetRubroCdp = new SiiRpDetRubroCdp();
        if (rpDetRubroCdpVo.getRdrCodigo() != null && rpDetRubroCdpVo.getRdrCodigo() > 0) {
            siiRpDetRubroCdp = rpDetRubroCdpDao.buscarCodigoRpDetRubroCdp(rpDetRubroCdpVo.getRdrCodigo());
        }
        siiRpDetRubroCdp.setRdrValor(rpDetRubroCdpVo.getRdrValor());
        siiRpDetRubroCdp.setRdrSaldoAnterior(rpDetRubroCdpVo.getRdrSaldoAnterior());

        //Padres
        if (rpDetRubroCdpVo.getRpVo() != null) {
            SiiRp siiRp = rpDao.buscarPorCodigoRp(rpDetRubroCdpVo.getRpVo().getRpCodigo());
            siiRpDetRubroCdp.setSiiRp(siiRp);
        }
        if (rpDetRubroCdpVo.getDetalleRubroCdpVo() != null) {
            SiiDetalleRubroCdp siiDetRubroCdp =
                detalleRubroCdpDao.buscarPorCodigoDetalleRubro(rpDetRubroCdpVo.getDetalleRubroCdpVo().getDrcCodigo());
            siiRpDetRubroCdp.setSiiDetalleRubroCdp(siiDetRubroCdp);
        }
        return siiRpDetRubroCdp;
    }

    public SiiTipoServicio convertir(TipoServicioVO tipoServicioVO) throws ExcepcionDAO {
        SiiTipoServicio tipoServicio = new SiiTipoServicio();
        if (tipoServicioVO.getTseCodigo() != null && tipoServicioVO.getTseCodigo() > 0) {
            tipoServicioDao.buscarTipoServicioPorId(tipoServicioVO.getTseCodigo());
        }
        tipoServicio.setTseActivo(tipoServicioVO.getTseActivo());
        tipoServicio.setTseCodigo(tipoServicioVO.getTseCodigo());
        tipoServicio.setTseNombre(tipoServicioVO.getTseNombre());

        return tipoServicio;
    }

    public SiiItemPlanContDetRub convertir(ItemPlanContDetRubVO itemPlanContDetRubVO) throws ExcepcionDAO {
        SiiItemPlanContDetRub itemPlanContDetRub = new SiiItemPlanContDetRub();
        if (itemPlanContDetRubVO.getIdrCodigo() != null && itemPlanContDetRubVO.getIdrCodigo() > 0) {
            itemPlanContDetRubDao.buscarItemPlanContDetRubPorId(itemPlanContDetRubVO.getIdrCodigo());
        }

        itemPlanContDetRub.setIdrCodigo(itemPlanContDetRubVO.getIdrCodigo());
        itemPlanContDetRub.setIdrValor(itemPlanContDetRubVO.getIdrValor());
        //Padres:
        if (itemPlanContDetRubVO.getDetalleRubroVO() != null) {
            SiiDetalleRubro siiDetalleRubro =
                detalleRubroDao.buscarPorCodigoDetalleRubro(itemPlanContDetRubVO.getDetalleRubroVO().getDruCodigo());
            itemPlanContDetRub.setSiiDetalleRubro(siiDetalleRubro);
        }
        if (itemPlanContDetRubVO.getItemPlanContratacVO() != null) {
            SiiItemPlanContratac siiItemPlanContratac =
                itemPlanContratacionDao.buscarItemPlanContratacPorId(itemPlanContDetRubVO.getItemPlanContratacVO().getIpcCodigo());
            itemPlanContDetRub.setSiiItemPlanContratac(siiItemPlanContratac);
        }
        return itemPlanContDetRub;
    }

    public SiiEstPrevDetRubro convertir(EstPrevDetRubroVO estPrevDetRubroVo) throws ExcepcionDAO {
        SiiEstPrevDetRubro siiEstPrevDetRubro = new SiiEstPrevDetRubro();
        if (estPrevDetRubroVo.getEpdCodigo() != null && estPrevDetRubroVo.getEpdCodigo() > 0) {
            estPrevDetRubroDao.buscarEstPrevDetRubroPorId(estPrevDetRubroVo.getEpdCodigo());
        }
        siiEstPrevDetRubro.setEpdCodigo(estPrevDetRubroVo.getEpdCodigo());
        siiEstPrevDetRubro.setEpdValor(estPrevDetRubroVo.getEpdValor());
        //Padres
        if (estPrevDetRubroVo.getDetalleRubroVo() != null) {
            SiiDetalleRubro siiDetalleRubro =
                detalleRubroDao.buscarPorCodigoDetalleRubro(estPrevDetRubroVo.getDetalleRubroVo().getDruCodigo());
            siiEstPrevDetRubro.setSiiDetalleRubro(siiDetalleRubro);
        }
        return siiEstPrevDetRubro;
    }

    public SiiRequisitoCrit convertir(RequisitoCritVO requisitoCriticVo) throws ExcepcionDAO {
        SiiRequisitoCrit siiRequisitoCrit = new SiiRequisitoCrit();
        if (requisitoCriticVo.getRcrCodigo() != null && requisitoCriticVo.getRcrCodigo() > 0) {
            siiRequisitoCrit = requisitoCritDao.buscarRequisitoCritPorId(requisitoCriticVo.getRcrCodigo());
        }
        siiRequisitoCrit.setRcrNombre(requisitoCriticVo.getRcrNombre());
        siiRequisitoCrit.setRcrActivo(requisitoCriticVo.getRcrActivo());
        siiRequisitoCrit.setRcrTipo(requisitoCriticVo.getRcrTipo());
        return siiRequisitoCrit;
    }

    /**
     * @author Modifica Giovanni
     * @param reqEstudioPrevioVo
     * @return
     * @throws ExcepcionDAO
     */
    public SiiReqEstudioPrevio convertir(ReqEstudioPrevioVO reqEstudioPrevioVo) throws ExcepcionDAO {
        SiiReqEstudioPrevio siiReqEstudioPrevio = new SiiReqEstudioPrevio();
        if (reqEstudioPrevioVo.getResCodigo() != null && reqEstudioPrevioVo.getResCodigo() > 0) {
            reqEstudioPrevioDao.buscarReqEstudioPrevioPorId(reqEstudioPrevioVo.getResCodigo());
        }
        siiReqEstudioPrevio.setResCodigo(reqEstudioPrevioVo.getResCodigo());
        siiReqEstudioPrevio.setResPuntaje(reqEstudioPrevioVo.getResPuntaje());

        //Estudio Previo
        if (reqEstudioPrevioVo.getEstudioPrevioVo() != null &&
            reqEstudioPrevioVo.getEstudioPrevioVo().getEpeCodigo() != null &&
            reqEstudioPrevioVo.getEstudioPrevioVo().getEpeCodigo() > 0) {
            SiiEstudioPrevio siiEstudioPrevio =
                estudioPrevioDao.buscarEstudioPrevioPorId(reqEstudioPrevioVo.getEstudioPrevioVo().getEpeCodigo());
            siiReqEstudioPrevio.setSiiEstudioPrevio1(siiEstudioPrevio);
        }

        //Requisito Crit
        if (reqEstudioPrevioVo.getRequisitoCritVo() != null &&
            reqEstudioPrevioVo.getRequisitoCritVo().getRcrCodigo() != null &&
            reqEstudioPrevioVo.getRequisitoCritVo().getRcrCodigo() > 0) {
            SiiRequisitoCrit siiRequisitoCrit =
                requisitoCritDao.buscarRequisitoCritPorId(reqEstudioPrevioVo.getRequisitoCritVo().getRcrCodigo());
            siiReqEstudioPrevio.setSiiRequisitoCrit(siiRequisitoCrit);
        }

        return siiReqEstudioPrevio;
    }

    public SiiTipoAmparo convertir(TipoAmparoVO tipoAmparoVo) throws ExcepcionDAO {
        SiiTipoAmparo siiTipoAmparo = new SiiTipoAmparo();
        if (tipoAmparoVo.getTamCodigo() != null && tipoAmparoVo.getTamCodigo() > 0) {
            tipoAmparoDao.buscarTipoAmparoPorId(tipoAmparoVo.getTamCodigo());
        }
        siiTipoAmparo.setTamActivo(tipoAmparoVo.getTamActivo());
        siiTipoAmparo.setTamCodigo(tipoAmparoVo.getTamCodigo());
        siiTipoAmparo.setTamDescripcion(tipoAmparoVo.getTamDescripcion());
        siiTipoAmparo.setTamNombre(tipoAmparoVo.getTamNombre());
        return siiTipoAmparo;
    }

    /**
     * @author Modifica Giovanni
     * @param amparoEstPrevVO
     * @return
     * @throws ExcepcionDAO
     */
    public SiiAmparoEstPrev convertir(AmparoEstPrevVO amparoEstPrevVO) throws ExcepcionDAO {
        SiiAmparoEstPrev siiAmparoEstPrev = new SiiAmparoEstPrev();
        if (amparoEstPrevVO.getAepCodigo() != null && amparoEstPrevVO.getAepCodigo() > 0) {
            amparoEstPrevDao.buscarAmparoEstPrevPorId(amparoEstPrevVO.getAepCodigo());
        }
        siiAmparoEstPrev.setAepCodigo(amparoEstPrevVO.getAepCodigo());
        siiAmparoEstPrev.setAepJustificacion(amparoEstPrevVO.getAepJustificacion());
        siiAmparoEstPrev.setAepPorcentaje(amparoEstPrevVO.getAepPorcentaje());
        siiAmparoEstPrev.setAepVigencia(amparoEstPrevVO.getAepVigencia());

        //Tipo Garantia
        if (amparoEstPrevVO.getTipoGarantiaVO() != null && amparoEstPrevVO.getTipoGarantiaVO().getTgaCodigo() != null &&
            amparoEstPrevVO.getTipoGarantiaVO().getTgaCodigo() > 0) {
            SiiTipoGarantia siiTipoGarantia =
                tipoGarantiaDao.buscarTipoGarantiaPorId(amparoEstPrevVO.getTipoGarantiaVO().getTgaCodigo());
            siiAmparoEstPrev.setSiiTipoGarantia(siiTipoGarantia);
        }

        //Estudio Previo
        if (amparoEstPrevVO.getEstudioPrevioVo() != null &&
            amparoEstPrevVO.getEstudioPrevioVo().getEpeCodigo() != null &&
            amparoEstPrevVO.getEstudioPrevioVo().getEpeCodigo() > 0) {
            SiiEstudioPrevio siiEstudioPrevio =
                estudioPrevioDao.buscarEstudioPrevioPorId(amparoEstPrevVO.getEstudioPrevioVo().getEpeCodigo());
            siiAmparoEstPrev.setSiiEstudioPrevio(siiEstudioPrevio);
        }

        //Tipo Amparo
        if (amparoEstPrevVO.getTipoAmparoVo() != null && amparoEstPrevVO.getTipoAmparoVo().getTamCodigo() != null &&
            amparoEstPrevVO.getTipoAmparoVo().getTamCodigo() > 0) {
            SiiTipoAmparo siiTipoAmparo =
                tipoAmparoDao.buscarTipoAmparoPorId(amparoEstPrevVO.getTipoAmparoVo().getTamCodigo());
            siiAmparoEstPrev.setSiiTipoAmparo(siiTipoAmparo);
        }
        return siiAmparoEstPrev;
    }


    public SiiTerminosReferencia convertir(TerminoReferenciaVO terminoReferenciaVO) throws ExcepcionDAO {
        SiiTerminosReferencia terminoReferencia = new SiiTerminosReferencia();
        if (terminoReferenciaVO.getTdrCodigo() != null && terminoReferenciaVO.getTdrCodigo() > 0) {
            terminoReferencia =
                terminoReferenciaDao.buscarPorCodigoTerminoReferencia(terminoReferenciaVO.getTdrCodigo());
        }

        terminoReferencia.setTdrFechaApAud(terminoReferenciaVO.getTdrFechaApAud());

        terminoReferencia.setTdrFechaApDef(terminoReferenciaVO.getTdrFechaApDef());
        terminoReferencia.setTdrFechaApObs(terminoReferenciaVO.getTdrFechaApObs());
        terminoReferencia.setTdrFechaApObsDef(terminoReferenciaVO.getTdrFechaApObsDef());
        terminoReferencia.setTdrFechaApProy(terminoReferenciaVO.getTdrFechaApProy());
        terminoReferencia.setTdrFechaEnAud(terminoReferenciaVO.getTdrFechaEnAud());
        terminoReferencia.setTdrFechaEnDef(terminoReferenciaVO.getTdrFechaEnDef());
        terminoReferencia.setTdrFechaEnObs(terminoReferenciaVO.getTdrFechaEnObs());
        terminoReferencia.setTdrFechaEnObsDef(terminoReferenciaVO.getTdrFechaEnObsDef());
        terminoReferencia.setTdrFechaEnProy(terminoReferenciaVO.getTdrFechaEnProy());
        terminoReferencia.setTdrFechaPbAud(terminoReferenciaVO.getTdrFechaPbAud());
        terminoReferencia.setTdrFechaPbDef(terminoReferenciaVO.getTdrFechaPbDef());
        terminoReferencia.setTdrFechaPbObs(terminoReferenciaVO.getTdrFechaPbObs());
        terminoReferencia.setTdrFechaPbObsDef(terminoReferenciaVO.getTdrFechaPbObsDef());
        terminoReferencia.setTdrFechaPbProy(terminoReferenciaVO.getTdrFechaPbProy());


        if (terminoReferenciaVO.getProcesoContratacionVO() != null) {
            SiiProcesoContratacion siiProcesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(terminoReferenciaVO.getProcesoContratacionVO().getPrcCodigo());
            terminoReferencia.setSiiProcesoContratacion(siiProcesoContratacion);
        }

        return terminoReferencia;
    }

    public SiiRol convertir(RolVO rolVo) throws ExcepcionDAO {
        SiiRol siiRol = new SiiRol();
        if (rolVo.getRolCodigo() != null && rolVo.getRolCodigo() > 0) {
            siiRol = rolDao.buscarRolPorId(rolVo.getRolCodigo());
        }
        siiRol.setRolActivo(rolVo.getRolActivo());
        siiRol.setRolCodigo(rolVo.getRolCodigo());
        siiRol.setRolDescripcion(rolVo.getRolDescripcion());
        siiRol.setRolNombre(rolVo.getRolNombre());
        return siiRol;
    }

    /* Por Diego Alvarado */
    public SiiPermisoRolModulo convertir(PermisoRolModuloVO permisoRolModuloVo) throws ExcepcionDAO {
        SiiPermisoRolModulo siiPermisoRolModulo = new SiiPermisoRolModulo();
        if (permisoRolModuloVo.getPrmCodigo() != null && permisoRolModuloVo.getPrmCodigo() > 0) {
            siiPermisoRolModulo = permisoRolModuloDao.buscarPermisoRolModuloPorId(permisoRolModuloVo.getPrmCodigo());
        }
        //Padres:
        if (permisoRolModuloVo.getPermisoVo() != null) {
            SiiPermiso unPermiso = permisoDao.buscarPermisoPorId(permisoRolModuloVo.getPermisoVo().getPmsCodigo());
            siiPermisoRolModulo.setSiiPermiso(unPermiso);
        }
        if (permisoRolModuloVo.getRolVo() != null) {
            SiiRol unRol = rolDao.buscarRolPorId(permisoRolModuloVo.getRolVo().getRolCodigo());
            siiPermisoRolModulo.setSiiRol(unRol);
        }
        if (permisoRolModuloVo.getModuloVo() != null) {
            SiiModulo unModulo = moduloDao.buscarModuloPorId(permisoRolModuloVo.getModuloVo().getModCodigo());
            siiPermisoRolModulo.setSiiModulo1(unModulo);
        }
        return siiPermisoRolModulo;
    }


    public SiiSolicitudPfcMens convertir(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO {
        SiiSolicitudPfcMens solicitudPfcm = new SiiSolicitudPfcMens();
        if (solicitudPfcMensualVo.getSpfCodigo() != null && solicitudPfcMensualVo.getSpfCodigo() > 0) {
            solicitudPfcm = solicitudPfcMensualDao.buscarPorCodigoSpfcm(solicitudPfcMensualVo.getSpfCodigo());
        }
        solicitudPfcm.setSpfFecha(solicitudPfcMensualVo.getSpfFecha());
        solicitudPfcm.setSpfVigencia(solicitudPfcMensualVo.getSpfVigencia());
        //Padres
        if (solicitudPfcMensualVo.getEstadoSolicPfcmVo() != null) {
            SiiEstadoSolicPfcm unSiiEstadoSolicPfcm = new SiiEstadoSolicPfcm();
            unSiiEstadoSolicPfcm.setEspCodigo(solicitudPfcMensualVo.getEstadoSolicPfcmVo().getEspCodigo());
            solicitudPfcm.setSiiEstadoSolicPfcm(unSiiEstadoSolicPfcm);
        }
        if (solicitudPfcMensualVo.getMesVo() != null) {
            SiiMes unSiiMes = mesDao.buscarMesPorId(solicitudPfcMensualVo.getMesVo().getMesCodigo());
            solicitudPfcm.setSiiMes1(unSiiMes);
        }

        return solicitudPfcm;
    }


    public SiiSolicPfcmDetalle convertir(SolicPfcmDetalleVO solicPfcmDetalleVo) throws ExcepcionDAO {
        SiiSolicPfcmDetalle siiSolicPfcmDetalle = new SiiSolicPfcmDetalle();
        if (solicPfcmDetalleVo.getSpdCodigo() != null && solicPfcmDetalleVo.getSpdCodigo() > 0) {
            siiSolicPfcmDetalle = solicPfcmDetalleDao.buscarSolicitudPfcmPorId(solicPfcmDetalleVo.getSpdCodigo());
        }

        siiSolicPfcmDetalle.setSpdValorAntic(solicPfcmDetalleVo.getSpdValorAntic());
        siiSolicPfcmDetalle.setSpdValorAplaz(solicPfcmDetalleVo.getSpdValorAplaz());
        siiSolicPfcmDetalle.setSpdValorProgram(solicPfcmDetalleVo.getSpdValorProgram());

        //Padres}
        if (solicPfcmDetalleVo.getSolicitudPfcMensualVo() != null) {
            SiiSolicitudPfcMens siiSolicitudPfcMens =
                solicitudPfcMensualao.buscarPorCodigoSpfcm(solicPfcmDetalleVo.getSolicitudPfcMensualVo().getSpfCodigo());
            siiSolicPfcmDetalle.setSiiSolicitudPfcMens(siiSolicitudPfcMens);
        }

        return siiSolicPfcmDetalle;
    }

    public SiiEstadoSolicPfcm convertir(EstadoSolicPfcmVO estadoSolicPfcmVo) throws ExcepcionDAO {
        SiiEstadoSolicPfcm estadoSolicPfcm = new SiiEstadoSolicPfcm();
        if (estadoSolicPfcmVo.getEspCodigo() != null && estadoSolicPfcmVo.getEspCodigo() > 0) {
            estadoSolicPfcm = estadoSolicPfcmDao.buscarEstadoSolicPfcmPorId(estadoSolicPfcmVo.getEspCodigo());
        }
        estadoSolicPfcm.setEspNombre(estadoSolicPfcmVo.getEspNombre());
        return estadoSolicPfcm;
    }

    public SiiPermiso convertir(PermisoVO permisoVo) throws ExcepcionDAO {
        SiiPermiso siiPermiso = new SiiPermiso();
        if (permisoVo.getPmsCodigo() != null && permisoVo.getPmsCodigo() > 0) {
            siiPermiso = permisoDao.buscarPermisoPorId(permisoVo.getPmsCodigo());
        }
        siiPermiso.setPmsNombre(permisoVo.getPmsNombre());
        return siiPermiso;
    }

    public SiiModulo convertir(ModuloVO moduloVo) throws ExcepcionDAO {
        SiiModulo siiModulo = new SiiModulo();
        if (moduloVo.getModCodigo() != null && moduloVo.getModCodigo() > 0) {
            siiModulo = moduloDao.buscarModuloPorId(moduloVo.getModCodigo());
        }
        siiModulo.setModActivo(moduloVo.getModActivo());
        siiModulo.setModCodigoPadre(moduloVo.getModCodigoPadre());
        siiModulo.setModNombre(moduloVo.getModNombre());
        siiModulo.setModOrden(moduloVo.getModOrden());
        siiModulo.setModPath(moduloVo.getModPath());
        siiModulo.setModTitulo(moduloVo.getModTitulo());
        siiModulo.setModMbClass(moduloVo.getModMbClass());
        siiModulo.setModParametros(moduloVo.getModParametros());
        return siiModulo;
    }

    public SiiAdendaTdr convertir(AdendaVO adendaVO) throws ExcepcionDAO {
        SiiAdendaTdr adenda = new SiiAdendaTdr();
        if (adendaVO.getAtdCodigo() != null && adendaVO.getAtdCodigo() > 0) {
            adenda = adendaDao.buscarPorCodigoAdenda(adendaVO.getAtdCodigo());
        }
        adenda.setAtdCodigo(adendaVO.getAtdCodigo());
        adenda.setAtdFechaAprob(adendaVO.getAtdFechaAprob());
        adenda.setAtdFechaEnvPub(adendaVO.getAtdFechaEnvPub());
        adenda.setAtdFechaPub(adendaVO.getAtdFechaPub());


        //Padres
        if (adendaVO.getTerminosReferencia() != null) {
            SiiTerminosReferencia siiTerminosReferencia =
                terminoReferenciaDao.buscarPorCodigoTerminoReferencia(adendaVO.getTerminosReferencia().getTdrCodigo());
            adenda.setSiiTerminosReferencia(siiTerminosReferencia);
        }
        return adenda;
    }

    public SiiEstadoAlcanceInv convertir(EstadoAlcanceInvVO estadoAlcanceInvVo) throws ExcepcionDAO {
        SiiEstadoAlcanceInv estadoAlcanceInv = new SiiEstadoAlcanceInv();
        if (estadoAlcanceInvVo.getEaiCodigo() != null && estadoAlcanceInvVo.getEaiCodigo() > 0) {
            estadoAlcanceInv = estadoAlcanceInvDao.buscarEstadoAlcanceInvPorId(estadoAlcanceInvVo.getEaiCodigo());

        }
        estadoAlcanceInv.setEaiCodigo(estadoAlcanceInvVo.getEaiCodigo());
        estadoAlcanceInv.setEaiNombre(estadoAlcanceInvVo.getEaiNombre());
        return estadoAlcanceInv;
    }

    public SiiAlcanceInvitacion convertir(AlcanceInvitacionVO alcanceInvitacionVo) throws ExcepcionDAO {
        SiiAlcanceInvitacion alcanceInvitacion = new SiiAlcanceInvitacion();
        if (alcanceInvitacionVo.getAliCodigo() != null && alcanceInvitacionVo.getAliCodigo() > 0) {
            alcanceInvitacion = alcanceInvitacionDao.buscarAlcanceInvitacionPorId(alcanceInvitacionVo.getAliCodigo());
        }
        alcanceInvitacion.setAliCodigo(alcanceInvitacionVo.getAliCodigo());
        alcanceInvitacion.setAliFechaVencim(alcanceInvitacionVo.getAliFechaVencim());
        alcanceInvitacion.setAliFormaPago(alcanceInvitacionVo.getAliFormaPago());
        alcanceInvitacion.setAliObligacContrat(alcanceInvitacionVo.getAliObligacContrat());
        alcanceInvitacion.setAliOtroTipAlcan(alcanceInvitacionVo.getAliOtroTipAlcan());
        alcanceInvitacion.setAliTiempoDurac(alcanceInvitacionVo.getAliTiempoDurac());
        alcanceInvitacion.setAliUnidadDurac(alcanceInvitacionVo.getAliUnidadDurac());
        alcanceInvitacion.setAliValor(alcanceInvitacionVo.getAliValor());
        alcanceInvitacion.setAliFecha(alcanceInvitacionVo.getAliFecha());
        //Padres:
        if (alcanceInvitacionVo.getEstadoAlcanceInvVo() != null) {
            SiiEstadoAlcanceInv estadoAlcanceInv =
                estadoAlcanceInvDao.buscarEstadoAlcanceInvPorId(alcanceInvitacionVo.getEstadoAlcanceInvVo().getEaiCodigo());
            alcanceInvitacion.setSiiEstadoAlcanceInv(estadoAlcanceInv);
        }
        if (alcanceInvitacionVo.getProcesoContratacionVo() != null) {
            SiiProcesoContratacion procesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(alcanceInvitacionVo.getProcesoContratacionVo().getPrcCodigo());
            alcanceInvitacion.setSiiProcesoContratacion(procesoContratacion);
        }
        return alcanceInvitacion;
    }

    public SiiMotivoDevolucion convertir(MotivoDevolucionVO motivoDevolucionVo) throws ExcepcionDAO {
        SiiMotivoDevolucion motivoDevolucion = new SiiMotivoDevolucion();
        if (motivoDevolucionVo.getMdeCodigo() != null && motivoDevolucionVo.getMdeCodigo() > 0) {
            motivoDevolucion = motivoDevolucionDao.buscarPorCodigo(motivoDevolucionVo.getMdeCodigo());
        }
        motivoDevolucion.setMdeNombre(motivoDevolucionVo.getMdeNombre());
        return motivoDevolucion;
    }

    public SiiMotivoAnulRp convertir(MotivoAnulRpVO motivoAnulRpVo) throws ExcepcionDAO {
        SiiMotivoAnulRp motivoAnulacion =
            motivoAnulacionRpDao.buscarPorCodigoMotivoAnulacion(motivoAnulRpVo.getManCodigo());
        motivoAnulacion.setManNombre(motivoAnulRpVo.getManNombre());
        return motivoAnulacion;
    }

    public SiiMotivoRechSolRp convertir(MotivoRechSolRpVO motivoRechSolRpVo) throws ExcepcionDAO {
        SiiMotivoRechSolRp motivoRechazo =
            motivoRechSolRpDao.buscarPorCodigoMotivoRechSolRp(motivoRechSolRpVo.getMrsCodigo());
        motivoRechazo.setMrsNombre(motivoRechSolRpVo.getMrsNombre());
        return motivoRechazo;
    }

    public SiiReqAlcanceInv convertir(ReqAlcanceInvVO reqAlcanceInvVo) throws ExcepcionDAO {
        SiiReqAlcanceInv reqAlcanceInv = new SiiReqAlcanceInv();
        if (reqAlcanceInvVo.getRaiCodigo() != null && reqAlcanceInvVo.getRaiCodigo() > 0) {

            reqAlcanceInv = reqAlcanceInvDao.buscarReqAlcanceInvPorId(reqAlcanceInvVo.getRaiCodigo());
        }
        reqAlcanceInv.setRaiCodigo(reqAlcanceInvVo.getRaiCodigo());
        reqAlcanceInv.setRcrPuntaje(reqAlcanceInvVo.getRcrPuntaje());
        //Padres:
        if (reqAlcanceInvVo.getAlcanceInvitacionVo() != null) {
            SiiAlcanceInvitacion alcanceInvitacion =
                alcanceInvitacionDao.buscarAlcanceInvitacionPorId(reqAlcanceInvVo.getAlcanceInvitacionVo().getAliCodigo());
            reqAlcanceInv.setSiiAlcanceInvitacion(alcanceInvitacion);
        }

        if (reqAlcanceInvVo.getRequisitoCritVo() != null) {
            SiiRequisitoCrit requisitoCrit =
                requisitoCritDao.buscarRequisitoCritPorId(reqAlcanceInvVo.getRequisitoCritVo().getRcrCodigo());
            reqAlcanceInv.setSiiRequisitoCrit(requisitoCrit);
        }
        return reqAlcanceInv;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param propuestaRecibVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiPropuestaRecib convertir(PropuestaRecibVO propuestaRecibVO) throws ExcepcionDAO {
        SiiPropuestaRecib propuestaRecib = new SiiPropuestaRecib();
        // realizar la busqueda por codigo
        if (propuestaRecibVO.getPreCodigo() != null && propuestaRecibVO.getPreCodigo() > 0) {
            propuestaRecib = propuestaRecibDao.buscarPorCodigoPropuestaRecib(propuestaRecibVO.getPreCodigo());
        }

        if (propuestaRecibVO.getProveedor() != null) {
            SiiProveedor siiProveedor =
                proveedorDao.buscarProveedorPorId(propuestaRecibVO.getProveedor().getProCodigo());
            propuestaRecib.setSiiProveedor(siiProveedor);
        }
        if (propuestaRecibVO.getRecepcionPropuestas() != null && propuestaRecib.getSiiRecepcionPropuestas() == null) {
            propuestaRecib.setSiiRecepcionPropuestas(convertir(propuestaRecibVO.getRecepcionPropuestas()));
        }

        return propuestaRecib;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param recepcionPropuestasVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiRecepcionPropuestas convertir(RecepcionPropuestasVO recepcionPropuestasVO) throws ExcepcionDAO {
        SiiRecepcionPropuestas recepcionPropuestas = new SiiRecepcionPropuestas();
        // realizar la busqueda por codigo
        if (recepcionPropuestasVO.getRprCodigo() != null && recepcionPropuestasVO.getRprCodigo() > 0) {
            recepcionPropuestas =
                recepcionPropuestasDao.buscarPorCodigoRecepcionPropuestas(recepcionPropuestasVO.getRprCodigo());
        }
        recepcionPropuestas.setRprCodigo(recepcionPropuestasVO.getRprCodigo());
        recepcionPropuestas.setRprEstadoActa(recepcionPropuestasVO.getRprEstadoActa());
        recepcionPropuestas.setRprFechaActa(recepcionPropuestasVO.getRprFechaActa());
        recepcionPropuestas.setRprNumActa(recepcionPropuestasVO.getRprNumActa());

        if (recepcionPropuestasVO.getArchivoFisico() != null && recepcionPropuestasVO.getArchivoFisico().getAfiCodigo()!=null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(recepcionPropuestasVO.getArchivoFisico().getAfiCodigo());
            recepcionPropuestas.setSiiArchivoFisico(siiArchivoFisico);
        }

        if (recepcionPropuestasVO.getProcesoContratacion() != null && recepcionPropuestasVO.getProcesoContratacion().getPrcCodigo()!=null) {
            SiiProcesoContratacion siiProcesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(recepcionPropuestasVO.getProcesoContratacion().getPrcCodigo());
            recepcionPropuestas.setSiiProcesoContratacion(siiProcesoContratacion);
        }

        return recepcionPropuestas;
    }

    public SiiModificacionCdp convertir(ModificacionCdpVO modificacionCdpVo) throws ExcepcionDAO {
        SiiModificacionCdp modificacionCdp = new SiiModificacionCdp();
        if (modificacionCdpVo.getMcdCodigo() != null && modificacionCdpVo.getMcdCodigo() > 0) {
            modificacionCdp = modificacionCdpDao.buscarModificacionCdpPorId(modificacionCdpVo.getMcdCodigo());
        }
        modificacionCdp.setMcdCodigo(modificacionCdpVo.getMcdCodigo());
        modificacionCdp.setMcdFechaSolic(modificacionCdpVo.getMcdFechaSolic());
        modificacionCdp.setMcdTipoMod(modificacionCdpVo.getMcdTipoMod());
        modificacionCdp.setMcdNumero(modificacionCdpVo.getMcdNumero());
        //Padres:
        if (modificacionCdpVo.getCdpVo() != null) {
            SiiCdp siiCdp = cdpDao.buscarCdpPorId(modificacionCdpVo.getCdpVo().getCdpCodigo());
            modificacionCdp.setSiiCdp(siiCdp);
        }

        if (modificacionCdpVo.getEstadoModifCdpVo() != null) {
            SiiEstadoModifCdp siiEstadoModifCdp =
                estadoModifCdpDao.buscarEstadoModifCdpPorId(modificacionCdpVo.getEstadoModifCdpVo().getEmcCodigo());
            modificacionCdp.setSiiEstadoModifCdp(siiEstadoModifCdp);
        }

        if (modificacionCdpVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(modificacionCdpVo.getArchivoFisicoVo().getAfiCodigo());
            modificacionCdp.setSiiArchivoFisico(siiArchivoFisico);
        }

        return modificacionCdp;
    }

    public SiiEstadoModifCdp convertir(EstadoModifCdpVO estadoModifCdpVO) throws ExcepcionDAO {
        SiiEstadoModifCdp estadoModifCdp = new SiiEstadoModifCdp();
        if (estadoModifCdpVO.getEmcCodigo() != null && estadoModifCdpVO.getEmcCodigo() > 0) {
            estadoModifCdp = estadoModifCdpDao.buscarEstadoModifCdpPorId(estadoModifCdpVO.getEmcCodigo());
        }
        estadoModifCdp.setEmcCodigo(estadoModifCdpVO.getEmcCodigo());
        estadoModifCdp.setEmcActivo(estadoModifCdpVO.getEmcActivo());
        estadoModifCdp.setEmcDescripcion(estadoModifCdpVO.getEmcDescripcion());
        estadoModifCdp.setEmcNombre(estadoModifCdpVO.getEmcNombre());

        return estadoModifCdp;
    }

    public SiiModifCdpDetRubCdp convertir(ModifCdpDetRubCdpVO modifVo) throws ExcepcionDAO {
        SiiModifCdpDetRubCdp modif = new SiiModifCdpDetRubCdp();
        if (modifVo.getMcrCodigo() != null && modifVo.getMcrCodigo() > 0) {
            modif = modifCdpDetRubCdpDao.buscarModifCdpDetRubCdpPorId(modifVo.getMcrCodigo());
        }
        modif.setMcrCodigo(modifVo.getMcrCodigo());
        modif.setMcrValor(modifVo.getMcrValor());
        //Padres:
        if (modifVo.getDetalleRubroCdpVo() != null) {
            SiiDetalleRubroCdp unSiiDetalleRubroCdp =
                detalleRubroCdpDao.buscarPorCodigoDetalleRubro(modifVo.getDetalleRubroCdpVo().getDrcCodigo());
            modif.setSiiDetalleRubroCdp(unSiiDetalleRubroCdp);
        }

        if (modifVo.getModificacionCdpVo() != null) {
            SiiModificacionCdp unaSiiModificacionCdp =
                modificacionCdpDao.buscarModificacionCdpPorId(modifVo.getModificacionCdpVo().getMcdCodigo());
            modif.setSiiModificacionCdp(unaSiiModificacionCdp);
        }

        return modif;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param propuestaEvaluacionVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiPropuestaEvaluacion convertir(PropuestaEvaluacionVO propuestaEvaluacionVO) throws ExcepcionDAO {
        SiiPropuestaEvaluacion propuestaEvaluacion = new SiiPropuestaEvaluacion();
        // realizar la busqueda por codigo
        if (propuestaEvaluacionVO.getPevCodigo() != null && propuestaEvaluacionVO.getPevCodigo() > 0) {
            propuestaEvaluacion =
                propuestaEvaluacionDAO.buscarPorCodigoPropuestaEvaluacion(propuestaEvaluacionVO.getPevCodigo());
        }
        propuestaEvaluacion.setPevCodigo(propuestaEvaluacionVO.getPevCodigo());
        propuestaEvaluacion.setPevCalificacion(propuestaEvaluacionVO.getPevCalificacion());
        propuestaEvaluacion.setPevCumpleEvFin(propuestaEvaluacionVO.getPevCumpleEvFin());
        propuestaEvaluacion.setPevCumpleEvJur(propuestaEvaluacionVO.getPevCumpleEvJur());
        propuestaEvaluacion.setPevCumpleEvTec(propuestaEvaluacionVO.getPevCumpleEvTec());
        propuestaEvaluacion.setPevIva(propuestaEvaluacionVO.getPevIva());
        propuestaEvaluacion.setPevValor(propuestaEvaluacionVO.getPevValor());

        if (propuestaEvaluacionVO.getEvaluacionJurTecFin() != null) {
            propuestaEvaluacion.setSiiEvaluacionJurTecFin(evaluacionJurTecFinDAO.buscarPorCodigo(propuestaEvaluacionVO.getEvaluacionJurTecFin().getEjtCodigo()));
        }

        if (propuestaEvaluacionVO.getPropuestaRecib() != null) {
            propuestaEvaluacion.setSiiPropuestaRecib(propuestaRecibDao.buscarPorCodigoPropuestaRecib(propuestaEvaluacionVO.getPropuestaRecib().getPreCodigo()));
        }


        return propuestaEvaluacion;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param estadoEvaluacionJtfVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiEstadoEvaluacionJtf convertir(EstadoEvaluacionJtfVO estadoEvaluacionJtfVO) throws ExcepcionDAO {
        SiiEstadoEvaluacionJtf estadoEvaluacionJtf = new SiiEstadoEvaluacionJtf();
        // realizar la busqueda por codigo
        if (estadoEvaluacionJtfVO.getEejCodigo() != null && estadoEvaluacionJtfVO.getEejCodigo() > 0) {
            estadoEvaluacionJtf = estadoEvaluacionJtfDAO.buscarPorCodigo(estadoEvaluacionJtfVO.getEejCodigo());
        }
        estadoEvaluacionJtf.setEejCodigo(estadoEvaluacionJtfVO.getEejCodigo());
        estadoEvaluacionJtf.setEejNombre(estadoEvaluacionJtfVO.getEejNombre());

        return estadoEvaluacionJtf;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param evaluacionJurTecFinVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiEvaluacionJurTecFin convertir(EvaluacionJurTecFinVO evaluacionJurTecFinVO) throws ExcepcionDAO {
        SiiEvaluacionJurTecFin evaluacionJurTecFin = new SiiEvaluacionJurTecFin();
        // realizar la busqueda por codigo
        if (evaluacionJurTecFinVO.getEjtCodigo() != null && evaluacionJurTecFinVO.getEjtCodigo() > 0) {
            evaluacionJurTecFin = evaluacionJurTecFinDAO.buscarPorCodigo(evaluacionJurTecFinVO.getEjtCodigo());
        }
        evaluacionJurTecFin.setEjtCodigo(evaluacionJurTecFinVO.getEjtCodigo());
        evaluacionJurTecFin.setEjtFechaAprobFin(evaluacionJurTecFinVO.getEjtFechaAprobFin());
        evaluacionJurTecFin.setEjtFechaAprobJur(evaluacionJurTecFinVO.getEjtFechaAprobJur());
        evaluacionJurTecFin.setEjtFechaAprobTec(evaluacionJurTecFinVO.getEjtFechaAprobTec());
        evaluacionJurTecFin.setEjtObservaciones(evaluacionJurTecFinVO.getEjtObservaciones());


        if (evaluacionJurTecFinVO.getArchivoFisicoJur() != null)
            evaluacionJurTecFin.setSiiArchivoFisicoJur(archivoFisicoDao.buscarArchivoFisicoPorId(evaluacionJurTecFinVO.getArchivoFisicoJur().getAfiCodigo()));

        if (evaluacionJurTecFinVO.getArchivoFisicoTec() != null)
            evaluacionJurTecFin.setSiiArchivoFisicoTec(archivoFisicoDao.buscarArchivoFisicoPorId(evaluacionJurTecFinVO.getArchivoFisicoTec().getAfiCodigo()));

        if (evaluacionJurTecFinVO.getArchivoFisicoFin() != null)
            evaluacionJurTecFin.setSiiArchivoFisicoFin(archivoFisicoDao.buscarArchivoFisicoPorId(evaluacionJurTecFinVO.getArchivoFisicoFin().getAfiCodigo()));

        if (evaluacionJurTecFinVO.getEstadoEvaluacionJtf() != null) {
            evaluacionJurTecFin.setSiiEstadoEvaluacionJtf(estadoEvaluacionJtfDao.buscarPorCodigo(evaluacionJurTecFinVO.getEstadoEvaluacionJtf().getEejCodigo()));
        }

        if (evaluacionJurTecFinVO.getProcesoContratacion() != null) {
            evaluacionJurTecFin.setSiiProcesoContratacion(procesoContratacionDao.buscarProcesoContratacionPorId(evaluacionJurTecFinVO.getProcesoContratacion().getPrcCodigo()));
        }

        return evaluacionJurTecFin;
    }


    public SiiExpedienteFisico convertir(ExpedienteFisicoVO expedienteFisicoVO) throws ExcepcionDAO {
        SiiExpedienteFisico siiExpedienteFisico = new SiiExpedienteFisico();
        if (expedienteFisicoVO.getEfiCodigo() != null && expedienteFisicoVO.getEfiCodigo() > 0) {
            siiExpedienteFisico = expedienteFisicoDao.buscarExpedienteFisicoPorId(expedienteFisicoVO.getEfiCodigo());
        }
        siiExpedienteFisico.setEfiActivo(expedienteFisicoVO.getEfiActivo());
        siiExpedienteFisico.setEfiFecha(expedienteFisicoVO.getEfiFecha());
        return siiExpedienteFisico;
    }

    public SiiExpedArchFisico convertir(ExpedArchFisicoVO expedArchFisicoVO) throws ExcepcionDAO {
        SiiExpedArchFisico siiExpedArchFisico = new SiiExpedArchFisico();
        if (expedArchFisicoVO.getEafCodigo() != null && expedArchFisicoVO.getEafCodigo() > 0) {
            siiExpedArchFisico = expedArchFisicoDao.buscarExpedArchivoFisicoPorId(expedArchFisicoVO.getEafCodigo());
        }
        siiExpedArchFisico.setEafActivo(expedArchFisicoVO.getEafActivo());
        if (expedArchFisicoVO.getArchivoFisicoVo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(expedArchFisicoVO.getArchivoFisicoVo().getAfiCodigo());
            siiExpedArchFisico.setSiiArchivoFisico(siiArchivoFisico);
        }
        if (expedArchFisicoVO.getExpedienteFisicoVo() != null) {
            SiiExpedienteFisico siiExpedienteFisico =
                expedienteFisicoDao.buscarExpedienteFisicoPorId(expedArchFisicoVO.getExpedienteFisicoVo().getEfiCodigo());
            siiExpedArchFisico.setSiiExpedienteFisico(siiExpedienteFisico);
        }
        return siiExpedArchFisico;
    }

    public SiiModificacionRp convertir(ModificacionRpVO modificacionRpVo) throws ExcepcionDAO {
        SiiModificacionRp modificacionRp = new SiiModificacionRp();
        if (modificacionRpVo.getMrpCodigo() != null && modificacionRpVo.getMrpCodigo() > 0) {
            modificacionRp = modificacionRpDao.buscarModificacionRpPorId(modificacionRpVo.getMrpCodigo());
        }
        modificacionRp.setMrpCodigo(modificacionRpVo.getMrpCodigo());
        modificacionRp.setMrpFecha(modificacionRpVo.getMrpFecha());
        modificacionRp.setMrpTipoModif(modificacionRpVo.getMrpTipoModif());
        modificacionRp.setMrpConsecutivo(modificacionRpVo.getMrpConsecutivo());
        modificacionRp.setMrpMotivoAnula(modificacionRpVo.getMrpMotivoAnula());
        //Padres:
        if (modificacionRpVo.getRpVo() != null) {
            modificacionRp.setSiiRp1(rpDao.buscarPorCodigoRp(modificacionRpVo.getRpVo().getRpCodigo()));
        }
        if (modificacionRpVo.getEstadoModificRpVo() != null) {
            modificacionRp.setSiiEstadoModificRp(estadoModificRpDao.buscarEstadoModificRpPorId(modificacionRpVo.getEstadoModificRpVo().getEmrCodigo()));
        }
        return modificacionRp;
    }


    private SiiEstadoModificRp convertir(EstadoModificRpVO estadoModificRpVO) throws ExcepcionDAO {
        SiiEstadoModificRp estadoModificRp = new SiiEstadoModificRp();
        if (estadoModificRpVO.getEmrCodigo() != null && estadoModificRpVO.getEmrCodigo() > 0) {
            estadoModificRp = estadoModificRpDao.buscarEstadoModificRpPorId(estadoModificRpVO.getEmrCodigo());
        }
        estadoModificRp.setEmrCodigo(estadoModificRpVO.getEmrCodigo());
        estadoModificRp.setEmrNombre(estadoModificRpVO.getEmrNombre());

        return estadoModificRp;
    }

    public SiiModifRpDetRubCdp convertir(ModifRpDetRubCdpVO modifVo) throws ExcepcionDAO {
        SiiModifRpDetRubCdp modif = new SiiModifRpDetRubCdp();
        if (modifVo.getMrdCodigo() != null && modifVo.getMrdCodigo() > 0) {
            modif = modifRpDetRubCdpDao.buscarModifRpDetRubCdpPorId(modifVo.getMrdCodigo());
        }
        modif.setMrdCodigo(modifVo.getMrdCodigo());
        modif.setMrdValor(modifVo.getMrdValor());

        //Padres:
        if (modifVo.getPpDetRubroCdpVo() != null) {
            modif.setSiiRpDetRubroCdp(rpDetRubroCdpDao.buscarCodigoRpDetRubroCdp(modifVo.getPpDetRubroCdpVo().getRdrCodigo()));
        }

        if (modifVo.getModificacionRpVo() != null) {
            modif.setSiiModificacionRp(modificacionRpDao.buscarModificacionRpPorId(modifVo.getModificacionRpVo().getMrpCodigo()));
        }

        return modif;

    }

    /**
     *  Modificado por Giovanni
     * @param personalEmpresaVO
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPersonalEmpresa convertir(PersonalEmpresaVO personalEmpresaVO) throws ExcepcionDAO {
        SiiPersonalEmpresa siiPersonalEmpresa = new SiiPersonalEmpresa();
        if (personalEmpresaVO.getPemCodigo() != null && personalEmpresaVO.getPemCodigo() > 0) {
            siiPersonalEmpresa = personalEmpresaDao.buscarPersonalEmpresaPorCodigo(personalEmpresaVO.getPemCodigo());
        }

        //Variables VO
        siiPersonalEmpresa.setPemActivo(personalEmpresaVO.getPemActivo());
        siiPersonalEmpresa.setPemFechaRegistro(personalEmpresaVO.getPemFechaRegistro());

        //Persona Empresa
        if (personalEmpresaVO.getPersonaEmpresaVo() != null) {
            siiPersonalEmpresa.setSiiPersona(personaDao.buscarPersonaPorId(personalEmpresaVO.getPersonaEmpresaVo().getPerCodigo()));
        }

        //Persona
        if (personalEmpresaVO.getPersonaVo() != null) {
            siiPersonalEmpresa.setSiiPersona3(personaDao.buscarPersonaPorId(personalEmpresaVO.getPersonaVo().getPerCodigo()));
        }

        //Tipo Persona
        if (personalEmpresaVO.getTipoPersonalVo() != null) {
            siiPersonalEmpresa.setSiiTipoPersonal(tipoPersonalDao.buscarTipoPersonalPorCodigo(personalEmpresaVO.getTipoPersonalVo().getTpeCodigo()));
        }

        return siiPersonalEmpresa;
    }

    public SiiTipoPersonal convertir(TipoPersonalVO tipoPersonalVo) throws ExcepcionDAO {
        SiiTipoPersonal siiTipoPersonal = new SiiTipoPersonal();
        if (tipoPersonalVo.getTpeCodigo() != null && tipoPersonalVo.getTpeCodigo() > 0) {
            siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(tipoPersonalVo.getTpeCodigo());
        }

        siiTipoPersonal.setTpeNombre(tipoPersonalVo.getTpeNombre());

        return siiTipoPersonal;
    }

    /**
     * Modifica: Giovanni
     * @param detalleFinancVo
     * @return
     * @throws ExcepcionDAO
     */
    public SiiDetalleFinanc convertir(DetalleFinancVO detalleFinancVo) throws ExcepcionDAO {
        SiiDetalleFinanc siiDetalleFinanc = new SiiDetalleFinanc();
        if (detalleFinancVo.getDfiCodigo() != null && detalleFinancVo.getDfiCodigo() > 0) {
            siiDetalleFinanc = detalleFinancDao.buscarDetalleFinancPorCodigo(detalleFinancVo.getDfiCodigo());
        }

        siiDetalleFinanc.setDfiActivosTot(detalleFinancVo.getDfiActivosTot());
        siiDetalleFinanc.setDfiAdqComprav(detalleFinancVo.getDfiAdqComprav());
        siiDetalleFinanc.setDfiAdqDonac(detalleFinancVo.getDfiAdqDonac());
        siiDetalleFinanc.setDfiAdqNoPoseeBien(detalleFinancVo.getDfiAdqNoPoseeBien());
        siiDetalleFinanc.setDfiAdqOtro(detalleFinancVo.getDfiAdqOtro());
        siiDetalleFinanc.setDfiAdqOtroCual(detalleFinancVo.getDfiAdqOtroCual());
        siiDetalleFinanc.setDfiCambiosDiv(detalleFinancVo.getDfiCambiosDiv());
        siiDetalleFinanc.setDfiEgreNoOpe(detalleFinancVo.getDfiEgreNoOpe());
        siiDetalleFinanc.setDfiEgresosMens(detalleFinancVo.getDfiEgresosMens());
        siiDetalleFinanc.setDfiExportaciones(detalleFinancVo.getDfiExportaciones());
        siiDetalleFinanc.setDfiGiros(detalleFinancVo.getDfiGiros());
        siiDetalleFinanc.setDfiImportaciones(detalleFinancVo.getDfiImportaciones());
        siiDetalleFinanc.setDfiIngrNoOper(detalleFinancVo.getDfiIngrNoOper());
        siiDetalleFinanc.setDfiIngresosMens(detalleFinancVo.getDfiIngresosMens());
        siiDetalleFinanc.setDfiInversiones(detalleFinancVo.getDfiInversiones());
        siiDetalleFinanc.setDfiOperacInt(detalleFinancVo.getDfiOperacInt());
        siiDetalleFinanc.setDfiOrdenesPago(detalleFinancVo.getDfiOrdenesPago());
        siiDetalleFinanc.setDfiOriCual(detalleFinancVo.getDfiOriCual());
        siiDetalleFinanc.setDfiOriFonNegocio(detalleFinancVo.getDfiOriFonNegocio());
        siiDetalleFinanc.setDfiOriFonSocios(detalleFinancVo.getDfiOriFonSocios());
        siiDetalleFinanc.setDfiOriOtro(detalleFinancVo.getDfiOriOtro());
        siiDetalleFinanc.setDfiOtrosIngr(detalleFinancVo.getDfiOtrosIngr());
        siiDetalleFinanc.setDfiPasivosTot(detalleFinancVo.getDfiPasivosTot());
        siiDetalleFinanc.setDfiPatrimonioTot(detalleFinancVo.getDfiPatrimonioTot());
        siiDetalleFinanc.setDfiPrestamosMe(detalleFinancVo.getDfiPrestamosMe());
        siiDetalleFinanc.setDfiRemesas(detalleFinancVo.getDfiRemesas());
        siiDetalleFinanc.setDfiTransferencias(detalleFinancVo.getDfiTransferencias());

        siiDetalleFinanc.setDfiFechaFinCorte(detalleFinancVo.getDfiFechaFinCorte());
        siiDetalleFinanc.setDfiFechaIniCorte(detalleFinancVo.getDfiFechaIniCorte());
        siiDetalleFinanc.setDfiCostosGastosAdm(detalleFinancVo.getDfiCostosGastosAdm());
        siiDetalleFinanc.setDfiCapitalSocial(detalleFinancVo.getDfiCapitalSocial());
        siiDetalleFinanc.setDfiNivelEndeud(detalleFinancVo.getDfiNivelEndeud());
        siiDetalleFinanc.setDfiCapTrabReq(detalleFinancVo.getDfiCapTrabReq());
        siiDetalleFinanc.setDfiIndiceActTot(detalleFinancVo.getDfiIndiceActTot());
        siiDetalleFinanc.setDfiPatrimonReq(detalleFinancVo.getDfiPatrimonReq());
        siiDetalleFinanc.setDfiCambioDivisa(detalleFinancVo.getDfiCambioDivisa());

        siiDetalleFinanc.setDfiCostGastAdmOpe(detalleFinancVo.getDfiCostGastAdmOpe());
        siiDetalleFinanc.setDfiGastIntereses(detalleFinancVo.getDfiGastIntereses());
        siiDetalleFinanc.setDfiGastFinancieros(detalleFinancVo.getDfiGastFinancieros());
        siiDetalleFinanc.setDfiUtilidadNeta(detalleFinancVo.getDfiUtilidadNeta());
        siiDetalleFinanc.setDfiUtilidadOper(detalleFinancVo.getDfiUtilidadOper());
        siiDetalleFinanc.setDfiCapitalTrabajo(detalleFinancVo.getDfiCapitalTrabajo());
        siiDetalleFinanc.setDfiEbit(detalleFinancVo.getDfiEbit());
        siiDetalleFinanc.setDfiEbitda(detalleFinancVo.getDfiEbitda());
        siiDetalleFinanc.setDfiRetornoActivos(detalleFinancVo.getDfiRetornoActivos());
        siiDetalleFinanc.setDfiGastFinEbit(detalleFinancVo.getDfiGastFinEbit());
        siiDetalleFinanc.setDfiGastFinEbitda(detalleFinancVo.getDfiGastFinEbitda());
        siiDetalleFinanc.setDfiRazonEndeuda(detalleFinancVo.getDfiRazonEndeuda());
        siiDetalleFinanc.setDfiActivoCorriente(detalleFinancVo.getDfiActivoCorriente());
        siiDetalleFinanc.setDfiPasivoCorriente(detalleFinancVo.getDfiPasivoCorriente());

        //Moneda
        if (detalleFinancVo.getMonedaVO() != null && detalleFinancVo.getMonedaVO().getMonCodigo() != null &&
            detalleFinancVo.getMonedaVO().getMonCodigo() > 0) {
            SiiMoneda siiMoneda = monedaDao.buscarMonedaPorId(detalleFinancVo.getMonedaVO().getMonCodigo());
            siiDetalleFinanc.setSiiMoneda(siiMoneda);
        }

        //Persona
        if (detalleFinancVo.getPersonaVo() != null && detalleFinancVo.getPersonaVo().getPerCodigo() != null &&
            detalleFinancVo.getPersonaVo().getPerCodigo() > 0) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(detalleFinancVo.getPersonaVo().getPerCodigo());
            siiDetalleFinanc.setSiiPersona2(siiPersona);
        }
        return siiDetalleFinanc;
    }

    public SiiSolicitudPago convertir(SolicitudPagoVO solicitudPagoVO) throws ExcepcionDAO {
        SiiSolicitudPago siiSolicitudPago = new SiiSolicitudPago();
        if (solicitudPagoVO.getSpaCodigo() != null && solicitudPagoVO.getSpaCodigo() > 0) {
            siiSolicitudPago = solicitudPagoDao.buscarSolicitudPagoPorId(solicitudPagoVO.getSpaCodigo());
        }

        siiSolicitudPago.setSpaCodigo(solicitudPagoVO.getSpaCodigo());
        siiSolicitudPago.setSpaConsecutivo(solicitudPagoVO.getSpaConsecutivo());
        siiSolicitudPago.setSpaFechaSol(solicitudPagoVO.getSpaFechaSol());
        siiSolicitudPago.setSpaMotivoDevoluc(solicitudPagoVO.getSpaMotivoDevoluc());
        siiSolicitudPago.setSpaNumDocCobro(solicitudPagoVO.getSpaNumDocCobro());
        siiSolicitudPago.setSpaObservaciones(solicitudPagoVO.getSpaObservaciones());
        siiSolicitudPago.setSpaTipoCuenta(solicitudPagoVO.getSpaTipoCuenta());
        siiSolicitudPago.setSpaValorCuenta(solicitudPagoVO.getSpaValorCuenta());
        siiSolicitudPago.setSpaVigencia(solicitudPagoVO.getSpaVigencia());

        if (solicitudPagoVO.getEstadoSolicPagoVo() != null &&
            solicitudPagoVO.getEstadoSolicPagoVo().getEsoCodigo() != null) {
            SiiEstadoSolicPago siiEstadoSolicitud =
                estadoSolicPagoDao.buscarPorCodigoEstadoSolicPago(solicitudPagoVO.getEstadoSolicPagoVo().getEsoCodigo());
            siiSolicitudPago.setSiiEstadoSolicPago(siiEstadoSolicitud);
        }

        if (solicitudPagoVO.getMesVo() != null && solicitudPagoVO.getMesVo().getMesCodigo() != null) {
            SiiMes siiMes = mesDao.buscarMesPorId(solicitudPagoVO.getMesVo().getMesCodigo());
            siiSolicitudPago.setSiiMes(siiMes);
        }

        if (solicitudPagoVO.getRpVo() != null && solicitudPagoVO.getRpVo().getRpCodigo() != null) {
            SiiRp siiRp = rpDao.buscarPorCodigoRp(solicitudPagoVO.getRpVo().getRpCodigo());
            siiSolicitudPago.setSiiRp(siiRp);
        }

        if (solicitudPagoVO.getTipoDocSopSolicPagoVo()!=null && solicitudPagoVO.getTipoDocSopSolicPagoVo().getTspCodigo()!=null) {
            SiiTipoDocSopSolicPago siiTipoDocSopSolicPago = tipoDocSopSolicPagoDao.buscarPorCodigo(solicitudPagoVO.getTipoDocSopSolicPagoVo().getTspCodigo());
            siiSolicitudPago.setSiiTipoDocSopSolicPago(siiTipoDocSopSolicPago);
        }

        return siiSolicitudPago;
    }


    public SiiEstadoSolicPago convertir(EstadoSolicPagoVO estadoSolicitudPagoVO) throws ExcepcionDAO {
        SiiEstadoSolicPago siiEstadoSolicPago = new SiiEstadoSolicPago();
        if (estadoSolicitudPagoVO.getEsoCodigo() != null) {
            siiEstadoSolicPago =
                estadoSolicPagoDao.buscarPorCodigoEstadoSolicPago(estadoSolicitudPagoVO.getEsoCodigo());
        }
        siiEstadoSolicPago.setEsoNombre(estadoSolicitudPagoVO.getEsoNombre());

        return siiEstadoSolicPago;
    }


    public SiiSolicitudAutoriza convertir(SolicitudAutorizaVO solicitudVo) throws ExcepcionDAO {
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();
        if (solicitudVo.getSauCodigo() != null && solicitudVo.getSauCodigo() > 0) {
            siiSolicitudAutoriza =
                solicitudAutorizaDao.buscarSolicitudAutorizacionPorCodigo(solicitudVo.getSauCodigo());
        }
        siiSolicitudAutoriza.setSauFecha(solicitudVo.getSauFecha());
        siiSolicitudAutoriza.setSauNit(solicitudVo.getSauNit());
        //siiSolicitudAutoriza.setSauNumeroSiito(solicitudVo.getSauNumeroSiito());
        siiSolicitudAutoriza.setSauMovimientoSiito(solicitudVo.getSauMovimientoSiito());
        siiSolicitudAutoriza.setSauTiempoContr(solicitudVo.getSauTiempoContr());
        siiSolicitudAutoriza.setSauValorEstimado(solicitudVo.getSauValorEstimado());
        siiSolicitudAutoriza.setSauValorProrroga(solicitudVo.getSauValorProrroga());
        siiSolicitudAutoriza.setSauAmpliacion(solicitudVo.getSauAmpliacion());
        siiSolicitudAutoriza.setSauNitCesionario(solicitudVo.getSauNitCesionario());

        //Padres:
        if (solicitudVo.getTipoSolicAutorizaVo() != null) {
            SiiTipoSolicAutoriza siiTipoSolicAutoriza =
                tipoSolicAutorizaDao.buscarTipoSolicAutorizaPorCodigo(solicitudVo.getTipoSolicAutorizaVo().getTsaCodigo());
            siiSolicitudAutoriza.setSiiTipoSolicAutoriza(siiTipoSolicAutoriza);
        }
        if (solicitudVo.getEstadoSolicAutoriz() != null) {
            SiiEstadoSolicAutoriz siiEstadoSolicAutoriz =
                estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(solicitudVo.getEstadoSolicAutoriz().getEsaCodigo());
            siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
        }
        if (solicitudVo.getPersonaRifaPromVo() != null) {
            if (solicitudVo.getPersonaRifaPromVo().getPerCodigo() != null) {
                SiiPersona siiPersona =
                    personaDao.buscarPersonaPorId(solicitudVo.getPersonaRifaPromVo().getPerCodigo());
                siiSolicitudAutoriza.setSiiPersonaRifaProm(siiPersona);
            }
        }
        if (solicitudVo.getUsuarioVo() != null) {
            SiiUsuario siiusuario = usuarioDao.buscarUsuarioPorId(solicitudVo.getUsuarioVo().getUsuCodigo());
            siiSolicitudAutoriza.setSiiUsuario(siiusuario);
        }


        return siiSolicitudAutoriza;
    }

    public SiiTipoSolicAutoriza convertir(TipoSolicAutorizaVO tipoSolicAutorizaVo) throws ExcepcionDAO {
        SiiTipoSolicAutoriza siiTipoSolicAutoriza = new SiiTipoSolicAutoriza();
        if (tipoSolicAutorizaVo.getTsaCodigo() != null && tipoSolicAutorizaVo.getTsaCodigo() > 0) {
            siiTipoSolicAutoriza =
                tipoSolicAutorizaDao.buscarTipoSolicAutorizaPorCodigo(tipoSolicAutorizaVo.getTsaCodigo());
        }

        siiTipoSolicAutoriza.setTsaNombre(tipoSolicAutorizaVo.getTsaNombre());
        return siiTipoSolicAutoriza;
    }


    public SiiModificPfcAnual convertir(ModificPfcAnualVO modificPfcAnualVo) throws ExcepcionDAO {
        SiiModificPfcAnual siiModificPfcAnual = new SiiModificPfcAnual();

        if (modificPfcAnualVo.getMpaCodigo() != null && modificPfcAnualVo.getMpaCodigo() > 0) {
            siiModificPfcAnual = modificPfcAnualDao.buscarPorCodigoModPfca(modificPfcAnualVo.getMpaCodigo());
        }
        siiModificPfcAnual.setMpaActivo(modificPfcAnualVo.getMpaActivo());
        siiModificPfcAnual.setMpaValor(modificPfcAnualVo.getMpaValor());
        siiModificPfcAnual.setMpaTipoModif(modificPfcAnualVo.getMpaTipoModif());
        siiModificPfcAnual.setMpaJustificacion(modificPfcAnualVo.getMpaJustificacion());

        //padres
        if (modificPfcAnualVo.getDistribucionPfcVo() != null) {
            siiModificPfcAnual.setSiiDistribucionPfc(distribucionPfcDao.buscarDistribucionPfcPorId(modificPfcAnualVo.getDistribucionPfcVo().getDpfCodigo()));
        }
        if (modificPfcAnualVo.getSolicPfcmDetalleVo() != null) {
            siiModificPfcAnual.setSiiSolicPfcmDetalle(solicPfcmDetalleDao.buscarSolicitudPfcmPorId(modificPfcAnualVo.getSolicPfcmDetalleVo().getSpdCodigo()));
        }

        return siiModificPfcAnual;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param oficioAdjudicaVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiOficioAdjudica convertir(OficioAdjudicaVO oficioAdjudicaVO) throws ExcepcionDAO {
        SiiOficioAdjudica siiOficioAdjudica = new SiiOficioAdjudica();
        // realizar la busqueda por codigo
        if (oficioAdjudicaVO.getOadCodigo() != null && oficioAdjudicaVO.getOadCodigo() > 0) {
            siiOficioAdjudica = oficioAdjudicaDao.buscarPorCodigo(oficioAdjudicaVO.getOadCodigo());
        }

        siiOficioAdjudica.setOadCodigo(oficioAdjudicaVO.getOadCodigo());
        siiOficioAdjudica.setOadEstado(oficioAdjudicaVO.getOadEstado());
        siiOficioAdjudica.setOadFechaReg(oficioAdjudicaVO.getOadFechaReg());
        siiOficioAdjudica.setOadConsecContr(oficioAdjudicaVO.getOadConsecContr());
        siiOficioAdjudica.setOadTipoContr(oficioAdjudicaVO.getOadTipoContr());
        siiOficioAdjudica.setOadVigenciaContr(oficioAdjudicaVO.getOadVigenciaContr());


        if (oficioAdjudicaVO.getProcesoContratacion() != null) {
            SiiProcesoContratacion siiProcesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(oficioAdjudicaVO.getProcesoContratacion().getPrcCodigo());
            siiOficioAdjudica.setSiiProcesoContratacion(siiProcesoContratacion);
        }

        if (oficioAdjudicaVO.getProveedor() != null) {
            SiiProveedor siiProveedor =
                proveedorDao.buscarProveedorPorId(oficioAdjudicaVO.getProveedor().getProCodigo());
            siiOficioAdjudica.setSiiProveedor(siiProveedor);
        }

        return siiOficioAdjudica;
    }

    public SiiSolPfcMensDetRub convertir(SolicitudPFCMenDetalleVO solicitudPFCMenDetalleVo) throws ExcepcionDAO {
        SiiSolPfcMensDetRub unSolPfcMensDetRub = new SiiSolPfcMensDetRub();
        if (solicitudPFCMenDetalleVo.getSprcodigo() != null && solicitudPFCMenDetalleVo.getSprcodigo() > 0) {
            unSolPfcMensDetRub =
                solicitudPFCMenDetalleRDao.buscarSolicitudPfcMensDettalleRPorId(solicitudPFCMenDetalleVo.getSprcodigo());
        }
        unSolPfcMensDetRub.setSprValorAprob(solicitudPFCMenDetalleVo.getSprValorAprobado());
        //padres
        if (solicitudPFCMenDetalleVo.getDetalleRubroVo() != null)
            unSolPfcMensDetRub.setSiiDetalleRubro(detalleRubroDao.buscarPorCodigoDetalleRubro(solicitudPFCMenDetalleVo.getDetalleRubroVo().getDruCodigo()));

        if (solicitudPFCMenDetalleVo.getSolicitudPfcMensualVo() != null)
            unSolPfcMensDetRub.setSiiSolicitudPfcMens(solicitudPfcMensualDao.buscarPorCodigoSpfcm((solicitudPFCMenDetalleVo.getSolicitudPfcMensualVo().getSpfCodigo())));

        return unSolPfcMensDetRub;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param obligacionVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiObligacion convertir(ObligacionVO obligacionVO) throws ExcepcionDAO {
        SiiObligacion siiObligacion = new SiiObligacion();
        // realizar la busqueda por codigo
        if (obligacionVO.getOblCodigo() != null && obligacionVO.getOblCodigo() > 0) {
            siiObligacion = obligacionDao.buscarPorCodigo(obligacionVO.getOblCodigo());
        }

        siiObligacion.setOblCodigo(obligacionVO.getOblCodigo());
        siiObligacion.setOblFecha(obligacionVO.getOblFecha());
        siiObligacion.setOblNumero(obligacionVO.getOblNumero());
        siiObligacion.setOblSubtotal(obligacionVO.getOblSubtotal());
        siiObligacion.setOblIva(obligacionVO.getOblIva());
        siiObligacion.setOblMotivoAnula(obligacionVO.getOblMotivoAnula());

        if (obligacionVO.getEstadoObligacionVo() != null) {
            SiiEstadoObligacion siiEstadoObligacion =
                estadoObligacionDao.buscarPorCodigo(obligacionVO.getEstadoObligacionVo().getEobCodigo());
            siiObligacion.setSiiEstadoObligacion(siiEstadoObligacion);
        }

        if (obligacionVO.getSiiSolicitudPago() != null) {
            SiiSolicitudPago siiSolicitudPago =
                solicitudPagoDao.buscarSolicitudPagoPorId(obligacionVO.getSiiSolicitudPago().getSpaCodigo());
            siiObligacion.setSiiSolicitudPago(siiSolicitudPago);
        }

        if (obligacionVO.getSiiUsuarioReg() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(obligacionVO.getSiiUsuarioReg().getUsuCodigo());
            siiObligacion.setSiiUsuarioReg(siiUsuario);
        }

        if (obligacionVO.getSiiUsuarioApr() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(obligacionVO.getSiiUsuarioApr().getUsuCodigo());
            siiObligacion.setSiiUsuarioApr(siiUsuario);
        }

        if (obligacionVO.getTipoDocContableVo() != null) {
            SiiTipoDocContable siiTipoDocContable =
                tipoDocContableDao.buscarPorCodigo(obligacionVO.getTipoDocContableVo().getTdcCodigo());
            siiObligacion.setSiiTipoDocContable(siiTipoDocContable);
        }

        if (obligacionVO.getCargaNominaVo() != null && obligacionVO.getCargaNominaVo().getCnoCodigo() != null) {
            SiiCargaNomina siiCargaNomina =
                cargaNominaDao.buscarPorCodigo(obligacionVO.getCargaNominaVo().getCnoCodigo());
            siiObligacion.setSiiCargaNomina(siiCargaNomina);
        }

        if (obligacionVO.getRpVo() != null && obligacionVO.getRpVo().getRpCodigo() != null) {
            SiiRp siiRp = rpDao.buscarPorCodigoRp(obligacionVO.getRpVo().getRpCodigo());
            siiObligacion.setSiiRp(siiRp);
        }

        if (obligacionVO.getDistribucionMesVo() != null && obligacionVO.getDistribucionMesVo().getDmeCodigo() != null) {
            SiiDistribucionMes siiDistribucionMes =
                distribucionMesDao.buscarPorCodigoDistribucionMes(obligacionVO.getDistribucionMesVo().getDmeCodigo());
            siiObligacion.setSiiDistribucionMes(siiDistribucionMes);
        }

        if (obligacionVO.getPersonaBenefic() != null && obligacionVO.getPersonaBenefic().getPerCodigo() != null) {
            SiiPersona siiPersonaBenefic =
                personaDao.buscarPersonaPorId(obligacionVO.getPersonaBenefic().getPerCodigo());
            siiObligacion.setSiiPersonaBenefic(siiPersonaBenefic);
        }

        /*if (obligacionVO.getDetalleDistribVo()!=null && obligacionVO.getDetalleDistribVo().getDdiCodigo()!=null) {
            SiiDetalleDistrib siiDetalleDistrib = detalleDistribDao.buscarPorCodigoDetalleDistrib(obligacionVO.getDetalleDistribVo().getDdiCodigo());
            siiObligacion.setSiiDetalleDistrib(siiDetalleDistrib);
        }*/

        if (obligacionVO.getConsolidadoDistVo() != null && obligacionVO.getConsolidadoDistVo().getCodCodigo() != null) {
            SiiConsolidadoDist siiConsolidadoDist =
                consolidadoDistDao.buscarPorCodigoConsolidadoDist(obligacionVO.getConsolidadoDistVo().getCodCodigo());
            siiObligacion.setSiiConsolidadoDist(siiConsolidadoDist);
        }

        return siiObligacion;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param estadoObligacionVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiEstadoObligacion convertir(EstadoObligacionVO estadoObligacionVO) throws ExcepcionDAO {
        SiiEstadoObligacion siiEstadoObligacion = new SiiEstadoObligacion();
        // realizar la busqueda por codigo
        if (estadoObligacionVO.getEobCodigo() != null && estadoObligacionVO.getEobCodigo() > 0) {
            siiEstadoObligacion = estadoObligacionDao.buscarPorCodigo(estadoObligacionVO.getEobCodigo());
        }

        siiEstadoObligacion.setEobCodigo(estadoObligacionVO.getEobCodigo());
        siiEstadoObligacion.setEobNombre(estadoObligacionVO.getEobNombre());

        return siiEstadoObligacion;
    }


    public SiiDocumentoTdr convertir(DocumentoTdrVO documentoTdrVo) throws ExcepcionDAO {
        SiiDocumentoTdr siiDocumentoTdr = new SiiDocumentoTdr();
        if (documentoTdrVo.getDtdCodigo() != null && documentoTdrVo.getDtdCodigo() > 0) {
            siiDocumentoTdr = documentoTdrDao.buscarPorCodigoDocumento(documentoTdrVo.getDtdCodigo());
        }

        siiDocumentoTdr.setDtdCodigo(documentoTdrVo.getDtdCodigo());
        siiDocumentoTdr.setDtdTipoDocTdr(documentoTdrVo.getDtdTipoDocTdr());
        if (documentoTdrVo.getArchivoFisicovo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(documentoTdrVo.getArchivoFisicovo().getAfiCodigo());
            siiDocumentoTdr.setSiiArchivoFisico(siiArchivoFisico);
        }
        if (documentoTdrVo.getTerminosReferenciavo() != null) {
            SiiTerminosReferencia siiTerminosReferencia =
                terminoReferenciaDao.buscarPorCodigoTerminoReferencia(documentoTdrVo.getTerminosReferenciavo().getTdrCodigo());
            siiDocumentoTdr.setSiiTerminosReferencia(siiTerminosReferencia);
        }
        return siiDocumentoTdr;
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param obligacionConceptoVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiObligacionConcepto convertir(ObligacionConceptoVO obligacionConceptoVO) throws ExcepcionDAO {
        SiiObligacionConcepto siiObligacionConcepto = new SiiObligacionConcepto();

        // realizar la busqueda por codigo
        if (obligacionConceptoVO.getOcoCodigo() != null && obligacionConceptoVO.getOcoCodigo() > 0) {
            siiObligacionConcepto = obligacionConceptoDao.buscarPorCodigo(obligacionConceptoVO.getOcoCodigo());
        }

        siiObligacionConcepto.setOcoAiu(obligacionConceptoVO.getOcoAiu());
        siiObligacionConcepto.setOcoCodigo(obligacionConceptoVO.getOcoCodigo());
        siiObligacionConcepto.setOcoImpuestoIca(obligacionConceptoVO.getOcoImpuestoIca());
        siiObligacionConcepto.setOcoImpuestoIva(obligacionConceptoVO.getOcoImpuestoIva());
        siiObligacionConcepto.setOcoImpuestoRent(obligacionConceptoVO.getOcoImpuestoRent());
        siiObligacionConcepto.setOcoIva(obligacionConceptoVO.getOcoIva());
        siiObligacionConcepto.setOcoSubtotal(obligacionConceptoVO.getOcoSubtotal());
        siiObligacionConcepto.setOcoValorIca(obligacionConceptoVO.getOcoValorIca());
        siiObligacionConcepto.setOcoValorIva(obligacionConceptoVO.getOcoValorIva());
        siiObligacionConcepto.setOcoValorRenta(obligacionConceptoVO.getOcoValorRenta());
        siiObligacionConcepto.setOcoValorIni(obligacionConceptoVO.getOcoValorIni());
        siiObligacionConcepto.setOcoBaseRetef(obligacionConceptoVO.getOcoBaseRetef());
        siiObligacionConcepto.setOcoEstampillaUnal(obligacionConceptoVO.getOcoEstampillaUnal());
        siiObligacionConcepto.setOcoValorRetEstamp(obligacionConceptoVO.getOcoValorRetEstamp());
        siiObligacionConcepto.setOcoValorVolAfc(obligacionConceptoVO.getOcoValorVolAfc());
        siiObligacionConcepto.setOcoValorVolAfp(obligacionConceptoVO.getOcoValorVolAfp());
        siiObligacionConcepto.setOcoImpuestoEstamp(obligacionConceptoVO.getOcoImpuestoEstamp());

        if (obligacionConceptoVO.getConceptoGastoVo() != null) {
            SiiConceptoGasto siiConceptoGasto =
                conceptoGastoDao.buscarPorCodigo(obligacionConceptoVO.getConceptoGastoVo().getCgaCodigo());
            siiObligacionConcepto.setSiiConceptoGasto(siiConceptoGasto);
        }

        if (obligacionConceptoVO.getObligacionVo() != null) {
            SiiObligacion siiObligacion =
                obligacionDao.buscarPorCodigo(obligacionConceptoVO.getObligacionVo().getOblCodigo());
            siiObligacionConcepto.setSiiObligacion(siiObligacion);
        }

        if (obligacionConceptoVO.getRpVo() != null) {
            SiiRp siiRp = rpDao.buscarPorCodigoRp(obligacionConceptoVO.getRpVo().getRpCodigo());
            siiObligacionConcepto.setSiiRp(siiRp);
        }

        if (obligacionConceptoVO.getFuenteFinancContabVo() != null) {
            SiiFuenteFinancContab siiFuenteFinancContab =
                fuenteFinancContabDao.buscarPorCodigo(obligacionConceptoVO.getFuenteFinancContabVo().getFfcCodigo());
            siiObligacionConcepto.setSiiFuenteFinancContab(siiFuenteFinancContab);
        }

        if (obligacionConceptoVO.getTipoRetencionRentaVo() != null &&
            obligacionConceptoVO.getTipoRetencionRentaVo().getTreCodigo() != null) {
            SiiTipoRetencion siiTipoRetencionRenta =
                tipoRetencionDao.buscarPorCodigo(obligacionConceptoVO.getTipoRetencionRentaVo().getTreCodigo());
            siiObligacionConcepto.setSiiTipoRetencionRenta(siiTipoRetencionRenta);
        }

        if (obligacionConceptoVO.getTipoRetencionIvaVo() != null &&
            obligacionConceptoVO.getTipoRetencionIvaVo().getTreCodigo() != null) {
            SiiTipoRetencion siiTipoRetencionIva =
                tipoRetencionDao.buscarPorCodigo(obligacionConceptoVO.getTipoRetencionIvaVo().getTreCodigo());
            siiObligacionConcepto.setSiiTipoRetencionIva(siiTipoRetencionIva);
        }

        if (obligacionConceptoVO.getActividadIcaVo() != null &&
            obligacionConceptoVO.getActividadIcaVo().getAicCodigo() != null) {
            SiiActividadIca siiActividadIca =
                actividadIcaDao.buscarPorCodigoActividadIca(obligacionConceptoVO.getActividadIcaVo().getAicCodigo());
            siiObligacionConcepto.setSiiActividadIca(siiActividadIca);
        }

        if (obligacionConceptoVO.getTipoRetencionEstamp() != null &&
            obligacionConceptoVO.getTipoRetencionEstamp().getTreCodigo() != null) {
            SiiTipoRetencion siiTipoRetencionEstamp =
                tipoRetencionDao.buscarPorCodigo(obligacionConceptoVO.getTipoRetencionEstamp().getTreCodigo());
            siiObligacionConcepto.setSiiTipoRetencionEstamp(siiTipoRetencionEstamp);
        }

        if (obligacionConceptoVO.getPersonaBenefAfcVo() != null &&
            obligacionConceptoVO.getPersonaBenefAfcVo().getPerCodigo() != null) {
            SiiPersona siiPersonaBenefAfc =
                personaDao.buscarPersonaPorId(obligacionConceptoVO.getPersonaBenefAfcVo().getPerCodigo());
            siiObligacionConcepto.setSiiPersonaBenefAfc(siiPersonaBenefAfc);
        }

        if (obligacionConceptoVO.getPersonaBenefAfpVo() != null &&
            obligacionConceptoVO.getPersonaBenefAfpVo().getPerCodigo() != null) {
            SiiPersona siiPersonaBenefAfp =
                personaDao.buscarPersonaPorId(obligacionConceptoVO.getPersonaBenefAfpVo().getPerCodigo());
            siiObligacionConcepto.setSiiPersonaBenefAfp(siiPersonaBenefAfp);
        }

        return siiObligacionConcepto;
    }


    public SiiContrato convertir(ContratoVO contratoVo) throws ExcepcionDAO {
        SiiContrato siiContrato = new SiiContrato();
        if (contratoVo.getConCodigo() != null && contratoVo.getConCodigo() > 0) {
            siiContrato = contratoDao.buscarContratoPorId(contratoVo.getConCodigo());
        }

        siiContrato.setConCodigo(contratoVo.getConCodigo());
        siiContrato.setConDescripcion(contratoVo.getConDescripcion());
        siiContrato.setConFechaFin(contratoVo.getConFechaFin());
        siiContrato.setConFechaIni(contratoVo.getConFechaIni());
        siiContrato.setConNumero(contratoVo.getConNumero());
        siiContrato.setConVigente(contratoVo.getConVigente());
        siiContrato.setConConsecutivo(contratoVo.getConConsecutivo());
        siiContrato.setConFecha(contratoVo.getConFecha());
        siiContrato.setConVigente(contratoVo.getConVigente());
        siiContrato.setConConsecutivo(contratoVo.getConConsecutivo());
        siiContrato.setConExpedienteUrl(contratoVo.getConExpedienteUrl());
        siiContrato.setConFechaCitFirOpe(contratoVo.getConFechaCitFirOpe());
        siiContrato.setConFechaFirColj(contratoVo.getConFechaFirColj());
        siiContrato.setConFechaFirOpe(contratoVo.getConFechaFirOpe());
        siiContrato.setConFechaPrgFirOpe(contratoVo.getConFechaPrgFirOpe());
        siiContrato.setConFechaRegistro(contratoVo.getConFechaRegistro());
        siiContrato.setConFechaRevAbog(contratoVo.getConFechaRevAbog());
        siiContrato.setConTextoValFinan(contratoVo.getConTextoValFinan());
        siiContrato.setConTextoValGct(contratoVo.getConTextoValGct());
        siiContrato.setConPermiso(contratoVo.getConPermiso());
        siiContrato.setConTextoValCca(contratoVo.getConTextoValCca());
        siiContrato.setConFechaCesion(contratoVo.getConFechaCesion());
        siiContrato.setConValorEstimado(contratoVo.getConValorEstimado());
        siiContrato.setConFechaFinDefin(contratoVo.getConFechaFinDefin());

        if (contratoVo.getEstadoContratoVo() != null) {
            SiiEstadoContrato unSiiEstadoContrato =
                estadoContratoDao.buscarEstadoContratoPorId(contratoVo.getEstadoContratoVo().getEcoCodigo());
            siiContrato.setSiiEstadoContrato(unSiiEstadoContrato);
        }

        if (contratoVo.getOperadorVo() != null) {
            SiiOperador unSiiOperador = operadorDao.buscarPorCodigoOperador(contratoVo.getOperadorVo().getOpeCodigo());
            siiContrato.setSiiOperador(unSiiOperador);
        }

        if (contratoVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico unArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(contratoVo.getArchivoFisicoVo().getAfiCodigo());
            siiContrato.setSiiArchivoFisico(unArchivoFisico);
        }

        if (contratoVo.getContratoCedenteVo() != null) {
            SiiContrato unSiiContrato = contratoDao.buscarContratoPorId(contratoVo.getContratoCedenteVo().getConCodigo());
            siiContrato.setSiiContratoCedente(unSiiContrato);
        } 

        return siiContrato;


    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param conceptoGastoVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiConceptoGasto convertir(ConceptoGastoVO conceptoGastoVO) throws ExcepcionDAO {
        SiiConceptoGasto siiConceptoGasto = new SiiConceptoGasto();

        // realizar la busqueda por codigo
        if (conceptoGastoVO.getCgaCodigo() != null && conceptoGastoVO.getCgaCodigo() > 0) {
            siiConceptoGasto = conceptoGastoDao.buscarPorCodigo(conceptoGastoVO.getCgaCodigo());
        }

        siiConceptoGasto.setCgaCodigo(conceptoGastoVO.getCgaCodigo());
        siiConceptoGasto.setCgaCodigoSiicol(conceptoGastoVO.getCgaCodigoSiicol());
        siiConceptoGasto.setCgaModulo(conceptoGastoVO.getCgaModulo());
        siiConceptoGasto.setCgaNombre(conceptoGastoVO.getCgaNombre());


        if (conceptoGastoVO.getComprobAsociado() != null) {
            SiiComprobAsociado siiComprobAsociado =
                comprobAsociadoDao.buscarComprobAsociadoPorId(conceptoGastoVO.getComprobAsociado().getCasCodigo());
            siiConceptoGasto.setSiiComprobAsociado(siiComprobAsociado);
        }


        if (conceptoGastoVO.getCuentasContablesCred() != null &&
            conceptoGastoVO.getCuentasContablesCred().getCcoCodigo() != null) {
            SiiCuentasContables siiCuentasContables =
                cuentasContablesDao.buscarPorCodigo(conceptoGastoVO.getCuentasContablesCred().getCcoCodigo());
            siiConceptoGasto.setSiiCuentasContablesCred(siiCuentasContables);
        }

        if (conceptoGastoVO.getCuentasContablesDeb() != null &&
            conceptoGastoVO.getCuentasContablesDeb().getCcoCodigo() != null) {
            SiiCuentasContables siiCuentasContables =
                cuentasContablesDao.buscarPorCodigo(conceptoGastoVO.getCuentasContablesDeb().getCcoCodigo());
            siiConceptoGasto.setSiiCuentasContablesDeb(siiCuentasContables);
        }


        return siiConceptoGasto;
    }

    public SiiPlanContratacion convertir(PlanContratacionVO planContratacionVo) throws ExcepcionDAO {
        SiiPlanContratacion siiPlanContratacion = new SiiPlanContratacion();
        if (planContratacionVo.getPcnCodigo() != null && planContratacionVo.getPcnCodigo() > 0) {
            siiPlanContratacion = planContratacionDao.buscarPlanContratacionPorId(planContratacionVo.getPcnCodigo());
        }
        siiPlanContratacion.setPcnCodigo(planContratacionVo.getPcnCodigo());
        siiPlanContratacion.setPcnVigencia(planContratacionVo.getPcnVigencia());
        return siiPlanContratacion;
    }

    public SiiTipoInstrumento convertir(TipoInstrumentoVO tipoInstrumentoVo) throws ExcepcionDAO {
        SiiTipoInstrumento siiTipoInstrumento = new SiiTipoInstrumento();
        if (tipoInstrumentoVo.getTinCodigo() != null && tipoInstrumentoVo.getTinCodigo() > 0) {
            siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(tipoInstrumentoVo.getTinCodigo());
        }
        siiTipoInstrumento.setTinCodigo(tipoInstrumentoVo.getTinCodigo());
        siiTipoInstrumento.setTinNombre(tipoInstrumentoVo.getTinNombre());

        return siiTipoInstrumento;
    }

    public SiiMarca convertir(MarcaVO marcaVo) throws ExcepcionDAO {
        SiiMarca siiMarca = new SiiMarca();
        if (marcaVo.getMarCodigo() != null && marcaVo.getMarCodigo() > 0) {
            siiMarca = marcaDao.buscarMarcaPorCodigo(marcaVo.getMarCodigo());
        }
        siiMarca.setMarCodigo(marcaVo.getMarCodigo());
        siiMarca.setMarNombre(marcaVo.getMarNombre());

        return siiMarca;
    }

    public SiiMet convertir(MetVO metVo) throws ExcepcionDAO {
        SiiMet siiMet = new SiiMet();
        if (metVo.getMetCodigo() != null && metVo.getMetCodigo() > 0) {
            siiMet = metDao.buscarPorCodigoMet(metVo.getMetCodigo());
        }
        siiMet.setMetCodigo(metVo.getMetCodigo());
        siiMet.setMetFechaFab(metVo.getMetFechaFab());
        siiMet.setMetFechaMarcOnline(metVo.getMetFechaMarcaOnline());
        siiMet.setMetHomologado(metVo.getMetHomologado());
        siiMet.setMetMarcaAnterior(metVo.getMetMarcaAnterior());
        siiMet.setMetModelo(metVo.getMetModelo());
        siiMet.setMetNuid(metVo.getMetNuid());
        siiMet.setMetOnline(metVo.getMetOnline());
        siiMet.setMetSerial(metVo.getMetSerial());
        siiMet.setMetUid(metVo.getMetUid());
        if (metVo.getMarcaVo() != null) {
            SiiMarca siiMarca = marcaDao.buscarMarcaPorCodigo(metVo.getMarcaVo().getMarCodigo());
            siiMet.setSiiMarca(siiMarca);
        }

        return siiMet;
    }

    public SiiJuegoMesa convertir(JuegoMesaVO juegoMesaVo) throws ExcepcionDAO {
        SiiJuegoMesa siiJuegoMesa = new SiiJuegoMesa();
        if (juegoMesaVo.getJmeCodigo() != null && juegoMesaVo.getJmeCodigo() > 0) {
            siiJuegoMesa = juegoMesaDao.buscarJuegoMesaPorCodigo(juegoMesaVo.getJmeCodigo());
        }
        siiJuegoMesa.setJmeCodigo(juegoMesaVo.getJmeCodigo());
        siiJuegoMesa.setJmeNombre(juegoMesaVo.getJmeNombre());

        return siiJuegoMesa;
    }

    public SiiMesaCasino convertir(MesaCasinoVO mesaCasinoVo) throws ExcepcionDAO {
        SiiMesaCasino siiMesaCasino = new SiiMesaCasino();
        if (mesaCasinoVo.getMcaCodigo() != null && mesaCasinoVo.getMcaCodigo() > 0) {
            siiMesaCasino = mesaCasinoDao.buscarPorCodigoMesaCasino(mesaCasinoVo.getMcaCodigo());
        }
        siiMesaCasino.setMcaCodigo(mesaCasinoVo.getMcaCodigo());
        if (mesaCasinoVo.getJuegoMesa() != null) {
            SiiJuegoMesa siiJuegoMesa =
                juegoMesaDao.buscarJuegoMesaPorCodigo(mesaCasinoVo.getJuegoMesa().getJmeCodigo());
            siiMesaCasino.setSiiJuegoMesa(siiJuegoMesa);
        }

        return siiMesaCasino;
    }

    public SiiInstrumento convertir(InstrumentoVO instrumentoVo) throws ExcepcionDAO {
        SiiInstrumento siiInstrumento = new SiiInstrumento();
        if (instrumentoVo.getInsCodigo() != null && instrumentoVo.getInsCodigo() > 0) {
            siiInstrumento = instrumentoDao.buscarPorCodigoInstrumento(instrumentoVo.getInsCodigo());
        }

        siiInstrumento.setInsFechaModific(instrumentoVo.getInsFechaModific());
        siiInstrumento.setInsFechaRegistro(instrumentoVo.getInsFechaRegistro());

        if (instrumentoVo.getMesaCasino() != null) {
            SiiMesaCasino siiMesaCasino =
                mesaCasinoDao.buscarPorCodigoMesaCasino(instrumentoVo.getMesaCasino().getMcaCodigo());
            siiInstrumento.setSiiMesaCasino(siiMesaCasino);
        }
        if (instrumentoVo.getMetVo() != null) {
            SiiMet siiMet = metDao.buscarPorCodigoMet(instrumentoVo.getMetVo().getMetCodigo());
            siiInstrumento.setSiiMet(siiMet);
        }
        if (instrumentoVo.getOperadorVo() != null) {
            SiiOperador siiOperador = operadorDao.buscarPorCodigoOperador(instrumentoVo.getOperadorVo().getOpeCodigo());
            siiInstrumento.setSiiOperador1(siiOperador);
        }
        if (instrumentoVo.getTipoInstrumentoVo() != null) {
            SiiTipoInstrumento siiTipoInstrumento =
                tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(instrumentoVo.getTipoInstrumentoVo().getTinCodigo());
            siiInstrumento.setSiiTipoInstrumento(siiTipoInstrumento);
        }

        siiInstrumento.setTapCodigo(instrumentoVo.getTapCodigo());
        return siiInstrumento;
    }

    public SiiTipoApuesta convertir(TipoApuestaVO tipoApuestaVo) throws ExcepcionDAO {
        SiiTipoApuesta siiTipoApuesta = new SiiTipoApuesta();
        if (siiTipoApuesta.getTapCodigo() != null && siiTipoApuesta.getTapCodigo() > 0) {
            siiTipoApuesta = tipoApuestaDao.buscarTipoApuestaPorCodigo(siiTipoApuesta.getTapCodigo());
        }
        siiTipoApuesta.setTapCodigo(siiTipoApuesta.getTapCodigo());
        siiTipoApuesta.setTapCodigoApuesta(tipoApuestaVo.getTapCodigoApuesta());
        siiTipoApuesta.setTapDerExplFormula(tipoApuestaVo.getTapDerExplFormula());
        siiTipoApuesta.setTapDerechosExpl(tipoApuestaVo.getTapDerechosExpl());
        siiTipoApuesta.setTapGastAdmFormula(tipoApuestaVo.getTapGastAdmFormula());
        siiTipoApuesta.setTapGastosAdm(tipoApuestaVo.getTapGastosAdm());
        siiTipoApuesta.setTapNombre(tipoApuestaVo.getTapNombre());
        if (tipoApuestaVo.getTipoJuego() != null) {
            SiiTipoJuego siiTipoJuego = tipoJuegoDao.buscarPorCodigo(tipoApuestaVo.getTipoJuego().getTjuCodigo());
            siiTipoApuesta.setSiiTipoJuego(siiTipoJuego);
        }
        if (tipoApuestaVo.getClaseJuego() != null) {
            SiiClaseJuego siiClaseJuego =
                claseJuegoDao.buscarClaseJuegoPorId(tipoApuestaVo.getClaseJuego().getCjuCodigo());
            siiTipoApuesta.setSiiClaseJuego(siiClaseJuego);
        }
        return siiTipoApuesta;
    }

    public SiiContratoProveedor convertir(ContratoProveedorVO contratoProveerdorVo) throws ExcepcionDAO {
        SiiContratoProveedor siiContratoProveedor = new SiiContratoProveedor();
        if (siiContratoProveedor.getCprCodigo() != null) {
            siiContratoProveedor =
                contratoProveedorDao.buscarContratoProveedorPorId(siiContratoProveedor.getCprCodigo());
        }
        siiContratoProveedor.setCprCodigo(contratoProveerdorVo.getCprCodigo());
        siiContratoProveedor.setCprFecha(contratoProveerdorVo.getCprFecha());
        siiContratoProveedor.setCprValor(contratoProveerdorVo.getCprValor());


        if (contratoProveerdorVo.getEstadoContrProvVo() != null) {
            SiiEstadoContrProv siiEstadoContrProv =
                estadoContrProvDao.buscarEstadoContrProvPorId(contratoProveerdorVo.getEstadoContrProvVo().getEcpCodigo());
            siiContratoProveedor.setSiiEstadoContrProv(siiEstadoContrProv);
        }
        if (contratoProveerdorVo.getOficioAdjudicaVo() != null) {
            SiiOficioAdjudica siiOficioAdjudica =
                oficioAdjudicaDao.buscarPorCodigo(contratoProveerdorVo.getOficioAdjudicaVo().getOadCodigo());
            siiContratoProveedor.setSiiOficioAdjudica(siiOficioAdjudica);
        }
        if (contratoProveerdorVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(contratoProveerdorVo.getArchivoFisicoVo().getAfiCodigo());
            siiContratoProveedor.setSiiArchivoFisico(siiArchivoFisico);
        }
        return siiContratoProveedor;
    }

    public SiiEstadoContrProv convertir(EstadoContrProvVO estadoContrProvVo) throws ExcepcionDAO {
        SiiEstadoContrProv siiEstadoContrProv = new SiiEstadoContrProv();
        if (siiEstadoContrProv.getEcpCodigo() != null) {
            siiEstadoContrProv = estadoContrProvDao.buscarEstadoContrProvPorId(siiEstadoContrProv.getEcpCodigo());
        }
        siiEstadoContrProv.setEcpCodigo(siiEstadoContrProv.getEcpCodigo());
        siiEstadoContrProv.setEcpNombre(siiEstadoContrProv.getEcpNombre());

        return siiEstadoContrProv;
    }


    public SiiRecaudoBanco convertir(PagoOperadoresVO pagoOperadoresVo) throws ExcepcionDAO {
        SiiRecaudoBanco siiRecaudoBanco = new SiiRecaudoBanco();
        if (pagoOperadoresVo.getOpeCodigo() != null) {
            siiRecaudoBanco = recaudoBancoDao.buscarRecaudoBancoXId(pagoOperadoresVo.getOpeCodigo());
        }

        siiRecaudoBanco.setRbaFechaRec(pagoOperadoresVo.getOpeFechaRecaudo());
        siiRecaudoBanco.setRbaNumCuenta(pagoOperadoresVo.getOpeNumeroCuenta());
        siiRecaudoBanco.setRbaOrdenDia(pagoOperadoresVo.getOpeOrdenDia());
        siiRecaudoBanco.setRbaFechaArchivo(pagoOperadoresVo.getOpeFechaArchivo());

        //padres
        if (pagoOperadoresVo.getBancoVo() != null) {
            SiiBanco siibanco = bancoDao.buscarBancoXId(pagoOperadoresVo.getBancoVo().getBanCodigo());
            siiRecaudoBanco.setSiiBanco(siibanco);
        }

        if (pagoOperadoresVo.getTipoCuentaVo() != null) {
            SiiTipoCuenta siiTipoCuenta =
                tipoCuentaDao.buscarTipoCuentaXId(pagoOperadoresVo.getTipoCuentaVo().getTcuCodigo());
            siiRecaudoBanco.setSiiTipoCuenta(siiTipoCuenta);
        }
        if (pagoOperadoresVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(pagoOperadoresVo.getArchivoFisicoVo().getAfiCodigo());
            siiRecaudoBanco.setSiiArchivoFisico(siiArchivoFisico);
        }

        return siiRecaudoBanco;

    }

    public SiiDetalleRecaudo convertir(DetalleRecaudoVO detalleRecaudoVo) throws ExcepcionDAO {
        SiiDetalleRecaudo siiDetalleRecaudo = new SiiDetalleRecaudo();

        if (detalleRecaudoVo.getDreCodigo() != null) {
            siiDetalleRecaudo = detalleRecaudoDao.buscarPorCodigo(detalleRecaudoVo.getDreCodigo());
        }
        siiDetalleRecaudo.setDreEstado(detalleRecaudoVo.getDreEstado());
        siiDetalleRecaudo.setDreNumAutoriza((detalleRecaudoVo.getDreNumeroAutorizacion()).intValue());
        siiDetalleRecaudo.setDreNumOperac((detalleRecaudoVo.getDreNumeroOperacion()).intValue());
        siiDetalleRecaudo.setDreRefPago(detalleRecaudoVo.getDreRefPago());
        siiDetalleRecaudo.setDreSecuencia((detalleRecaudoVo.getDreSecuencia()).intValue());
        siiDetalleRecaudo.setDreSucursal(detalleRecaudoVo.getDreSucursal());
        siiDetalleRecaudo.setDreValor(detalleRecaudoVo.getDreValor());
        //Padres
        if (detalleRecaudoVo.getBancoVo() != null) {
            SiiBanco siiBanco = bancoDao.buscarBancoXId(detalleRecaudoVo.getBancoVo().getBanCodigo());
            siiDetalleRecaudo.setSiiBanco(siiBanco);
        }
        if (detalleRecaudoVo.getMedioPagoVo() != null) {
            SiiMedioPago siiMedioPago =
                medioPagoDao.buscarMedioPagoXId(detalleRecaudoVo.getMedioPagoVo().getMepCodigo());
            siiDetalleRecaudo.setSiiMedioPago(siiMedioPago);
        }
        if (detalleRecaudoVo.getPagoOperadoresVo() != null) {
            SiiRecaudoBanco siiRecaudoBanco =
                recaudoBancoDao.buscarRecaudoBancoXId(detalleRecaudoVo.getPagoOperadoresVo().getOpeCodigo());
            siiDetalleRecaudo.setSiiRecaudoBanco(siiRecaudoBanco);
        }

        if (detalleRecaudoVo.getProcedenciaPagoVo() != null) {
            SiiProcedenciaPago siiProcedenciaPago =
                procedenciaPagoDao.buscarProcedenciaPagoXId((detalleRecaudoVo.getProcedenciaPagoVo().getPpaCodigo()) +
                                                            "");
            siiDetalleRecaudo.setSiiProcedenciaPago(siiProcedenciaPago);
        }

        return siiDetalleRecaudo;

    }

    public SiiOficioLiquidacion convertir(OficioLiquidacionVO oficioLiquidacionVo) throws ExcepcionDAO {
        SiiOficioLiquidacion siiOficioLiquidacion = new SiiOficioLiquidacion();
        if (oficioLiquidacionVo.getOliCodigo() != null) {
            siiOficioLiquidacion =
                oficioLiquidacionDao.buscarPorCodigoOficioLiquidacion(oficioLiquidacionVo.getOliCodigo());
        }
        siiOficioLiquidacion.setOliCodigo(oficioLiquidacionVo.getOliCodigo());
        siiOficioLiquidacion.setOliConsecutivo(oficioLiquidacionVo.getOliConsecutivo());
        siiOficioLiquidacion.setOliFechaOficio(oficioLiquidacionVo.getOliFechaOficio());
        siiOficioLiquidacion.setOliValorDerExpl(oficioLiquidacionVo.getOliValorDerExpl());
        siiOficioLiquidacion.setOliValorGastAdm(oficioLiquidacionVo.getOliValorGastAdm());

        if (oficioLiquidacionVo.getEstadoOficioLiqVo() != null) {
            SiiEstadoOficioLiq siiEstadoOficioLiq =
                estadoOficioLiqDao.buscarPorCodigo(oficioLiquidacionVo.getEstadoOficioLiqVo().getEolCodigo());
            siiOficioLiquidacion.setSiiEstadoOficioLiq(siiEstadoOficioLiq);
        }
        if (oficioLiquidacionVo.getSolicitudAutorizaVo() != null) {
            SiiSolicitudAutoriza siiSolicitudAutoriza =
                solicitudAutorizaDao.buscarSolicitudAutorizacionPorCodigo(oficioLiquidacionVo.getSolicitudAutorizaVo().getSauCodigo());
            siiOficioLiquidacion.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
        }

        return siiOficioLiquidacion;
    }

    public SiiOficLiqTipoApuesta convertir(OficLiqTipoApuestaVO oficLiqTipoApuestaVo) throws ExcepcionDAO {
        SiiOficLiqTipoApuesta siiOficLiqTipoApuesta = new SiiOficLiqTipoApuesta();
        if (oficLiqTipoApuestaVo.getOtaCodigo() != null) {
            siiOficLiqTipoApuesta =
                oficLiqTipoApuestaDao.buscarOficLiqTipoApuestaPorCodigo(oficLiqTipoApuestaVo.getOtaCodigo());
        }
        siiOficLiqTipoApuesta.setOtaCodigo(oficLiqTipoApuestaVo.getOtaCodigo());
        siiOficLiqTipoApuesta.setOtaDerExplMes(oficLiqTipoApuestaVo.getOtaDerExplMes());
        siiOficLiqTipoApuesta.setOtaGasAdmin(oficLiqTipoApuestaVo.getOtaGasAdmin());
        siiOficLiqTipoApuesta.setOtaNumElem(oficLiqTipoApuestaVo.getOtaNumElem());
        siiOficLiqTipoApuesta.setOtaValorUnidad(oficLiqTipoApuestaVo.getOtaValorUnidad());
        siiOficLiqTipoApuesta.setOtaIndicadorLiq(oficLiqTipoApuestaVo.getOtaIndicadorLiq());

        if (oficLiqTipoApuestaVo.getOficioLiquidacionVo() != null) {
            SiiOficioLiquidacion siiOficioLiquidacion =
                oficioLiquidacionDao.buscarPorCodigoOficioLiquidacion(oficLiqTipoApuestaVo.getOficioLiquidacionVo().getOliCodigo());
            siiOficLiqTipoApuesta.setSiiOficioLiquidacion(siiOficioLiquidacion);
        }
        if (oficLiqTipoApuestaVo.getTipoApuestaVo() != null) {
            SiiTipoApuesta siiTipoApuesta =
                tipoApuestaDao.buscarTipoApuestaPorCodigo(oficLiqTipoApuestaVo.getTipoApuestaVo().getTapCodigo());
            siiOficLiqTipoApuesta.setSiiTipoApuesta(siiTipoApuesta);
        }

        return siiOficLiqTipoApuesta;
    }

    /**
     * @author Modifica Giovanni
     * @param polizaContratVo
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPolizaContrat convertir(PolizaContratVO polizaContratVo) throws ExcepcionDAO {
        SiiPolizaContrat polizaContrat = new SiiPolizaContrat();
        if (polizaContratVo.getPccCodigo() != null) {
            polizaContrat = polizaContratDao.buscarPolizaContratPorCodigo(polizaContratVo.getPccCodigo());
        }
        polizaContrat.setPccCodigo(polizaContratVo.getPccCodigo());
        polizaContrat.setPccFechaExped(polizaContratVo.getPccFechaExped());
        polizaContrat.setPccFechaRecep(polizaContratVo.getPccFechaRecep());
        polizaContrat.setPccNumero(polizaContratVo.getPccNumero());
        polizaContrat.setPccObservaciones(polizaContratVo.getPccObservaciones());
        polizaContrat.setPccContratoNue(polizaContratVo.getPccContratoNue());
        polizaContrat.setPccRenovacion(polizaContratVo.getPccRenovacion());
        polizaContrat.setPccFechaAprobac(polizaContratVo.getPccFechaAprobac());
        polizaContrat.setPccFechaIniOpera(polizaContratVo.getPccFechaIniOpera());
        polizaContrat.setPccRadicado(polizaContratVo.getPccRadicado());
        polizaContrat.setPccFechaRadicado(polizaContratVo.getPccFechaRadicado());
        polizaContrat.setPccTiempoEjecCon(polizaContratVo.getPccTiempoEjecCon());

        //Padres:
        if (polizaContratVo.getArchivoFisicoVO() != null &&
            polizaContratVo.getArchivoFisicoVO().getAfiCodigo() != null) {
            SiiArchivoFisico archivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(polizaContratVo.getArchivoFisicoVO().getAfiCodigo());
            polizaContrat.setSiiArchivoFisico(archivoFisico);
        }
        if (polizaContratVo.getAseguradoraVO() != null) {
            SiiAseguradora aseguradora =
                aseguradoraDao.buscarAseguradoraPorCodigo(polizaContratVo.getAseguradoraVO().getAseCodigo());
            polizaContrat.setSiiAseguradora(aseguradora);
        }
        if (polizaContratVo.getContratoVO() != null) {
            SiiContrato contrato = contratoDao.buscarContratoPorId(polizaContratVo.getContratoVO().getConCodigo());
            polizaContrat.setSiiContrato(contrato);
        }
        if (polizaContratVo.getEstadoPolizaContVO() != null) {
            SiiEstadoPolizaCont estado =
                estadoPolizaContDao.buscarEstadoPolizaContPorId(polizaContratVo.getEstadoPolizaContVO().getEpoCodigo());
            polizaContrat.setSiiEstadoPolizaCont(estado);
        }
        //OtroSi
        if (polizaContratVo.getOtroSiVO() != null) {
            SiiOtrosi siiOtrosi = otroSiDao.buscarOtroSiPorId(polizaContratVo.getOtroSiVO().getOsiCodigo());
            polizaContrat.setSiiOtrosi(siiOtrosi);
        }
        return polizaContrat;
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param fuenteFinancContabVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiFuenteFinancContab convertir(FuenteFinancContabVO fuenteFinancContabVO) throws ExcepcionDAO {
        SiiFuenteFinancContab siiFuenteFinancContab = new SiiFuenteFinancContab();
        // realizar la busqueda por codigo
        if (fuenteFinancContabVO.getFfcCodigo() != null && !fuenteFinancContabVO.getFfcCodigo().isEmpty()) {
            siiFuenteFinancContab = fuenteFinancContabDao.buscarPorCodigo(fuenteFinancContabVO.getFfcCodigo());
        }

        siiFuenteFinancContab.setFfcCodigo(fuenteFinancContabVO.getFfcCodigo());
        siiFuenteFinancContab.setFccNombre(fuenteFinancContabVO.getFccNombre());

        return siiFuenteFinancContab;
    }

    public SiiGarantiaPoliza convertir(GarantiaPolizaVO garantiaPolizaVo) throws ExcepcionDAO {
        SiiGarantiaPoliza garantiaPoliza = new SiiGarantiaPoliza();
        if (garantiaPolizaVo.getGpoCodigo() != null) {
            garantiaPoliza = garantiaPolizaDao.buscarGarantiaPolizaPorCodigo(garantiaPolizaVo.getGpoCodigo());
        }
        garantiaPoliza.setGpoCodigo(garantiaPolizaVo.getGpoCodigo());
        garantiaPoliza.setGpoMontoValor(garantiaPolizaVo.getGpoMontoValor());
        garantiaPoliza.setGpoValorAsegurado(garantiaPolizaVo.getGpoValorAsegurado());
        garantiaPoliza.setGpoVigenciaDesde(garantiaPolizaVo.getGpoVigenciaDesde());
        garantiaPoliza.setGpoVigenciaHasta(garantiaPolizaVo.getGpoVigenciaHasta());
        garantiaPoliza.setGpoAntValAsegurado(garantiaPolizaVo.getGpoAntValAsegurado());
        garantiaPoliza.setGpoAntVigenciaDesde(garantiaPolizaVo.getGpoAntVigenciaDesde());
        garantiaPoliza.setGpoAntVigenciaHasta(garantiaPolizaVo.getGpoAntVigenciaHasta());
        //Padres:
        if (garantiaPolizaVo.getGarantiaExigidaVo() != null) {
            SiiGarantiaExigida garantiaExigida =
                garantiaExigidaDao.buscarPorCodigo(garantiaPolizaVo.getGarantiaExigidaVo().getGexCodigo());
            garantiaPoliza.setSiiGarantiaExigida(garantiaExigida);
        }
        if (garantiaPolizaVo.getPolizaContratVo() != null) {
            SiiPolizaContrat polizaContrat =
                polizaContratDao.buscarPolizaContratPorCodigo(garantiaPolizaVo.getPolizaContratVo().getPccCodigo());
            garantiaPoliza.setSiiPolizaContrat(polizaContrat);
        }
        return garantiaPoliza;
    }

    public SiiOficInfPoliza convertir(OficInfPolizaVO oficioVo) throws ExcepcionDAO {
        SiiOficInfPoliza oficio = new SiiOficInfPoliza();
        if (oficioVo.getOipCodigo() != null) {
            oficio = oficInfPolizaDao.buscarOficInfPolizaPorCodigo(oficioVo.getOipCodigo());
        }
        oficio.setOipCodigo(oficioVo.getOipCodigo());
        oficio.setOipFechaRadic(oficioVo.getOipFechaRadic());
        oficio.setOipNumRadica(oficioVo.getOipNumRadica());
        oficio.setOipTipoDocum(oficioVo.getOipTipoDocum());
        //Padres:
        if (oficioVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico archivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(oficioVo.getArchivoFisicoVo().getAfiCodigo());
            oficio.setSiiArchivoFisico(archivoFisico);
        }
        if (oficioVo.getPolizaContratVo() != null) {
            SiiPolizaContrat polizaContrat =
                polizaContratDao.buscarPolizaContratPorCodigo(oficioVo.getPolizaContratVo().getPccCodigo());
            oficio.setSiiPolizaContrat(polizaContrat);
        }

        return oficio;
    }

    public SiiPolizaRequisitosPol convertir(PolizaRequisitosPolVO requisitoVo) throws ExcepcionDAO {
        SiiPolizaRequisitosPol requisito = new SiiPolizaRequisitosPol();
        if (requisitoVo.getPrpCodigo() != null) {
            requisito = polizaRequisitoDao.buscarPolizaRequisitosPolPorCodigo(requisitoVo.getPrpCodigo());
        }
        requisito.setPrpCodigo(requisitoVo.getPrpCodigo());
        requisito.setPrpCumple(requisitoVo.getPrpCumple());
        //Padres:
        if (requisitoVo.getPolizaContratVo() != null) {
            SiiPolizaContrat polizaContrat =
                polizaContratDao.buscarPolizaContratPorCodigo(requisitoVo.getPolizaContratVo().getPccCodigo());
            requisito.setSiiPolizaContrat(polizaContrat);
        }
        if (requisitoVo.getRequisitosPolizaConVo() != null) {
            SiiRequisitosPolizaCon requisitosPolizaCon =
                requisitosPolizaConDao.buscarRequisitosPolizaPorId(requisitoVo.getRequisitosPolizaConVo().getRpcCodigo());
            requisito.setSiiRequisitosPolizaCon(requisitosPolizaCon);
        }

        return requisito;
    }

    public SiiGarantPolizaOficLiq convertir(GarantPolizaOficLiqVO garantPolizaOficLiqVo) throws ExcepcionDAO {
        SiiGarantPolizaOficLiq siiGarantPolizaOficLiq = new SiiGarantPolizaOficLiq();
        if (garantPolizaOficLiqVo.getGolCodigo() != null) {
            siiGarantPolizaOficLiq =
                garantPolizaOficLiqDao.buscarGarantPolizaOficLiqPorCodigo(garantPolizaOficLiqVo.getGolCodigo());
        }
        siiGarantPolizaOficLiq.setGolCodigo(garantPolizaOficLiqVo.getGolCodigo());
        siiGarantPolizaOficLiq.setGolDescripcion(garantPolizaOficLiqVo.getGolDescripcion());
        siiGarantPolizaOficLiq.setGolValorAmparo(garantPolizaOficLiqVo.getGolValorAmparo());
        if (garantPolizaOficLiqVo.getGarantiaExigidaVo() != null) {
            SiiGarantiaExigida siiGarantiaExigida =
                garantiaExigidaDao.buscarPorCodigo(garantPolizaOficLiqVo.getGarantiaExigidaVo().getGexCodigo());
            siiGarantPolizaOficLiq.setSiiGarantiaExigida(siiGarantiaExigida);
        }
        if (garantPolizaOficLiqVo.getOficioLiquidacionVo() != null) {
            SiiOficioLiquidacion siiOficioLiquidacion =
                oficioLiquidacionDao.buscarPorCodigoOficioLiquidacion(garantPolizaOficLiqVo.getOficioLiquidacionVo().getOliCodigo());
            siiGarantPolizaOficLiq.setSiiOficioLiquidacion(siiOficioLiquidacion);
        }

        return siiGarantPolizaOficLiq;
    }

    public SiiPolizaContProv convertir(PolizaContProvVO polizaContProvVo) throws ExcepcionDAO {
        SiiPolizaContProv siiPolizaContProv = new SiiPolizaContProv();
        if (polizaContProvVo.getPcpCodigo() != null && polizaContProvVo.getPcpCodigo() > 0) {
            siiPolizaContProv = polizaConrProvDao.buscarPolizaContProvPorId(polizaContProvVo.getPcpCodigo());
        }
        siiPolizaContProv.setPcpCodigo(polizaContProvVo.getPcpCodigo());
        siiPolizaContProv.setPcpEstado(polizaContProvVo.getPcpEstado());
        siiPolizaContProv.setPcpFechaExped(polizaContProvVo.getPcpFechaExped());
        siiPolizaContProv.setPcpFechaRecep(polizaContProvVo.getPcpFechaRecep());
        siiPolizaContProv.setPcpNumero(polizaContProvVo.getPcpNumero());
        siiPolizaContProv.setPcpFechaAprob(polizaContProvVo.getPcpFechaAprob());
        //padres
        if (polizaContProvVo.getAseguradoraVo() != null) {
            SiiAseguradora siiAseguradora =
                aseguradoraDao.buscarAseguradoraPorCodigo(polizaContProvVo.getAseguradoraVo().getAseCodigo());
            siiPolizaContProv.setSiiAseguradora(siiAseguradora);
        }
        if (polizaContProvVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(polizaContProvVo.getArchivoFisicoVo().getAfiCodigo());
            siiPolizaContProv.setSiiArchivoFisico(siiArchivoFisico);
        }
        if (polizaContProvVo.getProcesoContratacionVo() != null) {
            SiiProcesoContratacion siiProcesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(polizaContProvVo.getProcesoContratacionVo().getPrcCodigo());
            siiPolizaContProv.setSiiProcesoContratacion(siiProcesoContratacion);
        }
        return siiPolizaContProv;
    }


    public SiiAmparoPolContProv convertir(AmparoPolContProvVO amparoPolContProvVo) throws ExcepcionDAO {
        SiiAmparoPolContProv siiAmparoPolContProv = new SiiAmparoPolContProv();
        if (siiAmparoPolContProv.getApcCodigo() != null && siiAmparoPolContProv.getApcCodigo() > 0) {
            siiAmparoPolContProv =
                amparoPolContProvDao.buscarAmparoPolContProvPorId(amparoPolContProvVo.getApcCodigo());
        }
        siiAmparoPolContProv.setApcValorAseg(amparoPolContProvVo.getApcValorAseg());
        siiAmparoPolContProv.setApcCodigo(amparoPolContProvVo.getApcCodigo());
        siiAmparoPolContProv.setApcVigenciaDes(amparoPolContProvVo.getApcVigenciaDes());
        siiAmparoPolContProv.setApcVigenciaHas(amparoPolContProvVo.getApcVigenciaHas());

        //Padres
        if (amparoPolContProvVo.getPolizaContProvVo() != null) {
            SiiPolizaContProv siiPolizaContProv =
                polizaContProvDao.buscarPolizaContProvPorId(amparoPolContProvVo.getPolizaContProvVo().getPcpCodigo());
            siiAmparoPolContProv.setSiiPolizaContProv(siiPolizaContProv);
        }
        if (amparoPolContProvVo.getTipoAmparoVo() != null) {
            SiiTipoAmparo siiTipoAmparo =
                tipoAmparoDao.buscarTipoAmparoPorId(amparoPolContProvVo.getTipoAmparoVo().getTamCodigo());
            siiAmparoPolContProv.setSiiTipoAmparo(siiTipoAmparo);
        }
        return siiAmparoPolContProv;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param conceptoRetenVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiConceptoReten convertir(ConceptoRetenVO conceptoRetenVO) throws ExcepcionDAO {
        SiiConceptoReten siiConceptoReten = new SiiConceptoReten();
        // realizar la busqueda por codigo
        if (conceptoRetenVO.getCreCodigo() != null && conceptoRetenVO.getCreCodigo() > 0) {
            siiConceptoReten = conceptoRetenDao.buscarPorCodigo(conceptoRetenVO.getCreCodigo());
        }

        siiConceptoReten.setCreCodigo(conceptoRetenVO.getCreCodigo());
        siiConceptoReten.setCreNombre(conceptoRetenVO.getCreNombre());

        return siiConceptoReten;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tipoRetencionVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTipoRetencion convertir(TipoRetencionVO tipoRetencionVO) throws ExcepcionDAO {
        SiiTipoRetencion siiTipoRetencion = new SiiTipoRetencion();
        // realizar la busqueda por codigo
        if (tipoRetencionVO.getTreCodigo() != null && !tipoRetencionVO.getTreCodigo().isEmpty()) {
            siiTipoRetencion = tipoRetencionDao.buscarPorCodigo(tipoRetencionVO.getTreCodigo());
        }
        if (siiTipoRetencion == null) {
            siiTipoRetencion = new SiiTipoRetencion();
        }
        siiTipoRetencion.setTreCodigo(tipoRetencionVO.getTreCodigo());
        siiTipoRetencion.setTreNomClasific(tipoRetencionVO.getTreNomClasific());
        siiTipoRetencion.setTreObservaciones(tipoRetencionVO.getTreObservaciones());
        siiTipoRetencion.setTreRenglon(tipoRetencionVO.getTreRenglon());
        siiTipoRetencion.setTreTarifa(tipoRetencionVO.getTreTarifa());
        siiTipoRetencion.setTreBaseUvt(tipoRetencionVO.getTreBaseUvt());

        if (tipoRetencionVO.getConceptoReten() != null) {
            SiiConceptoReten siiConceptoReten =
                conceptoRetenDao.buscarPorCodigo(tipoRetencionVO.getConceptoReten().getCreCodigo());
            siiTipoRetencion.setSiiConceptoReten(siiConceptoReten);
        }

        if (tipoRetencionVO.getCuentasContables() != null) {
            SiiCuentasContables siiCuentasContables =
                cuentasContablesDao.buscarPorCodigo(tipoRetencionVO.getCuentasContables().getCcoCodigo());
            siiTipoRetencion.setSiiCuentasContables(siiCuentasContables);
        }

        if (tipoRetencionVO.getGrupoRetenc() != null) {
            SiiGrupoRetenc siiGrupoRetenc =
                grupoRetencDao.buscarPorCodigo(tipoRetencionVO.getGrupoRetenc().getGreCodigo());
            siiTipoRetencion.setSiiGrupoRetenc(siiGrupoRetenc);
        }

        return siiTipoRetencion;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param concepInfExogenaVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiConcepInfExogena convertir(ConcepInfExogenaVO concepInfExogenaVO) throws ExcepcionDAO {
        SiiConcepInfExogena siiConcepInfExogena = new SiiConcepInfExogena();
        // realizar la busqueda por codigo
        if (concepInfExogenaVO.getCieCodigo() != null && concepInfExogenaVO.getCieCodigo() > 0) {
            siiConcepInfExogena = concepInfExogenaDao.buscarPorCodigo(concepInfExogenaVO.getCieCodigo());
        }

        siiConcepInfExogena.setCieCodigo(concepInfExogenaVO.getCieCodigo());
        siiConcepInfExogena.setCieNombre(concepInfExogenaVO.getCieNombre());

        return siiConcepInfExogena;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param imputacionContableVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiImputacionContable convertir(ImputacionContableVO imputacionContableVO) throws ExcepcionDAO {
        SiiImputacionContable siiImputacionContable = new SiiImputacionContable();
        // realizar la busqueda por codigo
        if (imputacionContableVO.getImcCodigo() != null && imputacionContableVO.getImcCodigo() > 0) {
            siiImputacionContable = imputacionContableDao.buscarPorCodigo(imputacionContableVO.getImcCodigo());
        }

        siiImputacionContable.setImcCodigo(imputacionContableVO.getImcCodigo());
        siiImputacionContable.setImcConcepto(imputacionContableVO.getImcConcepto());
        siiImputacionContable.setImcDescrOperacion(imputacionContableVO.getImcDescrOperacion());
        siiImputacionContable.setImcReferencia1(imputacionContableVO.getImcReferencia1());
        siiImputacionContable.setImcReferencia2(imputacionContableVO.getImcReferencia2());
        siiImputacionContable.setImcTipoMovim(imputacionContableVO.getImcTipoMovim());
        siiImputacionContable.setImcValor(imputacionContableVO.getImcValor());
        siiImputacionContable.setImcEstado(imputacionContableVO.getImcEstado());

        if (imputacionContableVO.getDocumentoContableVo() != null &&
            imputacionContableVO.getDocumentoContableVo().getDcoCodigo() != null) {
            SiiDocumentoContable siiDocumentoContable =
                documentoContableDao.buscarPorCodigo(imputacionContableVO.getDocumentoContableVo().getDcoCodigo());
            siiImputacionContable.setSiiDocumentoContable(siiDocumentoContable);

        }

        if (imputacionContableVO.getFuenteFinancContabVo() != null) {
            SiiFuenteFinancContab siiFuenteFinancContab =
                fuenteFinancContabDao.buscarPorCodigo(imputacionContableVO.getFuenteFinancContabVo().getFfcCodigo());
            siiImputacionContable.setSiiFuenteFinancContab(siiFuenteFinancContab);
        }

        if (imputacionContableVO.getAreaColjuegosVo() != null) {
            SiiAreaColjuegos siiAreaColjuegos =
                areaColjuegosDao.buscarAreaColjuegosPorId(imputacionContableVO.getAreaColjuegosVo().getAcoCodigo());
            siiImputacionContable.setSiiAreaColjuegos(siiAreaColjuegos);
        }

        if (imputacionContableVO.getConcepInfExogenaVo() != null) {
            SiiConcepInfExogena siiConcepInfExogena =
                concepInfExogenaDao.buscarPorCodigo(imputacionContableVO.getConcepInfExogenaVo().getCieCodigo());
            siiImputacionContable.setSiiConcepInfExogena(siiConcepInfExogena);
        }

        if (imputacionContableVO.getCuentasContablesVo() != null) {
            SiiCuentasContables siiCuentasContables =
                cuentasContablesDao.buscarPorCodigo(imputacionContableVO.getCuentasContablesVo().getCcoCodigo());
            siiImputacionContable.setSiiCuentasContables(siiCuentasContables);
        }

        if (imputacionContableVO.getPersonaVo() != null) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(imputacionContableVO.getPersonaVo().getPerCodigo());
            siiImputacionContable.setSiiPersona(siiPersona);
        }

        return siiImputacionContable;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tipoDocContableVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTipoDocContable convertir(TipoDocContableVO tipoDocContableVO) throws ExcepcionDAO {
        SiiTipoDocContable siiTipoDocContable = new SiiTipoDocContable();
        // realizar la busqueda por codigo
        if (tipoDocContableVO.getTdcCodigo() != null && !tipoDocContableVO.getTdcCodigo().isEmpty()) {
            siiTipoDocContable = tipoDocContableDao.buscarPorCodigo(tipoDocContableVO.getTdcCodigo());
        }
        if (siiTipoDocContable == null) {
            siiTipoDocContable = new SiiTipoDocContable();
        }

        siiTipoDocContable.setTdcCodigo(tipoDocContableVO.getTdcCodigo());
        siiTipoDocContable.setTdcNombre(tipoDocContableVO.getTdcNombre());
        siiTipoDocContable.setTdcPermiteManual(tipoDocContableVO.getTdcPermiteManual());
        siiTipoDocContable.setTdcActivo(tipoDocContableVO.getTdcActivo());

        return siiTipoDocContable;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param documentoContableVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiDocumentoContable convertir(DocumentoContableVO documentoContableVO) throws ExcepcionDAO {
        SiiDocumentoContable siiDocumentoContable = new SiiDocumentoContable();
        // realizar la busqueda por codigo
        if (documentoContableVO.getDcoCodigo() != null && documentoContableVO.getDcoCodigo() > 0) {
            siiDocumentoContable = documentoContableDao.buscarPorCodigo(documentoContableVO.getDcoCodigo());
        }


        siiDocumentoContable.setDcoCodigo(documentoContableVO.getDcoCodigo());
        siiDocumentoContable.setDcoFechaOper(documentoContableVO.getDcoFechaOper());
        siiDocumentoContable.setDcoNumeroCompr(documentoContableVO.getDcoNumeroCompr());
        siiDocumentoContable.setDcoMotivoAnula(documentoContableVO.getDcoMotivoAnula());
        siiDocumentoContable.setDcoConcepto(documentoContableVO.getDcoConcepto());
        siiDocumentoContable.setDcoValor(documentoContableVO.getDcoValor());


        if (documentoContableVO.getObligacionVo() != null) {
            SiiObligacion siiObligacion =
                obligacionDao.buscarPorCodigo(documentoContableVO.getObligacionVo().getOblCodigo());
            siiDocumentoContable.setSiiObligacion(siiObligacion);
        }

        if (documentoContableVO.getTipoDocContableVo() != null) {
            SiiTipoDocContable siiTipoDocContable =
                tipoDocContableDao.buscarPorCodigo(documentoContableVO.getTipoDocContableVo().getTdcCodigo());
            siiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
        }

        if (documentoContableVO.getOrdenPagoVo() != null) {
            SiiOrdenPago siiOrdenPago =
                ordenPagoDao.buscarOrdenPagoPorCodigo(documentoContableVO.getOrdenPagoVo().getOrpCodigo());
            siiDocumentoContable.setSiiOrdenPago(siiOrdenPago);
        }

        if (documentoContableVO.getEstadoDocContabVo() != null) {
            SiiEstadoDocContab siiEstadoDocContab =
                estadoDocContabDao.buscarPorCodigo(documentoContableVO.getEstadoDocContabVo().getEdoCodigo());
            siiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
        }

        if (documentoContableVO.getInteresCuotaVo() != null) {
            SiiInteresCuota siiInteres =
                interesCuotaDao.buscarInteresCuotaPorId(documentoContableVO.getInteresCuotaVo().getIcuCodigo());
            siiDocumentoContable.setSiiInteresCuota(siiInteres);
        }

        if (documentoContableVO.getUsuarioApruebaVo() != null &&
            documentoContableVO.getUsuarioApruebaVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuario =
                usuarioDao.buscarUsuarioPorId(documentoContableVO.getUsuarioApruebaVo().getUsuCodigo());
            siiDocumentoContable.setSiiUsuarioAprueba(siiUsuario);
        }

        if (documentoContableVO.getUsuarioRegistraVo() != null &&
            documentoContableVO.getUsuarioRegistraVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuario =
                usuarioDao.buscarUsuarioPorId(documentoContableVO.getUsuarioRegistraVo().getUsuCodigo());
            siiDocumentoContable.setSiiUsuarioRegistra(siiUsuario);
        }

        if (documentoContableVO.getCierreAnualContableVo() != null &&
            documentoContableVO.getCierreAnualContableVo().getCacCodigo() != null) {
            SiiCierreAnualContable siiCierreAnualContable =
                cierreAnualContableDao.buscarPorCodigo(documentoContableVO.getCierreAnualContableVo().getCacCodigo());
            siiDocumentoContable.setSiiCierreAnualContable(siiCierreAnualContable);
        }

        if (documentoContableVO.getCargaDocumentoContVo() != null &&
            documentoContableVO.getCargaDocumentoContVo().getCdcCodigo() != null) {
            SiiCargaDocumentoCont siiCargaDocumentoCont =
                cargaDocumentoContDao.buscarPorCodigo(documentoContableVO.getCargaDocumentoContVo().getCdcCodigo());
            siiDocumentoContable.setSiiCargaDocumentoCont(siiCargaDocumentoCont);
        }

        if (documentoContableVO.getNotaCreditoVo() != null &&
            documentoContableVO.getNotaCreditoVo().getNcrCodigo() != null) {
            SiiNotaCredito siiNotaCredito =
                notaCreditoDao.buscarPorCodigo(documentoContableVO.getNotaCreditoVo().getNcrCodigo());
            siiDocumentoContable.setSiiNotaCredito(siiNotaCredito);
        }
        if (documentoContableVO.getIncumplimientoContrVo()!=null && documentoContableVO.getIncumplimientoContrVo().getIcnCodigo()!=null) {
            SiiIncumplimientoContr siiIncumplimientoContr = incumplimientoContrDao.buscarPorCodigo(documentoContableVO.getIncumplimientoContrVo().getIcnCodigo());
            siiDocumentoContable.setSiiIncumplimientoContr(siiIncumplimientoContr);
        }
        
        if (documentoContableVO.getLiquidacionMesDE()!=null && documentoContableVO.getLiquidacionMesDE().getLmeCodigo()!=null) {
            SiiLiquidacionMes siiLiquidacionMesDE = liquidacionMesDao.buscarLiquidacionMesPorId(documentoContableVO.getLiquidacionMesDE().getLmeCodigo());
            siiDocumentoContable.setSiiLiquidacionMesDE(siiLiquidacionMesDE);
        }
        
        if (documentoContableVO.getLiquidacionMesGA()!=null && documentoContableVO.getLiquidacionMesGA().getLmeCodigo()!=null) {
            SiiLiquidacionMes siiLiquidacionMesGA = liquidacionMesDao.buscarLiquidacionMesPorId(documentoContableVO.getLiquidacionMesGA().getLmeCodigo());
            siiDocumentoContable.setSiiLiquidacionMesGA(siiLiquidacionMesGA);
        }
        
        if (documentoContableVO.getProcesoSancionatorioVo()!=null && documentoContableVO.getProcesoSancionatorioVo().getPsaCodigo()!=null) {
            SiiProcesoSancionatorio siiProcesoSancionatorio = procesoSancionatorioDao.buscarPorCodigo(documentoContableVO.getProcesoSancionatorioVo().getPsaCodigo());
            siiDocumentoContable.setSiiProcesoSancionatorio(siiProcesoSancionatorio);
        }

        return siiDocumentoContable;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param ordenPagoVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiOrdenPago convertir(OrdenPagoVO ordenPagoVO) throws ExcepcionDAO {
        SiiOrdenPago siiOrdenPago = new SiiOrdenPago();
        if (ordenPagoVO.getOrpCodigo() != null && ordenPagoVO.getOrpCodigo() > 0) {
            siiOrdenPago = ordenPagoDao.buscarOrdenPagoPorCodigo(ordenPagoVO.getOrpCodigo());
        }

        siiOrdenPago.setOrpConsecutivo(ordenPagoVO.getOrpConsecutivo());
        siiOrdenPago.setOrpFecha(ordenPagoVO.getOrpFecha());
        siiOrdenPago.setOrpPagDestFinal(ordenPagoVO.getOrpPagDestFinal());
        siiOrdenPago.setOrpMotivoAnula(ordenPagoVO.getMotivoAnulacion());
        siiOrdenPago.setOrpValorGasto(ordenPagoVO.getValorGasto());
        siiOrdenPago.setOrpTipoGasto(ordenPagoVO.getIndicadorPago());
        siiOrdenPago.setOrpNumDocSop(ordenPagoVO.getNumeroDocCobro());

        if (ordenPagoVO.getObligacionVo() != null) {
            SiiObligacion siiObligacion = obligacionDao.buscarPorCodigo(ordenPagoVO.getObligacionVo().getOblCodigo());
            siiOrdenPago.setSiiObligacion(siiObligacion);
        }

        if (ordenPagoVO.getCuentaBancariaVo() != null) {
            SiiCuentaBancaria siiCuentaBancaria =
                cuentaBancariaDao.buscarCuentaPorId(ordenPagoVO.getCuentaBancariaVo().getCbaCodigo());
            siiOrdenPago.setSiiCuentaBancaria(siiCuentaBancaria);
        }

        if (ordenPagoVO.getEstadoOrdenPagoVo() != null) {
            SiiEstadoOrdenPago siiEstadoOrdenPago =
                estadoOrdenPagoDao.buscarEstadoOrdenPagoPorId(ordenPagoVO.getEstadoOrdenPagoVo().getEopCodigo());
            siiOrdenPago.setSiiEstadoOrdenPago(siiEstadoOrdenPago);
        }

        if (ordenPagoVO.getUsuarioApruebaVo() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(ordenPagoVO.getUsuarioApruebaVo().getUsuCodigo());
            siiOrdenPago.setSiiUsuarioAprueba(siiUsuario);
        }

        if (ordenPagoVO.getUsuarioRegistraVo() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(ordenPagoVO.getUsuarioRegistraVo().getUsuCodigo());
            siiOrdenPago.setSiiUsuarioRegistra(siiUsuario);
        }
        if (ordenPagoVO.getTipoDocCobroSolPagoVo() != null) {
            SiiTipoDocSopSolicPago siiTipoDocSopSolicPago =
                tipoDocSopSolicPagoDao.buscarPorCodigo(ordenPagoVO.getTipoDocCobroSolPagoVo().getTspCodigo());
            siiOrdenPago.setSiiTipoDocSopSolicPago(siiTipoDocSopSolicPago);
        }


        //Valores para la orden de pago 2013
        siiOrdenPago.setOblNumeroRp(ordenPagoVO.getNumeroRP());


        if (ordenPagoVO.getBeneficiario() != null) {
            SiiProveedor siiBeneficiario =
                proveedorDao.buscarProveedorPorId(ordenPagoVO.getBeneficiario().getProCodigo());
            siiOrdenPago.setSiiProveedor(siiBeneficiario);
        }

        if (ordenPagoVO.getObligacionNoPresupVo() != null) {
            SiiObligacionNoPresup siiObligacionNoPresup =
                obligacionNoPresupDao.buscarPorCodigoObligacionNoPres(ordenPagoVO.getObligacionNoPresupVo().getOnpCodigo());
            siiOrdenPago.setSiiObligacionNoPresup(siiObligacionNoPresup);
        }

        if (ordenPagoVO.getTipoDocContableVo() != null && ordenPagoVO.getTipoDocContableVo().getTdcCodigo() != null) {
            SiiTipoDocContable siiTipoDocContable =
                tipoDocContableDao.buscarPorCodigo(ordenPagoVO.getTipoDocContableVo().getTdcCodigo());
            siiOrdenPago.setSiiTipoDocContable(siiTipoDocContable);
        }

        if (ordenPagoVO.getFuenteFinancContabVo() != null &&
            ordenPagoVO.getFuenteFinancContabVo().getFfcCodigo() != null) {
            SiiFuenteFinancContab siiFuenteFinancContab =
                fuenteFinancContabDao.buscarPorCodigo(ordenPagoVO.getFuenteFinancContabVo().getFfcCodigo());
            siiOrdenPago.setSiiFuenteFinancContab(siiFuenteFinancContab);
        }


        return siiOrdenPago;
    }

    public SiiDocumentoConpes convertir(DocumentoConpesVO documentoConpesVo) throws ExcepcionDAO {
        SiiDocumentoConpes siiDocumentoConpes = new SiiDocumentoConpes();
        if (documentoConpesVo.getDcnCodigo() != null && documentoConpesVo.getDcnCodigo() > 0) {
            siiDocumentoConpes = documentoConpesDao.buscarDocumentoConpesPorId(documentoConpesVo.getDcnCodigo());
        }
        siiDocumentoConpes.setDcnActivo(documentoConpesVo.getDcnActivo());
        siiDocumentoConpes.setDcnFecha(documentoConpesVo.getDcnFecha());
        siiDocumentoConpes.setDcnFechaReg(documentoConpesVo.getDcnFechaRegistro());
        siiDocumentoConpes.setDcnNumero(documentoConpesVo.getDcnNumero());
        //padres
        if (documentoConpesVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(documentoConpesVo.getArchivoFisicoVo().getAfiCodigo());
            siiDocumentoConpes.setSiiArchivoFisico(siiArchivoFisico);
        }

        if (documentoConpesVo.getEstadoDocConpesVo() != null) {
            SiiEstadoDocConpes siiEstadoDocConpes =
                estadoDocConpesDao.buscarEstadoDocConpesPorId(documentoConpesVo.getEstadoDocConpesVo().getEdcCodigo());
            siiDocumentoConpes.setSiiEstadoDocConpes(siiEstadoDocConpes);
        }
        return siiDocumentoConpes;
    }


    public SiiDistribucionUbica convertir(DistribucionUbicaVO distribucionUbicaVo) throws ExcepcionDAO {
        SiiDistribucionUbica siiDistribucionUbica = new SiiDistribucionUbica();
        if (distribucionUbicaVo.getDubCodigo() != null && distribucionUbicaVo.getDubCodigo() > 0) {
            siiDistribucionUbica =
                distribucionUbicaDao.buscarDistribucionUbicaPorId(distribucionUbicaVo.getDubCodigo());
        }
        siiDistribucionUbica.setDubValor(distribucionUbicaVo.getDubValor());

        if (distribucionUbicaVo.getDocumentoConpesVo() != null) {
            SiiDocumentoConpes siiDocumentoConpes =
                documentoConpesDao.buscarDocumentoConpesPorId(distribucionUbicaVo.getDocumentoConpesVo().getDcnCodigo());
            siiDistribucionUbica.setSiiDocumentoConpes(siiDocumentoConpes);
        }

        if (distribucionUbicaVo.getEnteTerritorialVo() != null) {
            SiiEnteTerritorial siiEnteTerritorial =
                enteTerritorialDao.buscarEnteTerritorialPorId(distribucionUbicaVo.getEnteTerritorialVo().getEtiCodigo());
            siiDistribucionUbica.setSiiEnteTerritorial(siiEnteTerritorial);
        }


        return siiDistribucionUbica;
    }

    public SiiOficioDesigSuperv convertir(OficioDesigSupervVO oficioDesigSupervVo) throws ExcepcionDAO {
        SiiOficioDesigSuperv siiOficioDesigSuperv = new SiiOficioDesigSuperv();
        if (oficioDesigSupervVo.getOdsCodgo() != null && oficioDesigSupervVo.getOdsCodgo() > 0) {
            siiOficioDesigSuperv = oficioDesigSupervDao.buscarOficioDesigSupervPorId(oficioDesigSupervVo.getOdsCodgo());
        }
        siiOficioDesigSuperv.setOdsCodgo(oficioDesigSupervVo.getOdsCodgo());
        siiOficioDesigSuperv.setOdsEstado(oficioDesigSupervVo.getOdsEstado());
        siiOficioDesigSuperv.setOdsFechaDesig(oficioDesigSupervVo.getOdsFechaDesig());
        siiOficioDesigSuperv.setOdsNumIdentExt(oficioDesigSupervVo.getOdsNumIdentExt());
        //Padres
        if (oficioDesigSupervVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(oficioDesigSupervVo.getArchivoFisicoVo().getAfiCodigo());
            siiOficioDesigSuperv.setSiiArchivoFisico(siiArchivoFisico);
        }
        if (oficioDesigSupervVo.getProcesoContratacionVo() != null) {
            SiiProcesoContratacion siiProcesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(oficioDesigSupervVo.getProcesoContratacionVo().getPrcCodigo());
            siiOficioDesigSuperv.setSiiProcesoContratacion(siiProcesoContratacion);
        }
        if (oficioDesigSupervVo.getTipoIdentificacionVo() != null) {
            SiiTipoIdentificacion siiTipoIdentificacion =
                tipoIdentificacionDao.buscarTipoIdentificacionPorId(oficioDesigSupervVo.getTipoIdentificacionVo().getTidCodigo());
            siiOficioDesigSuperv.setSiiTipoIdentificacion(siiTipoIdentificacion);
        }
        if (oficioDesigSupervVo.getUsuarioVo() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(oficioDesigSupervVo.getUsuarioVo().getUsuCodigo());
            siiOficioDesigSuperv.setSiiUsuario(siiUsuario);
        }
        return siiOficioDesigSuperv;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param actividadIcaPersVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiActividadIcaPers convertir(ActividadIcaPersVO actividadIcaPersVO) throws ExcepcionDAO {
        SiiActividadIcaPers siiActividadIcaPers = new SiiActividadIcaPers();
        // realizar la busqueda por codigo
        if (actividadIcaPersVO.getAipCodigo() != null && actividadIcaPersVO.getAipCodigo() > 0) {
            siiActividadIcaPers = actividadIcaPersDao.buscarPorCodigo(actividadIcaPersVO.getAipCodigo());
        }

        siiActividadIcaPers.setAipCodigo(actividadIcaPersVO.getAipCodigo());
        siiActividadIcaPers.setAipActivPrinc(actividadIcaPersVO.getAipActivPrinc());

        if (actividadIcaPersVO.getPersonaVo() != null) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(actividadIcaPersVO.getPersonaVo().getPerCodigo());
            siiActividadIcaPers.setSiiPersona(siiPersona);
        }

        if (actividadIcaPersVO.getActividadIcaVo() != null) {
            SiiActividadIca siiActividadIca =
                actividadIcaDao.buscarPorCodigoActividadIca(actividadIcaPersVO.getActividadIcaVo().getAicCodigo());
            siiActividadIcaPers.setSiiActividadIca(siiActividadIca);
        }

        return (siiActividadIcaPers);
    }


    public SiiRecaudoPse convertir(PagoOperadoresPseVO pagoOperadoresPseVo) throws ExcepcionDAO {
        SiiRecaudoPse siiRecaudoPse = new SiiRecaudoPse();
        if (pagoOperadoresPseVo.getRpsCodigo() != null && pagoOperadoresPseVo.getRpsCodigo() > 0) {
            siiRecaudoPse = pagoOpePseDao.buscarRecaudoPseXId(pagoOperadoresPseVo.getRpsCodigo());
        }
        if (siiRecaudoPse == null) {
            siiRecaudoPse = new SiiRecaudoPse();
        }
        siiRecaudoPse.setRpsCodigo(pagoOperadoresPseVo.getRpsCodigo());
        siiRecaudoPse.setRpsCodigoTrans(pagoOperadoresPseVo.getRpsCodigoTrans());
        siiRecaudoPse.setRpsEstado(pagoOperadoresPseVo.getRpsEstado());
        siiRecaudoPse.setRpsFechaEstado(pagoOperadoresPseVo.getRpsFechaEstado());
        siiRecaudoPse.setRpsReferencia1(pagoOperadoresPseVo.getRpsReferencia1());


        return siiRecaudoPse;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param estadoDocContabVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiEstadoDocContab convertir(EstadoDocContabVO estadoDocContabVO) throws ExcepcionDAO {
        SiiEstadoDocContab siiEstadoDocContab = new SiiEstadoDocContab();
        // realizar la busqueda por codigo
        if (estadoDocContabVO.getEdoCodigo() != null && estadoDocContabVO.getEdoCodigo() > 0) {
            siiEstadoDocContab = estadoDocContabDao.buscarPorCodigo(estadoDocContabVO.getEdoCodigo());
        }

        siiEstadoDocContab.setEdoCodigo(estadoDocContabVO.getEdoCodigo());
        siiEstadoDocContab.setEdoNombre(estadoDocContabVO.getEdoNombre());

        return (siiEstadoDocContab);
    }


    public SiiGravamenMovFinanc convertir(GravamenMovFinancVO gravamenMovFinancVo) throws ExcepcionDAO {
        SiiGravamenMovFinanc siiGravamenMovFinanc = new SiiGravamenMovFinanc();
        if (gravamenMovFinancVo.getGmfCodigo() != null && gravamenMovFinancVo.getGmfCodigo() > 0) {
            siiGravamenMovFinanc =
                gravamenMovFinancDao.buscarGravamenMovFinancPorId(gravamenMovFinancVo.getGmfCodigo());
        }
        siiGravamenMovFinanc.setGmfActivo(gravamenMovFinancVo.getGmfActivo());
        siiGravamenMovFinanc.setGmfCodigo(gravamenMovFinancVo.getGmfCodigo());
        siiGravamenMovFinanc.setGmfFechaReg(gravamenMovFinancVo.getGmfFechaReg());
        siiGravamenMovFinanc.setGmfValor(gravamenMovFinancVo.getGmfValor());

        return siiGravamenMovFinanc;
    }

    public SiiResolucionAutoriz convertir(ResolucionAutorizVO resolucionAutorizVO) throws ExcepcionDAO {
        SiiResolucionAutoriz resolucionAutoriz = new SiiResolucionAutoriz();
        if (resolucionAutorizVO.getRauCodigo() != null && resolucionAutorizVO.getRauCodigo() > 0) {
            resolucionAutoriz = resolucionAutorizDao.buscarResolucionAutorizPorId(resolucionAutorizVO.getRauCodigo());
        }
        resolucionAutoriz.setRauCodigo(resolucionAutorizVO.getRauCodigo());
        resolucionAutoriz.setRauFechaNotif(resolucionAutorizVO.getRauFechaNotif());
        resolucionAutoriz.setRauFechaPasFirma(resolucionAutorizVO.getRauFechaPasFirma());
        resolucionAutoriz.setRauFechaPasRev(resolucionAutorizVO.getRauFechaPasRev());
        resolucionAutoriz.setRauFechaResFirme(resolucionAutorizVO.getRauFechaResFirme());
        resolucionAutoriz.setRauFechaResol(resolucionAutorizVO.getRauFechaResol());
        resolucionAutoriz.setRauMedioNotif(resolucionAutorizVO.getRauMedioNotif());
        resolucionAutoriz.setRauNumeroRes(resolucionAutorizVO.getRauNumeroRes());
        resolucionAutoriz.setRauObservaciones(resolucionAutorizVO.getRauObservaciones());
        //Padres:
        if (resolucionAutorizVO.getEstadoResolucAutVO() != null) {
            SiiEstadoResolucAut estado =
                estadoResolucAutDao.buscarEstadoResolucAutPorId(resolucionAutorizVO.getEstadoResolucAutVO().getEraCodigo());
            resolucionAutoriz.setSiiEstadoResolucAut(estado);
        }
        if (resolucionAutorizVO.getSolicitudAutorizaVO() != null) {
            SiiSolicitudAutoriza solicitud =
                solicitudAutorizaDao.buscarSolicitudAutorizacionPorCodigo(resolucionAutorizVO.getSolicitudAutorizaVO().getSauCodigo());
            resolucionAutoriz.setSiiSolicitudAutoriza(solicitud);
        }
        if (resolucionAutorizVO.getArchivoFisicoVo() != null) {
            SiiArchivoFisico archivo =
                archivoFisicoDao.buscarArchivoFisicoPorId(resolucionAutorizVO.getArchivoFisicoVo().getAfiCodigo());
            resolucionAutoriz.setSiiArchivoFisico(archivo);
        }

        return resolucionAutoriz;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param modificPresupVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiModificPresup convertir(ModificPresupVO modificPresupVO) throws ExcepcionDAO {
        SiiModificPresup siiModificPresup = new SiiModificPresup();
        // realizar la busqueda por codigo
        if (modificPresupVO.getMprCodigo() != null && modificPresupVO.getMprCodigo() > 0) {
            siiModificPresup = modificPresupDao.buscarModificPresupPorId(modificPresupVO.getMprCodigo());
        }

        siiModificPresup.setMprCodigo(modificPresupVO.getMprCodigo());
        siiModificPresup.setMprFecha(modificPresupVO.getMprFecha());
        siiModificPresup.setMprTipo(modificPresupVO.getMprTipo());
        siiModificPresup.setMprVigencia(modificPresupVO.getMprVigencia());
        siiModificPresup.setMprFechaAcuerdoJunta(modificPresupVO.getMprFechaAcuerdoJunta());
        siiModificPresup.setMprFechaDecreto(modificPresupVO.getMprFechaDecreto());
        siiModificPresup.setMprFechaOficioDesagregacion(modificPresupVO.getMprFechaOficioDesagregacion());
        siiModificPresup.setMprNumeroAcuerdoJunta(modificPresupVO.getMprNumeroAcuerdoJunta());
        siiModificPresup.setMprNumeroDecreto(modificPresupVO.getMprNumeroDecreto());
        siiModificPresup.setMprNumOficioDesagregacion(modificPresupVO.getMprNumOficioDesagregacion());
        siiModificPresup.setMprConsecutivo(modificPresupVO.getMprConsecutivo());


        if (modificPresupVO.getEstadoModifPresupVo() != null) {
            SiiEstadoModifPresup siiEstadoModifPresup =
                estadoModifPresupDao.buscarEstadoModifPresupPorId(modificPresupVO.getEstadoModifPresupVo().getEmpCodigo());
            siiModificPresup.setSiiEstadoModifPresup(siiEstadoModifPresup);
        }

        return (siiModificPresup);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param modPresDetRubroVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiModPresDetRubro convertir(ModPresDetRubroVO modPresDetRubroVo) throws ExcepcionDAO {
        SiiModPresDetRubro siiModPresDetRubro = new SiiModPresDetRubro();
        // realizar la busqueda por codigo
        if (modPresDetRubroVo.getMpdCodigo() != null && modPresDetRubroVo.getMpdCodigo() > 0) {
            siiModPresDetRubro = modPresDetRubroDao.buscarModPresDetRubroPorId(modPresDetRubroVo.getMpdCodigo());
        }

        siiModPresDetRubro.setMpdCodigo(modPresDetRubroVo.getMpdCodigo());
        siiModPresDetRubro.setMpdValor(modPresDetRubroVo.getMpdValor());

        if (modPresDetRubroVo.getDetalleRubroOriVo() != null) {
            SiiDetalleRubro siiDetalleRubro =
                detalleRubroDao.buscarPorCodigoDetalleRubro(modPresDetRubroVo.getDetalleRubroOriVo().getDruCodigo());
            siiModPresDetRubro.setSiiDetalleRubroOri(siiDetalleRubro);
        }

        if (modPresDetRubroVo.getDetalleRubroDestVo() != null) {
            SiiDetalleRubro siiDetalleRubro =
                detalleRubroDao.buscarPorCodigoDetalleRubro(modPresDetRubroVo.getDetalleRubroDestVo().getDruCodigo());
            siiModPresDetRubro.setSiiDetalleRubroDest(siiDetalleRubro);
        }

        if (modPresDetRubroVo.getModificPresupVo() != null) {
            SiiModificPresup siiModificPresup =
                modificPresupDao.buscarModificPresupPorId(modPresDetRubroVo.getModificPresupVo().getMprCodigo());
            siiModPresDetRubro.setSiiModificPresup(siiModificPresup);
        }

        return (siiModPresDetRubro);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param estadoModifPresupVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiEstadoModifPresup convertir(EstadoModifPresupVO estadoModifPresupVO) throws ExcepcionDAO {
        SiiEstadoModifPresup siiEstadoModifPresup = new SiiEstadoModifPresup();
        // realizar la busqueda por codigo
        if (estadoModifPresupVO.getEmpCodigo() != null && estadoModifPresupVO.getEmpCodigo() > 0) {
            siiEstadoModifPresup =
                estadoModifPresupDao.buscarEstadoModifPresupPorId(estadoModifPresupVO.getEmpCodigo());
        }

        siiEstadoModifPresup.setEmpCodigo(estadoModifPresupVO.getEmpCodigo());
        siiEstadoModifPresup.setEmpNombre(estadoModifPresupVO.getEmpNombre());

        return (siiEstadoModifPresup);
    }

    public SiiSaldoCtaBanco convertir(SaldoCuentaBancoVO saldoCuentaBancoVo) throws ExcepcionDAO {
        SiiSaldoCtaBanco saldoCtaBanco = new SiiSaldoCtaBanco();
        if (saldoCuentaBancoVo.getScbCodigo() != null && saldoCuentaBancoVo.getScbCodigo() > 0) {
            saldoCtaBanco = saldoCtaBancoDao.buscarSaldoCtaBancoPorId(saldoCuentaBancoVo.getScbCodigo());
        }
        saldoCtaBanco.setScbEstado(saldoCuentaBancoVo.getScbEstado());
        saldoCtaBanco.setScbFecha(saldoCuentaBancoVo.getScbFEcha());
        saldoCtaBanco.setScbSaldo(saldoCuentaBancoVo.getScbSaldo());

        //Padre
        if (saldoCuentaBancoVo.getCuentaBancariaVo() != null) {
            SiiCuentaBancaria siiCuentaBancaria =
                cuentaBancariaDao.buscarCuentaPorId(saldoCuentaBancoVo.getCuentaBancariaVo().getCbaCodigo());
            saldoCtaBanco.setSiiCuentaBancaria(siiCuentaBancaria);
        }

        return saldoCtaBanco;
    }

    public SiiCuentaBancaria convertir(CuentaBancariaVO cuentaBancariaVo) throws ExcepcionDAO {
        SiiCuentaBancaria siiCuentaBancaria = new SiiCuentaBancaria();
        if (cuentaBancariaVo.getCbaCodigo() != null && cuentaBancariaVo.getCbaCodigo() > 0)
            siiCuentaBancaria = cuentaBancariaDao.buscarCuentaPorId(cuentaBancariaVo.getCbaCodigo());
        siiCuentaBancaria.setCbaActivo(cuentaBancariaVo.getCbaActivo());
        siiCuentaBancaria.setCbaComentario(cuentaBancariaVo.getCbaComentario());
        siiCuentaBancaria.setCbaNumero(cuentaBancariaVo.getCbaNumero());
        siiCuentaBancaria.setCbaTipo(cuentaBancariaVo.getCbaTipo());
        siiCuentaBancaria.setCboAplicaGmf(cuentaBancariaVo.getCbaAplicaGmf());

        if (cuentaBancariaVo.getSiiBanco() != null) {
            SiiBanco siiBanco = bancoDao.buscarBancoXId(cuentaBancariaVo.getSiiBanco().getBanCodigo());
            siiCuentaBancaria.setSiiBanco(siiBanco);
        }
        return siiCuentaBancaria;
    }


    public SiiInventario convertir(InventarioVO inventarioVo) throws ExcepcionDAO {

        SiiInventario siiInventario = new SiiInventario();

        if (inventarioVo.getInvCodigo() != null && inventarioVo.getInvCodigo() > 0)
            siiInventario = inventarioDao.buscarInventarioPorId(inventarioVo.getInvCodigo());
        siiInventario.setInvEstado(inventarioVo.getInvEstado());
        siiInventario.setInvFechaFinLiq(inventarioVo.getInvFechaFinLiq());
        siiInventario.setInvFechaFinOfi(inventarioVo.getInvFechaFinOfi());
        siiInventario.setInvFechaIniLiq(inventarioVo.getInvFechaIniLiq());
        siiInventario.setInvFechaIniOfi(inventarioVo.getInvFechaIniOfi());
        siiInventario.setInvSillas(inventarioVo.getInvSillas());
        siiInventario.setInvPg(inventarioVo.getInvPg());


        if (inventarioVo.getEstablecimientoVo() != null && inventarioVo.getEstablecimientoVo().getEstCodigo() > 0) {
            SiiEstablecimiento siiEstablecimiento =
                establecimientoDao.buscarEstablecimientoPorId(inventarioVo.getEstablecimientoVo().getEstCodigo());
            siiInventario.setSiiEstablecimiento(siiEstablecimiento);
        }

        if (inventarioVo.getTipoApuestaVo() != null && inventarioVo.getTipoApuestaVo().getTapCodigo() > 0) {
            SiiTipoApuesta siiTipoApuesta =
                tipoApuestaDao.buscarTipoApuestaPorCodigo(inventarioVo.getTipoApuestaVo().getTapCodigo());
            siiInventario.setSiiTipoApuesta(siiTipoApuesta);
        }

        if (inventarioVo.getInstrumentoVo() != null && inventarioVo.getInstrumentoVo().getInsCodigo() > 0) {
            SiiInstrumento siiInstrumento =
                instrumentoDao.buscarPorCodigoInstrumento(inventarioVo.getInstrumentoVo().getInsCodigo());
            siiInventario.setSiiInstrumento(siiInstrumento);
        }

        if (inventarioVo.getNovedadVo() != null && inventarioVo.getNovedadVo().getNovCodigo() > 0) {
            SiiNovedad siiNovedad = novedadDao.buscarNovedadPorId(inventarioVo.getNovedadVo().getNovCodigo());
            siiInventario.setSiiNovedad(siiNovedad);
        }


        return siiInventario;
    }


    public SiiInteresCuota convertir(InteresCuotaVO interesVo) throws ExcepcionDAO {
        SiiInteresCuota siiInteresCuota = new SiiInteresCuota();
        if (interesVo.getIcuCodigo() != null && interesVo.getIcuCodigo() > 0) {
            siiInteresCuota = interesCuotaDao.buscarInteresCuotaPorId(interesVo.getIcuCodigo());
        }
        siiInteresCuota.setIcuBaseCalc(interesVo.getIcuBaseCalc());
        siiInteresCuota.setIcuCancelado(interesVo.getIcuCancelado());
        siiInteresCuota.setIcuFecha(interesVo.getIcuFecha());
        siiInteresCuota.setIcuTasaAplic(interesVo.getIcuTasaAplic());
        siiInteresCuota.setIcuValor(interesVo.getIcuValor());
        siiInteresCuota.setIcuValorPagado(interesVo.getIcuValorPagado());
        if (interesVo.getCuotaOperadorVo() != null) {
            SiiCuotaOperador siiCuotaOperador =
                cuotaOperadorDao.buscarCuotaOperadorPorId(interesVo.getCuotaOperadorVo().getCopCodigo());
            siiInteresCuota.setSiiCuotaOperador(siiCuotaOperador);
        }
        return siiInteresCuota;
    }

    public SiiTrasladoBancario convertir(TrasladoCuentasBancariasVO trasladoCuentasBancariasVo) throws ExcepcionDAO {
        SiiTrasladoBancario siiTrasladoBancario = new SiiTrasladoBancario();
        if (trasladoCuentasBancariasVo.getTbaCodigo() != null && trasladoCuentasBancariasVo.getTbaCodigo() > 0)
            siiTrasladoBancario =
                trasladoCuentasBancariasDao.buscarTrasladoBancarioPorId(trasladoCuentasBancariasVo.getTbaCodigo());
        siiTrasladoBancario.setTbaConsecutivo(trasladoCuentasBancariasVo.getTbaConsecutivo());
        siiTrasladoBancario.setTbaDescripcion(trasladoCuentasBancariasVo.getTbaDescripcion());
        siiTrasladoBancario.setTbaFecha(trasladoCuentasBancariasVo.getTbaFecha());
        siiTrasladoBancario.setTbaValor(trasladoCuentasBancariasVo.getTbaValor());
        if (trasladoCuentasBancariasVo.getEstadoTrasladoBancarioVo() != null) {
            SiiEstadoTraslBancario siiEstadoTraslBancario =
                estadoTansladoBancarioDao.buscarPorCodigo(trasladoCuentasBancariasVo.getEstadoTrasladoBancarioVo().getEstCodigo());
            siiTrasladoBancario.setSiiEstadoTraslBancario(siiEstadoTraslBancario);
        }
        if (trasladoCuentasBancariasVo.getCuentaBancariaOrigenVo() != null) {
            SiiCuentaBancaria siiCuentaBancariaOri =
                cuentaBancariaDao.buscarCuentaPorId(trasladoCuentasBancariasVo.getCuentaBancariaOrigenVo().getCbaCodigo());
            siiTrasladoBancario.setSiiCuentaBancariaOri(siiCuentaBancariaOri);
        }

        if (trasladoCuentasBancariasVo.getCuentaBancariaOrigenVo() != null) {
            SiiCuentaBancaria siiCuentaBancariaDest =
                cuentaBancariaDao.buscarCuentaPorId(trasladoCuentasBancariasVo.getCuentaBancariaDestinoVo().getCbaCodigo());
            siiTrasladoBancario.setSiiCuentaBancariaDest(siiCuentaBancariaDest);
        }


        return siiTrasladoBancario;

    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param oblConcRpDetRubCdpVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiOblConcRpDetRubCdp convertir(OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) throws ExcepcionDAO {
        SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp = new SiiOblConcRpDetRubCdp();
        // realizar la busqueda por codigo
        if (oblConcRpDetRubCdpVo.getOcrCodigo() != null && oblConcRpDetRubCdpVo.getOcrCodigo() > 0) {
            siiOblConcRpDetRubCdp = oblConcRpDetRubCdpDao.buscarPorCodigo(oblConcRpDetRubCdpVo.getOcrCodigo());
        }

        siiOblConcRpDetRubCdp.setOcrCodigo(oblConcRpDetRubCdpVo.getOcrCodigo());
        siiOblConcRpDetRubCdp.setOcrValor(oblConcRpDetRubCdpVo.getOcrValor());

        if (oblConcRpDetRubCdpVo.getObligacionVo() != null &&
            oblConcRpDetRubCdpVo.getObligacionVo().getOblCodigo() != null) {
            SiiObligacion siiObligacion =
                obligacionDao.buscarPorCodigo(oblConcRpDetRubCdpVo.getObligacionVo().getOblCodigo());
            siiOblConcRpDetRubCdp.setSiiObligacion(siiObligacion);
        }

        if (oblConcRpDetRubCdpVo.getObligacionConceptoVo() != null &&
            oblConcRpDetRubCdpVo.getObligacionConceptoVo().getOcoCodigo() != null) {
            SiiObligacionConcepto siiObligacionConcepto =
                obligacionConceptoDao.buscarPorCodigo(oblConcRpDetRubCdpVo.getObligacionConceptoVo().getOcoCodigo());
            siiOblConcRpDetRubCdp.setSiiObligacionConcepto(siiObligacionConcepto);
        }

        if (oblConcRpDetRubCdpVo.getRpDetRubroCdpVo() != null &&
            oblConcRpDetRubCdpVo.getRpDetRubroCdpVo().getRdrCodigo() != null) {
            SiiRpDetRubroCdp siiRpDetRubroCdp =
                rpDetRubroCdpDao.buscarCodigoRpDetRubroCdp(oblConcRpDetRubCdpVo.getRpDetRubroCdpVo().getRdrCodigo());
            siiOblConcRpDetRubCdp.setSiiRpDetRubroCdp(siiRpDetRubroCdp);
        }

        return (siiOblConcRpDetRubCdp);
    }

    public SiiCdpRp convertir(CdpRpVO cdpRpVo) throws ExcepcionDAO {
        SiiCdpRp siiCdpRp = new SiiCdpRp();
        // realizar la busqueda por codigo
        if (cdpRpVo.getCrpCodigo() != null && cdpRpVo.getCrpCodigo() > 0) {
            siiCdpRp = cdpRpDao.buscarPorCodigoCdpRp(cdpRpVo.getCrpCodigo());
        }
        siiCdpRp.setCrpCodigo(cdpRpVo.getCrpCodigo());
        if (cdpRpVo.getCdpVo() != null) {
            SiiCdp siiCdp = cdpDao.buscarCdpPorId(cdpRpVo.getCdpVo().getCdpCodigo());
            siiCdpRp.setSiiCdp(siiCdp);
        }

        if (cdpRpVo.getRpVo() != null) {
            SiiRp siiRp = rpDao.buscarPorCodigoRp(cdpRpVo.getRpVo().getRpCodigo());
            siiCdpRp.setSiiRp(siiRp);
        }


        return (siiCdpRp);
    }


    public SiiCierreContable convertir(CierreMensualVO cierreMensualVo) throws ExcepcionDAO {
        SiiCierreContable siiCierreContable = new SiiCierreContable();
        if (cierreMensualVo.getCicCodigo() != null && cierreMensualVo.getCicCodigo() > 0)
            siiCierreContable = cierreMensualDao.buscarCierreContablePorId(cierreMensualVo.getCicCodigo());

        siiCierreContable.setCicFechaCCont(cierreMensualVo.getCicFechaCierre());
        siiCierreContable.setCicVigencia(cierreMensualVo.getCicVigencia());

        if (cierreMensualVo.getMesVo() != null) {
            SiiMes siiMes = mesDao.buscarMesPorId(cierreMensualVo.getMesVo().getMesCodigo());
            siiCierreContable.setSiiMes(siiMes);
        }


        return (siiCierreContable);
    }


    public SiiCierreRecaudo convertir(CierreRecaudoVO cierreRecaudoVo) throws ExcepcionDAO {
        SiiCierreRecaudo siiCierreRecaudo = new SiiCierreRecaudo();

        if (cierreRecaudoVo.getCirCodigo() != null && cierreRecaudoVo.getCirCodigo() > 0) {
            siiCierreRecaudo = cierreRecaudoDao.buscarPorCodigoCierreRecaudo(cierreRecaudoVo.getCirCodigo());
        }
        siiCierreRecaudo.setCirFechaCierre(cierreRecaudoVo.getCirFechaCierre());
        siiCierreRecaudo.setCirConsecutivo(cierreRecaudoVo.getCirConsecutivo());
        if (cierreRecaudoVo.getCirFechaCieCar() != null)
            siiCierreRecaudo.setCirFechaCieCar(cierreRecaudoVo.getCirFechaCieCar());
        if (cierreRecaudoVo.getCirFechaCieCont() != null)
            siiCierreRecaudo.setCirFechaCieCont(cierreRecaudoVo.getCirFechaCieCont());
        siiCierreRecaudo.setCirVigencia(cierreRecaudoVo.getCirVigencia());
        siiCierreRecaudo.setMesCodigo(cierreRecaudoVo.getMesCodigo());

        if (cierreRecaudoVo.getEstadoCierrreRecVo() != null) {
            SiiEstadoCierrreRec siiEstadoCierre =
                estadoCierreRecDao.buscarEstadoCierrreRecPorId(cierreRecaudoVo.getEstadoCierrreRecVo().getEcrCodigo());
            siiCierreRecaudo.setSiiEstadoCierrreRec(siiEstadoCierre);
        }
        return (siiCierreRecaudo);
    }


    public SiiResponsabilidadDian convertir(ResponsabilidadDianVO responsabilidadDianVo) throws ExcepcionDAO {
        SiiResponsabilidadDian siiResponsabilidadDian = new SiiResponsabilidadDian();
        if (responsabilidadDianVo.getRdiCodigo() != null && responsabilidadDianVo.getRdiCodigo() > 0) {
            siiResponsabilidadDian =
                responsabilidadDianDao.buscarResponsabilidadDianPorId(responsabilidadDianVo.getRdiCodigo());
        }
        siiResponsabilidadDian.setRdiNombre(responsabilidadDianVo.getRdiNombre());

        return siiResponsabilidadDian;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param actividadIcaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiActividadIca convertir(ActividadIcaVO actividadIcaVo) throws ExcepcionDAO {
        SiiActividadIca siiActividadIca = new SiiActividadIca();
        // realizar la busqueda por codigo
        if (actividadIcaVo.getAicCodigo() != null && !actividadIcaVo.getAicCodigo().isEmpty()) {
            siiActividadIca = actividadIcaDao.buscarPorCodigoActividadIca(actividadIcaVo.getAicCodigo());
        }

        siiActividadIca.setAicAgrupacion(actividadIcaVo.getAicAgrupacion());
        siiActividadIca.setAicCodigo(actividadIcaVo.getAicCodigo());
        siiActividadIca.setAicDescripcion(actividadIcaVo.getAicDescripcion());
        siiActividadIca.setAicTarifa(actividadIcaVo.getAicTarifa());

        if (actividadIcaVo.getCuentasContablesVo() != null &&
            actividadIcaVo.getCuentasContablesVo().getCcoCodigo() != null) {
            SiiCuentasContables siiCuentasContables =
                cuentasContablesDao.buscarPorCodigo(actividadIcaVo.getCuentasContablesVo().getCcoCodigo());
            siiActividadIca.setSiiCuentasContables(siiCuentasContables);
        }

        return (siiActividadIca);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param responDianPersonaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiResponDianPersona convertir(ResponDianPersonaVO responDianPersonaVo) throws ExcepcionDAO {
        SiiResponDianPersona siiResponDianPersona = new SiiResponDianPersona();
        // realizar la busqueda por codigo
        if (responDianPersonaVo.getRdpCodigo() != null && responDianPersonaVo.getRdpCodigo() > 0) {
            siiResponDianPersona = responDianPersonaDao.buscarPorCodigo(responDianPersonaVo.getRdpCodigo());
        }

        siiResponDianPersona.setRdpCodigo(responDianPersonaVo.getRdpCodigo());

        if (responDianPersonaVo.getResponsabilidadDianVo() != null &&
            responDianPersonaVo.getResponsabilidadDianVo().getRdiCodigo() != null) {
            SiiResponsabilidadDian siiResponsabilidadDian =
                responsabilidadDianDao.buscarResponsabilidadDianPorId(responDianPersonaVo.getResponsabilidadDianVo().getRdiCodigo());
            siiResponDianPersona.setSiiResponsabilidadDian(siiResponsabilidadDian);
        }

        if (responDianPersonaVo.getPersonaVo() != null && responDianPersonaVo.getPersonaVo().getPerCodigo() != null) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(responDianPersonaVo.getPersonaVo().getPerCodigo());
            siiResponDianPersona.setSiiPersona(siiPersona);
        }

        return (siiResponDianPersona);
    }

    public SiiObligacionNoPresup convertir(ObligacionNoPresupVO obligacionNoPresupVo) throws ExcepcionDAO {
        SiiObligacionNoPresup siiObligacionNoPresup = new SiiObligacionNoPresup();
        // realizar la busqueda por codigo
        if (obligacionNoPresupVo.getOnpCodigo() != null && obligacionNoPresupVo.getOnpCodigo() > 0) {
            siiObligacionNoPresup =
                obligacionNoPresupDao.buscarPorCodigoObligacionNoPres(obligacionNoPresupVo.getOnpCodigo());
        }

        siiObligacionNoPresup.setOnpCodigo(obligacionNoPresupVo.getOnpCodigo());
        siiObligacionNoPresup.setOnpFecha(obligacionNoPresupVo.getOnpFecha());
        siiObligacionNoPresup.setOnpNumero(obligacionNoPresupVo.getOnpNumero());
        siiObligacionNoPresup.setOnpConcepto(obligacionNoPresupVo.getOnpConcepto());
        if (obligacionNoPresupVo.getOnpMotivoAnul() != null) {
            siiObligacionNoPresup.setOnpMotivoAnul(obligacionNoPresupVo.getOnpMotivoAnul());
        }
        if (obligacionNoPresupVo.getEstadoObligNoPresVo() != null) {
            SiiEstadoObligNoPres siiEstadoObligNoPres =
                estadoObligNoPresDao.buscarPorCodigo(obligacionNoPresupVo.getEstadoObligNoPresVo().getEonCodigo());
            siiObligacionNoPresup.setSiiEstadoObligNoPres(siiEstadoObligNoPres);
        }
        if (obligacionNoPresupVo.getPersonaVo() != null) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(obligacionNoPresupVo.getPersonaVo().getPerCodigo());
            siiObligacionNoPresup.setSiiPersona(siiPersona);
        }

        if (obligacionNoPresupVo.getUsuarioRegistra() != null &&
            obligacionNoPresupVo.getUsuarioRegistra().getUsuCodigo() != null) {
            SiiUsuario siiUsuario =
                usuarioDao.buscarUsuarioPorId(obligacionNoPresupVo.getUsuarioRegistra().getUsuCodigo());
            siiObligacionNoPresup.setSiiUsuarioRegistra(siiUsuario);
        }

        if (obligacionNoPresupVo.getUsuarioAprueba() != null &&
            obligacionNoPresupVo.getUsuarioAprueba().getUsuCodigo() != null) {
            SiiUsuario siiUsuario =
                usuarioDao.buscarUsuarioPorId(obligacionNoPresupVo.getUsuarioAprueba().getUsuCodigo());
            siiObligacionNoPresup.setSiiUsuarioAprueba(siiUsuario);
        }

        return (siiObligacionNoPresup);
    }

    public SiiImpContabOblNoPres convertir(ImpContabOblNoPresVO ImpContabOblNoPresVo) throws ExcepcionDAO {
        SiiImpContabOblNoPres siiImpContabOblNoPres = new SiiImpContabOblNoPres();
        // realizar la busqueda por codigo
        if (ImpContabOblNoPresVo.getIonCodigo() != null && ImpContabOblNoPresVo.getIonCodigo() > 0) {
            siiImpContabOblNoPres =
                impContabOblNoPresDao.buscarImpContabOblNoPresPorCodigo(ImpContabOblNoPresVo.getIonCodigo());
        }
        siiImpContabOblNoPres.setIonCodigo(ImpContabOblNoPresVo.getIonCodigo());
        siiImpContabOblNoPres.setIonEstado(ImpContabOblNoPresVo.getIonEstado());

        if (ImpContabOblNoPresVo.getCuentasContablesVo() != null) {
            SiiCuentasContables siiCuentasContables =
                cuentasContablesDao.buscarPorCodigo(ImpContabOblNoPresVo.getCuentasContablesVo().getCcoCodigo());
            siiImpContabOblNoPres.setSiiCuentasContables(siiCuentasContables);
        }
        if (ImpContabOblNoPresVo.getImputacionContableVo() != null) {
            SiiImputacionContable siiImputacionContable =
                imputacionContableDao.buscarPorCodigo(ImpContabOblNoPresVo.getImputacionContableVo().getImcCodigo());
            siiImpContabOblNoPres.setSiiImputacionContable(siiImputacionContable);
        }
        if (ImpContabOblNoPresVo.getObligacionNoPresupVo() != null) {
            SiiObligacionNoPresup siiObligacionNoPresup =
                obligacionNoPresupDao.buscarPorCodigoObligacionNoPres(ImpContabOblNoPresVo.getObligacionNoPresupVo().getOnpCodigo());
            siiImpContabOblNoPres.setSiiObligacionNoPresup(siiObligacionNoPresup);
        }


        return (siiImpContabOblNoPres);
    }

    public SiiDistribucionMes convertir(DistribucionMesVO distribucionMesVo) throws ExcepcionDAO {
        SiiDistribucionMes siiDistribucionMes = new SiiDistribucionMes();
        // realizar la busqueda por codigo
        if (distribucionMesVo.getDmeCodigo() != null && distribucionMesVo.getDmeCodigo() > 0) {
            siiDistribucionMes = distribucionMesDao.buscarPorCodigoDistribucionMes(distribucionMesVo.getDmeCodigo());
        }
        siiDistribucionMes.setDmeCodigo(distribucionMesVo.getDmeCodigo());
        siiDistribucionMes.setDcnNumero(distribucionMesVo.getDcnNumero());
        siiDistribucionMes.setDmeFechaDistrib(distribucionMesVo.getDmeFechaDistrib());
        siiDistribucionMes.setDmeVigencia(distribucionMesVo.getDmeVigencia());
        siiDistribucionMes.setDmeDescripcion(distribucionMesVo.getDmeDescripcion());
        siiDistribucionMes.setDmeResolucion(distribucionMesVo.getDmeResolucion());
        siiDistribucionMes.setDmeFechaResol(distribucionMesVo.getDmeFechaResol());
        siiDistribucionMes.setDmeTotRendimFinanc(distribucionMesVo.getDmeTotRendimFinanc());

        if (distribucionMesVo.getCierreRecaudoVo() != null) {
            SiiCierreRecaudo siiCierreRecaudo =
                cierreRecaudoDao.buscarPorCodigoCierreRecaudo(distribucionMesVo.getCierreRecaudoVo().getCirCodigo());
            siiDistribucionMes.setSiiCierreRecaudo(siiCierreRecaudo);
        }

        if (distribucionMesVo.getDocumentoConpesVo() != null) {
            SiiDocumentoConpes siiDocumentoConpes =
                documentoConpesDao.buscarDocumentoConpesPorId(distribucionMesVo.getDocumentoConpesVo().getDcnCodigo());
            siiDistribucionMes.setSiiDocumentoConpes(siiDocumentoConpes);
        }
        if (distribucionMesVo.getEstadoDistribEnteVo() != null) {
            SiiEstadoDistribEnte siiEstadoDistribEnte =
                estadoDistribEnteDao.buscarPorCodigo(distribucionMesVo.getEstadoDistribEnteVo().getEdeCodigo());
            siiDistribucionMes.setSiiEstadoDistribEnte(siiEstadoDistribEnte);
        }
        if (distribucionMesVo.getMesVo() != null) {
            SiiMes siiMes = mesDao.buscarMesPorId(distribucionMesVo.getMesVo().getMesCodigo());
            siiDistribucionMes.setSiiMes(siiMes);
        }

        return (siiDistribucionMes);
    }

    public SiiDetalleDistrib convertir(DetalleDistribVO detalleDistribVo) throws ExcepcionDAO {
        SiiDetalleDistrib siiDetalleDistrib = new SiiDetalleDistrib();
        // realizar la busqueda por codigo
        if (detalleDistribVo.getDdiCodigo() != null && detalleDistribVo.getDdiCodigo() > 0) {
            siiDetalleDistrib = detalleDistribDao.buscarPorCodigoDetalleDistrib(detalleDistribVo.getDdiCodigo());
        }
        siiDetalleDistrib.setDdiCodigo(detalleDistribVo.getDdiCodigo());
        siiDetalleDistrib.setDdiValorDetod(detalleDistribVo.getDdiValorDetod());
        siiDetalleDistrib.setDdiValorProp(detalleDistribVo.getDdiValorProp());
        siiDetalleDistrib.setDdiValorRec(detalleDistribVo.getDdiValorRec());
        siiDetalleDistrib.setDdiValorTodos(detalleDistribVo.getDdiValorTodos());
        siiDetalleDistrib.setDdiPorcentParticip(detalleDistribVo.getDdiPorcentParticip());
        siiDetalleDistrib.setDdiSubtotalTranf(detalleDistribVo.getDdiSubtotalTranf());
        siiDetalleDistrib.setDdiValColciencias(detalleDistribVo.getDdiValColciencias());
        siiDetalleDistrib.setDdiValRendimFinanc(detalleDistribVo.getDdiValRendimFinanc());
        siiDetalleDistrib.setDdiValTotMunicipios(detalleDistribVo.getDdiValTotMunicipios());
        siiDetalleDistrib.setDdiValTotSaypFosiga(detalleDistribVo.getDdiValTotSaypFosiga());
        siiDetalleDistrib.setDdiValTotalControl(detalleDistribVo.getDdiValTotalControl());
        siiDetalleDistrib.setDdiValTotalTranfer(detalleDistribVo.getDdiValTotalTranfer());

        if (detalleDistribVo.getDdiEsInteres() != null) {
            siiDetalleDistrib.setDdiEsInteres(detalleDistribVo.getDdiEsInteres());
        }

        if (detalleDistribVo.getCategoriaDistribVo() != null) {
            SiiCategoriaDistrib siiCategoriaDistrib =
                categoriaDistribDao.buscarPorCodigoCategoriaDistrib(detalleDistribVo.getCategoriaDistribVo().getCadCodigo());
            siiDetalleDistrib.setSiiCategoriaDistrib(siiCategoriaDistrib);
        }
        if (detalleDistribVo.getDistribucionMesVo() != null) {
            SiiDistribucionMes siiDistribucionMes =
                distribucionMesDao.buscarPorCodigoDistribucionMes(detalleDistribVo.getDistribucionMesVo().getDmeCodigo());
            siiDetalleDistrib.setSiiDistribucionMes(siiDistribucionMes);
        }

        if (detalleDistribVo.getEnteTerritorialVo() != null) {
            SiiEnteTerritorial siiEnteTerritorial =
                enteTerritorialDao.buscarEnteTerritorialPorId(detalleDistribVo.getEnteTerritorialVo().getEtiCodigo());
            siiDetalleDistrib.setSiiEnteTerritorial(siiEnteTerritorial);
        }

        return (siiDetalleDistrib);
    }

    public SiiNovedad convertir(NovedadVO novedadVo) throws ExcepcionDAO {
        SiiNovedad siiNovedad = new SiiNovedad();
        if (novedadVo.getNovCodigo() != null && novedadVo.getNovCodigo() > 0) {
            siiNovedad = novedadDAO.buscarNovedadPorId(novedadVo.getNovCodigo());
        }
        siiNovedad.setNovCodigo(novedadVo.getNovCodigo());
        siiNovedad.setNovFecha(novedadVo.getNovFecha());

        if (novedadVo.getContratoVO() != null) {
            SiiContrato siiContrato = contratoDao.buscarContratoPorId(novedadVo.getContratoVO().getConCodigo());
            siiNovedad.setSiiContrato(siiContrato);
        }

        if (novedadVo.getTipoNovedad() != null) {
            SiiTipoNovedad siiTipoNOvedad = tipoNovedadDao.buscarPorCodigo(novedadVo.getTipoNovedad().getTnoCodigo());
            siiNovedad.setSiiTipoNovedad(siiTipoNOvedad);
        }

        if (novedadVo.getSolicitudAutorizaVO() != null) {
            SiiSolicitudAutoriza siiSolicitud =
                solicitudAutorizaDao.buscarSolicitudAutorizacionPorCodigo(novedadVo.getSolicitudAutorizaVO().getSauCodigo());
            siiNovedad.setSiiSolicitudAutoriza(siiSolicitud);
        }

        if (novedadVo.getOtroSiVo() != null) {
            SiiOtrosi siiOtrosi = otroSiDao.buscarOtroSiPorId(novedadVo.getOtroSiVo().getOsiCodigo());
            siiNovedad.setSiiOtrosi(siiOtrosi);
        }

        return siiNovedad;
    }

    public SiiOtrosi convertir(OtroSiVO otroSiVo) throws ExcepcionDAO {
        SiiOtrosi siiOtroSi = new SiiOtrosi();
        if (otroSiVo.getOsiCodigo() != null && otroSiVo.getOsiCodigo() > 0) {
            siiOtroSi = otroSiDao.buscarOtroSiPorId(otroSiVo.getOsiCodigo());
        }
        siiOtroSi.setOsiCodigo(otroSiVo.getOsiCodigo());
        siiOtroSi.setOsiConsecutivo(otroSiVo.getOsiConsecutivo());
        siiOtroSi.setOsiFecha(otroSiVo.getOsiFecha());
        siiOtroSi.setOsiFechaCitOpe(otroSiVo.getOsiFechaCitOpe());
        siiOtroSi.setOsiFechaFirColj(otroSiVo.getOsiFechaFirColj());
        siiOtroSi.setOsiFechaFirOpe(otroSiVo.getOsiFechaFirOpe());
        siiOtroSi.setOsiFechaProgFir(otroSiVo.getOsiFechaProgFir());
        siiOtroSi.setOsiFechaRevAbog(otroSiVo.getOsiFechaRevAbog());
        siiOtroSi.setOsiFechaFin(otroSiVo.getOsiFechaFin());        
        siiOtroSi.setOsiTexValFin(otroSiVo.getOsiTexValFin());
        siiOtroSi.setOsiTexValGct(otroSiVo.getOsiTexValGct());
        //Padres:
        if (otroSiVo.getEstadoOtroSiVo() != null) {
            SiiEstadoOtrosi unSiiEstadoOtroSi =
                estadoOtrosiDao.buscarPorCodigo(otroSiVo.getEstadoOtroSiVo().getEosCodigo());
            siiOtroSi.setSiiEstadoOtrosi(unSiiEstadoOtroSi);
        }
        if (otroSiVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico unArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(otroSiVo.getArchivoFisicoVo().getAfiCodigo());
            siiOtroSi.setSiiArchivoFisico(unArchivoFisico);
        }

        return siiOtroSi;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param uvtVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiUvt convertir(UvtVO uvtVo) throws ExcepcionDAO {
        SiiUvt siiUvt = new SiiUvt();

        if (uvtVo.getUvtVigencia() != null && uvtVo.getUvtVigencia() > 0) {
            siiUvt = uvtDao.obtenerUvtPorVigencia(uvtVo.getUvtVigencia());
        }

        siiUvt.setUvtFecha(uvtVo.getUvtFecha());
        siiUvt.setUvtValor(uvtVo.getUvtValor());
        siiUvt.setUvtVigencia(uvtVo.getUvtVigencia());

        return (siiUvt);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param cargaNominaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiCargaNomina convertir(CargaNominaVO cargaNominaVo) throws ExcepcionDAO {
        SiiCargaNomina siiCargaNomina = new SiiCargaNomina();

        if (cargaNominaVo.getCnoCodigo() != null && cargaNominaVo.getCnoCodigo() > 0) {
            siiCargaNomina = cargaNominaDao.buscarPorCodigo(cargaNominaVo.getCnoCodigo());
        }

        siiCargaNomina.setCnoCodigo(cargaNominaVo.getCnoCodigo());
        siiCargaNomina.setCnoNombreArch(cargaNominaVo.getCnoNombreArch());
        siiCargaNomina.setCnoDescripcion(cargaNominaVo.getCnoDescripcion());


        // padres
        if (cargaNominaVo.getArchivoFisicoVo() != null && cargaNominaVo.getArchivoFisicoVo().getAfiCodigo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(cargaNominaVo.getArchivoFisicoVo().getAfiCodigo());
            siiCargaNomina.setSiiArchivoFisico(siiArchivoFisico);
        }

        return (siiCargaNomina);
    }


    /**
     *Conversion del Value Object a entidad de HistPersona
     * @param histPersonaVO
     * @return
     */
    public SiiHistPersona convertir(HistPersonaVO histPersonaVO) throws ExcepcionDAO {
        SiiHistPersona siiHistPersona = new SiiHistPersona();
        if (histPersonaVO.getHpeCodigo() != null && histPersonaVO.getHpeCodigo() > 0) {
            siiHistPersona = histPersonaDao.buscarPorCodigo(histPersonaVO.getHpeCodigo());
        }

        siiHistPersona.setHpeCelular(histPersonaVO.getHpeCelular());
        siiHistPersona.setHpeDigitoVerif(histPersonaVO.getHpeDigitoVerif());
        siiHistPersona.setHpeDireccion(histPersonaVO.getHpeDireccion());
        siiHistPersona.setHpeEmail(histPersonaVO.getHpeEmail());
        siiHistPersona.setHpeFax(histPersonaVO.getHpeFax());
        siiHistPersona.setHpeJurNombreCorto(histPersonaVO.getHpeJurNombreCorto());
        siiHistPersona.setHpeJurNombreLargo(histPersonaVO.getHpeJurNombreLargo());
        siiHistPersona.setHpeNumIdentificacion(histPersonaVO.getHpeNumIdentificacion());
        siiHistPersona.setHpeOrigen(histPersonaVO.getHpeOrigen());
        siiHistPersona.setHpePrimerApellido(histPersonaVO.getHpePrimerApellido());
        siiHistPersona.setHpePrimerNombre(histPersonaVO.getHpePrimerNombre());
        siiHistPersona.setHpeSegundoApellido(histPersonaVO.getHpeSegundoApellido());
        siiHistPersona.setHpeSegundoNombre(histPersonaVO.getHpeSegundoNombre());
        siiHistPersona.setHpeTelefono(histPersonaVO.getHpeTelefono());
        siiHistPersona.setHpeTelefono2(histPersonaVO.getHpeTelefono2());
        siiHistPersona.setHpeTipoPersona(histPersonaVO.getHpeTipoPersona());
        siiHistPersona.setHpeTipoProveedor(histPersonaVO.getHpeTipoProveedor());
        siiHistPersona.setRdiCodigoRenta(histPersonaVO.getRdiCodigoRenta());
        siiHistPersona.setRdiCodigoVentas(histPersonaVO.getRdiCodigoVentas());
        siiHistPersona.setTreCodigo(histPersonaVO.getTreCodigo());

        if (histPersonaVO.getUbicacionVO() != null && !histPersonaVO.getUbicacionVO().getUbiCodigo().equals("")) {
            SiiUbicacion siiUbicacion =
                ubicacionDao.buscarUbicacionPorId(histPersonaVO.getUbicacionVO().getUbiCodigo());
            siiHistPersona.setSiiUbicacion(siiUbicacion);
        }

        if (histPersonaVO.getTipoRetencionVentVO() != null &&
            !histPersonaVO.getTipoRetencionVentVO().getTreCodigo().equals("")) {
            SiiTipoRetencion siiTipoRetencionVent =
                tipoRetencionDao.buscarPorCodigo(histPersonaVO.getTipoRetencionVentVO().getTreCodigo());
            siiHistPersona.setSiiTipoRetencionVent(siiTipoRetencionVent);
        }

        if (histPersonaVO.getTipoRetencionRentVO() != null &&
            !histPersonaVO.getTipoRetencionRentVO().getTreCodigo().equals("")) {
            SiiTipoRetencion siiTipoRetencionRent =
                tipoRetencionDao.buscarPorCodigo(histPersonaVO.getTipoRetencionRentVO().getTreCodigo());
            siiHistPersona.setSiiTipoRetencionRent(siiTipoRetencionRent);
        }

        if (histPersonaVO.getPersonaOrigenVO() != null && histPersonaVO.getPersonaOrigenVO().getPerCodigo() > 0) {
            SiiPersona siiPersonaOrigen =
                personaDao.buscarPersonaPorId(histPersonaVO.getPersonaOrigenVO().getPerCodigo());
            siiHistPersona.setSiiPersonaOrigen(siiPersonaOrigen);
        }
        if (histPersonaVO.getHistPersonaRepLegalVO() != null &&
            histPersonaVO.getHistPersonaRepLegalVO().getHpeCodigo() > 0) {
            SiiHistPersona siiHistPersonaRepLegal =
                histPersonaDao.buscarPorCodigo(histPersonaVO.getHistPersonaRepLegalVO().getHpeCodigo());
            siiHistPersona.setSiiHistPersonaRepLegal(siiHistPersonaRepLegal);
        }

        if (histPersonaVO.getTipoIdentificacionVO() != null &&
            histPersonaVO.getTipoIdentificacionVO().getTidCodigo() > 0) {
            SiiTipoIdentificacion siiTipoIdentificacion =
                tipoIdentificacionDao.buscarTipoIdentificacionPorId(histPersonaVO.getTipoIdentificacionVO().getTidCodigo());
            siiHistPersona.setSiiTipoIdentificacion(siiTipoIdentificacion);
        }

        return siiHistPersona;
    }

    /**
     *Conversion del Value Object a la entidad de HistPersonalEmp
     * @param histPersonalEmpVO
     * @return
     */
    public SiiHistPersonalEmp convertir(HistPersonalEmpVO histPersonalEmpVO) throws ExcepcionDAO {
        SiiHistPersonalEmp siiHistPersonalEmp = new SiiHistPersonalEmp();
        if (histPersonalEmpVO.getHpmCodigo() != null && histPersonalEmpVO.getHpmCodigo() > 0) {
            siiHistPersonalEmp = histPersonalEmpDao.buscarPorCodigo(histPersonalEmpVO.getHpmCodigo());
        }

        siiHistPersonalEmp.setHpmActivo(histPersonalEmpVO.getHpmActivo());
        siiHistPersonalEmp.setHpmFechaRegistro(histPersonalEmpVO.getHpmFechaRegistro());
        siiHistPersonalEmp.setHpmFechaInactivac(histPersonalEmpVO.getHpmFechaInactivac());
        siiHistPersonalEmp.setHpmPorcentajePart(histPersonalEmpVO.getHpmPorcentajePart());

        if (histPersonalEmpVO.getHistPersonaEmpresaVO() != null &&
            histPersonalEmpVO.getHistPersonaEmpresaVO().getHpeCodigo() > 0) {
            SiiHistPersona siiHistPersonaEmpresa =
                histPersonaDao.buscarPorCodigo(histPersonalEmpVO.getHistPersonaEmpresaVO().getHpeCodigo());
            siiHistPersonalEmp.setSiiHistPersonaEmpresa(siiHistPersonaEmpresa);
        }

        if (histPersonalEmpVO.getTipoPersonalVO() != null && histPersonalEmpVO.getTipoPersonalVO().getTpeCodigo() > 0) {
            SiiTipoPersonal siiTipoPersonal =
                tipoPersonalDao.buscarTipoPersonalPorCodigo(histPersonalEmpVO.getTipoPersonalVO().getTpeCodigo());
            siiHistPersonalEmp.setSiiTipoPersonal(siiTipoPersonal);
        }

        if (histPersonalEmpVO.getHistPersonaPersonaVO() != null &&
            histPersonalEmpVO.getHistPersonaPersonaVO().getHpeCodigo() > 0) {
            SiiHistPersona siiHistPersonaPersona =
                histPersonaDao.buscarPorCodigo(histPersonalEmpVO.getHistPersonaPersonaVO().getHpeCodigo());
            siiHistPersonalEmp.setSiiHistPersonaPersona(siiHistPersonaPersona);
        }
        return siiHistPersonalEmp;
    }

    /**
     * @author Giovanni
     * @param hitosEmpresaVO
     * @return
     */
    public SiiHitosEmpresa convertir(HitosEmpresaVO hitosEmpresaVO) throws ExcepcionDAO {
        SiiHitosEmpresa siiHitosEmpresa = new SiiHitosEmpresa();
        if (hitosEmpresaVO.getHemCodigo() != null && hitosEmpresaVO.getHemCodigo() > 0) {
            siiHitosEmpresa = hitosEmpresaDao.buscarHitoEmpresaPorId(hitosEmpresaVO.getHemCodigo());
        }

        siiHitosEmpresa.setHemConsideraciones(hitosEmpresaVO.getHemConsideraciones());
        siiHitosEmpresa.setHemFecha(hitosEmpresaVO.getHemFecha());

        //Persona
        if (hitosEmpresaVO.getPersonaVO() != null && hitosEmpresaVO.getPersonaVO().getPerCodigo() != null &&
            hitosEmpresaVO.getPersonaVO().getPerCodigo() > 0) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(hitosEmpresaVO.getPersonaVO().getPerCodigo());
            siiHitosEmpresa.setSiiPersona(siiPersona);
        }
        return siiHitosEmpresa;
    }

    /**
     * @author Giovanni
     * @param personaCtaBancoVO
     * @return
     */
    public SiiPersonaCtaBanco convertir(PersonaCtaBancoVO personaCtaBancoVO) throws ExcepcionDAO {
        SiiPersonaCtaBanco siiPersonaCtaBanco = new SiiPersonaCtaBanco();
        if (personaCtaBancoVO.getPcbCodigo() != null) {
            siiPersonaCtaBanco = personaCtaBancoDao.buscarPorCodigo(personaCtaBancoVO.getPcbCodigo());
        }

        //Cuenta Banco
        if (personaCtaBancoVO.getCuentaBancoPersonaVo() != null &&
            personaCtaBancoVO.getCuentaBancoPersonaVo().getCbpCodigo() != null &&
            personaCtaBancoVO.getCuentaBancoPersonaVo().getCbpCodigo() > 0) {
            SiiCuentaBancoPersona siiCuentaBancoPersona =
                cuentaBancoPersonaDao.buscarCuentaBancoPersonaPorId(personaCtaBancoVO.getCuentaBancoPersonaVo().getCbpCodigo());
            siiPersonaCtaBanco.setSiiCuentaBancoPersona(siiCuentaBancoPersona);
        }

        //Persona
        if (personaCtaBancoVO.getPersonaVo() != null && personaCtaBancoVO.getPersonaVo().getPerCodigo() != null &&
            personaCtaBancoVO.getPersonaVo().getPerCodigo() > 0) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(personaCtaBancoVO.getPersonaVo().getPerCodigo());
            siiPersonaCtaBanco.setSiiPersona(siiPersona);
        }

        return siiPersonaCtaBanco;
    }

    /**
     * @author Giovanni
     * @param cuentaBancoPersonaVO
     * @return
     */
    public SiiCuentaBancoPersona convertir(CuentaBancoPersonaVO cuentaBancoPersonaVO) throws ExcepcionDAO {
        SiiCuentaBancoPersona siiCuentaBancoPersona = new SiiCuentaBancoPersona();
        if (cuentaBancoPersonaVO.getCbpCodigo() != null && cuentaBancoPersonaVO.getCbpCodigo() > 0) {
            siiCuentaBancoPersona =
                cuentaBancoPersonaDao.buscarCuentaBancoPersonaPorId(cuentaBancoPersonaVO.getCbpCodigo());
        }

        siiCuentaBancoPersona.setCbpActivo(cuentaBancoPersonaVO.getCbpActivo());
        siiCuentaBancoPersona.setCbpComentario(cuentaBancoPersonaVO.getCbpComentario());
        siiCuentaBancoPersona.setCbpNumero(cuentaBancoPersonaVO.getCbpNumero());
        siiCuentaBancoPersona.setCbpTipo(cuentaBancoPersonaVO.getCbpTipo());

        //Banco
        if (cuentaBancoPersonaVO.getBancoVo() != null && cuentaBancoPersonaVO.getBancoVo().getBanCodigo() != null) {
            SiiBanco siiBanco = bancoDao.buscarBancoXId(cuentaBancoPersonaVO.getBancoVo().getBanCodigo());
            siiCuentaBancoPersona.setSiiBanco(siiBanco);
        }

        return siiCuentaBancoPersona;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param detalleContNominaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiDetalleContNomina convertir(DetalleContNominaVO detalleContNominaVo) throws ExcepcionDAO {
        SiiDetalleContNomina siiDetalleContNomina = new SiiDetalleContNomina();

        if (detalleContNominaVo != null) {
            if (detalleContNominaVo.getDcmCodigo() != null && detalleContNominaVo.getDcmCodigo() > 0) {
                siiDetalleContNomina = detalleContNominaDao.buscarPorCodigo(detalleContNominaVo.getDcmCodigo());
            }

            siiDetalleContNomina.setDcmCodigo(detalleContNominaVo.getDcmCodigo());
            siiDetalleContNomina.setDcmContrato(detalleContNominaVo.getDcmContrato());
            siiDetalleContNomina.setDcmReferencia1(detalleContNominaVo.getDcmReferencia1());
            siiDetalleContNomina.setDcmTipoRetencion(detalleContNominaVo.getDcmTipoRetencion());
            siiDetalleContNomina.setDcmValor(detalleContNominaVo.getDcmValor());

            if (detalleContNominaVo.getFuenteFinancContabVo() != null &&
                detalleContNominaVo.getFuenteFinancContabVo().getFfcCodigo() != null) {
                SiiFuenteFinancContab siiFuenteFinancContab =
                    fuenteFinancContabDao.buscarPorCodigo(detalleContNominaVo.getFuenteFinancContabVo().getFfcCodigo());
                siiDetalleContNomina.setSiiFuenteFinancContab(siiFuenteFinancContab);
            }

            if (detalleContNominaVo.getObligacionVo() != null &&
                detalleContNominaVo.getObligacionVo().getOblCodigo() != null) {
                SiiObligacion siiObligacion = new SiiObligacion();
                siiObligacion.setOblCodigo(detalleContNominaVo.getObligacionVo().getOblCodigo());
                siiDetalleContNomina.setSiiObligacion(siiObligacion);
            }

            if (detalleContNominaVo.getPersonaVo() != null &&
                detalleContNominaVo.getPersonaVo().getPerCodigo() != null) {
                SiiPersona siiPersona =
                    personaDao.buscarPersonaPorId(detalleContNominaVo.getPersonaVo().getPerCodigo());
                siiDetalleContNomina.setSiiPersona(siiPersona);
            }

            if (detalleContNominaVo.getRpVo() != null && detalleContNominaVo.getRpVo().getRpCodigo() != null) {
                SiiRp siiRp = new SiiRp();
                siiRp.setRpCodigo(detalleContNominaVo.getRpVo().getRpCodigo());
                siiDetalleContNomina.setSiiRp(siiRp);
            }

            if (detalleContNominaVo.getAreaColjuegosVo() != null &&
                detalleContNominaVo.getAreaColjuegosVo().getAcoCodigo() != null) {
                SiiAreaColjuegos siiAreaColjuegos =
                    areaColjuegosDao.buscarAreaColjuegosPorId(detalleContNominaVo.getAreaColjuegosVo().getAcoCodigo());
                siiDetalleContNomina.setSiiAreaColjuegos(siiAreaColjuegos);
            }

            if (detalleContNominaVo.getConceptoNominaVo() != null &&
                detalleContNominaVo.getConceptoNominaVo().getCnoCodigo() != null) {
                SiiConceptoNomina siiConceptoNomina =
                    conceptoNominaDao.buscarPorCodigo(detalleContNominaVo.getConceptoNominaVo().getCnoCodigo());
                siiDetalleContNomina.setSiiConceptoNomina(siiConceptoNomina);
            }

            if (detalleContNominaVo.getCargaNominaVo() != null &&
                detalleContNominaVo.getCargaNominaVo().getCnoCodigo() != null) {
                SiiCargaNomina siiCargaNomina =
                    cargaNominaDao.buscarPorCodigo(detalleContNominaVo.getCargaNominaVo().getCnoCodigo());
                siiDetalleContNomina.setSiiCargaNomina(siiCargaNomina);
            }
        }

        return (siiDetalleContNomina);
    }


    public SiiActaIniContrato convertir(ActaIniContratoVO actaIniContratoVo) throws ExcepcionDAO {
        SiiActaIniContrato actaIniContrato = new SiiActaIniContrato();
        if (actaIniContrato.getAcnCodigo() != null && actaIniContrato.getAcnCodigo() > 0) {
            actaIniContrato = actaIniContratoDao.buscarActaIniContratoPorId(actaIniContratoVo.getAcnCodigo());
        }
        actaIniContrato.setAcnCodigo(actaIniContratoVo.getAcnCodigo());
        actaIniContrato.setAcnEstado(actaIniContratoVo.getAcnEstado());
        actaIniContrato.setAcnFechaIni(actaIniContratoVo.getAcnFechaIni());
        //Padres:
        if (actaIniContratoVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico archivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(actaIniContratoVo.getArchivoFisicoVo().getAfiCodigo());
            actaIniContrato.setSiiArchivoFisico(archivoFisico);
        }
        if (actaIniContratoVo.getClaseContratoVo() != null) {
            SiiClaseContrato claseContrato =
                claseContratoDao.buscarClaseContratoPorId(actaIniContratoVo.getClaseContratoVo().getClcCodigo());
            actaIniContrato.setSiiClaseContrato(claseContrato);
        }
        if (actaIniContratoVo.getProcesoContratacionVo() != null) {
            SiiProcesoContratacion procesoContratacion =
                procesoContratacionDao.buscarProcesoContratacionPorId(actaIniContratoVo.getProcesoContratacionVo().getPrcCodigo());
            actaIniContrato.setSiiProcesoContratacion(procesoContratacion);
        }
        return actaIniContrato;
    }

    public SiiInformeActaIni convertir(InformeActaIniVO informeActaIniVo) throws ExcepcionDAO {
        SiiInformeActaIni informeActaIni = new SiiInformeActaIni();
        if (informeActaIni.getIaiCodigo() != null && informeActaIni.getIaiCodigo() > 0) {
            informeActaIni = informeActaIniDao.buscarInformeActaIniPorId(informeActaIniVo.getIaiCodigo());
        }
        informeActaIni.setIaiCodigo(informeActaIniVo.getIaiCodigo());
        informeActaIni.setIaiFecha(informeActaIniVo.getIaiFecha());
        informeActaIni.setIaiPago(informeActaIniVo.getIaiPago());
        informeActaIni.setIaiTipoInforme(informeActaIniVo.getIaiTipoInforme());
        informeActaIni.setIaiValor(informeActaIniVo.getIaiValor());
        //Padres:
        if (informeActaIniVo.getActaIniContratoVo() != null) {
            SiiActaIniContrato actaIniContrato =
                actaIniContratoDao.buscarActaIniContratoPorId(informeActaIniVo.getActaIniContratoVo().getAcnCodigo());
            informeActaIni.setSiiActaIniContrato(actaIniContrato);
        }
        return informeActaIni;
    }

    public SiiCorteCartera convertir(CorteCarteraVO corteCarteraVo) throws ExcepcionDAO {
        SiiCorteCartera siiCorteCartera = new SiiCorteCartera();
        if (corteCarteraVo.getCcaCodigo() != null && corteCarteraVo.getCcaCodigo() > 0) {
            siiCorteCartera = corteCarteraDao.buscarCorteCarteraPorId(corteCarteraVo.getCcaCodigo());
        }
        siiCorteCartera.setCcaFecha(corteCarteraVo.getCcaFecha());
        siiCorteCartera.setCcaVigencia(corteCarteraVo.getCcaVigencia());
        if (corteCarteraVo.getMesVo() != null) {
            SiiMes siiMes = mesDao.buscarMesPorId(corteCarteraVo.getMesVo().getMesCodigo());
            siiCorteCartera.setSiiMes(siiMes);
        }
        if (corteCarteraVo.getUsuarioVo() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(corteCarteraVo.getUsuarioVo().getUsuCodigo());
            siiCorteCartera.setSiiUsuario(siiUsuario);
        }
        return siiCorteCartera;
    }

    public SiiCargaRp convertir(CargaRpVO cargaRpVo) throws ExcepcionDAO {
        SiiCargaRp cargaRp = new SiiCargaRp();
        if (cargaRpVo.getCrpCodigo() != null && cargaRpVo.getCrpCodigo() > 0) {
            cargaRp = cargaRpDao.buscarCargaRpPorId(cargaRpVo.getCrpCodigo());
        }
        cargaRp.setCrpNombreArch(cargaRpVo.getCrpNombreArch());
        cargaRp.setCrpDescripcion(cargaRpVo.getCrpDescripcion());
        //Padres:
        if (cargaRpVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico archivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(cargaRpVo.getArchivoFisicoVo().getAfiCodigo());
            cargaRp.setSiiArchivoFisico(archivoFisico);
        }
        return cargaRp;
    }

    /**
     *
     * @param tasaIntSuperbanVO
     * @return
     */
    public SiiTasaIntSuperban convertir(TasaIntSuperbanVO tasaIntSuperbanVO) throws ExcepcionDAO {
        SiiTasaIntSuperban siiTasaIntSuperban = new SiiTasaIntSuperban();
        if (tasaIntSuperbanVO.getTisCodigo() != null && tasaIntSuperbanVO.getTisCodigo().intValue() > 0) {
            siiTasaIntSuperban = tasaIntSuperbanDao.buscarTasaIntSuperbanPorId(tasaIntSuperbanVO.getTisCodigo());
        }

        siiTasaIntSuperban.setTisActivo(tasaIntSuperbanVO.getTisActivo());
        siiTasaIntSuperban.setTisCodigo(tasaIntSuperbanVO.getTisCodigo());
        siiTasaIntSuperban.setTisFecha(tasaIntSuperbanVO.getTisFecha());
        siiTasaIntSuperban.setTisTasa(tasaIntSuperbanVO.getTisTasa());
        siiTasaIntSuperban.setTisVigenDesde(tasaIntSuperbanVO.getTisVigenDesde());
        siiTasaIntSuperban.setTisVigenHasta(tasaIntSuperbanVO.getTisVigenHasta());
        siiTasaIntSuperban.setTisTipoInteres(tasaIntSuperbanVO.getTisTipoInteres());

        return siiTasaIntSuperban;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param ctaContabConcepCuotaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiCtaContabConcepCuota convertir(CtaContabConcepCuotaVO ctaContabConcepCuotaVo) throws ExcepcionDAO {
        SiiCtaContabConcepCuota siiCtaContabConcepCuota = new SiiCtaContabConcepCuota();
        if (ctaContabConcepCuotaVo != null && ctaContabConcepCuotaVo.getCccCodigo() != null &&
            ctaContabConcepCuotaVo.getCccCodigo() > 0) {
            siiCtaContabConcepCuota = ctaContabConcepCuotaDao.buscarPorCodigo(ctaContabConcepCuotaVo.getCccCodigo());
        }

        siiCtaContabConcepCuota.setCccCodigo(ctaContabConcepCuotaVo.getCccCodigo());
        siiCtaContabConcepCuota.setCccInteres(ctaContabConcepCuotaVo.getCccInteres());
        siiCtaContabConcepCuota.setCccTipo(ctaContabConcepCuotaVo.getCccTipo());

        //Padres:
        if (ctaContabConcepCuotaVo.getConceptoCuotaVo() != null &&
            ctaContabConcepCuotaVo.getConceptoCuotaVo().getCcuCodigo() != null) {
            SiiConceptoCuota siiConceptoCuota =
                conceptoCuotaDao.buscarConceptoCuotaXId(ctaContabConcepCuotaVo.getConceptoCuotaVo().getCcuCodigo());
            siiCtaContabConcepCuota.setSiiConceptoCuota(siiConceptoCuota);
        }
        if (ctaContabConcepCuotaVo.getCuentasContablesVo() != null &&
            ctaContabConcepCuotaVo.getCuentasContablesVo().getCcoCodigo() != null) {
            SiiCuentasContables siiCuentasContables =
                cuentasContablesDao.buscarPorCodigo(ctaContabConcepCuotaVo.getCuentasContablesVo().getCcoCodigo());
            siiCtaContabConcepCuota.setSiiCuentasContables(siiCuentasContables);
        }

        return (siiCtaContabConcepCuota);
    }

    /**
     *
     * @param tasaIntSuperbanVO
     * @return
     */
    public SiiExpedienteDocum convertir(ExpedienteDocumVO expedienteDocumVo) {
        SiiExpedienteDocum siiExpedienteDocum = new SiiExpedienteDocum();

        siiExpedienteDocum.setEdoCodigo(expedienteDocumVo.getEdoCodigo());
        siiExpedienteDocum.setEdoFecha(expedienteDocumVo.getEdoFecha());

        return siiExpedienteDocum;
    }


    public SiiRifaPromocional convertir(SolicitudPromocionalesVO SolicitudPromocionalesVo) throws ExcepcionDAO {
        SiiRifaPromocional siiRifaPromocional = new SiiRifaPromocional();
        if (SolicitudPromocionalesVo.getIdSolicitud() != null && SolicitudPromocionalesVo.getIdSolicitud() > 0) {
            siiRifaPromocional =
                rifaPromocionalDao.buscarPorCodigoRifaPromocional(SolicitudPromocionalesVo.getIdSolicitud());
        }
        siiRifaPromocional.setRfpCodigo(siiRifaPromocional.getRfpCodigo());
        siiRifaPromocional.setRfpConsecutivo(SolicitudPromocionalesVo.getConsecutivo());
        siiRifaPromocional.setRfpFechaFin(SolicitudPromocionalesVo.getFechaCierre());
        siiRifaPromocional.setRfpFechaInicio(SolicitudPromocionalesVo.getFechaInicio());
        siiRifaPromocional.setRfpNombre(SolicitudPromocionalesVo.getNombreJuego());
        siiRifaPromocional.setRfpValorDe(SolicitudPromocionalesVo.getValorDE());
        siiRifaPromocional.setRfpValorGa(SolicitudPromocionalesVo.getValorGA());
        siiRifaPromocional.setRfpValorTotal(SolicitudPromocionalesVo.getValorTotalPremios());
        siiRifaPromocional.setRfpResolucion(SolicitudPromocionalesVo.getNumeroResolucion());
        siiRifaPromocional.setRfpFechaResol(SolicitudPromocionalesVo.getFechaResolucion());

        siiRifaPromocional.setRfpFechaResDesExp(SolicitudPromocionalesVo.getFechaRadicaciónExp());
        siiRifaPromocional.setRfpResolDesistExpr(SolicitudPromocionalesVo.getNumeroRadicaciónExp());
        siiRifaPromocional.setRfpResolDesistTaci(SolicitudPromocionalesVo.getNumeroResTacito());
        siiRifaPromocional.setRfpFechaResDesTaci(SolicitudPromocionalesVo.getFechaResTacito());

        if (SolicitudPromocionalesVo.getTipoApuestaVo() != null) {
            SiiTipoApuesta siiTipoApuesta =
                tipoApuestaDao.buscarTipoApuestaPorCodigo(SolicitudPromocionalesVo.getTipoApuestaVo().getTapCodigo());
            siiRifaPromocional.setSiiTipoApuesta(siiTipoApuesta);
        }
        if (SolicitudPromocionalesVo.getSolicitudAutorizaVo() != null) {
            if (SolicitudPromocionalesVo.getSolicitudAutorizaVo().getSauCodigo() != null) {
                SiiSolicitudAutoriza siiSolicitudAutoriza =
                    solicitudAutorizaDao.buscarSolicitudAutorizacionPorCodigo(SolicitudPromocionalesVo.getSolicitudAutorizaVo().getSauCodigo());
                siiRifaPromocional.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
            }
        }


        return siiRifaPromocional;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param vigenciaFuturaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiVigenciaFutura convertir(VigenciaFuturaVO vigenciaFuturaVo) throws ExcepcionDAO {
        SiiVigenciaFutura siiVigenciaFutura = new SiiVigenciaFutura();

        if (vigenciaFuturaVo != null) {
            if (vigenciaFuturaVo.getVfuCodigo() != null && vigenciaFuturaVo.getVfuCodigo() > 0) {
                siiVigenciaFutura = vigenciaFuturaDao.buscarPorCodigo(vigenciaFuturaVo.getVfuCodigo());
            }

            siiVigenciaFutura.setVfuCodigo(vigenciaFuturaVo.getVfuCodigo());
            siiVigenciaFutura.setVfuEstado(vigenciaFuturaVo.getVfuEstado());
            siiVigenciaFutura.setVfuFechaOficioAut(vigenciaFuturaVo.getVfuFechaOficioAut());
            siiVigenciaFutura.setVfuNumOficioAut(vigenciaFuturaVo.getVfuNumOficioAut());
            siiVigenciaFutura.setVfuVigencia(vigenciaFuturaVo.getVfuVigencia());
        }

        return (siiVigenciaFutura);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param detRubroVigenFuturaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiDetRubroVigenFutura convertir(DetRubroVigenFuturaVO detRubroVigenFuturaVo) throws ExcepcionDAO {
        SiiDetRubroVigenFutura siiDetRubroVigenFutura = new SiiDetRubroVigenFutura();

        if (detRubroVigenFuturaVo != null) {
            if (detRubroVigenFuturaVo.getDrvCodigo() != null && detRubroVigenFuturaVo.getDrvCodigo() > 0) {
                siiDetRubroVigenFutura = detRubroVigenFuturaDao.buscarPorCodigo(detRubroVigenFuturaVo.getDrvCodigo());
            }

            siiDetRubroVigenFutura.setDrvCodigo(detRubroVigenFuturaVo.getDrvCodigo());
            siiDetRubroVigenFutura.setDrvEstado(detRubroVigenFuturaVo.getDrvEstado());
            siiDetRubroVigenFutura.setDrvValor(detRubroVigenFuturaVo.getDrvValor());
            siiDetRubroVigenFutura.setDrvVigencia(detRubroVigenFuturaVo.getDrvVigencia());


            if (detRubroVigenFuturaVo.getDetalleRubroVo() != null &&
                detRubroVigenFuturaVo.getDetalleRubroVo().getDruCodigo() != null) {
                SiiDetalleRubro siiDetalleRubro =
                    detalleRubroDao.buscarPorCodigoDetalleRubro(detRubroVigenFuturaVo.getDetalleRubroVo().getDruCodigo());
                siiDetRubroVigenFutura.setSiiDetalleRubro(siiDetalleRubro);
            }

            if (detRubroVigenFuturaVo.getVigenciaFuturaVo() != null &&
                detRubroVigenFuturaVo.getVigenciaFuturaVo().getVfuCodigo() != null) {
                SiiVigenciaFutura siiVigenciaFutura =
                    vigenciaFuturaDao.buscarPorCodigo(detRubroVigenFuturaVo.getVigenciaFuturaVo().getVfuCodigo());
                siiDetRubroVigenFutura.setSiiVigenciaFutura(siiVigenciaFutura);
            }
        }

        return (siiDetRubroVigenFutura);
    }

    public SiiRevisionFinan convertir(RevisionFinanVO revVo) throws ExcepcionDAO {
        SiiRevisionFinan rev = new SiiRevisionFinan();
        if (revVo != null) {
            if (revVo.getRfiCodigo() != null && revVo.getRfiCodigo() > 0) {
                rev = revisionFinanDao.buscarRevisionFinan(revVo.getRfiCodigo());
            }
            rev.setRfiCodigo(revVo.getRfiCodigo());
            rev.setRfiFecha(revVo.getRfiFecha());
            rev.setRfiObservac(revVo.getRfiObservac());
            rev.setRfiValida(revVo.getRfiValida());
            rev.setRfiTipoValidac(revVo.getRfiTipoValidac());

            if (revVo.getContratoVo() != null && revVo.getContratoVo().getConCodigo() != null) {
                rev.setSiiContrato(contratoDao.buscarContratoPorId(revVo.getContratoVo().getConCodigo()));
            }

        }
        return rev;
    }

    public SiiRevisionGct convertir(RevisionGctVO revVo) throws ExcepcionDAO {
        SiiRevisionGct rev = new SiiRevisionGct();
        if (revVo != null) {
            if (revVo.getRgcCodigo() != null && revVo.getRgcCodigo() > 0) {
                rev = revisionGctDao.buscarRevisionGct(revVo.getRgcCodigo());
            }
            rev.setRgcCodigo(revVo.getRgcCodigo());
            rev.setRgcFecha(revVo.getRgcFecha());
            rev.setRgcObservac(revVo.getRgcObservac());
            rev.setRgcValido(revVo.getRgcValido());

            if (revVo.getContratoVo() != null && revVo.getContratoVo().getConCodigo() != null) {
                rev.setSiiContrato(contratoDao.buscarContratoPorId(revVo.getContratoVo().getConCodigo()));
            }

        }
        return rev;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param cierreAnualContableVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiCierreAnualContable convertir(CierreAnualContableVO cierreAnualContableVo) throws ExcepcionDAO {
        SiiCierreAnualContable siiCierreAnualContable = new SiiCierreAnualContable();

        if (cierreAnualContableVo != null) {
            if (cierreAnualContableVo.getCacCodigo() != null && cierreAnualContableVo.getCacCodigo() > 0) {
                siiCierreAnualContable = cierreAnualContableDao.buscarPorCodigo(cierreAnualContableVo.getCacCodigo());
            }

            siiCierreAnualContable.setCacCodigo(cierreAnualContableVo.getCacCodigo());
            siiCierreAnualContable.setCacBancarias(cierreAnualContableVo.getCacBancarias());
            siiCierreAnualContable.setCacFechaCierre(cierreAnualContableVo.getCacFechaCierre());
            siiCierreAnualContable.setCacImpuestos(cierreAnualContableVo.getCacImpuestos());
            siiCierreAnualContable.setCacVigFiscal(cierreAnualContableVo.getCacVigFiscal());
            siiCierreAnualContable.setCacVigencia(cierreAnualContableVo.getCacVigencia());


            if (cierreAnualContableVo.getEstadoCierreAnualContVo() != null &&
                cierreAnualContableVo.getEstadoCierreAnualContVo().getEcaCodigo() != null) {
                SiiEstadoCierreAnualCont siiEstadoCierreAnualCont =
                    estadoCierreAnualContDao.buscarPorCodigo(cierreAnualContableVo.getEstadoCierreAnualContVo().getEcaCodigo());
                siiCierreAnualContable.setSiiEstadoCierreAnualCont(siiEstadoCierreAnualCont);
            }
        }

        return (siiCierreAnualContable);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param AcuerdoPagoVO - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiAcuerdoPago convertir(AcuerdoPagoVO acuerdoPagoVo) throws ExcepcionDAO {
        SiiAcuerdoPago siiAcuerdoPago = new SiiAcuerdoPago();

        if (acuerdoPagoVo != null) {
            if (acuerdoPagoVo.getApaCodigo() != null && acuerdoPagoVo.getApaCodigo() > 0) {
                siiAcuerdoPago = acuerdoPagoDao.buscarAcuerdoPagoPorCodigo(acuerdoPagoVo.getApaCodigo());
            }

            siiAcuerdoPago.setApaCodigo(acuerdoPagoVo.getApaCodigo());
            siiAcuerdoPago.setApaFecha(acuerdoPagoVo.getApaFecha());
            siiAcuerdoPago.setApaFechaResol(acuerdoPagoVo.getApaFechaResol());
            siiAcuerdoPago.setApaNumResol(acuerdoPagoVo.getApaNumResol());
            siiAcuerdoPago.setApaNumero(acuerdoPagoVo.getApaNumero());
            siiAcuerdoPago.setApaFechaInicio(acuerdoPagoVo.getApaFechaInicio());
            siiAcuerdoPago.setApaFechaFin(acuerdoPagoVo.getApaFechaFin());
            siiAcuerdoPago.setApaFechaFirmaRes(acuerdoPagoVo.getApaFechaFirmaRes());
            siiAcuerdoPago.setApaResolucModif(acuerdoPagoVo.getApaResolucModif());
            siiAcuerdoPago.setApaNumComiteApr(acuerdoPagoVo.getApaNumComiteApr());
            siiAcuerdoPago.setApaFechaAprComite(acuerdoPagoVo.getApaFechaAprComite());
            siiAcuerdoPago.setApaDocOrigen(acuerdoPagoVo.getApaDocOrigen());


            if (acuerdoPagoVo.getEstadoAcuerdoPagoVo() != null &&
                acuerdoPagoVo.getEstadoAcuerdoPagoVo().getEapCodigo() != null) {
                SiiEstadoAcuerdoPago siiEstadoAcuerdoPago =
                    estadoAcuerdoPagoDao.buscarEstadoAcuerdoPagoPorId(acuerdoPagoVo.getEstadoAcuerdoPagoVo().getEapCodigo());
                siiAcuerdoPago.setSiiEstadoAcuerdoPago(siiEstadoAcuerdoPago);
            }
            if (acuerdoPagoVo.getPersonaVo() != null && acuerdoPagoVo.getPersonaVo().getPerCodigo() != null) {
                SiiPersona siiPersona = personaDao.buscarPersonaPorId(acuerdoPagoVo.getPersonaVo().getPerCodigo());
                siiAcuerdoPago.setSiiPersona(siiPersona);
            }
            if (acuerdoPagoVo.getTipoOrigenVo() != null && acuerdoPagoVo.getTipoOrigenVo().getTorCodigo() != null) {
                SiiTipoOrigen siiTipoOrigen =
                    tipoOrigenDao.buscarTipoOrigenPorId(acuerdoPagoVo.getTipoOrigenVo().getTorCodigo());
                siiAcuerdoPago.setSiiTipoOrigen(siiTipoOrigen);
            }

        }

        return (siiAcuerdoPago);
    }

    public SiiRevisionFinancResolAutoriz convertir(RevisionFinancResolAutorizVO rev) throws ExcepcionDAO {
        SiiRevisionFinancResolAutoriz siiRev = new SiiRevisionFinancResolAutoriz();
        if (rev != null) {
            if (rev.getRfrCodigo() != null && rev.getRfrCodigo() > 0) {
                siiRev = revisionFinancResolAutorizDao.buscarRevisionFinancResolAutoriz(rev.getRfrCodigo());
            }
        }
        siiRev.setRfrCodigo(rev.getRfrCodigo());
        siiRev.setRfrFecha(rev.getRfrFecha());
        siiRev.setRfrObservaciones(rev.getRfrObservaciones());
        siiRev.setRfrValida(rev.getRfrValida());
        //Padres:
        if (rev.getResolucionAutorizVo() != null && rev.getResolucionAutorizVo().getRauCodigo() != null) {
            SiiResolucionAutoriz siiResolucionAutoriz =
                resolucionAutorizDao.buscarResolucionAutorizPorId(rev.getResolucionAutorizVo().getRauCodigo());
            siiRev.setSiiResolucionAutoriz(siiResolucionAutoriz);
        }
        return siiRev;
    }

    public SiiRevisionGctResolucAutoriza convertir(RevisionGctResolucAutorizaVO rev) throws ExcepcionDAO {
        SiiRevisionGctResolucAutoriza siiRev = new SiiRevisionGctResolucAutoriza();
        if (rev != null) {
            if (rev.getRgrCodigo() != null && rev.getRgrCodigo() > 0) {
                siiRev = revisionGctResolucAutorizaDao.buscarRevisionGctResolucAutoriza(rev.getRgrCodigo());
            }
        }
        siiRev.setRgrCodigo(rev.getRgrCodigo());
        siiRev.setRgrFecha(rev.getRgrFecha());
        siiRev.setRgrObservaciones(rev.getRgrObservaciones());
        siiRev.setRgrValida(rev.getRgrValida());
        //Padres:
        if (rev.getResolucionAutorizVo() != null && rev.getResolucionAutorizVo().getRauCodigo() != null) {
            SiiResolucionAutoriz siiResolucionAutoriz =
                resolucionAutorizDao.buscarResolucionAutorizPorId(rev.getResolucionAutorizVo().getRauCodigo());
            siiRev.setSiiResolucionAutoriz(siiResolucionAutoriz);

        }
        return siiRev;
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param cuotaOperadorVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiCuotaOperador convertir(CuotaOperadorVO cuotaOperadorVo) throws ExcepcionDAO {
        SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
        if (cuotaOperadorVo.getCopCodigo() != null && cuotaOperadorVo.getCopCodigo() > 0) {
            siiCuotaOperador = cuotaOperadorDao.buscarCuotaOperadorPorId(cuotaOperadorVo.getCopCodigo());
        }

        siiCuotaOperador.setCopAbonoIni(cuotaOperadorVo.getCopAbonoIni());
        siiCuotaOperador.setCopAbonoIniInt(cuotaOperadorVo.getCopAbonoIniInt());
        siiCuotaOperador.setCopCancelada(cuotaOperadorVo.getCopCancelada());
        siiCuotaOperador.setCopCodigo(cuotaOperadorVo.getCopCodigo());
        siiCuotaOperador.setCopFechaLimPag(cuotaOperadorVo.getCopFechaLimitepago());
        siiCuotaOperador.setCopNumCuota(cuotaOperadorVo.getCopNumerocuota());
        siiCuotaOperador.setCopTipoCartera(cuotaOperadorVo.getCopTipoCartera());
        siiCuotaOperador.setCopValor(cuotaOperadorVo.getCopValor());
        siiCuotaOperador.setCopValorIncApa(cuotaOperadorVo.getCopValorIncApa());
        siiCuotaOperador.setCopValorIncIntApa(cuotaOperadorVo.getCopValorIncIntApa());
        siiCuotaOperador.setCopVigencia(cuotaOperadorVo.getCopVigencia());
        siiCuotaOperador.setMesCodigo(cuotaOperadorVo.getMesCodigo());
        siiCuotaOperador.setCopTipoDocSopor(cuotaOperadorVo.getCopTipoDocSoporte());
        if (cuotaOperadorVo.getAcuerdoPagoVo() != null && cuotaOperadorVo.getAcuerdoPagoVo().getApaCodigo() > 0) {
            SiiAcuerdoPago siiAcuerdoPago =
                acuerdoPagoDao.buscarAcuerdoPagoPorCodigo(cuotaOperadorVo.getAcuerdoPagoVo().getApaCodigo());
            siiCuotaOperador.setSiiAcuerdoPago(siiAcuerdoPago);
        }
        if (cuotaOperadorVo.getConceptoCuotaVo() != null && cuotaOperadorVo.getConceptoCuotaVo().getCcuCodigo() > 0) {
            SiiConceptoCuota siiConceptoCuota =
                conceptoCuotaDao.buscarConceptoCuotaXId(cuotaOperadorVo.getConceptoCuotaVo().getCcuCodigo());
            siiCuotaOperador.setSiiConceptoCuota(siiConceptoCuota);
        }
        if (cuotaOperadorVo.getOperadorVo() != null && cuotaOperadorVo.getOperadorVo().getOpeCodigo() > 0) {
            SiiOperador siiOperador =
                operadorDao.buscarPorCodigoOperador(cuotaOperadorVo.getOperadorVo().getOpeCodigo());
            siiCuotaOperador.setSiiOperador(siiOperador);
        }

        /*if (cuotaOperadorVo.getReporteVentasVo() != null && cuotaOperadorVo.getReporteVentasVo().getRveCodigo() > 0) {
            SiiReporteVentas siiReporteVentas =
                reporteVentasDao.buscarReporteVentasPorCodigo(cuotaOperadorVo.getReporteVentasVo().getRveCodigo());
            siiCuotaOperador.setSiiReporteVentas(siiReporteVentas);
        }*/
        
        if (cuotaOperadorVo.getIncumplimientoContrVo()!=null && cuotaOperadorVo.getIncumplimientoContrVo().getIcnCodigo()!=null) {
            SiiIncumplimientoContr siiIncumplimientoContr = incumplimientoContrDao.buscarPorCodigo(cuotaOperadorVo.getIncumplimientoContrVo().getIcnCodigo());
            siiCuotaOperador.setSiiIncumplimientoContr(siiIncumplimientoContr);
        }
        
        if (cuotaOperadorVo.getProcesoSancionatorioVo()!=null && cuotaOperadorVo.getProcesoSancionatorioVo().getPsaCodigo()!=null) {
            SiiProcesoSancionatorio siiProcesoSancionatorio = procesoSancionatorioDao.buscarPorCodigo(cuotaOperadorVo.getProcesoSancionatorioVo().getPsaCodigo());
            siiCuotaOperador.setSiiProcesoSancionatorio(siiProcesoSancionatorio);
        }
        
        if (cuotaOperadorVo.getProcesoSancIlegalidadVo()!= null && cuotaOperadorVo.getProcesoSancIlegalidadVo().getPrsCodigo()!=null){
            siiCuotaOperador.setSiiProcesoSancIlegalidad(procesoSancIlegalidadDao.buscarPorCodigo(cuotaOperadorVo.getProcesoSancIlegalidadVo().getPrsCodigo()));
        }

        return (siiCuotaOperador);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param hlpCuotaAcuerdoVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiHlpCuotaAcuerdo convertir(HlpCuotaAcuerdoVO hlpCuotaAcuerdoVo) throws ExcepcionDAO {
        SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo = new SiiHlpCuotaAcuerdo();
        if (hlpCuotaAcuerdoVo.getHcaCodigo() != null && hlpCuotaAcuerdoVo.getHcaCodigo() > 0) {
            siiHlpCuotaAcuerdo = hlpCuotaAcuerdoDao.buscarHlpCuotaAcuerdoPorCodigo(hlpCuotaAcuerdoVo.getHcaCodigo());
        }
        siiHlpCuotaAcuerdo.setHcaCodigo(hlpCuotaAcuerdoVo.getHcaCodigo());
        siiHlpCuotaAcuerdo.setCcuCodigo(hlpCuotaAcuerdoVo.getCcuCodigo());
        siiHlpCuotaAcuerdo.setHcaFechaPago(hlpCuotaAcuerdoVo.getHcaFechaPago());
        siiHlpCuotaAcuerdo.setHcaNumCuota(hlpCuotaAcuerdoVo.getHcaNumCuota());
        siiHlpCuotaAcuerdo.setHcaValor(hlpCuotaAcuerdoVo.getHcaValor());
        siiHlpCuotaAcuerdo.setHcaVigencia(hlpCuotaAcuerdoVo.getHcaVigencia());
        if (hlpCuotaAcuerdoVo.getAcuerdoPagoVo() != null) {
            SiiAcuerdoPago siiAcuerdoPago =
                acuerdoPagoDao.buscarAcuerdoPagoPorCodigo(hlpCuotaAcuerdoVo.getAcuerdoPagoVo().getApaCodigo());
            siiHlpCuotaAcuerdo.setSiiAcuerdoPago(siiAcuerdoPago);
        }
        if (hlpCuotaAcuerdoVo.getMesVo() != null) {
            SiiMes siiMes = mesDao.buscarMesPorId(hlpCuotaAcuerdoVo.getMesVo().getMesCodigo());
            siiHlpCuotaAcuerdo.setSiiMes(siiMes);
        }

        return (siiHlpCuotaAcuerdo);
    }


    public SiiLiquidacionContrato convertir(LiquidacionContratoVO liquidacionContratoVo) throws ExcepcionDAO {
        SiiLiquidacionContrato siiLiqContrato = new SiiLiquidacionContrato();
        if (liquidacionContratoVo.getLcoCodigo() != null && liquidacionContratoVo.getLcoCodigo() > 0) {
            siiLiqContrato = liquidacionContratoDao.buscarLiquidacionContratoXId(liquidacionContratoVo.getLcoCodigo());
        }
        siiLiqContrato.setLcoCodigo(liquidacionContratoVo.getLcoCodigo());
        siiLiqContrato.setLcoFechaCita(liquidacionContratoVo.getLcoFechaCita());
        siiLiqContrato.setLcoFechaGenInfFin(liquidacionContratoVo.getLcoFechaGenInfFin());
        siiLiqContrato.setLcoFechaBorrCit(liquidacionContratoVo.getLcoFechaBorrCit());
        siiLiqContrato.setLcoFechaGenOfiCit(liquidacionContratoVo.getLcoFechaGenOfiCit());
        siiLiqContrato.setLcoFechaLiq(liquidacionContratoVo.getLcoFechaLiq());
        siiLiqContrato.setLcoIndicaEstCta(liquidacionContratoVo.getLcoIndicadorCuenta());
        siiLiqContrato.setLcoRadicadoInfFin(liquidacionContratoVo.getNumeroGenInFinal());
        siiLiqContrato.setLcoRadicadoOfiCit(liquidacionContratoVo.getNumeroRadGenOfiCita());


        if (liquidacionContratoVo.getCausalTerContratoVo() != null &&
            liquidacionContratoVo.getCausalTerContratoVo().getCtcCodigo() > 0) {
            SiiCausalTermContr siiCausalTermContr =
                causalTermContratoDao.buscarSiiCausalTermContrXId(liquidacionContratoVo.getCausalTerContratoVo().getCtcCodigo());
            siiLiqContrato.setSiiCausalTermContr(siiCausalTermContr);
        }
        if (liquidacionContratoVo.getContratoVo() != null && liquidacionContratoVo.getContratoVo().getConCodigo() > 0) {
            SiiContrato siiContrato =
                contratoDao.buscarContratoPorId(liquidacionContratoVo.getContratoVo().getConCodigo());
            siiLiqContrato.setSiiContrato(siiContrato);
        }
        if (liquidacionContratoVo.getEstadoLiquidacionContratoVo() != null &&
            liquidacionContratoVo.getEstadoLiquidacionContratoVo().getElcCodigo() > 0) {
            SiiEstadoLiquidCont siiEstadoLiquidCont =
                estadoLiqContratoDao.buscarEstadoLiqContratoXId(liquidacionContratoVo.getEstadoLiquidacionContratoVo().getElcCodigo());
            siiLiqContrato.setSiiEstadoLiquidCont(siiEstadoLiquidCont);
        }
        if (liquidacionContratoVo.getArcFisicoInfFinal() != null &&
            liquidacionContratoVo.getArcFisicoInfFinal().getAfiCodigo() > 0) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(liquidacionContratoVo.getArcFisicoInfFinal().getAfiCodigo());
            siiLiqContrato.setSiiArchivoFisicoInfFinal(siiArchivoFisico);
        }
        if (liquidacionContratoVo.getArcFisicoOfiCita() != null &&
            liquidacionContratoVo.getArcFisicoOfiCita().getAfiCodigo() > 0) {
            SiiArchivoFisico siiArchivoFisico2 =
                archivoFisicoDao.buscarArchivoFisicoPorId(liquidacionContratoVo.getArcFisicoOfiCita().getAfiCodigo());
            siiLiqContrato.setSiiArchivoFisicoOficioCita(siiArchivoFisico2);
        }
        if (liquidacionContratoVo.getArcFisicoLiqFir() != null &&
            liquidacionContratoVo.getArcFisicoLiqFir().getAfiCodigo() > 0) {
            SiiArchivoFisico siiArchivoFisico3 =
                archivoFisicoDao.buscarArchivoFisicoPorId(liquidacionContratoVo.getArcFisicoLiqFir().getAfiCodigo());
            siiLiqContrato.setSiiArchivoFisicoActaLiq(siiArchivoFisico3);
        }


        return (siiLiqContrato);
    }

    public SiiBeneficiarioEnte convertir(BeneficiarioEnteVO beneficiarioEnteVo) throws ExcepcionDAO {
        SiiBeneficiarioEnte siiBeneficiarioEnte = new SiiBeneficiarioEnte();
        if (beneficiarioEnteVo.getBenCodigo() != null && beneficiarioEnteVo.getBenCodigo() > 0) {
            siiBeneficiarioEnte =
                beneficiarioEnteDao.buscarPorCodigoBeneficiarioEnte(beneficiarioEnteVo.getBenCodigo());
        }
        siiBeneficiarioEnte.setBenCodigo(beneficiarioEnteVo.getBenCodigo());
        siiBeneficiarioEnte.setBenActivo(beneficiarioEnteVo.getBenActivo());
        siiBeneficiarioEnte.setBenFecha(beneficiarioEnteVo.getBenFecha());
        siiBeneficiarioEnte.setBenFechaIniAct(beneficiarioEnteVo.getBenFechaIniAct());
        siiBeneficiarioEnte.setBenFechaFinAct(beneficiarioEnteVo.getBenFechaFinAct());
        siiBeneficiarioEnte.setBenVigencia(beneficiarioEnteVo.getBenVigencia());

        if (beneficiarioEnteVo.getEnteTerritorialVo() != null) {
            SiiEnteTerritorial siiEnte =
                enteTerritorialDao.buscarEnteTerritorialPorId(beneficiarioEnteVo.getEnteTerritorialVo().getEtiCodigo());
            siiBeneficiarioEnte.setSiiEnteTerritorial(siiEnte);
        }
        if (beneficiarioEnteVo.getPersonaVo() != null && beneficiarioEnteVo.getPersonaVo().getPerCodigo() != null) {
            SiiPersona siiPerso = personaDao.buscarPersonaPorId(beneficiarioEnteVo.getPersonaVo().getPerCodigo());
            siiBeneficiarioEnte.setSiiPersona(siiPerso);
        }
        if (beneficiarioEnteVo.getMesVo() != null && beneficiarioEnteVo.getMesVo().getMesCodigo() != null) {
            SiiMes siiMes = mesDao.buscarMesPorId(beneficiarioEnteVo.getMesVo().getMesCodigo());
            siiBeneficiarioEnte.setSiiMes(siiMes);
        }


        return siiBeneficiarioEnte;
    }


    public SiiModificacionPlanCont convertir(ModificacionPlanContVO modificacionPlanVO) throws ExcepcionDAO {
        SiiModificacionPlanCont modificacionPlan = new SiiModificacionPlanCont();
        if (modificacionPlanVO.getMpcCodigo() != null && modificacionPlanVO.getMpcCodigo() > 0) {
            modificacionPlan =
                modificacionPlanContDao.buscarModificacionPlanContPorId(modificacionPlanVO.getMpcCodigo());
        }
        modificacionPlan.setMpcCodigo(modificacionPlanVO.getMpcCodigo());
        modificacionPlan.setMpcConsecutivo(modificacionPlanVO.getMpcConsecutivo());
        modificacionPlan.setMpcFecha(modificacionPlanVO.getMpcFecha());
        modificacionPlan.setMpcVigencia(modificacionPlanVO.getMpcVigencia());
        //Padres:
        if (modificacionPlanVO.getEstadoModifPlanContVo() != null) {
            SiiEstadoModifPlanCont estado =
                estadoModifPlanContDao.buscarEstadoModifPlanContPorId(modificacionPlanVO.getEstadoModifPlanContVo().getEmoCodigo());
            modificacionPlan.setSiiEstadoModifPlanCont(estado);
        }

        return modificacionPlan;
    }


    public SiiCuentasContables convertit(CuentasContablesVO cuentasContablesVo) throws ExcepcionDAO {
        SiiCuentasContables cuentaContables = new SiiCuentasContables();
        if (cuentasContablesVo.getCcoCodigo() != null && cuentasContablesVo.getCcoCodigo() > 0) {
            cuentaContables = cuentasContablesDao.buscarPorCodigo(cuentasContablesVo.getCcoCodigo());
        }
        cuentaContables.setCcoAcumTerc(cuentasContablesVo.getCcoAcumTerc());
        cuentaContables.setCcoCentroCost(cuentasContablesVo.getCcoCentroCost());
        cuentaContables.setCcoConcInfExog(cuentasContablesVo.getCcoConcInfExog());
        cuentaContables.setCcoCtaBalance(cuentasContablesVo.getCcoCtaBalance());
        cuentaContables.setCcoCtaImpuestos(cuentasContablesVo.getCcoCtaImpuestos());
        cuentaContables.setCcoCtaResult(cuentasContablesVo.getCcoCtaResult());
        cuentaContables.setCcoDescripcion(cuentasContablesVo.getCcoDescripcion());
        cuentaContables.setCcoFteFinanc(cuentasContablesVo.getCcoFteFinanc());
        cuentaContables.setCcoNaturaleza(cuentasContablesVo.getCcoNaturaleza());
        cuentaContables.setCcoNivel1(cuentasContablesVo.getCcoNivel1());
        cuentaContables.setCcoNivel2(cuentasContablesVo.getCcoNivel2());
        cuentaContables.setCcoNivel3(cuentasContablesVo.getCcoNivel3());
        cuentaContables.setCcoNivel4(cuentasContablesVo.getCcoNivel4());
        cuentaContables.setCcoNivel5(cuentasContablesVo.getCcoNivel5());
        cuentaContables.setCcoNumDocConta(cuentasContablesVo.getCcoNumDocConta());
        cuentaContables.setCcoObligaTerc(cuentasContablesVo.getCcoObligaTerc());
        cuentaContables.setCcoPermiteObl(cuentasContablesVo.getCcoPermiteObl());
        cuentaContables.setCcoReferencia1(cuentasContablesVo.getCcoReferencia1());
        cuentaContables.setCcoReferencia2(cuentasContablesVo.getCcoReferencia2());
        cuentaContables.setCcoTipDocConta(cuentasContablesVo.getCcoTipDocConta());
        cuentaContables.setCcoTipoCuenta(cuentasContablesVo.getCcoTipoCuenta());
        if (cuentasContablesVo.getEstadoCuentaContableVo() != null) {
            SiiEstadoCuentaContable siiEstadoCuentaContable =
                estadoCuentasContablesDao.buscarPorCodigo(cuentasContablesVo.getEstadoCuentaContableVo().getEccCodigo());
            cuentaContables.setSiiEstadoCuentaContable(siiEstadoCuentaContable);
        }
        if (cuentasContablesVo.getPersonaVo() != null){
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(cuentasContablesVo.getPersonaVo().getPerCodigo());
            cuentaContables.setSiiPersonaCancSaldo(siiPersona);
        }
        return cuentaContables;
    }


    public SiiDocumSoporModif convertir(DocumSoporModifVO documSoporModifVo) throws ExcepcionDAO {
        SiiDocumSoporModif documSoporModif = new SiiDocumSoporModif();
        if (documSoporModifVo.getDsmCodigo() != null && documSoporModifVo.getDsmCodigo() > 0) {
            documSoporModif = documSoporModifDao.buscarDocumSoporModifPorId(documSoporModifVo.getDsmCodigo());
        }
        documSoporModif.setDsmActivo(documSoporModifVo.getDsmActivo());
        documSoporModif.setDsmCodigo(documSoporModifVo.getDsmCodigo());
        documSoporModif.setDsmFecha(documSoporModifVo.getDsmFecha());
        documSoporModif.setDsmNumDoc(documSoporModifVo.getDsmNumDoc());
        //Padres
        if (documSoporModifVo.getModificacionPlanContVo() != null) {
            documSoporModif.setSiiModificacionPlanCont(modificacionPlanContDao.buscarModificacionPlanContPorId(documSoporModifVo.getModificacionPlanContVo().getMpcCodigo()));
        }
        if (documSoporModifVo.getTipoDocSoporteModifVo() != null) {
            documSoporModif.setSiiTipoDocSoporteModif(tipoDocSoporteModifDao.buscarTipoSoporteModifPorId(documSoporModifVo.getTipoDocSoporteModifVo().getTdmCodigo()));
        }
        return documSoporModif;
    }

    public SiiModPlanConItemPlanDetRub convertir(ModPlanConItemPlanDetRubVO modPlanConItemPlanDetRubVo) throws ExcepcionDAO {
        SiiModPlanConItemPlanDetRub modPlanConItemPlanDetRub = new SiiModPlanConItemPlanDetRub();
        if (modPlanConItemPlanDetRubVo.getMidCodigo() != null && modPlanConItemPlanDetRubVo.getMidCodigo() > 0) {
            modPlanConItemPlanDetRub =
                modPlanConItemPlanDetRubDao.buscarModPlanConItemPlanDetRubPorId(modPlanConItemPlanDetRubVo.getMidCodigo());
        }
        modPlanConItemPlanDetRub.setMidActivo(modPlanConItemPlanDetRubVo.getMidActivo());
        modPlanConItemPlanDetRub.setMidCodigo(modPlanConItemPlanDetRubVo.getMidCodigo());
        modPlanConItemPlanDetRub.setMidTipo(modPlanConItemPlanDetRubVo.getMidTipo());
        modPlanConItemPlanDetRub.setMidValor(modPlanConItemPlanDetRubVo.getMidValor());
        //Padres:
        if (modPlanConItemPlanDetRubVo.getItemPlanContDetRubDesVo() != null) {
            modPlanConItemPlanDetRub.setSiiItemPlanContDetRubDes(itemPlanContDetRubDesDao.buscarItemPlanContDetRubPorId(modPlanConItemPlanDetRubVo.getItemPlanContDetRubDesVo().getIdrCodigo()));
        }
        if (modPlanConItemPlanDetRubVo.getModificacionPlanContVo() != null) {
            modPlanConItemPlanDetRub.setSiiModificacionPlanCont(modificacionPlanContDao.buscarModificacionPlanContPorId(modPlanConItemPlanDetRubVo.getModificacionPlanContVo().getMpcCodigo()));
        }

        return modPlanConItemPlanDetRub;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param cuentaContTipoDocContVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiCuentaContTipoDocCont convertir(CuentaContTipoDocContVO cuentaContTipoDocContVo) throws ExcepcionDAO {
        SiiCuentaContTipoDocCont siiCuentaContTipoDocCont = new SiiCuentaContTipoDocCont();
        if (cuentaContTipoDocContVo.getCctCodigo() != null && cuentaContTipoDocContVo.getCctCodigo() > 0) {
            siiCuentaContTipoDocCont = cuentaContTipoDocContDao.buscarPorCodigo(cuentaContTipoDocContVo.getCctCodigo());
        }

        siiCuentaContTipoDocCont.setCctActivo(cuentaContTipoDocContVo.getCctActivo());
        siiCuentaContTipoDocCont.setCctConcepto(cuentaContTipoDocContVo.getCctConcepto());
        siiCuentaContTipoDocCont.setCctDestRecSinC(cuentaContTipoDocContVo.getCctDestRecSinC());
        siiCuentaContTipoDocCont.setCctIndicador1(cuentaContTipoDocContVo.getCctIndicador1());
        siiCuentaContTipoDocCont.setCctTipoCartera(cuentaContTipoDocContVo.getCctTipoCartera());
        siiCuentaContTipoDocCont.setCctTipoMovim(cuentaContTipoDocContVo.getCctTipoMovim());
        siiCuentaContTipoDocCont.setCctTipoRetNomina(cuentaContTipoDocContVo.getCctTipoRetNomina());

        if (cuentaContTipoDocContVo.getAreaColjuegosVo() != null &&
            cuentaContTipoDocContVo.getAreaColjuegosVo().getAcoCodigo() > 0) {
            SiiAreaColjuegos siiAreaColjuegos =
                areaColjuegosDao.buscarAreaColjuegosPorId(cuentaContTipoDocContVo.getAreaColjuegosVo().getAcoCodigo());
            siiCuentaContTipoDocCont.setSiiAreaColjuegos(siiAreaColjuegos);
        }

        if (cuentaContTipoDocContVo.getCuentasContablesVo() != null &&
            cuentaContTipoDocContVo.getCuentasContablesVo().getCcoCodigo() > 0) {
            SiiCuentasContables siiCuentasContables =
                cuentasContablesDao.buscarPorCodigo(cuentaContTipoDocContVo.getCuentasContablesVo().getCcoCodigo());
            siiCuentaContTipoDocCont.setSiiCuentasContables(siiCuentasContables);
        }

        if (cuentaContTipoDocContVo.getFuenteFinancContabVo() != null &&
            cuentaContTipoDocContVo.getFuenteFinancContabVo().getFfcCodigo() != null) {
            SiiFuenteFinancContab siiFuenteFinancContab =
                fuenteFinancContabDao.buscarPorCodigo(cuentaContTipoDocContVo.getFuenteFinancContabVo().getFfcCodigo());
            siiCuentaContTipoDocCont.setSiiFuenteFinancContab(siiFuenteFinancContab);
        }

        if (cuentaContTipoDocContVo.getPersonaVo() != null &&
            cuentaContTipoDocContVo.getPersonaVo().getPerCodigo() > 0) {
            SiiPersona siiPersona =
                personaDao.buscarPersonaPorId(cuentaContTipoDocContVo.getPersonaVo().getPerCodigo());
            siiCuentaContTipoDocCont.setSiiPersona(siiPersona);
        }

        if (cuentaContTipoDocContVo.getTipoDocContableVo() != null &&
            cuentaContTipoDocContVo.getTipoDocContableVo().getTdcCodigo() != null) {
            SiiTipoDocContable siiTipoDocContable =
                tipoDocContableDao.buscarPorCodigo(cuentaContTipoDocContVo.getTipoDocContableVo().getTdcCodigo());
            siiCuentaContTipoDocCont.setSiiTipoDocContable(siiTipoDocContable);
        }

        return (siiCuentaContTipoDocCont);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param hlpCuotaOpCuoAcuVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiHlpCuotaOpCuoAcu convertir(HlpCuotaOpCuoAcuVO hlpCuotaOpCuoAcuVo) throws ExcepcionDAO {
        SiiHlpCuotaOpCuoAcu siiHlpCuotaOpCuoAcu = new SiiHlpCuotaOpCuoAcu();
        if (hlpCuotaOpCuoAcuVo.getHcoCodigo() != null && hlpCuotaOpCuoAcuVo.getHcoCodigo() > 0) {
            siiHlpCuotaOpCuoAcu =
                hlpCuotaOpCuoAcuDao.buscarHlpCuotaOpCuoAcuPorCodigo(hlpCuotaOpCuoAcuVo.getHcoCodigo());
        }
        siiHlpCuotaOpCuoAcu.setHcoCodigo(hlpCuotaOpCuoAcuVo.getHcoCodigo());
        siiHlpCuotaOpCuoAcu.setHcaValor(hlpCuotaOpCuoAcuVo.getHcaValor());
        siiHlpCuotaOpCuoAcu.setHcaValorAbInt(hlpCuotaOpCuoAcuVo.getHcaValorAbInt());
        siiHlpCuotaOpCuoAcu.setHcaValorAbono(hlpCuotaOpCuoAcuVo.getHcaValorAbono());
        siiHlpCuotaOpCuoAcu.setHcaValorInt(hlpCuotaOpCuoAcuVo.getHcaValorInt());

        if (hlpCuotaOpCuoAcuVo.getCuotaOperadorVo() != null) {
            SiiCuotaOperador siiCuotaOperador =
                cuotaOperadorDao.buscarCuotaOperadorPorId(hlpCuotaOpCuoAcuVo.getCuotaOperadorVo().getCopCodigo());
            siiHlpCuotaOpCuoAcu.setSiiCuotaOperador(siiCuotaOperador);
        }

        if (hlpCuotaOpCuoAcuVo.getHlpCuotaAcuerdoVo() != null) {
            SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo =
                hlpCuotaAcuerdoDao.buscarHlpCuotaAcuerdoPorCodigo(hlpCuotaOpCuoAcuVo.getHlpCuotaAcuerdoVo().getHcaCodigo());
            siiHlpCuotaOpCuoAcu.setSiiHlpCuotaAcuerdo(siiHlpCuotaAcuerdo);
        }

        return (siiHlpCuotaOpCuoAcu);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param conceptoNominaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiConceptoNomina convertir(ConceptoNominaVO conceptoNominaVo) throws ExcepcionDAO {
        SiiConceptoNomina siiConceptoNomina = null;
        if (conceptoNominaVo.getCnoCodigo() != null && !conceptoNominaVo.getCnoCodigo().isEmpty()) {
            siiConceptoNomina = conceptoNominaDao.buscarPorCodigo(conceptoNominaVo.getCnoCodigo());
        }

        if (siiConceptoNomina == null)
            siiConceptoNomina = new SiiConceptoNomina();


        siiConceptoNomina.setCnoCodigo(conceptoNominaVo.getCnoCodigo());
        siiConceptoNomina.setCnoActivo(conceptoNominaVo.getCnoActivo());
        siiConceptoNomina.setCnoNombre(conceptoNominaVo.getCnoNombre());
        siiConceptoNomina.setCnoReintegro(conceptoNominaVo.getCnoReintegro());
        siiConceptoNomina.setCnoRubro(conceptoNominaVo.getCnoRubro());


        return (siiConceptoNomina);
    }

    public SiiDetalleDeclaracionSug convertir(DetalleDeclaracionSugVO detalleDeclaracionSugVo) throws ExcepcionDAO {
        SiiDetalleDeclaracionSug siiDetalleDeclaracionSug = new SiiDetalleDeclaracionSug();
        if (detalleDeclaracionSugVo.getDdsCodigo() != null && detalleDeclaracionSugVo.getDdsCodigo() > 0) {
            siiDetalleDeclaracionSug = detalleDeclaracionSugDao.buscarPorCodigo(detalleDeclaracionSugVo.getDdsCodigo());
        }

        siiDetalleDeclaracionSug.setDdsValor(detalleDeclaracionSugVo.getDdsValor());
        siiDetalleDeclaracionSug.setDdsValorInteres(detalleDeclaracionSugVo.getDdsValorInteres());

        if (detalleDeclaracionSugVo.getCuotaOperadorVo() != null &&
            detalleDeclaracionSugVo.getCuotaOperadorVo().getCopCodigo() != null) {
            SiiCuotaOperador siiCuotaOperador =
                cuotaOperadorDao.buscarCuotaOperadorPorId(detalleDeclaracionSugVo.getCuotaOperadorVo().getCopCodigo());
            siiDetalleDeclaracionSug.setSiiCuotaOperador(siiCuotaOperador);
        }

        if (detalleDeclaracionSugVo.getDeclaracionSugeridaVo() != null &&
            detalleDeclaracionSugVo.getDeclaracionSugeridaVo().getDsuCodigo() != null) {
            SiiDeclaracionSugerida siiDeclaracionSugerida =
                declaracionSugeridaDao.buscarDeclaracionSugeridaPorId(detalleDeclaracionSugVo.getDeclaracionSugeridaVo().getDsuCodigo());
            siiDetalleDeclaracionSug.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
        }
        return siiDetalleDeclaracionSug;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param cargaDocumentoContVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiCargaDocumentoCont convertir(CargaDocumentoContVO cargaDocumentoContVo) throws ExcepcionDAO {
        SiiCargaDocumentoCont siiCargaDocumentoCont = new SiiCargaDocumentoCont();

        if (cargaDocumentoContVo.getCdcCodigo() != null && cargaDocumentoContVo.getCdcCodigo() > 0) {
            siiCargaDocumentoCont = cargaDocumentoContDao.buscarPorCodigo(cargaDocumentoContVo.getCdcCodigo());
        }

        siiCargaDocumentoCont.setCdcCodigo(cargaDocumentoContVo.getCdcCodigo());
        siiCargaDocumentoCont.setCdcDescripcion(cargaDocumentoContVo.getCdcDescripcion());


        // padres
        if (cargaDocumentoContVo.getArchivoFisicoVo() != null &&
            cargaDocumentoContVo.getArchivoFisicoVo().getAfiCodigo() != null) {
            SiiArchivoFisico siiArchivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(cargaDocumentoContVo.getArchivoFisicoVo().getAfiCodigo());
            siiCargaDocumentoCont.setSiiArchivoFisico(siiArchivoFisico);
        }

        return (siiCargaDocumentoCont);
    }

    public SiiFiscalizadorSustanc convertir(FiscalizadorSustancVO fiscalizadorSustancVo) throws ExcepcionDAO {
        SiiFiscalizadorSustanc siiFiscalizadorSustanc = new SiiFiscalizadorSustanc();
        if (fiscalizadorSustancVo.getFsuCodigo() != null && fiscalizadorSustancVo.getFsuCodigo() > 0) {
            siiFiscalizadorSustanc = fiscalizadorSustancDao.buscarPorCodigo(fiscalizadorSustancVo.getFsuCodigo());
        }
        siiFiscalizadorSustanc.setFsuCodigo(fiscalizadorSustancVo.getFsuCodigo());
        siiFiscalizadorSustanc.setFsuRol(fiscalizadorSustancVo.getFsuRol());
        //Padres:
        if (fiscalizadorSustancVo.getPersonaVo() != null &&
            fiscalizadorSustancVo.getPersonaVo().getPerCodigo() != null) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(fiscalizadorSustancVo.getPersonaVo().getPerCodigo());
            siiFiscalizadorSustanc.setSiiPersona(siiPersona);
        }
        if (fiscalizadorSustancVo.getTipoActuacionVo() != null &&
            fiscalizadorSustancVo.getTipoActuacionVo().getTacCodigo() != null) {
            SiiTipoActuacion siiTipoActuacion =
                tipoActuacionDao.buscarPorCodigo(fiscalizadorSustancVo.getTipoActuacionVo().getTacCodigo());
            siiFiscalizadorSustanc.setSiiTipoActuacion(siiTipoActuacion);
        }
        return siiFiscalizadorSustanc;
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param consolidadoDistVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiConsolidadoDist convertir(ConsolidadoDistVO consolidadoDistVo) throws ExcepcionDAO {
        SiiConsolidadoDist siiConsolidadoDist = new SiiConsolidadoDist();

        if (consolidadoDistVo.getCodCodigo() != null && consolidadoDistVo.getCodCodigo() > 0) {
            siiConsolidadoDist = consolidadoDistDao.buscarPorCodigoConsolidadoDist(consolidadoDistVo.getCodCodigo());
        }

        siiConsolidadoDist.setCodCodigo(consolidadoDistVo.getCodCodigo());
        siiConsolidadoDist.setCodActuacAdmin(consolidadoDistVo.getCodActuacAdmin());
        siiConsolidadoDist.setCodColciencias(consolidadoDistVo.getCodColciencias());
        siiConsolidadoDist.setCodDistribFosyga(consolidadoDistVo.getCodDistribFosyga());
        siiConsolidadoDist.setCodDistribMunicip(consolidadoDistVo.getCodDistribMunicip());
        siiConsolidadoDist.setCodHipicosGallist(consolidadoDistVo.getCodHipicosGallist());
        siiConsolidadoDist.setCodInteresFinanc(consolidadoDistVo.getCodInteresFinanc());
        siiConsolidadoDist.setCodInteresMora(consolidadoDistVo.getCodInteresMora());
        siiConsolidadoDist.setCodLegalizacAnticip(consolidadoDistVo.getCodLegalizacAnticip());
        siiConsolidadoDist.setCodLocMayCienDnp(consolidadoDistVo.getCodLocMayCienDnp());
        siiConsolidadoDist.setCodLocalizMayCien(consolidadoDistVo.getCodLocalizMayCien());
        siiConsolidadoDist.setCodLocalizMenCien(consolidadoDistVo.getCodLocalizMenCien());
        siiConsolidadoDist.setCodPorcentajePart(consolidadoDistVo.getCodPorcentajePart());
        siiConsolidadoDist.setCodPromocionales(consolidadoDistVo.getCodPromocionales());
        siiConsolidadoDist.setCodRendimientosFin(consolidadoDistVo.getCodRendimientosFin());
        siiConsolidadoDist.setCodRifas(consolidadoDistVo.getCodRifas());
        siiConsolidadoDist.setCodSubtotalTrans(consolidadoDistVo.getCodSubtotalTrans());
        siiConsolidadoDist.setCodTotalControl(consolidadoDistVo.getCodTotalControl());
        siiConsolidadoDist.setCodTotalTransf(consolidadoDistVo.getCodTotalTransf());
        siiConsolidadoDist.setCodValorRecaudo(consolidadoDistVo.getCodValorRecaudo());
        siiConsolidadoDist.setCodDerechosExpl(consolidadoDistVo.getCodDerechosExpl());
        siiConsolidadoDist.setCodDeColciencias(consolidadoDistVo.getCodDeColciencias());
        siiConsolidadoDist.setCodDeFosyga(consolidadoDistVo.getCodDeFosyga());
        siiConsolidadoDist.setCodDeMunicipio(consolidadoDistVo.getCodDeMunicipio());
        siiConsolidadoDist.setCodIfColciencias(consolidadoDistVo.getCodIfColciencias());
        siiConsolidadoDist.setCodIfFosyga(consolidadoDistVo.getCodIfFosyga());
        siiConsolidadoDist.setCodIfMunicipio(consolidadoDistVo.getCodIfMunicipio());
        siiConsolidadoDist.setCodImColciencias(consolidadoDistVo.getCodImColciencias());
        siiConsolidadoDist.setCodImFosyga(consolidadoDistVo.getCodImFosyga());
        siiConsolidadoDist.setCodImMunicipio(consolidadoDistVo.getCodImMunicipio());
        siiConsolidadoDist.setCodAaColciencias(consolidadoDistVo.getCodAaColciencias());
        siiConsolidadoDist.setCodAaFosyga(consolidadoDistVo.getCodAaFosyga());
        siiConsolidadoDist.setCodAaMunicipio(consolidadoDistVo.getCodAaMunicipio());
        siiConsolidadoDist.setCodRfColciencias(consolidadoDistVo.getCodRfColciencias());
        siiConsolidadoDist.setCodRfFosyga(consolidadoDistVo.getCodRfFosyga());
        siiConsolidadoDist.setCodRfMunicipio(consolidadoDistVo.getCodRfMunicipio());
        siiConsolidadoDist.setCodDistrColciencias(consolidadoDistVo.getCodDistrColciencias());

        if (consolidadoDistVo.getDistribucionMesVo() != null &&
            consolidadoDistVo.getDistribucionMesVo().getDmeCodigo() != null) {
            SiiDistribucionMes siiDistribucionMes =
                distribucionMesDao.buscarPorCodigoDistribucionMes(consolidadoDistVo.getDistribucionMesVo().getDmeCodigo());
            siiConsolidadoDist.setSiiDistribucionMes(siiDistribucionMes);
        }

        if (consolidadoDistVo.getUbicacionVo() != null && consolidadoDistVo.getUbicacionVo().getUbiCodigo() != null) {
            SiiUbicacion siiUbicacion =
                ubicacionDao.buscarUbicacionPorId(consolidadoDistVo.getUbicacionVo().getUbiCodigo());
            siiConsolidadoDist.setSiiUbicacion(siiUbicacion);
        }

        if (consolidadoDistVo.getPersonaVo() != null && consolidadoDistVo.getPersonaVo().getPerCodigo() != null) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(consolidadoDistVo.getPersonaVo().getPerCodigo());
            siiConsolidadoDist.setSiiPersona(siiPersona);
        }


        return (siiConsolidadoDist);
    }

    public SiiHistEstadoFiscaliz convertir(HistEstadoFiscalizVO histEstadoFiscalizVo) throws ExcepcionDAO {
        SiiHistEstadoFiscaliz siiHistEstadoFiscaliz = new SiiHistEstadoFiscaliz();
        if (siiHistEstadoFiscaliz.getHefCodigo() != null && siiHistEstadoFiscaliz.getHefCodigo() > 0) {
            siiHistEstadoFiscaliz = histEstadoFiscalizDao.buscarPorCodigo(histEstadoFiscalizVo.getHefCodigo());
        }
        siiHistEstadoFiscaliz.setHefCodigo(histEstadoFiscalizVo.getHefCodigo());
        siiHistEstadoFiscaliz.setHefEstado(histEstadoFiscalizVo.getHefEstado());
        siiHistEstadoFiscaliz.setHefFechaAct(histEstadoFiscalizVo.getHefFechaAct());
        siiHistEstadoFiscaliz.setHefFechaInact(histEstadoFiscalizVo.getHefFechaInact());
        siiHistEstadoFiscaliz.setHefGrupoAsignVisit(histEstadoFiscalizVo.getHefGrupoAsignVisit());
        //Padres:
        if (histEstadoFiscalizVo.getFiscalizadorSustancVo() != null &&
            histEstadoFiscalizVo.getFiscalizadorSustancVo().getFsuCodigo() != null) {
            SiiFiscalizadorSustanc fiscalizadorSustanc =
                fiscalizadorSustancDao.buscarPorCodigo(histEstadoFiscalizVo.getFiscalizadorSustancVo().getFsuCodigo());
            siiHistEstadoFiscaliz.setSiiFiscalizadorSustanc(fiscalizadorSustanc);
        }
        if(histEstadoFiscalizVo.getUsuarioConectVo() != null && histEstadoFiscalizVo.getUsuarioConectVo().getUsuCodigo() != null) {
            SiiUsuario usuario = usuarioDao.buscarUsuarioPorId(histEstadoFiscalizVo.getUsuarioConectVo().getUsuCodigo());
            siiHistEstadoFiscaliz.setSiiUsuarioConect(usuario);
        }

        return siiHistEstadoFiscaliz;
    }

    public SiiResolucionLiquid convertir(ResolucionLiquidacionVO resolucionLiquidacionVo) throws ExcepcionDAO {
        SiiResolucionLiquid siiResolucionLiquid = new SiiResolucionLiquid();
        if (resolucionLiquidacionVo.getRliCodigo() != null && resolucionLiquidacionVo.getRliCodigo() > 0) {
            siiResolucionLiquid =
                resolucionLiquidacionDao.buscarResolucionLiquidPorId(resolucionLiquidacionVo.getRliCodigo());
        }
        siiResolucionLiquid.setRliCodigo(resolucionLiquidacionVo.getRliCodigo());
        siiResolucionLiquid.setRliFecha(resolucionLiquidacionVo.getRlifecha());
        siiResolucionLiquid.setRliFechaFirme(resolucionLiquidacionVo.getRliFechaFirma());
        siiResolucionLiquid.setRliNumero(resolucionLiquidacionVo.getRlinumero());
        siiResolucionLiquid.setRliTipoRes(resolucionLiquidacionVo.getRliTipoRes());
        siiResolucionLiquid.setRliResultadoRec(resolucionLiquidacionVo.getRliResultadoRec());
        siiResolucionLiquid.setRliFechaNotifica(resolucionLiquidacionVo.getFechaNotificacion());
        //Padres:
        if (resolucionLiquidacionVo.getArchivoFisicoVo() != null) {
            SiiArchivoFisico archivoFisico =
                archivoFisicoDao.buscarArchivoFisicoPorId(resolucionLiquidacionVo.getArchivoFisicoVo().getAfiCodigo());
            siiResolucionLiquid.setSiiArchivoFisico(archivoFisico);
        }
        if (resolucionLiquidacionVo.getEstadoResolucionLiqVo() != null) {
            SiiEstadoResolucLiq estadoResolucLiq =
                estadoResolucionLiqDao.buscarEstadoResolucionLiqXId(resolucionLiquidacionVo.getEstadoResolucionLiqVo().getErlCodigo());
            siiResolucionLiquid.setSiiEstadoResolucLiq(estadoResolucLiq);
        }
        if (resolucionLiquidacionVo.getLiquidacionContratoVo() != null) {
            SiiLiquidacionContrato liquidacionContrato =
                liquidacionContratoDao.buscarLiquidacionContratoXId(resolucionLiquidacionVo.getLiquidacionContratoVo().getLcoCodigo());
            siiResolucionLiquid.setSiiLiquidacionContrato(liquidacionContrato);
        }

        return siiResolucionLiquid;
    }


    public SiiRevisFinancOtrosi convertir(RevisFinancOtroSiVO rev) throws ExcepcionDAO {
        SiiRevisFinancOtrosi siiRevisFinancOtrosi = new SiiRevisFinancOtrosi();
        if (siiRevisFinancOtrosi.getRfoCodigo() != null && siiRevisFinancOtrosi.getRfoCodigo() > 0) {
            siiRevisFinancOtrosi = revisFinancOtrosiDao.buscarPorCodigo(rev.getRfoCodigo());
        }
        siiRevisFinancOtrosi.setRfoCodigo(rev.getRfoCodigo());
        siiRevisFinancOtrosi.setRfoFecha(rev.getRfoFecha());
        siiRevisFinancOtrosi.setRfoObservaciones(rev.getRfoObservaciones());
        siiRevisFinancOtrosi.setRfoTipoValidac(rev.getRfoTipoValidac());
        siiRevisFinancOtrosi.setRfoValida(rev.getRfoValida());
        //Padres:
        if (rev.getOtroSiVo() != null && rev.getOtroSiVo().getOsiCodigo() != null) {
            SiiOtrosi otrosi = otroSiDao.buscarOtroSiPorId(rev.getOtroSiVo().getOsiCodigo());
            siiRevisFinancOtrosi.setSiiOtrosi(otrosi);
        }
        return siiRevisFinancOtrosi;
    }

    /**
     * Realiza la conversión de value object a entity
     * @param descargoProcSanVo
     * @return siiDescargoProcSan - entity
     * @throws ExcepcionDAO
     */

    public SiiDescargoProcSan convertir(DescargoProcSanVO descargoProcSanVo) throws ExcepcionDAO {
        SiiDescargoProcSan siiDescargoProcSan = new SiiDescargoProcSan();

        if (descargoProcSanVo != null) {
            if (descargoProcSanVo.getDpsCodigo() != null && descargoProcSanVo.getDpsCodigo() > 0) {
                siiDescargoProcSan = descargoProcSanDao.buscarPorCodigo(descargoProcSanVo.getDpsCodigo());
            }

            siiDescargoProcSan.setDpsCodigo(descargoProcSanVo.getDpsCodigo());
            siiDescargoProcSan.setDpsFechaRad(descargoProcSanVo.getDpsFechaRad());
            siiDescargoProcSan.setDpsPruebasSol(descargoProcSanVo.getDpsPruebasSol());
            siiDescargoProcSan.setDpsRadicado(descargoProcSanVo.getDpsRadicado());
            siiDescargoProcSan.setDpsSolicitaPru(descargoProcSanVo.getDpsSolicitaPru());

            if (descargoProcSanVo.getProcesoSancionatorioVo() != null &&
                descargoProcSanVo.getProcesoSancionatorioVo().getPsaCodigo() != null) {
                SiiProcesoSancionatorio siiProcesoSancionatorio =
                    procesoSancionatorioDao.buscarPorCodigo(descargoProcSanVo.getProcesoSancionatorioVo().getPsaCodigo());
                siiDescargoProcSan.setSiiProcesoSancionatorio(siiProcesoSancionatorio);
            }
        }

        return (siiDescargoProcSan);
    }

    /**
     * Convertir el value  object de cuotas inexactas de proceso sancionatorio en entity
     * @param cuotaInexacProcSancVo
     * @return siiCuotaInexacProcSanc - entity
     * @throws ExcepcionDAO
     */

    public SiiCuotaInexacProcSanc convertir(CuotaInexacProcSancVO cuotaInexacProcSancVo) throws ExcepcionDAO {
        SiiCuotaInexacProcSanc siiCuotaInexacProcSanc = new SiiCuotaInexacProcSanc();

        if (cuotaInexacProcSancVo != null) {
            if (cuotaInexacProcSancVo.getCipCodigo() != null && cuotaInexacProcSancVo.getCipCodigo() > 0) {
                siiCuotaInexacProcSanc = cuotaInexacProcSancDao.buscarPorCodigo(cuotaInexacProcSancVo.getCipCodigo());
            }
            
            siiCuotaInexacProcSanc.setCipActivo(cuotaInexacProcSancVo.getCipActivo());
            siiCuotaInexacProcSanc.setCipCodigo(cuotaInexacProcSancVo.getCipCodigo());
            siiCuotaInexacProcSanc.setCipDiferenciaDe(cuotaInexacProcSancVo.getCipDiferenciaDe());
            siiCuotaInexacProcSanc.setCipDiferenciaGa(cuotaInexacProcSancVo.getCipDiferenciaGa());
            siiCuotaInexacProcSanc.setCipLiquidRevisDe(cuotaInexacProcSancVo.getCipLiquidRevisDe());
            siiCuotaInexacProcSanc.setCipLiquidRevisGa(cuotaInexacProcSancVo.getCipLiquidRevisGa());
            siiCuotaInexacProcSanc.setCipValorSancion(cuotaInexacProcSancVo.getCipValorSancion());
            
            
            if (cuotaInexacProcSancVo.getProcesoSancionatorioVo()!=null && cuotaInexacProcSancVo.getProcesoSancionatorioVo().getPsaCodigo()!=null) {
                SiiProcesoSancionatorio siiProcesoSancionatorio = procesoSancionatorioDao.buscarPorCodigo(cuotaInexacProcSancVo.getProcesoSancionatorioVo().getPsaCodigo());
                siiCuotaInexacProcSanc.setSiiProcesoSancionatorio(siiProcesoSancionatorio);
            }
            
            if (cuotaInexacProcSancVo.getCuotaOperadorDE() != null &&
                cuotaInexacProcSancVo.getCuotaOperadorDE().getCopCodigo() != null) {
                SiiCuotaOperador siiCuotaOperadorDE =
                    cuotaOperadorDao.buscarCuotaOperadorPorId(cuotaInexacProcSancVo.getCuotaOperadorDE().getCopCodigo());
                siiCuotaInexacProcSanc.setSiiCuotaOperador(siiCuotaOperadorDE);
            }
            
            if (cuotaInexacProcSancVo.getCuotaOperadorGA() != null &&
                cuotaInexacProcSancVo.getCuotaOperadorGA().getCopCodigo() != null) {
                SiiCuotaOperador siiCuotaOperadorGA =
                    cuotaOperadorDao.buscarCuotaOperadorPorId(cuotaInexacProcSancVo.getCuotaOperadorGA().getCopCodigo());
                siiCuotaInexacProcSanc.setSiiCuotaOperadorGA(siiCuotaOperadorGA);
            }
        }

        return (siiCuotaInexacProcSanc);
    }

    /**
     * Convertir el value object de inventario del proceso sancionatorio en su correspondiente entity
     * @param inventarioProcSanVO
     * @return siiInventarioProcSan - Entity
     * @throws ExcepcionDAO
     */

    public SiiInventarioProcSan convertir(InventarioProcSanVO inventarioProcSanVO) throws ExcepcionDAO {
        SiiInventarioProcSan siiInventarioProcSan = new SiiInventarioProcSan();

        if (inventarioProcSanVO != null) {
            if (inventarioProcSanVO.getIpsCodigo() != null && inventarioProcSanVO.getIpsCodigo() > 0) {
                siiInventarioProcSan = inventarioProcSanDao.buscarPorCodigo(inventarioProcSanVO.getIpsCodigo());
            }

            siiInventarioProcSan.setIpsCodigo(inventarioProcSanVO.getIpsCodigo());
            siiInventarioProcSan.setIpsActivo(inventarioProcSanVO.getIpsActivo());

            if (inventarioProcSanVO.getInventarioVo() != null &&
                inventarioProcSanVO.getInventarioVo().getInvCodigo() != null) {
                SiiInventario siiInventario =
                    inventarioDao.buscarInventarioPorId(inventarioProcSanVO.getInventarioVo().getInvCodigo());
                siiInventarioProcSan.setSiiInventario(siiInventario);
            }

            if (inventarioProcSanVO.getProcesoSancionatorioVo() != null &&
                inventarioProcSanVO.getProcesoSancionatorioVo().getPsaCodigo() != null) {
                SiiProcesoSancionatorio siiProcesoSancionatorio =
                    procesoSancionatorioDao.buscarPorCodigo(inventarioProcSanVO.getProcesoSancionatorioVo().getPsaCodigo());
                siiInventarioProcSan.setSiiProcesoSancionatorio(siiProcesoSancionatorio);
            }

            if (inventarioProcSanVO.getTipoApuestaVo() != null &&
                inventarioProcSanVO.getTipoApuestaVo().getTapCodigo() != null) {
                SiiTipoApuesta siiTipoApuesta =
                    tipoApuestaDao.buscarTipoApuestaPorCodigo(inventarioProcSanVO.getTipoApuestaVo().getTapCodigo());
                siiInventarioProcSan.setSiiTipoApuesta(siiTipoApuesta);
            }
            
            if (inventarioProcSanVO.getTipoApuestaEncontVo() != null &&
                inventarioProcSanVO.getTipoApuestaEncontVo().getTapCodigo() != null) {
                SiiTipoApuesta siiTipoApuesta =
                    tipoApuestaDao.buscarTipoApuestaPorCodigo(inventarioProcSanVO.getTipoApuestaEncontVo().getTapCodigo());
                siiInventarioProcSan.setSiiTipoApuestaEncont(siiTipoApuesta);
        }
        }

        return (siiInventarioProcSan);
    }

    
    /**
     * Convertir el value object de la cuota de omisi&oacute;n del proceso sancionatorio en su correspondiente entity
     * @param cuotaOmisProcSancVo
     * @return siiCuotaOmisProcSanc - entity
     * @throws ExcepcionDAO
     */
    
    public SiiCuotaOmisProcSanc convertir(CuotaOmisProcSancVO cuotaOmisProcSancVo) throws ExcepcionDAO {
        SiiCuotaOmisProcSanc siiCuotaOmisProcSanc = new SiiCuotaOmisProcSanc();

        if (cuotaOmisProcSancVo != null) {
            if (cuotaOmisProcSancVo.getCosCodigo() != null && cuotaOmisProcSancVo.getCosCodigo() > 0) {
                siiCuotaOmisProcSanc = cuotaOmisProcSancDao.buscarPorCodigo(cuotaOmisProcSancVo.getCosCodigo());
            }

            siiCuotaOmisProcSanc.setCosActivo(cuotaOmisProcSancVo.getCosActivo());
            siiCuotaOmisProcSanc.setCosCodigo(cuotaOmisProcSancVo.getCosCodigo());
            siiCuotaOmisProcSanc.setCosValorDe(cuotaOmisProcSancVo.getCosValorDe());
            siiCuotaOmisProcSanc.setCosValorSancion(cuotaOmisProcSancVo.getCosValorSancion());

            if (cuotaOmisProcSancVo.getCuotaOperadorVo() != null &&
                cuotaOmisProcSancVo.getCuotaOperadorVo().getCopCodigo() != null) {
                SiiCuotaOperador siiCuotaOperador =
                    cuotaOperadorDao.buscarCuotaOperadorPorId(cuotaOmisProcSancVo.getCuotaOperadorVo().getCopCodigo());
                siiCuotaOmisProcSanc.setSiiCuotaOperador(siiCuotaOperador);
            }

            if (cuotaOmisProcSancVo.getProcesoSancionatorioVo()!=null && cuotaOmisProcSancVo.getProcesoSancionatorioVo().getPsaCodigo()!=null) {
                SiiProcesoSancionatorio siiProcesoSancionatorio = procesoSancionatorioDao.buscarPorCodigo(cuotaOmisProcSancVo.getProcesoSancionatorioVo().getPsaCodigo());
                siiCuotaOmisProcSanc.setSiiProcesoSancionatorio(siiProcesoSancionatorio);
            }
        }

        return (siiCuotaOmisProcSanc);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param ordenTrabajoVisitaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiOrdenTrabajoVisita convertir(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO {
        SiiOrdenTrabajoVisita siiOrdenTrabajoVisita = new SiiOrdenTrabajoVisita();

        if (ordenTrabajoVisitaVo != null) {
            if (ordenTrabajoVisitaVo.getOtvCodigo() != null && ordenTrabajoVisitaVo.getOtvCodigo() > 0) {
                siiOrdenTrabajoVisita = ordenTrabajoVisitaDao.buscarPorCodigo(ordenTrabajoVisitaVo.getOtvCodigo());
            }

            siiOrdenTrabajoVisita.setOtvCodigo(ordenTrabajoVisitaVo.getOtvCodigo());
            siiOrdenTrabajoVisita.setOtvEstado(ordenTrabajoVisitaVo.getOtvEstado());
            siiOrdenTrabajoVisita.setOtvFecha(ordenTrabajoVisitaVo.getOtvFecha());
            siiOrdenTrabajoVisita.setOtvFechaFinal(ordenTrabajoVisitaVo.getOtvFechaFinal());
            siiOrdenTrabajoVisita.setOtvFechaInicio(ordenTrabajoVisitaVo.getOtvFechaInicio());
            siiOrdenTrabajoVisita.setOtvNumero(ordenTrabajoVisitaVo.getOtvNumero());
            siiOrdenTrabajoVisita.setOtvNumeroFun(ordenTrabajoVisitaVo.getOtvNumeroFun());

        }

        return (siiOrdenTrabajoVisita);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param auditorOrdenTrabVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiAuditorOrdenTrab convertir(AuditorOrdenTrabVO auditorOrdenTrabVo) throws ExcepcionDAO {
        SiiAuditorOrdenTrab siiAuditorOrdenTrab = new SiiAuditorOrdenTrab();

        if (auditorOrdenTrabVo != null) {
            if (auditorOrdenTrabVo.getAotCodigo() != null && auditorOrdenTrabVo.getAotCodigo() > 0) {
                siiAuditorOrdenTrab = auditorOrdenTrabDao.buscarPorCodigo(auditorOrdenTrabVo.getAotCodigo());
            }

            siiAuditorOrdenTrab.setAotActivo(auditorOrdenTrabVo.getAotActivo());
            siiAuditorOrdenTrab.setAotCodigo(auditorOrdenTrabVo.getAotCodigo());

            if (auditorOrdenTrabVo.getOrdenTrabajoVisitaVO() != null &&
                auditorOrdenTrabVo.getOrdenTrabajoVisitaVO().getOtvCodigo() != null) {
                SiiOrdenTrabajoVisita siiOrdenTrabajoVisita =
                    ordenTrabajoVisitaDao.buscarPorCodigo(auditorOrdenTrabVo.getOrdenTrabajoVisitaVO().getOtvCodigo());
                siiAuditorOrdenTrab.setSiiOrdenTrabajoVisita(siiOrdenTrabajoVisita);
            }

            if (auditorOrdenTrabVo.getOrdenTrabajoVisitaVO() != null &&
                auditorOrdenTrabVo.getOrdenTrabajoVisitaVO().getOtvCodigo() != null) {
                SiiSustanciadorAuditor siiSustanciadorAuditor =
                    sustanciadorAuditorDao.buscarPorCodigo(auditorOrdenTrabVo.getSustanciadorAuditorVO().getSuaCodigo());
                siiAuditorOrdenTrab.setSiiSustanciadorAuditor(siiSustanciadorAuditor);
            }

        }

        return (siiAuditorOrdenTrab);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param barrioOrdenVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiBarrioOrden convertir(BarrioOrdenVO barrioOrdenVo) throws ExcepcionDAO {
        SiiBarrioOrden siiBarrioOrden = new SiiBarrioOrden();

        if (barrioOrdenVo != null) {
            if (barrioOrdenVo.getBorCodigo() != null && barrioOrdenVo.getBorCodigo() > 0) {
                siiBarrioOrden = barrioOrdenDao.buscarPorCodigo(barrioOrdenVo.getBorCodigo());
            }

            siiBarrioOrden.setBorActivo(barrioOrdenVo.getBorActivo());
            siiBarrioOrden.setBorCodigo(barrioOrdenVo.getBorCodigo());
            siiBarrioOrden.setBorNombre(barrioOrdenVo.getBorNombre());

            if (barrioOrdenVo.getOrdenTrabajoVisitaVO() != null &&
                barrioOrdenVo.getOrdenTrabajoVisitaVO().getOtvCodigo() != null) {
                SiiOrdenTrabajoVisita siiOrdenTrabajoVisita =
                    ordenTrabajoVisitaDao.buscarPorCodigo(barrioOrdenVo.getOrdenTrabajoVisitaVO().getOtvCodigo());
                siiBarrioOrden.setSiiOrdenTrabajoVisita(siiOrdenTrabajoVisita);
            }

            if (barrioOrdenVo.getUbicacionMunicipioVO() != null &&
                barrioOrdenVo.getUbicacionMunicipioVO().getUbiCodigo() != null) {
                SiiUbicacion siiUbicacionMunicipio =
                    ubicacionDao.buscarUbicacionPorId(barrioOrdenVo.getUbicacionMunicipioVO().getUbiCodigo());
                siiBarrioOrden.setSiiUbicacionMunicipio(siiUbicacionMunicipio);
            }
        }

        return (siiBarrioOrden);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param cuadranteOrdenTraVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiCuadranteOrdenTra convertir(CuadranteOrdenTraVO cuadranteOrdenTraVo) throws ExcepcionDAO {
        SiiCuadranteOrdenTra siiCuadranteOrdenTra = new SiiCuadranteOrdenTra();

        if (cuadranteOrdenTraVo != null) {
            if (cuadranteOrdenTraVo.getCotCodigo() != null && cuadranteOrdenTraVo.getCotCodigo() > 0) {
                siiCuadranteOrdenTra = cuadranteOrdenTraDAO.buscarPorCodigo(cuadranteOrdenTraVo.getCotCodigo());
            }

            siiCuadranteOrdenTra.setCotActivo(cuadranteOrdenTraVo.getCotActivo());
            siiCuadranteOrdenTra.setCotCodigo(cuadranteOrdenTraVo.getCotCodigo());
            siiCuadranteOrdenTra.setCotLimite1(cuadranteOrdenTraVo.getCotLimite1());
            siiCuadranteOrdenTra.setCotLimite2(cuadranteOrdenTraVo.getCotLimite2());
            siiCuadranteOrdenTra.setCotLimite3(cuadranteOrdenTraVo.getCotLimite3());
            siiCuadranteOrdenTra.setCotLimite4(cuadranteOrdenTraVo.getCotLimite4());

            if (cuadranteOrdenTraVo.getOrdenTrabajoVisitaVO() != null &&
                cuadranteOrdenTraVo.getOrdenTrabajoVisitaVO().getOtvCodigo() != null) {
                SiiOrdenTrabajoVisita siiOrdenTrabajoVisita =
                    ordenTrabajoVisitaDao.buscarPorCodigo(cuadranteOrdenTraVo.getOrdenTrabajoVisitaVO().getOtvCodigo());
                siiCuadranteOrdenTra.setSiiOrdenTrabajoVisita(siiOrdenTrabajoVisita);
            }
        }

        return (siiCuadranteOrdenTra);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param denunciaOrdenTrabVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiDenunciaOrdenTrab convertir(DenunciaOrdenTrabVO denunciaOrdenTrabVo) throws ExcepcionDAO {
        SiiDenunciaOrdenTrab siiDenunciaOrdenTrab = new SiiDenunciaOrdenTrab();

        if (denunciaOrdenTrabVo != null) {
            if (denunciaOrdenTrabVo.getDotCodigo() != null && denunciaOrdenTrabVo.getDotCodigo() > 0) {
                siiDenunciaOrdenTrab = denunciaOrdenTrabDao.buscarPorCodigo(denunciaOrdenTrabVo.getDotCodigo());
            }

            siiDenunciaOrdenTrab.setDotActivo(denunciaOrdenTrabVo.getDotActivo());
            siiDenunciaOrdenTrab.setDotCodigo(denunciaOrdenTrabVo.getDotCodigo());

            if (denunciaOrdenTrabVo.getDenunciaVO() != null &&
                denunciaOrdenTrabVo.getDenunciaVO().getDenCodigo() != null) {
                SiiDenuncia siiDenuncia =
                    denunciaDao.buscarPorCodigo(denunciaOrdenTrabVo.getDenunciaVO().getDenCodigo());
                siiDenunciaOrdenTrab.setSiiDenuncia(siiDenuncia);
            }

            if (denunciaOrdenTrabVo.getOrdenTrabajoVisitaVO() != null &&
                denunciaOrdenTrabVo.getOrdenTrabajoVisitaVO().getOtvCodigo() != null) {
                SiiOrdenTrabajoVisita siiOrdenTrabajoVisita =
                    ordenTrabajoVisitaDao.buscarPorCodigo(denunciaOrdenTrabVo.getOrdenTrabajoVisitaVO().getOtvCodigo());
                siiDenunciaOrdenTrab.setSiiOrdenTrabajoVisita(siiOrdenTrabajoVisita);
            }
        }

        return (siiDenunciaOrdenTrab);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param municipioOrdenTrabVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiMunicipioOrdenTrab convertir(MunicipioOrdenTrabVO municipioOrdenTrabVo) throws ExcepcionDAO {
        SiiMunicipioOrdenTrab siiMunicipioOrdenTrab = new SiiMunicipioOrdenTrab();

        if (municipioOrdenTrabVo != null) {
            if (municipioOrdenTrabVo.getMotCodigo() != null && municipioOrdenTrabVo.getMotCodigo() > 0) {
                siiMunicipioOrdenTrab = municipioOrdenTrabDao.buscarPorCodigo(municipioOrdenTrabVo.getMotCodigo());
            }

            siiMunicipioOrdenTrab.setMotActivo(municipioOrdenTrabVo.getMotActivo());
            siiMunicipioOrdenTrab.setMotCodigo(municipioOrdenTrabVo.getMotCodigo());

            if (municipioOrdenTrabVo.getOrdenTrabajoVisitaVO() != null &&
                municipioOrdenTrabVo.getOrdenTrabajoVisitaVO().getOtvCodigo() != null) {
                SiiOrdenTrabajoVisita siiOrdenTrabajoVisita =
                    ordenTrabajoVisitaDao.buscarPorCodigo(municipioOrdenTrabVo.getOrdenTrabajoVisitaVO().getOtvCodigo());
                siiMunicipioOrdenTrab.setSiiOrdenTrabajoVisita(siiOrdenTrabajoVisita);
            }

            if (municipioOrdenTrabVo.getUbicacionMunicipioVO() != null &&
                municipioOrdenTrabVo.getUbicacionMunicipioVO().getUbiCodigo() != null) {
                SiiUbicacion siiUbicacion =
                    ubicacionDao.buscarUbicacionPorId(municipioOrdenTrabVo.getUbicacionMunicipioVO().getUbiCodigo());
                siiMunicipioOrdenTrab.setSiiUbicacionMunicipio(siiUbicacion);
            }
        }

        return (siiMunicipioOrdenTrab);
    }


    /**
     * Convertir a su respectiva entidad
     * @param actaDestruccionVo - value object
     * @return siiActaDestruccion - entity
     * @throws ExcepcionDAO
     */

    public SiiActaDestruccion convertir(ActaDestruccionVO actaDestruccionVo) throws ExcepcionDAO {
        SiiActaDestruccion siiActaDestruccion = new SiiActaDestruccion();

        if (actaDestruccionVo != null) {
            if (actaDestruccionVo.getAdeCodigo() != null && actaDestruccionVo.getAdeCodigo() > 0) {
                siiActaDestruccion = actaDestruccionDao.buscarPorCodigo(actaDestruccionVo.getAdeCodigo());
            }

            siiActaDestruccion.setAdeCodigo(actaDestruccionVo.getAdeCodigo());
            siiActaDestruccion.setAdeEstado(actaDestruccionVo.getAdeEstado());
            siiActaDestruccion.setAdeFecha(actaDestruccionVo.getAdeFecha());
            siiActaDestruccion.setAdeFechaFin(actaDestruccionVo.getAdeFechaFin());
            siiActaDestruccion.setAdeFechaIni(actaDestruccionVo.getAdeFechaIni());
            siiActaDestruccion.setAdeLugar(actaDestruccionVo.getAdeLugar());
            siiActaDestruccion.setAdeNumero(actaDestruccionVo.getAdeNumero());

            if (actaDestruccionVo.getEmpresaDestruyeVo() != null &&
                actaDestruccionVo.getEmpresaDestruyeVo().getEmdCodigo() != null) {
                SiiEmpresaDestruye siiEmpresaDestruye =
                    empresaDestruyeDao.buscarPorCodigo(actaDestruccionVo.getEmpresaDestruyeVo().getEmdCodigo());
                siiActaDestruccion.setSiiEmpresaDestruye(siiEmpresaDestruye);
            }

            if (actaDestruccionVo.getMotivoNoDestruccionVo() != null &&
                actaDestruccionVo.getMotivoNoDestruccionVo().getMndCodigo() != null) {
                SiiMotivoNoDestruccion siiMotivoNoDestruccion =
                    motivoNoDestruccionDao.buscarPorCodigo(actaDestruccionVo.getMotivoNoDestruccionVo().getMndCodigo());
                siiActaDestruccion.setSiiMotivoNoDestruccion(siiMotivoNoDestruccion);
            }

            if (actaDestruccionVo.getUbicacionMunicVo() != null &&
                actaDestruccionVo.getUbicacionMunicVo().getUbiCodigo() != null) {
                SiiUbicacion siiUbicacionMunic =
                    ubicacionDao.buscarUbicacionPorId(actaDestruccionVo.getUbicacionMunicVo().getUbiCodigo());
                siiActaDestruccion.setSiiUbicacionMunic(siiUbicacionMunic);
            }

            if (actaDestruccionVo.getUsuarioConectVo() != null &&
                actaDestruccionVo.getUsuarioConectVo().getUsuCodigo() != null) {
                SiiUsuario siiUsuarioConect =
                    usuarioDao.buscarUsuarioPorId(actaDestruccionVo.getUsuarioConectVo().getUsuCodigo());
                siiActaDestruccion.setSiiUsuarioConect(siiUsuarioConect);
            }

        }

        return (siiActaDestruccion);
    }

    /**
     * Realiza la conversión del Value Object a Entity
     * @param resolucionDecomDestVo
     * @return siiResolucionDecomDest - Entity
     * @throws ExcepcionDAO
     */

    public SiiResolucionDecomDest convertir(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO {
        SiiResolucionDecomDest siiResolucionDecomDest = new SiiResolucionDecomDest();

        if (resolucionDecomDestVo != null) {
            if (resolucionDecomDestVo.getRddCodigo() != null && resolucionDecomDestVo.getRddCodigo() > 0) {
                siiResolucionDecomDest = resolucionDecomDestDao.buscarPorCodigo(resolucionDecomDestVo.getRddCodigo());
            }

            siiResolucionDecomDest.setRddCodigo(resolucionDecomDestVo.getRddCodigo());
            siiResolucionDecomDest.setRddFechaGener(resolucionDecomDestVo.getRddFechaGener());
            siiResolucionDecomDest.setRddFechaRadicac(resolucionDecomDestVo.getRddFechaRadicac());
            siiResolucionDecomDest.setRddResolucion(resolucionDecomDestVo.getRddResolucion());
            
            siiResolucionDecomDest.setRddFechaResolNumera(resolucionDecomDestVo.getRddFechaResolNumerado());
            siiResolucionDecomDest.setRddResolucionNumera(resolucionDecomDestVo.getRddNumeroResolNumerado());
            
            if (resolucionDecomDestVo.getResultadoResDecDesVo() != null &&
                resolucionDecomDestVo.getResultadoResDecDesVo().getRrdCodigo() != null) {
                SiiResultadoResDecDes siiResultadoResDecDes =
                    resultadoResDecDesDao.buscarPorCodigo(resolucionDecomDestVo.getResultadoResDecDesVo().getRrdCodigo());
                siiResolucionDecomDest.setSiiResultadoResDecDes(siiResultadoResDecDes);
            }
            
            if (resolucionDecomDestVo.getActaDestruccionVo() != null &&
                resolucionDecomDestVo.getActaDestruccionVo().getAdeCodigo() != null) {
                SiiActaDestruccion siiActaDestruccion =
                    actaDestruccionDao.buscarPorCodigo(resolucionDecomDestVo.getActaDestruccionVo().getAdeCodigo());
                siiResolucionDecomDest.setSiiActaDestruccion(siiActaDestruccion);
            }
            
            if (resolucionDecomDestVo.getUsuarioConectVo() != null &&
                resolucionDecomDestVo.getUsuarioConectVo().getUsuCodigo() != null) {
                SiiUsuario siiUsuarioConect =
                    usuarioDao.buscarUsuarioPorId(resolucionDecomDestVo.getUsuarioConectVo().getUsuCodigo());
                siiResolucionDecomDest.setSiiUsuarioConect(siiUsuarioConect);
            }

        }

        return (siiResolucionDecomDest);
    }

    /**
     * Realiza la conversión de value object a entity
     * @param motivoNoDestruccionVo
     * @return siiMotivoNoDestruccion - Entity
     * @throws ExcepcionDAO
     */

    public SiiMotivoNoDestruccion convertir(MotivoNoDestruccionVO motivoNoDestruccionVo) throws ExcepcionDAO {
        SiiMotivoNoDestruccion siiMotivoNoDestruccion = new SiiMotivoNoDestruccion();

        if (motivoNoDestruccionVo != null) {
            if (motivoNoDestruccionVo.getMndCodigo() != null && motivoNoDestruccionVo.getMndCodigo() > 0) {
                siiMotivoNoDestruccion = motivoNoDestruccionDao.buscarPorCodigo(motivoNoDestruccionVo.getMndCodigo());
            }

            siiMotivoNoDestruccion.setMndCodigo(motivoNoDestruccionVo.getMndCodigo());
            siiMotivoNoDestruccion.setMndNombre(motivoNoDestruccionVo.getMndNombre());

        }

        return (siiMotivoNoDestruccion);
    }
    
    /**
     * Realiza la conversión del value object a entity
     * @param empresaDestruyeVo
     * @return siiEmpresaDestruye - entity
     * @throws ExcepcionDAO
     */
    
    public SiiEmpresaDestruye convertir(EmpresaDestruyeVO empresaDestruyeVo) throws ExcepcionDAO {
        SiiEmpresaDestruye siiEmpresaDestruye = new SiiEmpresaDestruye();

        if (empresaDestruyeVo != null) {
            if (empresaDestruyeVo.getEmdCodigo() != null && empresaDestruyeVo.getEmdCodigo() > 0) {
                siiEmpresaDestruye = empresaDestruyeDao.buscarPorCodigo(empresaDestruyeVo.getEmdCodigo());
            }

            siiEmpresaDestruye.setEmdActivo(empresaDestruyeVo.getEmdActivo());
            siiEmpresaDestruye.setEmdCodigo(empresaDestruyeVo.getEmdCodigo());
            siiEmpresaDestruye.setEmdFechaActiv(empresaDestruyeVo.getEmdFechaActiv());
            siiEmpresaDestruye.setEmdFechaInac(empresaDestruyeVo.getEmdFechaInac());
            siiEmpresaDestruye.setEmdVigencia(empresaDestruyeVo.getEmdVigencia());
            
            if (empresaDestruyeVo.getPersonaVo() != null &&
                empresaDestruyeVo.getPersonaVo().getPerCodigo() != null) {
                SiiPersona siiPersona =
                    personaDao.buscarPersonaPorId(empresaDestruyeVo.getPersonaVo().getPerCodigo());
                siiEmpresaDestruye.setSiiPersona(siiPersona);
            }
            
            if (empresaDestruyeVo.getUsuarioConectVo() != null &&
                empresaDestruyeVo.getPersonaVo().getPerCodigo() != null) {
                SiiPersona siiPersona =
                    personaDao.buscarPersonaPorId(empresaDestruyeVo.getPersonaVo().getPerCodigo());
                siiEmpresaDestruye.setSiiPersona(siiPersona);
            }

        }

        return (siiEmpresaDestruye);
    }

    /**
     * Convertir el value object TramiteResolDecDes a su entidad
     * @param tramiteResolDecDesVo
     * @return siiTramiteResolDecDes - Entity
     * @throws ExcepcionDAO
     */

    public SiiTramiteResolDecDes convertir(TramiteResolDecDesVO tramiteResolDecDesVo) throws ExcepcionDAO {
        SiiTramiteResolDecDes siiTramiteResolDecDes = new SiiTramiteResolDecDes();

        if(tramiteResolDecDesVo != null) {
            if(tramiteResolDecDesVo.getTrdCodigo() != null && tramiteResolDecDesVo.getTrdCodigo() > 0) {
                siiTramiteResolDecDes = tramiteResolDecDesDao.buscarPorCodigo(tramiteResolDecDesVo.getTrdCodigo());
            }

            siiTramiteResolDecDes.setTrdCodigo(tramiteResolDecDesVo.getTrdCodigo());
            siiTramiteResolDecDes.setTrdFecha(tramiteResolDecDesVo.getTrdFecha());

            if(tramiteResolDecDesVo.getEstadoTramResDecDesVo() != null && tramiteResolDecDesVo.getEstadoTramResDecDesVo().getEtdCodigo() != null) {
                SiiEstadoTramResDecDes siiEstadoTramResDecDes = estadoTramResDecDesDao.buscarPorCodigo(tramiteResolDecDesVo.getEstadoTramResDecDesVo().getEtdCodigo());
                siiTramiteResolDecDes.setSiiEstadoTramResDecDes(siiEstadoTramResDecDes);
            }

            if(tramiteResolDecDesVo.getResolucionDecomDestVo() != null && tramiteResolDecDesVo.getResolucionDecomDestVo().getRddCodigo() != null) {
                SiiResolucionDecomDest siiResolucionDecomDest = resolucionDecomDestDAO.buscarPorCodigo(tramiteResolDecDesVo.getResolucionDecomDestVo().getRddCodigo());
                siiTramiteResolDecDes.setSiiResolucionDecomDest(siiResolucionDecomDest);
            }

            if(tramiteResolDecDesVo.getUsuarioConectVo() != null && tramiteResolDecDesVo.getUsuarioConectVo().getUsuCodigo() != null) {
                SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(tramiteResolDecDesVo.getUsuarioConectVo().getUsuCodigo());
                siiTramiteResolDecDes.setSiiUsuarioConect(siiUsuario);
            }

        }

        return (siiTramiteResolDecDes);
    }
    
    /**
     * Convierte el value object de la comunicación de la resolución de las personas investigadas en su determinada entidad
     * @param comunicResolPersIleVo
     * @return siiComunicResolPersIle - Entity
     * @throws ExcepcionDAO
     */
    
    public SiiComunicResolPersIle convertir(ComunicResolPersIleVO comunicResolPersIleVo) throws ExcepcionDAO {
        SiiComunicResolPersIle siiComunicResolPersIle = new SiiComunicResolPersIle();

        if(comunicResolPersIleVo != null) {
            if(comunicResolPersIleVo.getCorCodigo() != null && comunicResolPersIleVo.getCorCodigo() > 0) {
                siiComunicResolPersIle = comunicResolPersIleDao.buscarPorCodigo(comunicResolPersIleVo.getCorCodigo());
            }

            siiComunicResolPersIle.setCorCodigo(comunicResolPersIleVo.getCorCodigo());
            siiComunicResolPersIle.setCorFechaFinPub(comunicResolPersIleVo.getCorFechaFinPub());
            siiComunicResolPersIle.setCorFechaIniPub(comunicResolPersIleVo.getCorFechaIniPub());
            siiComunicResolPersIle.setCorFechaRad(comunicResolPersIleVo.getCorFechaRad());
            siiComunicResolPersIle.setCorRadicado(comunicResolPersIleVo.getCorRadicado());

            if(comunicResolPersIleVo.getPersonaInvestProIleVo() != null && comunicResolPersIleVo.getPersonaInvestProIleVo().getPipCodigo() != null) {
                SiiPersonaInvestProIle siiPersonaInvestProIle = personaInvestProIleDao.buscarPorCodigo(comunicResolPersIleVo.getPersonaInvestProIleVo().getPipCodigo()); 
                siiComunicResolPersIle.setSiiPersonaInvestProIle(siiPersonaInvestProIle);
            }

            if(comunicResolPersIleVo.getResolucionProcIlegVo() != null && comunicResolPersIleVo.getResolucionProcIlegVo().getRpiCodigo() != null) {
                SiiResolucionProcIleg siiResolucionProcIleg = resolucionProcIlegDao.buscarPorCodigo(comunicResolPersIleVo.getResolucionProcIlegVo().getRpiCodigo());
                siiComunicResolPersIle.setSiiResolucionProcIleg(siiResolucionProcIleg);
            }
            
            if(comunicResolPersIleVo.getUsuarioConecVo() != null && comunicResolPersIleVo.getUsuarioConecVo().getUsuCodigo() != null) {
                SiiUsuario siiUsuarioConec = usuarioDao.buscarUsuarioPorId(comunicResolPersIleVo.getUsuarioConecVo().getUsuCodigo());
                siiComunicResolPersIle.setSiiUsuarioConec(siiUsuarioConec);
            }
        }

        return (siiComunicResolPersIle);
    }
    
    /**
     * Convertir el value object de la persona investigada del proceso sancionatorio de ilegalidad en su respectiva entidad
     * @param personaInvestProIleVo - Value object
     * @return siiPersonaInvestProIle - entity
     * @throws ExcepcionDAO
     */

    public SiiPersonaInvestProIle convertir(PersonaInvestProIleVO personaInvestProIleVo) throws ExcepcionDAO {
        SiiPersonaInvestProIle siiPersonaInvestProIle = new SiiPersonaInvestProIle();

        if(personaInvestProIleVo != null) {
            if(personaInvestProIleVo.getPipCodigo() != null && personaInvestProIleVo.getPipCodigo() > 0) {
                siiPersonaInvestProIle = personaInvestProIleDao.buscarPorCodigo(personaInvestProIleVo.getPipCodigo());
            }

            siiPersonaInvestProIle.setPipActivo(personaInvestProIleVo.getPipActivo());
            siiPersonaInvestProIle.setPipCodigo(personaInvestProIleVo.getPipCodigo());
            siiPersonaInvestProIle.setPipComIniFechaRad(personaInvestProIleVo.getPipComIniFechaRad());
            siiPersonaInvestProIle.setPipComIniRadicado(personaInvestProIleVo.getPipComIniRadicado());
            siiPersonaInvestProIle.setPipResEnvFecha(personaInvestProIleVo.getPipResEnvFecha());
            siiPersonaInvestProIle.setPipResEnvIndResp(personaInvestProIleVo.getPipResEnvIndResp());
            siiPersonaInvestProIle.setPipResEnvNumGuia(personaInvestProIleVo.getPipResEnvNumGuia());
            siiPersonaInvestProIle.setPipCreada(personaInvestProIleVo.getPipCreada());
            siiPersonaInvestProIle.setPipSancionada(personaInvestProIleVo.getPipSancionada());
            siiPersonaInvestProIle.setPipAutorEnvEmail(personaInvestProIleVo.getPipAutorEnvEmail());
            siiPersonaInvestProIle.setPipInvestigada(personaInvestProIleVo.getPipInvestigada());
            
            if(personaInvestProIleVo.getProcesoSancIlegalidadVo() != null && personaInvestProIleVo.getProcesoSancIlegalidadVo().getPrsCodigo() != null) {
                SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = procesoSancIlegalidadDao.buscarPorCodigo(personaInvestProIleVo.getProcesoSancIlegalidadVo().getPrsCodigo());
                siiPersonaInvestProIle.setSiiProcesoSancIlegalidad(siiProcesoSancIlegalidad);
            }

            if(personaInvestProIleVo.getPersonaVo() != null && personaInvestProIleVo.getPersonaVo().getPerCodigo() != null) {
                SiiPersona siiPersona = personaDao.buscarPersonaPorId(personaInvestProIleVo.getPersonaVo().getPerCodigo());
                siiPersonaInvestProIle.setSiiPersona(siiPersona);
            }
            
            if(personaInvestProIleVo.getUsuarioConecVo() != null && personaInvestProIleVo.getUsuarioConecVo().getUsuCodigo() != null) {
                SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(personaInvestProIleVo.getUsuarioConecVo().getUsuCodigo());
                siiPersonaInvestProIle.setSiiUsuarioConec(siiUsuario);
            }

        }

        return (siiPersonaInvestProIle);
    }
    
    /**
     * Convertir el value object de la dirección procesal de una persona investigada de un proceso sancionatorio de ilegalidad en su respectivo entity
     * @param direccionProcePerIleVo - Value object
     * @return siiDireccionProcePerIle - Entity
     * @throws ExcepcionDAO
     */
    
    public SiiDireccionProcePerIle convertir(DireccionProcePerIleVO direccionProcePerIleVo) throws ExcepcionDAO {
        SiiDireccionProcePerIle siiDireccionProcePerIle = new SiiDireccionProcePerIle();

        if(direccionProcePerIleVo != null) {
            if(direccionProcePerIleVo.getDipCodigo() != null && direccionProcePerIleVo.getDipCodigo() > 0) {
                siiDireccionProcePerIle = direccionProcePerIleDao.buscarPorCodigo(direccionProcePerIleVo.getDipCodigo());
            }

            siiDireccionProcePerIle.setDipCodigo(direccionProcePerIleVo.getDipCodigo());

            if(direccionProcePerIleVo.getDireccionVo() != null && direccionProcePerIleVo.getDireccionVo().getDirCodigo() != null) {
                SiiDireccion siiDireccion = direccionDao.buscarPorCodigo(direccionProcePerIleVo.getDireccionVo().getDirCodigo());
                siiDireccionProcePerIle.setSiiDireccion(siiDireccion);
            }

            if(direccionProcePerIleVo.getPersonaInvestProIleVo() != null && direccionProcePerIleVo.getPersonaInvestProIleVo().getPipCodigo() != null) {
                SiiPersonaInvestProIle siiPersonaInvestProIle = personaInvestProIleDao.buscarPorCodigo(direccionProcePerIleVo.getPersonaInvestProIleVo().getPipCodigo());
                siiDireccionProcePerIle.setSiiPersonaInvestProIle(siiPersonaInvestProIle);
            }
            
            if(direccionProcePerIleVo.getUbicacionVo() != null && direccionProcePerIleVo.getUbicacionVo().getUbiCodigo() != null) {
                SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId(direccionProcePerIleVo.getUbicacionVo().getUbiCodigo());
                siiDireccionProcePerIle.setSiiUbicacion(siiUbicacion);
            }
            
            if(direccionProcePerIleVo.getUsuarioConecVo() != null && direccionProcePerIleVo.getUsuarioConecVo().getUsuCodigo() != null) {
                SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(direccionProcePerIleVo.getUsuarioConecVo().getUsuCodigo());
                siiDireccionProcePerIle.setSiiUsuarioConec(siiUsuario);
            }

        }

        return (siiDireccionProcePerIle);
    }
    
    /**
     * Convertir el value object en su respectiva entidad
     * @param direccionPersonaVo
     * @return siiDireccionPersona - Entity
     * @throws ExcepcionDAO
     */
    
    public SiiDireccionPersona convertir(DireccionPersonaVO direccionPersonaVo) throws ExcepcionDAO {
        SiiDireccionPersona siiDireccionPersona = new SiiDireccionPersona();

        if (direccionPersonaVo != null) {
            if (direccionPersonaVo.getDpeCodigo() != null && direccionPersonaVo.getDpeCodigo() > 0) {
                siiDireccionPersona = direccionPersonaDao.buscarPorCodigo(direccionPersonaVo.getDpeCodigo());
            }

            siiDireccionPersona.setDpeCodigo(direccionPersonaVo.getDpeCodigo());

            if (direccionPersonaVo.getDireccionVo() != null &&
                direccionPersonaVo.getDireccionVo().getDirCodigo() != null) {
                SiiDireccion siiDireccion =
                    direccionDao.buscarPorCodigo(direccionPersonaVo.getDireccionVo().getDirCodigo());
                siiDireccionPersona.setSiiDireccion(siiDireccion);
            }
            
            if (direccionPersonaVo.getPersonaVo() != null &&
                direccionPersonaVo.getPersonaVo().getPerCodigo() != null) {
                SiiPersona siiPersona =
                    personaDao.buscarPersonaPorId(direccionPersonaVo.getPersonaVo().getPerCodigo());
                siiDireccionPersona.setSiiPersona(siiPersona);
            }
            
            if (direccionPersonaVo.getUbicacionMunicipioVo() != null &&
                direccionPersonaVo.getUbicacionMunicipioVo().getUbiCodigo() != null) {
                SiiUbicacion siiUbicacionMunicipio =
                    ubicacionDao.buscarUbicacionPorId(direccionPersonaVo.getUbicacionMunicipioVo().getUbiCodigo());
                siiDireccionPersona.setSiiUbicacionMunicipio(siiUbicacionMunicipio);
            }
            
            if (direccionPersonaVo.getUsuarioConecVo() != null &&
                direccionPersonaVo.getUsuarioConecVo().getUsuCodigo() != null) {
                SiiUsuario siiUsuarioConec =
                    usuarioDao.buscarUsuarioPorId(direccionPersonaVo.getUsuarioConecVo().getUsuCodigo());
                siiDireccionPersona.setSiiUsuarioConec(siiUsuarioConec);
            }

        }

        return (siiDireccionPersona);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param notaCreditoVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiNotaCredito convertir(NotaCreditoVO notaCreditoVo) throws ExcepcionDAO {
        SiiNotaCredito siiNotaCredito = new SiiNotaCredito();

        if (notaCreditoVo != null) {
            if (notaCreditoVo.getNcrCodigo() != null && notaCreditoVo.getNcrCodigo() > 0) {
                siiNotaCredito = notaCreditoDao.buscarPorCodigo(notaCreditoVo.getNcrCodigo());
            }

            siiNotaCredito.setNcrCodigo(notaCreditoVo.getNcrCodigo());
            siiNotaCredito.setNcrEstado(notaCreditoVo.getNcrEstado());
            siiNotaCredito.setNcrFecha(notaCreditoVo.getNcrFecha());
            siiNotaCredito.setNcrNumero(notaCreditoVo.getNcrNumero());
            siiNotaCredito.setNcrRcIndepend(notaCreditoVo.getNcrRcIndepend());
            siiNotaCredito.setNcrTipoNota(notaCreditoVo.getNcrTipoNota());
            siiNotaCredito.setNcrMotivoAnula(notaCreditoVo.getNcrMotivoAnula());
            siiNotaCredito.setNcrConcepto(notaCreditoVo.getNcrConcepto());


            if (notaCreditoVo.getFuenteFinancContabVo() != null &&
                notaCreditoVo.getFuenteFinancContabVo().getFfcCodigo() != null) {
                SiiFuenteFinancContab siiFuenteFinancContab =
                    fuenteFinancContabDao.buscarPorCodigo(notaCreditoVo.getFuenteFinancContabVo().getFfcCodigo());
                siiNotaCredito.setSiiFuenteFinancContab(siiFuenteFinancContab);
            }

            if (notaCreditoVo.getObligacionVo() != null && notaCreditoVo.getObligacionVo().getOblCodigo() != null) {
                SiiObligacion siiObligacion =
                    obligacionDao.buscarPorCodigo(notaCreditoVo.getObligacionVo().getOblCodigo());
                siiNotaCredito.setSiiObligacion(siiObligacion);
            }

            if (notaCreditoVo.getUsuarioApruebaVo() != null &&
                notaCreditoVo.getUsuarioApruebaVo().getUsuCodigo() != null) {
                SiiUsuario siiUsuario =
                    usuarioDao.buscarUsuarioPorId(notaCreditoVo.getUsuarioApruebaVo().getUsuCodigo());
                siiNotaCredito.setSiiUsuarioAprueba(siiUsuario);
            }

            if (notaCreditoVo.getUsuarioRegistraVo() != null &&
                notaCreditoVo.getUsuarioRegistraVo().getUsuCodigo() != null) {
                SiiUsuario siiUsuario =
                    usuarioDao.buscarUsuarioPorId(notaCreditoVo.getUsuarioRegistraVo().getUsuCodigo());
                siiNotaCredito.setSiiUsuarioRegistra(siiUsuario);
            }
        }

        return (siiNotaCredito);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param notaCredOblConceptoVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiNotaCredOblConcepto convertir(NotaCredOblConceptoVO notaCredOblConceptoVo) throws ExcepcionDAO {
        SiiNotaCredOblConcepto siiNotaCredOblConcepto = new SiiNotaCredOblConcepto();

        if (notaCredOblConceptoVo != null) {
            if (notaCredOblConceptoVo.getNcoCodigo() != null && notaCredOblConceptoVo.getNcoCodigo() > 0) {
                siiNotaCredOblConcepto = notaCredOblConceptoDao.buscarPorCodigo(notaCredOblConceptoVo.getNcoCodigo());
            }

            siiNotaCredOblConcepto.setNcoCodigo(notaCredOblConceptoVo.getNcoCodigo());
            siiNotaCredOblConcepto.setNcoAiu(notaCredOblConceptoVo.getNcoAiu());
            siiNotaCredOblConcepto.setNcoBenefDedAfc(notaCredOblConceptoVo.getNcoBenefDedAfc());
            siiNotaCredOblConcepto.setNcoBenefDedAfp(notaCredOblConceptoVo.getNcoBenefDedAfp());
            siiNotaCredOblConcepto.setNcoIva(notaCredOblConceptoVo.getNcoIva());
            siiNotaCredOblConcepto.setNcoSubtotal(notaCredOblConceptoVo.getNcoSubtotal());
            siiNotaCredOblConcepto.setNcoValor(notaCredOblConceptoVo.getNcoValor());
            siiNotaCredOblConcepto.setNcoValorRetiva(notaCredOblConceptoVo.getNcoValorRetiva());
            siiNotaCredOblConcepto.setNcoValorRetica(notaCredOblConceptoVo.getNcoValorRetica());
            siiNotaCredOblConcepto.setNcoValorRetrenta(notaCredOblConceptoVo.getNcoValorRetrenta());
            siiNotaCredOblConcepto.setNcoValorRetest(notaCredOblConceptoVo.getNcoValorRetest());


            if (notaCredOblConceptoVo.getNotaCreditoVo() != null &&
                notaCredOblConceptoVo.getNotaCreditoVo().getNcrCodigo() != null) {
                SiiNotaCredito siiNotaCredito =
                    notaCreditoDao.buscarPorCodigo(notaCredOblConceptoVo.getNotaCreditoVo().getNcrCodigo());
                siiNotaCredOblConcepto.setSiiNotaCredito(siiNotaCredito);
            }

            if (notaCredOblConceptoVo.getObligacionConceptoVo() != null &&
                notaCredOblConceptoVo.getObligacionConceptoVo().getOcoCodigo() != null) {
                SiiObligacionConcepto siiObligacionConcepto =
                    obligacionConceptoDao.buscarPorCodigo(notaCredOblConceptoVo.getObligacionConceptoVo().getOcoCodigo());
                siiNotaCredOblConcepto.setSiiObligacionConcepto(siiObligacionConcepto);
            }

            if (notaCredOblConceptoVo.getDetalleContNominaVo() != null &&
                notaCredOblConceptoVo.getDetalleContNominaVo().getDcmCodigo() != null) {
                SiiDetalleContNomina siiDetalleContNomina =
                    detalleContNominaDao.buscarPorCodigo(notaCredOblConceptoVo.getDetalleContNominaVo().getDcmCodigo());
                siiNotaCredOblConcepto.setSiiDetalleContNomina(siiDetalleContNomina);
            }
        }

        return (siiNotaCredOblConcepto);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param notaCredOblConcDetRubVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiNotaCredOblConcDetRub convertir(NotaCredOblConcDetRubVO notaCredOblConcDetRubVo) throws ExcepcionDAO {
        SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub = new SiiNotaCredOblConcDetRub();

        if (notaCredOblConcDetRubVo != null) {
            if (notaCredOblConcDetRubVo.getNdrCodigo() != null && notaCredOblConcDetRubVo.getNdrCodigo() > 0) {
                siiNotaCredOblConcDetRub =
                    notaCredOblConcDetRubDao.buscarPorCodigo(notaCredOblConcDetRubVo.getNdrCodigo());
            }

            siiNotaCredOblConcDetRub.setNdrCodigo(notaCredOblConcDetRubVo.getNdrCodigo());
            siiNotaCredOblConcDetRub.setNdrValor(notaCredOblConcDetRubVo.getNdrValor());


            if (notaCredOblConcDetRubVo.getNotaCreditoVo() != null &&
                notaCredOblConcDetRubVo.getNotaCreditoVo().getNcrCodigo() != null) {
                SiiNotaCredito siiNotaCredito =
                    notaCreditoDao.buscarPorCodigo(notaCredOblConcDetRubVo.getNotaCreditoVo().getNcrCodigo());
                siiNotaCredOblConcDetRub.setSiiNotaCredito(siiNotaCredito);
            }

            if (notaCredOblConcDetRubVo.getOblConcRpDetRubCdpVo() != null &&
                notaCredOblConcDetRubVo.getOblConcRpDetRubCdpVo().getOcrCodigo() != null) {
                SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp =
                    oblConcRpDetRubCdpDao.buscarPorCodigo(notaCredOblConcDetRubVo.getOblConcRpDetRubCdpVo().getOcrCodigo());
                siiNotaCredOblConcDetRub.setSiiOblConcRpDetRubCdp(siiOblConcRpDetRubCdp);
            }
        }

        return (siiNotaCredOblConcDetRub);
    }

    public SiiReintegroIngresoPag convertir(ReintegroPagaduriaVO reintegroPagaduriaVo) throws ExcepcionDAO {
        SiiReintegroIngresoPag siiReintegroIngresoPag = new SiiReintegroIngresoPag();
        if (reintegroPagaduriaVo != null) {
            if (reintegroPagaduriaVo.getRipCodigo() != null && reintegroPagaduriaVo.getRipCodigo() > 0) {
                siiReintegroIngresoPag =
                    reintegroPagaduriaDao.buscarPorCodigoReintegroIngresoPag(reintegroPagaduriaVo.getRipCodigo());
            }
            siiReintegroIngresoPag.setRipConcepto(reintegroPagaduriaVo.getRipConcepto());
            siiReintegroIngresoPag.setRipEstado(reintegroPagaduriaVo.getRipEstado());
            siiReintegroIngresoPag.setRipFecha(reintegroPagaduriaVo.getRipFecha());
            siiReintegroIngresoPag.setRipNumero(reintegroPagaduriaVo.getRipNumero());
            siiReintegroIngresoPag.setRipValor(reintegroPagaduriaVo.getRipValor());

            if (reintegroPagaduriaVo.getCuentaBancariaVo() != null &&
                reintegroPagaduriaVo.getCuentaBancariaVo().getCbaCodigo() != null) {
                SiiCuentaBancaria siiCuentaBancaria =
                    cuentaBancariaDao.buscarCuentaPorId(reintegroPagaduriaVo.getCuentaBancariaVo().getCbaCodigo());
                siiReintegroIngresoPag.setSiiCuentaBancaria(siiCuentaBancaria);
            }
            if (reintegroPagaduriaVo.getNotaCreditoVo() != null &&
                reintegroPagaduriaVo.getNotaCreditoVo().getNcrCodigo() != null) {
                SiiNotaCredito siiNotaCredito =
                    notaCreditoDao.buscarPorCodigo(reintegroPagaduriaVo.getNotaCreditoVo().getNcrCodigo());
                siiReintegroIngresoPag.setSiiNotaCredito(siiNotaCredito);
            }
        }
        return (siiReintegroIngresoPag);
    }


    public SiiInformeSupervision convertir(InformeSupervisionVO informeSupervisionVo) throws ExcepcionDAO {
        SiiInformeSupervision siiInformeSupervision = new SiiInformeSupervision();

        if (informeSupervisionVo != null) {
            if (informeSupervisionVo.getIsuCodigo() != null && informeSupervisionVo.getIsuCodigo() > 0) {
                siiInformeSupervision = informeSupervisionDao.buscarPorCodigo(informeSupervisionVo.getIsuCodigo());
            }

            siiInformeSupervision.setIsuCodigo(informeSupervisionVo.getIsuCodigo());
            siiInformeSupervision.setIsuEstado(informeSupervisionVo.getIsuEstado());
            siiInformeSupervision.setIsuFechaRadicacion(informeSupervisionVo.getIsuFechaRadicacion());
            siiInformeSupervision.setIsuRadicado(informeSupervisionVo.getIsuRadicado());
            //Padres:
            if (informeSupervisionVo.getArchivoFisicoVo() != null &&
                informeSupervisionVo.getArchivoFisicoVo().getAfiCodigo() != null) {
                siiInformeSupervision.setSiiArchivoFisico(archivoFisicoDao.buscarArchivoFisicoPorId(informeSupervisionVo.getArchivoFisicoVo().getAfiCodigo()));
            }
            if (informeSupervisionVo.getContratoVo() != null &&
                informeSupervisionVo.getContratoVo().getConCodigo() != null) {
                siiInformeSupervision.setSiiContrato(contratoDao.buscarContratoPorId(informeSupervisionVo.getContratoVo().getConCodigo()));
            }
            if (informeSupervisionVo.getUsuarioVo() != null &&
                informeSupervisionVo.getUsuarioVo().getUsuCodigo() != null) {
                siiInformeSupervision.setSiiUsuario(usuarioDao.buscarUsuarioPorId(informeSupervisionVo.getUsuarioVo().getUsuCodigo()));
            }
            if (informeSupervisionVo.getTipoActuacionVo() != null &&
                informeSupervisionVo.getTipoActuacionVo().getTacCodigo() != null) {
                siiInformeSupervision.setSiiTipoActuacion(tipoActuacionDao.buscarPorCodigo(informeSupervisionVo.getTipoActuacionVo().getTacCodigo()));
            }
        }
        return siiInformeSupervision;
    }

    public SiiMotivoIncuInfSuperv convertir(MotivoIncuInfSupervVO motivoIncuInfSupervVo) throws ExcepcionDAO {
        SiiMotivoIncuInfSuperv siiMotivoIncuInfSuperv = new SiiMotivoIncuInfSuperv();

        if (motivoIncuInfSupervVo != null) {
            if (siiMotivoIncuInfSuperv.getMiiCodigo() != null && siiMotivoIncuInfSuperv.getMiiCodigo() > 0) {
                siiMotivoIncuInfSuperv = motivoIncuInfSupervDao.buscarPorCodigo(motivoIncuInfSupervVo.getMiiCodigo());
            }

            siiMotivoIncuInfSuperv.setMiiActivo(motivoIncuInfSupervVo.getMiiActivo());
            siiMotivoIncuInfSuperv.setMiiCodigo(motivoIncuInfSupervVo.getMiiCodigo());
            //Padres:
            if (motivoIncuInfSupervVo.getInformeSupervisionVo() != null &&
                motivoIncuInfSupervVo.getInformeSupervisionVo().getIsuCodigo() != null) {
                siiMotivoIncuInfSuperv.setSiiInformeSupervision(informeSupervisionDao.buscarPorCodigo(motivoIncuInfSupervVo.getInformeSupervisionVo().getIsuCodigo()));
            }
            if (motivoIncuInfSupervVo.getMotivoIncumplimientoVo() != null &&
                motivoIncuInfSupervVo.getMotivoIncumplimientoVo().getMinCodigo() != null) {
                siiMotivoIncuInfSuperv.setSiiMotivoIncumplimiento(motivoIncumplimientoDao.buscarPorCodigo(motivoIncuInfSupervVo.getMotivoIncumplimientoVo().getMinCodigo()));
            }
        }
        return siiMotivoIncuInfSuperv;
    }

    public SiiAutoComisorio convertir(AutoComisorioVO autoComisorioVo) throws ExcepcionDAO {
        SiiAutoComisorio siiAutoComisorio = new SiiAutoComisorio();
        if (autoComisorioVo != null) {
            if (autoComisorioVo.getAucCodigo() != null && autoComisorioVo.getAucCodigo() > 0)
                siiAutoComisorio = autoComisorioDao.buscarPorCodigoAutoComisorio(autoComisorioVo.getAucCodigo());

            siiAutoComisorio.setAucEstado(autoComisorioVo.getAucEstado());
            siiAutoComisorio.setAucFecha(autoComisorioVo.getAucFecha());
            siiAutoComisorio.setAucFechaAnulac(autoComisorioVo.getAucFechaAnulac());
            siiAutoComisorio.setAucFechaVisita(autoComisorioVo.getAucFechaVisita());
            siiAutoComisorio.setAucTipoVisita(autoComisorioVo.getAucTipoVisita());
            siiAutoComisorio.setAucMotivoAnulac(autoComisorioVo.getAucMotivoAnulac());
            siiAutoComisorio.setAucNumero(autoComisorioVo.getAucNumero());

            if (autoComisorioVo.getContratoVo() != null && autoComisorioVo.getContratoVo().getConCodigo() > 0)
                siiAutoComisorio.setSiiContrato(contratoDao.buscarContratoPorId(autoComisorioVo.getContratoVo().getConCodigo()));

            if (autoComisorioVo.getEstablecimientoVo() != null &&
                autoComisorioVo.getEstablecimientoVo().getEstCodigo() > 0)
                siiAutoComisorio.setSiiEstablecimiento(establecimientoDao.buscarEstablecimientoPorId(autoComisorioVo.getEstablecimientoVo().getEstCodigo()));

            if (autoComisorioVo.getGrupoFiscalizacionVo() != null &&
                autoComisorioVo.getGrupoFiscalizacionVo().getGfiCodigo() > 0)
                siiAutoComisorio.setSiiGrupoFiscalizacion(grupoFiscalizadorDao.buscarPorCodigoSiiGrupoFiscalizacion(autoComisorioVo.getGrupoFiscalizacionVo().getGfiCodigo()));

        }
        return siiAutoComisorio;
    }

    public SiiIncumplimientoContr convertir(IncumplimientoContrVO incumplimientoContrVo) throws ExcepcionDAO {
        SiiIncumplimientoContr siiIncumplimientoContr = new SiiIncumplimientoContr();

        if (incumplimientoContrVo != null) {
            if (incumplimientoContrVo.getIcnCodigo() != null && incumplimientoContrVo.getIcnCodigo() > 0) {
                siiIncumplimientoContr = incumplimientoContrDao.buscarPorCodigo(incumplimientoContrVo.getIcnCodigo());
            }

            siiIncumplimientoContr.setIcnCodigo(incumplimientoContrVo.getIcnCodigo());
            siiIncumplimientoContr.setIcnConsecutivo(incumplimientoContrVo.getIcnConsecutivo());
            siiIncumplimientoContr.setIcnFechaAutoArchivo(incumplimientoContrVo.getIcnFechaAutoArchivo());
            siiIncumplimientoContr.setIcnFechaCancelacion(incumplimientoContrVo.getIcnFechaCancelacion());
            siiIncumplimientoContr.setIcnFechaCitaAud(incumplimientoContrVo.getIcnFechaCitaAud());
            siiIncumplimientoContr.setIcnFechaComAse(incumplimientoContrVo.getIcnFechaComAse());
            siiIncumplimientoContr.setIcnFechaComOpe(incumplimientoContrVo.getIcnFechaComOpe());
            siiIncumplimientoContr.setIcnFechaConstEjecut(incumplimientoContrVo.getIcnFechaConstEjecut());
            siiIncumplimientoContr.setIcnFechaRadCitAse(incumplimientoContrVo.getIcnFechaRadCitAse());
            siiIncumplimientoContr.setIcnFechaRadCitOpe(incumplimientoContrVo.getIcnFechaRadCitOpe());
            siiIncumplimientoContr.setIcnFechaReanudAud(incumplimientoContrVo.getIcnFechaReanudAud());
            siiIncumplimientoContr.setIcnFechaSuperaInc(incumplimientoContrVo.getIcnFechaSuperaInc());
            siiIncumplimientoContr.setIcnFechaSuspension(incumplimientoContrVo.getIcnFechaSuspension());
            siiIncumplimientoContr.setIcnFormaComunicaAse(incumplimientoContrVo.getIcnFormaComunicaAse());
            siiIncumplimientoContr.setIcnFormaComunicaOpe(incumplimientoContrVo.getIcnFormaComunicaOpe());
            siiIncumplimientoContr.setIcnMotivoCancelac(incumplimientoContrVo.getIcnMotivoCancelac());
            siiIncumplimientoContr.setIcnMotivoSuspen(incumplimientoContrVo.getIcnMotivoSuspen());
            siiIncumplimientoContr.setIcnNumAutoArchivo(incumplimientoContrVo.getIcnNumAutoArchivo());
            siiIncumplimientoContr.setIcnNumGuiaAse(incumplimientoContrVo.getIcnNumGuiaAse());
            siiIncumplimientoContr.setIcnNumGuiaOpe(incumplimientoContrVo.getIcnNumGuiaOpe());
            siiIncumplimientoContr.setIcnObservacCancela(incumplimientoContrVo.getIcnObservacCancela());
            siiIncumplimientoContr.setIcnObservacionesSus(incumplimientoContrVo.getIcnObservacionesSus());
            siiIncumplimientoContr.setIcnRadicaCitaAse(incumplimientoContrVo.getIcnRadicaCitaAse());
            siiIncumplimientoContr.setIcnRadicaCitaOpe(incumplimientoContrVo.getIcnRadicaCitaOpe());
            siiIncumplimientoContr.setIcnDiasIncumplim(incumplimientoContrVo.getIcnDiasIncumplim());
            siiIncumplimientoContr.setIcnValorClausulaP(incumplimientoContrVo.getIcnValorClausulaP());
            siiIncumplimientoContr.setIcnValorMulta(incumplimientoContrVo.getIcnValorMulta());
            siiIncumplimientoContr.setIcnCantidadElem(incumplimientoContrVo.getIcnCantidadElem());
            siiIncumplimientoContr.setIcnSuperoInc(incumplimientoContrVo.getIcnSuperoInc());
            siiIncumplimientoContr.setIcnRepLegPrimApeCitAud(incumplimientoContrVo.getIcnRepLegPrimApeCitAud());
            siiIncumplimientoContr.setIcnRepLegPrimNomCitAud(incumplimientoContrVo.getIcnRepLegPrimNomCitAud());
            siiIncumplimientoContr.setIcnRepLegSegApeCitAud(incumplimientoContrVo.getIcnRepLegSegApeCitAud());
            siiIncumplimientoContr.setIcnRepLegSegNomCitAud(incumplimientoContrVo.getIcnRepLegSegNomCitAud());
            
            //Padres:
            if (incumplimientoContrVo.getArchivoFisicoAsegVo() != null &&
                incumplimientoContrVo.getArchivoFisicoAsegVo().getAfiCodigo() != null) {
                siiIncumplimientoContr.setSiiArchivoFisicoAseg(archivoFisicoDao.buscarArchivoFisicoPorId(incumplimientoContrVo.getArchivoFisicoAsegVo().getAfiCodigo()));
            }
            if (incumplimientoContrVo.getArchivoFisicoAutoVo() != null &&
                incumplimientoContrVo.getArchivoFisicoAutoVo().getAfiCodigo() != null) {
                siiIncumplimientoContr.setSiiArchivoFisicoAuto(archivoFisicoDao.buscarArchivoFisicoPorId(incumplimientoContrVo.getArchivoFisicoAutoVo().getAfiCodigo()));
            }
            if (incumplimientoContrVo.getArchivoFisicoOperVo() != null &&
                incumplimientoContrVo.getArchivoFisicoOperVo().getAfiCodigo() != null) {
                siiIncumplimientoContr.setSiiArchivoFisicoOper(archivoFisicoDao.buscarArchivoFisicoPorId(incumplimientoContrVo.getArchivoFisicoOperVo().getAfiCodigo()));
            }
            if (incumplimientoContrVo.getEstadoIncumplContractVo() != null &&
                incumplimientoContrVo.getEstadoIncumplContractVo().getEicCodigo() != null) {
                siiIncumplimientoContr.setSiiEstadoIncumplContract(estadoIncumplContractDao.buscarPorCodigo(incumplimientoContrVo.getEstadoIncumplContractVo().getEicCodigo()));
            }
            if (incumplimientoContrVo.getInformeSupervisionVo() != null &&
                incumplimientoContrVo.getInformeSupervisionVo().getIsuCodigo() != null) {
                siiIncumplimientoContr.setSiiInformeSupervision(informeSupervisionDao.buscarPorCodigo(incumplimientoContrVo.getInformeSupervisionVo().getIsuCodigo()));
            }
            
            if (incumplimientoContrVo.getResolucionIncumContrRecursoVo()!=null && incumplimientoContrVo.getResolucionIncumContrRecursoVo().getRcoCodigo()!=null) {
                SiiResolucionIncumContr siiResolucionIncumContr = resolucionIncumContrDao.buscarPorCodigo(incumplimientoContrVo.getResolucionIncumContrRecursoVo().getRcoCodigo());
                siiIncumplimientoContr.setSiiResolucionIncumContrRecurso(siiResolucionIncumContr);
            }
            
            if (incumplimientoContrVo.getResolucionIncumContrResolVo()!=null && incumplimientoContrVo.getResolucionIncumContrResolVo().getRcoCodigo()!=null) {
                SiiResolucionIncumContr siiResolucionIncumContr = resolucionIncumContrDao.buscarPorCodigo(incumplimientoContrVo.getResolucionIncumContrResolVo().getRcoCodigo());
                siiIncumplimientoContr.setSiiResolucionIncumContrResol(siiResolucionIncumContr);
            }
            
            if (incumplimientoContrVo.getUsuarioRegistraVo()!=null && incumplimientoContrVo.getUsuarioRegistraVo().getUsuCodigo()!=null) {
                SiiUsuario siiUsuarioRegistra = usuarioDao.buscarUsuarioPorId(incumplimientoContrVo.getUsuarioRegistraVo().getUsuCodigo());
                siiIncumplimientoContr.setSiiUsuarioRegistra(siiUsuarioRegistra);
            }

        }
        return siiIncumplimientoContr;
    }

    public SiiRepartoFiscalizador convertir(RepartoFiscalizadorVO repartoFiscalizadorVo) throws ExcepcionDAO {
        SiiRepartoFiscalizador siiRepartoFiscalizador = new SiiRepartoFiscalizador();

        if (repartoFiscalizadorVo != null) {
            if (repartoFiscalizadorVo.getRfsCodigo() != null && repartoFiscalizadorVo.getRfsCodigo() > 0) {
                siiRepartoFiscalizador = repartoFiscalizadorDao.buscarPorCodigo(repartoFiscalizadorVo.getRfsCodigo());
            }
        }
        siiRepartoFiscalizador.setRfsActivo(repartoFiscalizadorVo.getRfsActivo());
        siiRepartoFiscalizador.setRfsCodigo(repartoFiscalizadorVo.getRfsCodigo());
        siiRepartoFiscalizador.setRfsFecha(repartoFiscalizadorVo.getRfsFecha());
        //Padres:
        if (repartoFiscalizadorVo.getFiscalizadorSustancVo() != null &&
            repartoFiscalizadorVo.getFiscalizadorSustancVo().getFsuCodigo() != null) {
            siiRepartoFiscalizador.setSiiFiscalizadorSustanc(fiscalizadorSustancDao.buscarPorCodigo(repartoFiscalizadorVo.getFiscalizadorSustancVo().getFsuCodigo()));
        }
        if (repartoFiscalizadorVo.getIncumplimientoContrVo() != null &&
            repartoFiscalizadorVo.getIncumplimientoContrVo().getIcnCodigo() != null) {
            siiRepartoFiscalizador.setSiiIncumplimientoContr(incumplimientoContrDao.buscarPorCodigo(repartoFiscalizadorVo.getIncumplimientoContrVo().getIcnCodigo()));
        }
        if (repartoFiscalizadorVo.getProcesoSancionatorioVo()!= null &&
            repartoFiscalizadorVo.getProcesoSancionatorioVo().getPsaCodigo() != null ) {
            siiRepartoFiscalizador.setSiiProcesoSancionatorio(procesoSancionatorioDao.buscarPorCodigo(repartoFiscalizadorVo.getProcesoSancionatorioVo().getPsaCodigo()));
        }
        return siiRepartoFiscalizador;
    }

    public SiiSuspensionContr convertir(SuspensionContrVO suspensionContrVo) throws ExcepcionDAO {
        SiiSuspensionContr suspensionContr = new SiiSuspensionContr();
        if (suspensionContrVo != null) {
            if (suspensionContrVo.getScoCodigo() != null && suspensionContrVo.getScoCodigo() > 0) {
                suspensionContr = suspensionContrDao.buscarPorCodigo(suspensionContrVo.getScoCodigo());
            }
        }
        suspensionContr.setScoCodigo(suspensionContrVo.getScoCodigo());
        suspensionContr.setScoFechaActaSusp(suspensionContrVo.getScoFechaActaSusp());
        suspensionContr.setScoFechaFinDefCon(suspensionContrVo.getScoFechaFinDefCon());
        suspensionContr.setScoFechaFinSusAct(suspensionContrVo.getScoFechaFinSusAct());
        suspensionContr.setScoFechaFinSusp(suspensionContrVo.getScoFechaFinSusp());
        suspensionContr.setScoFechaIniSusAct(suspensionContrVo.getScoFechaIniSusAct());
        suspensionContr.setScoFechaIniSusp(suspensionContrVo.getScoFechaIniSusp());
        suspensionContr.setScoFechaRadDesist(suspensionContrVo.getScoFechaRadDesist());
        suspensionContr.setScoFechaRadRecha(suspensionContrVo.getScoFechaRadRecha());
        suspensionContr.setScoFechaRadica(suspensionContrVo.getScoFechaRadica());
        suspensionContr.setScoFechaReanuda(suspensionContrVo.getScoFechaReanuda());
        suspensionContr.setScoModificaFecFin(suspensionContrVo.getScoModificaFecFin());
        suspensionContr.setScoMotivoDesist(suspensionContrVo.getScoMotivoDesist());
        suspensionContr.setScoMotivoRachazo(suspensionContrVo.getScoMotivoRechazo());
        suspensionContr.setScoRadicado(suspensionContrVo.getScoRadicado());
        suspensionContr.setScoRadicadoDesist(suspensionContrVo.getScoRadicadoDesist());
        suspensionContr.setScoRadicadoRecha(suspensionContrVo.getScoRadicadoRecha());
        suspensionContr.setScoTipo(suspensionContrVo.getScoTipo());
        //Padres:
        if (suspensionContrVo.getContratoVo() != null && suspensionContrVo.getContratoVo().getConCodigo() != null) {
            suspensionContr.setSiiContrato(contratoDao.buscarContratoPorId(suspensionContrVo.getContratoVo().getConCodigo()));
        }
        if (suspensionContrVo.getEstadoSuspensionContVo() != null &&
            suspensionContrVo.getEstadoSuspensionContVo().getEscCodigo() != null) {
            suspensionContr.setSiiEstadoSuspensionCont(estadoSuspensionContDao.buscarPorCodigo(suspensionContrVo.getEstadoSuspensionContVo().getEscCodigo()));
        }

        return suspensionContr;
    }


    public SiiTerminacionAnticip convertir(TerminacionAnticipContVO terminacionAnticipConVo) throws ExcepcionDAO {
        SiiTerminacionAnticip siiTerminacionAnticip = new SiiTerminacionAnticip();
        if (terminacionAnticipConVo.getTanCodigo() != null && terminacionAnticipConVo.getTanCodigo() > 0) {
            siiTerminacionAnticip =
                terminacionAnticipContDao.buscarTerminacionAnticipadaPorId(terminacionAnticipConVo.getTanCodigo());
        }
        if (terminacionAnticipConVo.getTanFechaActaTerAnt() != null) {
            siiTerminacionAnticip.setTanFechaActaTerAnt(terminacionAnticipConVo.getTanFechaActaTerAnt());
        }
        if (terminacionAnticipConVo.getTanFechaAproTerAnt() != null) {
            siiTerminacionAnticip.setTanFechaAproTerAnt(terminacionAnticipConVo.getTanFechaAproTerAnt());
        }
        if (terminacionAnticipConVo.getTanFechaRadDesist() != null) {
            siiTerminacionAnticip.setTanFechaRadDesist(terminacionAnticipConVo.getTanFechaRadDesist());
        }
        if (terminacionAnticipConVo.getTanFechaRadicRech() != null) {
            siiTerminacionAnticip.setTanFechaRadicRech(terminacionAnticipConVo.getTanFechaRadicRech());
        }
        if (terminacionAnticipConVo.getTanFechaRadica() != null) {
            siiTerminacionAnticip.setTanFechaRadica(terminacionAnticipConVo.getTanFechaRadica());
        }
        if (terminacionAnticipConVo.getTanFechaTermAntic() != null) {
            siiTerminacionAnticip.setTanFechaTermAntic(terminacionAnticipConVo.getTanFechaTermAntic());
        }
        if (terminacionAnticipConVo.getTanFechaTermSolic() != null) {
            siiTerminacionAnticip.setTanFechaTermSolic(terminacionAnticipConVo.getTanFechaTermSolic());
        }
        if (terminacionAnticipConVo.getTanMotivoDesistim() != null) {
            siiTerminacionAnticip.setTanMotivoDesistim(terminacionAnticipConVo.getTanMotivoDesistim());
        }
        if (terminacionAnticipConVo.getTanMotivoRechazo() != null) {
            siiTerminacionAnticip.setTanMotivoRechazo(terminacionAnticipConVo.getTanMotivoRechazo());
        }
        if (terminacionAnticipConVo.getTanMotivoSolic() != null) {
            siiTerminacionAnticip.setTanMotivoSolic(terminacionAnticipConVo.getTanMotivoSolic());
        }
        if (terminacionAnticipConVo.getTanRadicado() != null) {
            siiTerminacionAnticip.setTanRadicado(terminacionAnticipConVo.getTanRadicado());
        }
        if (terminacionAnticipConVo.getTanRadicadoDesistim() != null) {
            siiTerminacionAnticip.setTanRadicadoDesistim(terminacionAnticipConVo.getTanRadicadoDesistim());
        }
        if (terminacionAnticipConVo.getTanRadicadoRechazo() != null) {
            siiTerminacionAnticip.setTanRadicadoRechazo(terminacionAnticipConVo.getTanRadicadoRechazo());
        }
        if (terminacionAnticipConVo.getContratoVo() != null) {
            SiiContrato siiContrato =
                contratoDao.buscarContratoPorId(terminacionAnticipConVo.getContratoVo().getConCodigo());
            siiTerminacionAnticip.setSiiContrato(siiContrato);
        }
        if (terminacionAnticipConVo.getEstadoTermAnticipVo() != null) {
            SiiEstadoTermAnticip siiEstadoTermAnticip =
                estadoTermAnticipDao.buscarEstadoTermAnticipPorId(terminacionAnticipConVo.getEstadoTermAnticipVo().getEtaCodigo());
            siiTerminacionAnticip.setSiiEstadoTermAnticip(siiEstadoTermAnticip);
        }
        return siiTerminacionAnticip;
    }


    public SiiGrupoFiscalizacion convertir(GrupoFiscalizacionVO grupoFiscalizacionVo) throws ExcepcionDAO {
        SiiGrupoFiscalizacion siiGrupoFiscalizacion = new SiiGrupoFiscalizacion();
        if (grupoFiscalizacionVo != null) {
            if (grupoFiscalizacionVo.getGfiCodigo() != null && grupoFiscalizacionVo.getGfiCodigo() > 0)
                siiGrupoFiscalizacion =
                    grupoFiscalizadorDao.buscarPorCodigoSiiGrupoFiscalizacion(grupoFiscalizacionVo.getGfiCodigo());

            siiGrupoFiscalizacion.setGfiFechaFin(grupoFiscalizacionVo.getGfiFechaFin());
            siiGrupoFiscalizacion.setGfiFechaIni(grupoFiscalizacionVo.getGfiFechaIni());
            siiGrupoFiscalizacion.setGfiNumero(grupoFiscalizacionVo.getGfiNumero());

            if (grupoFiscalizacionVo.getFiscalizadorSustancVoAcompañante() != null &&
                grupoFiscalizacionVo.getFiscalizadorSustancVoAcompañante().getFsuCodigo() > 0)
                siiGrupoFiscalizacion.setSiiFiscalizadorSustancAcomp(fiscalizadorSustancDao.buscarPorCodigoSiiFiscalizadorSustanc(grupoFiscalizacionVo.getFiscalizadorSustancVoAcompañante().getFsuCodigo()));

            if (grupoFiscalizacionVo.getFiscalizadorSustancVoPrincipal() != null &&
                grupoFiscalizacionVo.getFiscalizadorSustancVoPrincipal().getFsuCodigo() > 0)
                siiGrupoFiscalizacion.setSiiFiscalizadorSustancPrincipal(fiscalizadorSustancDao.buscarPorCodigoSiiFiscalizadorSustanc(grupoFiscalizacionVo.getFiscalizadorSustancVoPrincipal().getFsuCodigo()));


        }
        return siiGrupoFiscalizacion;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tramiteResolSanConVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTramiteResolSanCon convertir(TramiteResolSanConVO tramiteResolSanConVo) throws ExcepcionDAO {
        SiiTramiteResolSanCon siiTramiteResolSanCon = new SiiTramiteResolSanCon();

        if (tramiteResolSanConVo != null) {
            if (tramiteResolSanConVo.getTrsCodigo() != null && tramiteResolSanConVo.getTrsCodigo() > 0) {
                siiTramiteResolSanCon = tramiteResolSanConDao.buscarPorCodigo(tramiteResolSanConVo.getTrsCodigo());
            }

            siiTramiteResolSanCon.setTrsCodigo(tramiteResolSanConVo.getTrsCodigo());
            siiTramiteResolSanCon.setTrsFecha(tramiteResolSanConVo.getTrsFecha());


            if (tramiteResolSanConVo.getEstadoResolucSanConVo() != null &&
                tramiteResolSanConVo.getEstadoResolucSanConVo().getErsCodigo() != null) {
                SiiEstadoResolucSanCon siiEstadoResolucSanCon =
                    estadoResolucSanConDao.buscarPorCodigo(tramiteResolSanConVo.getEstadoResolucSanConVo().getErsCodigo());
                siiTramiteResolSanCon.setSiiEstadoResolucSanCon(siiEstadoResolucSanCon);
            }

            if (tramiteResolSanConVo.getResolucionIncumContrVo() != null &&
                tramiteResolSanConVo.getResolucionIncumContrVo().getRcoCodigo() != null) {
                SiiResolucionIncumContr siiResolucionIncumContr =
                    resolucionIncumContrDao.buscarPorCodigo(tramiteResolSanConVo.getResolucionIncumContrVo().getRcoCodigo());
                siiTramiteResolSanCon.setSiiResolucionIncumContr(siiResolucionIncumContr);
            }
        }

        return (siiTramiteResolSanCon);
    }
    

    public SiiEstablecSuspension convertir(EstablecSuspensionVO establecimientoSuspensionVo) throws ExcepcionDAO {
        SiiEstablecSuspension establecimientoSuspension = new SiiEstablecSuspension();
        if (establecimientoSuspensionVo != null) {
            if (establecimientoSuspensionVo.getEsuCodigo() != null && establecimientoSuspensionVo.getEsuCodigo() > 0) {
                establecimientoSuspension =
                    establecimientoSuspensionDao.buscarPorCodigo(establecimientoSuspensionVo.getEsuCodigo());
            }
            establecimientoSuspension.setEsuCodigo(establecimientoSuspensionVo.getEsuCodigo());

            if (establecimientoSuspensionVo.getEstablecimientoVo() != null &&
                establecimientoSuspensionVo.getEstablecimientoVo().getEstCodigo() != null) {
                establecimientoSuspension.setSiiEstablecimiento(establecimientoDao.buscarEstablecimientoPorId(establecimientoSuspensionVo.getEstablecimientoVo().getEstCodigo()));
            }
            if (establecimientoSuspensionVo.getSuspensionContrVo() != null &&
                establecimientoSuspensionVo.getSuspensionContrVo() != null) {
                establecimientoSuspension.setSiiSuspensionContr(suspensionContrDao.buscarPorCodigo(establecimientoSuspensionVo.getSuspensionContrVo().getScoCodigo()));
            }


        }
        return establecimientoSuspension;
    }

    public SiiResumenNoConectado convertir(ResumenNoConectadoVO resumenNoConectadoVo) throws ExcepcionDAO {
        SiiResumenNoConectado siiResumenNoConectado = new SiiResumenNoConectado();
        if (resumenNoConectadoVo != null) {
            if (resumenNoConectadoVo.getRncCodigo() != null && resumenNoConectadoVo.getRncCodigo() > 0) {
                siiResumenNoConectado =
                    resumenNoConectadoDao.buscarPorCodigoResumen(resumenNoConectadoVo.getRncCodigo());
            }
            siiResumenNoConectado.setRncCodigo(resumenNoConectadoVo.getRncCodigo());
            siiResumenNoConectado.setRncNumElemen(resumenNoConectadoVo.getRncNumElemen());
            siiResumenNoConectado.setRncValorDe(resumenNoConectadoVo.getRncValorDe());
            siiResumenNoConectado.setRncValorTarifa(resumenNoConectadoVo.getRncValorTarifa());

            if (resumenNoConectadoVo.getCuotaOperadorVo() != null) {
                siiResumenNoConectado.setSiiCuotaOperador(cuotaOperadorDao.buscarCuotaOperadorPorId(resumenNoConectadoVo.getCuotaOperadorVo().getCopCodigo()));
            }

            if (resumenNoConectadoVo.getTipoApuestaVO() != null) {
                siiResumenNoConectado.setSiiTipoApuesta(tipoApuestaDao.buscarTipoApuestaPorCodigo(resumenNoConectadoVo.getTipoApuestaVO().getTapCodigo()));
            }

        }
        return siiResumenNoConectado;
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param resolucionIncumContrVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiResolucionIncumContr convertir(ResolucionIncumContrVO resolucionIncumContrVo) throws ExcepcionDAO {
        SiiResolucionIncumContr siiResolucionIncumContr = new SiiResolucionIncumContr();

        if (resolucionIncumContrVo != null) {
            if (resolucionIncumContrVo.getRcoCodigo() != null && resolucionIncumContrVo.getRcoCodigo() > 0) {
                siiResolucionIncumContr =
                    resolucionIncumContrDao.buscarPorCodigo(resolucionIncumContrVo.getRcoCodigo());
            }

            siiResolucionIncumContr.setRcoCodigo(resolucionIncumContrVo.getRcoCodigo());
            siiResolucionIncumContr.setRcoFechaFinInhab(resolucionIncumContrVo.getRcoFechaFinInhab());
            siiResolucionIncumContr.setRcoFechaIniInhab(resolucionIncumContrVo.getRcoFechaIniInhab());
            siiResolucionIncumContr.setRcoFechaNotific(resolucionIncumContrVo.getRcoFechaNotific());
            siiResolucionIncumContr.setRcoFechaResol(resolucionIncumContrVo.getRcoFechaResol());
            siiResolucionIncumContr.setRcoFechaSupInc(resolucionIncumContrVo.getRcoFechaSupInc());
            siiResolucionIncumContr.setRcoFechaResolFirme(resolucionIncumContrVo.getRcoFechaResolFirme());
            siiResolucionIncumContr.setRcoNumeroResol(resolucionIncumContrVo.getRcoNumeroResol());
            siiResolucionIncumContr.setRcoOrigenRecurso(resolucionIncumContrVo.getRcoOrigenRecurso());
            siiResolucionIncumContr.setRcoReponeRecurso(resolucionIncumContrVo.getRcoReponeRecurso());
            siiResolucionIncumContr.setRcoTipoDecision(resolucionIncumContrVo.getRcoTipoDecision());
            siiResolucionIncumContr.setRcoTipoResol(resolucionIncumContrVo.getRcoTipoResol());
            siiResolucionIncumContr.setRcoSinSancion(resolucionIncumContrVo.getRcoSinSancion());


            if (resolucionIncumContrVo.getArchivoFisicoVo() != null &&
                resolucionIncumContrVo.getArchivoFisicoVo().getAfiCodigo() != null) {
                SiiArchivoFisico siiArchivoFisico =
                    archivoFisicoDao.buscarArchivoFisicoPorId(resolucionIncumContrVo.getArchivoFisicoVo().getAfiCodigo());
                siiResolucionIncumContr.setSiiArchivoFisico(siiArchivoFisico);
            }
        }

        return (siiResolucionIncumContr);
    }

    public SiiAsignacionRecaudo convertir(AsignacionRecaudoVO asignacionRecaudoVo) throws ExcepcionDAO {

        SiiAsignacionRecaudo siiAsignacionRecaudo = new SiiAsignacionRecaudo();
        if (asignacionRecaudoVo != null)
            if (asignacionRecaudoVo.getAreCodigo() != null && asignacionRecaudoVo.getAreCodigo() > 0) {
                siiAsignacionRecaudo =
                    asignacionRecaudoDao.buscarAsignacionRecaudoPorId(asignacionRecaudoVo.getAreCodigo());
            }
        siiAsignacionRecaudo.setAreEstado(asignacionRecaudoVo.getAreEstado());
        if (asignacionRecaudoVo.getDetalleDeclaracionVo() != null &&
            asignacionRecaudoVo.getDetalleDeclaracionVo().getDdeCodigo() != null) {
            siiAsignacionRecaudo.setSiiDetalleDeclaracion(detalleDeclaracionDao.buscarPorCodigoDetalleDeclaracion(asignacionRecaudoVo.getDetalleDeclaracionVo().getDdeCodigo()));
        }
        return siiAsignacionRecaudo;
    }


    public SiiLiquidacionEstabl convertir(LiquidacionEstablVO liquidacionEstablVo) throws ExcepcionDAO {

        SiiLiquidacionEstabl siiLiquidacionEstabl = new SiiLiquidacionEstabl();
        if (liquidacionEstablVo != null)
            if (liquidacionEstablVo.getLesCodigo() != null && liquidacionEstablVo.getLesCodigo() > 0) {
                siiLiquidacionEstabl =
                    liquidacionEstablecimientoDao.buscarLiquidacionEstablXId(liquidacionEstablVo.getLesCodigo());
            }
        siiLiquidacionEstabl.setLesNumEstablec(liquidacionEstablVo.getNumEstablecimiento());
        siiLiquidacionEstabl.setLesPonderado(liquidacionEstablVo.getLesPonderado());
        siiLiquidacionEstabl.setLesValor(liquidacionEstablVo.getLesValor());

        if (liquidacionEstablVo.getUbicacionVo() != null &&
            liquidacionEstablVo.getUbicacionVo().getUbiCodigo() != null) {
            siiLiquidacionEstabl.setSiiUbicacionMunEstab(ubicacionDao.buscarUbicacionPorId(liquidacionEstablVo.getUbicacionVo().getUbiCodigo()));
        }
        if (liquidacionEstablVo.getLiquidacionMesVo() != null &&
            liquidacionEstablVo.getLiquidacionMesVo().getLmeCodigo() != null) {
            siiLiquidacionEstabl.setSiiLiquidacionMes(liquidacionMesDao.buscarLiquidacionMesPorId(liquidacionEstablVo.getLiquidacionMesVo().getLmeCodigo()));
        }

        if (liquidacionEstablVo.getEstablecimientoVo() != null &&
            liquidacionEstablVo.getEstablecimientoVo().getEstCodigo() != null) {
            siiLiquidacionEstabl.setSiiEstablecimiento(establecimientoDao.buscarEstablecimientoPorId(liquidacionEstablVo.getEstablecimientoVo().getEstCodigo()));
        }

        return siiLiquidacionEstabl;
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiDenuncia convertir(DenunciaVO denunciaVo) throws ExcepcionDAO {
        SiiDenuncia siiDenuncia = new SiiDenuncia();

        if (denunciaVo != null) {
            if (denunciaVo.getDenCodigo() != null && denunciaVo.getDenCodigo() > 0) {
                siiDenuncia = denunciaDao.buscarPorCodigo(denunciaVo.getDenCodigo());
            }

            siiDenuncia.setDenBarrio(denunciaVo.getDenBarrio());
            siiDenuncia.setDenCodigo(denunciaVo.getDenCodigo());
            siiDenuncia.setDenDenunEdad(denunciaVo.getDenDenunEdad());
            siiDenuncia.setDenDenunEmail(denunciaVo.getDenDenunEmail());
            siiDenuncia.setDenDenunGenero(denunciaVo.getDenDenunGenero());
            siiDenuncia.setDenDenunNumIden(denunciaVo.getDenDenunNumIden());
            siiDenuncia.setDenDenunPrimApe(denunciaVo.getDenDenunPrimApe());
            siiDenuncia.setDenDenunPrimNom(denunciaVo.getDenDenunPrimNom());
            siiDenuncia.setDenDenunRazonSoc(denunciaVo.getDenDenunRazonSoc());
            siiDenuncia.setDenDenunSegApe(denunciaVo.getDenDenunSegApe());
            siiDenuncia.setDenDenunSegNom(denunciaVo.getDenDenunSegNom());
            siiDenuncia.setDenDenunTelef(denunciaVo.getDenDenunTelef());
            siiDenuncia.setDenDetalle(denunciaVo.getDenDetalle());
            siiDenuncia.setDenDenunNumIden(denunciaVo.getDenDenunNumIden());
            siiDenuncia.setDenDenunPrimApe(denunciaVo.getDenDenunPrimApe());
            siiDenuncia.setDenDenunPrimNom(denunciaVo.getDenDenunPrimNom());
            siiDenuncia.setDenDenunSegApe(denunciaVo.getDenDenunSegApe());
            siiDenuncia.setDenDenunSegNom(denunciaVo.getDenDenunSegNom());
            siiDenuncia.setDenDenunTelef(denunciaVo.getDenDenunTelef());
            siiDenuncia.setDenFechaDescarte(denunciaVo.getDenFechaDescarte());
            siiDenuncia.setDenFechaRadicado(denunciaVo.getDenFechaRadicado());
            siiDenuncia.setDenFuente(denunciaVo.getDenFuente());
            siiDenuncia.setDenLocal(denunciaVo.getDenLocal());
            siiDenuncia.setDenLocalidad(denunciaVo.getDenLocalidad());
            siiDenuncia.setDenMotivoDescarte(denunciaVo.getDenMotivoDescarte());
            siiDenuncia.setDenNumero(denunciaVo.getDenNumero());
            siiDenuncia.setDenNumeroSoporte(denunciaVo.getDenNumeroSoporte());
            siiDenuncia.setDenPaginaWeb(denunciaVo.getDenPaginaWeb());
            siiDenuncia.setDenRadicado(denunciaVo.getDenRadicado());
            siiDenuncia.setDenBarrio(denunciaVo.getDenBarrio());
            siiDenuncia.setDenRtaCanal(denunciaVo.getDenRtaCanal());
            siiDenuncia.setDenRtaDescripcion(denunciaVo.getDenRtaDescripcion());
            siiDenuncia.setDenRtaEstado(denunciaVo.getDenRtaEstado());
            siiDenuncia.setDenRtaFechaRadic(denunciaVo.getDenRtaFechaRadic());
            siiDenuncia.setDenRtaFechaRadAl(denunciaVo.getDenRtaFechaRadAl());
            siiDenuncia.setDenRtaFechaRadFis(denunciaVo.getDenRtaFechaRadFis());
            siiDenuncia.setDenRtaRadicado(denunciaVo.getDenRtaRadicado());
            siiDenuncia.setDenRtaRadicAlcal(denunciaVo.getDenRtaRadicAlcal());
            siiDenuncia.setDenRtaRadicFisc(denunciaVo.getDenRtaRadicFisc());
            siiDenuncia.setDenTipoDenunciante(denunciaVo.getDenTipoDenunciante());
            siiDenuncia.setDenTipJuegoLoc(denunciaVo.getDenTipJuegoLoc());
            siiDenuncia.setDenTipJuegoNov(denunciaVo.getDenTipJuegoNov());
            siiDenuncia.setDenTipJuegoOtros(denunciaVo.getDenTipJuegoOtros());
            siiDenuncia.setDenTipJuegoSinIden(denunciaVo.getDenTipJuegoSinIden());
            siiDenuncia.setDenTipoSoporte(denunciaVo.getDenTipoSoporte());
            siiDenuncia.setDenVerfesFecha(denunciaVo.getDenVerfesFecha());
            siiDenuncia.setDenVerfesObserv(denunciaVo.getDenVerfesObserv());
            siiDenuncia.setDenVerfesVerCon(denunciaVo.getDenVerfesVerCon());
            siiDenuncia.setDenVerfesVerTra(denunciaVo.getDenVerfesVerTra());
            siiDenuncia.setUsuCodigo(denunciaVo.getUsuCodigo());
            siiDenuncia.setDenDnadoNumIden(denunciaVo.getDenDnadoNumIden());
            siiDenuncia.setDenDnadoPrimApe(denunciaVo.getDenDnadoPrimApe());
            siiDenuncia.setDenDnadoPrimNom(denunciaVo.getDenDnadoPrimNom());
            siiDenuncia.setDenDnadoSegApe(denunciaVo.getDenDnadoSegApe());
            siiDenuncia.setDenDnadoSegNom(denunciaVo.getDenDnadoSegNom());
            siiDenuncia.setDenDnadoTelef(denunciaVo.getDenDnadoTelef());

            //Padres:
            if (denunciaVo.getUbicacionDenuncianteVO() != null &&
                denunciaVo.getUbicacionDenuncianteVO().getUbiCodigo() != null) {
                siiDenuncia.setSiiUbicacionDenunciante(ubicaDao.buscarUbicacionPorId(denunciaVo.getUbicacionDenuncianteVO().getUbiCodigo()));
            }
            if (denunciaVo.getUbicacionLocalVO() != null && denunciaVo.getUbicacionLocalVO().getUbiCodigo() != null) {
                siiDenuncia.setSiiUbicacionLocal(ubicaDao.buscarUbicacionPorId(denunciaVo.getUbicacionLocalVO().getUbiCodigo()));
            }
            if (denunciaVo.getUbicacionMunicDenunciado() != null &&
                denunciaVo.getUbicacionMunicDenunciado().getUbiCodigo() != null) {
                siiDenuncia.setSiiUbicacionMunicDenunciado(ubicaDao.buscarUbicacionPorId(denunciaVo.getUbicacionMunicDenunciado().getUbiCodigo()));
            }
            if (denunciaVo.getAreaColjuegosVO() != null && denunciaVo.getAreaColjuegosVO().getAcoCodigo() != null) {
                siiDenuncia.setSiiAreaColjuegos(areaColjuegosDao.buscarAreaColjuegosPorId(denunciaVo.getAreaColjuegosVO().getAcoCodigo()));
            }
            if (denunciaVo.getTipoIdentificacionDenunciado() != null &&
                denunciaVo.getTipoIdentificacionDenunciado().getTidCodigo() != null) {
                siiDenuncia.setSiiTipoIdentificacionDenunciado(tipoIdDao.buscarTipoIdentificacionPorId(denunciaVo.getTipoIdentificacionDenunciado().getTidCodigo()));
            }
            if (denunciaVo.getTipoIdentificacionVO() != null &&
                denunciaVo.getTipoIdentificacionVO().getTidCodigo() != null) {
                siiDenuncia.setSiiTipoIdentificacion(tipoIdDao.buscarTipoIdentificacionPorId(denunciaVo.getTipoIdentificacionVO().getTidCodigo()));
            }
            if (denunciaVo.getEstadoDenunciaVO()!=null && denunciaVo.getEstadoDenunciaVO().getEdnCodigo()!=null) {
                siiDenuncia.setSiiEstadoDenuncia(estadoDenunciaDao.buscarPorCodigo(denunciaVo.getEstadoDenunciaVO().getEdnCodigo()));
            }
            if (denunciaVo.getResultadoVerifDenunVO()!=null && denunciaVo.getResultadoVerifDenunVO().getRevCodigo()!=null) {
                siiDenuncia.setSiiResultadoVerifDenun(resultadoVerifDenunDao.buscarPorCodigo(denunciaVo.getResultadoVerifDenunVO().getRevCodigo()));
            }
            if (denunciaVo.getMedioDenunciaVO() != null && denunciaVo.getMedioDenunciaVO().getMedCodigo() != null)
                siiDenuncia.setSiiMedioDenuncia(medioDenunciaDao.buscarPorCodigo(denunciaVo.getMedioDenunciaVO().getMedCodigo()));
            if (denunciaVo.getDenDireccionVo()  != null && denunciaVo.getDenDireccionVo().getDirCodigo() != null)
                siiDenuncia.setSiiDireccion(direccionDao.buscarPorCodigo(denunciaVo.getDenDireccionVo().getDirCodigo()));
            if (denunciaVo.getDenDenunDireccionVo()  != null && denunciaVo.getDenDenunDireccionVo().getDirCodigo() != null)
                siiDenuncia.setSiiDireccionDenun(direccionDao.buscarPorCodigo(denunciaVo.getDenDenunDireccionVo().getDirCodigo()));
            if (denunciaVo.getDenDnadoDireccionVo()  != null && denunciaVo.getDenDnadoDireccionVo().getDirCodigo() != null)
                siiDenuncia.setSiiDireccionDnado(direccionDao.buscarPorCodigo(denunciaVo.getDenDnadoDireccionVo().getDirCodigo()));
            
            if (denunciaVo.getAutoComisorioAccConVo() != null && denunciaVo.getAutoComisorioAccConVo().getAcaCodigo() != null) {
                siiDenuncia.addSiiAutoComisorioAccCon(autoComisorioAccConDao.buscaSiiAutoComisorioAccConPorId(denunciaVo.getAutoComisorioAccConVo().getAcaCodigo()));
            }
                                                      
        }

        return (siiDenuncia);
    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param elementoIlegDenunVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiElementoIlegDenun convertir(ElementoIlegDenunVO elementoIlegDenunVo) throws ExcepcionDAO {
        SiiElementoIlegDenun siiElementoIlegDenun = new SiiElementoIlegDenun();

        if (elementoIlegDenunVo.getEidCodigo() != null && elementoIlegDenunVo.getEidCodigo() > 0) {
            siiElementoIlegDenun = elementoIlegDenunDao.buscarPorCodigo(elementoIlegDenunVo.getEidCodigo());            
        }
        siiElementoIlegDenun.setEidActivo(elementoIlegDenunVo.getEidActivo());
        siiElementoIlegDenun.setEidNumero(elementoIlegDenunVo.getEidNumero());
        // Padres
        if (elementoIlegDenunVo.getDenunciaVo() != null && elementoIlegDenunVo.getDenunciaVo().getDenCodigo() != null){
            siiElementoIlegDenun.setSiiDenuncia(denunciaDao.buscarPorCodigo(elementoIlegDenunVo.getDenunciaVo().getDenCodigo()));            
        }
        if (elementoIlegDenunVo.getTipoElemenIlegalidadVo() != null && elementoIlegDenunVo.getTipoElemenIlegalidadVo().getTeiCodigo() != null) {
            siiElementoIlegDenun.setSiiTipoElemenIlegalidad(tipoElemenIlegalidadDao.buscarPorCodigo(elementoIlegDenunVo.getTipoElemenIlegalidadVo().getTeiCodigo()));
        }
        

        return siiElementoIlegDenun;

    }

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tipoElemenIlegalidadVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTipoElemenIlegalidad convertir(TipoElemenIlegalidadVO tipoElemenIlegalidadVo) {

        SiiTipoElemenIlegalidad siiTipoElemenIlegalidad = new SiiTipoElemenIlegalidad();

        siiTipoElemenIlegalidad.setTeiCodigo(tipoElemenIlegalidadVo.getTeiCodigo());
        siiTipoElemenIlegalidad.setTeiNombre(tipoElemenIlegalidadVo.getTeiNombre());

        return siiTipoElemenIlegalidad;


    }


    public SiiDireccionProcesalInc convertir(DireccionProcesalIncVO direccionProcesalIncVo) throws ExcepcionDAO {
        SiiDireccionProcesalInc siiDireccionProcesalInc = new SiiDireccionProcesalInc();

        if (direccionProcesalIncVo != null) {
            if (direccionProcesalIncVo.getDpiCodigo() != null && direccionProcesalIncVo.getDpiCodigo() > 0) {
                siiDireccionProcesalInc =
                    direccionProcesalIncDao.buscarPorCodigo(direccionProcesalIncVo.getDpiCodigo());
            }

            siiDireccionProcesalInc.setDpiCodigo(direccionProcesalIncVo.getDpiCodigo());
            siiDireccionProcesalInc.setDpiActivo(direccionProcesalIncVo.getDpiActivo());
            siiDireccionProcesalInc.setDpiDireccion(direccionProcesalIncVo.getDpiDireccion());
            siiDireccionProcesalInc.setDpiFechaActiv(direccionProcesalIncVo.getDpiFechaActiv());
            siiDireccionProcesalInc.setDpiFechaInac(direccionProcesalIncVo.getDpiFechaInac());


            if (direccionProcesalIncVo.getIncumplimientoContrVo() != null &&
                direccionProcesalIncVo.getIncumplimientoContrVo().getIcnCodigo() != null) {
                SiiIncumplimientoContr siiIncumplimientoContr =
                    incumplimientoContrDao.buscarPorCodigo(direccionProcesalIncVo.getIncumplimientoContrVo().getIcnCodigo());
                siiDireccionProcesalInc.setSiiIncumplimientoContr(siiIncumplimientoContr);
            }

            if (direccionProcesalIncVo.getOperadorVo() != null &&
                direccionProcesalIncVo.getOperadorVo().getOpeCodigo() != null) {
                SiiOperador siiOperador =
                    operadorDao.buscarPorCodigoOperador(direccionProcesalIncVo.getOperadorVo().getOpeCodigo());
                siiDireccionProcesalInc.setSiiOperador(siiOperador);
            }
        }

        return (siiDireccionProcesalInc);
    }

    // *****

    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param asigRecaudoAaEstablVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiAsigRecaudoAaEstabl convertir(AsigRecaudoAaEstablVO asigRecaudoAaEstablVo) throws ExcepcionDAO {
        SiiAsigRecaudoAaEstabl siiAsigRecaudoAaEstabl = new SiiAsigRecaudoAaEstabl();

        if (asigRecaudoAaEstablVo != null) {
            if (asigRecaudoAaEstablVo.getAsrCodigo() != null && asigRecaudoAaEstablVo.getAsrCodigo() > 0) {
                siiAsigRecaudoAaEstabl =
                    asigRecaudoAaEstablDao.buscarPorCodigoAsigRecaudoAaEstabl(asigRecaudoAaEstablVo.getAsrCodigo());
            }

            siiAsigRecaudoAaEstabl.setAsrCodigo(asigRecaudoAaEstablVo.getAsrCodigo());
            siiAsigRecaudoAaEstabl.setAsrNumEstablec(asigRecaudoAaEstablVo.getAsrNumEstablec());
            siiAsigRecaudoAaEstabl.setAsrValor(asigRecaudoAaEstablVo.getAsrValor());

            if (asigRecaudoAaEstablVo.getUbicacionVo() != null &&
                asigRecaudoAaEstablVo.getUbicacionVo().getUbiCodigo() != null) {
                SiiUbicacion siiUbicacion =
                    ubicacionDao.buscarUbicacionPorId(asigRecaudoAaEstablVo.getUbicacionVo().getUbiCodigo());
                siiAsigRecaudoAaEstabl.setSiiUbicacion(siiUbicacion);
            }

            if (asigRecaudoAaEstablVo.getAsignacionRecaudoAaVo() != null &&
                asigRecaudoAaEstablVo.getAsignacionRecaudoAaVo().getAraCodigo() != null) {
                SiiAsignacionRecaudoAa siiAsignacionRecaudoAa =
                    asignacionRecaudoAaDao.buscarPorCodigoAsignacionRecaudoAa(asigRecaudoAaEstablVo.getAsignacionRecaudoAaVo().getAraCodigo());
                siiAsigRecaudoAaEstabl.setSiiAsignacionRecaudoAa(siiAsignacionRecaudoAa);
            }


        }

        return (siiAsigRecaudoAaEstabl);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param procesoSancionatorioVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiProcesoSancionatorio convertir(ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO {
        SiiProcesoSancionatorio siiProcesoSancionatorio = new SiiProcesoSancionatorio();

        if (procesoSancionatorioVo != null) {
            if (procesoSancionatorioVo.getPsaCodigo() != null && procesoSancionatorioVo.getPsaCodigo() > 0) {
                siiProcesoSancionatorio =
                    procesoSancionatorioDao.buscarPorCodigo(procesoSancionatorioVo.getPsaCodigo());
            }

            siiProcesoSancionatorio.setPsaCodigo(procesoSancionatorioVo.getPsaCodigo());
            siiProcesoSancionatorio.setPsaAuprDecretaPr(procesoSancionatorioVo.getPsaAuprDecretaPr());
            siiProcesoSancionatorio.setPsaAuprNumDias(procesoSancionatorioVo.getPsaAuprNumDias());
            siiProcesoSancionatorio.setPsaBorTotales(procesoSancionatorioVo.getPsaBorTotales());
            siiProcesoSancionatorio.setPsaComFechaRad(procesoSancionatorioVo.getPsaComFechaRad());
            siiProcesoSancionatorio.setPsaComRadicado(procesoSancionatorioVo.getPsaComRadicado());
            siiProcesoSancionatorio.setPsaFechaAutoArch(procesoSancionatorioVo.getPsaFechaAutoArch());
            siiProcesoSancionatorio.setPsaFechaGenAuTrAl(procesoSancionatorioVo.getPsaFechaGenAuTrAl());
            siiProcesoSancionatorio.setPsaMotivoInexac(procesoSancionatorioVo.getPsaMotivoInexac());
            siiProcesoSancionatorio.setPsaMotivoOmision(procesoSancionatorioVo.getPsaMotivoOmision());
            siiProcesoSancionatorio.setPsaNumFechaRad(procesoSancionatorioVo.getPsaNumFechaRad());
            siiProcesoSancionatorio.setPsaNumRadicado(procesoSancionatorioVo.getPsaNumRadicado());
            siiProcesoSancionatorio.setPsaPruDescripcion(procesoSancionatorioVo.getPsaPruDescripcion());
            siiProcesoSancionatorio.setPsaPruFechaRad(procesoSancionatorioVo.getPsaPruFechaRad());
            siiProcesoSancionatorio.setPsaPruRadicado(procesoSancionatorioVo.getPsaPruRadicado());
            siiProcesoSancionatorio.setPsaResulFecha(procesoSancionatorioVo.getPsaResulFecha());
            siiProcesoSancionatorio.setPsaResulIndResp(procesoSancionatorioVo.getPsaResulIndResp());
            siiProcesoSancionatorio.setPsaResulNumGuia(procesoSancionatorioVo.getPsaResulNumGuia());
            siiProcesoSancionatorio.setPsaSnataFechaRad(procesoSancionatorioVo.getPsaSnataFechaRad());
            siiProcesoSancionatorio.setPsaSnataRadicado(procesoSancionatorioVo.getPsaSnataRadicado());
            siiProcesoSancionatorio.setPsaSnaupFechaRad(procesoSancionatorioVo.getPsaSnaupFechaRad());
            siiProcesoSancionatorio.setPsaSnaupRadicado(procesoSancionatorioVo.getPsaSnaupRadicado());
            siiProcesoSancionatorio.setPsaSnumaarFechaRad(procesoSancionatorioVo.getPsaSnumaarFechaRad());
            siiProcesoSancionatorio.setPsaSnumaarRadicado_(procesoSancionatorioVo.getPsaSnumaarRadicado());
            siiProcesoSancionatorio.setPsaConsecutivo(procesoSancionatorioVo.getPsaConsecutivo());
            siiProcesoSancionatorio.setPsaInterpApelacion(procesoSancionatorioVo.getPsaInterpApelacion());
            siiProcesoSancionatorio.setPsaInterpRecurso(procesoSancionatorioVo.getPsaInterpRecurso());
            
            
            if (procesoSancionatorioVo.getArchivoFisicoAuto() != null && procesoSancionatorioVo.getArchivoFisicoAuto().getAfiCodigo() != null) {
                SiiArchivoFisico siiArchivoFisicoAuto =
                    archivoFisicoDao.buscarArchivoFisicoPorId(procesoSancionatorioVo.getArchivoFisicoAuto().getAfiCodigo());
                siiProcesoSancionatorio.setSiiArchivoFisicoAuto(siiArchivoFisicoAuto);
            }

            if (procesoSancionatorioVo.getContratoVo() != null &&
                procesoSancionatorioVo.getContratoVo().getConCodigo() != null) {
                SiiContrato siiContrato =
                    contratoDao.buscarContratoPorId(procesoSancionatorioVo.getContratoVo().getConCodigo());
                siiProcesoSancionatorio.setSiiContrato(siiContrato);
            }

            if (procesoSancionatorioVo.getEstadoProcesoSancVo() != null &&
                procesoSancionatorioVo.getEstadoProcesoSancVo().getEpsCodigo() != null) {
                SiiEstadoProcesoSanc siiEstadoProcesoSanc =
                    estadoProcesoSancDao.buscarPorCodigo(procesoSancionatorioVo.getEstadoProcesoSancVo().getEpsCodigo());
                siiProcesoSancionatorio.setSiiEstadoProcesoSanc(siiEstadoProcesoSanc);
            }

            if (procesoSancionatorioVo.getResolucionProcSancApela() != null &&
                procesoSancionatorioVo.getResolucionProcSancApela().getRepCodigo() != null) {
                SiiResolucionProcSanc siiResolucionProcSancApela =
                    resolucionProcSancDao.buscarPorCodigo(procesoSancionatorioVo.getResolucionProcSancApela().getRepCodigo());
                siiProcesoSancionatorio.setSiiResolucionProcSancApela(siiResolucionProcSancApela);
            }

            if (procesoSancionatorioVo.getResolucionProcSancRepos() != null &&
                procesoSancionatorioVo.getResolucionProcSancRepos().getRepCodigo() != null) {
                SiiResolucionProcSanc siiResolucionProcSancRepos =
                    resolucionProcSancDao.buscarPorCodigo(procesoSancionatorioVo.getResolucionProcSancRepos().getRepCodigo());
                siiProcesoSancionatorio.setSiiResolucionProcSancRepos(siiResolucionProcSancRepos);
            }

            if (procesoSancionatorioVo.getResolucionProcSancSanc() != null &&
                procesoSancionatorioVo.getResolucionProcSancSanc().getRepCodigo() != null) {
                SiiResolucionProcSanc siiResolucionProcSancSanc =
                    resolucionProcSancDao.buscarPorCodigo(procesoSancionatorioVo.getResolucionProcSancSanc().getRepCodigo());
                siiProcesoSancionatorio.setSiiResolucionProcSancSanc(siiResolucionProcSancSanc);
            }

            if (procesoSancionatorioVo.getResolucionProcSancSin() != null &&
                procesoSancionatorioVo.getResolucionProcSancSin().getRepCodigo() != null) {
                SiiResolucionProcSanc siiResolucionProcSancSin =
                    resolucionProcSancDao.buscarPorCodigo(procesoSancionatorioVo.getResolucionProcSancSin().getRepCodigo());
                siiProcesoSancionatorio.setSiiResolucionProcSancSin(siiResolucionProcSancSin);
            }
            
            if (procesoSancionatorioVo.getInformeSupervisionVo() != null &&
                procesoSancionatorioVo.getInformeSupervisionVo().getIsuCodigo() != null) {
                siiProcesoSancionatorio.setSiiInformeSupervision(informeSupervisionDao.buscarPorCodigo(procesoSancionatorioVo.getInformeSupervisionVo().getIsuCodigo()));
            }
            
            if (procesoSancionatorioVo.getUsuarioRegistraVo()!=null && procesoSancionatorioVo.getUsuarioRegistraVo().getUsuCodigo()!=null) {
                SiiUsuario siiUsuarioRegistra = usuarioDao.buscarUsuarioPorId(procesoSancionatorioVo.getUsuarioRegistraVo().getUsuCodigo());
                siiProcesoSancionatorio.setSiiUsuarioRegistra(siiUsuarioRegistra);
            }
        }

        return (siiProcesoSancionatorio);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param resolucionProcSancVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiResolucionProcSanc convertir(ResolucionProcSancVO resolucionProcSancVo) throws ExcepcionDAO {
        SiiResolucionProcSanc siiResolucionProcSanc = new SiiResolucionProcSanc();

        if (resolucionProcSancVo != null) {
            if (resolucionProcSancVo.getRepCodigo() != null && resolucionProcSancVo.getRepCodigo() > 0) {
                siiResolucionProcSanc = resolucionProcSancDao.buscarPorCodigo(resolucionProcSancVo.getRepCodigo());
            }

            siiResolucionProcSanc.setRepCodigo(resolucionProcSancVo.getRepCodigo());
            siiResolucionProcSanc.setRemFecha(resolucionProcSancVo.getRemFecha());
            siiResolucionProcSanc.setRemNumero(resolucionProcSancVo.getRemNumero());
            siiResolucionProcSanc.setRemSnumFechaRad(resolucionProcSancVo.getRemSnumFechaRad());
            siiResolucionProcSanc.setRemSnumRadicado(resolucionProcSancVo.getRemSnumRadicado());
            siiResolucionProcSanc.setRemTipo(resolucionProcSancVo.getRemTipo());
            siiResolucionProcSanc.setRemValClausulaPen(resolucionProcSancVo.getRemValClausulaPen());
            siiResolucionProcSanc.setRemValorSancion(resolucionProcSancVo.getRemValorSancion());
            siiResolucionProcSanc.setRepConceptoSancion(resolucionProcSancVo.getRepConceptoSancion());
            siiResolucionProcSanc.setRepFecha(resolucionProcSancVo.getRepFecha());

            if (resolucionProcSancVo.getArchivoFisicoVo() != null &&
                resolucionProcSancVo.getArchivoFisicoVo().getAfiCodigo() != null) {
                SiiArchivoFisico siiArchivoFisico =
                    archivoFisicoDao.buscarArchivoFisicoPorId(resolucionProcSancVo.getArchivoFisicoVo().getAfiCodigo());
                siiResolucionProcSanc.setSiiArchivoFisico(siiArchivoFisico);
            }
        }

        return (siiResolucionProcSanc);
    }


    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tramiteResolProcSanVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTramiteResolProcSan convertir(TramiteResolProcSanVO tramiteResolProcSanVo) throws ExcepcionDAO {
        SiiTramiteResolProcSan siiTramiteResolProcSan = new SiiTramiteResolProcSan();

        if (tramiteResolProcSanVo != null) {
            if (tramiteResolProcSanVo.getTrpCodigo() != null && tramiteResolProcSanVo.getTrpCodigo() > 0) {
                siiTramiteResolProcSan = tramiteResolProcSanDao.buscarPorCodigo(tramiteResolProcSanVo.getTrpCodigo());
            }

            siiTramiteResolProcSan.setTrpCodigo(tramiteResolProcSanVo.getTrpCodigo());
            siiTramiteResolProcSan.setTrpFecha(tramiteResolProcSanVo.getTrpFecha());
            siiTramiteResolProcSan.setTrpNumeracFecRad(tramiteResolProcSanVo.getTrpNumeracFecRad());
            siiTramiteResolProcSan.setTrpNumeracRadicado(tramiteResolProcSanVo.getTrpNumeracRadicado());


            if (tramiteResolProcSanVo.getEstadoTramResPrSanVo() != null &&
                tramiteResolProcSanVo.getEstadoTramResPrSanVo().getEtrCodigo() != null) {
                SiiEstadoTramResPrSan siiEstadoTramResPrSan =
                    estadoTramResPrSanDao.buscarPorCodigo(tramiteResolProcSanVo.getEstadoTramResPrSanVo().getEtrCodigo());
                siiTramiteResolProcSan.setSiiEstadoTramResPrSan(siiEstadoTramResPrSan);
            }

            if (tramiteResolProcSanVo.getResolucionProcSancVo() != null &&
                tramiteResolProcSanVo.getResolucionProcSancVo().getRepCodigo() != null) {
                SiiResolucionProcSanc siiResolucionProcSanc =
                    resolucionProcSancDao.buscarPorCodigo(tramiteResolProcSanVo.getResolucionProcSancVo().getRepCodigo());
                siiTramiteResolProcSan.setSiiResolucionProcSanc(siiResolucionProcSanc);
            }
            
        }

        return (siiTramiteResolProcSan);
    }
    
    public SiiBarrioOrdenInfVer convertir(BarrioOrdenInfVerVO barrioOrdenInfVerVo) throws ExcepcionDAO {
        SiiBarrioOrdenInfVer siiBarrioOrdenInfVer = new SiiBarrioOrdenInfVer();
      
       if(barrioOrdenInfVerVo.getBivCodigo() != null && barrioOrdenInfVerVo.getBivCodigo() > 0 ){
                siiBarrioOrdenInfVer = barrioOrdenInfVerDao.buscarBarrioOrdenInfVerPorId(barrioOrdenInfVerVo.getBivCodigo()); 
       }
       siiBarrioOrdenInfVer.setBivDireccion(barrioOrdenInfVerVo.getBivDireccion());
       siiBarrioOrdenInfVer.setBivTipoJuego(barrioOrdenInfVerVo.getBivTipoJuego());
       siiBarrioOrdenInfVer.setBivActivo(barrioOrdenInfVerVo.getBivActivo());
        
       if (barrioOrdenInfVerVo.getBarrioOrdenVo() != null  &&  barrioOrdenInfVerVo.getBarrioOrdenVo().getBorCodigo()>0){
          SiiBarrioOrden siiBarrioOrden =  barrioOrdenDao.buscarPorCodigo(barrioOrdenInfVerVo.getBarrioOrdenVo().getBorCodigo());
          siiBarrioOrdenInfVer.setSiiBarrioOrden(siiBarrioOrden);  
       }
       if (barrioOrdenInfVerVo.getInformeVerificCampo() != null  &&  barrioOrdenInfVerVo.getInformeVerificCampo().getIvcCodigo()>0){
          SiiInformeVerificCampo siiInformeVerificCampo = informeVerificCampoDao.buscarInformeVerificCampoPorId(barrioOrdenInfVerVo.getInformeVerificCampo().getIvcCodigo());
           siiBarrioOrdenInfVer.setSiiInformeVerificCampo(siiInformeVerificCampo); 
       }
       
        return siiBarrioOrdenInfVer;
    }
    
    public SiiElementoIlegInfVer convertir(ElementoIlegInfVerVO elementoIlegInfVerVo) throws ExcepcionDAO{
        SiiElementoIlegInfVer siiElementoIlegInfVer  = new SiiElementoIlegInfVer();
        if(elementoIlegInfVerVo.getEivCodigo() != null && elementoIlegInfVerVo.getEivCodigo() > 0){
            siiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementoIlegInfVerPorId(elementoIlegInfVerVo.getEivCodigo()); 
        }
        siiElementoIlegInfVer.setEivNumElementos(elementoIlegInfVerVo.getEivNumElementos());
        
        if(elementoIlegInfVerVo.getBarrioOrdenInfVerVo() != null && elementoIlegInfVerVo.getBarrioOrdenInfVerVo().getBivCodigo() != null   ){
          SiiBarrioOrdenInfVer barrioOrdenInfVerVo =  barrioOrdenInfVerDao.buscarBarrioOrdenInfVerPorId(elementoIlegInfVerVo.getBarrioOrdenInfVerVo().getBivCodigo());
          siiElementoIlegInfVer.setSiiBarrioOrdenInfVer(barrioOrdenInfVerVo);
        }
        
        if(elementoIlegInfVerVo.getDenuncOrdTraInfVerVo() != null && elementoIlegInfVerVo.getDenuncOrdTraInfVerVo().getDivCodigo() != null  ){
            SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer = denuncOrdTraInfVerDao.buscarDenuncOrdTraInfVerPorId(elementoIlegInfVerVo.getDenuncOrdTraInfVerVo().getDivCodigo() );
            siiElementoIlegInfVer.setSiiDenuncOrdTraInfVer(siiDenuncOrdTraInfVer);
        }
        
        if(elementoIlegInfVerVo.getMunicOrdTraInfVerif() != null &&  elementoIlegInfVerVo.getMunicOrdTraInfVerif().getMivCodigo() != null  ){
            SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif =   municOrdTraInfVerifDao.buscarMunicOrdTraInfVerifPorId(elementoIlegInfVerVo.getMunicOrdTraInfVerif().getMivCodigo());
            siiElementoIlegInfVer.setSiiMunicOrdTraInfVerif(siiMunicOrdTraInfVerif);    
        }
        
        if(elementoIlegInfVerVo.getCuadranteOrdTraInfVerVo() != null &&  elementoIlegInfVerVo.getCuadranteOrdTraInfVerVo().getCivCodigo() != null  ){
           SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer = cuadranteOrdTraInfVerDao.buscarCuadranteOrdTraInfVerPorId(elementoIlegInfVerVo.getCuadranteOrdTraInfVerVo().getCivCodigo());
           siiElementoIlegInfVer.setSiiCuadranteOrdTraInfVer(siiCuadranteOrdTraInfVer);
        }
            
        return  siiElementoIlegInfVer;
        
    }
   public SiiGrupoAccionControl convertir(GrupoAccionControlVO grupoAccionControlVo) throws ExcepcionDAO{
        
        SiiGrupoAccionControl siiGrupoAccionControl = new SiiGrupoAccionControl();
        if(grupoAccionControlVo.getGacCodigo() != null && grupoAccionControlVo.getGacCodigo() > 0){
            siiGrupoAccionControl = grupoAccionControlDao.buscarGrupoAccionControlPorId(grupoAccionControlVo.getGacCodigo());

        }
        siiGrupoAccionControl.setGacFecha(grupoAccionControlVo.getGacFecha());
        siiGrupoAccionControl.setGacNumero(grupoAccionControlVo.getGacNumero());
        
        if (grupoAccionControlVo.getSustanciadorAuditorAcompVo() != null && grupoAccionControlVo.getSustanciadorAuditorAcompVo().getSuaCodigo() != null){
           SiiSustanciadorAuditor siiSustanciadorAuditorAcomp =  sustanciadorAuditorDao.buscarPorCodigo(grupoAccionControlVo.getSustanciadorAuditorAcompVo().getSuaCodigo());
            siiGrupoAccionControl.setSiiSustanciadorAuditorAcomp(siiSustanciadorAuditorAcomp);
        }
        
        if (grupoAccionControlVo.getSustanciadorAuditorPpalVo() != null && grupoAccionControlVo.getSustanciadorAuditorPpalVo().getSuaCodigo() != null){
           SiiSustanciadorAuditor siiSustanciadorAuditorPpal =  sustanciadorAuditorDao.buscarPorCodigo(grupoAccionControlVo.getSustanciadorAuditorPpalVo().getSuaCodigo());
            siiGrupoAccionControl.setSiiSustanciadorAuditorPpal(siiSustanciadorAuditorPpal);
        }
        
        return siiGrupoAccionControl;
    }
    
    public SiiAutoComisorioAccCon convertir (AutoComisorioAccConVO autoComisorioAccConVo)throws ExcepcionDAO{
        SiiAutoComisorioAccCon  siiAutoComisorioAccCon = new  SiiAutoComisorioAccCon();
        
        if(autoComisorioAccConVo.getAcaCodigo() != null && autoComisorioAccConVo.getAcaCodigo()>0 ){
           siiAutoComisorioAccCon = autoComisorioAccConDao.buscaSiiAutoComisorioAccConPorId(autoComisorioAccConVo.getAcaCodigo());
        }
        
        siiAutoComisorioAccCon.setAcaDireccion(autoComisorioAccConVo.getAcaDireccion());
        siiAutoComisorioAccCon.setAcaEstado(autoComisorioAccConVo.getAcaEstado());
        siiAutoComisorioAccCon.setAcaFecha(autoComisorioAccConVo.getAcaFecha());
        siiAutoComisorioAccCon.setAcaFechaAnulacion(autoComisorioAccConVo.getAcaFechaAnulacion());
        siiAutoComisorioAccCon.setAcaFechaAccion(autoComisorioAccConVo.getAcaFechaAccionControl());
        siiAutoComisorioAccCon.setAcaNumero(autoComisorioAccConVo.getAcaNumero());
      
        if(autoComisorioAccConVo.getDenunciaVo() != null && autoComisorioAccConVo.getDenunciaVo().getDenCodigo() != null ){
            SiiDenuncia siiDenuncia = denunciaDao.buscarPorCodigo(autoComisorioAccConVo.getDenunciaVo().getDenCodigo());
            siiAutoComisorioAccCon.setSiiDenuncia(siiDenuncia);  
        }
        if(autoComisorioAccConVo.getSiiMotivoAnulAuComAcCon() != null && autoComisorioAccConVo.getSiiMotivoAnulAuComAcCon().getMaaCodigo() != null ){
            SiiMotivoAnulAuComAcCon siiMotivoAnulAuComAcCon =
                motivoAnulAuComAcConDao.buscarMotivoAnulAuComAcConPorId(autoComisorioAccConVo.getSiiMotivoAnulAuComAcCon().getMaaCodigo() );
            siiAutoComisorioAccCon.setSiiMotivoAnulAuComAcCon(siiMotivoAnulAuComAcCon);  
        }
        if(autoComisorioAccConVo.getUbicacionMunicVo() != null && autoComisorioAccConVo.getUbicacionMunicVo().getUbiCodigo() != null ){
            SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId(autoComisorioAccConVo.getUbicacionMunicVo().getUbiCodigo() );
            siiAutoComisorioAccCon.setSiiUbicacionMunic(siiUbicacion);
        }
        if(autoComisorioAccConVo.getGrupoAccionControlVo() != null && autoComisorioAccConVo.getGrupoAccionControlVo().getGacCodigo() != null ){
            SiiGrupoAccionControl siiGrupoAccionControl = 
                grupoAccionControlDao.buscarGrupoAccionControlPorId(autoComisorioAccConVo.getGrupoAccionControlVo().getGacCodigo() );
            siiAutoComisorioAccCon.setSiiGrupoAccionControl(siiGrupoAccionControl);
        }
        
        return siiAutoComisorioAccCon;
    }
 
    public SiiAccionControl convertir(AccionControlVO accionControlVo) throws ExcepcionDAO {
        SiiAccionControl  siiAccionControl = new SiiAccionControl();
        
        if (accionControlVo != null) {
            if (accionControlVo.getAccCodigo() != null && accionControlVo.getAccCodigo() > 0) {
                siiAccionControl = accionControlDao.buscarPorCodigo(accionControlVo.getAccCodigo());
            }            
        }
        siiAccionControl.setAccBarrio(accionControlVo.getAccBarrio());
        siiAccionControl.setAccBodega(accionControlVo.getAccBodega());
        siiAccionControl.setAccDireccion(accionControlVo.getAccDireccion());
        siiAccionControl.setAccEstado(accionControlVo.getAccEstado());
        siiAccionControl.setAccEstadoEstabl(accionControlVo.getAccEstadoEstabl());
        siiAccionControl.setAccFechaActa(accionControlVo.getAccFechaActa());
        siiAccionControl.setAccLocalidad(accionControlVo.getAccLocalidad());
        siiAccionControl.setAccNomEstabl(accionControlVo.getAccNomEstabl());
        siiAccionControl.setAccNumElemEncon(accionControlVo.getAccNumElemEncon());
        siiAccionControl.setAccNumElemRetir(accionControlVo.getAccNumElemRetir());
        siiAccionControl.setAccNumeroActa(accionControlVo.getAccNumeroActa());
        siiAccionControl.setAccObservaciones(accionControlVo.getAccObservaciones());
        siiAccionControl.setAccSucursal(accionControlVo.getAccSucursal());
        siiAccionControl.setAccTipoAccion(accionControlVo.getAccTipoAccion());
        //Padres
        if (accionControlVo.getAutoComisorioAccConVo() != null && 
            accionControlVo.getAutoComisorioAccConVo().getAcaCodigo() != null) {
            siiAccionControl.setSiiAutoComisorioAccCon(autoComisorioAccConDao.buscaSiiAutoComisorioAccConPorId(accionControlVo.getAutoComisorioAccConVo().getAcaCodigo()));
        }
        if (accionControlVo.getMotivoAnulaAccContVo() != null &&
            accionControlVo.getMotivoAnulaAccContVo().getMacCodigo() != null) {
                siiAccionControl.setSiiMotivoAnulaAccCont(motivoAnulaAccContDao.buscarPorCodigo(accionControlVo.getMotivoAnulaAccContVo().getMacCodigo()));
            }
        if (accionControlVo.getUbicacionMunicVo() != null && 
            accionControlVo.getUbicacionMunicVo().getUbiCodigo() != null) {
                siiAccionControl.setSiiUbicacionMunic(ubicacionDao.buscarUbicacionPorId(accionControlVo.getUbicacionMunicVo().getUbiCodigo()));
            }
        if (accionControlVo.getUsuarioConectVo() != null && 
            accionControlVo.getUsuarioConectVo().getUsuCodigo() != null ) {
                siiAccionControl.setSiiUsuarioConect(usuarioDao.buscarUsuarioPorId(accionControlVo.getUsuarioConectVo().getUsuCodigo()));
            }
        
        if(accionControlVo.getResolucionDecomDestVo() != null && accionControlVo.getResolucionDecomDestVo().getRddCodigo() != null) {
            siiAccionControl.setSiiResolucionDecomDest(resolucionDecomDestDAO.buscarPorCodigo(accionControlVo.getResolucionDecomDestVo().getRddCodigo()));
        }
        if(accionControlVo.getResolucionDecomDestResuelveVo() != null && accionControlVo.getResolucionDecomDestResuelveVo().getRddCodigo() != null) {
            siiAccionControl.setSiiResolucionDecomDestResuelve(resolucionDecomDestDAO.buscarPorCodigo(accionControlVo.getResolucionDecomDestResuelveVo().getRddCodigo()));
        }
        
 
        return siiAccionControl;
    }
   
    public SiiMunicOrdTraInfVerif convertir(MunicOrdTraInfVerifVO siiMunicOrdTraInfVerifVo)throws ExcepcionDAO {
        SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif = new SiiMunicOrdTraInfVerif();
        
        if (siiMunicOrdTraInfVerifVo != null) {
            if (siiMunicOrdTraInfVerifVo.getMivCodigo() != null && siiMunicOrdTraInfVerifVo.getMivCodigo() > 0) {
                siiMunicOrdTraInfVerif = municOrdTraInfVerifDao.buscarMunicOrdTraInfVerifPorId(siiMunicOrdTraInfVerifVo.getMivCodigo());
            }            
        }
        siiMunicOrdTraInfVerif.setMivDireccion(siiMunicOrdTraInfVerifVo.getMivDireccion());
        siiMunicOrdTraInfVerif.setMivTipoJuego(siiMunicOrdTraInfVerifVo.getMivTipoJuego());
        siiMunicOrdTraInfVerif.setMivActivo(siiMunicOrdTraInfVerifVo.getMivActivo());
        
        if (siiMunicOrdTraInfVerifVo.getMunicipioOrdenTrabVo()!= null && siiMunicOrdTraInfVerifVo.getMunicipioOrdenTrabVo().getMotCodigo() != null){
            siiMunicOrdTraInfVerif.setSiiMunicipioOrdenTrab(municipioOrdenTrabDao.buscarPorCodigo(siiMunicOrdTraInfVerifVo.getMunicipioOrdenTrabVo().getMotCodigo()));
        }
        
        return siiMunicOrdTraInfVerif;
    }
    
    public SiiCuadranteOrdTraInfVer convertir(CuadranteOrdTraInfVerVO cuadranteOrdTraInfVerVo)throws ExcepcionDAO {
        SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer = new SiiCuadranteOrdTraInfVer();
        
        if (cuadranteOrdTraInfVerVo != null ){
            if(cuadranteOrdTraInfVerVo.getCivCodigo() != null && cuadranteOrdTraInfVerVo.getCivCodigo() > 0 ){
                siiCuadranteOrdTraInfVer = cuadranteOrdTraInfVerDao.buscarCuadranteOrdTraInfVerPorId(cuadranteOrdTraInfVerVo.getCivCodigo()); 
            }
        }
        siiCuadranteOrdTraInfVer.setCivDireccion(cuadranteOrdTraInfVerVo.getCivDireccion());
        siiCuadranteOrdTraInfVer.setCivTipoJuego(cuadranteOrdTraInfVerVo.getCivTipoJuego());
        siiCuadranteOrdTraInfVer.setCivActivo(cuadranteOrdTraInfVerVo.getCivActivo());
        
        if(cuadranteOrdTraInfVerVo.getCuadranteOrdenTraVo() != null && cuadranteOrdTraInfVerVo.getCuadranteOrdenTraVo().getCotCodigo() != null){
            siiCuadranteOrdTraInfVer.setSiiCuadranteOrdenTra(cuadranteOrdenTraDao.buscarPorCodigo(cuadranteOrdTraInfVerVo.getCuadranteOrdenTraVo().getCotCodigo()));
        }
        
        
        return siiCuadranteOrdTraInfVer;
    }
    
    
            


    public SiiElementoRetiradoAcc convertir(ElementoRetiradoAccVO elementoRetiradoAccVo) throws ExcepcionDAO {
        SiiElementoRetiradoAcc siiElementoRetiradoAcc = new SiiElementoRetiradoAcc();
        if (elementoRetiradoAccVo != null) {
            if (elementoRetiradoAccVo.getElrCodigo() != null && elementoRetiradoAccVo.getElrCodigo()>0) {
                siiElementoRetiradoAcc = elementoRetiradoAccDao.buscarPorCodigo(elementoRetiradoAccVo.getElrCodigo());
            }
        }
        siiElementoRetiradoAcc.setElrAccion(elementoRetiradoAccVo.getElrAccion());
        siiElementoRetiradoAcc.setElrActivo(elementoRetiradoAccVo.getElrActivo());
        siiElementoRetiradoAcc.setElrAvaluo(elementoRetiradoAccVo.getElrAvaluo());
        siiElementoRetiradoAcc.setElrDestruido(elementoRetiradoAccVo.getElrDestruido());
        siiElementoRetiradoAcc.setElrMarca(elementoRetiradoAccVo.getElrMarca());
        siiElementoRetiradoAcc.setElrModelo(elementoRetiradoAccVo.getElrModelo());
        siiElementoRetiradoAcc.setElrNumElementos(elementoRetiradoAccVo.getElrNumElementos());
        siiElementoRetiradoAcc.setElrSello(elementoRetiradoAccVo.getElrSello());
        siiElementoRetiradoAcc.setElrSerial(elementoRetiradoAccVo.getElrSerial());
        siiElementoRetiradoAcc.setElrUtilizaTrans(elementoRetiradoAccVo.getElrUtilizaTrans());
        //Padres:
        if (elementoRetiradoAccVo.getTipoElemenIlegalidadVo()!= null &&
            elementoRetiradoAccVo.getTipoElemenIlegalidadVo().getTeiCodigo() != null) {
                siiElementoRetiradoAcc.setSiiTipoElemenIlegalidad(tipoElemenIlegalidadDao.buscarPorCodigo(elementoRetiradoAccVo.getTipoElemenIlegalidadVo().getTeiCodigo()));
            }
        if (elementoRetiradoAccVo.getUsuarioConectVo() != null &&
            elementoRetiradoAccVo.getUsuarioConectVo().getUsuCodigo() != null) {
                siiElementoRetiradoAcc.setSiiUsuarioConect(usuarioDao.buscarUsuarioPorId(elementoRetiradoAccVo.getUsuarioConectVo().getUsuCodigo()));
            }
        if (elementoRetiradoAccVo.getAccionControlVo() != null && 
            elementoRetiradoAccVo.getAccionControlVo().getAccCodigo() != null) {
                siiElementoRetiradoAcc.setSiiAccionControl(accionControlDao.buscarPorCodigo(elementoRetiradoAccVo.getAccionControlVo().getAccCodigo()));                
            }
        
        return siiElementoRetiradoAcc;
    }

    public SiiPersonaAtiendeAcc convertir(PersonaAtiendeAccVO personaAtiendeAccVo) throws ExcepcionDAO {
        SiiPersonaAtiendeAcc personaAtiendeAcc = new SiiPersonaAtiendeAcc();
        if (personaAtiendeAccVo != null) {
            if (personaAtiendeAccVo.getPeaCodigo() != null && personaAtiendeAccVo.getPeaCodigo() > 0) {
                personaAtiendeAcc = personaAtiendeAccDao.buscarPorCodigo(personaAtiendeAccVo.getPeaCodigo());
            }
        }
        personaAtiendeAcc.setPeaActivo(personaAtiendeAccVo.getPeaActivo());
        personaAtiendeAcc.setPeaEmail(personaAtiendeAccVo.getPeaEmail());
        personaAtiendeAcc.setPeaNumeroIden(personaAtiendeAccVo.getPeaNumeroIden());
        personaAtiendeAcc.setPeaPrimerApell(personaAtiendeAccVo.getPeaPrimerApell());
        personaAtiendeAcc.setPeaPrimerNombre(personaAtiendeAccVo.getPeaPrimerNombre());
        personaAtiendeAcc.setPeaSegundoApell(personaAtiendeAccVo.getPeaSegundoApell());
        personaAtiendeAcc.setPeaSegundoNomb(personaAtiendeAccVo.getPeaSegundoNomb());
        personaAtiendeAcc.setPeaTelefonos(personaAtiendeAccVo.getPeaTelefonos());
        if (personaAtiendeAccVo.getAccionControlVo() != null && 
            personaAtiendeAccVo.getAccionControlVo().getAccCodigo() != null) {
            personaAtiendeAcc.setSiiAccionControl(accionControlDao.buscarPorCodigo(personaAtiendeAccVo.getAccionControlVo().getAccCodigo()));            
        }
        if (personaAtiendeAccVo.getUsuarioConectVo() != null && 
            personaAtiendeAccVo.getUsuarioConectVo().getUsuCodigo() != null) {
            personaAtiendeAcc.setSiiUsuarioConect(usuarioDao.buscarUsuarioPorId(personaAtiendeAccVo.getUsuarioConectVo().getUsuCodigo()));
        }
        if (personaAtiendeAccVo.getTipoIdentificacionVo() != null && personaAtiendeAccVo.getTipoIdentificacionVo().getTidCodigo() > 0) {
            personaAtiendeAcc.setSiiTipoIdentificacion(tipoIdentificacionDao.buscarTipoIdentificacionPorId(personaAtiendeAccVo.getTipoIdentificacionVo().getTidCodigo()));            
        }
        return personaAtiendeAcc;
    }

    public SiiDireccionPersonaAtien convertir(DireccionPersonaAtienVO direccionVo) throws ExcepcionDAO {
        SiiDireccionPersonaAtien direccion = new SiiDireccionPersonaAtien();
        if (direccionVo != null) {
            if (direccionVo.getDpaCodigo() != null && direccionVo.getDpaCodigo() > 0) {
                direccion = direccionPersonaAtienDao.buscarPorCodigo(direccionVo.getDpaCodigo());
            }
        }
        direccion.setDpaActivo(direccionVo.getDpaActivo());
        direccion.setDpaDireccion(direccionVo.getDpaDireccion());
        //Padres:
        if (direccionVo.getPersonaAtiendeAccVo() != null && direccionVo.getPersonaAtiendeAccVo().getPeaCodigo() != null) {
            direccion.setSiiPersonaAtiendeAcc(personaAtiendeAccDao.buscarPorCodigo(direccionVo.getPersonaAtiendeAccVo().getPeaCodigo()));
        }
        if (direccionVo.getUbicacionMunicVo() != null && direccionVo.getUbicacionMunicVo().getUbiCodigo()!= null) {
            direccion.setSiiUbicacionMunic(ubicacionDao.buscarUbicacionPorId(direccionVo.getUbicacionMunicVo().getUbiCodigo()));
        }
        if (direccionVo.getUsuarioConectVo() != null && direccionVo.getUsuarioConectVo().getUsuCodigo() != null) {
            direccion.setSiiUsuarioConect(usuarioDao.buscarUsuarioPorId(direccionVo.getUsuarioConectVo().getUsuCodigo()));
        }
        return direccion;
    }
    
    public SiiDenuncOrdTraInfVer convertir( DenuncOrdTraInfVerVO denuncOrdTraInfVerVo)throws ExcepcionDAO {
        SiiDenuncOrdTraInfVer SiiDenuncOrdTraInfVer = new SiiDenuncOrdTraInfVer();
        if(denuncOrdTraInfVerVo != null ){
            if(denuncOrdTraInfVerVo.getDivCodigo() != null && denuncOrdTraInfVerVo.getDivCodigo() >0 ){
                SiiDenuncOrdTraInfVer = denuncOrdTraInfVerDao.buscarDenuncOrdTraInfVerPorId(denuncOrdTraInfVerVo.getDivCodigo());
            }
        }
        SiiDenuncOrdTraInfVer.setDivActivo(denuncOrdTraInfVerVo.getBivActivo());
        SiiDenuncOrdTraInfVer.setDivDireccion(denuncOrdTraInfVerVo.getDivDireccion());
        SiiDenuncOrdTraInfVer.setDivTipoJuego(denuncOrdTraInfVerVo.getDivTipoJuego());
        if(denuncOrdTraInfVerVo.getDenunciaOrdenTrabVo() != null && denuncOrdTraInfVerVo.getDenunciaOrdenTrabVo().getDotCodigo()!= null ){
           SiiDenuncOrdTraInfVer.setSiiDenunciaOrdenTrab(denunciaOrdenTrabDao.buscarPorCodigo(denuncOrdTraInfVerVo.getDenunciaOrdenTrabVo().getDotCodigo()));
        }
        if(denuncOrdTraInfVerVo.getInformeVerificCampoVo() != null && denuncOrdTraInfVerVo.getInformeVerificCampoVo().getIvcCodigo() != null){
            SiiDenuncOrdTraInfVer.setSiiInformeVerificCampo(informeVerificCampoDao.buscarInformeVerificCampoPorId(denuncOrdTraInfVerVo.getInformeVerificCampoVo().getIvcCodigo()));
        }
        
        return SiiDenuncOrdTraInfVer;
    }
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tipoMultaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTipoMulta convertir (TipoMultaVO tipoMultaVo) throws ExcepcionDAO 
    {
        SiiTipoMulta siiTipoMulta = new SiiTipoMulta();

        if (tipoMultaVo != null) {
            if (tipoMultaVo.getTmuCodigo() != null && tipoMultaVo.getTmuCodigo() > 0) {
                siiTipoMulta = tipoMultaDao.buscarPorCodigo(tipoMultaVo.getTmuCodigo());
            }

            siiTipoMulta.setTmuCodigo(tipoMultaVo.getTmuCodigo());
            siiTipoMulta.setTmuClase(tipoMultaVo.getTmuClase());
            siiTipoMulta.setTmuDescripcion(tipoMultaVo.getTmuDescripcion());
            siiTipoMulta.setTmuFactor(tipoMultaVo.getTmuFactor());
            siiTipoMulta.setTmuLimite(tipoMultaVo.getTmuLimite());
            siiTipoMulta.setTmuMaximo(tipoMultaVo.getTmuMaximo());
            siiTipoMulta.setTmuNombre(tipoMultaVo.getTmuNombre());
        }

        return (siiTipoMulta);
    }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param motivoIncumplimientoVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiMotivoIncumplimiento convertir (MotivoIncumplimientoVO motivoIncumplimientoVo) throws ExcepcionDAO 
    {
        SiiMotivoIncumplimiento siiMotivoIncumplimiento = new SiiMotivoIncumplimiento();

        if (motivoIncumplimientoVo != null) {
            if (motivoIncumplimientoVo.getMinCodigo() != null && motivoIncumplimientoVo.getMinCodigo() > 0) {
                siiMotivoIncumplimiento = motivoIncumplimientoDao.buscarPorCodigo(motivoIncumplimientoVo.getMinCodigo());
            }

            siiMotivoIncumplimiento.setMinCodigo(motivoIncumplimientoVo.getMinCodigo());
            siiMotivoIncumplimiento.setMinNombre(motivoIncumplimientoVo.getMinNombre());
            siiMotivoIncumplimiento.setMinTipo(motivoIncumplimientoVo.getMinTipo());
            siiMotivoIncumplimiento.setMinConcepto(motivoIncumplimientoVo.getMinConcepto());
            
            if (motivoIncumplimientoVo.getTipoMultaVo()!=null && motivoIncumplimientoVo.getTipoMultaVo().getTmuCodigo()!=null) {
                SiiTipoMulta siiTipoMulta = tipoMultaDao.buscarPorCodigo(motivoIncumplimientoVo.getTipoMultaVo().getTmuCodigo());
                siiMotivoIncumplimiento.setSiiTipoMulta(siiTipoMulta);
            }
        }

        return (siiMotivoIncumplimiento);
    }

    public SiiResolucionDesisSolAut convertir(ResolucionDesisSolAutVO resolucionDesisSolAutVo) throws ExcepcionDAO {
        SiiResolucionDesisSolAut siiResolucionDesisSolAut = new SiiResolucionDesisSolAut();
        if (resolucionDesisSolAutVo.getRdsCodigo() !=null && resolucionDesisSolAutVo.getRdsCodigo()>0){
            siiResolucionDesisSolAut = resolucionDesisSolAutDao.buscarPorCodigo(resolucionDesisSolAutVo.getRdsCodigo());
        }
        siiResolucionDesisSolAut.setRdsCodigo(resolucionDesisSolAutVo.getRdsCodigo());
        siiResolucionDesisSolAut.setRdsDuracCont(resolucionDesisSolAutVo.getRdsDuracCont());
        siiResolucionDesisSolAut.setRdsDuracProrr(resolucionDesisSolAutVo.getRdsDuracProrr());
        siiResolucionDesisSolAut.setRdsFechaRadicado(resolucionDesisSolAutVo.getRdsFechaRadicado());
        siiResolucionDesisSolAut.setRdsFechaSol(resolucionDesisSolAutVo.getRdsFechaSol());
        siiResolucionDesisSolAut.setRdsNumContrato(resolucionDesisSolAutVo.getRdsNumContrato());
        siiResolucionDesisSolAut.setRdsNumeroSol(resolucionDesisSolAutVo.getRdsNumeroSol());
        siiResolucionDesisSolAut.setRdsRadicado(resolucionDesisSolAutVo.getRdsRadicado());
        siiResolucionDesisSolAut.setRdsEstado(resolucionDesisSolAutVo.getRdsEstado());
        siiResolucionDesisSolAut.setRdsFechaResFirme(resolucionDesisSolAutVo.getRdsFechaResFirme());
        siiResolucionDesisSolAut.setRdsFechaResoluc(resolucionDesisSolAutVo.getRdsFechaResoluc());
        siiResolucionDesisSolAut.setRdsNumResolFirme(resolucionDesisSolAutVo.getRdsNumResolFirme());
        
        if (resolucionDesisSolAutVo.getUsuarioConectVo()!=null && resolucionDesisSolAutVo.getUsuarioConectVo().getUsuCodigo() != null){
            SiiUsuario siiUsuarioConect =
                usuarioDao.buscarUsuarioPorId(resolucionDesisSolAutVo.getUsuarioConectVo().getUsuCodigo());
            siiResolucionDesisSolAut.setSiiUsuarioConect(siiUsuarioConect);
        }
        if(resolucionDesisSolAutVo.getTipoSolicAutorizaVo()!=null && resolucionDesisSolAutVo.getTipoSolicAutorizaVo().getTsaCodigo()!=null){
            SiiTipoSolicAutoriza siiTipoSolicAutoriza =
            tipoSolicAutorizaDao.buscarTipoSolicAutorizaPorCodigo(resolucionDesisSolAutVo.getTipoSolicAutorizaVo().getTsaCodigo());
            siiResolucionDesisSolAut.setSiiTipoSolicAutoriza(siiTipoSolicAutoriza);
        }

        if(resolucionDesisSolAutVo.getOperadorVo()!=null && resolucionDesisSolAutVo.getOperadorVo().getOpeCodigo()!=null){
            SiiOperador siiOperador =
                operadorDao.buscarPorCodigoOperador(resolucionDesisSolAutVo.getOperadorVo().getOpeCodigo());
            siiResolucionDesisSolAut.setSiiOperador(siiOperador);
        }
            
        return siiResolucionDesisSolAut;
    }

    public SiiInventarioResolDesis convertir(InventarioResolDesisVO inventarioResolDesisVo) throws ExcepcionDAO {
        SiiInventarioResolDesis siiInventarioResolDesis = new SiiInventarioResolDesis();
        if(inventarioResolDesisVo.getIrdCodigo() !=null && inventarioResolDesisVo.getIrdCodigo()>0){
            siiInventarioResolDesis = inventarioResolDesisDao.buscarPorCodigo(inventarioResolDesisVo.getIrdCodigo());
        }
        siiInventarioResolDesis.setIrdCodigo(inventarioResolDesisVo.getIrdCodigo());
        siiInventarioResolDesis.setIrdCantidadElem(inventarioResolDesisVo.getIrdCantidadElem());
        siiInventarioResolDesis.setIrdActivo(inventarioResolDesisVo.getIrdActivo());
        
        if(inventarioResolDesisVo.getTipoApuestaVo()!=null && inventarioResolDesisVo.getTipoApuestaVo().getTapCodigo()!=null){
            SiiTipoApuesta siiTipoApuesta =
           tipoApuestaDao.buscarTipoApuestaPorCodigo(inventarioResolDesisVo.getTipoApuestaVo().getTapCodigo());
            siiInventarioResolDesis.setSiiTipoApuesta(siiTipoApuesta);
        }
        if (inventarioResolDesisVo.getUsuarioConectVo()!=null && inventarioResolDesisVo.getUsuarioConectVo().getUsuCodigo() != null){
            SiiUsuario siiUsuarioConect =
                usuarioDao.buscarUsuarioPorId(inventarioResolDesisVo.getUsuarioConectVo().getUsuCodigo());
            siiInventarioResolDesis.setSiiUsuarioConect(siiUsuarioConect);
        }
        if(inventarioResolDesisVo.getResolucionDesisSolAutVo()!=null && inventarioResolDesisVo.getResolucionDesisSolAutVo().getRdsCodigo()!=null){
            SiiResolucionDesisSolAut siiResolucionDesisSolAut =
            resolucionDesisSolAutDao.buscarPorCodigo(inventarioResolDesisVo.getResolucionDesisSolAutVo().getRdsCodigo());
            siiInventarioResolDesis.setSiiResolucionDesisSolAut(siiResolucionDesisSolAut);
        }
        if (inventarioResolDesisVo.getTipoNovedadVo()!=null && inventarioResolDesisVo.getTipoNovedadVo().getTnoCodigo()!=null){
            SiiTipoNovedad siiTipoNovedad =
            tipoNovedadDao.buscarTipoNovedadPorId(inventarioResolDesisVo.getTipoNovedadVo().getTnoCodigo());
            siiInventarioResolDesis.setSiiTipoNovedad(siiTipoNovedad);
        }
        
        return siiInventarioResolDesis;
    }
  
    
    public SiiDireccion convertir (DireccionVO direccionVo) throws ExcepcionDAO{
        
        SiiDireccion siiDireccion = new SiiDireccion();
        
        if(siiDireccion != null){
            
            if(direccionVo.getDirCodigo() != null)
                siiDireccion = direccionDao.buscarPorCodigo(direccionVo.getDirCodigo());
            
            siiDireccion.setDirActivo(direccionVo.getDirActivo());
            siiDireccion.setDirCallePpal(direccionVo.getDirCallePpal());
            siiDireccion.setDirInfoAdicional(direccionVo.getDirInfoAdicional());
            siiDireccion.setDirNumero1(direccionVo.getDirNumero1());
            siiDireccion.setDirNumero2(direccionVo.getDirNumero2());
            siiDireccion.setSiiTipoCalleDireccion(siiDireccion.getSiiTipoCalleDireccion());
            
            if(direccionVo.getTipoCalleDireccionVo() != null && direccionVo.getTipoCalleDireccionVo().getTcdCodigo() != null){
                siiDireccion.setSiiTipoCalleDireccion(tipoCalleDireccionDao.buscarPorCodigo(direccionVo.getTipoCalleDireccionVo().getTcdCodigo()));
            }
            
            if(direccionVo.getTipoSectorDirecPpalVo() != null && direccionVo.getTipoSectorDirecPpalVo().getTsdCodigo() != null){
                siiDireccion.setSiiTipoSectorDirecPpal(tipoSectorDireDao.buscarPorCodigo(direccionVo.getTipoSectorDirecPpalVo().getTsdCodigo()));
            }else{
                siiDireccion.setSiiTipoSectorDirecPpal(null);
            }
            
            if(direccionVo.getTipoSufijo1CallePpal1Vo() != null && direccionVo.getTipoSufijo1CallePpal1Vo().getTscCodigo() != null){
                siiDireccion.setSiiTipoSufijo1CallePpal1(tipoSufijo1CalleDao.buscarPorCodigo(direccionVo.getTipoSufijo1CallePpal1Vo().getTscCodigo()));
            }else{
                siiDireccion.setSiiTipoSufijo1CallePpal1(null);
            }
            
            if(direccionVo.getTipoSufijo1CallePpal2Vo() != null && direccionVo.getTipoSufijo1CallePpal2Vo().getTscCodigo() != null){
                siiDireccion.setSiiTipoSufijo1CallePpal2(tipoSufijo1CalleDao.buscarPorCodigo(direccionVo.getTipoSufijo1CallePpal2Vo().getTscCodigo()));
            }else{
                siiDireccion.setSiiTipoSufijo1CallePpal2(null);
            }
            
            if(direccionVo.getTipoSufijo1CalleNum1Vo() != null && direccionVo.getTipoSufijo1CalleNum1Vo().getTscCodigo() != null){
                siiDireccion.setSiiTipoSufijo1CalleNum1(tipoSufijo1CalleDao.buscarPorCodigo(direccionVo.getTipoSufijo1CalleNum1Vo().getTscCodigo()));
            }else{
                siiDireccion.setSiiTipoSufijo1CalleNum1(null);
            }
            
            if(direccionVo.getTipoSufijo2CalleVo() != null && direccionVo.getTipoSufijo2CalleVo().getTsuCodigo() != null){
                siiDireccion.setSiiTipoSufijo2Calle(tipoSufijo2CalleDao.buscarPorCodigo(direccionVo.getTipoSufijo2CalleVo().getTsuCodigo()));
            }else{
                siiDireccion.setSiiTipoSufijo2Calle(null);
            }
            
            if(direccionVo.getTipoSectorDirecNum2Vo() != null && direccionVo.getTipoSectorDirecNum2Vo().getTsdCodigo() != null){
                siiDireccion.setSiiTipoSectorDirecNum2(tipoSectorDireDao.buscarPorCodigo(direccionVo.getTipoSectorDirecNum2Vo().getTsdCodigo()));
            }else{
                siiDireccion.setSiiTipoSectorDirecNum2(null);
            }
            
            if(direccionVo.getUsuarioConecVo() != null && direccionVo.getUsuarioConecVo().getUsuCodigo() != null)
                siiDireccion.setSiiUsuarioConec(usuarioDao.buscarUsuarioPorId(direccionVo.getUsuarioConecVo().getUsuCodigo()));
        }
        return siiDireccion;
        
    }

    public SiiHistEstadoSustan convertir(HistEstadoSustanVO historiaVo) throws ExcepcionDAO {
        SiiHistEstadoSustan siiHistEstadoSustan = new SiiHistEstadoSustan();
        if (siiHistEstadoSustan.getHesCodigo() != null && siiHistEstadoSustan.getHesCodigo() > 0) {
            siiHistEstadoSustan = histEstadoSustanDao.buscarPorCodigo(historiaVo.getHesCodigo());
        }
        siiHistEstadoSustan.setHesCodigo(historiaVo.getHesCodigo());
        siiHistEstadoSustan.setHesEstado(historiaVo.getHesEstado());
        siiHistEstadoSustan.setHesFechaAct(historiaVo.getHesFechaAct());
        siiHistEstadoSustan.setHesFechaInact(historiaVo.getHesFechaInact());
        siiHistEstadoSustan.setHesGrupoAsignVisit(historiaVo.getHesGrupoAsignVisit());
        //Padres:
        if (historiaVo.getSustanciadorAuditorVo() != null &&
            historiaVo.getSustanciadorAuditorVo().getSuaCodigo() != null) {
            SiiSustanciadorAuditor sustanc =
                sustanciadorAuditorDao.buscarPorCodigo(historiaVo.getSustanciadorAuditorVo().getSuaCodigo());
            siiHistEstadoSustan.setSiiSustanciadorAuditor(sustanc);
        }
        if(historiaVo.getUsuarioConectVo() != null && historiaVo.getUsuarioConectVo().getUsuCodigo() != null) {
            SiiUsuario usuario = usuarioDao.buscarUsuarioPorId(historiaVo.getUsuarioConectVo().getUsuCodigo());
            siiHistEstadoSustan.setSiiUsuarioConect(usuario);
        }

        return siiHistEstadoSustan;
    }
    
    public SiiSustanciadorAuditor convertir(SustanciadorAuditorVO sustanciadorAuditorVo) throws ExcepcionDAO {
        SiiSustanciadorAuditor siiSustanciadorAuditor = new SiiSustanciadorAuditor();
        if (sustanciadorAuditorVo.getSuaCodigo() != null && sustanciadorAuditorVo.getSuaCodigo() > 0) {
            siiSustanciadorAuditor = sustanciadorAuditorDao.buscarPorCodigo(sustanciadorAuditorVo.getSuaCodigo());
        }
        siiSustanciadorAuditor.setSuaCodigo(sustanciadorAuditorVo.getSuaCodigo());
        siiSustanciadorAuditor.setSuaRol(sustanciadorAuditorVo.getSuaRol());
        //Padres:
        if (sustanciadorAuditorVo.getPersonaVo() != null &&
            sustanciadorAuditorVo.getPersonaVo().getPerCodigo() != null) {
            SiiPersona siiPersona = personaDao.buscarPersonaPorId(sustanciadorAuditorVo.getPersonaVo().getPerCodigo());
            siiSustanciadorAuditor.setSiiPersona(siiPersona);
        }
        if (sustanciadorAuditorVo.getTipoActuacionVo() != null &&
            sustanciadorAuditorVo.getTipoActuacionVo().getTacCodigo() != null) {
            SiiTipoActuacion siiTipoActuacion =
                tipoActuacionDao.buscarPorCodigo(sustanciadorAuditorVo.getTipoActuacionVo().getTacCodigo());
            siiSustanciadorAuditor.setSiiTipoActuacion(siiTipoActuacion);
        }
        return siiSustanciadorAuditor;
    }


    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param actaSuspenAudIncumConVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiActaSuspenAudIncumCon convertir (ActaSuspenAudIncumConVO actaSuspenAudIncumConVo) throws ExcepcionDAO 
    {
        SiiActaSuspenAudIncumCon siiActaSuspenAudIncumCon = new SiiActaSuspenAudIncumCon();

        if (actaSuspenAudIncumConVo != null) {
            if (actaSuspenAudIncumConVo.getAsaCodigo() != null && actaSuspenAudIncumConVo.getAsaCodigo() > 0) {
                siiActaSuspenAudIncumCon = actaSuspenAudIncumConDao.buscarPorCodigo(actaSuspenAudIncumConVo.getAsaCodigo());
            }

            siiActaSuspenAudIncumCon.setAsaCodigo(actaSuspenAudIncumConVo.getAsaCodigo());
            siiActaSuspenAudIncumCon.setAsaFecha(actaSuspenAudIncumConVo.getAsaFecha());
            siiActaSuspenAudIncumCon.setAsaFechaReanud(actaSuspenAudIncumConVo.getAsaFechaReanud());
            siiActaSuspenAudIncumCon.setAsaMotivo(actaSuspenAudIncumConVo.getAsaMotivo());
            siiActaSuspenAudIncumCon.setAsaObservaciones(actaSuspenAudIncumConVo.getAsaObservaciones());
            
            if (actaSuspenAudIncumConVo.getIncumplimientoContrVo()!=null && actaSuspenAudIncumConVo.getIncumplimientoContrVo().getIcnCodigo()!=null) {
                SiiIncumplimientoContr siiIncumplimientoContr = incumplimientoContrDao.buscarPorCodigo(actaSuspenAudIncumConVo.getIncumplimientoContrVo().getIcnCodigo());
                siiActaSuspenAudIncumCon.setSiiIncumplimientoContr(siiIncumplimientoContr);
            }
        }

        return (siiActaSuspenAudIncumCon);
    }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param operadorVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiOperador convertir (OperadorVO operadorVo) throws ExcepcionDAO 
    {
        SiiOperador siiOperador = new SiiOperador();

        if (operadorVo != null) {
            if (operadorVo.getOpeCodigo() != null && operadorVo.getOpeCodigo() > 0) {
                siiOperador = operadorDao.buscarPorCodigoOperador(operadorVo.getOpeCodigo());
            }

            siiOperador.setOpeCodigo(operadorVo.getOpeCodigo());
            siiOperador.setOpeEstado(operadorVo.getOpeEstado());
            siiOperador.setOpeFechaFinInhab(operadorVo.getOpeFechaFinInhab());
            siiOperador.setOpeFechaIniInhab(operadorVo.getOpeFechaIniInhab());
            siiOperador.setOpePotencial(operadorVo.getOpePotencial());
            siiOperador.setOpeTipoPoblac(operadorVo.getOpeTipoPoblac());
            
            if (operadorVo.getPersonaVo()!=null && operadorVo.getPersonaVo().getPerCodigo()!=null) {
                SiiPersona siiPersona = personaDao.buscarPersonaPorId(operadorVo.getPersonaVo().getPerCodigo());
                siiOperador.setSiiPersona(siiPersona);
            }
        }

        return (siiOperador);
    }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param inhabilidadPersonaVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiInhabilidadPersona convertir (InhabilidadPersonaVO inhabilidadPersonaVo) throws ExcepcionDAO 
    {
        SiiInhabilidadPersona siiInhabilidadPersona = new SiiInhabilidadPersona();

        if (inhabilidadPersonaVo != null) {
            if (inhabilidadPersonaVo.getIpeCodigo() != null && inhabilidadPersonaVo.getIpeCodigo() > 0) {
                siiInhabilidadPersona = inhabilidadPersonaDao.buscarPorCodigo(inhabilidadPersonaVo.getIpeCodigo());
            }

            siiInhabilidadPersona.setIpeCodigo(inhabilidadPersonaVo.getIpeCodigo());
            siiInhabilidadPersona.setIpeActivo(inhabilidadPersonaVo.getIpeActivo());
            siiInhabilidadPersona.setIpeFechaIni(inhabilidadPersonaVo.getIpeFechaIni());
            siiInhabilidadPersona.setIpeFechaFin(inhabilidadPersonaVo.getIpeFechaFin());
            
            
            if (inhabilidadPersonaVo.getPersonaVo()!=null && inhabilidadPersonaVo.getPersonaVo().getPerCodigo()!=null) {
                SiiPersona siiPersona = personaDao.buscarPersonaPorId(inhabilidadPersonaVo.getPersonaVo().getPerCodigo());
                siiInhabilidadPersona.setSiiPersona(siiPersona);
            }
            
            if (inhabilidadPersonaVo.getUsuarioConecVo()!=null && inhabilidadPersonaVo.getUsuarioConecVo().getUsuCodigo()!=null) {
                SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(inhabilidadPersonaVo.getUsuarioConecVo().getUsuCodigo());
                siiInhabilidadPersona.setSiiUsuarioConec(siiUsuario);
            }
            
            if (inhabilidadPersonaVo.getIncumplimientoContrVo()!=null && inhabilidadPersonaVo.getIncumplimientoContrVo().getIcnCodigo()!=null) {
                SiiIncumplimientoContr siiIncumplimientoContr = incumplimientoContrDao.buscarPorCodigo(inhabilidadPersonaVo.getIncumplimientoContrVo().getIcnCodigo());
                siiInhabilidadPersona.setSiiIncumplimientoContr(siiIncumplimientoContr);
            }
            
            if (inhabilidadPersonaVo.getProcesoSancionatorioVo()!=null && inhabilidadPersonaVo.getProcesoSancionatorioVo().getPsaCodigo()!=null) {
                SiiProcesoSancionatorio siiProcesoSancionatorio = procesoSancionatorioDao.buscarPorCodigo(inhabilidadPersonaVo.getProcesoSancionatorioVo().getPsaCodigo());
                siiInhabilidadPersona.setSiiProcesoSancionatorio(siiProcesoSancionatorio);
            }
            
            if (inhabilidadPersonaVo.getProcesoSancIlegalidadVo()!=null && inhabilidadPersonaVo.getProcesoSancIlegalidadVo().getPrsCodigo()!=null) {
                SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = procesoSancIlegalidadDao.buscarPorCodigo(inhabilidadPersonaVo.getProcesoSancIlegalidadVo().getPrsCodigo());
                siiInhabilidadPersona.setSiiProcesoSancIlegalidad(siiProcesoSancIlegalidad);
            }
        }

        return (siiInhabilidadPersona);
    }
    
    public SiiCargaActuacionesAdm convertir (CargaActuacionesAdmVO cargaActuacionesAdmVo)throws ExcepcionDAO {
            SiiCargaActuacionesAdm siiCargaActuacionesAdm = new SiiCargaActuacionesAdm();
            if( cargaActuacionesAdmVo.getCaaCodigo() != null && cargaActuacionesAdmVo.getCaaCodigo() > 0  ){
                siiCargaActuacionesAdm = cargaActuacionesAdmDao.buscarPorCodigo(cargaActuacionesAdmVo.getCaaCodigo());
            }
            siiCargaActuacionesAdm.setCaaCodigo(cargaActuacionesAdmVo.getCaaCodigo());
            siiCargaActuacionesAdm.setCaaDiasPlazo(cargaActuacionesAdmVo.getCaaDiasPlazo());
            siiCargaActuacionesAdm.setCaaEstado(cargaActuacionesAdmVo.getCaaEstado());
            siiCargaActuacionesAdm.setCaaFechaEjecut(cargaActuacionesAdmVo.getCaaFechaEjecut());
            siiCargaActuacionesAdm.setCaaFechaFinInhab(cargaActuacionesAdmVo.getCaaFechaFinInhab());
            siiCargaActuacionesAdm.setCaaFechaIniInhab(cargaActuacionesAdmVo.getCaaFechaIniInhab());
            siiCargaActuacionesAdm.setCaaFechaMigracion(cargaActuacionesAdmVo.getCaaFechaMigracion());
            siiCargaActuacionesAdm.setCaaFechaResoluc(cargaActuacionesAdmVo.getCaaFechaResoluc());
            siiCargaActuacionesAdm.setCaaNumResolucion(cargaActuacionesAdmVo.getCaaNumResolucion());
            siiCargaActuacionesAdm.setCaaTipoDias(cargaActuacionesAdmVo.getCaaTipoDias());
            siiCargaActuacionesAdm.setCaaConsecutivo(cargaActuacionesAdmVo.getCaaConsecutivo());
            if(cargaActuacionesAdmVo.getContratoVo() != null && cargaActuacionesAdmVo.getContratoVo().getConCodigo() != null){
               SiiContrato siiContrato =  contratoDao.buscarContratoPorId(cargaActuacionesAdmVo.getContratoVo().getConCodigo());
                siiCargaActuacionesAdm.setSiiContrato(siiContrato);
            }
            
            if(cargaActuacionesAdmVo.getPersonaVo() != null && cargaActuacionesAdmVo.getPersonaVo().getPerCodigo() != null ){
                SiiPersona  siiPersona = personaDao.buscarPersonaPorId(cargaActuacionesAdmVo.getPersonaVo().getPerCodigo());
                siiCargaActuacionesAdm.setSiiPersona(siiPersona);
            }
            
            if(cargaActuacionesAdmVo.getProcesoOriCargaVo() != null && cargaActuacionesAdmVo.getProcesoOriCargaVo().getPocCodigo() != null ){
                SiiProcesoOriCarga siiProcesoOriCarga = procesoOriCargaDao.buscarPorCodigo(cargaActuacionesAdmVo.getProcesoOriCargaVo().getPocCodigo());
                siiCargaActuacionesAdm.setSiiProcesoOriCarga(siiProcesoOriCarga);
            }
            
            if(cargaActuacionesAdmVo.getMotivoIncumplimientoVo() != null && cargaActuacionesAdmVo.getMotivoIncumplimientoVo().getMinCodigo() != null  ){
                SiiMotivoIncumplimiento siiMotivoIncumplimiento = motivoIncumplimientoDao.buscarPorCodigo(cargaActuacionesAdmVo.getMotivoIncumplimientoVo().getMinCodigo());
                siiCargaActuacionesAdm.setSiiMotivoIncumplimiento(siiMotivoIncumplimiento);
            }
            
            if(cargaActuacionesAdmVo.getDocumentoContableVo()  != null &&  cargaActuacionesAdmVo.getDocumentoContableVo().getDcoCodigo() != null){
                SiiDocumentoContable  siiDocumentoContable =  documentoContableDao.buscarPorCodigo(cargaActuacionesAdmVo.getDocumentoContableVo().getDcoCodigo());
                siiCargaActuacionesAdm.setSiiDocumentoContable(siiDocumentoContable);
            }
            
            if(cargaActuacionesAdmVo.getUsuarioConectadoVo() != null && cargaActuacionesAdmVo.getUsuarioConectadoVo().getUsuCodigo() != null ){
                SiiUsuario siiUsuarioConectado = usuarioDao.buscarUsuarioPorId(cargaActuacionesAdmVo.getUsuarioConectadoVo().getUsuCodigo());
                siiCargaActuacionesAdm.setSiiUsuarioConectado(siiUsuarioConectado);
            }
            
            
            return siiCargaActuacionesAdm;
            
        }


        public SiiConcepCuotCarActAdm convertir (ConcepCuotCarActAdmVO concepCuotCarActAdmVo)throws ExcepcionDAO {
            SiiConcepCuotCarActAdm siiConcepCuotCarActAdm = new SiiConcepCuotCarActAdm();
            
            if( concepCuotCarActAdmVo.getCamCodigo() != null && concepCuotCarActAdmVo.getCamCodigo() > 0  ){
                siiConcepCuotCarActAdm = concepCuotCarActAdmDao.buscarPorCodigo(concepCuotCarActAdmVo.getCamCodigo());
            }
            siiConcepCuotCarActAdm.setCamActivo(concepCuotCarActAdmVo.getCamActivo());
            siiConcepCuotCarActAdm.setCamValor(concepCuotCarActAdmVo.getCamValor());
            if(concepCuotCarActAdmVo.getCargaActuacionesAdmVo() != null && concepCuotCarActAdmVo.getCargaActuacionesAdmVo().getCaaCodigo()!= null ){
                SiiCargaActuacionesAdm siiCargaActuacionesAdm = cargaActuacionesAdmDao.buscarPorCodigo(concepCuotCarActAdmVo.getCargaActuacionesAdmVo().getCaaCodigo());
                siiConcepCuotCarActAdm.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
            }
            if(concepCuotCarActAdmVo.getConceptoCuotaVo() != null && concepCuotCarActAdmVo.getConceptoCuotaVo().getCcuCodigo()!= null  ){
                SiiConceptoCuota siiConceptoCuota = conceptoCuotaDao.buscarConceptoCuotaXId(concepCuotCarActAdmVo.getConceptoCuotaVo().getCcuCodigo());
                siiConcepCuotCarActAdm.setSiiConceptoCuota(siiConceptoCuota);
            }
            if(concepCuotCarActAdmVo.getUsuarioConectadoVo() != null && concepCuotCarActAdmVo.getUsuarioConectadoVo().getUsuCodigo()  != null ){
                SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(concepCuotCarActAdmVo.getUsuarioConectadoVo().getUsuCodigo() );
                siiConcepCuotCarActAdm.setSiiUsuarioConectado(siiUsuario);
            }
            
            
            
            return siiConcepCuotCarActAdm;
        }

        public SiiPagoCargaActAdm convertir (PagoCargaActAdmVO pagoCargaActAdmVo)throws ExcepcionDAO {
            SiiPagoCargaActAdm siipagoCargaActAdm = new SiiPagoCargaActAdm ();
            
            if(pagoCargaActAdmVo.getPcaCodigo() != null && pagoCargaActAdmVo.getPcaCodigo() > 0 ){
                siipagoCargaActAdm = pagoCargaActAdmDao.buscarPorCodigo(pagoCargaActAdmVo.getPcaCodigo());
            }
            siipagoCargaActAdm.setPcaActivo(pagoCargaActAdmVo.getPcaActivo());
            siipagoCargaActAdm.setPcaFechaPago(pagoCargaActAdmVo.getPcaFechaPago());
            siipagoCargaActAdm.setPcaValorCapital(pagoCargaActAdmVo.getPcaValorCapital());
            siipagoCargaActAdm.setPcaValorInteres(pagoCargaActAdmVo.getPcaValorInteres());
            if(pagoCargaActAdmVo.getCargaActuacionesAdmVo() !=  null && pagoCargaActAdmVo.getCargaActuacionesAdmVo().getCaaCodigo() != null){
                SiiCargaActuacionesAdm  siiCargaActuacionesAdm = cargaActuacionesAdmDao.buscarPorCodigo(pagoCargaActAdmVo.getCargaActuacionesAdmVo().getCaaCodigo());
                siipagoCargaActAdm.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
            }
            if(pagoCargaActAdmVo.getConceptoCuotaVo() != null && pagoCargaActAdmVo.getConceptoCuotaVo().getCcuCodigo() != null){
                SiiConceptoCuota siiConceptoCuota = conceptoCuotaDao.buscarConceptoCuotaXId(pagoCargaActAdmVo.getConceptoCuotaVo().getCcuCodigo());
                siipagoCargaActAdm.setSiiConceptoCuota(siiConceptoCuota);
            }
            if(pagoCargaActAdmVo.getUsuarioConectadoVo() != null && pagoCargaActAdmVo.getUsuarioConectadoVo().getUsuCodigo() != null){
                SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(pagoCargaActAdmVo.getUsuarioConectadoVo().getUsuCodigo() );
                siipagoCargaActAdm.setSiiUsuarioConectado(siiUsuario);
            }
            
            return siipagoCargaActAdm;
        }
        
        public SiiEstablecConCuoCar convertir (EstablecConCuoCarVO establecConCuoCarVo)throws ExcepcionDAO {
            SiiEstablecConCuoCar  siiEstablecConCuoCar = new SiiEstablecConCuoCar();
            
            if(establecConCuoCarVo.getEcuCodigo() != null && establecConCuoCarVo.getEcuCodigo()>0 ){
                 siiEstablecConCuoCar = establecConCuoCaDao.buscarPorCodigo(establecConCuoCarVo.getEcuCodigo());
            }
            siiEstablecConCuoCar.setEcuValor(establecConCuoCarVo.getEcuValor());
            siiEstablecConCuoCar.setEcuActivo(establecConCuoCarVo.getEcuActivo());
            siiEstablecConCuoCar.setEcuCodEstablec(establecConCuoCarVo.getEcuCodEstablec());
            siiEstablecConCuoCar.setEcuPorcentaje(establecConCuoCarVo.getEcuPorcentaje());
            
            if(establecConCuoCarVo.getConcepCuotCarActAdmVo() != null && establecConCuoCarVo.getConcepCuotCarActAdmVo().getCamCodigo()!= null){
               SiiConcepCuotCarActAdm  siiConcepCuotCarActAdm = concepCuotCarActAdmDao.buscarPorCodigo(establecConCuoCarVo.getConcepCuotCarActAdmVo().getCamCodigo());
               siiEstablecConCuoCar.setSiiConcepCuotCarActAdm(siiConcepCuotCarActAdm);
            }
            if(establecConCuoCarVo.getUbicacionMunicipioVo() != null && establecConCuoCarVo.getUbicacionMunicipioVo().getUbiCodigo() != null ){
                SiiUbicacion  siiUbicacion = ubicacionDao.buscarUbicacionPorId(establecConCuoCarVo.getUbicacionMunicipioVo().getUbiCodigo());
                siiEstablecConCuoCar.setSiiUbicacionMunicipio(siiUbicacion);
            }
            
            if(establecConCuoCarVo.getUsuarioConectadoVo() != null && establecConCuoCarVo.getUsuarioConectadoVo().getUsuCodigo() != null  ){
                SiiUsuario  usuario = usuarioDao.buscarUsuarioPorId(establecConCuoCarVo.getUsuarioConectadoVo().getUsuCodigo() );
                siiEstablecConCuoCar.setSiiUsuarioConectado(usuario);
            }
            
            
            return siiEstablecConCuoCar;
        }
        
    /**
     *
     * @param tasaInteresVO
     * @return
     */
    public SiiTasaInteres convertir(TasaInteresVO tasaInteresVO) throws ExcepcionDAO {
        SiiTasaInteres siiTasaInteres = new SiiTasaInteres();
        if (tasaInteresVO.getTaiCodigo() != null && tasaInteresVO.getTaiCodigo().intValue() > 0) {
            siiTasaInteres = tasaInteresDao.buscarPorCodigo(tasaInteresVO.getTaiCodigo());
        }

        siiTasaInteres.setTaiActivo(tasaInteresVO.getTaiActivo()); 
        siiTasaInteres.setTaiCodigo(tasaInteresVO.getTaiCodigo());
        siiTasaInteres.setTaiFecha(tasaInteresVO.getTaiFecha());
        siiTasaInteres.setTaiFechaDesde(tasaInteresVO.getTaiFechaDesde());
        siiTasaInteres.setTaiFechaHasta(tasaInteresVO.getTaiFechaHasta());
        siiTasaInteres.setTaiPorcentaje(tasaInteresVO.getTaiPorcentaje());
        siiTasaInteres.setTaiTipoInteres(tasaInteresVO.getTaiTipoInteres());
        if (tasaInteresVO.getUsuarioConecVo() != null && tasaInteresVO.getUsuarioConecVo().getUsuCodigo() != null){
            SiiUsuario  siiUsuario = usuarioDao.buscarUsuarioPorId(tasaInteresVO.getUsuarioConecVo().getUsuCodigo());
            siiTasaInteres.setSiiUsuarioConec(siiUsuario);
        }
        if (tasaInteresVO.getTipoTasaInteresVo() != null && tasaInteresVO.getTipoTasaInteresVo().getTtiCodigo() != null){
            SiiTipoTasaInteres siiTipoTasaInteres = tipoTasaInteresDao.buscarPorCodigo(tasaInteresVO.getTipoTasaInteresVo().getTtiCodigo());
            siiTasaInteres.setSiiTipoTasaInteres(siiTipoTasaInteres);
        }
        return siiTasaInteres;
    }
    
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param recepcionAlegatoProSanVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiRecepcionAlegatoProSan convertir (RecepcionAlegatoProSanVO recepcionAlegatoProSanVo) throws ExcepcionDAO 
    {
        SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan = new SiiRecepcionAlegatoProSan();

        if (recepcionAlegatoProSanVo != null) {
            if (recepcionAlegatoProSanVo.getRalCodigo() != null && recepcionAlegatoProSanVo.getRalCodigo() > 0) {
                siiRecepcionAlegatoProSan = recepcionAlegatoProSanDao.buscarPorCodigo(recepcionAlegatoProSanVo.getRalCodigo());
            }

            siiRecepcionAlegatoProSan.setRalCodigo(recepcionAlegatoProSanVo.getRalCodigo());
            siiRecepcionAlegatoProSan.setRalFechaRad(recepcionAlegatoProSanVo.getRalFechaRad());
            siiRecepcionAlegatoProSan.setRalPruebas(recepcionAlegatoProSanVo.getRalPruebas());
            siiRecepcionAlegatoProSan.setRalRadicado(recepcionAlegatoProSanVo.getRalRadicado());
            siiRecepcionAlegatoProSan.setRalSolicitaPru(recepcionAlegatoProSanVo.getRalSolicitaPru());
            
            
            
            if (recepcionAlegatoProSanVo.getUsuarioConecVo()!=null && recepcionAlegatoProSanVo.getUsuarioConecVo().getUsuCodigo()!=null) {
                SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(recepcionAlegatoProSanVo.getUsuarioConecVo().getUsuCodigo());
                siiRecepcionAlegatoProSan.setSiiUsuarioConec(siiUsuario);
            }
            
            if (recepcionAlegatoProSanVo.getProcesoSancionatorioVo()!=null && recepcionAlegatoProSanVo.getProcesoSancionatorioVo().getPsaCodigo()!=null) {
                SiiProcesoSancionatorio siiProcesoSancionatorio = procesoSancionatorioDao.buscarPorCodigo(recepcionAlegatoProSanVo.getProcesoSancionatorioVo().getPsaCodigo());
                siiRecepcionAlegatoProSan.setSiiProcesoSancionatorio(siiProcesoSancionatorio);
            }
        }

        return (siiRecepcionAlegatoProSan);
    }
    
    public SiiLogActividad convertir(LogActividadVO logActividadVo) throws ExcepcionDAO{
        SiiLogActividad siiLogActividad = new SiiLogActividad();
        if(logActividadVo != null && logActividadVo.getLoaCodigo() != null && logActividadVo.getLoaCodigo() > 0){
            siiLogActividad = logActividadDao.buscarPorCodigo(logActividadVo.getLoaCodigo());
        }
        siiLogActividad.setLoaFecha(logActividadVo.getLoaFecha());
        siiLogActividad.setLoaIdSesion(logActividadVo.getLoaIdSesion());
        siiLogActividad.setLoaPermisoAcc(logActividadVo.getLoaPermisoAcc());
        siiLogActividad.setLoaUrl(logActividadVo.getLoaUrl());
        if(logActividadVo.getUsuarioVo() != null && logActividadVo.getUsuarioVo().getUsuCodigo() != null && logActividadVo.getUsuarioVo().getUsuCodigo() > 0){
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(logActividadVo.getUsuarioVo().getUsuCodigo());
            siiLogActividad.setSiiUsuario(siiUsuario);
        }
        return siiLogActividad;
    }
    
    public SiiAjusteContCarAct convertir (AjusteContCarActVO ajusteContCarActVo) throws ExcepcionDAO{
        SiiAjusteContCarAct siiAjusteContCarAct = new SiiAjusteContCarAct();
        if (ajusteContCarActVo.getAjcCodigo() != null && ajusteContCarActVo.getAjcCodigo() > 0  ){
            siiAjusteContCarAct = ajusteContCarActDao.buscarPorCodigo(ajusteContCarActVo.getAjcCodigo());
        }
        siiAjusteContCarAct.setAjcActivo(ajusteContCarActVo.getAjcActivo());
        siiAjusteContCarAct.setAjcValor(ajusteContCarActVo.getAjcValor());
        siiAjusteContCarAct.setAjcDescripcion(ajusteContCarActVo.getAjcDescripcion());
        siiAjusteContCarAct.setAjcFecha(ajusteContCarActVo.getAjcFechaAjuste());
        if(ajusteContCarActVo.getCargaActuacionesAdmVo() != null && ajusteContCarActVo.getCargaActuacionesAdmVo().getCaaCodigo()!= null ){
                SiiCargaActuacionesAdm siiCargaActuacionesAdm = cargaActuacionesAdmDao.buscarPorCodigo(ajusteContCarActVo.getCargaActuacionesAdmVo().getCaaCodigo());
                siiAjusteContCarAct.setSiiCargaActuacionesAdm(siiCargaActuacionesAdm);
        }
        if(ajusteContCarActVo.getUsuarioConectadoVo() != null && ajusteContCarActVo.getUsuarioConectadoVo().getUsuCodigo() != null  ){
                SiiUsuario  usuario = usuarioDao.buscarUsuarioPorId(ajusteContCarActVo.getUsuarioConectadoVo().getUsuCodigo() );
                siiAjusteContCarAct.setSiiUsuarioConectado(usuario);
        }
               
        return siiAjusteContCarAct;
    }
    
    public SiiProcesoSancIlegalidad convertir (ProcesoSancIlegalidadVO procesoSancIlegalidadVo) throws ExcepcionDAO{
        SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = new SiiProcesoSancIlegalidad();
        if (procesoSancIlegalidadVo != null && procesoSancIlegalidadVo.getPrsCodigo() != null && procesoSancIlegalidadVo.getPrsCodigo() >0){
            siiProcesoSancIlegalidad  = procSancIlegalDao.buscarPorCodigo(procesoSancIlegalidadVo.getPrsCodigo());            
        }
        siiProcesoSancIlegalidad.setPrsAuArcFechaGen(procesoSancIlegalidadVo.getPrsAuArcFechaGen());
        siiProcesoSancIlegalidad.setPrsAuArcSolNFecR(procesoSancIlegalidadVo.getPrsAuArcSolNFecR());
        siiProcesoSancIlegalidad.setPrsAuArcSolNRadi(procesoSancIlegalidadVo.getPrsAuArcSolNRadi());
        siiProcesoSancIlegalidad.setPrsConsecutivo(procesoSancIlegalidadVo.getPrsConsecutivo());
        siiProcesoSancIlegalidad.setPrsInterpRecApel(procesoSancIlegalidadVo.getPrsInterpRecApel());
        siiProcesoSancIlegalidad.setPrsInterpRecRepo(procesoSancIlegalidadVo.getPrsInterpRecRepo());
        siiProcesoSancIlegalidad.setPrsFechaConHech(procesoSancIlegalidadVo.getPrsFechaConHech());
        siiProcesoSancIlegalidad.setPrsNumeroAuto(procesoSancIlegalidadVo.getPrsNumeroAuto());
        siiProcesoSancIlegalidad.setPrsFechaAuto(procesoSancIlegalidadVo.getPrsFechaAuto());
        
        if (procesoSancIlegalidadVo.getDenunciaVo() != null && procesoSancIlegalidadVo.getDenunciaVo().getDenCodigo() != null && procesoSancIlegalidadVo.getDenunciaVo().getDenCodigo() > 0 ){
            SiiDenuncia siiDenuncia =  denunciaDao.buscarPorCodigo(procesoSancIlegalidadVo.getDenunciaVo().getDenCodigo());    
            siiProcesoSancIlegalidad.setSiiDenuncia(siiDenuncia);
        }
        if (procesoSancIlegalidadVo.getResolucionProcIlegApelaVo() != null && procesoSancIlegalidadVo.getResolucionProcIlegApelaVo().getRpiCodigo() != null && procesoSancIlegalidadVo.getResolucionProcIlegApelaVo().getRpiCodigo() > 0){
            SiiResolucionProcIleg siiResolucionProcIleg = resolucionProcIlegalDao.buscarPorCodigo(procesoSancIlegalidadVo.getResolucionProcIlegApelaVo().getRpiCodigo());
            siiProcesoSancIlegalidad.setSiiResolucionProcIlegApela(siiResolucionProcIleg);
        }
        if (procesoSancIlegalidadVo.getEstadoProcSanIlegVo() != null && procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo() != null && procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo() >0){
            SiiEstadoProcSanIleg siiEstadoProcSanIleg = estadoProcSanIlegDao.buscarPorCodigo(procesoSancIlegalidadVo.getEstadoProcSanIlegVo().getEpiCodigo());
            siiProcesoSancIlegalidad.setSiiEstadoProcSanIleg(siiEstadoProcSanIleg);
        }
        if (procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo() != null && procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo().getRpiCodigo() != null && procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo().getRpiCodigo()>0){
            SiiResolucionProcIleg siiResolucionProcIleg = resolucionProcIlegalDao.buscarPorCodigo(procesoSancIlegalidadVo.getResolucionProcIlegReposicionVo().getRpiCodigo());
            siiProcesoSancIlegalidad.setSiiResolucionProcIlegReposicion(siiResolucionProcIleg);
        }
        if (procesoSancIlegalidadVo.getResolucionProcIlegResolVo() != null && procesoSancIlegalidadVo.getResolucionProcIlegResolVo().getRpiCodigo() != null && procesoSancIlegalidadVo.getResolucionProcIlegResolVo().getRpiCodigo() >0){
            SiiResolucionProcIleg     siiResolucionProcIleg = resolucionProcIlegalDao.buscarPorCodigo(procesoSancIlegalidadVo.getResolucionProcIlegResolVo().getRpiCodigo());
            siiProcesoSancIlegalidad.setSiiResolucionProcIlegResol(siiResolucionProcIleg);
        }
        if (procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo() != null && procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo().getRpiCodigo() != null && procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo().getRpiCodigo() >0){
            SiiResolucionProcIleg     siiResolucionProcIleg = resolucionProcIlegalDao.buscarPorCodigo(procesoSancIlegalidadVo.getResolucionProcIlegSinSancionVo().getRpiCodigo());
            siiProcesoSancIlegalidad.setSiiResolucionProcIlegSinSancion (siiResolucionProcIleg);
        }
        if (procesoSancIlegalidadVo.getUsuarioConecVo() != null && procesoSancIlegalidadVo.getUsuarioConecVo().getUsuCodigo() != null && procesoSancIlegalidadVo.getUsuarioConecVo().getUsuCodigo() >0){
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(procesoSancIlegalidadVo.getUsuarioConecVo().getUsuCodigo());
            siiProcesoSancIlegalidad.setSiiUsuarioConec(siiUsuario);
        }
        return siiProcesoSancIlegalidad;
    }

    public SiiCargaPoblacion convertir(CargaPoblacionVO cargaPoblacionVo) throws ExcepcionDAO {
            SiiCargaPoblacion siiCargaPoblacion = new SiiCargaPoblacion();

            if (cargaPoblacionVo != null) {
                if (cargaPoblacionVo.getCpoCodigo() != null && cargaPoblacionVo.getCpoCodigo() > 0) {
                    siiCargaPoblacion = cargaPoblacionDao.buscarPorCodigo(cargaPoblacionVo.getCpoCodigo());
                }
                siiCargaPoblacion.setCpoCodigo(cargaPoblacionVo.getCpoCodigo());
                siiCargaPoblacion.setCpoConsecutivoCar(cargaPoblacionVo.getCpoConsecutivoCar());
                siiCargaPoblacion.setCpoFechaRad(cargaPoblacionVo.getCpoFechaRad());
                siiCargaPoblacion.setCpoFechaRegistro(cargaPoblacionVo.getCpoFechaRegistro());
                siiCargaPoblacion.setCpoFuente(cargaPoblacionVo.getCpoFuente());
                siiCargaPoblacion.setCpoNumeroRad(cargaPoblacionVo.getCpoNumeroRad());
                
                //padres
                if (cargaPoblacionVo.getArchivoFisicoVo() != null) {
                    SiiArchivoFisico siiArchivoFisico =
                        archivoFisicoDao.buscarArchivoFisicoPorId(cargaPoblacionVo.getArchivoFisicoVo().getAfiCodigo());
                    siiCargaPoblacion.setSiiArchivoFisico(siiArchivoFisico);
                }
            }

            return (siiCargaPoblacion);
        }
    public SiiPoblacionEnte convertir(PoblacionEnteVO poblacionEnteVo) throws ExcepcionDAO {
            SiiPoblacionEnte siiPoblacionEnte = new SiiPoblacionEnte();

            if (poblacionEnteVo != null) {
                if (poblacionEnteVo.getPenCodigo() != null && poblacionEnteVo.getPenCodigo() > 0) {
                    siiPoblacionEnte = poblacionEnteDao.buscarPorCodigo(poblacionEnteVo.getPenCodigo());
                }
                
                siiPoblacionEnte.setPenCodigo(poblacionEnteVo.getPenCodigo());
                siiPoblacionEnte.setPenFechaFin(poblacionEnteVo.getPenFechaFin());
                siiPoblacionEnte.setPenFechaIni(poblacionEnteVo.getPenFechaIni());
                siiPoblacionEnte.setPenPoblacCabec(poblacionEnteVo.getPenPoblacCabec());
                siiPoblacionEnte.setPenPoblacResto(poblacionEnteVo.getPenPoblacResto());
                siiPoblacionEnte.setPenPoblacTotal(poblacionEnteVo.getPenPoblacTotal());
                
                if (poblacionEnteVo.getUsuarioConec()!=null && poblacionEnteVo.getUsuarioConec().getUsuCodigo()!=null) {
                    SiiUsuario siiUsuario = usuarioDao.buscarUsuarioXId(poblacionEnteVo.getUsuarioConec().getUsuCodigo());
                    siiPoblacionEnte.setSiiUsuarioConec(siiUsuario);
                }
                
            }

            return (siiPoblacionEnte);
        }
    
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param autoFormCargProIleVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiAutoFormCargProIle convertir (AutoFormCargProIleVO autoFormCargProIleVo) throws ExcepcionDAO 
    {
        SiiAutoFormCargProIle siiAutoFormCargProIle = new SiiAutoFormCargProIle();

        if (autoFormCargProIleVo != null) {
            if (autoFormCargProIleVo.getAfcCodigo() != null && autoFormCargProIleVo.getAfcCodigo() > 0) {
                siiAutoFormCargProIle = autoFormCargProIleDao.buscarPorCodigo(autoFormCargProIleVo.getAfcCodigo());
            }

            siiAutoFormCargProIle.setAfcCodigo(autoFormCargProIleVo.getAfcCodigo());
            siiAutoFormCargProIle.setAfcNumFechaRad(autoFormCargProIleVo.getAfcNumFechaRad());
            siiAutoFormCargProIle.setAfcNumRadicado(autoFormCargProIleVo.getAfcNumRadicado());
            siiAutoFormCargProIle.setAfcNumero(autoFormCargProIleVo.getAfcNumero());
            siiAutoFormCargProIle.setAfcFecha(autoFormCargProIleVo.getAfcFecha());
            siiAutoFormCargProIle.setAfcFechaNotifica(autoFormCargProIleVo.getAfcFechaNotifica());
            
            
            if (autoFormCargProIleVo.getUsuarioConecVo()!=null && autoFormCargProIleVo.getUsuarioConecVo().getUsuCodigo()!=null) {
                SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(autoFormCargProIleVo.getUsuarioConecVo().getUsuCodigo());
                siiAutoFormCargProIle.setSiiUsuarioConec(siiUsuario);
            }
            
            if (autoFormCargProIleVo.getProcesoSancIlegalidadVo()!=null && autoFormCargProIleVo.getProcesoSancIlegalidadVo().getPrsCodigo()!=null) {
                SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = procesoSancIlegalidadDao.buscarPorCodigo(autoFormCargProIleVo.getProcesoSancIlegalidadVo().getPrsCodigo());
                siiAutoFormCargProIle.setSiiProcesoSancIlegalidad(siiProcesoSancIlegalidad);
            }
        }

        return (siiAutoFormCargProIle);
    }
	
	    public SiiModifEstadoDocContab convertir(ModifEstadoDocContabVO modifEstadoDocContabVo) throws ExcepcionDAO {
            SiiModifEstadoDocContab siiModifEstadoDocContab = new SiiModifEstadoDocContab();

            if (modifEstadoDocContabVo != null) {
                if (modifEstadoDocContabVo.getMecCodigo() != null && modifEstadoDocContabVo.getMecCodigo()  > 0) {
                    siiModifEstadoDocContab = modifEstadoDocContabDao.buscarPorCodigoModifEstadoDocContab(modifEstadoDocContabVo.getMecCodigo());
                }
                
                siiModifEstadoDocContab.setMecCodigo(modifEstadoDocContabVo.getMecCodigo());
                siiModifEstadoDocContab.setMecFecha(modifEstadoDocContabVo.getMecFecha());               
                
                if (modifEstadoDocContabVo.getUsuarioConecVo()!=null && modifEstadoDocContabVo.getUsuarioConecVo().getUsuCodigo()!=null) {
                    SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(modifEstadoDocContabVo.getUsuarioConecVo().getUsuCodigo());
                    siiModifEstadoDocContab.setSiiUsuarioConec(siiUsuario);
                }
                
            }

            return (siiModifEstadoDocContab);
        }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tipoJuegoVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTipoJuego convertir (TipoJuegoVO tipoJuegoVo) throws ExcepcionDAO 
    {
        SiiTipoJuego siiTipoJuego = new SiiTipoJuego();

        if (tipoJuegoVo != null) {
            if (tipoJuegoVo.getTjuCodigo() != null && tipoJuegoVo.getTjuCodigo() > 0) {
                siiTipoJuego = tipoJuegoDao.buscarPorCodigo(tipoJuegoVo.getTjuCodigo());
            }

            siiTipoJuego.setTjuCodigo(tipoJuegoVo.getTjuCodigo());
            siiTipoJuego.setTjuNombre(tipoJuegoVo.getTjuNombre());
        }

        return (siiTipoJuego);
    }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param claseJuegoVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiClaseJuego convertir (ClaseJuegoVO claseJuegoVo) throws ExcepcionDAO 
    {
        SiiClaseJuego siiClaseJuego = new SiiClaseJuego();
        
        if (claseJuegoVo != null) {
            if (claseJuegoVo.getCjuCodigo() != null && claseJuegoVo.getCjuCodigo() > 0) {
                siiClaseJuego = claseJuegoDao.buscarPorCodigo(claseJuegoVo.getCjuCodigo());
            }
            
            siiClaseJuego.setCjuCodigo(claseJuegoVo.getCjuCodigo());
            siiClaseJuego.setCjuNombre(claseJuegoVo.getCjuNombre());
        }
        
        return (siiClaseJuego);
    }
    
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param elementoProcesoIleVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiElementoProcesoIle convertir (ElementoProcesoIleVO elementoProcesoIleVo) throws ExcepcionDAO {
        SiiElementoProcesoIle siiElementoProcesoIle = new SiiElementoProcesoIle();

        if (elementoProcesoIleVo.getEprCodigo() != null && elementoProcesoIleVo.getEprCodigo() > 0) {
            siiElementoProcesoIle = elementoProcesoIleDao.buscarPorCodigo(elementoProcesoIleVo.getEprCodigo());            
        }
        
        siiElementoProcesoIle.setEprCodigo(elementoProcesoIleVo.getEprCodigo());
        siiElementoProcesoIle.setEprActivo(elementoProcesoIleVo.getEprActivo());
        siiElementoProcesoIle.setEprNumElementos(elementoProcesoIleVo.getEprNumElementos());
        siiElementoProcesoIle.setEprValorSancion(elementoProcesoIleVo.getEprValorSancion());
        
        
        // Padres
        if (elementoProcesoIleVo.getProcesoSancIlegalidadVo() != null && elementoProcesoIleVo.getProcesoSancIlegalidadVo().getPrsCodigo() != null){
            SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = procesoSancIlegalidadDao.buscarPorCodigo(elementoProcesoIleVo.getProcesoSancIlegalidadVo().getPrsCodigo());
            siiElementoProcesoIle.setSiiProcesoSancIlegalidad(siiProcesoSancIlegalidad);
        }
        if (elementoProcesoIleVo.getClaseJuegoVo() != null && elementoProcesoIleVo.getClaseJuegoVo().getCjuCodigo() != null) {
            SiiClaseJuego siiClaseJuego = claseJuegoDao.buscarPorCodigo(elementoProcesoIleVo.getClaseJuegoVo().getCjuCodigo());
            siiElementoProcesoIle.setSiiClaseJuego(siiClaseJuego);
        }
        if (elementoProcesoIleVo.getTipoInstrumentoVo() != null && elementoProcesoIleVo.getTipoInstrumentoVo().getTinCodigo() != null) {
            SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(elementoProcesoIleVo.getTipoInstrumentoVo().getTinCodigo());
            siiElementoProcesoIle.setSiiTipoInstrumento(siiTipoInstrumento);
        }
        if (elementoProcesoIleVo.getUsuarioConecVo() != null && elementoProcesoIleVo.getUsuarioConecVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(elementoProcesoIleVo.getUsuarioConecVo().getUsuCodigo());
            siiElementoProcesoIle.setSiiUsuarioConec(siiUsuario);
        }
        
        return (siiElementoProcesoIle);
    }
    
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tarifaIlegalidadVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTarifaIlegalidad convertir (TarifaIlegalidadVO tarifaIlegalidadVo) throws ExcepcionDAO {
        SiiTarifaIlegalidad siiTarifaIlegalidad = new SiiTarifaIlegalidad();

        if (tarifaIlegalidadVo.getTleCodigo() != null && tarifaIlegalidadVo.getTleCodigo() > 0) {
            siiTarifaIlegalidad = tarifaIlegalidadDao.buscarPorCodigo(tarifaIlegalidadVo.getTleCodigo());            
        }
        
        siiTarifaIlegalidad.setTleCodigo(tarifaIlegalidadVo.getTleCodigo());
        siiTarifaIlegalidad.setTleHabitDesde(tarifaIlegalidadVo.getTleHabitDesde());
        siiTarifaIlegalidad.setTleHabitHasta(tarifaIlegalidadVo.getTleHabitHasta());
        siiTarifaIlegalidad.setTleMinSillas(tarifaIlegalidadVo.getTleMinSillas());
        siiTarifaIlegalidad.setTleSmmlvUni(tarifaIlegalidadVo.getTleSmmlvUni());
        siiTarifaIlegalidad.setTleUnidad(tarifaIlegalidadVo.getTleUnidad());
        
        
        // Padres
        if (tarifaIlegalidadVo.getClaseJuegoVo() != null && tarifaIlegalidadVo.getClaseJuegoVo().getCjuCodigo() != null) {
            SiiClaseJuego siiClaseJuego = claseJuegoDao.buscarPorCodigo(tarifaIlegalidadVo.getClaseJuegoVo().getCjuCodigo());
            siiTarifaIlegalidad.setSiiClaseJuego(siiClaseJuego);
        }
        if (tarifaIlegalidadVo.getTipoInstrumentoVo() != null && tarifaIlegalidadVo.getTipoInstrumentoVo().getTinCodigo() != null) {
            SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(tarifaIlegalidadVo.getTipoInstrumentoVo().getTinCodigo());
            siiTarifaIlegalidad.setSiiTipoInstrumento(siiTipoInstrumento);
        }
        
        return (siiTarifaIlegalidad);
    }

    public SiiTramiteResolProIle convertir(TramiteResolProIleVO tramiteVo) throws ExcepcionDAO {
        SiiTramiteResolProIle  tramite = new SiiTramiteResolProIle();
        
        if (tramiteVo.getTpiCodigo() != null && tramiteVo.getTpiCodigo() > 0) {
            tramite = tramiteResolProIleDao.buscarPorCodigo(tramiteVo.getTpiCodigo());
        }
        tramite.setTpiFecha(tramiteVo.getTpiFecha());
        //Padres:
        if (tramiteVo.getEstadoTramResProcIlegVo() != null && tramiteVo.getEstadoTramResProcIlegVo().getEtrCodigo() != null) {
            tramite.setSiiEstadoTramResProcIleg(estadoTramResProcDao.buscarPorCodigo(tramiteVo.getEstadoTramResProcIlegVo().getEtrCodigo()));
        }
        if (tramiteVo.getResolucionProcIlegVo()!= null  && tramiteVo.getResolucionProcIlegVo().getRpiCodigo() != null) {
            tramite.setSiiResolucionProcIleg(resolucionProcIlegDao.buscarPorCodigo(tramiteVo.getResolucionProcIlegVo().getRpiCodigo()));
        }
        if (tramiteVo.getUsuarioConecVo() != null && tramiteVo.getUsuarioConecVo().getUsuCodigo()!= null) {
            tramite.setSiiUsuarioConec(usuarioDao.buscarUsuarioPorId(tramiteVo.getUsuarioConecVo().getUsuCodigo()));
        }
        
        return tramite;
    }

    public SiiResolucionProcIleg convertir(ResolucionProcIlegVO resolucionVo) throws ExcepcionDAO {
        SiiResolucionProcIleg resolucion = new SiiResolucionProcIleg();
        if (resolucionVo.getRpiCodigo() != null && resolucionVo.getRpiCodigo()>0) {
            resolucion = resolucionProcIlegDao.buscarPorCodigo(resolucionVo.getRpiCodigo());            
        }
        resolucion.setRpiComunFiscalia(resolucionVo.getRpiComunFiscalia());
        resolucion.setRpiFechaGenera(resolucionVo.getRpiFechaGenera());
        resolucion.setRpiFechaRadicSol(resolucionVo.getRpiFechaRadicSol());
        resolucion.setRpiFechaResol(resolucionVo.getRpiFechaResol());
        resolucion.setRpiNumeroRadicSol(resolucionVo.getRpiNumeroRadicSol());
        resolucion.setRpiNumeroResol(resolucionVo.getRpiNumeroResol());
        resolucion.setRpiPresQueja(resolucionVo.getRpiPresQueja());
        resolucion.setRpiTipoResol(resolucionVo.getRpiTipoResol());
        resolucion.setRpiFechaNotificacion(resolucionVo.getRpiFechaNotificacion());
        
        //Padres;
        if (resolucionVo.getUsuarioConecVo()!=null && resolucionVo.getUsuarioConecVo().getUsuCodigo()!=null){
            resolucion.setSiiUsuarioConec(usuarioDao.buscarUsuarioPorId(resolucionVo.getUsuarioConecVo().getUsuCodigo()));
        }
        return resolucion;
    }
    
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param personaInvProIleAutoVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiPersonaInvProIleAuto convertir (PersonaInvProIleAutoVO personaInvProIleAutoVo) throws ExcepcionDAO 
    {
        SiiPersonaInvProIleAuto siiPersonaInvProIleAuto = new SiiPersonaInvProIleAuto();

        if (personaInvProIleAutoVo.getPiaCodigo() != null && personaInvProIleAutoVo.getPiaCodigo() > 0) {
            siiPersonaInvProIleAuto = personaInvProIleAutoDao.buscarPorCodigo(personaInvProIleAutoVo.getPiaCodigo());            
        }
        
        siiPersonaInvProIleAuto.setPiaCodigo(personaInvProIleAutoVo.getPiaCodigo());
        siiPersonaInvProIleAuto.setPiaComFechaFinP(personaInvProIleAutoVo.getPiaComFechaFinP());
        siiPersonaInvProIleAuto.setPiaComFechaIniP(personaInvProIleAutoVo.getPiaComFechaIniP());
        siiPersonaInvProIleAuto.setPiaComFechaRad(personaInvProIleAutoVo.getPiaComFechaRad());
        siiPersonaInvProIleAuto.setPiaComRadicado(personaInvProIleAutoVo.getPiaComRadicado());
        siiPersonaInvProIleAuto.setPiaNumFechaRad(personaInvProIleAutoVo.getPiaNumFechaRad());
        siiPersonaInvProIleAuto.setPiaNumRadicado(personaInvProIleAutoVo.getPiaNumRadicado());
        
        
        // Padres
        if (personaInvProIleAutoVo.getAutoFormCargProIleVo() != null && personaInvProIleAutoVo.getAutoFormCargProIleVo().getAfcCodigo() != null) {
            SiiAutoFormCargProIle siiAutoFormCargProIle = autoFormCargProIleDao.buscarPorCodigo(personaInvProIleAutoVo.getAutoFormCargProIleVo().getAfcCodigo());
            siiPersonaInvProIleAuto.setSiiAutoFormCargProIle(siiAutoFormCargProIle);
        }
        if (personaInvProIleAutoVo.getPersonaInvestProIleVo() != null && personaInvProIleAutoVo.getPersonaInvestProIleVo().getPipCodigo() != null) {
            SiiPersonaInvestProIle siiPersonaInvestProIle = personaInvestProIleDao.buscarPorCodigo(personaInvProIleAutoVo.getPersonaInvestProIleVo().getPipCodigo());
            siiPersonaInvProIleAuto.setSiiPersonaInvestProIle(siiPersonaInvestProIle);
        }
        if (personaInvProIleAutoVo.getUsuarioConecVo() != null && personaInvProIleAutoVo.getUsuarioConecVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuarioConec = usuarioDao.buscarUsuarioPorId(personaInvProIleAutoVo.getUsuarioConecVo().getUsuCodigo());
            siiPersonaInvProIleAuto.setSiiUsuarioConec(siiUsuarioConec);
        }
        
        return (siiPersonaInvProIleAuto);
    }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tramiteAutoForCarIleVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTramiteAutoForCarIle convertir (TramiteAutoForCarIleVO tramiteAutoForCarIleVo) throws ExcepcionDAO 
    {
        SiiTramiteAutoForCarIle siiTramiteAutoForCarIle = new SiiTramiteAutoForCarIle();

        if (tramiteAutoForCarIleVo.getTafCodigo() != null && tramiteAutoForCarIleVo.getTafCodigo() > 0) {
            siiTramiteAutoForCarIle = tramiteAutoForCarIleDao.buscarPorCodigo(tramiteAutoForCarIleVo.getTafCodigo());            
        }
        
        siiTramiteAutoForCarIle.setTafCodigo(tramiteAutoForCarIleVo.getTafCodigo());
        siiTramiteAutoForCarIle.setTafFecha(tramiteAutoForCarIleVo.getTafFecha());
        siiTramiteAutoForCarIle.setTafPaso(tramiteAutoForCarIleVo.getTafPaso());
        
        
        // Padres
        if (tramiteAutoForCarIleVo.getAutoFormCargProIleVo() != null && tramiteAutoForCarIleVo.getAutoFormCargProIleVo().getAfcCodigo() != null) {
            SiiAutoFormCargProIle siiAutoFormCargProIle = autoFormCargProIleDao.buscarPorCodigo(tramiteAutoForCarIleVo.getAutoFormCargProIleVo().getAfcCodigo());
            siiTramiteAutoForCarIle.setSiiAutoFormCargProIle(siiAutoFormCargProIle);
        }
        if (tramiteAutoForCarIleVo.getUsuarioConecVo() != null && tramiteAutoForCarIleVo.getUsuarioConecVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuarioConec = usuarioDao.buscarUsuarioPorId(tramiteAutoForCarIleVo.getUsuarioConecVo().getUsuCodigo());
            siiTramiteAutoForCarIle.setSiiUsuarioConec(siiUsuarioConec);
        }
        
        return (siiTramiteAutoForCarIle);
    }
    
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param descargoProcIlegVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiDescargoProcIleg convertir (DescargoProcIlegVO descargoProcIlegVo) throws ExcepcionDAO 
    {
        SiiDescargoProcIleg siiDescargoProcIleg = new SiiDescargoProcIleg();

        if (descargoProcIlegVo.getDprCodigo() != null && descargoProcIlegVo.getDprCodigo() > 0) {
            siiDescargoProcIleg = descargoProcIlegDao.buscarPorCodigo(descargoProcIlegVo.getDprCodigo());            
        }
        
        siiDescargoProcIleg.setDprCodigo(descargoProcIlegVo.getDprCodigo());
        siiDescargoProcIleg.setDprFechaRadic(descargoProcIlegVo.getDprFechaRadic());
        siiDescargoProcIleg.setDprRadicado(descargoProcIlegVo.getDprRadicado());
        siiDescargoProcIleg.setDprSolicitaPrue(descargoProcIlegVo.getDprSolicitaPrue());
        siiDescargoProcIleg.setDprObservaciones(descargoProcIlegVo.getDprObservaciones());
        
        
        // Padres
        if (descargoProcIlegVo.getProcesoSancIlegalidadVo() != null && descargoProcIlegVo.getProcesoSancIlegalidadVo().getPrsCodigo() != null) {
            SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = procesoSancIlegalidadDao.buscarPorCodigo(descargoProcIlegVo.getProcesoSancIlegalidadVo().getPrsCodigo());
            siiDescargoProcIleg.setSiiProcesoSancIlegalidad(siiProcesoSancIlegalidad);
        }
        if (descargoProcIlegVo.getUsuarioVo() != null && descargoProcIlegVo.getUsuarioVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(descargoProcIlegVo.getUsuarioVo().getUsuCodigo());
            siiDescargoProcIleg.setSiiUsuario(siiUsuario);
        }
        
        return (siiDescargoProcIleg);
    }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param pruebaDescargoProIleVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiPruebaDescargoProIle convertir (PruebaDescargoProIleVO pruebaDescargoProIleVo) throws ExcepcionDAO 
    {
        SiiPruebaDescargoProIle siiPruebaDescargoProIle = new SiiPruebaDescargoProIle();

        if (pruebaDescargoProIleVo.getPdpCodigo() != null && pruebaDescargoProIleVo.getPdpCodigo() > 0) {
            siiPruebaDescargoProIle = pruebaDescargoProIleDao.buscarPorCodigo(pruebaDescargoProIleVo.getPdpCodigo());            
        }
        
        siiPruebaDescargoProIle.setPdpCodigo(pruebaDescargoProIleVo.getPdpCodigo());
        
        
        // Padres
        if (pruebaDescargoProIleVo.getDescargoProcIlegVo() != null && pruebaDescargoProIleVo.getDescargoProcIlegVo().getDprCodigo() != null) {
            SiiDescargoProcIleg siiDescargoProcIleg = descargoProcIlegDao.buscarPorCodigo(pruebaDescargoProIleVo.getDescargoProcIlegVo().getDprCodigo());
            siiPruebaDescargoProIle.setSiiDescargoProcIleg(siiDescargoProcIleg);
        }
        if (pruebaDescargoProIleVo.getTipoPruebaIlegVo() != null && pruebaDescargoProIleVo.getTipoPruebaIlegVo().getTpiCodigo() != null) {
            SiiTipoPruebaIleg siiTipoPruebaIleg = tipoPruebaIlegDao.buscarPorCodigo(pruebaDescargoProIleVo.getTipoPruebaIlegVo().getTpiCodigo());
            siiPruebaDescargoProIle.setSiiTipoPruebaIleg(siiTipoPruebaIleg);
        }
        if (pruebaDescargoProIleVo.getUsuarioConecVo() != null && pruebaDescargoProIleVo.getUsuarioConecVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuarioConec = usuarioDao.buscarUsuarioPorId(pruebaDescargoProIleVo.getUsuarioConecVo().getUsuCodigo());
            siiPruebaDescargoProIle.setSiiUsuarioConec(siiUsuarioConec);
        }
        
        return (siiPruebaDescargoProIle);
    }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param autoDecretaPrueProIleVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiAutoDecretaPrueProIle convertir (AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) throws ExcepcionDAO 
    {
        SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle = new SiiAutoDecretaPrueProIle();

        if (autoDecretaPrueProIleVo.getAtpCodigo() != null && autoDecretaPrueProIleVo.getAtpCodigo() > 0) {
            siiAutoDecretaPrueProIle = autoDecretaPrueProIleDao.buscarPorCodigo(autoDecretaPrueProIleVo.getAtpCodigo());            
        }
        
        siiAutoDecretaPrueProIle.setAtpCodigo(autoDecretaPrueProIleVo.getAtpCodigo());
        siiAutoDecretaPrueProIle.setAtpDecretaPru(autoDecretaPrueProIleVo.getAtpDecretaPru());
        siiAutoDecretaPrueProIle.setAtpDias(autoDecretaPrueProIleVo.getAtpDias());
        siiAutoDecretaPrueProIle.setAtpTipoAuto(autoDecretaPrueProIleVo.getAtpTipoAuto());
        siiAutoDecretaPrueProIle.setAtpFecha(autoDecretaPrueProIleVo.getAtpFecha());
        siiAutoDecretaPrueProIle.setAtpFechaRad(autoDecretaPrueProIleVo.getAtpFechaRad());
        siiAutoDecretaPrueProIle.setAtpNumero(autoDecretaPrueProIleVo.getAtpNumero());
        siiAutoDecretaPrueProIle.setAtpRadicado(autoDecretaPrueProIleVo.getAtpRadicado());
        
        
        // Padres
        if (autoDecretaPrueProIleVo.getProcesoSancIlegalidadVo() != null && autoDecretaPrueProIleVo.getProcesoSancIlegalidadVo().getPrsCodigo() != null) {
            SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = procesoSancIlegalidadDao.buscarPorCodigo(autoDecretaPrueProIleVo.getProcesoSancIlegalidadVo().getPrsCodigo());
            siiAutoDecretaPrueProIle.setSiiProcesoSancIlegalidad(siiProcesoSancIlegalidad);
        }
        if (autoDecretaPrueProIleVo.getUsuarioConecVo() != null && autoDecretaPrueProIleVo.getUsuarioConecVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuarioConec = usuarioDao.buscarUsuarioPorId(autoDecretaPrueProIleVo.getUsuarioConecVo().getUsuCodigo());
            siiAutoDecretaPrueProIle.setSiiUsuarioConec(siiUsuarioConec);
        }
        
        return (siiAutoDecretaPrueProIle);
    }
    
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param perInvesProIleAutoPruVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiPerInvesProIleAutoPru convertir (PerInvesProIleAutoPruVO perInvesProIleAutoPruVo) throws ExcepcionDAO 
    {
        SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru = new SiiPerInvesProIleAutoPru();

        if (perInvesProIleAutoPruVo.getPauCodigo() != null && perInvesProIleAutoPruVo.getPauCodigo() > 0) {
            siiPerInvesProIleAutoPru = perInvesProIleAutoPruDao.buscarPorCodigo(perInvesProIleAutoPruVo.getPauCodigo());            
        }
        
        siiPerInvesProIleAutoPru.setPauCodigo(perInvesProIleAutoPruVo.getPauCodigo());
        siiPerInvesProIleAutoPru.setPauFechaFinPubl(perInvesProIleAutoPruVo.getPauFechaFinPubl());
        siiPerInvesProIleAutoPru.setPauFechaIniPubl(perInvesProIleAutoPruVo.getPauFechaIniPubl());
        siiPerInvesProIleAutoPru.setPauFechaRadic(perInvesProIleAutoPruVo.getPauFechaRadic());
        siiPerInvesProIleAutoPru.setPauRadicado(perInvesProIleAutoPruVo.getPauRadicado());
        
        
        // Padres
        if (perInvesProIleAutoPruVo.getAutoDecretaPrueProIleVo()!=null && perInvesProIleAutoPruVo.getAutoDecretaPrueProIleVo().getAtpCodigo() != null) {
            SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle = autoDecretaPrueProIleDao.buscarPorCodigo(perInvesProIleAutoPruVo.getAutoDecretaPrueProIleVo().getAtpCodigo());
            siiPerInvesProIleAutoPru.setSiiAutoDecretaPrueProIle(siiAutoDecretaPrueProIle);
        }
        if (perInvesProIleAutoPruVo.getPersonaInvestProIleVo()!=null && perInvesProIleAutoPruVo.getPersonaInvestProIleVo().getPipCodigo() != null) {
            SiiPersonaInvestProIle siiPersonaInvestProIle = personaInvestProIleDao.buscarPorCodigo(perInvesProIleAutoPruVo.getPersonaInvestProIleVo().getPipCodigo());
            siiPerInvesProIleAutoPru.setSiiPersonaInvestProIle(siiPersonaInvestProIle);
        }
        if (perInvesProIleAutoPruVo.getUsuarioConecVo() != null && perInvesProIleAutoPruVo.getUsuarioConecVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuarioConec = usuarioDao.buscarUsuarioPorId(perInvesProIleAutoPruVo.getUsuarioConecVo().getUsuCodigo());
            siiPerInvesProIleAutoPru.setSiiUsuarioConec(siiUsuarioConec);
        }
        
        return (siiPerInvesProIleAutoPru);
    }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param pruebaAutoDecrPruVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiPruebaAutoDecrPru convertir (PruebaAutoDecrPruVO pruebaAutoDecrPruVo) throws ExcepcionDAO 
    {
        SiiPruebaAutoDecrPru siiPruebaAutoDecrPru = new SiiPruebaAutoDecrPru();

        if (pruebaAutoDecrPruVo.getPapCodigo() != null && pruebaAutoDecrPruVo.getPapCodigo() > 0) {
            siiPruebaAutoDecrPru = pruebaAutoDecrPruDao.buscarPorCodigo(pruebaAutoDecrPruVo.getPapCodigo());            
        }
        
        siiPruebaAutoDecrPru.setPapCodigo(pruebaAutoDecrPruVo.getPapCodigo());
        
        
        // Padres
        if (pruebaAutoDecrPruVo.getAutoDecretaPrueProIleVo()!=null && pruebaAutoDecrPruVo.getAutoDecretaPrueProIleVo().getAtpCodigo() != null) {
            SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle = autoDecretaPrueProIleDao.buscarPorCodigo(pruebaAutoDecrPruVo.getAutoDecretaPrueProIleVo().getAtpCodigo());
            siiPruebaAutoDecrPru.setSiiAutoDecretaPrueProIle(siiAutoDecretaPrueProIle);
        }
        if (pruebaAutoDecrPruVo.getTipoPruebaIlegVo()!=null && pruebaAutoDecrPruVo.getTipoPruebaIlegVo().getTpiCodigo() != null) {
            SiiTipoPruebaIleg siiTipoPruebaIleg = tipoPruebaIlegDao.buscarPorCodigo(pruebaAutoDecrPruVo.getTipoPruebaIlegVo().getTpiCodigo());
            siiPruebaAutoDecrPru.setSiiTipoPruebaIleg(siiTipoPruebaIleg);
        }
        if (pruebaAutoDecrPruVo.getUsuarioConecVo() != null && pruebaAutoDecrPruVo.getUsuarioConecVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuarioConec = usuarioDao.buscarUsuarioPorId(pruebaAutoDecrPruVo.getUsuarioConecVo().getUsuCodigo());
            siiPruebaAutoDecrPru.setSiiUsuarioConec(siiUsuarioConec);
        }
        
        return (siiPruebaAutoDecrPru);
    }
    
    
    /**
     * Realiza la conversi&oacute;n del Value Object a Entity.
     * @param tramiteAutoPrueTrasVo - Value Object
     * @return Entity class
     * @throws ExcepcionDAO
     */
    public SiiTramiteAutoPrueTras convertir (TramiteAutoPrueTrasVO tramiteAutoPrueTrasVo) throws ExcepcionDAO 
    {
        SiiTramiteAutoPrueTras siiTramiteAutoPrueTras = new SiiTramiteAutoPrueTras();

        if (tramiteAutoPrueTrasVo.getTraCodigo() != null && tramiteAutoPrueTrasVo.getTraCodigo() > 0) {
            siiTramiteAutoPrueTras = tramiteAutoPrueTrasDao.buscarPorCodigo(tramiteAutoPrueTrasVo.getTraCodigo());            
        }
        
        siiTramiteAutoPrueTras.setTraCodigo(tramiteAutoPrueTrasVo.getTraCodigo());
        siiTramiteAutoPrueTras.setTraFecha(tramiteAutoPrueTrasVo.getTraFecha());
        siiTramiteAutoPrueTras.setTraPaso(tramiteAutoPrueTrasVo.getTraPaso());
        
        
        // Padres
        if (tramiteAutoPrueTrasVo.getAutoDecretaPrueProIleVo()!=null && tramiteAutoPrueTrasVo.getAutoDecretaPrueProIleVo().getAtpCodigo() != null) {
            SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle = autoDecretaPrueProIleDao.buscarPorCodigo(tramiteAutoPrueTrasVo.getAutoDecretaPrueProIleVo().getAtpCodigo());
            siiTramiteAutoPrueTras.setSiiAutoDecretaPrueProIle(siiAutoDecretaPrueProIle);
        }
        if (tramiteAutoPrueTrasVo.getUsuarioConecVo() != null && tramiteAutoPrueTrasVo.getUsuarioConecVo().getUsuCodigo() != null) {
            SiiUsuario siiUsuarioConec = usuarioDao.buscarUsuarioPorId(tramiteAutoPrueTrasVo.getUsuarioConecVo().getUsuCodigo());
            siiTramiteAutoPrueTras.setSiiUsuarioConec(siiUsuarioConec);
        }
        
        return (siiTramiteAutoPrueTras);
    }
    
    /**
        * Convertir el value object ComunicacSujSancIleVO en su respectiva entidad
        * @param comunicacSujSancIleVo
        * @return siiComunicacSujSancIle - Entity SiiComunicacSujSancIle
        * @throws ExcepcionDAO
        */
       
       public SiiComunicacSujSancIle convertir(ComunicacSujSancIleVO comunicacSujSancIleVo) throws ExcepcionDAO {
           SiiComunicacSujSancIle siiComunicacSujSancIle = new SiiComunicacSujSancIle();

           if(comunicacSujSancIleVo != null) {
               if(comunicacSujSancIleVo.getCssCodigo() != null && comunicacSujSancIleVo.getCssCodigo() > 0) {
                   siiComunicacSujSancIle = comunicacSujSancIleDao.buscarPorCodigo(comunicacSujSancIleVo.getCssCodigo());
               }

               siiComunicacSujSancIle.setCssActivo(comunicacSujSancIleVo.getCssActivo());
               siiComunicacSujSancIle.setCssCodigo(comunicacSujSancIleVo.getCssCodigo());
               siiComunicacSujSancIle.setCssFechaRad(comunicacSujSancIleVo.getCssFechaRad());
               siiComunicacSujSancIle.setCssRadicado(comunicacSujSancIleVo.getCssRadicado());

               if(comunicacSujSancIleVo.getProcesoSancIlegalidadVo() != null && comunicacSujSancIleVo.getProcesoSancIlegalidadVo().getPrsCodigo() != null) {
                   SiiProcesoSancIlegalidad siiProcesoSancIlegalidad = procesoSancIlegalidadDao.buscarPorCodigo(comunicacSujSancIleVo.getProcesoSancIlegalidadVo().getPrsCodigo());
                   siiComunicacSujSancIle.setSiiProcesoSancIlegalidad(siiProcesoSancIlegalidad);
               }
               
               if(comunicacSujSancIleVo.getUsuarioConecVo() != null && comunicacSujSancIleVo.getUsuarioConecVo().getUsuCodigo() != null) {
                   SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(comunicacSujSancIleVo.getUsuarioConecVo().getUsuCodigo());
                   siiComunicacSujSancIle.setSiiUsuarioConec(siiUsuario);
               }

           }

           return (siiComunicacSujSancIle);
       }
    
    public SiiTipoApuestPolizaRenovac convertir(TipoApuestPolizaRenovacVO tipoApuestPolizaRenovacVo) throws ExcepcionDAO {
        SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac = new SiiTipoApuestPolizaRenovac();
        if(tipoApuestPolizaRenovacVo != null){
            if(tipoApuestPolizaRenovacVo.getTalCodigo() != null && tipoApuestPolizaRenovacVo.getTalCodigo() > 0){
                siiTipoApuestPolizaRenovac = tipoApuestPolizaRenovacDao.buscarPorCodigo(tipoApuestPolizaRenovacVo.getTalCodigo());
            }
            
            siiTipoApuestPolizaRenovac.setTalDuracion(tipoApuestPolizaRenovacVo.getTalDuracion());
            siiTipoApuestPolizaRenovac.setTalNumeroElem(tipoApuestPolizaRenovacVo.getTalNumeroElem());
            siiTipoApuestPolizaRenovac.setTalValorDe(tipoApuestPolizaRenovacVo.getTalValorDe());
            siiTipoApuestPolizaRenovac.setTalValorGa(tipoApuestPolizaRenovacVo.getTalValorGa());
            siiTipoApuestPolizaRenovac.setTalValorUnitario(tipoApuestPolizaRenovacVo.getTalValorUnitario());
            
            if(tipoApuestPolizaRenovacVo.getPolizaContratVo() != null && tipoApuestPolizaRenovacVo.getPolizaContratVo().getPccCodigo() != null){
                SiiPolizaContrat siiPolizaContrat = polizaContratDao.buscarPolizaContratPorCodigo(tipoApuestPolizaRenovacVo.getPolizaContratVo().getPccCodigo());
                siiTipoApuestPolizaRenovac.setSiiPolizaContrat(siiPolizaContrat);
            }
            
            if(tipoApuestPolizaRenovacVo.getTipoApuestaVo() != null && tipoApuestPolizaRenovacVo.getTipoApuestaVo().getTapCodigo() != null){
                SiiTipoApuesta siiTipoApuesta = tipoApuestaDao.buscarTipoApuestaPorCodigo(tipoApuestPolizaRenovacVo.getTipoApuestaVo().getTapCodigo());
                siiTipoApuestPolizaRenovac.setSiiTipoApuesta(siiTipoApuesta);
            }
            
            if(tipoApuestPolizaRenovacVo.getUsuarioConecVo() != null && tipoApuestPolizaRenovacVo.getUsuarioConecVo().getUsuCodigo() != null){
                SiiUsuario siiUsuarioConec = usuarioDao.buscarUsuarioPorId(tipoApuestPolizaRenovacVo.getUsuarioConecVo().getUsuCodigo());
                siiTipoApuestPolizaRenovac.setSiiUsuarioConec(siiUsuarioConec);
            }
        }
        
        return siiTipoApuestPolizaRenovac;
    }
}


