package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponsabilidadDian;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class ResponsabilidadDianDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ResponsabilidadDianDAO() {
        recursos = new Recursos();    
    }
    public SiiResponsabilidadDian buscarResponsabilidadDianPorId(Long idResponsabilidadDian) throws ExcepcionDAO{
        SiiResponsabilidadDian siiResponsabilidadDian = new SiiResponsabilidadDian();
        try{
            siiResponsabilidadDian = (SiiResponsabilidadDian) manager.find(SiiResponsabilidadDian.class, idResponsabilidadDian);
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"ResponsabilidadDianDAO");
        }
        return siiResponsabilidadDian;
    }
    
    public List<SiiResponsabilidadDian> buscarTodosResponsabilidadDian() throws ExcepcionDAO{
        try{
            List<SiiResponsabilidadDian> listaSiiResponsabilidadDian = new ArrayList<SiiResponsabilidadDian>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT srd FROM SiiResponsabilidadDian srd ");
            Query query = manager.createQuery(sql.toString());
            listaSiiResponsabilidadDian = query.getResultList();
            return listaSiiResponsabilidadDian;        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ResponsabilidadDianDAO");
        }
    }    
}

