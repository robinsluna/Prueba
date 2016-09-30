package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoOtrosi;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOtrosi;
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
public class OtroSiDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public OtroSiDAO() {
        recursos = new Recursos();
    }
    
    public SiiOtrosi insertarSiiOtroSi(SiiOtrosi otroSi) throws ExcepcionDAO {
        try {
            manager.persist(otroSi); 
            manager.flush(); 
            return    otroSi;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OtroSiDAO");
        }
    }            

    public SiiOtrosi actualizarSiiOtroSi(SiiOtrosi otroSi) throws ExcepcionDAO {
        try {
            manager.merge(otroSi);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OtroSiDAO");
        }
        return otroSi;
    }
   
    public Long siguienteNumeroOtroSi() throws ExcepcionDAO {
        Long i;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append ("SELECT max(o.osiConsecutivo) FROM SiiOtrosi o");
            Query query = manager.createQuery(sql.toString());
            i = (Long) query.getSingleResult();
            if (i==null) {
                i = 1L;
            }
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OtroSiDAO");
        }
        return i+1L;
    }
   
    public SiiOtrosi buscarOtroSiPorId(Long osiCodigo) throws ExcepcionDAO {
        SiiOtrosi siiOtroSi = null;
        try {
            siiOtroSi = (SiiOtrosi) manager.find(SiiOtrosi.class, osiCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OtroSiDAO");
        }
        return siiOtroSi;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiOtrosi> otrosiPerfeccionadosSinPolizasPendientes() throws ExcepcionDAO {
        List<SiiOtrosi> siiOtrosis = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT osi FROM SiiOtrosi osi");
            sql.append(" WHERE NOT EXISTS(");
            sql.append(" SELECT pcc FROM SiiPolizaContrat pcc");
            sql.append(" WHERE pcc.siiOtrosi.osiCodigo = osi.osiCodigo)");
            sql.append(" AND osi.siiEstadoOtrosi.eosCodigo = :estadoPerfeccionado");
            sql.append(" ORDER BY osi.osiConsecutivo DESC");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estadoPerfeccionado", EnumEstadoOtrosi.PERFECCIONADO.getId()); 
            
            siiOtrosis = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OtroSiDAO");
        }
        return siiOtrosis;
    }

    public List<SiiOtrosi> buscarOtroSiPorIdContrato(Long conCodigo) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT o.siiOtrosi FROM SiiNovedad o  WHERE o.siiContrato.conCodigo = :conCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo); 
            
            List<SiiOtrosi> listaOtroSi =  query.getResultList();
            return listaOtroSi;
        
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OtroSiDAO");
        }
    }
}
