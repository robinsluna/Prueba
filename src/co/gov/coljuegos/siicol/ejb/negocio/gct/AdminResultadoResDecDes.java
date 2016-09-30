package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ResultadoResDecDesVO;

import java.util.List;

import javax.ejb.Local;



@Local
public interface AdminResultadoResDecDes {
    
    
    
    public List<ResultadoResDecDesVO> buscarTodos() throws ExcepcionDAO;

    
}
