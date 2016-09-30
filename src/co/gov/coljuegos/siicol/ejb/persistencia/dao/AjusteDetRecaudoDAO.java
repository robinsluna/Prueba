package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjusteDetRecaudo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class AjusteDetRecaudoDAO extends GenericDAO<SiiAjusteDetRecaudo>{
    public AjusteDetRecaudoDAO() {
        super(SiiAjusteDetRecaudo.class);
    }
    
    public List<SiiAjusteDetRecaudo> buscarAjusteDetRecaudoPorIdDetRecaudo(Long idDetRecaudo) throws ExcepcionDAO{
        List<SiiAjusteDetRecaudo> listaSiiAjusteDetRecaudo = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT adr FROM SiiAjusteDetRecaudo adr ");
            sql.append("WHERE adr.siiDetalleRecaudo.dreCodigo = :idDetRecaudo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("idDetRecaudo", idDetRecaudo);

            listaSiiAjusteDetRecaudo = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiAjusteDetRecaudo;
    }
}
