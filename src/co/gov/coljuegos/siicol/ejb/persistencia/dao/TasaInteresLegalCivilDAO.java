package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteresLegalCivil;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Tasas de Inter&eacute;s Legal Civil.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class TasaInteresLegalCivilDAO extends AbstractDAO<Long, SiiTasaInteresLegalCivil> 
{
    /**
     * Constructor.
     */
    public TasaInteresLegalCivilDAO() 
    {
        super(SiiTasaInteresLegalCivil.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de las Tasas de Inter&eacute;s Legal Civil, que se encuentren en estado ACTIVO.
     * @return Instancia de SiiTasaInteresLegalCivil.
     * @throws ExcepcionDAO
     */
    public SiiTasaInteresLegalCivil buscarTasaInteresLegalCivilActiva () throws ExcepcionDAO 
    {
        SiiTasaInteresLegalCivil resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT til FROM SiiTasaInteresLegalCivil til ");
            sql.append("WHERE til.tilActivo = :tilActivo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("tilActivo", EnumDecision.SI.getId());
            
            // Debe existir solo un registro en estado ACTIVO.
            List<SiiTasaInteresLegalCivil> lista = query.getResultList();
            if (lista!=null && !lista.isEmpty())
                resultado = lista.get(0);
            
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
               
        return (resultado);
    }
    
    
    
    
    
}
