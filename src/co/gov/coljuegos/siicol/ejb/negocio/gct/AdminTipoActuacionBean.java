package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoActuacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoActuacion;
import co.gov.coljuegos.siicol.ejb.vo.TipoActuacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoActuacionBean implements AdminTipoActuacion  {
    @EJB
    private TipoActuacionDAO tipoActuacionDao;
    
    
    public AdminTipoActuacionBean() {
        
    }
    
    public List<TipoActuacionVO> buscarTodoTipoActuacion() throws ExcepcionDAO {
        List<TipoActuacionVO> tiposActuacionVo = new ArrayList<TipoActuacionVO>();
        for (SiiTipoActuacion tipo : tipoActuacionDao.buscarTodo()) {
            tiposActuacionVo.add(new TipoActuacionVO(tipo));
        }
        return tiposActuacionVo;
    }

    public TipoActuacionVO buscarTipoActuacionPorNombre(String tipoActuacion) throws ExcepcionDAO {
        return new TipoActuacionVO(tipoActuacionDao.buscarTipoActuacionPorNombre(tipoActuacion));
    }
    
    public TipoActuacionVO buscarTipoActuacionPorCodigo(Long tacCodigo) throws ExcepcionDAO {
        return new TipoActuacionVO(tipoActuacionDao.buscarPorCodigo(tacCodigo));
    }
}
