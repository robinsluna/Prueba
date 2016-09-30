package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaRequisitosPolVO;

import java.util.List;

import javax.ejb.Local;

@Local 

public interface AdminRequisitosPolizaPol {
    public List<PolizaRequisitosPolVO> buscarRequisitosPorPolizaContrat(Long pccCodigo) throws ExcepcionDAO;
}
