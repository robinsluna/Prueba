/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocContable;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuenteFinancContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImpContabOblNoPresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OrdenPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinancContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionObligaNoPresupuestalVO;
import co.gov.coljuegos.siicol.ejb.vo.InfoSaldoImpCuentaContabVO;
import co.gov.coljuegos.siicol.ejb.vo.OrdenPagoVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminImputacionContableBean implements AdminImputacionContable 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ImputacionContableDAO imputacionContableDao;
    @EJB
    private DocumentoContableDAO documentoContableDao;
    @EJB
    private ImpContabOblNoPresDAO impContabOblNoPresDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private OrdenPagoDAO ordenPagoDao;
    @EJB
    private FuenteFinancContabDAO fuenteFinancContabDao;
    @EJB
    private CuentasContablesDAO cuentasContablesDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminImputacionContableBean() {
        super();
    }

    @Override
    public ImputacionContableVO buscarPorCodigoImputacionContable(Long imcCodigo) throws ExcepcionDAO {
        SiiImputacionContable siiImputacionContable = imputacionContableDao.buscarPorCodigo(imcCodigo);
        if (siiImputacionContable==null) return null;
        return ( new ImputacionContableVO(siiImputacionContable) );
    }

    @Override
    public ImputacionContableVO insertarImputacionContable(ImputacionContableVO imputacionContableVO) throws ExcepcionDAO {
        SiiImputacionContable siiImputacionContable = imputacionContableDao.insertar(conversionVoEntidad.convertir(imputacionContableVO));
        if (siiImputacionContable==null) return null;
        return ( new ImputacionContableVO(siiImputacionContable) );
    }

    @Override
    public ImputacionContableVO actualizarImputacionContable(ImputacionContableVO imputacionContableVO) throws ExcepcionDAO {
        SiiImputacionContable siiImputacionContable = imputacionContableDao.actualizar(conversionVoEntidad.convertir(imputacionContableVO));
        if (siiImputacionContable==null) return null;
        return ( new ImputacionContableVO(siiImputacionContable) );
    }

    @Override
    public void borrarImputacionContable(Long imcCodigo) throws ExcepcionDAO {
        imputacionContableDao.eliminar(imcCodigo);
    }

    @Override
    public List<ImputacionContableVO> buscarTodaImputacionContable() throws ExcepcionDAO {
        List<ImputacionContableVO> listaImputacionContable = null;
        List<SiiImputacionContable> lista = imputacionContableDao.buscarTodo();
        if (lista!=null) {
            listaImputacionContable = new ArrayList<ImputacionContableVO>();
            for (SiiImputacionContable siiImputacionContable: lista) {
                listaImputacionContable.add(new ImputacionContableVO(siiImputacionContable));
            }
        }
        return (listaImputacionContable);
    }
    
    @Override
    public List<ImputacionContableVO> buscarPorCodigoDocumentoContable(Long dcoCodigo) throws ExcepcionDAO {
        List<ImputacionContableVO> listaImputacionContable = null;
        List<SiiImputacionContable> lista = imputacionContableDao.buscarPorCodigoDocumentoContable(dcoCodigo);
        if (lista!=null) {
            listaImputacionContable = new ArrayList<ImputacionContableVO>();
            for (SiiImputacionContable siiImputacionContable: lista) {
                listaImputacionContable.add(new ImputacionContableVO(siiImputacionContable));
            }
        }
        return (listaImputacionContable);
    }
    
    
    @Override
    public List<ImputacionContableVO> buscarPorCodigoDocumentoContableYEstado(Long dcoCodigo,
                                                                              String imcEstado) throws ExcepcionDAO {
        List<ImputacionContableVO> listaImputacionContable = null;
        List<SiiImputacionContable> lista = imputacionContableDao.buscarPorCodigoDocumentoContableYEstado(dcoCodigo, imcEstado);
        if (lista!=null) {
            listaImputacionContable = new ArrayList<ImputacionContableVO>();
            for (SiiImputacionContable siiImputacionContable: lista) {
                listaImputacionContable.add(new ImputacionContableVO(siiImputacionContable));
            }
        }
        return (listaImputacionContable);
    }
    
    
    public List<ImputacionObligaNoPresupuestalVO> buscarImputacionObligacionesNoPresupuestales(String tipoIdentificacion, String numeroIdentificacion, String idFueFinan) throws ExcepcionDAO {
        List<ImputacionObligaNoPresupuestalVO> lista = null;
        lista = imputacionContableDao.buscarImputacionObligacionesNoPresupuestales(tipoIdentificacion, numeroIdentificacion,idFueFinan);
        return lista;
    }
    
    public List<ImputacionObligaNoPresupuestalVO> buscarImputacionObligacionesNoPresupuestalesPorCodigoOblNoPres(Long idObligNoPres ) throws ExcepcionDAO {
        List<ImputacionObligaNoPresupuestalVO> lista = null;
        lista = imputacionContableDao.buscarImputacionObligacionesNoPresupuestalesPorCodigoOblNoPres(idObligNoPres);
        return lista;
    }
    
    public boolean insertarImputacionContableOrdenesPagoNoPres(DocumentoContableVO doc, OrdenPagoVO orden, String estadoImpBorrador, 
                                                               BigDecimal totalObligacion,List<ImputacionContableVO> listaImputacionEd) throws ExcepcionDAO {
        //Se actualiza el estado de la orden a APROBADO
        SiiOrdenPago resultadoOrden = ordenPagoDao.actualizarSiiOrdenPago(conversionVoEntidad.convertir(orden));
        // se inserta el documento contable
        BigDecimal cuatro= new BigDecimal (4);
        BigDecimal mil  = new BigDecimal (1000);
        BigDecimal tmp = cuatro.divide(mil);
        boolean respuesta = false;
        
        if(listaImputacionEd!= null && listaImputacionEd.size()>0){
            SiiDocumentoContable resultadoDoc = documentoContableDao.insertarDocumentoContable(conversionVoEntidad.convertir(doc));   
            if(listaImputacionEd.size()> 0){
                    for(ImputacionContableVO unImpVo : listaImputacionEd){
                        SiiImputacionContable siiImputa = conversionVoEntidad.convertir(unImpVo);   
                        siiImputa.setSiiDocumentoContable(resultadoDoc);
                        // se inserta la imputación
                        imputacionContableDao.insertarInputacionContable(siiImputa);                    
                    } 
                }
            respuesta= true;
        }
        
       return respuesta; 
    }
    public boolean insertarImputacionContableOrdenesPagoNoPresTPE(DocumentoContableVO doc, OrdenPagoVO orden, String estadoImpBorrador, BigDecimal totalObligacion) throws ExcepcionDAO {
        SiiDocumentoContable resultadoDoc = documentoContableDao.insertarDocumentoContable(conversionVoEntidad.convertir(doc));   
        List<SiiCuentaContTipoDocCont> listaCuentasCon = new ArrayList();
        if(orden.getGastosGenerales().equals("GP")){
                listaCuentasCon = impContabOblNoPresDao.buscarCuentaContablePorDocumentoYFuente(EnumTipoDocContable.TRASLADO_A_PAGADURIA.toString(), "RNP");
                if(listaCuentasCon.size() > 0){
                    for(SiiCuentaContTipoDocCont siicuentaCon : listaCuentasCon){
                        SiiImputacionContable siiImputaConDfN =  new SiiImputacionContable();
                        siiImputaConDfN.setSiiCuentasContables(siicuentaCon.getSiiCuentasContables());
                        siiImputaConDfN.setImcTipoMovim("C");
                        siiImputaConDfN.setSiiDocumentoContable(resultadoDoc);
                        SiiPersona tercerodFN = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), "899999090");
                        siiImputaConDfN.setSiiPersona(tercerodFN);
                        SiiFuenteFinancContab fuenteFinanc = fuenteFinancContabDao.buscarPorCodigo("RNP");
                        siiImputaConDfN.setSiiFuenteFinancContab(fuenteFinanc);
                        siiImputaConDfN.setImcDescrOperacion("TRASLADO A PAGADURIA ENTIDAD");
                        siiImputaConDfN.setImcValor(totalObligacion);
                        imputacionContableDao.insertarInputacionContable(siiImputaConDfN);
                        
                        SiiImputacionContable siiImputaConDfN2 =  new SiiImputacionContable();
                        SiiCuentasContables siicuentas = cuentasContablesDao.buscarPorCodigo(orden.getCuentaBancariaVo().getCuentasContablesVo().getCcoCodigo());
                        siiImputaConDfN2.setSiiCuentasContables(siicuentas);
                        siiImputaConDfN2.setImcTipoMovim("D");
                        siiImputaConDfN2.setSiiDocumentoContable(resultadoDoc);
                        SiiPersona tercerodFN2 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), "899999090");
                        siiImputaConDfN2.setSiiPersona(tercerodFN2);
                        SiiFuenteFinancContab fuenteFinanc2 = fuenteFinancContabDao.buscarPorCodigo("RNP");
                        siiImputaConDfN2.setSiiFuenteFinancContab(fuenteFinanc2);
                        siiImputaConDfN2.setImcDescrOperacion("TRASLADO A PAGADURIA ENTIDAD");
                        siiImputaConDfN2.setImcValor(totalObligacion);
                        imputacionContableDao.insertarInputacionContable(siiImputaConDfN2);                        
                    }                    
                }
            } else if(orden.getGastosGenerales().equals("GG")){
                listaCuentasCon = impContabOblNoPresDao.buscarCuentaContablePorDocumentoYFuente(EnumTipoDocContable.TRASLADO_A_PAGADURIA.toString(), "RNG");
                if(listaCuentasCon.size() > 0){
                    for(SiiCuentaContTipoDocCont siicuentaCon : listaCuentasCon){
                        SiiImputacionContable siiImputaConDfN =  new SiiImputacionContable();
                        siiImputaConDfN.setSiiCuentasContables(siicuentaCon.getSiiCuentasContables());
                        siiImputaConDfN.setImcTipoMovim("C");
                        siiImputaConDfN.setSiiDocumentoContable(resultadoDoc);
                        SiiPersona tercerodFN = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), "899999090");
                        siiImputaConDfN.setSiiPersona(tercerodFN);
                        SiiFuenteFinancContab fuenteFinanc = fuenteFinancContabDao.buscarPorCodigo("RNG");
                        siiImputaConDfN.setSiiFuenteFinancContab(fuenteFinanc);
                        siiImputaConDfN.setImcDescrOperacion("TRASLADO A PAGADURIA ENTIDAD");
                        siiImputaConDfN.setImcValor(totalObligacion);
                        imputacionContableDao.insertarInputacionContable(siiImputaConDfN);
                        
                        SiiImputacionContable siiImputaConDfN3 =  new SiiImputacionContable();
                        SiiCuentasContables siicuentas = cuentasContablesDao.buscarPorCodigo(orden.getCuentaBancariaVo().getCuentasContablesVo().getCcoCodigo());
                        siiImputaConDfN3.setSiiCuentasContables(siicuentas);
                        siiImputaConDfN3.setImcTipoMovim("D");
                        siiImputaConDfN3.setSiiDocumentoContable(resultadoDoc);
                        SiiPersona tercerodFN3 = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), "899999090");
                        siiImputaConDfN3.setSiiPersona(tercerodFN3);
                        SiiFuenteFinancContab fuenteFinanc2 = fuenteFinancContabDao.buscarPorCodigo("RNG");
                        siiImputaConDfN3.setSiiFuenteFinancContab(fuenteFinanc2);
                        siiImputaConDfN3.setImcDescrOperacion("TRASLADO A PAGADURIA ENTIDAD");
                        siiImputaConDfN3.setImcValor(totalObligacion);
                        imputacionContableDao.insertarInputacionContable(siiImputaConDfN3);                        
                    }                    
                }
            
            
            }
        return true;
    }
    
    public boolean insertarImputacionConfPago(DocumentoContableVO doc, List<ImputacionContableVO> listaImpNueva,OrdenPagoVO orden) throws ExcepcionDAO {
        //Se actualiza el estado de la orden a APROBADO
        SiiOrdenPago resultadoOrden = ordenPagoDao.actualizarSiiOrdenPago(conversionVoEntidad.convertir(orden));
        if(doc!= null){
            SiiDocumentoContable resultadoDoc = documentoContableDao.insertarDocumentoContable(conversionVoEntidad.convertir(doc));
            if(listaImpNueva.size() > 0){
                for(ImputacionContableVO unVo : listaImpNueva){
                    SiiImputacionContable unSiiImpuContable = conversionVoEntidad.convertir(unVo);
                    unSiiImpuContable.setSiiDocumentoContable(resultadoDoc );
                    imputacionContableDao.insertarInputacionContable(unSiiImpuContable);
                }
                
            }
        }
        return true;
    
    }
    
    
    public List<InfoSaldoImpCuentaContabVO> obtenerInfoSaldoImputacionCuentasContab (Integer vigencia, boolean incluirSaldoInicial, Long ccoCodigo, boolean groupByPerCodigo, boolean groupByAcoCodigo) throws ExcepcionDAO {
        return ( imputacionContableDao.obtenerInfoSaldoImputacionCuentasContab(vigencia, incluirSaldoInicial, ccoCodigo, groupByPerCodigo, groupByAcoCodigo) );
    }
    
    
    public List<InfoSaldoImpCuentaContabVO> obtenerInfoSaldoImputacionCuentasContab (Integer vigencia, boolean incluirSaldoInicial, String ccoTipoCuenta, String ccoCtaResult, String ccoCtaImpuestos, boolean groupByPerCodigo, boolean groupByAcoCodigo, Long ccoCodigo) throws ExcepcionDAO 
    {
        return ( imputacionContableDao.obtenerInfoSaldoImputacionCuentasContab(vigencia, incluirSaldoInicial, ccoTipoCuenta, ccoCtaResult, ccoCtaImpuestos, groupByPerCodigo, groupByAcoCodigo, ccoCodigo) );
    }
}
