package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RevisFinancOtroSiVO;

import java.util.List;

public interface AdminRevisionFinanOtroSi {
    public List<RevisFinancOtroSiVO> buscarRevisionFinanPorOtroSi(Long osiCodigo, String rfoTipoValidac) throws ExcepcionDAO;
}
