package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjuste;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class AjusteDAO extends GenericDAO<SiiAjuste> {
    public AjusteDAO() {
        super(SiiAjuste.class);
    }
    
    public Integer buscarUltimoConsecutivoPorVigencia(Integer vigencia) throws ExcepcionDAO{
        Integer resultado = null;
        Integer inicioConsecutivo = ((vigencia - 2000) * 1000000) + 50000000;
        Integer finConsecutivo = ((vigencia  - 2000 + 1) * 1000000) + 50000000;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT MAX(AJU.AJU_CONSECUTIVO) FROM SII_AJUSTE AJU");
            sql.append(" WHERE AJU.AJU_CONSECUTIVO >= #inicioConsecutivo ");
            sql.append(" AND AJU.AJU_CONSECUTIVO < #finConsecutivo ");
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("inicioConsecutivo", inicioConsecutivo);
            query.setParameter("finConsecutivo", finConsecutivo);

            List<Object> results = query.getResultList();

            for (Object object : results) {
                if(object != null){
                    resultado = ((BigDecimal) object).intValue();
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return resultado;
    }
}
