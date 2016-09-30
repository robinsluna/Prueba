package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionPersonaAtien;
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
public class DireccionPersonaAtienDAO extends AbstractDAO<Long, SiiDireccionPersonaAtien> {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public DireccionPersonaAtienDAO() {
        super(SiiDireccionPersonaAtien.class);
        recursos = new Recursos();
    }

    public List<SiiDireccionPersonaAtien> buscarDireccionesPorPersona(Long peaCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiDireccionPersonaAtien o WHERE o.siiPersonaAtiendeAcc.peaCodigo = :peaCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("peaCodigo", peaCodigo);
            return query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DireccionPersonaAtienDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "DireccionPersonaAtienDAO");

        }
    }
    
    public SiiDireccionPersonaAtien insertarSiiDireccionPersonaAtien(SiiDireccionPersonaAtien direccion) throws ExcepcionDAO {
        if(direccion.getDpaCodigo() == null) {
            direccion.setDpaActivo("S");
            return insertar(direccion);
        }
        else {
            SiiDireccionPersonaAtien direccionPrevia = this.buscarPorCodigo(direccion.getDpaCodigo());
            direccionPrevia.setDpaActivo("S");
            return actualizar(direccionPrevia);

        }


    }

    public void eleminarSiiDireccionPersonaAtien(SiiDireccionPersonaAtien direccion) throws ExcepcionDAO {
        try {
            SiiDireccionPersonaAtien direccionPrevia = buscarPorCodigo(direccion.getDpaCodigo());
            direccionPrevia.setDpaActivo("N");
            actualizar(direccionPrevia);

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DireccionPersonaAtienDAO");
        }

    }

}
