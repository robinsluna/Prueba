/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel5;
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
public class Nivel5DAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public Nivel5DAO() {
        recursos = new Recursos();
    }
    
    public PrNivel5 insertarNivel5(PrNivel5 prNivel5) throws ExcepcionDAO{
        try{
            manager.persist(prNivel5);
            manager.flush();
            return prNivel5;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"Nivel5DAO");      
        }
    }
    
    public PrNivel5 buscarNivel5PorCodigoPorVigencia(String codigo, Integer vigencia) throws ExcepcionDAO{
    PrNivel5 prNivel5 = null;
        try{
            List<PrNivel5> listaNivel5 = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nivel5 FROM PrNivel5 nivel5");
            sql.append(" WHERE nivel5.codigo = :codigo");
            sql.append(" AND nivel5.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigo", codigo);
            query.setParameter("vigencia", vigencia);
            listaNivel5 = query.getResultList();
            if(listaNivel5 != null && listaNivel5.size()>0){
                prNivel5 = listaNivel5.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return prNivel5;
    }
    
}
