package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoAnulaAccContVO;

import java.util.List;

public interface AdminMotivoAnulaAccCont {
    public List<MotivoAnulaAccContVO> buscarTodosMotivos() throws ExcepcionDAO;
}
