package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PermisoVO;

import javax.ejb.Local;

@Local
public interface AdminPermiso {
    public PermisoVO insertarPermiso(PermisoVO permisoVo) throws ExcepcionDAO;
}
