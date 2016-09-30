package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaAtiendeAcc;
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
public class PersonaAtiendeAccDAO extends AbstractDAO<Long, SiiPersonaAtiendeAcc> {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public PersonaAtiendeAccDAO() {
        super(SiiPersonaAtiendeAcc.class);
        recursos = new Recursos();
    }

    public SiiPersonaAtiendeAcc insertarSiiPersonaAtiendeAcc(SiiPersonaAtiendeAcc persona) throws ExcepcionDAO {
        if(persona.getPeaCodigo() == null) {
            persona.setPeaActivo("S");
            return insertar(persona);
        }
        else {
            SiiPersonaAtiendeAcc personaPrevia = this.buscarPorCodigo(persona.getPeaCodigo());
            personaPrevia.setPeaActivo("S");
            return actualizar(personaPrevia);

        }


    }

    public void eleminarSiiPersonaAtiendeAcc(SiiPersonaAtiendeAcc persona) throws ExcepcionDAO {
        try {
            SiiPersonaAtiendeAcc personaPrevia = buscarPorCodigo(persona.getPeaCodigo());
            personaPrevia.setPeaActivo("N");
            actualizar(personaPrevia);

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaAtiendeAccDAO");
        }

    }


    public List<SiiPersonaAtiendeAcc> buscarPersonaAtiendePorAccionControl(Long accCodigo) throws ExcepcionDAO {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiPersonaAtiendeAcc o ");
            sql.append("WHERE o.siiAccionControl.accCodigo = :accCodigo AND o.peaActivo='S'");

            Query query = em.createQuery(sql.toString());
            query.setParameter("accCodigo", accCodigo);

            return query.getResultList();

        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
        }

    }
}
