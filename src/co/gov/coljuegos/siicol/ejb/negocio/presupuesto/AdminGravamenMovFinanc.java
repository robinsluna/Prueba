package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.GravamenMovFinancVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminGravamenMovFinanc {
    public List<GravamenMovFinancVO> buscarGravamenMovFinancPorEstado (String estadoGravamenMovFinanc) throws ExcepcionDAO;
    public GravamenMovFinancVO buscarGravamenMovFinancPorId (Long idGravamenMovFinanc) throws ExcepcionDAO;
}
