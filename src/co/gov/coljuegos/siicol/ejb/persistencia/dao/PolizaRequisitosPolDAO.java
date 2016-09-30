package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaRequisitosPol;
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
public class PolizaRequisitosPolDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public PolizaRequisitosPolDAO() {
        recursos = new Recursos();

    }

    public SiiPolizaRequisitosPol buscarPolizaRequisitosPolPorCodigo(Long prpCodigo) throws ExcepcionDAO {
        SiiPolizaRequisitosPol localPolizaRequisitosPol = null;
        try {
            localPolizaRequisitosPol = (SiiPolizaRequisitosPol) manager.find(SiiPolizaRequisitosPol.class, prpCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "PolizaRequisitosPol");
        }
        return localPolizaRequisitosPol;
    }

    public SiiPolizaRequisitosPol insertarPolizaRequisitosPol(SiiPolizaRequisitosPol polizaRequisitosPol) throws ExcepcionDAO {
        try {
            manager.persist(polizaRequisitosPol);
            manager.flush();
            return polizaRequisitosPol;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " " + pe.getMessage(), "PolizaRequisitosPolDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "PolizaRequisitosPolDAO");
        }

    }

    public SiiPolizaRequisitosPol actualizarPolizaRequisitosPol(SiiPolizaRequisitosPol polizaRequisitosPol) throws ExcepcionDAO {
        try {
            manager.merge(polizaRequisitosPol);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "PolizaRequisitosPolDAO");
        }
        return polizaRequisitosPol;
    }    
    
    /**
     * Se encarga de devolver todas los requisitos 
     * @author Giovanni
     * @param idPolizaCont
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiPolizaRequisitosPol> buscarPolizaRequisitosXPolizaCont(Long idPolizaCont) throws ExcepcionDAO {
        List<SiiPolizaRequisitosPol> siiPolizaRequisitosPols = new ArrayList<SiiPolizaRequisitosPol>();  
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT prp FROM SiiPolizaRequisitosPol prp");
            sql.append(" WHERE prp.siiPolizaContrat.pccCodigo = :idPolizaCont");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPolizaCont", idPolizaCont);

            siiPolizaRequisitosPols = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "PolizaRequisitosPolDAO");
        }
        return siiPolizaRequisitosPols;
    }

}
