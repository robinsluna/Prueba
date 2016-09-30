package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioAccConVO;

import javax.ejb.Local;


@Local
public interface AdminAutoComisorioAccCon {
    
    public AutoComisorioAccConVO buscarUnAutoComisorioAccPorDenuncia(Long denCodigo) throws ExcepcionDAO;
}
