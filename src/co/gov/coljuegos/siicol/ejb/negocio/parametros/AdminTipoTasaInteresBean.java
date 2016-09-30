package co.gov.coljuegos.siicol.ejb.negocio.parametros;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoTasaInteresDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoTasaInteres;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.TipoTasaInteresVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoTasaInteresBean implements AdminTipoTasaInteres{
    
    @EJB
    private TipoTasaInteresDAO  tipoTasaInteresDAO;
    
    
    public AdminTipoTasaInteresBean() {
        super();
    }
    
    public List<TipoTasaInteresVO> buscarTodoTipoTasaInteres () throws ExcepcionDAO{
        List<SiiTipoTasaInteres> listaTipoTasaInteres = null;
        List<TipoTasaInteresVO> listaTipoTasaInteresVo = new ArrayList<TipoTasaInteresVO>();
        listaTipoTasaInteres = tipoTasaInteresDAO.buscarTodo();
        
        for(SiiTipoTasaInteres siiTipoTasaInteres :listaTipoTasaInteres){
            TipoTasaInteresVO tipoTasaInteresVO = new TipoTasaInteresVO(siiTipoTasaInteres);
            listaTipoTasaInteresVo.add(tipoTasaInteresVO);
        }
        return listaTipoTasaInteresVo;
    }
}
