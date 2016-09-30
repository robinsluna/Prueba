package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteAutoForCarIle;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class TramiteAutoForCarIleDAO  extends AbstractDAO<Long,SiiTramiteAutoForCarIle>{
    /**
     * Constructor.
     */
    public TramiteAutoForCarIleDAO() {
        super(SiiTramiteAutoForCarIle.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los Tr&aacute;mites del Auto de Formulaci&oacute;n de Cargos asociados al identificador del Auto especificado.
     * @param afcCodigo - C&oacute;digo del Auto de Formulaci&oacute;n de Cargos del Proceso Sancionatorio de Ilegalidad.
     * @return Listado de SiiTramiteAutoForCarIle.
     * @throws ExcepcionDAO
     */
    public List<SiiTramiteAutoForCarIle> buscarElementoAutoFormCarIlePorIdAutoFormCargProIle (Long afcCodigo) throws ExcepcionDAO 
    {
        List<SiiTramiteAutoForCarIle> resultado = null;
        
        if (afcCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT taf FROM SiiTramiteAutoForCarIle taf ");
                sql.append("WHERE taf.siiAutoFormCargProIle.afcCodigo = :afcCodigo ");
                
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
