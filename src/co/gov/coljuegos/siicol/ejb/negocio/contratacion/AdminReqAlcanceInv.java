package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ReqAlcanceInvVO;

import java.util.List;

import javax.ejb.Local;

@Local 
public interface AdminReqAlcanceInv {
    public ReqAlcanceInvVO buscarReqAlcanceInvPorId(Long id) throws ExcepcionDAO;
    public List<ReqAlcanceInvVO> buscarReqAlcanceInvPorAlcanceInv(Long id) throws ExcepcionDAO;
    public void eliminarReqAlcanceInv(ReqAlcanceInvVO reqAlcanceInvVo) throws ExcepcionDAO;
}
