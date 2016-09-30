
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-03-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoObligacionNoPresupuestal;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoOrdenPago;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionNoPresup;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionNoPresupVO;

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
public class ObligacionNoPresupDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ObligacionNoPresupDAO() {
        recursos = new Recursos();
    }
    
    public SiiObligacionNoPresup insertarSiiObligacionNoPresup(SiiObligacionNoPresup siiObligacionNoPresup) throws ExcepcionDAO {
        try {
            manager.persist(siiObligacionNoPresup); 
            manager.flush(); 
            return siiObligacionNoPresup; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ObligacionNoPresupDAO");
        }
    }
    public SiiObligacionNoPresup buscarPorCodigoObligacionNoPres(Long idCodigoObligNoPres) throws ExcepcionDAO {
        SiiObligacionNoPresup retorno = null;
        try {
            retorno = manager.find(SiiObligacionNoPresup.class, idCodigoObligNoPres);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ObligacionNoPresupDAO");
        }
        return retorno;

    }
    public List<SiiObligacionNoPresup> buscarTodoSiiObligacionNoPresup() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiObligacionNoPresup o order by o.onpNumero desc ");
            Query query = manager.createQuery(sql.toString());
            List<SiiObligacionNoPresup> listaObligNoPres = query.getResultList();
            return listaObligNoPres;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ObligacionNoPresupDAO");
        }

    }
    
    public Long buscarConsecutivoObligaNoPres() throws ExcepcionDAO {
        Long consecutivo;        
        try{
            StringBuilder sql = new StringBuilder(); 
            sql.append("SELECT NVL(MAX(ONP_NUMERO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM SII_OBLIGACION_NO_PRESUP onp ");
            sql.append("WHERE ONP_NUMERO LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%'");            
           
            Query query = manager.createNativeQuery(sql.toString());
            
            if (query.getSingleResult() == null) {
                consecutivo = 0L;
            } else {
                consecutivo = ((BigDecimal) query.getSingleResult()).longValue();
            }                 
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ObligacionNoPresupDAO");
        }
        return consecutivo;
    }
    public SiiObligacionNoPresup actualizarSiiObligacionNoPresup(SiiObligacionNoPresup obligacion) throws ExcepcionDAO {
        try {
            manager.merge(obligacion); 
            manager.flush(); 
            return obligacion; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ObligacionNoPresupDAO");
        }
    }
    
    public List<ObligacionNoPresupVO> buscarObligacionesNoPresSinOrdenPago() throws ExcepcionDAO {
         List<ObligacionNoPresupVO> listaObligaVO = new ArrayList<ObligacionNoPresupVO>(); 
         try{
             StringBuilder sql = new StringBuilder();                     
             sql.append(" select onp_codigo,onp_numero from Sii_Obligacion_No_Presup" );
             sql.append(" where onp_codigo not in (SELECT ONP_CODIGO FROM Sii_Orden_Pago WHERE ONP_CODIGO IS NOT NULL  AND  EOP_CODIGO <> #eopCodigoAnulada)");
             sql.append(" and eon_codigo = #eonCodigoAprobada  order by onp_numero desc");
             
             Query query = manager.createNativeQuery(sql.toString()); 
             query.setParameter("eopCodigoAnulada", EnumEstadoOrdenPago.ANULADO.getId());
             query.setParameter("eonCodigoAprobada", EnumEstadoObligacionNoPresupuestal.APROBADO.getId());
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ObligacionNoPresupVO vo = new ObligacionNoPresupVO();
                 vo.setOnpCodigo(new Long(((BigDecimal) object[0]).longValue()) );
                 vo.setOnpNumero(new Integer(((BigDecimal) object[1]).intValue()));
                 listaObligaVO.add(vo);
                 
             }
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return listaObligaVO;
     }
    
}
