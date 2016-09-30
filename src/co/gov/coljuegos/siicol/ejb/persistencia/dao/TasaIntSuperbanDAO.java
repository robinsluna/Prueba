package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaIntSuperban;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class TasaIntSuperbanDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    /**
     *Metodo encargado de hacer el registro de una tasa de intereses
     * @author David Tafur
     * @param siiTasaIntSuperban
     * @return
     * @throws ExcepcionDAO
     */
    public SiiTasaIntSuperban insertarSiiTasaIntSuperban(SiiTasaIntSuperban siiTasaIntSuperban) throws ExcepcionDAO {
        try {
            manager.persist(siiTasaIntSuperban); //La guarda en el almacen
            manager.flush(); //Pasa a la Bd
            return siiTasaIntSuperban; //Retorna la entidad

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TasaIntSuperbanDAO");
        }
    }

    /**
     *Metodo encargado de hacer la actualizacion de una tasa de intereses
     * @author David Tafur
     * @param siiTasaIntSuperban
     * @return
     * @throws ExcepcionDAO
     */
    public SiiTasaIntSuperban actualizarSiiTasaIntSuperban(SiiTasaIntSuperban siiTasaIntSuperban) throws ExcepcionDAO {
        try {
            manager.merge(siiTasaIntSuperban); //La actualiza en el almacen
            manager.flush(); //Pasa a la Bd
            return siiTasaIntSuperban; //Retorna la entidad

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TasaIntSuperbanDAO");
        }
    }

    /**
     *Metodo encargado de consulta el listado de tasas interes
     * @author David Tafur
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiTasaIntSuperban> consultarListaTasaIntSuperban() throws ExcepcionDAO {
        List<SiiTasaIntSuperban> listaTasaIntSuperban = new ArrayList<SiiTasaIntSuperban>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("Select u FROM SiiTasaIntSuperban u ORDER BY u.tisCodigo DESC");

            Query consulta = manager.createQuery(sql.toString());
            listaTasaIntSuperban = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TasaIntSuperbanDAO");
        }
        return listaTasaIntSuperban;
    }
    
    public SiiTasaIntSuperban buscarTasaIntSuperbanPorId(BigDecimal idTasaIntSuperban) throws ExcepcionDAO{
        SiiTasaIntSuperban siiTasaIntSuperban = null;
        try{
            siiTasaIntSuperban = manager.find(SiiTasaIntSuperban.class, idTasaIntSuperban);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"TasaIntSuperbanDAO");
        }
        return siiTasaIntSuperban;
    }
    
    /**
     *Metodo encargado de consultar la tasa de interes Activa
     * @author Mónica Pabón
     * @return
     * @throws ExcepcionDAO
     */
    public SiiTasaIntSuperban consultarTasaIntSuperbanActiva() throws ExcepcionDAO {
        SiiTasaIntSuperban tasaIntSuperban = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("Select u FROM SiiTasaIntSuperban u where u.tisActivo = 'S' ");

            Query consulta = manager.createQuery(sql.toString());
            tasaIntSuperban = (SiiTasaIntSuperban) consulta.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TasaIntSuperbanDAO");
        }
        return tasaIntSuperban;
    }
    
    public SiiTasaIntSuperban consultarTasaIntSuperbanXFecha(Date fecha) throws ExcepcionDAO {
        SiiTasaIntSuperban siiTasaIntSuperban = new SiiTasaIntSuperban();
        List<SiiTasaIntSuperban>  listSiiTasaIntSuperban = new ArrayList();
        System.out.println(fecha);   
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("Select u FROM SiiTasaIntSuperban u  where ");
            sql.append(" :fecha between u.tisVigenDesde and u.tisVigenHasta  order by u.tisCodigo desc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("fecha", fecha);
            listSiiTasaIntSuperban =  query.getResultList();
            if(listSiiTasaIntSuperban.size()>0)
                return listSiiTasaIntSuperban.get(0);
            else 
                 return siiTasaIntSuperban; 
       
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TasaIntSuperbanDAO");
        }
    }
    
    public List<SiiTasaIntSuperban> consultarTasasIntSuperbanDesdeXFecha(Date fecha) throws ExcepcionDAO {
        SiiTasaIntSuperban siiTasaIntSuperban = new SiiTasaIntSuperban();
        List<SiiTasaIntSuperban>  listSiiTasaIntSuperban = new ArrayList();
        Date fechaActual = new Date(); 
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" Select u FROM SiiTasaIntSuperban u  where  ");
            sql.append(" fecha >= u.tisVigenDesde and u.tisVigenHasta <= fechaActual order by u.tisVigenDesde asc ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("fecha", fecha);
            query.setParameter("fechaActual", fechaActual);
            listSiiTasaIntSuperban =  query.getResultList();  
            return listSiiTasaIntSuperban; 
       
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TasaIntSuperbanDAO");
        }
    }
    
    public List<SiiTasaIntSuperban> consultarListaTasasIntSuperbanDesdeFecha(Date fecha) throws ExcepcionDAO {
        SiiTasaIntSuperban siiTasaIntSuperban = new SiiTasaIntSuperban();
        List<SiiTasaIntSuperban>  listSiiTasaIntSuperban = new ArrayList();
        Date fechaActual = new Date(); 
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" Select u FROM SiiTasaIntSuperban u  where  ");
            sql.append(" :fecha between u.tisVigenDesde and u.tisVigenHasta ");
            sql.append(" or u.tisVigenDesde  >= :fecha    order by u.tisVigenDesde asc");  
            Query query = manager.createQuery(sql.toString());
            query.setParameter("fecha", fecha);
            listSiiTasaIntSuperban =  query.getResultList();  
            return listSiiTasaIntSuperban; 
       
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TasaIntSuperbanDAO");
        }
    }
    
}
