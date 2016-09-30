/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaBancariaDAO;
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
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MedioPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcedenciaPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecaudoBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecaudoEstablecDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReferenciaPagoDeclDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RifaPromocionalDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoCuentaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
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
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMedioPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcedenciaPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoEstablec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReferenciaPagoDecl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRifaPromocional;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoCuenta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.BancoVO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRecaudoVO;
import co.gov.coljuegos.siicol.ejb.vo.MedioPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.PagoOperadoresVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcedenciaPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoCuentaVO;
import co.gov.coljuegos.siicol.ejb.vo.ValidacionInteresVO;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRecaudoBancoBean implements AdminRecaudoBanco {
    @EJB 
    DetalleRecaudoDAO detalleRecaudoDao;
    @EJB 
    RecaudoBancoDAO recaudoBancoDao;
    @EJB 
    BancoDAO bancoDao;
    @EJB 
    TipoCuentaDAO tipoCuentaDao;
    @EJB 
    MedioPagoDAO medioPagoDao;
    @EJB 
    ProcedenciaPagoDAO procedenciaPagoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ReferenciaPagoDeclDAO referenciaPagoDeclDao;
    @EJB
    DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    ArchivoFisicoDAO archivoFisicoDao;
    @EJB
    TipoDocContableDAO tipoDocContableDao;
    @EJB
    DocumentoContableDAO documentoContableDao;
    @EJB
    ConceptoCuotaDAO conceptoCuotaDao;
    @EJB
    ImputacionContableDAO imputacionContableDao;
    @EJB
    PersonaDAO personaDao;
    @EJB
    OperadorDAO operadorDao;
    @EJB
    LiquidacionMesDAO liquidacionMesDao;
    @EJB
    ContratoDAO contratoDao;
    @EJB
    EstadoDocContabDAO estadoDocContabDao;
    @EJB
    CuentasContablesDAO cuentasContablesDao;
    @EJB
    LiquidacionEstablecimientoDAO liquidacionEstablecimientoDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    DetalleRecaudoInteresDAO DetalleRecaudoInteresDao;
    @EJB
    InteresCuotaDAO interesCuotaDao;
    @EJB
    CuentaBancariaDAO cuentaBancariaDao;
    @EJB
    RecaudoEstablecDAO recaudoEstablecDao;
    @EJB
    RifaPromocionalDAO rifaPromocionalDao;
   
   

    public AdminRecaudoBancoBean() {
       
    }
    
    
    public PagoOperadoresVO  buscarRecaudoBancoXId(Long idRec) throws ExcepcionDAO {
        SiiRecaudoBanco  siiRecaudoBanco = recaudoBancoDao.buscarRecaudoBancoXId(idRec);
        return ( new PagoOperadoresVO(siiRecaudoBanco) );
    }
    
    
    public List<DetalleRecaudoVO> buscarTodoDetalleRecaudoXRecaudo(PagoOperadoresVO  pagoOperadoresVo) throws ExcepcionDAO{        
            List<SiiDetalleRecaudo> listaSiiDetalleRecaudo;
            List<DetalleRecaudoVO> listaDetalleRecaudoVo= new ArrayList();
            listaSiiDetalleRecaudo = detalleRecaudoDao.buscarTodoDetalleRecaudoXRecaudo(pagoOperadoresVo.getOpeCodigo());
            
            for(SiiDetalleRecaudo unaSiiDetalleRecaudo   :listaSiiDetalleRecaudo ){
                DetalleRecaudoVO nuevoDetalleRecaudoVo= new DetalleRecaudoVO(unaSiiDetalleRecaudo); 
                listaDetalleRecaudoVo.add(nuevoDetalleRecaudoVo);
            }
          
           return listaDetalleRecaudoVo;
        } 
    
    public List<PagoOperadoresVO> buscarTodosRecaudoBanco() throws ExcepcionDAO{
        List<PagoOperadoresVO> listaPagoOperadoresVo= new ArrayList<PagoOperadoresVO>();
        
        List<SiiRecaudoBanco>  listaSiiRecaudoBanco = recaudoBancoDao.buscarTodosRecaudoBanco();
        
        for(SiiRecaudoBanco  unPagoOpVo :listaSiiRecaudoBanco){
            PagoOperadoresVO nuevoPagoOperadoresVo= new PagoOperadoresVO(unPagoOpVo); 
            listaPagoOperadoresVo.add(nuevoPagoOperadoresVo);
            
        }
        return listaPagoOperadoresVo;
    }
    
    public BancoVO  buscarBancoXId(BancoVO bancoVo) throws ExcepcionDAO {
        SiiBanco siiBanco= bancoDao.buscarBancoXId(bancoVo.getBanCodigo());
        return ( new BancoVO(siiBanco) );
    
    }
    
    public TipoCuentaVO  buscarTipoCuentaXId(TipoCuentaVO tipoCuentaVo) throws ExcepcionDAO {
        SiiTipoCuenta siiTipoCuenta=tipoCuentaDao.buscarTipoCuentaXId(tipoCuentaVo.getTcuCodigo());
        return(new TipoCuentaVO(siiTipoCuenta));
    }
    
    public MedioPagoVO  buscarMedioPagoXId(MedioPagoVO medioPagoVo) throws ExcepcionDAO {
        SiiMedioPago siiMedioPago= medioPagoDao.buscarMedioPagoXId(medioPagoVo.getMepCodigo());
        return (new MedioPagoVO(siiMedioPago));
    }
    
    public ProcedenciaPagoVO  buscarProcedenciaPagoXId(ProcedenciaPagoVO ProcedenciaPagoVo) throws ExcepcionDAO {
        SiiProcedenciaPago siiProcedenciaPago=procedenciaPagoDao.buscarProcedenciaPagoXId(ProcedenciaPagoVo.getPpaCodigo());
        return (new  ProcedenciaPagoVO(siiProcedenciaPago));
    }
    
    public DetalleRecaudoVO  buscarDetalleRecaudoXId(DetalleRecaudoVO detalleRecaudoVo) throws ExcepcionDAO {
        SiiDetalleRecaudo siiDetalleRecaudo= detalleRecaudoDao.buscarPorCodigo(detalleRecaudoVo.getDreCodigo());
        return(new DetalleRecaudoVO(siiDetalleRecaudo ) );
    } 
    
    public List<DetalleRecaudoVO> BuscarDetalleRecaudoXIdRefPago(DetalleRecaudoVO detalleRecaudoVo ) throws ExcepcionDAO{
        List<DetalleRecaudoVO> listaDetalleRecaudoVo= new ArrayList<DetalleRecaudoVO>();
        List<SiiDetalleRecaudo> listaSiiDetalleRecaudo= detalleRecaudoDao.BuscarDetalleRecaudoXIdRefPago(Long.parseLong(detalleRecaudoVo.getDreRefPago()));
        for(SiiDetalleRecaudo unSiidetalleRecaudoVo :listaSiiDetalleRecaudo)    {
            DetalleRecaudoVO unDetalleRecaudoVo=new DetalleRecaudoVO(unSiidetalleRecaudoVo); 
            listaDetalleRecaudoVo.add(unDetalleRecaudoVo);
        }
    
    return listaDetalleRecaudoVo;
    }
    
    public PagoOperadoresVO insertarRecaudoBanco(PagoOperadoresVO pagoOperadoresVo) throws ExcepcionDAO, ExcepcionAplicacion {
         PagoOperadoresVO unpagoOperadoresVo = null;
         String tipoDocContable= null;
        try{
           CuotaOperadorVO cuotaOperadorVo=new CuotaOperadorVO();
           SiiCuotaOperador siiCuotaoperador= new SiiCuotaOperador();
            SiiContrato siiContrato = new SiiContrato();
           SiiPersona siiPersona=new SiiPersona();
           SiiRecaudoBanco siiRecaudoBanco= conversionVoEntidad.convertir(pagoOperadoresVo);
           String concepto=null;
           siiRecaudoBanco= recaudoBancoDao.insertar(siiRecaudoBanco);
           BigDecimal totalPagoAplicado = BigDecimal.ZERO;       

           //IMPUTACION CONTABLE 
           for(DetalleRecaudoVO  detalleRecaudoVo:pagoOperadoresVo.getDetalleRecaudoVoList()){
                              
               SiiReferenciaPagoDecl siiReferenciaPagoDecl=referenciaPagoDeclDao.BuscarReferenciaPagoXNumeroRef(Long.parseLong(detalleRecaudoVo.getDreRefPago())); 
              //busca declaraciones por referencia de pago 
               List<SiiDetalleDeclaracion> siiListaDetalleDecl=detalleDeclaracionDao.BuscarDetalleDeclaracionXIdRefPago(Long.parseLong(detalleRecaudoVo.getDreRefPago()));
               if(siiReferenciaPagoDecl.getRpdCodigo()!= null){              
                  
                   for (SiiDetalleDeclaracion unSiiDetalleDeclaracion :siiListaDetalleDecl){
                    
                      BigDecimal tempCancelaCuota = new BigDecimal(0);
                      siiCuotaoperador=cuotaOperadorDao.buscarCuotaOperadorPorId(unSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                      SiiConceptoCuota siiConceptoCuota =  conceptoCuotaDao.buscarConceptoCuotaXId(siiCuotaoperador.getSiiConceptoCuota().getCcuCodigo());
                       
                       BigDecimal temp = new BigDecimal(0); 
                      for(SiiDetalleDeclaracion unaListaDetalleDecl :siiListaDetalleDecl ) {
                          if(unaListaDetalleDecl.getDdeValorInter() != null)
                          temp=temp.add(unaListaDetalleDecl.getDdeValorDeclarado().add(unaListaDetalleDecl.getDdeValorInter()));
                          else 
                          temp=temp.add(unaListaDetalleDecl.getDdeValorDeclarado());
                      }
                      
                      if(siiListaDetalleDecl.size()>0 && temp.compareTo(detalleRecaudoVo.getDreValor())==0 ){
                         
                          //busqueda el saldo de la  cuota 
                          List<SiiDetalleDeclaracion> siiListaDetalleDeclPagos= detalleDeclaracionDao.buscarDetalleDeclaracionPorXCodigoCuota(unSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                          ValidacionInteresVO unValidacionInteresVo = interesCuotaDao.buscarSaldoPagoInteresesXcodigoCuota(unSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                          SiiCuotaOperador unSiiCuotaOperador=  cuotaOperadorDao.buscarCuotaOperadorPorId(unSiiDetalleDeclaracion.getSiiCuotaOperador().getCopCodigo());
                          
                          
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
                          
                          if(unSiiDetalleDeclaracion.getDdeValorPagado()!= null) 
                              saldoCuota=(unSiiCuotaOperador.getCopValor().subtract(tempPago));
                          if(unSiiDetalleDeclaracion.getDdeValorPagInt()!= null)
                              saldoCuotaInt=(unValidacionInteresVo.getInteresGenerado().subtract(tempPagoInt));
                          
                          
                          //inserta el detalle Recaudo. 
                          SiiDetalleRecaudo siiDetalleRecaudo= conversionVoEntidad.convertir(detalleRecaudoVo);
                          siiDetalleRecaudo.setSiiRecaudoBanco(siiRecaudoBanco);
                          siiDetalleRecaudo.setDreEstado("A");
                          siiDetalleRecaudo= detalleRecaudoDao.insertar(siiDetalleRecaudo);
                          
                          //actualiza el detalle declaración.   
                          unSiiDetalleDeclaracion.setSiiDetalleRecaudo(siiDetalleRecaudo);
                          unSiiDetalleDeclaracion.setDdeValorPagado(unSiiDetalleDeclaracion.getDdeValorDeclarado());
                          unSiiDetalleDeclaracion.setDdeValorPagInt(unSiiDetalleDeclaracion.getDdeValorInter());
                          detalleDeclaracionDao.actualizarDetalleDeclaracion(unSiiDetalleDeclaracion);
                          
                         //Si la cuota es menor que octubre 2015, crea RPB de lo contrario RPI//se coloco 2020 mientras validad a que fecha se debe publicar este cambio
                          //if (siiCuotaoperador.getCopVigencia().equals("2016") && siiCuotaoperador.getMesCodigo()<10 ){
                              tipoDocContable = "RPB";
                         /* }
                          //else 
                              tipoDocContable = "RPI";*/
                          
                          //inserta documento contable
                          SiiDocumentoContable insertSiiDocumentoContable= new SiiDocumentoContable();
                          SiiTipoDocContable siiTipoDocContable =tipoDocContableDao.buscarPorCodigo(tipoDocContable);
                          Integer consecutivo =documentoContableDao.buscarConsecutivoDocumentoContable(tipoDocContable);
                          insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                          insertSiiDocumentoContable.setDcoFechaOper(pagoOperadoresVo.getOpeFechaRecaudo());
                          insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                          insertSiiDocumentoContable.setSiiDetalleRecaudo(siiDetalleRecaudo);
                          String nombreEstado="BORRADOR";
                          SiiEstadoDocContab  siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
                          insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                          insertSiiDocumentoContable=documentoContableDao.insertarDocumentoContable(insertSiiDocumentoContable);
                          
                          
                          //insertar recaudo Establecimiento
                          List<SiiLiquidacionEstabl> listaSiiLiquidacionEstabl = new ArrayList<SiiLiquidacionEstabl>();
                          listaSiiLiquidacionEstabl =  liquidacionEstablecimientoDao.buscarTodaLiquidacionEstablXidCuotaOperador(siiCuotaoperador.getCopCodigo());
                          for (SiiLiquidacionEstabl unaSiiLiquidacionEstabl :listaSiiLiquidacionEstabl)  {
                              if(unSiiDetalleDeclaracion.getDdeValorPagado().compareTo(BigDecimal.ZERO)>0 ){
                                  SiiRecaudoEstablec siiRecaudoEstbl= new SiiRecaudoEstablec();
                                  siiRecaudoEstbl.setSiiDetalleDeclaracion(unSiiDetalleDeclaracion);
                                  siiRecaudoEstbl.setSiiLiquidacionEstabl(unaSiiLiquidacionEstabl);
                                  if(unSiiDetalleDeclaracion.getDdeValorPagado()!= null)
                                        siiRecaudoEstbl.setReeValorPagado(unSiiDetalleDeclaracion.getDdeValorPagado().multiply( unaSiiLiquidacionEstabl.getLesPonderado())); 
                                  if( unSiiDetalleDeclaracion.getDdeValorPagInt()!= null )
                                         siiRecaudoEstbl.setReeValorPagInter(unSiiDetalleDeclaracion.getDdeValorPagInt().multiply( unaSiiLiquidacionEstabl.getLesPonderado()));
                                  recaudoEstablecDao.insertarRecaudoEstablec(siiRecaudoEstbl);
                              }
                          }
                                       
    
                          //buscar datos tercero
                              if(siiCuotaoperador.getSiiOperador()!= null){
                                  SiiOperador siiOperador= operadorDao.buscarPorCodigoOperador(siiCuotaoperador.getSiiOperador().getOpeCodigo());
                                   siiPersona=  personaDao.buscarPersonaPorId(siiOperador.getSiiPersona().getPerCodigo());
                              }
                              if(siiCuotaoperador.getSiiRifaPromocional()!= null) {
                                  SiiRifaPromocional siiRifaPromocional= new SiiRifaPromocional();
                                  siiRifaPromocional=rifaPromocionalDao.buscarPorCodigoRifaPromocional(siiCuotaoperador.getSiiRifaPromocional().getRfpCodigo());
                                   siiPersona=  (siiRifaPromocional.getSiiSolicitudAutoriza().getSiiPersonaRifaProm());
                              }

               
                          //buscar numero de contrato
                        
                          if(siiCuotaoperador.getSiiLiquidacionMes()!= null  ){
                               SiiLiquidacionMes  siiLiquidacionMes = liquidacionMesDao.buscarLiquidacionMesPorId(siiCuotaoperador.getSiiLiquidacionMes().getLmeCodigo());
                               siiContrato= contratoDao.buscarContratoPorId(siiLiquidacionMes.getSiiContrato().getConCodigo());
                          }
                          
                          //imputacion contable Debito General 
                          SiiImputacionContable siiImputacionContable= new SiiImputacionContable();
                          String grupoRecaudo=  (unSiiDetalleDeclaracion.getSiiReferenciaPagoDecl().getRpdNumero().toString()).substring(0,3);
                          SiiCuentasContables siiCuentasContable= detalleRecaudoDao.BuscarCuentaContTipoDocContXCodigoConcSinTer(pagoOperadoresVo.getOpeNumeroCuenta(),tipoDocContable );
                          siiImputacionContable.setSiiCuentasContables(siiCuentasContable);
                          siiImputacionContable.setImcTipoMovim("D");
                          //validaciones
                          if(siiCuentasContable.getCcoNumDocConta().equals("S"))
                              siiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
                          SiiArchivoFisico siiArchivoFisico = new SiiArchivoFisico();
                          siiArchivoFisico= archivoFisicoDao.buscarArchivoFisicoPorId(siiRecaudoBanco.getSiiArchivoFisico().getAfiCodigo());
                          siiImputacionContable.setImcDescrOperacion("Recaudo Importado según archivo || "+siiArchivoFisico.getAfiNombreOrignal());                      
                          siiImputacionContable.setImcValor(unSiiDetalleDeclaracion.getDdeValorPagado().add(unSiiDetalleDeclaracion.getDdeValorPagInt()));
                          siiImputacionContable.setImcEstado("A");
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
                          
                          imputacionContableDao.insertarImputacionContable(siiImputacionContable);
                          
                          
                          //ingresar movimiento contable
                         
                          if(unSiiDetalleDeclaracion.getDdeValorDeclarado().compareTo(BigDecimal.ZERO)>0 ){     
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
                                  
                                  siiArchivoFisico= archivoFisicoDao.buscarArchivoFisicoPorId(siiRecaudoBanco.getSiiArchivoFisico().getAfiCodigo());
                                  siiImputacionCont.setImcDescrOperacion("Recaudo Importado según archivo || "+siiArchivoFisico.getAfiNombreOrignal());
                                  siiImputacionCont.setImcValor(unSiiDetalleDeclaracion.getDdeValorPagado());
                                  siiImputacionCont.setImcEstado("A");
                                  imputacionContableDao.insertarImputacionContable(siiImputacionCont);
                              } 
                          }
                          

                          //ingresar movimiento contable con intereses
                          BigDecimal b1 = new BigDecimal("-1");
                          if(unSiiDetalleDeclaracion.getDdeValorInter().compareTo(BigDecimal.ZERO)>0 ){    
                               List<SiiDetalleDeclaracion> listaDetalleDeclaracion= new ArrayList<SiiDetalleDeclaracion>();
                               listaDetalleDeclaracion= detalleDeclaracionDao.BuscarDetalleDeclaracionXIdRefPago(Long.parseLong(detalleRecaudoVo.getDreRefPago()));
                               
                               for(SiiDetalleDeclaracion unSiiDetDeclaracion :listaDetalleDeclaracion){
                                   List<SiiCuentaContTipoDocCont> listaSiiCuentaContTDC= new ArrayList<SiiCuentaContTipoDocCont>();
                                     SiiCuotaOperador siiCuotaOpe=cuotaOperadorDao.buscarCuotaOperadorPorId(unSiiDetDeclaracion.getSiiCuotaOperador().getCopCodigo());
                                          SiiConceptoCuota siiConceptoCuo =  conceptoCuotaDao.buscarConceptoCuotaXId(siiCuotaOpe.getSiiConceptoCuota().getCcuCodigo());
                                          System.out.println("Buscar concepto cuota " + siiCuotaOpe.getSiiConceptoCuota().getCcuCodigo());
                                          System.out.println("Resultado: " + (siiConceptoCuo == null?"nulo":siiConceptoCuo.toString()));
                                          if (siiConceptoCuo.getCcuAbreviatura().equals("DE"))
                                                     concepto="DEI";
                                          if (siiConceptoCuo.getCcuAbreviatura().equals("GA"))
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
                                              siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString());
                                              }
                                               
                                       } 
                                       if(siiCuentasCont.getCcoReferencia2().equals("S"))
                                            siiImputacionCont.setImcReferencia2(String.valueOf(siiCuotaoperador.getCopNumCuota()));
                                       
                                       siiImputacionCont.setImcDescrOperacion("Recaudo Importado según archivo || "+siiArchivoFisico.getAfiNombreOrignal());
                                       siiImputacionCont.setImcValor(unSiiDetDeclaracion.getDdeValorInter());
                                       siiImputacionCont.setImcEstado("A");
                                       imputacionContableDao.insertarImputacionContable(siiImputacionCont);
                                       
                                   }
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
                                          /*  if(siiCuotaoperador.getSiiMulta()!= null){
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
                                          siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString());
                                          }
                                  } 
                                  siiArchivoFisico= archivoFisicoDao.buscarArchivoFisicoPorId(siiRecaudoBanco.getSiiArchivoFisico().getAfiCodigo());
                                  siiImputacionContableCuotaSaldo.setImcDescrOperacion("Recaudo por clasificar Importado según archivo  || "+siiArchivoFisico.getAfiNombreOrignal());
                                  siiImputacionContableCuotaSaldo.setImcValor(saldoCuota);
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
                                          siiImputacionContable.setImcReferencia1(siiCuotaoperador.getSiiRifaPromocional().getRfpConsecutivo().toString());
                                          }
                                          
                                  } 
                                  siiArchivoFisico= archivoFisicoDao.buscarArchivoFisicoPorId(siiRecaudoBanco.getSiiArchivoFisico().getAfiCodigo());
                                  siiImputacionContableCuotaInt.setImcDescrOperacion("Recaudo Por clasificar Int Importado según archivo || "+siiArchivoFisico.getAfiNombreOrignal());
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
                       else {
                           SiiDetalleRecaudo siiDetalleRecaudo= conversionVoEntidad.convertir(detalleRecaudoVo);
                           siiDetalleRecaudo.setDreEstado("I");
                           siiDetalleRecaudo.setSiiRecaudoBanco(siiRecaudoBanco);
                           siiDetalleRecaudo= detalleRecaudoDao.insertar(siiDetalleRecaudo);   
                      }
                       
                     
                                                        
                       
                       
                  
                  }
                   
               }
               else{                
                   SiiDetalleRecaudo siiDetalleRecaudo= conversionVoEntidad.convertir(detalleRecaudoVo);
                   siiDetalleRecaudo.setDreEstado("I");
                   siiDetalleRecaudo.setSiiRecaudoBanco(siiRecaudoBanco);
                   siiDetalleRecaudo= detalleRecaudoDao.insertar(siiDetalleRecaudo);   
               }   
                
         }
    
         unpagoOperadoresVo = new PagoOperadoresVO(siiRecaudoBanco);
         
        } catch (ExcepcionDAO ex){
            ex.printStackTrace();
            throw ex;
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
        }
        return unpagoOperadoresVo;
     } 
   
    
   
}
     

