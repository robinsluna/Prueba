package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuenteFinanciacionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.MesDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;

import co.gov.coljuegos.siicol.ejb.vo.MesVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminMesBean implements AdminMes {
    @Resource
    SessionContext sessionContext;
    
    @EJB
    MesDAO mesDao;

    public AdminMesBean() {
    }
    
    public MesVO buscarMesPorId(MesVO mesVo) throws ExcepcionDAO {
        
        SiiMes siiMes = mesDao.buscarMesPorId(mesVo.getMesCodigo());
        return new MesVO(siiMes);
    }  
    
    public List<MesVO> buscarTodosMes() throws ExcepcionDAO {
        List<SiiMes> listaSiiMes = mesDao.buscarTodosMes();
        List<MesVO> listaMesVo = new ArrayList();
        for(SiiMes unaEntidadMes : listaSiiMes){
                MesVO nuevoMesVO = new MesVO(unaEntidadMes);
                listaMesVo.add(nuevoMesVO);
        }
        return listaMesVo;        
    }
}

/*
 *     
 */