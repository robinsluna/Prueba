/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 11-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel8;
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
public class Nivel8DAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public Nivel8DAO() {
        recursos = new Recursos();
    }
    
    public PrNivel8 insertarNivel8(PrNivel8 prNivel8) throws ExcepcionDAO{
        try{
            manager.persist(prNivel8);
            manager.flush();
            return prNivel8;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"Nivel8DAO");      
        }
    }
    
    public PrNivel8 buscarNivel8PorCodigoPorVigencia(String codigo, Integer vigencia) throws ExcepcionDAO{
    PrNivel8 prNivel8 = null;
        try{
            List<PrNivel8> listaNivel8 = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nivel8 FROM PrNivel8 nivel8");
            sql.append(" WHERE nivel8.codigo = :codigo");
            sql.append(" AND nivel8.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigo", codigo);
            query.setParameter("vigencia", vigencia);
            listaNivel8 = query.getResultList();
            if(listaNivel8 != null && listaNivel8.size()>0){
                prNivel8 = listaNivel8.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return prNivel8;
    }
    
}