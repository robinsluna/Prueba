package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.AreaColjuegosVO;


import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class TerminoReferenciaDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TerminoReferenciaDAO() {
        recursos = new Recursos();
    }

    public SiiTerminosReferencia buscarPorCodigoTerminoReferencia(Long idCodigoTerminoReferencia) throws ExcepcionDAO {
        SiiTerminosReferencia terminoReferenciaRetorno = null;
        try {
            terminoReferenciaRetorno = (SiiTerminosReferencia) manager.find(SiiTerminosReferencia.class, idCodigoTerminoReferencia);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminoReferenciaDAO");
        }
        return terminoReferenciaRetorno;

    }

    public SiiTerminosReferencia insertarSiiTerminoReferencia(SiiTerminosReferencia terminoReferencia) throws ExcepcionDAO {
        try {
            manager.persist(terminoReferencia); 
            manager.flush(); 
            return terminoReferencia; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminoReferenciaDAO");
        }
    }

    public SiiTerminosReferencia actualizarSiiTerminoReferencia(SiiTerminosReferencia terminoReferencia) throws ExcepcionDAO {
        try {
            manager.merge(terminoReferencia); 
            manager.flush(); 
            return terminoReferencia; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminoReferenciaDAO");
        }
    }

    public void borrarTerminoReferencia(Long idCodigoTerminoReferencia) throws ExcepcionDAO {
        SiiTerminosReferencia terminoReferenciaBorrar = null;
        try {
            terminoReferenciaBorrar = manager.find(SiiTerminosReferencia.class, idCodigoTerminoReferencia);
            manager.remove(terminoReferenciaBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminoReferenciaDAO");
        }
    }

    public List<SiiTerminosReferencia> buscarTodoSiiTerminoReferencia() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTerminosReferencia o");
            Query query = manager.createQuery(sql.toString());
            List<SiiTerminosReferencia> listaTerminoReferencia = query.getResultList();
            return listaTerminoReferencia;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminoReferenciaDAO");
        }

    }
    
    public SiiTerminosReferencia buscarTerminoReferencia (Integer idProcesoContratacion) throws ExcepcionDAO{
                
                SiiTerminosReferencia miSiiTerminoRerferencia = null;
                SiiProcesoContratacion miSiiProcContra = new SiiProcesoContratacion();
                List<TerminoReferenciaVO> miListaTrVo =  null;
                List<SiiSolicitudEstMercado> miListaSolEstMer = new ArrayList<SiiSolicitudEstMercado>();
                try {
                  StringBuilder sql = new StringBuilder();  
                  sql.append ("select ter.tdr_codigo,ter.tdr_fecha_ap_proy,ter.tdr_fecha_pb_proy,ter.tdr_fecha_ap_obs, ");
                  sql.append (" ter.tdr_fecha_pb_obs,ter.tdr_fecha_ap_def,ter.tdr_fecha_pb_def,ter.tdr_fecha_ap_obs_def,");
                  sql.append (" ter.tdr_fecha_pb_obs_def, ter.tdr_fecha_ap_aud, ter.tdr_fecha_pb_aud, ter.tdr_fecha_en_proy,");
                  sql.append (" ter.tdr_fecha_en_obs, ter.tdr_fecha_en_def, ter.tdr_fecha_en_obs_def, ter.tdr_fecha_en_aud,");
                  sql.append (" ter.tdr_radic_aud, ter.tdr_radic_def, ter.tdr_radic_obs, ter.tdr_radic_obs_def, ter.tdr_radic_proy,");
                  sql.append (" sol.sem_objeto_contrato,area.aco_nombre from sii_terminos_referencia ter");
                  sql.append (" inner join sii_solicitud_est_mercado sol on (ter.prc_codigo = sol.prc_codigo)");
                  sql.append (" inner join sii_area_coljuegos area on (sol.aco_codigo_responsable = area.aco_codigo)");
                  sql.append (" where ter.prc_codigo =#idProcesoContratacion");
                    
                  /*sql.append(" SELECT tr, FROM SiiTerminosReferencia tr");
                  sql.append(" SELECT tr FROM SiiTerminosReferencia tr");
                  sql.append(" WHERE tr.siiProcesoContratacion.prcCodigo = :idProcesoContratacion");
                  
                  Query query = manager.createQuery(sql.toString());*/
                  
                  Query query = manager.createNativeQuery(sql.toString());            
                  query.setParameter("idProcesoContratacion",idProcesoContratacion); 
                  //miSiiTerminoRerferencia = (SiiTerminosReferencia) (query.getResultList().get(0));
                                     
                  List<Object[]> results = query.getResultList();
                  if (results != null && !results.isEmpty()) {
                      miSiiTerminoRerferencia = new SiiTerminosReferencia();
                      
                          for (Object[] object : results) {
                              //ProcesoContratacionVO unProcContraVo= new ProcesoContratacionVO();
                              
                              SiiSolicitudEstMercado siiSolEstMer = new SiiSolicitudEstMercado();
                              SiiAreaColjuegos siiAreaCol         = new SiiAreaColjuegos();
                              
                              miSiiTerminoRerferencia.setTdrCodigo(((BigDecimal)object[0]).longValue());
                              miSiiTerminoRerferencia.setTdrFechaApProy((Date)object[1]);
                              miSiiTerminoRerferencia.setTdrFechaPbProy((Date) object[2]);
                              miSiiTerminoRerferencia.setTdrFechaApObs((Date) object[3]);
                              miSiiTerminoRerferencia.setTdrFechaPbObs((Date) object[4]);
                              miSiiTerminoRerferencia.setTdrFechaApDef((Date) object[5]);
                              miSiiTerminoRerferencia.setTdrFechaPbDef((Date) object[6]);
                              miSiiTerminoRerferencia.setTdrFechaApObsDef((Date) object[7]);
                              miSiiTerminoRerferencia.setTdrFechaPbObsDef((Date) object[8]);
                              miSiiTerminoRerferencia.setTdrFechaApAud((Date) object[9]);
                              miSiiTerminoRerferencia.setTdrFechaPbAud((Date) object[10]);
                              miSiiTerminoRerferencia.setTdrFechaEnProy((Date) object[11]);
                              miSiiTerminoRerferencia.setTdrFechaEnObs((Date) object[12]);                              
                              miSiiTerminoRerferencia.setTdrFechaEnDef((Date) object[13]);                              
                              miSiiTerminoRerferencia.setTdrFechaEnObsDef((Date) object[14]);
                              miSiiTerminoRerferencia.setTdrFechaEnAud((Date) object[15]);
                              miSiiTerminoRerferencia.setTdrRadicAud((String) object[16]);
                              miSiiTerminoRerferencia.setTdrRadicDef((String) object[17]);
                              miSiiTerminoRerferencia.setTdrRadicObs((String) object[18]);
                              miSiiTerminoRerferencia.setTdrRadicObsDef((String) object[19]);
                              miSiiTerminoRerferencia.setTdrRadicProy((String) object[20]);
                              
                              siiAreaCol.setAcoNombre((String) object[22]);
                              siiSolEstMer.setSiiAreaColjuegos(siiAreaCol);
                              miListaSolEstMer.add(siiSolEstMer);
                              
                              miSiiProcContra.setPrcCodigo((long ) idProcesoContratacion);
                              miSiiProcContra.setPrcObjeto((String) object[21]);
                              miSiiProcContra.setSiiSolicitudEstMercadoList((List) miListaSolEstMer);
                              miSiiTerminoRerferencia.setSiiProcesoContratacion((miSiiProcContra));
                          }
                  }
                   /*else {
                      ProcesoContratacionVO unProcContraVo= new ProcesoContratacionVO();
                      unProcContraVo.setPrcCodigo((long ) idProcesoContratacion);
                          miTermiRefVo.setProcesoContratacionVO(unProcContraVo);
                      }*/
                    
                  } catch (PersistenceException pe) {
                      String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                      throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"TerminoReferenciaDAO");
                  } catch(Exception ex){
                      ex.printStackTrace();
                      String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                      throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"TerminoReferenciaDAO");
                  }
                  return miSiiTerminoRerferencia;    
    }
    
    //Buscar terminos de referencia por proceso de contratacion
    public String buscarAreaColjuegosPorCodigoProcesoContratacion (Integer idProcesoContratacion) throws ExcepcionDAO{
                String area="";
         try {
                  StringBuilder sql = new StringBuilder();  
                  sql.append ("select area.aco_nombre ");
                  sql.append (" from sii_solicitud_est_mercado sol ");
                  sql.append (" left outer join  sii_area_coljuegos area on (sol.aco_codigo_responsable = area.aco_codigo) ");
                  sql.append (" where sol.prc_codigo =#idProcesoContratacion");
                                                   
                                    
                  Query query = manager.createNativeQuery(sql.toString());            
                  query.setParameter("idProcesoContratacion",idProcesoContratacion); 
                                                       
                  area = (String) query.getSingleResult();
                 
                  } catch (PersistenceException pe) {
                      String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                      throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"TerminoReferenciaDAO");
                  } catch(Exception ex){
                      ex.printStackTrace();
                      String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                      throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"TerminoReferenciaDAO");
                  }
                  return area;    
    }
   



}
