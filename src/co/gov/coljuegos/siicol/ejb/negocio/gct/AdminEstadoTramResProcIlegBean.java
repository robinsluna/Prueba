package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTramResProcIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResProcIleg;
import co.gov.coljuegos.siicol.ejb.vo.EstadoTramResProcIlegVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoTramResProcIlegBean implements AdminEstadoTramResProcIleg{
    @EJB
    private EstadoTramResProcIlegDAO estadoTramResProcIlegDao;
    @Override
    public EstadoTramResProcIlegVO buscarEstadoTramResProcIlegPorCodigo(Long etrCodigo) throws ExcepcionDAO {
        EstadoTramResProcIlegVO resultado = null;
        SiiEstadoTramResProcIleg estadoTramResProcIleg = estadoTramResProcIlegDao.buscarPorCodigo(etrCodigo);
        if (estadoTramResProcIleg != null) {
            resultado = new EstadoTramResProcIlegVO(estadoTramResProcIleg);
        }
        return resultado;
    }

    @Override
    public List<EstadoTramResProcIlegVO> buscarTodoEstadoTramResProcIleg() throws ExcepcionDAO {
        List<EstadoTramResProcIlegVO> resultado = null;
        List<SiiEstadoTramResProcIleg> lista = estadoTramResProcIlegDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<EstadoTramResProcIlegVO>();
            for (SiiEstadoTramResProcIleg estado : lista ) {
                if (estado != null) {
                    resultado.add(new EstadoTramResProcIlegVO(estado));
                }
            }
        }
        return resultado;
    }
}
