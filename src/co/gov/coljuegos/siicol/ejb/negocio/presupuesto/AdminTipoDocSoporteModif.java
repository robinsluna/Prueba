package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocSoporteModifVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoDocSoporteModif {
    public List<TipoDocSoporteModifVO> buscarTodosTipoDocSoporteModif() throws ExcepcionDAO;
    public TipoDocSoporteModifVO buscarTipoSoporteModifPorNombre(String tdmNombre) throws ExcepcionDAO;
    public TipoDocSoporteModifVO buscarTipoSoporteModifPorId(Long tdmCodigo) throws ExcepcionDAO;
}
