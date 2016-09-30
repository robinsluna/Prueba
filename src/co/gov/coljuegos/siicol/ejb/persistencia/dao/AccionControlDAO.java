package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAccionControl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class AccionControlDAO extends AbstractDAO<Long, SiiAccionControl> {
    public AccionControlDAO() {
        super(SiiAccionControl.class);
    }

    /**
     * Buscar Accion Control por id de resolución de decomiso y destrucción
     * @param rddCodigo
     * @return resultado - lista de acciones de control
     * @throws ExcepcionDAO
     */
    
    public List<SiiAccionControl> buscarAccionControlXIdResolucionDecomDest(Long rddCodigo) throws ExcepcionDAO {
        List<SiiAccionControl> resultado = null;

        if (rddCodigo != null) {
            try {

                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ac FROM SiiAccionControl ac ");
                sql.append("WHERE ac.siiResolucionDecomDest.rddCodigo = :rddCodigo");

                Query query = em.createQuery(sql.toString());
                query.setParameter("rddCodigo", rddCodigo);

                resultado = query.getResultList();

            } catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }

        return (resultado);
    }
    
    
    /**
     * Buscar Accion Control por id de resolución de decomiso y destrucción
     * @param acaCodigo
     * @return resultado - lista de acciones de control
     * @throws ExcepcionDAO
     */
    
    public SiiAccionControl buscarAccionControlXIdAutoComisorio(Long acaCodigo) throws ExcepcionDAO {
        SiiAccionControl resultado = null;

        if (acaCodigo != null) {
            try {

                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ac FROM SiiAccionControl ac ");
                sql.append("WHERE ac.siiAutoComisorioAccCon.acaCodigo = :acaCodigo");

                Query query = em.createQuery(sql.toString());
                query.setParameter("acaCodigo", acaCodigo);

                List<SiiAccionControl> lista = query.getResultList();
                if (lista!=null && !lista.isEmpty())
                    resultado = lista.get(0);

            } catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }

        return (resultado);
    }
    
    public SiiAccionControl buscarAccionControlXIdElementoRetiradoAcc(Long elrCodigo) throws ExcepcionDAO {
        SiiAccionControl resultado = null;

        if (elrCodigo != null) {
            try {

                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ac FROM SiiAccionControl ac ");
                sql.append("WHERE ac.siiAutoComisorioAccCon.elrCodigo = :elrCodigo");

                Query query = em.createQuery(sql.toString());
                query.setParameter("elrCodigo", elrCodigo);

                List<SiiAccionControl> lista = query.getResultList();
                if (lista!=null && !lista.isEmpty())
                    resultado = lista.get(0);

            } catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }

        return (resultado);
    }

    public List<SiiAccionControl> buscarTodaAccionControlPorCodigoDesc() throws ExcepcionDAO {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiAccionControl o ORDER BY o.accCodigo DESC");
            Query query = em.createQuery(sql.toString());
            return query.getResultList();            

        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
        }
    }

    public List<SiiAccionControl> buscarAccionesControlAprobadas() throws ExcepcionDAO {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiAccionControl o WHERE o.accEstado = 'A' ORDER BY o.accCodigo DESC");
            Query query = em.createQuery(sql.toString());
            return query.getResultList();            

        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
        }
    }

    /**
     * Buscar las acciones de control que tengan acta de hechos
     * @return
     * @throws ExcepcionDAO
     */
    
    public List<SiiAccionControl> buscarAccionControlConActaHechosDesc() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiAccionControl o ");
            sql.append(" WHERE o.accNumeroActa IS NOT NULL");
            sql.append(" ORDER BY o.accCodigo DESC");
            Query query = em.createQuery(sql.toString());
            return query.getResultList();

        } catch(PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
        }
    }
    
    /**
     * Buscar todas las acciones de control que no tengan proceso sancionatorio de ilegalidad
     * @return List - Lista de SiiAccionControl
     * @throws ExcepcionDAO
     */
    
    public List<SiiAccionControl> buscarTodaAccionControlSinProcesoSancIleg() throws ExcepcionDAO {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT ac");
            sql.append(" FROM SiiAccionControl ac");
            sql.append(" INNER JOIN SiiAutoComisorioAccCon acac");
            sql.append(" ON ac.siiAutoComisorioAccCon.acaCodigo = acac.acaCodigo");
            sql.append(" INNER JOIN SiiDenuncia den");
            sql.append(" ON acac.siiDenuncia.denCodigo = den.denCodigo");
            
            Query query = em.createQuery(sql.toString());
            return query.getResultList();

        } catch(PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
        }
    }
    
}
