package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioResolDesisVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminInventarioResolDesis {
    public InventarioResolDesisVO buscarInventarioResolDesisPorId (Long irdCodigo) throws ExcepcionDAO;
    public InventarioResolDesisVO insertarInventarioResolDesis (InventarioResolDesisVO inventarioResolDesisVo) throws ExcepcionDAO;
    public InventarioResolDesisVO actualizarInventarioResolDesis (InventarioResolDesisVO inventarioResolDesisVo) throws ExcepcionDAO;
    public void eliminarInventarioResolDesis (Long irdCodigo) throws ExcepcionDAO;
    public List<InventarioResolDesisVO> buscarTodoInventarioResolDesis() throws ExcepcionDAO;
    public List<InventarioResolDesisVO> buscarInventarioResolDesisPorIdResolucionDesisSolAut (Long rdsCodigo) throws ExcepcionDAO;
}
