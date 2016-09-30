package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionOperador;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DeclaracionOperadorDAO extends GenericDAO<SiiDeclaracionOperador>{
   
    public DeclaracionOperadorDAO() {
        super(SiiDeclaracionOperador.class);  
    }
    
    public long consultarConsecutivo() throws ExcepcionDAO {
        long consecutivo = 0L;
        try{
            StringBuilder sql = new StringBuilder();
            
            
            sql.append("select MAX(DOP_CODIGO)+1 from SII_DECLARACION_OPERADOR");
            Query query = em.createNativeQuery(sql.toString());
            
            if(query.getSingleResult() != null){
                consecutivo =  ((BigDecimal)query.getSingleResult()).longValue();
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    public List<SiiDeclaracionOperador> buscarDeclaracionesPorCuota(Long idCuota) throws ExcepcionDAO{
        List<SiiDeclaracionOperador> siiDeclaracionOperador = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT dop FROM SiiDetalleDeclaracion dde");
            sql.append(" INNER JOIN dde.siiDeclaracionOperador dop");
            sql.append(" WHERE dde.siiCuotaOperador.copCodigo = :idCuota");
            Query query = em.createQuery(sql.toString());
            query.setParameter("idCuota", idCuota);
            siiDeclaracionOperador = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDeclaracionOperador;
    }
}
