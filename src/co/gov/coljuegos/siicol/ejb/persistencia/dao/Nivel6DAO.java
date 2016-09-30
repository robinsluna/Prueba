/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel6;
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
public class Nivel6DAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public Nivel6DAO() {
        recursos = new Recursos();
    }
    
    public PrNivel6 insertarNivel6(PrNivel6 prNivel6) throws ExcepcionDAO{
        try{
            manager.persist(prNivel6);
            manager.flush();
            return prNivel6;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"Nivel6DAO");     
        }
    }
    
    public PrNivel6 buscarNivel6PorCodigoPorVigencia(String codigo, Integer vigencia) throws ExcepcionDAO{
    PrNivel6 prNivel6 = null;
        try{
            List<PrNivel6> listaNivel6 = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nivel6 FROM PrNivel6 nivel6");
            sql.append(" WHERE nivel6.codigo = :codigo");
            sql.append(" AND nivel6.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigo", codigo);
            query.setParameter("vigencia", vigencia);
            listaNivel6 = query.getResultList();
            if(listaNivel6 != null && listaNivel6.size()>0){
                prNivel6 = listaNivel6.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return prNivel6;
    }

}
