/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-10-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.AdendaVO;
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
public class AdendaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public AdendaDAO() {
        recursos = new Recursos();
    }
    
    public SiiAdendaTdr buscarPorCodigoAdenda(Long idCodigoAdenda) throws ExcepcionDAO {
        SiiAdendaTdr adendaRetorno = null;
        try {
            adendaRetorno = (SiiAdendaTdr) manager.find(SiiAdendaTdr.class, idCodigoAdenda);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AdendaDAO");
        }
        return adendaRetorno;

    }
    
    public SiiAdendaTdr insertarSiiAdendaTdr(SiiAdendaTdr adenda) throws ExcepcionDAO {
        try {
            manager.persist(adenda); 
            manager.flush(); 
            return adenda; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AdendaDAO");
        }
    }
    
    public SiiAdendaTdr actualizarSiiAdendaTdr(SiiAdendaTdr adenda) throws ExcepcionDAO {
        try {
            manager.merge(adenda); 
            manager.flush(); 
            return adenda; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AdendaDAO");
        }
    }
    public void borrarAdendaTdr(Long idCodigoAdenda) throws ExcepcionDAO {
        SiiAdendaTdr adendaBorrar = null;
        try {
            adendaBorrar = manager.find(SiiAdendaTdr.class, idCodigoAdenda);
            manager.remove(adendaBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AdendaDAO");
        }
    }
    
    public List<SiiAdendaTdr> buscarAdendasPorCodigoProcesoContratacion (Integer idProcesoContratacion) throws ExcepcionDAO{
                AdendaVO miAdendaVo = new AdendaVO();
                SiiTerminosReferencia miSiiTerminoRerferencia = new SiiTerminosReferencia(); 
                
                
                List<SiiAdendaTdr> miListaAdendasSI =  new ArrayList<SiiAdendaTdr>();
                List<SiiSolicitudEstMercado> miListaSolEstMer = new ArrayList<SiiSolicitudEstMercado>();
                try {
                  StringBuilder sql = new StringBuilder();  
                  sql.append ("select ade.atd_codigo,area.aco_nombre,sol.sem_objeto_contrato,ter.tdr_fecha_ap_def, ");
                  sql.append (" ter.tdr_fecha_en_def,ter.tdr_fecha_pb_def ,");
                  sql.append (" ade.atd_fecha_aprob,ade.atd_fecha_env_pub,ade.atd_fecha_pub from sii_terminos_referencia ter");
                  sql.append (" inner join sii_solicitud_est_mercado sol on (ter.prc_codigo = sol.prc_codigo)");
                  sql.append (" inner join sii_area_coljuegos area on (sol.aco_codigo_responsable = area.aco_codigo)");
                  sql.append (" inner join sii_adenda_tdr ade on (ter.tdr_codigo = ade.tdr_codigo)");                  
                  sql.append (" where ter.prc_codigo =#idProcesoContratacion");                  
                  
                  
                  Query query = manager.createNativeQuery(sql.toString());            
                  query.setParameter("idProcesoContratacion",idProcesoContratacion);                   
                                     
                  List<Object[]> results = query.getResultList();
                  if (results != null && !results.isEmpty()) {
                      
                          for (Object[] object : results) {
                              SiiAdendaTdr miSiiAdenda = new SiiAdendaTdr();
                              SiiProcesoContratacion miSiiProcContra = new SiiProcesoContratacion();
                              SiiSolicitudEstMercado siiSolEstMer = new SiiSolicitudEstMercado();
                              SiiAreaColjuegos siiAreaCol         = new SiiAreaColjuegos();
                              
                              miSiiAdenda.setAtdCodigo(((BigDecimal)object[0]).longValue());
                              miSiiAdenda.setAtdFechaAprob((Date) object[6]);
                              miSiiAdenda.setAtdFechaEnvPub((Date) object[7]);
                              miSiiAdenda.setAtdFechaPub((Date) object[8]);
                             
                              miSiiTerminoRerferencia.setTdrFechaApDef((Date) object[3]);
                              miSiiTerminoRerferencia.setTdrFechaEnDef((Date) object[4]);
                              miSiiTerminoRerferencia.setTdrFechaPbDef((Date) object[5]);
                              
                              siiAreaCol.setAcoNombre((String) object[1]);
                              siiSolEstMer.setSiiAreaColjuegos(siiAreaCol);
                              miListaSolEstMer.add(siiSolEstMer);
                              
                              miSiiProcContra.setPrcCodigo((long ) idProcesoContratacion);
                              miSiiProcContra.setPrcObjeto((String) object[2]);
                              miSiiProcContra.setSiiSolicitudEstMercadoList((List) miListaSolEstMer);
                              miSiiTerminoRerferencia.setSiiProcesoContratacion((miSiiProcContra));
                              
                              miSiiAdenda.setSiiTerminosReferencia(miSiiTerminoRerferencia);
                              miListaAdendasSI.add(miSiiAdenda);
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
                  return miListaAdendasSI;    
    }
    public List<SiiAdendaTdr> buscarTodoSiiAdenda() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiAdendaTdr o");
            Query query = manager.createQuery(sql.toString());
            List<SiiAdendaTdr> listaAdendas = query.getResultList();
            return listaAdendas;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AdendaDAO");
        }

    }
}
