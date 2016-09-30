package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogGeneral;
import co.gov.coljuegos.siicol.ejb.negocio.sistema.AdminParametrosSistema;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CausalTermContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoLiqContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoResolucAutDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoResolucionLiqDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionLiquidacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCausalTermContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoLiquidCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemCotizacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionLiquid;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CausalTerminacionContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoLiquidacionContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoPolizaContVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoResolucionLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemCotizacionVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionContratoVO;

import co.gov.coljuegos.siicol.ejb.vo.ResolucionLiquidacionVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminLiquidacionContratoBean implements AdminLiquidacionContrato { 
    
    @Resource
    SessionContext sessionContext;
    
    @EJB
    private LiquidacionContratoDAO liquidacionContratoDao;
    @EJB
    private CausalTermContratoDAO causalTermContratoDao;
    @EJB
    private EstadoLiqContratoDAO estadoLiqContratoDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ResolucionLiquidacionDAO resolucionLiquidacionDao;
    @EJB
    private EstadoResolucionLiqDAO estadoResolucionLiqDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private ContratoDAO contratoDao;
    @EJB
    private EstadoContratoDAO estadoContratoDao;
    @EJB
    private UsuarioDAO usuarioDao;
    @EJB
    private AdminParametrosSistema adminParametrosSistema;
    @EJB
    private AdminLogGeneral adminLogGeneral;
                                                                                    
                                                                                    
   public AdminLiquidacionContratoBean() {
        
   }
   
    public LiquidacionContratoVO insertarLiquidacionContrato(LiquidacionContratoVO liquidacionContratoVo) throws ExcepcionDAO{
        SiiLiquidacionContrato siiLiquidacionContrato = conversionVoEntidad.convertir(liquidacionContratoVo);
        siiLiquidacionContrato = liquidacionContratoDao.insertarLiquidacionContrato(siiLiquidacionContrato);
        return new LiquidacionContratoVO(siiLiquidacionContrato);
    }
           
   public List<LiquidacionContratoVO> buscarTodosLiquidacionContrato() throws ExcepcionDAO{
       List<SiiLiquidacionContrato> siiLiquidacionContrato = liquidacionContratoDao.buscarTodosLiquidacionContrato();
       List<LiquidacionContratoVO> liquidacionContratoVo = new ArrayList();
       LiquidacionContratoVO unaLiquidacionContratoVo = new LiquidacionContratoVO();
       List<ResolucionLiquidacionVO> listResolucionLiquidacionVo = new ArrayList(); 
       for (SiiLiquidacionContrato unaSiiLiquidacionContrato : siiLiquidacionContrato) {
           List<SiiResolucionLiquid> listResol = resolucionLiquidacionDao.buscarSiiResolucionLiquidPorIdLiq(unaSiiLiquidacionContrato.getLcoCodigo());
           unaSiiLiquidacionContrato.setSiiResolucionLiquidList(listResol);
           unaLiquidacionContratoVo=(new LiquidacionContratoVO(unaSiiLiquidacionContrato));
           
           //calcula la duracion del contrato
           Calendar calendar = Calendar.getInstance();
           calendar.setTime(unaLiquidacionContratoVo.getContratoVo().getConFechaIni());
           int anio_ = calendar.get(Calendar.YEAR);
           int mes_ = calendar.get(Calendar.MONTH)+1;
           int dia_ = calendar.get(Calendar.DAY_OF_MONTH);
           
           Calendar calendar2 = Calendar.getInstance();
           calendar2.setTime(unaLiquidacionContratoVo.getContratoVo().getConFechaFin());
           int anio2 = calendar2.get(Calendar.YEAR);
           int mes2 = calendar2.get(Calendar.MONTH)+1;
           int dia2 = calendar2.get(Calendar.DAY_OF_MONTH);
                  
           String dateIni; 
           String dateFin;
           dateIni=anio_ + "/" + mes_  + "/" + dia_ ;
           dateFin=anio2 + "/" + mes2  + "/" + dia2 ;
           String[] tempIni= dateIni.split("/");
           String[] tempFin= dateFin.split("/");
           
           for(SiiResolucionLiquid unaResolucionLiquid: unaSiiLiquidacionContrato.getSiiResolucionLiquidList()){
               if (unaResolucionLiquid.getRliTipoRes().equals("L"))
                    unaLiquidacionContratoVo.setEstadoResolucionLiq(unaResolucionLiquid.getSiiEstadoResolucLiq().getErlNombre());
               else 
                    unaLiquidacionContratoVo.setEstadoRecursoRep(unaResolucionLiquid.getSiiEstadoResolucLiq().getErlNombre());
           }
                   
           
           
           unaLiquidacionContratoVo.setDuracionContrato( Long.parseLong(tempFin[0])*12 +Long.parseLong(tempFin[1]) - ( Long.parseLong(tempIni[0])*12 +Long.parseLong(tempIni[1]) ));
           liquidacionContratoVo.add(unaLiquidacionContratoVo);
       }
       return liquidacionContratoVo;
               
   }
   
    public LiquidacionContratoVO buscarLiquidacionContratoXId(Long  idLiqContrato) throws ExcepcionDAO {
        LiquidacionContratoVO unaLiquidacionContratoVo = new LiquidacionContratoVO();
        SiiLiquidacionContrato siiLiquidacionContrato= liquidacionContratoDao.buscarLiquidacionContratoXId(idLiqContrato);
        unaLiquidacionContratoVo=(new LiquidacionContratoVO(siiLiquidacionContrato));
        List<ResolucionLiquidacionVO> listResolucionLiquidacionVo = null;
        List<SiiResolucionLiquid> listSiiResolucionLiquid = new ArrayList();
        
        unaLiquidacionContratoVo=(new LiquidacionContratoVO(siiLiquidacionContrato));
        listSiiResolucionLiquid = resolucionLiquidacionDao.buscarSiiResolucionLiquidPorIdLiq(unaLiquidacionContratoVo.getLcoCodigo());
            listResolucionLiquidacionVo = new ArrayList();
            for( SiiResolucionLiquid siiResolucionLiquid: listSiiResolucionLiquid){
                ResolucionLiquidacionVO resolucionLiquidacionVo=(new ResolucionLiquidacionVO(siiResolucionLiquid)) ;
                listResolucionLiquidacionVo.add(resolucionLiquidacionVo);
            }
            
        
        unaLiquidacionContratoVo.setListResolucionLiquidacionVo(listResolucionLiquidacionVo);
        
        //calcula la duracion del contrato
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(unaLiquidacionContratoVo.getContratoVo().getConFechaIni());
        int anio_ = calendar.get(Calendar.YEAR);
        int mes_ = calendar.get(Calendar.MONTH)+1;
        int dia_ = calendar.get(Calendar.DAY_OF_MONTH);
        
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(unaLiquidacionContratoVo.getContratoVo().getConFechaFin());
        int anio2 = calendar2.get(Calendar.YEAR);
        int mes2 = calendar2.get(Calendar.MONTH)+1;
        int dia2 = calendar2.get(Calendar.DAY_OF_MONTH);
               
        String dateIni; 
        String dateFin;
        dateIni=anio_ + "/" + mes_  + "/" + dia_ ;
        dateFin=anio2 + "/" + mes2  + "/" + dia2 ;
        String[] tempIni= dateIni.split("/");
        String[] tempFin= dateFin.split("/");
        
        unaLiquidacionContratoVo.setDuracionContrato( Long.parseLong(tempFin[0])*12 +Long.parseLong(tempFin[1]) - ( Long.parseLong(tempIni[0])*12 +Long.parseLong(tempIni[1]) ));
        
        return (unaLiquidacionContratoVo);   
    }
   
    public List<CausalTerminacionContratoVO> buscarTodosCausalTermContr() throws ExcepcionDAO{

        List<SiiCausalTermContr> listaSiiCausalTermContr = causalTermContratoDao.buscarTodosCausalTermContr();
        List<CausalTerminacionContratoVO> causalTerminacionContratoVo = new ArrayList();
        for (SiiCausalTermContr unaSiiCausalTermContr : listaSiiCausalTermContr) {
            
            causalTerminacionContratoVo.add(new CausalTerminacionContratoVO(unaSiiCausalTermContr));
            
            
        }
        return causalTerminacionContratoVo;


    }    
    
    public CausalTerminacionContratoVO buscarSiiCausalTermContrXId(Long  idCausal) throws ExcepcionDAO{
        SiiCausalTermContr siiCausalTermContr = causalTermContratoDao.buscarSiiCausalTermContrXId(idCausal);
        return new CausalTerminacionContratoVO(siiCausalTermContr);


    }  
    
    public EstadoLiquidacionContratoVO buscarEstadoLiquidContXNombre (String nombreEstado ) throws ExcepcionDAO {
      SiiEstadoLiquidCont siiEstadoLiquidCont =estadoLiqContratoDao.buscarEstadoLiquidContXNombre(nombreEstado);
      return new  EstadoLiquidacionContratoVO (siiEstadoLiquidCont);
    }
    
    public ResolucionLiquidacionVO buscarResolucionLiquidPorId(Long codigo) throws ExcepcionDAO {
        SiiResolucionLiquid siiResolucionLiquid=resolucionLiquidacionDao.buscarResolucionLiquidPorId(codigo);
        return new  ResolucionLiquidacionVO (siiResolucionLiquid);
    }
    public LiquidacionContratoVO actualizarLiquidacionContrato(LiquidacionContratoVO liquidacionContratoVo,  UsuarioVO usuarioLogueado) throws ExcepcionDAO {
         SiiLiquidacionContrato siiLiquidacionContrato = conversionVoEntidad.convertir(liquidacionContratoVo);
         siiLiquidacionContrato= liquidacionContratoDao.actualizarLiquidacionContrato(siiLiquidacionContrato);
        
         List<SiiResolucionLiquid>  listaSiiResolucionLiquid = new ArrayList();
         if (liquidacionContratoVo.getListResolucionLiquidacionVo()!= null){
             for(ResolucionLiquidacionVO resolucionLiquidacionVo :liquidacionContratoVo.getListResolucionLiquidacionVo()  ) {
                 if(resolucionLiquidacionVo.getRliCodigo() == null ){
                     SiiResolucionLiquid siiResolucionLiquid = conversionVoEntidad.convertir(liquidacionContratoVo.getListResolucionLiquidacionVo().get(0));
                     siiResolucionLiquid.setSiiLiquidacionContrato(siiLiquidacionContrato);
                     listaSiiResolucionLiquid.add(resolucionLiquidacionDao.insertarResolucionLiq(siiResolucionLiquid));
                     
                     if(siiLiquidacionContrato.getSiiEstadoLiquidCont().getElcCodigo()!= null){
                     adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.RESOLUCION_LIQUIDACION_UNILATERAL.getId(),
                                                                 siiResolucionLiquid.getSiiEstadoResolucLiq().getErlCodigo(),
                                                                 usuarioLogueado, siiResolucionLiquid.getRliCodigo());
                     }
                 }
             }
         }
        
         if(siiLiquidacionContrato.getSiiEstadoLiquidCont().getElcCodigo()!= null){
         adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.LIQUIDACION_CONTRATO_CONCESION.getId(),
                                                     siiLiquidacionContrato.getSiiEstadoLiquidCont().getElcCodigo(),
                                                     usuarioLogueado, siiLiquidacionContrato.getLcoCodigo());
         
         }
        
         return new LiquidacionContratoVO(siiLiquidacionContrato);
    }
    
    public LiquidacionContratoVO buscarLiquidacionContratoPorContrato(String conNumero) throws ExcepcionDAO{
        LiquidacionContratoVO liquidacionContratoVo= liquidacionContratoDao.buscarLiquidacionContratoPorContrato(conNumero);
        return liquidacionContratoVo;   
    }
    
    public EstadoResolucionLiqVO  buscarEstadoResolucLiqPorEstado(String nombreEstado) throws ExcepcionDAO {
        EstadoResolucionLiqVO estadoResolucionLiqVO = estadoResolucionLiqDao.buscarEstadoResolucLiqPorEstado(nombreEstado);
        return estadoResolucionLiqVO;   
    }  
    
    public ResolucionLiquidacionVO actualizarSiiResolucionLiquid(ResolucionLiquidacionVO resolucionLiquidacionVo,ContratoVO contratoVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        SiiResolucionLiquid unaResolucionLiquid = conversionVoEntidad.convertir(resolucionLiquidacionVo);
        unaResolucionLiquid = resolucionLiquidacionDao.actualizarSiiResolucionLiquid(unaResolucionLiquid);
         
        if(unaResolucionLiquid.getSiiEstadoResolucLiq() != null){ 
        adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.RESOLUCION_LIQUIDACION_UNILATERAL.getId(),
                                                    unaResolucionLiquid.getSiiEstadoResolucLiq().getErlCodigo(),
                                                    usuarioLogueado, unaResolucionLiquid.getRliCodigo());
        }
        if(resolucionLiquidacionVo.getEstadoResolucionLiqVo().getErlNombre().equals("EN FIRME")){
            SiiLiquidacionContrato siiLiquidacionContrato = conversionVoEntidad.convertir(resolucionLiquidacionVo.getLiquidacionContratoVo());
            siiLiquidacionContrato = liquidacionContratoDao.actualizarLiquidacionContrato(siiLiquidacionContrato);
            
            if(resolucionLiquidacionVo.getLiquidacionContratoVo().getEstadoLiquidacionContratoVo() != null){ 
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.LIQUIDACION_CONTRATO_CONCESION.getId(),
                                                        siiLiquidacionContrato.getSiiEstadoLiquidCont().getElcCodigo(),
                                                        usuarioLogueado, siiLiquidacionContrato.getLcoCodigo());
            }
            if(contratoVo != null){
                SiiContrato siiContrato = conversionVoEntidad.convertir(contratoVo);
               contratoDao.actualizarSiiContrato(siiContrato);
               
                if(contratoVo.getEstadoContratoVo() != null){ 
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CONTRATO_CONCESION.getId(),
                                                            contratoVo.getEstadoContratoVo().getEcoCodigo(),
                                                            usuarioLogueado, contratoVo.getConCodigo());
                }
               
            }
        }
       
         
        return new  ResolucionLiquidacionVO (unaResolucionLiquid);
    }
    
    @Schedule(minute = "00", hour = "6") 
    public void liquidacionConFirmeAutomatico(){
        try{
         List<LiquidacionContratoVO> listLiquidacionContratoVo =  liquidacionContratoDao.listaLiquidacionNotificada();
            for (LiquidacionContratoVO liquidacionContratoVo: listLiquidacionContratoVo){
               SiiLiquidacionContrato unaSiiLiquidacionContrato =  liquidacionContratoDao.buscarLiquidacionContratoXId(liquidacionContratoVo.getLcoCodigo());
               List<SiiResolucionLiquid> listaResolucionLiquid = resolucionLiquidacionDao.buscarSiiResolucionLiquidPorIdLiq(liquidacionContratoVo.getLcoCodigo());
                boolean tempCR=false;
                boolean tempCP=false;
                boolean tempRR=false;
                
                for (SiiResolucionLiquid unaSiiResolucionLiquid : listaResolucionLiquid ){
                    if(unaSiiResolucionLiquid.getRliTipoRes().equals("R") ){
                        if(unaSiiResolucionLiquid.getRliResultadoRec().equals("CR") )
                            tempCR=true;
                        if(unaSiiResolucionLiquid.getRliResultadoRec().equals("CP") )
                            tempCP=true;
                        if(unaSiiResolucionLiquid.getRliResultadoRec().equals("RR") )
                            tempRR=true;
                    }
                }
               
                for (SiiResolucionLiquid unaSiiResolucionLiquid : listaResolucionLiquid ){
                    if(unaSiiResolucionLiquid.getRliTipoRes().equals("R") ){
                        EstadoResolucionLiqVO estadoResolucionLiqVO = estadoResolucionLiqDao.buscarEstadoResolucLiqPorEstado("NOTIFICADO");
                        SiiEstadoResolucLiq siiEstadoResolucLiq = new SiiEstadoResolucLiq();
                        siiEstadoResolucLiq.setErlCodigo(estadoResolucionLiqVO.getErlCodigo());
                        unaSiiResolucionLiquid.setSiiEstadoResolucLiq(siiEstadoResolucLiq);
                        unaSiiResolucionLiquid = resolucionLiquidacionDao.actualizarSiiResolucionLiquid(unaSiiResolucionLiquid);
                    }        
                    //Actualiza resolución de liquidación
                    if(unaSiiResolucionLiquid.getRliTipoRes().equals("L") ){
                      
                        SiiContrato siiContrato =  contratoDao.buscarContratoPorId(unaSiiLiquidacionContrato.getSiiContrato().getConCodigo());
                        SiiEstadoContrato siiEstadoContrato = estadoContratoDao.buscarEstadoContratoPorNombre("LIQUIDADO");
                        siiContrato.setSiiEstadoContrato(siiEstadoContrato);                    
                        
                        if(tempCR==true){
                            EstadoResolucionLiqVO estadoResolucionLiqVO = estadoResolucionLiqDao.buscarEstadoResolucLiqPorEstado("EN FIRME");
                            SiiEstadoResolucLiq siiEstadoResolucLiq = new SiiEstadoResolucLiq();
                            siiEstadoResolucLiq.setErlCodigo(estadoResolucionLiqVO.getErlCodigo());
                            unaSiiResolucionLiquid.setSiiEstadoResolucLiq(siiEstadoResolucLiq);
                            unaSiiResolucionLiquid = resolucionLiquidacionDao.actualizarSiiResolucionLiquid(unaSiiResolucionLiquid);
                            SiiEstadoLiquidCont siiEstadoLiquidCont =   estadoLiqContratoDao.buscarEstadoLiquidContXNombre("LIQUIDADO");
                            unaSiiLiquidacionContrato.setSiiEstadoLiquidCont(siiEstadoLiquidCont);
                            liquidacionContratoDao.actualizarLiquidacionContrato(unaSiiLiquidacionContrato);
                            contratoDao.actualizarSiiContrato(siiContrato);
                            if(unaSiiLiquidacionContrato.getSiiEstadoLiquidCont() != null){ 
                              SiiUsuario siiUsuario =  usuarioDao.buscarUsuarioPorLogin("ROOT_SIICOL");
                              UsuarioVO usuarioVo= new UsuarioVO(siiUsuario);
                              adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.LIQUIDACION_CONTRATO_CONCESION.getId(),
                                                                            unaSiiLiquidacionContrato.getSiiEstadoLiquidCont().getElcCodigo(),
                                                                            usuarioVo, unaSiiLiquidacionContrato.getLcoCodigo());
                            }  
                            if(siiContrato.getSiiEstadoContrato() != null){ 
                              SiiUsuario siiUsuario =  usuarioDao.buscarUsuarioPorLogin("ROOT_SIICOL");
                              UsuarioVO usuarioVo= new UsuarioVO(siiUsuario);
                              adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CONTRATO_CONCESION.getId(),
                                                                            siiContrato.getSiiEstadoContrato().getEcoCodigo(),
                                                                            usuarioVo, siiContrato.getConCodigo());
                            }
                        }
                        if(tempCP==true){
                            EstadoResolucionLiqVO estadoResolucionLiqVO = estadoResolucionLiqDao.buscarEstadoResolucLiqPorEstado("CONFIRMADO PARCIALMENTE");
                            SiiEstadoResolucLiq siiEstadoResolucLiq = new SiiEstadoResolucLiq();
                            siiEstadoResolucLiq.setErlCodigo(estadoResolucionLiqVO.getErlCodigo());
                            unaSiiResolucionLiquid.setSiiEstadoResolucLiq(siiEstadoResolucLiq);
                            unaSiiResolucionLiquid = resolucionLiquidacionDao.actualizarSiiResolucionLiquid(unaSiiResolucionLiquid);
                            SiiEstadoLiquidCont siiEstadoLiquidCont =   estadoLiqContratoDao.buscarEstadoLiquidContXNombre("LIQUIDADO");
                            unaSiiLiquidacionContrato.setSiiEstadoLiquidCont(siiEstadoLiquidCont);
                            liquidacionContratoDao.actualizarLiquidacionContrato(unaSiiLiquidacionContrato);
                            contratoDao.actualizarSiiContrato(siiContrato);
                            
                            if(unaSiiLiquidacionContrato.getSiiEstadoLiquidCont() != null){ 
                              SiiUsuario siiUsuario =  usuarioDao.buscarUsuarioPorLogin("ROOT_SIICOL");
                              UsuarioVO usuarioVo= new UsuarioVO(siiUsuario);
                              adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.LIQUIDACION_CONTRATO_CONCESION.getId(),
                                                                            unaSiiLiquidacionContrato.getSiiEstadoLiquidCont().getElcCodigo(),
                                                                            usuarioVo, unaSiiLiquidacionContrato.getLcoCodigo());
                            }  
                            if(siiContrato.getSiiEstadoContrato() != null){ 
                              SiiUsuario siiUsuario =  usuarioDao.buscarUsuarioPorLogin("ROOT_SIICOL");
                              UsuarioVO usuarioVo= new UsuarioVO(siiUsuario);
                              adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CONTRATO_CONCESION.getId(),
                                                                            siiContrato.getSiiEstadoContrato().getEcoCodigo(),
                                                                            usuarioVo, siiContrato.getConCodigo());
                            }
                            
                        }
                        if(tempRR==true){
                            EstadoResolucionLiqVO estadoResolucionLiqVO = estadoResolucionLiqDao.buscarEstadoResolucLiqPorEstado("REVOCADO");
                            SiiEstadoResolucLiq siiEstadoResolucLiq = new SiiEstadoResolucLiq();
                            siiEstadoResolucLiq.setErlCodigo(estadoResolucionLiqVO.getErlCodigo());
                            unaSiiResolucionLiquid.setSiiEstadoResolucLiq(siiEstadoResolucLiq);
                            unaSiiResolucionLiquid = resolucionLiquidacionDao.actualizarSiiResolucionLiquid(unaSiiResolucionLiquid);
                                                        
                        }     
                    }
                    
                if(unaSiiResolucionLiquid.getSiiEstadoResolucLiq() != null){ 
                  SiiUsuario siiUsuario =  usuarioDao.buscarUsuarioPorLogin("ROOT_SIICOL");
                  UsuarioVO usuarioVo= new UsuarioVO(siiUsuario);
                  adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.RESOLUCION_LIQUIDACION_UNILATERAL.getId(),
                                                                unaSiiResolucionLiquid.getSiiEstadoResolucLiq().getErlCodigo(),
                                                                usuarioVo, unaSiiResolucionLiquid.getRliCodigo());
                }  
                
               }
            }

        }catch(Exception ex){
            adminLogGeneral.log("AdminLiquidacionContratoBean - liquidacionConFirmeAutomatico","Error en la ejecucion de la liquidacion de contrato - sistema : " + adminParametrosSistema.buscarCadenaParametroPorId("BASE_DE_DATOS") + " - Mensaje : " + ex.getMessage(), null);
        }
        adminLogGeneral.log("AdminLiquidacionContratoBean - liquidacionConFirmeAutomatico","Ejecucion correcta de la liquidacion de contrato - sistema : " + adminParametrosSistema.buscarCadenaParametroPorId("BASE_DE_DATOS"), null);
        
    }
    
    
    public List<ResolucionLiquidacionVO> buscarSiiResolucionLiquidPorIdLiq(Long lcoCodigo) throws ExcepcionDAO {
        List<ResolucionLiquidacionVO> listResolucionLiquidacionVo = new ArrayList();
        List<SiiResolucionLiquid> listaResolucionLiquid = resolucionLiquidacionDao.buscarSiiResolucionLiquidPorIdLiq(lcoCodigo);
        for (SiiResolucionLiquid siiResolucionLiquid : listaResolucionLiquid){
            listResolucionLiquidacionVo.add(new ResolucionLiquidacionVO(siiResolucionLiquid));
        }
        
        return listResolucionLiquidacionVo;     
    }
    
    public EstadoResolucionLiqVO buscarEstadoResolucionLiqXId(Long  idEstadoResLiq) throws ExcepcionDAO {
        SiiEstadoResolucLiq siiEstadoResolucLiq = estadoResolucionLiqDao.buscarEstadoResolucionLiqXId(idEstadoResLiq);
        return new EstadoResolucionLiqVO(siiEstadoResolucLiq) ;   
    }
    
                     
}
