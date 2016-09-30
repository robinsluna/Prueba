package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoProcSanIleg;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoTramResProcIleg;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDecisionResolucion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancIlegalidad;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Procesos Sancionatorios de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class ProcesoSancIlegalidadDAO extends AbstractDAO<Long, SiiProcesoSancIlegalidad>
{
    

    /**
     * Constructor.
     */
    public ProcesoSancIlegalidadDAO() 
    {
        super(SiiProcesoSancIlegalidad.class);
    }
    
    /**
     * Obtener el Consecutivo del proceso sancionatorio de ilegalidad
     * @return consecutivo - Integer
     * @throws ExcepcionDAO
     */
    
    public Integer obtenerConsecutivoProcesoSancIlegalidad () throws ExcepcionDAO 
    {
        Integer consecutivo = null;
        
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT NVL(MAX(otv.prs_consecutivo)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'0001')) ");
            sql.append("FROM sii_proceso_sanc_ilegalidad otv "); 
            sql.append("WHERE otv.prs_consecutivo LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");
            
            Query query = em.createNativeQuery(sql.toString());
            
            Object result = query.getSingleResult();
            if(result != null){
                consecutivo = new Integer(((BigDecimal)result).intValueExact());
            }
            
        }
        catch (NoResultException e) {
            consecutivo = null;
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (consecutivo);
    }
    
    /**
     * Buscar todos los procesos sancionatorios de ilegalidad con datos de acción control y denuncia
     * @return listaResultado - List of SiiProcesoSancIlegalidad.
     * @throws ExcepcionDAO
     */

    public List<SiiProcesoSancIlegalidad> buscarTodoProcesoSancIlegalidadConDenuncia() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT psi FROM SiiProcesoSancIlegalidad psi ");
            sql.append(" inner join  psi.siiDenuncia den ");

            Query query = em.createQuery(sql.toString());

            List<SiiProcesoSancIlegalidad> listaResultado = query.getResultList();
            return listaResultado;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ProcesoSancIlegalidadDAO");
        }
    }

    public List<Long> procesosIlegalidadSinSancionPorTerminar() throws ExcepcionDAO {
        //       Coloca la Resolución sin sanción en estado EN FIRME.
        //      Coloca el estado del proceso en TERMINADO SIN SANCIÓN

// busca los procesos que no interponen recurso con fecha de notificacion anterior a la fecha actual.
        
        List<Long> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("WITH ultimos_estados_resolucion AS\n" + 
            "  (SELECT tpi.RPI_CODIGO,\n" + 
            "    MAX(tpi.TPI_CODIGO) TPI_CODIGO\n" + 
            "  FROM sii_tramite_resol_pro_ile tpi\n" + 
            "  GROUP BY tpi.RPI_CODIGO\n" + 
            "  ),\n" + 
            "  resoluciones_notificadas_ss AS\n" + 
            "  (SELECT etr.ETR_NOMBRE,\n" + 
            "    tpi.RPI_CODIGO,\n" + 
            "    tpi.TPI_FECHA,\n" + 
            "    prs.PRS_INTERP_REC_REPO,\n" + 
            "    prs.PRS_INTERP_REC_APEL,\n" +                        
            "    prs.PRS_CODIGO\n" + 
            "  FROM ultimos_estados_resolucion usr\n" + 
            "  INNER JOIN sii_tramite_resol_pro_ile tpi\n" + 
            "  ON tpi.RPI_CODIGO  = usr.RPI_CODIGO\n" + 
            "  AND tpi.TPI_CODIGO = usr.TPI_CODIGO\n" + 
            "  INNER JOIN sii_estado_tram_res_proc_ileg etr\n" + 
            "  ON tpi.ETR_CODIGO = etr.ETR_CODIGO\n" + 
            "  INNER JOIN sii_proceso_sanc_ilegalidad prs\n" + 
            "  ON usr.RPI_CODIGO    = prs.RPI_CODIGO_SIN_SANC\n" + // cambiar la referencia para los demas tipos de resoluciones
            "  WHERE etr.ETR_CODIGO = "+EnumEstadoTramResProcIleg.NOTIFICADO.getId() + "\n"+
            "  AND NVL(prs.PRS_INTERP_REC_REPO,'N') = 'N'\n" +                        
            "  AND prs.EPI_CODIGO <> "+EnumEstadoProcSanIleg.TERMINADO_SIN_SANCION.getId()+" \n"+                     
            "  )\n" + 
            "SELECT prs_codigo\n" + 
            "FROM resoluciones_notificadas_ss\n" + 
            "WHERE TRUNC(resoluciones_notificadas_ss.TPI_FECHA) < SysDate ");
            Query query = em.createNativeQuery(sql.toString());
            
            List<BigDecimal> lista = query.getResultList();
            if (lista!=null && !lista.isEmpty()) {
                resultado = new ArrayList<Long>();
                for (BigDecimal cod: lista) {
                    if (cod!=null)
                        resultado.add(cod.longValueExact());
                }
            }
            
            return resultado;
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public List<Long> procesosIlegalidadConSancionPorTerminar() throws ExcepcionDAO {
        //       Coloca la Resolución sancionatoria en estado EN FIRME.
        //       Coloca el estado del proceso en TERMINADO CON SANCIÓN
        //       busca los procesos que no interponen recurso con fecha de notificacion anterior a la fecha actual.
        
        List<Long> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("WITH ultimos_estados_resolucion AS\n" + 
            "  (SELECT tpi.RPI_CODIGO,\n" + 
            "    MAX(tpi.TPI_CODIGO) TPI_CODIGO\n" + 
            "  FROM sii_tramite_resol_pro_ile tpi\n" + 
            "  GROUP BY tpi.RPI_CODIGO\n" + 
            "  ),\n" + 
            "  resoluciones_notificadas_s AS\n" + 
            "  (SELECT etr.ETR_NOMBRE,\n" + 
            "    tpi.RPI_CODIGO,\n" + 
            "    tpi.TPI_FECHA,\n" + 
            "    prs.PRS_INTERP_REC_REPO,\n" + 
            "    prs.PRS_CODIGO\n" + 
            "  FROM ultimos_estados_resolucion usr\n" + 
            "  INNER JOIN sii_tramite_resol_pro_ile tpi\n" + 
            "  ON tpi.RPI_CODIGO  = usr.RPI_CODIGO\n" + 
            "  AND tpi.TPI_CODIGO = usr.TPI_CODIGO\n" + 
            "  INNER JOIN sii_estado_tram_res_proc_ileg etr\n" + 
            "  ON tpi.ETR_CODIGO = etr.ETR_CODIGO\n" + 
            "  INNER JOIN sii_proceso_sanc_ilegalidad prs\n" + 
            "  ON tpi.RPI_CODIGO    = prs.RPI_CODIGO\n" + 
            "  WHERE etr.ETR_CODIGO = "+EnumEstadoTramResProcIleg.NOTIFICADO.getId() + "\n"+
            "  AND NVL(prs.PRS_INTERP_REC_REPO,'N') = 'N'                       \n" + 
            "  AND prs.EPI_CODIGO <> "+EnumEstadoProcSanIleg.TERMINADO_CON_SANCION.getId()+" \n"+
            "\n" + 
            "  )\n" + 
            "SELECT resoluciones_notificadas_s.PRS_CODIGO\n" + 
            "FROM resoluciones_notificadas_s\n" + 
            "WHERE TRUNC(resoluciones_notificadas_s.TPI_FECHA) < SysDate");
            Query query = em.createNativeQuery(sql.toString());
            
            List<BigDecimal> lista = query.getResultList();
            if (lista!=null && !lista.isEmpty()) {
                resultado = new ArrayList<Long>();
                for (BigDecimal cod: lista) {
                    if (cod!=null)
                        resultado.add(cod.longValueExact());
                }
            }
            
            return resultado;
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public List<Long> procesosConReposicionPorTerminar() throws ExcepcionDAO {
        List<Long> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("WITH ultimos_estados_resolucion AS\n" + 
            "  (SELECT tpi.RPI_CODIGO,\n" + 
            "    MAX(tpi.TPI_CODIGO) TPI_CODIGO\n" + 
            "  FROM sii_tramite_resol_pro_ile tpi\n" + 
            "  GROUP BY tpi.RPI_CODIGO\n" + 
            "  ),\n" + 
            "  reposiciones_notificadas AS\n" + 
            "  (SELECT etr.ETR_NOMBRE,\n" + 
            "    tpi.RPI_CODIGO,\n" + 
            "    tpi.TPI_FECHA,\n" + 
            "    prs.PRS_CODIGO\n" + 
            "  FROM ultimos_estados_resolucion usr\n" + 
            "  INNER JOIN sii_tramite_resol_pro_ile tpi\n" + 
            "  ON tpi.RPI_CODIGO  = usr.RPI_CODIGO\n" + 
            "  AND tpi.TPI_CODIGO = usr.TPI_CODIGO\n" + 
            "  INNER JOIN sii_estado_tram_res_proc_ileg etr\n" + 
            "  ON tpi.ETR_CODIGO = etr.ETR_CODIGO\n" + 
            "  INNER JOIN sii_proceso_sanc_ilegalidad prs\n" + 
            "  ON tpi.RPI_CODIGO                     = prs.RPI_CODIGO_REPOSIC\n" + 
            "  INNER JOIN sii_resolucion_proc_ileg rpi  ON  rpi.RPI_CODIGO = prs.RPI_CODIGO_REPOSIC \n" +
            "  WHERE etr.ETR_CODIGO = "+EnumEstadoTramResProcIleg.NOTIFICADO.getId() + "\n"+
            "  AND NVL(prs.PRS_INTERP_REC_APEL, 'N') = 'N'\n" + 
            "  AND rpi.RPI_TIPO_RESOL IN ('"+EnumTipoDecisionResolucion.CONFIRMA.getId()+"', '"+EnumTipoDecisionResolucion.REVOCA_PARCIALMENTE.getId()+"') \n" +
            "  AND prs.EPI_CODIGO NOT IN ("+EnumEstadoProcSanIleg.TERMINADO_SIN_SANCION.getId()+", "+EnumEstadoProcSanIleg.TERMINADO_CON_SANCION.getId()+") \n"+
            "  )\n" + 
            "SELECT reposiciones_notificadas.PRS_CODIGO\n" + 
            "FROM reposiciones_notificadas\n" + 
            "WHERE TRUNC(reposiciones_notificadas.TPI_FECHA) < SysDate");
            Query query = em.createNativeQuery(sql.toString());
            
            
            List<BigDecimal> lista = query.getResultList();
            if (lista!=null && !lista.isEmpty()) {
                resultado = new ArrayList<Long>();
                for (BigDecimal cod: lista) {
                    if (cod!=null)
                        resultado.add(cod.longValueExact());
                }
            }
            
            return resultado;
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public List<Long> procesosConApelacionPorTerminar() throws ExcepcionDAO {
        List<Long> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("WITH ultimos_estados_resolucion AS\n" + 
            "  (SELECT tpi.RPI_CODIGO,\n" + 
            "    MAX(tpi.TPI_CODIGO) TPI_CODIGO\n" + 
            "  FROM sii_tramite_resol_pro_ile tpi\n" + 
            "  GROUP BY tpi.RPI_CODIGO\n" + 
            "  ),\n" + 
            "  apelaciones_notificadas AS\n" + 
            "  (SELECT etr.ETR_NOMBRE,\n" + 
            "    tpi.RPI_CODIGO,\n" + 
            "    tpi.TPI_FECHA,\n" + 
            "    prs.PRS_CODIGO\n" + 
            "  FROM ultimos_estados_resolucion usr\n" + 
            "  INNER JOIN sii_tramite_resol_pro_ile tpi\n" + 
            "  ON tpi.RPI_CODIGO  = usr.RPI_CODIGO\n" + 
            "  AND tpi.TPI_CODIGO = usr.TPI_CODIGO\n" + 
            "  INNER JOIN sii_estado_tram_res_proc_ileg etr\n" + 
            "  ON tpi.ETR_CODIGO = etr.ETR_CODIGO\n" + 
            "  INNER JOIN sii_proceso_sanc_ilegalidad prs\n" + 
            "  ON tpi.RPI_CODIGO                     = prs.RPI_CODIGO_APELAC\n" + 
            "  INNER JOIN sii_resolucion_proc_ileg rpi  ON  rpi.RPI_CODIGO = prs.RPI_CODIGO_APELAC \n" +
            "  WHERE etr.ETR_CODIGO = "+EnumEstadoTramResProcIleg.NOTIFICADO.getId() + "\n"+
            "  AND rpi.RPI_TIPO_RESOL IN ('"+EnumTipoDecisionResolucion.CONFIRMA.getId()+"', '"+EnumTipoDecisionResolucion.REVOCA_PARCIALMENTE.getId()+"') \n" +
            "  AND prs.EPI_CODIGO NOT IN ("+EnumEstadoProcSanIleg.TERMINADO_SIN_SANCION.getId()+", "+EnumEstadoProcSanIleg.TERMINADO_CON_SANCION.getId()+") \n"+
            "  )\n" + 
            "SELECT apelaciones_notificadas.PRS_CODIGO\n" + 
            "FROM apelaciones_notificadas\n" + 
            "WHERE TRUNC(apelaciones_notificadas.TPI_FECHA) < SysDate");
            Query query = em.createNativeQuery(sql.toString());
            
            List<BigDecimal> lista = query.getResultList();
            if (lista!=null && !lista.isEmpty()) {
                resultado = new ArrayList<Long>();
                for (BigDecimal cod: lista) {
                    if (cod!=null)
                        resultado.add(cod.longValueExact());
                }
            }
            
            return resultado;
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Obtiene el Valor Total de la Sanci&oacute;n, calculado a partir de los Elementos asociados al Proceso Sancionatorio de Ilegalidad.
     * @param prsCodigo - C&oacute;digo del Proceso Sancionatorio de Ilegalidad.
     * @return Sumatoria de los Valores de Sanci&oacute;n de c/u de los Elementos asociados al Proceso.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerValorTotalSancionElementosProceso (Long prsCodigo) throws ExcepcionDAO 
    {
        BigDecimal resultado = null;
        
        if (prsCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                
                sql.append("SELECT SUM(epr.EPR_VALOR_SANCION) ");
                sql.append("FROM SII_ELEMENTO_PROCESO_ILE epr ");
                sql.append("WHERE epr.PRS_CODIGO = #prsCodigo ");
                sql.append("AND epr.EPR_ACTIVO = #eprActivo ");
                
                Query query = em.createNativeQuery(sql.toString());
                query.setParameter("prsCodigo", prsCodigo);
                query.setParameter("eprActivo", EnumDecision.SI.getId());
                
                resultado = (BigDecimal) query.getSingleResult();
            }
            catch (NoResultException ne) {
                resultado = null;
                ne.printStackTrace();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
