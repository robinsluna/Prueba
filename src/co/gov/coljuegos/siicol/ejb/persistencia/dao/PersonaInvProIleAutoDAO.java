package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvProIleAuto;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class PersonaInvProIleAutoDAO  extends AbstractDAO<Long,SiiPersonaInvProIleAuto>{
    /**
     * Constructor.
     */
    public PersonaInvProIleAutoDAO() {
        super(SiiPersonaInvProIleAuto.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de las Personas Investigadas del Auto de Formulaci&oacute;n de Cargos asociados al identificador del Auto especificado.
     * @param afcCodigo - C&oacute;digo del Auto de Formulaci&oacute;n de Cargos del Proceso Sancionatorio de Ilegalidad.
     * @return Listado de SiiPersonaInvProIleAuto.
     * @throws ExcepcionDAO
     */
    public List<SiiPersonaInvProIleAuto> buscarElementoAutoFormCarIlePorIdAutoFormCargProIle (Long afcCodigo) throws ExcepcionDAO 
    {
        List<SiiPersonaInvProIleAuto> resultado = null;
        
        if (afcCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT pia FROM SiiPersonaInvProIleAuto pia ");
                sql.append("WHERE pia.siiAutoFormCargProIle.afcCodigo = :afcCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("afcCodigo", afcCodigo);
                
                resultado = query.getResultList();
                
            }
            catch(PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch(Exception e) {
                throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
            }
        }
        
        return (resultado);
    }
}
