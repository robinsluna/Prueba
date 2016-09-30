package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermiso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class PermisoRolModuloDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    
    private Recursos recursos;
    
    public PermisoRolModuloDAO() {
        recursos = new Recursos();
    }
    
    public SiiPermisoRolModulo insertarPermisoRolModulo(SiiPermisoRolModulo permisoRolModulo) throws ExcepcionDAO{
        try{
            manager.persist(permisoRolModulo);                                                                                
            manager.flush();                                                                                               
            return permisoRolModulo;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"PermisoRolModuloDAO");
        }
    }
    
    public SiiPermisoRolModulo buscarPermisoRolModuloPorId(Long idPRM) throws ExcepcionDAO{
        SiiPermisoRolModulo siiPRMRetorno = null;
        try{
            siiPRMRetorno = (SiiPermisoRolModulo) manager.find(SiiPermisoRolModulo.class,idPRM);
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModuloDAO");
        }
        return siiPRMRetorno;
    }
    
    public SiiPermisoRolModulo buscarPermisoRolModuloPorPadres(SiiPermisoRolModulo permisoRolModulo) throws ExcepcionDAO{
        List<SiiPermisoRolModulo> listaPermisoRolModulo = null;
        SiiPermisoRolModulo permisoRolModuloRetorno = null;
        try{            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT prm FROM SiiPermisoRolModulo prm");
            sql.append(" WHERE prm.siiPermiso.pmsCodigo = :idPermiso");
            sql.append(" AND prm.siiRol.rolCodigo = :idRol");
            sql.append(" AND prm.siiModulo1.modCodigo = :idModulo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPermiso", permisoRolModulo.getSiiPermiso().getPmsCodigo());
            query.setParameter("idRol", permisoRolModulo.getSiiRol().getRolCodigo());
            query.setParameter("idModulo", permisoRolModulo.getSiiModulo1().getModCodigo());
            listaPermisoRolModulo = query.getResultList();      
        }catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"PermisoRolModuloDAO");            
        }
        if(listaPermisoRolModulo != null && listaPermisoRolModulo.size()>0){
            permisoRolModuloRetorno = listaPermisoRolModulo.get(0);
        }
        return permisoRolModuloRetorno;
    }
    
    public void borrarPermisoRolModulo(Long idPermisoRolModulo) throws ExcepcionDAO{
        SiiPermisoRolModulo siiPermisoRolModuloBorrar = null;
        try {
            siiPermisoRolModuloBorrar = manager.find(SiiPermisoRolModulo.class, idPermisoRolModulo);
            manager.remove(siiPermisoRolModuloBorrar);                                               
            manager.flush();  
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"PermisoRolModuloDAO");
        }
    }
    
    public List<SiiPermisoRolModulo> buscarPermisoRolModuloPorRol(Long idRol) throws ExcepcionDAO{
        List<SiiPermisoRolModulo> listaPRM = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT prm FROM SiiPermisoRolModulo prm");
            sql.append(" INNER JOIN prm.siiRol rol");
            sql.append(" WHERE rol.rolCodigo = :idRol");
            sql.append(" ORDER BY prm.siiModulo1.modCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idRol", idRol);
            listaPRM = query.getResultList();
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return listaPRM;
    }
    
}
