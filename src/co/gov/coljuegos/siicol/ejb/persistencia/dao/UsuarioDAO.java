package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoUsuario;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean

public class UsuarioDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public UsuarioDAO() {
        recursos = new Recursos();
    }

    public SiiUsuario buscarUsuarioPorId(Long idUsuario) throws ExcepcionDAO {
        SiiUsuario siiUsuarioRetorno = null;
        try {
            siiUsuarioRetorno = (SiiUsuario) manager.find(SiiUsuario.class, idUsuario);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiUsuarioRetorno;
    }

    public SiiUsuario insertarUsuario(SiiUsuario siiUsuario) throws ExcepcionDAO {
        try {
            manager.persist(siiUsuario); //La guarda en el almacen
            manager.flush(); //Retorna el VO
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiUsuario;
    }

    public SiiUsuario actualizarUsuario(SiiUsuario siiUsuario) throws ExcepcionDAO {
        try {
            siiUsuario = manager.merge(siiUsuario);
            manager.flush();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiUsuario;
    }


    public List<SiiUsuario> buscarTodosUsuario() throws ExcepcionDAO {
        List<SiiUsuario> listaUsuario = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT usu FROM SiiUsuario usu where usu.usuUsuSistema is null or usu.usuUsuSistema = 'N' ORDER BY usu.usuNombreUsuario");
            Query query = manager.createQuery(sql.toString());
            listaUsuario = query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaUsuario;
    }

    public List<SiiUsuario> buscarTodoUsuarioConPersona() throws ExcepcionDAO {
        List<SiiUsuario> listaUsuario = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT usu FROM SiiUsuario usu where usu.siiPersona is not null ORDER BY usu.usuNombreUsuario");
            Query query = manager.createQuery(sql.toString());
            listaUsuario = query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaUsuario;
    }

    /**
     * @author Modifica Giovanni
     * @param unUsuario
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiUsuario> buscarUsuarioPorNombre(SiiUsuario unUsuario) throws ExcepcionDAO {
        List<SiiUsuario> usuarioRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT usuario FROM SiiUsuario usuario");
            sql.append(" WHERE usuario.usuNombreUsuario = :usuNombre");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("usuNombre", unUsuario.getUsuNombreUsuario());
            usuarioRetorno = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return usuarioRetorno;
    }

    public SiiUsuario buscarUsuarioPorLogin(String unUsuarioLogin) throws ExcepcionDAO {
        SiiUsuario usuarioRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT usuario FROM SiiUsuario usuario");
            sql.append(" WHERE usuario.usuNombreUsuario = :usuLogin");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("usuLogin", unUsuarioLogin.toUpperCase());
            List<SiiUsuario> listaUsuario = query.getResultList();
            if(listaUsuario != null && listaUsuario.size() > 0) {
                usuarioRetorno = listaUsuario.get(0);
            }
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return usuarioRetorno;
    }

    public SiiUsuario buscarUsuarioPorIdPersona(Long idPersona) throws ExcepcionDAO {
        SiiUsuario usuarioRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT usuario FROM SiiUsuario usuario");
            sql.append(" WHERE usuario.siiPersona.perCodigo = :idPersona");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPersona", idPersona);
            usuarioRetorno = (SiiUsuario) query.getSingleResult();
        }
        catch (NoResultException e) {
            usuarioRetorno = null;
        }
        catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return usuarioRetorno;
    }

    /**
     * @author Giovanni
     * @param idUsuario
     * @return
     * @throws ExcepcionDAO
     */
    public SiiUsuario buscarUsuarioXId(Long idUsuario) throws ExcepcionDAO {
        SiiUsuario usuarioRetorno = new SiiUsuario();
        try {
            usuarioRetorno = manager.find(SiiUsuario.class, idUsuario);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return usuarioRetorno;
    }


    /**
     * Realiza la b&uacute;squeda de los Usuarios <i>Activos</i> a partir del c&oacute;digo de la Funci&oacute;n.
     * @param idFuncion - C&oacute;digo de la Funci&oacute;n.
     * @return Listado de SiiUsuario
     */
    public List<SiiUsuario> buscarUsuariosPorIdFuncion(Long idFuncion) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT u FROM SiiUsuario u, ");
            sql.append("              SiiFuncion f ");
            sql.append("WHERE f.funCodigo = u.siiFuncion1.funCodigo ");
            sql.append("AND f.funCodigo = :idFuncion ");
            sql.append("AND u.siiEstadoUsuario.eusCodigo = :eusCodigo ");
            sql.append("order by u desc ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idFuncion", idFuncion);
            query.setParameter("eusCodigo", EnumEstadoUsuario.ACTIVO.getId());

            List<SiiUsuario> listaFR = query.getResultList();
            return listaFR;

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    /**
     * Realiza la b&uacute;squeda de los Usuarios <i>Activos</i> a partir del c&oacute;digo del &acuterea coljuegos.
     * @param idArea - C&oacute;digo de la Funci&oacute;n.
     * @return Listado de SiiUsuario
     */
    public List<SiiUsuario> buscarUsuariosPorIdArea(Long idArea) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT u FROM SiiUsuario u ");
            sql.append(" Inner Join u.siiAreaColjuegos1 a ");
            sql.append("WHERE a.acoCodigo = :idArea ");
            sql.append("AND u.siiEstadoUsuario.eusCodigo = :eusCodigo ");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("idArea", idArea);
            query.setParameter("eusCodigo", EnumEstadoUsuario.ACTIVO.getId());

            List<SiiUsuario> listaFR = query.getResultList();
            return listaFR;

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

}
