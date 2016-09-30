package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstPrevDetRubroDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstPrevDetRubro;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstPrevDetRubroVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminEstPrevDetRubroBean implements AdminEstPrevDetRubro{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    EstPrevDetRubroDAO estPrevDetRubroDao;
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
        
    public AdminEstPrevDetRubroBean() {
                       
    }
    
    public EstPrevDetRubroVO buscarEstPrevDetRubroPorId(EstPrevDetRubroVO estPrevDetRubroVo) throws ExcepcionDAO{
        SiiEstPrevDetRubro estPrevDetRubro = conversionVoEntidad.convertir(estPrevDetRubroVo);
        SiiEstPrevDetRubro unEstPrevDetRubro = estPrevDetRubroDao.buscarEstPrevDetRubroPorId(estPrevDetRubro.getEpdCodigo());
        return new EstPrevDetRubroVO(unEstPrevDetRubro);
        }
           
    public EstPrevDetRubroVO insertarEstPrevDetRubro(EstPrevDetRubroVO estPrevDetRubroVo) throws ExcepcionDAO{
        SiiEstPrevDetRubro estPrevDetRubro = conversionVoEntidad.convertir(estPrevDetRubroVo);                     
        SiiEstPrevDetRubro unEstPrevDetRubro = estPrevDetRubroDao.insertarEstPrevDetRubro(estPrevDetRubro);
        return new EstPrevDetRubroVO(unEstPrevDetRubro);
        }
       
    public EstPrevDetRubroVO actualizarEstPrevDetRubro(EstPrevDetRubroVO estPrevDetRubroVo) throws ExcepcionDAO{
        SiiEstPrevDetRubro estPrevDetRubro = conversionVoEntidad.convertir(estPrevDetRubroVo);                     
        SiiEstPrevDetRubro unEstPrevDetRubro = estPrevDetRubroDao.actualizarEstPrevDetRubro(estPrevDetRubro);
        return new EstPrevDetRubroVO(unEstPrevDetRubro);
        }
       
    public List<EstPrevDetRubroVO> buscarTodosEstPrevDetRubro() throws ExcepcionDAO{
        List<SiiEstPrevDetRubro> listaEstPrevDetRubro;
        listaEstPrevDetRubro = estPrevDetRubroDao.buscarTodosEstPrevDetRubro();
        List<EstPrevDetRubroVO> listaEstPrevDetRubroVo = new ArrayList();
        for (SiiEstPrevDetRubro unEstPrevDetRubro : listaEstPrevDetRubro){
            listaEstPrevDetRubroVo.add(new EstPrevDetRubroVO(unEstPrevDetRubro));
        }
        return listaEstPrevDetRubroVo;
        }
    
    public List<EstPrevDetRubroVO> buscarEstPrevDetRubroPorIdEstPrevio (Long idEstPrevio) throws ExcepcionDAO{
        List<SiiEstPrevDetRubro> listaEstPrevDetRubro;
        listaEstPrevDetRubro = estPrevDetRubroDao.buscarEstPrevDetRubroPorIdEstPrevio(idEstPrevio);
        List<EstPrevDetRubroVO> listaEstPrevDetRubroVo =new ArrayList();
        for (SiiEstPrevDetRubro unEstPrevDetRubro : listaEstPrevDetRubro){
            listaEstPrevDetRubroVo.add(new EstPrevDetRubroVO(unEstPrevDetRubro));
        }
        return listaEstPrevDetRubroVo;
    }
    
    public void eliminarEstPrevDetRubro (EstPrevDetRubroVO estPrevDetRubroVo) throws ExcepcionDAO{
        estPrevDetRubroDao.eliminarEstPrevDetRubro(estPrevDetRubroVo.getEpdCodigo());
    }
}

