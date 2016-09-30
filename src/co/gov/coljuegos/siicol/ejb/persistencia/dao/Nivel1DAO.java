/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1PK;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;
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
public class Nivel1DAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public Nivel1DAO() {
        recursos = new Recursos();
    }
    
    public PrNivel1 insertarNivel1(PrNivel1 prNivel1) throws ExcepcionDAO{
        try{
            manager.persist(prNivel1);
            manager.flush();
            return prNivel1;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"Nivel1DAO");
        }
    }
    
    public PrNivel1 buscarNivel1PorId(PrNivel1PK prNivel1PK) throws ExcepcionDAO{
    PrNivel1 prNivel1 = null;
        try{
            prNivel1 = (PrNivel1)manager.find(PrNivel1.class, prNivel1PK);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return prNivel1;
    }
    
    public PrNivel1 buscarNivel1PorCodigoPorVigencia(String codigo, Integer vigencia) throws ExcepcionDAO{
    PrNivel1 prNivel1 = null;
        try{
            List<PrNivel1> listaNivel1 = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nivel1 FROM PrNivel1 nivel1");
            sql.append(" WHERE nivel1.codigo = :codigo");
            sql.append(" AND nivel1.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigo", codigo);
            query.setParameter("vigencia", vigencia);
            listaNivel1 = query.getResultList();
            if(listaNivel1 != null && listaNivel1.size()>0){
                prNivel1 = listaNivel1.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return prNivel1;
    }
    
    
}
