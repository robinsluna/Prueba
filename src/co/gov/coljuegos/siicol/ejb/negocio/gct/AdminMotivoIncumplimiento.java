package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncumplimientoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminMotivoIncumplimiento {
    public List<MotivoIncumplimientoVO> motivosTipo(String tipo) throws ExcepcionDAO;
    public List<MotivoIncumplimientoVO>  listaMotivos()  throws ExcepcionDAO;
}
