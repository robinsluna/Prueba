/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel7;
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
public class Nivel7DAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public Nivel7DAO() {
        recursos = new Recursos();
    }
    
    public PrNivel7 insertarNivel7(PrNivel7 prNivel7) throws ExcepcionDAO{
        try{
            manager.persist(prNivel7);
            manager.flush();
            return prNivel7;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"Nivel7DAO");      
        }
    }
    
    public PrNivel7 buscarNivel7PorCodigoPorVigencia(String codigo, Integer vigencia) throws ExcepcionDAO{
    PrNivel7 prNivel7 = null;
        try{
            List<PrNivel7> listaNivel7 = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nivel7 FROM PrNivel7 nivel7");
            sql.append(" WHERE nivel7.codigo = :codigo");
            sql.append(" AND nivel7.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigo", codigo);
            query.setParameter("vigencia", vigencia);
            listaNivel7 = query.getResultList();
            if(listaNivel7 != null && listaNivel7.size()>0){
                prNivel7 = listaNivel7.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return prNivel7;
    }
    
}
