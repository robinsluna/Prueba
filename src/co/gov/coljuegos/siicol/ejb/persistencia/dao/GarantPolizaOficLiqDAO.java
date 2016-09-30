/*
 * SISTEMA	: SIICOL
 * MÓDULO	: DME
 * AUTOR	: Mónica Pabón
 * FECHA	: 19-01-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantPolizaOficLiq;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.AmparoOficioLiqVO;

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
public class GarantPolizaOficLiqDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public GarantPolizaOficLiqDAO() {
        recursos = new Recursos();
    }
    
    public SiiGarantPolizaOficLiq buscarGarantPolizaOficLiqPorCodigo(Long idCodigoGarantPolizaOficLiq) throws ExcepcionDAO {
        SiiGarantPolizaOficLiq retorno = null;
        try {
            retorno = (SiiGarantPolizaOficLiq) manager.find(SiiGarantPolizaOficLiq.class, idCodigoGarantPolizaOficLiq);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "GarantPolizaOficLiqDAO");
        }
        return retorno;

    }
    
    public SiiGarantPolizaOficLiq insertarSiiGarantPolizaOficLiq(SiiGarantPolizaOficLiq siiGarantPolizaOficLiq) throws ExcepcionDAO {
        try {
            manager.persist(siiGarantPolizaOficLiq); 
            manager.flush(); 
            return siiGarantPolizaOficLiq; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "GarantPolizaOficLiqDAO");
        }
    }
    
    public SiiGarantPolizaOficLiq actualizarSiiGarantPolizaOficLiq(SiiGarantPolizaOficLiq siiGarantPolizaOficLiq) throws ExcepcionDAO {
        try {
            manager.merge(siiGarantPolizaOficLiq); 
            manager.flush(); 
            return siiGarantPolizaOficLiq; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "GarantPolizaOficLiqDAO");
        }
    }
    public List<AmparoOficioLiqVO> buscarGarantiaPorOficioLiquidacion(Long idOficio) throws ExcepcionDAO{
        List<AmparoOficioLiqVO> miListaAmparos =  new ArrayList<AmparoOficioLiqVO>();
        
        try {
          StringBuilder sql = new StringBuilder();  
          sql.append (" select distinct gol.gol_descripcion,Ge.Gex_Vigencia_Gar,Ge.Gex_Monto_Porc ,Gol.Gol_Valor_Amparo");
          sql.append (" from sii_garant_poliza_ofic_liq gol");
          sql.append (" Inner Join sii_garantia_exigida ge on (gol.gex_codigo = ge.gex_codigo)");
          sql.append (" where gol.oli_codigo=#idOficio");          
                          
          Query query = manager.createNativeQuery(sql.toString());
          query.setParameter("idOficio",idOficio); 
          List<Object[]> results = query.getResultList();
          if (results != null && !results.isEmpty()) {                      
                  for (Object[] object : results) {
                      AmparoOficioLiqVO amparo = new AmparoOficioLiqVO();
                      amparo.setRiesgos((String)object[0]);
                      amparo.setVigencia((String)object[1]);
                      amparo.setPorcentaje(((BigDecimal)object[2]).toString());
                      amparo.setValorAsegurar((BigDecimal)object[3]);                      
                      miListaAmparos.add(amparo);
                  }
          }                   
            
          } catch (PersistenceException pe) {
              String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
              throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"GarantPolizaOficLiqDAO");
          } catch(Exception ex){
              ex.printStackTrace();
              String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
              throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"GarantPolizaOficLiqDAO");
          }
          return miListaAmparos;
    
    }

    /**
     * @author Giovanni
     * @param idOficioliqui
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiGarantPolizaOficLiq> consultarGarantPolizaOficLiqXOficioLiquidacion(Long idOficioliqui) throws ExcepcionDAO {
        List<SiiGarantPolizaOficLiq> siiGarantPolizaOficLiqs = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT gol FROM SiiGarantPolizaOficLiq gol");
            sql.append(" WHERE gol.siiOficioLiquidacion.oliCodigo = :idOficioliqui");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("idOficioliqui", idOficioliqui);

            siiGarantPolizaOficLiqs = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "GarantPolizaOficLiqDAO");
        }

        return siiGarantPolizaOficLiqs;
    }
}
