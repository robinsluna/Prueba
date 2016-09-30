package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ReqEstudioPrevioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminReqEstudioPrevio {
    public ReqEstudioPrevioVO buscarReqEstudioPrevioPorId(ReqEstudioPrevioVO reqEstudioPrevioVo) throws ExcepcionDAO;        
    public ReqEstudioPrevioVO insertarReqEstudioPrevio(ReqEstudioPrevioVO reqEstudioPrevioVo) throws ExcepcionDAO;
    public ReqEstudioPrevioVO actualizarReqEstudioPrevio(ReqEstudioPrevioVO reqEstudioPrevioVo) throws ExcepcionDAO;
    public List<ReqEstudioPrevioVO> buscarTodosReqEstudioPrevio() throws ExcepcionDAO;
    public List<ReqEstudioPrevioVO> buscarReqEstudioPrevioPorEstudioPrevio(Long id) throws ExcepcionDAO;
    public void eliminarReqEstudioPrevio(ReqEstudioPrevioVO reqEstudioPrevioVo) throws ExcepcionDAO;
}
