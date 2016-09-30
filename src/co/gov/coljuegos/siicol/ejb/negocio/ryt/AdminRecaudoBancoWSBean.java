package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaBancariaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InteresCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionEstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionMesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperacionLineaBanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecaudoBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecaudoEstablecDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecaudoLineaBanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RifaPromocionalDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperacionLineaBan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoEstablec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoLineaBan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRifaPromocional;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.InteresCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.ValidacionInteresVO;
import co.gov.coljuegos.siicol.ejb.wsvo.AnulacionRecaudoResponseWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.AnulacionRecaudoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ConsultaRecaudoResponseWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ConsultaRecaudoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PagoRecaudoResponseWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PagoRecaudoWSVO;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRecaudoBancoWSBean implements AdminRecaudoBancoWS {

    @EJB
    private OperacionLineaBanDAO operacionLineaBanDAO;
    @EJB
    private RecaudoLineaBanDAO recaudoLineaBanDAO;
    @EJB
    private DetalleDeclaracionDAO detalleDeclaracionDAO;
    @EJB
    private DetalleRecaudoDAO detalleRecaudoDAO;
    @EJB 
    private BancoDAO bancoDao;
    @EJB 
    private RecaudoBancoDAO recaudoBancoDao;
    @EJB
    private TipoDocContableDAO tipoDocContableDao;
    @EJB
    private DocumentoContableDAO documentoContableDao;
    @EJB
    private EstadoDocContabDAO estadoDocContabDao;
    @EJB
    private LiquidacionEstablecimientoDAO liquidacionEstablecimientoDao;
    @EJB
    private RecaudoEstablecDAO recaudoEstablecDao;
    @EJB
    private CuentasContablesDAO cuentasContablesDao;
    @EJB
    private CuentaBancariaDAO cuentaBancariaDao;
    @EJB
    private ImputacionContableDAO imputacionContableDao;
    @EJB
    private DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB 
    private DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    private CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    private ConceptoCuotaDAO conceptoCuotaDao;
    @EJB
    private OperadorDAO operadorDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private LiquidacionMesDAO liquidacionMesDao;
    @EJB
    private ContratoDAO contratoDao;
    @EJB
    private InteresCuotaDAO interesCuotaDao;
    @EJB
    private RecaudoLineaBanDAO recaudoLineaBanDao;
    @EJB
    private RifaPromocionalDAO rifaPromocionalDao;
    @EJB
    private LiquidacionMesDAO LiquidacionMesDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    



    /**
     *Metodo encargado de hacer la consulta por la referencia para consultar los datos de pago que
     * debe hacer el operador
     * @author David Tafur
     * @param consultaRecaudoWSVO
     * @return ConsultaRecaudoResponseWSVO
     */
    public ConsultaRecaudoResponseWSVO consultaPagoRecaudo(ConsultaRecaudoWSVO consultaRecaudoWSVO) throws ExcepcionDAO {

        /*
        * Bandera usada para verificar si ocurrio un error
        */
        boolean hayErrores = false;
        Integer codigoError = null;
        Calendar calendar = Calendar.getInstance();

        /*
         *Variable encargada de almacenar la respuesta enviada al banco
        */
        ConsultaRecaudoResponseWSVO consultaRecaudoResponseWSVO = new ConsultaRecaudoResponseWSVO();
        /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         * Posibles errores asociados a la operacion de consulta, que debe manejar el web services
         * en caso de que se presente alguno de los escenarios.
         * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         */

        Map<String, List<Object>> erroresRespuesta = new HashMap<String, List<Object>>();
        List<Object> error = new ArrayList<Object>();

        error.add("Transacción Exitosa");
        error.add("Ejecución Correcta");
        erroresRespuesta.put("0", error);
        error = new ArrayList<Object>();

        error.add("Factura no Existe");
        error.add("La referencia no se encuentra en la base de datos");
        erroresRespuesta.put("1", error);
        error = new ArrayList<Object>();

        error.add("Acceso no permitido");
        error.add("Acceso denegado a aplicación");
        erroresRespuesta.put("2", error);
        error = new ArrayList<Object>();

        error.add("Valor Incorrecto");
        error.add("El valor no corresponde a la factura");
        erroresRespuesta.put("3", error);
        error = new ArrayList<Object>();

        error.add("Pago ya realizado");
        error.add("El pago ya fue efectuado");
        erroresRespuesta.put("4", error);
        error = new ArrayList<Object>();

        error.add("Error de Conexión");
        error.add("Falla de infraestructura");
        erroresRespuesta.put("5", error);
        error = new ArrayList<Object>();

        error.add("Fuera de Línea");
        error.add("Se interrumpe la comunicación");
        erroresRespuesta.put("6", error);
        error = new ArrayList<Object>();

        error.add("Mantenimiento del sistema");
        error.add("Mantenimiento de la plataforma o sistema");
        erroresRespuesta.put("7", error);
        error = new ArrayList<Object>();

        error.add("Formato Invalido");
        error.add("El formato de la trama es incorrecto");
        erroresRespuesta.put("8", error);
        error = new ArrayList<Object>();

        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/FIN MENSAJES ERROR_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/

        /*
        * Se realiza la consulta  por medio de la referencia
        */
        SiiDetalleDeclaracion siiDetalleDeclaracion = new SiiDetalleDeclaracion();
        siiDetalleDeclaracion =
            detalleDeclaracionDAO.buscarDetalleDeclaracionPorReferenciaPago(Long.parseLong(consultaRecaudoWSVO.refererenciaPrincipal));

        /*
        * Verificamos que si haya encontrado algun registro por ese numero de referencia
        */
        if (!hayErrores) {
            if (siiDetalleDeclaracion == null || siiDetalleDeclaracion.getDdeCodigo() == null ||
                siiDetalleDeclaracion.getDdeCodigo() == 0) {
                consultaRecaudoResponseWSVO.codigoError = 1;
                consultaRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("1").get(0);
                consultaRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("1").get(1);
                hayErrores = true;
                codigoError = 1;
            }
        }

        /*
         * Verificamos que el valor que llega por el web services sea el valor que corresponde en la base
         * de datos para ese numero de referencia
        */
        if (!hayErrores) {
            if (!siiDetalleDeclaracion.getDdeValorDeclarado().add(siiDetalleDeclaracion.getDdeValorInter()).equals(consultaRecaudoWSVO.valorTotal)) {
                consultaRecaudoResponseWSVO.codigoError = 3;
                consultaRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("3").get(0);
                consultaRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("3").get(1);
                hayErrores = true;
                codigoError = 3;
            }
        }

        /*
        * Verificamos si esa referencia de pago ya fue pagada
        */
        if (!hayErrores) {
            if ((siiDetalleDeclaracion.getDdeValorPagado() != null && siiDetalleDeclaracion.getDdeValorPagado().doubleValue() > 0D) || 
               (siiDetalleDeclaracion.getDdeValorPagInt() != null && siiDetalleDeclaracion.getDdeValorPagInt().doubleValue() > 0D))  {
                consultaRecaudoResponseWSVO.codigoError = 4;
                consultaRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("4").get(0);
                consultaRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("4").get(1);
                hayErrores = true;
                codigoError = 4;
            }
        }

        /*
        * Una vez que se hicieron todas las validaciones entonces armamos la respuesta que le vamos a devolver
        * por medio del web services
        */

        if (!hayErrores) {
            consultaRecaudoResponseWSVO.codigoError = 0;
            consultaRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("0").get(0);
            consultaRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("0").get(1);
            consultaRecaudoResponseWSVO.valorFactura = siiDetalleDeclaracion.getDdeValorDeclarado().add(siiDetalleDeclaracion.getDdeValorInter());
            consultaRecaudoResponseWSVO.fechaVencimiento =
                siiDetalleDeclaracion.getSiiCuotaOperador().getCopFechaLimPag();
            codigoError = 0;
        }

        /*
         * Registramos la solicitud en linea del banco
         */
        SiiOperacionLineaBan siiOperacionLineaBan = new SiiOperacionLineaBan();

        siiOperacionLineaBan.setOlbCodigoResp(codigoError);
        siiOperacionLineaBan.setOlbCodEan(consultaRecaudoWSVO.codEAN);
        siiOperacionLineaBan.setOlbDatosAdicion((String) erroresRespuesta.get(String.valueOf(codigoError)).get(1));
        siiOperacionLineaBan.setOlbFecha(consultaRecaudoWSVO.fechaOperacion);
        siiOperacionLineaBan.setOlbFechaReg(calendar.getTime());
        //Id del web services
        Random random = new Random();
        int i = random.nextInt(100000);
        siiOperacionLineaBan.setOlbIdWebservice(System.currentTimeMillis() + "_" + i);
        siiOperacionLineaBan.setOlbRefPrincipal(consultaRecaudoWSVO.refererenciaPrincipal);
        siiOperacionLineaBan.setOlbTipoOperacion("C");
        siiOperacionLineaBan.setOlbValor(consultaRecaudoWSVO.valorTotal);

        operacionLineaBanDAO.insertarSiiOperacionLineaBan(siiOperacionLineaBan);

        return consultaRecaudoResponseWSVO;
    }

    /**
     *Metodo encargado de hacer el registor de un recaudo que llega por medio del web services
     * @author David Tafur
     * @param pagoRecaudoWSVO
     * @return PagoRecaudoResponseWSVO
     */
    public PagoRecaudoResponseWSVO registroPagoRecaudo(PagoRecaudoWSVO pagoRecaudoWSVO) throws ExcepcionDAO,ExcepcionAplicacion {
        
        /*
        * Bandera usada para verificar si ocurrio un error
        */
        Calendar calendar = Calendar.getInstance();
        /*
        * Variable usada para guardar la informacion de respuesta que se devolvera por el webServices luego
        * del pago exitoso
        */

        PagoRecaudoResponseWSVO pagoRecaudoResponseWSVO = new PagoRecaudoResponseWSVO();
        SiiPersona siiPersona=new SiiPersona();
        /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         * Posibles errores asociados a la operacion de consulta, que debe manejar el web services
         * en caso de que se presente alguno de los escenarios.
         * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         */

        Map<String, List<Object>> erroresRespuesta = new HashMap<String, List<Object>>();
        List<Object> error = new ArrayList<Object>();

        error.add("Transacción Exitosa");
        error.add("Ejecución Correcta");
        erroresRespuesta.put("0", error);
        error = new ArrayList<Object>();
        
        error.add("Fuera de Línea");
        error.add("Se interrumpe la comunicación");
        erroresRespuesta.put("6", error);
        error = new ArrayList<Object>();
        
        /*error.add("Valor Incorrecto");
        error.add("El valor no corresponde a la factura");
        erroresRespuesta.put("3", error);
        error = new ArrayList<Object>();
        
        error.add("Pago ya realizado");
        error.add("El pago ya fue efectuado");
        erroresRespuesta.put("4", error);
        error = new ArrayList<Object>();
        
        error.add("Factura no Existe");
        error.add("La referencia no se encuentra en la base de datos");
        erroresRespuesta.put("1", error);
        error = new ArrayList<Object>();*/

        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/FIN MENSAJES ERROR_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


        try{

        /*
        * Se realiza la consulta  por medio de la referencia
        */
        //SiiDetalleDeclaracion siiDetalleDeclaracion = new SiiDetalleDeclaracion();
       
         List<SiiDetalleDeclaracion> listaDetalleDecl = detalleRecaudoDao.BuscarDetalleDeclaracionXIdRefPagoSinPago(Long.parseLong(pagoRecaudoWSVO.refererenciaPrincipal));     
         String tipoDocContable = null;   
        //siiDetalleDeclaracion =
          //  detalleDeclaracionDAO.buscarDetalleDeclaracionPorReferenciaPago(Long.parseLong(pagoRecaudoWSVO.refererenciaPrincipal));

                /*
                 * Registramos la solicitud en linea del banco
                 */
                SiiOperacionLineaBan siiOperacionLineaBan = new SiiOperacionLineaBan();
        
                siiOperacionLineaBan.setOlbCodigoResp(0);
                siiOperacionLineaBan.setOlbCodEan(pagoRecaudoWSVO.codEAN);
                siiOperacionLineaBan.setOlbDatosAdicion((String) erroresRespuesta.get("0").get(1));
                siiOperacionLineaBan.setOlbFecha(pagoRecaudoWSVO.fechaOperacion);
                siiOperacionLineaBan.setOlbFechaReg(calendar.getTime());
                Random random = new Random();
                int i = random.nextInt(100000);
                siiOperacionLineaBan.setOlbIdWebservice(System.currentTimeMillis() + "_" + i);
                siiOperacionLineaBan.setOlbRefPrincipal(pagoRecaudoWSVO.refererenciaPrincipal);
                siiOperacionLineaBan.setOlbTipoOperacion("P");
                siiOperacionLineaBan.setOlbValor(pagoRecaudoWSVO.valorTotal);
                siiOperacionLineaBan.setOlbMedioPago(pagoRecaudoWSVO.tipoPago);
                operacionLineaBanDAO.insertarSiiOperacionLineaBan(siiOperacionLineaBan);
        
                SiiRecaudoLineaBan siiRecaudoLineaBan = new SiiRecaudoLineaBan();
                siiRecaudoLineaBan.setSiiOperacionLineaBan(siiOperacionLineaBan);
                siiRecaudoLineaBan=recaudoLineaBanDAO.insertarSiiRecaudoLineaBan(siiRecaudoLineaBan);
        
        
            //busca si hay recaudo por clasificar
           
            for(SiiDetalleDeclaracion siiDetalleDeclaracion :listaDetalleDecl){
                
                
                List<SiiDetalleDeclaracion> siiListaDetalleDeclPagos= detalleDeclaracionDao.buscarDetalleDeclaracionPorXCodigoCuota(siiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                ValidacionInteresVO unValidacionInteresVo = interesCuotaDao.buscarSaldoPagoInteresesXcodigoCuota(siiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                SiiCuotaOperador unSiiCuotaOperador=  cuotaOperadorDao.buscarCuotaOperadorPorId(siiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                
                BigDecimal tempPago = BigDecimal.ZERO;
                BigDecimal tempPagoInt = BigDecimal.ZERO;
                BigDecimal saldoCuota = BigDecimal.ZERO;
                BigDecimal saldoCuotaInt = BigDecimal.ZERO;
                 
                for (SiiDetalleDeclaracion unsiiDetalleDeclaracion:siiListaDetalleDeclPagos  ){
                        if( unsiiDetalleDeclaracion.getDdeValorPagado() != null)
                            tempPago = tempPago.add(unsiiDetalleDeclaracion.getDdeValorPagado());
                          
                        if( unsiiDetalleDeclaracion.getDdeValorPagInt() != null)
                            tempPagoInt= tempPagoInt.add(unsiiDetalleDeclaracion.getDdeValorPagInt());
                }
                    
                if(siiDetalleDeclaracion.getDdeValorPagado()!= null)
                        saldoCuota=(unSiiCuotaOperador.getCopValor().subtract(tempPago));
                if(siiDetalleDeclaracion.getDdeValorPagInt()!= null)
                        saldoCuotaInt=(unValidacionInteresVo.getInteresGenerado().subtract(tempPagoInt));
                
                    /*
                    * Inserto el registro de detalle recaudo en la base de datos
                    */
                    
                    SiiDetalleRecaudo siiDetalleRecaudo = new SiiDetalleRecaudo();
                    siiDetalleRecaudo.setDreEstado("A");
                    siiDetalleRecaudo.setDreRefPago(pagoRecaudoWSVO.refererenciaPrincipal);
                    siiDetalleRecaudo.setDreValor(pagoRecaudoWSVO.valorTotal);
                    siiDetalleRecaudo.setSiiRecaudoLineaBan(siiRecaudoLineaBan);
                    siiDetalleRecaudo.setDreNumAutoriza(pagoRecaudoWSVO.codEAN.intValue());
                    siiDetalleRecaudo=detalleRecaudoDAO.insertar(siiDetalleRecaudo);
            
                    
                    /*
                     * Actualizamos el detalle declaracion para asociarle el detalle de recaudo
                     */
                    siiDetalleDeclaracion.setSiiDetalleRecaudo(siiDetalleRecaudo);
                    siiDetalleDeclaracion.setDdeValorPagado(siiDetalleDeclaracion.getDdeValorDeclarado());
                    siiDetalleDeclaracion.setDdeValorPagInt(siiDetalleDeclaracion.getDdeValorInter());
                    detalleDeclaracionDAO.actualizarDetalleDeclaracion(siiDetalleDeclaracion);
                    
                    //Si la cuota es menor que octubre 2015, crea RPB de lo contrario RPI //se coloco 2020 mientras validad a que fecha se debe publicar este cambio
                  //  if (unSiiCuotaOperador.getCopVigencia().equals("2020") && unSiiCuotaOperador.getMesCodigo()<10 ){
                        tipoDocContable = "RPB";
                    //}
                    //else 
                      //  tipoDocContable = "RPI";
                
                    //documento contable
                    SiiDocumentoContable insertSiiDocumentoContable= new SiiDocumentoContable();
                    SiiTipoDocContable siiTipoDocContable =tipoDocContableDao.buscarPorCodigo(tipoDocContable);
                    Integer consecutivo =documentoContableDao.buscarConsecutivoDocumentoContable(tipoDocContable);
                    insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                    insertSiiDocumentoContable.setDcoFechaOper(pagoRecaudoWSVO.fechaOperacion);
                    insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                    insertSiiDocumentoContable.setSiiDetalleRecaudo(siiDetalleRecaudo);
                    String nombreEstado="BORRADOR";
                    SiiEstadoDocContab  siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
                    insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                    insertSiiDocumentoContable=documentoContableDao.insertarDocumentoContable(insertSiiDocumentoContable);
                    
                        SiiCuotaOperador siiCuotaoperador= new SiiCuotaOperador();                                    
                        List<SiiDetalleDeclaracion> siiListaDetalleDecl=detalleDeclaracionDao.BuscarDetalleDeclaracionXIdRefPago(Long.parseLong( pagoRecaudoWSVO.refererenciaPrincipal));
                        siiCuotaoperador=cuotaOperadorDao.buscarCuotaOperadorPorId(siiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                        SiiConceptoCuota siiConceptoCuota =  conceptoCuotaDao.buscarConceptoCuotaXId(siiCuotaoperador.getSiiConceptoCuota().getCcuCodigo());
                        
                        //buscar datos tercero
                        if(siiCuotaoperador.getSiiOperador() != null ){
                          SiiOperador siiOperador= operadorDao.buscarPorCodigoOperador(siiCuotaoperador.getSiiOperador().getOpeCodigo());
                          siiPersona=  personaDao.buscarPersonaPorId(siiOperador.getSiiPersona().getPerCodigo());
                        }
                        //para casos de rifas promocionales
                        if(siiCuotaoperador.getSiiRifaPromocional()!= null){
                            SiiRifaPromocional siiRifaPromocional= new SiiRifaPromocional();
                            siiRifaPromocional= rifaPromocionalDao.buscarPorCodigoRifaPromocional(siiCuotaoperador.getSiiRifaPromocional().getRfpCodigo());
                            siiPersona =  siiRifaPromocional.getSiiSolicitudAutoriza().getSiiPersonaRifaProm();
                        }
                        
                       
                    
                    
                    //insertar recaudo Establecimiento
                    
                    List<SiiLiquidacionEstabl> listaSiiLiquidacionEstabl = new ArrayList<SiiLiquidacionEstabl>();
                    listaSiiLiquidacionEstabl =  liquidacionEstablecimientoDao.buscarTodaLiquidacionEstablXidCuotaOperador(siiCuotaoperador.getCopCodigo());
                    for (SiiLiquidacionEstabl unaSiiLiquidacionEstabl :listaSiiLiquidacionEstabl)  {
                        SiiRecaudoEstablec siiRecaudoEstbl= new SiiRecaudoEstablec();
                        siiRecaudoEstbl.setSiiDetalleDeclaracion(siiDetalleDeclaracion);
                        siiRecaudoEstbl.setSiiLiquidacionEstabl(unaSiiLiquidacionEstabl);
                        siiRecaudoEstbl.setReeValorPagado(siiDetalleDeclaracion.getDdeValorPagado().multiply( unaSiiLiquidacionEstabl.getLesPonderado()));  
                        if(siiDetalleDeclaracion.getDdeValorPagado()!= null)
                              siiRecaudoEstbl.setReeValorPagado(siiDetalleDeclaracion.getDdeValorPagado().multiply( unaSiiLiquidacionEstabl.getLesPonderado())); 
                        if( siiDetalleDeclaracion.getDdeValorPagInt()!= null )
                               siiRecaudoEstbl.setReeValorPagInter(siiDetalleDeclaracion.getDdeValorPagInt().multiply( unaSiiLiquidacionEstabl.getLesPonderado()));
                        recaudoEstablecDao.insertarRecaudoEstablec(siiRecaudoEstbl);
                    }
                    
                    //buscar numero de contrato
                    SiiContrato siiContrato = new SiiContrato();
                    
                    if(siiCuotaoperador.getSiiLiquidacionMes()!= null  ){
                         SiiLiquidacionMes  siiLiquidacionMes = liquidacionMesDao.buscarLiquidacionMesPorId(siiCuotaoperador.getSiiLiquidacionMes().getLmeCodigo());
                         siiContrato= contratoDao.buscarContratoPorId(siiLiquidacionMes.getSiiContrato().getConCodigo());
                    }
                    
                    //imputacion contable Debito General 
                    SiiImputacionContable siiImputacionContable= new SiiImputacionContable();       
                    String grupoRecaudo=  pagoRecaudoWSVO.refererenciaPrincipal.substring(0,3);
                    SiiCuentasContables siiCuentasContable= detalleRecaudoDao.BuscarCuentaContTipoDocContXCodigoConcSinTer(pagoRecaudoWSVO.refererenciaSecundaria,tipoDocContable );
                    siiImputacionContable.setSiiCuentasContables(siiCuentasContable);
                    siiImputacionContable.setImcTipoMovim("D");
                    //validaciones
                   
                    if(siiCuentasContable.getCcoNumDocConta().equals("S"))
                        siiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
                        siiImputacionContable.setImcDescrOperacion("Recaudo Web Services ");                      
                        siiImputacionContable.setImcValor(siiDetalleDeclaracion.getDdeValorPagado().add(siiDetalleDeclaracion.getDdeValorPagInt()));
                   if(siiCuentasContable.getCcoObligaTerc().equals("S") )
                        siiImputacionContable.setSiiPersona(siiPersona);
                   if(siiCuentasContable.getCcoReferencia1().equals("S") ){
                                Calendar cal=Calendar.getInstance();
                                DateFormat format=new SimpleDateFormat("yyyy/mm/dd");
                                if(siiCuotaoperador.getSiiAcuerdoPago()!= null){
                                    format.format(siiCuotaoperador.getSiiAcuerdoPago().getApaFechaResol());
                                    cal=format.getCalendar();
                                    siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiAcuerdoPago().getApaNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                }
                                /* if(siiCuotaoperador.getSiiMulta()!= null){
                                    format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                    cal=format.getCalendar(); 
                                    siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                }
                                if(siiCuotaoperador.getSiiSancion()!= null){
                                    format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                    cal=format.getCalendar(); 
                                    siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                } */
                                if(siiCuotaoperador.getSiiLiquidacionMes()!= null){
                                    siiImputacionContable.setImcReferencia1(siiContrato.getConNumero());   
                                }
                                if(siiCuotaoperador.getSiiRifaPromocional()!= null){
                                siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString());
                               }
                        } 
                
                        if(siiCuentasContable.getCcoReferencia2().equals("S"))
                             siiImputacionContable.setImcReferencia2(String.valueOf(siiCuotaoperador.getCopNumCuota()));
                        
                    siiImputacionContable.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionContable);
                   
              
                    //ingresar movimiento contable 
                    for (SiiDetalleDeclaracion unSiiDetalleDeclaracion :siiListaDetalleDecl){
                            
                        if(siiDetalleDeclaracion.getDdeValorDeclarado().compareTo(BigDecimal.ZERO)>0 ){     
                            List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= new ArrayList<SiiCuentaContTipoDocCont>();
                            listaSiiCuentaContTipoDocCont=detalleRecaudoDao.buscarCuentaContTipoDocContXCodigoConceptoTcartera(siiConceptoCuota.getCcuAbreviatura(), siiCuotaoperador.getCopTipoCartera(),tipoDocContable);
                            
                        for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont :listaSiiCuentaContTipoDocCont){
                            SiiImputacionContable siiImputacionCont= new SiiImputacionContable();
                            siiImputacionCont.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                            siiImputacionCont.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                            SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                            //validaciones
                            if(siiCuentasContables.getCcoObligaTerc().equals("S") )
                                 siiImputacionCont.setSiiPersona(siiPersona);
                            if(siiCuentasContables.getCcoNumDocConta().equals("S") )
                                siiImputacionCont.setSiiDocumentoContable(insertSiiDocumentoContable);
                            if(siiCuentasContables.getCcoReferencia1().equals("S") ){
                                        Calendar cal=Calendar.getInstance();
                                        DateFormat format=new SimpleDateFormat("yyyy/mm/dd");
                                        if(siiCuotaoperador.getSiiAcuerdoPago()!= null){
                                            format.format(siiCuotaoperador.getSiiAcuerdoPago().getApaFechaResol());
                                            cal=format.getCalendar();
                                            siiImputacionCont.setImcReferencia1(siiCuotaoperador.getSiiAcuerdoPago().getApaNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                        }
                                        /* if(siiCuotaoperador.getSiiMulta()!= null){
                                            format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                            cal=format.getCalendar(); 
                                            siiImputacionCont.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                        }
                                        if(siiCuotaoperador.getSiiSancion()!= null){
                                            format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                            cal=format.getCalendar(); 
                                            siiImputacionCont.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                        } */
                                        if(siiCuotaoperador.getSiiLiquidacionMes()!= null){
                                            siiImputacionCont.setImcReferencia1(siiContrato.getConNumero());   
                                        }
                                        if(siiCuotaoperador.getSiiRifaPromocional()!= null){
                                        siiImputacionCont.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString());
                                        }
                                } 
                                
                                if(siiCuentasContables.getCcoReferencia2().equals("S"))
                                     siiImputacionCont.setImcReferencia2(String.valueOf(siiCuotaoperador.getCopNumCuota()));
                            
                            siiImputacionCont.setImcDescrOperacion("Recaudo Web Services");
                            siiImputacionCont.setImcValor(unSiiDetalleDeclaracion.getDdeValorDeclarado());
                            siiImputacionCont.setImcEstado("A");
                            imputacionContableDao.insertarImputacionContable(siiImputacionCont);
                            } 
                        }
                    
                        //ingresar movimiento contable con intereses
                        BigDecimal b1 = new BigDecimal("-1");
                        String concepto=null;
                        if(unSiiDetalleDeclaracion.getDdeValorInter().compareTo(BigDecimal.ZERO)>0 ){    
                                 List<SiiDetalleDeclaracion> listaDetalleDeclaracion= new ArrayList<SiiDetalleDeclaracion>();
                                 List<SiiCuentaContTipoDocCont> listaSiiCuentaContTDC= new ArrayList<SiiCuentaContTipoDocCont>();
                                 SiiCuotaOperador siiCuotaOpe=cuotaOperadorDao.buscarCuotaOperadorPorId(unSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                                   SiiConceptoCuota siiConceptoCuo =  conceptoCuotaDao.buscarConceptoCuotaXId(siiCuotaOpe.getSiiConceptoCuota().getCcuCodigo());
                                   //System.out.println("Buscar concepto cuota " + siiCuotaOpe.getSiiConceptoCuota().getCcuCodigo());
                                   //System.out.println("Resultado: " + (siiConceptoCuo == null?"nulo":siiConceptoCuo.toString()));
                                   if (siiConceptoCuo.getCcuAbreviatura().equals("DE"))
                                              concepto="DEI";
                                   if (siiConceptoCuo.getCcuAbreviatura().equals("GA"))
                                               concepto="GAI";
                                 
                                 listaSiiCuentaContTDC=detalleRecaudoDao.buscarCuentaContTipoDocContXCodigoConceptoTcartera(concepto, siiCuotaoperador.getCopTipoCartera(),tipoDocContable);
                                         
                                 for(SiiCuentaContTipoDocCont unSiiCuentaContTDCont :listaSiiCuentaContTDC){
                                     SiiImputacionContable siiImputacionContInt= new SiiImputacionContable();
                                     siiImputacionContInt.setSiiCuentasContables(unSiiCuentaContTDCont.getSiiCuentasContables());
                                     siiImputacionContInt.setImcTipoMovim(unSiiCuentaContTDCont.getCctTipoMovim());
                                     
                                     SiiCuentasContables siiCuentasCont = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTDCont.getSiiCuentasContables().getCcoCodigo());
                                     //validaciones
                                     if(siiCuentasCont.getCcoObligaTerc().equals("S") )
                                          siiImputacionContInt.setSiiPersona(siiPersona);
                                     if(siiCuentasCont.getCcoNumDocConta().equals("S") )
                                         siiImputacionContInt.setSiiDocumentoContable(insertSiiDocumentoContable);    
                                     if(siiCuentasCont.getCcoReferencia1().equals("S") ){
                                             Calendar cal=Calendar.getInstance();
                                             DateFormat format=new SimpleDateFormat("yyyy/mm/dd");
                                             if(siiCuotaoperador.getSiiAcuerdoPago()!= null){
                                                 format.format(siiCuotaoperador.getSiiAcuerdoPago().getApaFechaResol());
                                                 cal=format.getCalendar();
                                                 siiImputacionContInt.setImcReferencia1(siiCuotaoperador.getSiiAcuerdoPago().getApaNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                             }
                                             /* if(siiCuotaoperador.getSiiMulta()!= null){
                                                 format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                                 cal=format.getCalendar(); 
                                                 siiImputacionContInt.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                             }
                                             if(siiCuotaoperador.getSiiSancion()!= null){
                                                 format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                                 cal=format.getCalendar(); 
                                                 siiImputacionContInt.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                             } */
                                             if(siiCuotaoperador.getSiiLiquidacionMes()!= null){
                                                 siiImputacionContInt.setImcReferencia1(siiContrato.getConNumero());   
                                             }
                                             if(siiCuotaoperador.getSiiRifaPromocional()!= null){
                                             siiImputacionContInt.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString());
                                            }
                                     } 
                                     
                                     if(siiCuentasCont.getCcoReferencia2().equals("S"))
                                          siiImputacionContInt.setImcReferencia2(String.valueOf(siiCuotaoperador.getCopNumCuota()));
                                     
                                     siiImputacionContInt.setImcDescrOperacion("Recaudo Interes Web Services");
                                     siiImputacionContInt.setImcValor(unSiiDetalleDeclaracion.getDdeValorInter());
                                     siiImputacionContInt.setImcEstado("A");
                                     imputacionContableDao.insertarImputacionContable(siiImputacionContInt);
                                 }
                          }
                        
                        //movimiento contable de saldo  recaudo por clasificar
                        if(saldoCuota.compareTo(BigDecimal.ZERO)<0  ){    
                            List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocContSaldoCuota= new ArrayList<SiiCuentaContTipoDocCont>();
                            listaSiiCuentaContTipoDocContSaldoCuota=detalleRecaudoDao.BuscarCuentaContTipoDocContXCodigoConceptoDestino(siiConceptoCuota.getCcuDestino(),tipoDocContable);
                            for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont :listaSiiCuentaContTipoDocContSaldoCuota){
                                SiiImputacionContable siiImputacionContableCuotaSaldo= new SiiImputacionContable();
                                siiImputacionContableCuotaSaldo.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                                siiImputacionContableCuotaSaldo.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                                SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                                
                                //validaciones
                                if(siiCuentasContables.getCcoObligaTerc().equals("S") )
                                     siiImputacionContableCuotaSaldo.setSiiPersona(siiPersona);
                                
                                if(siiCuentasContables.getCcoNumDocConta().equals("S") )
                                    siiImputacionContableCuotaSaldo.setSiiDocumentoContable(insertSiiDocumentoContable);
                               
                                if(siiCuentasContables.getCcoReferencia1().equals("S") ){
                                        Calendar cal=Calendar.getInstance();
                                        DateFormat format=new SimpleDateFormat("yyyy/mm/dd");
                                        if(siiCuotaoperador.getSiiAcuerdoPago()!= null){
                                            format.format(siiCuotaoperador.getSiiAcuerdoPago().getApaFechaResol());
                                            cal=format.getCalendar();
                                            siiImputacionContableCuotaSaldo.setImcReferencia1(siiCuotaoperador.getSiiAcuerdoPago().getApaNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                        }
                                        /* if(siiCuotaoperador.getSiiMulta()!= null){
                                            format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                            cal=format.getCalendar(); 
                                            siiImputacionContableCuotaSaldo.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                        }
                                        if(siiCuotaoperador.getSiiSancion()!= null){
                                            format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                            cal=format.getCalendar(); 
                                            siiImputacionContableCuotaSaldo.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                        } */
                                        if(siiCuotaoperador.getSiiLiquidacionMes()!= null){
                                            siiImputacionContableCuotaSaldo.setImcReferencia1(siiContrato.getConNumero());   
                                        }
                                        if(siiCuotaoperador.getSiiRifaPromocional()!= null){
                                          siiImputacionContableCuotaSaldo.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString());
                                        }
                                } 
                                               
                                siiImputacionContableCuotaSaldo.setImcDescrOperacion("Recaudo por clasificar Web Services  ");
                                siiImputacionContableCuotaSaldo.setImcValor(saldoCuota.multiply(b1));
                                siiImputacionContableCuotaSaldo.setImcEstado("A");
                                imputacionContableDao.insertarImputacionContable(siiImputacionContableCuotaSaldo); 
                            }     
                        }
                        
                        //movimiento contable de interes  recaudo por clasificar
                        if(saldoCuotaInt.compareTo(BigDecimal.ZERO)<0  ){    
                            List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocContSaldoInt= new ArrayList<SiiCuentaContTipoDocCont>();
                            listaSiiCuentaContTipoDocContSaldoInt=detalleRecaudoDao.BuscarCuentaContTipoDocContXCodigoConceptoDestino(siiConceptoCuota.getCcuDestino(),tipoDocContable);
                        
                            for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont :listaSiiCuentaContTipoDocContSaldoInt){
                                SiiImputacionContable siiImputacionContableCuotaInt= new SiiImputacionContable();
                                siiImputacionContableCuotaInt.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                                siiImputacionContableCuotaInt.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                                SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                                
                                //validaciones
                                if(siiCuentasContables.getCcoObligaTerc().equals("S") )
                                     siiImputacionContableCuotaInt.setSiiPersona(siiPersona);
                                
                                if(siiCuentasContables.getCcoNumDocConta().equals("S") )
                                    siiImputacionContableCuotaInt.setSiiDocumentoContable(insertSiiDocumentoContable);
                                if(siiCuentasContables.getCcoReferencia1().equals("S") ){
                                        Calendar cal=Calendar.getInstance();
                                        DateFormat format=new SimpleDateFormat("yyyy/mm/dd");
                                        if(siiCuotaoperador.getSiiAcuerdoPago()!= null){
                                            format.format(siiCuotaoperador.getSiiAcuerdoPago().getApaFechaResol());
                                            cal=format.getCalendar();
                                            siiImputacionContableCuotaInt.setImcReferencia1(siiCuotaoperador.getSiiAcuerdoPago().getApaNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                        }
                                        /* if(siiCuotaoperador.getSiiMulta()!= null){
                                            format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                            cal=format.getCalendar(); 
                                            siiImputacionContableCuotaInt.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                        }
                                        if(siiCuotaoperador.getSiiSancion()!= null){
                                            format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                            cal=format.getCalendar(); 
                                            siiImputacionContableCuotaInt.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                        } */
                                        if(siiCuotaoperador.getSiiLiquidacionMes()!= null){
                                            siiImputacionContableCuotaInt.setImcReferencia1(siiContrato.getConNumero());   
                                        }
                                       if(siiCuotaoperador.getSiiRifaPromocional()!= null){
                                            siiImputacionContableCuotaInt.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString());
                                       }
                                } 
                                siiImputacionContableCuotaInt.setImcDescrOperacion("Recaudo Por clasificar Int Web Services ");
                                siiImputacionContableCuotaInt.setImcValor(saldoCuotaInt.multiply(b1));
                                siiImputacionContableCuotaInt.setImcEstado("A");
                                imputacionContableDao.insertarImputacionContable(siiImputacionContableCuotaInt); 
            
                            }
                            
                        }    
                        // inactiva cuotas sugeridas o modificadas 
                        List<SiiCuotaOperador> ListCuotas = cuotaOperadorDao.buscarCuotaOperadorXContratoXNumCuota(siiContrato.getConNumero(), siiCuotaoperador.getCopNumCuota(),siiCuotaoperador.getSiiConceptoCuota().getCcuAbreviatura());
                        for (SiiCuotaOperador siiCuotaOpe :ListCuotas){
                            if(siiCuotaOpe.getCopCancelada().equals("T") || siiCuotaOpe.getCopCancelada().equals("A") ){
                                siiCuotaOpe.setCopCancelada("I");
                                siiCuotaOpe=cuotaOperadorDao.actualizarCuotaOperador(siiCuotaOpe); 
                            }
                        }
                        
                       //Actualiza Cuota Operador  a estado Cancelado
                       siiCuotaoperador.setCopCancelada("C");
                       siiCuotaoperador=cuotaOperadorDao.actualizarCuotaOperador(siiCuotaoperador); 
                                                                               
                       
             
                    }
            }
                    pagoRecaudoResponseWSVO.codigoError = 0;
                    pagoRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("0").get(0);
                    pagoRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("0").get(1);
                    pagoRecaudoResponseWSVO.horaPago = calendar.getTime();
                
            return pagoRecaudoResponseWSVO;
                
        } catch (ExcepcionDAO ex){
            ex.printStackTrace();
            throw ex;
        } catch(Exception ex){           
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
          
        } 
                
              
        
       
    }

    /**
     *Metodo encargado de hacer la anulacion de un pago recaudo registrado por medio del ws
     * @author David Tafur
     * @param anulacionRecaudoWSVO
     * @return AnulacionRecaudoResponseWSVO
     */
    public AnulacionRecaudoResponseWSVO anulacionPagoRecaudo(AnulacionRecaudoWSVO anulacionRecaudoWSVO)throws ExcepcionDAO,ExcepcionAplicacion {
       
        Calendar calendar = Calendar.getInstance();
        /*
        * Variable usada para guardar la informacion de respuesta que se devolvera por el webServices luego
        * del pago exitoso
        */

        AnulacionRecaudoResponseWSVO anulacionRecaudoResponseWSVO = new AnulacionRecaudoResponseWSVO();
         /*
         *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         * Posibles errores asociados a la operacion de consulta, que debe manejar el web services
         * en caso de que se presente alguno de los escenarios.
         * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/*/
      
        Map<String, List<Object>> erroresRespuesta = new HashMap<String, List<Object>>();
        List<Object> error = new ArrayList<Object>();

        error.add("Transacción Exitosa");
        error.add("Ejecución Correcta");
        erroresRespuesta.put("0", error);
        error = new ArrayList<Object>();
        
        error.add("Error de Conexión");
        error.add("Falla de infraestructura");
        erroresRespuesta.put("5", error);
        error = new ArrayList<Object>();
        
        error.add("Fuera de línea");
        error.add("Se interrumpe la comunicación");
        erroresRespuesta.put("6", error);
        error = new ArrayList<Object>();
        
        error.add("Formato Invalido");
        error.add("El formato de la trama es incorrecto");
        erroresRespuesta.put("8", error);
        error = new ArrayList<Object>();
        
        error.add("Anulación ya hecha");
        error.add("La anulación se ejecuta por segunda vez");
        erroresRespuesta.put("9", error);
        error = new ArrayList<Object>();


        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/FIN MENSAJES ERROR_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/

        SiiDetalleDeclaracion siiDetalleDeclaracion = new SiiDetalleDeclaracion();
        SiiOperacionLineaBan siiOperacionLineaBanNew = new SiiOperacionLineaBan();
        SiiOperacionLineaBan siiOperacionLineaBan = new SiiOperacionLineaBan();
        SiiRecaudoLineaBan siiRecaudoLineaBan = new SiiRecaudoLineaBan();
        SiiDetalleRecaudo siiDetalleRecaudo = new SiiDetalleRecaudo();
        SiiDocumentoContable siiDocumentoContable = new SiiDocumentoContable();
        List<SiiRecaudoEstablec> listaRecaudoEstablec= new ArrayList();
        try {
            //verifica si ya fue anulada.
            siiRecaudoLineaBan = recaudoLineaBanDAO.buscarRecaudoLineaBanXRef(anulacionRecaudoWSVO.refererenciaPrincipal);
            if(siiRecaudoLineaBan.getSiiOperacionLineaBanAnula() == null){
            
                ////inserta Operación de banco
                siiOperacionLineaBanNew.setOlbCodigoResp(0);
                siiOperacionLineaBanNew.setOlbCodEan(anulacionRecaudoWSVO.codEAN.longValue());
                siiOperacionLineaBanNew.setOlbDatosAdicion((String) erroresRespuesta.get("0").get(1));
                siiOperacionLineaBanNew.setOlbFecha(anulacionRecaudoWSVO.fechaOperacion);
                siiOperacionLineaBanNew.setOlbFechaReg(calendar.getTime());
                Random random = new Random();
                int i = random.nextInt(100000);
                siiOperacionLineaBanNew.setOlbIdWebservice(System.currentTimeMillis() + "_" + i);
                siiOperacionLineaBanNew.setOlbRefPrincipal(anulacionRecaudoWSVO.refererenciaPrincipal);
                siiOperacionLineaBanNew.setOlbRefSecund(anulacionRecaudoWSVO.refererenciaSecundaria);
                siiOperacionLineaBanNew.setOlbTipoOperacion("A");
                siiOperacionLineaBanNew.setOlbValor(anulacionRecaudoWSVO.valorTotal);
                siiOperacionLineaBanNew = operacionLineaBanDAO.insertarSiiOperacionLineaBan(siiOperacionLineaBanNew);
                                
                siiRecaudoLineaBan.setSiiOperacionLineaBanAnula(siiOperacionLineaBanNew);
                siiRecaudoLineaBan=recaudoLineaBanDAO.actualizarSiiRecaudoLineaBan(siiRecaudoLineaBan);

               //Busca declaracion 
                siiDetalleDeclaracion =
                    detalleDeclaracionDAO.buscarDetalleDeclaracionPorReferenciaPago(Long.parseLong(anulacionRecaudoWSVO.refererenciaPrincipal));
           
                
                //Actualiza a anulado el documento contable
                siiDocumentoContable = documentoContableDao.buscarDocumentoContableXIDdetalleRecaudo(siiDetalleDeclaracion.getSiiDetalleRecaudo().getDreCodigo());
                siiDocumentoContable.setDcoMotivoAnula("Web Services BBVA");
                documentoContableDao.actualizar(siiDocumentoContable);
                
                //Actualiza el recaudo Establecimiento a 0 
                listaRecaudoEstablec= recaudoEstablecDao.buscarRecEstPorIdDetalleDec(siiDetalleDeclaracion.getDdeCodigo());
                for (SiiRecaudoEstablec siiRecaudoEstablec:listaRecaudoEstablec){
                    siiRecaudoEstablec.setReeValorPagado(BigDecimal.ZERO);
                    siiRecaudoEstablec.setReeValorPropio(BigDecimal.ZERO);
                    siiRecaudoEstablec.setReeValorTodos(BigDecimal.ZERO);
                    recaudoEstablecDao.actualizarSiiRecaudoEstablec(siiRecaudoEstablec);
                }
              
                // Actualiza declaración
                siiDetalleDeclaracion.setDdeValorPagado(BigDecimal.ZERO);
                siiDetalleDeclaracion.setDdeValorPagInt(BigDecimal.ZERO);
                siiDetalleDeclaracion.setSiiDetalleRecaudo(null);
                siiDetalleDeclaracion.setDdeEstado("I");
                siiDetalleDeclaracion = detalleDeclaracionDAO.actualizarDetalleDeclaracion(siiDetalleDeclaracion);
                
                //Recalcula intereses en caso de anulacion en fechas posteriores al pago 
                int dias = 0;
                GregorianCalendar fechaFin= new GregorianCalendar();
                fechaFin.setTime(anulacionRecaudoWSVO.fechaOperacion);
                GregorianCalendar fechaInicio= new GregorianCalendar();
                fechaInicio.setTime(siiRecaudoLineaBan.getSiiOperacionLineaBan().getOlbFecha());
                dias =(fechaFin.get(Calendar.DAY_OF_YEAR)- fechaInicio.get(Calendar.DAY_OF_YEAR));
                                  
                for(int j = 0 ; dias > j ; i++  ){
                        SiiLiquidacionMes unaSiiLiquidacionMes = new SiiLiquidacionMes();
                        List<SiiConceptoCuota> listaSiiConceptoCuota  = new ArrayList();
                        List<InteresCuotaVO> listInteresVo = new ArrayList<InteresCuotaVO>();
                        List<InteresCuotaVO>  listaIntereses = new ArrayList<InteresCuotaVO>(); 
                    
                        unaSiiLiquidacionMes = LiquidacionMesDao.liquidaciónMesRefPago(Long.parseLong(anulacionRecaudoWSVO.refererenciaPrincipal));
                        listaSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXAbreviatura(unaSiiLiquidacionMes.getLiqConcepto());
                        SiiContrato siiContrato = contratoDao.contratoXRefPagoDeclaracion(Long.parseLong(anulacionRecaudoWSVO.refererenciaPrincipal));
                        listaIntereses = liquidacionMesDao.buscarInteresDiarioXCUOTA(fechaFin.getTime(),unaSiiLiquidacionMes.getLmeNumCuota(),
                                                                      listaSiiConceptoCuota.get(0).getCcuNombre(),siiContrato.getConNumero()); 
                        for (InteresCuotaVO unInteresCuotaVo : listaIntereses){
                           unInteresCuotaVo.setIcuValor(Utilidades.redondear (unInteresCuotaVo.getIcuValor(), 0));
                           SiiInteresCuota siiInteresCuota= conversionVoEntidad.convertir(unInteresCuotaVo);
                           SiiInteresCuota siiInteresCuotaResult = interesCuotaDao.insertarSiiInteresCuota(siiInteresCuota);
                        }
                        fechaFin.add(Calendar.DAY_OF_YEAR, -1);
                        dias=dias-1;
                }
                
                //Envio de respuesta
                anulacionRecaudoResponseWSVO.codigoError = 0;
                anulacionRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("0").get(0);
                anulacionRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("0").get(1);
                anulacionRecaudoResponseWSVO.horaPago = calendar.getTime();
            }
            else {
                anulacionRecaudoResponseWSVO.codigoError = 9;
                anulacionRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("9").get(0);
                anulacionRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("9").get(1);
                anulacionRecaudoResponseWSVO.horaPago = calendar.getTime();
            }
            
            
        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();
            throw ex;
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
        }


        return anulacionRecaudoResponseWSVO;
    }


}
