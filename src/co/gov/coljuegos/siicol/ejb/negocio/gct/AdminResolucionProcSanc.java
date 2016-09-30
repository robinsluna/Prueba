package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionProcSancVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Resoluciones de Proceso Sancionatorio
 * @author Camilo Miranda
 */
@Local
public interface AdminResolucionProcSanc 
{
    public ResolucionProcSancVO buscarResolucionProcSancPorCodigo (Long repCodigo) throws ExcepcionDAO;
    public List<ResolucionProcSancVO> buscarTodaResolucionProcSanc () throws ExcepcionDAO;
    public ResolucionProcSancVO insertarResolucionProcSanc (ResolucionProcSancVO resolucionProcSancVo) throws ExcepcionDAO;
    public ResolucionProcSancVO insertarResolucionProcSanc (ResolucionProcSancVO resolucionProcSancVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public ResolucionProcSancVO actualizarResolucionProcSanc (ResolucionProcSancVO resolucionProcSancVo) throws ExcepcionDAO;
    public ResolucionProcSancVO actualizarResolucionProcSanc (ResolucionProcSancVO resolucionProcSancVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public void eliminarResolucionProcSanc (Long repCodigo) throws ExcepcionDAO;
}
