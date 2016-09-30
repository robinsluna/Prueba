/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 24-09-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSmmlv;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class SmmlvDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public SmmlvDAO() {
        recursos = new Recursos();
    }
    
       
    public Long buscarSmmlvPorVigencia(Integer vigencia) throws ExcepcionDAO{
        Long valorSmmlv;
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append(" SELECT smmlv.smmValor FROM SiiSmmlv smmlv");
            sql.append(" WHERE smmlv.smmVigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", vigencia);
            
            valorSmmlv =(Long) query.getSingleResult();
            
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
           
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SmmlvDAO");
        }
       
        return valorSmmlv;
    }
    public SiiSmmlv buscarSmmlvPorId(Integer vigencia) throws ExcepcionDAO{
        SiiSmmlv siiSmmlv = null;
        try{
            siiSmmlv = manager.find(SiiSmmlv.class, vigencia);
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
       
        return siiSmmlv;
    }
    
  
}
