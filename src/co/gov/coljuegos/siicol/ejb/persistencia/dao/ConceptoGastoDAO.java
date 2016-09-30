package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoGasto;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ConceptoGastoDAO extends GenericDAO<SiiConceptoGasto>{

    
    public ConceptoGastoDAO() {
        super(SiiConceptoGasto.class);
    }

    public List<SiiConceptoGasto> buscarTodoConceptoGasto() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiConceptoGasto o ");
            sql.append("ORDER BY o.cgaCodigoSiicol, o.cgaNombre ASC");
            Query query = em.createQuery(sql.toString());
            List<SiiConceptoGasto> listaConceptosGaston = query.getResultList();
            return listaConceptosGaston;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoGastoDAO");
        }
    }
    
    public SiiConceptoGasto buscarPorCodigo(Long idCodigo) throws ExcepcionDAO {
        SiiConceptoGasto conceptoGastoRetorno = null;
        try {
            conceptoGastoRetorno = em.find(SiiConceptoGasto.class, idCodigo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContableDAO");
        }
        return conceptoGastoRetorno;

    }
    
}
