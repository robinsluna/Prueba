package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;

import java.util.List;

public interface AdminDetalleFinanc {
   
    public DetalleFinancVO insertarSiiDetalleFinanc(DetalleFinancVO detalleFinancVo) throws ExcepcionDAO;
    public DetalleFinancVO actualizarSiiDetalleFinanc(DetalleFinancVO detalleFinanc) throws ExcepcionDAO;
    public void borrarSiiDetalleFinanc(Long idCodigoDetalleFinanc) throws ExcepcionDAO;    
    public List<DetalleFinancVO> buscarTodoSiiDetalleFinanc() throws ExcepcionDAO;
    public DetalleFinancVO buscarDetalleFinancPorCodigo(Long idCodigoDetFinanc)  throws ExcepcionDAO;    
    public DetalleFinancVO buscarDetalleFinancPorPersona(Long perCodigo) throws ExcepcionDAO;
    
    /**
     * @author Giovani 
     * @param perCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public List<DetalleFinancVO> buscarDetallesFinancierosXPersona(Long perCodigo) throws ExcepcionDAO;
}
