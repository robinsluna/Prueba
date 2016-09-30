/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 24-09-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;

import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.DetFuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;

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
public class FuenteFinanciacionDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public FuenteFinanciacionDAO() {
        recursos = new Recursos();
    }
    
    public SiiFuenteFinanciacion buscarFuenteFinanciacionPorId(Long IdFuenteFinanciacion) throws ExcepcionDAO{
       SiiFuenteFinanciacion siiFuenteFinanciacionRetorno = null;
        try{
            siiFuenteFinanciacionRetorno = (SiiFuenteFinanciacion) manager.find(SiiFuenteFinanciacion.class, IdFuenteFinanciacion);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }
        return siiFuenteFinanciacionRetorno; 
    }
    
    public SiiFuenteFinanciacion buscarFuenteFinanciacionPorNombre(SiiFuenteFinanciacion siiFuenteFinanciacion) throws ExcepcionDAO{
        SiiFuenteFinanciacion siiFuenteFinanciacionRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT fteFin FROM SiiFuenteFinanciacion fteFin");
            sql.append(" WHERE fteFin.ffiNombre = :nombreFuente");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreFuente", siiFuenteFinanciacion.getFfiNombre());
            List<SiiFuenteFinanciacion> listaEntidadesFteFin = query.getResultList();
            
            if (listaEntidadesFteFin != null && !listaEntidadesFteFin.isEmpty()) {
                siiFuenteFinanciacionRetorno = listaEntidadesFteFin.get(0);
        }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            //throw new ExcepcionDAO(mensajeError,"FuenteFinanciacionDAO");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }
        //FuenteFinanciacionVO retornoFuenteFinanciacionVo = new FuenteFinanciacionVO();
        return siiFuenteFinanciacionRetorno;
    }
    
    public SiiFuenteFinanciacion buscarCodFuenteFinanciacionPorNombre(SiiFuenteFinanciacion siiFuenteFinanciacion) throws ExcepcionDAO{
        SiiFuenteFinanciacion siiFuenteFinanciacionRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT fteFin FROM SiiFuenteFinanciacion fteFin");
            sql.append(" WHERE fteFin.ffiCodigoFuente = :nombreFuente");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreFuente", siiFuenteFinanciacion.getFfiCodigoFuente());
            List<SiiFuenteFinanciacion> listaEntidadesFteFin = query.getResultList();
            
            if (listaEntidadesFteFin != null && !listaEntidadesFteFin.isEmpty()) {
                siiFuenteFinanciacionRetorno = listaEntidadesFteFin.get(0);
        }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }
        return siiFuenteFinanciacionRetorno;
    }
    
    public SiiFuenteFinanciacion insertarFuenteFinanciacion(SiiFuenteFinanciacion siiFuenteFinanciacion) throws ExcepcionDAO{
        try{
            manager.persist(siiFuenteFinanciacion);                                                                                     //La guarda en el almacen
            manager.flush();                                                                                                            //Pasa a la Bd
                                                                                                           //Retorna la Entidad
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return siiFuenteFinanciacion;
    }
    
    public SiiFuenteFinanciacion actualizarFuenteFinanciacion(SiiFuenteFinanciacion siiFuenteFinanciacion) throws ExcepcionDAO{
        try{
            manager.merge(siiFuenteFinanciacion);
            manager.flush();
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }
        return siiFuenteFinanciacion;
    }
    
    //public void eliminarFuenteFinanciacion(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO{
    public void eliminarFuenteFinanciacion(Long idFuenteFinanciacion) throws ExcepcionDAO{
        SiiFuenteFinanciacion siiFuenteFinanciacionBorrar = null;
        try{
            siiFuenteFinanciacionBorrar = (SiiFuenteFinanciacion) manager.find(SiiFuenteFinanciacion.class, idFuenteFinanciacion);          
            manager.remove(siiFuenteFinanciacionBorrar);
            manager.flush();
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }
    }
    
    public List<SiiFuenteFinanciacion> buscarTodoFteFinanciacionConDtle() throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT fteFin FROM SiiFuenteFinanciacion fteFin");
            Query query = manager.createQuery(sql.toString());
            List<SiiFuenteFinanciacion> listaEntidadesFteFin = query.getResultList();
            return listaEntidadesFteFin;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }

    }
    
    
    
    /**
     * Consulta el listado de Fuentes de Financiaci&oacute;n relacionadas con el c&oacute;digo de RP especificado.
     * @param rpCodigo - C&oacute;digo del RP.
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiFuenteFinanciacion> buscarFuenteFinanciacionPorRp(Long rpCodigo) throws ExcepcionDAO {
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ff FROM SiiFuenteFinanciacion ff, "); 
            sql.append("               SiiRp rp, ");
            sql.append("               SiiRpDetRubroCdp rpdrcdp, ");
            sql.append("               SiiDetalleRubroCdp drcdp, ");
            sql.append("               SiiDetalleRubro dr, "); 
            sql.append("               SiiDtlleFuenteFinanciacion dff "); 
            sql.append("WHERE rpdrcdp.siiRp.rpCodigo = rp.rpCodigo ");
            sql.append("AND rpdrcdp.siiDetalleRubroCdp.drcCodigo = drcdp.drcCodigo "); 
            sql.append("AND drcdp.siiDetalleRubro.druCodigo = dr.druCodigo "); 
            sql.append("AND dr.siiDtlleFuenteFinanciacion.dffCodigo = dff.dffCodigo ");
            sql.append("AND dff.siiFuenteFinanciacion.ffiCodigo = ff.ffiCodigo ");
            sql.append("AND rp.rpCodigo = :rpCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            List<SiiFuenteFinanciacion> listaEntidadesFteFin = query.getResultList();
            return listaEntidadesFteFin;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
        
}
