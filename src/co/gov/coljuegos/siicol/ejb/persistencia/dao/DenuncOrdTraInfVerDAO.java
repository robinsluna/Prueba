package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrdenInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdTraInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncOrdTraInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegInfVer;
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
public class DenuncOrdTraInfVerDAO{
   
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    
    public DenuncOrdTraInfVerDAO(){
  
        recursos = new Recursos();
    }
    
    public SiiDenuncOrdTraInfVer insertarDenuncOrdTraInfVer(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) throws ExcepcionDAO {
        try {
            manager.persist(siiDenuncOrdTraInfVer);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDenuncOrdTraInfVer;
    }
    
    public SiiDenuncOrdTraInfVer buscarDenuncOrdTraInfVerPorId(Long idDenuncia) throws ExcepcionDAO {
        SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer = null;
        try {
            siiDenuncOrdTraInfVer = manager.find(SiiDenuncOrdTraInfVer.class, idDenuncia);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "DenuncOrdTraInfVerDAO");
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiDenuncOrdTraInfVer;
    }
    
    public void borrarSiiDenuncOrdTraInfVer(Long divCodigo) throws ExcepcionDAO {
        SiiDenuncOrdTraInfVer Borrar = null;
        try {
         Borrar = manager.find(SiiDenuncOrdTraInfVer.class, divCodigo);
            manager.remove(Borrar);
            manager.flush();
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "DenuncOrdTraInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    public List<SiiDenuncOrdTraInfVer> buscarDenuncOrdTraInfVerPorDotCodigo(Long dotCodigo) throws ExcepcionDAO {
        List<SiiDenuncOrdTraInfVer> listaSiiDenuncOrdTraInfVer = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT d FROM SiiDenuncOrdTraInfVer d WHERE d.siiDenunciaOrdenTrab.dotCodigo = :dotCodigo");
            sql.append(" and (d.divActivo is null or d.divActivo = 'S' )");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("dotCodigo", dotCodigo);
            listaSiiDenuncOrdTraInfVer = query.getResultList();
            return listaSiiDenuncOrdTraInfVer;
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "DenuncOrdTraInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    public SiiDenuncOrdTraInfVer actualizarDenuncOrdTraInfVer(SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer) throws ExcepcionDAO{
      
        try{            
            manager.merge(siiDenuncOrdTraInfVer);
        } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "ElementoIlegInfVerDAO");
        }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDenuncOrdTraInfVer;
    }
    
    
    
}
