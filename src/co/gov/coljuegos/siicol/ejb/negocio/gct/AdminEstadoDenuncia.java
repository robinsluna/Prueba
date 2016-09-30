package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDenunciaVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstadoDenuncia {
    
    public List<EstadoDenunciaVO> buscarTodos() throws ExcepcionDAO;
    public EstadoDenunciaVO buscarEstadoPorNombre(String estado) throws ExcepcionDAO;
}
