package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionProcIlegVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminResolucionProcIleg  {
    public ResolucionProcIlegVO buscarResolucionProcSancPorCodigo (Long repCodigo) throws ExcepcionDAO;
    public List<ResolucionProcIlegVO> buscarTodaResolucionProcSanc () throws ExcepcionDAO;
    public ResolucionProcIlegVO insertarResolucionProcSanc (ResolucionProcIlegVO resolucionVo) throws ExcepcionDAO;
    public ResolucionProcIlegVO insertarResolucionProcSanc (ResolucionProcIlegVO resolucionVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public ResolucionProcIlegVO actualizarResolucionProcSanc (ResolucionProcIlegVO resolucionVo) throws ExcepcionDAO;
    public ResolucionProcIlegVO actualizarResolucionProcSanc (ResolucionProcIlegVO resolucionVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public void eliminarResolucionProcSanc (Long repCodigo) throws ExcepcionDAO;
}
