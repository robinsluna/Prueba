package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoReintegroPagaduria;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NotaCredOblConcDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NotaCredOblConceptoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NotaCreditoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReintegroPagaduriaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubReintIngPagDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcepto;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReintegroIngresoPag;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubReintIngPag;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConcDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;
import co.gov.coljuegos.siicol.ejb.vo.ReintegroPagaduriaVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleFuenteRpVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminReintegroPagaduriaBean implements AdminReintegroPagaduria {
    @Resource
    SessionContext sessionContext;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    @EJB
    ReintegroPagaduriaDAO reintegroPagaduriaDao;
    @EJB
    NotaCreditoDAO notaCreditoDao;
    @EJB
    TipoDocContableDAO tipoDocContableDao;
    @EJB
    DocumentoContableDAO documentoContableDao;
    @EJB
    EstadoDocContabDAO estadoDocContabDao;
    @EJB
    ImputacionContableDAO imputacionContableDao;
    @EJB
    DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    NotaCredOblConcDetRubDAO notaCredOblConcDetRubDao;
    @EJB
    NotaCredOblConceptoDAO notaCredOblConceptoDao;
    @EJB
    RpDetRubroCdpDAO rpDetRubroCdpDao;
    @EJB
    ObligacionPagoDAO obligacionPagoDao;
    @EJB
    RpDetRubReintIngPagDAO rpDetRubReintIngPagDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    
        
    public AdminReintegroPagaduriaBean() {
        
    }
    
    public ReintegroPagaduriaVO buscarPorCodigoReintegroIngresoPag (Long ripCodigo) throws ExcepcionDAO {
        List<RubroFuenteDetalleFuenteRpVO>  listRubroFuenteDetalleFuenteRpVo= new ArrayList();
        List<RubroFuenteDetalleFuenteRpVO>  listRubroFuenteDetalleFuenteRpVo2= new ArrayList();
        
        SiiReintegroIngresoPag siiReintegroIngresoPag = reintegroPagaduriaDao.buscarPorCodigoReintegroIngresoPag(ripCodigo);
        ReintegroPagaduriaVO reintegroPagaduriaVo = new ReintegroPagaduriaVO(siiReintegroIngresoPag);
        listRubroFuenteDetalleFuenteRpVo = obligacionPagoDao.buscarRubroFuenteFDetfuenteXIdNotaCredito(siiReintegroIngresoPag.getSiiNotaCredito().getNcrCodigo());
        
        List<SiiRpDetRubReintIngPag>  listSiiRpDetRubReintIngPag = rpDetRubReintIngPagDao.buscarRpDetRubReintIngPagXReiIngresoPag(reintegroPagaduriaVo.getRipCodigo());
        for (RubroFuenteDetalleFuenteRpVO rubroFuenteDetalleFuenteRpVo  :listRubroFuenteDetalleFuenteRpVo ){
            for (SiiRpDetRubReintIngPag siiRpDetRubReintIngPag :listSiiRpDetRubReintIngPag){
                if(siiRpDetRubReintIngPag.getSiiRpDetRubroCdp().getRdrCodigo().equals(rubroFuenteDetalleFuenteRpVo.getRdfCodigoDetalleRubroCdp())){
                    rubroFuenteDetalleFuenteRpVo.setValorReintegro(siiRpDetRubReintIngPag.getRinValorReintegro());
                    listRubroFuenteDetalleFuenteRpVo2.add(rubroFuenteDetalleFuenteRpVo);
                }
            }  
        }
        reintegroPagaduriaVo.setListRubroFuenteDetalleFuenteRpVo(listRubroFuenteDetalleFuenteRpVo2);
        return  reintegroPagaduriaVo;
    }  
    
    public ReintegroPagaduriaVO insertarSiiReintegroPagaduria(ReintegroPagaduriaVO reintegroPagaduriaVo,UsuarioVO usuarioLogueadoVo) throws ExcepcionDAO {
        SiiRpDetRubReintIngPag siiRpDetRubReintIngPag;
        SiiUsuario siiUsuario = conversionVoEntidad.convertir(usuarioLogueadoVo);
        SiiReintegroIngresoPag siiReintegroIngresoPag = conversionVoEntidad.convertir(reintegroPagaduriaVo);
        siiReintegroIngresoPag.setSiiUsuarioConec(siiUsuario);
         siiReintegroIngresoPag = reintegroPagaduriaDao.insertarSiiReintegroIngresoPag(siiReintegroIngresoPag);
        for (RubroFuenteDetalleFuenteRpVO rubroFuenteDetalleFuenteRpVo: reintegroPagaduriaVo.getListRubroFuenteDetalleFuenteRpVo() ){
             siiRpDetRubReintIngPag = new SiiRpDetRubReintIngPag();
             siiRpDetRubReintIngPag.setRinValorReintegro(rubroFuenteDetalleFuenteRpVo.getValorReintegro());
             siiRpDetRubReintIngPag.setSiiReintegroIngresoPag(siiReintegroIngresoPag);
             SiiRpDetRubroCdp siiRpDetRubroCdp = rpDetRubroCdpDao.buscarCodigoRpDetRubroCdp(rubroFuenteDetalleFuenteRpVo.getRdfCodigoDetalleRubroCdp());
             siiRpDetRubReintIngPag.setSiiRpDetRubroCdp(siiRpDetRubroCdp);
             siiRpDetRubReintIngPag.setSiiUsuarioConec(siiUsuario);
             rpDetRubReintIngPagDao.insertar(siiRpDetRubReintIngPag);
        }
        
        if(siiReintegroIngresoPag == null )
            return null;
        
        adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.REINTEGRO_PAGADURIA.getId(),
                                               "B",usuarioLogueadoVo, siiReintegroIngresoPag.getRipCodigo());
        
            
        return (new ReintegroPagaduriaVO(siiReintegroIngresoPag));
    }
    
    public ReintegroPagaduriaVO actualizarReintegroIngresoPag(ReintegroPagaduriaVO reintegroPagaduriaVo,UsuarioVO usuarioLogueadoVo) throws ExcepcionDAO {
        SiiReintegroIngresoPag siiReintegroIngresoPag = reintegroPagaduriaDao.actualizarReintegroIngresoPag(conversionVoEntidad.convertir(reintegroPagaduriaVo));
        
        if(reintegroPagaduriaVo.getRipEstado().equals("A") ){
        
                Calendar cal=Calendar.getInstance();
                Date date=cal.getTime();
                
                //Generar imputacion contable
                //documento contable
                SiiDocumentoContable insertSiiDocumentoContable= new SiiDocumentoContable();
                SiiTipoDocContable siiTipoDocContable =tipoDocContableDao.buscarPorCodigo("RPE");
                Integer consecutivo =documentoContableDao.buscarConsecutivoDocumentoContable("RPE");
                insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                insertSiiDocumentoContable.setDcoFechaOper(date);
                insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                insertSiiDocumentoContable.setSiiReintegroIngresoPag(siiReintegroIngresoPag);
                String nombreEstado="BORRADOR";
                SiiEstadoDocContab  siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
                insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                insertSiiDocumentoContable=documentoContableDao.insertarDocumentoContable(insertSiiDocumentoContable);
                
                //Ingreso de imputación contable  D
                SiiImputacionContable siiImputacionContable= new SiiImputacionContable();
                SiiCuentasContables siiCuentasContable= detalleRecaudoDao.BuscarCuentaContXCuentaBancaria(reintegroPagaduriaVo.getCuentaBancariaVo().getCbaCodigo() );
                siiImputacionContable.setSiiCuentasContables(siiCuentasContable);
                siiImputacionContable.setImcTipoMovim("D");
                //validaciones
                if(siiCuentasContable.getCcoNumDocConta().equals("S"))
                    siiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);                      
                siiImputacionContable.setImcEstado("A");
                siiImputacionContable.setImcDescrOperacion(siiReintegroIngresoPag.getRipConcepto());
                if(siiCuentasContable.getCcoReferencia1().equals("S") )
                     siiImputacionContable.setImcReferencia1(siiReintegroIngresoPag.getSiiNotaCredito().getNcrNumero().toString());
                siiImputacionContable.setImcValor(siiReintegroIngresoPag.getRipValor());
                imputacionContableDao.insertarImputacionContable(siiImputacionContable);    
                
                //Ingreso de imputación contable C
                SiiImputacionContable unaSiiImputacionContable= new SiiImputacionContable();
                List<SiiCuentasContables> unaSiiCuentasContable = detalleRecaudoDao.BuscarCuentaContXtipoDocumento(reintegroPagaduriaVo.getNotaCreditoVo().getNcrTipoNota() );
                unaSiiImputacionContable.setSiiCuentasContables(unaSiiCuentasContable.get(0));
                unaSiiImputacionContable.setImcTipoMovim("C");
                //validaciones
                if(unaSiiCuentasContable.get(0).getCcoNumDocConta().equals("S"))
                    unaSiiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);                      
                unaSiiImputacionContable.setImcEstado("A");
                unaSiiImputacionContable.setImcDescrOperacion(siiReintegroIngresoPag.getRipConcepto());
                if(unaSiiCuentasContable.get(0).getCcoReferencia1().equals("S") )
                     unaSiiImputacionContable.setImcReferencia1(siiReintegroIngresoPag.getSiiNotaCredito().getNcrNumero().toString());
                unaSiiImputacionContable.setImcValor(siiReintegroIngresoPag.getRipValor());
                imputacionContableDao.insertarImputacionContable(unaSiiImputacionContable);    
                
                adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.REINTEGRO_PAGADURIA.getId(),
                                                       "A",usuarioLogueadoVo, siiReintegroIngresoPag.getRipCodigo());
                
        }
        
        
        if(reintegroPagaduriaVo.getRipEstado().equals("N")){
            List<SiiDocumentoContable> lista = documentoContableDao.buscarPorCodigoReintegroPag(reintegroPagaduriaVo.getRipCodigo());
            if (lista != null) {
                for (SiiDocumentoContable siiDocumentoContable : lista) {
                    String nombreEstado="ANULADO";
                    SiiEstadoDocContab  siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
                    siiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                    documentoContableDao.actualizar(siiDocumentoContable);
                }
            }
            
            adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.REINTEGRO_PAGADURIA.getId(),
                                                       "N",usuarioLogueadoVo, siiReintegroIngresoPag.getRipCodigo());
            
        }
        
        
        return (new ReintegroPagaduriaVO(siiReintegroIngresoPag));
    }
    
    public List<ReintegroPagaduriaVO> buscarTodoReintegroIngresoPag() throws ExcepcionDAO {
        List<ReintegroPagaduriaVO> listaReintegroPagaduriaVo= null;
        List<SiiReintegroIngresoPag> lista = reintegroPagaduriaDao.buscarTodoReintegroIngresoPag();
        if (lista!=null) {
            listaReintegroPagaduriaVo = new ArrayList<ReintegroPagaduriaVO>();
            for (SiiReintegroIngresoPag siiReintegroIngresoPag: lista) {
               ReintegroPagaduriaVO unReintegroPagaduriaVo = new ReintegroPagaduriaVO(siiReintegroIngresoPag);
                if(siiReintegroIngresoPag.getRipEstado().equals("B") )
                    unReintegroPagaduriaVo.setRipEstado("BORRADOR");
                if(siiReintegroIngresoPag.getRipEstado().equals("A") )
                    unReintegroPagaduriaVo.setRipEstado("APROBADO");
                if(siiReintegroIngresoPag.getRipEstado().equals("N") )
                    unReintegroPagaduriaVo.setRipEstado("ANULADO");
                listaReintegroPagaduriaVo.add(unReintegroPagaduriaVo);
            }
        }
        return (listaReintegroPagaduriaVo);
    }
    
    
    
    public List<NotaCreditoVO> buscarTodoNotaCreditoAprobado(String estado) throws ExcepcionDAO {
        List<NotaCreditoVO> listaNotaCreditoVo = new ArrayList();
        
        List<SiiNotaCredito> lista = notaCreditoDao.buscarTodoNotaCreditoAprobado(estado);
        List<SiiNotaCredOblConcepto> listSiiNotaCredOblConcepto =  new ArrayList();
       
        NotaCredOblConceptoVO notaCredOblConcepto;
        List<NotaCredOblConcDetRubVO> NotaCredOblConcDetRubVO= new ArrayList();
        if (lista!=null) {
            listaNotaCreditoVo = new ArrayList<NotaCreditoVO>();
            for (int  i = 0 ; i < lista.size() ; i++) {        
                NotaCreditoVO unNotaCreditoVo =new NotaCreditoVO();
                BigDecimal tempValor  = BigDecimal.ZERO;
                BigDecimal tempReintegro = BigDecimal.ZERO;
                listSiiNotaCredOblConcepto = notaCredOblConceptoDao.buscarNotaCredOblConceptoPorIdNotaCredito(lista.get(i).getNcrCodigo());
                unNotaCreditoVo = new NotaCreditoVO(lista.get(i));
                //listaNotaCreditoVo.add(new NotaCreditoVO(lista.get(i)));
                //calcula valro de la nota credito 
                for (SiiNotaCredOblConcepto siiNotaCredOblConcepto : listSiiNotaCredOblConcepto ){
                    tempValor=tempValor.add(siiNotaCredOblConcepto.getNcoSubtotal().add(siiNotaCredOblConcepto.getNcoIva()));
                }
                unNotaCreditoVo.setTotalConcepNotaCredito(tempValor);
                
                //calcula el saldo nota credito 
                List<ReintegroPagaduriaVO> ListReintegroPagaduriaVo = reintegroPagaduriaDao.buscarReintregroXNotaCredito(lista.get(i).getNcrCodigo());
                for (ReintegroPagaduriaVO unReintegroPagaduriaVo : ListReintegroPagaduriaVo ){
                    if (unReintegroPagaduriaVo!=null && 
                        EnumEstadoReintegroPagaduria.APROBADO.getId().equals(unReintegroPagaduriaVo.getRipEstado())) 
                    {
                        tempReintegro=tempReintegro.add(unReintegroPagaduriaVo.getRipValor());
                    }
                }
                unNotaCreditoVo.setSaldoNotaCredito(unNotaCreditoVo.getTotalConcepNotaCredito().subtract(tempReintegro));  
                
                if(unNotaCreditoVo.getSaldoNotaCredito().compareTo(BigDecimal.ZERO)> 0)
                    listaNotaCreditoVo.add(unNotaCreditoVo);
            
            }
            
        }
        return (listaNotaCreditoVo);
    }
    
    public String siguienteNumeroReintegroIngresoPag() throws ExcepcionDAO {
        String idSiguiente= reintegroPagaduriaDao.siguienteNumeroReintegroIngresoPag();
        return idSiguiente;   
    }
    
   
    public NotaCreditoVO buscarNotaCreditoXId(Long  ncrCodigo,Long ripCodigo) throws ExcepcionDAO {
        BigDecimal tempValor  = BigDecimal.ZERO;
        BigDecimal tempReintegro = BigDecimal.ZERO;
        List<SiiNotaCredOblConcepto> listSiiNotaCredOblConcepto =  new ArrayList();
        SiiNotaCredito siiNotaCredito = notaCreditoDao.buscarPorCodigoNotaCredito(ncrCodigo); 
        listSiiNotaCredOblConcepto = notaCredOblConceptoDao.buscarNotaCredOblConceptoPorIdNotaCredito(siiNotaCredito.getNcrCodigo());
        //se busca valor nota credito
        for (SiiNotaCredOblConcepto siiNotaCredOblConcepto : listSiiNotaCredOblConcepto ){
            tempValor=tempValor.add(siiNotaCredOblConcepto.getNcoSubtotal().add(siiNotaCredOblConcepto.getNcoIva()));
        }
        NotaCreditoVO  unaNotaCreditoVo = new NotaCreditoVO(siiNotaCredito);
        unaNotaCreditoVo.setTotalConcepNotaCredito(tempValor);
        
        //se busca saldo
        List<ReintegroPagaduriaVO> ListReintegroPagaduriaVo = reintegroPagaduriaDao.buscarReintregroXNotaCreditoId(unaNotaCreditoVo.getNcrCodigo(),ripCodigo);
        for (ReintegroPagaduriaVO unReintegroPagaduriaVo : ListReintegroPagaduriaVo ){
            // Solo se descuentan los reintegros en estado APROBADO.
            if (unReintegroPagaduriaVo!=null && 
                EnumEstadoReintegroPagaduria.APROBADO.getId().equals(unReintegroPagaduriaVo.getRipEstado())) 
            {
                tempReintegro=tempReintegro.add(unReintegroPagaduriaVo.getRipValor());
            }
        }
        unaNotaCreditoVo.setSaldoNotaCredito(unaNotaCreditoVo.getTotalConcepNotaCredito().subtract(tempReintegro));     
        
        return unaNotaCreditoVo;
    }
    
   
    @Override
    public List<ReintegroPagaduriaVO> buscarReintregroXNotaCredito(long nrcCodigo) throws ExcepcionDAO 
    {
        List<ReintegroPagaduriaVO> resultado = reintegroPagaduriaDao.buscarReintregroXNotaCredito(nrcCodigo);
        return (resultado);
    }
    
}
