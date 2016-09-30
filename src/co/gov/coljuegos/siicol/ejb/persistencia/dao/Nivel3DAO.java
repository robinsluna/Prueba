/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel3;
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
public class Nivel3DAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public Nivel3DAO() {
        recursos = new Recursos();
    }
    
    public PrNivel3 insertarNivel3(PrNivel3 prNivel3) throws ExcepcionDAO{
        try{
            manager.persist(prNivel3);
            manager.flush();
            return prNivel3;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"Nivel3DAO");      
        }
    }
    
    public PrNivel3 buscarNivel3PorCodigoPorVigencia(String codigo, Integer vigencia) throws ExcepcionDAO{
    PrNivel3 prNivel3 = null;
        try{
            List<PrNivel3> listaNivel3 = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nivel3 FROM PrNivel3 nivel3");
            sql.append(" WHERE nivel3.codigo = :codigo");
            sql.append(" AND nivel3.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigo", codigo);
            query.setParameter("vigencia", vigencia);
            listaNivel3 = query.getResultList();
            if(listaNivel3 != null && listaNivel3.size()>0){
                prNivel3 = listaNivel3.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return prNivel3;
    }
    
}
