package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoInteresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InteresCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionEstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionMesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PagoOpePseDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecaudoEstablecDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReferenciaPagoDeclDAO;
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
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoEstablec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoPse;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ValidacionInteresVO;
import co.gov.coljuegos.siicol.ejb.vo.pagoOperadoresPSE.PagoOperadoresPseVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PagoRecaudoPSEWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.PagoRecaudoResponseWSVO;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRecaudoPSEWSBean  implements AdminRecaudoPSEWS{
    
    
    @EJB
    DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    TipoDocContableDAO tipoDocContableDao;
    @EJB
    DocumentoContableDAO documentoContableDao;
    @EJB
    ConceptoCuotaDAO conceptoCuotaDao;
    @EJB
    OperadorDAO operadorDao;
    @EJB
    ImputacionContableDAO imputacionContableDao;
    @EJB
    EstadoDocContabDAO estadoDocContabDao;
    @EJB
    PagoOpePseDAO pagoOpePseDao;
    @EJB
    CuentasContablesDAO cuentasContablesDao;
    @EJB
    LiquidacionEstablecimientoDAO liquidacionEstablecimientoDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    InteresCuotaDAO interesCuotaDao;
    @EJB
    DetalleRecaudoInteresDAO DetalleRecaudoInteresDao;
    @EJB
    RecaudoEstablecDAO recaudoEstablecDao;
    @EJB
    ReferenciaPagoDeclDAO referenciaPagoDeclDao;
    @EJB
    PersonaDAO personaDao;
    @EJB
    LiquidacionMesDAO liquidacionMesDao;
    @EJB
    ContratoDAO contratoDao;
    
    
    public PagoRecaudoResponseWSVO registroPagoRecaudoPSE ( PagoRecaudoPSEWSVO pagoRecaudoPSEWSVo) throws ExcepcionDAO,ExcepcionAplicacion {

            /*
            * Bandera usada para verificar si ocurrio un error
            */
            Calendar calendar = Calendar.getInstance();
            /*
            * Variable usada para guardar la informacion de respuesta que se devolvera por el webServices luego
            * del pago exitoso
            */
        
            PagoRecaudoResponseWSVO pagoRecaudoResponseWSVO = new PagoRecaudoResponseWSVO();
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
            
            error.add("Valor Incorrecto");
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
            error = new ArrayList<Object>();
            

            CuotaOperadorVO cuotaOperadorVo=new CuotaOperadorVO();
            PagoOperadoresPseVO unpagoOperadoresPseVo = new PagoOperadoresPseVO();
            SiiCuotaOperador siiCuotaoperador = new SiiCuotaOperador();
            BigDecimal tempTotalPagoAplicado = BigDecimal.ZERO;
            SiiDocumentoContable insertSiiDocumentoContable= new SiiDocumentoContable();
            SiiRecaudoPse  siiRecaudoPse = new SiiRecaudoPse();
            SiiRecaudoPse  siiRecaudoPse2 = new SiiRecaudoPse();
            List<SiiDetalleDeclaracion> siiListaDetalleDecl = new ArrayList();
            List<SiiDetalleDeclaracion> siiListaDetalleDecl2 = new ArrayList();
            List<SiiDetalleDeclaracion> siiListaDetalleDecl1 = new ArrayList();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String concepto=null;
            String tipoDocContable = null;
            
            try{
            
            //verifica que pago ya existe 
            siiRecaudoPse= pagoOpePseDao.buscarRecaudoPseXId(Long.parseLong((105+pagoRecaudoPSEWSVo.id.toString())));
            siiRecaudoPse2= pagoOpePseDao.buscarRecaudoPseXId(Long.parseLong((pagoRecaudoPSEWSVo.id.toString())));
            if (siiRecaudoPse!=null){
                pagoRecaudoResponseWSVO.codigoError = 4;
                pagoRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("4").get(0);
                pagoRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("4").get(1);
                pagoRecaudoResponseWSVO.horaPago = calendar.getTime();
                return pagoRecaudoResponseWSVO;
            }
            if (siiRecaudoPse2!=null){
                pagoRecaudoResponseWSVO.codigoError = 4;
                pagoRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("4").get(0);
                pagoRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("4").get(1);
                pagoRecaudoResponseWSVO.horaPago = calendar.getTime();
                return pagoRecaudoResponseWSVO;
            }
           
            int pos=0;
            int pos2=0;
            pos=pagoRecaudoPSEWSVo.referencia1.indexOf("|",pos+1 );
            pos2=pagoRecaudoPSEWSVo.referencia1.indexOf("|",pos+1 );
            siiListaDetalleDecl1 = detalleRecaudoDao.BuscarDetalleDeclaracionXIdRefPagoSinPago(Long.parseLong( pagoRecaudoPSEWSVo.referencia1.substring(0,pos)));
            siiListaDetalleDecl2=detalleRecaudoDao.BuscarDetalleDeclaracionXIdRefPagoSinPago(Long.parseLong(pagoRecaudoPSEWSVo.referencia1.substring(pos+1,pos2))); 
            if (siiListaDetalleDecl2.size()>0 )
               siiListaDetalleDecl.add(siiListaDetalleDecl2.get(0));
               
            if ( siiListaDetalleDecl1.size()>0  )
               siiListaDetalleDecl.add(siiListaDetalleDecl1.get(0));
            
                 
                        
            BigDecimal temp = new BigDecimal(0);
               for(SiiDetalleDeclaracion unaListaDetalleDecl :siiListaDetalleDecl ) {                   
                   if(unaListaDetalleDecl.getDdeValorInter() != null)
                   temp=temp.add(unaListaDetalleDecl.getDdeValorDeclarado().add(unaListaDetalleDecl.getDdeValorInter()));
                   else 
                   temp=temp.add(unaListaDetalleDecl.getDdeValorDeclarado());
               }
               
            if(siiListaDetalleDecl.size()>0  ){
                if( temp.compareTo(pagoRecaudoPSEWSVo.valorPagado)==0 ){
                    for(SiiDetalleDeclaracion unaSiiDetalleDeclaracion :siiListaDetalleDecl){
    
                           //inserta el recaudo de PSE
                           siiRecaudoPse = new SiiRecaudoPse();
                           siiRecaudoPse.setRpsEstado("A");
                           siiRecaudoPse.setRpsCodigoTrans(pagoRecaudoPSEWSVo.codigoTransaccion);
                           siiRecaudoPse.setRpsFechaEstado(pagoRecaudoPSEWSVo.fechaEstado);
                           siiRecaudoPse.setRpsReferencia1( unaSiiDetalleDeclaracion.getSiiReferenciaPagoDecl().getRpdNumero().toString());
                           if (unaSiiDetalleDeclaracion.getSiiReferenciaPagoDecl().getRpdNumero().toString().substring(0,3).equals("105"))
                                siiRecaudoPse.setRpsCodigo(Long.parseLong((105+pagoRecaudoPSEWSVo.id.toString())));
                           if (unaSiiDetalleDeclaracion.getSiiReferenciaPagoDecl().getRpdNumero().toString().substring(0,3).equals("205"))
                                siiRecaudoPse.setRpsCodigo(Long.parseLong((205+pagoRecaudoPSEWSVo.id.toString())));
                           siiRecaudoPse=pagoOpePseDao.insertarPagoOperadorPse(siiRecaudoPse);   
                        
                        //busqueda el saldo de la  cuota 
                        List<SiiDetalleDeclaracion> siiListaDetalleDeclPagos= detalleDeclaracionDao.buscarDetalleDeclaracionPorXCodigoCuota(unaSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                        ValidacionInteresVO unValidacionInteresVo = interesCuotaDao.buscarSaldoPagoInteresesXcodigoCuota(unaSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                        SiiCuotaOperador unSiiCuotaOperador=  cuotaOperadorDao.buscarCuotaOperadorPorId(unaSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                        
                        //busca si hay recaudo por clasificar
                        BigDecimal tempPago = BigDecimal.ZERO;
                        BigDecimal tempPagoInt = BigDecimal.ZERO;
                        BigDecimal saldoCuota = BigDecimal.ZERO;
                        BigDecimal saldoCuotaInt = BigDecimal.ZERO;
                         
                        for (SiiDetalleDeclaracion unSiiDetalleDeclaracionPago:siiListaDetalleDeclPagos  ){
                            if( unSiiDetalleDeclaracionPago.getDdeValorPagado() != null)
                                tempPago = tempPago.add(unSiiDetalleDeclaracionPago.getDdeValorPagado());
                              
                            if( unSiiDetalleDeclaracionPago.getDdeValorPagInt() != null)
                                tempPagoInt= tempPagoInt.add(unSiiDetalleDeclaracionPago.getDdeValorPagInt());
                        }
                        
                        if(unaSiiDetalleDeclaracion.getDdeValorPagado()!= null && unaSiiDetalleDeclaracion.getDdeValorPagado().compareTo(BigDecimal.ZERO)>0)
                            saldoCuota=(unSiiCuotaOperador.getCopValor().subtract(tempPago));
                        if(unaSiiDetalleDeclaracion.getDdeValorPagInt()!= null && unaSiiDetalleDeclaracion.getDdeValorPagInt().compareTo(BigDecimal.ZERO)>0 )
                            saldoCuotaInt=(unValidacionInteresVo.getInteresGenerado().subtract(tempPagoInt));
                    
                           //Inserta el detalle recaudo por cada registro 
                           SiiDetalleRecaudo siiDetalleRecaudo= new SiiDetalleRecaudo();
                           BigDecimal tempCancelaCuota = new BigDecimal(0);
                           siiDetalleRecaudo.setDreRefPago(siiRecaudoPse.getRpsReferencia1());
                           siiDetalleRecaudo.setDreValor(pagoRecaudoPSEWSVo.valorPagado);
                           siiDetalleRecaudo.setDreEstado("A");
                           siiDetalleRecaudo.setSiiRecaudoPse(siiRecaudoPse);
                           siiDetalleRecaudo= detalleRecaudoDao.insertar(siiDetalleRecaudo);
                           //le agrega al detalle declaracion el detalle recaudo
                           unaSiiDetalleDeclaracion.setSiiDetalleRecaudo(siiDetalleRecaudo);
                           unaSiiDetalleDeclaracion.setDdeValorPagado(unaSiiDetalleDeclaracion.getDdeValorDeclarado());
                           unaSiiDetalleDeclaracion.setDdeValorPagInt(unaSiiDetalleDeclaracion.getDdeValorInter());
                           detalleDeclaracionDao.actualizarDetalleDeclaracion(unaSiiDetalleDeclaracion);  
                           
                           siiCuotaoperador= cuotaOperadorDao.buscarCuotaOperadorPorId(unaSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                                
                           //valida si ya es >= el total de la cuota para colocarlo en estado cancelado 
                           cuotaOperadorVo=cuotaOperadorDao.BuscarTotalDetalleDeclaracionXIdCuota(siiCuotaoperador.getCopCodigo());
                    
                            //insertar recaudo Establecimiento
                            List<SiiLiquidacionEstabl> listaSiiLiquidacionEstabl = new ArrayList<SiiLiquidacionEstabl>();
                            listaSiiLiquidacionEstabl =  liquidacionEstablecimientoDao.buscarTodaLiquidacionEstablXidCuotaOperador(siiCuotaoperador.getCopCodigo());
                            for (SiiLiquidacionEstabl unaSiiLiquidacionEstabl :listaSiiLiquidacionEstabl)  {
                                SiiRecaudoEstablec siiRecaudoEstbl= new SiiRecaudoEstablec();
                                siiRecaudoEstbl.setSiiDetalleDeclaracion(unaSiiDetalleDeclaracion);
                                siiRecaudoEstbl.setSiiLiquidacionEstabl(unaSiiLiquidacionEstabl); 
                                if(unaSiiDetalleDeclaracion.getDdeValorPagado()!= null)
                                      siiRecaudoEstbl.setReeValorPagado(unaSiiDetalleDeclaracion.getDdeValorPagado().multiply( unaSiiLiquidacionEstabl.getLesPonderado())); 
                                if( unaSiiDetalleDeclaracion.getDdeValorPagInt()!= null )
                                       siiRecaudoEstbl.setReeValorPagInter(unaSiiDetalleDeclaracion.getDdeValorPagInt().multiply( unaSiiLiquidacionEstabl.getLesPonderado()));
                                recaudoEstablecDao.insertarRecaudoEstablec(siiRecaudoEstbl);
                            }
                            
                        
                            SiiOperador siiOperador= operadorDao.buscarPorCodigoOperador(siiCuotaoperador.getSiiOperador().getOpeCodigo());
                            SiiPersona siiPersona=  personaDao.buscarPersonaPorId(siiOperador.getSiiPersona().getPerCodigo());
                               
                            //buscar numero de contrato
                            SiiContrato siiContrato = new SiiContrato();
                            if(siiCuotaoperador.getSiiLiquidacionMes()!= null  ){
                                SiiLiquidacionMes  siiLiquidacionMes = liquidacionMesDao.buscarLiquidacionMesPorId(siiCuotaoperador.getSiiLiquidacionMes().getLmeCodigo());
                                 siiContrato= contratoDao.buscarContratoPorId(siiLiquidacionMes.getSiiContrato().getConCodigo());
                            }
                        
                        //busca el concepto de la cuota 
                        SiiConceptoCuota siiConceptoCuota = conceptoCuotaDao.buscarConceptoCuotaXId(siiCuotaoperador.getSiiConceptoCuota().getCcuCodigo());
                        
                        //Si la cuota es menor que octubre 2015, crea RPB de lo contrario RPI//se coloco 2020 mientras validad a que fecha se debe publicar este cambio
                       // if (unSiiCuotaOperador.getCopVigencia().equals("2020") && unSiiCuotaOperador.getMesCodigo()<10 ){
                            tipoDocContable = "RPB";
                        //}
                        //else 
                          //  tipoDocContable = "RPI";
                        
                        //Movimiento contable
                        TipoDocContableVO  tipoDocContableVo=new TipoDocContableVO();
                        SiiTipoDocContable siiTipoDocContable =tipoDocContableDao.buscarPorCodigo(tipoDocContable);
                        Integer consecutivo =documentoContableDao.buscarConsecutivoDocumentoContable(tipoDocContable);
                        insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                        insertSiiDocumentoContable.setDcoFechaOper(pagoRecaudoPSEWSVo.fechaEstado);
                        insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                        String nombreEstado = "BORRADOR";
                        SiiEstadoDocContab  siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
                        insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                        insertSiiDocumentoContable=documentoContableDao.insertar(insertSiiDocumentoContable);
                        
                        //imputacion contable General
                        SiiImputacionContable siiTotalImputacionContable= new SiiImputacionContable();
                        //SiiCuentaContTipoDocCont siiCuentaContTipoDocCont= new SiiCuentaContTipoDocCont();  
                        //siiCuentaContTipoDocCont=detalleRecaudoDao.BuscarCuentaContTipoDocContXRPBConceptoTercero("PSE");
                        String grupoRecaudo=  (unaSiiDetalleDeclaracion.getSiiReferenciaPagoDecl().getRpdNumero().toString()).substring(0,3);
                        SiiCuentasContables siiCuentasContable= detalleRecaudoDao.BuscarCuentaContTipoDocContXCodigoConcSinTer("PSE",tipoDocContable );
                        siiTotalImputacionContable.setSiiCuentasContables(siiCuentasContable);
                        siiTotalImputacionContable.setImcTipoMovim("D");
                        if(siiCuentasContable.getCcoNumDocConta().equals("S"))
                            siiTotalImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
                        siiTotalImputacionContable.setImcDescrOperacion("Pago Importado PSE || "+ insertSiiDocumentoContable.getDcoFechaOper());
                        siiTotalImputacionContable.setImcValor(unaSiiDetalleDeclaracion.getDdeValorPagado().add(unaSiiDetalleDeclaracion.getDdeValorPagInt()));
                       
                        if(siiCuentasContable.getCcoReferencia1().equals("S") ){
                                Calendar cal=Calendar.getInstance();
                                DateFormat format=new SimpleDateFormat("yyyy/mm/dd");
                                if(siiCuotaoperador.getSiiAcuerdoPago()!= null){
                                    format.format(siiCuotaoperador.getSiiAcuerdoPago().getApaFechaResol());
                                    cal=format.getCalendar();
                                    siiTotalImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiAcuerdoPago().getApaNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                }
                                /*if(siiCuotaoperador.getSiiMulta()!= null){
                                    format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                    cal=format.getCalendar(); 
                                    siiTotalImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                }
                                if(siiCuotaoperador.getSiiSancion()!= null){
                                    format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                    cal=format.getCalendar(); 
                                    siiTotalImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                }*/
                                if(siiCuotaoperador.getSiiLiquidacionMes()!= null){
                                    siiTotalImputacionContable.setImcReferencia1(siiContrato.getConNumero());   
                                }
                                if(siiCuotaoperador.getSiiRifaPromocional()!= null){
                                         siiTotalImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString()+
                                                                                      " - "+ cal.get(Calendar.YEAR));
                                }
                        } 
                        
                        if(siiCuentasContable.getCcoReferencia2().equals("S"))
                             siiTotalImputacionContable.setImcReferencia2(String.valueOf(siiCuotaoperador.getCopNumCuota()));
                        
                        siiTotalImputacionContable.setImcEstado("A");
                        imputacionContableDao.insertarImputacionContable(siiTotalImputacionContable);

                            //ingresar movimiento contable
                        if(unaSiiDetalleDeclaracion.getDdeValorDeclarado() != null ){
                            if(unaSiiDetalleDeclaracion.getDdeValorDeclarado().compareTo(BigDecimal.ZERO)>0 ){     
                                List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= new ArrayList<SiiCuentaContTipoDocCont>();
                                listaSiiCuentaContTipoDocCont=detalleRecaudoDao.buscarCuentaContTipoDocContXCodigoConceptoTcartera(siiConceptoCuota.getCcuAbreviatura(), siiCuotaoperador.getCopTipoCartera(),tipoDocContable);
                                for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont :listaSiiCuentaContTipoDocCont){
                                    SiiImputacionContable siiImputacionContable= new SiiImputacionContable();
                                    siiImputacionContable.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                                    siiImputacionContable.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                                    SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                                    if(siiCuentasContables.getCcoObligaTerc().equals("S") )
                                         siiImputacionContable.setSiiPersona(siiPersona);
                                    if(siiCuentasContables.getCcoReferencia1().equals("S") ){
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
                                                 siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString()+
                                                                                              " - "+ cal.get(Calendar.YEAR));
                                           }
                                    } 
                                    
                                    if(siiCuentasContables.getCcoReferencia2().equals("S"))
                                         siiImputacionContable.setImcReferencia2(String.valueOf(siiCuotaoperador.getCopNumCuota()));
                                    
                                    if(siiCuentasContables.getCcoNumDocConta().equals("S") )
                                        siiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
                                   
                                    siiImputacionContable.setImcDescrOperacion("Pago Importado PSE ||"+ insertSiiDocumentoContable.getDcoFechaOper() );
                                    
                                    if(saldoCuota.compareTo(BigDecimal.ZERO)<0  )
                                       siiImputacionContable.setImcValor(unaSiiDetalleDeclaracion.getDdeValorPagado().add(saldoCuota) );
                                    else
                                       siiImputacionContable.setImcValor(unaSiiDetalleDeclaracion.getDdeValorPagado());
                                    siiImputacionContable.setImcEstado("A");
                                    imputacionContableDao.insertarImputacionContable(siiImputacionContable);
                                }    
                            }
                        }
                            
                            //ingresar movimiento contable con intereses   
                        if( unaSiiDetalleDeclaracion.getDdeValorInter() != null){
                        if(unaSiiDetalleDeclaracion.getDdeValorInter().compareTo(BigDecimal.ZERO)>0  ){
                            List<SiiCuentaContTipoDocCont> listaSiiCuentaContTDC= new ArrayList<SiiCuentaContTipoDocCont>();
                            SiiCuotaOperador siiCuotaOpe=cuotaOperadorDao.buscarCuotaOperadorPorId(unaSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                             List<SiiConceptoCuota> listaSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXNombre(siiCuotaOpe.getSiiConceptoCuota().getCcuNombre());
                             if (listaSiiConceptoCuota.get(0).getCcuAbreviatura().equals("DE"))
                                        concepto="DEI";
                             if (listaSiiConceptoCuota.get(0).getCcuAbreviatura().equals("GA"))
                                         concepto="GAI"; 
                         
                            listaSiiCuentaContTDC=detalleRecaudoDao.buscarCuentaContTipoDocContXCodigoConceptoTcartera(concepto, siiCuotaoperador.getCopTipoCartera(),tipoDocContable);
                               
                            for(SiiCuentaContTipoDocCont unSiiCuentaContTDCont :listaSiiCuentaContTDC){
                                     SiiImputacionContable siiImputacionCont= new SiiImputacionContable();
                                     siiImputacionCont.setSiiCuentasContables(unSiiCuentaContTDCont.getSiiCuentasContables());
                                     siiImputacionCont.setImcTipoMovim(unSiiCuentaContTDCont.getCctTipoMovim());
                                     
                                     SiiCuentasContables siiCuentasCont = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTDCont.getSiiCuentasContables().getCcoCodigo());
                                     //validaciones
                                     if(siiCuentasCont.getCcoObligaTerc().equals("S") )
                                          siiImputacionCont.setSiiPersona(siiPersona);
                                     if(siiCuentasCont.getCcoNumDocConta().equals("S") )
                                         siiImputacionCont.setSiiDocumentoContable(insertSiiDocumentoContable);                         
                                     
                                     if(siiCuentasCont.getCcoReferencia1().equals("S") ){
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
                                                           siiImputacionCont.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString()+
                                                                                                        " - "+ cal.get(Calendar.YEAR));
                                                 }
                                         } 
                                         
                                     if(siiCuentasCont.getCcoReferencia2().equals("S"))
                                              siiImputacionCont.setImcReferencia2(String.valueOf(siiCuotaoperador.getCopNumCuota()));
                                
                                     siiImputacionCont.setImcDescrOperacion("Pago Interes Importado PSE  || "+ insertSiiDocumentoContable.getDcoFechaOper());
                                     siiImputacionCont.setImcValor(unaSiiDetalleDeclaracion.getDdeValorInter());
                                     siiImputacionCont.setImcEstado("A");
                                     imputacionContableDao.insertarImputacionContable(siiImputacionCont);
                                     
                           }
                         }
                        }
                        
                        //movimiento contable  recaudo por clasificar
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
                                                      siiImputacionContableCuotaSaldo.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString()+
                                                                                                   " - "+ cal.get(Calendar.YEAR));
                                       }
                                } 
                                
                               
                                siiImputacionContableCuotaSaldo.setImcDescrOperacion("Pago recaudo por clasificar Importado PSE || RPC-Pago ||  "+ insertSiiDocumentoContable.getDcoFechaOper());
                                siiImputacionContableCuotaSaldo.setImcValor(saldoCuota);
                                siiImputacionContableCuotaSaldo.setImcEstado("A");
                                imputacionContableDao.insertarImputacionContable(siiImputacionContableCuotaSaldo); 
                            }
                        }
                        //movimiento contable  recaudo por clasificar interes
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
                                                  siiImputacionContableCuotaInt.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString()+
                                                                                               " - "+ cal.get(Calendar.YEAR));
                                         }
                                } 
                                siiImputacionContableCuotaInt.setImcDescrOperacion("Pago recaudo por clasificar Int Importado PSE || RPC-Interes " + insertSiiDocumentoContable.getDcoFechaOper());
                                siiImputacionContableCuotaInt.setImcValor(saldoCuotaInt);
                                siiImputacionContableCuotaInt.setImcEstado("A");
                                imputacionContableDao.insertarImputacionContable(siiImputacionContableCuotaInt); 
                            }
                        }
                        // inactiva cuotas sugeridas o modificadas 
                        List<SiiCuotaOperador> ListCuotas = cuotaOperadorDao.buscarCuotaOperadorXContratoXNumCuota(siiContrato.getConNumero(), siiCuotaoperador.getCopNumCuota(),siiCuotaoperador.getSiiConceptoCuota().getCcuAbreviatura());
                        for (SiiCuotaOperador siiCuotaOpe :ListCuotas){
                            if(siiCuotaOpe.getCopCancelada().equals("T") || siiCuotaOpe.getCopCancelada().equals("A")   ){
                                siiCuotaOpe.setCopCancelada("I");
                                siiCuotaOpe=cuotaOperadorDao.actualizarCuotaOperador(siiCuotaOpe); 
                            }
                        }
                        
                            //Actualiza Cuota Operador  a estado Cancelado
                            siiCuotaoperador.setCopCancelada("C");
                            siiCuotaoperador=cuotaOperadorDao.actualizarCuotaOperador(siiCuotaoperador); 
                                                             
                           
                    } 
                    pagoRecaudoResponseWSVO.codigoError = 0;
                    pagoRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("0").get(0);
                    pagoRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("0").get(1);
                    pagoRecaudoResponseWSVO.horaPago = calendar.getTime();

                }
                else {
                    pagoRecaudoResponseWSVO.codigoError = 3;
                    pagoRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("3").get(0);
                    pagoRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("3").get(1);
                    pagoRecaudoResponseWSVO.horaPago = calendar.getTime();
                    
                    siiRecaudoPse = new SiiRecaudoPse();
                    siiRecaudoPse.setRpsEstado("I");
                    siiRecaudoPse.setRpsCodigoTrans(pagoRecaudoPSEWSVo.codigoTransaccion);
                    siiRecaudoPse.setRpsFechaEstado(pagoRecaudoPSEWSVo.fechaEstado);
                    siiRecaudoPse.setRpsReferencia1( pagoRecaudoPSEWSVo.referencia1);
                    siiRecaudoPse.setRpsCodigo(pagoRecaudoPSEWSVo.id);
                    siiRecaudoPse=pagoOpePseDao.insertarPagoOperadorPse(siiRecaudoPse);   
                }
            }
            else {
                pagoRecaudoResponseWSVO.codigoError = 1;
                pagoRecaudoResponseWSVO.mensajeError = (String) erroresRespuesta.get("1").get(0);
                pagoRecaudoResponseWSVO.mensajeErrorAlterno = (String) erroresRespuesta.get("1").get(1);
                pagoRecaudoResponseWSVO.horaPago = calendar.getTime();
                
                siiRecaudoPse = new SiiRecaudoPse();
                siiRecaudoPse.setRpsEstado("I");
                siiRecaudoPse.setRpsCodigoTrans(pagoRecaudoPSEWSVo.codigoTransaccion);
                siiRecaudoPse.setRpsFechaEstado(pagoRecaudoPSEWSVo.fechaEstado);
                siiRecaudoPse.setRpsReferencia1( pagoRecaudoPSEWSVo.referencia1);
                siiRecaudoPse.setRpsCodigo(pagoRecaudoPSEWSVo.id);
                siiRecaudoPse=pagoOpePseDao.insertarPagoOperadorPse(siiRecaudoPse);  
            }
            
            } catch (ExcepcionDAO ex){
                ex.printStackTrace();
                throw ex;
            } catch(Exception ex){
                ex.printStackTrace();
                throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
            }
            return pagoRecaudoResponseWSVO;
       
        }
    
}
