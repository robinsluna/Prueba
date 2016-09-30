/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 24-01-2014
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEnteTerritorial;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EnteTerritorialDAO extends GenericDAO<SiiEnteTerritorial> {

    
    public EnteTerritorialDAO() {
        super(SiiEnteTerritorial.class);
    }
    
    public SiiEnteTerritorial buscarEnteTerritorialPorId (Long idDocConpes) throws ExcepcionDAO {
        SiiEnteTerritorial siiEnteTerritorial = null;
        try {
            siiEnteTerritorial =  em.find(SiiEnteTerritorial.class, idDocConpes); 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
        return siiEnteTerritorial;

    }
    
    
    public SiiEnteTerritorial buscarEnteTerritorialXIdUbicacion(String idUbicacion) throws ExcepcionDAO {
        try {
            SiiEnteTerritorial siiEnteTerritorial= null;
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT est FROM SiiEnteTerritorial est");
            sql.append(" WHERE est.siiUbicacion.ubiCodigo = :idUbicacion");
            Query query = em.createQuery(sql.toString());
            query.setParameter("idUbicacion", idUbicacion);
            List<SiiEnteTerritorial> listaSiiEnteTerritorial= query.getResultList();
            
            if (listaSiiEnteTerritorial != null && !listaSiiEnteTerritorial.isEmpty()) {
                siiEnteTerritorial = listaSiiEnteTerritorial.get(0);
            }
            return siiEnteTerritorial;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda del Ente Territorial que se encuentra asociado al c&oacute;digo de la Ubicaci&oacute;n correspondiente al NIT del mismo.
     * @param ubiCodigo - C&oacute;digo de la Ubicaci&oacute;n del Ente Territorial.
     * @return Instance of SiiEnteTerritorial.
     * @throws ExcepcionDAO
     */
    public SiiEnteTerritorial buscarEnteTerritorialPorUbicacion (String ubiCodigo) throws ExcepcionDAO 
    {
        SiiEnteTerritorial resultado = null;
        
        if (ubiCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT et FROM SiiEnteTerritorial et ");
                sql.append("WHERE et.siiUbicacion.ubiCodigo = :ubiCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("ubiCodigo", ubiCodigo);
                
                resultado = (SiiEnteTerritorial) query.getSingleResult();
                
            }
            catch (NoResultException e) {
                resultado = null;
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
