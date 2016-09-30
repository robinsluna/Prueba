package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminLogGeneral {
    public void log(Integer tipoLog, int severidad, String modulo, String mensaje, UsuarioVO usuarioVo);
    public void log(String modulo, String mensaje, UsuarioVO usuarioVo);
    public void logTiempo(Integer tipoLog, int severidad, String modulo, String mensaje, UsuarioVO usuarioVo, long tiempoEjec);
    public void logTiempo(String modulo, long tiempoEjec, String usuarioWebservice);
    public void logConsola(String textoLog);
    public List<String> buscarTodoModuloLogGeneral () throws ExcepcionDAO;
}
