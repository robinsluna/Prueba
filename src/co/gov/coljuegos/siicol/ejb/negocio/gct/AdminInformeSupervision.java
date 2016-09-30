package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.InformeSupervisionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminInformeSupervision {
    public List<InformeSupervisionVO> buscarInformesSupervision() throws ExcepcionDAO;
    public InformeSupervisionVO insertarInformeSupervision(InformeSupervisionVO informeSupervisionVo) throws ExcepcionDAO;
    public InformeSupervisionVO actualizarInformeSupervision(InformeSupervisionVO informeSupervisionVo) throws ExcepcionDAO;
    public List<InformeSupervisionVO> buscarInformesSupervision(Long usuCodigo) throws ExcepcionDAO;
    public InformeSupervisionVO aprobarInformeSupervision(InformeSupervisionVO informeSupervisionVo) throws ExcepcionDAO;
}
