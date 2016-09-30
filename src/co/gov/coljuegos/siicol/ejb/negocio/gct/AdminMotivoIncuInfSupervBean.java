package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoIncuInfSupervDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoIncuInfSuperv;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncuInfSupervVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminMotivoIncuInfSupervBean implements AdminMotivoIncuInfSuperv {
    @EJB
    private MotivoIncuInfSupervDAO motivoIncuInfSupervDao;
    public List<MotivoIncuInfSupervVO> buscarMotivoIncuPorInfSuper(Long isuCodigo) throws ExcepcionDAO {
        List<MotivoIncuInfSupervVO> motivosIncVo = new ArrayList<MotivoIncuInfSupervVO>();
        for (SiiMotivoIncuInfSuperv motivoInc : motivoIncuInfSupervDao.buscarMotivoIncuPorInfSuper(isuCodigo)) {
            motivosIncVo.add(new MotivoIncuInfSupervVO(motivoInc));
        }
        return motivosIncVo;
    }
}
