package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.RpDetRubroCdpVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminRpDetRubroCdpBean implements AdminRpDetRubroCdp {
    @Resource
    SessionContext sessionContext;
    
    @EJB
    RpDetRubroCdpDAO rpDetRubroCdpDao;
    @EJB 
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminRpDetRubroCdpBean() {
        
    }

    /**
     * @param drcCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public List<RpDetRubroCdpVO> buscarRpDetRubroCdpPorDetRubCdp (Long drcCodigo) throws ExcepcionDAO {
        List<SiiRpDetRubroCdp> listaRpDetRubroCdp = rpDetRubroCdpDao.buscarRpDetRubroCdpPorDetRubCdp(drcCodigo);
        List<RpDetRubroCdpVO> listaRpDetRubroCdpVO =  new ArrayList<RpDetRubroCdpVO>();
            
        for (SiiRpDetRubroCdp unRpDetRubroCdp : listaRpDetRubroCdp) {
            listaRpDetRubroCdpVO.add(new RpDetRubroCdpVO(unRpDetRubroCdp));
        }
        return listaRpDetRubroCdpVO;
    }

    /**
     * @param rpCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public List<RpDetRubroCdpVO> buscarRpDetRubroCdpPorRp (Long rpCodigo) throws ExcepcionDAO {
        List<SiiRpDetRubroCdp> listaRpDetRubroCdp = rpDetRubroCdpDao.buscarRpDetRubroCdpPorRp(rpCodigo);
        List<RpDetRubroCdpVO> listaRpDetRubroCdpVO =  new ArrayList<RpDetRubroCdpVO>();
            
        for (SiiRpDetRubroCdp unRpDetRubroCdp : listaRpDetRubroCdp) {
            listaRpDetRubroCdpVO.add(new RpDetRubroCdpVO(unRpDetRubroCdp));
        }
        return listaRpDetRubroCdpVO;

    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubroCdpDAO#buscarRpDetRubroCdpPorRpFFC(java.lang.Long, java.lang.String)
     */
    @Override
    public List<RpDetRubroCdpVO> buscarRpDetRubroCdpPorRpFFC (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        List<RpDetRubroCdpVO> listaRpDetRubroCdpVo = null;
        List<SiiRpDetRubroCdp> listaRpDetRubroCdp = rpDetRubroCdpDao.buscarRpDetRubroCdpPorRpFFC(rpCodigo, ffcCodigo);
        
        if (listaRpDetRubroCdp!=null) {
            listaRpDetRubroCdpVo = new ArrayList<RpDetRubroCdpVO>();
                
            for (SiiRpDetRubroCdp siiRpDetRubroCdp : listaRpDetRubroCdp) {
                if (siiRpDetRubroCdp!=null)
                    listaRpDetRubroCdpVo.add(new RpDetRubroCdpVO(siiRpDetRubroCdp));
            }
        }
        
        return (listaRpDetRubroCdpVo);
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubroCdpDAO#buscarRpDetRubroCdpPorRpFFCGMF(java.lang.Long, java.lang.String, java.lang.Boolean)
     */
    @Override
    public List<RpDetRubroCdpVO> buscarRpDetRubroCdpPorRpFFCGMF (Long rpCodigo, String ffcCodigo, Boolean aplicaGmf) throws ExcepcionDAO 
    {
        List<RpDetRubroCdpVO> listaRpDetRubroCdpVo = null;
        List<SiiRpDetRubroCdp> listaRpDetRubroCdp = rpDetRubroCdpDao.buscarRpDetRubroCdpPorRpFFCGMF(rpCodigo, ffcCodigo, aplicaGmf);
        
        if (listaRpDetRubroCdp!=null) {
            listaRpDetRubroCdpVo = new ArrayList<RpDetRubroCdpVO>();
                
            for (SiiRpDetRubroCdp siiRpDetRubroCdp : listaRpDetRubroCdp) {
                if (siiRpDetRubroCdp!=null)
                    listaRpDetRubroCdpVo.add(new RpDetRubroCdpVO(siiRpDetRubroCdp));
            }
        }
        
        return (listaRpDetRubroCdpVo);
    }
    
    
    
    @SuppressWarnings("oracle.jdeveloper.java.tag-is-missing")
    public BigDecimal valorRpDetRubroCdpAprobado(Long drcCodigo) throws ExcepcionDAO {
        return rpDetRubroCdpDao.valorRpDetRubroCdpAprobado(drcCodigo);
    }
    
    public List<RpDetRubroCdpVO> listaRubrosRpsAsociadosConLosCdpAsociadosConElRubroRp(RpDetRubroCdpVO rpDetRubroCdpVO) throws ExcepcionDAO  {
        List<SiiRpDetRubroCdp> listaRpDetRubroCdp = rpDetRubroCdpDao.listaRubrosRpsAsociadosConLosCdpAsociadosConElRubroRp(rpDetRubroCdpVO);
        List<RpDetRubroCdpVO> listaRpDetRubroCdpVO =  new ArrayList<RpDetRubroCdpVO>();
            
        for (SiiRpDetRubroCdp unRpDetRubroCdp : listaRpDetRubroCdp) {
            listaRpDetRubroCdpVO.add(new RpDetRubroCdpVO(unRpDetRubroCdp));
        }
        return listaRpDetRubroCdpVO;
    }
}
