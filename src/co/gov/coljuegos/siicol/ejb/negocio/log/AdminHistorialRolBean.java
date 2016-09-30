package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistorialPermisoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistorialRolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PermisoRolModuloDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistorialPermiso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistorialRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminHistorialRolBean implements AdminHistorialRol{
    
    @EJB
    PermisoRolModuloDAO permisoRolModuloDao;
    @EJB
    HistorialRolDAO historialRolDao;
    @EJB
    HistorialPermisoDAO historialPermisoDao;
    
    public AdminHistorialRolBean() {
    }
    
    public void registrarDesasignacionRol(SiiRol siiRol, SiiUsuario siiUsuario, SiiUsuario siiUsuarioConec) throws ExcepcionDAO{
        SiiHistorialRol siiHistorialRol = new SiiHistorialRol();
        siiHistorialRol.setHroFechaDesasigna(new Date());
        guardarHistorialRolConPermisos(siiRol, siiUsuario, siiUsuarioConec, siiHistorialRol, "N");
    }
    
    public void registrarAsignacionRol(SiiRol siiRol, SiiUsuario siiUsuario, SiiUsuario siiUsuarioConec) throws ExcepcionDAO{
        SiiHistorialRol siiHistorialRol = new SiiHistorialRol();
        siiHistorialRol.setHroFechaAsigna(new Date());
        guardarHistorialRolConPermisos(siiRol, siiUsuario, siiUsuarioConec, siiHistorialRol, "S");
    }
    
    private void guardarHistorialRolConPermisos(SiiRol siiRol, SiiUsuario siiUsuario, SiiUsuario siiUsuarioConec, SiiHistorialRol siiHistorialRol, String esActivo) throws ExcepcionDAO{
        //Buscamos los permisos del rol
        List<SiiPermisoRolModulo> listaSiiPermisoRolModulo = permisoRolModuloDao.buscarPermisoRolModuloPorRol(siiRol.getRolCodigo());
        siiHistorialRol.setSiiRol(siiRol);
        siiHistorialRol.setSiiUsuarioConec(siiUsuarioConec);
        siiHistorialRol.setHroFechaActInacPer(new Date());
        historialRolDao.insertar(siiHistorialRol);
        //Insertamos el historial de los permisos asignados o desasignados
        for(SiiPermisoRolModulo siiPermisoRolModulo : listaSiiPermisoRolModulo){
            SiiHistorialPermiso siiHistorialPermiso = new SiiHistorialPermiso();
            siiHistorialPermiso.setSiiHistorialRol(siiHistorialRol);
            siiHistorialPermiso.setSiiModulo(siiPermisoRolModulo.getSiiModulo1());
            siiHistorialPermiso.setSiiPermiso(siiPermisoRolModulo.getSiiPermiso());
            siiHistorialPermiso.setSiiUsuario(siiUsuario);
            siiHistorialPermiso.setSiiUsuarioConec(siiUsuarioConec);
            siiHistorialPermiso.setHipActivo(esActivo);
            historialPermisoDao.insertar(siiHistorialPermiso);
        }
    }
}
