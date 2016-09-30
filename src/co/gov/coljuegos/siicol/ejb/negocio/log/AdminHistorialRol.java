package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import javax.ejb.Local;

@Local
public interface AdminHistorialRol {
    
    public void registrarDesasignacionRol(SiiRol siiRol, SiiUsuario siiUsuario, SiiUsuario siiUsuarioConec) throws ExcepcionDAO;
    public void registrarAsignacionRol(SiiRol siiRol, SiiUsuario siiUsuario, SiiUsuario siiUsuarioConec) throws ExcepcionDAO;
    
}
