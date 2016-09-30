package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AmparoEstPrevDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoEstPrev;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AmparoEstPrevVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminAmparoEstPrevBean implements AdminAmparoEstPrev{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    AmparoEstPrevDAO amparoEstPrevDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    
    public AdminAmparoEstPrevBean() {
    }
    
    public AmparoEstPrevVO buscarAmparoEstPrevPorId(AmparoEstPrevVO amparoEstPrevVo) throws ExcepcionDAO{
        SiiAmparoEstPrev amparoEstPrev = conversionVoEntidad.convertir(amparoEstPrevVo);
        SiiAmparoEstPrev unAmparoEstPrev = amparoEstPrevDao.buscarAmparoEstPrevPorId(amparoEstPrev.getAepCodigo());
        return new AmparoEstPrevVO(unAmparoEstPrev);
        }
        
    public AmparoEstPrevVO  insertarAmparoEstPrev (AmparoEstPrevVO  amparoEstPrevVo) throws ExcepcionDAO{
            SiiAmparoEstPrev amparoEstPrev = conversionVoEntidad.convertir(amparoEstPrevVo);
            SiiAmparoEstPrev unAmparoEstPrev = amparoEstPrevDao.insertarAmparoEstPrev(amparoEstPrev);
            return new AmparoEstPrevVO(unAmparoEstPrev);
        }
        
    public AmparoEstPrevVO actualizarAmparoEstPrev(AmparoEstPrevVO amparoEstPrevVo) throws ExcepcionDAO{
            SiiAmparoEstPrev amparoEstPrev = conversionVoEntidad.convertir(amparoEstPrevVo);
            SiiAmparoEstPrev unAmparoEstPrev = amparoEstPrevDao.actualizarAmparoEstPrev(amparoEstPrev);
            return new AmparoEstPrevVO(unAmparoEstPrev);
        }
        
    public List<AmparoEstPrevVO> buscarTodosAmparoEstPrev() throws ExcepcionDAO{
            List<SiiAmparoEstPrev> listaAmparoEstPrev = amparoEstPrevDao.buscarTodosAmparoEstPrev();
            List<AmparoEstPrevVO> listaAmparoEstPrevVo = new ArrayList();
            for (SiiAmparoEstPrev unAmparoEstPrev : listaAmparoEstPrev){
                listaAmparoEstPrevVo.add(new AmparoEstPrevVO(unAmparoEstPrev));
            }
            return listaAmparoEstPrevVo;
        }
    
    public List<AmparoEstPrevVO> buscarAmparoEstPrevPorIdEstPrevio (Long idEstPrevio) throws ExcepcionDAO{
        List<SiiAmparoEstPrev> listaAmparoEstPrev = amparoEstPrevDao.buscarAmparoEstPrevPorIdEstPrevio(idEstPrevio);
        List<AmparoEstPrevVO> listaAmparoEstPrevVo = new ArrayList();
        for (SiiAmparoEstPrev unAmparoEstPrev : listaAmparoEstPrev){
            listaAmparoEstPrevVo.add(new AmparoEstPrevVO(unAmparoEstPrev));
        }
        return listaAmparoEstPrevVo;
    }
    
    public void eliminarAmparoEstPrev (AmparoEstPrevVO amparoEstPrevVo) throws ExcepcionDAO{
        amparoEstPrevDao.eliminarAmparoEstPrev(amparoEstPrevVo.getAepCodigo());
    }
}

