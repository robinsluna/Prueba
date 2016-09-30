package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoElemenIlegalidadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoElemenIlegalidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoElemenIlegalidadVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public  class AdminElemenIlegalidadBean implements AdminElemenIlegalidad {
    @EJB
    private TipoElemenIlegalidadDAO elemenIlegalidadDao;

    public AdminElemenIlegalidadBean() {
        
    }

    public List<TipoElemenIlegalidadVO> buscarTodoTipoElementoIlegalidad() throws ExcepcionDAO {
        List<TipoElemenIlegalidadVO> tiposElemenIlegalidadVo = new ArrayList<TipoElemenIlegalidadVO>();
        for (SiiTipoElemenIlegalidad tipoElemen :elemenIlegalidadDao.buscarTodo()) {
            tiposElemenIlegalidadVo.add(new TipoElemenIlegalidadVO(tipoElemen));
        }
        return tiposElemenIlegalidadVo;
    }
}
