package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRequisitoCrit;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import java.math.BigDecimal;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.util.List;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class RequisitoCritDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public RequisitoCritDAO() {
        recursos = new Recursos();
    }
    
    public SiiRequisitoCrit buscarRequisitoCritPorId(Long idRequisitoCrit) throws ExcepcionDAO{
            SiiRequisitoCrit siiRequisitoCritRetorno = null;
            try{
                siiRequisitoCritRetorno = (SiiRequisitoCrit) manager.find(SiiRequisitoCrit.class, idRequisitoCrit);
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"RequisitoCritDAO");
            }
            return siiRequisitoCritRetorno;
        }
    
    public SiiRequisitoCrit insertarRequisitoCrit(SiiRequisitoCrit siiRequisitoCrit) throws ExcepcionDAO{
        try{
            manager.persist(siiRequisitoCrit);                                                                                                //La guarda en el almacen
            manager.flush();                                                                                              //Retorna el VO
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"RequisitoCritDAO");
        }
        return siiRequisitoCrit;
    }
    
    public SiiRequisitoCrit actualizarRequisitoCrit(SiiRequisitoCrit siiRequisitoCrit) throws ExcepcionDAO{
        try{
            siiRequisitoCrit = manager.merge(siiRequisitoCrit);
            manager.flush();
            return siiRequisitoCrit;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"RequisitoCritDAO");
        }
    }
    
    public List<SiiRequisitoCrit> buscarTodosRequisitoCrit() throws ExcepcionDAO{
        try{
            List<SiiRequisitoCrit> listaRequisitoCrit = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rc FROM SiiRequisitoCrit rc");
            Query query = manager.createQuery(sql.toString());
            listaRequisitoCrit = query.getResultList();

            return listaRequisitoCrit;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"RequisitoCritDAO");
        }
    }
    
    public List<SiiRequisitoCrit> buscarRequisitoCritPorTipo(String tipoRequisito) throws ExcepcionDAO{
        List<SiiRequisitoCrit> requisitoCritRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT req FROM SiiRequisitoCrit req");
            sql.append(" WHERE req.rcrTipo = :idRequisito");            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idRequisito", tipoRequisito);
            requisitoCritRetorno = query.getResultList();            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"RequisitoCritDAO");
        }
            return requisitoCritRetorno;
    }
    public List<SiiRequisitoCrit> buscarRequisitoCriPorIdEstudioPrevio (Integer idProcesoContratacion) throws ExcepcionDAO{                               
                    List<SiiRequisitoCrit> miListaSiiReqCri =  new ArrayList<SiiRequisitoCrit>();
                    
                    try {
                      StringBuilder sql = new StringBuilder();  
                      sql.append ("select rec.rcr_codigo, rec.rcr_nombre, rec.rcr_tipo ");
                      sql.append (" from sii_requisito_crit rec inner join sii_req_estudio_previo req on (req.rcr_codigo = rec.rcr_codigo)");
                      sql.append (" inner join sii_estudio_previo ep on (ep.epe_codigo = req.epe_codigo)");                       
                      sql.append (" where ep.epe_codigo =#idProcesoContratacion");                  
                      
                      
                      Query query = manager.createNativeQuery(sql.toString());            
                      query.setParameter("idProcesoContratacion",idProcesoContratacion);                   
                                         
                      List<Object[]> results = query.getResultList();
                      if (results != null && !results.isEmpty()) {
                          
                              for (Object[] object : results) {
                                  SiiRequisitoCrit miSiiReqCri = new SiiRequisitoCrit();                               
                                  miSiiReqCri.setRcrCodigo(((BigDecimal)object[0]).longValue());
                                  miSiiReqCri.setRcrNombre((String) object[1]);
                                  miSiiReqCri.setRcrTipo((String) object[2]);                              
                                  miListaSiiReqCri.add(miSiiReqCri);
                              }
                      }
                       
                        
                      } catch (PersistenceException pe) {
                          String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                          throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"AdendaDAO");
                      } catch(Exception ex){
                          ex.printStackTrace();
                          String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                          throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"AdendaDAO");
                      }
                      return miListaSiiReqCri;    
        }
}

