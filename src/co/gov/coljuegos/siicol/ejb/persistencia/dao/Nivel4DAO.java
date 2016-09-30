/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel4;
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
public class Nivel4DAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public Nivel4DAO() {
        recursos = new Recursos();
    }
    
    public PrNivel4 insertarNivel4(PrNivel4 prNivel4) throws ExcepcionDAO{
        try{
            manager.persist(prNivel4);
            manager.flush();
            return prNivel4;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"Nivel4DAO");      
        }
    }
    
    public PrNivel4 buscarNivel4PorCodigoPorVigencia(String codigo, Integer vigencia) throws ExcepcionDAO{
    PrNivel4 prNivel4 = null;
        try{
            List<PrNivel4> listaNivel4 = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nivel4 FROM PrNivel4 nivel4");
            sql.append(" WHERE nivel4.codigo = :codigo");
            sql.append(" AND nivel4.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigo", codigo);
            query.setParameter("vigencia", vigencia);
            listaNivel4 = query.getResultList();
            if(listaNivel4 != null && listaNivel4.size()>0){
                prNivel4 = listaNivel4.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return prNivel4;
    }
    
}
