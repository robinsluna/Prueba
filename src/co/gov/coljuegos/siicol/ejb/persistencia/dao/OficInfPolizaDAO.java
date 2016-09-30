package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficInfPoliza;
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
public class OficInfPolizaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public OficInfPolizaDAO() {
        recursos = new Recursos();

    }

    public SiiOficInfPoliza buscarOficInfPolizaPorCodigo(Long oipCodigo) throws ExcepcionDAO {
        SiiOficInfPoliza oficio = null;
        try {
            oficio = (SiiOficInfPoliza) manager.find(SiiOficInfPoliza.class, oipCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OficInfPolizaDAO");
        }
        return oficio;

    }

    public SiiOficInfPoliza insertarOficInfPoliza(SiiOficInfPoliza oficInfPoliza) throws ExcepcionDAO {
        try {
            manager.persist(oficInfPoliza);
            manager.flush();
            return oficInfPoliza;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " " + pe.getMessage(), "OficInfPolizaDAO");
        }

    }

    public SiiOficInfPoliza actualizarOficInfPoliza(SiiOficInfPoliza oficInfPoliza) throws ExcepcionDAO {
        try {
            manager.merge(oficInfPoliza);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OficInfPolizaDAO");
        }
        return oficInfPoliza;
    }

    /**
     * @author Giovanni
     * @param codPolizaConcesion
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiOficInfPoliza> buscarOficInfPolizaXPolizaConcesion(Long codPolizaConcesion) throws ExcepcionDAO {
        List<SiiOficInfPoliza> siiOficInfPolizas = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT oip FROM SiiOficInfPoliza oip");
            sql.append(" WHERE oip.siiPolizaContrat.pccCodigo = :codPolizaConcesion");
            
            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codPolizaConcesion", codPolizaConcesion);

            siiOficInfPolizas = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OficInfPolizaDAO");
        }

        return siiOficInfPolizas;
    }
}


