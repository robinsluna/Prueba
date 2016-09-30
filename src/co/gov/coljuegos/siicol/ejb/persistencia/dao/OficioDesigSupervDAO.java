package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioDesigSuperv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.EstadoProcContratVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioDesigSupervVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;

import java.math.BigDecimal;

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
public class OficioDesigSupervDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public OficioDesigSupervDAO() {
        recursos = new Recursos();
    }
    
    public SiiOficioDesigSuperv insertarOficioDesigSuperv (SiiOficioDesigSuperv siiOficioDesigSuperv) throws ExcepcionDAO{
        try{
            manager.persist(siiOficioDesigSuperv);
            manager.flush();
            return siiOficioDesigSuperv;
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OficioDesigSuperDAO");
        }
    }
    
    public List<SiiOficioDesigSuperv> buscarTodoOficioDesigSuperv () throws ExcepcionDAO{
        try{
            List<SiiOficioDesigSuperv> listaOficioDesigSuperv = new ArrayList<SiiOficioDesigSuperv>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ods FROM SiiOficioDesigSuper ods");
            Query query = manager.createQuery(sql.toString());
            listaOficioDesigSuperv = query.getResultList();
            return listaOficioDesigSuperv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"OficioDesigSuperDAO");
        }
    }
    
    public SiiOficioDesigSuperv buscarOficioDesigSupervPorId (Long idOficioDesigSuperv) throws ExcepcionDAO{
        SiiOficioDesigSuperv siiOficioDesigSuperv = new SiiOficioDesigSuperv();
        try{
            siiOficioDesigSuperv = (SiiOficioDesigSuperv) manager.find(SiiOficioDesigSuperv.class, idOficioDesigSuperv);
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OficioDesigSuperDAO");
        }
        return siiOficioDesigSuperv;
    }
    
    public List<SiiOficioDesigSuperv> buscarOficioDesigSupervPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO{
        try{
            List<SiiOficioDesigSuperv> listaOficioDesigSuperv = new ArrayList<SiiOficioDesigSuperv>();
            StringBuilder sql = new StringBuilder();                    
            sql.append("SELECT ods FROM SiiOficioDesigSuperv ods WHERE ods.siiProcesoContratacion.prcCodigo = :idProcesoContratacion " +
                "order by ods asc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idProcesoContratacion", idProcesoContratacion);
            listaOficioDesigSuperv = query.getResultList();
            return listaOficioDesigSuperv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"OficioDesigSuperDAO");
        }
        
    }
    
    public SiiOficioDesigSuperv actualizarOficioDesigSuperv (SiiOficioDesigSuperv siiOficioDesigSuperv) throws ExcepcionDAO{
        try{
            manager.merge(siiOficioDesigSuperv);
            manager.flush();
            return siiOficioDesigSuperv;
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OficioDesigSuperDAO");
        }
    }    
    
    public List<SiiOficioDesigSuperv> buscarUltimoOficioDesigSupervPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO{
        try{
            List<SiiOficioDesigSuperv> listaOficioDesigSuperv = new ArrayList<SiiOficioDesigSuperv>();
            StringBuilder sql = new StringBuilder();                    
            sql.append("SELECT ods FROM SiiOficioDesigSuperv ods WHERE ods.odsCodgo IN (SELECT max(nwods.odsCodgo) from SiiOficioDesigSuperv nwods) " +
                "AND ods.siiProcesoContratacion.prcCodigo = :idProcesoContratacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idProcesoContratacion", idProcesoContratacion);
            listaOficioDesigSuperv = query.getResultList();
            return listaOficioDesigSuperv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"OficioDesigSuperDAO");
        }        
    }
    
    public List<SiiOficioDesigSuperv> buscarOficioDesigSupervPorIdProcesoContratacionEstado(Long idProcesoContratacion) throws ExcepcionDAO{
        try{
            List<SiiOficioDesigSuperv> listaOficioDesigSuperv = new ArrayList<SiiOficioDesigSuperv>();
            StringBuilder sql = new StringBuilder();                    
            sql.append("SELECT ods FROM SiiOficioDesigSuperv ods WHERE ods.siiProcesoContratacion.prcCodigo = :idProcesoContratacion " +
                "AND ods.odsEstado IN ('A', 'B') ORDER BY ods ASC");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idProcesoContratacion", idProcesoContratacion);            
            listaOficioDesigSuperv = query.getResultList();
            return listaOficioDesigSuperv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"OficioDesigSuperDAO");
        }
        
    }
    
    public List<ProcesoContratacionVO> buscarProcesoContratacionOficioDesigSuperv() throws ExcepcionDAO{
        List<ProcesoContratacionVO> miListaProcesoContratacionVo = new ArrayList<ProcesoContratacionVO>();
        try{            
            StringBuilder sql = new StringBuilder();                    
            sql.append("SELECT spc.prc_codigo, spc.prc_objeto, sepc.epc_nombre, sods.ods_codgo, sods.ods_estado from sii_proceso_contratacion spc " + 
                "INNER JOIN sii_estado_proc_contrat sepc ON (sepc.epc_codigo = spc.epc_codigo) " + 
                "LEFT OUTER JOIN sii_oficio_desig_superv sods ON (spc.prc_codigo = sods.prc_codigo) " + 
                "WHERE sepc.epc_nombre IN ('CONTRATO LEGALIZADO', 'DESIGNACIÓN SUPERVISOR') " + 
                "AND sods.ods_estado in ('A', 'B') ");
            Query query = manager.createNativeQuery(sql.toString());            
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    ProcesoContratacionVO procesoContratacionVo = new ProcesoContratacionVO();
                    procesoContratacionVo.setPrcCodigo(((BigDecimal) object[0]).longValue());
                    procesoContratacionVo.setPrcObjeto((String) object[1]);
                    EstadoProcContratVO estadoProcContratVo = new EstadoProcContratVO();
                    estadoProcContratVo.setEpcNombre((String) object[2]);
                    procesoContratacionVo.setEstadoProcContrat(estadoProcContratVo);
                    OficioDesigSupervVO oficioDesigSupervVo = new OficioDesigSupervVO();
                    oficioDesigSupervVo.setOdsCodgo(((BigDecimal) object[3]).longValue());
                    oficioDesigSupervVo.setOdsEstado((String) object[4]);                    
                    procesoContratacionVo.setOficioDesigSuperv(oficioDesigSupervVo);
                    miListaProcesoContratacionVo.add(procesoContratacionVo);
                    
                }
            }
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OficioDesigSuperDAO");
        }catch(Exception ex){
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"OficioDesigSuperDAO");
        }
        return miListaProcesoContratacionVo;
    }
        
}

