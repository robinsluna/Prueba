package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorioAccCon;
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
public class AutoComisorioAccConDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public AutoComisorioAccConDAO() {
        recursos = new Recursos();
    }

    public SiiAutoComisorioAccCon insertarAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon) throws ExcepcionDAO {
        try {
            manager.persist(siiAutoComisorioAccCon);
            manager.flush();
            return siiAutoComisorioAccCon;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AutoComisorioAccConDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public SiiAutoComisorioAccCon buscaSiiAutoComisorioAccConPorId(Long idAutCodigo) throws ExcepcionDAO {
        SiiAutoComisorioAccCon siiAutoComisorioAccCon = null;
        try {
            siiAutoComisorioAccCon = manager.find(SiiAutoComisorioAccCon.class, idAutCodigo);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "AutoComisorioAccConDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return siiAutoComisorioAccCon;
    }

    public List<SiiAutoComisorioAccCon> buscarTodoAutoComisorioAcc() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT a FROM SiiAutoComisorioAccCon a  ");
            sql.append(" order by a.acaNumero desc ");
            Query query = manager.createQuery(sql.toString());

            List<SiiAutoComisorioAccCon> listaAutoComisorioAccCon = query.getResultList();
            return listaAutoComisorioAccCon;

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "AutoComisorioAccConDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public String siguienteNumeroAutoComisorioAcc() throws ExcepcionDAO {
        Integer i;
        String consecutivo = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT max(a.acaNumero) FROM SiiAutoComisorioAccCon a");
            Query query = manager.createQuery(sql.toString());
            i = (Integer) query.getSingleResult();
            if(i == null) {
                return "00";
            }
            else
                return consecutivo = Integer.toString(i + 1);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "AutoComisorioAccConDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

    }

    public SiiAutoComisorioAccCon actualizarAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon) throws ExcepcionDAO {
        try {
            manager.merge(siiAutoComisorioAccCon);
            manager.flush();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "AutoComisorioAccConDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiAutoComisorioAccCon;
    }


    public List<SiiAutoComisorioAccCon> buscarAutoComisorioAccPorDenuncia(Long denCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiAutoComisorioAccCon o WHERE o.siiDenuncia.denCodigo = :denCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("denCodigo", denCodigo);
            return query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "AutoComisorioAccConDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

    }
    
    public SiiAutoComisorioAccCon buscarUnAutoComisorioAccPorDenuncia(Long denCodigo) throws ExcepcionDAO {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiAutoComisorioAccCon o WHERE o.siiDenuncia.denCodigo = :denCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("denCodigo", denCodigo);
            List<SiiAutoComisorioAccCon> lista = query.getResultList();
            
            if (lista!=null && !lista.isEmpty())
                return lista.get(0);
            else return null;
            
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "AutoComisorioAccConDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
   


}
