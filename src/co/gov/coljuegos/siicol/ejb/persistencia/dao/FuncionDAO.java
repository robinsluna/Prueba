package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuncion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

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

public class FuncionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public FuncionDAO() {
        recursos = new Recursos();
    }
    
    public SiiFuncion buscarFuncionPorId(Long idFuncion) throws ExcepcionDAO{
            SiiFuncion siiFuncionRetorno = null;
            try{
                siiFuncionRetorno = (SiiFuncion) manager.find(SiiFuncion.class, idFuncion);
            } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
            return siiFuncionRetorno;
        }

    
    public List<SiiFuncion> buscarTodoFuncion()
            throws ExcepcionDAO{
        List<SiiFuncion> listaFuncion = new ArrayList();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT fun FROM SiiFuncion fun order by fun.funNombre");
            Query query = manager.createQuery(sql.toString());
            listaFuncion = query.getResultList(); 
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaFuncion;
    }

    public List<SiiPersona> buscarFuncionarioPorFuncion(String funcion) throws ExcepcionDAO {
        List<SiiPersona> listaPersona = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT per FROM SiiUsuario usu JOIN usu.siiFuncion1 fun JOIN usu.siiPersona per " +
                "WHERE fun.funNombre LIKE :funcion AND usu.siiEstadoUsuario.eusNombre='ACTIVO'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("funcion", funcion);
            listaPersona = query.getResultList();                        
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaPersona;
    }
}
