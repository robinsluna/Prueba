package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MedioDenunciaVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminMedioDenuncia {
    
  
    public List<MedioDenunciaVO> buscarTodos() throws ExcepcionDAO;
    
    
}
