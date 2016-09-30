package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ParametrosSistemaVO;

import javax.ejb.Local;

@Local
public interface AdminParametrosSistema {
    
    public ParametrosSistemaVO buscarParametroPorId(String Id) throws ExcepcionDAO;
    public String buscarCadenaParametroPorId(String Id);
}
