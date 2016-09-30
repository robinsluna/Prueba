
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReferenciaPagoDecl;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean 


public class ReferenciaPagoDeclDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
   
    public ReferenciaPagoDeclDAO() {
        recursos = new Recursos();
    }
    
    public SiiReferenciaPagoDecl buscarReferenciaPagoXId(Long idRefPago) throws ExcepcionDAO {
        SiiReferenciaPagoDecl retornoSiiReferenciaPagoDecl = null;
        try {
            retornoSiiReferenciaPagoDecl = (SiiReferenciaPagoDecl) manager.find(SiiReferenciaPagoDecl.class, idRefPago);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecaudoBancoDAO");
        }
        return retornoSiiReferenciaPagoDecl;

    }  
    
    /**
     * Realiza la consulta para obtener el Consecutivo de la Referencia.
     * @return referencia.nextval
     * @throws ExcepcionDAO
     */
    public long buscarConsecutivoReferencia() throws ExcepcionDAO 
    {
        long consecutivo = 0L;
        try{
            StringBuilder sql = new StringBuilder();
            
            
            sql.append("select MAX(RPD_CODIGO)+1 from SII_REFERENCIA_PAGO_DECL");
            Query query = manager.createNativeQuery(sql.toString());
            
            if(query.getSingleResult() != null){
                consecutivo =  ((BigDecimal)query.getSingleResult()).longValue();
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    /**
     * Realiza la consulta para obtener el Número de la Referencia.
     * @return referencia.nextval
     * @throws ExcepcionDAO
     */
    public long buscarNumeroReferencia() throws ExcepcionDAO 
    {
        long consecutivo = 0L;
        try{
            StringBuilder sql = new StringBuilder();
            
            
            sql.append("select MAX(RPD_NUMERO)+1 from SII_REFERENCIA_PAGO_DECL");
            Query query = manager.createNativeQuery(sql.toString());
            
            if(query.getSingleResult() != null){
               consecutivo = ((BigDecimal)query.getSingleResult()).longValue();
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : Error obteniendo el Número de referencia" + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    public SiiReferenciaPagoDecl insertarReferenciaPagoDecl(SiiReferenciaPagoDecl siiReferenciaPagoDecl) throws ExcepcionDAO{
        try{
            manager.persist(siiReferenciaPagoDecl);                                                                                
            manager.flush();                                                                                               
            return siiReferenciaPagoDecl;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ReferenciaPagoDeclDAO");
        }
    }
    
    public SiiReferenciaPagoDecl BuscarReferenciaPagoXNumeroRef(Long idNumReferencia ) throws ExcepcionDAO{ 
        List<SiiReferenciaPagoDecl> listaSiiReferenciaPagoDecl = null;
        SiiReferenciaPagoDecl unSiiReferenciaPagoDecl= new SiiReferenciaPagoDecl();
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select ref from SiiDetalleDeclaracion det");
            sql.append(" inner join det.siiReferenciaPagoDecl ref");
            sql.append(" where ref.rpdNumero = :idNumReferencia"); 
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idNumReferencia", idNumReferencia);
            listaSiiReferenciaPagoDecl = query.getResultList();   
            if (listaSiiReferenciaPagoDecl != null && !listaSiiReferenciaPagoDecl.isEmpty()) 
                unSiiReferenciaPagoDecl = listaSiiReferenciaPagoDecl.get(0);
            
            return unSiiReferenciaPagoDecl;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");
        }
    }
    
    public long buscarConsecutivoReferenciaPagoDeclaracion(String inicial) throws ExcepcionDAO 
    {   
        String ini=inicial;
        long consecutivo = 0L;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" select case when  (RPD_numero) is null then  to_number(concat("+ ini +",'000001'))  else RPD_numero+1   end as ref  from (");
            sql.append(" select max(RPD_numero)as RPD_numero from (");
            sql.append(" select length( RPD_numero)as cant , RPD_numero  from sii_referencia_pago_decl)");
            sql.append(" where cant=11 and  rpd_numero like '"+ ini +"%' )");
            Query query = manager.createNativeQuery(sql.toString());            
            if(query.getSingleResult() != null){
                consecutivo =  ((BigDecimal)query.getSingleResult()).longValue();
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    
}
