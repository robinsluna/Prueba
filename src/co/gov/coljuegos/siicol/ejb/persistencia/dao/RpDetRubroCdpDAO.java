/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 18-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.RpDetRubroCdpVO;

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
public class RpDetRubroCdpDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public RpDetRubroCdpDAO() {
        recursos = new Recursos();
    }
    
    public SiiRpDetRubroCdp buscarCodigoRpDetRubroCdp(Long idRpDetRubroCdp) throws ExcepcionDAO {
        SiiRpDetRubroCdp siiRpDetRubroCdpRetorno = null;
        try{
            siiRpDetRubroCdpRetorno = (SiiRpDetRubroCdp) manager.find(SiiRpDetRubroCdp.class, idRpDetRubroCdp);
        
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
        return siiRpDetRubroCdpRetorno;
    }
    
    public SiiRpDetRubroCdp insertarRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) throws ExcepcionDAO{
        try{
            manager.persist(siiRpDetRubroCdp);
            manager.flush();
            return siiRpDetRubroCdp;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDetRubroCdpDAO");
        }
        
    }
    
    public SiiRpDetRubroCdp actualizarRpDetRubroCdp(SiiRpDetRubroCdp siiRpDetRubroCdp) throws ExcepcionDAO{
        try{
            manager.merge(siiRpDetRubroCdp);
            manager.flush();
            return (siiRpDetRubroCdp);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDetRubroCdpDAO");
        }
    }
    
    public List<SiiRpDetRubroCdp> buscarTodoRpDetRubroCdp() throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rpDetRubroCdp FROM SiiRpDetRubroCdp rpDetRubroCdp");
            Query query = manager.createQuery(sql.toString());
            List<SiiRpDetRubroCdp> listaEntidadRpDetRubroCdp = query.getResultList();
            
            return listaEntidadRpDetRubroCdp;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDetRubroCdpDAO");
        }
    }
    
    public List<SiiRpDetRubroCdp> buscarRpDetRubroCdpPorDetRubCdp(Long drcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(
                "SELECT o FROM SiiRpDetRubroCdp o " +
                "WHERE o.siiDetalleRubroCdp.drcCodigo = :drcCodigo " +
                "AND o.siiRp.siiEstadoRp.erpNombre = 'RP APROBADO'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("drcCodigo",drcCodigo);
            List<SiiRpDetRubroCdp> listaSiiRpDetRubroCdp = query.getResultList();
            return listaSiiRpDetRubroCdp;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDetRubroCdpDAO");
        }
    }
    
    public List<SiiRpDetRubroCdp> buscarRpDetRubroCdpPorRp (Long rpCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRpDetRubroCdp o WHERE o.siiRp.rpCodigo = :rpCodigo ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rpCodigo",rpCodigo);
            List<SiiRpDetRubroCdp> listaSiiRpDetRubroCdp = query.getResultList();
            return listaSiiRpDetRubroCdp;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDetRubroCdpDAO");
        }
        
    }
    
    
    
    /**
     * Consultar el listado de RPs por Detalle Rubro CDP, asociados al RP y Fuente de Financiaci&oacute;n Contable dados.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return List of SiiRpDetRubroCdp
     * @throws ExcepcionDAO
     */
    public List<SiiRpDetRubroCdp> buscarRpDetRubroCdpPorRpFFC (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        return ( this.buscarRpDetRubroCdpPorRpFFCGMF(rpCodigo, ffcCodigo, null) );
    }
    
    
    
    /**
     * Consultar el listado de RPs por Detalle Rubro CDP, asociados al RP, Fuente de Financiaci&oacute;n Contable y GMF dados.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @param aplicaGmf - Flag que determina si se deben buscar &uacute;nicamente los registros que apliquen o no apliquen 4x1000 (<i>null</i> para traer ambos).
     * @return List of SiiRpDetRubroCdp
     * @throws ExcepcionDAO
     */
    public List<SiiRpDetRubroCdp> buscarRpDetRubroCdpPorRpFFCGMF (Long rpCodigo, String ffcCodigo, Boolean aplicaGmf) throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRpDetRubroCdp o ");
            sql.append("INNER JOIN SiiDetalleRubroCdp drc  ON  drc.drcCodigo = o.siiDetalleRubroCdp.drcCodigo ");
            sql.append("INNER JOIN SiiDetalleRubro dru  ON  dru.druCodigo = drc.siiDetalleRubro.druCodigo ");
            sql.append("WHERE o.siiRp.rpCodigo = :rpCodigo ");
            sql.append("AND dru.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
            
            if (aplicaGmf!=null) {
                sql.append("AND drc.drcAplicaGmf = :drcAplicaGmf ");
            }
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            query.setParameter("ffcCodigo", ffcCodigo);
            
            if (aplicaGmf!=null) {
                if (aplicaGmf)
                    query.setParameter("drcAplicaGmf", EnumDecision.SI.getId());
                else
                    query.setParameter("drcAplicaGmf", EnumDecision.NO.getId());
            }
            
            List<SiiRpDetRubroCdp> listaSiiRpDetRubroCdp = query.getResultList();
            return listaSiiRpDetRubroCdp;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
    }
    

    public List<SiiRpDetRubroCdp> buscarRpDetRubroCdpPorX(Long drcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRpDetRubroCdp o WHERE o.siiDetalleRubroCdp.drcCodigo = :drcCodigo ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("drcCodigo",drcCodigo);
            List<SiiRpDetRubroCdp> listaSiiRpDetRubroCdp = query.getResultList();
            return listaSiiRpDetRubroCdp;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDetRubroCdpDAO");
        }
    }

    public BigDecimal valorRpDetRubroCdpAprobado(Long drcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.rdrValor) FROM SiiRpDetRubroCdp o " +
                "WHERE o.siiDetalleRubroCdp.drcCodigo = :drcCodigo " +
                "AND o.siiRp.siiEstadoRp.erpNombre='RP APROBADO'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("drcCodigo",drcCodigo);

            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDetRubroCdpDAO");
        }
    }
    
    public List<SiiRpDetRubroCdp> listaRubrosRpsAsociadosConLosCdpAsociadosConElRubroRp(RpDetRubroCdpVO rpDetRubroCdpVO) throws ExcepcionDAO {
        
        try{
            StringBuilder sql = new StringBuilder();                        
            sql.append("SELECT distinct losRdr\n" +
                "FROM SiiRpDetRubroCdp rdr\n" +
                "INNER JOIN rdr.siiRp rp\n" +
                "INNER JOIN rp.siiCdpRpList crp\n" +
                "INNER JOIN crp.siiCdp losCdp\n" +
                "INNER JOIN losCdp.siiCdpRpList losCrp\n" +
                "INNER JOIN losCrp.siiRp losRp\n" +
                "INNER JOIN losRP.siiEstadoRp erp\n" +
                "INNER JOIN losRp.siiRpDetRubroCdpList1 losRdr\n" +             
            "WHERE rdr.rdrCodigo = :unRpDetRubroCdp AND erp.erpNombre = 'RP APROBADO'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("unRpDetRubroCdp", rpDetRubroCdpVO.getRdrCodigo());
            return query.getResultList();
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }        

    }

}
