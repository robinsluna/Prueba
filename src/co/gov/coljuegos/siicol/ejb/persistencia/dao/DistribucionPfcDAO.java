/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Diana Caro
 * FECHA	: 20-09-2013
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicPfcm;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.DistribucionPfcVO;

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
public class DistribucionPfcDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public DistribucionPfcDAO() {
        recursos = new Recursos();
    }

    public SiiDistribucionPfc buscarDistribucionPfcPorId(Long idDistribucionPfc) throws ExcepcionDAO {
        SiiDistribucionPfc siiDistribucionPfcRetorno = null;
        try {
            siiDistribucionPfcRetorno =  manager.find(SiiDistribucionPfc.class, idDistribucionPfc); 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionPfcDAO");
        }
        return siiDistribucionPfcRetorno;

    }

    public SiiDistribucionPfc insertarSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) throws ExcepcionDAO {
        try {
            manager.persist(siiDistribucionPfc);                                
            manager.flush();                                                   
            return siiDistribucionPfc; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionPfcDAO");
        }
    }


    public SiiDistribucionPfc actualizarSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) throws ExcepcionDAO {
        try {
            manager.merge(siiDistribucionPfc);                                                                           
            manager.flush();                                                                                             
            return siiDistribucionPfc;                                                                                 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionPfcDAO");
        }
    }  
    
    public void borrarPorCodigoSiiDistribucionPfc(SiiDistribucionPfc siiDistribucionPfc) throws ExcepcionDAO {
        SiiDistribucionPfc siiDistribucionPfcBorrar = null;
        try {
            siiDistribucionPfcBorrar = manager.find(SiiDistribucionPfc.class,  siiDistribucionPfc.getDpfCodigo());
            manager.remove(siiDistribucionPfc);                                               
            manager.flush();  
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionPfcDAO");
        }
    }

    public List<SiiDistribucionPfc> buscarTodoSiiDistribucionPfc() throws ExcepcionDAO {
        try {
         //   List<DistribucionPfcVO> listaSiiDistribucionPfcVo = new ArrayList();
        //    List<SiiDistribucionPfc> listaEntidadDistribucion = new ArrayList();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pfc FROM SiiDistribucionPfc pfc");
            Query query = manager.createQuery(sql.toString());
            List<SiiDistribucionPfc> listaSiiDistribucionPfc = query.getResultList();

           return listaSiiDistribucionPfc;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionPfcDAO");
        }

    }
    
    public List<SiiDistribucionPfc> buscarTodoSiiDistribucionPfcXIdDetalleRubro(SiiDetalleRubro siiDetalleRubro) throws ExcepcionDAO {
        List<SiiDistribucionPfc> listaSiiDistribucionPfc = null;
        try {
         //   List<DistribucionPfcVO> listaSiiDistribucionPfcVo = new ArrayList();
        //    List<SiiDistribucionPfc> listaEntidadDistribucion = new ArrayList();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pfc FROM SiiDistribucionPfc pfc");
            sql.append(" INNER JOIN pfc.siiDetalleRubro det");
            sql.append(" WHERE det.druCodigo = :codigoDetRubro");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoDetRubro", siiDetalleRubro.getDruCodigo());
            listaSiiDistribucionPfc = query.getResultList();

           

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionPfcDAO");
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return listaSiiDistribucionPfc;
    }
    
    public List<SiiDistribucionPfc> buscarTodoSiiDistribucionPfcXVigencia(SiiDetalleRubro siiDetalleRubro) throws ExcepcionDAO {
        List<SiiDistribucionPfc> listaSiiDistribucionPfc = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pfc FROM SiiDistribucionPfc pfc");
            sql.append(" INNER JOIN pfc.siiDetalleRubro det");
            sql.append(" WHERE det.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", siiDetalleRubro.getVigencia());
            listaSiiDistribucionPfc = query.getResultList();

           

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionPfcDAO");
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return listaSiiDistribucionPfc;
    }
    public SiiDistribucionPfc buscarDistribucionPfcXVigenciaDetalleR(Integer mes, Long drucodigo,String vigencia) throws ExcepcionDAO {
         SiiDistribucionPfc distribucionPfcRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT distri FROM SiiDistribucionPfc distri");
            sql.append(" INNER JOIN distri.siiProyeccionFlujoCaja pfc");
            sql.append(" WHERE distri.siiMes.mesCodigo = :mes");
            sql.append(" and distri.siiDetalleRubro.druCodigo = :drucodigo");
            sql.append(" and pfc.pfcVigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mes", mes);
            query.setParameter("drucodigo", drucodigo);
            query.setParameter("vigencia",Integer.parseInt(vigencia));
            List<SiiDistribucionPfc> listaDistribucionPfc=query.getResultList();
            
            if (listaDistribucionPfc != null && !listaDistribucionPfc.isEmpty()) {
                distribucionPfcRetorno = listaDistribucionPfc.get(0);
            }
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionPfcDAO");
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return distribucionPfcRetorno;
    }
    
    


}

