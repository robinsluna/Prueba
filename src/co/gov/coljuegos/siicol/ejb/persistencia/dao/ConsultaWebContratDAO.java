package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsultaWebContrat;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean

public class ConsultaWebContratDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ConsultaWebContratDAO() {
        recursos = new Recursos();
    }
    
    public SiiConsultaWebContrat buscarConsultaWebContratPorId(Long idConsultaWebCont) throws ExcepcionDAO{
        SiiConsultaWebContrat localConsultaWebContrat = null;
        try{
            localConsultaWebContrat = (SiiConsultaWebContrat) manager.find(SiiConsultaWebContrat.class, idConsultaWebCont);
            
        }catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ConsultaWebContratDAO");
            }
        return localConsultaWebContrat;
    }
    
    public SiiConsultaWebContrat insertarConsultaWebContrat(SiiConsultaWebContrat consultaWebContrat) throws ExcepcionDAO{
        try{
            manager.persist(consultaWebContrat);
            manager.flush();
            return consultaWebContrat;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ConsultaWebContratDAO");
            }
    }
    
    public SiiConsultaWebContrat actualizarConsultaWebContrat(SiiConsultaWebContrat consultaWebContrat) throws ExcepcionDAO {
        try {
            manager.merge(consultaWebContrat);
            manager.flush();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ConsultaWebContratDAO");
            }
        return consultaWebContrat;
    }

    public void eliminarConsultaWebContrat(Long idConsultaWebCont) throws ExcepcionDAO {
        try {
            SiiConsultaWebContrat borrarConsultaWebContrat = (SiiConsultaWebContrat) manager.find(SiiConsultaWebContrat.class, idConsultaWebCont);
            manager.remove(borrarConsultaWebContrat);
            manager.flush();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ConsultaWebContratDAO");
        }
    }
    
    public List<SiiConsultaWebContrat> buscarTodoConsultaWebContrat() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiConsultaWebContrat"); 
            Query query = manager.createQuery(sql.toString()); 
            
            List<SiiConsultaWebContrat> listaConsultaWebContrat = query.getResultList();
            return listaConsultaWebContrat;
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ConsultaWebContratDAO");
        }
    }
    
}
