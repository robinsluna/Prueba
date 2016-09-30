package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrdenInfVer;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocConpes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoElemenIlegalidad;
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
public class ElementoIlegInfVerDAO{
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ElementoIlegInfVerDAO(){
        recursos = new Recursos();
    }
    
    public SiiElementoIlegInfVer insertarElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) throws ExcepcionDAO {
        try {
            manager.persist(siiElementoIlegInfVer);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiElementoIlegInfVer;
    }
    
    public SiiElementoIlegInfVer buscarElementoIlegInfVerPorId(Long idElemento) throws ExcepcionDAO {
        SiiElementoIlegInfVer siiElementoIlegInfVer = null;
        try {
            siiElementoIlegInfVer = manager.find(SiiElementoIlegInfVer.class, idElemento);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "ElementoIlegInfVerDAO");
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiElementoIlegInfVer;
    }
    
    public List<SiiElementoIlegInfVer> buscarElementosPorIdPadre(Long bivCodigo,Long mivCodigo, Long civCodigo, Long divCodigo) throws ExcepcionDAO {
        List<SiiElementoIlegInfVer> listaSiiElementoIlegInfVer = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT b FROM SiiElementoIlegInfVer b  left join b.siiDenuncOrdTraInfVer d  WHERE (b.eivActivo = 'S') ");
            if (bivCodigo != null )
                sql.append(" and b.siiBarrioOrdenInfVer.bivCodigo = :bivCodigo "); 
            if (mivCodigo != null )
                sql.append(" and  b.siiMunicOrdTraInfVerif.mivCodigo = :mivCodigo "); 
            if (civCodigo != null )
                sql.append(" and b.siiCuadranteOrdTraInfVer.civCodigo = :civCodigo ");
            if (divCodigo != null )
                sql.append(" and d.divCodigo = :divCodigo ");
            
            Query query = manager.createQuery(sql.toString());
            if (mivCodigo != null)
                query.setParameter("mivCodigo", mivCodigo);
            if (bivCodigo != null)    
                query.setParameter("bivCodigo", bivCodigo);
            if(civCodigo != null )
                query.setParameter("civCodigo", civCodigo);
            if(divCodigo != null )
                query.setParameter("divCodigo", divCodigo);
            
            listaSiiElementoIlegInfVer = query.getResultList();
            return listaSiiElementoIlegInfVer;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CotizacionEstudioDAO");
        }

    }
    
    public void borrarSiiElementoIlegInfVer(Long eivCodigo) throws ExcepcionDAO {
        SiiElementoIlegInfVer Borrar = null;
        try {
         Borrar = manager.find(SiiElementoIlegInfVer.class, eivCodigo);
            manager.remove(Borrar);
            manager.flush();
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "ElementoIlegInfVerDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
       
    public SiiElementoIlegInfVer actualizarElementoIlegInfVer(SiiElementoIlegInfVer siiElementoIlegInfVer) throws ExcepcionDAO{
      
        try{            
            manager.merge(siiElementoIlegInfVer);
        } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "ElementoIlegInfVerDAO");
        }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiElementoIlegInfVer;
    }
    
    
}
