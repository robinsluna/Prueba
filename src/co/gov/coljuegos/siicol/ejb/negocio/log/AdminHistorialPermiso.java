package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistorialRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import javax.ejb.Local;

@Local
public interface AdminHistorialPermiso {
    public void registarDesasignacionPermiso(SiiHistorialRol siiHistorialRol, SiiPermisoRolModulo siiPermisoRolModulo, SiiUsuario siiUsuarioConec) throws ExcepcionDAO;
    public void registarAsignacionPermiso(SiiHistorialRol siiHistorialRol, SiiPermisoRolModulo siiPermisoRolModulo, SiiUsuario siiUsuarioConec) throws ExcepcionDAO;
}
