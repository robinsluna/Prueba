/*
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 03-04-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaCtaBanco;
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
public class PersonaCtaBancoDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager entityManager;
    private Recursos recursos;

    /**
     * Realiza la b&uacute;squeda del registro por medio del c&oacute;digo de la Persona.
     * @param perCodigo
     * @return List of SiiPersonaCtaBanco
     * @throws ExcepcionDAO
     */
    public List<SiiPersonaCtaBanco> buscarPorCodigoPersona(Long perCodigo) throws ExcepcionDAO {
        recursos = new Recursos();
        List<SiiPersonaCtaBanco> resultado = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiPersonaCtaBanco o ");
            sql.append("WHERE o.siiPersona.perCodigo = :perCodigo ");

            Query query = entityManager.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);

            resultado = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }

        return (resultado);
    }

    /**
     * @auhtor Giovanni
     * @param siiPersonaCtaBanco
     * @throws ExcepcionDAO
     */
    public void insertarPersonaCtaBanco(SiiPersonaCtaBanco siiPersonaCtaBanco) throws ExcepcionDAO {
        recursos = new Recursos();
        try {
            entityManager.persist(siiPersonaCtaBanco);
            entityManager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "PersonaCtaBancoDAO");
        }
    }

    /**
     * @auhtor Giovanni
     * @param siiPersonaCtaBanco
     * @throws ExcepcionDAO
     */
    public void actualizarPersonaCtaBanco(SiiPersonaCtaBanco siiPersonaCtaBanco) throws ExcepcionDAO {
        recursos = new Recursos();
        try {
            entityManager.merge(siiPersonaCtaBanco);
            entityManager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "PersonaCtaBancoDAO");
        }
    }


    public SiiPersonaCtaBanco buscarPorCodigo(Long idPersonaCtaBanco) throws ExcepcionDAO {
        SiiPersonaCtaBanco siiPersonaCtaBanco = null;
        try {
            siiPersonaCtaBanco = (SiiPersonaCtaBanco) entityManager.find(SiiPersonaCtaBanco.class, idPersonaCtaBanco);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaCtaBancoDAO");
        }
        return siiPersonaCtaBanco;
    }

}
