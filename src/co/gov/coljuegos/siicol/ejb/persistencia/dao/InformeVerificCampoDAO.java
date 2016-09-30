package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrdenInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeVerificCampo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;

import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.Date;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class InformeVerificCampoDAO{
 
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

 
    public InformeVerificCampoDAO(){
        recursos = new Recursos();
    }
    
    public SiiInformeVerificCampo insertarInformeVerificCampo(SiiInformeVerificCampo siiInformeVerificCampo) throws ExcepcionDAO {
        try {
            manager.persist(siiInformeVerificCampo);
            manager.flush();
            return siiInformeVerificCampo;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InformeVerificCampoDAO");
        }   catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    public SiiInformeVerificCampo buscarInformeVerificCampoPorId(Long idInfVeriCampo) throws ExcepcionDAO {
        SiiInformeVerificCampo siiInformeVerificCampoRetorno = null;
        try {
            siiInformeVerificCampoRetorno = manager.find(SiiInformeVerificCampo.class, idInfVeriCampo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "InformeVerificCampoDAO");
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiInformeVerificCampoRetorno;
    }
    
    
    public SiiInformeVerificCampo buscarSiiInformeVerificCampoPorOrdenId(Long otvCodigo) throws ExcepcionDAO {
        List<SiiInformeVerificCampo> listSiiInformeVerificCampo = null;
        SiiInformeVerificCampo siiInformeVerificCampo = null ;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT b FROM SiiInformeVerificCampo b WHERE b.siiOrdenTrabajoVisita.otvCodigo = :otvCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("otvCodigo", otvCodigo);
            listSiiInformeVerificCampo = query.getResultList();
            if(listSiiInformeVerificCampo.size()>0)
                return listSiiInformeVerificCampo.get(0);
            else 
                return siiInformeVerificCampo;
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "BarrioOrdenInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
}
