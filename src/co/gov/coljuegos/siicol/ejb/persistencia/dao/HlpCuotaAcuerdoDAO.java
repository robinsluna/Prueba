/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 22-01-2015
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBeneficiarioEnte;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaAcuerdo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaOpCuoAcu;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class HlpCuotaAcuerdoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public HlpCuotaAcuerdoDAO() {
        recursos = new Recursos();
    }
    public SiiHlpCuotaAcuerdo buscarHlpCuotaAcuerdoPorCodigo(Long idCodigoHlpCuotaAcuerdo) throws ExcepcionDAO {
        SiiHlpCuotaAcuerdo retorno = null;
        try {
            retorno = (SiiHlpCuotaAcuerdo) manager.find(SiiHlpCuotaAcuerdo.class, idCodigoHlpCuotaAcuerdo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "HlpCuotaAcuerdoDAO");
        }
        return retorno;

    }
    
    public SiiHlpCuotaAcuerdo insertarSiiHlpCuotaAcuerdo(SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo) throws ExcepcionDAO {
        try {
            manager.persist(siiHlpCuotaAcuerdo); 
            manager.flush(); 
            return siiHlpCuotaAcuerdo; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "HlpCuotaAcuerdoDAO");
        }
    }
    /**
     * Realiza la b&uacute;squeda de las cuotas de los acuerdos de pago <i>ACTIVOS</i>.    
     * @return List of SiiHlpCuotaAcuerdo.
     */
    public List<SiiHlpCuotaAcuerdo> buscarCuotasPorNumeroAcuerdoPago (Long idAcuerdoPago) throws ExcepcionDAO
    {
        List<SiiHlpCuotaAcuerdo> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiHlpCuotaAcuerdo o INNER JOIN o.siiAcuerdoPago ap "); 
            sql.append(" WHERE ap.apaCodigo = :idAcuerdoPago");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idAcuerdoPago", idAcuerdoPago);
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    /**
     * Realiza la b&uacute;squeda de las cuotas origenes de los acuerdos de pago <i>ACTIVOS</i>.    
     * @return List of SiiHlpCuotaOpCuoAcu.
     */
    public List<SiiHlpCuotaOpCuoAcu> buscarCuotasOrigenPorNumeroAcuerdoPago (Long idAcuerdoPago) throws ExcepcionDAO
    {
        List<SiiHlpCuotaOpCuoAcu> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiHlpCuotaAcuerdo o INNER JOIN o.siiAcuerdoPago ap "); 
            sql.append(" WHERE ap.apaCodigo = :idAcuerdoPago");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idAcuerdoPago", idAcuerdoPago);
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
}
