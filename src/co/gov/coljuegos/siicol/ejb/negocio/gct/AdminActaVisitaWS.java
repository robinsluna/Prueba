package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ActaVisitaVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ActaVisitaResponseWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ActaVisitaWSVO;

import java.util.List;

public interface  AdminActaVisitaWS {
    
    
    public ActaVisitaResponseWSVO registroActaVisita ( ActaVisitaWSVO actaVisitaWSVo) throws ExcepcionDAO,ExcepcionAplicacion ;
    public List<ActaVisitaVO> buscarActaVisitaPorAutoComisorio (Long aucCodigo) throws ExcepcionDAO;
    
}
