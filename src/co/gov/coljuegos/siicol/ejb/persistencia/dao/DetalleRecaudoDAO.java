
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionConcepto;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class DetalleRecaudoDAO extends GenericDAO<SiiDetalleRecaudo>{
    //@PersistenceContext(unitName = "siicolPU")
    //private EntityManager manager;
    //private Recursos recursos;
    
    public DetalleRecaudoDAO() {
        super(SiiDetalleRecaudo.class);
    }

    
    public List<SiiDetalleRecaudo> buscarTodoDetalleRecaudoXRecaudo(Long idRecaudoBanco) throws ExcepcionDAO {
        List<SiiDetalleRecaudo> listaSiiDetalleRecaudo = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT dre FROM SiiDetalleRecaudo dre");
            sql.append(" where dre.siiRecaudoBanco.rbaCodigo = :idRecaudoBanco ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("idRecaudoBanco", idRecaudoBanco);
            listaSiiDetalleRecaudo = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleRecaudo;
    }
    
    
    public List<SiiDetalleRecaudo> BuscarDetalleRecaudoXIdRefPago(Long idRefPago ) throws ExcepcionDAO{ 
        List<SiiDetalleRecaudo> listaSiiDetalleRecaudo = null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select dr from  SiiDetalleDeclaracion dd");
            sql.append(" inner join dd.siiDetalleRecaudo dr");
            sql.append(" inner join dd.siiReferenciaPagoDecl refPag");
            sql.append(" where refPag.rpdNumero = :idRefPago"); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("idRefPago", idRefPago);
            listaSiiDetalleRecaudo = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleRecaudo;
    }
    
    public List<SiiDetalleDeclaracion> BuscarDetalleDeclaracionXIdRefPagoSinPago(Long idRefPago ) throws ExcepcionDAO{ 
        List<SiiDetalleDeclaracion> listaSiiDetalleDeclaracion = null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select dd from  SiiDetalleDeclaracion dd");
            sql.append(" left join dd.siiDetalleRecaudo dr");
            sql.append(" inner join dd.siiReferenciaPagoDecl refPag");
            sql.append(" where refPag.rpdNumero = :idRefPago"); 
            sql.append(" and  dr.dreCodigo  is null"); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("idRefPago", idRefPago);
            listaSiiDetalleDeclaracion = query.getResultList(); 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleDeclaracion;
    }
    
       
    public List<SiiCuentaContTipoDocCont> buscarCuentaContTipoDocContXCodigoConceptoTcartera (String concepto,String tipoCartera, String tipoDocContable ) throws ExcepcionDAO{ 
        
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cct from  SiiCuentaContTipoDocCont cct");
            sql.append(" inner join cct.siiTipoDocContable tdc");
            sql.append(" where tdc.tdcCodigo = :tipoDoc  and cct.cctDestRecSinC is null   and   ");
           
            if(concepto != null)
                sql.append("  cct.cctConcepto = :concepto and");
            if(tipoCartera != null)
                sql.append(" cct.cctTipoCartera = :tipoCartera and ");
            sql.append("  cct.cctActivo = 'S' and cct.siiCuentasContables is not null "); 
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", tipoDocContable);
            if(concepto !=null)
                query.setParameter("concepto", concepto);
            if(tipoCartera != null)
                query.setParameter("tipoCartera", tipoCartera);
            
            
            listaSiiCuentaContTipoDocCont = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentaContTipoDocCont;
    }
        
    public List<SiiCuentaContTipoDocCont> BuscarCuentaContTipoDocContObligacion (Long idObligacion ) throws ExcepcionDAO{ 
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select tdc from  SiiObligacion obl");
            sql.append(" inner join obl.siiTipoDocContable tip");
            sql.append(" inner join tip.siiCuentaContTipoDocContList tdc");
            sql.append(" where tdc.tdcCodigo= :tipoDoc  and");
            sql.append(" obl.cctTipoCartera= :idObligacion"); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", "OPR");
            query.setParameter("idObligacion", idObligacion);
            listaSiiCuentaContTipoDocCont = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentaContTipoDocCont;
    }
    
    public List<SiiCuentaContTipoDocCont> BuscarCuentaContTipoDocContable ( String concepto ,String tipoDoc ) throws ExcepcionDAO{ 
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select tdc from  SiiCuentaContTipoDocCont tdc");
            sql.append(" where tdc.siiTipoDocContable.tdcCodigo= :tipoDoc  and tdc.cctActivo = 'S'  ");
            if( concepto != null)
                sql.append("and  tdc.cctConcepto= :concepto"); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", tipoDoc);
            if( concepto != null)
                query.setParameter("concepto", concepto);
            listaSiiCuentaContTipoDocCont = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentaContTipoDocCont;
    }

    
    public List<SiiCuentaContTipoDocCont> BuscarCuentaContTipoDocContFuenteFin (Long tercero,String TipoDocCon, String fuente) throws ExcepcionDAO{ 
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cct from  SiiCuentaContTipoDocCont cct");
            sql.append(" inner join cct.siiTipoDocContable tdc");
            sql.append(" inner join cct.siiFuenteFinancContab ff");
            sql.append(" left join cct.siiPersona p");
            sql.append(" where ff.ffcCodigo= :fuente and cct.cctActivo = 'S' ");
            if(TipoDocCon != null)
                 sql.append(" and tdc.tdcCodigo= :tipoDoc"); 
            if(tercero!= null )
                sql.append(" and cct.siiPersona.perCodigo  = :tercero"); 
            Query query = em.createQuery(sql.toString());
            if(tercero != null)
                query.setParameter("tercero", tercero);
            if(TipoDocCon != null)
                 query.setParameter("tipoDoc", TipoDocCon);
          
            query.setParameter("fuente", fuente);
          
            listaSiiCuentaContTipoDocCont = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentaContTipoDocCont;
    
    }
    
    public List<SiiCuentaContTipoDocCont> BuscarCuentaContTipoDocContFuenteFinSinTer (String TipoDocCon,String tipoFuente) throws ExcepcionDAO{ 
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cct from  SiiCuentaContTipoDocCont cct");
            sql.append(" inner join cct.siiTipoDocContable tdc");
            sql.append(" inner join cct.siiFuenteFinancContab ff");
            sql.append(" left join cct.siiPersona p");
            sql.append(" where ff.ffcCodigo= :tipoFuente");
            sql.append(" and tdc.tdcCodigo= :tipoDoc and cct.cctActivo = 'S'"); 
            //sql.append(" and p.perCodigo is null "); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", TipoDocCon);
            query.setParameter("tipoFuente", tipoFuente);
            
            listaSiiCuentaContTipoDocCont = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentaContTipoDocCont;
    }
    
    public List<SiiCuentaContTipoDocCont> BuscarCuentaContTipoDocContFuenteFinSinTercero (String TipoDocCon,String tipoFuente) throws ExcepcionDAO{ 
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cct from  SiiCuentaContTipoDocCont cct");
            sql.append(" inner join cct.siiTipoDocContable tdc");
            sql.append(" inner join cct.siiFuenteFinancContab ff");
            sql.append(" left join cct.siiPersona p");
            sql.append(" where ff.ffcCodigo= :tipoFuente");
            sql.append(" and tdc.tdcCodigo= :tipoDoc"); 
            sql.append(" and p.perCodigo is null and cct.cctActivo = 'S'"); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", TipoDocCon);
            query.setParameter("tipoFuente", tipoFuente);
            
            listaSiiCuentaContTipoDocCont = query.getResultList();    

            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentaContTipoDocCont;
    }
    
 
    public List<DuplaVO> buscarPagosPorContrato(long codigoContrato) throws ExcepcionDAO{
               
        List<DuplaVO> miListaConceptos =  new ArrayList<DuplaVO>();
        
        try {
        StringBuilder sql = new StringBuilder();  
        sql.append (" SELECT SUM(dr.dre_Valor),cc.ccu_nombre");
        sql.append (" FROM sii_detalle_recaudo dr");
        sql.append (" INNER JOIN sii_detalle_declaracion dd ON dr.dre_codigo = dd.dre_codigo");
        sql.append (" INNER JOIN sii_cuota_operador co ON co.cop_codigo = dd.cop_codigo");
        sql.append (" INNER JOIN sii_concepto_cuota cc ON cc.ccu_codigo = co.ccu_codigo");
        sql.append (" INNER JOIN sii_liquidacion_mes lm ON lm.lme_codigo = co.lme_codigo");
        sql.append (" WHERE lm.con_codigo =#codigoContrato ");
        sql.append (" GROUP BY cc.ccu_nombre");
        
        Query query = em.createNativeQuery(sql.toString());                                      
        List<Object[]> results = query.getResultList();
        if (results != null && !results.isEmpty()) {
          
              for (Object[] object : results) {
                  DuplaVO dum = new DuplaVO();
                  dum.setValor((BigDecimal)object[0]);
                  dum.setConcepto((String)object[1]);                             
                  miListaConceptos.add(dum);
              }
        }                   
        
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miListaConceptos;    
    }
    
    public List<SiiObligacionConcepto> BuscarConceptocontableXObligacion (Long idObligacion ) throws ExcepcionDAO{ 
        List<SiiObligacionConcepto> listaSiiObligacionConcepto= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select obl from  SiiObligacionConcepto obl");
            sql.append(" where obl.siiObligacion.oblCodigo= :idObligacion  and");
            sql.append(" obl.siiObligacion.siiTipoDocContable.tdcCodigo= :tipoDoc"); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", "OPR");
            query.setParameter("idObligacion", idObligacion);
            listaSiiObligacionConcepto = query.getResultList();   

        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        } 
        return listaSiiObligacionConcepto;
    }
    
    public List<SiiCuentaContTipoDocCont> BuscarCuentaContXPpr4XMil () throws ExcepcionDAO{ 
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cct from  SiiCuentaContTipoDocCont cct");
            sql.append(" where cct.siiTipoDocContable.tdcCodigo = :tipoDoc");
            sql.append(" and cct.cctConcepto= :concepto and cct.cctActivo = 'S'"); 
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", "PPR");
            query.setParameter("concepto", "4X");
          
            listaSiiCuentaContTipoDocCont = query.getResultList();    

        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentaContTipoDocCont;
    }
    
    public List<SiiCuentaContTipoDocCont> BuscarCuentaContTipoDocContYNumeroObligacion (String tipo,Long  idObligacion ) throws ExcepcionDAO{ 
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cct from  SiiCuentaContTipoDocCont cct");
            sql.append(" inner join cct.siiObligacionConcepto obl");
            sql.append(" where cct.siiTipoDocContable.tdcCodigo= :tipoDoc  and");
            sql.append(" obl.ocoCodigo = :idObligacion and cct.cctActivo = 'S'"); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", "RPB");
            query.setParameter("idObligacion", idObligacion);
            listaSiiCuentaContTipoDocCont = query.getResultList();  
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentaContTipoDocCont;
    }
     
    
    public List<SiiCuentaContTipoDocCont> BuscarCuentaContTipoDocContXCodigoConceptoDestino (String destino,String tipoDocContable ) throws ExcepcionDAO{ 
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cct from  SiiCuentaContTipoDocCont cct");
            sql.append(" inner join cct.siiTipoDocContable tdc");
            sql.append(" where tdc.tdcCodigo= :tipoDoc  and");
            sql.append(" cct.cctDestRecSinC = :destino and cct.cctActivo = 'S'"); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", tipoDocContable);
            query.setParameter("destino", destino);
          
            listaSiiCuentaContTipoDocCont = query.getResultList();   
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentaContTipoDocCont;
    }
    
    public SiiCuentaContTipoDocCont BuscarCuentaContTipoDocContXRPBConceptoTercero (String cuenta) throws ExcepcionDAO{ 
        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= null;
        SiiCuentaContTipoDocCont  unSiiCuentaContTipoDocCont = new SiiCuentaContTipoDocCont();
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select cct from  SiiCuentaContTipoDocCont cct");
            sql.append(" inner join cct.siiTipoDocContable tdc");
            sql.append(" where tdc.tdcCodigo= :tipoDoc  and");
            sql.append(" cct.cctIndicador1 = :cuenta and cct.cctActivo = 'S'"); 
           // sql.append(" cct.cctConcepto='' "); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", "RPB");
            query.setParameter("cuenta", cuenta);
          
            listaSiiCuentaContTipoDocCont = query.getResultList();   
            if(listaSiiCuentaContTipoDocCont!=null && listaSiiCuentaContTipoDocCont.size()>0){
                    unSiiCuentaContTipoDocCont = listaSiiCuentaContTipoDocCont.get(0); 
            }  
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return unSiiCuentaContTipoDocCont;
    }
    
    public SiiCuentasContables BuscarCuentaContTipoDocContXCodigoConcSinTer(String tercero,String tipoDocContable ) throws ExcepcionDAO{ 
        List<SiiCuentasContables> listaSiiCuentasContablet= null;
        SiiCuentasContables  unSiiCuentasContables = new SiiCuentasContables();
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select c from  SiiCuentaContTipoDocCont cct");
            sql.append(" inner join cct.siiTipoDocContable tdc");
            sql.append(" inner join cct.siiCuentasContables c ");
            sql.append(" where tdc.tdcCodigo= :tipoDoc  and");
            sql.append(" cct.cctConcepto is null and cct.cctIndicador1= :tercero and cct.cctActivo = 'S' "); 
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDoc", tipoDocContable );
            query.setParameter("tercero", tercero);
            listaSiiCuentasContablet = query.getResultList();
            
            if(listaSiiCuentasContablet!=null && listaSiiCuentasContablet.size()>0){
                    unSiiCuentasContables = listaSiiCuentasContablet.get(0); 
            } 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return unSiiCuentasContables;
    }
    
    public SiiCuentasContables BuscarCuentaContXCuentaBancaria(Long idCuentaBan) throws ExcepcionDAO{ 
        List<SiiCuentasContables> listaSiiCuentasContablet= null;
        SiiCuentasContables  unSiiCuentasContables = new SiiCuentasContables();
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select c from  SiiCuentaBancaria cb");
            sql.append(" inner join cb.siiCuentasContables c ");
            sql.append(" where cb.cbaCodigo= :idCuentaBan  ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("idCuentaBan", idCuentaBan);
            listaSiiCuentasContablet = query.getResultList();
            
            if(listaSiiCuentasContablet!=null && listaSiiCuentasContablet.size()>0){
                    unSiiCuentasContables = listaSiiCuentasContablet.get(0); 
            } 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return unSiiCuentasContables;
    }

    public List<SiiCuentasContables> BuscarCuentaContXtipoDocumento(String tdcCodigo) throws ExcepcionDAO{ 
        List<SiiCuentasContables> listaSiiCuentasContablet= null;
        SiiCuentasContables  unSiiCuentasContables = new SiiCuentasContables();
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select c from  SiiCuentaContTipoDocCont cct");
            sql.append(" inner join cct.siiCuentasContables c ");
            sql.append(" where cct.siiTipoDocContable.tdcCodigo= :tdcCodigo ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("tdcCodigo", tdcCodigo);
            listaSiiCuentasContablet = query.getResultList();
        
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiCuentasContablet;
    }
    
    
    

}
