package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuestPolizaRenovac;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class TipoApuestPolizaRenovacDAO extends GenericDAO<SiiTipoApuestPolizaRenovac> {
    
    public TipoApuestPolizaRenovacDAO() {
        super(SiiTipoApuestPolizaRenovac.class);
    }
    
    public List<SiiTipoApuestPolizaRenovac> buscarTipoApuestaPolizaRenovacionPorPoliza(Long idPoliza) throws ExcepcionDAO{
        List<SiiTipoApuestPolizaRenovac> listaTipoApuestaPolizaRenovacion = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tal FROM SiiTipoApuestPolizaRenovac tal");
            sql.append(" WHERE tal.siiPolizaContrat.pccCodigo = :idPoliza");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("idPoliza", idPoliza);

            listaTipoApuestaPolizaRenovacion = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaTipoApuestaPolizaRenovacion;
    }
}
