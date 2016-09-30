/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RECAUDO Y TRANSFERENCIA
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-02-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreRecaudo;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class CierreRecaudoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public CierreRecaudoDAO() {
        recursos = new Recursos();
    }
    
    public SiiCierreRecaudo buscarPorCodigoCierreRecaudo(Long idCodigoCierre) throws ExcepcionDAO {
        SiiCierreRecaudo retorno = null;
        try {
            retorno = (SiiCierreRecaudo) manager.find(SiiCierreRecaudo.class, idCodigoCierre);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CierreRecaudoDAO");
        }
        return retorno;

    }
    
    public SiiCierreRecaudo insertarSiiCierreRecaudo(SiiCierreRecaudo cierreRecaudo) throws ExcepcionDAO {
        try {
            manager.persist(cierreRecaudo); 
            manager.flush(); 
            return cierreRecaudo; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CierreRecaudoDAO");
        }
    }
    
    
    public List<SiiCierreRecaudo> buscarTodoSiiCierreRecaudo() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiCierreRecaudo o where o.cirVigencia > 2013 order by o.cirConsecutivo desc");
            Query query = manager.createQuery(sql.toString());
            List<SiiCierreRecaudo> listaCierres = query.getResultList();
            return listaCierres;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CierreRecaudoDAO");
        }

    }
    public Long buscarConsecutivoCierre() throws ExcepcionDAO {
        Long consecutivo;        
        try{
            StringBuilder sql = new StringBuilder();            
            sql.append("SELECT MAX(SII_CIERRE_RECAUDO.CIR_CONSECUTIVO) FROM SII_CIERRE_RECAUDO");
            Query query = manager.createNativeQuery(sql.toString());
            
            if (query.getSingleResult() == null) {
                consecutivo = 0L;
            } else {
                consecutivo = ((BigDecimal) query.getSingleResult()).longValue();
            }                 
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
        return consecutivo;
    }
    public SiiCierreRecaudo actualizarSiiCierreRecaudo(SiiCierreRecaudo cierreRecaudo) throws ExcepcionDAO {
        try {
            manager.merge(cierreRecaudo); 
            manager.flush(); 
            return cierreRecaudo; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CierreRecaudoDAO");
        }
    }
    /**
     * Realiza la consulta del cierre recaudo.
     * @param pMes - mes del cierre.  
     * @param pVigencia - vigencia del cierre. 
     * @return entidad cierre.
     * @throws ExcepcionDAO
     */
    public SiiCierreRecaudo consultarCierreRecaudoPorMesVigencia (int pMes,  int pVigencia) throws ExcepcionDAO 
    {
        SiiCierreRecaudo resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiCierreRecaudo o ");
            sql.append("WHERE o.mesCodigo = :pMes  AND o.cirVigencia = :pVigencia and o.siiEstadoCierrreRec.ecrCodigo = 2");            
                        
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pMes", pMes);
            query.setParameter("pVigencia", pVigencia);            
            
            return (SiiCierreRecaudo) query.getSingleResult();
                //resultado = (SiiCierreRecaudo) query.getSingleResult();
        }
        catch (NoResultException nRe) {
                    return new SiiCierreRecaudo();
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        //return resultado;
    }
     
}
