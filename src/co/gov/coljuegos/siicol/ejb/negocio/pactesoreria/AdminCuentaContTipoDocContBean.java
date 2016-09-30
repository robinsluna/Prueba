/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-05-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaContTipoDocContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CuentaContTipoDocContVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminCuentaContTipoDocContBean implements AdminCuentaContTipoDocCont {

    /**
     * Constructor.
     */
    @EJB
    private CuentaContTipoDocContDAO cuentaContTipoDocContDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    
    /**
     * Constructor.
     */
    public AdminCuentaContTipoDocContBean() {
        super();
    }

    @Override
    public List<CuentaContTipoDocContVO> buscarSiiCuentaContTipoDocContPorTipoDoc(String tipoDocumento) throws ExcepcionDAO {
        List<CuentaContTipoDocContVO> resultado = null;
        List<SiiCuentaContTipoDocCont> lista = cuentaContTipoDocContDao.buscarSiiCuentaContTipoDocContPorTipoDoc(tipoDocumento);
        if (lista!=null) {
            resultado = new ArrayList<CuentaContTipoDocContVO>();
            for (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont: lista) {
                resultado.add(new CuentaContTipoDocContVO(siiCuentaContTipoDocCont));
            }
        }
        
        return (resultado);
    }

    @Override
    public List<CuentaContTipoDocContVO> buscarPorTipoDocConceptoNumIdentificacionTipoRetencionFFC(String tdcCodigo, String cctConcepto, String perNumIdentificacion, String cctTipoRetNomina, String ffcCodigo) throws ExcepcionDAO 
    {
        List<CuentaContTipoDocContVO> resultado = null;
        List<SiiCuentaContTipoDocCont> lista = cuentaContTipoDocContDao.buscarPorTipoDocConceptoNumIdentificacionTipoRetencionFFC(tdcCodigo, cctConcepto, perNumIdentificacion, cctTipoRetNomina, ffcCodigo);
        if (lista!=null) {
            resultado = new ArrayList<CuentaContTipoDocContVO>();
            for (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont: lista) {
                resultado.add(new CuentaContTipoDocContVO(siiCuentaContTipoDocCont));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<CuentaContTipoDocContVO> buscarPorTipoDocConceptoNumIdentificacionTipoRetencionFFC(String tdcCodigo,
                                                                                                   String cctConcepto,
                                                                                                   String perNumIdentificacion,
                                                                                                   String cctTipoRetNomina,
                                                                                                   String ffcCodigo,
                                                                                                   boolean buscarCuentasSinConcepto) 
        throws ExcepcionDAO 
    {
        List<CuentaContTipoDocContVO> resultado = null;
        List<SiiCuentaContTipoDocCont> lista = cuentaContTipoDocContDao.buscarPorTipoDocConceptoNumIdentificacionTipoRetencionFFC(tdcCodigo, cctConcepto, perNumIdentificacion, cctTipoRetNomina, ffcCodigo, buscarCuentasSinConcepto);
        if (lista!=null) {
            resultado = new ArrayList<CuentaContTipoDocContVO>();
            for (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont: lista) {
                resultado.add(new CuentaContTipoDocContVO(siiCuentaContTipoDocCont));
            }
        }
        
        return (resultado);
    }
    
    
    public List<CuentaContTipoDocContVO> buscarSiiCuentaContTipoDocContPorTipoDocYConcepto(String tipoDocumento, String concepto) throws ExcepcionDAO {
        List<CuentaContTipoDocContVO> resultado = null;
        List<SiiCuentaContTipoDocCont> lista = cuentaContTipoDocContDao.buscarSiiCuentaContTipoDocContPorTipoDocYConcepto(tipoDocumento, concepto);
        if (lista!=null) {
            resultado = new ArrayList<CuentaContTipoDocContVO>();
            for (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont: lista) {
                resultado.add(new CuentaContTipoDocContVO(siiCuentaContTipoDocCont));
            }
        }
        
        return (resultado);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.GenericDAO#buscarCuentaContTipoDocContPorCodigo(java.lang.Long)
     */
    @Override
    public CuentaContTipoDocContVO buscarCuentaContTipoDocContPorCodigo (Long cctCodigo) throws ExcepcionDAO 
    {
        CuentaContTipoDocContVO resultado = null;
        SiiCuentaContTipoDocCont siiCuentaContTipoDocCont = cuentaContTipoDocContDao.buscarPorCodigo(cctCodigo);
        if (siiCuentaContTipoDocCont!=null)
            resultado = new CuentaContTipoDocContVO(siiCuentaContTipoDocCont);
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.GenericDAO#buscarTodo
     */
    @Override
    public List<CuentaContTipoDocContVO> buscarTodaCuentaContTipoDocCont () throws ExcepcionDAO {
        List<CuentaContTipoDocContVO> resultado = null;
        List<SiiCuentaContTipoDocCont> lista = cuentaContTipoDocContDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<CuentaContTipoDocContVO>();
            for (SiiCuentaContTipoDocCont siiCuentaContTipoDocCont: lista) {
                if (siiCuentaContTipoDocCont!=null)
                    resultado.add(new CuentaContTipoDocContVO(siiCuentaContTipoDocCont));
            }
        }
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.GenericDAO#insertar(java.lang.Object)
     */
    @Override
    public CuentaContTipoDocContVO insertarCuentaContTipoDocCont (CuentaContTipoDocContVO cuentaContTipoDocContVo) throws ExcepcionDAO 
    {
        CuentaContTipoDocContVO resultado = null;
        SiiCuentaContTipoDocCont siiCuentaContTipoDocCont = cuentaContTipoDocContDao.insertar(conversionVoEntidad.convertir(cuentaContTipoDocContVo));
        if (siiCuentaContTipoDocCont!=null)
            resultado = new CuentaContTipoDocContVO(siiCuentaContTipoDocCont);
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.GenericDAO#actualizar(java.lang.Object)
     */
    @Override
    public CuentaContTipoDocContVO actualizarCuentaContTipoDocCont (CuentaContTipoDocContVO cuentaContTipoDocContVo) throws ExcepcionDAO 
    {
        CuentaContTipoDocContVO resultado = null;
        SiiCuentaContTipoDocCont siiCuentaContTipoDocCont = cuentaContTipoDocContDao.actualizar(conversionVoEntidad.convertir(cuentaContTipoDocContVo));
        if (siiCuentaContTipoDocCont!=null)
            resultado = new CuentaContTipoDocContVO(siiCuentaContTipoDocCont);
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.GenericDAO#eliminar(java.lang.Long)
     */
    @Override
    public void eliminarCuentaContTipoDocCont (Long cctCodigo) throws ExcepcionDAO {
        cuentaContTipoDocContDao.eliminar(cctCodigo);
    }
}
