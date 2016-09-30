package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ActaSuspenAudIncumConVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Actas de Suspensi&oacute;n de la Audiencia en procesos de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Local
public interface AdminActaSuspenAudIncumCon 
{
    public ActaSuspenAudIncumConVO buscarActaSuspenAudPorCodigo (Long asaCodigo) throws ExcepcionDAO;
    public ActaSuspenAudIncumConVO insertarActaSuspenAud (ActaSuspenAudIncumConVO actaSuspenAudIncumConVo) throws ExcepcionDAO;
    public ActaSuspenAudIncumConVO actualizarActaSuspenAud (ActaSuspenAudIncumConVO actaSuspenAudIncumConVo) throws ExcepcionDAO;
    public void eliminarActaSuspenAudIncumCon (Long asaCodigo) throws ExcepcionDAO;
    public List<ActaSuspenAudIncumConVO> buscarTodaActaSuspenAud () throws ExcepcionDAO;
    public List<ActaSuspenAudIncumConVO> buscarActaSuspenAudPorIdIncumplimientoContr (Long icnCodigo) throws ExcepcionDAO;
}
