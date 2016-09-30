/* 
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 14-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.BarrioOrdenVO;

import java.util.List;

/**
 * Interfaz para AdminBarrioOrdenBean
 * @author PAOLA ANDREA RUEDA LE�N
 */
public interface AdminBarrioOrden {
    public BarrioOrdenVO insertarBarrioOrden (BarrioOrdenVO barrioOrdenVo) throws ExcepcionDAO;
    public BarrioOrdenVO actualizarBarrioOrden (BarrioOrdenVO barrioOrdenVo) throws ExcepcionDAO;
    public List<BarrioOrdenVO> buscarBarrioOrdenXCodOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO;
}
