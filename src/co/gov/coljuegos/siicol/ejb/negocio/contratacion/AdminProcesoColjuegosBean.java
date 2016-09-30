package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoColjuegosDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoColjuegosVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminProcesoColjuegosBean implements AdminProcesoColjuegos {
    
    @Resource
    SessionContext sessionContext;
    
    @EJB
    ProcesoColjuegosDAO procesoColjuegosDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminProcesoColjuegosBean() {
    }
    
    public ProcesoColjuegosVO insertarProcesoColjuegos(ProcesoColjuegosVO procesoColjuegosVo) throws ExcepcionDAO{
        SiiProcesoColjuegos procesoColjuegos = conversionVoEntidad.convertir(procesoColjuegosVo);
        SiiProcesoColjuegos unProcesoColjuegos = procesoColjuegosDao.insertarProcesoColjuegos(procesoColjuegos);
        return new ProcesoColjuegosVO(unProcesoColjuegos) ;
    }
    
    public ProcesoColjuegosVO buscarProcesoColjuegosPorId(ProcesoColjuegosVO procesoColjuegosVo) throws ExcepcionDAO{
        SiiProcesoColjuegos unProcesoColjuegos = procesoColjuegosDao.buscarProcesoColjuegosPorId(procesoColjuegosVo.getPcoCodigo());
        return new ProcesoColjuegosVO(unProcesoColjuegos);        
    }
    
    public ProcesoColjuegosVO actualizarProcesoColjuegos(ProcesoColjuegosVO procesoColjuegosVo) throws ExcepcionDAO{
        SiiProcesoColjuegos procesoColjuegos =  conversionVoEntidad.convertir(procesoColjuegosVo);
        SiiProcesoColjuegos unProcesoColjuegos = procesoColjuegosDao.actualizarProcesoColjuegos(procesoColjuegos);
        return new ProcesoColjuegosVO(unProcesoColjuegos);                
    }
    /*
    public void eliminarProcesoColjuegos(ProcesoColjuegosVO procesoColjuegosVo) throws ExcepcionDAO{
        SiiProcesoColjuegos unProcesoColjuegos = procesoColjuegosDao.eliminarProcesoColjuegos(procesoColjuegosVo.getPcoCodigo());               
    }
    */
    public List<ProcesoColjuegosVO> buscarProcesoColjuegosPorNombre(ProcesoColjuegosVO unProcesoColjuegosVo) throws ExcepcionDAO{
        SiiProcesoColjuegos procesoColjuegos;
        procesoColjuegos = conversionVoEntidad.convertir(unProcesoColjuegosVo);
        List<SiiProcesoColjuegos> listaProcesoColjuegos;
        listaProcesoColjuegos = procesoColjuegosDao.buscarProcesoColjuegosPorNombre(procesoColjuegos);
        List<ProcesoColjuegosVO> listaProcesoColjuegosVo;
        listaProcesoColjuegosVo = new ArrayList();
        for (SiiProcesoColjuegos unProcesoColjuegos : listaProcesoColjuegos){
            listaProcesoColjuegosVo.add(new ProcesoColjuegosVO(unProcesoColjuegos));
        }
        return listaProcesoColjuegosVo;
    }    
    
    public List<ProcesoColjuegosVO> buscarTodoProcesoColjuegos() throws ExcepcionDAO{
       // SiiProcesoColjuegos procesoColjuegos = conversionVoEntidad.convertir(procesoColjuegosVo);
        List<SiiProcesoColjuegos> listaProcesoColjuegos = procesoColjuegosDao.buscarTodoProcesoColjuegos();
        List<ProcesoColjuegosVO> listaProcesoColjuegosVo = new ArrayList();
        for (SiiProcesoColjuegos unProcesoColjuegos : listaProcesoColjuegos){
            listaProcesoColjuegosVo.add(new ProcesoColjuegosVO(unProcesoColjuegos));
        }
        return listaProcesoColjuegosVo;
    }
}
