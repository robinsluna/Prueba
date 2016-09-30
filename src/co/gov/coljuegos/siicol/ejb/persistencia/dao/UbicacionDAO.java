package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoUbicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
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
public class UbicacionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    public UbicacionDAO() {
        recursos = new Recursos();
    }
    public SiiUbicacion buscarUbicacionPorId(String idUbicacion) throws ExcepcionDAO{
        SiiUbicacion siiUbicacion = null;
        try{
            siiUbicacion = (SiiUbicacion) manager.find(SiiUbicacion.class, idUbicacion);            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiUbicacion;
    }
    
    /*
     * Tipo de Ubicación
     * 1 País
     * 2 Departamento
     * 3 Ciudad
     * 4 Barrio
     */
    public List<SiiUbicacion>  buscarUbicacionTipoUbicacion(Long idTipoUbicacion) throws ExcepcionDAO{
        List<SiiUbicacion> listaUbicacion = null;
        try{            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT u FROM SiiUbicacion u ");
            sql.append("WHERE u.siiTipoUbicacion.tiuCodigo = :idTipoUbicacion ORDER BY u.ubiNombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idTipoUbicacion", idTipoUbicacion);
            listaUbicacion = query.getResultList();      
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaUbicacion;
    }
    
    public List<SiiUbicacion>  buscarUbicacionPorPadre(String idPadre)throws ExcepcionDAO{
        List<SiiUbicacion> listaUbicacion = null;
        try{            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT lg FROM SiiUbicacion lg");
            sql.append(" WHERE lg.ubiCodigoPadre = :idPadre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPadre", idPadre);
            listaUbicacion = query.getResultList();      
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaUbicacion;
    }
    
    /**
     * Metodo que se encarga de consultar todos los paises 
     * @author Giovanni 
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiUbicacion> buscarUbicacionPaises() throws ExcepcionDAO {
        List<SiiUbicacion> ubicacionPaises = new ArrayList<SiiUbicacion>(); 
        
        long codigoTipoUbicacionPais = EnumTipoUbicacion.PAIS.getTiuCodigo(); 
        
        try {
            
            StringBuilder sql = new  StringBuilder();
            sql.append("SELECT u FROM SiiUbicacion u");
            sql.append(" WHERE u.siiTipoUbicacion.tiuCodigo = :codigoTipoUbicacion");
            sql.append(" ORDER BY u.ubiNombre ASC");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoTipoUbicacion", codigoTipoUbicacionPais);
            
            ubicacionPaises = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return ubicacionPaises;
    }
    
    
    /**
     * Metodo que se encarga de consultar todos los departamentos 
     * @author Giovanni 
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiUbicacion> buscarUbicacionDepartamento() throws ExcepcionDAO {
        List<SiiUbicacion> ubicacionDepartamentos = new ArrayList<SiiUbicacion>(); 
        
        long codigoTipoUbicacionDepartamentos = EnumTipoUbicacion.DEPARTAMENTO.getTiuCodigo(); 
        
        try {
            
            StringBuilder sql = new  StringBuilder();
            sql.append("SELECT u FROM SiiUbicacion u");
            sql.append(" WHERE u.siiTipoUbicacion.tiuCodigo = :codigoTipoUbicacion");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoTipoUbicacion", codigoTipoUbicacionDepartamentos);
            
            ubicacionDepartamentos = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return ubicacionDepartamentos;
    }
    
    /**
     * Metodo que se encarga de consultar todas ciudades del departamento 
     * @author Giovanni 
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiUbicacion> buscarUbicacionCiudadesXDepartamento(String codigoDepartamento) throws ExcepcionDAO {
        List<SiiUbicacion> ubicacionCiudades = new ArrayList<SiiUbicacion>(); 
        
        try {
            
            StringBuilder sql = new  StringBuilder();
            sql.append("SELECT u FROM SiiUbicacion u");
            sql.append(" WHERE u.ubiCodigoPadre = :codigoUbicacion");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoUbicacion", codigoDepartamento);
            
            ubicacionCiudades = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return ubicacionCiudades;
    }

    public List<SiiUbicacion> buscarTodaUbicacion( ) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT a FROM SiiUbicacion a  ");
            sql.append(" order by a.ubiCodigo asc ");
            Query query = manager.createQuery(sql.toString());
           
            List<SiiUbicacion> listaSiiUbicacion = query.getResultList();
            return listaSiiUbicacion;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    
}
