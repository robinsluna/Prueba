package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProIle;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class TramiteResolProIleDAO  extends AbstractDAO<Long,SiiTramiteResolProIle>{
    /**
     * Constructor.
     */
    public TramiteResolProIleDAO() {
        super(SiiTramiteResolProIle.class);
    }
    
    
    
    /**
     * Busca la Fecha del Tr&aacute;mite de Resoluci&oacute;n por Resoluci&oacute;n y Estado de Tr&aacute;mite.
     * @param rpiCodigo - C&oacute;digo de la Resoluci&oacute;n.
     * @param etrCodigo - Estado del Tr&aacute;mite.
     * @return Fecha del Tr&aacute;mite de Resoluci&oacute;n.
     * @throws ExcepcionDAO
     */
    public Date fechaResolucionSancionatoriaPorEstado(Long rpiCodigo, Long etrCodigo) throws ExcepcionDAO {
        Date fecha = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o.tpiFecha from SiiTramiteResolProIle o where o.siiResolucionProcIleg.rpiCodigo = :rpiCodigo and o.siiEstadoTramResProcIleg.etrCodigo = :etrCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("rpiCodigo", rpiCodigo);
            query.setParameter("etrCodigo", etrCodigo);
            
            List<Date> result = query.getResultList();
            if (result!=null && !result.isEmpty())
                fecha = result.get(0);
        }
        catch (NoResultException e) {
            fecha = null;
            //e.printStackTrace();
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        catch (Exception e) {
            throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
        }
        return fecha;
    }
    
    
    
    public List<SiiTramiteResolProIle> buscarTramiteResolProIlePorIdResolucion(Long rpiCodigo) throws ExcepcionDAO {
        List<SiiTramiteResolProIle> tramites = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiTramiteResolProIle o where o.siiResolucionProcIleg.rpiCodigo = :rpiCodigo order by o.tpiCodigo DESC");
            Query query = em.createQuery(sql.toString());
            query.setParameter("rpiCodigo", rpiCodigo);
            tramites =  query.getResultList();
            return tramites;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        catch (Exception e) {
            throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
        }
    }
}
