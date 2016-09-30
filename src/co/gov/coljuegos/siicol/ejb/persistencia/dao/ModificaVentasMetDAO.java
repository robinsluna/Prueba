package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificaVentasMet;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ModificaVentasMetDAO extends GenericDAO<SiiModificaVentasMet>{
    public ModificaVentasMetDAO() {
        super(SiiModificaVentasMet.class);
    }
    
    public SiiModificaVentasMet actualizarSiiModificaVentasMet(SiiModificaVentasMet modificaVentasMet) throws ExcepcionDAO {
        try {
            em.merge(modificaVentasMet); 
            em.flush(); 
            return modificaVentasMet; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificaVentasMetDAO");
        }
    }
    
    public List<SiiModificaVentasMet> buscarModificacionesVentasPorReporteVentas(Long idReporteVentas) throws ExcepcionDAO{
         List<SiiModificaVentasMet> listaSiiModificaVentasMet = null;
         try{
             listaSiiModificaVentasMet = new ArrayList();           
             StringBuilder sql = new StringBuilder();
             sql.append("SELECT mv FROM SiiModificaVentasMet mv");
             sql.append(" WHERE mv.siiReporteVentas.rveCodigo = :idReporteVentas ");
             Query query = em.createQuery(sql.toString());
             query.setParameter("idReporteVentas", idReporteVentas);
             
             listaSiiModificaVentasMet = query.getResultList();
             
         } catch (PersistenceException pe) {
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         } catch (Exception ex) {
             ex.printStackTrace();
             throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
         }
         
         return listaSiiModificaVentasMet;
     }
    
    public List<SiiModificaVentasMet> buscarModificacionesVentasPorCodigoVentasYRpteVtas(Long idVentas, Long idReporteVtas) throws ExcepcionDAO{
         List<SiiModificaVentasMet> listaSiiModificaVentasMet = null;
         try{
             listaSiiModificaVentasMet = new ArrayList();           
             StringBuilder sql = new StringBuilder();
             sql.append("SELECT mv FROM SiiModificaVentasMet mv");
             sql.append(" INNER JOIN mv.siiVentasMet vmet");
             sql.append(" INNER JOIN mv.siiReporteVentas rve");
             sql.append(" WHERE vmet.vmeCodigo = :idVentas and rve.rveCodigo = :idReporteVtas");
             sql.append(" ORDER BY mv.mvmCodigo DESC");
             Query query = em.createQuery(sql.toString());
             query.setParameter("idVentas", idVentas);
             query.setParameter("idReporteVtas", idReporteVtas);
             
             listaSiiModificaVentasMet = query.getResultList();
             
         } catch (PersistenceException pe) {
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         } catch (Exception ex) {
             ex.printStackTrace();
             throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
         }
         
         return listaSiiModificaVentasMet;
     }
    
}
