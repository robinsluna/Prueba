/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 12-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OblConcRpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOblConcRpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.OblConcRpDetRubCdpVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminOblConcRpDetRubCdpBean implements AdminOblConcRpDetRubCdp 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private OblConcRpDetRubCdpDAO oblConcRpDetRubCdpDao;
    
    
    /**
     * Constructor.
     */
    public AdminOblConcRpDetRubCdpBean() {
        super();
    }

    @Override
    public OblConcRpDetRubCdpVO buscarPorCodigoOblConcRpDetRubCdp(Long ocrCodigo) throws ExcepcionDAO {
        OblConcRpDetRubCdpVO resultado = null;
        SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp = oblConcRpDetRubCdpDao.buscarPorCodigo(ocrCodigo);
        if (siiOblConcRpDetRubCdp!=null)
            resultado = new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp);
        
        return resultado;
    }

    @Override
    public OblConcRpDetRubCdpVO insertarOblConcRpDetRubCdp(OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) throws ExcepcionDAO {
        OblConcRpDetRubCdpVO resultado = null;
        SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp = oblConcRpDetRubCdpDao.insertar(conversionVoEntidad.convertir(oblConcRpDetRubCdpVo));
        if (siiOblConcRpDetRubCdp!=null) 
            resultado = new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp);
        
        return resultado;
    }

    @Override
    public OblConcRpDetRubCdpVO actualizarOblConcRpDetRubCdp(OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) throws ExcepcionDAO {
        OblConcRpDetRubCdpVO resultado = null;
        SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp = oblConcRpDetRubCdpDao.actualizar(conversionVoEntidad.convertir(oblConcRpDetRubCdpVo));
        if (siiOblConcRpDetRubCdp!=null) 
            resultado = new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp);
        
        return resultado;
    }

    @Override
    public void eliminarOblConcRpDetRubCdp(Long ocrCodigo) throws ExcepcionDAO {
        oblConcRpDetRubCdpDao.eliminar(ocrCodigo);
    }

    @Override
    public List<OblConcRpDetRubCdpVO> buscarTodoOblConcRpDetRubCdp() throws ExcepcionDAO {
        List<OblConcRpDetRubCdpVO> resultado = null;
        List<SiiOblConcRpDetRubCdp> lista = oblConcRpDetRubCdpDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<OblConcRpDetRubCdpVO>();
            for (SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp: lista) {
                resultado.add(new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp));
            }
        }
        return resultado;
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OblConcRpDetRubCdpDAO#buscarPorCodigoObligacionConcepto(java.lang.Long)
     */
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoObligacionConcepto(Long ocoCodigo) throws ExcepcionDAO {
        List<OblConcRpDetRubCdpVO> resultado = null;
        List<SiiOblConcRpDetRubCdp> lista = oblConcRpDetRubCdpDao.buscarPorCodigoObligacionConcepto(ocoCodigo);
        if (lista!=null) {
            resultado = new ArrayList<OblConcRpDetRubCdpVO>();
            for (SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp: lista) {
                resultado.add(new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp));
            }
        }
        return resultado;
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OblConcRpDetRubCdpDAO#buscarPorCodigoObligacion(java.lang.Long)
     */
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoObligacion(Long oblCodigo) throws ExcepcionDAO {
        List<OblConcRpDetRubCdpVO> resultado = null;
        List<SiiOblConcRpDetRubCdp> lista = oblConcRpDetRubCdpDao.buscarPorCodigoObligacion(oblCodigo);
        if (lista!=null) {
            resultado = new ArrayList<OblConcRpDetRubCdpVO>();
            for (SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp: lista) {
                resultado.add(new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp));
            }
        }
        return resultado;
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OblConcRpDetRubCdpDAO#obtenerTotalPorRpDetRubCdp(java.lang.Long)
     */
    public BigDecimal obtenerTotalPorRpDetRubCdp(Long rdrCodigo) throws ExcepcionDAO {
        return (oblConcRpDetRubCdpDao.obtenerTotalPorRpDetRubCdp(rdrCodigo));
    }
    
    public BigDecimal valorRubroRpEjecutado(Long rdrCodigo) throws ExcepcionDAO {
        return oblConcRpDetRubCdpDao.valorRubroRpEjecutado( rdrCodigo);
    }

    public List<OblConcRpDetRubCdpVO> buscarPorCodigoRp(Long rpCodigo) throws ExcepcionDAO {
        List<OblConcRpDetRubCdpVO> resultado = null;
        List<SiiOblConcRpDetRubCdp> lista = oblConcRpDetRubCdpDao.buscarPorCodigoRp(rpCodigo);
        if (lista!=null) {
            resultado = new ArrayList<OblConcRpDetRubCdpVO>();
            for (SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp: lista) {
                resultado.add(new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp));
            }
        }
        return resultado;
    }
    
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoRpFFC (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO {
        List<OblConcRpDetRubCdpVO> resultado = null;
        List<SiiOblConcRpDetRubCdp> lista = oblConcRpDetRubCdpDao.buscarPorCodigoRpFFC(rpCodigo, ffcCodigo);
        if (lista!=null) {
            resultado = new ArrayList<OblConcRpDetRubCdpVO>();
            for (SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp: lista) {
                resultado.add(new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp));
            }
        }
        return resultado;
    }
    
    
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoObligacionRpFFC (Long oblCodigo, Long rpCodigo, String ffcCodigo) throws ExcepcionDAO {
        List<OblConcRpDetRubCdpVO> resultado = null;
        List<SiiOblConcRpDetRubCdp> lista = oblConcRpDetRubCdpDao.buscarPorCodigoObligacionRpFFC(oblCodigo, rpCodigo, ffcCodigo);
        if (lista!=null) {
            resultado = new ArrayList<OblConcRpDetRubCdpVO>();
            for (SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp: lista) {
                resultado.add(new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp));
            }
        }
        return resultado;
    }
    
    
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoRpFFC (Long rpCodigo, String ffcCodigo, boolean descartarOblAnuladas) throws ExcepcionDAO {
        List<OblConcRpDetRubCdpVO> resultado = null;
        List<SiiOblConcRpDetRubCdp> lista = oblConcRpDetRubCdpDao.buscarPorCodigoRpFFC(rpCodigo, ffcCodigo, descartarOblAnuladas);
        if (lista!=null) {
            resultado = new ArrayList<OblConcRpDetRubCdpVO>();
            for (SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp: lista) {
                resultado.add(new OblConcRpDetRubCdpVO(siiOblConcRpDetRubCdp));
            }
        }
        return resultado;
    }
}
