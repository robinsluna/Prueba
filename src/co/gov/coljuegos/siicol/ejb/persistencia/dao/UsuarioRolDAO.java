package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuarioRol;
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
public class UsuarioRolDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public UsuarioRolDAO() {
        recursos = new Recursos();
    }
    
    public SiiUsuarioRol buscarUsuarioRolPorPadres(SiiUsuarioRol unSiiUsuarioRol) throws ExcepcionDAO{
        List<SiiUsuarioRol> listaUsuarioRol = null;
        SiiUsuarioRol usuarioRolRetorno = null;
        try{            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT uro FROM SiiUsuarioRol uro");
            sql.append(" WHERE uro.siiUsuario.usuCodigo = :idUsuario");
            sql.append(" AND uro.siiRol1.rolCodigo = :idRol");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idUsuario", unSiiUsuarioRol.getSiiUsuario().getUsuCodigo());
            query.setParameter("idRol", unSiiUsuarioRol.getSiiRol1().getRolCodigo());
            listaUsuarioRol = query.getResultList();      
        }catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"UsuarioRolDAO");            
        }
        if(listaUsuarioRol != null && listaUsuarioRol.size()>0){
            usuarioRolRetorno = listaUsuarioRol.get(0);
        }
        return usuarioRolRetorno;
    }
    
    public SiiUsuarioRol insertarUsuarioRol(SiiUsuarioRol siiUsuarioRol) throws ExcepcionDAO{
        try{
            manager.persist(siiUsuarioRol);                                                                                                //La guarda en el almacen
            manager.flush();                                                                                              //Retorna el VO
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"UsuarioRolDAO");
        }
        return siiUsuarioRol;
    }
    
    public List<SiiUsuarioRol> buscarUsuarioRolPorUsuario(Long idUsuario) throws ExcepcionDAO{
        List<SiiUsuarioRol> listaUsuarioRol = null;
        try{            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT uro FROM SiiUsuarioRol uro");
            sql.append(" WHERE uro.siiUsuario.usuCodigo = :idUsuario");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idUsuario", idUsuario);
            listaUsuarioRol = query.getResultList();      
        }catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"PermisoRolModuloDAO");            
        }
        return listaUsuarioRol;
    }
    
    public void borrarUsuarioRol(SiiUsuarioRol siiUsuarioRol) throws ExcepcionDAO{
        try{
            manager.remove(siiUsuarioRol);
            manager.flush();
        }catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"PermisoRolModuloDAO");            
        }
    }
}
