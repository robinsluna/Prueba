/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 07-03-2014
 */


package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleTrasBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaBancariaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTansladoBancarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RifaPromocionalDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocumentoColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TrasladoCuentasBancariasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancaria;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleTraslBanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTraslBancario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRifaPromocional;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTrasladoBancario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetalleTraslBanVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoTrasladoBancarioVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPromocionalesVO;
import co.gov.coljuegos.siicol.ejb.vo.TrasladoCuentasBancariasVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTrasladoCuentasBancariasBean implements AdminTrasladoCuentasBancarias {

    @EJB
    private TrasladoCuentasBancariasDAO trasladoCuentasBancariasDao;
    @EJB
    private EstadoTansladoBancarioDAO estadoTansladoBancarioDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private DocumentoContableDAO documentoContableDao;
    @EJB
    private EstadoDocContabDAO estadoDocContabDao;
    @EJB
    private TipoDocContableDAO tipoDocContableDao;
    @EJB
    private CuentaBancariaDAO cuentaBancariaDao;
    @EJB
    private CuentasContablesDAO cuentasContablesDao;
    @EJB
    private ImputacionContableDAO imputacionContableDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private TipoDocumentoColjuegosDAO tipoDocumentoColjuegosDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private DetalleTrasBancoDAO detalleTrasBancoDao;
    @EJB
    private  RifaPromocionalDAO rifaPromocionalDao;

    public AdminTrasladoCuentasBancariasBean() {

    }

    public TrasladoCuentasBancariasVO buscarTrasladoBancarioPorId(Long idTrasCuentaBan) throws ExcepcionDAO {
        SiiTrasladoBancario siiTrasladoBancario =
            trasladoCuentasBancariasDao.buscarTrasladoBancarioPorId(idTrasCuentaBan);
        return (new TrasladoCuentasBancariasVO(siiTrasladoBancario));
    }

    public List<TrasladoCuentasBancariasVO> buscarTodoTrasladoBancario() throws ExcepcionDAO {
        List<TrasladoCuentasBancariasVO> listaSiiTrasladoBancario = new ArrayList<TrasladoCuentasBancariasVO>();

        List<SiiTrasladoBancario> listaSiiTransBancario = trasladoCuentasBancariasDao.buscarTodoTrasladoBancario();

        for (SiiTrasladoBancario unTrasBancario : listaSiiTransBancario) {
            TrasladoCuentasBancariasVO nuevoTrasBancarioVo = new TrasladoCuentasBancariasVO(unTrasBancario);
            listaSiiTrasladoBancario.add(nuevoTrasBancarioVo);

        }
        return listaSiiTrasladoBancario;
    }

    public TrasladoCuentasBancariasVO insertarTrasladoBancario(TrasladoCuentasBancariasVO trasladoCuentasBancariasVo) throws ExcepcionDAO {
        SiiTrasladoBancario siiTrasladoBancario = conversionVoEntidad.convertir(trasladoCuentasBancariasVo);
        siiTrasladoBancario = trasladoCuentasBancariasDao.insertarTrasladoBancario(siiTrasladoBancario);
        DetalleTraslBanVO detalleTranslBanVo= new DetalleTraslBanVO();
        if(trasladoCuentasBancariasVo.getListaSolicitudPromocionalesVo() !=  null){
            for (SolicitudPromocionalesVO  solicitudPromocionalesVo: trasladoCuentasBancariasVo.getListaSolicitudPromocionalesVo()){
                 SiiDetalleTraslBanc unaSiiDetalleTraslBanc = new SiiDetalleTraslBanc();
                 
                 SiiRifaPromocional siiRifaPromocional = rifaPromocionalDao.buscarPorCodigoRifaPromocional(solicitudPromocionalesVo.getIdSolicitud());
                 unaSiiDetalleTraslBanc.setSiiTrasladoBancario(siiTrasladoBancario);
                 unaSiiDetalleTraslBanc.setDtbConcepto(solicitudPromocionalesVo.getConcepto());
                 unaSiiDetalleTraslBanc.setSiiRifaPromocional(siiRifaPromocional);
                 detalleTrasBancoDao.insertarDetalleTraslBanc(unaSiiDetalleTraslBanc);
            }
        }
        
        return new TrasladoCuentasBancariasVO(siiTrasladoBancario);
    }

    /**
     * @author Modifica Giovanni
     * @param trasladoCuentasBancariasVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public TrasladoCuentasBancariasVO actualizarTrasladoBancario(TrasladoCuentasBancariasVO trasladoCuentasBancariasVo,
                                                                 UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                   ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
       /* SiiTrasladoBancario siiTrasladoBancarioTemp = new SiiTrasladoBancario();
        siiTrasladoBancarioTemp =
            trasladoCuentasBancariasDao.buscarTrasladoBancarioPorId(trasladoCuentasBancariasVo.getTbaCodigo());
        if (siiTrasladoBancarioTemp.getSiiEstadoTraslBancario().getEtbCodigo() !=
            trasladoCuentasBancariasVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del traslado Bancario fue cambiado durante la modificación. Seleccione nuevamente el translado bancario");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (trasladoCuentasBancariasVo.getEstadoTrasladoBancarioVo().getEstCodigo() !=
            trasladoCuentasBancariasVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ACTA_INI_CONTRATO.getId(),
                                                         trasladoCuentasBancariasVo.getEstadoTrasladoBancarioVo().getEstCodigo(),
                                                         usuarioLogueado, trasladoCuentasBancariasVo.getTbaCodigo());
        }

        SiiTrasladoBancario siiTrasladoBancario = conversionVoEntidad.convertir(trasladoCuentasBancariasVo);
        siiTrasladoBancario = trasladoCuentasBancariasDao.actualizarTrasladoBancario(siiTrasladoBancario);

        return new TrasladoCuentasBancariasVO(siiTrasladoBancario);
    }

    /**
     * @author Modifica Giovanni
     * @param trasladoCuentasBancariasVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public TrasladoCuentasBancariasVO actualizarTrasladoBancarioAprobar(TrasladoCuentasBancariasVO trasladoCuentasBancariasVo,
                                                                        UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                          ExcepcionAplicacion {
        
        try{

        /*
         * Manejo de error de concurrencia
         */
        /*SiiTrasladoBancario siiTrasladoBancarioTemp = new SiiTrasladoBancario();
        siiTrasladoBancarioTemp =
            trasladoCuentasBancariasDao.buscarTrasladoBancarioPorId(trasladoCuentasBancariasVo.getTbaCodigo());
        if (siiTrasladoBancarioTemp.getSiiEstadoTraslBancario().getEtbCodigo() !=
            trasladoCuentasBancariasVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del traslado Bancario Aprobar fue cambiado durante la modificación. Seleccione nuevamente el translado bancario Aprobar");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (trasladoCuentasBancariasVo.getEstadoTrasladoBancarioVo().getEstCodigo() !=
            trasladoCuentasBancariasVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.TRASLADO_CUENTAS_BANCARIAS.getId(),
                                                         trasladoCuentasBancariasVo.getEstadoTrasladoBancarioVo().getEstCodigo(),
                                                         usuarioLogueado, trasladoCuentasBancariasVo.getTbaCodigo());
        }

        SiiTrasladoBancario siiTrasladoBancario = conversionVoEntidad.convertir(trasladoCuentasBancariasVo);
        siiTrasladoBancario = trasladoCuentasBancariasDao.actualizarTrasladoBancario(siiTrasladoBancario);

        // insertar movimiento contable
        SiiDocumentoContable insertSiiDocumentoContable = new SiiDocumentoContable();
        SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo("TRF");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar fechaActual = Calendar.getInstance();
        Date date = fechaActual.getTime();
        Integer consecutivo = documentoContableDao.buscarConsecutivoDocumentoContable("TRF");
        insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
        insertSiiDocumentoContable.setDcoFechaOper(trasladoCuentasBancariasVo.getTbaFecha());
        String nombreEstado = "BORRADOR";
        SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
        insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
        insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
        insertSiiDocumentoContable.setSiiTrasladoBancario(siiTrasladoBancario);
        insertSiiDocumentoContable = documentoContableDao.insertar(insertSiiDocumentoContable);

        //Insertar imputación contable cuenta destino
        SiiImputacionContable siiImputacionContable = new SiiImputacionContable();
        //SiiTipoDocContable siiTipoDocCon = tipoDocContableDao.buscarPorCodigo("TRF");
        SiiCuentaBancaria siiCuentaBancaria =
            cuentaBancariaDao.buscarCuentaPorId(trasladoCuentasBancariasVo.getCuentaBancariaDestinoVo().getCbaCodigo());
        SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(siiCuentaBancaria.getSiiCuentasContables().getCcoCodigo());
        siiImputacionContable.setSiiCuentasContables(siiCuentasContables);
        siiImputacionContable.setImcTipoMovim("D");
        siiImputacionContable.setImcEstado("A");
        SiiCuentasContables siiCuentasContable =
            cuentasContablesDao.buscarPorCodigo(siiCuentaBancaria.getSiiCuentasContables().getCcoCodigo());
        SiiPersona siiPersona = personaDao.buscarPersonaPorNumeroIdYTipoId("900505060", "NIT");
        //validaciones
        if (siiCuentasContable.getCcoObligaTerc().equals("S"))
            siiImputacionContable.setSiiPersona(siiPersona);
        if (siiCuentasContable.getCcoNumDocConta().equals("S"))
            siiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
        if (siiCuentasContable.getCcoReferencia1().equals("S"))
            siiImputacionContable.setImcReferencia1(format1.format(date));
        siiImputacionContable.setImcDescrOperacion(trasladoCuentasBancariasVo.getTbaDescripcion());
        siiImputacionContable.setImcValor(trasladoCuentasBancariasVo.getTbaValor());
        imputacionContableDao.insertarImputacionContable(siiImputacionContable);

        //insertar imputacion contable cuenta origen
        SiiImputacionContable siiImputacionContable2 = new SiiImputacionContable();
        //SiiTipoDocContable siiTipoDocCon2 = tipoDocContableDao.buscarPorCodigo("TRF");
        SiiCuentaBancaria siiCuentaBan = cuentaBancariaDao.buscarCuentaPorId(trasladoCuentasBancariasVo.getCuentaBancariaOrigenVo().getCbaCodigo());
        SiiCuentasContables siiCuentasCont = cuentasContablesDao.buscarPorCodigo(siiCuentaBan.getSiiCuentasContables().getCcoCodigo());
        siiImputacionContable2.setSiiCuentasContables(siiCuentasCont);
        siiImputacionContable2.setImcTipoMovim("C");
        siiImputacionContable2.setImcEstado("A");
        SiiCuentasContables siiCueCont =
            cuentasContablesDao.buscarPorCodigo(siiCuentaBan.getSiiCuentasContables().getCcoCodigo());
        //validaciones
        if (siiCueCont.getCcoObligaTerc().equals("S"))
            siiImputacionContable2.setSiiPersona(siiPersona);
        if (siiCueCont.getCcoNumDocConta().equals("S"))
            siiImputacionContable2.setSiiDocumentoContable(insertSiiDocumentoContable);
        if (siiCueCont.getCcoReferencia1().equals("S"))
            siiImputacionContable2.setImcReferencia1(format1.format(date));
        siiImputacionContable2.setImcDescrOperacion(trasladoCuentasBancariasVo.getTbaDescripcion());
        siiImputacionContable2.setImcValor(trasladoCuentasBancariasVo.getTbaValor());
        imputacionContableDao.insertarImputacionContable(siiImputacionContable2);

        return new TrasladoCuentasBancariasVO(siiTrasladoBancario);
            
        } catch (ExcepcionDAO ex){
            ex.printStackTrace();
            throw ex;
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
        }
    }

    public TrasladoCuentasBancariasVO buscarSaldoCuentaTrasladoBancario(Long idCuentaBancaria) throws ExcepcionDAO {
        TrasladoCuentasBancariasVO unTrasladoCuentasBancariasVO = new TrasladoCuentasBancariasVO();
        unTrasladoCuentasBancariasVO = trasladoCuentasBancariasDao.buscarSaldoCuentaTrasladoBancario(idCuentaBancaria);
        return unTrasladoCuentasBancariasVO;
    }

    public EstadoTrasladoBancarioVO buscarEstadoEstadoTraslBancarioPorNombre(String nombreEstado) throws ExcepcionDAO {
        SiiEstadoTraslBancario siiEstadoTraslBancario = new SiiEstadoTraslBancario();
        siiEstadoTraslBancario = estadoTansladoBancarioDao.buscarEstadoEstadoTraslBancarioPorNombre(nombreEstado);
        return new EstadoTrasladoBancarioVO(siiEstadoTraslBancario);

    }
    
    public DocumentoContableVO buscarPorCodigoTrasBanco (Long trbCodigo) throws ExcepcionDAO {
       
           SiiDocumentoContable siiDocumentoContable= trasladoCuentasBancariasDao.buscarPorCodigoTrasBanco(trbCodigo);
        
          if (siiDocumentoContable != null) {
              return new  DocumentoContableVO(siiDocumentoContable);
          } else {
              return new DocumentoContableVO();
          }
    }
   

}
