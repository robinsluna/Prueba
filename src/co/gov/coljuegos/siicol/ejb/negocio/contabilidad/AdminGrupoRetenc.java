package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoRetencVO;

import java.util.List;

public interface AdminGrupoRetenc {
    public List<GrupoRetencVO> buscarTodoGrupoRetenc() throws ExcepcionDAO;
    public GrupoRetencVO buscarGrupoRetencPorCodigo(Long idGrupoRetenc) throws ExcepcionDAO;
}
