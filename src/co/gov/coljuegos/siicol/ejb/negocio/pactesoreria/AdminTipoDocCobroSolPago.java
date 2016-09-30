package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocCobroSolPagoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoDocCobroSolPago 
{
    public List<TipoDocCobroSolPagoVO> buscarTodoTipoDocCobroSolPago() throws ExcepcionDAO;
    public TipoDocCobroSolPagoVO buscarTipoDocSopSolicPagoPorId(Long tspCodigo) throws ExcepcionDAO;
}
