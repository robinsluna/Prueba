package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.GravamenMovFinancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGravamenMovFinanc;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.GravamenMovFinancVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminGravamenMovFinancBean implements  AdminGravamenMovFinanc{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    @EJB
    GravamenMovFinancDAO gravamenMovFinancDao;
    
    
    public AdminGravamenMovFinancBean() {        
    }
    
    
    public List<GravamenMovFinancVO> buscarGravamenMovFinancPorEstado (String estadoGravamenMovFinanc) throws ExcepcionDAO{
        List<SiiGravamenMovFinanc> listaGravamenMovFinanc = new ArrayList<SiiGravamenMovFinanc>();
        List<GravamenMovFinancVO> listaGravamenMovFinancVo = new ArrayList<GravamenMovFinancVO>();
        listaGravamenMovFinanc = gravamenMovFinancDao.buscarGravamenMovFinancPorEstado(estadoGravamenMovFinanc);
        for (SiiGravamenMovFinanc siiGravamenMovFinanc: listaGravamenMovFinanc){
            listaGravamenMovFinancVo.add(new GravamenMovFinancVO (siiGravamenMovFinanc));
        }
        return listaGravamenMovFinancVo;
    }
    
    public GravamenMovFinancVO buscarGravamenMovFinancPorId (Long idGravamenMovFinanc) throws ExcepcionDAO {
        SiiGravamenMovFinanc gravamenMovFinanc = gravamenMovFinancDao.buscarGravamenMovFinancPorId(idGravamenMovFinanc);
        return new GravamenMovFinancVO(gravamenMovFinanc);
    }

   
}

