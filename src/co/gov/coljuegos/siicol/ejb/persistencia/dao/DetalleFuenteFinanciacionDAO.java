/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 19-09-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
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

public class DetalleFuenteFinanciacionDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public DetalleFuenteFinanciacionDAO() {
        recursos = new Recursos();
    }
    
    public SiiDtlleFuenteFinanciacion buscarDtlleFuenteFinanciacionPorId(Long idDtlleFuenteFinanciacion) throws ExcepcionDAO{
       SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacionRetorno = null;
        try{
            siiDtlleFuenteFinanciacionRetorno = (SiiDtlleFuenteFinanciacion) manager.find(SiiDtlleFuenteFinanciacion.class, idDtlleFuenteFinanciacion);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleFuenteFinanciacionDAO");
        }
        return siiDtlleFuenteFinanciacionRetorno; 
    }
    
    public SiiDtlleFuenteFinanciacion buscarCodDetFuenteFinanciacionPorNombre(Integer codigoRecurso) throws ExcepcionDAO{
        SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacionRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT detFteFin FROM SiiDtlleFuenteFinanciacion detFteFin");
            sql.append(" WHERE detFteFin.dffCodigoRecurso = :nombreDetFuente");
            Query query = manager.createQuery(sql.toString());
            //query.setParameter("nombreDetFuente", siiDtlleFuenteFinanciacion.getDffCodigoRecurso());
            query.setParameter("nombreDetFuente", codigoRecurso);
            List<SiiDtlleFuenteFinanciacion> listaEntidadesDetFteFin = query.getResultList();
            
            if (listaEntidadesDetFteFin != null && !listaEntidadesDetFteFin.isEmpty()) {
                siiDtlleFuenteFinanciacionRetorno = listaEntidadesDetFteFin.get(0);
        }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleFuenteFinanciacionDAO");
        }
        return siiDtlleFuenteFinanciacionRetorno;
    }
    
    public SiiDtlleFuenteFinanciacion buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre(String nombreFuente, String nombreDetFuente) throws ExcepcionDAO{
        SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacionRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT detFteFin FROM SiiDtlleFuenteFinanciacion detFteFin");
            sql.append(" INNER JOIN detFteFin.siiFuenteFinanciacion fteFin");
            sql.append(" WHERE fteFin.ffiDescripcion = :nombreFuente");
            sql.append(" AND detFteFin.dffDescripcion = :nombreDetFuente");
            Query query = manager.createQuery(sql.toString());
            //query.setParameter("nombreDetFuente", siiDtlleFuenteFinanciacion.getDffCodigoRecurso());
            query.setParameter("nombreFuente", nombreFuente);
            query.setParameter("nombreDetFuente", nombreDetFuente);
            List<SiiDtlleFuenteFinanciacion> listaEntidadesDetFteFin = query.getResultList();
            
            if (listaEntidadesDetFteFin != null && !listaEntidadesDetFteFin.isEmpty()) {
                siiDtlleFuenteFinanciacionRetorno = listaEntidadesDetFteFin.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleFuenteFinanciacionDAO");
        }
        return siiDtlleFuenteFinanciacionRetorno;
    }
    
    public SiiDtlleFuenteFinanciacion buscarCodDetFuenteFinanciacionPorCodigoFuenteCodigoRecurso(Integer codigoFuente, Integer codigoRecurso) throws ExcepcionDAO{
        SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacionRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT detFteFin FROM SiiDtlleFuenteFinanciacion detFteFin");
            sql.append(" INNER JOIN detFteFin.siiFuenteFinanciacion fteFin");
            sql.append(" WHERE fteFin.ffiCodigoFuente = :codigoFuente");
            sql.append(" AND detFteFin.dffCodigoRecurso = :codigoRecurso");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoFuente", codigoFuente);
            query.setParameter("codigoRecurso", codigoRecurso);
            List<SiiDtlleFuenteFinanciacion> listaEntidadesDetFteFin = query.getResultList();
            
            if (listaEntidadesDetFteFin != null && !listaEntidadesDetFteFin.isEmpty()) {
                siiDtlleFuenteFinanciacionRetorno = listaEntidadesDetFteFin.get(0);
                System.out.println("dffCodigo: "+siiDtlleFuenteFinanciacionRetorno.getDffCodigo());
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleFuenteFinanciacionDAO");
        }
        return siiDtlleFuenteFinanciacionRetorno;
    }
    
    /*
     * Por Gatopardo
     * A diferencia del metodo anterior la búsqueda se hace por los códigos de la fuente y el detalle de fuente
     * el metodo anterior busca por el id de la fuente de financiacion
     */
    public SiiDtlleFuenteFinanciacion buscarDetFuenteFinanciacionPorCodigoFuentePorCodigoRecurso(Integer codigoFuente, Integer codigoRecurso) throws ExcepcionDAO{
        SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacionRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT detFteFin FROM SiiDtlleFuenteFinanciacion detFteFin");
            sql.append(" INNER JOIN detFteFin.siiFuenteFinanciacion fteFin");
            sql.append(" WHERE fteFin.ffiCodigoFuente = :codigoFuente");
            sql.append(" AND detFteFin.dffCodigoRecurso = :codigoRecurso");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoFuente", codigoFuente);
            query.setParameter("codigoRecurso", codigoRecurso);
            List<SiiDtlleFuenteFinanciacion> listaEntidadesDetFteFin = query.getResultList();
            
            if (listaEntidadesDetFteFin != null && !listaEntidadesDetFteFin.isEmpty()) {
                siiDtlleFuenteFinanciacionRetorno = listaEntidadesDetFteFin.get(0);
                System.out.println("dffCodigo: "+siiDtlleFuenteFinanciacionRetorno.getDffCodigo());
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleFuenteFinanciacionDAO");
        }
        return siiDtlleFuenteFinanciacionRetorno;
    }

    public SiiDtlleFuenteFinanciacion insertarDtlleFuenteFinanciacion(SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion) throws ExcepcionDAO{
        try{
            manager.persist(siiDtlleFuenteFinanciacion);                                                                                                //La guarda en el almacen
            manager.flush();                                                                                                                            //Pasa a la Bd
            return siiDtlleFuenteFinanciacion;                                                                                                         //Retorna la Entidad
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleFuenteFinanciacionDAO");
        }
    }
    
    public SiiDtlleFuenteFinanciacion actualizarDtlleFuenteFinanciacion(SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion) throws ExcepcionDAO{
        try{
            manager.merge(siiDtlleFuenteFinanciacion);
            manager.flush();
            return siiDtlleFuenteFinanciacion;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleFuenteFinanciacionDAO");
        }
    }
    
    public void eliminarDtlleFuenteFinanciacion(Long idDetalleFuente) throws ExcepcionDAO{
        SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacionBorrar = null;
        try{
            siiDtlleFuenteFinanciacionBorrar = (SiiDtlleFuenteFinanciacion) manager.find(SiiDtlleFuenteFinanciacion.class, idDetalleFuente);
            manager.remove(siiDtlleFuenteFinanciacionBorrar);
            manager.flush();
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleFuenteFinanciacionDAO");
        }
    }
    
    public List<SiiDtlleFuenteFinanciacion> buscarTodoDetalleFuentePorFuenteFin(SiiFuenteFinanciacion siiFuenteFinanciacion)
            throws ExcepcionDAO{
        try{
            //List<DetFuenteFinanciacionVO> listaDetalleFuentesFinanciacionVo = new ArrayList();
            //List<SiiDtlleFuenteFinanciacion> listaEntidadesDetFteFin = new ArrayList();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT detFteFin FROM SiiDtlleFuenteFinanciacion detFteFin");
            sql.append(" WHERE detFteFin.siiFuenteFinanciacion.ffiCodigo = :codigoFuente");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoFuente", siiFuenteFinanciacion.getFfiCodigo());
            List<SiiDtlleFuenteFinanciacion> listaEntidadesDetFteFin = query.getResultList();
            /*
            for(SiiDtlleFuenteFinanciacion unaEntidadDtlleFuenteFinan : listaEntidadesDetFteFin){
                    DetFuenteFinanciacionVO nuevoDtlleFuenteFinVO = new DetFuenteFinanciacionVO();
                    nuevoDtlleFuenteFinVO = nuevoDtlleFuenteFinVO.convertirEntidadAVO(unaEntidadDtlleFuenteFinan);
                    listaDetalleFuentesFinanciacionVo.add(nuevoDtlleFuenteFinVO);
            }
            */
            return listaEntidadesDetFteFin;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleFuenteFinanciacionDAO");
        }
    }
}
