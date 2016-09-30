package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncuInfSupervVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminMotivoIncuInfSuperv {
    public List<MotivoIncuInfSupervVO> buscarMotivoIncuPorInfSuper(Long isuCodigo) throws ExcepcionDAO;
}
