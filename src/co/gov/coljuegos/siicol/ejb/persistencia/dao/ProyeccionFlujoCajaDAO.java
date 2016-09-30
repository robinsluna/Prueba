/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Diana Caro
 * FECHA	: 20-09-2013
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinancContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionFlujoCaja;

import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.ProyeccionFlujoCajaVO;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ProyeccionFlujoCajaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ProyeccionFlujoCajaDAO() {
        recursos = new Recursos();
    }

    public SiiProyeccionFlujoCaja buscarPorCodigoPFC(Long idProyFlujoCaja) throws ExcepcionDAO {
        SiiProyeccionFlujoCaja siiProyeccionFlujoCajaRetorno = null;
        try {
            siiProyeccionFlujoCajaRetorno =(SiiProyeccionFlujoCaja) manager.find(SiiProyeccionFlujoCaja.class, idProyFlujoCaja); 
          } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiProyeccionFlujoCajaDAO");
        }
        return siiProyeccionFlujoCajaRetorno;

    }

    public SiiProyeccionFlujoCaja insertarSiiProyeccionFC(SiiProyeccionFlujoCaja siiProyeccionFlujoCaja) throws ExcepcionDAO {
        try {
            manager.persist(siiProyeccionFlujoCaja);                                    
            manager.flush();                                                            
            
            return siiProyeccionFlujoCaja;                                         

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
           throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),  "SiiProyeccionFlujoCajaDAO");
        }
    }

    public SiiProyeccionFlujoCaja actualizarSiiProyeccionFlujoCaja(SiiProyeccionFlujoCaja siiProyeccionFlujoCaja) throws ExcepcionDAO {
        try {
            manager.merge(siiProyeccionFlujoCaja);                                                                           
            manager.flush();                                                                                             
           return siiProyeccionFlujoCaja;                                                                                 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "siiProyeccionFlujoCajaDAO");
        }
    }  
    
    public void borrarPorCodigoSiiProyeccionFlujoCaja(Long idProyFlujoCaja) throws ExcepcionDAO {
        SiiProyeccionFlujoCaja siiProyeccionFlujoCajaBorrar = null;
        try {
            siiProyeccionFlujoCajaBorrar = manager.find(SiiProyeccionFlujoCaja.class, idProyFlujoCaja);
            manager.remove(siiProyeccionFlujoCajaBorrar);                                               
            manager.flush();  
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiProyeccionFlujoCajaDAO");
        }
    }

    public List<SiiProyeccionFlujoCaja> buscarTodoSiiProyeccionFlujoCaja() throws ExcepcionDAO {
        try {
         /*   List<ProyeccionFlujoCajaVO> listaSiiProyeccionFlujoCajaVo = new ArrayList();
            List<SiiProyeccionFlujoCaja> listaEntidadesPfc = new ArrayList();*/

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pfc FROM SiiProyeccionFlujoCaja pfc");
            Query query = manager.createQuery(sql.toString());
            List<SiiProyeccionFlujoCaja> listaEntidadesPfc = query.getResultList();

            return listaEntidadesPfc;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),  "SiiProyeccionFlujoCajaDAO");
        }

    }
    public List<SiiProyeccionFlujoCaja> buscarTodoPFCNacion() throws ExcepcionDAO {
        try {
         /*   List<ProyeccionFlujoCajaVO> listaSiiProyeccionFlujoCajaVo = new ArrayList();
            List<SiiProyeccionFlujoCaja> listaEntidadesPfc = new ArrayList();*/

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pfc FROM SiiProyeccionFlujoCaja pfc ");
            sql.append("WHERE  pfc.siiEstadoPfc.epfNombre='APROBADO TESORERIA' ");
            sql.append("or pfc.siiEstadoPfc.epfNombre='CERRADO MHCP' ");
            sql.append("or pfc.siiEstadoPfc.epfNombre='APROBADO MHCP' ");
            Query query = manager.createQuery(sql.toString());
            List<SiiProyeccionFlujoCaja> listaEntidadesPfc = query.getResultList();

            return listaEntidadesPfc;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),  "SiiProyeccionFlujoCajaDAO");
        }

    }
    
    
    
    public List<SiiProyeccionFlujoCaja> buscarPFCPorVigencia(SiiProyeccionFlujoCaja siiProyeccionFlujoCaja) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pfc FROM SiiProyeccionFlujoCaja pfc");
            sql.append(" WHERE pfc.pfcVigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", siiProyeccionFlujoCaja.getPfcVigencia());
            List<SiiProyeccionFlujoCaja> listaProyecciones = query.getResultList();
            return listaProyecciones;
                
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiProyeccionFlujoCajaDAO");
            }
    }
    
    public List<SiiProyeccionFlujoCaja> buscarPFCPorVigenciayEstado(SiiProyeccionFlujoCaja siiProyeccionFlujoCaja) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pfc FROM SiiProyeccionFlujoCaja pfc");
            sql.append(" WHERE pfc.pfcVigencia = :vigencia");
            sql.append(" and  pfc.siiEstadoPfc.epfCodigo = :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", siiProyeccionFlujoCaja.getPfcVigencia());
            query.setParameter("estado", siiProyeccionFlujoCaja.getSiiEstadoPfc().getEpfCodigo());
            List<SiiProyeccionFlujoCaja> listaProyecciones = query.getResultList();
            return listaProyecciones;
                
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiProyeccionFlujoCajaDAO");
            }
    }
    
    
    
    public List<SiiProyeccionFlujoCaja> buscarPFCPorEstado(String estado) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pfc FROM SiiProyeccionFlujoCaja pfc INNER JOIN pfc.SiiEstadoPfc estado WHERE estado.epfNombre = :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            List<SiiProyeccionFlujoCaja> listaPfc = query.getResultList();
            return listaPfc;
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SiiProyeccionFlujoCajaDAO");
        }
    }
    
    public SiiProyeccionFlujoCaja buscarPfcPorId (Long pfcCodigo) throws ExcepcionDAO {
       SiiProyeccionFlujoCaja siiProyeccionFlujoCaja = null;
        try{
            siiProyeccionFlujoCaja = manager.find(SiiProyeccionFlujoCaja.class, pfcCodigo);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return siiProyeccionFlujoCaja; 
    }

}


