package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoElemenIlegalidadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoElemenIlegalidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoElemenIlegalidadVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminTipoElemenIlegalidadBean implements AdminTipoElemenIlegalidad {
    @EJB
    private TipoElemenIlegalidadDAO tipoElemenIlegalidadDao;
    
     
    public AdminTipoElemenIlegalidadBean() {
        super();
    }

    @Override
    public TipoElemenIlegalidadVO buscarTipoElemenIlegalidadPorId(Long teiCodigo) throws ExcepcionDAO {
        TipoElemenIlegalidadVO resultado = null;
        SiiTipoElemenIlegalidad siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarPorCodigo(teiCodigo);
        if (siiTipoElemenIlegalidad!=null)
            resultado = new TipoElemenIlegalidadVO(siiTipoElemenIlegalidad);
        
        return resultado;
    }
    
    
    @Override
    public List<TipoElemenIlegalidadVO> buscarTodoTipoElemenIlegalidad() throws ExcepcionDAO {
        List<TipoElemenIlegalidadVO> resultado = null;
        List<SiiTipoElemenIlegalidad> lista = tipoElemenIlegalidadDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<TipoElemenIlegalidadVO>();
            for (SiiTipoElemenIlegalidad siiTipoElemenIlegalidad: lista) {
                if (siiTipoElemenIlegalidad!=null) {
                    resultado.add(new TipoElemenIlegalidadVO(siiTipoElemenIlegalidad));
                }
            }
        }
        return resultado;
    }
}
