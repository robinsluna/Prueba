package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;


import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActaVisitaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoComisorioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InstrnoCorrespDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InstrumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioAutoComisorioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaVisita;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrNoCorresp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioAutoComis;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ActaVisitaVO;
import co.gov.coljuegos.siicol.ejb.wsvo.InventarioAutoComisWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ActaVisitaResponseWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ActaVisitaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.InstrnoCorrespWSVO;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminActaVisitaWSBean  implements AdminActaVisitaWS {
    @EJB 
    ActaVisitaDAO actaVisitaDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    AutoComisorioDAO autoComisorioDao;
    @EJB
    InventarioAutoComisorioDAO inventarioAutoComisorioDao;
    @EJB
    InstrumentoDAO instrumentoDao;
    @EJB
    InventarioDAO inventarioDao;
    @EJB
    InstrnoCorrespDAO instrnoCorrespDao;
    
    
    public ActaVisitaResponseWSVO registroActaVisita ( ActaVisitaWSVO actaVisitaWSVo) throws ExcepcionDAO,ExcepcionAplicacion {
        ActaVisitaResponseWSVO actaVisitaResponseWSVo = new  ActaVisitaResponseWSVO();
        SiiActaVisita siiActaVisita = new  SiiActaVisita();
        Calendar calendar = Calendar.getInstance();
        
        Map<String, List<Object>> erroresRespuesta = new HashMap<String, List<Object>>();
        List<Object> error = new ArrayList<Object>();
        
        error.add("Transacción Exitosa");
        error.add("Ejecución Correcta");
        erroresRespuesta.put("1", error);
        error = new ArrayList<Object>();
        
        error.add("Datos incompletos");
        error.add("Faltan datos obligatorios");
        erroresRespuesta.put("0", error);
        error = new ArrayList<Object>();
        
        error.add("Datos no existentes");
        error.add("El auto comisorio no existe");
        erroresRespuesta.put("2", error);  
        error = new ArrayList<Object>();
        
        error.add("Datos  existentes");
        error.add("El acta de visita ya existe");
        erroresRespuesta.put("3", error);  
        error = new ArrayList<Object>();
        
        
        
        Calendar calenFechaLlegda = Calendar.getInstance();
        Calendar calenFechaFin = Calendar.getInstance();
        
        char tempBuscar = ':';
        int  tempPos = 0;
        int tempPos2 = 0; 
        for (int x = 0 ; x < actaVisitaWSVo.aviHoraLlegada.length() ; x++){
            if(actaVisitaWSVo.aviHoraLlegada.charAt(x) == tempBuscar ){
                tempPos = x;
            }
        }
        for (int x = 0 ; x < actaVisitaWSVo.aviHoraFinalizacion.length() ; x++){
            if(actaVisitaWSVo.aviHoraFinalizacion.charAt(x) == tempBuscar ){
                tempPos2 = x;
            }
        }
        
        tempPos = tempPos-2;
        tempPos2 = tempPos2-2;
        
        calenFechaLlegda.set(Calendar.HOUR_OF_DAY,Integer.parseInt(actaVisitaWSVo.aviHoraLlegada.substring(0,2 ).replace(":", "")));
        calenFechaLlegda.set(Calendar.MINUTE,Integer.parseInt(actaVisitaWSVo.aviHoraLlegada.substring(tempPos,tempPos+2 )));
        Date dateFechaIni=calenFechaLlegda.getTime();
        
        calenFechaFin.set(Calendar.SECOND,Integer.parseInt(actaVisitaWSVo.aviHoraFinalizacion.substring(0,2).replace(":", "")));
        calenFechaFin.set(Calendar.MINUTE,Integer.parseInt(actaVisitaWSVo.aviHoraFinalizacion.substring(3,5 )));
        Date dateFechaFin=calenFechaFin.getTime();
        
        try{
         // validaciones 
           if (actaVisitaWSVo.aviVerifCualAct != null){
               if(actaVisitaWSVo.aviVerifMantenEle == null ){
                   actaVisitaResponseWSVo.codigoError = 0;
                   actaVisitaResponseWSVo.mensajeError = (String) erroresRespuesta.get("0").get(0);
                   actaVisitaResponseWSVo.mensajeErrorAlterno = (String) erroresRespuesta.get("0").get(1);
                   actaVisitaResponseWSVo.horaRegistro = calendar.getTime();
                   return actaVisitaResponseWSVo;
               }             
           }
           if (actaVisitaWSVo.aviVerifSpIdCli.equals("SI")){
              if(actaVisitaWSVo.aviVerifSpMonto == null ){
                actaVisitaResponseWSVo.codigoError = 0;
                actaVisitaResponseWSVo.mensajeError = (String) erroresRespuesta.get("0").get(0);
                actaVisitaResponseWSVo.mensajeErrorAlterno = (String) erroresRespuesta.get("0").get(1);
                actaVisitaResponseWSVo.horaRegistro = calendar.getTime();
                return actaVisitaResponseWSVo;
              }             
           }
           if (actaVisitaWSVo.aviVerifSpDilig.equals("SI")){
               if(actaVisitaWSVo.aviVerifSpSenAler == null ){
                 actaVisitaResponseWSVo.codigoError = 0;
                 actaVisitaResponseWSVo.mensajeError = (String) erroresRespuesta.get("0").get(0);
                 actaVisitaResponseWSVo.mensajeErrorAlterno = (String) erroresRespuesta.get("0").get(1);
                 actaVisitaResponseWSVo.horaRegistro = calendar.getTime();
                 return actaVisitaResponseWSVo;
               }             
            } 
        
            SiiAutoComisorio siiAutoComisorio = autoComisorioDao.buscarPorNumeroAutoComisorio(actaVisitaWSVo.aviNumeroAutoComisorio);
            List<SiiActaVisita> listSiiActaVisita = actaVisitaDao.buscarActaVisitaPorNumero(actaVisitaWSVo.aviNumero);
       
            if(siiAutoComisorio == null){
                actaVisitaResponseWSVo.codigoError = 2;
                actaVisitaResponseWSVo.mensajeError = (String) erroresRespuesta.get("2").get(0);
                actaVisitaResponseWSVo.mensajeErrorAlterno = (String) erroresRespuesta.get("2").get(1);
                actaVisitaResponseWSVo.horaRegistro = calendar.getTime();
                return actaVisitaResponseWSVo;
           }
            
            if(actaVisitaWSVo.listInventarioAutoComisWSVo == null){
                actaVisitaResponseWSVo.codigoError = 0;
                actaVisitaResponseWSVo.mensajeError = (String) erroresRespuesta.get("0").get(0);
                actaVisitaResponseWSVo.mensajeErrorAlterno = (String) erroresRespuesta.get("0").get(1);
                actaVisitaResponseWSVo.horaRegistro = calendar.getTime();
                return actaVisitaResponseWSVo;
            }
            
           if(listSiiActaVisita.size() > 0){
                actaVisitaResponseWSVo.codigoError = 3;
                actaVisitaResponseWSVo.mensajeError = (String) erroresRespuesta.get("3").get(0);
                actaVisitaResponseWSVo.mensajeErrorAlterno = (String) erroresRespuesta.get("3").get(1);
                actaVisitaResponseWSVo.horaRegistro = calendar.getTime();
              return actaVisitaResponseWSVo;
           }
                 
        //****************************************************************   
         
        siiActaVisita.setSiiAutoComisorio(siiAutoComisorio);
        
        siiActaVisita.setAviFechaVisita(actaVisitaWSVo.aviFechaVisita);
        siiActaVisita.setAviNumero(actaVisitaWSVo.aviNumero);
        siiActaVisita.setAviFechaLlegada(dateFechaIni);
        siiActaVisita.setAviFechaFin(dateFechaFin);
        siiActaVisita.setAviNumFolios(actaVisitaWSVo.aviNumFolios);
        siiActaVisita.setAviNombrePerAten(actaVisitaWSVo.aviNombrePerAten);
        siiActaVisita.setAviIdentPerAten(actaVisitaWSVo.aviIdentPerAten);
        siiActaVisita.setAviExpedPerAten(actaVisitaWSVo.aviLugarExpedPerAten);
        siiActaVisita.setAviCalidadPerAten(actaVisitaWSVo.aviCalidadPerAten);
        siiActaVisita.setAviVerifAviso(actaVisitaWSVo.aviVerifAviso);
        siiActaVisita.setAviVerifDireccion(actaVisitaWSVo.aviVeriDireccion);
        siiActaVisita.setAviVerifNomEst(actaVisitaWSVo.aviVerifNomEst);
        siiActaVisita.setAviVerifOtrasAct(actaVisitaWSVo.aviVerifOtrasAct);
        siiActaVisita.setAviVerifCualAct_(actaVisitaWSVo.aviVerifCualAct);
        siiActaVisita.setAviVerifMantenEle(actaVisitaWSVo.aviVerifMantenEle);
        siiActaVisita.setAviVerifSpIdCli(actaVisitaWSVo.aviVerifSpIdCli);
        siiActaVisita.setAviVerifSpMonto(actaVisitaWSVo.aviVerifSpMonto);
        siiActaVisita.setAviVerifSpDilig(actaVisitaWSVo.aviVerifSpDilig);
        siiActaVisita.setAviVerifSpSenAler(actaVisitaWSVo.aviVerifSpSenAler);
        siiActaVisita.setAviVerifSpCodCon(actaVisitaWSVo.aviVerifSpCodCon);
        siiActaVisita.setAviVerifTotalCoinc(actaVisitaWSVo.aviTotalElemCoincidentes.intValue());   
        siiActaVisita.setAviVerifTotalNoEnc(actaVisitaWSVo.aviTotalelemNoencontrados.intValue());  
        siiActaVisita.setAviVerifObsEncarg(actaVisitaWSVo.aviObserEncargado);    
        siiActaVisita.setAviVerifObsInspec(actaVisitaWSVo.aviObserInspector);    
        siiActaVisita.setAviTotEleNoInv(actaVisitaWSVo.aviTotEleNoInv);
        siiActaVisita.setAviTotEleTraNoau(actaVisitaWSVo.aviTotEleTraNoau);
        siiActaVisita.setAviMetEncontrado(actaVisitaWSVo.aviMetEncontrado);
        siiActaVisita.setAviSillEncontrado(actaVisitaWSVo.aviSillEncontrado);
        siiActaVisita.setAviMesaEncontrado(actaVisitaWSVo.aviMesaEncontrado);
        siiActaVisita.setAviOtroEncontrado(actaVisitaWSVo.aviOtroEncontrado);
        siiActaVisita.setAviMetAutoriz(actaVisitaWSVo.aviMetAutoriz);
        siiActaVisita.setAviSillAutoriz(actaVisitaWSVo.aviSillAutoriz);
        siiActaVisita.setAviMesaAutoriz(actaVisitaWSVo.aviMesaAutoriz);
        siiActaVisita.setAviOtroAutoriz(actaVisitaWSVo.aviOtroAutoriz);
        siiActaVisita.setAviMetNoEncont(actaVisitaWSVo.aviMetNoEncont);
        siiActaVisita.setAviSillNoEncont(actaVisitaWSVo.aviSillNoEncont);
        siiActaVisita.setAviMesaNoEncont(actaVisitaWSVo.aviMesaNoEncont);
        siiActaVisita.setAviOtroNoEncont(actaVisitaWSVo.aviOtroNoEncont);
        siiActaVisita.setAviMetSerNoCorr(actaVisitaWSVo.aviMetSerNoCorr);
        siiActaVisita.setAviSillSerNoCorr(actaVisitaWSVo.aviSillSerNoCorr);
        siiActaVisita.setAviMesaSerNoCorr(actaVisitaWSVo.aviMesaSerNoCorr);
        siiActaVisita.setAviOtroSerNoCorr(actaVisitaWSVo.aviOtroSerNoCorr);
        siiActaVisita.setAviMetSinPlaca(actaVisitaWSVo.aviMetSinPlaca);    
        siiActaVisita.setAviSillSinPlaca(actaVisitaWSVo.aviSillSinPlaca);   
        siiActaVisita.setAviMesaSinPlaca(actaVisitaWSVo.aviMesaSinPlaca);
        siiActaVisita.setAviOtroSinPlaca(actaVisitaWSVo.aviOtroSinPlaca);
        siiActaVisita.setAviMetApuNoCorr(actaVisitaWSVo.aviMetApuNoCorr);
        siiActaVisita.setAviSillApuNoCorr(actaVisitaWSVo.aviSillApuNoCorr);
        siiActaVisita.setAviMesaApuNoCorr(actaVisitaWSVo.aviMesaApuNoCorr);
        siiActaVisita.setAviOtroApuNoCorr(actaVisitaWSVo.aviOtroApuNoCorr);
        siiActaVisita.setAviMetMayNumAut(actaVisitaWSVo.aviMetMayNumAut);
        siiActaVisita.setAviSillMayNumAut(actaVisitaWSVo.aviSillMayNumAut);
        siiActaVisita.setAviMesaMayNumAut(actaVisitaWSVo.aviMesaMayNumAut);
        siiActaVisita.setAviOtroMayNumAut(actaVisitaWSVo.aviOtroMayNumAut);
        siiActaVisita.setAviMetNoRegNoOp(actaVisitaWSVo.aviMetNoRegNoOp);
        siiActaVisita.setAviSillNoRegNoOp(actaVisitaWSVo.aviSillNoRegNoOp);
        siiActaVisita.setAviMesaNoRegNoOp(actaVisitaWSVo.aviMesaNoRegNoOp);
        siiActaVisita.setAviOtroNoRegNoOp(actaVisitaWSVo.aviOtroNoRegNoOp);
        siiActaVisita.setAviEstLongitud(actaVisitaWSVo.aviEstLongitud);
        siiActaVisita.setAviEstLatitud(actaVisitaWSVo.aviEstLatitud);
        siiActaVisita.setAviNomRepOpera(actaVisitaWSVo.aviNomRepOpera);
        siiActaVisita.setAviIdRepOpera(actaVisitaWSVo.aviIdRepOpera);
        siiActaVisita.setAviCargoRepOpera(actaVisitaWSVo.aviCargoRepOpera);
        
       siiActaVisita = actaVisitaDao.insertarSiiActaVisita(siiActaVisita);
            
        for(InventarioAutoComisWSVO InventarioAutoComisVo: actaVisitaWSVo.listInventarioAutoComisWSVo){
           SiiInventarioAutoComis siiInventarioAutoComis = new SiiInventarioAutoComis();
           SiiInventario siiInventario  = inventarioDao.buscarInventarioPorIdInstrumento(Long.parseLong(InventarioAutoComisVo.iacItem));
           //siiInventario= inventarioDao.buscarInventarioPorId(siiInventario.getInvCodigo());
           siiInventarioAutoComis.setSiiInventario(siiInventario);
           siiInventarioAutoComis.setIacItem(InventarioAutoComisVo.iacItem);
           if(InventarioAutoComisVo.iacRevCodApuesta == 1 )
                siiInventarioAutoComis.setIacRevCodApuesta("S");
            else 
                siiInventarioAutoComis.setIacRevCodApuesta("N");
           if(InventarioAutoComisVo.iacRevcontadores == 1 )
                siiInventarioAutoComis.setIacRevContadores("S");
            else 
                siiInventarioAutoComis.setIacRevContadores("N");
           if(InventarioAutoComisVo.iacRevDescJuego == 1 ) 
               siiInventarioAutoComis.setIacRevDescJuego("S");
            else 
                siiInventarioAutoComis.setIacRevDescJuego("N");
            if(InventarioAutoComisVo.iacRevPlanPremios == 1 ) 
                siiInventarioAutoComis.setIacRevPlanPremios("S");
            else 
                siiInventarioAutoComis.setIacRevPlanPremios("N");
            if(InventarioAutoComisVo.iacRevSerial == 1 ) 
                siiInventarioAutoComis.setIacRevSerial("S");
            else
                siiInventarioAutoComis.setIacRevSerial("N");
            if(InventarioAutoComisVo.iacRevValorPremios == 1 ) 
                siiInventarioAutoComis.setIacRevValorPremios("S");
            else 
                siiInventarioAutoComis.setIacRevValorPremios("N");

           siiInventarioAutoComis.setIacCoinIn(InventarioAutoComisVo.iacCoinIn );
           siiInventarioAutoComis.setIacCoinOut(InventarioAutoComisVo.iacCoinOut);
           siiInventarioAutoComis.setIacValorCredito(InventarioAutoComisVo.iacValorCredito);
           siiInventarioAutoComis.setIacValorJackpot(InventarioAutoComisVo.iacValorjackpot);
           siiInventarioAutoComis.setSiiAutoComisorio(siiAutoComisorio);
           siiInventarioAutoComis = inventarioAutoComisorioDao.insertarInventarioAutoComis(siiInventarioAutoComis);
        }
        if (actaVisitaWSVo.listInstrNoCorrespWSVo != null ){
            for(InstrnoCorrespWSVO InstrnoCorrespWSVo : actaVisitaWSVo.listInstrNoCorrespWSVo ){
                SiiInstrNoCorresp siiInstrnoCorresp = new SiiInstrNoCorresp();
                siiInstrnoCorresp.setInoCodApuesta(InstrnoCorrespWSVo.inoCodApuesta);
                if(InstrnoCorrespWSVo.inoDescJuego == 1)
                    siiInstrnoCorresp.setInoDescJuego("S");
                else 
                    siiInstrnoCorresp.setInoDescJuego("N");
                siiInstrnoCorresp.setInoIndicador(InstrnoCorrespWSVo.inoIndicador);
                siiInstrnoCorresp.setInoItem(InstrnoCorrespWSVo.inoItem);
                siiInstrnoCorresp.setInoMarca(InstrnoCorrespWSVo.inoMarca);
                if(InstrnoCorrespWSVo.inoPlanPremios == 1)
                  siiInstrnoCorresp.setInoPlanPremios("S");
                else 
                    siiInstrnoCorresp.setInoPlanPremios("N"); 
                siiInstrnoCorresp.setInoSerial(InstrnoCorrespWSVo.inoSerial);
                siiInstrnoCorresp.setInoTipo("N");
                if(InstrnoCorrespWSVo.inoValoresPrem == 1 )
                    siiInstrnoCorresp.setInoValoresPrem("S");
                else
                    siiInstrnoCorresp.setInoValoresPrem("N");
                siiInstrnoCorresp.setSiiActaVisita(siiActaVisita);
                instrnoCorrespDao.insertarInstrnoCorresp(siiInstrnoCorresp);
            }
        }
        if (actaVisitaWSVo.listInstrSinAutorizacionWSVo != null)   { 
            for(InstrnoCorrespWSVO InstrSinAutWSVo : actaVisitaWSVo.listInstrSinAutorizacionWSVo ){
                SiiInstrNoCorresp siiInstrSinAuto = new SiiInstrNoCorresp();
                siiInstrSinAuto.setInoCodApuesta(InstrSinAutWSVo.inoCodApuesta);
                if(InstrSinAutWSVo.inoDescJuego == 1)
                    siiInstrSinAuto.setInoDescJuego("S");
                else 
                    siiInstrSinAuto.setInoDescJuego("N");
                siiInstrSinAuto.setInoIndicador(InstrSinAutWSVo.inoIndicador);
                siiInstrSinAuto.setInoItem(InstrSinAutWSVo.inoItem);
                siiInstrSinAuto.setInoMarca(InstrSinAutWSVo.inoMarca);
                if(InstrSinAutWSVo.inoPlanPremios == 1)
                  siiInstrSinAuto.setInoPlanPremios("S");
                else 
                    siiInstrSinAuto.setInoPlanPremios("N"); 
                
                siiInstrSinAuto.setInoSerial(InstrSinAutWSVo.inoSerial);
                siiInstrSinAuto.setInoTipo("T");
                if(InstrSinAutWSVo.inoValoresPrem == 1 )
                    siiInstrSinAuto.setInoValoresPrem("S");
                else
                    siiInstrSinAuto.setInoValoresPrem("N");
                siiInstrSinAuto.setSiiActaVisita(siiActaVisita);
                instrnoCorrespDao.insertarInstrnoCorresp(siiInstrSinAuto);
            }    
          }
            
        actaVisitaResponseWSVo.codigoError = 1;
        actaVisitaResponseWSVo.mensajeError = (String) erroresRespuesta.get("1").get(0);
        actaVisitaResponseWSVo.mensajeErrorAlterno = (String) erroresRespuesta.get("1").get(1);
        actaVisitaResponseWSVo.horaRegistro = calendar.getTime();
        return actaVisitaResponseWSVo;
        
    } catch (ExcepcionDAO ex){
        ex.printStackTrace();
        throw ex;
    } catch(Exception ex){           
        ex.printStackTrace();
        throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
      
    }    
    
    }
    public List<ActaVisitaVO> buscarActaVisitaPorAutoComisorio (Long aucCodigo) throws ExcepcionDAO{
        List<ActaVisitaVO> listaActaVisitaResponseWSVO = new ArrayList<ActaVisitaVO>();
        List<SiiActaVisita> listaActaVisita= new ArrayList<SiiActaVisita>();
        listaActaVisita = actaVisitaDao.buscarActaVisitaPorAutoComisorio(aucCodigo);
        for (SiiActaVisita actaVisita:listaActaVisita){
            listaActaVisitaResponseWSVO.add(new ActaVisitaVO(actaVisita));
        }
        return listaActaVisitaResponseWSVO;
    }
}
