package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ResolucionIncumContrVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Resoluciones de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Local
public interface AdminResolucionIncumContr 
{
    public ResolucionIncumContrVO buscarResolucionIncumContrPorId (Long rcoCodigo) throws ExcepcionDAO;
    public ResolucionIncumContrVO insertarResolucionIncumContr (ResolucionIncumContrVO resolucionIncumContrVo) throws ExcepcionDAO;
    public ResolucionIncumContrVO insertarResolucionIncumContr(ResolucionIncumContrVO resolucionIncumContrVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public ResolucionIncumContrVO actualizarResolucionIncumContr (ResolucionIncumContrVO resolucionIncumContrVo) throws ExcepcionDAO;
    public ResolucionIncumContrVO actualizarResolucionIncumContr(ResolucionIncumContrVO resolucionIncumContrVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public void borrarResolucionIncumContr (Long rcoCodigo) throws ExcepcionDAO;
    public List<ResolucionIncumContrVO> buscarTodaResolucionIncumContr () throws ExcepcionDAO;
    public List<ResolucionIncumContrVO> buscarResolucionIncumContrPorEstadoTramite (Long ersCodigo) throws ExcepcionDAO;
    public List<ResolucionIncumContrVO> buscarResolucionIncumContrPorEstadoTramEInterponeRecurso (Long ersCodigo, String rcoReponeRecurso) throws ExcepcionDAO;
}
