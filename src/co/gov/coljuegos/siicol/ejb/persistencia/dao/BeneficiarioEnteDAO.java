/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-10-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoBeneficiarioEnte;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBeneficiarioEnte;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class BeneficiarioEnteDAO extends GenericDAO<SiiBeneficiarioEnte> 
{
    /**
     * Constructor.
     */
    public BeneficiarioEnteDAO() {
        super(SiiBeneficiarioEnte.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros de Beneficiarios <i>ACTIVOS</i>, asociados al Ente Territorial especificado.
     * @param etiCodigo - C&oacute;digo del Ente Territorial.
     * @return List of SiiBeneficiarioEnte.
     */
    public List<SiiBeneficiarioEnte> buscarPorCodigoEnteTerritorial (Long etiCodigo) throws ExcepcionDAO 
    {
        return ( this.buscarPorCodigoEnteTerritorial(etiCodigo, EnumEstadoBeneficiarioEnte.ACTIVO.getId()) );
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros asociados al Ente Territorial especificado.
     * @param etiCodigo - C&oacute;digo del Ente Territorial.
     * @param benEstado - Estado del Beneficiario-Ente.
     * @return List of SiiBeneficiarioEnte.
     */
    public List<SiiBeneficiarioEnte> buscarPorCodigoEnteTerritorial (Long etiCodigo, String benEstado) throws ExcepcionDAO
    {
        return ( this.buscarPorCodigoEnteTerritorialMes(etiCodigo, null, null, benEstado) );
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros <i>ACTIVOS</i>, asociados al Ente Territorial, Mes y Vigencia especificados.
     * @param etiCodigo - C&oacute;digo del Ente Territorial.
     * @param mesCodigo - C&oacute;digo del Mes.
     * @param vigencia - Vigencia.
     * @return List of SiiBeneficiarioEnte.
     */
    public List<SiiBeneficiarioEnte> buscarPorCodigoEnteTerritorialMes (Long etiCodigo, Integer mesCodigo, Integer vigencia) throws ExcepcionDAO 
    {
        return ( this.buscarPorCodigoEnteTerritorialMes(etiCodigo, mesCodigo, vigencia, EnumEstadoBeneficiarioEnte.ACTIVO.getId()) );
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros asociados al Ente Territorial, Mes y Vigencia especificados.
     * @param etiCodigo - C&oacute;digo del Ente Territorial.
     * @param mesCodigo - C&oacute;digo del Mes.
     * @param vigencia - Vigencia.
     * @param benEstado - Estado del Beneficiario-Ente.
     * @return List of SiiBeneficiarioEnte.
     */
    public List<SiiBeneficiarioEnte> buscarPorCodigoEnteTerritorialMes (Long etiCodigo, Integer mesCodigo, Integer vigencia, String benEstado) throws ExcepcionDAO
    {
        List<SiiBeneficiarioEnte> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiBeneficiarioEnte o ");
            sql.append("WHERE o.siiEnteTerritorial.etiCodigo = :etiCodigo ");
            
            if (mesCodigo!=null)
                sql.append("AND o.siiMes.mesCodigo = :mesCodigo ");
            
            if (vigencia!=null)
                sql.append("AND o.benVigencia = :benVigencia ");
            
            if (benEstado!=null) 
                sql.append("AND o.benActivo = :benEstado ");
            
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("etiCodigo", etiCodigo);
            
            if (mesCodigo!=null)
                query.setParameter("mesCodigo", mesCodigo);
            
            if (vigencia!=null)
                query.setParameter("benVigencia", vigencia);
            
            if (benEstado!=null)
                query.setParameter("benEstado", benEstado);
            
            
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros de Beneficiarios <i>ACTIVOS</i>.    
     * @return List of SiiBeneficiarioEnte.
     */
    public List<SiiBeneficiarioEnte> buscarTodosBeneficiariosEnteTerritorial () throws ExcepcionDAO
    {
        List<SiiBeneficiarioEnte> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiBeneficiarioEnte o ");            
            
            Query query = em.createQuery(sql.toString());            
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Inserta los Beneficiarios de entes territoriales.    
     * @return SiiBeneficiarioEnte.
     */
    
    public SiiBeneficiarioEnte insertarSiiBeneficiarioEnte(SiiBeneficiarioEnte beneficiarioEnte) throws ExcepcionDAO {
        try {              
            em.persist(beneficiarioEnte); 
            em.flush(); 
            return beneficiarioEnte; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "BeneficiarioEnteDAO");
        }
    }
    public SiiBeneficiarioEnte buscarPorCodigoBeneficiarioEnte(Long idCodigoBen) throws ExcepcionDAO {
        SiiBeneficiarioEnte retorno = null;
        try {
            retorno = em.find(SiiBeneficiarioEnte.class, idCodigoBen);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "BeneficiarioEnteDAO");
        }
        return retorno;

    }
    
    /**
     * Realiza la b&uacute;squeda de los registros de Beneficiarios por codigo de persona .    
     * @return List of SiiBeneficiarioEnte.
     */
    public List<SiiBeneficiarioEnte> buscarBeneficiariosEnteTerritorialPorNit (String nit) throws ExcepcionDAO
    {
        List<SiiBeneficiarioEnte> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiBeneficiarioEnte o Inner Join o.siiPersona per where per.perNumIdentificacion=:nit");            
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("nit" ,nit );
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    /**
     * Realiza la actualización del Beneficiario ebte por codigo de beneficiario .    
     * @return List of SiiBeneficiarioEnte.
     */
    public SiiBeneficiarioEnte actualizarSiiBeneficiarioEnte(SiiBeneficiarioEnte beneficiario) throws ExcepcionDAO {
        try {
            em.merge(beneficiario); 
            em.flush(); 
            return beneficiario; 

        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
    }
    
}
