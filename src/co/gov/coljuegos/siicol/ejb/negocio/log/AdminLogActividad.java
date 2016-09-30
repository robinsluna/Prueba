package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.Date;

import javax.ejb.Local;

@Local
public interface AdminLogActividad {
    void log(Date fecha, String idSesion, String permisoAcceso, String url, UsuarioVO usuarioVo);
}
