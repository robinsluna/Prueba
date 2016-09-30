package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjusteCuota;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class AjusteCuotaDAO extends GenericDAO<SiiAjusteCuota> {
    
    public AjusteCuotaDAO() {
        super(SiiAjusteCuota.class);
    }
    
    public List<SiiAjusteCuota> buscarAjustesCuotaPorIdCuota(Long idCuota) throws ExcepcionDAO{
        List<SiiAjusteCuota> listaSiiAjusteCuota = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT acu FROM SiiAjusteCuota acu ");
            sql.append("INNER JOIN acu.siiCuotaOperador cop ");
            sql.append("WHERE cop.copCodigo = :idCuota ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("idCuota", idCuota);

            listaSiiAjusteCuota = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiAjusteCuota;
    }
}
