package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrdenInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeVerificCampo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
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
public class BarrioOrdenInfVerDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public BarrioOrdenInfVerDAO() {
        recursos = new Recursos();
    }
    
    
    public SiiBarrioOrdenInfVer insertarSiiBarrioOrdenInfVer(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer) throws ExcepcionDAO {
        try {
            manager.persist(siiBarrioOrdenInfVer);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiBarrioOrdenInfVer;
    }
    
    public SiiBarrioOrdenInfVer buscarBarrioOrdenInfVerPorId(Long idInfVeriCampo) throws ExcepcionDAO {
        SiiBarrioOrdenInfVer siiBarrioOrdenInfVer = null;
        try {
            siiBarrioOrdenInfVer = manager.find(SiiBarrioOrdenInfVer.class, idInfVeriCampo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "BarrioOrdenInfVerDAO");
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiBarrioOrdenInfVer;
    }
  
  
    public List<SiiBarrioOrdenInfVer> buscarBarrioOrdenInfVerPorBorCodigo(Long borCodigo) throws ExcepcionDAO {
        List<SiiBarrioOrdenInfVer> listaBarrioOrdenInfVer = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT b FROM SiiBarrioOrdenInfVer b WHERE b.siiBarrioOrden.borCodigo = :borCodigo");
            sql.append(" and (b.bivActivo is null or b.bivActivo = 'S') ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("borCodigo", borCodigo);
            listaBarrioOrdenInfVer = query.getResultList();
            return listaBarrioOrdenInfVer;
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "BarrioOrdenInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    public void borrarSiiBarrioOrdenInfVer(Long borCodigo) throws ExcepcionDAO {
        SiiBarrioOrdenInfVer Borrar = null;
        try {
         Borrar = manager.find(SiiBarrioOrdenInfVer.class, borCodigo);
            manager.remove(Borrar);
            manager.flush();
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "BarrioOrdenInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    public SiiBarrioOrdenInfVer actualizarBarrioOrdenInfVer(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer) throws ExcepcionDAO{
      
        try{            
            manager.merge(siiBarrioOrdenInfVer);
        } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "ElementoIlegInfVerDAO");
        }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiBarrioOrdenInfVer;
    }
    
    
}
