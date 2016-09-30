/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Desarrollo de Mercados
 * AUTOR	: Walter Becerra
 * FECHA	: 24-11-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DeclaracionOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DeclaracionSugeridaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteDocumDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReferenciaPagoDeclDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RifaPromocionalDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionSugerida;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteDocum;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReferenciaPagoDecl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRifaPromocional;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.ExpedienteDocumVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPromocionalesVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminSolicitudPromocionalesBean implements AdminSolicitudPromocionales{


    private static Long CONCEPTO_CUOTA_DEP;
    private static Long CONCEPTO_CUOTA_GAP;
    @EJB
    private RifaPromocionalDAO rifaPromocionalDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private EstadoSolicAutorizDAO estadoSolicAutorizDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private SolicitudAutorizaDAO solicitudAutorizaDao;
    @EJB
    ExpedienteDocumDAO expedienteDocumDAO;
    @EJB
    private ExpedienteDocumDAO expedienteDocumDao;
    @EJB
    private CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    private ConceptoCuotaDAO conceptoCuotaDao;
    @EJB
    private ReferenciaPagoDeclDAO referenciaPagoDao ;
    @EJB
    private DeclaracionOperadorDAO declaracionOperadorDao ;
    @EJB
    private DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    TipoDocContableDAO tipoDocContableDao;
    @EJB
    DocumentoContableDAO documentoContableDao;
    @EJB
    EstadoDocContabDAO estadoDocContabDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    CuentasContablesDAO cuentasContablesDao;
    @EJB
    ImputacionContableDAO imputacionContableDao;
    @EJB
    DeclaracionSugeridaDAO declaracionSugeridaDao;
 
   

    public AdminSolicitudPromocionalesBean() {
        
    }
    
    public SolicitudPromocionalesVO insertarSiiRifaPromocional(SolicitudPromocionalesVO solicitudPromocionalesVo) throws ExcepcionDAO {
      //  String retorno = "1 Cargue exitoso";
        SiiRifaPromocional siiRifaPromocional= new SiiRifaPromocional();
        SiiPersona siipersonaRep = new SiiPersona();
        SiiPersona unaSiipersona = new SiiPersona();
        
        // busca consecutivo
        solicitudPromocionalesVo.setConsecutivo(Integer.getInteger( rifaPromocionalDao.siguienteNumeroRifaPromocional()));
    
        SiiEstadoSolicAutoriz estadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorNombre("REGISTRADO");
        EstadoSolicAutorizVO estadoSolicAutorizVo = new EstadoSolicAutorizVO(estadoSolicAutoriz);
        solicitudPromocionalesVo.getSolicitudAutorizaVo().setEstadoSolicAutoriz(estadoSolicAutorizVo);
        
        SiiSolicitudAutoriza siiSolicitudAutoriza=conversionVoEntidad.convertir(solicitudPromocionalesVo.getSolicitudAutorizaVo());
        SiiRifaPromocional siiSolicitudPromocionales= conversionVoEntidad.convertir(solicitudPromocionalesVo);        
        //Gestion Documental
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        SiiExpedienteDocum siiExpedienteDoc = new SiiExpedienteDocum();
        
        siiExpedienteDocumento.setEdoCodigo( solicitudPromocionalesVo.getNumeroRadicación());
        siiExpedienteDocumento.setEdoFecha(solicitudPromocionalesVo.getFechaRadicación());
        siiExpedienteDocumento=expedienteDocumDAO.insertarExpedienteDocum(siiExpedienteDocumento);
        siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);
        //------
        siiSolicitudAutoriza=solicitudAutorizaDao.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);
        siiSolicitudPromocionales.setSiiSolicitudAutoriza(siiSolicitudAutoriza);       
        
            if(solicitudPromocionalesVo.getSolicitudAutorizaVo().getPersonaRifaPromVo() != null ){
                 siiRifaPromocional = rifaPromocionalDao.insertarSiiRifaPromocional(siiSolicitudPromocionales);
            }
            if(  solicitudPromocionalesVo.getPersonaVo()!= null ){
                SiiPersona siipersona = new SiiPersona();
                 if(solicitudPromocionalesVo.getPersonaRepVo()!= null ){
                      siipersonaRep=   personaDao.insertarPersona( conversionVoEntidad.convertir(  solicitudPromocionalesVo.getPersonaRepVo() ));
                      siipersona =   personaDao.insertarPersona( conversionVoEntidad.convertir(  solicitudPromocionalesVo.getPersonaVo() ));
                      siipersona.setSiiPersona(siipersonaRep);
                      siipersona= personaDao.actualizarPersona(siipersona);
                      siiSolicitudPromocionales.getSiiSolicitudAutoriza().setSiiPersonaRifaProm(siipersona);   
                      
                 }
                 else{
                     unaSiipersona=  conversionVoEntidad.convertir(solicitudPromocionalesVo.getPersonaVo());
                     siipersona =   personaDao.insertarPersona( unaSiipersona);
                     siiSolicitudPromocionales.getSiiSolicitudAutoriza().setSiiPersonaRifaProm(unaSiipersona);  
                 }
                 
            }
        siiRifaPromocional = rifaPromocionalDao.insertarSiiRifaPromocional(siiSolicitudPromocionales);
        
        
        return new SolicitudPromocionalesVO(siiRifaPromocional);
       
    }
    
    public SolicitudPromocionalesVO  buscarPorCodigoRifaPromocional(Long idSolicitud) throws ExcepcionDAO {
        SiiRifaPromocional  siiRifaPromocional = rifaPromocionalDao.buscarPorCodigoRifaPromocional(idSolicitud);
        return ( new SolicitudPromocionalesVO(siiRifaPromocional) );
    }
    
    
  public List<SolicitudPromocionalesVO> buscarTodoSiiRifaPromocional(Long tipoApuesta ) throws ExcepcionDAO{        
            List<SolicitudPromocionalesVO> listaSolicitudPromocionalesVo= new ArrayList();
            SiiExpedienteDocum siiExpedienteDocum = new SiiExpedienteDocum();
            List<SiiRifaPromocional> listaSiiRifaPromocional= new ArrayList();
            listaSiiRifaPromocional = rifaPromocionalDao.buscarTodoSiiRifaPromocional(tipoApuesta);   
            for(SiiRifaPromocional siiRifaPromocional   :listaSiiRifaPromocional ){
                if(siiRifaPromocional.getSiiSolicitudAutoriza().getSiiExpedienteDocum()!= null ){
                    siiExpedienteDocum=expedienteDocumDAO.buscarExpedienteDocumPorId(siiRifaPromocional.getSiiSolicitudAutoriza().getSiiExpedienteDocum().getEdoCodigo());
                    siiRifaPromocional.getSiiSolicitudAutoriza().setSiiExpedienteDocum(siiExpedienteDocum);
                }
                SolicitudPromocionalesVO nuevoSolicitudPromocionalesVo= new SolicitudPromocionalesVO(siiRifaPromocional); 
                listaSolicitudPromocionalesVo.add(nuevoSolicitudPromocionalesVo);
            }
          
           return listaSolicitudPromocionalesVo;
        } 
  
    public List<SolicitudPromocionalesVO> buscarTodoSiiRifaPromoPorRol(String rol,String tipoApuesta,Long usuCodigo) throws ExcepcionDAO{        
              List<SolicitudPromocionalesVO> listaSolicitudPromocionalesVo= new ArrayList();
              SiiExpedienteDocum siiExpedienteDocum = new SiiExpedienteDocum();
              List<SiiRifaPromocional> listaSiiRifaPromocional= new ArrayList();
              listaSiiRifaPromocional = rifaPromocionalDao.buscarTodoSiiRifaPromoPorRol(rol,tipoApuesta,usuCodigo);   
              for(SiiRifaPromocional siiRifaPromocional   :listaSiiRifaPromocional ){
                  if(siiRifaPromocional.getSiiSolicitudAutoriza().getSiiExpedienteDocum()!= null ){
                      siiExpedienteDocum=expedienteDocumDAO.buscarExpedienteDocumPorId(siiRifaPromocional.getSiiSolicitudAutoriza().getSiiExpedienteDocum().getEdoCodigo());
                      siiRifaPromocional.getSiiSolicitudAutoriza().setSiiExpedienteDocum(siiExpedienteDocum);
                  }
                  SolicitudPromocionalesVO nuevoSolicitudPromocionalesVo= new SolicitudPromocionalesVO(siiRifaPromocional); 
                  listaSolicitudPromocionalesVo.add(nuevoSolicitudPromocionalesVo);
              }
            
             return listaSolicitudPromocionalesVo;
          } 
  
    public SolicitudPromocionalesVO actualizarRifaPromocional(SolicitudPromocionalesVO solicitudPromocionalesVo) throws ExcepcionDAO {      
        SiiPersona siipersona = new  SiiPersona();
        SiiPersona siipersonaRep = new  SiiPersona();
        SiiRifaPromocional siiRifaPromocional= new SiiRifaPromocional();
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza ();
        SiiRifaPromocional siiSolicitudPromocionales= conversionVoEntidad.convertir(solicitudPromocionalesVo); 
        siiSolicitudAutoriza =conversionVoEntidad.convertir(solicitudPromocionalesVo.getSolicitudAutorizaVo()); 
        //Gestion Documental
         SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
         siiExpedienteDocumento = expedienteDocumDAO.buscarExpedienteDocumPorId(solicitudPromocionalesVo.getNumeroRadicación());
         // valida si el documento existe de lo contrario crea uno 
         if(siiExpedienteDocumento != null){
             if(siiExpedienteDocumento.getEdoCodigo().equals(solicitudPromocionalesVo.getNumeroRadicación())  ){
                 siiExpedienteDocumento.setEdoFecha(solicitudPromocionalesVo.getFechaRadicación() );
                 siiExpedienteDocumento=expedienteDocumDAO.actualizarExpedienteDocum(siiExpedienteDocumento);
                 siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento); 
             }
         }
         else {
             SiiExpedienteDocum siiNuevoExpedienteDocumento = new SiiExpedienteDocum();
             siiNuevoExpedienteDocumento.setEdoCodigo( solicitudPromocionalesVo.getNumeroRadicación());
             siiNuevoExpedienteDocumento.setEdoFecha(solicitudPromocionalesVo.getFechaRadicación());
             siiNuevoExpedienteDocumento=expedienteDocumDAO.insertarExpedienteDocum(siiNuevoExpedienteDocumento);
             siiSolicitudAutoriza.setSiiExpedienteDocum(siiNuevoExpedienteDocumento);
         }
        
        // valida si la persona existe o crea una 
        if(solicitudPromocionalesVo.getPersonaVo() != null){             
          
            if(solicitudPromocionalesVo.getPersonaRepVo() != null ){
                if(solicitudPromocionalesVo.getPersonaRepVo().getPerRifaPromo().equals("S")  ){
                    if(siipersonaRep.getPerCodigo()!= null){
                        siipersonaRep =   personaDao.buscarPersonaPorId(solicitudPromocionalesVo.getPersonaRepVo().getPerCodigo());
                        siipersonaRep=   personaDao.actualizarPersona(conversionVoEntidad.convertir(solicitudPromocionalesVo.getPersonaRepVo() ));
                    }
                    else                         
                     siipersonaRep=   personaDao.insertarPersona( conversionVoEntidad.convertir(  solicitudPromocionalesVo.getPersonaRepVo() ));
                }
            }
            if(solicitudPromocionalesVo.getPersonaVo().getPerRifaPromo().equals("S")   ){
              //  siipersona =   personaDao.buscarPersonaPorId(solicitudPromocionalesVo.getPersonaVo().getPerCodigo());
                
                       siipersona=conversionVoEntidad.convertir(  solicitudPromocionalesVo.getPersonaVo() );
                       if(solicitudPromocionalesVo.getPersonaVo().getPerCodigo()==0 ){
                           siipersona=   personaDao.insertarPersona( siipersona);
                       }
                       else{
                           if(siipersonaRep.getPerCodigo()!= null )
                                siipersona.setSiiPersona(siipersonaRep);
                           siipersona= personaDao.actualizarPersona(siipersona);
                       }
                }
                else{
                      siipersona=conversionVoEntidad.convertir(  solicitudPromocionalesVo.getPersonaVo() );
                      if(siipersonaRep.getPerCodigo()!= null )
                          siipersona.setSiiPersona(siipersonaRep);
                       siipersona=   personaDao.insertarPersona( siipersona);
                }
       
            
            siiSolicitudPromocionales.getSiiSolicitudAutoriza().setSiiPersonaRifaProm(siipersona);
        }
        else
            siiSolicitudAutoriza= solicitudAutorizaDao.actualizarSiiSolicitudAutoriza( siiSolicitudAutoriza);
        
       
        siiSolicitudPromocionales.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
        siiRifaPromocional = rifaPromocionalDao.actualizarRifaPromocional(siiSolicitudPromocionales);
        return ( new SolicitudPromocionalesVO(siiRifaPromocional) );

    }
    
    public SolicitudPromocionalesVO aprobarPromocional(SolicitudPromocionalesVO solicitudPromocionalesVo,UsuarioVO usuarioVo) throws ExcepcionDAO {
        Calendar cal=Calendar.getInstance();
        SiiEstadoSolicAutoriz estadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorNombre("APROBADO");
        SiiRifaPromocional  siiRifaPromocional = new SiiRifaPromocional();
        EstadoSolicAutorizVO estadoSolicAutorizVo = new EstadoSolicAutorizVO(estadoSolicAutoriz);
        solicitudPromocionalesVo.getSolicitudAutorizaVo().setEstadoSolicAutoriz(estadoSolicAutorizVo);
        SiiSolicitudAutoriza siiSolicitudAutoriza = solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudPromocionalesVo.getSolicitudAutorizaVo()));
        siiRifaPromocional.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
        siiRifaPromocional=conversionVoEntidad.convertir(solicitudPromocionalesVo);
        rifaPromocionalDao.actualizarRifaPromocional(siiRifaPromocional);
        
            /*
             * Registro del log de estados esto solo si el estado tuvo un cambio
             */
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOLICITUD_AUTORIZA.getId(),
                                                             estadoSolicAutoriz.getEsaCodigo(),
                                                             usuarioVo, siiSolicitudAutoriza.getSauCodigo());
                
        //buscar declaracón
        List<SiiCuotaOperador>  ListSiicuotaOperador= cuotaOperadorDao.buscarCuotaOperadorPorRifaPromocional(solicitudPromocionalesVo.getIdSolicitud());
        for  (SiiCuotaOperador  siiCuotaOperador: ListSiicuotaOperador ) {
            List<SiiDetalleDeclaracion> siiListaDetalleDeclPagos= detalleDeclaracionDao.buscarDetalleDeclaracionPorXCodigoCuotaConDetalle(siiCuotaOperador.getCopCodigo());
        
                //Documento contable
                SiiDocumentoContable insertSiiDocumentoContable= new SiiDocumentoContable();
                SiiTipoDocContable siiTipoDocContable =tipoDocContableDao.buscarPorCodigo("AJP");
                Integer consecutivo =documentoContableDao.buscarConsecutivoDocumentoContable("AJP");
                insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                insertSiiDocumentoContable.setDcoFechaOper(cal.getTime());
                insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                SiiDetalleRecaudo  SiiDetalleRecaudo=  detalleRecaudoDao.buscarPorCodigo(siiListaDetalleDeclPagos.get(0).getSiiDetalleRecaudo().getDreCodigo());
                insertSiiDocumentoContable.setSiiDetalleRecaudo(SiiDetalleRecaudo);
                String nombreEstado="BORRADOR";
                SiiEstadoDocContab  siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
                insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                insertSiiDocumentoContable=documentoContableDao.insertarDocumentoContable(insertSiiDocumentoContable);
                    
                //Imputación contable    
                if(siiListaDetalleDeclPagos.get(0).getDdeValorDeclarado().compareTo(BigDecimal.ZERO)>0 ){     
                    List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= new ArrayList<SiiCuentaContTipoDocCont>();
                    listaSiiCuentaContTipoDocCont=detalleRecaudoDao.BuscarCuentaContTipoDocContable(siiCuotaOperador.getSiiConceptoCuota().getCcuAbreviatura(),"AJP");
                
                    for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont :listaSiiCuentaContTipoDocCont){
                        SiiImputacionContable siiImputacionCont= new SiiImputacionContable();
                        siiImputacionCont.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                        siiImputacionCont.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                        SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                        //validaciones
                        if(siiCuentasContables.getCcoObligaTerc().equals("S") )
                             siiImputacionCont.setSiiPersona(siiSolicitudAutoriza.getSiiPersonaRifaProm());
                        if(siiCuentasContables.getCcoNumDocConta().equals("S") )
                            siiImputacionCont.setSiiDocumentoContable(insertSiiDocumentoContable);
                        if(siiCuentasContables.getCcoReferencia1().equals("S") )
                            siiImputacionCont.setImcReferencia1(solicitudPromocionalesVo.getConsecutivo().toString() );
                        if(siiCuentasContables.getCcoReferencia2().equals("S") )
                            siiImputacionCont.setImcReferencia2(solicitudPromocionalesVo.getNumeroResolucion());
                        
                        siiImputacionCont.setImcDescrOperacion("Aprobacion Promocionales");
                        siiImputacionCont.setImcValor(siiListaDetalleDeclPagos.get(0).getDdeValorDeclarado());
                        siiImputacionCont.setImcEstado("A");
                        imputacionContableDao.insertarImputacionContable(siiImputacionCont);
                        
                    }
              }
                
        }
        return ( new SolicitudPromocionalesVO(siiRifaPromocional));
    }
    
    
    public SolicitudPromocionalesVO aprobarRifa(SolicitudPromocionalesVO solicitudPromocionalesVo,UsuarioVO usuarioVo) throws ExcepcionDAO {
        Calendar cal=Calendar.getInstance();
        SiiEstadoSolicAutoriz estadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorNombre("APROBADO");
        SiiRifaPromocional  siiRifaPromocional = new SiiRifaPromocional();
        EstadoSolicAutorizVO estadoSolicAutorizVo = new EstadoSolicAutorizVO(estadoSolicAutoriz);
        solicitudPromocionalesVo.getSolicitudAutorizaVo().setEstadoSolicAutoriz(estadoSolicAutorizVo);
        SiiSolicitudAutoriza siiSolicitudAutoriza = solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudPromocionalesVo.getSolicitudAutorizaVo()));
        siiRifaPromocional.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
        
            /*
             * Registro del log de estados esto solo si el estado tuvo un cambio
             */
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOLICITUD_AUTORIZA.getId(),
                                                             estadoSolicAutoriz.getEsaCodigo(),
                                                             usuarioVo, siiSolicitudAutoriza.getSauCodigo());
                
       /* //buscar declaracón
        List<SiiCuotaOperador>  ListSiicuotaOperador= cuotaOperadorDao.buscarCuotaOperadorPorRifaPromocional(solicitudPromocionalesVo.getIdSolicitud());
        for  (SiiCuotaOperador  siiCuotaOperador: ListSiicuotaOperador ) {
            List<SiiDetalleDeclaracion> siiListaDetalleDeclPagos= detalleDeclaracionDao.buscarDetalleDeclaracionPorXCodigoCuota(siiCuotaOperador.getCopCodigo());
        
            for (SiiDetalleDeclaracion siiDetalleDeclaracion:siiListaDetalleDeclPagos ){
               
                //Documento contable
                SiiDocumentoContable insertSiiDocumentoContable= new SiiDocumentoContable();
                SiiTipoDocContable siiTipoDocContable =tipoDocContableDao.buscarPorCodigo("AJP");
                Integer consecutivo =documentoContableDao.buscarConsecutivoDocumentoContable("AJP");
                insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                insertSiiDocumentoContable.setDcoFechaOper(cal.getTime());
                insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                SiiDetalleRecaudo  SiiDetalleRecaudo=  detalleRecaudoDao.buscarPorCodigo(siiDetalleDeclaracion.getSiiDetalleRecaudo().getDreCodigo());
                insertSiiDocumentoContable.setSiiDetalleRecaudo(SiiDetalleRecaudo);
                String nombreEstado="BORRADOR";
                SiiEstadoDocContab  siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
                insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                insertSiiDocumentoContable=documentoContableDao.insertarDocumentoContable(insertSiiDocumentoContable);
                    
                //Imputación contable    
                if(siiDetalleDeclaracion.getDdeValorDeclarado().compareTo(BigDecimal.ZERO)>0 ){     
                    List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= new ArrayList<SiiCuentaContTipoDocCont>();
                    listaSiiCuentaContTipoDocCont=detalleRecaudoDao.BuscarCuentaContTipoDocContable(siiCuotaOperador.getSiiConceptoCuota().getCcuAbreviatura(),"AJP");
                
                    for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont :listaSiiCuentaContTipoDocCont){
                        SiiImputacionContable siiImputacionCont= new SiiImputacionContable();
                        siiImputacionCont.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                        siiImputacionCont.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                        SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                        //validaciones
                        if(siiCuentasContables.getCcoObligaTerc().equals("S") )
                             siiImputacionCont.setSiiPersona(siiSolicitudAutoriza.getSiiPersonaRifaProm());
                        if(siiCuentasContables.getCcoNumDocConta().equals("S") )
                            siiImputacionCont.setSiiDocumentoContable(insertSiiDocumentoContable);
                        if(siiCuentasContables.getCcoReferencia1().equals("S") )
                            siiImputacionCont.setImcReferencia1(solicitudPromocionalesVo.getIdSolicitud().toString());
                        
                        siiImputacionCont.setImcDescrOperacion("Aprobacion Promocionales");
                        siiImputacionCont.setImcValor(siiDetalleDeclaracion.getDdeValorDeclarado());
                        siiImputacionCont.setImcEstado("A");
                        imputacionContableDao.insertarInputacionContable(siiImputacionCont);
                        
                    }
              }
           }
                
        }*/
        return ( new SolicitudPromocionalesVO(siiRifaPromocional));
    }
    
    public SolicitudPromocionalesVO desistimientoRifaPromocional(SolicitudPromocionalesVO solicitudPromocionalesVo,UsuarioVO usuarioVo) throws ExcepcionDAO {
        Calendar cal=Calendar.getInstance();
        SiiEstadoSolicAutoriz estadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorNombre(solicitudPromocionalesVo.getEstado());
        SiiRifaPromocional  siiRifaPromocional = new SiiRifaPromocional();
        EstadoSolicAutorizVO estadoSolicAutorizVo = new EstadoSolicAutorizVO(estadoSolicAutoriz);
        solicitudPromocionalesVo.getSolicitudAutorizaVo().setEstadoSolicAutoriz(estadoSolicAutorizVo);
        SiiSolicitudAutoriza siiSolicitudAutoriza = solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudPromocionalesVo.getSolicitudAutorizaVo()));
        siiRifaPromocional.setRfpResolDesistExpr(solicitudPromocionalesVo.getNumeroRadicaciónExp());
        siiRifaPromocional.setRfpFechaResDesExp(solicitudPromocionalesVo.getFechaRadicaciónExp());
        siiRifaPromocional.setRfpFechaResDesTaci(solicitudPromocionalesVo.getFechaResTacito());
        siiRifaPromocional.setRfpResolDesistTaci(solicitudPromocionalesVo.getNumeroResTacito());
        siiRifaPromocional.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
    
        
        siiRifaPromocional=conversionVoEntidad.convertir(solicitudPromocionalesVo);
        rifaPromocionalDao.actualizarRifaPromocional(siiRifaPromocional);
        
        
        adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOLICITUD_AUTORIZA.getId(),
                                                     estadoSolicAutoriz.getEsaCodigo(),
                                                     usuarioVo, siiSolicitudAutoriza.getSauCodigo());
        
        //buscar declaracón
        List<SiiCuotaOperador>  ListSiicuotaOperador= cuotaOperadorDao.buscarCuotaOperadorPorRifaPromocional(solicitudPromocionalesVo.getIdSolicitud());
        for  (SiiCuotaOperador  siiCuotaOperador: ListSiicuotaOperador ) {
           
            List<SiiDetalleDeclaracion> siiListaDetalleDeclPagos= detalleDeclaracionDao.buscarDetalleDeclaracionPorXCodigoCuota(siiCuotaOperador.getCopCodigo());
                if( siiListaDetalleDeclPagos.get(0).getSiiDetalleRecaudo() != null){
                //Documento contable
                SiiDocumentoContable insertSiiDocumentoContable= new SiiDocumentoContable();
                SiiTipoDocContable siiTipoDocContable =tipoDocContableDao.buscarPorCodigo("DJP");
                Integer consecutivo =documentoContableDao.buscarConsecutivoDocumentoContable("DJP");
                insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                insertSiiDocumentoContable.setDcoFechaOper(cal.getTime());
                insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                SiiDetalleRecaudo  SiiDetalleRecaudo=  detalleRecaudoDao.buscarPorCodigo(siiListaDetalleDeclPagos.get(0).getSiiDetalleRecaudo().getDreCodigo());
                insertSiiDocumentoContable.setSiiDetalleRecaudo(SiiDetalleRecaudo);
                String nombreEstado="BORRADOR";
                SiiEstadoDocContab  siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
                insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                insertSiiDocumentoContable=documentoContableDao.insertarDocumentoContable(insertSiiDocumentoContable);
                    
                //Imputación contable    
                if(siiListaDetalleDeclPagos.get(0).getDdeValorDeclarado().compareTo(BigDecimal.ZERO)>0 ){     
                    List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= new ArrayList<SiiCuentaContTipoDocCont>();
                    listaSiiCuentaContTipoDocCont=detalleRecaudoDao.BuscarCuentaContTipoDocContable(siiCuotaOperador.getSiiConceptoCuota().getCcuAbreviatura(),"DJP");
                
                    for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont :listaSiiCuentaContTipoDocCont){
                        SiiImputacionContable siiImputacionCont= new SiiImputacionContable();
                        siiImputacionCont.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                        siiImputacionCont.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                        SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                        if (siiCuentasContables.getCcoFteFinanc().equals("S"))
                            siiImputacionCont.setSiiFuenteFinancContab(unSiiCuentaContTipoDocCont.getSiiFuenteFinancContab());
                        //validaciones
                        if(siiCuentasContables.getCcoObligaTerc().equals("S") )
                             siiImputacionCont.setSiiPersona(siiSolicitudAutoriza.getSiiPersonaRifaProm());
                        if(siiCuentasContables.getCcoNumDocConta().equals("S") )
                            siiImputacionCont.setSiiDocumentoContable(insertSiiDocumentoContable);
                        if(siiCuentasContables.getCcoReferencia1().equals("S") )
                            siiImputacionCont.setImcReferencia1(solicitudPromocionalesVo.getConsecutivo().toString());
                        if(siiCuentasContables.getCcoReferencia2().equals("S") ){
                            if (solicitudPromocionalesVo.getNumeroRadicaciónExp()!= null)
                                siiImputacionCont.setImcReferencia2(solicitudPromocionalesVo.getNumeroRadicaciónExp().toString());
                            if (solicitudPromocionalesVo.getNumeroResTacito()!= null)
                                siiImputacionCont.setImcReferencia2(solicitudPromocionalesVo.getNumeroResTacito().toString()); 
                        }
                        if (siiRifaPromocional.getRfpResolDesistExpr() != null )
                            siiImputacionCont.setImcDescrOperacion("Desistimiento Expreso");
                        if (siiRifaPromocional.getRfpResolDesistTaci() != null )
                            siiImputacionCont.setImcDescrOperacion("Desistimiento Tácito");
                        siiImputacionCont.setImcValor(siiListaDetalleDeclPagos.get(0).getDdeValorDeclarado());
                        siiImputacionCont.setImcEstado("A");
                        imputacionContableDao.insertarImputacionContable(siiImputacionCont);
                        
                    }
              }
            }
                
        }
        
        return ( new SolicitudPromocionalesVO(siiRifaPromocional));
    }
    
    public ExpedienteDocumVO buscarExpedienteDocumPorId(String idExpedienteDocum) throws ExcepcionDAO {
        SiiExpedienteDocum siiExpedienteDocumento =  expedienteDocumDao.buscarExpedienteDocumPorId(idExpedienteDocum);
        return ( new ExpedienteDocumVO (siiExpedienteDocumento));
    }
    
    
    public SolicitudPromocionalesVO insertarCuotaOperadorPromocionales(SolicitudPromocionalesVO solicitudPromocionalesVo  ){
            SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();
        try{
            SiiRifaPromocional siiRifaPromocional= conversionVoEntidad.convertir(solicitudPromocionalesVo);
            
            Calendar cal=Calendar.getInstance();
            Calendar cal2=Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);

              List<SiiConceptoCuota> listasiiConceptoCuota = new ArrayList();
               List<SiiCuotaOperador> listSiiCuotaOperador = new ArrayList();
                SiiCuotaOperador  siiCuotaOperador= new SiiCuotaOperador();
              SiiCuotaOperador  siiCuotaOperadorGap= new SiiCuotaOperador();
              long codigoRef;
              long numeroRef = 0;
            
              //se valida si ya existe cuota operador 
              listSiiCuotaOperador =    cuotaOperadorDao.buscarCuotaOperadorPorRifaPromocional(solicitudPromocionalesVo.getIdSolicitud());
            
                numeroRef = declaracionSugeridaDao.buscarConsecutivoDeclaracionSugerida();
                siiDeclaracionSugerida.setDsuFecha(cal.getTime());
                siiDeclaracionSugerida.setDsuConsecutivo(Integer.parseInt( String.valueOf(numeroRef)));                    
                siiDeclaracionSugerida = declaracionSugeridaDao.insertarSiiDeclaracionSugerida(siiDeclaracionSugerida);  
            
                //se crea declaración operador
                SiiDeclaracionOperador decOperador = new SiiDeclaracionOperador();
                decOperador.setDopCodigo(declaracionOperadorDao.consultarConsecutivo());
                decOperador.setDopFecha(new Date(System.currentTimeMillis()));
                decOperador.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
                decOperador.setDopTipo("L");
                //Guardar la declaracion
                try {
                   decOperador= declaracionOperadorDao.insertar(decOperador);
                } catch (ExcepcionDAO e) {
                     e.printStackTrace();
                }
                  
           if(solicitudPromocionalesVo.getValorDE()!= null ){
               
               if(listSiiCuotaOperador.size()<=0 ){
                   //Se crea la cuota operador
                   siiCuotaOperador.setCopFechaLimPag(cal.getTime());
                   siiCuotaOperador.setCopNumCuota(1);
                   siiCuotaOperador.setCopTipoDocSopor("RE"); //Re para Resolución 
                   siiCuotaOperador.setCopValor(solicitudPromocionalesVo.getValorDE());
                   siiCuotaOperador.setCopVigencia(Calendar.YEAR);
                   siiCuotaOperador.setMesCodigo(Calendar.MONTH);
                   siiCuotaOperador.setCopCancelada("N");
                   siiCuotaOperador.setCopTipoCartera("C");
                   SiiConceptoCuota siiConceptoCuota = new SiiConceptoCuota();
                   siiCuotaOperador.setSiiRifaPromocional(siiRifaPromocional);
                   
                   try {
                       listasiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXAbreviatura("DEP");
                       siiCuotaOperador.setSiiConceptoCuota(listasiiConceptoCuota.get(0));
                       
                      siiCuotaOperador = cuotaOperadorDao.insertarSiiCuotaOperador(siiCuotaOperador);
                   } catch (ExcepcionDAO e) {
                       e.printStackTrace();
                   }
               }
               
               for (SiiCuotaOperador unSiiCuotaOperador :listSiiCuotaOperador  ){
                                if(unSiiCuotaOperador.getSiiConceptoCuota().getCcuAbreviatura().equals("DEP"))
                                  siiCuotaOperador=unSiiCuotaOperador;
                }
               
                //Se crea la referencia de pago
               // String numeroInicial;
                //Integer vigencia = cal2.get(Calendar.YEAR);;
                //numeroInicial = "105" + String.valueOf(vigencia).substring(2,4); 
                SiiReferenciaPagoDecl referencia = new SiiReferenciaPagoDecl();
                
                try {
                    //codigoRef = referenciaPagoDao.buscarConsecutivoReferencia();
                    //referencia.setRpdCodigo(codigoRef);
                    referencia.setRpdNumero(Long.parseLong((105+(String.valueOf(numeroRef)))));
                    //Se inserta la Referencia de Pago                    
                    referencia= referenciaPagoDao.insertarReferenciaPagoDecl(referencia);
                } catch (ExcepcionDAO e) {
                    e.printStackTrace();
                }
                
                //Se crea la declaracion
                SiiDetalleDeclaracion declaracion = new SiiDetalleDeclaracion();
                declaracion.setDdeCodigo(detalleDeclaracionDao.buscarConsecutivoDetalle()); //DDE_CODIGO
                declaracion.setDdeValorDeclarado(solicitudPromocionalesVo.getValorDE()); //DDE_VALOR_DECLARADO
                declaracion.setDdeValorInter(BigDecimal.ZERO);
                declaracion.setSiiCuotaOperador(siiCuotaOperador); //COP_CODIGO
                declaracion.setSiiDeclaracionOperador(decOperador); //DRE_CODIGO
                declaracion.setSiiReferenciaPagoDecl(referencia); //RPD_CODIGO
                  
                //Guardar el detalle
                try {
                    declaracion = detalleDeclaracionDao.insertarDetalleDeclaracion(declaracion);
                    solicitudPromocionalesVo.setRefPagoDE(declaracion.getSiiReferenciaPagoDecl().getRpdNumero());
                } catch (ExcepcionDAO e) {
                    e.printStackTrace(); 
                }               
                
            }
            
            if(solicitudPromocionalesVo.getValorGA()!= null ){
                
                if(listSiiCuotaOperador.size()<=0 ){
                    siiCuotaOperadorGap.setCopFechaLimPag(cal.getTime());
                    siiCuotaOperadorGap.setCopNumCuota(1);
                    siiCuotaOperadorGap.setCopTipoDocSopor("RE"); //Re para Resolución 
                    siiCuotaOperadorGap.setCopValor(solicitudPromocionalesVo.getValorDE());
                    siiCuotaOperadorGap.setCopVigencia(Calendar.YEAR);
                    siiCuotaOperadorGap.setMesCodigo(Calendar.MONTH);
                    siiCuotaOperadorGap.setCopCancelada("N");
                    siiCuotaOperadorGap.setCopTipoCartera("C");
                    SiiConceptoCuota siiConceptoCuota = new SiiConceptoCuota();
                    siiCuotaOperadorGap.setSiiRifaPromocional(siiRifaPromocional);
                    try {
                        listasiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXAbreviatura("GAP");
                        siiCuotaOperadorGap.setSiiConceptoCuota(listasiiConceptoCuota.get(0));
                        
                       siiCuotaOperadorGap = cuotaOperadorDao.insertarSiiCuotaOperador(siiCuotaOperadorGap);
                    } catch (ExcepcionDAO e) {
                        e.printStackTrace();
                    }
              
                }
                
                for (SiiCuotaOperador unaSiiCuotaOperador :listSiiCuotaOperador  ){ 
                               if(unaSiiCuotaOperador.getSiiConceptoCuota().getCcuAbreviatura().equals("GAP"))
                                 siiCuotaOperadorGap = unaSiiCuotaOperador;
                    
                }
                
                //Se crea la referencia de pago
                //String numeroInicial;
                //Integer vigencia = cal2.get(Calendar.YEAR);
                //numeroInicial="205" + String.valueOf(vigencia).substring(2,4); 
                SiiReferenciaPagoDecl referencia = new SiiReferenciaPagoDecl();
               
                try {
                    //codigoRef = referenciaPagoDao.buscarConsecutivoReferencia();
                   // numeroRef = referenciaPagoDao.buscarConsecutivoReferenciaPagoDeclaracion(numeroInicial);
                    //String  numeroRefGA=numeroInicial +(Long.toString(numeroRef)).substring(5,11);
                    //referencia.setRpdCodigo(codigoRef);
                    referencia.setRpdNumero(Long.parseLong((205+(String.valueOf(numeroRef)))));
                    //Se inserta la Referencia de Pago
                    referencia = referenciaPagoDao.insertarReferenciaPagoDecl(referencia);
                } catch (ExcepcionDAO e) {
                    e.printStackTrace();
                }
    
                //Se crea la declaracion
                SiiDetalleDeclaracion declaracionGA = new SiiDetalleDeclaracion();
                declaracionGA.setDdeCodigo(detalleDeclaracionDao.buscarConsecutivoDetalle()); //DDE_CODIGO
                declaracionGA.setDdeValorDeclarado(solicitudPromocionalesVo.getValorGA()); //DDE_VALOR_DECLARADO
                declaracionGA.setDdeValorInter(BigDecimal.ZERO);
                declaracionGA.setSiiCuotaOperador(siiCuotaOperadorGap); //COP_CODIGO
                declaracionGA.setSiiDeclaracionOperador(decOperador); //DRE_CODIGO
                declaracionGA.setSiiReferenciaPagoDecl(referencia); //RPD_CODIGO              
        
                //Guardar el detalle
                try {
                   declaracionGA = detalleDeclaracionDao.insertarDetalleDeclaracion(declaracionGA);
                    solicitudPromocionalesVo.setRefPagoGA(declaracionGA.getSiiReferenciaPagoDecl().getRpdNumero());
                } catch (ExcepcionDAO e) {
                    e.printStackTrace();
                }  
            }
                   
            } catch(ExcepcionDAO ex){
                ex.printStackTrace();            
            }
            return solicitudPromocionalesVo;
        }   
    
    
    public String siguienteNumeroRifaPromocional() throws ExcepcionDAO {
    String idSiguiente= rifaPromocionalDao.siguienteNumeroRifaPromocional();
    return idSiguiente;   
    }
    
        
    public List<SolicitudPromocionalesVO>  buscarTodoRifaPromocionalTransferenciaBan() throws ExcepcionDAO {
        List<SolicitudPromocionalesVO> listaSiiRifaPromocional = rifaPromocionalDao.buscarTodoRifaPromocionalTransferenciaBan();
        for (SolicitudPromocionalesVO unaSolicitudPromocionalesVo : listaSiiRifaPromocional ){
             SiiPersona  siiPersona=personaDao.buscarPersonaPorId(unaSolicitudPromocionalesVo.getPersonaVo().getPerCodigo());
             unaSolicitudPromocionalesVo.setPersonaVo( new PersonaVO(siiPersona));
        }
        
        return listaSiiRifaPromocional ;
    }
    
    
    public List<SolicitudPromocionalesVO> buscarRifaPromocionalTransFerenciaBan(Long idTrasBanco) throws ExcepcionDAO {
        List<SolicitudPromocionalesVO> listaSiiRifaPromocional = rifaPromocionalDao.buscarRifaPromocionalTransFerenciaBan(idTrasBanco);
        for (SolicitudPromocionalesVO unaSolicitudPromocionalesVo : listaSiiRifaPromocional ){
             SiiPersona  siiPersona=personaDao.buscarPersonaPorId(unaSolicitudPromocionalesVo.getPersonaVo().getPerCodigo());
             unaSolicitudPromocionalesVo.setPersonaVo( new PersonaVO(siiPersona));
        }
        
        return listaSiiRifaPromocional ;
    } 
    
  
    
}
