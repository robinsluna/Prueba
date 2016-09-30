package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioResolDesis;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class InventarioResolDesisDAO extends AbstractDAO<Long, SiiInventarioResolDesis> {
    
    public InventarioResolDesisDAO() {
        super(SiiInventarioResolDesis.class);
    }
    
    
    public List<SiiInventarioResolDesis> buscarInventarioResolDesisPorIdResolucionDesisSolAut (Long rdsCodigo) throws ExcepcionDAO {
        List<SiiInventarioResolDesis> resultado = null;
        
        if (rdsCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ird FROM SiiInventarioResolDesis ird ");
                sql.append("WHERE ird.siiResolucionDesisSolAut.rdsCodigo = :rdsCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("rdsCodigo", rdsCodigo);
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return resultado;
    }
}