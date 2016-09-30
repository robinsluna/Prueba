package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantPolizaOficLiqDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficLiqTipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioLiquidacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantPolizaOficLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficLiqTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;
import co.gov.coljuegos.siicol.ejb.vo.GarantPolizaOficLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.OfiLiquidacionSolAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficLiqTipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;

import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminOficioLiquidacionBean implements AdminOficioLiquidacion {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private OficioLiquidacionDAO oficioLiquidacionDAO;
    @EJB
    private SolicitudAutorizaDAO solicitudAutorizaDao;
    @EJB
    private GarantPolizaOficLiqDAO garantPolizaOficLiqDao;
    @EJB
    private OficLiqTipoApuestaDAO oficLiqTipoApuestaDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private InventarioDAO inventarioDao;
    
    @EJB
    private TipoApuestaDAO tipoApuestaDao;
    
   
    public AdminOficioLiquidacionBean() {
    }

    public OficioLiquidacionVO insertarSiiOficioLiquidacion(OficioLiquidacionVO oficioLiquidacionVo,
                                                            SolicitudAutorizaVO solAutoriza,
                                                            List<GarantPolizaOficLiqVO> garPolizaOfic,
                                                            List<OficLiqTipoApuestaVO> listOficLiqTa) throws ExcepcionDAO {

        // Se actualiza el estado de la solicitud
        SiiSolicitudAutoriza resultadoSiiSolicitudAutoriza =
            solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solAutoriza));

        // Se registra el oficio de liquidación
        SiiOficioLiquidacion oficio = conversionVoEntidad.convertir(oficioLiquidacionVo);
        oficio.setSiiSolicitudAutoriza(resultadoSiiSolicitudAutoriza);

        // Se consulta el consecutivo actual
        Long consecutivo = new Long(0);
        consecutivo = oficioLiquidacionDAO.buscarConsecutivoOficio();
        consecutivo++;
        oficio.setOliConsecutivo(consecutivo.intValue());

        SiiOficioLiquidacion resultadoOficio = oficioLiquidacionDAO.insertarSiiOficioLiquidacion(oficio);

        // Se registran los amparo-poliza
        for (GarantPolizaOficLiqVO unaGarantia : garPolizaOfic) {
            SiiGarantPolizaOficLiq siiGarantPolizaOficLiq = conversionVoEntidad.convertir(unaGarantia);
            siiGarantPolizaOficLiq.setSiiOficioLiquidacion(resultadoOficio);
            SiiGarantPolizaOficLiq resultadoSiiGarantPolizaOficLiq =
                garantPolizaOficLiqDao.insertarSiiGarantPolizaOficLiq(siiGarantPolizaOficLiq);
        }
        for (OficLiqTipoApuestaVO unOficLiTq : listOficLiqTa) {
            SiiOficLiqTipoApuesta siiOficLiqTipoApuesta = conversionVoEntidad.convertir(unOficLiTq);
            siiOficLiqTipoApuesta.setSiiOficioLiquidacion(resultadoOficio);
            SiiOficLiqTipoApuesta resultadoSiiOficLiqTipoApuesta =
                oficLiqTipoApuestaDao.insertarSiiOficLiqTipoApuesta(siiOficLiqTipoApuesta);
        }

        return new OficioLiquidacionVO(resultadoOficio);
    }

    /**
     * @auhtor Modifica Giovanni
     * @param oficioLiquidacionVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public OficioLiquidacionVO actualizarSiiOficioLiquidacion(OficioLiquidacionVO oficioLiquidacionVO,
                                                              UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiOficioLiquidacion siiOficioLiquidacion = new SiiOficioLiquidacion();
        siiOficioLiquidacion =
            oficioLiquidacionDAO.buscarPorCodigoOficioLiquidacion(oficioLiquidacionVO.getOliCodigo());
        if (siiOficioLiquidacion.getSiiEstadoOficioLiq().getEolCodigo() != oficioLiquidacionVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de oficio liquidacion fue cambiado durante la modificación. Seleccione nuevamente el oficio Liquidacion");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (oficioLiquidacionVO.getEstadoOficioLiqVo().getEolCodigo() != oficioLiquidacionVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.OFICIO_LIQUIDACION.getId(),
                                                         oficioLiquidacionVO.getEstadoOficioLiqVo().getEolCodigo(),
                                                         usuarioLogueado, oficioLiquidacionVO.getOliCodigo());
        }

        SiiOficioLiquidacion oficio =
            oficioLiquidacionDAO.actualizarSiiOficioLiquidacion(conversionVoEntidad.convertir(oficioLiquidacionVO));

        return new OficioLiquidacionVO(oficio);
    }

    public void borrarSiiOficioLiquidacion(Long idOficioLiquidacion) throws ExcepcionDAO {
        oficioLiquidacionDAO.borrarSiiOficioLiquidacion(idOficioLiquidacion);
    }

    public List<OficioLiquidacionVO> buscarTodoSiiOficioLiquidacion() throws ExcepcionDAO {
        List<SiiOficioLiquidacion> miListSiiOficioLiquidacion = oficioLiquidacionDAO.buscarTodoSiiOficioLiquidacion();
        List<OficioLiquidacionVO> miListOficioLiquidacionVO = new ArrayList<OficioLiquidacionVO>();
        if (miListSiiOficioLiquidacion != null) {
            for (SiiOficioLiquidacion siiAd : miListSiiOficioLiquidacion) {
                OficioLiquidacionVO miOficioLiquidacionVo = new OficioLiquidacionVO(siiAd);
                miListOficioLiquidacionVO.add(miOficioLiquidacionVo);
            }
        }

        return (miListOficioLiquidacionVO);
    }

    public List<OficioLiquidacionVO> buscarOficioLiquidacionPorSolicitudAutorizacion(Long sauCodigo) throws ExcepcionDAO {
        List<SiiOficioLiquidacion> miListSiiOficioLiquidacion =
            oficioLiquidacionDAO.buscarOficioLiquidacionPorSolicitudAutorizacion(sauCodigo);
        List<OficioLiquidacionVO> miListOficioLiquidacionVO = new ArrayList<OficioLiquidacionVO>();
        if (miListSiiOficioLiquidacion != null) {
            for (SiiOficioLiquidacion siiAd : miListSiiOficioLiquidacion) {
                OficioLiquidacionVO miOficioLiquidacionVo = new OficioLiquidacionVO(siiAd);
                miListOficioLiquidacionVO.add(miOficioLiquidacionVo);
            }
        }

        return (miListOficioLiquidacionVO);
    }


    public List<OfiLiquidacionSolAutorizaVO> buscarTodosOficioLiquidacion(UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        List<OfiLiquidacionSolAutorizaVO> miListOfiLiquidacionSolAutorizaVO =
            oficioLiquidacionDAO.buscarTodosOficioLiquidacion(usuarioLogueado);
        return miListOfiLiquidacionSolAutorizaVO;
    }

    public OficioLiquidacionVO buscarPorCodigoOficioLiquidacion(Long idOficioLiquidacion) throws ExcepcionDAO {
        SiiOficioLiquidacion miSiiOficioLiquidacion =
            oficioLiquidacionDAO.buscarPorCodigoOficioLiquidacion(idOficioLiquidacion);
        return new OficioLiquidacionVO(miSiiOficioLiquidacion);

    }

    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionPorSolicitud(Long idSolicitud) throws ExcepcionDAO {
        List<OficioLiquidacionPrevioVO> miListaOficiosPrevios =
            oficioLiquidacionDAO.calcularOficioLiquidacionPorSolicitud(idSolicitud);
        return miListaOficiosPrevios;
    }

    public List<OficioLiquidacionPrevioVO> buscarOficiosLiquidacionPorCodigo(Long idOficio) throws ExcepcionDAO {
        List<OficioLiquidacionPrevioVO> miListaOficios =
            oficioLiquidacionDAO.buscarOficiosLiquidacionPorCodigo(idOficio);
        return miListaOficios;
    }

    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionModificaPorSolicitud(Long idContrato) throws ExcepcionDAO {
        List<OficioLiquidacionPrevioVO> miListaOficiosPrevios =
            oficioLiquidacionDAO.calcularOficioLiquidacionModificaPorSolicitud(idContrato);
        return miListaOficiosPrevios;
    }

    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionValorModificaPorSolicitud(Long idSolicitud) throws ExcepcionDAO {
        List<OficioLiquidacionPrevioVO> miListaOficiosPrevios =
            oficioLiquidacionDAO.calcularOficioLiquidacionValorModificaPorSolicitud(idSolicitud);
        return miListaOficiosPrevios;
    }
    
    public List<DuplaVO> buscarPagosPorContrato(long codigoContrato) throws ExcepcionDAO {
        List<DuplaVO> miListaPagos = oficioLiquidacionDAO.buscarPagosPorContrato(codigoContrato);
        return miListaPagos;
    }
    
    public Long cantidadElementosPorSolicitud(Long sauCodigo) throws ExcepcionDAO {
        return oficioLiquidacionDAO.cantidadElementosPorSolicitud(sauCodigo);
    }
	public List<ContratoVO> buscarContratoPorOficioLiquidacion(Long idOficio ) throws ExcepcionDAO {
        List<SiiContrato> listaSiiContratos =oficioLiquidacionDAO.buscarContratoPorOficioLiquidacion(idOficio);
        List<ContratoVO> listaContratosVo = new ArrayList();
        if(listaSiiContratos!= null && !listaSiiContratos.isEmpty()){
            for(SiiContrato unSiiContrato :listaSiiContratos ){
                listaContratosVo.add(new ContratoVO(unSiiContrato));
                }
        }
        return listaContratosVo; 
    }
    /**
     * Realiza la consulta de oficios de liquidación de modificación contratos.
     * @param UsuarioVO - Usuario logeado.
     * @throws ExcepcionDAO
     */
    public List<OfiLiquidacionSolAutorizaVO> buscarTodosOficioLiquidacionModifContrato(UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        List<OfiLiquidacionSolAutorizaVO> miListaOficios =
            oficioLiquidacionDAO.buscarTodosOficioLiquidacionModifContrato(usuarioLogueado);
        return miListaOficios;
    }
    /**
     * Realiza la consulta del inventario para calcular liquidación de contratos con novedad de modificación contratos.
     * @param idContrato - código del contrato.
     * @throws ExcepcionDAO
     */
    
    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionModificaPorContrato(Long idContrato) throws ExcepcionDAO {
        return oficioLiquidacionDAO.calcularOficioLiquidacionModificaPorContrato(idContrato);    
    }
    
    /**
     * Realiza la consulta del inventario activo más el modificado paracalcular liquidación de contratos con novedad de modificación contratos.
     * @param idContrato - código del contrato.
     * @param idSolicitud - código de la solicitud
     * @throws ExcepcionDAO
     */
    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionNuevoInventarioPorSolicitud(Long idSolicitud, Long idContrato) throws ExcepcionDAO {
        return oficioLiquidacionDAO.calcularOficioLiquidacionNuevoInventarioPorSolicitud(idSolicitud, idContrato);
    }
    
    // ***
    
    public List<OficioLiquidacionPrevioVO> obtenerLiquidacioncionOficioLiqPorContrato(Long idContrato) throws ExcepcionDAO {
        return oficioLiquidacionDAO.obtenerLiquidacioncionOficioLiqPorContrato(idContrato);
    }
	
	public OficioLiquidacionVO insertarSiiOficioLiquidacionModifContrato(OficioLiquidacionVO oficioLiquidacionVo,
														SolicitudAutorizaVO solAutoriza,
														List<GarantPolizaOficLiqVO> garPolizaOfic,
														List<OficLiqTipoApuestaVO> listOficLiqTa,
                                                                                                                List<InventarioVO> listaElementosActualizar,
                                                                                                                List<OficioLiquidacionPrevioVO> listaElementosAct,
                                                                                                                List<OficioLiquidacionPrevioVO> listaElementosModif,
                                                                                                                List<OficioLiquidacionPrevioVO> listaElementosNuevos                                                                                                                
                                                                                                                ) throws ExcepcionDAO {

               
                
                // Se actualiza el estado de la solicitud
		SiiSolicitudAutoriza resultadoSiiSolicitudAutoriza = solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solAutoriza));

		// Se registra el oficio de liquidación
		SiiOficioLiquidacion oficio = conversionVoEntidad.convertir(oficioLiquidacionVo);
		oficio.setSiiSolicitudAutoriza(resultadoSiiSolicitudAutoriza);

		// Se consulta el consecutivo actual
		Long consecutivo = new Long(0);
		consecutivo = oficioLiquidacionDAO.buscarConsecutivoOficio();
		consecutivo++;
		oficio.setOliConsecutivo(consecutivo.intValue());

		SiiOficioLiquidacion resultadoOficio = oficioLiquidacionDAO.insertarSiiOficioLiquidacion(oficio);

		// Se registran los amparo-poliza
		for (GarantPolizaOficLiqVO unaGarantia : garPolizaOfic) {
			SiiGarantPolizaOficLiq siiGarantPolizaOficLiq = conversionVoEntidad.convertir(unaGarantia);
			siiGarantPolizaOficLiq.setSiiOficioLiquidacion(resultadoOficio);
			SiiGarantPolizaOficLiq resultadoSiiGarantPolizaOficLiq =
				garantPolizaOficLiqDao.insertarSiiGarantPolizaOficLiq(siiGarantPolizaOficLiq);
		}
                // Se registran los elementos de la liquidacion actual
                if(listaElementosAct!= null && listaElementosAct.size()>0){
                    for (OficioLiquidacionPrevioVO unOfic : listaElementosAct) {
                        OficLiqTipoApuestaVO unOficLiTq = new OficLiqTipoApuestaVO();
                        unOficLiTq.setOtaNumElem(unOfic.getCantidad()); 
                        unOficLiTq.setOtaValorUnidad(unOfic.getValorUnidad());
                        unOficLiTq.setOtaDerExplMes(unOfic.getDerechosExplMensual());
                        unOficLiTq.setOtaGasAdmin(unOfic.getGastosAdministracionMensual());
						unOficLiTq.setOtaIndicadorLiq(unOfic.getIndicadorLiq());
                        TipoApuestaVO tipoApuestaVo = tipoApuestaDao.buscarSiiTipoCodigoApuesta(unOfic.getCodigoApuesta());                                        
                        unOficLiTq.setTipoApuestaVo(tipoApuestaVo);                                        
                        SiiOficLiqTipoApuesta siiOficLiqTipoApuesta = conversionVoEntidad.convertir(unOficLiTq);
                        siiOficLiqTipoApuesta.setSiiOficioLiquidacion(resultadoOficio);
                        SiiOficLiqTipoApuesta resultadoSiiOficLiqTipoApuesta =
                        oficLiqTipoApuestaDao.insertarSiiOficLiqTipoApuesta(siiOficLiqTipoApuesta);
                    } 
                }
                
                // Se registran los elementos de la liquidacion con la modificación
                if(listaElementosModif!= null && listaElementosModif.size()>0){
                    for (OficioLiquidacionPrevioVO unOfic : listaElementosModif) {
                        OficLiqTipoApuestaVO unOficLiTq1 = new OficLiqTipoApuestaVO();
                        unOficLiTq1.setOtaNumElem(unOfic.getCantidad()); 
                        unOficLiTq1.setOtaValorUnidad(unOfic.getValorUnidad());
                        unOficLiTq1.setOtaDerExplMes(unOfic.getDerechosExplMensual());
                        unOficLiTq1.setOtaGasAdmin(unOfic.getGastosAdministracionMensual());
						unOficLiTq1.setOtaIndicadorLiq(unOfic.getIndicadorLiq());
                        TipoApuestaVO tipoApuestaVo = tipoApuestaDao.buscarSiiTipoCodigoApuesta(unOfic.getCodigoApuesta());                                        
                        unOficLiTq1.setTipoApuestaVo(tipoApuestaVo);                                        
                        SiiOficLiqTipoApuesta siiOficLiqTipoApuesta = conversionVoEntidad.convertir(unOficLiTq1);
                        siiOficLiqTipoApuesta.setSiiOficioLiquidacion(resultadoOficio);
                        SiiOficLiqTipoApuesta resultadoSiiOficLiqTipoApuesta =
                        oficLiqTipoApuestaDao.insertarSiiOficLiqTipoApuesta(siiOficLiqTipoApuesta);
                    } 
                }
                
                // Se registran los elementos de la liquidacion nueva
                if(listaElementosNuevos!= null && listaElementosNuevos.size()>0){
                    for (OficioLiquidacionPrevioVO unOfic : listaElementosNuevos) {
                        OficLiqTipoApuestaVO unOficLiTq1 = new OficLiqTipoApuestaVO();
                        unOficLiTq1.setOtaNumElem(unOfic.getCantidad()); 
                        unOficLiTq1.setOtaValorUnidad(unOfic.getValorUnidad());
                        unOficLiTq1.setOtaDerExplMes(unOfic.getDerechosExplMensual());
                        unOficLiTq1.setOtaGasAdmin(unOfic.getGastosAdministracionMensual());
						unOficLiTq1.setOtaIndicadorLiq(unOfic.getIndicadorLiq());
                        TipoApuestaVO tipoApuestaVo = tipoApuestaDao.buscarSiiTipoCodigoApuesta(unOfic.getCodigoApuesta());                                        
                        unOficLiTq1.setTipoApuestaVo(tipoApuestaVo);                                        
                        SiiOficLiqTipoApuesta siiOficLiqTipoApuesta = conversionVoEntidad.convertir(unOficLiTq1);
                        siiOficLiqTipoApuesta.setSiiOficioLiquidacion(resultadoOficio);
                        SiiOficLiqTipoApuesta resultadoSiiOficLiqTipoApuesta =
                        oficLiqTipoApuestaDao.insertarSiiOficLiqTipoApuesta(siiOficLiqTipoApuesta);
                    } 
                }
		/*for (OficLiqTipoApuestaVO unOficLiTq : listOficLiqTa) {
			SiiOficLiqTipoApuesta siiOficLiqTipoApuesta = conversionVoEntidad.convertir(unOficLiTq);
			siiOficLiqTipoApuesta.setSiiOficioLiquidacion(resultadoOficio);
			SiiOficLiqTipoApuesta resultadoSiiOficLiqTipoApuesta =
				oficLiqTipoApuestaDao.insertarSiiOficLiqTipoApuesta(siiOficLiqTipoApuesta);
		}*/
		
		// Se actualiza el inventario
		if(listaElementosActualizar!= null && listaElementosActualizar.size()>0){
            for(InventarioVO unInvVo : listaElementosActualizar){
                    SiiInventario siiInventario = conversionVoEntidad.convertir(unInvVo);
                    inventarioDao.actualizarSiiInventario(siiInventario);                
            }
        }

		return new OficioLiquidacionVO(resultadoOficio);
}

    public List<Long> consultarCodigoInventarioPorSolicitud(Long idSolicitud) throws ExcepcionDAO {    
        return oficioLiquidacionDAO.consultarCodigoInventarioPorSolicitud(idSolicitud);
    }
    
    public List<OficLiqTipoApuestaVO> buscarSiiOficLiqTipoApuestaPorCodigoEIndicador(Long idOficio,String indicador) throws ExcepcionDAO {
        List<SiiOficLiqTipoApuesta> listaSiiOficLiqTipoApuesta= new ArrayList();
        List<OficLiqTipoApuestaVO> listaOficLiqTipoApuestaVo= new ArrayList();
        listaSiiOficLiqTipoApuesta = oficLiqTipoApuestaDao.buscarSiiOficLiqTipoApuestaPorCodigoEIndicador(idOficio, indicador);
        if(listaSiiOficLiqTipoApuesta.size() > 0){
            for(SiiOficLiqTipoApuesta unSiiOfi : listaSiiOficLiqTipoApuesta){
                listaOficLiqTipoApuestaVo.add(new OficLiqTipoApuestaVO(unSiiOfi));
            }
        }
        return listaOficLiqTipoApuestaVo;
    }
    
    public List<DuplaVO> buscarPagosPorContratoYDestino(long codigoContrato) throws ExcepcionDAO {
        return oficioLiquidacionDAO.buscarPagosPorContratoYDestino(codigoContrato);
    }
    
}
