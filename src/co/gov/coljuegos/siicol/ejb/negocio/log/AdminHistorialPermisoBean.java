package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistorialPermisoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistorialPermiso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistorialRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminHistorialPermisoBean implements AdminHistorialPermiso {
    
    @EJB
    RolDAO rolDao;
    @EJB
    HistorialPermisoDAO historialPermisoDao;
    
    public AdminHistorialPermisoBean() {
    }
    
    public void registarDesasignacionPermiso(SiiHistorialRol siiHistorialRol, SiiPermisoRolModulo siiPermisoRolModulo, SiiUsuario siiUsuarioConec) throws ExcepcionDAO {
        //buscamos los usuarios asignados al rol
        List<SiiUsuario> listaSiiUsuario = rolDao.buscarUsuariosPorRol(siiHistorialRol.getSiiRol().getRolCodigo());
        if(listaSiiUsuario != null && listaSiiUsuario.size() > 0){
            for(SiiUsuario siiUsuario : listaSiiUsuario){
                SiiHistorialPermiso siiHistorialPermiso = new SiiHistorialPermiso();
                siiHistorialPermiso.setSiiHistorialRol(siiHistorialRol);
                siiHistorialPermiso.setSiiModulo(siiPermisoRolModulo.getSiiModulo1());
                siiHistorialPermiso.setSiiPermiso(siiPermisoRolModulo.getSiiPermiso());
                siiHistorialPermiso.setSiiUsuario(siiUsuario);
                siiHistorialPermiso.setSiiUsuarioConec(siiUsuarioConec);
                siiHistorialPermiso.setHipActivo("N");
                historialPermisoDao.insertar(siiHistorialPermiso);
            }
        }
    }
    
    public void registarAsignacionPermiso(SiiHistorialRol siiHistorialRol, SiiPermisoRolModulo siiPermisoRolModulo, SiiUsuario siiUsuarioConec) throws ExcepcionDAO {
        //buscamos los usuarios asignados al rol
        List<SiiUsuario> listaSiiUsuario = rolDao.buscarUsuariosPorRol(siiHistorialRol.getSiiRol().getRolCodigo());
        if(listaSiiUsuario != null && listaSiiUsuario.size() > 0){
            for(SiiUsuario siiUsuario : listaSiiUsuario){
                SiiHistorialPermiso siiHistorialPermiso = new SiiHistorialPermiso();
                siiHistorialPermiso.setSiiHistorialRol(siiHistorialRol);
                siiHistorialPermiso.setSiiModulo(siiPermisoRolModulo.getSiiModulo1());
                siiHistorialPermiso.setSiiPermiso(siiPermisoRolModulo.getSiiPermiso());
                siiHistorialPermiso.setSiiUsuario(siiUsuario);
                siiHistorialPermiso.setSiiUsuarioConec(siiUsuarioConec);
                siiHistorialPermiso.setHipActivo("S");
                historialPermisoDao.insertar(siiHistorialPermiso);
            }
        }
    }
}
