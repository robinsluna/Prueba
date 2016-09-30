package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoComisorioAccConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoComisorioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FiscalizadorSustancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GrupoAccionControlDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GrupoFiscalizadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistEstadoFiscalizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistEstadoSustanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoAnulAuComAcConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SustanciadorAuditorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorioAccCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDenuncia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFiscalizadorSustanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoAccionControl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoFiscaliz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoSustan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulAuComAcCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSustanciadorAuditor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioAccConVO;
import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioVO;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.FiscalizadorSustancVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoAccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoFiscalizacionVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoAnulAuComAcConVO;
import co.gov.coljuegos.siicol.ejb.vo.SustanciadorAuditorVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminAutoComisorioBean implements AdminAutoComisorio {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    EstadoDocContabDAO estadoDocContabDao;
    @EJB
    ImputacionContableDAO imputacionContableDao;
    @EJB
    AutoComisorioDAO autoComisorioDao;
    @EJB
    EstablecimientoDAO establecimientoDao;
    @EJB
    GrupoFiscalizadorDAO grupoFiscalizadorDao;
    @EJB
    FiscalizadorSustancDAO fiscalizadorSustancDao;
    @EJB
    UsuarioDAO usuarioDao;
    @EJB
    UbicacionDAO ubicacionDao;
    @EJB
    AutoComisorioAccConDAO autoComisorioAccConDao;
    @EJB
    GrupoAccionControlDAO grupoAccionControlDao;
    @EJB
    SustanciadorAuditorDAO sustanciadorAuditorDao;
    @EJB
    DenunciaOrdenTrabDAO denunciaOrdenTrabDao;
    @EJB
     MotivoAnulAuComAcConDAO motivoAnulAuComAcConDao;
    @EJB
    DenunciaDAO denunciaDao;
    @EJB
    EstadoDenunciaDAO estadoDenunciaDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    HistEstadoFiscalizDAO histEstadoFiscalizDao;
    @EJB
    HistEstadoSustanDAO histEstadoSustanDao;
    @EJB
    DireccionDAO direccionDao;
    
    public AdminAutoComisorioBean() {
      
    }
    
    public AutoComisorioVO buscarPorCodigoAutoComisorio (Long aucCodigo) throws ExcepcionDAO {
        SiiAutoComisorio siiAutoComisorio = autoComisorioDao.buscarPorCodigoAutoComisorio(aucCodigo);
        AutoComisorioVO  unAutoComisorioVo= new AutoComisorioVO(siiAutoComisorio);
        SiiUsuario siiUsuarioAcom = usuarioDao.buscarUsuarioPorIdPersona(siiAutoComisorio.getSiiGrupoFiscalizacion().getSiiFiscalizadorSustancAcomp().getSiiPersona().getPerCodigo());
        SiiUsuario siiUsuarioPrin = usuarioDao.buscarUsuarioPorIdPersona(siiAutoComisorio.getSiiGrupoFiscalizacion().getSiiFiscalizadorSustancPrincipal().getSiiPersona().getPerCodigo());
        if(siiUsuarioAcom != null)
              unAutoComisorioVo.getGrupoFiscalizacionVo().getFiscalizadorSustancVoAcompañante().setCargo(siiUsuarioAcom.getSiiFuncion1().getFunNombre());
        if(siiUsuarioPrin != null)
              unAutoComisorioVo.getGrupoFiscalizacionVo().getFiscalizadorSustancVoPrincipal().setCargo(siiUsuarioAcom.getSiiFuncion1().getFunNombre());
        
        return unAutoComisorioVo;
    }  
    
    public List<AutoComisorioVO> buscarTodoAutoComisorio() throws ExcepcionDAO {
        List<AutoComisorioVO> listaAutoComisorioVo= null;
        List<SiiAutoComisorio> lista = autoComisorioDao.buscarTodoAutoComisorio();
        if (lista!=null) {
            listaAutoComisorioVo = new ArrayList<AutoComisorioVO>();
            for (SiiAutoComisorio siiAutoComisorio: lista) {
                AutoComisorioVO unAutoComisorioVo = new AutoComisorioVO(siiAutoComisorio);
                if(siiAutoComisorio.getAucEstado().equals("B") ){
                    unAutoComisorioVo.setAucEstado("BORRADOR");
                }
                if(siiAutoComisorio.getAucEstado().equals("A") ){
                    unAutoComisorioVo.setAucEstado("APROBADO");
                }
                if(siiAutoComisorio.getAucEstado().equals("N") ){
                    unAutoComisorioVo.setAucEstado("ANULADO");
                }
                listaAutoComisorioVo.add(unAutoComisorioVo);
                    
                
            }
            for(AutoComisorioVO unAutoComisorioVo : listaAutoComisorioVo){
                if(unAutoComisorioVo.getAucTipoVisita().equals("C")){
                    unAutoComisorioVo.setTipoVisita("CONTABLE");
                    unAutoComisorioVo.setEstablecimientoDireccion(unAutoComisorioVo.getContratoVo().getOperadorVo().getPersonaVo().getPerDireccion());
                    unAutoComisorioVo.setMunicipio(unAutoComisorioVo.getContratoVo().getOperadorVo().getPersonaVo().getUbicacionVo().getUbiNombre());
                    List<SiiUbicacion> listSiiUbicacion = ubicacionDao.buscarUbicacionPorPadre(unAutoComisorioVo.getContratoVo().getOperadorVo().getPersonaVo().getUbicacionVo().getUbiCodigoPadre());
                    String departamento = (new UbicacionVO(listSiiUbicacion.get(0))).getUbiNombre();
                    unAutoComisorioVo.setDepartamento(departamento);

                }
                if(unAutoComisorioVo.getAucTipoVisita().equals("F")){
                    unAutoComisorioVo.setTipoVisita("FISCALIZACIÓN");
                    unAutoComisorioVo.setEstablecimientoDireccion(unAutoComisorioVo.getEstablecimientoVo().getEstDireccion());
                    unAutoComisorioVo.setMunicipio(unAutoComisorioVo.getEstablecimientoVo().getEstNombre() );
                    List<SiiUbicacion> listSiiUbicacion = ubicacionDao.buscarUbicacionPorPadre(unAutoComisorioVo.getEstablecimientoVo().getUbicacionVo().getUbiCodigoPadre());
                    String departamento = (new UbicacionVO(listSiiUbicacion.get(0))).getUbiNombre();
                    unAutoComisorioVo.setDepartamento(departamento);
                }
            }
        }
        
        return (listaAutoComisorioVo);
    }
    public AutoComisorioVO actualizarAutoComisorio (AutoComisorioVO autoComisorioVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        
        SiiAutoComisorio siiAutoComisorio = conversionVoEntidad.convertir(autoComisorioVo);
        siiAutoComisorio  = autoComisorioDao.actualizarAutoComisorio(siiAutoComisorio);
        
        adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.AUTO_COMISORIO.getId(),
                                                        "A",usuarioLogueado, siiAutoComisorio.getAucCodigo());
       
        return (new AutoComisorioVO(siiAutoComisorio));
      
    }

    public AutoComisorioVO insertarAutoComisorio(AutoComisorioVO autoComisorioVo ) throws ExcepcionDAO {        
       
       try{
           SiiAutoComisorio siiAutoComisorio = autoComisorioDao.insertarSiiAutoComisorio(conversionVoEntidad.convertir(autoComisorioVo));
        if(siiAutoComisorio == null )
            return null;
        return (new AutoComisorioVO(siiAutoComisorio));
           
        } catch (ExcepcionDAO ex){
            ex.printStackTrace();
            throw ex;
        } 
    }
    
    public String siguienteNumeroAutoComisorio() throws ExcepcionDAO {
    String idSiguiente= autoComisorioDao.siguienteNumeroAutoComisorio();
    return idSiguiente;   
    }
    
    public  List<EstablecimientoVO>  buscarEstablecimientoXIdContrato(Long conCodigo )throws ExcepcionDAO {
      List<EstablecimientoVO> listEstablecimientoVo = new ArrayList();
      List<SiiEstablecimiento> listSiiEstablecimiento = establecimientoDao.buscarEstablecimientoXIdContrato(conCodigo);
      for (SiiEstablecimiento unaSiiEstablecimiento : listSiiEstablecimiento){
          SiiUbicacion ubicacion2 = ubicacionDao.buscarUbicacionPorId(unaSiiEstablecimiento.getSiiUbicacion1().getUbiCodigoPadre());
          SiiUbicacion ubicacion = ubicacionDao.buscarUbicacionPorId(unaSiiEstablecimiento.getSiiUbicacion1().getUbiCodigo());
          EstablecimientoVO establecimientoVo = new EstablecimientoVO();
          UbicacionVO ubicacionVo = new UbicacionVO();
          UbicacionVO ubicacionVo2 = new UbicacionVO();
          ubicacionVo2 = new UbicacionVO(ubicacion2);
          ubicacionVo = new UbicacionVO(ubicacion);
          establecimientoVo=new EstablecimientoVO (unaSiiEstablecimiento);
          establecimientoVo.setUbicacionVo(ubicacionVo);
          establecimientoVo.setUbicacionVo2(ubicacionVo2);
          listEstablecimientoVo.add(establecimientoVo);
      }
       
       
    return listEstablecimientoVo;
    }
    
    public List<GrupoFiscalizacionVO> buscarGruposAutoComisiorio(Date fechaIni )throws ExcepcionDAO ,  ExcepcionDAO {
        try{
        GrupoFiscalizacionVO grupoFiscalizacionVo = new GrupoFiscalizacionVO();
        List<GrupoFiscalizacionVO> listGrupoFiscalizacionVo = new ArrayList();
        List<SiiFiscalizadorSustanc> listSiiFisSustancPrincipal= new ArrayList();  
        List<SiiFiscalizadorSustanc> listSiiFisSustancPrincipalTemp= new ArrayList();  
        List<SiiFiscalizadorSustanc> listSiiFisSustancAcompañante= new ArrayList();
        List<SiiFiscalizadorSustanc> listSiiFisSustancAcompañanteTemp= new ArrayList();
        List<UsuarioVO> listUsuarioVo = new ArrayList();
        Calendar calendarioInicioSemana = Calendar.getInstance();
        Calendar calendarioFindeSemana = Calendar.getInstance();
    
        listSiiFisSustancPrincipalTemp = fiscalizadorSustancDao.buscarTodoFiscalizadorPrincipal();
            for (SiiFiscalizadorSustanc siiFisSustancPrincipal : listSiiFisSustancPrincipalTemp ){
                List<SiiHistEstadoFiscaliz>  listSiiHistEstadoFiscaliz = histEstadoFiscalizDao.buscarHistEstadoFiscalizPorEstadoYTipo(siiFisSustancPrincipal.getFsuCodigo(), "P");
                if(listSiiHistEstadoFiscaliz.size()>0 ){
                    if(listSiiHistEstadoFiscaliz.get(0).getHefEstado().equals("A")){
                      siiFisSustancPrincipal.addSiiHistEstadoFiscaliz(listSiiHistEstadoFiscaliz.get(0));
                      listSiiFisSustancPrincipal.add(siiFisSustancPrincipal);  
                    }
                }
            }
        listSiiFisSustancAcompañanteTemp = fiscalizadorSustancDao.buscarTodoFiscalizadorAcompañante();
        for (SiiFiscalizadorSustanc siiFisSustancAcompañante : listSiiFisSustancAcompañanteTemp ){
            List<SiiHistEstadoFiscaliz>  listSiiHistEstadoFiscaliz = histEstadoFiscalizDao.buscarHistEstadoFiscalizPorEstadoYTipo(siiFisSustancAcompañante.getFsuCodigo(), "A");
            if(listSiiHistEstadoFiscaliz.size()>0 ){
                if(listSiiHistEstadoFiscaliz.get(0).getHefEstado().equals("A")){
                  siiFisSustancAcompañante.addSiiHistEstadoFiscaliz(listSiiHistEstadoFiscaliz.get(0));
                  listSiiFisSustancAcompañante.add(siiFisSustancAcompañante);  
                }
            }
        }
        if(listSiiFisSustancPrincipal.size()<=0 || listSiiFisSustancAcompañante.size()<=0 )    {
                return listGrupoFiscalizacionVo; 
        }
            
        
        calendarioInicioSemana.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendarioInicioSemana.set(Calendar.MINUTE,0);
        calendarioInicioSemana.set(Calendar.SECOND,0);
        calendarioInicioSemana.set(Calendar.HOUR_OF_DAY,0);
        Date dateIni=calendarioInicioSemana.getTime();
            
        calendarioFindeSemana.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendarioInicioSemana.set(Calendar.MINUTE,0);
        calendarioInicioSemana.set(Calendar.SECOND,0);
        calendarioInicioSemana.set(Calendar.HOUR_OF_DAY,0);
        Date dateFin=calendarioFindeSemana.getTime();
        List<GrupoFiscalizacionVO>  listSiiGrupoFiscalizacion = new ArrayList();
       
        if(fechaIni != null ){
              listSiiGrupoFiscalizacion = grupoFiscalizadorDao.buscarGrupoFiscalizacionXSemana(fechaIni,dateFin);
        }
        else{
             listSiiGrupoFiscalizacion = grupoFiscalizadorDao.buscarGrupoFiscalizacionXSemana(dateIni,dateFin);
        }
       
        //valida que existan grupos de fiscalización
       if(listSiiGrupoFiscalizacion.size() >0 ){  
           for (GrupoFiscalizacionVO unSiiGrupoFiscalizacion :  listSiiGrupoFiscalizacion){
               SiiFiscalizadorSustanc siiFiscalizadorSustancAcom =  fiscalizadorSustancDao.buscarPorCodigoSiiFiscalizadorSustanc(unSiiGrupoFiscalizacion.getFiscalizadorSustancVoAcompañante().getFsuCodigo());
               SiiFiscalizadorSustanc siiFiscalizadorSustancPrin =  fiscalizadorSustancDao.buscarPorCodigoSiiFiscalizadorSustanc(unSiiGrupoFiscalizacion.getFiscalizadorSustancVoPrincipal().getFsuCodigo());
               unSiiGrupoFiscalizacion.setFiscalizadorSustancVoAcompañante(new FiscalizadorSustancVO(siiFiscalizadorSustancAcom) );
               unSiiGrupoFiscalizacion.setFiscalizadorSustancVoPrincipal(new FiscalizadorSustancVO(siiFiscalizadorSustancPrin) );
               listGrupoFiscalizacionVo.add( unSiiGrupoFiscalizacion);   
           }
         
       }
       else {   
           GrupoFiscalizacionVO ultimoGrupoFiscalizacionVo = grupoFiscalizadorDao.ultimoGrupoFiscalizador(); 
           if(ultimoGrupoFiscalizacionVo == null){
               Integer tempNum = 0;
               int j=0;
               int tempj =0;
               for(int i = 0 ; i < listSiiFisSustancPrincipal.size() ;i++ ){
                   
                   grupoFiscalizacionVo= new GrupoFiscalizacionVO();
                   grupoFiscalizacionVo.setFiscalizadorSustancVoPrincipal(new FiscalizadorSustancVO (listSiiFisSustancPrincipal.get(i)));
                   
                   if( tempj==listSiiFisSustancAcompañante.size())
                      tempj=0;
                   
                   for( j = tempj ; j < listSiiFisSustancAcompañante.size() ;j++  ){
                       grupoFiscalizacionVo.setFiscalizadorSustancVoAcompañante(new FiscalizadorSustancVO (listSiiFisSustancAcompañante.get(j)));
                       break;
                   }
                   grupoFiscalizacionVo.setGfiFechaIni(dateIni);
                   grupoFiscalizacionVo.setGfiFechaFin(dateFin);
                   tempj=tempj+1;
                   tempNum=tempNum+1;
                   grupoFiscalizacionVo.setGfiNumero(tempNum.toString());  
                
                   listGrupoFiscalizacionVo.add(grupoFiscalizacionVo);
               }           
           }
           else{
              Integer tempNum = 0;
              int j=0;
              int tempj =0;
              int temAcom = 0;
              //busca posición del ultimo acompañante
              for(SiiFiscalizadorSustanc unSiiFiscalizadorSustanc : listSiiFisSustancAcompañante ){
                  if(unSiiFiscalizadorSustanc.getFsuCodigo() != ultimoGrupoFiscalizacionVo.getFiscalizadorSustancVoAcompañante().getFsuCodigo())
                      temAcom=temAcom+1;
              }
               
              //reinicia acompañantes
              if (temAcom != 0 && listSiiFisSustancAcompañante.size() != temAcom )
                  tempj=temAcom+1;
              else
                   tempj=temAcom;
               
               for(int i = 0 ; i < listSiiFisSustancPrincipal.size() ;i++ ){
                   
                   grupoFiscalizacionVo= new GrupoFiscalizacionVO();
                   grupoFiscalizacionVo.setFiscalizadorSustancVoPrincipal(new FiscalizadorSustancVO (listSiiFisSustancPrincipal.get(i)));                                     
                   
                   if( tempj == listSiiFisSustancAcompañante.size())
                      tempj = 0;
                   
                   //asigna acompañantes
                   for( j = tempj ; j < listSiiFisSustancAcompañante.size() ;j++  ){
                       grupoFiscalizacionVo.setFiscalizadorSustancVoAcompañante(new FiscalizadorSustancVO (listSiiFisSustancAcompañante.get(j)));
                       break;
                   }
                   
                   grupoFiscalizacionVo.setGfiFechaIni(dateIni);
                   grupoFiscalizacionVo.setGfiFechaFin(dateFin);
                   tempj = tempj+1;
                   tempNum = tempNum+1;
                   grupoFiscalizacionVo.setGfiNumero(tempNum.toString());  
                
                   listGrupoFiscalizacionVo.add(grupoFiscalizacionVo);
                      
               }
          }
       }
       for (GrupoFiscalizacionVO unGrupoFiscalizacionVo:listGrupoFiscalizacionVo ){
           if(unGrupoFiscalizacionVo.getFiscalizadorSustancVoAcompañante() != null){
               unGrupoFiscalizacionVo.getFiscalizadorSustancVoAcompañante().setTipoIntegrante("ACOMPAÑANTE");
               SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorIdPersona(unGrupoFiscalizacionVo.getFiscalizadorSustancVoAcompañante().getPersonaVo().getPerCodigo());
               if(siiUsuario != null)
                    unGrupoFiscalizacionVo.getFiscalizadorSustancVoAcompañante().setCargo(siiUsuario.getSiiFuncion1().getFunNombre());
           }
           if(unGrupoFiscalizacionVo.getFiscalizadorSustancVoPrincipal() != null){
              unGrupoFiscalizacionVo.getFiscalizadorSustancVoPrincipal().setTipoIntegrante("PRINCIPAL");
              SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorIdPersona(unGrupoFiscalizacionVo.getFiscalizadorSustancVoPrincipal().getPersonaVo().getPerCodigo());
              if(siiUsuario != null)
                    unGrupoFiscalizacionVo.getFiscalizadorSustancVoPrincipal().setCargo(siiUsuario.getSiiFuncion1().getFunNombre());
           }

       }
           
       if(listSiiGrupoFiscalizacion.size() == 0){
            if(listGrupoFiscalizacionVo != null)
                for(GrupoFiscalizacionVO unGrupFiscalizacionVo :listGrupoFiscalizacionVo ){
                    grupoFiscalizadorDao.insertarSiiGrupoFiscalizacion(conversionVoEntidad.convertir(unGrupFiscalizacionVo));
            }
       }
                                    
    return listGrupoFiscalizacionVo;
    
    } catch (ExcepcionDAO ex){
        ex.printStackTrace();
        throw ex;
    } 
        
    }
    
    public List<AutoComisorioVO> buscarAutoComisorioPorTipoVisitaYCodigoContrato (String tipoVisita, Long conCodigo) throws ExcepcionDAO{
        List<AutoComisorioVO> listaAutoComisorioVO = new ArrayList<AutoComisorioVO>();
        List<SiiAutoComisorio> listaAutoComisorio = autoComisorioDao.buscarAutoComisorioPorTipoVisitaYCodigoContrato(tipoVisita, conCodigo);
        for (SiiAutoComisorio autoComisorio:listaAutoComisorio){
            listaAutoComisorioVO.add(new AutoComisorioVO(autoComisorio));
        }
     
        return listaAutoComisorioVO;
    }
    
    
    public List<AutoComisorioAccConVO> buscarTodoAutoComisorioAcc( ) throws ExcepcionDAO {
    
        List<AutoComisorioAccConVO> listaAutoComisorioVo = null;
        List<SiiAutoComisorioAccCon> lista = autoComisorioAccConDao.buscarTodoAutoComisorioAcc();
        if (lista!=null) {
            listaAutoComisorioVo = new ArrayList<AutoComisorioAccConVO>();
            for (SiiAutoComisorioAccCon siiAutoComisorioAccCon: lista) {
                AutoComisorioAccConVO unAutoComisorioAccVo = new AutoComisorioAccConVO(siiAutoComisorioAccCon);
                if(siiAutoComisorioAccCon.getAcaEstado().equals("B") ){
                    unAutoComisorioAccVo.setAcaEstado("BORRADOR");
                }
                if(siiAutoComisorioAccCon.getAcaEstado().equals("A") ){
                    unAutoComisorioAccVo.setAcaEstado("APROBADO");
                }
                if(siiAutoComisorioAccCon.getAcaEstado().equals("N") ){
                    unAutoComisorioAccVo.setAcaEstado("ANULADO");
                }
                listaAutoComisorioVo.add(unAutoComisorioAccVo);
            }
        }
            
     return listaAutoComisorioVo;
    
    }
    
    public String siguienteNumeroAutoComisorioAcc() throws ExcepcionDAO {
        String idSiguiente= autoComisorioAccConDao.siguienteNumeroAutoComisorioAcc();
        return idSiguiente;   
    }
    
    public List<GrupoAccionControlVO> buscarGrupoAccionControlXFecha (Date fecha) throws ExcepcionDAO {
        List<GrupoAccionControlVO> listGrupoAccionControlVo;
        List<GrupoAccionControlVO> listGrupoAccControlVo = new ArrayList();
        List<SiiHistEstadoSustan> listSiiHistEstadoSustanAc = new ArrayList();
        List<SiiHistEstadoSustan> listSiiHistEstadoSustan = new ArrayList();
        GrupoAccionControlVO ultimoGrupoAccionControlVo = grupoAccionControlDao.ultimoGrupoAccionControl();
  
        listGrupoAccionControlVo = grupoAccionControlDao.buscarGrupoAccionControlXFecha(fecha);
        for (GrupoAccionControlVO grupoAccionControlVo  : listGrupoAccionControlVo){
            if(grupoAccionControlVo.getSustanciadorAuditorAcompVo().getSuaCodigo() != null){
            
                SustanciadorAuditorVO sustanciadorAuditorVo = new SustanciadorAuditorVO();
                
                listSiiHistEstadoSustanAc =
                histEstadoSustanDao.buscarHistEstadoSustanPorAuditor(grupoAccionControlVo.getSustanciadorAuditorAcompVo().getSuaCodigo(),"A");
                
                if(listSiiHistEstadoSustanAc.get(0).getHesEstado().equals("A") ){
                    SiiSustanciadorAuditor siiSustanciadorAuditor  = sustanciadorAuditorDao.buscarPorCodigo(grupoAccionControlVo.getSustanciadorAuditorAcompVo().getSuaCodigo());
                    sustanciadorAuditorVo = new SustanciadorAuditorVO(siiSustanciadorAuditor);
                    sustanciadorAuditorVo.setSuaGrupoAsigVis("ACOMPAÑANTE");
                    sustanciadorAuditorVo.setNombreCompleto(sustanciadorAuditorVo.getPersonaVo().getNombreCompleto());
                    sustanciadorAuditorVo.setPerNumIdentificacion(sustanciadorAuditorVo.getPersonaVo().getPerNumIdentificacion());
                    grupoAccionControlVo.setSustanciadorAuditorAcompVo(sustanciadorAuditorVo);     
                }
            }
            
            if(grupoAccionControlVo.getSustanciadorAuditorPpalVo().getSuaCodigo() != null){
                SustanciadorAuditorVO sustanciadorAuditorVo = new SustanciadorAuditorVO();
                
               listSiiHistEstadoSustan =
                histEstadoSustanDao.buscarHistEstadoSustanPorAuditor(grupoAccionControlVo.getSustanciadorAuditorPpalVo().getSuaCodigo(),"P");
                
                if(listSiiHistEstadoSustan.get(0).getHesEstado().equals("A") ){
                
                    SiiSustanciadorAuditor siiSustanciadorAuditor =
                    sustanciadorAuditorDao.buscarPorCodigo(grupoAccionControlVo.getSustanciadorAuditorPpalVo().getSuaCodigo());
                    sustanciadorAuditorVo = new SustanciadorAuditorVO(siiSustanciadorAuditor);
                    sustanciadorAuditorVo.setSuaGrupoAsigVis("PRINCIPAL"); 
                    sustanciadorAuditorVo.setNombreCompleto(sustanciadorAuditorVo.getPersonaVo().getNombreCompleto());
                    sustanciadorAuditorVo.setPerNumIdentificacion(sustanciadorAuditorVo.getPersonaVo().getPerNumIdentificacion());
                    grupoAccionControlVo.setSustanciadorAuditorPpalVo(sustanciadorAuditorVo);
                }            
            }
            if(listSiiHistEstadoSustanAc.get(0).getHesEstado().equals("A") && listSiiHistEstadoSustan.get(0).getHesEstado().equals("A")  )
                listGrupoAccControlVo.add(grupoAccionControlVo);
        }
   
        
        return listGrupoAccControlVo;
    
    }
   
    public List<GrupoAccionControlVO> buscarGruposAutoComisiorioAccFecha (Date fecha,Integer numGrupos) throws ExcepcionDAO {
        try{
        List<SiiSustanciadorAuditor> listSiiSustanciadorAuditorPrin= new ArrayList();  
        List<SiiSustanciadorAuditor> listSiiSustanciadorAuditorAcom= new ArrayList();
        List<GrupoAccionControlVO> listGrupoAccionControlVo;
        List<GrupoAccionControlVO> listGrupoAccConVo = new ArrayList();
        List<GrupoAccionControlVO> returnListGrupoAccConVo = new ArrayList();
        List<UsuarioVO> listUsuarioVo = new ArrayList();
        GrupoAccionControlVO grupoAccionControlVo = new GrupoAccionControlVO();
              
        List<SiiSustanciadorAuditor>  listSiiSustanciadores = sustanciadorAuditorDao.buscarTodoOrdenadoPorPrimerNombre();
            for (SiiSustanciadorAuditor siiSustanciadorAuditor : listSiiSustanciadores ){
                List<SiiHistEstadoSustan>  listSiiHistEstadoSustan = histEstadoSustanDao.buscarHistEstadoSustanciadorPorEstadoYTipo(siiSustanciadorAuditor.getSuaCodigo(), "P");
                if( listSiiHistEstadoSustan != null && listSiiHistEstadoSustan.size()>0 ){
                    if(listSiiHistEstadoSustan.get(0).getHesEstado().equals("A") ){
                      siiSustanciadorAuditor.addSiiHistEstadoSustan(listSiiHistEstadoSustan.get(0));
                      listSiiSustanciadorAuditorPrin.add(siiSustanciadorAuditor);  
                    }
                }
            }
     
            for (SiiSustanciadorAuditor siiSustanciadorAuditor : listSiiSustanciadores ){
                List<SiiHistEstadoSustan>  listSiiHistEstadoSustan = histEstadoSustanDao.buscarHistEstadoSustanciadorPorEstadoYTipo(siiSustanciadorAuditor.getSuaCodigo(), "A");
                if( listSiiHistEstadoSustan != null &&  listSiiHistEstadoSustan.size()>0 ){
                    if (listSiiHistEstadoSustan.get(0).getHesEstado().equals("A")){
                      siiSustanciadorAuditor.addSiiHistEstadoSustan(listSiiHistEstadoSustan.get(0));
                      listSiiSustanciadorAuditorAcom.add(siiSustanciadorAuditor);  
                    }
                }
            }    
            if(listSiiSustanciadorAuditorPrin.size() == 0  || listSiiSustanciadorAuditorAcom.size()==0){
                listGrupoAccionControlVo = new ArrayList();
                return listGrupoAccionControlVo; 
            }
            
        listGrupoAccionControlVo = grupoAccionControlDao.buscarGrupoAccionControlXFecha(fecha);
     
        //valida que existan grupos de fiscalización
        if(listGrupoAccionControlVo.size() >0 ){
           for (GrupoAccionControlVO unGrupoAccionControlVo :  listGrupoAccionControlVo){
               SiiSustanciadorAuditor siiSustanciadorAuditorAcom =  sustanciadorAuditorDao.buscarPorCodigo(unGrupoAccionControlVo.getSustanciadorAuditorAcompVo().getSuaCodigo());
               SiiSustanciadorAuditor siiSustanciadorAuditorPrin =  sustanciadorAuditorDao.buscarPorCodigo(unGrupoAccionControlVo.getSustanciadorAuditorPpalVo().getSuaCodigo());
               
               SustanciadorAuditorVO sustanciadorAuditorAcomVo = new SustanciadorAuditorVO(siiSustanciadorAuditorAcom);
               sustanciadorAuditorAcomVo.setNombreCompleto(sustanciadorAuditorAcomVo.getPersonaVo().getNombreCompleto());
               sustanciadorAuditorAcomVo.setPerNumIdentificacion(sustanciadorAuditorAcomVo.getPersonaVo().getPerNumIdentificacion());
               unGrupoAccionControlVo.setSustanciadorAuditorAcompVo(sustanciadorAuditorAcomVo);
               
               SustanciadorAuditorVO sustanciadorAuditorPrinVo = new SustanciadorAuditorVO(siiSustanciadorAuditorPrin);
               sustanciadorAuditorPrinVo.setNombreCompleto(sustanciadorAuditorPrinVo.getPersonaVo().getNombreCompleto());
               sustanciadorAuditorPrinVo.setPerNumIdentificacion(sustanciadorAuditorPrinVo.getPersonaVo().getPerNumIdentificacion());
               unGrupoAccionControlVo.setSustanciadorAuditorPpalVo(sustanciadorAuditorPrinVo);
               listGrupoAccConVo.add(unGrupoAccionControlVo);   
           }
        }
        else {   
            GrupoAccionControlVO ultimoGrupoAccionControlVO = grupoAccionControlDao.ultimoGrupoAccionControl(); 
            if(ultimoGrupoAccionControlVO == null){
           
                Integer tempNum = 0;
                int j=0;
                int tempj =0;
                if(numGrupos == null )
                    numGrupos = listSiiSustanciadorAuditorPrin.size();
                
                for(int i = 0 ; i < numGrupos ;i++ ){
                    
                    grupoAccionControlVo = new GrupoAccionControlVO();
                    grupoAccionControlVo.setSustanciadorAuditorPpalVo(new SustanciadorAuditorVO (listSiiSustanciadorAuditorPrin.get(i)));
                    
                    if( tempj==listSiiSustanciadorAuditorAcom.size())
                       tempj=0;
                    
                    for( j = tempj ; j < listSiiSustanciadorAuditorAcom.size() ;j++  ){
                        grupoAccionControlVo.setSustanciadorAuditorAcompVo(new SustanciadorAuditorVO (listSiiSustanciadorAuditorAcom.get(j)));
                        break;
                    }
                    grupoAccionControlVo.setGacFecha(fecha);
                    tempj=tempj+1;
                    tempNum=tempNum+1;
                    grupoAccionControlVo.setGacNumero(tempNum);  
                 
                    listGrupoAccConVo.add(grupoAccionControlVo);
                    }          
                }               
            
            else{
               Integer tempNum = 0;
               int j=0;
               int tempj =0;
               int tempi = 0; 
               int temAcom = 0;
               int temPrin = 0;
               //busca posición del ultimo acompañante
               for(SiiSustanciadorAuditor unSiiSustanciadorAuditor : listSiiSustanciadorAuditorAcom ){
                   if(unSiiSustanciadorAuditor.getSuaCodigo() != ultimoGrupoAccionControlVO.getSustanciadorAuditorAcompVo().getSuaCodigo())
                       temAcom=temAcom+1;
               }
                
               //inicializa posicion ultimo acompañantes
               if (temAcom != 0 && listSiiSustanciadorAuditorAcom.size()!= temAcom )
                   tempj=temAcom+1;
               else
                    tempj=temAcom;
                
                //busca posición del ultimo  principal
                for(SiiSustanciadorAuditor unSiiSustanciadorAuditor : listSiiSustanciadorAuditorAcom ){
                    if(unSiiSustanciadorAuditor.getSuaCodigo() != ultimoGrupoAccionControlVO.getSustanciadorAuditorPpalVo().getSuaCodigo())
                            temPrin=temPrin+1;
                }
                                    
                
                //inicializa posicion ultimo  principal
                if (temPrin != 0 && listSiiSustanciadorAuditorPrin.size()!= temPrin )
                    tempi=temPrin+1;
                else
                     tempi=temPrin;
               
                if(numGrupos == null )
                    numGrupos = listSiiSustanciadorAuditorPrin.size();
                
                
                for(int i = tempi ; i < (numGrupos+tempi) ;i++ ){
                    
                    if( listSiiSustanciadorAuditorPrin.size() <= i) {
                        numGrupos =  numGrupos - listSiiSustanciadorAuditorPrin.size() ;
                        i = 0;
                    }
                        
                    grupoAccionControlVo= new GrupoAccionControlVO();
                    grupoAccionControlVo.setSustanciadorAuditorPpalVo(new SustanciadorAuditorVO (listSiiSustanciadorAuditorPrin.get(i)));                                     
                    
                    if( tempj == listSiiSustanciadorAuditorAcom.size())
                       tempj = 0;
                    
                    //asigna acompañantes
                    for( j = tempj ; j < listSiiSustanciadorAuditorAcom.size() ;j++  ){
                        grupoAccionControlVo.setSustanciadorAuditorAcompVo(new SustanciadorAuditorVO (listSiiSustanciadorAuditorAcom.get(j)));
                        break;
                    }
                    grupoAccionControlVo.setGacFecha(fecha);
                    tempj = tempj+1;
                    tempNum = tempNum+1;
                    grupoAccionControlVo.setGacNumero(tempNum);  
                 
                    listGrupoAccConVo.add(grupoAccionControlVo);
                       
                }
            }
            
            if(listGrupoAccConVo.size() != 0){
                 if(listGrupoAccConVo != null)
                     for(GrupoAccionControlVO unGrupoAccionControlVO:listGrupoAccConVo ){
                       SiiGrupoAccionControl unSiiGrupoAccionControl  =   grupoAccionControlDao.insertarGrupoAccionControl(conversionVoEntidad.convertir(unGrupoAccionControlVO));
                       GrupoAccionControlVO unGrupoAccionControlVo = new GrupoAccionControlVO();
                       unGrupoAccionControlVo = new GrupoAccionControlVO (unSiiGrupoAccionControl);
                  
                       unGrupoAccionControlVo.getSustanciadorAuditorPpalVo().setSuaGrupoAsigVis("PRINCIPAL");
                       unGrupoAccionControlVo.getSustanciadorAuditorPpalVo().setNombreCompleto(unGrupoAccionControlVo.getSustanciadorAuditorPpalVo().getPersonaVo().getNombreCompleto());
                       unGrupoAccionControlVo.getSustanciadorAuditorPpalVo().setPerNumIdentificacion(unGrupoAccionControlVo.getSustanciadorAuditorPpalVo().getPersonaVo().getPerNumIdentificacion());
    
                       unGrupoAccionControlVo.getSustanciadorAuditorAcompVo().setSuaGrupoAsigVis("ACOMPAÑANTE");
                       unGrupoAccionControlVo.getSustanciadorAuditorAcompVo().setNombreCompleto(unGrupoAccionControlVo.getSustanciadorAuditorAcompVo().getPersonaVo().getNombreCompleto());
                       unGrupoAccionControlVo.getSustanciadorAuditorAcompVo().setPerNumIdentificacion(unGrupoAccionControlVo.getSustanciadorAuditorAcompVo().getPersonaVo().getPerNumIdentificacion());
     
                       returnListGrupoAccConVo.add(unGrupoAccionControlVo) ;
                 }
            }
        }
                       
        return returnListGrupoAccConVo;
        } catch (ExcepcionDAO ex){
            ex.printStackTrace();
            throw ex;
        }
    }
    
    
    public AutoComisorioAccConVO insertarAutoComisorioAcc(AutoComisorioAccConVO autoComisorioAccConVo ) throws ExcepcionDAO {     
       
            SiiAutoComisorioAccCon siiAutoComisorioAccCon = autoComisorioAccConDao.insertarAutoComisorioAccCon(conversionVoEntidad.convertir(autoComisorioAccConVo));
        if(siiAutoComisorioAccCon == null )
            return null;
        return (new AutoComisorioAccConVO(siiAutoComisorioAccCon));
     
        
    }
    
    public AutoComisorioAccConVO actualizarAutoComisorioAcc (AutoComisorioAccConVO autoComisorioAccConVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        SiiAutoComisorioAccCon siiAutoComisorioAccCon = conversionVoEntidad.convertir(autoComisorioAccConVo);
        siiAutoComisorioAccCon  = autoComisorioAccConDao.actualizarAutoComisorioAccCon(siiAutoComisorioAccCon);
          SiiDenuncia siiDenuncia = denunciaDao.buscarPorCodigo(autoComisorioAccConVo.getDenunciaVo().getDenCodigo());
          if (siiDenuncia != null  && autoComisorioAccConVo.getAcaEstado().equals("A") ){
              SiiEstadoDenuncia siiEstadoDenuncia = estadoDenunciaDao.buscarEstadoPorNombre("AUTO COMISORIO"); 
              siiDenuncia.setSiiEstadoDenuncia(siiEstadoDenuncia);
              denunciaDao.actualizar(siiDenuncia);
              
              adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.AUTO_COMISORIO_ACC.getId(),
                                                          siiEstadoDenuncia.getEdnCodigo(),
                                                          usuarioLogueado, siiAutoComisorioAccCon.getAcaCodigo());
              adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.AUTO_COMISORIO_ACC.getId(),
                                                              "A",usuarioLogueado, siiAutoComisorioAccCon.getAcaCodigo());
          }
        return (new AutoComisorioAccConVO(siiAutoComisorioAccCon)); 
    }
    
    public AutoComisorioAccConVO buscaSiiAutoComisorioAccConPorId(Long idAutCodigo) throws ExcepcionDAO {
        AutoComisorioAccConVO autoComisorioAccConVo = new AutoComisorioAccConVO();
        SiiAutoComisorioAccCon siiAutoComisorioAccCon =   autoComisorioAccConDao.buscaSiiAutoComisorioAccConPorId(idAutCodigo);
        autoComisorioAccConVo = new AutoComisorioAccConVO(siiAutoComisorioAccCon);
        DenunciaVO denunciaVo= new DenunciaVO();
        
        autoComisorioAccConVo.getDenunciaVo().setDenDenunDireccion(direccionDao.buscarDireccionCompletaXIdDenuncia(autoComisorioAccConVo.getDenunciaVo().getDenCodigo()));           
        SustanciadorAuditorVO sustanciadorAuditorAcomVo = new SustanciadorAuditorVO();
        sustanciadorAuditorAcomVo.setNombreCompleto(autoComisorioAccConVo.getGrupoAccionControlVo().getSustanciadorAuditorAcompVo().getPersonaVo().getNombreCompleto());
        sustanciadorAuditorAcomVo.setPerNumIdentificacion(autoComisorioAccConVo.getGrupoAccionControlVo().getSustanciadorAuditorAcompVo().getPersonaVo().getPerNumIdentificacion());
        sustanciadorAuditorAcomVo.setSuaGrupoAsigVis("ACOMPAÑANTE");
        autoComisorioAccConVo.getGrupoAccionControlVo().setSustanciadorAuditorAcompVo(sustanciadorAuditorAcomVo);
        
        SustanciadorAuditorVO sustanciadorAuditorPrinVo = new SustanciadorAuditorVO();
        sustanciadorAuditorPrinVo.setNombreCompleto(autoComisorioAccConVo.getGrupoAccionControlVo().getSustanciadorAuditorPpalVo().getPersonaVo().getNombreCompleto());
        sustanciadorAuditorPrinVo.setPerNumIdentificacion(autoComisorioAccConVo.getGrupoAccionControlVo().getSustanciadorAuditorPpalVo().getPersonaVo().getPerNumIdentificacion());
        sustanciadorAuditorPrinVo.setSuaGrupoAsigVis("PRINCIPAL");
        autoComisorioAccConVo.getGrupoAccionControlVo().setSustanciadorAuditorPpalVo(sustanciadorAuditorPrinVo);
        
        
        return autoComisorioAccConVo;
    }
    
    public List<MotivoAnulAuComAcConVO> buscarTodoMotivoAnulAuComAcCon() throws ExcepcionDAO {
        List<MotivoAnulAuComAcConVO> listMotivoAnulAuComAcConVo = new ArrayList();
        List<SiiMotivoAnulAuComAcCon> listMotivoAnulAuComAcCon = motivoAnulAuComAcConDao.buscarTodoMotivoAnulAuComAcCon();
        for (SiiMotivoAnulAuComAcCon unSiiMotivoAnulAuComAcCon :listMotivoAnulAuComAcCon){
            listMotivoAnulAuComAcConVo.add(new MotivoAnulAuComAcConVO(unSiiMotivoAnulAuComAcCon));
        }
        
        return listMotivoAnulAuComAcConVo;
    }


    public List<AutoComisorioAccConVO> buscarAutoComisorioAccPorDenuncia(Long denCodigo) throws ExcepcionDAO {
        
        List<AutoComisorioAccConVO> listaAutoComisorioAccVo = new ArrayList<AutoComisorioAccConVO>();
        for (SiiAutoComisorioAccCon auto : autoComisorioAccConDao.buscarAutoComisorioAccPorDenuncia(denCodigo)) {
            listaAutoComisorioAccVo.add(new AutoComisorioAccConVO(auto));
        }
        return listaAutoComisorioAccVo;
    }
    
    public List<DenunciaVO> buscarDenunciasSinAutoAcc() throws ExcepcionDAO {
        List<DenunciaVO> listDenunciaVo = new ArrayList<DenunciaVO>();
        List<SiiDenuncia> listSiiDenuncia = new ArrayList<SiiDenuncia>();
        List<SiiDenuncia> listSiiDenunciaTemp = denunciaDao.buscarTodo();
        
        for(SiiDenuncia siiDenuncia:listSiiDenunciaTemp){
            if(!siiDenuncia.getSiiEstadoDenuncia().getEdnNombre().equals("DESCARTADO"))
                listSiiDenuncia.add(siiDenuncia);
        }
        
        List<SiiAutoComisorioAccCon> listSiiAutoComisorioAccCon =   autoComisorioAccConDao.buscarTodoAutoComisorioAcc();
    
         for (SiiDenuncia siiDenuncia : listSiiDenuncia){
             Boolean temp= true;
             for (SiiAutoComisorioAccCon unSiiAutoComisorioAccCon : listSiiAutoComisorioAccCon){
                 if(!unSiiAutoComisorioAccCon.getAcaEstado().equals("N") ){
                     if (unSiiAutoComisorioAccCon.getSiiDenuncia()!= null){
                         if(siiDenuncia.getDenCodigo() == unSiiAutoComisorioAccCon.getSiiDenuncia().getDenCodigo() ){
                             temp = false ;
                         }
                     }
                 }
                 }
              if(temp == true){
                     DenunciaVO denunciaVo= new DenunciaVO(siiDenuncia);
                     denunciaVo.setDenDenunDireccion(direccionDao.buscarDireccionCompletaXIdDenuncia(denunciaVo.getDenCodigo()));                                   
                     listDenunciaVo.add(denunciaVo);
              }
         }
        
        return listDenunciaVo;
    }
}
