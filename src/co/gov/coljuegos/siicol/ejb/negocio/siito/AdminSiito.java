package co.gov.coljuegos.siicol.ejb.negocio.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoConsultaInvSiicol;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ConsultaInventarioWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.MovCargueInventarioWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminSiito {

    /**
     *Metodo encargado de consulta la tabla intermedia entre siicol y siito para traer el lista
     * de inventarios que tengan el numero siito y el codigo de movimiento
     * @param solicitudAutorizaWSVO
     * @return
     * @throws ExcepcionDAO
     */
    public List<MovCargueInventarioWSVO> consultarListaInventarioTablaIntermediaSiito(SolicitudAutorizaWSVO solicitudAutorizaWSVO) 
            throws ExcepcionDAO,Exception;

    public String insertarInventarioTablaIntermediaConsultaSiito(List<ConsultaInventarioWSVO> inventario, String acure) 
            throws ExcepcionDAO,Exception;

    public boolean insertarSiitoConsultaInvSiicol(SiitoConsultaInvSiicol entidad) throws ExcepcionDAO;
    
    public boolean insertarSiitoConsultaInvSiicol(List<SiiInventario> entidad) throws Exception,ExcepcionDAO;
    
    public boolean borrarInventarioSiicolASincronizar() throws ExcepcionDAO,Exception;


}
