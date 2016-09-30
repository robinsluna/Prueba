package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AreaColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;

import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.AreaColjuegosVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;


@Stateless
public class AdminAreaColjuegosBean implements AdminAreaColjuegos {
    @Resource
    SessionContext sessionContext;

    @EJB
    AreaColjuegosDAO areaColjuegosDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminAreaColjuegosBean() {
        //super();
    }
    
    
    public AreaColjuegosVO buscarAreaColjuegosPorId(Long idAreaColjuegos) throws ExcepcionDAO {
        AreaColjuegosVO acjVo = null;
        SiiAreaColjuegos siiAreaColjuegos = areaColjuegosDao.buscarAreaColjuegosPorId(idAreaColjuegos);
        if (siiAreaColjuegos!=null)
            acjVo = new AreaColjuegosVO(siiAreaColjuegos);
        
        return (acjVo);
    }
    
    public AreaColjuegosVO buscarAreaColjuegosPorId(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO {
        SiiAreaColjuegos unAreaColjuegos = areaColjuegosDao.buscarAreaColjuegosPorId(areaColjuegosVo.getAcoCodigo());
        return new AreaColjuegosVO(unAreaColjuegos);
    }

    public AreaColjuegosVO insertarAreaColjuegos(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO {
        SiiAreaColjuegos areaColjuegos = conversionVoEntidad.convertir(areaColjuegosVo);
        areaColjuegos = areaColjuegosDao.insertarAreaColjuegos(areaColjuegos);
        return new AreaColjuegosVO(areaColjuegos);
    }

    public AreaColjuegosVO actualizarAreaColjuegos(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO {
        SiiAreaColjuegos areaColjuegos = conversionVoEntidad.convertir(areaColjuegosVo);
        areaColjuegos = areaColjuegosDao.actualizarAreaColjuegos(areaColjuegos);
        return new AreaColjuegosVO(areaColjuegos);
    }
/*
    public AreaColjuegosVO eliminarAreaColjuegos(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO {
        SiiAreaColjuegos areaColjuegos = conversionVoEntidad.convertir(areaColjuegosVo);
        SiiAreaColjuegos unAreaColjuegos = areaColjuegosDao.eliminarAreaColjuegos(areaColjuegos);
        AreaColjuegosVO areaColjuegosVoRetorno = AreaColjuegosVO.convertirEntidadAVO(unAreaColjuegos);
        return areaColjuegosVoRetorno;
    }
    */
    public List<AreaColjuegosVO> buscarTodoAreaColjuegos() throws ExcepcionDAO{
        List<SiiAreaColjuegos> listaAreaColjuegos = areaColjuegosDao.buscarTodoAreaColjuegos();
        List<AreaColjuegosVO> listaAreaColjuegosVo = new ArrayList();
        for (SiiAreaColjuegos unAreaColjuegos : listaAreaColjuegos){
            listaAreaColjuegosVo.add(new AreaColjuegosVO(unAreaColjuegos));
        }
        return listaAreaColjuegosVo;
    }
    public List<AreaColjuegosVO> buscarAreaColjuegosPorNombre(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO{
        List<SiiAreaColjuegos> listaAreaColjuegos = areaColjuegosDao.buscarAreaColjuegosPorNombre(conversionVoEntidad.convertir(areaColjuegosVo));
        List<AreaColjuegosVO> listaAreaColjuegosVo = new ArrayList();
        for (SiiAreaColjuegos unAreaColjuegos : listaAreaColjuegos){
            listaAreaColjuegosVo.add(new AreaColjuegosVO(unAreaColjuegos));
        }
        return listaAreaColjuegosVo;
    }
    
    public List<AreaColjuegosVO> buscarAreaColjuegosPorNombre(String acoNombre) throws ExcepcionDAO 
    {
        List<SiiAreaColjuegos> listaAreaColjuegos = areaColjuegosDao.buscarAreaColjuegosPorNombre(acoNombre);
        List<AreaColjuegosVO> listaAreaColjuegosVo = new ArrayList();
        for (SiiAreaColjuegos siiAreaColjuegos : listaAreaColjuegos){
            if (siiAreaColjuegos!=null)
                listaAreaColjuegosVo.add(new AreaColjuegosVO(siiAreaColjuegos));
        }
        return listaAreaColjuegosVo;
    }
    
    
    @Override
    public AreaColjuegosVO buscarAreaColjuegosPorAbreviatura (String acoAbreviatura) throws ExcepcionDAO 
    {
        AreaColjuegosVO resultado = null;
        SiiAreaColjuegos siiAreaColjuegos = areaColjuegosDao.buscarAreaColjuegosPorAbreviatura(acoAbreviatura);
        if (siiAreaColjuegos!=null)
            resultado = new AreaColjuegosVO(siiAreaColjuegos);
        
        return (resultado);
    }
}

