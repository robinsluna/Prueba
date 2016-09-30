package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AmparoPolContProvVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminAmparoPolContProv {
    public AmparoPolContProvVO insertarAmparoPolContProv (AmparoPolContProvVO amparoPolContProvVo) throws ExcepcionDAO;
    public AmparoPolContProvVO buscarAmparoPolContProvPorId (Long idAmparoPolContProv) throws ExcepcionDAO;
    public AmparoPolContProvVO actualizarAmparoPolContProv (AmparoPolContProvVO amparoPolContProvVo) throws ExcepcionDAO;
    public List<AmparoPolContProvVO> buscarTodoAmparoPolContProv () throws ExcepcionDAO;
    public List<AmparoPolContProvVO> buscarAmparoPolContProvPorIdPolizaContProv (Long idPolizaContProv) throws ExcepcionDAO;
}
