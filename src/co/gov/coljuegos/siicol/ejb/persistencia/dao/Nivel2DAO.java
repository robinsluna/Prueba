/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel2;
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
public class Nivel2DAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public Nivel2DAO() {
        recursos = new Recursos();
    }
    
    public PrNivel2 insertarNivel2(PrNivel2 prNivel2) throws ExcepcionDAO{
        try{
            manager.persist(prNivel2);
            manager.flush();
            return prNivel2;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"Nivel2DAO");
        }
    }
    
    public PrNivel2 buscarNivel2PorCodigoPorVigencia(String codigo, Integer vigencia) throws ExcepcionDAO{
    PrNivel2 prNivel2 = null;
        try{
            List<PrNivel2> listaNivel2 = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nivel2 FROM PrNivel2 nivel2");
            sql.append(" WHERE nivel2.codigo = :codigo");
            sql.append(" AND nivel2.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigo", codigo);
            query.setParameter("vigencia", vigencia);
            listaNivel2 = query.getResultList();
            if(listaNivel2 != null && listaNivel2.size()>0){
                prNivel2 = listaNivel2.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return prNivel2;
    }
    
}
