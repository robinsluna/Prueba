package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrdenInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncOrdTraInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicOrdTraInfVerif;
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

public class MunicOrdTraInfVerifDAO{
   
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
   
    public MunicOrdTraInfVerifDAO(){
        recursos = new Recursos();
    }
    
    public SiiMunicOrdTraInfVerif insertarMunicOrdTraInfVerif(SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif) throws ExcepcionDAO {
        try {
            manager.persist(siiMunicOrdTraInfVerif);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiMunicOrdTraInfVerif;
    }
    
    public SiiMunicOrdTraInfVerif buscarMunicOrdTraInfVerifPorId(Long idMunOrdVer) throws ExcepcionDAO {
        SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif = null;
        try {
            siiMunicOrdTraInfVerif = manager.find(SiiMunicOrdTraInfVerif.class, idMunOrdVer);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "MunicOrdTraInfVerifDAO");
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiMunicOrdTraInfVerif;
    }
    
    public void borrarSiiMunicOrdTraInfVerif(Long mivCodigo) throws ExcepcionDAO {
        SiiMunicOrdTraInfVerif Borrar = null;
        try {
         Borrar = manager.find(SiiMunicOrdTraInfVerif.class, mivCodigo);
            manager.remove(Borrar);
            manager.flush();
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "MunicOrdTraInfVerifDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    public List<SiiMunicOrdTraInfVerif> buscarMunicOrdTraInfVerifPorMotCodigo(Long motCodigo) throws ExcepcionDAO {
        List<SiiMunicOrdTraInfVerif> listaMunicOrdTraInfVerif = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT m FROM SiiMunicOrdTraInfVerif m WHERE m.siiMunicipioOrdenTrab.motCodigo = :motCodigo   ");
            sql.append(" and (m.mivActivo is null or m.mivActivo = 'S') ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("motCodigo", motCodigo);
            listaMunicOrdTraInfVerif = query.getResultList();
            return listaMunicOrdTraInfVerif;
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "BarrioOrdenInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    public SiiMunicOrdTraInfVerif actualizarBarrioOrdenInfVer(SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif) throws ExcepcionDAO{
      
        try{            
            manager.merge(siiMunicOrdTraInfVerif);
        } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "BarrioOrdenInfVerDAO");
        }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiMunicOrdTraInfVerif;
    }
    
    
}
