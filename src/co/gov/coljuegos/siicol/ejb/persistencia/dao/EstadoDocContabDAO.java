/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-02-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class EstadoDocContabDAO extends GenericDAO<SiiEstadoDocContab> {

    
    /**
     * Constructor.
     */
    public EstadoDocContabDAO() {
       
        // Establecer la clase correspondiente a la Entidad que administra el DAO
        super(SiiEstadoDocContab.class);
    }
    
    public SiiEstadoDocContab buscarEstadoDocContabXNombre(String nombreEstado ) throws ExcepcionDAO {
           try {
               SiiEstadoDocContab siiEstadoDocContab= null;
               StringBuilder sql = new StringBuilder();
               sql.append(" SELECT est FROM SiiEstadoDocContab est");
               sql.append(" WHERE est.edoNombre = :nombreEstado");
               Query query = em.createQuery(sql.toString());
               query.setParameter("nombreEstado", nombreEstado);
               List<SiiEstadoDocContab> listaSiiEstadoDocContab = query.getResultList();
               
               if (listaSiiEstadoDocContab!= null && !listaSiiEstadoDocContab.isEmpty()) {
                   siiEstadoDocContab = listaSiiEstadoDocContab.get(0);
               }
               return siiEstadoDocContab;

           } catch (PersistenceException pe) {
               String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
               throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
           }
       }
}
