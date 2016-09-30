package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AseguradoraVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminAseguradora {
    public List<AseguradoraVO> buscarTodaAseguradora() throws ExcepcionDAO;
    public AseguradoraVO buscarAseguradoraPorCodigo(Long aseCodigo) throws ExcepcionDAO;
}
