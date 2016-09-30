package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoAmparoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoAmparo {
    public TipoAmparoVO buscarTipoAmparoPorId(Long idAmparo) throws ExcepcionDAO;
    public TipoAmparoVO insertarTipoAmparo(TipoAmparoVO tipoAmparoVo) throws ExcepcionDAO;
    public List<TipoAmparoVO> buscarTodosTipoAmparo() throws ExcepcionDAO;
    public List<TipoAmparoVO> buscarTipoAmparoPorNombre(TipoAmparoVO tipoAmparoVo) throws ExcepcionDAO;
}

