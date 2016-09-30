package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCorteCartera;
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
public class CorteCarteraDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public CorteCarteraDAO() {
        recursos = new Recursos();
    }
    
    public SiiCorteCartera buscarCorteCarteraPorVigenciaPorMes(int vigencia, int mes) throws ExcepcionDAO{
        SiiCorteCartera siiCorteCarteraRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cca FROM SiiCorteCartera cca ");
            sql.append("WHERE cca.ccaVigencia = :vigencia ");
            sql.append("AND cca.siiMes.mesCodigo = :mes");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", vigencia);
            query.setParameter("mes", mes);
            List<SiiCorteCartera> listaCorteCartera = query.getResultList();
            if(listaCorteCartera != null && listaCorteCartera.size() > 0){
                siiCorteCarteraRetorno = listaCorteCartera.get(0);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoGastoDAO");
        }
        return siiCorteCarteraRetorno;
    }
    
    public SiiCorteCartera insertarCorteCartera(SiiCorteCartera siiCorteCartera) throws ExcepcionDAO{
        try {
            manager.persist(siiCorteCartera); 
            manager.flush(); 
            return siiCorteCartera; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CorteCarteraDAO");
        }
    }
    
    public SiiCorteCartera actualizarCorteCartera(SiiCorteCartera siiCorteCartera) throws ExcepcionDAO{
        try {
            manager.merge(siiCorteCartera); 
            manager.flush();  

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CorteCarteraDAO");
        }
        return siiCorteCartera;
    }
    
    public SiiCorteCartera buscarCorteCarteraPorId(Long idCorteCartera) throws ExcepcionDAO{
        SiiCorteCartera siiCorteCartera = null;
        try{
            siiCorteCartera = (SiiCorteCartera)manager.find(SiiCorteCartera.class, idCorteCartera);
        }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"CorteCarteraDAO");
            }
        return siiCorteCartera;
    }
}
