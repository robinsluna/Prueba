package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaInteresDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteres;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TasaInteresVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTasaInteresBean implements AdminTasaInteres{
    @EJB
    private TasaInteresDAO tasaInteresDAO;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    public AdminTasaInteresBean() {
        super();
    }
    
    public TasaInteresVO buscarTasaInteresPorId (Long id) throws ExcepcionDAO{
        return new TasaInteresVO(tasaInteresDAO.buscarPorCodigo(id));
    }
    
    public TasaInteresVO insertarTasaInteres (TasaInteresVO tasaInteresVo) throws ExcepcionDAO{
        
        tasaInteresVo = new TasaInteresVO (tasaInteresDAO.insertar(conversionVoEntidad.convertir(tasaInteresVo)));
        return tasaInteresVo;
    }
    
    public List<TasaInteresVO> buscarTodoTasaInteres () throws ExcepcionDAO{
        List<SiiTasaInteres> listaTasaInteres = null;
        List<TasaInteresVO> listaTasaInteresVo = new ArrayList<TasaInteresVO>();
        listaTasaInteres = tasaInteresDAO.buscarTodo();
        
        for (SiiTasaInteres siiTasaInteres :listaTasaInteres){
            TasaInteresVO tasaInteresVo = new TasaInteresVO(siiTasaInteres);            
            listaTasaInteresVo.add(tasaInteresVo);
        }
        return listaTasaInteresVo;
    }
    
    public TasaInteresVO actualizarTasaInteres (TasaInteresVO tasaInteresVo) throws ExcepcionDAO{
        tasaInteresVo = new TasaInteresVO (tasaInteresDAO.actualizar(conversionVoEntidad.convertir(tasaInteresVo)));
        return tasaInteresVo;
    }
}
