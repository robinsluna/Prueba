package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRepartoFiscalizador;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class RepartoFiscalizadorDAO extends AbstractDAO<Long, SiiRepartoFiscalizador>{
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    
    public RepartoFiscalizadorDAO() {
        super(SiiRepartoFiscalizador.class);
        recursos = new Recursos();
    }
    
    /**
     * Realiza la b&uacute;squeda de TODOS los registros correspondientes a la Entidad base.
     * @return List of SiiRepartoFiscalizador
     * @throws ExcepcionDAO
     */
    public List<SiiRepartoFiscalizador> buscarTodo() throws ExcepcionDAO 
    {
        List<SiiRepartoFiscalizador> lista = null;
        
        try {                
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRepartoFiscalizador o");
            Query query = em.createQuery(sql.toString());
            lista = query.getResultList();
            
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    public SiiRepartoFiscalizador buscarRepartoFiscalizPorId(Long rfsCodigo) throws ExcepcionDAO {
        
        SiiRepartoFiscalizador siiRepartoFiscalizador = null;
        
        try {
            siiRepartoFiscalizador = (SiiRepartoFiscalizador) manager.find(SiiRepartoFiscalizador.class, rfsCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRepartoFiscalizador;
    }
    
    public SiiRepartoFiscalizador buscarRepartoFiscalizPorIcnCodigo(Long icnCodigo) throws ExcepcionDAO {

        SiiRepartoFiscalizador siiRepartoFiscalizador = null;
        List<SiiRepartoFiscalizador> listaRepartos = new ArrayList<SiiRepartoFiscalizador>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRepartoFiscalizador o WHERE o.siiIncumplimientoContr.icnCodigo = :icnCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("icnCodigo", icnCodigo);
            listaRepartos = query.getResultList();

            if (listaRepartos.size() > 0) {
                siiRepartoFiscalizador = listaRepartos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRepartoFiscalizador;
    }
    
    public SiiRepartoFiscalizador buscarRepartoFiscalizPorIcnCodigoYActivo(Long icnCodigo) throws ExcepcionDAO {

        SiiRepartoFiscalizador siiRepartoFiscalizador = null;
        List<SiiRepartoFiscalizador> listaRepartos = new ArrayList<SiiRepartoFiscalizador>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRepartoFiscalizador o WHERE o.siiIncumplimientoContr.icnCodigo = :icnCodigo and o.rfsActivo = 'S'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("icnCodigo", icnCodigo);
            listaRepartos = query.getResultList();

            if (listaRepartos.size() > 0) {
                siiRepartoFiscalizador = listaRepartos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRepartoFiscalizador;
    }
    
    public SiiRepartoFiscalizador insertarSiiRepartoFiscalizador(SiiRepartoFiscalizador siiRepartoFiscalizador) throws ExcepcionDAO {
        try {
            manager.persist(siiRepartoFiscalizador);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRepartoFiscalizador;
    }
    
    public SiiRepartoFiscalizador actualizarSiiReparto(SiiRepartoFiscalizador siiRepartoFiscalizador) throws ExcepcionDAO {
        try {
            manager.merge(siiRepartoFiscalizador);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRepartoFiscalizador;
    }
    
    public List<SiiRepartoFiscalizador> buscarRepartoFiscalizActivos() throws ExcepcionDAO {

        List<SiiRepartoFiscalizador> listaRepartos = new ArrayList<SiiRepartoFiscalizador>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRepartoFiscalizador o WHERE o.rfsActivo = 'S' AND o.siiFiscalizadorSustanc.siiTipoActuacion.tacCodigo is not null order by 1 desc");
            Query query = manager.createQuery(sql.toString());
            listaRepartos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRepartos;
    }
    
    public SiiRepartoFiscalizador buscarPorCodigo(Long idCodigoEstabl) throws ExcepcionDAO {
        SiiRepartoFiscalizador resultado = null;
        try {
            resultado = (SiiRepartoFiscalizador) manager.find(SiiRepartoFiscalizador.class, idCodigoEstabl);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
        return resultado;
    }
    

    
}
