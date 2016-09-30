package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistEstadoSustanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoSustan;
import co.gov.coljuegos.siicol.ejb.vo.HistEstadoSustanVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminHistEstadoSustanBean implements AdminHistEstadoSustan {
    @EJB
    private HistEstadoSustanDAO histEstadoSustanDao;

    public AdminHistEstadoSustanBean() {
    }

    public List<HistEstadoSustanVO> buscarHistEstadoSustanPorSustan(Long suaCodigo) throws ExcepcionDAO {
        List<HistEstadoSustanVO> histVo = new ArrayList<HistEstadoSustanVO>();
        for (SiiHistEstadoSustan hist : histEstadoSustanDao.buscarHistEstadoSustanPorAuditor(suaCodigo,null)) {
            histVo.add(new HistEstadoSustanVO(hist));
        }
        return histVo;
    }
}
