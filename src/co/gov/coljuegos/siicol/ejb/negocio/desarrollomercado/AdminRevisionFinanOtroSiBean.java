package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionFinanOtroSiDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisFinancOtrosi;
import co.gov.coljuegos.siicol.ejb.vo.RevisFinancOtroSiVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRevisionFinanOtroSiBean implements AdminRevisionFinanOtroSi {
    @EJB
    RevisionFinanOtroSiDAO revisionFinanOtroSiDao;

    public List<RevisFinancOtroSiVO> buscarRevisionFinanPorOtroSi(Long osiCodigo,
                                                                  String rfoTipoValidac) throws ExcepcionDAO {
        List<RevisFinancOtroSiVO> revisionesVo = new ArrayList<RevisFinancOtroSiVO>();
        for (SiiRevisFinancOtrosi revision :
             revisionFinanOtroSiDao.buscarRevisionFinanPorOtroSi(osiCodigo, rfoTipoValidac)) {
            revisionesVo.add(new RevisFinancOtroSiVO(revision));

        }
        return revisionesVo;
    }
}
