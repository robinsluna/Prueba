/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 05-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.SustanciadorAuditorVO;

import java.util.List;

/**
 * Interface que gestiona los sustanciadores/auditores para las órdenes de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public interface AdminSustanciadorAuditor {
    public List<SustanciadorAuditorVO> buscarSustanciadoresAuditoresActivosOrdAlfa(Integer numFun) throws ExcepcionDAO;
    
    public List<SustanciadorAuditorVO> buscarTodoSustanciadorAuditor() throws ExcepcionDAO;
    
    public SustanciadorAuditorVO insertarSustanciadorAuditor(SustanciadorAuditorVO sustanciadorAuditorVo) throws ExcepcionDAO, ExcepcionAplicacion;
    
    public SustanciadorAuditorVO actualizarSustanciadorAuditor(SustanciadorAuditorVO sustanciadorAuditorVo) throws ExcepcionDAO;
}
