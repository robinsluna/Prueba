package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AdendaVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroCdpVO;

import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;

import java.util.List;

public interface AdminAdenda {
   
    public AdendaVO insertarSiiAdendaTdr(AdendaVO adendaVO) throws ExcepcionDAO;
    public AdendaVO actualizarSiiAdendaTdr(AdendaVO adendaVO) throws ExcepcionDAO;
    public void borrarAdendaTdr(Long idCodigoAdenda) throws ExcepcionDAO;   
    public List<AdendaVO> buscarAdendasPorCodigoProcesoContratacion (Integer idProcesoContratacion) throws ExcepcionDAO;
    public List<AdendaVO> buscarTodoSiiAdenda() throws ExcepcionDAO;
    public AdendaVO buscarPorCodigoAdenda(Long idCodigoAdenda)  throws ExcepcionDAO;
}
