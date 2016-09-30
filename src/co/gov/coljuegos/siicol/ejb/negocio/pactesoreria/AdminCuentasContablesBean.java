package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CuentasContablesVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionResultVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminCuentasContablesBean implements AdminCuentasContables{

    @EJB
    private CuentasContablesDAO cuentasDAO;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    public List<ImputacionResultVO> buscarCuentasPorCodigosConceptos(List<Long> codigosConceptos) throws ExcepcionDAO {
        return cuentasDAO.buscarCuentasPorCodigosConceptos(codigosConceptos);
    }
    
    
    /**
     * Realiza la b&uacute;squeda de un registro de Cuentas Contables a trav&eacute;s del C&oacute;digo de la misma.
     * @param ccoCodigo
     * @return instancia de CuentasContablesVO.
     * @throws ExcepcionDAO
     */
    public CuentasContablesVO buscarPorCodigo(Long ccoCodigo) throws ExcepcionDAO {
        SiiCuentasContables siiCuentasContables = cuentasDAO.buscarPorCodigo(ccoCodigo);
        if (siiCuentasContables==null) return null;
        return (new CuentasContablesVO(siiCuentasContables));
    }
    
    
    /**
     * Consulta el listado de Cuentas Contables de las cuales se desagrega la cuenta contable hija especificada.
     * @param ccoCodigo - C&oacute;digo de la Cuenta Contable hija.
     * @return List of SiiCuentasContables
     * @throws ExcepcionDAO
     */
    public List<CuentasContablesVO> buscarCuentasContablesPadre(Long ccoCodigo) throws ExcepcionDAO {
        List<CuentasContablesVO> resultado = null;
        List<SiiCuentasContables> lista = cuentasDAO.buscarCuentasContablesPadre(ccoCodigo);
        if (lista!=null) {
            resultado = new ArrayList<CuentasContablesVO>();
            for (SiiCuentasContables cc: lista) {
                resultado.add(new CuentasContablesVO(cc));
            }
        }
        return (resultado);
    }
    
    
    /**
     * Realiza la consulta de TODAS las Cuentas Contables.
     * @return List of CuentasContablesVO.
     * @throws ExcepcionDAO
     */
    public List<CuentasContablesVO> buscarTodoCuentasContables() throws ExcepcionDAO {
        List<CuentasContablesVO> resultado = null;
        List<SiiCuentasContables> lista = cuentasDAO.buscarTodoCuentasContables();
        if (lista!=null) {
            resultado = new ArrayList<CuentasContablesVO>();
            for (SiiCuentasContables cc: lista) {
                resultado.add(new CuentasContablesVO(cc));
            }
        }
        return (resultado);
    }

    public List<CuentasContablesVO> buscarCuentasPorNaturalezaYDocumentoContable(String naturaleza,
                                                                                 String docContable) throws ExcepcionDAO {
        
        List<CuentasContablesVO> resultado = null;
        List<SiiCuentasContables> lista = cuentasDAO.buscarCuentasPorNaturalezaYDocumentoContable(naturaleza,docContable);
        if (lista!=null) {
            resultado = new ArrayList<CuentasContablesVO>();
            for (SiiCuentasContables cc: lista) {
                resultado.add(new CuentasContablesVO(cc));
            }
        }
        return (resultado);
    }

    public List<CuentasContablesVO> buscarPorRangoCuentas(String cuentaInicial, String cuentaFinal) throws ExcepcionDAO {
        List<CuentasContablesVO> resultado = null;
        List<SiiCuentasContables> lista = cuentasDAO.buscarPorRangoCuentas(cuentaInicial, cuentaFinal);
        if (lista!=null) {
            resultado = new ArrayList<CuentasContablesVO>();
            for (SiiCuentasContables cc: lista) {
                resultado.add(new CuentasContablesVO(cc));
            }
        }
        return (resultado);
    }

    public List<CuentasContablesVO> buscarCuentasPorFuenteFinancContab(String ffcCodigo) throws ExcepcionDAO {
        List<CuentasContablesVO> resultado = null;
        List<SiiCuentasContables> lista = cuentasDAO.buscarCuentasPorFuenteFinancContab(ffcCodigo);
        if (lista!=null) {
            resultado = new ArrayList<CuentasContablesVO>();
            for (SiiCuentasContables cc: lista) {
                if (cc!=null)
                    resultado.add(new CuentasContablesVO(cc));
            }
        }
        return (resultado);
    }

    public List<CuentasContablesVO> buscarCuentasContablesPorCategoriaDistribucion(Long cadCodigo) throws ExcepcionDAO 
    {
        List<CuentasContablesVO> resultado = null;
        List<SiiCuentasContables> lista = cuentasDAO.buscarCuentasContablesPorCategoriaDistribucion(cadCodigo);
        if (lista!=null) {
            resultado = new ArrayList<CuentasContablesVO>();
            for (SiiCuentasContables cc: lista) {
                if (cc!=null)
                    resultado.add(new CuentasContablesVO(cc));
            }
        }
        return (resultado);
    }
    
    public CuentasContablesVO insertarCuentasContables(CuentasContablesVO cuentasContablesVo) throws ExcepcionDAO{
       
        SiiCuentasContables siiCuentasContables = new SiiCuentasContables();
        siiCuentasContables = conversionVoEntidad.convertit(cuentasContablesVo);
        siiCuentasContables = cuentasDAO.insertarSiiCuentasContables(siiCuentasContables);        
        return cuentasContablesVo;
    }

    public CuentasContablesVO actualizarCuentasContables(CuentasContablesVO cuentasContablesVo) throws ExcepcionDAO{
        SiiCuentasContables siiCuentasContables = new SiiCuentasContables();
        siiCuentasContables = conversionVoEntidad.convertit(cuentasContablesVo);
        siiCuentasContables = cuentasDAO.actualizarSiiCuentasContables(siiCuentasContables);
        return cuentasContablesVo;
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO#buscarPorCadenaNiveles(java.lang.String)
     */
    @Override
    public CuentasContablesVO buscarPorCadenaNiveles (String cadenaNiveles) throws ExcepcionDAO 
    {
        CuentasContablesVO resultado = null;
        SiiCuentasContables siiCuentasContables = cuentasDAO.buscarPorCadenaNiveles(cadenaNiveles);
        if (siiCuentasContables!=null)
            resultado = new CuentasContablesVO(siiCuentasContables);
        
        return (resultado);
    }
    
    @Override
    public List<CuentasContablesVO> buscarCuentasContablesAcreedoras() throws ExcepcionDAO {
        List<CuentasContablesVO> resultado = null;
        List<SiiCuentasContables> lista = cuentasDAO.buscarCuentasContablesAcreedoras();
        if (lista!=null) {
            resultado = new ArrayList<CuentasContablesVO>();
            for (SiiCuentasContables cc: lista) {
                resultado.add(new CuentasContablesVO(cc));
            }
        }
        return (resultado);
    }
    
    
}
