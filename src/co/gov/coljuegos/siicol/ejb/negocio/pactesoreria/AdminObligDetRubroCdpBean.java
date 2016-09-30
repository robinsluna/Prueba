package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligDetRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminObligDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.ObligDetRubroCdpVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminObligDetRubroCdpBean implements AdminObligDetRubroCdp{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    ObligDetRubroCdpDAO obligDetRubroCdpDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminObligDetRubroCdpBean() {
    }
    
    public ObligDetRubroCdpVO buscarObligDetRubroCdpPorId(ObligDetRubroCdpVO obligDetRubroCdpVo) throws ExcepcionDAO{
        SiiObligDetRubroCdp obligDetRubroCdp = obligDetRubroCdpDao.buscarObligDetRubroCdpPorId(obligDetRubroCdpVo.getOdrCodigo());
        return new ObligDetRubroCdpVO(obligDetRubroCdp);
        
    }
    public ObligDetRubroCdpVO insertarObligDetRubroCdp(ObligDetRubroCdpVO obligDetRubroCdpVo) throws ExcepcionDAO{
        SiiObligDetRubroCdp obligDetRubroCdp = conversionVoEntidad.converir(obligDetRubroCdpVo);
        SiiObligDetRubroCdp obligDetRubroCdpRetorno = obligDetRubroCdpDao.insertarObligDetRubroCdp(obligDetRubroCdp);
        return new ObligDetRubroCdpVO(obligDetRubroCdpRetorno);
    }
        
    public void eliminarObligDetRubroCdp (ObligDetRubroCdpVO obligDetRubroCdpVo) throws ExcepcionDAO{
        obligDetRubroCdpDao.eliminarObligDetRubroCdp(obligDetRubroCdpVo.getOdrCodigo());
        
    }
        
    public List<ObligDetRubroCdpVO> buscarTodosObligDetRubroCdp() throws ExcepcionDAO{
        List<SiiObligDetRubroCdp> listaObligDetRubroCdp = obligDetRubroCdpDao.buscarTodosObligDetRubroCdp();
        List<ObligDetRubroCdpVO> listaObligacionDetRubroCdpVo = new ArrayList();
        for(SiiObligDetRubroCdp unaObligacionDetRubroCdp : listaObligDetRubroCdp){
            ObligDetRubroCdpVO nuevaObliDetRubroCdpVo = new ObligDetRubroCdpVO(unaObligacionDetRubroCdp);
        }
        return listaObligacionDetRubroCdpVo;
    }
}

