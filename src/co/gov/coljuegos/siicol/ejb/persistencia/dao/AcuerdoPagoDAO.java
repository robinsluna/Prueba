/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 18-11-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAcuerdoPago;
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
public class AcuerdoPagoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public AcuerdoPagoDAO() {
        recursos = new Recursos();
    }
    /**
     * Obtiene la lista de todos los acuerdos de pago    
     * @return instance of Map<String, Date>
     */
    public List<SiiAcuerdoPago> buscarTodoAcuerdoPago() throws ExcepcionDAO {
        List<SiiAcuerdoPago> listaSiiAcuerdoPago = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiAcuerdoPago o order by o.apaFecha desc");
            Query query = manager.createQuery(sql.toString());
            listaSiiAcuerdoPago = query.getResultList();
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos: " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiAcuerdoPago;
    }
    
    
    /**
     * Inserta el <b>Acuerdo de pago</b> .
     * @param SiiAcuerdoPago    
     * @throws ExcepcionDAO
     */
    
    public SiiAcuerdoPago insertarSiiAcuerdoPago(SiiAcuerdoPago acuerdo) throws ExcepcionDAO {
        try {
            manager.persist(acuerdo); 
            manager.flush();
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos: " + ex.getMessage(), getClass().getSimpleName());
        }
        return acuerdo;
    }
    /**
     * Establece el <b>CONSECUTIVO</b> del acuerdo de pago.     
     * @throws ExcepcionDAO
     */
    public Long consultarConsecutivoAcuerdo() throws ExcepcionDAO {
        Long consecutivo = null;
        try {
            StringBuilder sql = new StringBuilder();


            sql.append("SELECT NVL(MAX(apa_numero)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM sii_acuerdo_pago apa ");
            sql.append("WHERE apa_numero LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%'");
            Query query = manager.createNativeQuery(sql.toString());

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
    /**
     * Busca el <b>Acuerdo de pago</b> por código.
     * @param idAcuerdo    
     * @throws ExcepcionDAO
     */
    public SiiAcuerdoPago buscarAcuerdoPagoPorCodigo(Long idAcuerdo) throws ExcepcionDAO {
        SiiAcuerdoPago retorno = null;
        try {
            retorno = (SiiAcuerdoPago) manager.find(SiiAcuerdoPago.class, idAcuerdo);

        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos: " + ex.getMessage(), getClass().getSimpleName());
        }
        return retorno;
    }
    
    public SiiAcuerdoPago buscarAcuerdoPagoPorNumero(Integer numero) throws ExcepcionDAO {
        SiiAcuerdoPago siiAcuerdoPago = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT apa FROM SiiAcuerdoPago apa");
            sql.append(" WHERE apa.apaNumero = :numero");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numero", numero);
            
            List <SiiAcuerdoPago> listaAcuerdoPago = query.getResultList();
            if(listaAcuerdoPago != null && listaAcuerdoPago.size() > 0){
                siiAcuerdoPago = listaAcuerdoPago.get(0);
            }
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos: " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiAcuerdoPago;
    }
    
    
    
}
