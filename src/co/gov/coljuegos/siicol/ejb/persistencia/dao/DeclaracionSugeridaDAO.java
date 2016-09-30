package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionSugerida;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DeclaracionSugeridaDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public DeclaracionSugeridaDAO() {
        recursos = new Recursos();
    }

    public SiiDeclaracionSugerida insertarSiiDeclaracionSugerida(SiiDeclaracionSugerida siiDeclaracionSugerida) throws ExcepcionDAO {
        try {
            manager.persist(siiDeclaracionSugerida);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDeclaracionSugerida;
    }

    public SiiDeclaracionSugerida actualizarSiiDeclaracionSugerida(SiiDeclaracionSugerida siiDeclaracionSugerida) throws ExcepcionDAO {
        try {
            manager.merge(siiDeclaracionSugerida);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDeclaracionSugerida;
    }

    /**
     *Metodo encargado de hacer la consulta de un registro de declaracion sugerida por el numero de consecutivo
     * @author David Tafur
     * @param consecutivo
     * @return
     * @throws ExcepcionDAO
     */
    public SiiDeclaracionSugerida consultarDeclaracionSugeridaPorConsecutivo(Integer consecutivo) throws ExcepcionDAO {
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT u FROM SiiDeclaracionSugerida u");
            sql.append(" WHERE u.dsuConsecutivo =:consecutivo");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("consecutivo", consecutivo);

            siiDeclaracionSugerida = (SiiDeclaracionSugerida) consulta.getResultList().get(0);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDeclaracionSugerida;
    }

    public List<SiiDeclaracionSugerida> consultaListaSiiDeclaracionSugerida() throws ExcepcionDAO {
        List<SiiDeclaracionSugerida> listaSiiDeclaracionSugerida = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("Select u FROM SiiDeclaracionSugerida u ORDER BY u.dsuCodigo DESC");

            Query consulta = manager.createQuery(sql.toString());
            listaSiiDeclaracionSugerida = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDeclaracionSugerida;
    }


    public SiiDeclaracionSugerida buscarDeclaracionSugeridaPorId(Long idDeclaracionSugerida) throws ExcepcionDAO {
        SiiDeclaracionSugerida siiDeclaracionSugerida = null;
        try {
            siiDeclaracionSugerida = manager.find(SiiDeclaracionSugerida.class, idDeclaracionSugerida);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDeclaracionSugerida;
    }
    
    public long buscarConsecutivoDeclaracionSugerida() throws ExcepcionDAO 
    {
        long consecutivo = 0L;
        try{
            StringBuilder sql = new StringBuilder();
            
            
            sql.append("select MAX(dsu_consecutivo)+1 from sii_declaracion_sugerida");
            Query query = manager.createNativeQuery(sql.toString());
            
            if(query.getSingleResult() != null){
                consecutivo =  ((BigDecimal)query.getSingleResult()).longValue();
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
}
