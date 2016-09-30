package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoElemenIlegalidadVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminTipoElemenIlegalidad {
    public TipoElemenIlegalidadVO buscarTipoElemenIlegalidadPorId (Long teiCodigo) throws ExcepcionDAO;
    public List<TipoElemenIlegalidadVO> buscarTodoTipoElemenIlegalidad () throws ExcepcionDAO;
}
