package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminMes;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminMesBean;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MesDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.MetDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.MesVO;
import co.gov.coljuegos.siicol.ejb.vo.MetVO;

import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminMetBean implements AdminMet{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    MetDAO metDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    public AdminMetBean() {
    }


    public MetVO insertarMet(MetVO metVo) throws ExcepcionDAO {
        SiiMet met = conversionVoEntidad.convertir(metVo);
        SiiMet unaMet = metDao.insertarSiiMet(met);
        return new MetVO(unaMet);
    }
    
    public MetVO buscarMetPorNuc(String metVo) throws ExcepcionDAO{
        SiiMet siiMet = metDao.buscarMetPorNuc(metVo);
        return siiMet!=null?new MetVO(siiMet):null;
    }
    
    public MetVO modificarMet(MetVO metVO) throws ExcepcionDAO{
        SiiMet met = conversionVoEntidad.convertir(metVO);
        SiiMet siiMet = metDao.actualizarSiiMet(met);
        return new MetVO(siiMet);
    }
    
    public int buscarMetMarcadasPorContrato(String contrato, String nit) throws ExcepcionDAO {
        return metDao.buscarMetMarcadasPorContrato(contrato,nit);
    }
    
}
