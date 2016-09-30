package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaPoblacion;

import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class CargaPoblacionDAO extends AbstractDAO<Long, SiiCargaPoblacion> 
{
    
    public CargaPoblacionDAO() {
        super(SiiCargaPoblacion.class);
    }
    public Long consultarConsecutivoCargaPoblacion() throws ExcepcionDAO {
            Long consecutivo = null;
            try {
                StringBuilder sql = new StringBuilder();


                sql.append("SELECT NVL(MAX(cpo_consecutivo_car)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
                sql.append("FROM sii_carga_poblacion apa ");
                sql.append("WHERE cpo_consecutivo_car LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%'");
                Query query = em.createNativeQuery(sql.toString());

                if (query.getSingleResult() != null) {
                    consecutivo = new Long(((BigDecimal) query.getSingleResult()).longValue());
                }else {
                    consecutivo = 0L;
                }

            } catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos: " + ex.getMessage(), getClass().getSimpleName());
            }
            return consecutivo;
        }
    public Long BuscarCargaPoblacionOrdenado() throws ExcepcionDAO {
            Long consecutivo = null;
            try {
                StringBuilder sql = new StringBuilder();

                sql.append("SELECT MAX(apa.cpo_codigo) ");
                sql.append("FROM sii_carga_poblacion apa ");
                sql.append("ORDER BY 1 DESC");
                Query query = em.createNativeQuery(sql.toString());

                if (query.getSingleResult() != null) {
                    consecutivo = new Long(((BigDecimal) query.getSingleResult()).longValue());
                }else {
                    consecutivo = 0L;
                }

            } catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos: " + ex.getMessage(), getClass().getSimpleName());
            }
            return consecutivo;
        }
}
