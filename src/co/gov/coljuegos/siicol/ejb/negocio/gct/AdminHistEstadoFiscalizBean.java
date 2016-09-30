package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistEstadoFiscalizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoFiscaliz;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.HistEstadoFiscalizVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminHistEstadoFiscalizBean implements AdminHistEstadoFiscaliz {
    @EJB
    private HistEstadoFiscalizDAO histEstadoFiscalizDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    public AdminHistEstadoFiscalizBean() {

    }

    public List<HistEstadoFiscalizVO> buscarTodoHistEstadoFiscalizVo() throws ExcepcionDAO {
        List<HistEstadoFiscalizVO> histVo = new ArrayList<HistEstadoFiscalizVO>();
        for (SiiHistEstadoFiscaliz hist : histEstadoFiscalizDao.buscarTodo()) {
            histVo.add(new HistEstadoFiscalizVO(hist));
        }
        return histVo;
    }

    public HistEstadoFiscalizVO insertarHistEstadoFiscaliz(HistEstadoFiscalizVO histEstadoFiscalizVo) throws ExcepcionDAO {
        return new HistEstadoFiscalizVO(histEstadoFiscalizDao.insertar(conversionVoEntidad.convertir(histEstadoFiscalizVo)));
    }

    public List<HistEstadoFiscalizVO> buscarHistEstadoFiscalizPorFiscaliz(Long fsuCodigo) throws ExcepcionDAO {
        List<HistEstadoFiscalizVO> histVo = new ArrayList<HistEstadoFiscalizVO>();
        for (SiiHistEstadoFiscaliz hist : histEstadoFiscalizDao.buscarHistEstadoFiscalizPorFiscaliz(fsuCodigo)) {
            histVo.add(new HistEstadoFiscalizVO(hist));
        }
        return histVo;
    }
}
