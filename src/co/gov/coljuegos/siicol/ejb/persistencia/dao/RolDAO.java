package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.RolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioRolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class RolDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public RolDAO() {
        recursos = new Recursos();
    }
    
    public SiiRol buscarRolPorId(Long idRol) throws ExcepcionDAO{
        SiiRol rolRetorno = null;
        try{
            rolRetorno = manager.find(SiiRol.class, idRol);            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return rolRetorno;
    }
    
    public SiiRol insertarRol(SiiRol siiRol) throws ExcepcionDAO{
        try{
            manager.persist(siiRol);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRol;
    }
    
    public SiiRol buscarRolPorNombre(String unRolNombre) throws ExcepcionDAO{
        SiiRol rolRetorno = null;
        try{
            List<SiiRol> listaRoles = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rol FROM SiiRol rol");
            sql.append(" WHERE rol.rolNombre = :unRolNombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("unRolNombre", unRolNombre);
            listaRoles = query.getResultList();
            if(listaRoles != null && listaRoles.size()>0){
                rolRetorno = listaRoles.get(0);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return rolRetorno;
    }
    
    public List<SiiRol> buscarTodosRoles() throws ExcepcionDAO{
        List<SiiRol> listaRoles = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT rol FROM SiiRol rol order by rol.rolNombre");
        Query query = manager.createQuery(sql.toString());
        listaRoles = query.getResultList();
        return listaRoles;
    }
    
    public SiiRol actualizarRol(SiiRol siiRol) throws ExcepcionDAO{
        try{
            manager.persist(siiRol);
            manager.flush();
            return siiRol;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    public List<RolVO> buscarTodosRolesConSinPermisoPorUsuario(Long idUsuario) throws ExcepcionDAO{
        List<RolVO> listaRoles = null;
        UsuarioVO usuarioVo = new UsuarioVO();
        usuarioVo.setUsuCodigo(idUsuario);
        try{            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUB0.ROL_CODIGO,SUB0.ROL_NOMBRE, URO.URO_CODIGO");
            sql.append(" FROM(");
            sql.append(" SELECT ROL.ROL_CODIGO,ROL.ROL_NOMBRE, USU.USU_CODIGO");
            sql.append(" FROM SII_USUARIO USU, SII_ROL ROL) SUB0");
            sql.append(" LEFT JOIN SII_USUARIO_ROL URO ON URO.USU_CODIGO = SUB0.USU_CODIGO AND URO.ROL_CODIGO = SUB0.ROL_CODIGO");
            sql.append(" LEFT JOIN SII_USUARIO USU ON USU.USU_CODIGO = SUB0.USU_CODIGO");
            sql.append(" WHERE USU.USU_CODIGO = #idUsuario");
            sql.append(" ORDER BY SUB0.ROL_NOMBRE");
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("idUsuario",idUsuario);
            
            List<Object[]> results = query.getResultList();
            if(results != null && results.size() > 0){
                listaRoles = new ArrayList<RolVO>();
                //RolVO rolVo = null;
                for (Object[] object : results) {
                    RolVO rolVo = new RolVO();
                    rolVo.setRolCodigo(((BigDecimal) object[0]).longValue());
                    rolVo.setRolNombre((String) object[1]);
                    if(object[2] != null){
                        rolVo.setSeleccionado(true);
                    }
                    UsuarioRolVO usuarioRolVo = new UsuarioRolVO();
                    usuarioRolVo.setRolVo(rolVo);
                    usuarioRolVo.setUsuarioVo(usuarioVo);
                    rolVo.setUsuarioRolVoList(new ArrayList<UsuarioRolVO>());
                    rolVo.getUsuarioRolVoList().add(usuarioRolVo);
                    listaRoles.add(rolVo);
                }     
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRoles;
    }
    

    
    public List<SiiRol> buscarUsuariosIdPorRol(Long idusuario) throws ExcepcionDAO {
        List<SiiRol> listaRol = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT ro FROM SiiUsuario u ");
            sql.append(" inner join u.siiUsuarioRolList ur   ");
            //sql.append(" inner join ur.siiUsuarioRol  r   ");
            sql.append(" inner join ur.siiRol1 ro ");
            sql.append(" WHERE  u.usuCodigo = :idusuario ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idusuario", idusuario);
            listaRol = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRol;
    }
    
    public List<SiiUsuario> buscarUsuariosPorRol(Long idRol) throws ExcepcionDAO {
        List<SiiUsuario> listaSiiUsuario = null;
        try {
            StringBuilder sql = new StringBuilder();
            //sql.append("SELECT usu FROM SiiUsuario usu ");
            sql.append("SELECT usu FROM SiiUsuarioRol uro");
            sql.append(" INNER JOIN uro.siiUsuario usu");
            //sql.append(" INNER JOIN uro.siiRol1 rol");
            sql.append(" WHERE uro.siiRol1.rolCodigo = :idRol");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idRol", idRol);
            listaSiiUsuario = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return listaSiiUsuario;
    }
    
    
}
