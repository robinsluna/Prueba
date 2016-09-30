package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSopSolicPago;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class TipoDocCobroSolPagoDAO extends GenericDAO<SiiTipoDocSopSolicPago> {
    
    /**
     * Constructor.
     */
    public TipoDocCobroSolPagoDAO() {
        super(SiiTipoDocSopSolicPago.class);
    }
    
    
    public List<SiiTipoDocSopSolicPago> buscarTodoTipoDocCobroSolPago() throws ExcepcionDAO{
        try{
            List<SiiTipoDocSopSolicPago> listaSiiTipoDocSopSolicPago = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ta FROM SiiTipoDocSopSolicPago ta");
            Query query = em.createQuery(sql.toString());
            listaSiiTipoDocSopSolicPago = query.getResultList();
            return listaSiiTipoDocSopSolicPago;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
    }
    
    
}
