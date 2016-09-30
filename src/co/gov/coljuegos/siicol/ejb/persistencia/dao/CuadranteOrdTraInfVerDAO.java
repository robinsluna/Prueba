package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrdenInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdTraInfVer;
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
public class CuadranteOrdTraInfVerDAO{
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public CuadranteOrdTraInfVerDAO(){
        recursos = new Recursos();
    }
    
    public SiiCuadranteOrdTraInfVer insertarCuadranteOrdTraInfVer(SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer) throws ExcepcionDAO {
        try {
            manager.persist(siiCuadranteOrdTraInfVer);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuadranteOrdTraInfVer;
    }
    
    public SiiCuadranteOrdTraInfVer buscarCuadranteOrdTraInfVerPorId(Long idCuadrante) throws ExcepcionDAO {
        SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer = null;
        try {
            siiCuadranteOrdTraInfVer = manager.find(SiiCuadranteOrdTraInfVer.class, idCuadrante);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "CuadranteOrdTraInfVerDAO");
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiCuadranteOrdTraInfVer;
    }
    
    public void SiiCuadranteOrdTraInfVer(Long civCodigo) throws ExcepcionDAO {
        SiiCuadranteOrdTraInfVer Borrar = null;
        try {
         Borrar = manager.find(SiiCuadranteOrdTraInfVer.class, civCodigo);
            manager.remove(Borrar);
            manager.flush();
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "CuadranteOrdTraInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    public void borrarSiiCuadranteOrdTraInfVer(Long civCodigo) throws ExcepcionDAO {
        SiiCuadranteOrdTraInfVer Borrar = null;
        try {
         Borrar = manager.find(SiiCuadranteOrdTraInfVer.class, civCodigo);
            manager.remove(Borrar);
            manager.flush();
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "CuadranteOrdTraInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    public List<SiiCuadranteOrdTraInfVer> buscarCuadranteOrdTraInfVerPorCotCodigo(Long cotCodigo) throws ExcepcionDAO {
        List<SiiCuadranteOrdTraInfVer> listaCuadranteOrdTraInfVer = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT c FROM SiiCuadranteOrdTraInfVer c WHERE c.siiCuadranteOrdenTra.cotCodigo = :cotCodigo");
            sql.append(" and (c.civActivo is null or  c.civActivo = 'S' )");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("cotCodigo", cotCodigo);
            listaCuadranteOrdTraInfVer = query.getResultList();
            return listaCuadranteOrdTraInfVer;
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "BarrioOrdenInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    public SiiCuadranteOrdTraInfVer actualizarCuadranteOrdTraInfVer(SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer) throws ExcepcionDAO{
      
        try{            
            manager.merge(siiCuadranteOrdTraInfVer);
        } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "ElementoIlegInfVerDAO");
        }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuadranteOrdTraInfVer;
    }
    
    
    
}
