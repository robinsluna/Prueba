package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoTasaInteresVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoTasaInteres {
    public List<TipoTasaInteresVO> buscarTodoTipoTasaInteres () throws ExcepcionDAO;
}
