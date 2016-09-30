/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Mónica Pabón
 * FECHA	: 14-03-2014
 */



package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CdpRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdpRp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CdpRpVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminCdpRpBean implements AdminCdpRp{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    CdpRpDAO cdrpDao;    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    
    public AdminCdpRpBean() {
    }

    public CdpRpVO insertarCdpRp(CdpRpVO cdpRpVo) throws ExcepcionDAO{
        SiiCdpRp siiCdpRp = conversionVoEntidad.convertir(cdpRpVo);
        SiiCdpRp RetornoCdpRp = cdrpDao.insertarSiiCdpRp(siiCdpRp);
        return new CdpRpVO(RetornoCdpRp);
    }
    
    public CdpRpVO actualizarCdpRp(CdpRpVO cdpRpVo) throws ExcepcionDAO{
        SiiCdpRp siiCdpRp = conversionVoEntidad.convertir(cdpRpVo);
        SiiCdpRp RetornoCdpRp = cdrpDao.actualizarSiiCdpRp(siiCdpRp);
        return new CdpRpVO(RetornoCdpRp);
    }
    
    public CdpRpVO buscarPorCodigoCdpRp(CdpRpVO cdpRpVo) throws ExcepcionDAO{
        SiiCdpRp resultadoSiiCdpRp = cdrpDao.buscarPorCodigoCdpRp(cdpRpVo.getCrpCodigo());
        CdpRpVO miCdpRpVo = new CdpRpVO(resultadoSiiCdpRp);          
        return miCdpRpVo;
    }
    public List<CdpRpVO> buscarCdpRpPorRp(Long idRp) throws ExcepcionDAO{
        List<CdpRpVO> listaCdpRpVo = new ArrayList<CdpRpVO>();
        List<SiiCdpRp> listaSiiCdpRp = cdrpDao.buscarCdpRpPorRp(idRp);
        if(listaSiiCdpRp!= null){
            for(SiiCdpRp unCdpRp : listaSiiCdpRp){
                    listaCdpRpVo.add(new CdpRpVO(unCdpRp));
            }            
        }        
        return listaCdpRpVo;
    }
    public List<CdpRpVO> buscarCdpRpPorCdp(Long cdpCodigo)  throws ExcepcionDAO {
        List<CdpRpVO> listaCdpRpVo = new ArrayList<CdpRpVO>();
        List<SiiCdpRp> listaSiiCdpRp = cdrpDao.buscarCdpRpPorCdp(cdpCodigo);
        if(listaSiiCdpRp!= null){
            for(SiiCdpRp unCdpRp : listaSiiCdpRp){
                    listaCdpRpVo.add(new CdpRpVO(unCdpRp));
            }            
        }        
        return listaCdpRpVo;
        
    }
   
}

