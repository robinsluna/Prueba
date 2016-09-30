package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.AmparoPolContProvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoPolContProv;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AmparoPolContProvVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminAmparoPolContProvBean  implements AdminAmparoPolContProv{
    @Resource
    SessionContext sessionContext;
    @EJB
    AmparoPolContProvDAO amparoPolContProvDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    public AdminAmparoPolContProvBean() {
        
    }
    
    public AmparoPolContProvVO insertarAmparoPolContProv (AmparoPolContProvVO amparoPolContProvVo) throws ExcepcionDAO{
        SiiAmparoPolContProv siiAmparoPolContProv = conversionVoEntidad.convertir (amparoPolContProvVo);
        siiAmparoPolContProv = amparoPolContProvDao.insertarAmparoPolContProv(siiAmparoPolContProv);
        return new AmparoPolContProvVO(siiAmparoPolContProv);
    }
    
    public AmparoPolContProvVO buscarAmparoPolContProvPorId (Long idAmparoPolContProv) throws ExcepcionDAO{
        SiiAmparoPolContProv siiAmparoPolContProcov = amparoPolContProvDao.buscarAmparoPolContProvPorId(idAmparoPolContProv);        
        return new AmparoPolContProvVO(siiAmparoPolContProcov);
    }
    
    public AmparoPolContProvVO actualizarAmparoPolContProv (AmparoPolContProvVO amparoPolContProvVo) throws ExcepcionDAO{
        SiiAmparoPolContProv siiAmparoPolContProv = conversionVoEntidad.convertir(amparoPolContProvVo);
        siiAmparoPolContProv = amparoPolContProvDao.actualizarAmparoPolContProv(siiAmparoPolContProv);
        return new AmparoPolContProvVO(siiAmparoPolContProv);
    }
    
    public List<AmparoPolContProvVO> buscarTodoAmparoPolContProv () throws ExcepcionDAO{
        List<SiiAmparoPolContProv>  listaAmparoPolContProv = new ArrayList<SiiAmparoPolContProv>();
        listaAmparoPolContProv = amparoPolContProvDao.buscarTodosAmparoPolContProv();
        List<AmparoPolContProvVO> listaAmparoPolContProvVo = new ArrayList();
        for(SiiAmparoPolContProv siiAmparoPolContProv : listaAmparoPolContProv){
            listaAmparoPolContProvVo.add(new AmparoPolContProvVO(siiAmparoPolContProv));
        }
        return listaAmparoPolContProvVo;
    }
    
    public List<AmparoPolContProvVO> buscarAmparoPolContProvPorIdPolizaContProv (Long idPolizaContProv) throws ExcepcionDAO{
        List<SiiAmparoPolContProv>  listaAmparoPolContProv = new ArrayList<SiiAmparoPolContProv>();
        listaAmparoPolContProv = amparoPolContProvDao.buscarAmparoPolContProvPorIdPolizaContProv(idPolizaContProv);
        List<AmparoPolContProvVO> listaAmparoPolContProvVo = new ArrayList();
        for(SiiAmparoPolContProv siiAmparoPolContProv : listaAmparoPolContProv){
            listaAmparoPolContProvVo.add(new AmparoPolContProvVO(siiAmparoPolContProv));
        }
        return listaAmparoPolContProvVo;
    }
    
    public void eliminarAmparoPolContProv (Long idAmparoPolContProv) throws ExcepcionDAO{
        
    }
}

