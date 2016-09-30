/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ConcepInfExogenaVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminConcepInfExogena 
{
    public ConcepInfExogenaVO buscarPorCodigoConcepInfExogena (Long cieCodigo) throws ExcepcionDAO;
    public ConcepInfExogenaVO insertarConcepInfExogena (ConcepInfExogenaVO concepInfExogenaVO) throws ExcepcionDAO;
    public ConcepInfExogenaVO actualizarConcepInfExogena (ConcepInfExogenaVO concepInfExogenaVO) throws ExcepcionDAO;
    public void borrarConcepInfExogena (Long cieCodigo) throws ExcepcionDAO;
    public List<ConcepInfExogenaVO> buscarTodoConcepInfExogena () throws ExcepcionDAO;
}
