/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 03-02-2014
 */
package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
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
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PagoOperadoresPSE.PagoOperadoresPseDAO;
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
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ValidacionInteresVO;
import co.gov.coljuegos.siicol.ejb.vo.pagoOperadoresPSE.PagoOperadoresPseVO;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminPagoOperadoresPseBean  implements AdminPagoOperadoresPse{
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    PagoOperadoresPseDAO PagoOperadoresPseDao;
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
    PersonaDAO personaDao;
    @EJB
    LiquidacionMesDAO liquidacionMesDao;
    @EJB
    ContratoDAO contratoDao;
    @EJB
    DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    ArchivoFisicoDAO archivoFisicoDao;
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
             
                      
    
    public AdminPagoOperadoresPseBean() {
       
    }
    
    
    public List<PagoOperadoresPseVO> buscarTodoDetalleRecaudoXRecaudo(Date fechaActual ) throws ExcepcionDAO{        
            List<SiiRecaudoPse> listaSiiRecaudoPse;
            List<PagoOperadoresPseVO> listaPagoOperadoresPseVo= new ArrayList();
            listaPagoOperadoresPseVo = PagoOperadoresPseDao.buscarTodoDiaAnteriorPagoPse(fechaActual);
           //insertarPagoOperadoresPse(listaPagoOperadoresPseVo);     
             return listaPagoOperadoresPseVo;
        } 
    
    
    
    
    public PagoOperadoresPseVO  insertarPagoOperadoresPse (List<PagoOperadoresPseVO> lista ) throws ExcepcionDAO, ExcepcionAplicacion {
        CuotaOperadorVO cuotaOperadorVo=new CuotaOperadorVO();
        PagoOperadoresPseVO unpagoOperadoresPseVo= new PagoOperadoresPseVO();
        SiiCuotaOperador siiCuotaoperador = new SiiCuotaOperador();
        BigDecimal tempTotalPagoAplicado = BigDecimal.ZERO;
        List<SiiDetalleDeclaracion> siiListaDetalleDecl = new ArrayList();
        List<SiiDetalleDeclaracion> siiListaDetalleDecl2 = new ArrayList();
        List<SiiDetalleDeclaracion> siiListaDetalleDecl1 = new ArrayList();
        List<PagoOperadoresPseVO> listaPagos= new ArrayList();
        String concepto=null;
        String tipoDocContable;
        try{
         
        if(lista != null && lista.size() > 0 ){

            for(PagoOperadoresPseVO unPagoOperadoresPseVo:lista) {
                     siiListaDetalleDecl1.clear();
                     siiListaDetalleDecl2.clear();
                     siiListaDetalleDecl.clear();
                
                     siiListaDetalleDecl1 = detalleRecaudoDao.BuscarDetalleDeclaracionXIdRefPagoSinPago(Long.parseLong(unPagoOperadoresPseVo.getRpsReferencia1()));
                     siiListaDetalleDecl2=detalleRecaudoDao.BuscarDetalleDeclaracionXIdRefPagoSinPago(Long.parseLong(unPagoOperadoresPseVo.getRpsReferencia2())); 
                     for (SiiDetalleDeclaracion unaSiiDetDec :siiListaDetalleDecl2)
                        siiListaDetalleDecl.add(unaSiiDetDec);
                        
                     for (SiiDetalleDeclaracion unaSiiDetDec1 :siiListaDetalleDecl1)
                        siiListaDetalleDecl.add(unaSiiDetDec1);
                    
                     BigDecimal temp = new BigDecimal(0);
                        for(SiiDetalleDeclaracion unaListaDetalleDecl :siiListaDetalleDecl ) {
                            if(unaListaDetalleDecl.getDdeValorInter() != null)
                            temp=temp.add(unaListaDetalleDecl.getDdeValorDeclarado().add(unaListaDetalleDecl.getDdeValorInter()));
                            else 
                            temp=temp.add(unaListaDetalleDecl.getDdeValorDeclarado());
                        }
                        
                    if(siiListaDetalleDecl.size()>0 && temp.compareTo(unPagoOperadoresPseVo.getValorPagado())==0 ){
        
                            for(SiiDetalleDeclaracion unaSiiDetalleDeclaracion :siiListaDetalleDecl){
                                SiiDocumentoContable insertSiiDocumentoContable= new SiiDocumentoContable();
                                PagoOperadoresPseVO newPagoOperadoresPseVo = new PagoOperadoresPseVO();
                                SiiRecaudoPse siiRecaudoPse= new SiiRecaudoPse();
                                   newPagoOperadoresPseVo.setRpsEstado("A");
                                if (unaSiiDetalleDeclaracion.getSiiReferenciaPagoDecl().getRpdNumero().toString().substring(0,3).equals("105")){
                                       newPagoOperadoresPseVo.setRpsReferencia1(unPagoOperadoresPseVo.getRpsReferencia1());
                                       newPagoOperadoresPseVo.setRpsCodigo(Long.parseLong((105+unPagoOperadoresPseVo.getRpsCodigo().toString())));
                                      
                                }
                                if (unaSiiDetalleDeclaracion.getSiiReferenciaPagoDecl().getRpdNumero().toString().substring(0,3).equals("205")){
                                        newPagoOperadoresPseVo.setRpsReferencia1(unPagoOperadoresPseVo.getRpsReferencia2());
                                        newPagoOperadoresPseVo.setRpsCodigo(Long.parseLong((205+unPagoOperadoresPseVo.getRpsCodigo().toString())));
                                        
                                }
                                   newPagoOperadoresPseVo.setRpsCodigoTrans(unPagoOperadoresPseVo.getRpsCodigoTrans());
                                   newPagoOperadoresPseVo.setRpsFechaEstado(unPagoOperadoresPseVo.getRpsFechaEstado());
                                   siiRecaudoPse = conversionVoEntidad.convertir(newPagoOperadoresPseVo);
                                
                                   siiRecaudoPse=pagoOpePseDao.insertarPagoOperadorPse(siiRecaudoPse);
                                   newPagoOperadoresPseVo= new PagoOperadoresPseVO(siiRecaudoPse);     
                    
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
                                   siiDetalleRecaudo.setDreValor(unaSiiDetalleDeclaracion.getDdeValorDeclarado().add(unaSiiDetalleDeclaracion.getDdeValorInter()));
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
                               //  if (siiCuotaoperador.getCopVigencia().equals("2020") && siiCuotaoperador.getMesCodigo()<10 ){
                                     tipoDocContable = "RPB";
                                // }
                                // else 
                                 //    tipoDocContable = "RPI";
                                
                                //inserta documento contable
                                TipoDocContableVO  tipoDocContableVo=new TipoDocContableVO();
                                SiiTipoDocContable siiTipoDocContable =tipoDocContableDao.buscarPorCodigo("RPB");
                                Integer consecutivo =documentoContableDao.buscarConsecutivoDocumentoContable("RPB");
                                insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                                insertSiiDocumentoContable.setDcoFechaOper(lista.get(0).getRpsFechaEstado());
                                insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                                insertSiiDocumentoContable.setSiiDetalleRecaudo(siiDetalleRecaudo);
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
                                if(siiCuentasContable.getCcoObligaTerc().equals("S") )
                                     siiTotalImputacionContable.setSiiPersona(siiPersona);
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
                                                    /*if(siiCuotaoperador.getSiiMulta()!= null){
                                                        format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                                        cal=format.getCalendar(); 
                                                        siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                                    }
                                                    if(siiCuotaoperador.getSiiSancion()!= null){
                                                        format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                                        cal=format.getCalendar(); 
                                                        siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                                    }*/
                                                    if(siiCuotaoperador.getSiiLiquidacionMes()!= null){
                                                        siiImputacionContable.setImcReferencia1(siiContrato.getConNumero());   
                                                    }
                                                   if(siiCuotaoperador.getSiiRifaPromocional()!= null){
                                                    siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString()+
                                                                               " - "+ cal.get(Calendar.YEAR));
                                                    }
                                            } 
                                            
                                            if(siiCuentasContables.getCcoNumDocConta().equals("S") )
                                                siiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
                                            if(siiCuentasContables.getCcoReferencia2().equals("S"))
                                                 siiImputacionContable.setImcReferencia2(String.valueOf(siiCuotaoperador.getCopNumCuota()));
                                           
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
                                     
                                     System.out.println("Resultado: " + (listaSiiConceptoCuota.get(0).getCcuAbreviatura() == null?"nulo":listaSiiConceptoCuota.get(0).getCcuAbreviatura().toString()));
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
                                               /*if(siiCuotaoperador.getSiiMulta()!= null){
                                                   format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                                   cal=format.getCalendar(); 
                                                   siiImputacionCont.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                               }
                                               if(siiCuotaoperador.getSiiSancion()!= null){
                                                   format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                                   cal=format.getCalendar(); 
                                                   siiImputacionCont.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                               }*/
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
                                BigDecimal b1 = new BigDecimal("-1");
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
                                                /*if(siiCuotaoperador.getSiiMulta()!= null){
                                                    format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                                    cal=format.getCalendar(); 
                                                    siiImputacionContableCuotaSaldo.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                                }
                                                if(siiCuotaoperador.getSiiSancion()!= null){
                                                    format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                                    cal=format.getCalendar(); 
                                                    siiImputacionContableCuotaSaldo.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                                }*/
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
                                                /*if(siiCuotaoperador.getSiiMulta()!= null){
                                                    format.format(siiCuotaoperador.getSiiMulta().getMulFechaResol());
                                                    cal=format.getCalendar(); 
                                                    siiImputacionContableCuotaInt.setImcReferencia1(siiCuotaoperador.getSiiMulta().getMulNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                                }
                                                if(siiCuotaoperador.getSiiSancion()!= null){
                                                    format.format(siiCuotaoperador.getSiiSancion().getSanFechaResol());
                                                    cal=format.getCalendar(); 
                                                    siiImputacionContableCuotaInt.setImcReferencia1(siiCuotaoperador.getSiiSancion().getSanNumResol()+ " - "+ cal.get(Calendar.YEAR));
                                                }*/
                                                if(siiCuotaoperador.getSiiLiquidacionMes()!= null){
                                                    siiImputacionContableCuotaInt.setImcReferencia1(siiContrato.getConNumero());   
                                                }
                                                if(siiCuotaoperador.getSiiRifaPromocional()!= null){
                                                siiImputacionContableCuotaInt.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString()+
                                                                                 " - "+ cal.get(Calendar.YEAR));
                                               }
                                        } 
                                        
                                        if(siiCuentasContables.getCcoReferencia2().equals("S"))
                                             siiImputacionContableCuotaInt.setImcReferencia2(String.valueOf(siiCuotaoperador.getCopNumCuota()));
                                        
                                       
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
                        }
                        else{
                            unPagoOperadoresPseVo.setRpsEstado("I");
                            SiiRecaudoPse  siiRecaudoPse = conversionVoEntidad.convertir(unPagoOperadoresPseVo);
                            siiRecaudoPse=pagoOpePseDao.insertarPagoOperadorPse(siiRecaudoPse);
                            unpagoOperadoresPseVo= new PagoOperadoresPseVO(siiRecaudoPse);  
                        }
            }
        }   
        
        else{
            // en caso de no encontrar ningun registro
            unpagoOperadoresPseVo= null;
        }
        } catch (ExcepcionDAO ex){
            ex.printStackTrace();
            throw ex;
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
        }
            
            
     return unpagoOperadoresPseVo; 
    }
    
}
